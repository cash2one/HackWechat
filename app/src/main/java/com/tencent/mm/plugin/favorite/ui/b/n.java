package com.tencent.mm.plugin.favorite.ui.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.plugin.favorite.ui.b.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.vg;

public final class n extends a {
    public n(h hVar) {
        super(hVar);
    }

    public final View a(View view, ViewGroup viewGroup, f fVar) {
        b bVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            b aVar = new a();
            view = a(View.inflate(context, R.i.dhC, null), aVar, fVar);
            aVar.ldJ = (TextView) view.findViewById(R.h.chm);
            bVar = aVar;
        } else {
            a aVar2 = (a) view.getTag();
        }
        a(bVar, fVar);
        if (fVar.field_favProto.desc == null || fVar.field_favProto.desc.length() <= 0) {
            bVar.ldJ.setText("");
        } else {
            bVar.ldJ.setText(i.b(bVar.ldJ.getContext(), fVar.field_favProto.desc, bVar.ldJ.getTextSize()));
        }
        return view;
    }

    public final void a(View view, vg vgVar) {
        e.a(view.getContext(), ((a) view.getTag()).mqC, vgVar);
    }
}
