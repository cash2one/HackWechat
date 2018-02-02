package com.tencent.mm.plugin.sport.ui.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ag.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.h;

class a$2 implements OnClickListener {
    final /* synthetic */ a rUU;

    a$2(a aVar) {
        this.rUU = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ((h) g.h(h.class)).a(f.jS(this.rUU.jLe.field_username), (Activity) this.rUU.context, this.rUU.jLe);
        this.rUU.arR();
    }
}
