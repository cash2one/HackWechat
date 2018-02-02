package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.plugin.mmsight.segment.e.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;

public class i implements e {
    protected long aBM;
    private int frameCount = 0;
    protected String hTv = null;
    protected MediaExtractor opL;
    protected MediaCodec opN;
    protected long owN;
    protected int owP;
    protected BufferInfo owd = new BufferInfo();
    protected MediaFormat oxL;
    protected a oxs;
    protected int oyf;
    private byte[] oyl;
    protected int sampleSize;

    public i(MediaExtractor mediaExtractor, MediaFormat mediaFormat, int i) {
        x.i("MicroMsg.MediaCodecTranscodeDecoder", "create MediaCodecTranscodeDecoder: %s, %s, %s", new Object[]{mediaExtractor, mediaFormat, Integer.valueOf(i)});
        this.opL = mediaExtractor;
        this.oxL = mediaFormat;
        this.oyf = i;
    }

    public final int q(String str, long j, long j2) {
        this.hTv = str;
        this.aBM = j;
        this.owN = j2;
        x.i("MicroMsg.MediaCodecTranscodeDecoder", "initDecoder() called with: format = [" + this.oxL + "]");
        try {
            String string = this.oxL.getString("mime");
            this.opN = MediaCodec.createDecoderByType(string);
            MediaCodecInfo Fm = Fm(string);
            x.i("MicroMsg.MediaCodecTranscodeDecoder", "found codec: %s", new Object[]{Fm});
            if (Fm != null) {
                x.i("MicroMsg.MediaCodecTranscodeDecoder", "codec name: %s", new Object[]{Fm.getName()});
                x.i("MicroMsg.MediaCodecTranscodeDecoder", "found colorFormat: %s", new Object[]{Integer.valueOf(a(Fm, string))});
                this.oxL.setInteger("color-format", r1);
            }
            this.opN.configure(this.oxL, null, null, 0);
            this.opN.start();
            return 0;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MediaCodecTranscodeDecoder", e, "Init decoder failed : %s", new Object[]{e.getMessage()});
            return -1;
        }
    }

    private static MediaCodecInfo Fm(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (!codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (String equalsIgnoreCase : supportedTypes) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        return null;
    }

    protected int a(MediaCodecInfo mediaCodecInfo, String str) {
        x.i("MicroMsg.MediaCodecTranscodeDecoder", "selectColorFormat, mimeType: %s, codecInfo: %s", new Object[]{str, mediaCodecInfo});
        long Wq = bh.Wq();
        CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        x.i("MicroMsg.MediaCodecTranscodeDecoder", "getCapabilitiesForType used %sms", new Object[]{Long.valueOf(bh.bA(Wq))});
        x.i("MicroMsg.MediaCodecTranscodeDecoder", "color format length: %s", new Object[]{Integer.valueOf(capabilitiesForType.colorFormats.length)});
        int i = 0;
        for (int i2 : capabilitiesForType.colorFormats) {
            x.i("MicroMsg.MediaCodecTranscodeDecoder", "capabilities colorFormat: %s", new Object[]{Integer.valueOf(i2)});
            if (sT(i2) && (i2 > i || i2 == 21)) {
                i = i2;
            }
        }
        x.i("MicroMsg.MediaCodecTranscodeDecoder", "codec: %s, colorFormat: %s", new Object[]{mediaCodecInfo.getName(), Integer.valueOf(i)});
        return i;
    }

    protected boolean sT(int i) {
        switch (i) {
            case 19:
            case 21:
                return true;
            default:
                return false;
        }
    }

    protected boolean bbk() {
        if (this.opN == null) {
            x.e("MicroMsg.MediaCodecTranscodeDecoder", "drainDecoder, decoder is null");
            return true;
        }
        x.i("MicroMsg.MediaCodecTranscodeDecoder", "decoderOutputByteBuffers length: %s", new Object[]{Integer.valueOf(this.opN.getOutputBuffers().length)});
        int dequeueOutputBuffer = this.opN.dequeueOutputBuffer(this.owd, 60000);
        x.i("MicroMsg.MediaCodecTranscodeDecoder", "outputBufferIndex-->" + dequeueOutputBuffer);
        int i = dequeueOutputBuffer;
        ByteBuffer[] byteBufferArr = r1;
        int i2 = i;
        while (i2 != -1) {
            if (i2 != -3) {
                if (i2 != -2) {
                    if (i2 >= 0) {
                        x.v("MicroMsg.MediaCodecTranscodeDecoder", "perform decoding");
                        ByteBuffer byteBuffer = byteBufferArr[i2];
                        if (byteBuffer == null) {
                            break;
                        }
                        long j = this.owd.presentationTimeUs;
                        if (j < this.aBM * 1000 && (this.owd.flags & 4) == 0) {
                            this.opN.releaseOutputBuffer(i2, false);
                            x.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder pts: %s, not reach start: %s", new Object[]{Long.valueOf(j), Long.valueOf(this.aBM * 1000)});
                            return false;
                        } else if (this.owd.size != 0) {
                            byteBuffer.position(this.owd.offset);
                            byteBuffer.limit(this.owd.offset + this.owd.size);
                            long Wq = bh.Wq();
                            BufferInfo bufferInfo = this.owd;
                            if (byteBuffer == null) {
                                x.e("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer error! byteBuffer is null");
                            } else {
                                this.frameCount++;
                                if (this.owP <= 1 || this.frameCount % this.owP != 0) {
                                    if (this.oyl == null) {
                                        this.oyl = new byte[byteBuffer.remaining()];
                                    }
                                    long Wq2 = bh.Wq();
                                    try {
                                        this.oxL = this.opN.getOutputFormat();
                                    } catch (Exception e) {
                                        x.e("MicroMsg.MediaCodecTranscodeDecoder", "get output format error");
                                    }
                                    byteBuffer.get(this.oyl, 0, byteBuffer.remaining());
                                    x.i("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d cost %d", new Object[]{byteBuffer, bufferInfo, Integer.valueOf(bufferInfo.size), Long.valueOf(bh.bA(Wq2))});
                                    if (this.oxs != null) {
                                        this.oxs.aA(this.oyl);
                                    }
                                }
                            }
                            x.v("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer %s", new Object[]{Long.valueOf(bh.bA(Wq))});
                            this.opN.releaseOutputBuffer(i2, false);
                            if (this.owN != 1 && j >= this.owN * 1000) {
                                x.e("MicroMsg.MediaCodecTranscodeDecoder", "exceed endTimeMs");
                                return true;
                            } else if ((this.owd.flags & 4) == 0) {
                                return false;
                            } else {
                                x.i("MicroMsg.MediaCodecTranscodeDecoder", "receive end of stream");
                                try {
                                    this.opN.stop();
                                    this.opN.release();
                                    this.opN = null;
                                } catch (Exception e2) {
                                    x.e("MicroMsg.MediaCodecTranscodeDecoder", "stop and release decoder error: %s", new Object[]{e2.getMessage()});
                                }
                                return true;
                            }
                        } else {
                            this.opN.releaseOutputBuffer(i2, false);
                        }
                    } else {
                        x.w("MicroMsg.MediaCodecTranscodeDecoder", "unexpected result from decoder.dequeueOutputBuffer: " + i2);
                    }
                } else {
                    this.oxL = this.opN.getOutputFormat();
                    x.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder output format changed: " + this.oxL);
                }
            } else {
                byteBufferArr = this.opN.getOutputBuffers();
                x.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder output buffers changed");
            }
            i2 = this.opN.dequeueOutputBuffer(this.owd, 60000);
            if (i2 < 0) {
                break;
            }
        }
        x.i("MicroMsg.MediaCodecTranscodeDecoder", "no output from decoder available, break");
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void D(Runnable runnable) {
        int dequeueInputBuffer;
        this.frameCount = 0;
        do {
            boolean z;
            MediaExtractor mediaExtractor = this.opL;
            if (this.opN == null) {
                x.i("MicroMsg.MediaCodecTranscodeDecoder", "input decoder is null");
                z = true;
            } else {
                ByteBuffer[] inputBuffers = this.opN.getInputBuffers();
                if (inputBuffers == null) {
                    z = false;
                } else {
                    x.i("MicroMsg.MediaCodecTranscodeDecoder", "decoderInputByteBuffers size: %d", new Object[]{Integer.valueOf(inputBuffers.length)});
                    int i = 0;
                    while (true) {
                        dequeueInputBuffer = this.opN.dequeueInputBuffer(60000);
                        if (dequeueInputBuffer < 0 && i < 15) {
                            long Wq = bh.Wq();
                            boolean bbk = bbk();
                            x.i("MicroMsg.MediaCodecTranscodeDecoder", "drain cost1 %d", new Object[]{Long.valueOf(bh.bA(Wq))});
                            if (bbk) {
                                break;
                            }
                            i++;
                        }
                    }
                    z = true;
                }
            }
            if (z) {
                break;
            }
            this.opL.advance();
        } while (this.opL.getSampleTrackIndex() == this.oyf);
        x.i("MicroMsg.MediaCodecTranscodeDecoder", "track index not match, break");
        MediaExtractor mediaExtractor2 = this.opL;
        x.i("MicroMsg.MediaCodecTranscodeDecoder", "sendDecoderEOS");
        ByteBuffer[] inputBuffers2 = this.opN.getInputBuffers();
        dequeueInputBuffer = this.opN.dequeueInputBuffer(60000);
        if (dequeueInputBuffer < 0) {
            x.i("MicroMsg.MediaCodecTranscodeDecoder", "check decoder input buffer index = %d count = %d", new Object[]{Integer.valueOf(dequeueInputBuffer), Integer.valueOf(0)});
        }
        if (dequeueInputBuffer >= 0) {
            ByteBuffer byteBuffer = inputBuffers2[dequeueInputBuffer];
            byteBuffer.clear();
            this.sampleSize = mediaExtractor2.readSampleData(byteBuffer, 0);
            byteBuffer.position(0);
            Wq = mediaExtractor2.getSampleTime();
            if (dequeueInputBuffer >= 0) {
                x.i("MicroMsg.MediaCodecTranscodeDecoder", "send EOS, decoderInputBufferIndex: %s", new Object[]{Integer.valueOf(dequeueInputBuffer)});
                this.opN.queueInputBuffer(dequeueInputBuffer, 0, 0, Wq * 1000, 4);
            } else {
                x.w("MicroMsg.MediaCodecTranscodeDecoder", "input buffer not available");
            }
        }
        bbk();
        ag.h(new Runnable(this) {
            final /* synthetic */ i oym;

            {
                this.oym = r1;
            }

            public final void run() {
                if (this.oym.opN != null) {
                    x.i("MicroMsg.MediaCodecTranscodeDecoder", "delay to stop decoder");
                    try {
                        this.oym.opN.stop();
                        this.oym.opN.release();
                        this.oym.opN = null;
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.MediaCodecTranscodeDecoder", e, "delay to stop decoder error: %s", new Object[]{e.getMessage()});
                    }
                }
            }
        }, 500);
        runnable.run();
    }

    public final void a(a aVar) {
        this.oxs = aVar;
    }

    public int baY() {
        x.i("MicroMsg.MediaCodecTranscodeDecoder", "src color format: %s", new Object[]{Integer.valueOf(this.oxL.getInteger("color-format"))});
        switch (this.oxL.getInteger("color-format")) {
            case 19:
                return 2;
            default:
                return 1;
        }
    }

    public final Point baV() {
        return new Point(this.oxL.getInteger("width"), this.oxL.getInteger("height"));
    }

    public final void stop() {
        if (this.opN != null) {
            try {
                x.i("MicroMsg.MediaCodecTranscodeDecoder", "stop decoder");
                this.opN.stop();
                this.opN.release();
                this.opN = null;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MediaCodecTranscodeDecoder", e, "stop decoder error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    public final void sS(int i) {
        x.i("MicroMsg.MediaCodecTranscodeDecoder", "setFrameDropInterval: %s", new Object[]{Integer.valueOf(i)});
        this.owP = i;
    }
}
