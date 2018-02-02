package com.tencent.mm.plugin.facedetect.e;

import com.tencent.mm.plugin.facedetect.model.n;
import com.tencent.mm.plugin.mmsight.api.b;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public class a {
    private static volatile a mkQ = null;
    private static final String mlf = (n.aGP() + File.separator + "fdv_");
    public static final String mlg = (n.aGP() + File.separator + "video_temp_test.mp4");
    private static final String mlh = (n.aGP() + File.separator + "fdv_t_");
    private d iou;
    private String mFilePath;
    private final Object mLock;
    public com.tencent.mm.remoteservice.d mfB;
    public ag mkR;
    private final int mkS;
    private final int mkT;
    private final int mkU;
    private int mkV;
    private int mkW;
    private boolean mkX;
    private int mkY;
    public boolean mkZ;
    private b mla;
    public int mlb;
    public int mlc;
    private String mld;
    public b mle;
    private com.tencent.mm.plugin.mmsight.model.a.d.a mli;
    private com.tencent.mm.plugin.facedetect.model.d.b mlj;

    static /* synthetic */ void d(a aVar) {
        com.tencent.mm.loader.stub.b.deleteFile(aVar.mFilePath);
        com.tencent.mm.loader.stub.b.deleteFile(aVar.mld);
    }

    private a() {
        this.mLock = new Object();
        this.mkR = null;
        this.mkS = 960;
        this.mkT = 540;
        this.mkU = 15;
        this.mkV = a.mlz;
        this.mkW = 0;
        this.mkX = false;
        this.mkY = 0;
        this.mkZ = false;
        this.mla = null;
        this.mlb = -1;
        this.mlc = -1;
        this.mFilePath = "";
        this.mld = "";
        this.mfB = new com.tencent.mm.remoteservice.d(ac.getContext());
        this.mle = b.oqZ.XY();
        this.mli = new 5(this);
        this.mlj = new 6(this);
        this.mkR = new ag("face_video_handler");
    }

    public static a aHt() {
        if (mkQ != null) {
            return mkQ;
        }
        a aVar;
        synchronized (a.class) {
            if (mkQ == null) {
                mkQ = new a();
            }
            aVar = mkQ;
        }
        return aVar;
    }

    public final boolean isStarted() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mkV == a.mlB;
        }
        return z;
    }

    public final com.tencent.mm.e.b.c.a aHu() {
        if (this.iou != null) {
            return this.iou.baF();
        }
        x.w("MicroMsg.FaceVideoRecorder", "hy: no media recorder");
        return null;
    }

    public final void aHv() {
        this.mkR.F(new 3(this));
    }

    public final void a(b bVar) {
        this.mkR.F(new 4(this, bVar));
    }

    public final int aHw() {
        int i;
        synchronized (this.mLock) {
            i = this.mkV;
        }
        return i;
    }
}
