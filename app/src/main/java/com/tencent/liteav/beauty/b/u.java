package com.tencent.liteav.beauty.b;

import android.content.res.AssetFileDescriptor;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.os.Handler;
import android.os.Looper;

public class u {
    private static final String b = u.class.getSimpleName();
    OnFrameAvailableListener a;
    private SurfaceTexture c;
    private int d = -1;
    private boolean e = false;
    private MediaExtractor f;
    private AssetFileDescriptor g;
    private int h = -1;
    private int i = -1;
    private int j = -1;
    private int k = -1;
    private long l;
    private MediaCodec m;
    private boolean n = false;
    private boolean o;
    private Handler p;
    private Object q = new Object();

    private void b() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:17:0x001f
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:248)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r3 = this;
        r2 = 0;
        r0 = r3.e;
        if (r0 == 0) goto L_0x001f;
    L_0x0005:
        r0 = 0;
        r3.e = r0;
        r0 = r3.f;
        if (r0 == 0) goto L_0x0013;
    L_0x000c:
        r0 = r3.f;
        r0.release();
        r3.f = r2;
    L_0x0013:
        r0 = r3.m;	 Catch:{ Exception -> 0x0028, all -> 0x0039 }
        r0.stop();	 Catch:{ Exception -> 0x0028, all -> 0x0039 }
        r0 = r3.m;
        r0.release();
        r3.m = r2;
    L_0x001f:
        return;
    L_0x0020:
        r0 = move-exception;
        r3.m = r2;
        goto L_0x001f;
    L_0x0024:
        r0 = move-exception;
        r3.m = r2;
        throw r0;
    L_0x0028:
        r0 = move-exception;
        r0 = r3.m;
        r0.release();
        r3.m = r2;
        goto L_0x001f;
    L_0x0031:
        r0 = move-exception;
        r3.m = r2;
        goto L_0x001f;
    L_0x0035:
        r0 = move-exception;
        r3.m = r2;
        throw r0;
    L_0x0039:
        r0 = move-exception;
        r1 = r3.m;	 Catch:{ Exception -> 0x0042, all -> 0x0046 }
        r1.release();	 Catch:{ Exception -> 0x0042, all -> 0x0046 }
        r3.m = r2;
    L_0x0041:
        throw r0;
    L_0x0042:
        r1 = move-exception;
        r3.m = r2;
        goto L_0x0041;
    L_0x0046:
        r0 = move-exception;
        r3.m = r2;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.beauty.b.u.b():void");
    }

    u() {
    }

    synchronized void a() {
        synchronized (this.q) {
            if (this.p != null) {
                if (Looper.myLooper() == this.p.getLooper()) {
                    c();
                } else {
                    Runnable 1 = new 1(this);
                    this.p.removeCallbacksAndMessages(null);
                    this.p.post(1);
                    this.p.getLooper().quitSafely();
                    while (true) {
                        try {
                            this.q.wait();
                            break;
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }
        }
    }

    private void c() {
        b();
        this.a = null;
        this.l = 0;
        this.o = false;
        if (this.c != null) {
            this.c.release();
            this.c = null;
        }
        synchronized (this.q) {
            if (this.p != null) {
                this.p.removeCallbacksAndMessages(null);
                this.p.getLooper().quit();
                this.p = null;
                this.q.notify();
            }
        }
        if (this.g != null) {
            try {
                this.g.close();
            } catch (Exception e) {
            }
            this.g = null;
        }
    }
}
