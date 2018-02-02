package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.ui.account.mobile.MobileInputUI;
import com.tencent.mm.z.bh;

class RegSetInfoUI$22 implements OnClickListener {
    final /* synthetic */ RegSetInfoUI xSg;

    RegSetInfoUI$22(RegSetInfoUI regSetInfoUI) {
        this.xSg = regSetInfoUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent;
        b.oH("R200_100");
        if (bh.HO().HP() == 0) {
            intent = new Intent(this.xSg, MobileInputUI.class);
            intent.putExtra("mobile_input_purpose", 2);
        } else {
            intent = new Intent(this.xSg, RegByMobileRegAIOUI.class);
        }
        intent.addFlags(67108864);
        this.xSg.startActivity(intent);
        this.xSg.finish();
    }
}
