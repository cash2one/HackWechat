package com.tencent.mm.pluginsdk.ui;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

class VoiceSearchLayout$2 implements OnCompletionListener {
    final /* synthetic */ VoiceSearchLayout vmL;
    final /* synthetic */ i vmM;

    VoiceSearchLayout$2(VoiceSearchLayout voiceSearchLayout, i iVar) {
        this.vmL = voiceSearchLayout;
        this.vmM = iVar;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.release();
    }
}
