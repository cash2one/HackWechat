package com.tencent.mm.plugin.record.ui;

import android.app.Dialog;
import com.tencent.mm.R;
import com.tencent.mm.ui.snackbar.a;

class FavRecordDetailUI$3 implements Runnable {
    final /* synthetic */ Dialog msk;
    final /* synthetic */ FavRecordDetailUI pFP;

    FavRecordDetailUI$3(FavRecordDetailUI favRecordDetailUI, Dialog dialog) {
        this.pFP = favRecordDetailUI;
        this.msk = dialog;
    }

    public final void run() {
        this.msk.dismiss();
        a.h(this.pFP, this.pFP.getString(R.l.eic));
    }
}
