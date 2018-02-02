package com.tencent.liteav.renderer;

import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.a;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.rtmp.TXLiveConstants;
import java.lang.ref.WeakReference;

public class h extends a implements SurfaceTextureListener {
    private SurfaceTexture a;
    private long b;
    protected TextureView c;
    protected g d;
    protected int e = 0;
    protected int f = 0;
    protected int g = 0;
    protected int h = 0;
    protected i i;
    WeakReference<com.tencent.liteav.basic.c.a> j;
    private boolean k = false;
    private boolean l = false;
    private a m = new a();

    public void a(i iVar) {
        this.i = iVar;
    }

    public void a(com.tencent.liteav.basic.c.a aVar) {
        this.j = new WeakReference(aVar);
    }

    public void a(TextureView textureView) {
        b(textureView);
    }

    public void a(long j, int i, int i2) {
        a(i, i2);
        b();
    }

    public void a(SurfaceTexture surfaceTexture, int i, int i2) {
        a(i, i2);
        b();
    }

    public void a(int i, int i2, int i3, boolean z, int i4) {
        a(i2, i3);
    }

    public void g() {
        this.l = true;
        this.k = false;
        l();
    }

    public void h() {
        this.k = false;
        this.l = false;
    }

    public void b(int i, int i2) {
        a(i, i2);
    }

    public void a(int i) {
        if (this.d != null) {
            this.d.a(i);
        }
    }

    public void b(int i) {
        if (this.d != null) {
            this.d.c(i);
        }
    }

    public SurfaceTexture a() {
        return null;
    }

    public TextureView i() {
        return this.c;
    }

    public int j() {
        return this.g;
    }

    public int k() {
        return this.h;
    }

    protected void a(SurfaceTexture surfaceTexture) {
    }

    protected void b(SurfaceTexture surfaceTexture) {
    }

    private void b(TextureView textureView) {
        Object obj = null;
        if ((this.c == null && textureView != null) || !(this.c == null || this.c.equals(textureView))) {
            obj = 1;
        }
        TXCLog.w("TXCVideoRender", "play:vrender: set video view @old=" + this.c + ",new=" + textureView);
        if (obj != null) {
            if (this.c != null && this.a == null) {
                b(this.c.getSurfaceTexture());
            }
            this.c = textureView;
            if (this.c != null) {
                this.e = this.c.getWidth();
                this.f = this.c.getHeight();
                this.d = new g(this.c);
                this.d.b(this.g, this.h);
                this.d.a(this.e, this.f);
                this.c.setSurfaceTextureListener(this);
                if (this.a != null) {
                    this.c.setSurfaceTexture(this.a);
                } else if (this.c.isAvailable()) {
                    a(this.c.getSurfaceTexture());
                }
            }
        }
    }

    protected void a(int i, int i2) {
        if (this.g != i || this.h != i2) {
            if (this.g != i || this.h != i2) {
                this.g = i;
                this.h = i2;
                if (this.d != null) {
                    this.d.b(this.g, this.h);
                }
            }
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        TXCLog.w("TXCVideoRender", "play:vrender: texture available @" + surfaceTexture);
        this.e = i;
        this.f = i2;
        if (this.d != null) {
            this.d.a(this.e, this.f);
        }
        if (this.a != null) {
            this.c.setSurfaceTexture(this.a);
            this.a = null;
            return;
        }
        a(surfaceTexture);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        TXCLog.w("TXCVideoRender", "play:vrender: texture size change new:" + i + "," + i2 + " old:" + this.e + "," + this.f);
        this.e = i;
        this.f = i2;
        if (this.d != null) {
            this.d.a(this.e, this.f);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        try {
            TXCLog.w("TXCVideoRender", "play:vrender:  onSurfaceTextureDestroyed when need save texture : " + this.l);
            if (this.l) {
                this.a = surfaceTexture;
            } else {
                this.m.a = 0;
                b(surfaceTexture);
            }
        } catch (Exception e) {
        }
        return this.a == null;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void l() {
        this.m.a = 0;
        this.m.b = 0;
        this.m.c = 0;
        this.m.d = 0;
        this.m.e = 0;
        this.m.f = 0;
        this.m.g = 0;
        this.m.h = 0;
        this.m.i = 0;
        this.m.j = 0;
        this.m.k = 0;
        setStatusValue(6001, Long.valueOf(0));
        setStatusValue(6002, Double.valueOf(0.0d));
        setStatusValue(6003, Long.valueOf(0));
        setStatusValue(6005, Long.valueOf(0));
        setStatusValue(6006, Long.valueOf(0));
        setStatusValue(6004, Long.valueOf(0));
    }

    private long a(long j) {
        long timeTick = TXCTimeUtil.getTimeTick();
        if (j > timeTick) {
            return 0;
        }
        return timeTick - j;
    }

    private void b() {
        if (!this.k) {
            com.tencent.liteav.basic.util.a.a(this.j, this.b, 2003, "渲染首个视频数据包(IDR)");
            setStatusValue(6001, Long.valueOf(TXCTimeUtil.getTimeTick()));
            this.k = true;
        }
        a aVar = this.m;
        aVar.c++;
        if (this.m.a == 0) {
            this.m.a = TXCTimeUtil.getTimeTick();
        } else {
            long timeTick = TXCTimeUtil.getTimeTick() - this.m.a;
            if (timeTick >= 1000) {
                setStatusValue(6002, Double.valueOf((((double) (this.m.c - this.m.b)) * 1000.0d) / ((double) timeTick)));
                this.m.b = this.m.c;
                a aVar2 = this.m;
                aVar2.a = timeTick + aVar2.a;
            }
        }
        if (this.m.d != 0) {
            this.m.i = a(this.m.d);
            if (this.m.i > 500) {
                aVar = this.m;
                aVar.e++;
                setStatusValue(6003, Long.valueOf(this.m.e));
                if (this.m.i > this.m.h) {
                    this.m.h = this.m.i;
                    setStatusValue(6005, Long.valueOf(this.m.h));
                }
                aVar = this.m;
                aVar.g += this.m.i;
                setStatusValue(6006, Long.valueOf(this.m.g));
                TXCLog.w("TXCVideoRender", "render frame count:" + this.m.c + " block time:" + this.m.i + "> 500");
            }
            if (this.m.i > 800) {
                TXCLog.w("TXCVideoRender", "render frame count:" + this.m.c + " block time:" + this.m.i + "> 800");
            }
            if (this.m.i > 1000) {
                aVar = this.m;
                aVar.f++;
                setStatusValue(6004, Long.valueOf(this.m.f));
                TXCLog.w("TXCVideoRender", "render frame count:" + this.m.c + " block time:" + this.m.i + "> 1000");
                com.tencent.liteav.basic.util.a.a(this.j, this.b, TXLiveConstants.PLAY_WARNING_VIDEO_PLAY_LAG, "当前视频播放出现卡顿" + this.m.i + "ms");
            }
        }
        this.m.d = TXCTimeUtil.getTimeTick();
        this.m.k = this.h;
        this.m.j = this.g;
    }
}
