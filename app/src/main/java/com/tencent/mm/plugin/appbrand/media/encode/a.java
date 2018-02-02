package com.tencent.mm.plugin.appbrand.media.encode;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.mm.plugin.appbrand.media.j;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;

public final class a extends b {
    int jAe = 2;
    private MediaCodec jAf;
    BufferInfo jAg;
    private final int jAh = 100;
    private String mFilePath = "";

    public final boolean f(String str, int i, int i2, int i3) {
        boolean z;
        x.i("MicroMsg.AACAudioEncoder", "init, filePath:%s, sampleRate:%d, channelCount:%d, bitRate:%d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        this.mFilePath = str;
        try {
            x.i("MicroMsg.AACAudioEncoder", "initCodec");
            this.jAg = new BufferInfo();
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat(this.jAi, i, i2);
            createAudioFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, i3);
            createAudioFormat.setInteger("aac-profile", this.jAe);
            this.jAf = MediaCodec.createEncoderByType(this.jAi);
            this.jAf.configure(createAudioFormat, null, null, 1);
            this.jAf.start();
            x.i("MicroMsg.AACAudioEncoder", "encoder start to work");
            z = false;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AACAudioEncoder", e, "initCodec", new Object[0]);
            z = true;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.AACAudioEncoder", e2, "initCodec", new Object[0]);
            z = true;
        }
        if (z) {
            x.i("MicroMsg.AACAudioEncoder", "initCodec  fail,");
            j.kV(21);
            return false;
        }
        x.i("MicroMsg.AACAudioEncoder", "initCodec ok");
        if (M4aAudioFormatJni.createM4aFile(str, i2, i, this.jAe) == 0) {
            x.i("MicroMsg.AACAudioEncoder", "createM4aFile m4a jni api ok,");
            return true;
        }
        x.i("MicroMsg.AACAudioEncoder", "createM4aFile m4a jni api fail,");
        j.kV(22);
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(boolean z, byte[] bArr, int i) {
        if (bArr == null) {
            x.e("MicroMsg.AACAudioEncoder", "pcm is null");
            return false;
        } else if (this.jAf != null) {
            x.i("MicroMsg.AACAudioEncoder", "encodePCMToAAC endOfStream:%b", new Object[]{Boolean.valueOf(z)});
            ByteBuffer[] inputBuffers = this.jAf.getInputBuffers();
            ByteBuffer[] outputBuffers = this.jAf.getOutputBuffers();
            int dequeueInputBuffer = this.jAf.dequeueInputBuffer(100);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                byteBuffer.put(bArr);
                byteBuffer.position(0);
                byteBuffer.limit(bArr.length);
                x.i("MicroMsg.AACAudioEncoder", "inputBufferIndex:%d, data length:%d", new Object[]{Integer.valueOf(dequeueInputBuffer), Integer.valueOf(bArr.length)});
                if (z) {
                    this.jAf.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, System.nanoTime(), 4);
                    inputBuffers = outputBuffers;
                } else {
                    this.jAf.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, System.nanoTime(), 0);
                    inputBuffers = outputBuffers;
                }
            } else {
                x.e("MicroMsg.AACAudioEncoder", "inputBufferIndex %d", new Object[]{Integer.valueOf(dequeueInputBuffer)});
                inputBuffers = outputBuffers;
            }
            while (true) {
                dequeueInputBuffer = this.jAf.dequeueOutputBuffer(this.jAg, 100);
                if (dequeueInputBuffer == -1) {
                    break;
                } else if (dequeueInputBuffer == -3) {
                    x.e("MicroMsg.AACAudioEncoder", "output buff change");
                    inputBuffers = this.jAf.getOutputBuffers();
                } else if (dequeueInputBuffer == -2) {
                    x.e("MicroMsg.AACAudioEncoder", "encoder output format changed: " + this.jAf.getOutputFormat());
                } else if (dequeueInputBuffer < 0) {
                    x.e("MicroMsg.AACAudioEncoder", "unexpected result from encoder.dequeueOutputBuffer: %s", new Object[]{Integer.valueOf(dequeueInputBuffer)});
                } else {
                    x.i("MicroMsg.AACAudioEncoder", "outputBufferIndex %d", new Object[]{Integer.valueOf(dequeueInputBuffer)});
                    ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
                    if (byteBuffer2 == null) {
                        throw new RuntimeException("outputBuffer " + dequeueInputBuffer + " was null");
                    }
                    if ((this.jAg.flags & 2) != 0) {
                        x.e("MicroMsg.AACAudioEncoder", "flags is BUFFER_FLAG_CODEC_CONFIG, don't writ data into file");
                    } else {
                        int i2 = this.jAg.size;
                        byte[] bArr2 = new byte[i2];
                        byteBuffer2.get(bArr2, 0, i2);
                        int writeAudioBuff = M4aAudioFormatJni.writeAudioBuff(bArr2, i2);
                        c(bArr2, i2, false);
                        if (writeAudioBuff == 0) {
                            x.i("MicroMsg.AACAudioEncoder", "writeAudioBuff buff ok,");
                        } else {
                            x.i("MicroMsg.AACAudioEncoder", "writeAudioBuff buff fail,");
                        }
                    }
                    this.jAf.releaseOutputBuffer(dequeueInputBuffer, false);
                    if ((this.jAg.flags & 4) != 0) {
                        break;
                    }
                }
                return true;
            }
            if (z) {
                x.e("MicroMsg.AACAudioEncoder", "reach the end, and end to encode the data");
            } else {
                x.w("MicroMsg.AACAudioEncoder", "reached end of stream unexpectedly");
            }
            return true;
        } else {
            x.e("MicroMsg.AACAudioEncoder", "mEncoder is null");
            return false;
        }
    }

    public final void flush() {
        x.i("MicroMsg.AACAudioEncoder", "flush");
        c(new byte[0], 0, true);
    }

    public final void close() {
        x.i("MicroMsg.AACAudioEncoder", "close");
        if (this.jAf != null) {
            this.jAf.stop();
            this.jAf.release();
            this.jAf = null;
        }
        M4aAudioFormatJni.closeM4aFile();
    }
}
