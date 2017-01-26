package com.veryworks.android.activitycontrol;

import android.util.Log;

/**
 *
 * @author kodonho
 * @version 1.0
 * @since 2017
 */
public class Logger {
    // Debug Mode : 정상동작 안될경우 강제로 세팅한다
    public final static boolean DEBUG_MODE = true; //BuildConfig.DEBUG; //

    /** 로그 내용을 콘솔에 출력
     *
     * @param string
     * @param className
     */
    public static void print(String string, String className) {
        if(DEBUG_MODE) {
            Log.d(className, string);
        }
    }
}
