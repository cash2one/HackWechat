package com.tencent.liteav.beauty;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.liteav.basic.d.a;
import com.tencent.liteav.basic.d.e;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

public class c implements d {
    protected Context a;
    protected boolean b = true;
    protected boolean c = false;
    protected int d = 0;
    protected int e = 0;
    protected int f = 0;
    protected a g = null;
    protected b h;
    protected a i = new a();
    protected b j = null;
    e k;
    private boolean l = false;

    private static class b {
        public boolean a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public boolean g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;
        public a m;

        private b() {
            this.g = false;
            this.k = 5;
            this.l = 0;
            this.m = null;
        }
    }

    public int a(int i, int i2, int i3) {
        boolean z = false;
        if (this.k == null) {
            return 0;
        }
        com.tencent.liteav.basic.f.c cVar = new com.tencent.liteav.basic.f.c();
        cVar.d = i2;
        cVar.e = i3;
        cVar.i = this.j != null ? this.j.j : 0;
        if (this.j != null) {
            z = this.j.g;
        }
        cVar.h = z;
        cVar.a = i;
        return this.k.a(cVar);
    }

    public void a(int i, int i2, int i3, long j) {
        boolean z = false;
        if (this.k != null) {
            com.tencent.liteav.basic.f.c cVar = new com.tencent.liteav.basic.f.c();
            cVar.d = i2;
            cVar.e = i3;
            cVar.i = this.j != null ? this.j.j : 0;
            if (this.j != null) {
                z = this.j.g;
            }
            cVar.h = z;
            cVar.a = i;
            this.k.a(cVar, j);
        }
    }

    public void a(byte[] bArr, int i, int i2, int i3, long j) {
        if (this.k != null) {
            this.k.a(bArr, i, i2, i3, j);
        }
    }

    public c(Context context, boolean z) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        TXCLog.i("TXCVideoPreprocessor", "TXCVideoPreprocessor version: VideoPreprocessor-v1.1");
        ConfigurationInfo deviceConfigurationInfo = activityManager.getDeviceConfigurationInfo();
        if (deviceConfigurationInfo != null) {
            TXCLog.i("TXCVideoPreprocessor", "opengl es version " + deviceConfigurationInfo.reqGlEsVersion);
            TXCLog.i("TXCVideoPreprocessor", "set GLContext " + z);
            if (deviceConfigurationInfo.reqGlEsVersion > WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                TXCLog.i("TXCVideoPreprocessor", "This devices is OpenGlUtils.OPENGL_ES_3");
                e.a(3);
            } else {
                TXCLog.i("TXCVideoPreprocessor", "This devices is OpenGlUtils.OPENGL_ES_2");
                e.a(2);
            }
        } else {
            TXCLog.e("TXCVideoPreprocessor", "getDeviceConfigurationInfo opengl Info failed!");
        }
        this.a = context;
        this.b = z;
        this.h = new b(this.a, this.b);
        a.a().a(context);
    }

    public void a(float[] fArr) {
        if (this.h != null) {
            this.h.a(fArr);
        }
    }

    public synchronized int a(byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        a(i, i2, m(i3), i4, i5);
        this.h.b(this.i);
        return this.h.a(bArr, i4);
    }

    public synchronized int a(int i, int i2, int i3, int i4, int i5, int i6) {
        a(i2, i3, m(i4), i5, i6);
        this.h.b(this.i);
        return this.h.a(i, i5);
    }

    public synchronized int a(com.tencent.liteav.basic.f.c cVar, int i, int i2) {
        a(cVar.j);
        a(cVar.f, cVar.g);
        a(cVar.h);
        a(cVar.i);
        a(cVar.c);
        return a(cVar.a, cVar.d, cVar.e, cVar.i, i, i2);
    }

    public synchronized void a(a aVar) {
        this.g = aVar;
    }

    public synchronized void a(int i, int i2) {
        this.d = i;
        this.e = i2;
    }

    public synchronized void a(int i) {
        this.f = i;
    }

    public synchronized void a(Bitmap bitmap, float f, float f2, float f3) {
        if (f < 0.0f || f2 < 0.0f || ((double) f3) < 0.0d) {
            TXCLog.e("TXCVideoPreprocessor", "WaterMark param is Error!");
        } else if (this.h != null) {
            this.h.a(bitmap, f, f2, f3);
        }
    }

    public synchronized void a(boolean z) {
        this.c = z;
    }

    public synchronized void a(d dVar) {
        if (this.h == null) {
            TXCLog.e("TXCVideoPreprocessor", "setListener mDrawer is null!");
        } else {
            this.h.a(dVar);
        }
    }

    public synchronized void a(e eVar) {
        if (this.h == null) {
            TXCLog.e("TXCVideoPreprocessor", "setListener mDrawer is null!");
        } else {
            this.k = eVar;
            if (eVar == null) {
                this.h.a(null);
            } else {
                this.h.a((d) this);
            }
        }
    }

    private int m(int i) {
        switch (i) {
            case 1:
                return 90;
            case 2:
                return 180;
            case 3:
                return 270;
            default:
                return i;
        }
    }

    private boolean a(int i, int i2, int i3, int i4, int i5) {
        if (this.j == null) {
            this.j = new b();
        }
        if (i != this.j.b || i2 != this.j.c || i3 != this.j.f || ((this.d > 0 && this.d != this.j.h) || ((this.e > 0 && this.e != this.j.i) || ((this.f > 0 && this.f != this.j.j) || ((this.g != null && ((this.g.c > 0 && (this.j.m == null || this.g.c != this.j.m.c)) || ((this.g.d > 0 && (this.j.m == null || this.g.d != this.j.m.d)) || ((this.g.a >= 0 && (this.j.m == null || this.g.a != this.j.m.a)) || (this.g.b >= 0 && (this.j.m == null || this.g.b != this.j.m.b)))))) || this.c != this.j.g))))) {
            TXCLog.i("TXCVideoPreprocessor", "Init sdk");
            TXCLog.i("TXCVideoPreprocessor", "Input widht " + i + " height " + i2);
            this.j.b = i;
            this.j.c = i2;
            if (this.g != null && this.g.a >= 0 && this.g.b >= 0 && this.g.c > 0 && this.g.d > 0) {
                int i6;
                TXCLog.i("TXCVideoPreprocessor", "set Crop Rect; init ");
                int i7 = i - this.g.a > this.g.c ? this.g.c : i - this.g.a;
                if (i2 - this.g.b > this.g.d) {
                    i6 = this.g.d;
                } else {
                    i6 = i2 - this.g.b;
                }
                this.g.c = i7;
                this.g.d = i6;
                i = this.g.c;
                i2 = this.g.d;
                this.j.m = this.g;
            }
            this.j.f = i3;
            this.j.a = this.b;
            this.j.k = i4;
            this.j.l = i5;
            if (true == this.l) {
                this.j.h = this.d;
                this.j.i = this.e;
            } else {
                this.j.h = 0;
                this.j.i = 0;
            }
            this.j.j = this.f;
            if (this.j.j <= 0) {
                this.j.j = 0;
            }
            if (this.j.h <= 0 || this.j.i <= 0) {
                if (90 == this.j.j || 270 == this.j.j) {
                    this.j.h = i2;
                    this.j.i = i;
                } else {
                    this.j.h = i;
                    this.j.i = i2;
                }
            }
            if (90 == this.j.j || 270 == this.j.j) {
                this.j.d = this.j.i;
                this.j.e = this.j.h;
            } else {
                this.j.d = this.j.h;
                this.j.e = this.j.i;
            }
            if (true != this.l) {
                this.j.h = this.d;
                this.j.i = this.e;
                if (this.j.h <= 0 || this.j.i <= 0) {
                    if (90 == this.j.j || 270 == this.j.j) {
                        this.j.h = i2;
                        this.j.i = i;
                    } else {
                        this.j.h = i;
                        this.j.i = i2;
                    }
                }
            }
            this.j.g = this.c;
            if (!a(this.j)) {
                TXCLog.e("TXCVideoPreprocessor", "init failed!");
                return false;
            }
        } else if (!(i4 == this.j.k && i5 == this.j.l)) {
            this.j.k = i4;
            this.i.k = i4;
            this.j.l = i5;
            this.i.l = i5;
            this.h.a(i5);
        }
        return true;
    }

    private boolean a(b bVar) {
        this.i.d = bVar.b;
        this.i.e = bVar.c;
        this.i.m = bVar.m;
        this.i.g = bVar.d;
        this.i.f = bVar.e;
        this.i.h = (bVar.f + 360) % 360;
        this.i.b = bVar.h;
        this.i.c = bVar.i;
        this.i.a = bVar.j;
        this.i.j = bVar.a;
        this.i.i = bVar.g;
        this.i.k = bVar.k;
        this.i.l = bVar.l;
        if (this.h == null) {
            this.h = new b(this.a, bVar.a);
        }
        return this.h.a(this.i);
    }

    public synchronized void a() {
        if (this.h != null) {
            this.h.a();
        }
        this.j = null;
    }

    public synchronized void b(int i) {
        if (this.h != null) {
            this.h.c(i);
        }
    }

    public synchronized void c(int i) {
        if (i > 9) {
            TXCLog.e("TXCVideoPreprocessor", "Beauty value too large! set max value 9");
            i = 9;
        } else if (i < 0) {
            TXCLog.e("TXCVideoPreprocessor", "Beauty < 0; set 0");
            i = 0;
        }
        if (this.h != null) {
            this.h.b(i);
        }
    }

    public synchronized void d(int i) {
        if (i > 9) {
            TXCLog.e("TXCVideoPreprocessor", "Brightness value too large! set max value 9");
            i = 9;
        } else if (i < 0) {
            TXCLog.e("TXCVideoPreprocessor", "Brightness < 0; set 0");
            i = 0;
        }
        if (this.h != null) {
            this.h.d(i);
        }
    }

    public synchronized void e(int i) {
        if (i > 9) {
            TXCLog.e("TXCVideoPreprocessor", "Ruddy value too large! set max value 9");
            i = 9;
        } else if (i < 0) {
            TXCLog.e("TXCVideoPreprocessor", "Ruddy < 0; set 0");
            i = 0;
        }
        if (this.h != null) {
            this.h.f(i);
        }
    }

    public void f(int i) {
        if (i > 9) {
            TXCLog.e("TXCVideoPreprocessor", "Brightness value too large! set max value 9");
            i = 9;
        } else if (i < 0) {
            TXCLog.e("TXCVideoPreprocessor", "Brightness < 0; set 0");
            i = 0;
        }
        if (this.h != null) {
            this.h.e(i);
        }
    }

    public synchronized void a(String str) {
        if (this.h != null) {
            this.h.a(str);
        }
    }

    @TargetApi(18)
    public boolean a(String str, boolean z) {
        if (VERSION.SDK_INT < 18) {
            return false;
        }
        if (this.h != null) {
            this.h.a(str, z);
        }
        return true;
    }

    public synchronized void g(int i) {
        if (this.h != null) {
            this.h.g(i);
        }
    }

    public synchronized void h(int i) {
        if (this.h != null) {
            this.h.h(i);
        }
    }

    public void i(int i) {
        if (this.h != null) {
            this.h.i(i);
        }
    }

    public void j(int i) {
        if (this.h != null) {
            this.h.j(i);
        }
    }

    public void k(int i) {
        if (this.h != null) {
            this.h.k(i);
        }
    }

    public void l(int i) {
        if (this.h != null) {
            this.h.l(i);
        }
    }

    public synchronized void a(float f) {
        if (this.h != null) {
            this.h.a(f);
        }
    }

    public synchronized void a(Bitmap bitmap) {
        if (this.h != null) {
            this.h.a(bitmap);
        }
    }
}
