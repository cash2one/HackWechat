package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;

class LuckyMoneyMyRecordUI$4 implements OnItemLongClickListener {
    final /* synthetic */ LuckyMoneyMyRecordUI oiq;

    LuckyMoneyMyRecordUI$4(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI) {
        this.oiq = luckyMoneyMyRecordUI;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i > 0 && i <= LuckyMoneyMyRecordUI.f(this.oiq).getCount()) {
            h.a(this.oiq, this.oiq.getResources().getString(i.uKn), null, this.oiq.getResources().getString(i.dEw), new 1(this, i - 1));
        }
        return true;
    }
}
