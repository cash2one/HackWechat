package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.b.s;

class LuckyMoneyBusiReceiveUI$9 implements OnClickListener {
    final /* synthetic */ LuckyMoneyBusiReceiveUI ohm;
    final /* synthetic */ s oho;

    LuckyMoneyBusiReceiveUI$9(LuckyMoneyBusiReceiveUI luckyMoneyBusiReceiveUI, s sVar) {
        this.ohm = luckyMoneyBusiReceiveUI;
        this.oho = sVar;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this.ohm.mController.xIM, LuckyMoneyBusiDetailUI.class);
        if (this.oho.ocR != null) {
            intent.putExtra("key_realname_guide_helper", this.oho.ocR);
        }
        intent.putExtra("key_native_url", LuckyMoneyBusiReceiveUI.j(this.ohm));
        intent.putExtra("key_sendid", this.oho.nZa);
        intent.putExtra("key_static_from_scene", LuckyMoneyBusiReceiveUI.g(this.ohm));
        this.ohm.startActivity(intent);
        this.ohm.finish();
    }
}
