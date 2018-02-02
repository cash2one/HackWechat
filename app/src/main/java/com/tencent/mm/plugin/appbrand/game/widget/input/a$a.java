package com.tencent.mm.plugin.appbrand.game.widget.input;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.q$g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.widget.input.u.a;

final class a$a extends FrameLayout implements a {
    private View jaz;

    public final View afa() {
        if (this.jaz == null) {
            this.jaz = findViewById(q$g.ivO);
        }
        return this.jaz;
    }

    public a$a(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(h.iwR, this, true);
        ((Button) findViewById(q$g.ivO)).setText(j.iBL);
    }

    public final void cF(boolean z) {
        setVisibility(z ? 8 : 0);
    }
}
