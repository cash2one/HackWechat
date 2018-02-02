package com.tencent.mm.plugin.music.model.g;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;

class e$1 implements Runnable {
    final /* synthetic */ e oMq;

    e$1(e eVar) {
        this.oMq = eVar;
    }

    public final void run() {
        x.i("MicroMsg.Music.MMPlayer", "starting...");
        Process.setThreadPriority(-19);
        if (bh.ov(this.oMq.oMn)) {
            x.e("MicroMsg.Music.MMPlayer", "source path is null");
            this.oMq.gW(false);
            return;
        }
        this.oMq.opL = new MediaExtractor();
        try {
            this.oMq.opL.setDataSource(this.oMq.oMn);
            MediaFormat mediaFormat = null;
            try {
                int readSampleData;
                MediaFormat trackFormat;
                x.e("MicroMsg.Music.MMPlayer", "tractCount is %d", new Object[]{Integer.valueOf(this.oMq.opL.getTrackCount())});
                for (int i = 0; i < readSampleData; i++) {
                    trackFormat = this.oMq.opL.getTrackFormat(i);
                    this.oMq.opJ = trackFormat.getString("mime");
                    if (!bh.ov(this.oMq.opJ) && this.oMq.opJ.startsWith("audio/")) {
                        mediaFormat = trackFormat;
                        break;
                    }
                }
                if (mediaFormat == null) {
                    x.e("MicroMsg.Music.MMPlayer", "format is null");
                    this.oMq.hey = 703;
                    this.oMq.gW(true);
                    e.a(this.oMq);
                    return;
                }
                x.i("MicroMsg.Music.MMPlayer", "format:%s", new Object[]{mediaFormat});
                this.oMq.sampleRate = mediaFormat.getInteger("sample-rate");
                this.oMq.channels = mediaFormat.getInteger("channel-count");
                this.oMq.duration = mediaFormat.getLong("durationUs");
                try {
                    this.oMq.apB = MediaCodec.createDecoderByType(this.oMq.opJ);
                    this.oMq.apB.configure(mediaFormat, null, null, 0);
                    this.oMq.apB.start();
                    ByteBuffer[] inputBuffers = this.oMq.apB.getInputBuffers();
                    ByteBuffer[] outputBuffers = this.oMq.apB.getOutputBuffers();
                    x.i("MicroMsg.Music.MMPlayer", "Track info: extractorFormat: %s mime: %s sampleRate: %s channels: %s duration: %s", new Object[]{mediaFormat, this.oMq.opJ, Integer.valueOf(this.oMq.sampleRate), Integer.valueOf(this.oMq.channels), Long.valueOf(this.oMq.duration)});
                    this.oMq.opL.selectTrack(0);
                    BufferInfo bufferInfo = new BufferInfo();
                    Object obj = null;
                    this.oMq.oMh.oMM = 3;
                    this.oMq.onStart();
                    ByteBuffer[] byteBufferArr = outputBuffers;
                    int i2 = 0;
                    Object obj2 = null;
                    while (obj == null && i2 < 50) {
                        try {
                            this.oMq.beC();
                            if (!this.oMq.bey()) {
                                break;
                            }
                            Object obj3;
                            int dequeueOutputBuffer;
                            ByteBuffer byteBuffer;
                            byte[] bArr;
                            ByteBuffer[] outputBuffers2;
                            int i3 = i2 + 1;
                            if (obj2 == null) {
                                i2 = this.oMq.apB.dequeueInputBuffer(1000);
                                if (i2 >= 0) {
                                    Object obj4;
                                    readSampleData = this.oMq.opL.readSampleData(inputBuffers[i2], 0);
                                    if (readSampleData < 0) {
                                        x.e("MicroMsg.Music.MMPlayer", "saw input EOS. Stopping playback");
                                        obj4 = 1;
                                        readSampleData = 0;
                                    } else {
                                        this.oMq.presentationTimeUs = this.oMq.opL.getSampleTime();
                                        this.oMq.tF(this.oMq.duration == 0 ? 0 : (int) ((100 * this.oMq.presentationTimeUs) / this.oMq.duration));
                                        obj4 = obj2;
                                    }
                                    this.oMq.apB.queueInputBuffer(i2, 0, readSampleData, this.oMq.presentationTimeUs, obj4 != null ? 4 : 0);
                                    if (obj4 == null) {
                                        this.oMq.opL.advance();
                                    }
                                    obj3 = obj4;
                                    dequeueOutputBuffer = this.oMq.apB.dequeueOutputBuffer(bufferInfo, 1000);
                                    if (dequeueOutputBuffer >= 0) {
                                        if (bufferInfo.size <= 0) {
                                            i2 = 0;
                                        } else {
                                            i2 = i3;
                                        }
                                        byteBuffer = byteBufferArr[dequeueOutputBuffer];
                                        bArr = new byte[bufferInfo.size];
                                        byteBuffer.get(bArr);
                                        byteBuffer.clear();
                                        if (bArr.length > 0) {
                                            if (this.oMq.afZ == null) {
                                                if (this.oMq.createAudioTrack()) {
                                                    x.e("MicroMsg.Music.MMPlayer", "audio track not initialized");
                                                    this.oMq.hey = 707;
                                                    this.oMq.gW(true);
                                                    return;
                                                }
                                                this.oMq.afZ.play();
                                            }
                                            this.oMq.afZ.write(bArr, 0, bArr.length);
                                            this.oMq.oMo = true;
                                        }
                                        this.oMq.apB.releaseOutputBuffer(dequeueOutputBuffer, false);
                                        if ((bufferInfo.flags & 4) == 0) {
                                            x.e("MicroMsg.Music.MMPlayer", "saw output EOS.");
                                            obj2 = 1;
                                        } else {
                                            obj2 = obj;
                                        }
                                        obj = obj2;
                                        obj2 = obj3;
                                    } else if (dequeueOutputBuffer == -3) {
                                        outputBuffers2 = this.oMq.apB.getOutputBuffers();
                                        x.i("MicroMsg.Music.MMPlayer", "output buffers have changed.");
                                        i2 = i3;
                                        byteBufferArr = outputBuffers2;
                                        obj2 = obj3;
                                    } else if (dequeueOutputBuffer != -2) {
                                        trackFormat = this.oMq.apB.getOutputFormat();
                                        x.i("MicroMsg.Music.MMPlayer", "output format has changed to " + trackFormat);
                                        this.oMq.sampleRate = trackFormat.getInteger("sample-rate");
                                        this.oMq.channels = trackFormat.getInteger("channel-count");
                                        e.c(this.oMq);
                                        i2 = i3;
                                        obj2 = obj3;
                                    } else {
                                        x.i("MicroMsg.Music.MMPlayer", "dequeueOutputBuffer returned " + dequeueOutputBuffer);
                                        i2 = i3;
                                        obj2 = obj3;
                                    }
                                } else {
                                    x.e("MicroMsg.Music.MMPlayer", "inputBufIndex " + i2);
                                }
                            }
                            obj3 = obj2;
                            dequeueOutputBuffer = this.oMq.apB.dequeueOutputBuffer(bufferInfo, 1000);
                            if (dequeueOutputBuffer >= 0) {
                                if (bufferInfo.size <= 0) {
                                    i2 = i3;
                                } else {
                                    i2 = 0;
                                }
                                byteBuffer = byteBufferArr[dequeueOutputBuffer];
                                bArr = new byte[bufferInfo.size];
                                byteBuffer.get(bArr);
                                byteBuffer.clear();
                                if (bArr.length > 0) {
                                    if (this.oMq.afZ == null) {
                                        if (this.oMq.createAudioTrack()) {
                                            this.oMq.afZ.play();
                                        } else {
                                            x.e("MicroMsg.Music.MMPlayer", "audio track not initialized");
                                            this.oMq.hey = 707;
                                            this.oMq.gW(true);
                                            return;
                                        }
                                    }
                                    this.oMq.afZ.write(bArr, 0, bArr.length);
                                    this.oMq.oMo = true;
                                }
                                this.oMq.apB.releaseOutputBuffer(dequeueOutputBuffer, false);
                                if ((bufferInfo.flags & 4) == 0) {
                                    obj2 = obj;
                                } else {
                                    x.e("MicroMsg.Music.MMPlayer", "saw output EOS.");
                                    obj2 = 1;
                                }
                                obj = obj2;
                                obj2 = obj3;
                            } else if (dequeueOutputBuffer == -3) {
                                outputBuffers2 = this.oMq.apB.getOutputBuffers();
                                x.i("MicroMsg.Music.MMPlayer", "output buffers have changed.");
                                i2 = i3;
                                byteBufferArr = outputBuffers2;
                                obj2 = obj3;
                            } else if (dequeueOutputBuffer != -2) {
                                x.i("MicroMsg.Music.MMPlayer", "dequeueOutputBuffer returned " + dequeueOutputBuffer);
                                i2 = i3;
                                obj2 = obj3;
                            } else {
                                trackFormat = this.oMq.apB.getOutputFormat();
                                x.i("MicroMsg.Music.MMPlayer", "output format has changed to " + trackFormat);
                                this.oMq.sampleRate = trackFormat.getInteger("sample-rate");
                                this.oMq.channels = trackFormat.getInteger("channel-count");
                                e.c(this.oMq);
                                i2 = i3;
                                obj2 = obj3;
                            }
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.Music.MMPlayer", e, "error", new Object[0]);
                            this.oMq.hey = 706;
                            this.oMq.gW(true);
                        } finally {
                            e.a(this.oMq);
                            e.b(this.oMq);
                            e.c(this.oMq);
                            this.oMq.oMn = null;
                            this.oMq.opJ = null;
                            this.oMq.sampleRate = 0;
                            this.oMq.channels = 0;
                            this.oMq.presentationTimeUs = 0;
                            this.oMq.duration = 0;
                        }
                    }
                    boolean z = (this.oMq.duration / 1000) - (this.oMq.presentationTimeUs / 1000) < 2000;
                    if (i2 >= 50) {
                        x.e("MicroMsg.Music.MMPlayer", "onError, noOutputCounter:%d", new Object[]{Integer.valueOf(i2)});
                        this.oMq.hey = 706;
                        this.oMq.gW(true);
                    } else {
                        x.i("MicroMsg.Music.MMPlayer", "onStop, isComplete:%b", new Object[]{Boolean.valueOf(z)});
                        this.oMq.gX(z);
                    }
                    e.a(this.oMq);
                    e.b(this.oMq);
                    e.c(this.oMq);
                    this.oMq.oMn = null;
                    this.oMq.opJ = null;
                    this.oMq.sampleRate = 0;
                    this.oMq.channels = 0;
                    this.oMq.presentationTimeUs = 0;
                    this.oMq.duration = 0;
                    x.i("MicroMsg.Music.MMPlayer", "stopping...");
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.Music.MMPlayer", e2, "createDecoderByType", new Object[0]);
                    this.oMq.hey = 704;
                    this.oMq.gW(true);
                    e.a(this.oMq);
                    e.b(this.oMq);
                }
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.Music.MMPlayer", e22, "get media format from media extractor", new Object[0]);
                this.oMq.hey = 705;
            }
        } catch (Throwable e222) {
            x.printErrStackTrace("MicroMsg.Music.MMPlayer", e222, "set extractor data source", new Object[0]);
            this.oMq.hey = 702;
            this.oMq.gW(true);
        }
    }
}
