package com.tencent.mm.plugin.favorite.ui.b;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;

public final class h extends a {
    private final int mxU;
    private Set<ImageView> mya;
    private OnClickListener myb = new 1(this);

    static /* synthetic */ void a(h hVar, ImageView imageView) {
        x.i("MicroMsg.FavBaseListItem", "mask iv set size is %d", new Object[]{Integer.valueOf(hVar.mya.size())});
        for (ImageView imageView2 : hVar.mya) {
            if (imageView2 == imageView) {
                imageView2.setImageResource(R.g.bDR);
            } else {
                imageView2.setImageResource(R.g.bDS);
            }
        }
    }

    public h(com.tencent.mm.plugin.favorite.b.h hVar) {
        super(hVar);
        this.mxU = a.aa(hVar.context, R.f.buY);
        this.mya = new HashSet();
    }

    public final View a(View view, ViewGroup viewGroup, f fVar) {
        a$b com_tencent_mm_plugin_favorite_ui_b_a_b;
        Context context = viewGroup.getContext();
        if (view == null) {
            a$b aVar = new a();
            view = a(View.inflate(context, R.i.dhx, null), aVar, fVar);
            aVar.jCP = (ImageView) view.findViewById(R.h.cgI);
            aVar.iiq = (TextView) view.findViewById(R.h.cho);
            aVar.iir = (TextView) view.findViewById(R.h.cgu);
            aVar.myd = (ImageView) view.findViewById(R.h.cgM);
            aVar.mxT = (TextView) view.findViewById(R.h.cgZ);
            aVar.mxT.setVisibility(8);
            aVar.myd.setOnClickListener(this.myb);
            aVar.myd.setVisibility(0);
            this.mya.add(aVar.myd);
            com_tencent_mm_plugin_favorite_ui_b_a_b = aVar;
        } else {
            com_tencent_mm_plugin_favorite_ui_b_a_b = (a) view.getTag();
        }
        a(com_tencent_mm_plugin_favorite_ui_b_a_b, fVar);
        vk vkVar = fVar.field_favProto.weS;
        uq p = j.p(fVar);
        com_tencent_mm_plugin_favorite_ui_b_a_b.iiq.setText(p.title);
        com_tencent_mm_plugin_favorite_ui_b_a_b.iir.setText(p.desc);
        this.mpb.a(com_tencent_mm_plugin_favorite_ui_b_a_b.jCP, p, fVar, R.k.dvn, this.mxU, this.mxU);
        com_tencent_mm_plugin_favorite_ui_b_a_b.myd.setTag(fVar);
        if (e.l(p)) {
            com_tencent_mm_plugin_favorite_ui_b_a_b.myd.setImageResource(R.g.bDR);
        } else {
            com_tencent_mm_plugin_favorite_ui_b_a_b.myd.setImageResource(R.g.bDS);
        }
        return view;
    }

    public final void a(View view, vg vgVar) {
        e.a(view.getContext(), ((a) view.getTag()).mqC, vgVar);
    }
}
