package com.tencent.liteav.audio.impl.Record;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.liteav.audio.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Vector;

public class e extends Thread {
    private BufferInfo a;
    private MediaCodecInfo b;
    private MediaFormat c;
    private MediaCodec d;
    private Vector<byte[]> e;
    private WeakReference<com.tencent.liteav.audio.e> f;
    private volatile boolean g = false;
    private volatile boolean h = false;
    private final Object i = new Object();
    private long j = 0;
    private int k = c.a;
    private int l = c.b;
    private int m = c.c;
    private byte[] n;

    static {
        a.d();
    }

    @TargetApi(16)
    public e() {
        super("TXAudioRecordThread");
    }

    public void a(int i, int i2, int i3, int i4, WeakReference<com.tencent.liteav.audio.e> weakReference) {
        this.f = weakReference;
        this.a = new BufferInfo();
        this.e = new Vector();
        this.k = i2;
        this.l = i3;
        this.m = i4;
        b();
    }

    public void a(byte[] bArr, long j) {
        if (!(this.e == null || bArr == null)) {
            synchronized (this.e) {
                if (this.e == null) {
                    return;
                }
                this.e.add(bArr);
            }
        }
        synchronized (this.i) {
            this.i.notify();
        }
    }

    public void a() {
        c();
    }

    private void b() {
        int i = 32000;
        this.b = a("audio/mp4a-latm");
        if (this.b == null) {
            TXCLog.e("AudioCenter:TXCAudioHWEncoder", "Unable to find an appropriate codec for audio/mp4a-latm");
            return;
        }
        TXCLog.i("AudioCenter:TXCAudioHWEncoder", "selected codec: " + this.b.getName());
        if (this.k >= 32000) {
            i = 64000;
        }
        this.c = MediaFormat.createAudioFormat("audio/mp4a-latm", this.k, this.l);
        this.c.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, i);
        this.c.setInteger("channel-count", this.l);
        this.c.setInteger("sample-rate", this.k);
        this.c.setInteger("aac-profile", 2);
        TXCLog.i("AudioCenter:TXCAudioHWEncoder", "format: " + this.c);
        try {
            d();
        } catch (Exception e) {
        }
        start();
    }

    private void c() {
        this.h = true;
    }

    @TargetApi(16)
    private void d() {
        if (this.d == null) {
            this.d = MediaCodec.createEncoderByType("audio/mp4a-latm");
            this.d.configure(this.c, null, null, 1);
            this.d.start();
            TXCLog.i("AudioCenter:TXCAudioHWEncoder", "prepare finishing");
            this.g = true;
        }
    }

    private void e() {
        if (this.d != null) {
            this.d.stop();
            this.d.release();
            this.d = null;
        }
        this.g = false;
    }

    public void run() {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        while (!this.h) {
            if (this.g) {
                boolean isEmpty;
                synchronized (this.e) {
                    isEmpty = this.e.isEmpty();
                }
                if (isEmpty) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                } else {
                    byte[] bArr;
                    synchronized (this.e) {
                        bArr = (byte[]) this.e.remove(0);
                    }
                    ByteBuffer byteBuffer;
                    if (bArr != null) {
                        try {
                            allocateDirect.clear();
                            if (bArr.length > allocateDirect.capacity()) {
                                allocateDirect = ByteBuffer.allocateDirect(bArr.length);
                            }
                            allocateDirect.clear();
                            allocateDirect.put(bArr);
                            allocateDirect.flip();
                            a(allocateDirect, bArr.length, f());
                        } catch (Exception e2) {
                            byteBuffer = allocateDirect;
                        }
                    } else {
                        byteBuffer = allocateDirect;
                        allocateDirect = byteBuffer;
                    }
                }
            } else {
                synchronized (this.i) {
                    try {
                        this.i.wait();
                    } catch (InterruptedException e3) {
                    }
                }
            }
        }
        e();
    }

    private void a(ByteBuffer byteBuffer, int i, long j) {
        if (!this.h) {
            ByteBuffer[] inputBuffers = this.d.getInputBuffers();
            int dequeueInputBuffer = this.d.dequeueInputBuffer(10000);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
                byteBuffer2.clear();
                if (byteBuffer != null) {
                    byteBuffer2.put(byteBuffer);
                }
                if (i <= 0) {
                    TXCLog.i("AudioCenter:TXCAudioHWEncoder", "send BUFFER_FLAG_END_OF_STREAM");
                    this.d.queueInputBuffer(dequeueInputBuffer, 0, 0, j, 4);
                } else {
                    this.d.queueInputBuffer(dequeueInputBuffer, 0, i, j, 0);
                }
            }
            inputBuffers = this.d.getOutputBuffers();
            do {
                dequeueInputBuffer = this.d.dequeueOutputBuffer(this.a, 10000);
                if (dequeueInputBuffer != -1) {
                    if (dequeueInputBuffer == -3) {
                        inputBuffers = this.d.getOutputBuffers();
                        continue;
                    } else if (dequeueInputBuffer == -2) {
                        this.d.getOutputFormat();
                        continue;
                    } else if (dequeueInputBuffer >= 0) {
                        ByteBuffer byteBuffer3 = inputBuffers[dequeueInputBuffer];
                        if ((this.a.flags & 2) != 0) {
                            TXCLog.d("AudioCenter:TXCAudioHWEncoder", "drain:BUFFER_FLAG_CODEC_CONFIG");
                            this.a.size = 0;
                        }
                        if (this.a.size != 0) {
                            this.a.presentationTimeUs = f();
                            this.n = new byte[byteBuffer3.limit()];
                            byteBuffer3.get(this.n);
                            b(this.n, this.a.presentationTimeUs);
                            this.j = this.a.presentationTimeUs;
                        }
                        this.d.releaseOutputBuffer(dequeueInputBuffer, false);
                        continue;
                    } else {
                        continue;
                    }
                }
            } while (dequeueInputBuffer >= 0);
        }
    }

    private long f() {
        long timeTick = TXCTimeUtil.getTimeTick();
        if (timeTick < this.j) {
            return timeTick + (this.j - timeTick);
        }
        return timeTick;
    }

    private static final MediaCodecInfo a(String str) {
        TXCLog.v("AudioCenter:TXCAudioHWEncoder", "selectAudioCodec:");
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (int i2 = 0; i2 < supportedTypes.length; i2++) {
                    TXCLog.i("AudioCenter:TXCAudioHWEncoder", "supportedType:" + codecInfoAt.getName() + ",MIME=" + supportedTypes[i2]);
                    if (supportedTypes[i2].equalsIgnoreCase(str)) {
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        return null;
    }

    private void b(byte[] bArr, long j) {
        if (this.f != null) {
            com.tencent.liteav.audio.e eVar = (com.tencent.liteav.audio.e) this.f.get();
            if (eVar != null) {
                eVar.b(bArr, j, this.k, this.l, this.m);
            }
        }
    }
}
