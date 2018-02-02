package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.luckymoney.b.h;
import com.tencent.mm.sdk.platformtools.bh;

class LuckyMoneyCanShareListUI$2 implements OnItemClickListener {
    final /* synthetic */ LuckyMoneyCanShareListUI ohs;

    LuckyMoneyCanShareListUI$2(LuckyMoneyCanShareListUI luckyMoneyCanShareListUI) {
        this.ohs = luckyMoneyCanShareListUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        h sh = LuckyMoneyCanShareListUI.a(this.ohs).sh((int) j);
        if (sh != null && !bh.ov(sh.nZa)) {
            Intent intent = new Intent();
            intent.setClass(this.ohs.mController.xIM, LuckyMoneyDetailUI.class);
            intent.putExtra("key_sendid", sh.nZa);
            this.ohs.startActivity(intent);
        }
    }
}
