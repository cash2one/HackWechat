package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnClickListener;

class IPCallAcitivityUI$1 implements OnClickListener {
    final /* synthetic */ IPCallAcitivityUI nHI;

    IPCallAcitivityUI$1(IPCallAcitivityUI iPCallAcitivityUI) {
        this.nHI = iPCallAcitivityUI;
    }

    public final void onClick(View view) {
        this.nHI.finish();
    }
}
