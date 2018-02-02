package com.tencent.mm.plugin.voiceprint.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class SettingsVoicePrintUI$5 implements OnClickListener {
    final /* synthetic */ SettingsVoicePrintUI shL;

    SettingsVoicePrintUI$5(SettingsVoicePrintUI settingsVoicePrintUI) {
        this.shL = settingsVoicePrintUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.VoiceSettingsUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a.a(this.shL, "android.permission.RECORD_AUDIO", 80, "", "")), bh.cgy(), this.shL});
        if (a.a(this.shL, "android.permission.RECORD_AUDIO", 80, "", "")) {
            SettingsVoicePrintUI.a(this.shL);
        }
    }
}
