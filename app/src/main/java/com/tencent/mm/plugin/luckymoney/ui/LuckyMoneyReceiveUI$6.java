package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.b.ac;

class LuckyMoneyReceiveUI$6 implements OnClickListener {
    final /* synthetic */ ac oiQ;
    final /* synthetic */ LuckyMoneyReceiveUI ojZ;

    LuckyMoneyReceiveUI$6(LuckyMoneyReceiveUI luckyMoneyReceiveUI, ac acVar) {
        this.ojZ = luckyMoneyReceiveUI;
        this.oiQ = acVar;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        if (this.oiQ.ocR != null) {
            intent.putExtra("key_realname_guide_helper", this.oiQ.ocR);
        }
        intent.setClass(this.ojZ.mController.xIM, LuckyMoneyDetailUI.class);
        intent.putExtra("key_native_url", this.oiQ.fLC);
        intent.putExtra("key_sendid", this.oiQ.nZa);
        this.ojZ.startActivity(intent);
        this.ojZ.finish();
    }
}
