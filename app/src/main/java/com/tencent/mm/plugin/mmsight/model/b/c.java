package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Point;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    private long aBM;
    private int frameCount = 0;
    private boolean huK = false;
    a owL;
    private String owM;
    private long owN;
    private byte[] owO = null;
    private int owP = 0;
    double owQ;
    private int videoFps;

    public final int c(String str, long j, long j2, int i) {
        x.i("MicroMsg.FFMpegTranscodeDecoder", "initDecoder, srcFilePath: %s, start: %s, end: %s, videoFps: %s", new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)});
        this.owM = str;
        this.aBM = j;
        this.owN = j2;
        this.videoFps = i;
        this.owQ = 1000.0d / ((double) i);
        if (bh.ov(str)) {
            return -1;
        }
        long Wq = bh.Wq();
        int ffmpegOpenAndSeekFile = MP4MuxerJNI.ffmpegOpenAndSeekFile(str, ((double) j) * 1000.0d, ((double) j2) * 1000.0d);
        x.i("MicroMsg.FFMpegTranscodeDecoder", "ffmpegOpenAndSeekFile used %sms", new Object[]{Long.valueOf(bh.bA(Wq))});
        return ffmpegOpenAndSeekFile;
    }

    public final void baU() {
        x.i("MicroMsg.FFMpegTranscodeDecoder", "startDecodeBlockLoop");
        this.huK = true;
        this.frameCount = 0;
        while (this.huK) {
            long Wq = bh.Wq();
            this.owO = MP4MuxerJNI.ffmpegGetNextVideoFrameData(this.owO);
            x.d("MicroMsg.FFMpegTranscodeDecoder", "ffmpegGetNextVideoFrameData used %sms", new Object[]{Long.valueOf(bh.bA(Wq))});
            boolean ffmpegCheckIfReachEndTimestamp = MP4MuxerJNI.ffmpegCheckIfReachEndTimestamp();
            this.frameCount++;
            if (this.owP <= 1 || this.frameCount % this.owP != 0) {
                if (this.owL != null) {
                    a aVar = this.owL;
                    byte[] bArr = this.owO;
                    boolean z = this.owO == null || ffmpegCheckIfReachEndTimestamp;
                    aVar.a(bArr, z, (long) ((((double) this.frameCount) * this.owQ) * 1000.0d));
                }
                if (this.owO == null || ffmpegCheckIfReachEndTimestamp) {
                    x.e("MicroMsg.FFMpegTranscodeDecoder", "ret buffer is null or reachEnd? %s", new Object[]{Boolean.valueOf(ffmpegCheckIfReachEndTimestamp)});
                    x.i("MicroMsg.FFMpegTranscodeDecoder", "decode finish, frame count: %s", new Object[]{Integer.valueOf(this.frameCount)});
                    this.huK = false;
                    return;
                }
            }
        }
    }

    public static Point baV() {
        return new Point(MP4MuxerJNI.ffmpegGetVideoWidth(), MP4MuxerJNI.ffmpegGetVideoHeight());
    }
}
