package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.f.a;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.nio.ByteBuffer;

@TargetApi(16)
public class r implements f {
    private ByteBuffer[] agD;
    private ByteBuffer[] apM;
    private int bitrate = 0;
    boolean fAs = false;
    boolean fke = false;
    int frameCount;
    private long gKo = 0;
    private int ioD;
    private int ioE;
    int mvv;
    int nUr;
    int otT;
    boolean oth = false;
    protected MediaCodec oul;
    private int ouu = -1;
    private o ouy;
    int ovW = -1;
    int ovX = -1;
    int ovY = -1;
    int ovZ = -1;
    a owa = new a(this.owi);
    protected MediaFormat owb;
    private int owc = -1;
    private BufferInfo owd;
    private boolean owe = false;
    private int owf;
    private int owg;
    a owh;
    private a.a owi = new 1(this);
    long startTime = 0;

    public r(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        this.ioD = i;
        this.ioE = i2;
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "create MMSightYUVMediaCodecRecorder, init targetWidth: %d, targetHeight: %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)});
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "create MMSightYUVMediaCodecRecorder, after align 16, targetWidth: %d, targetHeight: %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)});
        this.nUr = i3;
        this.mvv = i4;
        this.owg = i7;
        this.owf = i6;
        this.ouy = null;
        this.owd = new BufferInfo();
        this.bitrate = i5;
        this.oth = z;
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "create BigSightMediaCodecYUVRecorder, frameWidth: %s, frameHeight: %s, targetWidth: %s, targetHeight: %s, bitrate: %s, needRotateEachFrame: %s, muxer: %s", new Object[]{Integer.valueOf(this.ioD), Integer.valueOf(this.ioE), Integer.valueOf(this.nUr), Integer.valueOf(this.mvv), Integer.valueOf(i5), Boolean.valueOf(z), null});
    }

    public int cN(int i, int i2) {
        int i3 = -1;
        try {
            this.ovW = i2;
            i3 = baR();
        } catch (Exception e) {
            x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "init error: %s, try to re-init again", new Object[]{e.getMessage()});
            try {
                if (CaptureMMProxy.getInstance() != null) {
                    CaptureMMProxy.getInstance().set(w.a.xsS, Integer.valueOf(-1));
                }
                i3 = baR();
            } catch (Exception e2) {
                x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "re-init again error: %s", new Object[]{e2.getMessage()});
                k.bai();
            }
        }
        return i3;
    }

    private int baR() {
        int i;
        int i2;
        MediaCodecInfo mediaCodecInfo;
        long Wq = bh.Wq();
        String str = "video/avc";
        int codecCount = MediaCodecList.getCodecCount();
        loop0:
        for (i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (String equalsIgnoreCase : supportedTypes) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                        mediaCodecInfo = codecInfoAt;
                        break loop0;
                    }
                }
                continue;
            }
        }
        mediaCodecInfo = null;
        if (mediaCodecInfo == null) {
            x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "Unable to find an appropriate codec for video/avc");
            k.bai();
            return -1;
        }
        long Wq2;
        int i3;
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "found codec: %s, used %sms", new Object[]{mediaCodecInfo.getName(), Long.valueOf(bh.bA(Wq))});
        Wq = bh.Wq();
        if (CaptureMMProxy.getInstance() != null) {
            i2 = CaptureMMProxy.getInstance().getInt(w.a.xsS, -1);
        } else {
            i2 = -1;
        }
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "saveColorFormat: %s", new Object[]{Integer.valueOf(i2)});
        if (i2 <= 0) {
            Wq2 = bh.Wq();
            CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType("video/avc");
            x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "getCapabilitiesForType used %sms", new Object[]{Long.valueOf(bh.bA(Wq2))});
            x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "color format length: %s", new Object[]{Integer.valueOf(capabilitiesForType.colorFormats.length)});
            i2 = 0;
            for (int i4 : capabilitiesForType.colorFormats) {
                x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "capabilities colorFormat: %s", new Object[]{Integer.valueOf(i4)});
                switch (i4) {
                    case 19:
                    case 21:
                    case 2130706688:
                        i = 1;
                        break;
                    default:
                        i = 0;
                        break;
                }
                if (i != 0 && (i4 > i2 || i4 == 21)) {
                    i2 = i4;
                }
            }
            x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "codec: %s, colorFormat: %s", new Object[]{mediaCodecInfo.getName(), Integer.valueOf(i2)});
        }
        this.otT = i2;
        Wq2 = bh.bA(Wq);
        if (this.otT > 0 && Wq2 > 200 && CaptureMMProxy.getInstance() != null) {
            CaptureMMProxy.getInstance().set(w.a.xsS, Integer.valueOf(this.otT));
        }
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "found colorFormat: %s, used %sms", new Object[]{Integer.valueOf(this.otT), Long.valueOf(Wq2)});
        Wq = bh.Wq();
        String str2;
        if (this.oth) {
            str2 = "video/avc";
            i2 = (this.ovW == 180 || this.ovW == 0) ? this.nUr : this.mvv;
            i3 = (this.ovW == 180 || this.ovW == 0) ? this.mvv : this.nUr;
            this.owb = MediaFormat.createVideoFormat(str2, i2, i3);
        } else {
            str2 = "video/avc";
            i2 = (this.ovW == 180 || this.ovW == 0) ? this.mvv : this.nUr;
            i3 = (this.ovW == 180 || this.ovW == 0) ? this.nUr : this.mvv;
            this.owb = MediaFormat.createVideoFormat(str2, i2, i3);
        }
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "createVideoFormat used %sms", new Object[]{Long.valueOf(bh.bA(Wq))});
        if (mediaCodecInfo != null) {
            if (d.fM(23)) {
                try {
                    CodecCapabilities capabilitiesForType2 = mediaCodecInfo.getCapabilitiesForType("video/avc");
                    if (capabilitiesForType2 != null) {
                        CodecProfileLevel[] codecProfileLevelArr = capabilitiesForType2.profileLevels;
                        if (codecProfileLevelArr != null) {
                            CodecProfileLevel codecProfileLevel = new CodecProfileLevel();
                            codecProfileLevel.level = 0;
                            codecProfileLevel.profile = 0;
                            for (CodecProfileLevel codecProfileLevel2 : codecProfileLevelArr) {
                                int i5 = codecProfileLevel2.profile;
                                int i6 = codecProfileLevel2.level;
                                x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "profile: %s, level: %s", new Object[]{Integer.valueOf(i5), Integer.valueOf(i6)});
                                switch (i5) {
                                    case 1:
                                    case 2:
                                    case 8:
                                        i3 = 1;
                                        break;
                                    default:
                                        i3 = 0;
                                        break;
                                }
                                if (i3 != 0 && i5 >= codecProfileLevel.profile && i6 >= codecProfileLevel.level) {
                                    codecProfileLevel.profile = i5;
                                    codecProfileLevel.level = i6;
                                }
                            }
                            x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "best profile: %s, level: %s", new Object[]{Integer.valueOf(codecProfileLevel.profile), Integer.valueOf(codecProfileLevel.level)});
                            if (codecProfileLevel.profile > 0 && codecProfileLevel.level >= 256) {
                                this.owb.setInteger("profile", codecProfileLevel.profile);
                                this.owb.setInteger("level", 256);
                            }
                        }
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "trySetProfile error: %s", new Object[]{e.getMessage()});
                }
            }
            try {
                if (d.fM(21)) {
                    this.owb.setInteger("bitrate-mode", 1);
                }
            } catch (Exception e2) {
                x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "trySetBitRateMode error: %s", new Object[]{e2.getMessage()});
            }
        }
        this.owb.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.bitrate);
        this.owb.setInteger("frame-rate", this.owg);
        this.owb.setInteger("color-format", this.otT);
        this.owb.setInteger("i-frame-interval", this.owf);
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "mediaFormat: %s", new Object[]{this.owb});
        this.oul = MediaCodec.createByCodecName(mediaCodecInfo.getName());
        this.oul.configure(this.owb, null, null, 1);
        this.oul.start();
        return 0;
    }

    public final void d(byte[] bArr, boolean z) {
        try {
            if (!this.fAs) {
                x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeData, not start!");
            } else if (this.oul == null) {
                x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "encoder is null");
            } else {
                if (this.ouy != null && this.ouy.ovU <= 0) {
                    this.ouy.ovU = System.nanoTime();
                }
                long Wq = bh.Wq();
                this.apM = this.oul.getInputBuffers();
                this.agD = this.oul.getOutputBuffers();
                int dequeueInputBuffer = this.oul.dequeueInputBuffer(100);
                this.owc = dequeueInputBuffer;
                if (dequeueInputBuffer < 0) {
                    x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "video no input available, drain first");
                    baS();
                }
                if (this.oul == null) {
                    x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "encoder is null");
                    return;
                }
                x.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "inputBufferIndex: %s", new Object[]{Integer.valueOf(this.owc)});
                long Wq2 = bh.Wq();
                if (this.owc >= 0) {
                    long nanoTime = ((System.nanoTime() - ((long) ((bArr.length / 1600000) / 1000000000))) - (this.ouy != null ? this.ouy.ovU : this.startTime)) / 1000;
                    x.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "presentationTime: " + nanoTime);
                    ByteBuffer byteBuffer = this.apM[this.owc];
                    byteBuffer.clear();
                    byteBuffer.put(bArr);
                    byteBuffer.position(0);
                    if (!this.fAs || z) {
                        x.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "end of stream");
                        this.owe = true;
                        this.oul.queueInputBuffer(this.owc, 0, bArr.length, nanoTime, 4);
                    } else {
                        this.oul.queueInputBuffer(this.owc, 0, bArr.length, nanoTime, 0);
                    }
                } else {
                    x.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "input buffer not available");
                }
                baS();
                x.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "encoder used %sms %sms", new Object[]{Long.valueOf(bh.bA(Wq)), Long.valueOf(bh.bA(Wq2))});
            }
        } catch (Throwable e) {
            k.baj();
            x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeData error: %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", e, "", new Object[0]);
        }
    }

    private void baS() {
        this.ouu = this.oul.dequeueOutputBuffer(this.owd, 100);
        x.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "outputBufferIndex-->" + this.ouu);
        while (true) {
            if (this.ouu != -1) {
                if (this.ouu != -3) {
                    if (this.ouu != -2) {
                        if (this.ouu >= 0) {
                            x.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "perform encoding");
                            ByteBuffer byteBuffer = this.agD[this.ouu];
                            if (byteBuffer != null) {
                                this.frameCount++;
                                if ((this.owd.flags & 2) != 0) {
                                    x.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", new Object[]{Integer.valueOf(this.owd.size), Boolean.valueOf(false)});
                                }
                                if (this.owd.size != 0) {
                                    if (!(this.ouy == null || this.ouy.fAs)) {
                                        this.ouy.c(this.oul.getOutputFormat());
                                    }
                                    byteBuffer.position(this.owd.offset);
                                    byteBuffer.limit(this.owd.offset + this.owd.size);
                                    e(byteBuffer, this.owd);
                                }
                                this.oul.releaseOutputBuffer(this.ouu, false);
                                if ((this.owd.flags & 4) != 0) {
                                    break;
                                }
                            }
                            throw new RuntimeException("encoderOutputBuffer " + this.ouu + " was null");
                        }
                        x.w("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "unexpected result from encoder.dequeueOutputBuffer: " + this.ouu);
                    } else {
                        MediaFormat outputFormat = this.oul.getOutputFormat();
                        x.d("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "encoder output format changed: " + outputFormat);
                        if (this.ouy != null) {
                            this.ouy.c(outputFormat);
                        }
                    }
                } else {
                    this.agD = this.oul.getOutputBuffers();
                    x.d("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "encoder output buffers changed");
                }
            } else {
                x.d("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "no output from encoder available, break encoderEndStream %s", new Object[]{Boolean.valueOf(this.owe)});
                if (!this.owe) {
                    return;
                }
            }
            this.ouu = this.oul.dequeueOutputBuffer(this.owd, 100);
            if (this.ouu <= 0) {
                x.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "get outputBufferIndex %d", new Object[]{Integer.valueOf(this.ouu)});
            }
            if (this.ouu < 0 && !this.owe) {
                return;
            }
        }
        if (this.fke) {
            x.w("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "do stop encoder");
            try {
                this.oul.stop();
                this.oul.release();
                this.owa.stop();
                this.oul = null;
                this.fAs = false;
                if (this.owh != null) {
                    this.owh.baI();
                    return;
                }
                return;
            } catch (Exception e) {
                x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "do stop encoder error: %s", new Object[]{e.getMessage()});
                return;
            }
        }
        x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "reached end of stream unexpectedly");
    }

    protected void e(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        if (this.ouy != null && (bufferInfo.flags & 4) == 0) {
            this.ouy.g(byteBuffer, bufferInfo);
        }
    }

    public final void a(a aVar) {
        this.owh = aVar;
        this.fke = true;
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "!!!stop, isStart!!: %s %s isEnd %s", new Object[]{Boolean.valueOf(this.fAs), this.owh, Boolean.valueOf(this.owa.baq())});
        if (this.owa.baq()) {
            baT();
        }
    }

    final void baT() {
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "stopImp %s", new Object[]{bh.cgy().toString()});
        try {
            if (this.fAs) {
                ag.h(new Runnable(this) {
                    final /* synthetic */ r owj;

                    {
                        this.owj = r1;
                    }

                    public final void run() {
                        try {
                            if (this.owj.oul != null) {
                                x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "delay to stop encoder");
                                this.owj.owa.stop();
                                this.owj.oul.stop();
                                this.owj.oul.release();
                                this.owj.oul = null;
                                this.owj.fAs = false;
                                if (this.owj.owh != null) {
                                    this.owj.owh.baI();
                                }
                            }
                        } catch (Exception e) {
                            x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "delay to stop encoder error: %s", new Object[]{e.getMessage()});
                        }
                    }
                }, 500);
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "stop error: %s", new Object[]{e.getMessage()});
        }
    }

    public final long baQ() {
        return System.currentTimeMillis() - this.startTime;
    }

    public void clear() {
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "clear");
        try {
            if (this.oul != null) {
                x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "stop encoder");
                this.owa.stop();
                this.oul.stop();
                this.oul.release();
                this.oul = null;
                this.fAs = false;
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "clear error: %s", new Object[]{e.getMessage()});
        }
    }
}
