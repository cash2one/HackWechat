package com.tencent.mm.plugin.appbrand.game.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.game.a.c.a;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.fts.d.a.b.b;
import com.tencent.mm.sdk.platformtools.bh;

public class c$b extends b {
    final /* synthetic */ c iXY;

    public c$b(c cVar) {
        this.iXY = cVar;
        super(cVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(h.ixK, viewGroup, false);
        a aVar = this.iXY.iXW;
        aVar.iip = (ImageView) inflate.findViewById(g.bLL);
        aVar.iiq = (TextView) inflate.findViewById(g.cSu);
        aVar.contentView = inflate.findViewById(g.cJK);
        aVar.iVZ = (TextView) inflate.findViewById(g.iws);
        aVar.iXX = (TextView) inflate.findViewById(g.caS);
        aVar.iWa = (TextView) inflate.findViewById(g.iwB);
        inflate.setTag(aVar);
        return inflate;
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, com.tencent.mm.plugin.fts.d.a.b bVar, Object... objArr) {
        c cVar = (c) bVar;
        a aVar2 = (a) aVar;
        if (cVar.iXU == null) {
            aVar2.contentView.setVisibility(8);
            return;
        }
        aVar2.contentView.setVisibility(0);
        aVar2.iiq.setText(this.iXY.iVW);
        aVar2.iWa.setVisibility(8);
        aVar2.iXX.setVisibility(8);
        aVar2.iVZ.setVisibility(8);
        CharSequence ju;
        if (cVar.iXT != null) {
            ju = com.tencent.mm.plugin.appbrand.appcache.a.ju(cVar.iXT.iGA);
            if (bh.ov(ju)) {
                aVar2.iWa.setVisibility(8);
            } else {
                aVar2.iWa.setText(ju);
                aVar2.iWa.setVisibility(0);
            }
        } else {
            ju = cVar.iXU.field_BriefIntro;
            if (bh.ov(ju)) {
                aVar2.iXX.setVisibility(8);
            } else {
                aVar2.iXX.setText(ju);
                aVar2.iXX.setVisibility(0);
            }
        }
        com.tencent.mm.modelappbrand.a.b.Jj().a(aVar2.iip, cVar.iXU.field_IconUrl, com.tencent.mm.modelappbrand.a.a.Ji(), f.hkr);
    }

    public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.b bVar) {
        c cVar = (c) bVar;
        com.tencent.mm.sdk.b.b qpVar = new qp();
        qpVar.fIi.userName = cVar.iXU.field_UserName;
        qpVar.fIi.fIl = 0;
        if (cVar.iXT != null) {
            qpVar.fIi.fIl = cVar.iXT.iGA;
        }
        qpVar.fIi.fIo = true;
        qpVar.fIi.scene = 1027;
        com.tencent.mm.sdk.b.a.xef.m(qpVar);
        return true;
    }
}
