package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class CleanNewUI$2 implements OnClickListener {
    final /* synthetic */ CleanNewUI lhD;

    CleanNewUI$2(CleanNewUI cleanNewUI) {
        this.lhD = cleanNewUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.CleanNewUI", "%s goto clean msg ui", new Object[]{CleanNewUI.a(this.lhD)});
        g.pQN.a(714, 2, 1, false);
        this.lhD.startActivityForResult(new Intent(this.lhD, CleanMsgUI.class), 0);
    }
}
