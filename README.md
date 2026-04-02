# 🏠 AI-AR Smart Interior Platform  

> 🎓 **An AI + AR-based interior design assistant application**  
> Automatically analyzes indoor spaces and visualizes furniture placement using augmented reality.

---

<br>

# 🏆 Achievements  

## 🏅 Competition Award  

**2023 ICT Mentoring Competition**

- 🏅 Award: **Bronze Prize (Final Winner)**  
- 📌 Recognized as an outstanding project in AI + AR convergence  
- 📱 Developed Android-based AR interior application  
- 🎥 Demo: https://youtu.be/kEw1Z3oz_E0  

---

<br>

# 📌 1. Project Overview  

---

## 1.1 📖 Introduction  

This project is an **AI-AR based smart interior platform** designed to:

- 📸 Analyze indoor spaces using AI  
- 🪑 Recommend suitable furniture  
- 🏠 Visualize placement using AR  

> 💡 The goal is to reduce the complexity, time, and cost of interior design while improving accessibility.

---

## 1.2 🌍 Background & Motivation  

- Rapid growth of the interior design market  
- Increasing demand for **non-face-to-face services**  
- Need for **easy and intuitive interior design tools**

### 🎯 Our Solution  

- AI-based space recognition  
- AR-based furniture placement  
- Personalized recommendation system  

---

## 1.3 🎯 Objectives  

- Develop AI-based **space classification model**  
- Implement **AR furniture visualization**  
- Build **Android-based application**  
- Provide **personalized interior recommendations**

---

<br>

# 🏗 2. System Architecture  

---

## 2.1 🧩 Architecture Overview  

[ Android App ]
↓
[ Flask Backend Server ]
↓
[ AI Model (CNN) ]
↓
[ Furniture Recommendation System ]

---

### 🖥 Stack Overview

- **Frontend** → Android (Java)
- **Backend** → Python (Flask)
- **AI Model** → CNN-based image classification
- **AR** → Google ARCore
- **Cloud** → AWS EC2

---

<br>

# 🚀 3. Core Features  

---

## 3.1 📸 Space Analysis  

- Capture indoor images via camera  
- AI model classifies space:
  - bedroom, kitchen, living room, etc.  
- Provides context-aware recommendations  

---

## 3.2 🪑 Furniture Recommendation  

- Recommends furniture based on:
  - detected space  
  - user preferences  

- Provides:
  - product information  
  - visual previews  

---

## 3.3 🧊 AR Furniture Placement  

- Place furniture in real-world environment using AR  
- Preview layout before purchase  
- Improve decision-making  

---

## 3.4 ❤️ Wishlist System  

- Save favorite furniture  
- Manage items for later consideration  

---

<br>

# 🧠 4. Technical Implementation  

---

## 4.1 🧠 AI Space Classification  

- Built CNN-based classification model  
- Classified spaces into:
  - bathroom, bedroom, kitchen, living room, etc.  

- Dataset:
  - ~100 images per category  
  - manually collected and labeled  

---

## 4.2 🔄 Model Training & Optimization  

- Used **Keras** for deep learning  
- Conducted multiple experiments to improve accuracy  
- Addressed data limitations through dataset expansion  

---

## 4.3 🌐 Backend Server  

- Built using **Flask**  
- Handles:
  - image processing  
  - AI inference  
  - API communication  

- Deployed on **AWS EC2**

---

## 4.4 📱 Frontend (Android)  

- Developed using Android Studio  
- Implemented:
  - camera functionality  
  - API communication  
  - AR interaction  

---

## 4.5 🧊 AR Implementation  

- Used **Google ARCore**  
- Enables:
  - real-time furniture placement  
  - interactive visualization  

---

<br>

# 🛠 5. Development Process  

---

## 5.1 📅 Workflow  

- Requirement analysis  
- System design  
- AI model development  
- Android app development  
- Backend integration  
- Testing & debugging  

---

## 5.2 ⚠ Challenges & Solutions  

### 1️⃣ Data Collection Limitations  

**Problem**  
- Manual data collection was time-consuming  

**Solution**  
- Expanded dataset per category  
- Improved labeling consistency  

---

### 2️⃣ Model Accuracy Issues  

**Problem**  
- Low classification accuracy  

**Solution**  
- Repeated experiments  
- Model tuning and optimization  

---

### 3️⃣ ARCore Development Issues  

**Problem**  
- Lack of documentation  
- Execution errors  

**Solution**  
- Version compatibility fixes  
- Studied external resources and examples  

---

### 4️⃣ Backend Development Challenges  

**Problem**  
- Lack of understanding of API Gateway and Flask  

**Solution**  
- Studied architecture concepts  
- Implemented API documentation (Swagger)  

---

<br>

# 📈 6. Expected Impact  

---

## 👤 User Perspective  

- Reduced time and cost of interior design  
- Easy-to-use AR-based visualization  
- Accessible anytime, anywhere  

---

## 🎯 Technical Perspective  

- Practical experience in:
  - Deep Learning (CNN)  
  - AR development  
  - Android app development  
  - Backend server design  

---

## 📌 Key Takeaways  

- Built an **AI + AR integrated application**
- Implemented **CNN-based space classification**
- Developed **real-time AR visualization system**
- Experienced full-stack development from AI to mobile app
