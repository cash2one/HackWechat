package com.tencent.mm.plugin.card.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.card.b.d.b;

class d$4 implements OnClickListener {
    final /* synthetic */ b kXz;

    d$4(b bVar) {
        this.kXz = bVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.kXz.awa();
    }
}
