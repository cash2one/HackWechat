package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.x.a;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.ui.base.h;

class AppBrandTBSDownloadProxyUI$6 implements OnClickListener {
    final /* synthetic */ AppBrandTBSDownloadProxyUI jME;

    AppBrandTBSDownloadProxyUI$6(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI) {
        this.jME = appBrandTBSDownloadProxyUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.pQN.a(366, 2, 1, false);
        a.kR(false);
        j.pY(2);
        if (!this.jME.isFinishing() && !this.jME.xIq) {
            AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI = this.jME;
            Context context = this.jME.mController.xIM;
            this.jME.mController.xIM.getString(q.j.dGO);
            appBrandTBSDownloadProxyUI.tipDialog = h.a(context, this.jME.mController.xIM.getString(q.j.iBz), true, null);
            this.jME.tipDialog.setOnCancelListener(new 1(this));
            AppBrandTBSDownloadProxyUI.b(this.jME);
            AppBrandTBSDownloadProxyUI.c(this.jME);
        }
    }
}
