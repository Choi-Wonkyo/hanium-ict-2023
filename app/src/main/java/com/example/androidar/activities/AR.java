package com.example.androidar.activities;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.os.Handler;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidar.R;
import com.google.ar.core.Anchor;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

public class AR extends AppCompatActivity {

    private ArFragment arFragment;
    private int clickNo = 0;
    private boolean capturing = false;

    private static final int PERMISSION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ar);

        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.arfragment);
        Objects.requireNonNull(arFragment).setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {
            clickNo++;
            if (clickNo == 1) {
                Anchor anchor = hitResult.createAnchor();
                //int modelResourceId = R.raw.sofa; // Default model, you can change this as needed
                int modelResourceId = getIntent().getIntExtra("modelResourceId", R.raw.sofa); // 기본값으로 R.raw.sofa 사용하거나 전달받은 리소스 ID를 사용합니다.
                ModelRenderable.builder()
                        .setSource(this, modelResourceId)
                        .setIsFilamentGltf(true)
                        .build()
                        .thenAccept(modelRenderable -> add(anchor, modelRenderable))
                        .exceptionally(throwable -> {
                            Toast.makeText(this, "문제가 발생했습니다: " + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                            return null;
                        });
            }
        });

        Button captureButton = findViewById(R.id.capture);
        captureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestStoragePermissionAndCaptureARView();
            }
        });

        Button homeButton = findViewById(R.id.back_tohome);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AR.this, ActivityMain.class);
                startActivity(intent);
            }
        });

        arFragment.getArSceneView().getScene().addOnUpdateListener(frameTime -> {
            if (capturing) {
                captureARView();
                capturing = false;
            }
        });
    }

    private void requestStoragePermissionAndCaptureARView() {
        if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        } else {
            capturing = true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                capturing = true;
            } else {
                Toast.makeText(this, "저장소 권한이 거부되었습니다.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void captureARView() {
        SurfaceView arView = arFragment.getArSceneView();
        Bitmap bitmap = Bitmap.createBitmap(arView.getWidth(), arView.getHeight(), Bitmap.Config.ARGB_8888);

        PixelCopy.request(arView, bitmap, (copyResult) -> {
            if (copyResult == PixelCopy.SUCCESS) {
                saveImageToGallery(bitmap);
                Toast.makeText(this, "AR 뷰가 캡쳐되어 갤러리에 저장되었습니다.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "AR 뷰 캡쳐에 실패했습니다.", Toast.LENGTH_SHORT).show();
            }
        }, new Handler());
    }

    private void saveImageToGallery(Bitmap bitmap) {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "AR_Capture");
        values.put(MediaStore.Images.Media.DESCRIPTION, "AR 캡쳐 이미지");
        ContentResolver resolver = getContentResolver();
        Uri uri = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

        try {
            OutputStream outputStream = resolver.openOutputStream(Objects.requireNonNull(uri));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            Objects.requireNonNull(outputStream).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void add(Anchor anchor, ModelRenderable modelRenderable) {
        AnchorNode anchorNode = new AnchorNode(anchor);
        anchorNode.setParent(arFragment.getArSceneView().getScene());
        TransformableNode model = new TransformableNode(arFragment.getTransformationSystem());
        model.setParent(anchorNode);
        model.setRenderable(modelRenderable);
        model.select();
    }
}
