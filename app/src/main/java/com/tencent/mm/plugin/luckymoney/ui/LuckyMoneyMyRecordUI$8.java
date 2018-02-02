package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a.i;

class LuckyMoneyMyRecordUI$8 implements OnItemClickListener {
    final /* synthetic */ LuckyMoneyMyRecordUI oiq;
    final /* synthetic */ LuckyMoneyMyRecordUI$a oiu;

    LuckyMoneyMyRecordUI$8(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI, LuckyMoneyMyRecordUI$a luckyMoneyMyRecordUI$a) {
        this.oiq = luckyMoneyMyRecordUI;
        this.oiu = luckyMoneyMyRecordUI$a;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.oiq.dismissDialog(1);
        String kC = this.oiu.kC(i);
        this.oiu.atq = i;
        if (!kC.equals(LuckyMoneyMyRecordUI.j(this.oiq))) {
            LuckyMoneyMyRecordUI.a(this.oiq, kC);
            LuckyMoneyMyRecordUI.k(this.oiq).setText(this.oiq.getString(i.uKH, new Object[]{LuckyMoneyMyRecordUI.j(this.oiq)}));
            LuckyMoneyMyRecordUI.l(this.oiq);
            LuckyMoneyMyRecordUI.m(this.oiq).clear();
            LuckyMoneyMyRecordUI.n(this.oiq).clear();
            LuckyMoneyMyRecordUI.d(this.oiq);
        }
        g.pQN.h(11701, Integer.valueOf(LuckyMoneyMyRecordUI.e(this.oiq)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), kC);
    }
}
