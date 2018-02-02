package com.tencent.mm.plugin.fingerprint.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.d.b.a;
import com.tencent.mm.sdk.platformtools.x;

class SoterPayTestUI$2 implements OnClickListener {
    final /* synthetic */ SoterPayTestUI mAj;

    SoterPayTestUI$2(SoterPayTestUI soterPayTestUI) {
        this.mAj = soterPayTestUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.SoterPayTestUI", "hy: regen and upload ask");
        a.a(new 1(this), false, null);
    }
}
