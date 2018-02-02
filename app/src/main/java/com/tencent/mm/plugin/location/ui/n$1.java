package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.view.View.OnClickListener;

class n$1 implements OnClickListener {
    final /* synthetic */ n nVM;

    public n$1(n nVar) {
        this.nVM = nVar;
    }

    public final void onClick(View view) {
        if (this.nVM.nVI == null) {
            return;
        }
        if (this.nVM.nVI.getVisibility() == 0) {
            this.nVM.nVI.setVisibility(4);
            this.nVM.isVisible = false;
            return;
        }
        this.nVM.nVI.setVisibility(0);
        this.nVM.isVisible = true;
    }
}
