package com.tencent.mm.plugin.favorite.ui;

import android.app.Dialog;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.ui.FavSearchUI.2.1;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.snackbar.a;

class FavSearchUI$2$1$1 implements Runnable {
    final /* synthetic */ Dialog msk;
    final /* synthetic */ 1 mtk;

    FavSearchUI$2$1$1(1 1, Dialog dialog) {
        this.mtk = 1;
        this.msk = dialog;
    }

    public final void run() {
        if (this.msk != null) {
            this.msk.dismiss();
        }
        a.h(this.mtk.mtj.mth, this.mtk.mtj.mth.getString(R.l.eic));
        ag.h(new 1(this), 1800);
    }
}
