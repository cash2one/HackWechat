package com.tencent.liteav;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.f.c;
import com.tencent.liteav.renderer.d;
import com.tencent.liteav.renderer.i;
import com.tencent.liteav.renderer.j;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLContext;

public class b implements OnTouchListener, a, j, i, j {
    WeakReference<a> a;
    private Context b;
    private TXCloudVideoView c;
    private d d;
    private com.tencent.liteav.capturer.a e;
    private Handler f;
    private k g;
    private boolean h;
    private f i;
    private int j;
    private int k;
    private int l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;

    public b(Context context, f fVar, TXCloudVideoView tXCloudVideoView) {
        this.e = null;
        this.f = null;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = false;
        this.n = false;
        this.o = -1;
        this.p = -1;
        this.e = new com.tencent.liteav.capturer.a();
        try {
            this.i = (f) fVar.clone();
        } catch (CloneNotSupportedException e) {
            this.i = new f();
        }
        this.b = context;
        this.f = new Handler(Looper.getMainLooper());
        this.c = tXCloudVideoView;
        this.d = this.c.getGLSurfaceView();
    }

    public void a() {
        if (this.f != null) {
            this.f.post(new 1(this));
        }
        this.d.setListener(this);
        c(this.d.getSurfaceTexture());
        if (this.i.D) {
            this.c.setOnTouchListener(this);
        }
    }

    public void a(boolean z) {
        b();
        if (this.i.D && this.c != null) {
            this.c.setOnTouchListener(null);
        }
        if (this.d != null) {
            this.d.b(z);
            if (z && this.f != null) {
                this.f.post(new 2(this));
            }
        }
    }

    public void b() {
        this.e.b();
        this.h = false;
        if (this.d != null) {
            this.d.c(false);
        }
    }

    public void b(boolean z) {
        if (this.h && this.e != null && this.d != null) {
            f fVar = this.i;
            boolean z2 = z ? !this.i.m : this.i.m;
            fVar.m = z2;
            this.e.b();
            this.d.a(false);
            this.e.a(g());
            this.e.a(this.d.getSurfaceTexture());
            if (this.e.c(this.i.m) == 0) {
                this.h = true;
                a(1003, "打开摄像头成功");
            } else {
                this.h = false;
                a((int) TXLiveConstants.PUSH_ERR_OPEN_CAMERA_FAIL, "打开摄像头失败，请确认摄像头权限是否打开");
            }
            this.d.b();
        }
    }

    public boolean c() {
        return this.h;
    }

    public int d() {
        return this.e.a();
    }

    public boolean a(int i) {
        return this.e.c(i);
    }

    public void a(float f) {
        this.e.a(f);
    }

    public void b(int i) {
        this.o = i;
        h();
    }

    public void a(k kVar) {
        this.g = kVar;
    }

    public void c(boolean z) {
        if (this.d != null) {
            this.d.a(new 3(this, z));
        }
    }

    public boolean d(boolean z) {
        this.e.a(z);
        return true;
    }

    public void a(c cVar) {
        if (this.n) {
            this.d.a(cVar.a, this.k, this.l, cVar.h, this.j, cVar.d, cVar.e);
        } else {
            this.d.a(cVar.a, this.d.getWidth(), this.d.getHeight(), cVar.h, this.j, cVar.d, cVar.e);
        }
    }

    public void e(boolean z) {
        this.m = z;
    }

    public void a(Runnable runnable) {
        this.d.a(runnable);
    }

    public EGLContext e() {
        return this.d.getGLContext();
    }

    public void onNotifyEvent(int i, Bundle bundle) {
        com.tencent.liteav.basic.util.a.a(this.a, i, bundle);
    }

    public void a(a aVar) {
        this.a = new WeakReference(aVar);
    }

    public void c(int i) {
        this.p = i;
        h();
    }

    public void a(int i, int i2) {
        this.i.a = i;
        this.i.b = i2;
    }

    public void d(int i) {
        this.i.k = i;
        this.i.a();
    }

    private void c(SurfaceTexture surfaceTexture) {
        if (surfaceTexture != null && !this.h && this.e != null) {
            this.e.a(surfaceTexture);
            this.e.b(this.i.h);
            this.e.d(this.i.l);
            this.e.b(this.i.D);
            this.e.a(g());
            if (this.e.c(this.i.m) == 0) {
                this.h = true;
                a(1003, "打开摄像头成功");
                if (this.d != null) {
                    this.d.setFPS(this.i.h);
                    this.d.setTextureListener(this);
                    this.d.setNotifyListener(this);
                    this.d.b();
                    this.d.c(true);
                    f();
                }
                if (this.m && !com.tencent.liteav.audio.c.a().c()) {
                    com.tencent.liteav.audio.c.a().a(this.b);
                    this.m = false;
                    return;
                }
                return;
            }
            this.h = false;
            a((int) TXLiveConstants.PUSH_ERR_OPEN_CAMERA_FAIL, "打开摄像头失败，请确认摄像头权限是否打开");
        }
    }

    private void b(int i, int i2) {
        this.f.post(new 4(this, i, i2));
    }

    private void a(int i, String str) {
        if (this.f != null) {
            this.f.post(new 5(this, i, str));
        }
    }

    public void a(SurfaceTexture surfaceTexture) {
        new Handler(Looper.getMainLooper()).post(new 6(this, surfaceTexture));
        if (this.g != null) {
            this.g.a(surfaceTexture);
        }
    }

    public void b(SurfaceTexture surfaceTexture) {
        if (this.g != null) {
            this.g.q();
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.e != null && this.i.D) {
            this.e.a(motionEvent.getX() / ((float) view.getWidth()), motionEvent.getY() / ((float) view.getHeight()));
        }
        if (this.c != null && this.i.D) {
            this.c.onTouchFocus((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        return false;
    }

    public int a(int i, float[] fArr) {
        if (this.g != null) {
            c cVar = new c();
            cVar.d = this.e.e();
            cVar.e = this.e.f();
            cVar.f = this.i.a;
            cVar.g = this.i.b;
            cVar.i = this.e.c();
            boolean z = this.e.d() ? !this.i.J : this.i.J;
            cVar.h = z;
            cVar.a = i;
            cVar.c = fArr;
            cVar.b = 4;
            if (cVar.i == 0 || cVar.i == 180) {
                cVar.f = this.i.b;
                cVar.g = this.i.a;
            } else {
                cVar.f = this.i.a;
                cVar.g = this.i.b;
            }
            cVar.j = com.tencent.liteav.basic.util.a.a(cVar.d, cVar.e, this.i.b, this.i.a);
            this.g.b(cVar);
        }
        return 0;
    }

    private void f() {
        if (this.d != null && this.n) {
            this.k = 720;
            this.l = 1280;
            b(this.k, this.l);
        }
    }

    private int g() {
        if (this.i.K) {
            return 7;
        }
        switch (this.i.k) {
            case 0:
                return 4;
            case 1:
                return 5;
            case 2:
                return 6;
            case 6:
                return 3;
            default:
                return 7;
        }
    }

    private void h() {
        if (this.d != null) {
            this.d.a(new 7(this));
        }
    }
}
