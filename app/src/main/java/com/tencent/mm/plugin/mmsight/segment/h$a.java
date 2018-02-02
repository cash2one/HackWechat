package com.tencent.mm.plugin.mmsight.segment;

import android.os.Process;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class h$a implements Runnable {
    Object ovB;
    int ovh;
    volatile int ovu;
    boolean owX;
    final /* synthetic */ h oyk;

    private h$a(h hVar) {
        this.oyk = hVar;
        this.ovB = new Object();
    }

    public final void run() {
        if (this.ovh == -1) {
            this.ovh = Process.myTid();
            Process.setThreadPriority(Process.myTid(), -2);
            x.i("MicroMsg.MediaCodecFFMpegTranscoder", "encodeTid: %s", new Object[]{Integer.valueOf(this.ovh)});
        }
        this.ovu = 0;
        synchronized (this.ovB) {
            long Wq;
            while (!this.owX) {
                Wq = bh.Wq();
                x.i("MicroMsg.MediaCodecFFMpegTranscoder", "try trigger encode");
                int triggerEncodeForSegment = MP4MuxerJNI.triggerEncodeForSegment(Math.max(0, this.ovu), false);
                x.i("MicroMsg.MediaCodecFFMpegTranscoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[]{Long.valueOf(bh.bA(Wq)), Integer.valueOf(this.ovu), Integer.valueOf(triggerEncodeForSegment), Long.valueOf(Thread.currentThread().getId())});
                if (triggerEncodeForSegment == this.ovu) {
                    try {
                        Thread.sleep(20);
                    } catch (Exception e) {
                        x.e("MicroMsg.MediaCodecFFMpegTranscoder", "thread sleep error");
                    }
                }
                this.ovu = triggerEncodeForSegment;
            }
            Wq = bh.Wq();
            this.ovu = MP4MuxerJNI.triggerEncodeForSegment(this.ovu, true);
            x.i("MicroMsg.MediaCodecFFMpegTranscoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", new Object[]{Long.valueOf(bh.bA(Wq)), Integer.valueOf(this.ovu), Long.valueOf(Thread.currentThread().getId())});
        }
    }
}
