package com.tencent.mm.plugin.scanner.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.scanner.b;
import com.tencent.mm.sdk.platformtools.x;

class p$2 implements OnClickListener {
    final /* synthetic */ p pYq;

    p$2(p pVar) {
        this.pYq = pVar;
    }

    public final void onClick(View view) {
        if (this.pYq.pXp == null) {
            x.e("MicroMsg.scanner.ScanModeQRCode", "toMyQRCodeOnclickListener scanUICallback == null");
            return;
        }
        g.pQN.h(11264, new Object[]{Integer.valueOf(3)});
        b.ifs.au(this.pYq.pXp.getContext());
    }
}
