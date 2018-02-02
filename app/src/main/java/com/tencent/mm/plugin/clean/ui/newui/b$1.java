package com.tencent.mm.plugin.clean.ui.newui;

import android.view.View;
import android.view.View.OnClickListener;

class b$1 implements OnClickListener {
    final /* synthetic */ int kI;
    final /* synthetic */ b lhJ;

    b$1(b bVar, int i) {
        this.lhJ = bVar;
        this.kI = i;
    }

    public final void onClick(View view) {
        b.a(this.lhJ, this.kI);
        this.lhJ.notifyDataSetChanged();
    }
}
