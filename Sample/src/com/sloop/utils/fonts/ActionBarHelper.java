/**
 * @Package com.sloop.utils.fonts
 * @Copyright: Copyright (c) 2015
 * 
 * @author sloop
 * @date 2015年6月9日 上午1:19:32
 * @version V1.0
 */

package com.sloop.utils.fonts;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import android.util.Log;


/**
 * @ClassName: ActionBarManager
 * @author: sloop
 * @website: http://www.sloop.icoc.cc
 * @weibo: http://weibo.com/u/5459430586
 * @date 2015年6月9日 上午1:19:32
 */

@SuppressLint("DefaultLocale")
@SuppressWarnings("deprecation")
public class ActionBarHelper {

	private static final String TAG = "ActionBarHelperException";
	public static final String INIT_EXCEPTION = "使用该函数前必须对FontsManager进行初始化";

	/**
	 * 改变标题字体
	 * 
	 * @Title: changeTitleFonts
	 * @param activity
	 * @param typeface
	 */
	public static void changeTitleFonts(Activity activity, Typeface typeface){
		if (typeface == null || activity == null) {
			Log.e(TAG, "activity或 typeface等于空!");
			return;
		}
		if (activity instanceof ActionBarActivity) {
			try {
				android.support.v7.app.ActionBar actionBar = ((ActionBarActivity) activity).getSupportActionBar();
				setTitle(actionBar, typeface, actionBar.getTitle().toString());
			} catch (Exception e) {
				Log.e(TAG, e.toString());
			}

		} else if (activity instanceof Activity) {
			try {
				ActionBar actionBar = activity.getActionBar();
				setTitle(actionBar, typeface, actionBar.getTitle().toString());
			} catch (Exception e) {
				Log.e(TAG, e.toString());
			}
		}
	}

	public static void setTitle(Activity activity, Typeface typeface, String title){
		if (activity instanceof android.support.v7.app.ActionBarActivity) {
			try {
				android.support.v7.app.ActionBar actionBar = ((ActionBarActivity) activity).getSupportActionBar();
				setTitle(actionBar, typeface, title);
			} catch (Exception e) {
				Log.e(TAG, e.toString());
			}

		} else if (activity instanceof Activity) {
			try {
				ActionBar actionBar = activity.getActionBar();
				setTitle(actionBar, typeface, title);
			} catch (Exception e) {
				Log.e(TAG, e.toString());
			}
		}
	}

	public static void setTitle(android.support.v7.app.ActionBar actionBar, Typeface typeface, String title){
		if (typeface == null || actionBar == null) {
			Log.e(TAG, "typeface或actionbar为空");
			return;
		}
		SpannableString sp = new SpannableString(title);
		sp.setSpan(new TypefaceSpan(typeface), 0, sp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		setTitle(actionBar, sp);
	}

	public static void setTitle(ActionBar actionBar, Typeface typeface, String title){
		if (typeface == null || actionBar == null) {
			Log.e(TAG, "typeface或actionbar为空");
			return;
		}
		SpannableString sp = new SpannableString(title);
		sp.setSpan(new TypefaceSpan(typeface), 0, sp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		setTitle(actionBar, sp);
	}

	/**
	 * 设置标题
	 * 
	 * @Title: setTitle
	 * @param actionBar
	 * @param spannableString
	 */
	public static void setTitle(android.support.v7.app.ActionBar actionBar, SpannableString spannableString){
		if (Build.VERSION.SDK_INT == Build.VERSION_CODES.JELLY_BEAN && Build.MANUFACTURER.toUpperCase().equals("LGE")) {
			actionBar.setTitle(spannableString.toString());
		} else {
			actionBar.setTitle(spannableString);
		}
	}


	/**
	 * 设置标题
	 * 
	 * @Title: setTitle
	 * @param actionBar
	 * @param spannableString
	 */
	@TargetApi(11)
	public static void setTitle(ActionBar actionBar, SpannableString spannableString){
		if (Build.VERSION.SDK_INT == Build.VERSION_CODES.JELLY_BEAN && Build.MANUFACTURER.toUpperCase().equals("LGE")) {
			actionBar.setTitle(spannableString.toString());
		} else {
			actionBar.setTitle(spannableString);
		}
	}


	/**
	 * 设置字体样式
	 * 
	 * @ClassName: TypefaceSpan
	 * @author: sloop
	 * @website: http://www.sloop.icoc.cc
	 * @weibo: http://weibo.com/u/5459430586
	 * @date 2015年6月9日 下午12:11:13
	 */
	private static class TypefaceSpan extends MetricAffectingSpan {

		Typeface typeface;

		TypefaceSpan(Typeface typeface){
			this.typeface = typeface;
		}

		@Override
		public void updateMeasureState(TextPaint p){
			p.setTypeface(typeface);
			p.setFlags(p.getFlags() | Paint.SUBPIXEL_TEXT_FLAG);
		}

		@Override
		public void updateDrawState(TextPaint tp){
			tp.setTypeface(typeface);
			tp.setFlags(tp.getFlags() | Paint.SUBPIXEL_TEXT_FLAG);
		}
	}
}
