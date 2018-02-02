package com.tencent.mm.ui.widget.picker;

import android.view.View;
import android.view.View.OnClickListener;

class b$3 implements OnClickListener {
    final /* synthetic */ b zyj;

    public b$3(b bVar) {
        this.zyj = bVar;
    }

    public final void onClick(View view) {
        b.a(this.zyj, false, null);
        this.zyj.hide();
    }
}
