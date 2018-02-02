package com.tencent.mm.plugin.favorite.ui.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.plugin.favorite.ui.b.a.b;
import com.tencent.mm.protocal.c.vg;

public final class d extends a {
    private static int mxU;

    public d(h hVar) {
        super(hVar);
        mxU = a.aa(hVar.context, R.f.buZ);
    }

    public final View a(View view, ViewGroup viewGroup, f fVar) {
        b bVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            b aVar = new a();
            view = a(View.inflate(context, R.i.dhz, null), aVar, fVar);
            aVar.mxV = (ImageView) view.findViewById(R.h.cgP);
            bVar = aVar;
        } else {
            a aVar2 = (a) view.getTag();
        }
        a(bVar, fVar);
        h.a(bVar.mxV, R.k.dyy, j.p(fVar), fVar, false, mxU, mxU);
        return view;
    }

    public final void a(View view, vg vgVar) {
        e.a(view.getContext(), ((a) view.getTag()).mqC, vgVar);
    }
}
