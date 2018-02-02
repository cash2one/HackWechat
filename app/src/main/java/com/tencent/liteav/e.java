package com.tencent.liteav;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.liteav.renderer.b;
import com.tencent.liteav.renderer.j;
import com.tencent.liteav.renderer.k;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePlayer$ITXAudioRawDataListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;
import com.tencent.ugc.TXRecordCommon.TXRecordResult;

public class e extends m implements a, h.a, com.tencent.liteav.network.e, b.a, j {
    private int A;
    private TXLivePlayer$ITXAudioRawDataListener B;
    private String C;
    private boolean D;
    private h e;
    private b f;
    private TXCStreamDownloader g;
    private Handler h;
    private TextureView i;
    private Surface j;
    private boolean k;
    private boolean l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private com.tencent.liteav.a.a q;
    private ITXVideoRecordListener r;
    private d s;
    private int t;
    private int u;
    private k v;
    private k w;
    private float[] x;
    private float[] y;
    private String z;

    public e(Context context) {
        super(context);
        this.e = null;
        this.f = null;
        this.g = null;
        this.k = false;
        this.l = false;
        this.m = 0;
        this.n = 0;
        this.o = 16;
        this.p = false;
        this.t = 0;
        this.u = 0;
        this.v = null;
        this.w = null;
        this.x = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
        this.y = new float[16];
        this.z = "";
        this.C = "";
        this.D = false;
        this.h = new Handler(Looper.getMainLooper());
        this.f = new b();
        this.f.a(this);
    }

    public void a(TXCloudVideoView tXCloudVideoView) {
        if (!(this.c == null || this.c == tXCloudVideoView)) {
            View videoView = this.c.getVideoView();
            if (videoView != null) {
                this.c.removeView(videoView);
            }
        }
        super.a(tXCloudVideoView);
        if (this.c != null) {
            this.i = this.c.getVideoView();
            if (this.i == null) {
                this.i = new TextureView(this.c.getContext());
            }
            this.c.addVideoView(this.i);
        }
        if (this.f != null) {
            this.f.a(this.i);
        }
    }

    public void a(g gVar) {
        super.a(gVar);
        if (this.e != null) {
            this.e.a(gVar);
        }
    }

    public int a(String str, int i) {
        this.z = str;
        this.A = i;
        a(str);
        this.l = true;
        f(i);
        int b = b(str, i);
        if (b != 0) {
            this.l = false;
            k();
            j();
            if (this.i != null) {
                this.i.setVisibility(8);
            }
        } else {
            l();
            n();
            TXCDRApi.txReportDAU(this.b, com.tencent.liteav.basic.datareport.a.aH);
        }
        return b;
    }

    public int a(boolean z) {
        if (c()) {
            TXCLog.v("TXCLivePlayer", "play: stop");
            this.l = false;
            k();
            j();
            if (this.i != null && z) {
                this.i.setVisibility(8);
            }
            m();
            o();
            return 0;
        }
        TXCLog.w("TXCLivePlayer", "play: ignore stop play when not started");
        return -2;
    }

    public void a() {
        a(false);
    }

    public void b() {
        a(this.z, this.A);
    }

    public boolean c() {
        return this.l;
    }

    public void a(Surface surface) {
        this.j = surface;
        if (this.e != null) {
            this.e.a(surface);
        }
    }

    public void a(int i) {
        if (this.e != null) {
            this.e.a(i);
        }
    }

    public void b(int i) {
        if (this.e != null) {
            this.e.b(i);
        }
    }

    public void b(boolean z) {
        this.k = z;
        if (this.e != null) {
            this.e.b(this.k);
        }
    }

    public void a(Context context, int i) {
        h.a(context, i);
    }

    public void a(ITXVideoRecordListener iTXVideoRecordListener) {
        this.r = iTXVideoRecordListener;
    }

    public int c(int i) {
        if (this.p) {
            TXCLog.e("TXCLivePlayer", "startRecord: there is existing uncompleted record task");
            return -1;
        }
        this.p = true;
        this.f.a(this);
        this.f.a(this);
        TXCDRApi.txReportDAU(this.b, com.tencent.liteav.basic.datareport.a.au);
        return 0;
    }

    public TextureView d() {
        return this.i;
    }

    public void a(TXLivePlayer$ITXAudioRawDataListener tXLivePlayer$ITXAudioRawDataListener) {
        this.B = tXLivePlayer$ITXAudioRawDataListener;
    }

    public int e() {
        if (this.p) {
            this.p = false;
            return 0;
        }
        TXCLog.w("TXCLivePlayer", "stopRecord: no recording task exist");
        return -1;
    }

    public boolean a(byte[] bArr) {
        if (this.e != null) {
            return this.e.a(bArr);
        }
        return false;
    }

    public void a(n nVar) {
        if (this.e != null) {
            this.e.a(nVar);
        }
    }

    private void g() {
        if (this.q == null) {
            this.t = this.f.j();
            this.u = this.f.k();
            com.tencent.liteav.a.a.a i = i();
            this.q = new com.tencent.liteav.a.a();
            this.q.a(i);
            this.q.a(new com.tencent.liteav.a.a.b(this) {
                final /* synthetic */ e a;

                {
                    this.a = r1;
                }

                public void a(int i, String str, String str2, String str3) {
                    if (this.a.r != null) {
                        TXRecordResult tXRecordResult = new TXRecordResult();
                        if (i == 0) {
                            tXRecordResult.retCode = 0;
                        } else {
                            tXRecordResult.retCode = -1;
                        }
                        tXRecordResult.descMsg = str;
                        tXRecordResult.videoPath = str2;
                        tXRecordResult.coverPath = str3;
                        this.a.r.onRecordComplete(tXRecordResult);
                    }
                    this.a.f.a(null);
                    this.a.f.a(null);
                }

                public void a(long j) {
                    if (this.a.r != null) {
                        this.a.r.onRecordProgress(j);
                    }
                }
            });
        }
        if (this.v == null) {
            this.v = new k(Boolean.valueOf(true));
            this.v.a();
            this.v.b(this.t, this.u);
            this.v.a(this.t, this.u);
        }
        if (this.w == null) {
            this.w = new k(Boolean.valueOf(false));
            this.w.a();
            this.w.b(this.f.i().getWidth(), this.f.i().getHeight());
            this.w.a(this.f.i().getWidth(), this.f.i().getHeight());
            Matrix.setIdentityM(this.y, 0);
        }
    }

    private void h() {
        if (this.v != null) {
            this.v.b();
            this.v = null;
        }
        if (this.w != null) {
            this.w.b();
            this.w = null;
        }
        if (this.q != null) {
            this.q.a();
            this.q = null;
        }
    }

    private com.tencent.liteav.a.a.a i() {
        int i = 480;
        int i2 = 640;
        if (this.t > 0 && this.u > 0) {
            i = this.t;
            i2 = this.u;
        }
        com.tencent.liteav.a.a.a aVar = new com.tencent.liteav.a.a.a();
        aVar.a = i;
        aVar.b = i2;
        aVar.c = 20;
        aVar.d = (int) (Math.sqrt(((double) (i2 * i2)) + (((double) (i * i)) * 1.0d)) * 1.2d);
        aVar.h = this.m;
        aVar.i = this.n;
        aVar.j = this.o;
        aVar.f = com.tencent.liteav.a.a.a(this.b, ".mp4");
        aVar.g = com.tencent.liteav.a.a.a(this.b, ".jpg");
        aVar.e = this.f.b();
        TXCLog.d("TXCLivePlayer", "record config: " + aVar);
        return aVar;
    }

    private void f(int i) {
        boolean z = true;
        if (this.i != null) {
            this.i.setVisibility(0);
        }
        this.e = new h(this.b, 1);
        this.e.a(this);
        this.e.a(this.f);
        this.e.a(this);
        this.e.a(this.a);
        this.e.setID(this.C);
        h hVar = this.e;
        if (i != 5) {
            z = false;
        }
        hVar.a(z);
        this.e.a(this.j);
        this.e.b(this.k);
    }

    private void j() {
        if (this.e != null) {
            this.e.a();
            this.e.a(null);
            this.e.a(null);
            this.e.a(null);
            this.e = null;
        }
    }

    private int b(String str, int i) {
        int i2 = 0;
        if (i == 0) {
            this.g = new TXCStreamDownloader(this.b, 0, 1);
        } else if (i == 5) {
            this.g = new TXCStreamDownloader(this.b, 0, 4);
        } else {
            this.g = new TXCStreamDownloader(this.b, 0, 0);
        }
        this.g.setID(this.C);
        this.g.setListener(this);
        this.g.setNotifyListener(this);
        if (i == 5) {
            i2 = 1;
        }
        if (i2 != 0) {
            this.g.setRetryTimes(5);
            this.g.setRetryInterval(1);
        } else {
            this.g.setRetryTimes(this.a.d);
            this.g.setRetryInterval(this.a.e);
        }
        return this.g.start(str, this.a.i, this.a.j);
    }

    private void k() {
        if (this.g != null) {
            this.g.setListener(null);
            this.g.setNotifyListener(null);
            this.g.stop();
            this.g = null;
        }
    }

    private void l() {
        this.s = new d(this.b);
        this.s.a(this.z);
        this.s.a(this.A == 5);
        this.s.b(this.C);
        this.s.a();
    }

    private void m() {
        if (this.s != null) {
            this.s.c();
            this.s = null;
        }
    }

    private void a(String str) {
        this.C = String.format("%s-%d", new Object[]{str, Long.valueOf(TXCTimeUtil.getTimeTick() % 10000)});
        if (this.e != null) {
            this.e.setID(this.C);
        }
        if (this.f != null) {
            this.f.setID(this.C);
        }
        if (this.g != null) {
            this.g.setID(this.C);
        }
        if (this.s != null) {
            this.s.b(this.C);
        }
    }

    private void n() {
        this.D = true;
        if (this.h != null) {
            this.h.postDelayed(new 2(this), 2000);
        }
    }

    private void o() {
        this.D = false;
    }

    private void p() {
        int[] a = com.tencent.liteav.basic.util.a.a();
        int i = a[0] / 10;
        CharSequence charSequence = i + "/" + (a[1] / 10) + "%";
        int d = TXCStatus.d(this.C, 7102);
        int d2 = TXCStatus.d(this.C, 7101);
        CharSequence c = TXCStatus.c(this.C, 7110);
        i = (int) TXCStatus.e(this.C, 6002);
        Bundle bundle = new Bundle();
        if (this.f != null) {
            bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_WIDTH, this.f.j());
            bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_HEIGHT, this.f.k());
        }
        if (this.e != null) {
            int i2;
            bundle.putInt(TXLiveConstants.NET_STATUS_CACHE_SIZE, (int) this.e.c());
            bundle.putInt(TXLiveConstants.NET_STATUS_CODEC_CACHE, (int) this.e.b());
            bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_CACHE_SIZE, (int) this.e.d());
            bundle.putInt(TXLiveConstants.NET_STATUS_V_DEC_CACHE_SIZE, this.e.e());
            bundle.putInt(TXLiveConstants.NET_STATUS_AV_PLAY_INTERVAL, (int) this.e.f());
            bundle.putString(TXLiveConstants.NET_STATUS_AUDIO_INFO, this.e.k());
            bundle.putInt(TXLiveConstants.NET_STATUS_NET_JITTER, this.e.g());
            bundle.putInt(TXLiveConstants.NET_STATUS_AV_RECV_INTERVAL, (int) this.e.h());
            bundle.putFloat(TXLiveConstants.NET_STATUS_AUDIO_PLAY_SPEED, this.e.i());
            if (i == 0) {
                i2 = 15;
            } else {
                i2 = i;
            }
            bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_GOP, (int) (((double) (((float) ((this.e.j() * 10) / i2)) / 10.0f)) + 0.5d));
        }
        bundle.putInt(TXLiveConstants.NET_STATUS_NET_SPEED, d2 + d);
        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_FPS, i);
        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_BITRATE, d2);
        bundle.putInt(TXLiveConstants.NET_STATUS_AUDIO_BITRATE, d);
        bundle.putCharSequence(TXLiveConstants.NET_STATUS_SERVER_IP, c);
        bundle.putCharSequence(TXLiveConstants.NET_STATUS_CPU_USAGE, charSequence);
        com.tencent.liteav.basic.util.a.a(this.d, 15001, bundle);
        if (this.e != null) {
            this.e.l();
        }
        if (this.s != null) {
            this.s.e();
        }
        if (this.h != null && this.D) {
            this.h.postDelayed(new 3(this), 2000);
        }
    }

    public void onPullAudio(com.tencent.liteav.basic.f.a aVar) {
        if (this.l && this.e != null) {
            this.e.a(aVar);
        }
    }

    public void onPullNAL(com.tencent.liteav.basic.f.b bVar) {
        if (this.l) {
            try {
                if (this.e != null) {
                    this.e.a(bVar);
                }
            } catch (Exception e) {
            }
        }
    }

    public void onNotifyEvent(int i, Bundle bundle) {
        if (this.h != null) {
            this.h.post(new 4(this, i, bundle));
        }
    }

    public int a(int i, float[] fArr) {
        if (!(this.q == null || this.v == null)) {
            int b = this.v.b(i);
            this.q.a(b, TXCTimeUtil.getTimeTick());
            this.f.a(b, this.t, this.u, false, 0);
        }
        if (this.p) {
            g();
        } else {
            h();
        }
        return i;
    }

    public void d(int i) {
        if (!(this.q == null || this.w == null)) {
            this.w.a(this.x);
            this.q.a(this.w.b(i), TXCTimeUtil.getTimeTick());
            this.w.a(this.y);
            this.w.a(i);
        }
        if (this.p) {
            g();
        } else {
            h();
        }
    }

    public void a(SurfaceTexture surfaceTexture) {
        h();
        e();
    }

    public void a(byte[] bArr, long j) {
        if (this.q != null) {
            if (j <= 0) {
                j = TXCTimeUtil.getTimeTick();
            }
            this.q.a(bArr, j);
        }
        if (this.B != null) {
            this.B.onPcmDataAvailable(bArr, j);
        }
    }

    public void a(com.tencent.liteav.basic.f.a aVar) {
        TXCLog.d("TXCLivePlayer", "onPlayAudioInfoChanged, samplerate=" + aVar.a + ", channels=" + aVar.b + ", bits=" + aVar.c);
        this.m = aVar.b;
        this.n = aVar.a;
        if (aVar.c > 1) {
            this.o = aVar.c;
        }
    }
}
