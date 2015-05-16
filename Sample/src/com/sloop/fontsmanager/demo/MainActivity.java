package com.sloop.fontsmanager.demo;

import com.sloop.utils.fonts.FontsManager;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final ViewGroup root = (ViewGroup) findViewById(R.id.root);//找到View根节点
		findViewById(R.id.button).setOnClickListener(new OnClickListener() {

			public void onClick(View v){
				//执行替换并获得替换结果
				boolean isSuccess = FontsManager.changeFonts(MainActivity.this, root, "sao.ttf");
				if (isSuccess) {
					Toast.makeText(MainActivity.this, "替换成功", 1).show();
				} else {
					Toast.makeText(MainActivity.this, "替换失败", 1).show();
				}
			}
		});
	}
}
