package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Point;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.mm.c.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;

public final class l implements d {
    String fqR = "";
    String fvC = null;
    boolean ioU = false;
    private String jiq = null;
    private String mFileName;
    VideoTransPara oqJ;
    boolean oth = false;
    c ouP;
    p ouQ;
    s ouR;
    a ouS = null;
    e ouT;
    String ouU = "";
    int ouV = 0;
    float ouW = 0.0f;
    private int ouX = 480;
    private int ouY = 640;
    int ouZ = 1600000;
    int ova = 480;
    int ovb = 640;
    int ovc = 0;
    String ovd = null;
    private HandlerThread ove = null;
    af ovf = null;
    int ovg = -1;
    int ovh = -1;
    private boolean ovi = false;
    boolean ovj = false;
    private boolean ovk = false;
    private int ovl = -1;
    boolean ovm = false;
    int ovn = 0;
    a ovo;
    boolean ovp = false;
    boolean ovq = true;
    private f ovr = new f(this) {
        final /* synthetic */ l ovs;

        {
            this.ovs = r1;
        }

        public final boolean R(byte[] bArr) {
            if (bArr == null || bArr.length <= 0) {
                return false;
            }
            if (this.ovs.ouR.owk != c.oua) {
                return false;
            }
            l lVar = this.ovs;
            if (!lVar.ovj && lVar.ovq) {
                lVar.ovj = true;
                Object obj = new byte[bArr.length];
                System.arraycopy(bArr, 0, obj, 0, bArr.length);
                e.post(new 6(lVar, obj), "BigSightMediaCodecMP4MuxRecorder_saveThumb");
            }
            if (this.ovs.ovf == null) {
                return true;
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = bArr;
            this.ovs.ovf.sendMessage(obtain);
            return true;
        }
    };

    public l(VideoTransPara videoTransPara) {
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
        this.ovk = false;
        x.d("MicroMsg.MMSightFFMpegRecorder", "create MMSightFFMpegRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s,  defaultRate: %s", new Object[]{Integer.valueOf(this.ouX), Integer.valueOf(this.ouY), Integer.valueOf(this.ouZ), Integer.valueOf(baL)});
    }

    public final void m(int i, int i2, int i3, int i4) {
        x.i("MicroMsg.MMSightFFMpegRecorder", "setSize, width: %s, height: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.ouX = i3;
        this.ouY = i4;
        this.ova = i;
        this.ovb = i2;
        if (j.ouM.h(Integer.valueOf(((i * i2) * 3) / 2)) == null) {
            x.i("MicroMsg.MMSightFFMpegRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(3)});
            long Wq = bh.Wq();
            for (int i5 = 0; i5 < 3; i5++) {
                j.ouM.D(new byte[(((i * i2) * 3) / 2)]);
            }
            x.i("MicroMsg.MMSightFFMpegRecorder", "preloadCameraData used %sms", new Object[]{Long.valueOf(bh.bA(Wq))});
        }
    }

    public final String aNV() {
        return this.fvC;
    }

    private boolean sO(int i) {
        if (this.ouS == null || this.ouS.ovA) {
            return false;
        }
        if (!this.ouS.ovx) {
            this.ouS.fqI = null;
            this.ouS.ovz = true;
            this.ouS.ovy = true;
            e.remove(this.ouS);
        }
        synchronized (this.ouS.ovB) {
            SightVideoJNI.releaseBigSightDataBuffer(i);
            if (this.ouS.ovt != i) {
                SightVideoJNI.releaseBigSightDataBuffer(this.ouS.ovt);
            }
        }
        return true;
    }

    private void clear() {
        boolean z;
        boolean z2 = false;
        int i = -1;
        if (this.ouQ != null) {
            i = this.ouQ.ovV;
            if (i < 0) {
                x.v("MicroMsg.MMSightFFMpegRecorder", "call clear, but bufID error");
                return;
            }
            this.ouQ.stop();
        }
        if (this.ouP != null) {
            this.ouP.a(null);
        }
        String str = "MicroMsg.MMSightFFMpegRecorder";
        String str2 = "ashutest::clear bufID %d, encodeRunnable null ? %B, markCancel %B";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        if (this.ouS == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        if (this.ouS != null) {
            z2 = this.ouS.ovz;
        }
        objArr[2] = Boolean.valueOf(z2);
        x.v(str, str2, objArr);
        if (i >= 0 && !sO(i)) {
            SightVideoJNI.releaseRecorderBufferRef("clear");
            SightVideoJNI.releaseBigSightDataBuffer(i);
        }
    }

    public final void cancel() {
        x.i("MicroMsg.MMSightFFMpegRecorder", "cancel");
        this.ouR.a(c.ouc);
        clear();
        this.ouR.a(c.oud);
    }

    public final void C(final Runnable runnable) {
        boolean z;
        boolean z2 = true;
        String str = "MicroMsg.MMSightFFMpegRecorder";
        String str2 = "stop, encodeThread null ? %B, has trigger finish ? %B, has finish callback ? %B";
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(this.ouS == null);
        if (this.ouS == null || !this.ouS.ovx) {
            z = false;
        } else {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        if (this.ouS == null || !this.ouS.ovy) {
            z2 = false;
        }
        objArr[2] = Boolean.valueOf(z2);
        x.i(str, str2, objArr);
        if (this.ouS == null || !this.ouS.ovx) {
            e.post(new Runnable(this) {
                final /* synthetic */ l ovs;

                public final void run() {
                    l lVar = this.ovs;
                    Runnable runnable = runnable;
                    lVar.ouR.a(c.ouc);
                    if (lVar.ouQ != null) {
                        int i = lVar.ouQ.ovV;
                        float baQ = (((float) lVar.ouQ.frameCount) * 1000.0f) / ((float) lVar.ouQ.baQ());
                        x.i("MicroMsg.MMSightFFMpegRecorder", "stop, bufID %d, frameCount %d, duration %dms, %.6ffps", new Object[]{Integer.valueOf(i), Integer.valueOf(lVar.ouQ.frameCount), Long.valueOf(lVar.ouQ.baQ()), Float.valueOf(baQ)});
                        lVar.ouV = (int) lVar.ouQ.baQ();
                        lVar.ouW = baQ;
                        lVar.ouQ.stop();
                        if (lVar.ouS != null) {
                            lVar.ouS.ovv = baQ;
                            lVar.ouS.duration = lVar.ouV;
                            lVar.ouS.fqI = runnable;
                            lVar.ouS.ovx = true;
                            e.remove(lVar.ouS);
                        }
                    }
                    if (!(lVar.ouP == null || lVar.ovp)) {
                        lVar.ouP.a(new 3(lVar));
                    }
                    lVar.ouR.a(c.oud);
                    lVar.fqR = g.bV(lVar.ouU);
                    if (lVar.ouS == null) {
                        x.e("MicroMsg.MMSightFFMpegRecorder", "encodeRunnable is null!, directly call stopcallback");
                        lVar.reset();
                        ag.y(runnable);
                    }
                    if (lVar.ovp) {
                        lVar.bau();
                    }
                }
            }, "MMSightFFMpegRecorder_stop");
            return;
        }
        synchronized (this.ouS.ovB) {
            reset();
            ag.y(runnable);
        }
    }

    final void bau() {
        if (this.ouS != null) {
            this.ouS.ovy = true;
        }
    }

    public final String Nr() {
        return bh.az(this.fqR, "");
    }

    public final c baz() {
        return this.ouR.owk;
    }

    public final long bax() {
        return this.ouQ.baQ();
    }

    public final f bay() {
        return this.ovr;
    }

    public final String getFilePath() {
        return this.ouU;
    }

    public final String getFileName() {
        return this.mFileName;
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

    public final void reset() {
        x.i("MicroMsg.MMSightFFMpegRecorder", "reset");
        this.ouR.owk = c.oud;
        this.ovm = false;
        if (this.ouP != null) {
            this.ouP.clear();
        }
        if (this.ouQ != null) {
            p pVar = this.ouQ;
            SightVideoJNI.releaseBigSightDataBuffer(pVar.ovV);
            pVar.ovV = -1;
            synchronized (p.class) {
                pVar.frameCount = 0;
            }
            pVar.kEb = 0;
        }
        clear();
    }

    private boolean sP(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        long Wq = bh.Wq();
        this.oth = j.osX.oth;
        this.ovc = i;
        if (this.oth) {
            i2 = (i == 0 || i == 180) ? this.ova : this.ovb;
            i3 = (i == 0 || i == 180) ? this.ovb : this.ova;
            i4 = (i == 0 || i == 180) ? this.ouX : this.ouY;
            if (i == 0 || i == 180) {
                i5 = this.ouY;
            } else {
                i5 = this.ouX;
            }
        } else {
            i3 = (i == 0 || i == 180) ? this.ova : this.ovb;
            i2 = (i == 0 || i == 180) ? this.ovb : this.ova;
            i4 = this.ouX;
            i5 = this.ouY;
            int i6 = i2;
            i2 = i3;
            i3 = i6;
        }
        int initDataBufferForMMSight = SightVideoJNI.initDataBufferForMMSight(i2, i3, i, i4, i5, (float) this.oqJ.fps, this.ouZ, this.oqJ.huf, 8, this.oqJ.hue, 23.0f, this.oth, true, this.oqJ.duration, false);
        if (initDataBufferForMMSight < 0) {
            x.e("MicroMsg.MMSightFFMpegRecorder", "init failed!");
            k.bag();
            return false;
        }
        this.ovl = initDataBufferForMMSight;
        this.ouQ = new p(this.oth, i, i4, i5);
        i4 = this.ouQ.sQ(initDataBufferForMMSight);
        i2 = 0;
        i3 = -1;
        if (CaptureMMProxy.getInstance() != null) {
            i3 = CaptureMMProxy.getInstance().getInt(w.a.xsR, -1);
        }
        if (i3 < 0) {
            this.ouP = new g(this.oqJ.audioSampleRate, this.oqJ.huc);
            this.ouP.gC(this.ovp);
            i2 = this.ouP.ar(initDataBufferForMMSight, d.Jq(this.ouU));
            if (i4 < 0 || i2 < 0) {
                x.e("MicroMsg.MMSightFFMpegRecorder", "init yuv or aac recorder error!! %d %d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i2)});
                if (i2 < 0 && i4 >= 0) {
                    x.w("MicroMsg.MMSightFFMpegRecorder", "aac init error, try mediarecorder now");
                    this.ouP.clear();
                    this.ouP = new i(this.oqJ.audioSampleRate, this.oqJ.huc);
                    this.ouP.gC(this.ovp);
                    x.w("MicroMsg.MMSightFFMpegRecorder", "MMSightAACMediaRecorder init ret: %s", new Object[]{Integer.valueOf(this.ouP.ar(initDataBufferForMMSight, d.Jq(this.ouU)))});
                    if (this.ouP.ar(initDataBufferForMMSight, d.Jq(this.ouU)) >= 0) {
                        return true;
                    }
                }
                SightVideoJNI.releaseBigSightDataBuffer(initDataBufferForMMSight);
                k.bag();
                return false;
            }
        }
        if (i3 == 1) {
            this.ouP = new g(this.oqJ.audioSampleRate, this.oqJ.huc);
            this.ouP.gC(this.ovp);
            i2 = this.ouP.ar(initDataBufferForMMSight, d.Jq(this.ouU));
        } else if (i3 == 2) {
            this.ouP = new i(this.oqJ.audioSampleRate, this.oqJ.huc);
            this.ouP.gC(this.ovp);
            i2 = this.ouP.ar(initDataBufferForMMSight, d.Jq(this.ouU));
        }
        if (i4 < 0 || i2 < 0) {
            x.e("MicroMsg.MMSightFFMpegRecorder", "init yuv or aac recorder error!! %d %d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i2)});
            SightVideoJNI.releaseBigSightDataBuffer(initDataBufferForMMSight);
            k.bag();
            return false;
        }
        x.i("MicroMsg.MMSightFFMpegRecorder", "initImpl used %sms", new Object[]{Long.valueOf(bh.bA(Wq))});
        return true;
    }

    public final boolean sN(int i) {
        if (this.ovk) {
            return true;
        }
        x.i("MicroMsg.MMSightFFMpegRecorder", "preInit, cameraOrientation: %s", new Object[]{Integer.valueOf(i)});
        boolean sP = sP(i);
        this.ovk = true;
        x.i("MicroMsg.MMSightFFMpegRecorder", "initImpl result: %s", new Object[]{Boolean.valueOf(sP)});
        return sP;
    }

    public final int c(int i, boolean z, int i2) {
        x.i("MicroMsg.MMSightFFMpegRecorder", "request start, last status %s, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[]{this.ouR.owk, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)});
        this.ioU = z;
        this.ouV = 0;
        this.ovn = i2;
        this.ouR.a(c.otZ);
        String str = "MicroMsg.MMSightFFMpegRecorder";
        String str2 = "initialize: filePath[%s], encodeThread null[%B], encodeThreadFinish[%B]";
        Object[] objArr = new Object[3];
        objArr[0] = this.ouU;
        objArr[1] = Boolean.valueOf(this.ouS == null);
        objArr[2] = Boolean.valueOf(this.ouS == null ? true : this.ouS.ovA);
        x.i(str, str2, objArr);
        if (this.ouS != null && !this.ouS.ovA) {
            x.w("MicroMsg.MMSightFFMpegRecorder", "ERROR, status, wait last encode thread finish!!! MUST NOT BE HERE");
            return -1;
        } else if (bh.ov(this.ouU)) {
            x.e("MicroMsg.MMSightFFMpegRecorder", "start error, mCurRecordPath is null!!");
            return -1;
        } else {
            int i3;
            this.mFileName = com.tencent.mm.a.e.bR(this.ouU);
            x.i("MicroMsg.MMSightFFMpegRecorder", "mCurRecordPath: %s", new Object[]{this.ouU});
            this.ovc = i;
            x.i("MicroMsg.MMSightFFMpegRecorder", "start, cameraOrientation: %s", new Object[]{Integer.valueOf(this.ovc)});
            if (!this.ovk) {
                sP(i);
                this.ovk = true;
            }
            p pVar = this.ouQ;
            if (0 == pVar.kEb) {
                pVar.kEb = System.currentTimeMillis();
            }
            if (this.ovp) {
                i3 = 0;
            } else {
                i3 = this.ouP.a(new 4(this));
            }
            x.i("MicroMsg.MMSightFFMpegRecorder", "start aac recorder ret: %d", new Object[]{Integer.valueOf(i3)});
            this.ove = e.cZ("BigSightWriteCameraData", 0);
            this.ove.start();
            this.ovf = new 5(this, this.ove.getLooper());
            this.ovm = false;
            if (i3 != 0) {
                this.ouR.a(c.oug);
            } else {
                this.ouR.a(c.ouh);
            }
            k.baf();
            x.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegCapture");
            com.tencent.mm.plugin.report.service.g.pQN.a(440, 1, 1, false);
            if (!this.ovp) {
                return i3;
            }
            bat();
            return i3;
        }
    }

    final void bat() {
        x.i("MicroMsg.MMSightFFMpegRecorder", "ashutest::pcm ready");
        if (!(this.ouS == null || this.ouS.ovA)) {
            x.e("MicroMsg.MMSightFFMpegRecorder", "ashutest::OnPcmReady, last encode thread[%s] status error!!! MUST NOT BE HERE", new Object[]{this.ouS});
            synchronized (this.ouS.ovB) {
                sO(this.ouS.ovt);
            }
        }
        if (this.ouR.owk != c.ouh) {
            x.w("MicroMsg.MMSightFFMpegRecorder", "ashutest::not MediaStatus.Initialized, maybe canceled by user");
            return;
        }
        this.ouR.a(c.oua);
        this.ouS = new a(this);
        this.ouS.ovt = this.ovl;
        e.b(this.ouS, "SightCustomAsyncMediaRecorder_encode_" + bh.Wq(), 5);
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
        x.i("MicroMsg.MMSightFFMpegRecorder", "pause");
        if (this.ouR != null && this.ouR.owk == c.oua) {
            this.ouR.a(c.oui);
        }
    }

    public final void P(int i, int i2, int i3) {
        x.i("MicroMsg.MMSightFFMpegRecorder", "resume, cameraOrientation: %s", new Object[]{Integer.valueOf(i)});
        if (this.ouR != null && this.ouR.owk == c.oui) {
            if (this.ouQ != null) {
                p pVar = this.ouQ;
                x.i("MicroMsg.MMSightX264YUVRecorder", "resume, newRotate: %s, frameWidth: %s, frameHeight: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                pVar.ovX = i;
                pVar.ovY = i2;
                pVar.ovZ = i3;
            }
            this.ouR.a(c.oua);
        }
    }

    public final boolean baD() {
        return this.ovm;
    }

    public final void a(a aVar) {
        this.ovo = aVar;
    }

    public final boolean aZW() {
        return this.ioU;
    }

    public final void baE() {
        this.ovp = true;
    }

    public final com.tencent.mm.e.b.c.a baF() {
        return this.ouP != null ? this.ouP.bas() : null;
    }

    public final void baG() {
        this.ovq = false;
    }

    public final float baw() {
        return this.ouW;
    }
}
