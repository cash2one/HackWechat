package com.google.android.exoplayer2;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import com.google.android.exoplayer2.a.b;
import com.google.android.exoplayer2.a.e;
import com.google.android.exoplayer2.b.d;
import com.google.android.exoplayer2.f.c;
import com.google.android.exoplayer2.f.j$a;
import com.google.android.exoplayer2.g.g;
import com.google.android.exoplayer2.metadata.e.a;
import com.google.android.exoplayer2.source.f;
import java.util.concurrent.CopyOnWriteArraySet;

@TargetApi(16)
public final class v implements f {
    protected final r[] acF;
    private final f adh;
    private final a aeA = new a(this, (byte) 0);
    final CopyOnWriteArraySet<Object> aeB = new CopyOnWriteArraySet();
    final CopyOnWriteArraySet<j$a> aeC = new CopyOnWriteArraySet();
    public final CopyOnWriteArraySet<a> aeD = new CopyOnWriteArraySet();
    private final int aeE;
    private final int aeF;
    Format aeG;
    Format aeH;
    Surface aeI;
    private boolean aeJ;
    private int aeK;
    private SurfaceHolder aeL;
    private TextureView aeM;
    public e aeN;
    com.google.android.exoplayer2.video.e aeO;
    d aeP;
    d aeQ;
    int aeR;
    private b aeS;
    private float aeT;

    static /* synthetic */ void a(v vVar, Surface surface, boolean z) {
        c[] cVarArr = new c[vVar.aeE];
        r[] rVarArr = vVar.acF;
        int length = rVarArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3;
            f.b bVar = rVarArr[i];
            if (bVar.getTrackType() == 2) {
                i3 = i2 + 1;
                cVarArr[i2] = new c(bVar, surface);
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        if (vVar.aeI == null || vVar.aeI == surface) {
            vVar.adh.a(cVarArr);
        } else {
            vVar.adh.b(cVarArr);
            if (vVar.aeJ) {
                vVar.aeI.release();
            }
        }
        vVar.aeI = surface;
        vVar.aeJ = z;
    }

    protected v(u uVar, g gVar, m mVar) {
        this.acF = uVar.a(new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()), this.aeA, this.aeA, this.aeA, this.aeA);
        int i = 0;
        int i2 = 0;
        for (r trackType : this.acF) {
            switch (trackType.getTrackType()) {
                case 1:
                    i++;
                    break;
                case 2:
                    i2++;
                    break;
                default:
                    break;
            }
        }
        this.aeE = i2;
        this.aeF = i;
        this.aeT = 1.0f;
        this.aeR = 0;
        this.aeS = b.aft;
        this.aeK = 1;
        this.adh = new h(this.acF, gVar, mVar);
    }

    public final void a(q.a aVar) {
        this.adh.a(aVar);
    }

    public final void b(q.a aVar) {
        this.adh.b(aVar);
    }

    public final int ia() {
        return this.adh.ia();
    }

    public final void a(f fVar) {
        this.adh.a(fVar);
    }

    public final void ad(boolean z) {
        this.adh.ad(z);
    }

    public final boolean ib() {
        return this.adh.ib();
    }

    public final boolean ic() {
        return this.adh.ic();
    }

    public final void seekTo(long j) {
        this.adh.seekTo(j);
    }

    public final void stop() {
        this.adh.stop();
    }

    public final void release() {
        this.adh.release();
        if (this.aeM != null) {
            if (this.aeM.getSurfaceTextureListener() == this.aeA) {
                this.aeM.setSurfaceTextureListener(null);
            }
            this.aeM = null;
        }
        if (this.aeL != null) {
            this.aeL.removeCallback(this.aeA);
            this.aeL = null;
        }
        if (this.aeI != null) {
            if (this.aeJ) {
                this.aeI.release();
            }
            this.aeI = null;
        }
    }

    public final void a(c... cVarArr) {
        this.adh.a(cVarArr);
    }

    public final void b(c... cVarArr) {
        this.adh.b(cVarArr);
    }

    public final long getDuration() {
        return this.adh.getDuration();
    }

    public final long getCurrentPosition() {
        return this.adh.getCurrentPosition();
    }

    public final long getBufferedPosition() {
        return this.adh.getBufferedPosition();
    }

    public final int getBufferedPercentage() {
        return this.adh.getBufferedPercentage();
    }
}
