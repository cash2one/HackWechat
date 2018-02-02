package com.tencent.mm.plugin.webview.fts.topstory.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.a;
import com.tencent.mm.plugin.webview.fts.topstory.a.d;

class f$11 implements OnClickListener {
    final /* synthetic */ f tpL;

    f$11(f fVar) {
        this.tpL = fVar;
    }

    public final void onClick(View view) {
        if (f.b(this.tpL) == null || f.b(this.tpL).hashCode() != ((a) g.h(a.class)).bFr()) {
            f.d(this.tpL).Ad(f.c(this.tpL));
            d.Oc(f.e(this.tpL).sey);
            d.b(f.e(this.tpL), f.c(this.tpL), false);
            return;
        }
        this.tpL.kg(true);
    }
}
