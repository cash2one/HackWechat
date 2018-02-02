package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.g;

class g$37 implements OnClickListener {
    final /* synthetic */ String fgU;
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;
    final /* synthetic */ String txs;
    final /* synthetic */ String val$url;

    g$37(g gVar, String str, String str2, String str3, i iVar) {
        this.tIj = gVar;
        this.fgU = str;
        this.txs = str2;
        this.val$url = str3;
        this.tIg = iVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.pQN.h(14217, new Object[]{this.fgU, Integer.valueOf(6), this.txs, this.val$url, Integer.valueOf(3)});
        dialogInterface.dismiss();
        g.a(this.tIj, this.tIg, "add_download_task_straight:fail_network_not_wifi", null);
    }
}
