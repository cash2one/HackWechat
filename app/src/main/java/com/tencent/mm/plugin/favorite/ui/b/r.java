package com.tencent.mm.plugin.favorite.ui.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.plugin.favorite.ui.b.a.b;
import com.tencent.mm.protocal.c.vg;

public final class r extends a {
    public r(h hVar) {
        super(hVar);
    }

    public final View a(View view, ViewGroup viewGroup, f fVar) {
        b bVar;
        CharSequence string;
        Context context = viewGroup.getContext();
        if (view == null) {
            b aVar = new a();
            view = a(View.inflate(context, R.i.dhD, null), aVar, fVar);
            aVar.iiq = (TextView) view.findViewById(R.h.cho);
            bVar = aVar;
        } else {
            a aVar2 = (a) view.getTag();
        }
        a(bVar, fVar);
        int bv = (int) j.bv((long) j.p(fVar).duration);
        TextView textView = bVar.iiq;
        context = this.mpb.context;
        if (bv <= 0) {
            string = context.getString(R.l.egU, new Object[]{Integer.valueOf(0)});
        } else {
            string = context.getString(R.l.egU, new Object[]{Integer.valueOf(bv)});
        }
        textView.setText(string);
        return view;
    }

    public final void a(View view, vg vgVar) {
        e.a(view.getContext(), ((a) view.getTag()).mqC, vgVar);
    }
}
