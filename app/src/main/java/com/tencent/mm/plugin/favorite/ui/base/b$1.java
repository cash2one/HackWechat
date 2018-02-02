package com.tencent.mm.plugin.favorite.ui.base;

import android.view.View;
import android.view.View.OnClickListener;

class b$1 implements OnClickListener {
    final /* synthetic */ b muW;

    public b$1(b bVar) {
        this.muW = bVar;
    }

    public final void onClick(View view) {
        if (this.muW.muV != null) {
            this.muW.muV.aJo();
        }
    }
}
