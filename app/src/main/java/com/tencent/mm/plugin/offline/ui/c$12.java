package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.offline.a.s.g;
import com.tencent.mm.sdk.platformtools.x;

class c$12 implements OnClickListener {
    final /* synthetic */ c oXK;
    final /* synthetic */ g oXL;

    c$12(c cVar, g gVar) {
        this.oXK = cVar;
        this.oXL = gVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (this.oXK.oXF != null) {
            this.oXK.oXF.o(0, this.oXL.id, "");
        }
        com.tencent.mm.plugin.offline.g.bQ(this.oXL.fwY, com.tencent.mm.plugin.offline.g.oVz);
        x.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do cancel pay");
    }
}
