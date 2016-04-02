package com.sloop.fonts;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import android.util.Log;

/**
 * <ul type="disc">
 * <li>Author: Sloop</li>
 * <li>Version: v1.0.0</li>
 * <li>Copyright: Copyright (c) 2015</li>
 * <li>Date: 2015/12/15</li>
 * <li><a href="http://www.sloop.icoc.cc"    target="_blank">作者网站</a>      </li>
 * <li><a href="http://weibo.com/5459430586" target="_blank">作者微博</a>      </li>
 * <li><a href="https://github.com/GcsSloop" target="_blank">作者GitHub</a>   </li>
 * </ul>
 */
public class ActionBarHelper {

    private static final String TAG = "ABHException";

    /**
     * 改变标题字体
     *
     * @param activity activity
     * @param typeface 字体样式
     */
    public static void changeTitleFonts(Activity activity, Typeface typeface) {
        if (typeface == null || activity == null) {
            Log.e(TAG, "activity或 typeface等于空!");
            return;
        }
        if (activity instanceof ActionBarActivity) {
            try {
                android.support.v7.app.ActionBar actionBar = ((ActionBarActivity) activity).getSupportActionBar();
                if (actionBar != null)
                    setTitle(actionBar, typeface, actionBar.getTitle().toString());
            } catch (Exception e) {
                Log.e(TAG, e.toString());
            }

        }else if(activity instanceof AppCompatActivity){
            try {
                android.support.v7.app.ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
                if (actionBar != null)
                    setTitle(actionBar, typeface, actionBar.getTitle().toString());
            } catch (Exception e) {
                Log.e(TAG, e.toString());
            }
        } else {
            try {
                ActionBar actionBar = null;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    actionBar = activity.getActionBar();
                    if (actionBar != null)
                        setTitle(actionBar, typeface, actionBar.getTitle().toString());
                }
            } catch (Exception e) {
                Log.e(TAG, e.toString());
            }
        }
    }

    /**
     * 设置标题
     *
     * @param activity activity
     * @param typeface 字体样式
     * @param title    标题
     */
    public static void setTitle(Activity activity, Typeface typeface, String title) {
        if (activity instanceof ActionBarActivity) {
            try {
                android.support.v7.app.ActionBar actionBar = ((ActionBarActivity) activity).getSupportActionBar();
                setTitle(actionBar, typeface, title);
            } catch (Exception e) {
                Log.e(TAG, e.toString());
            }

        } else if (activity instanceof Activity) {
            try {
                ActionBar actionBar = null;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    actionBar = activity.getActionBar();
                }
                setTitle(actionBar, typeface, title);
            } catch (Exception e) {
                Log.e(TAG, e.toString());
            }
        }
    }

    /**
     * 设置标题
     *
     * @param actionBar 标题栏
     * @param typeface  字体样式
     * @param title     标题
     */
    public static void setTitle(android.support.v7.app.ActionBar actionBar, Typeface typeface, String title) {
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
     * @param actionBar 标题栏
     * @param typeface  字体
     * @param title     标题内容
     */
    public static void setTitle(ActionBar actionBar, Typeface typeface, String title) {
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
     * @param actionBar       标题栏
     * @param spannableString 格式化后的标题
     */
    public static void setTitle(android.support.v7.app.ActionBar actionBar, SpannableString spannableString) {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.JELLY_BEAN && Build.MANUFACTURER.toUpperCase().equals("LGE")) {
            actionBar.setTitle(spannableString.toString());
        } else {
            actionBar.setTitle(spannableString);
        }
    }


    /**
     * 设置标题
     *
     * @param actionBar       标题栏
     * @param spannableString 格式化后的标题
     */
    public static void setTitle(ActionBar actionBar, SpannableString spannableString) {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.JELLY_BEAN && Build.MANUFACTURER.toUpperCase().equals("LGE")) {
            actionBar.setTitle(spannableString.toString());
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                actionBar.setTitle(spannableString);
            }
        }
    }


    /**
     * 字体样式
     */
    private static class TypefaceSpan extends MetricAffectingSpan {

        Typeface typeface;

        TypefaceSpan(Typeface typeface) {
            this.typeface = typeface;
        }

        @Override
        public void updateMeasureState(TextPaint p) {
            p.setTypeface(typeface);
            p.setFlags(p.getFlags() | Paint.SUBPIXEL_TEXT_FLAG);
        }

        @Override
        public void updateDrawState(TextPaint tp) {
            tp.setTypeface(typeface);
            tp.setFlags(tp.getFlags() | Paint.SUBPIXEL_TEXT_FLAG);
        }
    }
}
