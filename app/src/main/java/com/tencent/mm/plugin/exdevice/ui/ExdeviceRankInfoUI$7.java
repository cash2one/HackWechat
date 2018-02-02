package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class ExdeviceRankInfoUI$7 implements OnCancelListener {
    final /* synthetic */ ExdeviceRankInfoUI lXj;

    ExdeviceRankInfoUI$7(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        this.lXj = exdeviceRankInfoUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (ExdeviceRankInfoUI.e(this.lXj) != null) {
            ExdeviceRankInfoUI.e(this.lXj).dismiss();
            ExdeviceRankInfoUI.f(this.lXj);
        }
        this.lXj.finish();
    }
}
