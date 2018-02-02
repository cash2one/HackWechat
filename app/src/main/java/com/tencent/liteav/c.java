package com.tencent.liteav;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.liteav.a.b;
import com.tencent.liteav.audio.TXCLiveBGMPlayer;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.e;
import com.tencent.liteav.audio.f;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.a;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import com.tencent.liteav.videoencoder.d;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.rtmp.TXLog;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLContext;

public class c extends a implements b, e, com.tencent.liteav.basic.c.a, com.tencent.liteav.beauty.e, k, d {
    private static final String d = c.class.getSimpleName();
    a a;
    f b = null;
    OnBGMNotify c = null;
    private j e = null;
    private com.tencent.liteav.beauty.c f = null;
    private int g = -1;
    private TXSVideoEncoderParam h = null;
    private com.tencent.liteav.videoencoder.b i = null;
    private Context j = null;
    private f k = null;
    private int l = 0;
    private int m = 0;
    private int n = 0;
    private float o = 1.0f;
    private int p = 0;
    private long q = 0;
    private a r = null;
    private WeakReference<com.tencent.liteav.basic.c.a> s;
    private WeakReference<l> t;
    private boolean u = false;

    public c(Context context) {
        this.j = context.getApplicationContext();
        this.k = new f();
        this.f = new com.tencent.liteav.beauty.c(this.j, true);
        this.f.a(this);
        this.h = new TXSVideoEncoderParam();
        this.i = null;
        this.a = new a(this);
        com.tencent.liteav.basic.e.b.a().a(this.j);
    }

    public void a(a aVar) {
        this.r = aVar;
    }

    public void a(f fVar) {
        Object obj = null;
        int i = this.k.k;
        Object obj2 = (fVar == null || (this.k.t == fVar.t && this.k.u == fVar.u && this.k.v == fVar.v)) ? null : 1;
        if (!(fVar == null || (this.k.x == fVar.x && this.k.y == fVar.y && this.k.z == fVar.z && this.k.C == fVar.C && this.k.A == fVar.A && this.k.B == fVar.B))) {
            obj = 1;
        }
        if (fVar != null) {
            try {
                this.k = (f) fVar.clone();
            } catch (CloneNotSupportedException e) {
                this.k = new f();
            }
        } else {
            this.k = new f();
        }
        l(i);
        if (i()) {
            t();
            w();
            if (this.e != null) {
                this.e.c(this.k.l);
            }
            if (obj2 != null) {
                u();
            }
            if (obj != null) {
                v();
            }
        }
    }

    public void a(com.tencent.liteav.basic.c.a aVar) {
        this.s = new WeakReference(aVar);
    }

    public void a(byte[] bArr) {
        com.tencent.liteav.audio.c.a().a(bArr);
    }

    public void a(l lVar) {
        this.t = new WeakReference(lVar);
    }

    public int b() {
        return this.h.width;
    }

    public int c() {
        return this.h.height;
    }

    public void setID(String str) {
        super.setID(str);
        if (this.i != null) {
            this.i.setID(str);
        }
    }

    public String d() {
        int i = 0;
        StringBuilder append = new StringBuilder().append(com.tencent.liteav.audio.c.a().f()).append(" | ").append(this.k != null ? this.k.q : 0).append(",");
        if (this.k != null) {
            i = this.k.r;
        }
        return append.append(i).toString();
    }

    public int e() {
        if (i()) {
            TXCLog.w(d, "ignore startPush when pushing, status:" + this.m);
            return -2;
        }
        TXCDRApi.initCrashReport(this.j);
        this.m = 1;
        TXCLog.d(d, "startPusher");
        t();
        com.tencent.liteav.audio.c.a().a(this);
        if ((this.k != null && this.k.E) || this.l == 1 || this.e == null || this.e.c()) {
            com.tencent.liteav.audio.c.a().a(this.j);
        } else if (this.e != null) {
            this.e.e(true);
        }
        w();
        TXCDRApi.txReportDAU(this.j, com.tencent.liteav.basic.datareport.a.aI);
        return 0;
    }

    public void f() {
        if (i()) {
            TXCLog.d(d, "stopPusher");
            this.m = 0;
            com.tencent.liteav.audio.c.a().b();
            com.tencent.liteav.audio.c.a().a(null);
            r();
            this.k.H = false;
            return;
        }
        TXCLog.w(d, "ignore stopPush when not pushing, status:" + this.m);
    }

    public void g() {
        if (this.m != 1) {
            TXCLog.w(d, "ignore pause push when is not pushing, status:" + this.m);
            return;
        }
        this.m = 2;
        TXCLog.d(d, "pausePusher");
        if ((this.k.w & 1) == 1) {
            if (!(this.a == null || this.k.E || this.e == null)) {
                this.a.a(this.k.v, this.k.u);
            }
            if (this.e != null) {
                this.e.b();
            }
            r();
        }
        if ((this.k.w & 2) == 2) {
            com.tencent.liteav.audio.c.a().c(true);
        }
    }

    public void h() {
        if (this.m != 2) {
            TXCLog.w(d, "ignore resume push when is not pause, status:" + this.m);
            return;
        }
        this.m = 1;
        TXCLog.d(d, "resumePusher");
        if ((this.k.w & 1) == 1) {
            if (!(this.a == null || this.k.E)) {
                this.a.a();
            }
            if (this.e != null) {
                this.e.a();
            }
        }
        if ((this.k.w & 2) == 2) {
            com.tencent.liteav.audio.c.a().c(this.u);
            if ((this.k.I & 1) == 0) {
                com.tencent.liteav.audio.c.a().b();
                com.tencent.liteav.audio.c.a().b(this.k.q);
                com.tencent.liteav.audio.c.a().a(this.k.s, this.j);
                com.tencent.liteav.audio.c.a().d(this.p);
                com.tencent.liteav.audio.c.a().a(this.o);
                com.tencent.liteav.audio.c.a().c(this.u);
                com.tencent.liteav.audio.c.a().a(this);
                com.tencent.liteav.audio.c.a().a(this.j);
            }
        }
    }

    public void a(int i, int i2, int i3) {
        if (this.e != null) {
            this.e.a(new 1(this, i2, i3, i));
        }
    }

    public boolean i() {
        return this.m != 0;
    }

    public void j() {
        if (this.e != null) {
            this.e.a(new 4(this));
        }
    }

    public void a(TXCloudVideoView tXCloudVideoView) {
        if (this.k.E) {
            TXCLog.e(d, "enable pure audio push , so can not start preview!");
            return;
        }
        if (tXCloudVideoView.getGLSurfaceView() == null) {
            tXCloudVideoView.addVideoView(new com.tencent.liteav.renderer.d(tXCloudVideoView.getContext()));
        }
        this.l = 0;
        this.e = new b(this.j, this.k, tXCloudVideoView);
        this.e.a(this);
        this.e.a(this);
        this.e.a();
        this.e.b(this.n);
    }

    public void a(boolean z) {
        if (this.e != null) {
            this.e.a(null);
            this.e.a(z);
            this.e.a(new 5(this));
            this.e = null;
            r();
        }
    }

    public void k() {
        if (VERSION.SDK_INT < 21) {
            Bundle bundle = new Bundle();
            bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "录屏失败,不支持的Android系统版本,需要5.0以上的系统");
            onNotifyEvent(TXLiveConstants.PUSH_ERR_SCREEN_CAPTURE_UNSURPORT, bundle);
            TXLog.e(d, "Screen capture need running on Android Lollipop or higher version, current:" + VERSION.SDK_INT);
            return;
        }
        this.l = 1;
        this.e = new i(this.j, this.k);
        this.e.a(this);
        this.e.a(this);
        this.e.a();
        TXCDRApi.txReportDAU(this.j, com.tencent.liteav.basic.datareport.a.aF);
    }

    public void l() {
        if (this.e != null) {
            r();
            this.e.a(false);
            this.e = null;
        }
    }

    public void a(int i) {
        this.n = i;
        if (this.e != null) {
            this.e.b(i);
        }
    }

    public boolean b(boolean z) {
        if (this.e == null) {
            return false;
        }
        this.e.d(z);
        return true;
    }

    public boolean b(int i, int i2, int i3) {
        if (this.f != null) {
            this.f.c(i);
            this.f.d(i2);
            this.f.e(i3);
        }
        return true;
    }

    public void b(int i) {
        if (this.f != null) {
            this.f.b(i);
        }
    }

    public void a(Bitmap bitmap) {
        if (this.f != null) {
            this.f.a(bitmap);
        }
    }

    public void c(int i) {
        if (this.f != null) {
            this.f.f(i);
        }
    }

    public void a(String str) {
        if (this.f != null) {
            this.f.a(str);
        }
    }

    @TargetApi(18)
    public boolean b(String str) {
        if (this.f != null) {
            return this.f.a(str, true);
        }
        return false;
    }

    public void d(int i) {
        if (this.f != null) {
            this.f.g(i);
        }
    }

    public void e(int i) {
        if (this.f != null) {
            this.f.h(i);
        }
    }

    public void a(float f) {
        if (this.f != null) {
            this.f.a(f);
        }
    }

    public void f(int i) {
        if (this.f != null) {
            this.f.i(i);
        }
    }

    public void g(int i) {
        if (this.f != null) {
            this.f.j(i);
        }
    }

    public void h(int i) {
        if (this.f != null) {
            this.f.k(i);
        }
    }

    public void i(int i) {
        if (this.f != null) {
            this.f.l(i);
        }
    }

    public void c(boolean z) {
        this.u = z;
        com.tencent.liteav.audio.c.a().c(z);
    }

    public int m() {
        if (this.e == null) {
            return 0;
        }
        return this.e.d();
    }

    public boolean j(int i) {
        if (this.e == null) {
            return false;
        }
        return this.e.a(i);
    }

    public boolean d(boolean z) {
        if (this.e == null) {
            return false;
        }
        this.e.c(z);
        return true;
    }

    public void b(float f) {
        if (this.e != null) {
            this.e.a(f);
        }
    }

    public void k(int i) {
        this.p = i;
        com.tencent.liteav.audio.c.a().d(i);
        TXCDRApi.txReportDAU(this.j, com.tencent.liteav.basic.datareport.a.ay);
    }

    private void b(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putLong("EVT_USERID", this.q);
        bundle.putInt("EVT_ID", i);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        if (str != null) {
            bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str);
        }
        com.tencent.liteav.basic.util.a.a(this.s, i, bundle);
    }

    public boolean c(String str) {
        if (!com.tencent.liteav.audio.c.a().c()) {
            return false;
        }
        TXCDRApi.txReportDAU(this.j, com.tencent.liteav.basic.datareport.a.az);
        return TXCLiveBGMPlayer.getInstance().startPlay(str, com.tencent.liteav.audio.c.a().f());
    }

    public boolean n() {
        TXCLiveBGMPlayer.getInstance().stopPlay();
        return true;
    }

    public boolean o() {
        TXCLiveBGMPlayer.getInstance().pause();
        return true;
    }

    public boolean p() {
        TXCLiveBGMPlayer.getInstance().resume();
        return true;
    }

    public boolean c(float f) {
        this.o = f;
        com.tencent.liteav.audio.c.a().a(f);
        return true;
    }

    public boolean d(float f) {
        TXCLiveBGMPlayer.getInstance().setVolume(f);
        return true;
    }

    public int d(String str) {
        return (int) TXCLiveBGMPlayer.getInstance().getMusicDuration(str);
    }

    public void a(OnBGMNotify onBGMNotify) {
        if (onBGMNotify == null) {
            this.b = null;
            this.c = null;
            TXCLiveBGMPlayer.getInstance().setOnPlayListener(null);
            return;
        }
        this.c = onBGMNotify;
        if (this.b == null) {
            this.b = new 6(this);
        }
        TXCLiveBGMPlayer.getInstance().setOnPlayListener(this.b);
    }

    public int a(byte[] bArr, int i, int i2, int i3) {
        int i4 = 640;
        int i5 = 368;
        if (this.k == null) {
            return -5;
        }
        switch (this.k.k) {
            case 0:
                break;
            case 1:
                i4 = 960;
                i5 = 544;
                break;
            case 2:
                i4 = 1280;
                i5 = 720;
                break;
            case 3:
                i5 = 640;
                i4 = 368;
                break;
            case 4:
                i4 = 544;
                i5 = 960;
                break;
            case 5:
                i5 = 1280;
                i4 = 720;
                break;
            default:
                TXCLog.e(d, "sendCustomYUVData: invalid video_resolution");
                return -1;
        }
        if (i5 > i2 || i4 > i3) {
            return -4;
        }
        if (this.k.E) {
            if (this.i != null) {
                this.i.a();
                this.i = null;
            }
            return DownloadResult.CODE_UNDEFINED;
        }
        a(i5, i4);
        this.i.a(bArr, i, i2, i3, TXCTimeUtil.getTimeTick());
        return 0;
    }

    public void a(byte[] bArr, long j, int i, int i2, int i3) {
        a aVar = this.r;
        if (aVar != null) {
            aVar.onRecordPcm(bArr, j, i, i2, i3);
        }
    }

    public void b(byte[] bArr, long j, int i, int i2, int i3) {
        a aVar = this.r;
        if (aVar != null) {
            aVar.onEncAudio(bArr, j, i, i2);
        }
    }

    public void a(int i, String str) {
        TXCLog.e(d, "onRecordError code = " + i + ":" + str);
        if (i == TXEAudioDef.TXE_AUDIO_RECORD_ERR_NO_MIC_PERMIT) {
            b((int) TXLiveConstants.PUSH_ERR_OPEN_MIC_FAIL, "打开麦克风失败");
        }
    }

    public int a(com.tencent.liteav.basic.f.c cVar) {
        if (this.t != null) {
            l lVar = (l) this.t.get();
            if (lVar != null) {
                cVar.a = lVar.onTextureCustomProcess(cVar.a, cVar.d, cVar.e);
            }
        }
        if (this.e != null) {
            this.e.a(cVar);
        }
        return cVar.a;
    }

    public void a(com.tencent.liteav.basic.f.c cVar, long j) {
        d(cVar.a, cVar.d, cVar.e);
    }

    public void a(byte[] bArr, int i, int i2, int i3, long j) {
    }

    public void a(com.tencent.liteav.basic.f.b bVar, int i) {
        if (i == 0) {
            a aVar = this.r;
            if (this.m == 1 && aVar != null && bVar != null) {
                aVar.onEncVideo(bVar);
            }
        } else if (i == 10000004 && this.g == 1) {
            this.k.j = 0;
            b((int) TXLiveConstants.PUSH_WARNING_HW_ACCELERATION_FAIL, "硬编码启动失败,采用软编码");
        }
    }

    public void a(MediaFormat mediaFormat) {
    }

    public void onNotifyEvent(int i, Bundle bundle) {
        if (bundle != null) {
            bundle.putLong("EVT_USERID", this.q);
        }
        com.tencent.liteav.basic.util.a.a(this.s, i, bundle);
    }

    public void a(com.tencent.liteav.basic.f.b bVar) {
        if (this.m == 2) {
            a aVar = this.r;
            if (bVar != null && aVar != null) {
                bVar.h = TXCTimeUtil.getTimeTick();
                bVar.g = TXCTimeUtil.getTimeTick();
                aVar.onEncVideo(bVar);
            }
        }
    }

    public void a(com.tencent.liteav.videoencoder.b bVar) {
        if (this.e != null) {
            this.e.a(new 7(this, bVar));
        } else if (bVar != null) {
            try {
                bVar.a();
                bVar.a(null);
            } catch (Exception e) {
            }
        }
    }

    public void a() {
        com.tencent.liteav.audio.c.a().b();
        com.tencent.liteav.audio.c.a().a(null);
    }

    public void a(SurfaceTexture surfaceTexture) {
        if (this.f != null) {
            this.f.a();
        }
    }

    public void b(com.tencent.liteav.basic.f.c cVar) {
        if (this.f != null && !this.k.E && this.e != null) {
            if (!(this.h.height == cVar.g && this.h.width == cVar.f)) {
                c(cVar.f, cVar.g);
            }
            this.f.a(cVar, cVar.b, 0);
        }
    }

    public void q() {
        if (this.f != null) {
            this.f.a();
        }
        if (this.t != null) {
            l lVar = (l) this.t.get();
            if (lVar != null) {
                lVar.onTextureDestoryed();
            }
        }
    }

    private void c(int i, int i2, int i3) {
        EGLContext a;
        int i4;
        TXCLog.d(d, "New encode size width = " + i + " height = " + i2 + " encType = " + i3);
        if (this.i != null) {
            this.i.a();
            this.i.a(null);
            this.i = null;
        }
        this.g = i3;
        this.i = new com.tencent.liteav.videoencoder.b(this.g);
        if ((this.k.I & 2) == 2) {
            a = this.i.a(i, i2);
            if (a != null) {
                this.i.a(new 8(this, i, i2, a));
            }
        } else {
            a = this.e.e();
            if (!(this.a.b() && this.h.height == i2 && this.h.width == i)) {
                this.a.a(a, this.j, this.k.t, i, i2);
            }
        }
        this.h.width = i;
        this.h.height = i2;
        this.h.fps = this.k.h;
        this.h.gop = this.k.i;
        TXSVideoEncoderParam tXSVideoEncoderParam = this.h;
        if (this.k.n) {
            i4 = 3;
        } else {
            i4 = 1;
        }
        tXSVideoEncoderParam.encoderProfile = i4;
        this.h.encoderMode = 1;
        this.h.glContext = a;
        this.i.a(this);
        this.i.a(this);
        this.i.a(this.h);
        this.i.a(this.k.c);
        this.i.setID(getID());
    }

    private void d(int i, int i2, int i3) {
        if (this.m == 1) {
            a(i2, i3);
            this.i.a(i, i2, i3, TXCTimeUtil.getTimeTick());
        }
    }

    private void a(int i, int i2) {
        int i3 = 2;
        int i4 = 1;
        switch (this.k.j) {
            case 1:
                i3 = 1;
                break;
            case 2:
                i3 = 3;
                break;
        }
        if (this.l != 1) {
            i4 = i3;
        }
        i3 = this.k.i;
        if (this.i == null || this.h.width != i || this.h.height != i2 || this.g != i4 || this.h.gop != i3) {
            c(i, i2, i4);
        }
    }

    private void r() {
        if (this.i != null) {
            if (this.e != null) {
                this.e.a(new 9(this));
            } else {
                s();
            }
        }
    }

    private void s() {
        try {
            if (this.i != null) {
                this.i.a();
                this.i.a(null);
                this.i = null;
            }
            this.h.width = 0;
            this.h.height = 0;
        } catch (Exception e) {
        }
    }

    private void t() {
        if ((this.k.I & 1) != 0) {
            com.tencent.liteav.audio.c.a().a(true);
            com.tencent.liteav.audio.c.a().c(this.k.r);
            com.tencent.liteav.audio.c.a().b(this.k.q);
        } else {
            com.tencent.liteav.audio.c.a().c(1);
            com.tencent.liteav.audio.c.a().b(this.k.q);
        }
        com.tencent.liteav.audio.c.a().a(this.k.s, this.j);
        com.tencent.liteav.audio.c.a().c(this.u);
        TXCLiveBGMPlayer.getInstance().switchAecType(com.tencent.liteav.audio.c.a().f());
    }

    private void l(int i) {
        if (this.e == null || !this.e.c() || i == this.k.k || this.k.K || this.l != 0) {
            this.k.a();
            if (this.e != null && this.e.c()) {
                this.e.a(new Runnable(this) {
                    final /* synthetic */ c a;

                    {
                        this.a = r1;
                    }

                    public void run() {
                        if (this.a.e != null) {
                            this.a.e.d(this.a.k.k);
                        }
                    }
                });
                return;
            }
            return;
        }
        this.e.a(new Runnable(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.k.a();
                if (this.a.e != null) {
                    this.a.e.d(this.a.k.k);
                    this.a.e.b(false);
                }
            }
        });
    }

    private void u() {
        if (this.k.t != null && this.e != null) {
            this.e.a(new 2(this));
        }
    }

    private void v() {
        if (this.k.x != null && this.e != null) {
            this.e.a(new 3(this));
        }
    }

    private void b(int i, int i2) {
        com.tencent.liteav.beauty.c cVar;
        Bitmap bitmap;
        float f;
        float f2;
        float f3;
        if (this.k.C != -1.0f) {
            if (this.f != null) {
                cVar = this.f;
                bitmap = this.k.x;
                f = this.k.A;
                f2 = this.k.B;
                f3 = this.k.C;
            } else {
                return;
            }
        } else if (this.f != null && i != 0 && i2 != 0) {
            cVar = this.f;
            bitmap = this.k.x;
            f = ((float) this.k.y) / ((float) i);
            f2 = ((float) this.k.z) / ((float) i2);
            f3 = this.k.x == null ? 0.0f : ((float) this.k.x.getWidth()) / ((float) i);
        } else {
            return;
        }
        cVar.a(bitmap, f, f2, f3);
    }

    private void w() {
        if (this.f == null) {
            return;
        }
        if (this.k.H) {
            this.f.f(0);
        } else {
            this.f.f(3);
        }
    }

    private void c(int i, int i2) {
        b(i, i2);
    }
}
