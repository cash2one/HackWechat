package com.tencent.mm.plugin.luckymoney.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

class LuckyMoneyBusiReceiveUI$3 implements OnClickListener {
    final /* synthetic */ LuckyMoneyBusiReceiveUI ohm;

    LuckyMoneyBusiReceiveUI$3(LuckyMoneyBusiReceiveUI luckyMoneyBusiReceiveUI) {
        this.ohm = luckyMoneyBusiReceiveUI;
    }

    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyBusiReceiveUI");
        bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
        if (LuckyMoneyBusiReceiveUI.d(this.ohm) == null || !LuckyMoneyBusiReceiveUI.d(this.ohm).a(this.ohm, bundle, null, true)) {
            this.ohm.finish();
        } else {
            LuckyMoneyBusiReceiveUI.e(this.ohm);
        }
    }
}
