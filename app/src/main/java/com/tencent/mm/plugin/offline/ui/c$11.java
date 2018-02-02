package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.offline.a.s$g;
import com.tencent.mm.sdk.platformtools.x;

class c$11 implements OnClickListener {
    final /* synthetic */ c oXK;
    final /* synthetic */ s$g oXL;

    c$11(c cVar, s$g com_tencent_mm_plugin_offline_a_s_g) {
        this.oXK = cVar;
        this.oXL = com_tencent_mm_plugin_offline_a_s_g;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (this.oXK.oXF != null) {
            this.oXK.oXF.o(1, this.oXL.id, "");
        }
        x.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do pay");
    }
}
