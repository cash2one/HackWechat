package com.google.android.exoplayer2.a;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;

@TargetApi(19)
class f$b extends f$a {
    private final AudioTimestamp agX = new AudioTimestamp();
    private long agY;
    private long agZ;
    private long aha;

    public f$b() {
        super();
    }

    public final void a(AudioTrack audioTrack, boolean z) {
        super.a(audioTrack, z);
        this.agY = 0;
        this.agZ = 0;
        this.aha = 0;
    }

    public final boolean iO() {
        boolean timestamp = this.afZ.getTimestamp(this.agX);
        if (timestamp) {
            long j = this.agX.framePosition;
            if (this.agZ > j) {
                this.agY++;
            }
            this.agZ = j;
            this.aha = j + (this.agY << 32);
        }
        return timestamp;
    }

    public final long iP() {
        return this.agX.nanoTime;
    }

    public final long iQ() {
        return this.aha;
    }
}
