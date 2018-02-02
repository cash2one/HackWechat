package com.tencent.mm.ui.account;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bh;

class RegByMobileRegAIOUI$20 implements OnClickListener {
    final /* synthetic */ RegByMobileRegAIOUI xQK;

    RegByMobileRegAIOUI$20(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        this.xQK = regByMobileRegAIOUI;
    }

    public final void onClick(View view) {
        bh.F(this.xQK.mController.xIM, this.xQK.getString(R.l.eSl));
    }
}
