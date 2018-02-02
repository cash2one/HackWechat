package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;

class j$2 implements OnClickListener {
    final /* synthetic */ j kVh;

    j$2(j jVar) {
        this.kVh = jVar;
    }

    public final void onClick(View view) {
        if (this.kVh.inJ != null && this.kVh.inJ.isShowing()) {
            this.kVh.inJ.dismiss();
        }
    }
}
