package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class VoicePrintFinishUI$1 implements OnClickListener {
    final /* synthetic */ VoicePrintFinishUI sib;

    VoicePrintFinishUI$1(VoicePrintFinishUI voicePrintFinishUI) {
        this.sib = voicePrintFinishUI;
    }

    public final void onClick(View view) {
        if (VoicePrintFinishUI.a(this.sib) == 72) {
            Intent intent = new Intent();
            intent.setClass(this.sib, VoiceUnLockUI.class);
            intent.putExtra("kscene_type", 73);
            this.sib.startActivity(intent);
        }
        this.sib.finish();
    }
}
