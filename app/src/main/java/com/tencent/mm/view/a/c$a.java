package com.tencent.mm.view.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.m.a.e;

class c$a {
    TextView iir;
    ImageView jCP;
    final /* synthetic */ c zEr;
    TextView zEs;

    public c$a(c cVar, View view) {
        this.zEr = cVar;
        this.jCP = (ImageView) view.findViewById(e.bLj);
        this.iir = (TextView) view.findViewById(e.lJl);
        this.zEs = (TextView) view.findViewById(e.lJm);
        this.zEs.setTextSize(1, 12.0f);
    }
}
