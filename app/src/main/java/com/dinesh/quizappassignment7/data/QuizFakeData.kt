package com.dinesh.quizappassignment7.data

import com.dinesh.quizappassignment7.constants.Constant.IS_CHECK_BOX
import com.dinesh.quizappassignment7.constants.Constant.IS_RADIO_BUTTON

class QuizFakeData {

    companion object {
        fun getQuizQuestions(): MutableList<Quiz> {
            return mutableListOf(
                Quiz(
                    1,
                    "1. Android is _____",
                    IS_RADIO_BUTTON,
                    "Android is a software package and linux based operating system for mobile devices such as tablet computers and smartphones.",
                    "a",
                    "an operating system",
                    "",
                    "",
                    mutableListOf("an operating system","a web browser", "a web server", "None of the above")
                ),
                Quiz(
                    2,
                    "2. Under which of the following Android is licensed?",
                    IS_RADIO_BUTTON,
                    "The Android platform was released under the Apache 2.0 license, and it is responsible for the copyright of the Android Open Source project.",
                    "c",
                    "Apache/MIT",
                    "",
                    "",
                    mutableListOf("OSS","Sourceforge","Apache/MIT","None of the above")
                ),
                Quiz(
                    3,
                    "3. For which of the following Android is mainly developed?",
                    IS_RADIO_BUTTON,
                    "Android is a software package and a Linux-based operating system specially designed for touch-screen mobile devices like smartphones and tablets.",
                    "d",
                    "Mobile devices",
                    "",
                    "",
                    mutableListOf("Servers","Desktops","Laptops","Mobile devices")
                ),
                Quiz(
                    4,
                    "4. Which of the following virtual machine is used by the Android operating system?",
                    IS_RADIO_BUTTON,
                    "The Dalvik Virtual Machine (DVM) is an android virtual machine optimized for mobile devices. It optimizes the virtual machine for memory, battery life, and performance.",
                    "b",
                    "Dalvik virtual machine",
                    "",
                    "",
                    mutableListOf("JVM","Dalvik virtual machine","Simple virtual machine","None of the above")
                ),
                Quiz(
                    5,
                    "5. Android is based on which of the following language?",
                    IS_RADIO_BUTTON,
                    "Java language is mainly used to write the android code even though other languages can be used.",
                    "a",
                    "Java",
                    "",
                    "",
                    mutableListOf("Java","C++","Python","C")
                ),
                Quiz(
                    6,
                    "6. APK stands for _____",
                    IS_RADIO_BUTTON,
                    "An APK is a short form of the Android Package Kit. An APK file is the file format used to install the applications on the android operating system.",
                    "c",
                    "Android Package Kit",
                    "",
                    "",
                    mutableListOf("Android Phone Kit","Android Page Kit","Android Package Kit")
                ),
                Quiz(
                    7,
                    "7. What does API stand for?",
                    IS_RADIO_BUTTON,
                    "API stands for application program interface. It is a set of routines, protocols, and tools for building software and applications.",
                    "a",
                    "Application Programming Interface",
                    "",
                    "",
                    mutableListOf("Application Programming Interface","Android Programming Interface","Android Page Interface", "Application Page Interface")
                ),
                Quiz(
                    8,
                    "8. How can we kill an activity in android?",
                    IS_CHECK_BOX,
                    "The finish() method is used to close the activity. Whereas the finishActivity(int requestCode) also closes the activity with requestCode.",
                    "ab",
                    "Using finish() method\nUsing finishActivity(int requestCode)",
                    "",
                    "",
                    mutableListOf("Using finish() method","Using finishActivity(int requestCode)","Neither (a) nor (b)")
                ),
                Quiz(
                    9,
                    "9. On which of the following, developers can test the application, during developing the android applications?",
                    IS_CHECK_BOX,
                    "We can use the Android emulator, physical android phone, or third-party emulator as a target device to execute and test our Android application.",
                    "abc",
                    "Third-party emulators\nEmulator included in Android SDK\nPhysical android phone",
                    "",
                    "",
                    mutableListOf("Third-party emulators","Emulator included in Android SDK","Physical android phone")
                ),
                Quiz(
                    10,
                    "10. Which of the following is not an activity lifecycle callback method?",
                    IS_RADIO_BUTTON,
                    "onBackPressed() method is not an activity lifecycle callback method",
                    "d",
                    "onBackPressed() method",
                    "",
                    "",
                    mutableListOf("onClick() method","onCreate() method","onStart() method","onBackPressed() method")
                ),
                Quiz(
                    11,
                    "11. Which of the following is a dialog class in android?",
                    IS_CHECK_BOX,
                    "All of the above are Dialog classes",
                    "abc",
                    "AlertDialog\nDatePicker Dialog\nProgressDialog",
                    "",
                    "",
                    mutableListOf("AlertDialog","DatePicker Dialog","ProgressDialog")
                ),
                Quiz(
                    12,
                    "12. Which of the following android component displays the part of an activity on screen?",
                    IS_RADIO_BUTTON,
                    "Android Fragment is the part of activity; it is also known as sub-activity. There can be more than one fragment in an activity. Fragments represent multiple screens inside one activity.",
                    "d",
                    "Fragment",
                    "",
                    "",
                    mutableListOf("View","Manifest","Gradle","Fragment")
                ),
                Quiz(
                    13,
                    "13. Which of the following is the parent class of Activity?",
                    IS_RADIO_BUTTON,
                    "The android Activity is the subclass of ContextThemeWrapper class. Android Activity Lifecycle is controlled by 7 methods of android.app.Activity class. An activity is a single screen in android. It is like a window or frame of Java.",
                    "c",
                    "contextThemeWrapper",
                    "",
                    "",
                    mutableListOf("context","object","contextThemeWrapper","None of the above")
                ),
                Quiz(
                    14,
                    "14. Which of the following features are updated in Android 4.1(Jelly Bean)?",
                    IS_CHECK_BOX,
                    "Android 4.1(Jelly Bean) updates to following features: smoother user interface, enhance accessibility, expandable notification, fixed bug on Nexus 7, one-finger gestures to expand/collapse notifications, lock screen improvement, multiple user accounts (tablets only), new clock application, Bluetooth low energy support, volume for incoming call, 4K resolution support, native emoji support, bug fixes for the Nexus 7 LTE.",
                    "abc",
                    "User Interface\nLock screen improvement\nNew clock application",
                    "",
                    "",
                    mutableListOf("User Interface","Lock screen improvement","New clock application")
                ),
                Quiz(
                    15,
                    "15. Which of the following method is used by services to clean up any services?",
                    IS_RADIO_BUTTON,
                    "The onDestroy() method can be used by services to clean up any resources like receivers, threads, registered listeners, etc.",
                    "c",
                    "onDestroy() method",
                    "",
                    "",
                    mutableListOf("onStop() method","stopService() method","onDestroy() method","stopSelf() method")
                )
            )
        }
    }
}