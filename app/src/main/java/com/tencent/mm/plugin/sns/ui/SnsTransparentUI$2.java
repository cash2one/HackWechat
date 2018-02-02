package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac;

class SnsTransparentUI$2 implements OnDismissListener {
    final /* synthetic */ SnsTransparentUI rKZ;

    SnsTransparentUI$2(SnsTransparentUI snsTransparentUI) {
        this.rKZ = snsTransparentUI;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        ac.dw(this.rKZ);
        this.rKZ.finish();
    }
}
