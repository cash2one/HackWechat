package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.ui.HomeUI.18;
import com.tencent.mm.ui.account.ShowAgreementsUI;

class HomeUI$18$1 implements OnClickListener {
    final /* synthetic */ 18 xGA;
    final /* synthetic */ String xGz;

    HomeUI$18$1(18 18, String str) {
        this.xGA = 18;
        this.xGz = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent(HomeUI.d(this.xGA.xGv), ShowAgreementsUI.class);
        intent.putExtra("agreement_type", 1);
        if (!t.ov(this.xGz)) {
            intent.putExtra("disagree_tip", this.xGz);
        }
        intent.putExtra("country_code", g.Dj().CU().get(274436, "").toString());
        HomeUI.d(this.xGA.xGv).startActivityForResult(intent, 22722);
    }
}
