package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;

class VoiceTransTextUI$6 extends af {
    final /* synthetic */ VoiceTransTextUI rZw;

    VoiceTransTextUI$6(VoiceTransTextUI voiceTransTextUI) {
        this.rZw = voiceTransTextUI;
    }

    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            VoiceTransTextUI.b(this.rZw, true);
        } else if (i == 2) {
            VoiceTransTextUI.b(this.rZw, false);
        }
    }
}
