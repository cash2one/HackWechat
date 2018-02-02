package com.tencent.mm.plugin.voip.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.plugin.voip.video.h.a;

class h$3 implements OnCompletionListener {
    final /* synthetic */ h suJ;
    final /* synthetic */ int suK;
    final /* synthetic */ long suL;
    final /* synthetic */ boolean suM;
    final /* synthetic */ int suN;

    h$3(h hVar, int i, long j, boolean z, int i2) {
        this.suJ = hVar;
        this.suK = i;
        this.suL = j;
        this.suM = z;
        this.suN = i2;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        if (System.currentTimeMillis() - this.suJ.suG > 70000) {
            this.suJ.suF = 4;
        }
        if (this.suJ.fdc) {
            this.suJ.suI = new a(this.suJ, this.suK, this.suL, this.suM, this.suN);
            this.suJ.hae.postDelayed(this.suJ.suI, this.suL);
        }
    }
}
