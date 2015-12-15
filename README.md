# FontsManager
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-FontsManager-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/1928)
[![License](https://img.shields.io/badge/license-Apache%202-green.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![Maven Central](https://img.shields.io/bintray/v/gcssloop/maven/fontsmanager.svg)](https://bintray.com/gcssloop/maven/fontsmanager/view)

### 字体管理器，方便快速的为应用内所有组件更换字体。

### 作者微博: [@安卓攻城师sloop](http://weibo.com/5459430586)

# 更新说明
```
 在1.2.0(包括1.2.0)之前版本引用Library目录下的jar文件
 在1.2.1(包括1.2.1)之后版本可以选择直接引用源码或者使用gradle添加依赖的形式加入项目
```
# 如何添加
### Android Studio
#### 1.在Project的build.gradle中添加仓库地址
```
 //sloop的仓库地址
  maven {url "http://dl.bintray.com/gcssloop/maven"}
```
示例：
```
allprojects {
    repositories {
        jcenter()
        //sloop的仓库地址
        maven {url "http://dl.bintray.com/gcssloop/maven"}
    }
}
```
#### 2.在Module目录下的build.gradle中添加依赖
```
    //fontsmanager
    compile 'com.sloop.view.fonts:fontsmanager:1.2.2'
```
示例：
```
  dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    testCompile 'junit:junit:4.12'
    compile 'com.android.support:appcompat-v7:23.0.1'
    //fontsmanager
    compile 'com.sloop.view.fonts:fontsmanager:1.2.2'
}
```

# 使用文档
### 初始化
		FontsManager.init(typeface);                     //传入一个typeface初始化
		FontsManager.initFormAssets(context, fontPath);  //传入上下文和字体包路径（字体文件在Assets中）
		FontsManager.initFormFile(fontFile);             //传入一个字体包文件
		FontsManager.initFormFile(fontFilePath);         //传入一个字体包文件路径
### 改变一个activity的字体
		FontsManager.changeFonts(activity);
### 改变一个view的字体
		FontsManager.changeFonts(view);
### 改变一个ViewGroup的字体
		FontsManager.changeFonts(viewGroup);

## 示例
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		FontsManager.initFormAssets(this, "fonts/sao.ttf");	//初始化
		FontsManager.changeFonts(this);		                //进行替换
	}

# 更新说明

版本号 | 更新内容
  ---  |  ---
v1.0.0 | 实现替换 View ViewGroup Activity字体
v1.0.1 | 完善错误提示
v1.2.0 | 支持替换ActionBar标题字体
v1.2.1 | 支持Gradle构建 优化部分代码
v1.2.2 | 修复ActionBar字体无法自动替换的问题
v1.2.3 | 修复一个ActionBar相关的BUG

## Demo演示
![fontsmanagerpic](https://github.com/GcsSloop/AndroidFontsManager/blob/master/Pic/fontsmanagerdemo.gif)


  




