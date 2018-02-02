package com.tencent.mm.pluginsdk.ui;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;

class VoiceSearchLayout$3 implements OnErrorListener {
    final /* synthetic */ VoiceSearchLayout vmL;
    final /* synthetic */ i vmM;

    VoiceSearchLayout$3(VoiceSearchLayout voiceSearchLayout, i iVar) {
        this.vmL = voiceSearchLayout;
        this.vmM = iVar;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        return false;
    }
}
