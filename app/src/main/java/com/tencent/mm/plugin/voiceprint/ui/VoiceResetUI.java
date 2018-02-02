package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.x;

public class VoiceResetUI extends VoiceUnLockUI {
    protected final void bFU() {
        x.d("MicroMsg.VoiceResetUI", "unlock success");
        startActivity(new Intent(this, VoiceCreateUI.class));
        finish();
    }
}
