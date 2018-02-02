package com.tencent.mm.compatible.util;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.sdk.platformtools.bh;

public final class n {
    public static String eN(String str) {
        if (str == null || q.gGe.gER == 2 || q.gGe.gFc == 1) {
            return str;
        }
        if (q.gGe.gER == 1) {
            if (str.toString().contains("\n")) {
                return str.toString().replace("\n", " ");
            }
            return str;
        } else if (VERSION.SDK_INT == 16 && str.toString().contains("\n") && bh.az(Build.MANUFACTURER, "").toLowerCase().indexOf("meizu".toLowerCase()) < 0) {
            return str.toString().replace("\n", " ");
        } else {
            return str;
        }
    }
}
