package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Process;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class l$a implements Runnable {
    int duration;
    Runnable fqI = null;
    boolean ovA = false;
    final Object ovB = new Object();
    final /* synthetic */ l ovs;
    int ovt;
    volatile int ovu = 0;
    float ovv;
    volatile boolean ovw = true;
    boolean ovx = false;
    boolean ovy = false;
    boolean ovz = false;

    public l$a(l lVar) {
        this.ovs = lVar;
        synchronized (this.ovB) {
            try {
                String mg = FileOp.mg(lVar.ouU);
                if (!mg.endsWith("/")) {
                    mg = mg + "/";
                }
                lVar.ovd = mg + "tempRotate.mp4";
            } catch (Exception e) {
                x.e("MicroMsg.MMSightFFMpegRecorder", "retrieve file name error: %s", e.getMessage());
            }
        }
    }

    public final void run() {
        if (this.ovs.ovh == -1) {
            this.ovs.ovh = Process.myTid();
            Process.setThreadPriority(Process.myTid(), -2);
            x.i("MicroMsg.MMSightFFMpegRecorder", "encodeTid: %s", Integer.valueOf(this.ovs.ovh));
        }
        synchronized (this.ovB) {
            long Wq;
            while (!this.ovy) {
                Wq = bh.Wq();
                int triggerEncode = SightVideoJNI.triggerEncode(this.ovt, Math.max(0, this.ovu), false);
                x.i("MicroMsg.MMSightFFMpegRecorder", "ing: trgger encode use %dms, Encode index[%d, %d), threadId: %s", Long.valueOf(bh.bA(Wq)), Integer.valueOf(this.ovu), Integer.valueOf(triggerEncode), Long.valueOf(Thread.currentThread().getId()));
                if (Math.abs(triggerEncode - this.ovu) <= 5) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        x.e("MicroMsg.MMSightFFMpegRecorder", "thread sleep error");
                    }
                }
                this.ovu = triggerEncode;
            }
            Wq = bh.Wq();
            if (!this.ovz) {
                this.ovu = SightVideoJNI.triggerEncode(this.ovt, this.ovu, true);
            }
            x.i("MicroMsg.MMSightFFMpegRecorder", "end: trgger encode use %dms, curEncode index %d, markCancel %B, threadId: %s", Long.valueOf(bh.bA(Wq)), Integer.valueOf(this.ovu), Boolean.valueOf(this.ovz), Long.valueOf(Thread.currentThread().getId()));
            if (!this.ovz) {
                this.ovs.ouT = new m(this.ovt, this.ovs.ouU, this.ovv, this.ovs.ouZ, Math.max(1000, this.duration), this.ovs.oqJ.audioSampleRate);
                Wq = bh.Wq();
                x.i("MicroMsg.MMSightFFMpegRecorder", "mux used %sms, success: %s", Long.valueOf(bh.bA(Wq)), Boolean.valueOf(this.ovs.ouT.baH()));
                if (!this.ovs.ouT.baH()) {
                    x.e("MicroMsg.MMSightFFMpegRecorder", "mux failed!");
                    SightVideoJNI.releaseBigSightDataBuffer(this.ovt);
                    ag.y(new Runnable(this) {
                        final /* synthetic */ l$a ovC;

                        {
                            this.ovC = r1;
                        }

                        public final void run() {
                            if (this.ovC.ovs.ovo != null) {
                                this.ovC.ovs.ovo.Yn();
                            }
                        }
                    });
                    x.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegCaptureMuxError");
                    g.pQN.a(440, 30, 1, false);
                    return;
                } else if ((this.ovs.ioU && this.ovs.oth) || (!(this.ovs.oth || this.ovs.ioU) || ((this.ovs.ioU && Math.abs(this.ovs.ovc - this.ovs.ovn) == 0) || this.ovs.ovn == 180))) {
                    int i;
                    long Wq2 = bh.Wq();
                    if (!this.ovs.oth && !this.ovs.ioU) {
                        i = this.ovs.ovc;
                    } else if (this.ovs.oth) {
                        i = this.ovs.ovn;
                    } else {
                        i = 180;
                    }
                    if (this.ovs.ovn == 180 && !this.ovs.oth) {
                        i += 180;
                        if (i > 360) {
                            i -= 360;
                        }
                    }
                    SightVideoJNI.tagRotateVideo(this.ovs.ouU, this.ovs.ovd, i);
                    x.i("MicroMsg.MMSightFFMpegRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", Long.valueOf(bh.bA(Wq2)), Integer.valueOf(this.ovs.ovc), Boolean.valueOf(this.ovs.ioU), Integer.valueOf(this.ovs.ovn), Integer.valueOf(i));
                    String str = this.ovs.ovd;
                    try {
                        FileOp.x(this.ovs.ovd, this.ovs.ouU);
                        e.post(new 3(this, str), "BigSightFFMpegRecorder_tagRotate_after_process");
                        x.i("MicroMsg.MMSightFFMpegRecorder", "tag rotate used %sms", Long.valueOf(bh.bA(Wq2)));
                    } catch (Exception e2) {
                        x.e("MicroMsg.MMSightFFMpegRecorder", "stop, copy file error");
                        SightVideoJNI.releaseBigSightDataBuffer(this.ovt);
                        ag.y(new 2(this));
                        return;
                    }
                }
            }
            SightVideoJNI.releaseBigSightDataBuffer(this.ovt);
            x.i("MicroMsg.MMSightFFMpegRecorder", "all finish, callback: %s", this.fqI);
            this.ovs.reset();
            ag.y(this.fqI);
            this.ovA = true;
            this.ovs.ovh = -1;
            this.ovs.ovg = -1;
        }
    }
}
