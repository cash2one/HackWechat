package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wenote.model.nativenote.b.a;

class c$1 implements OnClickListener {
    final /* synthetic */ a tXK;
    final /* synthetic */ c tXL;

    c$1(c cVar, a aVar) {
        this.tXL = cVar;
        this.tXK = aVar;
    }

    public final void onClick(View view) {
        int a = c.a(this.tXL);
        if (a == 1) {
            this.tXK.f(false, 0);
            this.tXK.P(3, 100);
        } else if (a == 3) {
            this.tXK.f(true, 50);
            this.tXK.P(1, 0);
        } else if (a == 2) {
            this.tXK.P(3, 0);
        }
    }
}
