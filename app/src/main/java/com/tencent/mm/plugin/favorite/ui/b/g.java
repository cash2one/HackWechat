package com.tencent.mm.plugin.favorite.ui.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.protocal.c.vd;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.sdk.platformtools.bh;

public final class g extends a {
    private final int mxU;

    public g(h hVar) {
        super(hVar);
        this.mxU = a.aa(hVar.context, R.f.buY);
    }

    public final View a(View view, ViewGroup viewGroup, f fVar) {
        a$b aVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new a();
            view = a(View.inflate(context, R.i.dhx, null), aVar, fVar);
            aVar.jCP = (ImageView) view.findViewById(R.h.cgI);
            aVar.iiq = (TextView) view.findViewById(R.h.cho);
            aVar.iir = (TextView) view.findViewById(R.h.cgu);
            aVar.mxT = (TextView) view.findViewById(R.h.cgZ);
            aVar.mxT.setVisibility(8);
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, fVar);
        vd vdVar = fVar.field_favProto.wed;
        aVar.iiq.setText(bh.ou(vdVar.title));
        aVar.iir.setText(bh.ou(vdVar.desc));
        aVar.iiq.setSingleLine(false);
        aVar.iiq.setMaxLines(2);
        this.mpb.a(aVar.jCP, null, fVar, R.k.dvx, this.mxU, this.mxU);
        return view;
    }

    public final void a(View view, vg vgVar) {
        e.a(view.getContext(), ((a) view.getTag()).mqC, vgVar);
    }
}
