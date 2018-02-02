package com.tencent.mm.bl;

import android.os.Build.VERSION;
import com.tencent.mm.w.a.f;

public final class a {
    public static int bXV() {
        if (VERSION.SDK_INT < 19) {
            return f.bEp;
        }
        return f.bEq;
    }
}
