package com.tencent.mm.plugin.mmsight.model.b;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.EncoderCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;

public final class d {
    private ByteBuffer[] agD;
    private ByteBuffer[] apM;
    private int bitrate = 0;
    boolean fAs = false;
    private boolean fke = false;
    int frameCount;
    private int ioD;
    private int ioE;
    int mvv;
    int nUr;
    int otT;
    protected int ouk = -1;
    protected MediaCodec oul;
    private int ouu = -1;
    a owR;
    int owS;
    byte[] owT;
    int owU;
    protected MediaFormat owb;
    private int owc = -1;
    private BufferInfo owd;
    private boolean owe = false;
    private int owf;
    private int owg;

    public d(int i, int i2, int i3, int i4, int i5, int i6) {
        this.ioD = i;
        this.ioE = i2;
        x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "create MMSightRemuxMediaCodecEncoder, init targetWidth: %d, targetHeight: %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)});
        this.nUr = i3;
        this.mvv = i4;
        this.owg = i6;
        this.owf = 1;
        this.owd = new BufferInfo();
        this.bitrate = i5;
        x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "create MMSightRemuxMediaCodecEncoder, frameWidth: %s, frameHeight: %s, targetWidth: %s, targetHeight: %s, bitrate: %s", new Object[]{Integer.valueOf(this.ioD), Integer.valueOf(this.ioE), Integer.valueOf(this.nUr), Integer.valueOf(this.mvv), Integer.valueOf(i5)});
    }

    public final int sR(int i) {
        try {
            this.ouk = i;
            return baR();
        } catch (Exception e) {
            x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "init error: %s, try to re-init again", new Object[]{e.getMessage()});
            try {
                return baR();
            } catch (Exception e2) {
                x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "re-init again error: %s", new Object[]{e2.getMessage()});
                k.bai();
                return -1;
            }
        }
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
            x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "Unable to find an appropriate codec for video/avc");
            k.bai();
            return -1;
        }
        long bA;
        CodecCapabilities capabilitiesForType;
        CodecProfileLevel[] codecProfileLevelArr;
        CodecProfileLevel codecProfileLevel;
        int i3;
        EncoderCapabilities encoderCapabilities;
        x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "found codec: %s, used %sms", new Object[]{mediaCodecInfo.getName(), Long.valueOf(bh.bA(Wq))});
        Wq = bh.Wq();
        i2 = 0;
        long Wq2 = bh.Wq();
        CodecCapabilities capabilitiesForType2 = mediaCodecInfo.getCapabilitiesForType("video/avc");
        x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "getCapabilitiesForType used %sms", new Object[]{Long.valueOf(bh.bA(Wq2))});
        x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "color format length: %s", new Object[]{Integer.valueOf(capabilitiesForType2.colorFormats.length)});
        for (int i4 : capabilitiesForType2.colorFormats) {
            Object obj;
            int i5;
            Object obj2;
            x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "capabilities colorFormat: %s", new Object[]{Integer.valueOf(i4)});
            switch (i4) {
                case 19:
                case 21:
                case 2130706688:
                    obj = 1;
                    break;
                default:
                    obj = null;
                    break;
            }
            if (obj != null && i4 > i2) {
                if (i4 != 19) {
                    i2 = i4;
                } else {
                    x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "codec: %s, colorFormat: %s", new Object[]{mediaCodecInfo.getName(), Integer.valueOf(i4)});
                    this.otT = i4;
                    bA = bh.bA(Wq);
                    x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "found colorFormat: %s, used %sms", new Object[]{Integer.valueOf(this.otT), Long.valueOf(bA)});
                    if (this.otT != 19) {
                        this.owU = 2;
                    } else {
                        this.owU = 1;
                    }
                    bA = bh.Wq();
                    this.owb = MediaFormat.createVideoFormat("video/avc", this.nUr, this.mvv);
                    x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "createVideoFormat used %sms", new Object[]{Long.valueOf(bh.bA(bA))});
                    if (mediaCodecInfo != null) {
                        if (com.tencent.mm.compatible.util.d.fM(23)) {
                            try {
                                capabilitiesForType = mediaCodecInfo.getCapabilitiesForType("video/avc");
                                if (capabilitiesForType != null) {
                                    codecProfileLevelArr = capabilitiesForType.profileLevels;
                                    if (codecProfileLevelArr != null) {
                                        codecProfileLevel = new CodecProfileLevel();
                                        codecProfileLevel.level = 0;
                                        codecProfileLevel.profile = 0;
                                        for (CodecProfileLevel codecProfileLevel2 : codecProfileLevelArr) {
                                            i3 = codecProfileLevel2.profile;
                                            i5 = codecProfileLevel2.level;
                                            x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "profile: %s, level: %s", new Object[]{Integer.valueOf(i3), Integer.valueOf(i5)});
                                            switch (i3) {
                                                case 1:
                                                case 2:
                                                case 8:
                                                    obj2 = 1;
                                                    break;
                                                default:
                                                    obj2 = null;
                                                    break;
                                            }
                                            if (obj2 != null && i3 >= codecProfileLevel.profile && i5 >= codecProfileLevel.level) {
                                                codecProfileLevel.profile = i3;
                                                codecProfileLevel.level = i5;
                                            }
                                        }
                                        x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "best profile: %s, level: %s", new Object[]{Integer.valueOf(codecProfileLevel.profile), Integer.valueOf(codecProfileLevel.level)});
                                        if (codecProfileLevel.profile > 0 && codecProfileLevel.level >= 256) {
                                            this.owb.setInteger("profile", codecProfileLevel.profile);
                                            this.owb.setInteger("level", 256);
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "trySetProfile error: %s", new Object[]{e.getMessage()});
                            }
                        }
                        try {
                            if (com.tencent.mm.compatible.util.d.fM(21)) {
                                capabilitiesForType = mediaCodecInfo.getCapabilitiesForType("video/avc");
                                if (capabilitiesForType != null) {
                                    encoderCapabilities = capabilitiesForType.getEncoderCapabilities();
                                    if (encoderCapabilities != null) {
                                        if (encoderCapabilities.isBitrateModeSupported(2)) {
                                            x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "support cbr bitrate mode");
                                            this.owb.setInteger("bitrate-mode", 2);
                                        } else if (encoderCapabilities.isBitrateModeSupported(0)) {
                                            x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "both cbr and cq bitrate mode not support!");
                                        } else {
                                            x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "support cq bitrate mode");
                                            this.owb.setInteger("bitrate-mode", 0);
                                        }
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "trySetBitRateMode error: %s", new Object[]{e2.getMessage()});
                        }
                    }
                    this.owb.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.bitrate);
                    this.owb.setInteger("frame-rate", this.owg);
                    this.owb.setInteger("color-format", this.otT);
                    this.owb.setInteger("i-frame-interval", this.owf);
                    x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "mediaFormat: %s", new Object[]{this.owb});
                    this.oul = MediaCodec.createByCodecName(mediaCodecInfo.getName());
                    this.oul.configure(this.owb, null, null, 1);
                    this.oul.start();
                    return 0;
                }
            }
        }
        i4 = i2;
        x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "codec: %s, colorFormat: %s", new Object[]{mediaCodecInfo.getName(), Integer.valueOf(i4)});
        this.otT = i4;
        bA = bh.bA(Wq);
        x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "found colorFormat: %s, used %sms", new Object[]{Integer.valueOf(this.otT), Long.valueOf(bA)});
        if (this.otT != 19) {
            this.owU = 1;
        } else {
            this.owU = 2;
        }
        bA = bh.Wq();
        this.owb = MediaFormat.createVideoFormat("video/avc", this.nUr, this.mvv);
        x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "createVideoFormat used %sms", new Object[]{Long.valueOf(bh.bA(bA))});
        if (mediaCodecInfo != null) {
            if (com.tencent.mm.compatible.util.d.fM(23)) {
                capabilitiesForType = mediaCodecInfo.getCapabilitiesForType("video/avc");
                if (capabilitiesForType != null) {
                    codecProfileLevelArr = capabilitiesForType.profileLevels;
                    if (codecProfileLevelArr != null) {
                        codecProfileLevel = new CodecProfileLevel();
                        codecProfileLevel.level = 0;
                        codecProfileLevel.profile = 0;
                        for (CodecProfileLevel codecProfileLevel22 : codecProfileLevelArr) {
                            i3 = codecProfileLevel22.profile;
                            i5 = codecProfileLevel22.level;
                            x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "profile: %s, level: %s", new Object[]{Integer.valueOf(i3), Integer.valueOf(i5)});
                            switch (i3) {
                                case 1:
                                case 2:
                                case 8:
                                    obj2 = 1;
                                    break;
                                default:
                                    obj2 = null;
                                    break;
                            }
                            codecProfileLevel.profile = i3;
                            codecProfileLevel.level = i5;
                        }
                        x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "best profile: %s, level: %s", new Object[]{Integer.valueOf(codecProfileLevel.profile), Integer.valueOf(codecProfileLevel.level)});
                        this.owb.setInteger("profile", codecProfileLevel.profile);
                        this.owb.setInteger("level", 256);
                    }
                }
            }
            if (com.tencent.mm.compatible.util.d.fM(21)) {
                capabilitiesForType = mediaCodecInfo.getCapabilitiesForType("video/avc");
                if (capabilitiesForType != null) {
                    encoderCapabilities = capabilitiesForType.getEncoderCapabilities();
                    if (encoderCapabilities != null) {
                        if (encoderCapabilities.isBitrateModeSupported(2)) {
                            x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "support cbr bitrate mode");
                            this.owb.setInteger("bitrate-mode", 2);
                        } else if (encoderCapabilities.isBitrateModeSupported(0)) {
                            x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "both cbr and cq bitrate mode not support!");
                        } else {
                            x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "support cq bitrate mode");
                            this.owb.setInteger("bitrate-mode", 0);
                        }
                    }
                }
            }
        }
        this.owb.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.bitrate);
        this.owb.setInteger("frame-rate", this.owg);
        this.owb.setInteger("color-format", this.otT);
        this.owb.setInteger("i-frame-interval", this.owf);
        x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "mediaFormat: %s", new Object[]{this.owb});
        this.oul = MediaCodec.createByCodecName(mediaCodecInfo.getName());
        this.oul.configure(this.owb, null, null, 1);
        this.oul.start();
        return 0;
    }

    public final void b(byte[] bArr, boolean z, long j) {
        try {
            if (!this.fAs) {
                x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "writeData, not start!");
            } else if (this.oul == null) {
                x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder is null");
            } else {
                long Wq = bh.Wq();
                this.apM = this.oul.getInputBuffers();
                this.agD = this.oul.getOutputBuffers();
                int i = 0;
                while (this.oul != null) {
                    int dequeueInputBuffer = this.oul.dequeueInputBuffer(600);
                    this.owc = dequeueInputBuffer;
                    if (dequeueInputBuffer >= 0 || i >= 10) {
                        break;
                    }
                    x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "video no input available, drain first");
                    baS();
                    i++;
                }
                if (this.oul == null) {
                    x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder is null");
                    return;
                }
                x.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "inputBufferIndex: %s", new Object[]{Integer.valueOf(this.owc)});
                long Wq2 = bh.Wq();
                if (this.owc < 0) {
                    x.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "input buffer not available");
                } else if (!this.fAs || z || bArr == null) {
                    x.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "end of stream");
                    this.owe = true;
                    this.oul.queueInputBuffer(this.owc, 0, 0, j, 4);
                    this.fke = true;
                } else {
                    x.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "presentationTime: " + j);
                    ByteBuffer byteBuffer = this.apM[this.owc];
                    byteBuffer.clear();
                    byteBuffer.put(bArr);
                    byteBuffer.position(0);
                    this.oul.queueInputBuffer(this.owc, 0, bArr.length, j, 0);
                }
                baS();
                x.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder used %sms %sms", new Object[]{Long.valueOf(bh.bA(Wq)), Long.valueOf(bh.bA(Wq2))});
            }
        } catch (Throwable e) {
            k.baj();
            x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "writeData error: %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.MMSightRemuxMediaCodecEncoder", e, "", new Object[0]);
        }
    }

    private void baS() {
        this.ouu = this.oul.dequeueOutputBuffer(this.owd, 600);
        x.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "outputBufferIndex-->" + this.ouu);
        while (true) {
            if (this.ouu != -1) {
                if (this.ouu != -3) {
                    if (this.ouu != -2) {
                        if (this.ouu >= 0) {
                            x.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "perform encoding");
                            ByteBuffer byteBuffer = this.agD[this.ouu];
                            if (byteBuffer != null) {
                                this.frameCount++;
                                if ((this.owd.flags & 2) != 0) {
                                    x.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", new Object[]{Integer.valueOf(this.owd.size), Boolean.valueOf(false)});
                                }
                                if (this.owd.size != 0) {
                                    byteBuffer.position(this.owd.offset);
                                    byteBuffer.limit(this.owd.offset + this.owd.size);
                                    BufferInfo bufferInfo = this.owd;
                                    if (!(byteBuffer == null || bufferInfo == null || this.owR == null)) {
                                        this.owR.a(this.ouk, byteBuffer, bufferInfo.size);
                                    }
                                }
                                this.oul.releaseOutputBuffer(this.ouu, false);
                                if ((this.owd.flags & 4) != 0) {
                                    break;
                                }
                            }
                            throw new RuntimeException("encoderOutputBuffer " + this.ouu + " was null");
                        }
                        x.w("MicroMsg.MMSightRemuxMediaCodecEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + this.ouu);
                    } else {
                        x.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder output format changed: " + this.oul.getOutputFormat());
                    }
                } else {
                    this.agD = this.oul.getOutputBuffers();
                    x.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder output buffers changed");
                }
            } else {
                x.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "no output from encoder available, break encoderEndStream %s", new Object[]{Boolean.valueOf(this.owe)});
                if (!this.owe) {
                    return;
                }
            }
            this.ouu = this.oul.dequeueOutputBuffer(this.owd, 600);
            if (this.ouu <= 0) {
                x.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "get outputBufferIndex %d", new Object[]{Integer.valueOf(this.ouu)});
            }
            if (this.ouu < 0 && !this.owe) {
                return;
            }
        }
        if (this.fke) {
            x.w("MicroMsg.MMSightRemuxMediaCodecEncoder", "do stop encoder, frameCount: %s, writeFrameCount: %s", new Object[]{Integer.valueOf(this.frameCount), Integer.valueOf(this.owS)});
            try {
                this.oul.stop();
                this.oul.release();
                this.oul = null;
                this.fAs = false;
                return;
            } catch (Exception e) {
                x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "do stop encoder error: %s", new Object[]{e.getMessage()});
                return;
            }
        }
        x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "reached end of stream unexpectedly");
    }
}
