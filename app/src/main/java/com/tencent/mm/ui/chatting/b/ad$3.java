package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.ArrayList;

class ad$3 implements OnClickListener {
    final /* synthetic */ ad yCE;
    final /* synthetic */ ArrayList yCF;

    ad$3(ad adVar, ArrayList arrayList) {
        this.yCE = adVar;
        this.yCF = arrayList;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.yCE.aj(this.yCF);
    }
}
