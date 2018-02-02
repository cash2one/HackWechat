package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Point;
import android.os.HandlerThread;
import com.tencent.mm.a.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.b;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;

public final class n implements d {
    private String fqR = "";
    String fvC = null;
    boolean ioU = false;
    private String jiq = null;
    private String mFileName;
    VideoTransPara oqJ;
    private Point osc = null;
    private boolean oth = false;
    s ouR;
    private String ouU = "";
    private int ouV = 0;
    private float ouW = 0.0f;
    private int ouX = 480;
    private int ouY = 640;
    private int ouZ = 1600000;
    int ouk;
    c ovF;
    q ovG;
    private m ovH;
    private HandlerThread ovI;
    af ovJ;
    private int ovK = 0;
    b ovL = new b("yuvRecorderWriteData");
    b ovM = new b("frameCountCallback");
    Runnable ovN = null;
    private boolean ovO = false;
    int ova = 480;
    int ovb = 640;
    int ovc;
    private String ovd = null;
    private boolean ovi = false;
    boolean ovj = false;
    private boolean ovk = false;
    boolean ovm = false;
    int ovn = 0;
    d$a ovo;
    boolean ovq = true;
    private f ovr = new 1(this);

    public n(VideoTransPara videoTransPara) {
        this.oqJ = videoTransPara;
        this.ouX = videoTransPara.width;
        this.ouY = videoTransPara.height;
        this.ouZ = videoTransPara.videoBitrate;
        k.baK();
        int baL = k.baL();
        if (baL == -1) {
            this.ouZ = videoTransPara.videoBitrate;
        } else {
            this.ouZ = baL;
        }
        this.ouR = new s();
        x.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "create MMSightMediaCodecMP4MuxRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s", new Object[]{Integer.valueOf(this.ouX), Integer.valueOf(this.ouY), Integer.valueOf(this.ouZ)});
    }

    private boolean sP(int i) {
        long Wq = bh.Wq();
        this.oth = j.osX.oth;
        int i2 = this.ouZ;
        this.ouk = SightVideoJNI.initDataBufferForMMSight(this.ova, this.ovb, i, this.ouX, this.ouY, (float) this.oqJ.fps, i2, this.oqJ.huf, 8, this.oqJ.hue, 23.0f, false, false, this.oqJ.duration, false);
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init, bufId: %s", new Object[]{Integer.valueOf(this.ouk)});
        if (this.ouk < 0) {
            x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init failed!");
            k.bah();
            return false;
        }
        this.ovc = i;
        this.ovG = new q(this.ova, this.ovb, this.ouX, this.ouY, this.ouZ, this.oqJ.hud, this.oqJ.fps, this.oth);
        int cN = this.ovG.cN(this.ouk, i);
        int i3 = 0;
        int i4 = -1;
        if (CaptureMMProxy.getInstance() != null) {
            i4 = CaptureMMProxy.getInstance().getInt(a.xsR, -1);
        }
        if (i4 < 0) {
            this.ovF = new g(this.oqJ.audioSampleRate, this.oqJ.huc);
            this.ovF.gC(this.ovO);
            i3 = this.ovF.ar(this.ouk, d.Jq(this.ouU));
            if (cN < 0 || i3 < 0) {
                x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", new Object[]{Integer.valueOf(cN), Integer.valueOf(i3)});
                if (i3 < 0 && cN >= 0) {
                    x.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac init error, try mediarecorder now");
                    this.ovF.clear();
                    this.ovF = new i(this.oqJ.audioSampleRate, this.oqJ.huc);
                    this.ovF.gC(this.ovO);
                    x.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "MMSightAACMediaRecorder init ret: %s", new Object[]{Integer.valueOf(this.ovF.ar(this.ouk, d.Jq(this.ouU)))});
                    if (this.ovF.ar(this.ouk, d.Jq(this.ouU)) >= 0) {
                        return true;
                    }
                }
                SightVideoJNI.releaseBigSightDataBuffer(this.ouk);
                k.bah();
                return false;
            }
        }
        if (i4 == 1) {
            this.ovF = new g(this.oqJ.audioSampleRate, this.oqJ.huc);
            this.ovF.gC(this.ovO);
            i3 = this.ovF.ar(this.ouk, d.Jq(this.ouU));
        } else if (i4 == 2) {
            this.ovF = new i(this.oqJ.audioSampleRate, this.oqJ.huc);
            this.ovF.gC(this.ovO);
            i3 = this.ovF.ar(this.ouk, d.Jq(this.ouU));
        }
        if (cN < 0 || i3 < 0) {
            x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", new Object[]{Integer.valueOf(cN), Integer.valueOf(i3)});
            SightVideoJNI.releaseBigSightDataBuffer(this.ouk);
            k.bah();
            return false;
        }
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "initImpl used %sms", new Object[]{Long.valueOf(bh.bA(Wq))});
        return true;
    }

    public final boolean sN(int i) {
        if (this.ovk) {
            return true;
        }
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preInit, cameraOrientation");
        boolean sP = sP(i);
        this.ovk = true;
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "initImpl result: %s", new Object[]{Boolean.valueOf(sP)});
        return sP;
    }

    public final int c(int i, boolean z, int i2) {
        int i3 = -1;
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)});
        this.ovL.reset();
        this.ouV = 0;
        this.ovM.reset();
        this.ovj = false;
        this.ioU = z;
        this.ovn = i2;
        this.ouR.a(c.otZ);
        if (bh.ov(this.ouU)) {
            x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start error, mCurRecordPath is null!!");
        } else {
            try {
                this.mFileName = e.bR(this.ouU);
                String mg = FileOp.mg(this.ouU);
                if (!mg.endsWith("/")) {
                    mg = mg + "/";
                }
                this.ovd = mg + "tempRotate.mp4";
            } catch (Exception e) {
                x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "retrieve file name error: %s", new Object[]{e.getMessage()});
            }
            x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mCurRecordPath: %s, tempRotateFilePath: %s", new Object[]{this.ouU, this.ovd});
            this.ovc = i;
            this.ovI = com.tencent.mm.sdk.f.e.cZ("BigSightMediaCodecMP4MuxRecorder_writeYuvData_" + hashCode(), -1);
            this.ovI.start();
            this.ovJ = new 2(this, this.ovI.getLooper());
            if (!this.ovk) {
                sP(i);
                this.ovk = true;
            }
            i3 = this.ovF.a(new 3(this));
            x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start aacRecorder ret: %s", new Object[]{Integer.valueOf(i3)});
            this.ovm = false;
            if (i3 != 0) {
                this.ouR.a(c.oug);
            } else {
                this.ouR.a(c.ouh);
            }
            k.baf();
            x.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecCapture");
            g.pQN.a(440, 2, 1, false);
        }
        return i3;
    }

    public final void C(Runnable runnable) {
        this.ovN = runnable;
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "!!!!!stop, stopCallback: %s!!!", new Object[]{runnable});
        if (this.ovG == null || this.ovF == null) {
            x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
            if (runnable != null) {
                ag.y(runnable);
            }
        } else if (this.ouR == null || this.ouR.owk != c.oud) {
            this.ovr = null;
            this.ouV = (int) this.ovG.baQ();
            if (this.ouR != null) {
                this.ouR.a(c.oub);
            }
            this.ovG.a(new 4(this));
            this.ovF.a(new 5(this));
        } else {
            x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, already in stop status");
            if (this.ovF != null) {
                this.ovF.clear();
            }
            if (this.ovG != null) {
                this.ovG.clear();
            }
            if (runnable != null) {
                ag.y(runnable);
            }
        }
    }

    final boolean baP() {
        long Wq = bh.Wq();
        if (!(this.ovI == null || this.ovJ == null)) {
            if (com.tencent.mm.compatible.util.d.fM(18)) {
                this.ovI.quitSafely();
            } else {
                this.ovI.quit();
            }
            this.ovJ = null;
        }
        this.ouW = (((float) this.ovG.frameCount) * 1000.0f) / ((float) this.ouV);
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, frameCount: %s, fps: %s, duration: %s, file: %s handlerrunning %s", new Object[]{Integer.valueOf(r2), Float.valueOf(this.ouW), Integer.valueOf(this.ouV), this.ouU, Long.valueOf(bh.bA(Wq))});
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "frameCountCallback %s", new Object[]{this.ovM.getValue()});
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "yuvRecorderWriteDataCallback %s", new Object[]{this.ovL.getValue()});
        this.ovH = new m(this.ouk, this.ouU, this.ouW, this.ouZ, this.ouV, this.oqJ.audioSampleRate);
        Wq = bh.Wq();
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux used %sms, success: %s", new Object[]{Long.valueOf(bh.bA(Wq)), Boolean.valueOf(this.ovH.baH())});
        if (this.ovH.baH()) {
            if ((this.ioU && this.oth) || (!(this.oth || this.ioU) || ((this.ioU && Math.abs(this.ovc - this.ovn) == 0) || this.ovn == 180))) {
                long Wq2 = bh.Wq();
                int i = (this.oth || this.ioU) ? this.oth ? this.ovn : 180 : this.ovc;
                if (this.ovn == 180 && !this.oth) {
                    i += 180;
                    if (i > 360) {
                        i -= 360;
                    }
                }
                SightVideoJNI.tagRotateVideo(this.ouU, this.ovd, i);
                this.ovi = true;
                x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[]{Long.valueOf(bh.bA(Wq2)), Integer.valueOf(this.ovc), Boolean.valueOf(this.ioU), Integer.valueOf(this.ovn), Integer.valueOf(i)});
                Wq = bh.Wq();
                try {
                    FileOp.deleteFile(this.ouU);
                    FileOp.at(this.ovd, this.ouU);
                    x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "copyFile cost %s", new Object[]{Long.valueOf(bh.bA(Wq))});
                    com.tencent.mm.sdk.f.e.post(new 7(this, this.ovd), "BigSightMediaCodecMP4MuxRecorder_tagRotate_after_process");
                } catch (Exception e) {
                    x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, copy file error");
                    return false;
                }
            }
            SightVideoJNI.releaseBigSightDataBuffer(this.ouk);
            this.ouR.a(c.oud);
            this.fqR = com.tencent.mm.c.g.bV(this.ovd);
            return true;
        }
        x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux failed!");
        x.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecMuxError");
        g.pQN.a(440, 31, 1, false);
        return false;
    }

    public final String Nr() {
        return bh.az(this.fqR, "");
    }

    public final void cancel() {
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "cancel record");
        if (this.ovG == null || this.ovF == null) {
            x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
            return;
        }
        this.ouR.a(c.ouc);
        this.ovG.a(null);
        this.ovF.a(new 8(this));
        if (!(this.ovI == null || this.ovJ == null)) {
            this.ovJ.removeMessages(0);
            this.ovI.quit();
            this.ovJ = null;
        }
        SightVideoJNI.releaseBigSightDataBuffer(this.ouk);
        this.ouR.a(c.oud);
        reset();
    }

    public final void setFilePath(String str) {
        this.ouU = str;
    }

    public final void Fi(String str) {
        this.fvC = str;
    }

    public final void Fj(String str) {
        this.jiq = str;
    }

    public final String bav() {
        return this.jiq;
    }

    public final String getFilePath() {
        return this.ouU;
    }

    public final String getFileName() {
        return this.mFileName;
    }

    public final float baw() {
        return this.ouW;
    }

    public final void reset() {
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s, muxer: %s", new Object[]{this.ovG, this.ovF, this.ovH});
        this.ovG = null;
        this.ovF = null;
        this.ovH = null;
        this.ovk = false;
        this.ovm = false;
    }

    public final long bax() {
        if (this.ovG != null) {
            return this.ovG.baQ();
        }
        return 0;
    }

    public final f bay() {
        return this.ovr;
    }

    public final void m(int i, int i2, int i3, int i4) {
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, after align, targetWidth: %d, targetHeight: %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)});
        this.ouX = i3;
        this.ouY = i4;
        this.ova = i;
        this.ovb = i2;
        if (j.ouM.h(Integer.valueOf(((i * i2) * 3) / 2)) == null) {
            x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(3)});
            long Wq = bh.Wq();
            for (int i5 = 0; i5 < 3; i5++) {
                j.ouM.D(new byte[(((i * i2) * 3) / 2)]);
            }
            x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preloadCameraData used %sms", new Object[]{Long.valueOf(bh.bA(Wq))});
        }
    }

    public final String aNV() {
        return this.fvC;
    }

    public final c baz() {
        return this.ouR.owk;
    }

    public final int baA() {
        return Math.round(((float) this.ouV) / 1000.0f);
    }

    public final Point baB() {
        return new Point(this.ova, this.ovb);
    }

    public final int baC() {
        return this.ovc;
    }

    public final void pause() {
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "pause");
        if (this.ouR != null && this.ouR.owk == c.oua) {
            this.ouR.a(c.oui);
        }
    }

    public final void P(int i, int i2, int i3) {
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "resume, cameraOrientation: %s", new Object[]{Integer.valueOf(i)});
        if (this.ouR != null && this.ouR.owk == c.oui) {
            if (this.ovG != null) {
                r rVar = this.ovG;
                rVar.ovX = i;
                rVar.ovY = i2;
                rVar.ovZ = i3;
                x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "resume, newRotation: %s, newFrameWidth: %s, newFrameHeight: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
            this.ouR.a(c.oua);
        }
    }

    public final boolean baD() {
        return this.ovm;
    }

    public final void a(d$a com_tencent_mm_plugin_mmsight_model_a_d_a) {
        this.ovo = com_tencent_mm_plugin_mmsight_model_a_d_a;
    }

    public final boolean aZW() {
        return this.ioU;
    }

    public final void baE() {
        this.ovO = true;
    }

    public final com.tencent.mm.e.b.c.a baF() {
        return this.ovF != null ? this.ovF.bas() : null;
    }

    public final void baG() {
        this.ovq = false;
    }
}
