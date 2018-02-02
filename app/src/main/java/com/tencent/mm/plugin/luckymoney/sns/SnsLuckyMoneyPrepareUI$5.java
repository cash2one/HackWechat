package com.tencent.mm.plugin.luckymoney.sns;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyCanShareListUI;
import com.tencent.mm.plugin.report.service.g;

class SnsLuckyMoneyPrepareUI$5 implements OnClickListener {
    final /* synthetic */ SnsLuckyMoneyPrepareUI ofF;

    SnsLuckyMoneyPrepareUI$5(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI) {
        this.ofF = snsLuckyMoneyPrepareUI;
    }

    public final void onClick(View view) {
        g.pQN.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(this.ofF)), Integer.valueOf(9)});
        Intent intent = new Intent();
        intent.setClass(this.ofF.mController.xIM, LuckyMoneyCanShareListUI.class);
        this.ofF.startActivity(intent);
    }
}
