package com.tencent.liteav.beauty;

import android.content.Context;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.a.a.c;
import com.tencent.liteav.beauty.c.a;

class b$a extends Handler {
    final /* synthetic */ b a;
    private String b = "EGLDrawThreadHandler";

    b$a(b bVar, Looper looper, Context context) {
        this.a = bVar;
        super(looper);
    }

    private void a(Object obj) {
        TXCLog.i(this.b, "come into InitEGL");
        a aVar = (a) obj;
        a();
        b.a(this.a, new com.tencent.liteav.beauty.a.a.a());
        b.a(this.a, new c(b.h(this.a), aVar.g, aVar.f, false));
        b.i(this.a).b();
        if (b.a(this.a, aVar)) {
            TXCLog.i(this.b, "come out InitEGL");
        } else {
            TXCLog.e(this.b, "initInternal failed!");
        }
    }

    public void a() {
        TXCLog.i(this.b, "come into releaseEGL");
        if (b.j(this.a) != null && b.j(this.a)[0] > 0) {
            GLES20.glDeleteBuffers(1, b.j(this.a), 0);
            b.a(this.a, null);
        }
        b.k(this.a);
        if (b.i(this.a) != null) {
            b.i(this.a).c();
            b.a(this.a, null);
        }
        if (b.h(this.a) != null) {
            b.h(this.a).a();
            b.a(this.a, null);
        }
        b.a(this.a, false);
        NativeLoad.getInstance();
        NativeLoad.nativeDeleteYuv2Yuv();
        TXCLog.i(this.b, "come out releaseEGL");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleMessage(Message message) {
        boolean z;
        super.handleMessage(message);
        switch (message.what) {
            case 0:
                a(message.obj);
                b.a(this.a, true);
                z = true;
                break;
            case 1:
                a();
                this.a.d.a();
                z = false;
                break;
            case 2:
                b.a(this.a, (byte[]) message.obj);
                z = false;
                break;
            case 3:
                b.b(this.a, message.arg1);
                z = true;
                break;
            case 4:
                b.a(this.a, (float) (((double) message.arg1) / 100.0d));
                if (b.a(this.a) != null) {
                    b.a(this.a).a(b.l(this.a));
                    z = false;
                    break;
                }
            case 5:
                b.b(this.a, (a) message.obj);
                z = false;
                break;
            case 7:
                b.a(this.a, b.c(this.a), b.d(this.a), b.m(this.a), message.arg1, message.arg2, ((Integer) message.obj).intValue());
                this.a.f.a();
                z = false;
                break;
        }
        z = false;
        synchronized (this) {
            if (true == z) {
                notify();
            }
        }
    }

    void b() {
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
    }
}
