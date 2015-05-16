# FontsManager
字体管理器，方便快速的为应用内所有组件更换字体。

## Demo演示
![fontsmanagerpic](https://github.com/GcsSloop/AndroidFontsManager/blob/master/Pic/fontsmanagerdemo.gif)

## 调用示例
        //找到需要修改字体的父类组件
		ViewGroup root = (ViewGroup) findViewById(R.id.view_root);
        //更换字体
		FontsManager.changeFonts(root, this); 

## 使用前请修改FontsManager中的字体

### 个人建议在每个构建视图的xml文件的根节点都加上一个id，然后直接找都这个id就能一下替换整个页面的字体了。
