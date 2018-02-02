package com.tencent.mm.plugin.appbrand.game.widget.input;

import android.view.View;
import android.view.View.OnClickListener;

class a$1 implements OnClickListener {
    final /* synthetic */ a jay;

    a$1(a aVar) {
        this.jay = aVar;
    }

    public final void onClick(View view) {
        if (a.a(this.jay) != null) {
            a.a(this.jay).onClick(view);
        }
    }
}
