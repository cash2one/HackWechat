package com.tencent.mm.ui.widget.picker;

import android.view.View;
import android.view.View.OnClickListener;

class b$2 implements OnClickListener {
    final /* synthetic */ b zyj;

    public b$2(b bVar) {
        this.zyj = bVar;
    }

    public final void onClick(View view) {
        b.a(this.zyj, true, this.zyj.zyh.czw());
        this.zyj.hide();
    }
}
