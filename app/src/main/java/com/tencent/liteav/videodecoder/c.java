package com.tencent.liteav.videodecoder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.f.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.rtmp.TXLiveConstants;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class c implements a {
    private BufferInfo a = new BufferInfo();
    private MediaCodec b = null;
    private String c = "video/avc";
    private int d = 540;
    private int e = 960;
    private long f = 0;
    private long g = 0;
    private boolean h = true;
    private boolean i = false;
    private boolean j = false;
    private Surface k = null;
    private int l = 0;
    private int m = 0;
    private ArrayList<b> n = new ArrayList();
    private d o;
    private WeakReference<a> p;

    private void a() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:34:0x0021 in {10, 18, 20, 22, 24, 28, 30, 31, 32, 36, 37, 38, 39, 40} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r6 = this;
        r5 = 0;
        r0 = r6.b;
        if (r0 == 0) goto L_0x0032;
    L_0x0005:
        r0 = r6.b;	 Catch:{ Exception -> 0x0055, all -> 0x00a3 }
        r0.stop();	 Catch:{ Exception -> 0x0055, all -> 0x00a3 }
        r0 = "MediaCodecDecoder";	 Catch:{ Exception -> 0x0055, all -> 0x00a3 }
        r1 = "decode: stop decoder sucess";	 Catch:{ Exception -> 0x0055, all -> 0x00a3 }
        com.tencent.liteav.basic.log.TXCLog.w(r0, r1);	 Catch:{ Exception -> 0x0055, all -> 0x00a3 }
        r0 = r6.b;
        r0.release();
        r0 = "MediaCodecDecoder";
        r1 = "decode: release decoder sucess";
        com.tencent.liteav.basic.log.TXCLog.w(r0, r1);
        r6.b = r5;
    L_0x0023:
        r0 = r6.n;
        r0.clear();
        r0 = 0;
        r6.f = r0;
        r0 = 1;
        r6.h = r0;
        r0 = 0;
        r6.m = r0;
    L_0x0032:
        return;
    L_0x0033:
        r0 = move-exception;
        r1 = "MediaCodecDecoder";	 Catch:{ Exception -> 0x0033, all -> 0x0051 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0033, all -> 0x0051 }
        r3 = "decode: release decoder exception: ";	 Catch:{ Exception -> 0x0033, all -> 0x0051 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0033, all -> 0x0051 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0033, all -> 0x0051 }
        r0 = r2.append(r0);	 Catch:{ Exception -> 0x0033, all -> 0x0051 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0033, all -> 0x0051 }
        com.tencent.liteav.basic.log.TXCLog.e(r1, r0);	 Catch:{ Exception -> 0x0033, all -> 0x0051 }
        r6.b = r5;
        goto L_0x0023;
    L_0x0051:
        r0 = move-exception;
        r6.b = r5;
        throw r0;
    L_0x0055:
        r0 = move-exception;
        r1 = "MediaCodecDecoder";	 Catch:{ Exception -> 0x0055, all -> 0x00a3 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0055, all -> 0x00a3 }
        r3 = "decode: stop decoder Exception: ";	 Catch:{ Exception -> 0x0055, all -> 0x00a3 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0055, all -> 0x00a3 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0055, all -> 0x00a3 }
        r0 = r2.append(r0);	 Catch:{ Exception -> 0x0055, all -> 0x00a3 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0055, all -> 0x00a3 }
        com.tencent.liteav.basic.log.TXCLog.e(r1, r0);	 Catch:{ Exception -> 0x0055, all -> 0x00a3 }
        r0 = r6.b;
        r0.release();
        r0 = "MediaCodecDecoder";
        r1 = "decode: release decoder sucess";
        com.tencent.liteav.basic.log.TXCLog.w(r0, r1);
        r6.b = r5;
        goto L_0x0023;
    L_0x0081:
        r0 = move-exception;
        r1 = "MediaCodecDecoder";	 Catch:{ Exception -> 0x0081, all -> 0x009f }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0081, all -> 0x009f }
        r3 = "decode: release decoder exception: ";	 Catch:{ Exception -> 0x0081, all -> 0x009f }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0081, all -> 0x009f }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0081, all -> 0x009f }
        r0 = r2.append(r0);	 Catch:{ Exception -> 0x0081, all -> 0x009f }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0081, all -> 0x009f }
        com.tencent.liteav.basic.log.TXCLog.e(r1, r0);	 Catch:{ Exception -> 0x0081, all -> 0x009f }
        r6.b = r5;
        goto L_0x0023;
    L_0x009f:
        r0 = move-exception;
        r6.b = r5;
        throw r0;
    L_0x00a3:
        r0 = move-exception;
        r1 = r6.b;	 Catch:{ Exception -> 0x00b5, all -> 0x00d3 }
        r1.release();	 Catch:{ Exception -> 0x00b5, all -> 0x00d3 }
        r1 = "MediaCodecDecoder";	 Catch:{ Exception -> 0x00b5, all -> 0x00d3 }
        r2 = "decode: release decoder sucess";	 Catch:{ Exception -> 0x00b5, all -> 0x00d3 }
        com.tencent.liteav.basic.log.TXCLog.w(r1, r2);	 Catch:{ Exception -> 0x00b5, all -> 0x00d3 }
        r6.b = r5;
    L_0x00b4:
        throw r0;
    L_0x00b5:
        r1 = move-exception;
        r2 = "MediaCodecDecoder";	 Catch:{ Exception -> 0x00b5, all -> 0x00d3 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00b5, all -> 0x00d3 }
        r4 = "decode: release decoder exception: ";	 Catch:{ Exception -> 0x00b5, all -> 0x00d3 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x00b5, all -> 0x00d3 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x00b5, all -> 0x00d3 }
        r1 = r3.append(r1);	 Catch:{ Exception -> 0x00b5, all -> 0x00d3 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x00b5, all -> 0x00d3 }
        com.tencent.liteav.basic.log.TXCLog.e(r2, r1);	 Catch:{ Exception -> 0x00b5, all -> 0x00d3 }
        r6.b = r5;
        goto L_0x00b4;
    L_0x00d3:
        r0 = move-exception;
        r6.b = r5;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videodecoder.c.a():void");
    }

    public void setListener(d dVar) {
        this.o = dVar;
    }

    public void setNotifyListener(WeakReference<a> weakReference) {
        this.p = weakReference;
    }

    public int config(Surface surface) {
        if (surface == null) {
            return -1;
        }
        this.k = surface;
        return 0;
    }

    public void decode(b bVar) {
        boolean z = true;
        if (bVar.i != 1) {
            z = false;
        }
        a(z);
        this.n.add(bVar);
        while (!this.n.isEmpty()) {
            int size = this.n.size();
            b();
            if (size == this.n.size()) {
                return;
            }
        }
    }

    public int start(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z, boolean z2) {
        return a(byteBuffer, byteBuffer2, z2);
    }

    public void stop() {
        a();
    }

    public int getDecoderCacheNum() {
        return this.m;
    }

    private int a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z) {
        Exception exception;
        Exception exception2;
        int i = 1;
        int i2 = 0;
        try {
            if (this.b != null || this.k == null) {
                TXCLog.e("MediaCodecDecoder", "decode: init decoder error, can not init for decoder=" + this.b + ",surface=" + this.k);
                return -1;
            }
            this.j = z;
            if (this.j) {
                this.c = "video/hevc";
            } else {
                this.c = "video/avc";
            }
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(this.c, this.d, this.e);
            if (byteBuffer != null) {
                createVideoFormat.setByteBuffer("csd-0", byteBuffer);
            }
            if (byteBuffer2 != null) {
                createVideoFormat.setByteBuffer("csd-1", byteBuffer2);
            }
            this.b = MediaCodec.createDecoderByType(this.c);
            try {
                this.b.configure(createVideoFormat, this.k, null, 0);
                this.b.setVideoScalingMode(1);
                this.b.start();
                i = 4;
                TXCLog.w("MediaCodecDecoder", "decode: start decoder success, is hevc: " + this.j);
            } catch (Exception e) {
                exception = e;
                i2 = -1;
                exception2 = exception;
                if (this.b != null) {
                    try {
                        this.b.release();
                        TXCLog.w("MediaCodecDecoder", "decode: , decoder release success");
                    } catch (Exception e2) {
                        TXCLog.e("MediaCodecDecoder", "decode: , decoder release exception: " + exception2.toString());
                        TXCLog.e("MediaCodecDecoder", "decode: init decoder " + i + " step exception: " + exception2.toString());
                        f();
                        return i2;
                    } finally {
                        this.b = null;
                    }
                }
                TXCLog.e("MediaCodecDecoder", "decode: init decoder " + i + " step exception: " + exception2.toString());
                f();
                return i2;
            }
            try {
                this.l = 0;
                return 0;
            } catch (Exception e3) {
                exception2 = e3;
                if (this.b != null) {
                    this.b.release();
                    TXCLog.w("MediaCodecDecoder", "decode: , decoder release success");
                }
                TXCLog.e("MediaCodecDecoder", "decode: init decoder " + i + " step exception: " + exception2.toString());
                f();
                return i2;
            }
        } catch (Exception e4) {
            exception = e4;
            i = 0;
            i2 = -1;
            exception2 = exception;
            if (this.b != null) {
                this.b.release();
                TXCLog.w("MediaCodecDecoder", "decode: , decoder release success");
            }
            TXCLog.e("MediaCodecDecoder", "decode: init decoder " + i + " step exception: " + exception2.toString());
            f();
            return i2;
        }
    }

    @TargetApi(16)
    private void b() {
        if (this.b == null) {
            TXCLog.e("MediaCodecDecoder", "null decoder");
            return;
        }
        b bVar = (b) this.n.get(0);
        if (bVar == null || bVar.a.length == 0) {
            TXCLog.e("MediaCodecDecoder", "decode: empty buffer");
            this.n.remove(0);
            return;
        }
        ByteBuffer[] inputBuffers = this.b.getInputBuffers();
        if (inputBuffers == null || inputBuffers.length == 0) {
            TXCLog.e("MediaCodecDecoder", "decode: getInputBuffers failed");
            return;
        }
        int dequeueInputBuffer;
        int dequeueOutputBuffer;
        try {
            dequeueInputBuffer = this.b.dequeueInputBuffer(10000);
        } catch (Exception e) {
            TXCLog.e("MediaCodecDecoder", "decode: dequeueInputBuffer Exception!! " + e);
            dequeueInputBuffer = -10000;
        }
        if (dequeueInputBuffer >= 0) {
            inputBuffers[dequeueInputBuffer].put(bVar.a);
            this.b.queueInputBuffer(dequeueInputBuffer, 0, bVar.a.length, bVar.g, 0);
            this.n.remove(0);
            this.m++;
            if (this.f == 0) {
                TXCLog.w("MediaCodecDecoder", "decode: input buffer available, dequeueInputBuffer index: " + dequeueInputBuffer);
            }
        } else {
            TXCLog.w("MediaCodecDecoder", "decode: input buffer not available, dequeueInputBuffer failed");
        }
        try {
            dequeueOutputBuffer = this.b.dequeueOutputBuffer(this.a, 10000);
        } catch (Exception e2) {
            g();
            TXCLog.e("MediaCodecDecoder", "decode: dequeueOutputBuffer exception!!" + e2);
            dequeueOutputBuffer = -10000;
        }
        if (dequeueOutputBuffer >= 0) {
            a(dequeueOutputBuffer, this.a.presentationTimeUs, this.a.presentationTimeUs);
            if (this.m > 0) {
                this.m--;
            }
            this.l = 0;
        } else if (dequeueOutputBuffer == -1) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e3) {
            }
            TXCLog.d("MediaCodecDecoder", "decode: no output from decoder available when timeout");
            g();
        } else if (dequeueOutputBuffer == -3) {
            TXCLog.d("MediaCodecDecoder", "decode: output buffers changed");
        } else if (dequeueOutputBuffer == -2) {
            c();
        } else {
            TXCLog.e("MediaCodecDecoder", "decode: unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
        }
    }

    private void a(int i, long j, long j2) {
        this.b.releaseOutputBuffer(i, true);
        if ((this.a.flags & 4) != 0) {
            TXCLog.d("MediaCodecDecoder", "output EOS");
        }
        try {
            if (this.o != null) {
                this.o.a(null, this.d, this.e, j, j2);
            }
        } catch (Exception e) {
        }
        d();
    }

    private void c() {
        MediaFormat outputFormat = this.b.getOutputFormat();
        TXCLog.d("MediaCodecDecoder", "decode output format changed: " + outputFormat);
        int abs = Math.abs(outputFormat.getInteger("crop-right") - outputFormat.getInteger("crop-left")) + 1;
        int abs2 = Math.abs(outputFormat.getInteger("crop-bottom") - outputFormat.getInteger("crop-top")) + 1;
        int integer = outputFormat.getInteger("width");
        int integer2 = outputFormat.getInteger("height");
        abs = Math.min(abs, integer);
        integer2 = Math.min(abs2, integer2);
        if (abs != this.d || integer2 != this.e) {
            this.d = abs;
            this.e = integer2;
            try {
                if (this.o != null) {
                    this.o.a(this.d, this.e);
                }
            } catch (Exception e) {
            }
            TXCLog.d("MediaCodecDecoder", "decode: video size change to w:" + abs + ",h:" + integer2);
        } else if (this.h) {
            this.h = false;
            if (this.o != null) {
                this.o.a(this.d, this.e);
            }
        }
    }

    private void d() {
        if (this.f == 0) {
            TXCLog.w("MediaCodecDecoder", "decode first frame sucess");
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f > 0 && currentTimeMillis > this.f + 1000 && currentTimeMillis > this.g + 2000 && this.g != 0) {
            TXCLog.e("MediaCodecDecoder", "frame interval[" + (currentTimeMillis - this.f) + "] > 1000");
            this.g = currentTimeMillis;
        }
        if (this.g == 0) {
            this.g = currentTimeMillis;
        }
        this.f = currentTimeMillis;
    }

    private boolean e() {
        if (VERSION.SDK_INT < 21) {
            return false;
        }
        for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(1).getCodecInfos()) {
            for (String contains : mediaCodecInfo.getSupportedTypes()) {
                if (contains.contains("video/hevc")) {
                    TXCLog.e("MediaCodecDecoder", "decode: video/hevc MediaCodecInfo: " + mediaCodecInfo.getName() + ",encoder:" + mediaCodecInfo.isEncoder());
                    return true;
                }
            }
        }
        return false;
    }

    private void f() {
        if (!this.i) {
            TXCLog.w("MediaCodecDecoder", "decode hw decode error, hevc: " + this.j);
            if (this.j) {
                com.tencent.liteav.basic.util.a.a(this.p, TXLiveConstants.PLAY_ERR_HEVC_DECODE_FAIL, "h265解码失败");
            } else {
                com.tencent.liteav.basic.util.a.a(this.p, TXLiveConstants.PLAY_WARNING_HW_ACCELERATION_FAIL, "硬解启动失败，采用软解");
            }
            this.i = true;
        }
    }

    private void g() {
        if (this.l >= 40) {
            f();
            this.l = 0;
            return;
        }
        this.l++;
    }

    private void a(boolean z) {
        if (this.j != z) {
            this.j = z;
            if (!this.i) {
                if (!this.j || e()) {
                    a();
                    a(null, null, this.j);
                    return;
                }
                a();
                f();
            }
        }
    }
}
