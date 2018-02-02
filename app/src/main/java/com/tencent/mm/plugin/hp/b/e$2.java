package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.hp.tinker.g;

class e$2 implements OnClickListener {
    final /* synthetic */ e nAN;
    final /* synthetic */ Context val$context;

    e$2(e eVar, Context context) {
        this.nAN = eVar;
        this.val$context = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.ah(this.val$context, this.nAN.nAL.nBq);
    }
}
