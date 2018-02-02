package com.tencent.mm.ui.account;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class RegByMobileVoiceVerifyUI$2 implements OnClickListener {
    final /* synthetic */ RegByMobileVoiceVerifyUI xRp;

    RegByMobileVoiceVerifyUI$2(RegByMobileVoiceVerifyUI regByMobileVoiceVerifyUI) {
        this.xRp = regByMobileVoiceVerifyUI;
    }

    public final void onClick(View view) {
        this.xRp.startActivityForResult(new Intent(this.xRp, RegByMobileVoiceVerifySelectUI.class).putExtra("voice_verify_code", RegByMobileVoiceVerifyUI.a(this.xRp)), 10000);
    }
}
