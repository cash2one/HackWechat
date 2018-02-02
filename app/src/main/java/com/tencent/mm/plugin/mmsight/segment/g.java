package com.tencent.mm.plugin.mmsight.segment;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class g {
    private long aBM;
    String opJ = null;
    private MediaExtractor opL;
    private long owN;
    MediaCodec oxJ;
    MediaCodec oxK;
    MediaFormat oxL;
    MediaFormat oxM;
    VideoTransPara oxN;
    boolean oxO = true;
    List<byte[]> oxP = null;
    private boolean oxQ = false;
    private boolean oxR = false;
    private byte[] oxS;
    private HandlerThread oxT = null;
    private af oxU = null;

    public g(MediaExtractor mediaExtractor, MediaFormat mediaFormat, long j, long j2, VideoTransPara videoTransPara) {
        this.opL = mediaExtractor;
        this.oxL = mediaFormat;
        this.aBM = j;
        this.owN = j2;
        this.oxN = videoTransPara;
        this.opJ = mediaFormat.getString("mime");
        this.oxP = new ArrayList();
        x.i("MicroMsg.MediaCodecAACTranscoder", "create MediaCodecAACTranscoder, startTimeMs: %s, endTimeMs: %s, mime: %s, srcMediaFormat: %s, para: %s", new Object[]{Long.valueOf(j), Long.valueOf(j2), this.opJ, mediaFormat, videoTransPara});
    }

    public final void bbg() {
        this.oxQ = false;
        this.oxR = false;
        while (this.oxJ != null && this.opL != null) {
            try {
                ByteBuffer[] inputBuffers = this.oxJ.getInputBuffers();
                int dequeueInputBuffer = this.oxJ.dequeueInputBuffer(20000);
                if (dequeueInputBuffer < 0) {
                    x.d("MicroMsg.MediaCodecAACTranscoder", "decoder no input buffer available, drain first");
                    bbh();
                }
                if (dequeueInputBuffer >= 0) {
                    boolean z;
                    x.d("MicroMsg.MediaCodecAACTranscoder", "decoderInputBufferIndex: %d", new Object[]{Integer.valueOf(dequeueInputBuffer)});
                    ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                    byteBuffer.clear();
                    byteBuffer.position(0);
                    int readSampleData = this.opL.readSampleData(byteBuffer, 0);
                    long sampleTime = this.opL.getSampleTime();
                    this.opL.advance();
                    x.d("MicroMsg.MediaCodecAACTranscoder", "sampleSize: %s, pts: %s", new Object[]{Integer.valueOf(readSampleData), Long.valueOf(sampleTime)});
                    if (sampleTime >= this.owN * 1000 || sampleTime <= 0 || readSampleData <= 0) {
                        x.i("MicroMsg.MediaCodecAACTranscoder", "reach end time, send EOS and try delay stop decoder");
                        this.oxR = true;
                        ag.h(new 1(this), 500);
                        z = true;
                    } else {
                        z = false;
                    }
                    if (this.oxJ == null) {
                        return;
                    }
                    if (z) {
                        x.i("MicroMsg.MediaCodecAACTranscoder", "EOS received in sendAudioToEncoder");
                        this.oxJ.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, sampleTime, 4);
                    } else {
                        this.oxJ.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, sampleTime, 0);
                    }
                }
                bbh();
                if (this.oxR && this.oxK == null) {
                    return;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", e, "startTranscodeBlockLoop error: %s", new Object[]{e.getMessage()});
                return;
            }
        }
        x.e("MicroMsg.MediaCodecAACTranscoder", "startTranscodeBlockLoop error");
    }

    private void bbh() {
        if (this.oxJ != null) {
            try {
                ByteBuffer[] outputBuffers = this.oxJ.getOutputBuffers();
                BufferInfo bufferInfo = new BufferInfo();
                ByteBuffer[] byteBufferArr = outputBuffers;
                while (true) {
                    int dequeueOutputBuffer = this.oxJ.dequeueOutputBuffer(bufferInfo, 20000);
                    x.d("MicroMsg.MediaCodecAACTranscoder", "decoderOutputBufferIndex: %s", new Object[]{Integer.valueOf(dequeueOutputBuffer)});
                    if (dequeueOutputBuffer == -1) {
                        x.d("MicroMsg.MediaCodecAACTranscoder", "no output available, break");
                        return;
                    } else if (dequeueOutputBuffer == -3) {
                        byteBufferArr = this.oxJ.getOutputBuffers();
                    } else if (dequeueOutputBuffer == -2) {
                        this.oxL = this.oxJ.getOutputFormat();
                        x.i("MicroMsg.MediaCodecAACTranscoder", "srcMediaFormat change: %s", new Object[]{this.oxL});
                    } else if (dequeueOutputBuffer < 0) {
                        x.e("MicroMsg.MediaCodecAACTranscoder", "unexpected decoderOutputBufferIndex: %s", new Object[]{Integer.valueOf(dequeueOutputBuffer)});
                    } else {
                        x.v("MicroMsg.MediaCodecAACTranscoder", "perform decoding");
                        ByteBuffer byteBuffer = byteBufferArr[dequeueOutputBuffer];
                        if (byteBuffer == null) {
                            x.e("MicroMsg.MediaCodecAACTranscoder", "ERROR, retrieve decoderOutputBuffer is null!!");
                            return;
                        }
                        if ((bufferInfo.flags & 2) != 0) {
                            x.e("MicroMsg.MediaCodecAACTranscoder", "ignore BUFFER_FLAG_CODEC_CONFIG");
                            bufferInfo.size = 0;
                        }
                        if (bufferInfo.size > 0) {
                            byteBuffer.position(bufferInfo.offset);
                            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                            a(byteBuffer, bufferInfo, (bufferInfo.flags & 4) != 0);
                        }
                        this.oxJ.releaseOutputBuffer(dequeueOutputBuffer, false);
                        if ((bufferInfo.flags & 4) != 0) {
                            break;
                        }
                    }
                }
                x.i("MicroMsg.MediaCodecAACTranscoder", "receive EOS!");
                if (this.oxJ != null) {
                    this.oxJ.stop();
                    this.oxJ.release();
                    this.oxJ = null;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", e, "drainDecoder error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    private void a(ByteBuffer byteBuffer, BufferInfo bufferInfo, boolean z) {
        if (byteBuffer != null) {
            x.d("MicroMsg.MediaCodecAACTranscoder", "processDecodeBuffer, EOS: %s, finishGetAllInputAACData: %s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(this.oxR)});
            if (this.oxO) {
                if (!this.oxQ) {
                    bbi();
                    this.oxQ = true;
                }
                if (this.oxS == null) {
                    this.oxS = new byte[byteBuffer.remaining()];
                    byteBuffer.get(this.oxS, 0, byteBuffer.remaining());
                }
                a(this.oxS, bufferInfo.presentationTimeUs, z);
                return;
            }
            Object obj = new byte[byteBuffer.remaining()];
            byteBuffer.get(obj, 0, byteBuffer.remaining());
            this.oxP.add(obj);
            if (this.oxR || z) {
                try {
                    this.oxJ.stop();
                    this.oxJ.release();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", e, "", new Object[0]);
                }
                bbi();
                this.oxQ = true;
                int i = 0;
                for (byte[] bArr : this.oxP) {
                    boolean z2;
                    long j = bufferInfo.presentationTimeUs;
                    if (i >= this.oxP.size() - 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    a(bArr, j, z2);
                    i++;
                }
            }
        }
    }

    private void bbi() {
        if (this.oxK == null || !this.oxO || this.oxQ) {
            try {
                this.oxM = new MediaFormat();
                this.oxM.setString("mime", "audio/mp4a-latm");
                this.oxM.setInteger("aac-profile", 2);
                this.oxM.setInteger("sample-rate", this.oxN.audioSampleRate);
                this.oxM.setInteger("channel-count", 1);
                this.oxM.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.oxN.huc);
                this.oxM.setInteger("max-input-size", 16384);
                this.oxK = MediaCodec.createEncoderByType(this.opJ);
                this.oxK.configure(this.oxM, null, null, 1);
                this.oxK.start();
                x.i("MicroMsg.MediaCodecAACTranscoder", "checkInitAndStartEncoder, not canEncodeDecodeBothExist, create new encoder");
                return;
            } catch (Exception e) {
                x.e("MicroMsg.MediaCodecAACTranscoder", "checkInitAndStartEncoder, not canEncodeDecodeBothExist, error: %s", new Object[]{e.getMessage()});
                return;
            }
        }
        this.oxJ.start();
    }

    private void a(byte[] bArr, long j, boolean z) {
        if (this.oxK != null && bArr != null) {
            ByteBuffer[] inputBuffers = this.oxK.getInputBuffers();
            int dequeueInputBuffer = this.oxK.dequeueInputBuffer(20000);
            if (dequeueInputBuffer < 0) {
                x.d("MicroMsg.MediaCodecAACTranscoder", "encoder no input buffer available, drain first");
                baS();
            }
            if (dequeueInputBuffer >= 0) {
                int i;
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                byteBuffer.position(0);
                byteBuffer.put(bArr);
                if (z) {
                    x.i("MicroMsg.MediaCodecAACTranscoder", "last, send EOS and try delay stop encoder");
                    i = 1;
                    ag.h(new 2(this), 500);
                } else {
                    i = 0;
                }
                if (this.oxK == null) {
                    return;
                }
                if (i != 0) {
                    x.i("MicroMsg.MediaCodecAACTranscoder", "EOS received in sendAudioToEncoder");
                    this.oxK.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, j, 4);
                } else {
                    this.oxK.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, j, 0);
                }
            }
            baS();
        }
    }

    private void baS() {
        if (this.oxK != null) {
            try {
                ByteBuffer[] outputBuffers = this.oxK.getOutputBuffers();
                BufferInfo bufferInfo = new BufferInfo();
                while (true) {
                    int dequeueOutputBuffer = this.oxK.dequeueOutputBuffer(bufferInfo, 20000);
                    x.d("MicroMsg.MediaCodecAACTranscoder", "encoderOutputBufferIndex: %s", new Object[]{Integer.valueOf(dequeueOutputBuffer)});
                    if (dequeueOutputBuffer == -1) {
                        x.d("MicroMsg.MediaCodecAACTranscoder", "no output available, break");
                        return;
                    } else if (dequeueOutputBuffer == -3) {
                        outputBuffers = this.oxK.getOutputBuffers();
                    } else if (dequeueOutputBuffer == -2) {
                        this.oxM = this.oxK.getOutputFormat();
                        x.i("MicroMsg.MediaCodecAACTranscoder", "dstMediaFormat change: %s", new Object[]{this.oxM});
                    } else if (dequeueOutputBuffer < 0) {
                        x.e("MicroMsg.MediaCodecAACTranscoder", "unexpected encoderOutputBufferIndex: %s", new Object[]{Integer.valueOf(dequeueOutputBuffer)});
                    } else {
                        x.v("MicroMsg.MediaCodecAACTranscoder", "perform encoding");
                        ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                        if (byteBuffer == null) {
                            x.e("MicroMsg.MediaCodecAACTranscoder", "ERROR, retrieve encoderOutputBuffer is null!!");
                            return;
                        }
                        if (bufferInfo.size > 0) {
                            byteBuffer.position(bufferInfo.offset);
                            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                            if (byteBuffer != null) {
                                MP4MuxerJNI.writeAACData(0, byteBuffer, bufferInfo.size);
                            }
                        }
                        this.oxK.releaseOutputBuffer(dequeueOutputBuffer, false);
                        if ((bufferInfo.flags & 4) != 0) {
                            break;
                        }
                    }
                }
                x.i("MicroMsg.MediaCodecAACTranscoder", "receive EOS!");
                if (this.oxK != null) {
                    this.oxK.stop();
                    this.oxK.release();
                    this.oxK = null;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", e, "drainEncoder error: %s", new Object[]{e.getMessage()});
            }
        }
    }
}
