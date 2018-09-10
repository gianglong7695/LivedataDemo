package com.dg.livedataexample.utils;

import android.util.Log;

import com.dg.livedataexample.BuildConfig;

public class Logs {
    private static boolean isDebug = true;
    private static String TAG = BuildConfig.APPLICATION_ID;


    public static void v(String msg) {
        if(isDebug){
            v(TAG, msg);
        }

    }

    public static void v(String tag, String msg) {
        if(isDebug){
            Log.v(tag, msg);

        }
    }

    public static void d(String msg) {
        if(isDebug){
            d(TAG, msg);

        }
    }

    public static void d(String tag, String msg) {
        if(isDebug){
            Log.d(tag, msg);

        }
    }

    public static void i(String msg) {
        if(isDebug){
            i(TAG, msg);

        }
    }

    public static void i(String tag, String msg) {
        if(isDebug){
            Log.i(tag, msg);

        }
    }

    public static void w(String msg) {
        if(isDebug){
            w(TAG, msg);

        }
    }

    public static void w(String tag, String msg) {
        if(isDebug){
            Log.i(tag, msg);

        }
    }

    public static void e(String msg) {
        if(isDebug){
            e(TAG, msg);

        }
    }

    public static void e(String tag, String msg) {
        if(isDebug){
            Log.e(tag, msg);

        }
    }
}
