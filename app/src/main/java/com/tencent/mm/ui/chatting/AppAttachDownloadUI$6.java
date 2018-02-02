package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ar;

class AppAttachDownloadUI$6 implements OnClickListener {
    final /* synthetic */ AppAttachDownloadUI ypv;

    AppAttachDownloadUI$6(AppAttachDownloadUI appAttachDownloadUI) {
        this.ypv = appAttachDownloadUI;
    }

    public final void onClick(View view) {
        AppAttachDownloadUI.k(this.ypv).setVisibility(0);
        AppAttachDownloadUI.l(this.ypv).setVisibility(8);
        AppAttachDownloadUI.m(this.ypv).setVisibility(0);
        if (AppAttachDownloadUI.p(this.ypv)) {
            c o = AppAttachDownloadUI.o(this.ypv);
            if (o != null) {
                o.field_status = 101;
                o.field_lastModifyTime = bh.Wo();
                an.aqd().c(o, new String[0]);
            }
            AppAttachDownloadUI.a(this.ypv, new ab(AppAttachDownloadUI.q(this.ypv), AppAttachDownloadUI.r(this.ypv), AppAttachDownloadUI.s(this.ypv)));
            ar.CG().a(AppAttachDownloadUI.a(this.ypv), 0);
        }
    }
}
