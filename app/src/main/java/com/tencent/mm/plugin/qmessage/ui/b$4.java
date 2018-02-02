package com.tencent.mm.plugin.qmessage.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.bm.d;

class b$4 implements OnClickListener {
    final /* synthetic */ b pnJ;

    b$4(b bVar) {
        this.pnJ = bVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        d.a(this.pnJ.context, "accountsync", "com.tencent.mm.ui.bindqq.BindQQUI", null);
    }
}
