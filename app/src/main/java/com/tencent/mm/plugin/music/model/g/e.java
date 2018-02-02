package com.tencent.mm.plugin.music.model.g;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import com.tencent.mm.compatible.b.d;
import com.tencent.mm.sdk.platformtools.x;

@TargetApi(16)
public final class e extends b {
    AudioTrack afZ;
    MediaCodec apB;
    int channels = 0;
    long duration = 0;
    int hey = 0;
    String oMn;
    boolean oMo = false;
    private Runnable oMp = new 1(this);
    String opJ = null;
    MediaExtractor opL;
    private boolean otH = true;
    long presentationTimeUs = 0;
    int sampleRate = 0;

    static /* synthetic */ void a(e eVar) {
        try {
            if (eVar.opL != null) {
                eVar.opL.release();
                eVar.opL = null;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.MMPlayer", e, "releaseMediaExtractor", new Object[0]);
        }
    }

    static /* synthetic */ void b(e eVar) {
        try {
            if (eVar.apB != null) {
                eVar.apB.stop();
                eVar.apB.release();
                eVar.apB = null;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.MMPlayer", e, "releaseMediaCodec", new Object[0]);
        }
    }

    static /* synthetic */ void c(e eVar) {
        try {
            if (eVar.afZ != null) {
                eVar.afZ.flush();
                eVar.afZ.release();
                eVar.afZ = null;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.MMPlayer", e, "releaseAudioTrack", new Object[0]);
        }
    }

    public final void Gv(String str) {
        this.oMn = str;
    }

    final boolean createAudioTrack() {
        x.i("MicroMsg.Music.MMPlayer", "createAudioTrack");
        int i = this.channels == 1 ? 4 : 12;
        this.afZ = new d(3, this.sampleRate, i, 2, AudioTrack.getMinBufferSize(this.sampleRate, i, 2));
        if (this.afZ != null && this.afZ.getState() == 1) {
            return true;
        }
        x.e("MicroMsg.Music.MMPlayer", "audio track not initialized");
        if (this.afZ != null) {
            try {
                this.afZ.release();
            } catch (Exception e) {
            }
        }
        return false;
    }

    public final int bez() {
        return (int) (this.presentationTimeUs / 1000);
    }

    public final int getDuration() {
        return (int) (this.duration / 1000);
    }

    public final void play() {
        x.i("MicroMsg.Music.MMPlayer", "play");
        if (!bey()) {
            this.otH = false;
            com.tencent.mm.sdk.f.e.post(this.oMp, "music_player");
        } else if (bey() && this.oMh.beD()) {
            this.oMh.oMM = 3;
            beB();
        }
    }

    private synchronized void beB() {
        x.i("MicroMsg.Music.MMPlayer", "sync notify");
        try {
            notify();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.MMPlayer", e, "syncNotify", new Object[0]);
        }
    }

    public final void stop() {
        x.i("MicroMsg.Music.MMPlayer", "stop");
        this.otH = true;
        if (this.oMh.beD()) {
            beB();
        }
    }

    public final void pause() {
        x.i("MicroMsg.Music.MMPlayer", "pause");
        if (bey()) {
            this.oMh.oMM = 2;
        }
    }

    public final void seek(long j) {
        this.opL.seekTo(1000 * j, 2);
    }

    public final synchronized void beC() {
        while (bey() && this.oMh.beD()) {
            try {
                x.i("MicroMsg.Music.MMPlayer", "wait play");
                wait();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Music.MMPlayer", e, "waitPlay", new Object[0]);
            }
        }
    }

    public final boolean isPlaying() {
        return this.oMh.isPlaying();
    }

    public final boolean bey() {
        return !this.otH;
    }

    protected final void gW(boolean z) {
        this.oMo = false;
        this.oMh.oMM = 4;
        this.otH = true;
        super.gW(z);
    }

    protected final void gX(boolean z) {
        this.oMh.oMM = 4;
        this.otH = true;
        super.gX(z);
    }

    public final String beA() {
        return this.opJ;
    }
}
