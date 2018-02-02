package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnClickListener;

class i$1 implements OnClickListener {
    final /* synthetic */ i vry;

    i$1(i iVar) {
        this.vry = iVar;
    }

    public final void onClick(View view) {
        if (!(this.vry.vrx == null || this.vry.vrt == null)) {
            this.vry.vrx.SB(this.vry.vrt.vrr);
        }
        this.vry.vru.dismiss();
    }
}
