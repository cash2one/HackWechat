package com.tencent.mm.plugin.favorite.ui;

import android.app.Dialog;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.ui.FavSelectUI.4;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.snackbar.a;

class FavSelectUI$4$1 implements Runnable {
    final /* synthetic */ Dialog msk;
    final /* synthetic */ 4 mtv;

    FavSelectUI$4$1(4 4, Dialog dialog) {
        this.mtv = 4;
        this.msk = dialog;
    }

    public final void run() {
        if (this.msk != null) {
            this.msk.dismiss();
        }
        a.h(this.mtv.mtu, this.mtv.mtu.getString(R.l.eic));
        ag.h(new 1(this), 1800);
    }
}
