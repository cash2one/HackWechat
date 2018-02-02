package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.q$g;
import com.tencent.mm.plugin.appbrand.widget.input.ad.a;

class ad$1 extends a<ViewGroup, f> {
    final /* synthetic */ ad jZC;

    ad$1(ad adVar) {
        this.jZC = adVar;
        super((byte) 0);
    }

    final /* synthetic */ View cb(View view) {
        return (f) view.findViewById(q$g.iuy);
    }

    final boolean ca(View view) {
        return view.getId() == q$g.iux;
    }
}
