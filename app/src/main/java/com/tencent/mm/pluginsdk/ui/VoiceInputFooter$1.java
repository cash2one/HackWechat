package com.tencent.mm.pluginsdk.ui;

import android.view.View;
import android.view.View.OnClickListener;

class VoiceInputFooter$1 implements OnClickListener {
    final /* synthetic */ VoiceInputFooter vlO;

    VoiceInputFooter$1(VoiceInputFooter voiceInputFooter) {
        this.vlO = voiceInputFooter;
    }

    public final void onClick(View view) {
        if (this.vlO.getVisibility() == 8) {
            this.vlO.setVisibility(0);
        }
        if (this.vlO.cav()) {
            VoiceInputFooter.a(this.vlO);
        }
        if (this.vlO.bCe()) {
            VoiceInputFooter.b(this.vlO);
        }
    }
}
