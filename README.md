# FontsManager
### 字体管理器，方便快速的为应用内所有组件更换字体。

### 作者微博: [@安卓攻城师sloop](http://weibo.com/5459430586)

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

## Demo演示
![fontsmanagerpic](https://github.com/GcsSloop/AndroidFontsManager/blob/master/Pic/fontsmanagerdemo.gif)







