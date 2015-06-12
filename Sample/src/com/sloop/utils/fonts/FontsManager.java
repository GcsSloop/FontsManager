/**
 * @Title: FontManager.java
 * @Package com.sloop.saomsg.util
 * @Copyright: Copyright (c) 2015
 * 
 * @author sloop
 * @date 2015年6月1日 下午10:20:52
 * @version V1.1
 */
package com.sloop.utils.fonts;

import java.io.File;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;


/**
 * 字体管理器
 * 
 * @ClassName: FontsManager
 * @author: sloop
 * @website: http://www.sloop.icoc.cc
 * @weibo: http://weibo.com/u/5459430586
 * @date 2015年6月1日 下午10:20:52
 */
public class FontsManager {

	public static final String TAG = "FontsManagerException";
	public static final String INIT_EXCEPTION = "FontsManager使用该函数前必须先进行初始化";
	/** 默认字体 */
	public static Typeface defaultTypeface = null;

	private FontsManager(){}

	//----初始化-------------------------------------------------------------------------
	/**
	 * 初始化
	 * 
	 * @Title: init
	 * @param typeface 字体
	 */
	public static void init(Typeface typeface){
		if (typeface == null) {
			Log.e(TAG, "typeface不能为空。");
			throw new IllegalStateException("typeface不能为空。");
		} else {
			defaultTypeface = typeface;
		}
	}

	/**
	 * 初始化
	 * 
	 * @Title: initFormAssets
	 * @param context 上下文
	 * @param fontPath Assets中字体包路径
	 */
	public static void initFormAssets(Context context, String fontPath){
		try {
			defaultTypeface = Typeface.createFromAsset(context.getAssets(), fontPath);
		} catch (Exception e) {
			Log.e(TAG, "初始化失败，请检查fontsPath是否错误");
			throw new IllegalStateException("初始化失败，请检查fontsPath是否错误");
		}
	}

	/**
	 * 初始化
	 * 
	 * @Title: initFormFile
	 * @param fontPath 字体包存放路径（例如：sdcard/font.ttf）
	 */
	public static void initFormFile(String fontPath){
		try {
			defaultTypeface = Typeface.createFromFile(fontPath);
		} catch (Exception e) {
			Log.e(TAG, "初始化失败，请检查fontsPath是否错误");
			throw new IllegalStateException("初始化失败，请检查fontsPath是否错误");
		}
	}

	/**
	 * 初始化
	 * 
	 * @Title: initFormFile
	 * @param fontPath 字体包文件
	 */
	public static void initFormFile(File fontFile){
		try {
			defaultTypeface = Typeface.createFromFile(fontFile);
		} catch (Exception e) {
			Log.e(TAG, "初始化失败，请检查fontFile是否是字体文件");
			throw new IllegalStateException("初始化失败，请检查fontFile是否是字体文件");
		}
	}

	//----改变字体-------------------------------------------------------------------------
	/**
	 * 更换字体
	 * 
	 * @Title: changeFonts
	 * @param activity
	 */
	public static void changeFonts(Activity activity){
		if (defaultTypeface == null) {
			Log.e(TAG, INIT_EXCEPTION);
			throw new IllegalStateException(INIT_EXCEPTION);
		}
		ActionBarHelper.changeTitleFonts(activity, defaultTypeface);
		changeFonts((ViewGroup) activity.findViewById(android.R.id.content), defaultTypeface);
	}

	/**
	 * 更改字体
	 * 
	 * @Title: changeFonts
	 * @param view
	 */
	public static void changeFonts(View view){
		if (defaultTypeface == null) {
			Log.e(TAG, INIT_EXCEPTION);
			throw new IllegalStateException(INIT_EXCEPTION);
		}
		changeFonts(view, defaultTypeface);
	}

	/**
	 * 更改字体
	 * 
	 * @Title: changeFonts
	 * @param viewGroup
	 */
	public static void changeFonts(ViewGroup viewGroup){
		if (defaultTypeface == null) {
			Log.e(TAG, INIT_EXCEPTION);
			throw new IllegalStateException(INIT_EXCEPTION);
		}
		changeFonts(viewGroup, defaultTypeface);
	}

	/**
	 * 更换字体
	 * 
	 * @Title: changeFonts
	 * @param viewGroup
	 * @param typeface
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
			Log.e(TAG, e.toString());
			// TODO
		}
	}

	/**
	 * 更换字体
	 * 
	 * @Title: changeFonts
	 * @param view
	 * @param typeface void
	 */
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
			Log.e(TAG, e.toString());
			// TODO
		}

	}
}
