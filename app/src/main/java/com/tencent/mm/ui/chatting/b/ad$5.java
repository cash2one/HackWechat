package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.pluginsdk.model.k;

class ad$5 implements OnCancelListener {
    final /* synthetic */ ad yCE;
    final /* synthetic */ k yCG;

    ad$5(ad adVar, k kVar) {
        this.yCE = adVar;
        this.yCG = kVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.yCG.bYp();
    }
}
