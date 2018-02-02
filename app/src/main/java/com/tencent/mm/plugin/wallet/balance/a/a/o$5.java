package com.tencent.mm.plugin.wallet.balance.a.a;

import android.content.Intent;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtCheckPwdInputDialogUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.axt;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.g;

class o$5 implements a<Void, axt> {
    final /* synthetic */ o syW;

    o$5(o oVar) {
        this.syW = oVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        x.i("MicroMsg.LqtSaveFetchLogic", "pre redeem finish: %s", new Object[]{(axt) obj});
        o.a(this.syW).bJB();
        o.a(this.syW, g.czQ());
        o.c(this.syW).czP();
        o.b(this.syW, r9.wER);
        Intent intent = new Intent(o.a(this.syW), WalletLqtCheckPwdInputDialogUI.class);
        intent.putExtra("lqt_fetch_pwd_title", o.a(this.syW).getString(i.uSE));
        intent.putExtra("lqt_fetch_pwd_money", (((double) o.d(this.syW)) / 100.0d));
        o.a(this.syW).startActivityForResult(intent, o.bJo());
        return zBS;
    }
}
