package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Looper;
import com.tencent.mm.e.b.c;
import com.tencent.mm.e.b.c.a;
import com.tencent.mm.plugin.mmsight.model.a.c.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;
import java.nio.ByteBuffer;

@TargetApi(16)
public class h implements c {
    int audioSampleRate;
    c fkb = null;
    private int huc;
    private final int jAh = 100;
    int jzK;
    protected boolean ouA;
    boolean ouB;
    final Object ouC = new byte[0];
    b ouD;
    boolean ouE = false;
    af ouF;
    Runnable ouG = new 2(this);
    private a ouH = new 3(this);
    MediaCodec oul;
    private MediaFormat oum;
    private BufferInfo oun;
    long ouo = 0;
    int oup;
    int ouq;
    long our;
    long ous;
    private int ouu;
    boolean ouv = false;
    boolean ouw = false;
    c.a oux = null;
    o ouy;
    af ouz = new 1(this, Looper.getMainLooper());
    private long startTime = 0;

    public h(int i, int i2) {
        this.huc = i2;
        this.audioSampleRate = i;
        this.ouy = null;
        x.i("MicroMsg.MMSightAACMediaCodecRecorder", "create MMSightAACMediaCodecRecorder, audioBitrate: %s, audioSampleRate: %s", new Object[]{Integer.valueOf(this.huc), Integer.valueOf(this.audioSampleRate)});
    }

    public int ar(int i, String str) {
        if (!(this.ouw || this.fkb == null)) {
            String str2 = "MicroMsg.MMSightAACMediaCodecRecorder";
            String str3 = "call init, before pcmRecorder stop, stopCallback null ? %B";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(this.ouD == null);
            x.e(str2, str3, objArr);
            this.fkb.vi();
        }
        if (this.oul != null) {
            boolean z;
            str2 = "MicroMsg.MMSightAACMediaCodecRecorder";
            str3 = "call init, before audioEncoder stop, stopCallback null ? %B";
            objArr = new Object[1];
            if (this.ouD == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.e(str2, str3, objArr);
            this.oul.stop();
            this.oul.release();
            this.oul = null;
            if (this.ouD != null) {
                this.ouD.bau();
                this.ouD = null;
            }
        }
        this.jzK = 0;
        this.ouA = false;
        synchronized (this.ouC) {
            this.ouB = false;
            this.ouD = null;
        }
        if (!this.ouw) {
            this.fkb = new c(this.audioSampleRate, 1, 5);
            this.fkb.et(FileUtils.S_IWUSR);
            this.fkb.aO(false);
            this.fkb.fkK = this.ouH;
        }
        if (this.ouF == null) {
            x.i("MicroMsg.MMSightAACMediaCodecRecorder", "create pcm control handler");
            this.ouF = new af();
        } else if (this.ouF.getLooper() != Looper.myLooper()) {
            x.w("MicroMsg.MMSightAACMediaCodecRecorder", "error pcm control handler looper[%s, %s], recreate handler", new Object[]{this.ouF.getLooper(), Looper.myLooper()});
            this.ouF = new af();
        }
        x.i("MicroMsg.MMSightAACMediaCodecRecorder", "sample rate %d, audio rate %d", new Object[]{Integer.valueOf(this.audioSampleRate), Integer.valueOf(this.huc)});
        try {
            this.oun = new BufferInfo();
            this.oum = new MediaFormat();
            this.oum.setString("mime", "audio/mp4a-latm");
            this.oum.setInteger("aac-profile", 2);
            this.oum.setInteger("sample-rate", this.audioSampleRate);
            this.oum.setInteger("channel-count", 1);
            this.oum.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.huc);
            this.oum.setInteger("max-input-size", 16384);
            this.oul = MediaCodec.createEncoderByType("audio/mp4a-latm");
            this.oul.configure(this.oum, null, null, 1);
            this.oul.start();
            return 0;
        } catch (Throwable th) {
            MediaCodec th2 = th;
            x.printErrStackTrace("MicroMsg.MMSightAACMediaCodecRecorder", th2, "start aac encoder error: %s", new Object[]{th2.getMessage()});
            if (this.oul != null) {
                try {
                    this.oul.stop();
                    this.oul.release();
                    this.oul = th2;
                } catch (Exception e) {
                    str2 = "MicroMsg.MMSightAACMediaCodecRecorder";
                    str3 = "try to stop aac encoder error: %s";
                    this.oul = null;
                    x.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecAACInitError");
                    g.pQN.a(440, 15, 1, false);
                    return -1;
                } catch (Throwable th3) {
                    th2 = th3;
                    this.oul = null;
                }
            }
            x.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecAACInitError");
            g.pQN.a(440, 15, 1, false);
            return -1;
        } finally {
            this.ouv = false;
        }
    }

    public final int a(c.a aVar) {
        int i = 0;
        x.i("MicroMsg.MMSightAACMediaCodecRecorder", "start, onPcmReady: %s", new Object[]{aVar});
        this.oux = aVar;
        if (!this.ouw) {
            if (this.fkb == null) {
                x.i("MicroMsg.MMSightAACMediaCodecRecorder", "start, pcmrecorder is null");
                return -1;
            } else if (!this.fkb.vr()) {
                i = -1;
            }
        }
        return i;
    }

    public final int a(b bVar) {
        boolean z;
        String str = "MicroMsg.MMSightAACMediaCodecRecorder";
        String str2 = "call stop, pcmRecorder null[%B], old stopCallback null[%B]new stopCallback null[%B], pcmMarkStop[%B]";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(this.fkb == null);
        if (this.ouD == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Boolean.valueOf(bVar == null);
        objArr[3] = Boolean.valueOf(this.ouA);
        x.i(str, str2, objArr);
        if (this.fkb == null && !this.ouw) {
            return -1;
        }
        this.ouA = true;
        synchronized (this.ouC) {
            this.ouD = bVar;
            if (this.ouB && bVar != null) {
                x.i("MicroMsg.MMSightAACMediaCodecRecorder", "has stop, directly call stop callback");
                bVar.bau();
                this.ouD = null;
            }
        }
        ag.h(new 4(this), 500);
        return 0;
    }

    public final void clear() {
        x.i("MicroMsg.MMSightAACMediaCodecRecorder", "clear");
        try {
            if (this.oul != null) {
                x.i("MicroMsg.MMSightAACMediaCodecRecorder", "stop encoder");
                this.oul.stop();
                this.oul.release();
                this.oul = null;
            }
            if (this.fkb != null && !this.ouw) {
                x.i("MicroMsg.MMSightAACMediaCodecRecorder", "stop pcm recorder");
                this.fkb.vi();
                this.fkb = null;
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMSightAACMediaCodecRecorder", "clear error: %s", new Object[]{e.getMessage()});
        }
    }

    public final void bar() {
        this.ouv = true;
    }

    public final a bas() {
        return this.ouH;
    }

    public final void gC(boolean z) {
        this.ouw = z;
    }

    final void gD(boolean z) {
        if (this.oul == null) {
            x.w("MicroMsg.MMSightAACMediaCodecRecorder", "drain audio encoder error, encoder is null, end:" + z);
            return;
        }
        try {
            ByteBuffer[] outputBuffers = this.oul.getOutputBuffers();
            while (true) {
                this.ouu = this.oul.dequeueOutputBuffer(this.oun, 100);
                x.v("MicroMsg.MMSightAACMediaCodecRecorder", "outputBufferIndex-->%s", new Object[]{Integer.valueOf(this.ouu)});
                if (this.ouu == -1) {
                    x.d("MicroMsg.MMSightAACMediaCodecRecorder", "no output available, break");
                    return;
                } else if (this.ouu == -3) {
                    outputBuffers = this.oul.getOutputBuffers();
                } else if (this.ouu == -2) {
                    MediaFormat outputFormat = this.oul.getOutputFormat();
                    x.d("MicroMsg.MMSightAACMediaCodecRecorder", "encoder output format changed: " + outputFormat);
                    if (this.ouy != null) {
                        this.ouy.d(outputFormat);
                    }
                } else if (this.ouu < 0) {
                    x.v("MicroMsg.MMSightAACMediaCodecRecorder", "unexpected result from encoder.dequeueOutputBuffer: %s", new Object[]{Integer.valueOf(this.ouu)});
                } else {
                    x.v("MicroMsg.MMSightAACMediaCodecRecorder", "perform encoding");
                    ByteBuffer byteBuffer = outputBuffers[this.ouu];
                    if (byteBuffer == null) {
                        throw new RuntimeException("encoderOutputBuffer " + this.ouu + " was null");
                    }
                    if ((this.oun.flags & 2) != 0) {
                        x.v("MicroMsg.MMSightAACMediaCodecRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG,size: %s, %s", new Object[]{Integer.valueOf(this.oun.size), Boolean.valueOf(baJ())});
                        if (baJ()) {
                            this.oun.size = 0;
                        }
                    }
                    if (this.oun.size != 0) {
                        if (!(this.ouy == null || this.ouy.fAs)) {
                            this.ouy.d(this.oul.getOutputFormat());
                        }
                        byteBuffer.position(this.oun.offset);
                        byteBuffer.limit(this.oun.offset + this.oun.size);
                        e(byteBuffer, this.oun);
                    }
                    this.oul.releaseOutputBuffer(this.ouu, false);
                    if ((this.oun.flags & 4) != 0) {
                        break;
                    }
                }
            }
            if (z) {
                x.w("MicroMsg.MMSightAACMediaCodecRecorder", "do stop audio encoder");
                this.oul.stop();
                this.oul.release();
                this.oul = null;
                return;
            }
            x.w("MicroMsg.MMSightAACMediaCodecRecorder", "reached end of stream unexpectedly");
        } catch (Exception e) {
            x.e("MicroMsg.MMSightAACMediaCodecRecorder", "drainEncoder error: %s", new Object[]{e.getMessage()});
        }
    }

    protected void e(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        if (this.ouy != null && (bufferInfo.flags & 4) == 0) {
            this.ouy.f(byteBuffer, bufferInfo);
        }
    }

    protected boolean baJ() {
        return false;
    }
}
