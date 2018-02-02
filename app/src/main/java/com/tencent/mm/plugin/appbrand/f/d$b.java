package com.tencent.mm.plugin.appbrand.f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.f.d.a;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.fts.d.a.b;
import com.tencent.mm.plugin.fts.d.a.b$b;
import com.tencent.mm.sdk.platformtools.bh;

public class d$b extends b$b {
    final /* synthetic */ d iWb;

    public d$b(d dVar) {
        this.iWb = dVar;
        super(dVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(h.iwQ, viewGroup, false);
        a aVar = this.iWb.iVY;
        aVar.iip = (ImageView) inflate.findViewById(g.bLL);
        aVar.iiq = (TextView) inflate.findViewById(g.cSu);
        aVar.contentView = inflate.findViewById(g.cJK);
        aVar.iVZ = (TextView) inflate.findViewById(g.iws);
        aVar.iWa = (TextView) inflate.findViewById(g.iwB);
        inflate.setTag(aVar);
        return inflate;
    }

    public final void a(Context context, b.a aVar, b bVar, Object... objArr) {
        d dVar = (d) bVar;
        a aVar2 = (a) aVar;
        if (dVar.iVV == null) {
            aVar2.contentView.setVisibility(8);
            return;
        }
        aVar2.contentView.setVisibility(0);
        aVar2.iiq.setText(this.iWb.iVW);
        CharSequence ju = com.tencent.mm.plugin.appbrand.appcache.a.ju(this.iWb.iVV.iGA);
        if (bh.ov(ju)) {
            aVar2.iWa.setVisibility(8);
        } else {
            aVar2.iWa.setText(ju);
            aVar2.iWa.setVisibility(0);
        }
        com.tencent.mm.modelappbrand.a.b.Jj().a(aVar2.iip, dVar.iVV.iJJ, com.tencent.mm.modelappbrand.a.a.Ji(), f.hkr);
    }

    public final boolean a(Context context, b bVar) {
        d dVar = (d) bVar;
        com.tencent.mm.sdk.b.b qpVar = new qp();
        qpVar.fIi.userName = dVar.iVV.fnl;
        qpVar.fIi.fIl = dVar.iVV.iGA;
        qpVar.fIi.fIo = true;
        qpVar.fIi.scene = 1027;
        com.tencent.mm.sdk.b.a.xef.m(qpVar);
        return true;
    }
}
