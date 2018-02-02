package com.tencent.mm.ui.appbrand;

import android.view.View;
import android.view.View.OnClickListener;

class c$1 implements OnClickListener {
    final /* synthetic */ c xVM;

    c$1(c cVar) {
        this.xVM = cVar;
    }

    public final void onClick(View view) {
        if (this.xVM.xVK != null) {
            this.xVM.xVK.coD();
        }
        this.xVM.vru.dismiss();
    }
}
