package com.tencent.mm.ui.chatting;

import com.tencent.mm.ae.f;
import com.tencent.mm.ae.k;

class AppAttachDownloadUI$4 implements f {
    final /* synthetic */ AppAttachDownloadUI ypv;

    AppAttachDownloadUI$4(AppAttachDownloadUI appAttachDownloadUI) {
        this.ypv = appAttachDownloadUI;
    }

    public final void a(int i, int i2, k kVar) {
        float f;
        if (i2 == 0) {
            f = 0.0f;
        } else {
            f = (((float) i) * 100.0f) / ((float) i2);
        }
        if (i < i2 && AppAttachDownloadUI.k(this.ypv).getVisibility() != 0) {
            AppAttachDownloadUI.k(this.ypv).setVisibility(0);
            AppAttachDownloadUI.l(this.ypv).setVisibility(8);
            AppAttachDownloadUI.m(this.ypv).setVisibility(0);
        }
        AppAttachDownloadUI.n(this.ypv).setProgress((int) f);
    }
}
