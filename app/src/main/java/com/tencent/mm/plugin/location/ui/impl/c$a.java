package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.view.animation.TranslateAnimation;
import java.util.ArrayList;
import java.util.List;

class c$a extends TranslateAnimation {
    final /* synthetic */ c nXi;
    private List<View> nXk = new ArrayList();

    public c$a(c cVar, float f) {
        this.nXi = cVar;
        super(0.0f, 0.0f, 0.0f, f);
    }

    public final c$a aWB() {
        setFillEnabled(true);
        setFillAfter(true);
        return this;
    }

    public final c$a co(View view) {
        this.nXk.add(view);
        return this;
    }

    public final void anF() {
        for (int i = 0; i < this.nXk.size(); i++) {
            ((View) this.nXk.get(i)).startAnimation(this);
        }
    }
}
