package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class e$2 implements OnClickListener {
    final /* synthetic */ e kRr;

    e$2(e eVar) {
        this.kRr = eVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (this.kRr.kRn != null) {
            this.kRr.kRn.avF();
        }
    }
}
