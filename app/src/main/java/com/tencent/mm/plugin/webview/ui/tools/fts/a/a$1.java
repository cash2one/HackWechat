package com.tencent.mm.plugin.webview.ui.tools.fts.a;

import android.view.View;
import android.view.View.OnClickListener;

class a$1 implements OnClickListener {
    final /* synthetic */ c tET;
    final /* synthetic */ a tEU;

    a$1(a aVar, c cVar) {
        this.tEU = aVar;
        this.tET = cVar;
    }

    public final void onClick(View view) {
        if (this.tEU.tES != null) {
            this.tEU.tES.a(this.tET);
        }
    }
}
