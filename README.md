# FontsManager
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-FontsManager-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/1928)
[![License](https://img.shields.io/badge/license-Apache%202-green.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![Maven Central](https://img.shields.io/bintray/v/gcssloop/maven/fontsmanager.svg)](https://bintray.com/gcssloop/maven/fontsmanager/view)

## [中文版说明文档戳这里](https://github.com/GcsSloop/AndroidFontsManager/blob/master/README-CN.md)

#### Author's weibo: [@攻城师sloop](http://weibo.com/5459430586)

## Overview

**Android FontsManager, It can help you change the module font easily.**

## Demo
![fontsmanagerpic](https://github.com/GcsSloop/AndroidFontsManager/blob/master/Pic/fontsmanagerdemo.gif)


## Prepare

#### 1.Add this in your Project's build.gradle
``` gradle
 //sloop's maven
  maven {url "http://dl.bintray.com/gcssloop/maven"}
```
Example：
``` gradle
allprojects {
    repositories {
        jcenter()
        //sloop's maven
        maven {url "http://dl.bintray.com/gcssloop/maven"}
    }
}
```
#### 2.Add this in your Module's build.gradle
``` gradle
    //fontsmanager
    compile 'com.sloop.view.fonts:fontsmanager:1.2.3'
```
Example：
``` gradle
dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    testCompile 'junit:junit:4.12'
    compile 'com.android.support:appcompat-v7:23.0.1'
    //fontsmanager
    compile 'com.sloop.view.fonts:fontsmanager:1.2.3'
}
```

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

## About me

[知乎](https://www.zhihu.com/people/li-yu-long-38) | [微博](http://weibo.com/5459430586) | [CSDN](http://blog.csdn.net/u013831257?viewmode=list) | [Github](https://github.com/GcsSloop)
 --- | --- | --- | ---
![](http://ww2.sinaimg.cn/mw690/005Xtdi2gw1f12thhjxn0j30810b4dhe.jpg) | ![](http://ww2.sinaimg.cn/mw690/005Xtdi2gw1f12t31cqbtj30b40b4gnp.jpg) | ![](http://ww2.sinaimg.cn/mw690/005Xtdi2gw1f12t3d4rnvj30b40b4jti.jpg) | ![](http://ww4.sinaimg.cn/mw690/005Xtdi2gw1f12t3mosq5j30b40b40tr.jpg)


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
