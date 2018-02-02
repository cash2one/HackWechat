package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;

class b$1 implements OnClickListener {
    final /* synthetic */ b pOs;

    b$1(b bVar) {
        this.pOs = bVar;
    }

    public final void onClick(View view) {
        if (b.a(this.pOs) != null) {
            b.a(this.pOs).onClick(view);
            this.pOs.dismiss();
        }
    }
}
