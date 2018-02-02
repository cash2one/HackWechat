package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.d.a.b$a;
import com.tencent.mm.plugin.fts.d.a.b.b;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.plugin.search.ui.a.a.a;

public class a$b extends b {
    final /* synthetic */ a qdH;

    public a$b(a aVar) {
        this.qdH = aVar;
        super(aVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(R.i.dji, viewGroup, false);
        a aVar = new a(this.qdH);
        aVar.jCP = (ImageView) inflate.findViewById(R.h.coO);
        aVar.mPU = (TextView) inflate.findViewById(R.h.cRV);
        aVar.contentView = inflate.findViewById(R.h.cJK);
        inflate.setTag(aVar);
        return inflate;
    }

    public final void a(Context context, b$a com_tencent_mm_plugin_fts_d_a_b_a, com.tencent.mm.plugin.fts.d.a.b bVar, Object... objArr) {
        a aVar = (a) com_tencent_mm_plugin_fts_d_a_b_a;
        cm(aVar.contentView);
        e.a(this.qdH.qdE, aVar.mPU);
        aVar.jCP.setImageResource(R.k.dAy);
    }

    public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.b bVar) {
        return false;
    }
}
