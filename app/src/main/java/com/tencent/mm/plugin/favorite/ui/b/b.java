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
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;

public final class b extends a {
    public b(h hVar) {
        super(hVar);
    }

    public final View a(View view, ViewGroup viewGroup, f fVar) {
        com.tencent.mm.plugin.favorite.ui.b.a.b bVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            com.tencent.mm.plugin.favorite.ui.b.a.b aVar = new a();
            view = a(View.inflate(context, R.i.dhx, null), aVar, fVar);
            aVar.jCP = (ImageView) view.findViewById(R.h.cgI);
            aVar.iiq = (TextView) view.findViewById(R.h.cho);
            aVar.iiq.setSingleLine(false);
            aVar.iiq.setMaxLines(2);
            aVar.iir = (TextView) view.findViewById(R.h.cgu);
            aVar.mxT = (TextView) view.findViewById(R.h.cgZ);
            bVar = aVar;
        } else {
            a aVar2 = (a) view.getTag();
        }
        a(bVar, fVar);
        uq p = j.p(fVar);
        ar.Hg();
        a EK = c.Fa().EK(p.desc);
        if (EK.rYX == null || EK.rYX.length() <= 0) {
            x.e("MicroMsg.FavCardListItem", "parse possible friend msg failed");
        }
        if (bh.ov(a(EK))) {
            bVar.iir.setVisibility(8);
        } else {
            bVar.iir.setText(a(EK));
        }
        bVar.mxT.setText(R.l.efA);
        bVar.mxT.setVisibility(0);
        ImageView imageView = bVar.jCP;
        String str = EK.rYX;
        if (bh.ov(str)) {
            imageView.setImageResource(R.g.bBB);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.a(imageView, str);
        }
        return view;
    }

    public final void a(View view, vg vgVar) {
        e.a(view.getContext(), ((a) view.getTag()).mqC, vgVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String a(a aVar) {
        Object obj = 1;
        Object obj2 = null;
        String str = aVar.gfN;
        if (bh.ov(str)) {
            str = aVar.rYX;
            if (com.tencent.mm.storage.x.WB(str) || s.gD(str)) {
                obj2 = 1;
            }
        }
        if (obj2 == null) {
            ar.Hg();
        }
        obj = obj2;
        return (obj != null || s.gM(aVar.tmE)) ? "" : str;
    }
}
