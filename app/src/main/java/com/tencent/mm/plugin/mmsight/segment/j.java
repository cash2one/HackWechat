package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.graphics.ImageFormat;
import android.media.Image;
import android.media.Image.Plane;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;

@TargetApi(21)
public final class j extends i {
    public static String TAG = "MicroMsg.MediaCodecTranscodeDecoder21";

    public j(MediaExtractor mediaExtractor, MediaFormat mediaFormat, int i) {
        super(mediaExtractor, mediaFormat, i);
        x.i(TAG, "init ");
    }

    protected final int a(MediaCodecInfo mediaCodecInfo, String str) {
        x.i(TAG, "selectColorFormat, mimeType: %s, codecInfo: %s", new Object[]{str, mediaCodecInfo});
        long Wq = bh.Wq();
        CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        x.i(TAG, "getCapabilitiesForType used %sms", new Object[]{Long.valueOf(bh.bA(Wq))});
        x.i(TAG, "color format length: %s", new Object[]{Integer.valueOf(capabilitiesForType.colorFormats.length)});
        int i = 0;
        for (int i2 : capabilitiesForType.colorFormats) {
            x.i(TAG, "capabilities colorFormat: %s", new Object[]{Integer.valueOf(i2)});
            if (sT(i2) && (i2 > i || i2 == 2135033992)) {
                i = i2;
            }
        }
        x.i(TAG, "codec: %s, colorFormat: %s", new Object[]{mediaCodecInfo.getName(), Integer.valueOf(i)});
        return i;
    }

    protected final boolean sT(int i) {
        switch (i) {
            case 2135033992:
                return true;
            default:
                return false;
        }
    }

    protected final boolean bbk() {
        if (this.opN == null) {
            x.e(TAG, "drainDecoder, decoder is null");
            return true;
        }
        int dequeueOutputBuffer = this.opN.dequeueOutputBuffer(this.owd, 60000);
        x.i(TAG, "outputBufferIndex-->" + dequeueOutputBuffer);
        while (dequeueOutputBuffer != -1) {
            if (dequeueOutputBuffer == -3) {
                x.i(TAG, "decoder output buffers changed");
            } else if (dequeueOutputBuffer == -2) {
                this.oxL = this.opN.getOutputFormat();
                x.i(TAG, "decoder output format changed: " + this.oxL);
            } else if (dequeueOutputBuffer < 0) {
                x.w(TAG, "unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                x.v(TAG, "perform decoding");
                long Wq = bh.Wq();
                byte[] a = a(this.opN.getOutputImage(dequeueOutputBuffer));
                x.v(TAG, "perform decoding costImage %s", new Object[]{Long.valueOf(bh.bA(Wq))});
                if (a == null) {
                    break;
                } else if (a.length != 0) {
                    BufferInfo bufferInfo = this.owd;
                    if (a == null) {
                        x.e(TAG, "processDecodeOutputBuffer error! byteBuffer is null");
                    } else {
                        x.i(TAG, "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d", new Object[]{a, bufferInfo, Integer.valueOf(bufferInfo.size)});
                        this.oxL = this.opN.getOutputFormat();
                        if (this.oxs != null) {
                            this.oxs.aA(a);
                        }
                    }
                    this.opN.releaseOutputBuffer(dequeueOutputBuffer, false);
                    long j = this.owd.presentationTimeUs;
                    if (this.owN != 1 && j >= this.owN * 1000) {
                        x.e(TAG, "exceed endTimeMs");
                        return true;
                    } else if ((this.owd.flags & 4) == 0) {
                        return false;
                    } else {
                        x.i(TAG, "receive end of stream");
                        try {
                            this.opN.stop();
                            this.opN.release();
                            this.opN = null;
                            return true;
                        } catch (Exception e) {
                            x.e(TAG, "stop and release decoder error: %s", new Object[]{e.getMessage()});
                            return true;
                        }
                    }
                } else {
                    this.opN.releaseOutputBuffer(dequeueOutputBuffer, false);
                }
            }
            dequeueOutputBuffer = this.opN.dequeueOutputBuffer(this.owd, 60000);
            if (dequeueOutputBuffer < 0) {
                break;
            }
        }
        x.i(TAG, "no output from decoder available, break");
        return false;
    }

    public final int baY() {
        return 2;
    }

    private static byte[] a(Image image) {
        int format = image.getFormat();
        int width = image.getWidth();
        int height = image.getHeight();
        int i = 0;
        Plane[] planes = image.getPlanes();
        x.i(TAG, "planes len %d, datalen: %s width %d height %d format %d", new Object[]{Integer.valueOf(planes.length), Integer.valueOf(((width * height) * ImageFormat.getBitsPerPixel(format)) / 8), Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(format)});
        byte[] h = com.tencent.mm.plugin.mmsight.model.a.j.ouM.h(Integer.valueOf(r3));
        int i2 = 0;
        while (i2 < planes.length) {
            ByteBuffer buffer = planes[i2].getBuffer();
            int rowStride = planes[i2].getRowStride();
            int pixelStride = planes[i2].getPixelStride();
            int i3 = i2 == 0 ? width : width / 2;
            format = i2 == 0 ? height : height / 2;
            x.v(TAG, "row planes rowStride %d w %d h %d pixelStride %d", new Object[]{Integer.valueOf(rowStride), Integer.valueOf(i3), Integer.valueOf(format), Integer.valueOf(pixelStride)});
            byte[] h2 = com.tencent.mm.plugin.mmsight.model.a.j.ouM.h(Integer.valueOf(rowStride));
            for (int i4 = 0; i4 < format; i4++) {
                int bitsPerPixel = ImageFormat.getBitsPerPixel(35) / 8;
                if (pixelStride == bitsPerPixel) {
                    bitsPerPixel *= i3;
                    buffer.get(h, i, bitsPerPixel);
                    if (format - i4 != 1) {
                        buffer.position((buffer.position() + rowStride) - bitsPerPixel);
                    }
                    i += bitsPerPixel;
                } else {
                    if (format - i4 == 1) {
                        buffer.get(h2, 0, (width - pixelStride) + 1);
                    } else {
                        buffer.get(h2, 0, rowStride);
                    }
                    bitsPerPixel = 0;
                    while (bitsPerPixel < i3) {
                        int i5 = i + 1;
                        h[i] = h2[bitsPerPixel * pixelStride];
                        bitsPerPixel++;
                        i = i5;
                    }
                }
            }
            com.tencent.mm.plugin.mmsight.model.a.j.ouM.D(h2);
            i2++;
        }
        return h;
    }
}
