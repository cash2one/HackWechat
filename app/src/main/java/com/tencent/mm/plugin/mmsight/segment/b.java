package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Point;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class b implements e {
    private long aBM;
    private int frameCount = 0;
    private boolean huK = false;
    private String owM;
    private long owN;
    private byte[] owO = null;
    private int owP;
    private e$a oxs;

    public final int q(String str, long j, long j2) {
        x.i("MicroMsg.FFMpegTranscodeDecoder", "initDecoder, srcFilePath: %s, start: %s, end: %s", new Object[]{str, Long.valueOf(j), Long.valueOf(j2)});
        this.owM = str;
        this.aBM = j;
        this.owN = j2;
        if (bh.ov(str)) {
            return -1;
        }
        long Wq = bh.Wq();
        int ffmpegOpenAndSeekFile = MP4MuxerJNI.ffmpegOpenAndSeekFile(str, ((double) j) * 1000.0d, ((double) j2) * 1000.0d);
        x.i("MicroMsg.FFMpegTranscodeDecoder", "ffmpegOpenAndSeekFile used %sms", new Object[]{Long.valueOf(bh.bA(Wq))});
        return ffmpegOpenAndSeekFile;
    }

    public final void D(Runnable runnable) {
        x.i("MicroMsg.FFMpegTranscodeDecoder", "startDecodeBlockLoop");
        this.huK = true;
        this.frameCount = 0;
        while (this.huK) {
            long Wq = bh.Wq();
            this.owO = MP4MuxerJNI.ffmpegGetNextVideoFrameData(this.owO);
            x.d("MicroMsg.FFMpegTranscodeDecoder", "ffmpegGetNextVideoFrameData used %sms", new Object[]{Long.valueOf(bh.bA(Wq))});
            boolean ffmpegCheckIfReachEndTimestamp = MP4MuxerJNI.ffmpegCheckIfReachEndTimestamp();
            if (this.owO == null || ffmpegCheckIfReachEndTimestamp) {
                x.e("MicroMsg.FFMpegTranscodeDecoder", "ret buffer is null or reachEnd? %s", new Object[]{Boolean.valueOf(ffmpegCheckIfReachEndTimestamp)});
                this.huK = false;
                runnable.run();
                return;
            }
            this.frameCount++;
            if ((this.owP <= 1 || this.frameCount % this.owP != 0) && this.oxs != null) {
                this.oxs.aA(this.owO);
            }
        }
    }

    public final void a(e$a com_tencent_mm_plugin_mmsight_segment_e_a) {
        this.oxs = com_tencent_mm_plugin_mmsight_segment_e_a;
    }

    public final Point baV() {
        return new Point(MP4MuxerJNI.ffmpegGetVideoWidth(), MP4MuxerJNI.ffmpegGetVideoHeight());
    }

    public final void stop() {
        x.i("MicroMsg.FFMpegTranscodeDecoder", "stop, start: %s", new Object[]{Boolean.valueOf(this.huK)});
        this.huK = false;
    }

    public final int baY() {
        return 2;
    }

    public final void sS(int i) {
        x.i("MicroMsg.FFMpegTranscodeDecoder", "setFrameDropInterval: %s", new Object[]{Integer.valueOf(i)});
        this.owP = i;
    }
}
