package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.pluginsdk.model.app.ab.a;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class AppAttachDownloadUI$5 implements OnClickListener {
    final /* synthetic */ AppAttachDownloadUI ypv;

    AppAttachDownloadUI$5(AppAttachDownloadUI appAttachDownloadUI) {
        this.ypv = appAttachDownloadUI;
    }

    public final void onClick(View view) {
        AppAttachDownloadUI.k(this.ypv).setVisibility(8);
        AppAttachDownloadUI.l(this.ypv).setVisibility(0);
        AppAttachDownloadUI.m(this.ypv).setVisibility(8);
        x.i("MicroMsg.AppAttachDownloadUI", "summerapp stopBtn downloadAppAttachScene[%s]", new Object[]{AppAttachDownloadUI.a(this.ypv)});
        if (AppAttachDownloadUI.a(this.ypv) != null) {
            ab a = AppAttachDownloadUI.a(this.ypv);
            a aVar = this.ypv;
            if (!a.veL) {
                g.MJ().kI(a.hBn);
                a.veF = an.aqd().Rz(a.mediaId);
            }
            x.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig pause listener[%s], info[%s], justSaveFile[%b], stack[%s]", new Object[]{aVar, a.veF, Boolean.valueOf(a.veL), bh.cgy()});
            if (a.veF != null) {
                if (a.veF.field_status == 101 && aVar != null) {
                    aVar.bYO();
                }
                a.veF.field_status = 102;
                if (!a.veL) {
                    an.aqd().c(a.veF, new String[0]);
                }
            }
            com.tencent.mm.kernel.g.CG().c(AppAttachDownloadUI.a(this.ypv));
            return;
        }
        c o = AppAttachDownloadUI.o(this.ypv);
        if (o != null && o.field_status != 199) {
            x.i("MicroMsg.AppAttachDownloadUI", "summerapp stopBtn onClick but scene is null and set status[%d] paused", new Object[]{Long.valueOf(o.field_status)});
            o.field_status = 102;
            an.aqd().c(o, new String[0]);
        }
    }
}
