package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.view.View;
import android.view.View.OnClickListener;

class g$3 implements OnClickListener {
    final /* synthetic */ g tTj;

    g$3(g gVar) {
        this.tTj = gVar;
    }

    public final void onClick(View view) {
        this.tTj.tTh.dismiss();
        this.tTj.mParentView.setVisibility(8);
        if (this.tTj.tTi != null) {
            this.tTj.tTi.bWH();
        }
    }
}
