package com.tencent.mm.plugin.favorite.ui.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.am.a;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.ux;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.sdk.platformtools.bh;

public final class f extends a {
    public f(h hVar) {
        super(hVar);
    }

    public final View a(View view, ViewGroup viewGroup, com.tencent.mm.plugin.fav.a.f fVar) {
        a$b com_tencent_mm_plugin_favorite_ui_b_a_b;
        Context context = viewGroup.getContext();
        if (view == null) {
            a$b aVar = new a();
            view = a(View.inflate(context, R.i.dhy, null), aVar, fVar);
            aVar.jCP = (ImageView) view.findViewById(R.h.cgI);
            aVar.iiq = (TextView) view.findViewById(R.h.cho);
            aVar.iir = (TextView) view.findViewById(R.h.cgx);
            com_tencent_mm_plugin_favorite_ui_b_a_b = aVar;
        } else {
            a aVar2 = (a) view.getTag();
        }
        a(com_tencent_mm_plugin_favorite_ui_b_a_b, fVar);
        com_tencent_mm_plugin_favorite_ui_b_a_b.jCP.setImageResource(R.k.dvm);
        ux uxVar = fVar.field_favProto.wdZ;
        CharSequence charSequence = fVar.field_favProto.iIj;
        if (!bh.ov(charSequence)) {
            com_tencent_mm_plugin_favorite_ui_b_a_b.iiq.setText(i.b(com_tencent_mm_plugin_favorite_ui_b_a_b.iiq.getContext(), charSequence, com_tencent_mm_plugin_favorite_ui_b_a_b.iiq.getTextSize()));
            if (a.kO(uxVar.fDu)) {
                com_tencent_mm_plugin_favorite_ui_b_a_b.iir.setText(uxVar.fDu);
                return view;
            }
        } else if (a.kO(uxVar.fDu)) {
            com_tencent_mm_plugin_favorite_ui_b_a_b.iiq.setText(uxVar.fDu);
        } else {
            com_tencent_mm_plugin_favorite_ui_b_a_b.iiq.setText(uxVar.label);
            com_tencent_mm_plugin_favorite_ui_b_a_b.iir.setVisibility(8);
            return view;
        }
        com_tencent_mm_plugin_favorite_ui_b_a_b.iir.setText(uxVar.label);
        return view;
    }

    public final void a(View view, vg vgVar) {
        e.a(view.getContext(), ((a) view.getTag()).mqC, vgVar);
    }
}
