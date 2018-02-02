package com.tencent.mm.plugin.favorite.ui.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.plugin.favorite.d;
import com.tencent.mm.plugin.favorite.ui.b.a.b;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMImageView;

public final class m extends a {
    private final int mxU;
    private final String mys = "";

    public static class a extends b {
        TextView iiq;
        TextView iir;
        MMImageView mvZ;
        TextView mxT;
    }

    public m(h hVar) {
        super(hVar);
        this.mxU = com.tencent.mm.bv.a.aa(hVar.context, R.f.buY);
    }

    public final View a(View view, ViewGroup viewGroup, f fVar) {
        b aVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new a();
            view = a(View.inflate(context, R.i.dhx, null), aVar, fVar);
            aVar.mvZ = (MMImageView) view.findViewById(R.h.cgI);
            aVar.iiq = (TextView) view.findViewById(R.h.cho);
            aVar.iir = (TextView) view.findViewById(R.h.cgu);
            aVar.mxT = (TextView) view.findViewById(R.h.cgZ);
            aVar.mxT.setVisibility(0);
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, fVar);
        vn vnVar = fVar.field_favProto.wef;
        if (vnVar != null) {
            aVar.iiq.setText(bh.ou(vnVar.title));
            aVar.iir.setText(bh.ou(vnVar.desc));
        } else {
            aVar.iiq.setText("");
            aVar.iir.setText("");
        }
        aVar.mxT.setText(bh.az(d.getAppName(context, fVar.field_favProto.weS.appId), this.mys));
        this.mpb.a(aVar.mvZ, null, fVar, R.k.dvx, this.mxU, this.mxU);
        return view;
    }

    public final void a(View view, vg vgVar) {
        e.a(view.getContext(), ((a) view.getTag()).mqC, vgVar);
    }
}
