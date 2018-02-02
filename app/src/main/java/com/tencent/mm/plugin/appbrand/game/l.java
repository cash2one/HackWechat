package com.tencent.mm.plugin.appbrand.game;

import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

public enum l {
    ;
    
    private int heightPixels;
    private boolean iXK;
    private int widthPixels;

    private l(String str) {
    }

    public final synchronized void bF(int i, int i2) {
        this.widthPixels = i;
        this.heightPixels = i2;
        this.iXK = true;
    }

    public final synchronized void b(Point point) {
        if (this.iXK) {
            point.x = this.widthPixels;
            point.y = this.heightPixels;
        } else {
            x.printErrStackTrace("MicroMsg.WAGameWindowSizeHandler", new IllegalStateException(), "WAGameWindowSizeHandler has not been set, but there is someone getSize from it.", new Object[0]);
        }
    }

    @Deprecated
    public static void c(Point point) {
        Context context = ac.getContext();
        if (context != null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null && windowManager.getDefaultDisplay() != null) {
                windowManager.getDefaultDisplay().getRealSize(point);
            }
        }
    }
}
