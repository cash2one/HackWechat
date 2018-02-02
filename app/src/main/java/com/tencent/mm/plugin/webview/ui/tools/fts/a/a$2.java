package com.tencent.mm.plugin.webview.ui.tools.fts.a;

import android.view.View;
import android.view.View.OnLongClickListener;

class a$2 implements OnLongClickListener {
    final /* synthetic */ c tET;
    final /* synthetic */ a tEU;

    a$2(a aVar, c cVar) {
        this.tEU = aVar;
        this.tET = cVar;
    }

    public final boolean onLongClick(View view) {
        if (this.tEU.tES != null) {
            this.tEU.tES.b(this.tET);
        }
        return true;
    }
}
