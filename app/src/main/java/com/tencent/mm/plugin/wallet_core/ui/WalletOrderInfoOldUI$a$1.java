package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.a;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

class WalletOrderInfoOldUI$a$1 implements OnItemClickListener {
    final /* synthetic */ a sUL;

    WalletOrderInfoOldUI$a$1(a aVar) {
        this.sUL = aVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Promotions zr = this.sUL.sUK.sUE.zr(i);
        if (bh.ov(zr.paA)) {
            String fg = this.sUL.sUK.fg(zr.sIr);
            if ("-1".equals(fg) || TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(fg)) {
                g.pQN.h(13472, new Object[]{WalletOrderInfoOldUI.b(this.sUL.sUK), Integer.valueOf(zr.sOB), Integer.valueOf(1), Long.valueOf(zr.sIr), Long.valueOf(zr.sNw)});
                g.pQN.h(13033, new Object[]{Integer.valueOf(2), "", zr.url, zr.name, ""});
                if (!bh.ov(zr.sOE) && !bh.ov(zr.sOF)) {
                    x.i("MicroMsg.WalletOrderInfoOldUI", "promotion jump tiny app, username: %s, path: %s", new Object[]{zr.sOE, zr.sOF});
                    b qpVar = new qp();
                    qpVar.fIi.userName = zr.sOE;
                    qpVar.fIi.fIk = bh.az(zr.sOF, "");
                    qpVar.fIi.scene = 1060;
                    qpVar.fIi.fnp = this.sUL.sUK.oWp;
                    qpVar.fIi.fIl = 0;
                    com.tencent.mm.sdk.b.a.xef.m(qpVar);
                    g.pQN.h(14118, new Object[]{this.sUL.sUK.oWp, this.sUL.sUK.bJQ(), Integer.valueOf(2)});
                    WalletOrderInfoOldUI.a(this.sUL.sUK, new d(this.sUL.sUK, zr.sIr, zr.sOC, zr.sNu, zr.sNv, this.sUL.sUK.bJQ(), WalletOrderInfoOldUI.b(this.sUL.sUK), zr.sNw));
                    WalletOrderInfoOldUI.a(this.sUL.sUK, true);
                    return;
                } else if (zr.sOB == 1) {
                    this.sUL.sUK.a(zr);
                    return;
                } else if (zr.sOB != 2 || bh.ov(zr.url)) {
                    x.e("MicroMsg.WalletOrderInfoOldUI", "promotion's activityActionType != ACTION_TYPE_NORMAL and url is null,unknow option");
                    return;
                } else if (WalletOrderInfoOldUI.c(this.sUL.sUK).containsKey(zr.sIr)) {
                    x.i("MicroMsg.WalletOrderInfoOldUI", "go to new url %s", new Object[]{((WalletOrderInfoOldUI.b) WalletOrderInfoOldUI.c(this.sUL.sUK).get(zr.sIr)).url});
                    this.sUL.sUK.Nn(r0.url);
                    return;
                } else {
                    this.sUL.sUK.sRB = zr.url;
                    this.sUL.sUK.a(zr.url, new d(this.sUL.sUK, zr.sIr, zr.sOC, zr.sNu, zr.sNv, this.sUL.sUK.bJQ(), WalletOrderInfoOldUI.b(this.sUL.sUK), zr.sNw));
                    return;
                }
            }
            return;
        }
        if (this.sUL.sUK.sTU.contains(zr.paA)) {
            this.sUL.sUK.sTU.remove(zr.paA);
        } else {
            this.sUL.sUK.sTU.add(zr.paA);
        }
        this.sUL.sUK.sUB.notifyDataSetChanged();
    }
}
