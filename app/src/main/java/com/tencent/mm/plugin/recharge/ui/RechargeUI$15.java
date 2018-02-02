package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class RechargeUI$15 implements OnClickListener {
    final /* synthetic */ RechargeUI pDQ;

    RechargeUI$15(RechargeUI rechargeUI) {
        this.pDQ = rechargeUI;
    }

    public final void onClick(View view) {
        c bMe = c.bMe();
        String str = RechargeUI.h(this.pDQ).pBK;
        x.d("MicroMsg.MallNewsManager", "removeNewsInIndexUI : " + str);
        if (!bh.ov(str) && bMe.sQL.containsKey(str)) {
            MallNews mallNews = (MallNews) bMe.sQL.get(str);
            if ("1".equals(mallNews.sQz)) {
                mallNews.sQz = "2";
                bMe.bjh();
            }
        }
        RechargeUI.i(this.pDQ).setVisibility(8);
    }
}
