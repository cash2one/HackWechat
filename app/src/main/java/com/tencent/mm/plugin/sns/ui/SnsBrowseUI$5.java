package com.tencent.mm.plugin.sns.ui;

import android.graphics.Rect;
import android.os.Build.VERSION;
import com.tencent.mm.ui.tools.g.a;

class SnsBrowseUI$5 implements a {
    final /* synthetic */ SnsBrowseUI rzl;

    SnsBrowseUI$5(SnsBrowseUI snsBrowseUI) {
        this.rzl = snsBrowseUI;
    }

    public final void s(int i, int i2, int i3, int i4) {
        if (this.rzl.ryY.rBU != null && VERSION.SDK_INT >= 18) {
            this.rzl.ryY.rBU.setClipBounds(new Rect(i, i2, i3, i4));
        }
    }
}
