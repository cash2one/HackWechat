package com.tencent.mm.plugin.s;

import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.af.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class i {
    Looper opQ;
    af opR;
    HandlerThread opS;
    HandlerThread opT;
    HandlerThread opU;
    public j opV;
    public c opW;
    private a opX;

    public i(Looper looper) {
        this(looper, (byte) 0);
    }

    private i(Looper looper, byte b) {
        this.opX = new 1(this);
        this.opS = e.cZ("VideoPlayer:inner", -16);
        this.opS.start();
        this.opT = e.cZ("VideoPlayer:video", -16);
        this.opT.start();
        this.opU = e.cZ("VideoPlayer:audio", -16);
        this.opU.start();
        this.opQ = looper;
        this.opR = new af(this.opQ, this.opX);
        this.opV = new j(this.opR, this.opS.getLooper(), this.opT.getLooper(), this.opU != null ? this.opU.getLooper() : null, false);
    }

    public final void setPath(String str) {
        x.i("MicroMsg.VideoPlayer", "%s video player set path %s", new Object[]{asP(), str});
        j jVar = this.opV;
        x.i("MicroMsg.VideoPlayerImpl", "%s set path %s", new Object[]{jVar.opD.asP(), str});
        jVar.oqe.setPath(str);
        if (jVar.oqg != null) {
            jVar.oqg.setPath(str);
        }
    }

    public final void a(b bVar) {
        if (bVar != null && this.opV != null) {
            this.opV.oqe.opG = bVar;
        }
    }

    public final void gy(boolean z) {
        this.opV.oqe.oqn = z;
    }

    public final void gz(boolean z) {
        if (this.opV != null) {
            j jVar = this.opV;
            if (jVar.opD != null) {
                jVar.opD.opy = z;
            }
        }
    }

    public final void gA(boolean z) {
        if (this.opV != null) {
            j jVar = this.opV;
            if (jVar.opD != null) {
                x.i("MicroMsg.VideoPlayerImpl", "%s set is online video type [%b]", new Object[]{jVar.opD.asP(), Boolean.valueOf(z)});
                jVar.opD.opz = z;
            }
        }
    }

    public final void setSurface(Surface surface) {
        if (surface != null) {
            x.i("MicroMsg.VideoPlayerImpl", "%s set surface[%d] ", new Object[]{this.opV.opD.asP(), Integer.valueOf(surface.hashCode())});
            r0.oqe.aeI = surface;
        }
    }

    public final boolean aZJ() {
        j jVar = this.opV;
        x.i("MicroMsg.VideoPlayerImpl", "%s player start to prepare ", new Object[]{jVar.opD.asP()});
        jVar.opZ.obtainMessage(1).sendToTarget();
        if (jVar.oqg != null) {
            jVar.oqa.obtainMessage(1).sendToTarget();
        }
        return true;
    }

    public final void start() {
        x.d("MicroMsg.VideoPlayer", "%s start state[%d] stack %s", new Object[]{asP(), Integer.valueOf(this.opV.state), bh.cgy()});
        if (d.sz(this.opV.state) || d.sx(this.opV.state)) {
            x.w("MicroMsg.VideoPlayer", "%s it seek now, do not response start event.", new Object[]{asP()});
            return;
        }
        this.opV.start();
    }

    public final void pause() {
        x.d("MicroMsg.VideoPlayer", "%s pause state[%d] stack %s", new Object[]{asP(), Integer.valueOf(this.opV.state), bh.cgy()});
        if (d.sz(this.opV.state) || d.sx(this.opV.state)) {
            x.w("MicroMsg.VideoPlayer", "%s it seek now, do not response pause event.", new Object[]{asP()});
            return;
        }
        this.opV.pause();
    }

    public final void sD(int i) {
        this.opV.F(i, true);
    }

    public final void setMute(boolean z) {
        try {
            if (this.opV != null) {
                j jVar = this.opV;
                if (jVar.oqg != null) {
                    x.i("MicroMsg.VideoPlayerImpl", "%s play set mute[%b]", new Object[]{jVar.opD.asP(), Boolean.valueOf(z)});
                    jVar.oqg.setMute(z);
                }
            }
        } catch (Exception e) {
        }
    }

    public final void release() {
        try {
            this.opV.release();
        } catch (Exception e) {
        }
    }

    public final int aZK() {
        j jVar = this.opV;
        if (jVar.opD == null) {
            return 0;
        }
        int i = (int) (jVar.opD.opt / 1000);
        int i2 = (int) jVar.opD.ops;
        if (i2 != -1) {
            i = i2;
        }
        if (((long) i) < jVar.opD.opu / 1000) {
            i = (int) (jVar.opD.opu / 1000);
        }
        x.d("MicroMsg.VideoPlayerImpl", "%s get curr play ms %d time[%d %d]", new Object[]{jVar.opD.asP(), Integer.valueOf(i), Long.valueOf(jVar.opD.opt), Long.valueOf(jVar.opD.opu)});
        return i;
    }

    public final boolean isPlaying() {
        return d.sw(this.opV.state);
    }

    public final String asP() {
        return this.opV != null ? this.opV.opD.asP() : "has no player!";
    }
}
