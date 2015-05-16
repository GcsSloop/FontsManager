/**
 * @Title: FontManager.java
 * @Package com.sloop.saomsg.util
 * Copyright: Copyright (c) 2015
 * 
 * @author sloop
 * @date 2015年3月13日 下午7:14:40
 * @version V1.0
 */

package com.sloop.sao.message.ui.util;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

/**
 * 字体管理器
 * 
 * @ClassName: FontManager
 * @author sloop
 * @date 2015年3月13日 下午7:14:40
 */

public class FontsManager {

	/**
	 * 变更字体
	 * @Title: changeFonts
	 * @param root			view的父类
	 * @param context 		上下文
	 * @return void
	 */
	public static void changeFonts(ViewGroup root, Context context) {
		Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/sao.ttf");
		for (int i = 0; i < root.getChildCount(); i++) {
			View v = root.getChildAt(i);
			if (v instanceof TextView) {
				((TextView) v).setTypeface(tf);
			} else if (v instanceof Button) {
				((Button) v).setTypeface(tf);
			} else if (v instanceof Switch) {
				((Switch) v).setTypeface(tf);
			} else if (v instanceof EditText) {
				((EditText) v).setTypeface(tf);
			} else if (v instanceof ViewGroup) {
				changeFonts((ViewGroup) v, context);
			}
		}
	}
}
