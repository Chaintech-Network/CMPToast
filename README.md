[![Maven Central](https://img.shields.io/maven-central/v/network.chaintech/cmptoast.svg)](https://central.sonatype.com/artifact/network.chaintech/cmptoast)
[![Kotlin](https://img.shields.io/badge/kotlin-v2.0.20-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![Compose Multiplatform](https://img.shields.io/badge/Compose%20Multiplatform-v1.7.0-blue)](https://github.com/JetBrains/compose-multiplatform)
[![License](https://img.shields.io/github/license/Chaintech-Network/CMPToast)](http://www.apache.org/licenses/LICENSE-2.0)

![badge-android](http://img.shields.io/badge/platform-android-3DDC84.svg?style=flat)
![badge-ios](http://img.shields.io/badge/platform-ios-FF375F.svg?style=flat)

# CMPToast - Toasts for Compose Multiplatform

🍞️ CMPToast is a lightweight and easy-to-use library for displaying toast messages in Compose Multiplatform projects.<br><br>

<img width="960" alt="Hero-image - CMP-Chart 3" src="/assets/CMPToast-Banner.png"><br><br>


## ✨ Features

- **Cross-platform support**: Works seamlessly on Android and iOS.
- **Composable API**: Designed to integrate naturally into Jetpack Compose.
- **Customizable**: Customize your toast message with text, duration, and appearance.<br><br>

## 📦 Installation

To use CMPToast in your Compose Multiplatform project, add the following dependency to your `build.gradle.kts`:

```kotlin
commonMain.dependencies {
  implementation("network.chaintech:cmptoast:1.0.2")
}
```

<br>Note : Create an Application Class and add the following line (Otherwise you might face context error):

```kotlin
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        multiplatform.network.cmptoast.AppContext.apply { set(applicationContext) }
    }
}
```

<br>Also if you are getting Manifest Merger Failed issue, add the following to your Android Manifest file:

```kotlin
tools:replace="android:name"
```
```kotlin
tools:replace="android:allowBackup"
```

<br>


## 🚀 Usage

### Basic Toast

To display a simple toast:

```kotlin
showToast(
    message = "This is a Toast"
)
```
<br>

## 🎥 Demo

Watch the demo below to see CMPToast in action:

<img src="/assets/ToastLibDemoVideo.gif" width="300" height="auto" alt="Toast Demo">
<br>


## 🎨 Customisation

### ⏳ Short Toast

To show a short-duration toast:

```kotlin
showToast(
    message = "This is Short Toast",
    backgroundColor = Color.White,
    textColor = Color.Black,
    duration = ToastDuration.Short
)
```

### ⏱️ Long Toast

To show a long-duration toast:

```kotlin
showToast(
    message = "This is Long Toast",
    backgroundColor = Color.White,
    textColor = Color.Black,
    duration = ToastDuration.Long
)
```

### 📍 Top Toast

To show toast at top of the screen:

```kotlin
showToast(
    message = "This is Top Toast",
    backgroundColor = Color.White,
    textColor = Color.Black,
    gravity = ToastGravity.Top
)
```

### 🎯 Center Toast

To show toast at center of the screen:

```kotlin
showToast(
    message = "This is Center Toast",
    backgroundColor = Color.White,
    textColor = Color.Black,
    gravity = ToastGravity.Center
)
```

### 🎨 Colored Toast

To show a colored toast:

```kotlin
showToast(
    message = "This is Colored Toast",
    backgroundColor = Color(0xFF27AD9D)
)
```
<br>

## ⚙️ Properties

| Property         | Type            | Description                                            |
|------------------|-----------------|--------------------------------------------------------|
| **message**      | `String`         | The message to be displayed in the toast.              |
| **gravity**      | `ToastGravity`   | The position of the toast.                             |
| **backgroundColor** | `Color`       | The background color of the toast.                     |
| **textColor**    | `Color`          | The color of the message text.                         |
| **duration**     | `ToastDuration`  | The duration of the toast.                             |
| **padding**      | `ToastPadding?`  | Internal padding for the toast content.                |
| **textSize**     | `TextUnit`       | The size of the text.                                  |
| **topPadding**   | `Int`            | Padding between toast and top of screen.               |
| **bottomPadding**| `Int`            | Padding between toast and bottom of screen.            |
| **cornerRadius** | `Int?`           | For rounding the corners of the toast.                 |
<br>

## 🖥️ Platforms Supported

CMPToast currently supports the following platforms:

- **Android** 🤖
- **iOS** 🍎
  <br><br>


## 📖 Detailed Explanation

For an in-depth guide and detailed explanation, check out our comprehensive Medium Blog Post.

[![Medium](https://img.shields.io/badge/Medium-12100E?style=for-the-badge&logo=medium&logoColor=white)](https://medium.com/@waghmaremayur855/cmptoast-toasts-for-compose-multiplatform-projects-db4a78f37dfe)

Stay connected and keep up with our latest innovations! 💼 Let's innovate together!

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/showcase/mobile-innovation-network)

<br>

## 📄 License
```
Copyright 2023 Mobile Innovation Network

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```


