package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.view.View.OnClickListener;

class a$12 implements OnClickListener {
    final /* synthetic */ a oBU;

    a$12(a aVar) {
        this.oBU = aVar;
    }

    public final void onClick(View view) {
        this.oBU.bbz();
        if (!this.oBU.oBN && this.oBU.oBE <= 10000) {
            a aVar = this.oBU;
            this.oBU.oBG = -1;
            aVar.oBF = -1;
            this.oBU.oxA.bbI();
            this.oBU.oBC = this.oBU.oxA.oDw;
            this.oBU.oBD = false;
        }
    }
}
