package com.tencent.mm.plugin.appbrand.media.a;

import android.os.Build.VERSION;
import com.tencent.mm.ac.d;

public final class c {
    public static d bu(String str, String str2) {
        if ((VERSION.SDK_INT <= 19 ? 1 : null) != null) {
            return new b(str, str2);
        }
        return new a(str, str2);
    }
}
