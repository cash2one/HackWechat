package com.tencent.mm.plugin.mmsight.segment.a;

import android.media.MediaPlayer;
import android.view.Surface;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.plugin.mmsight.segment.a.a.a;
import com.tencent.mm.plugin.mmsight.segment.a.a.b;
import com.tencent.mm.plugin.mmsight.segment.a.a.c;

public final class d implements a {
    private MediaPlayer hXM = new j();

    public final void setSurface(Surface surface) {
        this.hXM.setSurface(surface);
    }

    public final void setDataSource(String str) {
        this.hXM.setDataSource(str);
    }

    public final void prepareAsync() {
        this.hXM.prepareAsync();
    }

    public final void start() {
        this.hXM.start();
    }

    public final void stop() {
        this.hXM.stop();
    }

    public final void pause() {
        this.hXM.pause();
    }

    public final boolean isPlaying() {
        return this.hXM.isPlaying();
    }

    public final void seekTo(int i) {
        this.hXM.seekTo(i);
    }

    public final int getCurrentPosition() {
        return this.hXM.getCurrentPosition();
    }

    public final int getDuration() {
        return this.hXM.getDuration();
    }

    public final void release() {
        this.hXM.release();
    }

    public final void setAudioStreamType(int i) {
        this.hXM.setAudioStreamType(i);
    }

    public final void setLooping(boolean z) {
        this.hXM.setLooping(z);
    }

    public final void setLoop(int i, int i2) {
    }

    public final void a(b bVar) {
        if (bVar == null) {
            this.hXM.setOnPreparedListener(null);
        } else {
            this.hXM.setOnPreparedListener(new 1(this, bVar));
        }
    }

    public final void a(c cVar) {
        if (cVar == null) {
            this.hXM.setOnSeekCompleteListener(null);
        } else {
            this.hXM.setOnSeekCompleteListener(new 2(this, cVar));
        }
    }

    public final void a(com.tencent.mm.plugin.mmsight.segment.a.a.d dVar) {
        if (dVar == null) {
            this.hXM.setOnVideoSizeChangedListener(null);
        } else {
            this.hXM.setOnVideoSizeChangedListener(new 3(this, dVar));
        }
    }

    public final void a(a aVar) {
        if (aVar == null) {
            this.hXM.setOnErrorListener(null);
        } else {
            this.hXM.setOnErrorListener(new 4(this, aVar));
        }
    }
}
