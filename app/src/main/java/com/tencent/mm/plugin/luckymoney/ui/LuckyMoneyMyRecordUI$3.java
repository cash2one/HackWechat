package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.luckymoney.b.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class LuckyMoneyMyRecordUI$3 implements OnItemClickListener {
    final /* synthetic */ LuckyMoneyMyRecordUI oiq;

    LuckyMoneyMyRecordUI$3(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI) {
        this.oiq = luckyMoneyMyRecordUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2 = 3;
        int i3 = (int) j;
        g.pQN.h(11701, Integer.valueOf(LuckyMoneyMyRecordUI.e(this.oiq)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2));
        if (i3 >= 0 && i3 < LuckyMoneyMyRecordUI.f(this.oiq).getCount()) {
            h sh = LuckyMoneyMyRecordUI.f(this.oiq).sh(i3);
            if (sh != null && !bh.ov(sh.nZa)) {
                Intent intent = new Intent();
                if (sh.ocg == 2) {
                    x.d("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go busi detail");
                    intent.setClass(this.oiq.mController.xIM, LuckyMoneyBusiDetailUI.class);
                } else {
                    x.d("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go normal detail");
                    intent.setClass(this.oiq.mController.xIM, LuckyMoneyDetailUI.class);
                }
                intent.putExtra("key_sendid", sh.nZa);
                if (LuckyMoneyMyRecordUI.a(this.oiq) != 1) {
                    i2 = 1;
                }
                intent.putExtra("key_jump_from", i2);
                this.oiq.startActivity(intent);
            }
        }
    }
}
