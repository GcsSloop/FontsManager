
# <img src="http://ww3.sinaimg.cn/large/005Xtdi2jw1f2jr4jwwodj3074074q34.jpg" width=32 /> FontsManager
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-FontsManager-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/1928)
[![License](https://img.shields.io/badge/license-Apache%202-green.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![](https://jitpack.io/v/GcsSloop/FontsManager.svg)](https://jitpack.io/#GcsSloop/FontsManager)

### 字体管理器，方便快速的为应用内所有组件更换字体。

### 作者微博: [@GcsSloop](http://weibo.com/GcsSloop)

## Demo演示
![](http://ww4.sinaimg.cn/large/005Xtdi2jw1f2ip77q8ydg306j0b4jry.gif)

## 如何添加

#### 1.在Project的build.gradle中添加仓库地址

``` gradle
	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```

#### 2.在Module目录下的build.gradle中添加依赖
``` gradle
	dependencies {
	        compile 'com.github.GcsSloop:FontsManager:v1.0.0'
	}
```

# 使用文档
### 初始化
``` java
	FontsManager.init(typeface);                     //传入一个typeface初始化
	FontsManager.initFormAssets(context, fontPath);  //传入上下文和字体包路径（字体文件在Assets中）
	FontsManager.initFormFile(fontFile);             //传入一个字体包文件
	FontsManager.initFormFile(fontFilePath);         //传入一个字体包文件路径
```
### 改变一个activity的字体
``` java
	FontsManager.changeFonts(activity);
```
### 改变一个view的字体
``` java
	FontsManager.changeFonts(view);
```
### 改变一个ViewGroup的字体
``` java
	FontsManager.changeFonts(viewGroup);
```
## 示例
``` java
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		FontsManager.initFormAssets(this, "fonts/sao.ttf");	//初始化
		FontsManager.changeFonts(this);		                //进行替换
	}
```

# 更新说明

版本号 | 更新内容
  ---  |  ---
v1.0.0 | 从 Bintray 迁移到 JitPack。



## About Me
### 作者微博: [@GcsSloop](http://weibo.com/GcsSloop)

<a href="https://github.com/GcsSloop/SloopBlog/blob/master/FINDME.md" target="_blank"> <img src="http://ww4.sinaimg.cn/large/005Xtdi2gw1f1qn89ihu3j315o0dwwjc.jpg" width=300 height=100 /> </a>


# 开源协议
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






