package com.tencent.liteav.audio.impl.Play;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.wcdb.FileUtils;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class a implements Runnable {
    private static final String a = ("AudioCenter:" + a.class.getSimpleName());
    private WeakReference<d> b = null;
    private MediaCodec c = null;
    private BufferInfo d;
    private MediaFormat e;
    private long f = 0;
    private volatile boolean g = false;
    private Vector<com.tencent.liteav.basic.f.a> h;
    private List i;
    private Thread j = null;

    public void a(WeakReference<d> weakReference) {
        if (this.g) {
            b();
        }
        this.b = weakReference;
        this.f = 0;
        this.h = new Vector();
        this.i = new ArrayList();
        this.g = true;
        this.j = new Thread(this);
        this.j.setName(a);
        this.j.start();
    }

    public void a(com.tencent.liteav.basic.f.a aVar) {
        if (this.g) {
            synchronized (this.h) {
                if (this.h != null) {
                    this.h.add(aVar);
                }
            }
        }
    }

    public long a() {
        if (this.e == null) {
            return 0;
        }
        float integer = (float) this.e.getInteger("sample-rate");
        if (integer != 0.0f) {
            return (long) (((((float) this.i.size()) * 1024.0f) * 1000.0f) / integer);
        }
        return 0;
    }

    public void b() {
        this.g = false;
        if (this.j != null) {
            try {
                this.j.join();
            } catch (InterruptedException e) {
            }
            this.j = null;
        }
    }

    public void run() {
        Object e;
        while (this.g) {
            int i;
            synchronized (this.h) {
                boolean isEmpty = this.h.isEmpty();
            }
            if (isEmpty) {
                try {
                    Thread.sleep(10);
                } catch (Exception e2) {
                }
            } else {
                int i2;
                ByteBuffer[] byteBufferArr;
                com.tencent.liteav.basic.f.a aVar;
                if (this.c != null) {
                    try {
                        ByteBuffer[] inputBuffers = this.c.getInputBuffers();
                        i = 1;
                        try {
                            i = this.c.dequeueInputBuffer(10000);
                            if (i >= 0) {
                                i2 = i;
                                byteBufferArr = inputBuffers;
                            } else {
                                return;
                            }
                        } catch (Exception e3) {
                            e = e3;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        i = 0;
                    }
                } else {
                    byteBufferArr = null;
                    i2 = -1;
                }
                synchronized (this.h) {
                    aVar = (com.tencent.liteav.basic.f.a) this.h.remove(0);
                }
                if (aVar.d == com.tencent.liteav.basic.a.a.k) {
                    b(aVar);
                } else if (aVar.d == com.tencent.liteav.basic.a.a.l) {
                    this.i.add(new Long(aVar.e));
                    a(aVar, byteBufferArr, i2);
                } else {
                    TXCLog.e(a, "not support audio format");
                }
            }
        }
        if (this.c != null) {
            this.c.stop();
            this.c.release();
            this.c = null;
            return;
        }
        return;
        TXCLog.e(a, "Exception. step: " + i + ", error: " + e);
    }

    private int b(com.tencent.liteav.basic.f.a aVar) {
        Object e;
        int i;
        CodecException e2;
        Object e3;
        if (aVar.f.length != 2) {
            TXCLog.w(a, "aac seq header len not equal to 2 , with len " + aVar.f.length);
        }
        if (aVar.f == null) {
            return TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
        }
        int a = com.tencent.liteav.audio.impl.a.a(((aVar.f[0] & 7) << 1) | ((aVar.f[1] & FileUtils.S_IWUSR) >> 7));
        int i2 = (aVar.f[1] & 120) >> 3;
        this.e = MediaFormat.createAudioFormat("audio/mp4a-latm", a, i2);
        this.e.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, 64000);
        this.e.setInteger("is-adts", 0);
        this.e.setInteger("aac-profile", 2);
        TXCLog.i(a, "audio decoder media format: " + this.e);
        if (this.b != null) {
            d dVar = (d) this.b.get();
            com.tencent.liteav.basic.f.a aVar2 = new com.tencent.liteav.basic.f.a();
            aVar2.c = com.tencent.liteav.basic.a.a.h;
            aVar2.b = i2;
            aVar2.a = a;
            if (dVar != null) {
                dVar.onPlayAudioInfoChanged(aVar2, aVar2);
            }
        }
        if (this.c != null) {
            try {
                this.c.stop();
                try {
                    this.c.release();
                } catch (Exception e4) {
                    e = e4;
                    a = 1;
                    TXCLog.e(a, "hw audio decoder release error: " + a + ". error: " + e);
                    this.c = MediaCodec.createDecoderByType("audio/mp4a-latm");
                    if (VERSION.SDK_INT >= 21) {
                        i = 0;
                        while (true) {
                            try {
                                this.c.configure(this.e, null, null, 0);
                                try {
                                    this.c.start();
                                    break;
                                } catch (CodecException e5) {
                                    e2 = e5;
                                    i2 = 1;
                                }
                            } catch (CodecException e6) {
                                e2 = e6;
                                i2 = 0;
                                TXCLog.e(a, "CodecException: " + e2 + ". step: " + i2 + ", mediaformat: " + this.e);
                                i++;
                                if (i > 1) {
                                    TXCLog.e(a, "decoder start error!");
                                    this.c.release();
                                    this.c = null;
                                    return TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE;
                                } else if (e2.isRecoverable()) {
                                    try {
                                        this.c.stop();
                                    } catch (Exception e7) {
                                    }
                                } else if (e2.isTransient()) {
                                    try {
                                        Thread.sleep(20);
                                    } catch (InterruptedException e8) {
                                    }
                                } else {
                                    TXCLog.e(a, "decoder cath unrecoverable error!");
                                    this.c.release();
                                    this.c = null;
                                    return TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE;
                                }
                            }
                        }
                    }
                    i = 0;
                    while (true) {
                        try {
                            this.c.configure(this.e, null, null, 0);
                            try {
                                this.c.start();
                                break;
                            } catch (IllegalStateException e9) {
                                e3 = e9;
                                i2 = 1;
                            }
                        } catch (IllegalStateException e10) {
                            e3 = e10;
                            i2 = 0;
                            TXCLog.e(a, "CodecException1: " + e3 + ". step: " + i2);
                            i++;
                            if (i > 1) {
                                TXCLog.e(a, "decoder start error!");
                                this.c.release();
                                this.c = null;
                                return TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE;
                            }
                            try {
                                this.c.reset();
                            } catch (Exception e11) {
                            }
                        }
                    }
                    if (this.c != null) {
                        a(aVar, this.c.getInputBuffers(), this.c.dequeueInputBuffer(10000));
                    }
                    return TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
                }
            } catch (Exception e12) {
                e = e12;
                a = 0;
                TXCLog.e(a, "hw audio decoder release error: " + a + ". error: " + e);
                this.c = MediaCodec.createDecoderByType("audio/mp4a-latm");
                if (VERSION.SDK_INT >= 21) {
                    i = 0;
                    while (true) {
                        this.c.configure(this.e, null, null, 0);
                        this.c.start();
                    }
                } else {
                    i = 0;
                    while (true) {
                        this.c.configure(this.e, null, null, 0);
                        this.c.start();
                    }
                }
                if (this.c != null) {
                    a(aVar, this.c.getInputBuffers(), this.c.dequeueInputBuffer(10000));
                }
                return TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
            }
        }
        try {
            this.c = MediaCodec.createDecoderByType("audio/mp4a-latm");
        } catch (IOException e13) {
            TXCLog.e(a, "createDecoderByType exception: " + e13.getMessage());
        }
        if (VERSION.SDK_INT >= 21) {
            i = 0;
            while (true) {
                this.c.configure(this.e, null, null, 0);
                this.c.start();
            }
        } else {
            i = 0;
            while (true) {
                this.c.configure(this.e, null, null, 0);
                this.c.start();
            }
        }
        if (this.c != null) {
            a(aVar, this.c.getInputBuffers(), this.c.dequeueInputBuffer(10000));
        }
        return TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
    }

    private int a(com.tencent.liteav.basic.f.a aVar, ByteBuffer[] byteBufferArr, int i) {
        if (i >= 0) {
            try {
                if (aVar.f != null) {
                    ByteBuffer byteBuffer = byteBufferArr[i];
                    byteBuffer.clear();
                    byteBuffer.put(aVar.f);
                }
                if (aVar == null || aVar.f.length <= 0) {
                    this.c.queueInputBuffer(i, 0, 0, c(), 4);
                } else {
                    this.c.queueInputBuffer(i, 0, aVar.f.length, c(), 0);
                }
            } catch (Exception e) {
            }
        } else if (i == -1) {
            return -1;
        }
        ByteBuffer[] outputBuffers = this.c.getOutputBuffers();
        if (this.d == null) {
            this.d = new BufferInfo();
        }
        int dequeueOutputBuffer;
        do {
            ByteBuffer[] byteBufferArr2 = outputBuffers;
            dequeueOutputBuffer = this.c.dequeueOutputBuffer(this.d, 10000);
            if (dequeueOutputBuffer == -3) {
                outputBuffers = this.c.getOutputBuffers();
                continue;
            } else {
                d dVar;
                if (dequeueOutputBuffer == -2) {
                    this.e = this.c.getOutputFormat();
                    if (this.b != null) {
                        dVar = (d) this.b.get();
                        com.tencent.liteav.basic.f.a aVar2 = new com.tencent.liteav.basic.f.a();
                        aVar2.c = com.tencent.liteav.basic.a.a.h;
                        aVar2.b = this.e.getInteger("channel-count");
                        aVar2.a = this.e.getInteger("sample-rate");
                        if (dVar != null) {
                            dVar.onPlayAudioInfoChanged(aVar2, aVar2);
                        }
                        outputBuffers = byteBufferArr2;
                        continue;
                    }
                } else if (dequeueOutputBuffer >= 0) {
                    byteBuffer = byteBufferArr2[dequeueOutputBuffer];
                    byteBuffer.position(this.d.offset);
                    byteBuffer.limit(this.d.offset + this.d.size);
                    byte[] bArr = new byte[this.d.size];
                    byteBuffer.get(bArr);
                    long longValue = ((Long) this.i.get(0)).longValue();
                    this.i.remove(0);
                    if (this.b != null) {
                        dVar = (d) this.b.get();
                        if (dVar != null) {
                            dVar.onPlayPcmData(bArr, longValue);
                        }
                    }
                    this.c.releaseOutputBuffer(dequeueOutputBuffer, false);
                }
                outputBuffers = byteBufferArr2;
                continue;
            }
        } while (dequeueOutputBuffer >= 0);
        return TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
    }

    private long c() {
        long timeTick = TXCTimeUtil.getTimeTick();
        if (timeTick < this.f) {
            timeTick += this.f - timeTick;
        }
        this.f = timeTick;
        return timeTick;
    }
}
