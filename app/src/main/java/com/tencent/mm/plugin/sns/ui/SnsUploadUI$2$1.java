package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.sns.ui.SnsUploadUI.2;

class SnsUploadUI$2$1 implements OnClickListener {
    final /* synthetic */ 2 rLS;

    SnsUploadUI$2$1(2 2) {
        this.rLS = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (SnsUploadUI.h(this.rLS.rLR) != null) {
            SnsUploadUI.h(this.rLS.rLR).it(10);
        }
        this.rLS.rLR.setResult(0, new Intent());
        this.rLS.rLR.finish();
    }
}
