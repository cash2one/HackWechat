package com.tencent.mm.plugin.appbrand.ui;

import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import com.tencent.mm.sdk.platformtools.x;

class j$2 implements OnSystemUiVisibilityChangeListener {
    final /* synthetic */ Window jNi;

    j$2(Window window) {
        this.jNi = window;
    }

    public final void onSystemUiVisibilityChange(int i) {
        x.d("MicroMsg.AppBrandUIUtil", "visibility = " + i);
        if ((i & 4) == 0) {
            this.jNi.getDecorView().setSystemUiVisibility(j.d(this.jNi));
        }
    }
}
