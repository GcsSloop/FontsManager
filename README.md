# FontsManager
字体管理器，方便快速的为应用内所有组件更换字体。

## Demo演示
![fontsmanagerpic](https://github.com/GcsSloop/AndroidFontsManager/blob/master/Pic/fontsmanagerdemo.gif)

## 调用示例
		final ViewGroup root = (ViewGroup) findViewById(R.id.root);//找到View根节点
		//执行替换并获得替换结果 括号内参数分别为（上下文，根节点，字体文件名称）
		boolean isSuccess = FontsManager.changeFonts(MainActivity.this, root, "sao.ttf");
		if (isSuccess) {
			Toast.makeText(MainActivity.this, "替换成功", 1).show();
		} else {
			Toast.makeText(MainActivity.this, "替换失败", 1).show();
		}

## 注意： 字体文件必须放在assets目录下的fonts目录中。

