# Status Bar Notifier
[![Platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com)
[![API](https://img.shields.io/badge/API-16%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=16)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)


_A new way to flash your toast notifications in status bar._ 

StatusBarNotifier is an android library which enables you to pop up notification messages in android's status bar. You have options to set the text message, text color, display time, background color, auto hide etc.

This can be used in several places like in a chat application to show whenever a new user comes online or in a news app to flash the latest news while user is browsing or in an app that allows file downloading to show download complete/failed notification to the user etc. There can be so many use cases.

## Screenshot

![sample screenshot](sample/demo.gif "sample screenshot")

## Integration

This library is hosted on bintray and available on jcenter

```
repositories {
    jcenter()
}
```

Add this dependency to your `build.gradle` file:

```
implementation 'co.chiragm.sbn:library:0.0.1'
```

## Usage Instructions

```java

        // Build an instance of StatusBarNotifier
        final StatusBarNotifier statusBarNotifier = new StatusBarNotifier
                .Builder(this)
                .setAutoHide(true) // default true
                .setAutoHideDelayMillis(3000) // default 3000 ms (3 seconds)
                .build();

        // Set notification text and change colors
        statusBarNotifier.setText("Sample notification");
        statusBarNotifier.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        statusBarNotifier.getTextView().setTextColor(Color.WHITE);
        
        // Show status bar notification
        statusBarNotifier.show();
```

## License

StatusBarNotifier is licensed under `MIT license`. View [license](LICENSE).
