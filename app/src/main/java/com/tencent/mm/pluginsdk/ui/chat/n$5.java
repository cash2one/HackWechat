package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;

class n$5 implements OnClickListener {
    final /* synthetic */ n vsx;

    n$5(n nVar) {
        this.vsx = nVar;
    }

    public final void onClick(View view) {
        this.vsx.reset();
        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
        voiceInputBehavior.clear = 1;
        n.c(voiceInputBehavior);
    }
}
