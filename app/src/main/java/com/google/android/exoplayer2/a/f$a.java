package com.google.android.exoplayer2.a;

import android.media.AudioTrack;
import android.os.SystemClock;

class f$a {
    protected AudioTrack afZ;
    private boolean agQ;
    private long agR;
    private long agS;
    private long agT;
    private long agU;
    private long agV;
    private long agW;
    private int sampleRate;

    private f$a() {
    }

    public void a(AudioTrack audioTrack, boolean z) {
        this.afZ = audioTrack;
        this.agQ = z;
        this.agU = -9223372036854775807L;
        this.agR = 0;
        this.agS = 0;
        this.agT = 0;
        if (audioTrack != null) {
            this.sampleRate = audioTrack.getSampleRate();
        }
    }

    public final void x(long j) {
        this.agV = iM();
        this.agU = SystemClock.elapsedRealtime() * 1000;
        this.agW = j;
        this.afZ.stop();
    }

    public final void pause() {
        if (this.agU == -9223372036854775807L) {
            this.afZ.pause();
        }
    }

    public final long iM() {
        if (this.agU != -9223372036854775807L) {
            return Math.min(this.agW, ((((SystemClock.elapsedRealtime() * 1000) - this.agU) * ((long) this.sampleRate)) / 1000000) + this.agV);
        }
        int playState = this.afZ.getPlayState();
        if (playState == 1) {
            return 0;
        }
        long playbackHeadPosition = 4294967295L & ((long) this.afZ.getPlaybackHeadPosition());
        if (this.agQ) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.agT = this.agR;
            }
            playbackHeadPosition += this.agT;
        }
        if (this.agR > playbackHeadPosition) {
            this.agS++;
        }
        this.agR = playbackHeadPosition;
        return playbackHeadPosition + (this.agS << 32);
    }

    public final long iN() {
        return (iM() * 1000000) / ((long) this.sampleRate);
    }

    public boolean iO() {
        return false;
    }

    public long iP() {
        throw new UnsupportedOperationException();
    }

    public long iQ() {
        throw new UnsupportedOperationException();
    }
}
