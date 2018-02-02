package com.tencent.mm.ui.account;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;

class LoginVoiceUI$1 implements OnClickListener {
    final /* synthetic */ LoginVoiceUI xPM;

    LoginVoiceUI$1(LoginVoiceUI loginVoiceUI) {
        this.xPM = loginVoiceUI;
    }

    public final void onClick(View view) {
        g.pQN.h(11557, new Object[]{Integer.valueOf(2)});
        Intent intent = new Intent();
        intent.putExtra("Kusername", this.xPM.xOI);
        intent.putExtra("kscene_type", 1);
        d.b(this.xPM.mController.xIM, "voiceprint", ".ui.VoiceLoginUI", intent, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
    }
}
