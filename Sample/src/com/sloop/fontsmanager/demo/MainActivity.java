package com.sloop.fontsmanager.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.sloop.utils.fonts.FontsManager;

/**
 * @ClassName: MainActivity
 * @author:	 	sloop
 * @website:	http://www.sloop.icoc.cc
 * @weibo: 		http://weibo.com/u/5459430586
 * @date 2015年6月1日 下午10:41:54
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		FontsManager.initFormAssets(this, "fonts/sao.ttf");
		findViewById(R.id.button).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v){
				FontsManager.changeFonts(MainActivity.this);
			}
		});
	}
}
