package com.tencent.liteav.videoencoder;

import android.os.Bundle;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.a;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.b.k;
import com.tencent.rtmp.TXLiveConstants;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.khronos.egl.EGLContext;

public class b extends a {
    private static Integer r = Integer.valueOf(1);
    private static final String u = b.class.getSimpleName();
    private static int v = 0;
    private c a = null;
    private d b = null;
    private WeakReference<com.tencent.liteav.basic.c.a> c = null;
    private int d = 0;
    private int e = 2;
    private int f = 1;
    private Timer g = null;
    private TimerTask h = null;
    private LinkedList<Runnable> i = new LinkedList();
    private TXSVideoEncoderParam j;
    private float k = 0.0f;
    private float l = 0.0f;
    private float m = 0.0f;
    private int n = 0;
    private int o = 0;
    private com.tencent.liteav.basic.d.b p;
    private com.tencent.liteav.basic.util.b q;
    private boolean s;
    private k t;

    static /* synthetic */ int j(b bVar) {
        int i = bVar.n + 1;
        bVar.n = i;
        return i;
    }

    public b(int i) {
        this.e = i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(TXSVideoEncoderParam tXSVideoEncoderParam) {
        this.j = tXSVideoEncoderParam;
        int i = 10000002;
        int c = com.tencent.liteav.basic.e.b.a().c();
        if (this.e == 1 && c != 0) {
            this.a = new a();
            this.f = 1;
            a(1008, "启动硬编", 1);
        } else if (this.e == 3 && tXSVideoEncoderParam.width == 720 && tXSVideoEncoderParam.height == 1280 && c != 0) {
            this.a = new a();
            this.f = 1;
            a(1008, "启动硬编", 1);
        } else {
            this.a = new TXCSWVideoEncoder();
            this.f = 2;
            a(1008, "启动软编", 2);
        }
        setStatusValue(4004, Long.valueOf((long) this.f));
        if (this.a != null) {
            if (this.b != null) {
                this.a.setListener(this.b);
            }
            if (this.d != 0) {
                this.a.setBitrate(this.d);
            }
            this.a.setID(getID());
            i = this.a.start(tXSVideoEncoderParam);
        }
        if (this.e == 3) {
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 0;
            this.o = com.tencent.liteav.basic.e.b.a().e();
            c();
        }
        return i;
    }

    public void setID(String str) {
        super.setID(str);
        if (this.a != null) {
            this.a.setID(str);
        }
        setStatusValue(4004, Long.valueOf((long) this.f));
    }

    public EGLContext a(int i, int i2) {
        if (!this.s) {
            this.s = true;
            synchronized (r) {
                StringBuilder stringBuilder = new StringBuilder("CVGLThread");
                Integer num = r;
                r = Integer.valueOf(r.intValue() + 1);
                this.q = new com.tencent.liteav.basic.util.b(stringBuilder.append(num).toString());
            }
            boolean[] zArr = new boolean[1];
            this.q.a(new 1(this, i, i2, zArr));
            if (zArr[0]) {
                return this.p.d();
            }
            return null;
        } else if (this.p != null) {
            return this.p.d();
        } else {
            return null;
        }
    }

    public void a(Runnable runnable) {
        if (this.q != null) {
            this.q.a(runnable);
        }
    }

    protected void b(Runnable runnable) {
        synchronized (this.i) {
            this.i.add(runnable);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(Queue<Runnable> queue) {
        synchronized (queue) {
            if (queue.isEmpty()) {
                return false;
            }
            Runnable runnable = (Runnable) queue.poll();
        }
    }

    public long a(byte[] bArr, int i, int i2, int i3, long j) {
        if (this.p == null) {
            return -1;
        }
        this.q.b(new 2(this, i2, i3, i, bArr, j));
        return 0;
    }

    public void a() {
        this.i.clear();
        if (this.a != null) {
            this.a.stop();
        }
        if (this.q != null) {
            this.q.b(new 3(this, this.t, this.p));
            this.q = null;
            this.t = null;
            this.p = null;
        }
        if (this.e == 3) {
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 0;
            d();
        }
        this.b = null;
        this.d = 0;
    }

    public long a(int i, int i2, int i3, long j) {
        do {
        } while (a(this.i));
        if (this.a != null) {
            return this.a.pushVideoFrame(i, i2, i3, j);
        }
        return 10000002;
    }

    public void a(com.tencent.liteav.basic.c.a aVar) {
        this.c = new WeakReference(aVar);
    }

    public void a(d dVar) {
        this.b = dVar;
        b(new 4(this));
    }

    public void a(int i) {
        this.d = i;
        b(new 5(this));
    }

    public long b() {
        if (this.a != null) {
            return this.a.getRealFPS();
        }
        return 0;
    }

    private void c() {
        if (this.h == null) {
            this.h = new a(this);
        }
        this.g = new Timer();
        this.g.schedule(this.h, 1000, 1000);
    }

    private void d() {
        if (this.g != null) {
            this.g.cancel();
            this.g = null;
        }
        if (this.h != null) {
            this.h = null;
        }
    }

    private void a(int i, String str) {
        if (this.c != null) {
            com.tencent.liteav.basic.c.a aVar = (com.tencent.liteav.basic.c.a) this.c.get();
            if (aVar != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("EVT_ID", i);
                bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str);
                aVar.onNotifyEvent(i, bundle);
            }
        }
    }

    private void a(int i, String str, int i2) {
        if (this.c != null) {
            com.tencent.liteav.basic.c.a aVar = (com.tencent.liteav.basic.c.a) this.c.get();
            if (aVar != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("EVT_ID", i);
                bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str);
                bundle.putInt("EVT_PARAM1", i2);
                aVar.onNotifyEvent(i, bundle);
            }
        }
    }

    private void e() {
        b(new 6(this));
        TXCLog.w("TXCVideoEncoder", "switchSWToHW");
    }
}
