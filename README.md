# FontsManager
字体管理器，方便快速的为应用内所有组件更换字体。

## 调用示例
        //找到需要修改字体的父类组件
		ViewGroup root = (ViewGroup) findViewById(R.id.view_root);
        //更换字体
		FontsManager.changeFonts(root, this); 
