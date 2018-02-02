package com.google.android.exoplayer2.a;

import android.media.AudioTrack;

class f$1 extends Thread {
    final /* synthetic */ AudioTrack agO;
    final /* synthetic */ f agP;

    f$1(f fVar, AudioTrack audioTrack) {
        this.agP = fVar;
        this.agO = audioTrack;
    }

    public final void run() {
        try {
            this.agO.flush();
            this.agO.release();
        } finally {
            f.a(this.agP).open();
        }
    }
}
