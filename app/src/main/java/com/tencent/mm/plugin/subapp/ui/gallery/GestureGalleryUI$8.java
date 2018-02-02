package com.tencent.mm.plugin.subapp.ui.gallery;

import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.ui.base.h;

class GestureGalleryUI$8 implements a {
    final /* synthetic */ String icE;
    final /* synthetic */ GestureGalleryUI rXs;

    GestureGalleryUI$8(GestureGalleryUI gestureGalleryUI, String str) {
        this.rXs = gestureGalleryUI;
        this.icE = str;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            if (n.qQx != null) {
                n.qQx.dW(this.icE, str);
                n.qQx.buj();
            }
            h.bu(this.rXs, this.rXs.getResources().getString(R.l.dGG));
        }
    }
}
