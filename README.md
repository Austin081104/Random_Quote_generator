# 📜 Random Quotes Generator App

## 🎯 About the Project
The **Random Quotes Generator** is an Android application built with **Java & XML** in Android Studio. This app fetches and displays random quotes from an API, allows users to **save favorite quotes**, and provides features such as **categorization, sharing, and smooth animations**.

## ✨ Features
✅ Fetch random quotes from API ([qapi.vercel.app](https://qapi.vercel.app/api/random))  
✅ Save favorite quotes (Stored in **Firebase Firestore**)  
✅ View saved quotes on a separate page  
✅ Delete quotes from saved list  
✅ Copy quotes to clipboard  
✅ Share quotes via social media  
✅ Smooth transition animations  

## 📱 Screenshots
> Add some screenshots or GIFs of your app UI here

## 🔧 Installation Guide
1. Clone the repository:
   ```sh
   git clone https://github.com/your-username/Random-Quotes-App.git
   ```
2. Open the project in **Android Studio**.
3. Sync Gradle files.
4. Add **Firebase Firestore** to your project:
   - Go to [Firebase Console](https://console.firebase.google.com/)
   - Create a new Firebase project
   - Enable Firestore Database
   - Download the `google-services.json` file and place it in `app/` directory.
5. Run the app on an emulator or a real device.

## 📂 Project Structure
```
Random-Quotes-App/
│── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/randomquote/
│   │   │   │   ├── MainActivity.java
│   │   │   │   ├── SavedQuotesActivity.java
│   │   │   │   ├── FirestoreHelper.java
│   │   │   │   ├── QuoteModel.java
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   ├── activity_main.xml
│   │   │   │   │   ├── activity_saved_quotes.xml
│   │   │   │   │   ├── item_quote.xml
│   │   │   ├── drawable/
│   │   │   │   ├── gradient_bg.xml
│   │   │   ├── values/
│   │   │   │   ├── colors.xml
│   │   │   │   ├── strings.xml
│── README.md
│── build.gradle
```

## 🔗 API Used
- [qapi.vercel.app](https://qapi.vercel.app/api/random) - Fetches random quotes.

## 🔥 Technologies Used
- **Java** (Android development)
- **XML** (UI design)
- **Firebase Firestore** (Storing saved quotes)
- **Lottie Animations** (Smooth UI effects)

## 🛠️ Future Enhancements
- 📅 **Schedule Daily Quotes** feature
- 📊 **Leaderboard for popular quotes**
- 🌎 **Multi-language support**
- 🌟 **More customization options**

## 🤝 Contributing
Contributions are welcome! If you’d like to improve the app:
1. Fork the repository
2. Create a new branch (`git checkout -b feature-branch`)
3. Commit your changes (`git commit -m 'Added a new feature'`)
4. Push to your fork (`git push origin feature-branch`)
5. Open a Pull Request

## 📜 License
This project is **open-source** and available under the [MIT License](LICENSE).

---

### 👨‍💻 Developed by **[Your Name]**

