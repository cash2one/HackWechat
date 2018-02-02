package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

class LuckyMoneyIndexUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ LuckyMoneyIndexUI ohQ;

    LuckyMoneyIndexUI$4(LuckyMoneyIndexUI luckyMoneyIndexUI) {
        this.ohQ = luckyMoneyIndexUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        g.pQN.h(11701, new Object[]{Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4)});
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        linkedList.add(this.ohQ.getString(a$i.uKs));
        linkedList2.add(Integer.valueOf(0));
        linkedList.add(this.ohQ.getString(a$i.uKt));
        linkedList2.add(Integer.valueOf(1));
        h.a(this.ohQ.mController.xIM, "", linkedList, linkedList2, "", false, new 1(this));
        return true;
    }
}
