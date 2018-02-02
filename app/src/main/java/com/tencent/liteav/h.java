package com.tencent.liteav;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.audio.impl.Play.TXAudioJitterBufferReportInfo;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.renderer.i;
import com.tencent.rtmp.TXLiveConstants;

public class h extends com.tencent.liteav.basic.module.a implements d, b, com.tencent.liteav.basic.c.a, i, com.tencent.liteav.videodecoder.d {
    private Context a = null;
    private g b = null;
    private com.tencent.liteav.videodecoder.b c = null;
    private com.tencent.liteav.renderer.h d = null;
    private com.tencent.liteav.basic.b.a e = null;
    private com.tencent.liteav.audio.b f = null;
    private com.tencent.liteav.basic.c.a g = null;
    private boolean h = false;
    private long i = 0;
    private byte[] j = null;
    private n k = null;
    private int l;
    private boolean m = false;
    private String n;
    private final float o = com.tencent.liteav.basic.a.a.o;
    private final float p = com.tencent.liteav.basic.a.a.p;
    private final float q = com.tencent.liteav.basic.a.a.q;
    private final float r = 0.3f;
    private boolean s = false;
    private a t = null;

    public interface a {
        void a(SurfaceTexture surfaceTexture);

        void a(com.tencent.liteav.basic.f.a aVar);

        void a(byte[] bArr, long j);
    }

    public h(Context context, int i) {
        this.a = context;
        this.l = i;
    }

    public void a(com.tencent.liteav.renderer.h hVar) {
        this.d = hVar;
        if (this.d != null && this.g != null) {
            this.d.a(this);
        }
    }

    public void a(com.tencent.liteav.basic.c.a aVar) {
        this.g = aVar;
    }

    public void a(g gVar) {
        this.b = gVar;
        p();
    }

    public void setID(String str) {
        super.setID(str);
        if (this.d != null) {
            this.d.setID(getID());
        }
    }

    public void a(a aVar) {
        this.t = aVar;
    }

    public void a(boolean z) {
        this.h = z;
        this.m = true;
        if (this.d != null) {
            this.d.a(this);
            this.d.g();
            this.d.setID(getID());
        }
        this.c = new com.tencent.liteav.videodecoder.b();
        this.c.a(this.i);
        this.c.a(this);
        this.c.a(this);
        this.f = new com.tencent.liteav.audio.b();
        this.f.a(this);
        c(this.h);
        this.f.a(this.a);
        this.e = new com.tencent.liteav.basic.b.a();
        this.e.a((b) this);
        this.e.a();
        o();
        p();
    }

    public void a() {
        this.h = false;
        if (this.c != null) {
            this.c.a(null);
            this.c.a(null);
            this.c.c();
            this.c = null;
        }
        if (this.f != null) {
            this.f.a(null);
            this.f.a();
            this.f = null;
        }
        if (this.e != null) {
            this.e.a(null);
            this.e.b();
            this.e = null;
        }
        if (this.d != null) {
            this.d.h();
            this.d.a(null);
        }
    }

    public void a(Surface surface) {
        if (this.c != null && surface != null) {
            this.c.a(surface, null, null, this.b.h, !this.h);
            this.c.b();
        }
    }

    public void a(com.tencent.liteav.basic.f.a aVar) {
        if (this.f != null) {
            this.f.a(aVar);
        } else {
            TXCLog.w("TXCRenderAndDec", "decAudio fail which audio play hasn't been created!");
        }
    }

    public void a(com.tencent.liteav.basic.f.b bVar) {
        try {
            if (this.e != null) {
                this.e.a(bVar);
            }
        } catch (Exception e) {
        }
    }

    public void a(int i) {
        if (this.d != null) {
            this.d.a(i);
        }
    }

    public void b(int i) {
        if (this.d != null) {
            this.d.b(i);
        }
    }

    public void b(boolean z) {
        if (this.f != null) {
            this.f.d(z);
        }
    }

    public static void a(Context context, int i) {
        com.tencent.liteav.audio.b.a(context, i);
    }

    public long b() {
        if (this.f != null) {
            return this.f.b();
        }
        return 0;
    }

    public long c() {
        if (this.e != null) {
            return this.e.c();
        }
        return 0;
    }

    public long d() {
        if (this.e != null) {
            return this.e.d();
        }
        return 0;
    }

    public int e() {
        if (this.c != null) {
            return this.c.d();
        }
        return 0;
    }

    public long f() {
        if (this.e == null || this.f == null) {
            return 0;
        }
        return this.f.c() - this.e.e();
    }

    public int g() {
        if (this.f != null) {
            return this.f.d();
        }
        return 0;
    }

    public long h() {
        if (this.f == null || this.e == null) {
            return 0;
        }
        return this.f.e() - this.e.f();
    }

    public float i() {
        if (this.f != null) {
            return this.f.f();
        }
        return 0.0f;
    }

    public int j() {
        if (this.e != null) {
            return this.e.g();
        }
        return 0;
    }

    public String k() {
        int g;
        if (this.f != null) {
            g = this.f.g();
        } else {
            g = TXEAudioDef.TXE_AEC_NONE;
        }
        return g + " | " + this.n;
    }

    public void l() {
        long j = 0;
        if (this.f != null) {
            TXAudioJitterBufferReportInfo h = this.f.h();
            if (h != null) {
                long j2 = h.mLoadCnt == 0 ? 0 : (long) (h.mLoadTime / h.mLoadCnt);
                long j3 = h.mTimeTotalCacheTimeCnt == 0 ? 0 : h.mTimeTotalCacheTime / h.mTimeTotalCacheTimeCnt;
                long j4 = (long) (h.mTimeTotalJittCnt == 0 ? 0 : h.mTimeTotalJitt / h.mTimeTotalJittCnt);
                setStatusValue(2001, Long.valueOf(j2));
                setStatusValue(2002, Long.valueOf((long) h.mLoadCnt));
                setStatusValue(2003, Long.valueOf((long) h.mLoadMaxTime));
                setStatusValue(TXLiveConstants.PLAY_EVT_PLAY_BEGIN, Long.valueOf((long) h.mSpeedCnt));
                setStatusValue(TXLiveConstants.PLAY_EVT_PLAY_PROGRESS, Long.valueOf((long) h.mNoDataCnt));
                setStatusValue(TXLiveConstants.PLAY_EVT_PLAY_LOADING, Long.valueOf((long) h.mAvgCacheTime));
                setStatusValue(TXLiveConstants.PLAY_EVT_START_VIDEO_DECODER, Long.valueOf((long) h.mIsRealTime));
                setStatusValue(2010, Long.valueOf(j3));
                setStatusValue(2011, Long.valueOf(j4));
                setStatusValue(2014, Long.valueOf((long) h.mTimeDropCnt));
            }
        }
        if (this.e != null) {
            setStatusValue(TXLiveConstants.PLAY_EVT_PLAY_END, Long.valueOf(d()));
            setStatusValue(6007, Long.valueOf(this.e.j()));
            setStatusValue(6008, Long.valueOf(this.e.i()));
            setStatusValue(6009, Long.valueOf(this.e.h()));
        }
        if (this.c != null) {
            if (this.c.a()) {
                j = 1;
            }
            setStatusValue(5002, Long.valueOf(j));
        }
    }

    public boolean a(byte[] bArr) {
        synchronized (this) {
            this.j = bArr;
        }
        return true;
    }

    public void a(n nVar) {
        synchronized (this) {
            this.k = nVar;
        }
    }

    private void c(SurfaceTexture surfaceTexture) {
        com.tencent.liteav.videodecoder.b bVar = this.c;
        if (bVar != null && surfaceTexture != null) {
            bVar.a(surfaceTexture, null, null, this.b.h, !this.h);
            bVar.b();
        }
    }

    private void o() {
        SurfaceTexture a = this.d != null ? this.d.a() : null;
        if (a != null) {
            c(a);
        }
    }

    private void p() {
        c(this.h);
        if (this.f != null && (!this.h || (this.h && this.b.c <= this.q && this.b.b <= this.q))) {
            this.f.a(this.b.a);
            this.f.a(this.b.f);
            this.f.c(this.b.c);
            this.f.b(this.b.b);
            setStatusValue(2012, Long.valueOf((long) (this.b.c * 1000.0f)));
            setStatusValue(2013, Long.valueOf((long) (this.b.b * 1000.0f)));
            setStatusValue(2015, Long.valueOf(0));
        }
        if (this.c != null && this.c.a() && this.b.c < 0.3f && this.b.b < 0.3f) {
            this.b.h = false;
            this.c.c();
            o();
        }
    }

    private void c(boolean z) {
        if (z) {
            float f = this.b.c;
            float f2 = this.b.b;
            if (f > this.p) {
                f = this.p;
            }
            if (f2 > this.q) {
                f2 = this.q;
            }
            if (f >= f2) {
                f2 = this.p;
                f = this.q;
            } else {
                float f3 = f2;
                f2 = f;
                f = f3;
            }
            this.b.f = true;
            this.b.a = f2;
            this.b.c = f2;
            this.b.b = f;
            if (this.f != null) {
                this.f.a(true, this.a);
                this.f.c(true);
            }
        } else if (this.f == null) {
        } else {
            if (this.b == null || !this.b.g) {
                this.f.a(false, this.a);
                this.f.c(false);
                return;
            }
            this.f.a(true, this.a);
            this.f.c(true);
        }
    }

    private void a(int i, String str) {
        com.tencent.liteav.basic.c.a aVar = this.g;
        if (aVar != null) {
            Bundle bundle = new Bundle();
            new StringBuilder("TXCRenderAndDec notifyEvent: mUserID  ").append(this.i);
            bundle.putLong("EVT_USERID", this.i);
            bundle.putInt("EVT_ID", i);
            bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
            if (str != null) {
                bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str);
            }
            aVar.onNotifyEvent(i, bundle);
        }
    }

    private void q() {
        com.tencent.liteav.videodecoder.b bVar = this.c;
        if (bVar != null) {
            TXCLog.w("TXCRenderAndDec", "switch to soft decoder when hw error");
            bVar.c();
            this.b.h = false;
            c(this.h);
            o();
        }
    }

    public void onNotifyEvent(int i, Bundle bundle) {
        if (i == TXLiveConstants.PLAY_WARNING_HW_ACCELERATION_FAIL) {
            q();
        } else if (i == 2003 && this.m) {
            a((int) TXLiveConstants.PLAY_EVT_PLAY_BEGIN, "视频播放开始");
            this.m = false;
        }
        if (this.g != null) {
            this.g.onNotifyEvent(i, bundle);
        }
    }

    public void a(SurfaceTexture surfaceTexture) {
        c(surfaceTexture);
    }

    public void b(SurfaceTexture surfaceTexture) {
        try {
            TXCLog.w("TXCRenderAndDec", "play:stop decode when surface texture release");
            if (this.c != null) {
                this.c.c();
            }
            if (this.t != null) {
                this.t.a(surfaceTexture);
            }
        } catch (Exception e) {
        }
    }

    public long m() {
        try {
            if (this.f != null) {
                return this.f.b();
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void b(com.tencent.liteav.basic.f.b bVar) {
        try {
            if (this.c != null) {
                this.c.a(bVar);
            }
        } catch (Exception e) {
        }
    }

    public int n() {
        try {
            if (this.c != null) {
                return this.c.d();
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void a(SurfaceTexture surfaceTexture, int i, int i2, long j, long j2) {
        if (this.d != null) {
            this.d.a(surfaceTexture, i, i2);
            if (this.e != null) {
                this.e.a(j);
            }
        }
    }

    public void a(long j, int i, int i2, long j2, long j3) {
        if (!(this.k == null || this.j == null)) {
            synchronized (this) {
                byte[] bArr = this.j;
                this.j = null;
                if (!(this.k == null || bArr == null || this.c == null)) {
                    if (bArr.length <= ((i * i2) * 3) / 2) {
                        this.c.a(bArr, j, bArr.length);
                        this.k.onVideoRawDataAvailable(bArr, i, i2, (int) j2);
                    } else {
                        TXCLog.e("TXCRenderAndDec", "raw data buffer length is too large");
                    }
                }
            }
        }
        if (this.d != null) {
            this.d.a(j, i, i2);
            if (this.e != null) {
                this.e.a(j2);
            }
        }
    }

    public void a(int i, int i2) {
        if (this.d != null) {
            this.d.b(i, i2);
        }
        Bundle bundle = new Bundle();
        bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, "分辨率改变");
        bundle.putInt("EVT_PARAM1", i);
        bundle.putInt("EVT_PARAM2", i2);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        onNotifyEvent(TXLiveConstants.PLAY_EVT_CHANGE_RESOLUTION, bundle);
    }

    public void onPlayAudioInfoChanged(com.tencent.liteav.basic.f.a aVar, com.tencent.liteav.basic.f.a aVar2) {
        if (this.t != null) {
            this.t.a(aVar2);
        }
        if (aVar != null && aVar2 != null) {
            this.n = aVar.a + "," + aVar.b + " | " + aVar2.a + "," + aVar2.b;
        }
    }

    public void onPlayPcmData(byte[] bArr, long j) {
        if (this.t != null) {
            this.t.a(bArr, j);
        }
    }

    public void onPlayError(int i, String str) {
    }

    public void onPlayJitterStateNotify(int i) {
        if (i == TXEAudioDef.TXE_AUDIO_JITTER_STATE_LOADING) {
            a((int) TXLiveConstants.PLAY_EVT_PLAY_LOADING, "视频缓冲中...");
        } else if (i == TXEAudioDef.TXE_AUDIO_JITTER_STATE_PLAYING) {
            a((int) TXLiveConstants.PLAY_EVT_PLAY_BEGIN, "视频播放开始");
        } else if (i == TXEAudioDef.TXE_AUDIO_JITTER_STATE_FIRST_PLAY && this.m) {
            a((int) TXLiveConstants.PLAY_EVT_PLAY_BEGIN, "视频播放开始");
            this.m = false;
        }
    }
}
