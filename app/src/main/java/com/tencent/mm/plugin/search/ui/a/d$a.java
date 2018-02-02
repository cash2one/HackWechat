package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.d.a.b$b;
import com.tencent.mm.plugin.fts.d.a.b.a;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.plugin.fts.d.j.c;
import com.tencent.mm.plugin.fts.d.j.d;
import com.tencent.mm.plugin.search.ui.a.d.b;

public class d$a extends b$b {
    final /* synthetic */ d qdP;

    public d$a(d dVar) {
        this.qdP = dVar;
        super(dVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(R.i.diP, viewGroup, false);
        b bVar = this.qdP.qdO;
        bVar.lgs = (TextView) inflate.findViewById(d.cox);
        bVar.contentView = inflate.findViewById(d.cJK);
        bVar.mPK = inflate.findViewById(R.h.cCk);
        bVar.iip = (ImageView) inflate.findViewById(R.h.bLL);
        inflate.setTag(bVar);
        return inflate;
    }

    public final void a(Context context, a aVar, com.tencent.mm.plugin.fts.d.a.b bVar, Object... objArr) {
        b bVar2 = (b) aVar;
        e.a(this.qdP.mPH, bVar2.lgs);
        bVar2.contentView.setBackgroundResource(c.bDq);
        com.tencent.mm.pluginsdk.ui.a.b.a(bVar2.iip, this.qdP.talker);
        if (this.qdP.position == 0) {
            bVar2.mPK.setVisibility(8);
        } else {
            bVar2.mPK.setVisibility(0);
        }
    }

    public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.b bVar) {
        return false;
    }
}
