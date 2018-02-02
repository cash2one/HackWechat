package com.tencent.mm.plugin.sns.f;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.f.d.b;
import com.tencent.mm.plugin.sns.ui.a.a.c;

class c$2 implements OnClickListener {
    final /* synthetic */ d$a rac;
    final /* synthetic */ b rad;
    final /* synthetic */ c rae;
    final /* synthetic */ d raf;
    final /* synthetic */ c rag;
    final /* synthetic */ Context val$context;

    c$2(c cVar, Context context, d$a com_tencent_mm_plugin_sns_f_d_a, b bVar, c cVar2, d dVar) {
        this.rag = cVar;
        this.val$context = context;
        this.rac = com_tencent_mm_plugin_sns_f_d_a;
        this.rad = bVar;
        this.rae = cVar2;
        this.raf = dVar;
    }

    public final void onClick(View view) {
        c.a(this.rag, this.val$context, view, this.rac, this.rad, this.rae, this.raf);
    }
}
