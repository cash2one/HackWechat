package com.tencent.mm.ui.chatting.b;

import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class f$9 implements OnClickListener {
    final /* synthetic */ OnMenuItemClickListener kQr;
    final /* synthetic */ f yzA;

    f$9(f fVar, OnMenuItemClickListener onMenuItemClickListener) {
        this.yzA = fVar;
        this.kQr = onMenuItemClickListener;
    }

    public final void onClick(View view) {
        if (!this.yzA.fhr.csq().isScreenEnable()) {
            x.w("MicroMsg.ChattingUI.ChattingHeadereMgr", "Actionbar customView onclick screen not enable");
        } else if (this.kQr != null) {
            this.kQr.onMenuItemClick(null);
        }
    }
}
