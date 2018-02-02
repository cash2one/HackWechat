package com.tencent.mm.ui.chatting.h;

import android.view.View;
import android.view.View.OnClickListener;

class b$4 implements OnClickListener {
    final /* synthetic */ b yIj;

    b$4(b bVar) {
        this.yIj = bVar;
    }

    public final void onClick(View view) {
        if (this.yIj.yIh != null) {
            this.yIj.yIh.onCancel();
        }
    }
}
