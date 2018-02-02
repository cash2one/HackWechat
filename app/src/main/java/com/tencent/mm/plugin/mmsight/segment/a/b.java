package com.tencent.mm.plugin.mmsight.segment.a;

import android.os.Looper;
import android.view.Surface;
import com.tencent.mm.plugin.mmsight.segment.a.a.a;
import com.tencent.mm.plugin.mmsight.segment.a.a.c;
import com.tencent.mm.plugin.mmsight.segment.a.a.d;
import com.tencent.mm.plugin.s.i;
import com.tencent.mm.plugin.s.j;
import com.tencent.mm.sdk.platformtools.x;

public final class b implements a {
    boolean HE = false;
    boolean fAs = false;
    boolean hkw = false;
    i oAj = new i(Looper.getMainLooper());
    int oAk;
    int oAl = 0;
    private int oAm = 0;
    a oAn;
    d oAo;
    com.tencent.mm.plugin.mmsight.segment.a.a.b oAp;
    c oAq;

    public b() {
        i iVar = this.oAj;
        if (iVar.opV != null) {
            j jVar = iVar.opV;
            if (jVar.opD != null) {
                jVar.opD.opx = false;
            }
        }
        this.oAj.gz(false);
        this.oAj.opW = new 1(this);
    }

    public final void setSurface(Surface surface) {
        this.oAj.setSurface(surface);
    }

    public final void setDataSource(String str) {
        this.oAj.setPath(str);
    }

    public final void prepareAsync() {
        this.oAj.aZJ();
    }

    public final void start() {
        if (this.HE) {
            this.oAj.start();
        }
        this.fAs = true;
    }

    public final void stop() {
        this.oAj.opV.stop();
        this.fAs = false;
    }

    public final void pause() {
        this.oAj.pause();
    }

    public final boolean isPlaying() {
        return this.oAj.isPlaying();
    }

    public final void seekTo(int i) {
        if (this.oAj != null) {
            x.i("MicroMsg.MMSegmentVideoPlayer", "seekTo: %s", new Object[]{Integer.valueOf(i)});
            this.oAj.sD(i);
        }
    }

    public final int getCurrentPosition() {
        return this.oAj.aZK();
    }

    public final int getDuration() {
        return (int) this.oAj.opV.aqA;
    }

    public final void release() {
        this.oAj.release();
    }

    public final void setAudioStreamType(int i) {
    }

    public final void setLooping(boolean z) {
        this.hkw = z;
    }

    public final void setLoop(int i, int i2) {
        this.oAl = i;
        this.oAm = i2;
    }

    public final void a(com.tencent.mm.plugin.mmsight.segment.a.a.b bVar) {
        this.oAp = bVar;
    }

    public final void a(c cVar) {
        this.oAq = cVar;
    }

    public final void a(d dVar) {
        this.oAo = dVar;
    }

    public final void a(a aVar) {
        this.oAn = aVar;
    }
}
