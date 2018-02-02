package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.h.a;

class m$5 implements OnClickListener {
    final /* synthetic */ a icC;
    final /* synthetic */ int pa;
    final /* synthetic */ Context val$context;

    m$5(Context context, a aVar, int i) {
        this.val$context = context;
        this.icC = aVar;
        this.pa = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        m.c(this.val$context, this.icC.url, this.pa);
    }
}
