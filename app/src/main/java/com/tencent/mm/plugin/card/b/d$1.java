package com.tencent.mm.plugin.card.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.card.b.d.b;

class d$1 implements OnClickListener {
    final /* synthetic */ String kIo;
    final /* synthetic */ b kXz;

    d$1(b bVar, String str) {
        this.kXz = bVar;
        this.kIo = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.kXz.atf();
    }
}
