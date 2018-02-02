package com.tencent.mm.plugin.voiceprint.ui;

import android.view.View;
import android.view.View.OnClickListener;

class BaseVoicePrintUI$2 implements OnClickListener {
    final /* synthetic */ BaseVoicePrintUI shC;

    BaseVoicePrintUI$2(BaseVoicePrintUI baseVoicePrintUI) {
        this.shC = baseVoicePrintUI;
    }

    public final void onClick(View view) {
        this.shC.finish();
    }
}
