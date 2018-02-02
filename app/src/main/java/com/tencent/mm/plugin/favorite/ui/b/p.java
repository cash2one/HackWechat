package com.tencent.mm.plugin.favorite.ui.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.plugin.favorite.ui.b.a.b;
import com.tencent.mm.pluginsdk.c;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.platformtools.bh;

public final class p extends a {
    private final int mxU;

    public p(h hVar) {
        super(hVar);
        this.mxU = a.aa(hVar.context, R.f.buY);
    }

    public final View a(View view, ViewGroup viewGroup, f fVar) {
        b aVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new a();
            view = a(View.inflate(context, R.i.dhx, null), aVar, fVar);
            aVar.jCP = (ImageView) view.findViewById(R.h.cgI);
            aVar.iiq = (TextView) view.findViewById(R.h.cho);
            aVar.iiq.setMaxLines(2);
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, fVar);
        uq p = j.p(fVar);
        vt vtVar = fVar.field_favProto.web;
        vk vkVar = fVar.field_favProto.weS;
        TextView textView = aVar.iiq;
        uq p2 = j.p(fVar);
        CharSequence charSequence = "";
        if (vtVar != null) {
            charSequence = vtVar.title;
        }
        if (bh.ov(charSequence) && p2 != null) {
            charSequence = p2.title;
        }
        if (bh.ov(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setText(charSequence);
            textView.setVisibility(0);
        }
        int Rd = c.Rd(p.wcY);
        h hVar = this.mpb;
        ImageView imageView = aVar.jCP;
        if (Rd == c.bXX()) {
            Rd = R.k.dvD;
        }
        hVar.a(imageView, p, fVar, Rd, this.mxU, this.mxU);
        return view;
    }

    public final void a(View view, vg vgVar) {
        e.a(view.getContext(), ((a) view.getTag()).mqC, vgVar);
    }
}
