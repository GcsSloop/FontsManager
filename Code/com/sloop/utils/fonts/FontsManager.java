/**
 * @Title: FontManager.java
 * @Package com.sloop.saomsg.util Copyright: Copyright (c) 2015
 * 
 * @author sloop
 * @date 2015年3月13日 下午7:14:40
 * @version V1.0
 */
package com.sloop.utils.fonts;

import android.app.Activity;
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

	private static Typeface defaultTypeface = null;

	private FontsManager(){}

	public static void init(Typeface typeface){
		if (typeface == null) {
			throw new IllegalStateException("typeface不能为空。");
		} else {
			defaultTypeface = typeface;
		}
	}

	public static void initFormAssets(Context context, String fontPath){
		try {
			defaultTypeface = Typeface.createFromAsset(context.getAssets(), fontPath);
		} catch (Exception e) {
			throw new IllegalStateException("初始化失败，请检查fontsPath是否错误");
		}
	}

	public static void changeFonts(Activity activity){
		if (defaultTypeface == null) {
			throw new IllegalStateException("必须先使用init()进行初始化");
		}
		changeFonts((ViewGroup) activity.findViewById(android.R.id.content), defaultTypeface);
	}

	/**
	 * 更换字体
	 * 
	 * @Title: changeFonts
	 * @param context 上下文
	 * @param viewGroup view的父类
	 * @param fonts 字体文件名称（例如：sloop.ttf 请注意，字体文件必须放在assets/fonts目录下）
	 * @return true表示更换字体成功 false表示更换字体失败（可能是文件名称错误引起的）
	 */
	public static void changeFonts(ViewGroup viewGroup, Typeface typeface){
		try {
			for (int i = 0; i < viewGroup.getChildCount(); i++) {
				View v = viewGroup.getChildAt(i);
				if (v instanceof ViewGroup) {
					changeFonts((ViewGroup) v, typeface);
				} else if (v instanceof View) {
					changeFonts((View) v, typeface);
				}
			}
		} catch (Exception e) {
			// TODO
		}
	}

	public static void changeFonts(View view, Typeface typeface){
		try {
			if (view instanceof ViewGroup) {
				changeFonts((ViewGroup) view, typeface);
			} else if (view instanceof TextView) {
				((TextView) view).setTypeface(typeface);
			} else if (view instanceof Button) {
				((Button) view).setTypeface(typeface);
			} else if (view instanceof Switch) {
				((Switch) view).setTypeface(typeface);
			} else if (view instanceof EditText) {
				((EditText) view).setTypeface(typeface);
			}
		} catch (Exception e) {
			// TODO
		}

	}
}
