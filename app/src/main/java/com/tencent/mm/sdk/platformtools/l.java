package com.tencent.mm.sdk.platformtools;

import android.os.Build.VERSION;
import android.view.View;

public final class l {
    public static void bC(View view) {
        if (view != null) {
            x.j("MicroMsg.ForceGpuUtil", "setLayerType, view: %s", new Object[]{Integer.valueOf(view.hashCode())});
            if (VERSION.SDK_INT >= 11) {
                n nVar = new n();
                if (view.getLayerType() != 1) {
                    view.setLayerType(1, null);
                }
            }
        }
    }

    public static void k(View view, int i, int i2) {
        if (view != null && VERSION.SDK_INT >= 11) {
            n nVar = new n();
            int i3 = (i >= 2048 || i2 >= 2048) ? 1 : 2;
            if (view.getLayerType() != i3) {
                view.setLayerType(i3, null);
            }
        }
    }
}
