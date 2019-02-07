[![Release](https://jitpack.io/v/Qase/AndroidAppSkeleton.svg)](https://jitpack.io/#Qase/AndroidAppSkeleton)
[![Build Status](https://travis-ci.org/Qase/AndroidAppSkeleton.svg?branch=master)](https://travis-ci.org/Qase/AndroidAppSkeleton)
[![codebeat badge](https://codebeat.co/badges/4fe55c63-de52-4d3f-9d70-7f21d3a5ea60)](https://codebeat.co/projects/github-com-qase-androidappskeleton-master)
[![API](https://img.shields.io/badge/API-16%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=16)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Maintainer: havlisimo](https://img.shields.io/badge/Maintainer-havlisimo-blue.svg)](mailto:tomas.havlicek@quanti.cz)
[![Qase: AndroidAppSkeleton](https://img.shields.io/badge/Qase-AndroidAppSkeleton-ff69b4.svg)](https://github.com/Qase/AndroidAppSkeleton)

# Android App Skeleton

Android application skeleton for better fragment and navigation handling.

Currently used in all Quanti anroid projects, but there is huge update coming since google relased their own library with similiar capabilities. Further development will be discused.

[Google navigation architecture component](https://developer.android.com/topic/libraries/architecture/navigation/)

## Features
* Written in kotlin
* Usable in every JVM language including Java/Kotlin/Scala ...
* Very easy to use
* Better Fragment stack handling
* Descrptive in-code documentation of classes and functions
*
* Co jeste to dela?
* 
* Dagger integration on the way
* Demo app with basic usage is ready to build

## Installation

Click [HERE](https://jitpack.io/#Qase/AndroidAppSkeleton).

## Code example

Usage is simple

1) Inherit BaseMainActivity with your MainActivity
```kotlin
class MainActivity : BaseMainActivity() {
    ...
}
```

2) Inherit all Fragments with BaseFragment and specify bundle
```kotlin
class TestFragment : BaseFragment<TestFragmentBundle>() {
    ...
}
```

3) More can be explored in demo app - PreferenceFragment, DaggerBaseApp, BaseViewModelFragment and more


## License
[MIT](https://github.com/nishanths/license/blob/master/LICENSE)
