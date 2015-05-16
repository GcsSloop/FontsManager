/**
 * @Title: FontManager.java
 * @Package com.sloop.saomsg.util Copyright: Copyright (c) 2015
 * 
 * @author sloop
 * @date 2015年3月13日 下午7:14:40
 * @version V1.0
 */
package com.sloop.utils.fonts;

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
	 * 更换字体
	 * 
	 * @Title: changeFonts
	 * @param context 上下文
	 * @param root view的父类
	 * @param fonts 字体文件名称（例如：sloop.ttf 请注意，字体文件必须放在assets/fonts目录下）
	 * @return 	true表示更换字体成功	false表示更换字体失败（可能是文件名称错误引起的）
	 */
	public static boolean changeFonts(Context context, ViewGroup root, String fonts){
		try {
			Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/" + fonts);
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
					changeFonts(context, (ViewGroup) v, fonts);
				}
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
