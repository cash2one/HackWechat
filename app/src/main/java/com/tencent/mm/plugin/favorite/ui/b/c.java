package com.tencent.mm.plugin.favorite.ui.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.plugin.favorite.ui.b.a.b;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.sdk.platformtools.bh;

public final class c extends a {

    public static class a extends b {
        TextView iiq;
        TextView iir;
        ImageView jCP;
    }

    public c(h hVar) {
        super(hVar);
    }

    public final View a(View view, ViewGroup viewGroup, f fVar) {
        b bVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            b aVar = new a();
            view = a(View.inflate(context, R.i.dhy, null), aVar, fVar);
            aVar.jCP = (ImageView) view.findViewById(R.h.cgI);
            aVar.iiq = (TextView) view.findViewById(R.h.cho);
            aVar.iir = (TextView) view.findViewById(R.h.cgx);
            bVar = aVar;
        } else {
            a aVar2 = (a) view.getTag();
        }
        a(bVar, fVar);
        uq p = j.p(fVar);
        CharSequence charSequence = fVar.field_favProto.title;
        if (bh.ov(charSequence)) {
            charSequence = p.title;
        }
        bVar.iiq.setText(charSequence);
        bVar.iir.setText(j.ah((float) p.wde));
        if (p.wdR == 2) {
            bVar.iir.setText(">25MB");
        }
        bVar.jCP.setImageResource(com.tencent.mm.pluginsdk.model.c.Rr(p.wcY));
        return view;
    }

    public final void a(View view, vg vgVar) {
        e.a(view.getContext(), ((a) view.getTag()).mqC, vgVar);
    }
}
