package com.tencent.mm.plugin.mmsight.model.b;

import android.os.Process;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class e$a implements Runnable {
    Object ovB;
    int ovh;
    volatile int ovu;
    boolean owX;
    final /* synthetic */ e owY;

    private e$a(e eVar) {
        this.owY = eVar;
        this.ovB = new Object();
    }

    public final void run() {
        if (this.ovh == -1) {
            this.ovh = Process.myTid();
            Process.setThreadPriority(Process.myTid(), -2);
            x.i("MicroMsg.MMSightRemuxX264Encoder", "encodeTid: %s", Integer.valueOf(this.ovh));
        }
        this.ovu = 0;
        synchronized (this.ovB) {
            long Wq;
            while (!this.owX) {
                Wq = bh.Wq();
                x.i("MicroMsg.MMSightRemuxX264Encoder", "try trigger encode");
                int triggerEncodeForSegment = MP4MuxerJNI.triggerEncodeForSegment(Math.max(0, this.ovu), false);
                x.i("MicroMsg.MMSightRemuxX264Encoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", Long.valueOf(bh.bA(Wq)), Integer.valueOf(this.ovu), Integer.valueOf(triggerEncodeForSegment), Long.valueOf(Thread.currentThread().getId()));
                if (triggerEncodeForSegment == this.ovu) {
                    try {
                        Thread.sleep(20);
                    } catch (Exception e) {
                        x.e("MicroMsg.MMSightRemuxX264Encoder", "thread sleep error");
                    }
                }
                this.ovu = triggerEncodeForSegment;
            }
            Wq = bh.Wq();
            this.ovu = MP4MuxerJNI.triggerEncodeForSegment(this.ovu, true);
            x.i("MicroMsg.MMSightRemuxX264Encoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", Long.valueOf(bh.bA(Wq)), Integer.valueOf(this.ovu), Long.valueOf(Thread.currentThread().getId()));
        }
    }
}
