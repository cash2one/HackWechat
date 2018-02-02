package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI.4;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.ui.base.h.d;

class LuckyMoneyIndexUI$4$1 implements d {
    final /* synthetic */ 4 ohR;

    LuckyMoneyIndexUI$4$1(4 4) {
        this.ohR = 4;
    }

    public final void cn(int i, int i2) {
        int i3 = 1;
        switch (i2) {
            case 1:
                g.pQN.h(11701, new Object[]{Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(6)});
                break;
            default:
                g.pQN.h(11701, new Object[]{Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(5)});
                i3 = 2;
                break;
        }
        Intent intent = new Intent();
        intent.setClass(this.ohR.ohQ.mController.xIM, LuckyMoneyMyRecordUI.class);
        intent.putExtra("key_type", i3);
        this.ohR.ohQ.startActivity(intent);
    }
}
