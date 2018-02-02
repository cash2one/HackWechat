package com.tenpay.android.wechat;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;

public class TenpayTTSUtil {
    private static boolean sEnabled = true;
    private static TextToSpeech sTts;

    public static void init(Context context) {
        if (sTts == null) {
            sTts = new TextToSpeech(context.getApplicationContext(), null);
        }
    }

    public static void setEnabled(boolean z) {
        sEnabled = z;
    }

    public static void speak(String str) {
        if (sEnabled && sTts != null && !TextUtils.isEmpty(str)) {
            sTts.speak(str, 1, null);
        }
    }

    public static void speak(CharSequence charSequence) {
        if (sEnabled && sTts != null && !TextUtils.isEmpty(charSequence)) {
            sTts.speak(charSequence.toString(), 1, null);
        }
    }

    public static void stop() {
        if (sTts != null) {
            sTts.stop();
        }
    }

    public static void destroy() {
        if (sTts != null) {
            sTts.stop();
            sTts.shutdown();
            sTts = null;
        }
    }
}
