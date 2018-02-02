package com.tencent.mm.plugin.sns.ui;

import android.graphics.BitmapFactory.Options;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.sdk.platformtools.d;

class SnsBrowseUI$3 implements OnPreDrawListener {
    final /* synthetic */ SnsBrowseUI rzl;

    SnsBrowseUI$3(SnsBrowseUI snsBrowseUI) {
        this.rzl = snsBrowseUI;
    }

    public final boolean onPreDraw() {
        this.rzl.ryY.getViewTreeObserver().removeOnPreDrawListener(this);
        SnsBrowseUI.a(this.rzl, this.rzl.ryY.getWidth());
        SnsBrowseUI.b(this.rzl, this.rzl.ryY.getHeight());
        SnsBrowseUI.c(this.rzl, this.rzl.ryY.getWidth());
        SnsBrowseUI.d(this.rzl, this.rzl.ryY.getHeight());
        ae.bvs();
        String C = g.C(this.rzl.ryY.bzo());
        if (C != null) {
            Options UL = d.UL(C);
            SnsBrowseUI.d(this.rzl, (int) (((float) UL.outHeight) * (((float) SnsBrowseUI.b(this.rzl)) / ((float) UL.outWidth))));
            if (SnsBrowseUI.c(this.rzl) > this.rzl.ryY.getHeight()) {
                SnsBrowseUI.d(this.rzl, this.rzl.ryY.getHeight());
            }
        }
        this.rzl.kSb.fg(SnsBrowseUI.b(this.rzl), SnsBrowseUI.c(this.rzl));
        this.rzl.kSb.a(this.rzl.ryY, SnsBrowseUI.d(this.rzl), null);
        this.rzl.bAz();
        return true;
    }
}
