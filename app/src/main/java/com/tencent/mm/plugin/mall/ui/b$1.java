package com.tencent.mm.plugin.mall.ui;

import android.view.View;
import android.view.View.OnClickListener;

class b$1 implements OnClickListener {
    final /* synthetic */ b ols;

    b$1(b bVar) {
        this.ols = bVar;
    }

    public final void onClick(View view) {
        b.a(this.ols, !b.a(this.ols));
        b.b(this.ols);
        this.ols.notifyDataSetChanged();
    }
}
