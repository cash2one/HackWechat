package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelvideo.c;

class ad$8 implements OnCancelListener {
    final /* synthetic */ c onS;
    final /* synthetic */ ad yCE;

    ad$8(ad adVar, c cVar) {
        this.yCE = adVar;
        this.onS = cVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.onS.hTo = null;
    }
}
