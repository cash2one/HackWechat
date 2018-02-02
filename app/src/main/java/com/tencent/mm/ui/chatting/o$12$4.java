package com.tencent.mm.ui.chatting;

import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.chatting.o.12;

class o$12$4 implements c {
    final /* synthetic */ 12 yss;

    o$12$4(12 12) {
        this.yss = 12;
    }

    public final void jl(int i) {
        Intent intent = new Intent();
        switch (i) {
            case 0:
                g.pQN.h(11701, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(3)});
                intent.putExtra("key_username", this.yss.ysq.crz());
                intent.putExtra("key_way", 0);
                intent.putExtra("pay_channel", 11);
                d.b(this.yss.ysq.ysg.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearSendUI", intent);
                return;
            case 1:
                g.pQN.h(11701, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1)});
                intent.putExtra("key_way", 0);
                intent.putExtra("key_type", 0);
                intent.putExtra("key_from", 1);
                intent.putExtra("key_username", this.yss.ysq.crz());
                intent.putExtra("pay_channel", 11);
                d.b(this.yss.ysq.ysg.getContext(), "luckymoney", ".ui.LuckyMoneyPrepareUI", intent);
                return;
            default:
                return;
        }
    }
}
