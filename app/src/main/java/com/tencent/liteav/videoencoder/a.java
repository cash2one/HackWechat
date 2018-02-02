package com.tencent.liteav.videoencoder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.EncoderCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.d.f;
import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;

public class a extends c {
    private static final String a = a.class.getSimpleName();
    private ByteBuffer[] A;
    private byte[] B;
    private volatile long C;
    private long D;
    private long E;
    private int F;
    private int G;
    private boolean H;
    private int I;
    private int J;
    private long K;
    private int b;
    private long c;
    private long d;
    private long e;
    private long f;
    private int g;
    private boolean h;
    private boolean i;
    private long j;
    private long k;
    private long l;
    private long m;
    private long n;
    private long o;
    private long p;
    private MediaCodec q;
    private b r;
    private Runnable s;
    private Runnable t;
    private Runnable u;
    private ArrayDeque<Long> v;
    private com.tencent.liteav.basic.d.b w;
    private Surface x;
    private boolean y;
    private boolean z;

    public a() {
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.i = true;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = null;
        this.r = null;
        this.s = new 1(this);
        this.t = new 2(this);
        this.u = new 3(this);
        this.v = new ArrayDeque(10);
        this.x = null;
        this.y = true;
        this.z = true;
        this.A = null;
        this.B = null;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.r = new b("HWVideoEncoder");
    }

    public int start(TXSVideoEncoderParam tXSVideoEncoderParam) {
        super.start(tXSVideoEncoderParam);
        boolean[] zArr = new boolean[1];
        if (VERSION.SDK_INT < 18) {
            zArr[0] = false;
        } else {
            synchronized (this) {
                this.r.a(new 4(this, zArr, tXSVideoEncoderParam));
            }
        }
        if (!zArr[0]) {
            callDelegate(10000004);
        }
        if (zArr[0]) {
            return 0;
        }
        return 10000004;
    }

    public void stop() {
        this.z = true;
        synchronized (this) {
            this.r.a(new 5(this));
        }
    }

    public void setFPS(int i) {
        this.r.b(new 6(this, i));
    }

    public void setBitrate(int i) {
        this.b = i;
        this.r.b(new 7(this, i));
    }

    public long getRealFPS() {
        return this.d;
    }

    public long getRealBitrate() {
        return this.c;
    }

    public long pushVideoFrame(int i, int i2, int i3, long j) {
        if (this.z) {
            return 10000004;
        }
        if (this.mGLContextExternal != null) {
            if (this.mInputFilter == null) {
                this.mInputFilter = new c();
                this.mInputFilter.a(true);
                this.mInputFilter.a(g.e, g.a(f.a, false, false));
                if (!this.mInputFilter.a()) {
                    this.mInputFilter = null;
                    return 0;
                }
            }
            this.mInputFilter.a(i2, i3);
            GLES20.glViewport(0, 0, i2, i3);
            this.mInputFilter.b(i);
        }
        this.C = j;
        this.mInputTextureID = this.mInputFilter.l();
        this.r.b(this.u);
        return 0;
    }

    @TargetApi(16)
    private MediaFormat a(int i, int i2, int i3, int i4, int i5) {
        if (i == 0 || i2 == 0 || i3 == 0 || i4 == 0) {
            return null;
        }
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, i3 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        createVideoFormat.setInteger("frame-rate", i4);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("i-frame-interval", i5);
        return createVideoFormat;
    }

    @TargetApi(16)
    private MediaFormat a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = 0;
        MediaFormat a = a(i, i2, i3, i4, i5);
        if (a == null) {
            return null;
        }
        if (VERSION.SDK_INT >= 21) {
            MediaCodecInfo a2 = a("video/avc");
            if (a2 == null) {
                return a;
            }
            CodecCapabilities capabilitiesForType = a2.getCapabilitiesForType("video/avc");
            EncoderCapabilities encoderCapabilities = capabilitiesForType.getEncoderCapabilities();
            if (encoderCapabilities.isBitrateModeSupported(i6)) {
                a.setInteger("bitrate-mode", i6);
            } else if (encoderCapabilities.isBitrateModeSupported(2)) {
                a.setInteger("bitrate-mode", 2);
            }
            a.setInteger("complexity", ((Integer) encoderCapabilities.getComplexityRange().clamp(Integer.valueOf(5))).intValue());
            if (VERSION.SDK_INT >= 23) {
                CodecProfileLevel[] codecProfileLevelArr = capabilitiesForType.profileLevels;
                int length = codecProfileLevelArr.length;
                int i9 = 0;
                while (i8 < length) {
                    CodecProfileLevel codecProfileLevel = codecProfileLevelArr[i8];
                    if (codecProfileLevel.profile <= i7 && codecProfileLevel.profile > r0) {
                        i9 = codecProfileLevel.profile;
                        a.setInteger("profile", codecProfileLevel.profile);
                        a.setInteger("level", codecProfileLevel.level);
                    }
                    i8++;
                }
            }
        }
        return a;
    }

    @TargetApi(16)
    private static MediaCodecInfo a(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                for (String equalsIgnoreCase : codecInfoAt.getSupportedTypes()) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        return null;
    }

    private void a(long j) {
        this.v.add(Long.valueOf(j));
    }

    private long a() {
        Long l = (Long) this.v.poll();
        return l == null ? 0 : l.longValue();
    }

    private boolean a(Surface surface, int i, int i2) {
        if (surface == null) {
            return false;
        }
        EGLContext eGLContext = this.mGLContextExternal;
        if (eGLContext == null) {
            eGLContext = EGL10.EGL_NO_CONTEXT;
        }
        this.w = com.tencent.liteav.basic.d.b.a(null, eGLContext, surface, i, i2);
        if (this.w == null) {
            return false;
        }
        this.mEncodeFilter = new c();
        this.mEncodeFilter.a();
        return true;
    }

    private void b() {
        if (this.mInputFilter != null) {
            this.mInputFilter.d();
            this.mInputFilter = null;
        }
        if (this.mEncodeFilter != null) {
            this.mEncodeFilter.d();
            this.mEncodeFilter = null;
        }
        if (this.w != null) {
            this.w.c();
            this.w = null;
        }
    }

    @TargetApi(18)
    private boolean a(TXSVideoEncoderParam tXSVideoEncoderParam) {
        boolean z = true;
        this.z = false;
        this.y = false;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.A = null;
        this.B = null;
        this.C = 0;
        this.F = -1;
        this.G = tXSVideoEncoderParam.gop;
        this.H = tXSVideoEncoderParam.needEdit;
        this.v.clear();
        if (tXSVideoEncoderParam == null || tXSVideoEncoderParam.width == 0 || tXSVideoEncoderParam.height == 0 || tXSVideoEncoderParam.fps == 0 || tXSVideoEncoderParam.gop == 0) {
            this.y = true;
            return false;
        }
        int i;
        this.h = tXSVideoEncoderParam.annexb;
        this.i = tXSVideoEncoderParam.appendSpsPps;
        if (this.b == 0) {
            this.b = (int) (Math.sqrt((((double) (tXSVideoEncoderParam.width * tXSVideoEncoderParam.width)) * 1.0d) + ((double) (tXSVideoEncoderParam.height * tXSVideoEncoderParam.height))) * 1.2d);
        }
        this.j = (long) this.b;
        this.g = tXSVideoEncoderParam.fps;
        this.G = tXSVideoEncoderParam.gop;
        switch (tXSVideoEncoderParam.encoderMode) {
            case 1:
                i = 2;
                break;
            case 2:
                i = 1;
                break;
            case 3:
                i = 0;
                break;
            default:
                i = 2;
                break;
        }
        if (com.tencent.liteav.basic.e.b.a().c() == 1) {
            tXSVideoEncoderParam.encoderProfile = 1;
        }
        try {
            MediaFormat a = a(tXSVideoEncoderParam.width, tXSVideoEncoderParam.height, this.b, tXSVideoEncoderParam.fps, tXSVideoEncoderParam.gop, i, 1);
            if (a == null) {
                this.y = true;
                return false;
            }
            this.q = MediaCodec.createEncoderByType("video/avc");
            try {
                this.q.configure(a, null, null, 1);
            } catch (Exception e) {
                if ((e instanceof IllegalArgumentException) || (VERSION.SDK_INT >= 21 && (e instanceof CodecException))) {
                    this.q.configure(a(tXSVideoEncoderParam.width, tXSVideoEncoderParam.height, this.b, tXSVideoEncoderParam.fps, tXSVideoEncoderParam.gop), null, null, 1);
                } else {
                    throw e;
                }
            } catch (Exception e2) {
                if (z >= true && this.q != null) {
                    this.q.stop();
                }
                this.q = null;
                if (this.x != null) {
                    this.x.release();
                }
                this.x = null;
                if (this.q != null) {
                }
                this.y = true;
                return false;
            }
            z = true;
            this.x = this.q.createInputSurface();
            this.q.start();
            this.A = this.q.getOutputBuffers();
            if (this.q != null || this.A == null || this.x == null) {
                this.y = true;
                return false;
            } else if (a(this.x, tXSVideoEncoderParam.width, tXSVideoEncoderParam.height)) {
                this.mInit = true;
                this.r.a(this.s, 1);
                return true;
            } else {
                this.y = true;
                return false;
            }
        } catch (Exception e3) {
            z = true;
            this.q.stop();
            this.q = null;
            if (this.x != null) {
                this.x.release();
            }
            this.x = null;
            if (this.q != null) {
            }
            this.y = true;
            return false;
        }
    }

    private void c() {
        if (this.q != null) {
            BufferInfo bufferInfo = new BufferInfo();
            try {
                int dequeueOutputBuffer = this.q.dequeueOutputBuffer(bufferInfo, 5000);
                if (dequeueOutputBuffer != -1) {
                    if (dequeueOutputBuffer == -3) {
                        this.A = this.q.getOutputBuffers();
                    } else if (dequeueOutputBuffer == -2) {
                        callDelegate(this.q.getOutputFormat());
                    } else if (dequeueOutputBuffer < 0) {
                        this.y = true;
                        this.r.b(this.t);
                        callDelegate(10000005);
                        return;
                    } else {
                        if (this.H) {
                            f();
                        }
                        ByteBuffer byteBuffer = this.A[dequeueOutputBuffer];
                        if (byteBuffer == null) {
                            this.y = true;
                            this.r.b(this.t);
                            callDelegate(10000005);
                        } else {
                            byte[] bArr;
                            Object obj;
                            Object obj2 = new byte[bufferInfo.size];
                            byteBuffer.position(bufferInfo.offset);
                            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                            byteBuffer.get(obj2, 0, bufferInfo.size);
                            int length = obj2.length;
                            if (bufferInfo.size > 5 && obj2[0] == (byte) 0 && obj2[1] == (byte) 0 && obj2[2] == (byte) 0 && obj2[3] == (byte) 0 && obj2[4] == (byte) 0 && obj2[5] == (byte) 0) {
                                int i = 3;
                                while (i < length - 4) {
                                    if (obj2[i] == (byte) 0 && obj2[i + 1] == (byte) 0 && obj2[i + 2] == (byte) 0 && obj2[i + 3] == (byte) 1) {
                                        length -= i;
                                        break;
                                    }
                                    i++;
                                }
                                i = 0;
                                Object obj3 = new byte[length];
                                System.arraycopy(obj2, i, obj3, 0, length);
                                bArr = obj3;
                            } else {
                                obj = obj2;
                            }
                            if (bufferInfo.size == 0) {
                                this.y = true;
                                this.r.b(this.t);
                                callDelegate(10000005);
                            } else {
                                int i2 = 1;
                                if ((bufferInfo.flags & 2) != 2) {
                                    byte[] bArr2;
                                    if ((bufferInfo.flags & 1) == 1) {
                                        i2 = 0;
                                        this.F = -1;
                                        if (this.h) {
                                            bArr2 = new byte[(this.B.length + bArr.length)];
                                            System.arraycopy(this.B, 0, bArr2, 0, this.B.length);
                                            System.arraycopy(bArr, 0, bArr2, this.B.length, bArr.length);
                                        } else {
                                            obj = a(bArr);
                                            bArr2 = new byte[(this.B.length + obj.length)];
                                            System.arraycopy(this.B, 0, bArr2, 0, this.B.length);
                                            System.arraycopy(obj, 0, bArr2, this.B.length, obj.length);
                                        }
                                    } else if (this.h) {
                                        bArr2 = bArr;
                                    } else {
                                        bArr2 = a(bArr);
                                    }
                                    length = this.F + 1;
                                    this.F = length;
                                    if (length == this.g * this.G) {
                                        f();
                                    }
                                    long a = a();
                                    long j = bufferInfo.presentationTimeUs / 1000;
                                    if (this.E == 0) {
                                        this.E = a;
                                    }
                                    if (this.D == 0) {
                                        this.D = j;
                                    }
                                    long j2 = j + (this.E - this.D);
                                    if (a <= this.n) {
                                        a = this.n + 1;
                                    }
                                    if (a > j2) {
                                        a = j2;
                                    }
                                    this.n = a;
                                    a = TXCTimeUtil.getTimeTick();
                                    if (i2 == 0) {
                                        if (a > this.e + 1000) {
                                            this.c = (long) (((((double) this.o) * 8000.0d) / ((double) (a - this.e))) / 1024.0d);
                                            this.o = 0;
                                            this.e = a;
                                        }
                                        this.k++;
                                        this.l = 0;
                                    } else {
                                        this.l++;
                                    }
                                    this.o += (long) bArr2.length;
                                    if (a > this.f + 2000) {
                                        this.d = (long) ((((double) this.p) * 1000.0d) / ((double) (a - this.f)));
                                        this.p = 0;
                                        this.f = a;
                                    }
                                    this.p++;
                                    byteBuffer.position(bufferInfo.offset);
                                    if (this.i) {
                                        callDelegate(bArr2, i2, this.k, this.l, this.m, i2 == 0 ? 0 : this.l - 1, j2, j2, 0, byteBuffer, bufferInfo);
                                    } else {
                                        callDelegate(obj2, i2, this.k, this.l, this.m, i2 == 0 ? 0 : this.l - 1, j2, j2, 0, byteBuffer, bufferInfo);
                                    }
                                    this.m++;
                                    if ((bufferInfo.flags & 4) != 0) {
                                        this.y = true;
                                        this.r.b(this.t);
                                    }
                                } else if (this.h) {
                                    this.B = (byte[]) bArr.clone();
                                } else {
                                    this.B = a((byte[]) bArr.clone());
                                }
                            }
                        }
                        try {
                            this.q.releaseOutputBuffer(dequeueOutputBuffer, false);
                        } catch (IllegalStateException e) {
                        }
                    }
                    if (!this.y) {
                        this.r.b(this.s);
                    }
                } else if (!this.y) {
                    this.r.a(this.s, 10);
                }
            } catch (IllegalStateException e2) {
                this.y = true;
                this.r.b(this.t);
                callDelegate(10000005);
            }
        } else if (!this.y) {
            this.r.a(this.s, 10);
        }
    }

    private byte[] a(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[(length + 20)];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            if (bArr[i] == (byte) 0 && bArr[i + 1] == (byte) 0 && bArr[i + 2] == (byte) 1) {
                i3 = a(i, i2, bArr2, bArr, i3);
                i += 3;
                i2 = i;
            } else if (bArr[i] == (byte) 0 && bArr[i + 1] == (byte) 0 && bArr[i + 2] == (byte) 0 && bArr[i + 3] == (byte) 1) {
                i3 = a(i, i2, bArr2, bArr, i3);
                i += 4;
                i2 = i;
            }
            if (i == length - 4 && (bArr[i + 1] != (byte) 0 || bArr[i + 2] != (byte) 0 || bArr[i + 3] != (byte) 1)) {
                i = length;
                break;
            }
            i++;
        }
        int a = a(i, i2, bArr2, bArr, i3);
        Object obj = new byte[a];
        System.arraycopy(bArr2, 0, obj, 0, a);
        return obj;
    }

    private int a(int i, int i2, byte[] bArr, byte[] bArr2, int i3) {
        if (i2 <= 0 || i <= i2) {
            return i3;
        }
        int i4 = i - i2;
        ByteBuffer wrap = ByteBuffer.wrap(new byte[4]);
        wrap.asIntBuffer().put(i4);
        wrap.order(ByteOrder.BIG_ENDIAN);
        System.arraycopy(wrap.array(), 0, bArr, i3, 4);
        System.arraycopy(bArr2, i2, bArr, i3 + 4, i4);
        return i3 + (i4 + 4);
    }

    @TargetApi(18)
    private void d() {
        if (!this.y && this.C != 0 && this.w != null) {
            this.w.b();
            GLES20.glClear(16640);
            if (this.mGLContextExternal == null) {
                GLES20.glClearColor(0.1f, 0.3f, ((float) (this.m % 255)) / 255.0f, 1.0f);
                GLES20.glEnable(3042);
                GLES20.glBlendFunc(770, 771);
            } else {
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            }
            GLES20.glViewport(0, 0, this.mOutputWidth, this.mOutputHeight);
            this.mEncodeFilter.a(this.mInputTextureID);
            GLES20.glDisable(3042);
            a(this.C);
            this.w.a();
            this.C = 0;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e() {
        this.y = true;
        this.z = true;
        b();
        if (this.q != null) {
            try {
                if (VERSION.SDK_INT >= 18) {
                    this.q.signalEndOfInputStream();
                }
                this.q.stop();
                try {
                    this.q.release();
                } catch (Exception e) {
                }
            } catch (IllegalStateException e2) {
            } catch (Throwable th) {
                try {
                    this.q.release();
                } catch (Exception e3) {
                }
            }
        }
        this.q = null;
        this.mInputTextureID = -1;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.mGLContextExternal = null;
        this.A = null;
        this.B = null;
        this.C = 0;
        this.mOutputWidth = 0;
        this.mOutputHeight = 0;
        this.mInit = false;
        this.v.clear();
    }

    private void a(int i) {
        if (this.j != ((long) this.b)) {
            this.j = (long) this.b;
            if (VERSION.SDK_INT >= 19 && this.q != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("video-bitrate", this.b * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                this.q.setParameters(bundle);
            }
        }
    }

    private void f() {
        if (VERSION.SDK_INT >= 19 && this.q != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("request-sync", 0);
            this.q.setParameters(bundle);
            TXCLog.w(a, "P帧间隔异常,强制I帧");
        }
    }

    private void b(int i) {
    }
}
