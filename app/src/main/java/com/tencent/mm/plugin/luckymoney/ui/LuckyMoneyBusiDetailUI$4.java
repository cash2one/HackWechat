package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.luckymoney.b.e;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.x;

class LuckyMoneyBusiDetailUI$4 implements OnClickListener {
    final /* synthetic */ LuckyMoneyBusiDetailUI ogR;
    final /* synthetic */ e ogT;

    LuckyMoneyBusiDetailUI$4(LuckyMoneyBusiDetailUI luckyMoneyBusiDetailUI, e eVar) {
        this.ogR = luckyMoneyBusiDetailUI;
        this.ogT = eVar;
    }

    public final void onClick(View view) {
        if (TextUtils.isEmpty(this.ogT.nZg)) {
            com.tencent.mm.wallet_core.ui.e.HF(12);
            h.Y(this.ogR.mController.xIM, 1);
            x.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl is empty");
            return;
        }
        x.i("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl:" + this.ogT.nZg);
        if (this.ogT.nZg.startsWith("weixin://wxpay")) {
            com.tencent.mm.wallet_core.ui.e.HF(12);
            h.Y(this.ogR.mController.xIM, 1);
            return;
        }
        com.tencent.mm.wallet_core.ui.e.HF(7);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.ogT.nZg);
        d.b(this.ogR.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
    }
}
