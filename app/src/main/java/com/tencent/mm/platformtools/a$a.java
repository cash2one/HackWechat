package com.tencent.mm.platformtools;

import android.content.Context;

public class a$a {
    public static int b(Context context, float f) {
        b bVar = new b();
        return Math.round((((float) context.getResources().getDisplayMetrics().densityDpi) * f) / 160.0f);
    }
}
