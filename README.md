# FontsManager
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-FontsManager-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/1928)
[![License](https://img.shields.io/badge/license-Apache%202-green.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![](https://jitpack.io/v/GcsSloop/FontsManager.svg)](https://jitpack.io/#GcsSloop/FontsManager)

## [中文版说明文档戳这里](https://github.com/GcsSloop/AndroidFontsManager/blob/master/README-CN.md)

#### Author's weibo: [@GcsSloop](http://weibo.com/GcsSloop)

## Overview

**Android FontsManager： It can help you change font of view easily !**

## Demo
![](http://ww4.sinaimg.cn/large/005Xtdi2jw1f2ip77q8ydg306j0b4jry.gif)


## Prepare

#### Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

``` gradle
	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```

#### Step 2. Add the dependency

``` gradle
	dependencies {
	        compile 'com.github.GcsSloop:FontsManager:v1.0.0'
	}
```

> ### if you use Maven, [Click Here](https://jitpack.io/#GcsSloop/FontsManager/)

## Usage

#### Initialization the fontsmanager before use
You can use any of the following four methods to initialize the FontManager.

``` java
	// NO.1
	FontsManager.init(typeface);                     // use typeface
	// NO.2
	FontsManager.initFormAssets(context, fontPath);  // use context and path（file in Assets）
	// NO.3
	FontsManager.initFormFile(fontFile);             // use font file in sdcard
	// NO.4
	FontsManager.initFormFile(fontFilePath);         // use font filePath in sdcard
```

#### Change Activity font
``` java
	FontsManager.changeFonts(activity);
```
#### Change View font
``` java
	FontsManager.changeFonts(view);
```
#### Change ViewGroup font
``` java
	FontsManager.changeFonts(viewGroup);
```
## Complete example
``` java
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		FontsManager.initFormAssets(this, "fonts/sao.ttf");	//initialization
		FontsManager.changeFonts(this);		                //Change Activity font
	}
```

## Release Notes

Version | Notes
   ---  |  ---
 v1.0.0 | From bintray to JitPack.


## About Me

<a href="https://github.com/GcsSloop/SloopBlog/blob/master/FINDME.md" target="_blank"> <img src="http://ww4.sinaimg.cn/large/005Xtdi2gw1f1qn89ihu3j315o0dwwjc.jpg" width=300 height=100 /> </a>


# License
```
Copyright (c) 2015 GcsSloop

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



