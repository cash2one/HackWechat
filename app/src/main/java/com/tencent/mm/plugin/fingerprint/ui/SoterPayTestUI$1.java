package com.tencent.mm.plugin.fingerprint.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.c.a;
import com.tencent.mm.sdk.platformtools.x;

class SoterPayTestUI$1 implements OnClickListener {
    final /* synthetic */ SoterPayTestUI mAj;

    SoterPayTestUI$1(SoterPayTestUI soterPayTestUI) {
        this.mAj = soterPayTestUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.SoterPayTestUI", "hy: start get challenge");
        g.Dk();
        g.Di().gPJ.a(1586, this.mAj);
        g.Dk();
        g.Di().gPJ.a(new a(), 0);
    }
}
