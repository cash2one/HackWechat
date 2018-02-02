package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.x;

class c$16 implements OnClickListener {
    final /* synthetic */ c oXK;

    c$16(c cVar) {
        this.oXK = cVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.X(this.oXK.mActivity, 0);
        x.i("MicroMsg.OfflineLogicMgr", "do startBindBankcard");
    }
}
