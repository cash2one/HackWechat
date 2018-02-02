package com.tencent.mm.plugin.mmsight.segment.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.mm.plugin.mmsight.segment.a.a.c;

class d$2 implements OnSeekCompleteListener {
    final /* synthetic */ c oAA;
    final /* synthetic */ d oAz;

    d$2(d dVar, c cVar) {
        this.oAz = dVar;
        this.oAA = cVar;
    }

    public final void onSeekComplete(MediaPlayer mediaPlayer) {
        this.oAA.bz(mediaPlayer);
    }
}
