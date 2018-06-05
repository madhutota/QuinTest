package com.dev.quintest.bluetooth;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

public class Utility {
    private static  final boolean logMessageOnOrOff = true;

    public static Typeface setTypeFace_fontawesome(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "fontawesome-webfont.ttf");
    }


    public static boolean isValueNullOrEmpty(String value) {
        boolean isValue = false;
        if (value == null || value.equals(null) || value.equals("")
                || value.equals("null") || value.trim().length() == 0) {
            isValue = true;
        }
        return isValue;
    }

    public static void showLog(String logMsg, String logVal) {
        try {
            if (logMessageOnOrOff) {
                if (!isValueNullOrEmpty(logMsg) && !isValueNullOrEmpty(logVal)) {
                    Log.e(logMsg, logVal);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
