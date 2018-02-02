package com.tencent.mm.plugin.readerapp.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class b$2 implements OnClickListener {
    final /* synthetic */ b pAI;

    b$2(b bVar) {
        this.pAI = bVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.g(this.pAI.context, false);
    }
}
