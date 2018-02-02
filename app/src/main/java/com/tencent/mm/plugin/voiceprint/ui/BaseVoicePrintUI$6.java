package com.tencent.mm.plugin.voiceprint.ui;

import com.tencent.mm.R;

class BaseVoicePrintUI$6 implements Runnable {
    final /* synthetic */ BaseVoicePrintUI shC;

    BaseVoicePrintUI$6(BaseVoicePrintUI baseVoicePrintUI) {
        this.shC = baseVoicePrintUI;
    }

    public final void run() {
        BaseVoicePrintUI.c(this.shC).yt(R.l.eTJ);
        BaseVoicePrintUI.c(this.shC).bFZ();
        BaseVoicePrintUI.f(this.shC).setPressed(false);
        BaseVoicePrintUI.f(this.shC).setEnabled(false);
        BaseVoicePrintUI.g(this.shC).stop();
    }
}
