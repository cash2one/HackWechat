package com.tencent.mm.ui;

import android.content.Context;
import android.content.SharedPreferences.Editor;

public final class ac {
    private static float gOa = 0.0f;

    public static float eu(Context context) {
        float f = context.getSharedPreferences(com.tencent.mm.sdk.platformtools.ac.cfs(), 0).getFloat("text_size_scale_key", 1.0f);
        gOa = f;
        return f;
    }

    public static void h(Context context, float f) {
        Editor edit = context.getSharedPreferences(com.tencent.mm.sdk.platformtools.ac.cfs(), 0).edit();
        edit.putFloat("text_size_scale_key", f);
        edit.commit();
        gOa = f;
    }
}
