package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;

class IPCallRechargeUI$2 implements OnClickListener {
    final /* synthetic */ IPCallRechargeUI nLL;
    final /* synthetic */ String nLM;

    IPCallRechargeUI$2(IPCallRechargeUI iPCallRechargeUI, String str) {
        this.nLL = iPCallRechargeUI;
        this.nLM = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.pQN.a(257, 3, 1, true);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.nLM);
        intent.putExtra("showShare", false);
        d.b(this.nLL, "webview", ".ui.tools.WebViewUI", intent);
    }
}
