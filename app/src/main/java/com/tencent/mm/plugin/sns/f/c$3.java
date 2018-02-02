package com.tencent.mm.plugin.sns.f;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.sns.f.d.a;
import com.tencent.mm.plugin.sns.f.d.b;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.sdk.platformtools.x;

class c$3 implements OnClickListener {
    final /* synthetic */ bjv qUr;
    final /* synthetic */ b rad;
    final /* synthetic */ c rae;
    final /* synthetic */ d raf;
    final /* synthetic */ c rag;
    final /* synthetic */ a rah;
    final /* synthetic */ Context val$context;

    c$3(c cVar, Context context, bjv com_tencent_mm_protocal_c_bjv, a aVar, b bVar, c cVar2, d dVar) {
        this.rag = cVar;
        this.val$context = context;
        this.qUr = com_tencent_mm_protocal_c_bjv;
        this.rah = aVar;
        this.rad = bVar;
        this.rae = cVar2;
        this.raf = dVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.SnSABTestMgr", "onClick alert1");
        c.a(this.rag, this.val$context, this.qUr, this.rah, this.rad, this.rae, this.raf);
    }
}
