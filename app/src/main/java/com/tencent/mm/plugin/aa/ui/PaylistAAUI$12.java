package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.x;

class PaylistAAUI$12 implements Runnable {
    final /* synthetic */ PaylistAAUI ikp;

    PaylistAAUI$12(PaylistAAUI paylistAAUI) {
        this.ikp = paylistAAUI;
    }

    public final void run() {
        int height = this.ikp.getWindow().getDecorView().getHeight();
        int[] iArr = new int[2];
        View findViewById = this.ikp.findViewById(f.utg);
        findViewById.getLocationInWindow(iArr);
        int height2 = iArr[1] + findViewById.getHeight();
        int fromDPToPix = a.fromDPToPix(this.ikp.mController.xIM, 20);
        int fromDPToPix2 = ((height - height2) - a.fromDPToPix(this.ikp.mController.xIM, 24)) - a.fromDPToPix(this.ikp.mController.xIM, 12);
        if (fromDPToPix2 < fromDPToPix) {
            fromDPToPix2 = fromDPToPix;
        }
        x.d("MicroMsg.PaylistAAUI", "height: %s, h1: %s, topMargin: %s", new Object[]{Integer.valueOf(height), Integer.valueOf(height2), Integer.valueOf(fromDPToPix2)});
        LayoutParams layoutParams = (LayoutParams) PaylistAAUI.f(this.ikp).getLayoutParams();
        layoutParams.topMargin = fromDPToPix2;
        PaylistAAUI.f(this.ikp).setLayoutParams(layoutParams);
    }
}
