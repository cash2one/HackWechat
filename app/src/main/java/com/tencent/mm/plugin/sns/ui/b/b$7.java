package com.tencent.mm.plugin.sns.ui.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.base.h;

class b$7 implements OnClickListener {
    final /* synthetic */ b rPY;

    b$7(b bVar) {
        this.rPY = bVar;
    }

    public final void onClick(View view) {
        h.a(this.rPY.activity, j.qMu, j.dGO, j.dEw, j.dEn, new 1(this, view), null);
    }
}
