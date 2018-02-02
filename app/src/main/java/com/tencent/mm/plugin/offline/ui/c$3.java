package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class c$3 implements OnClickListener {
    final /* synthetic */ c oXK;

    c$3(c cVar) {
        this.oXK = cVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.oXK.oXF.bhi();
        x.i("MicroMsg.OfflineLogicMgr", "do changeBankcard");
    }
}
