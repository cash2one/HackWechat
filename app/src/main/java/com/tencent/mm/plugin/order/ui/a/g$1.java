package com.tencent.mm.plugin.order.ui.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

class g$1 implements OnClickListener {
    final /* synthetic */ TextView pda;
    final /* synthetic */ LinearLayout pdb;
    final /* synthetic */ g pdc;

    g$1(g gVar, TextView textView, LinearLayout linearLayout) {
        this.pdc = gVar;
        this.pda = textView;
        this.pdb = linearLayout;
    }

    public final void onClick(View view) {
        this.pda.setVisibility(8);
        for (String a : g.a(this.pdc)) {
            this.pdb.addView(g.a(this.pdc, a), new LayoutParams(-2, -2));
        }
        this.pda.setOnClickListener(null);
        if (g.b(this.pdc) != null) {
            g.b(this.pdc).notifyDataSetChanged();
        }
    }
}
