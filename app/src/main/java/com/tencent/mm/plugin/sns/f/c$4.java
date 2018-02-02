package com.tencent.mm.plugin.sns.f;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.sns.f.d.b;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.sdk.platformtools.x;

class c$4 implements OnClickListener {
    final /* synthetic */ bjv qUr;
    final /* synthetic */ b rad;
    final /* synthetic */ c rae;
    final /* synthetic */ d raf;
    final /* synthetic */ c rag;
    final /* synthetic */ d$a rai;
    final /* synthetic */ Context val$context;

    c$4(c cVar, Context context, bjv com_tencent_mm_protocal_c_bjv, d$a com_tencent_mm_plugin_sns_f_d_a, b bVar, c cVar2, d dVar) {
        this.rag = cVar;
        this.val$context = context;
        this.qUr = com_tencent_mm_protocal_c_bjv;
        this.rai = com_tencent_mm_plugin_sns_f_d_a;
        this.rad = bVar;
        this.rae = cVar2;
        this.raf = dVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.SnSABTestMgr", "onClick alert2");
        c.a(this.rag, this.val$context, this.qUr, this.rai, this.rad, this.rae, this.raf);
    }
}
