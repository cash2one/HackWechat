package com.tencent.mm.plugin.fts.d.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.d.a.b.b;
import com.tencent.mm.plugin.fts.d.a.c.a;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.plugin.fts.d.j$e;
import com.tencent.mm.plugin.fts.d.j.d;

public class c$b extends b {
    final /* synthetic */ c mPL;

    public c$b(c cVar) {
        this.mPL = cVar;
        super(cVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(j$e.diX, viewGroup, false);
        a aVar = (a) this.mPL.adq();
        aVar.lgs = (TextView) inflate.findViewById(d.cox);
        aVar.mPK = inflate.findViewById(d.cCk);
        aVar.contentView = inflate.findViewById(d.cJK);
        inflate.setTag(aVar);
        return inflate;
    }

    public final void a(Context context, b.a aVar, b bVar, Object... objArr) {
        a aVar2 = (a) aVar;
        e.a(this.mPL.mPH, aVar2.lgs);
        if (this.mPL.position == 0) {
            aVar2.mPK.setVisibility(8);
        } else {
            aVar2.mPK.setVisibility(0);
        }
        cn(aVar2.contentView);
    }

    public final boolean a(Context context, b bVar) {
        return false;
    }
}
