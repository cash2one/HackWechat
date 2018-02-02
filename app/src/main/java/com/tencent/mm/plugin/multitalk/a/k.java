package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.pluginsdk.h.l;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.pb.talkroom.sdk.f;
import java.util.concurrent.LinkedBlockingQueue;

public final class k implements Runnable {
    boolean flS;
    protected volatile a oGq;
    protected LinkedBlockingQueue<c> oHa = new LinkedBlockingQueue();
    protected af[] oHb;
    volatile l oHc = new l("multitalk_network");
    private int oHd;
    private int oHe = 5;
    private int oHf;
    private int oHg;

    public k(a aVar) {
        this.oGq = aVar;
    }

    public final void start() {
        int i;
        x.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "current member size %d", new Object[]{Integer.valueOf(this.oHd)});
        this.flS = true;
        e.d(this, "MultiTalk_videoReceiver1", 1).start();
        e.d(this, "MultiTalk_videoReceiver2", 1).start();
        this.oHb = new af[2];
        for (i = 0; i < this.oHb.length; i++) {
            e.d(new a(this, i), "MultiTalkVideoTaskManager_drawer_handler", 1).start();
        }
        for (i = 0; i < 36; i++) {
            this.oHa.add(new c(this, false));
        }
    }

    public final void stop() {
        int i = 0;
        this.oGq = null;
        this.flS = false;
        this.oHd = 0;
        if (this.oHb != null) {
            while (i < this.oHb.length) {
                if (this.oHb[i] != null) {
                    this.oHb[i].removeCallbacksAndMessages(null);
                    this.oHb[i].getLooper().quit();
                    this.oHb[i] = null;
                }
                i++;
            }
        }
        this.oHa.clear();
        this.oHa.add(new c(this, true));
        this.oHa.add(new c(this, true));
    }

    public final void run() {
        x.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "start run receiver sleepTime: " + this.oHe);
        while (this.flS) {
            this.oHc.RO("_total");
            c cVar = null;
            try {
                cVar = (c) this.oHa.take();
            } catch (InterruptedException e) {
            }
            boolean z = false;
            if (cVar != null) {
                if (cVar.hik) {
                    break;
                }
                z = a(cVar);
            }
            if (!z) {
                try {
                    Thread.sleep((long) this.oHe);
                } catch (InterruptedException e2) {
                }
            }
        }
        x.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "stop run receiver");
    }

    public final void tj(int i) {
        this.oHd = i;
        x.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "memberSize " + i);
    }

    private synchronized boolean a(c cVar) {
        boolean z = true;
        synchronized (this) {
            if (cVar != null) {
                if (cVar.oHj == null) {
                    cVar.oHj = new int[57600];
                }
                cVar.oHj[0] = 0;
                if (Thread.currentThread().getName().contains("MultiTalk_videoReceiver2")) {
                    cVar.oHj[0] = 1;
                }
                f r = o.bcU().oFQ.r(cVar.oHj);
                if (this.oGq == null || r.ret <= 0 || bh.ov(r.zQv)) {
                    if (r.ret == 0) {
                        this.oHf++;
                    }
                    this.oHc.RO("_fail");
                    x.v("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "handleIdleObj fail ret %d", new Object[]{Integer.valueOf(r.ret)});
                    if ((this.oHf + this.oHg) % 100 == 0) {
                        x.v("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "01_rate: 0:%f 1:%f", new Object[]{Float.valueOf(((float) this.oHf) / ((float) (this.oHf + this.oHg))), Float.valueOf(((float) this.oHg) / ((float) (this.oHf + this.oHg)))});
                    }
                    try {
                        this.oHa.put(cVar);
                    } catch (InterruptedException e) {
                    }
                    z = false;
                } else {
                    int Fn = this.oGq.Fn(r.zQv);
                    cVar.username = r.zQv;
                    cVar.oHl = r.zQz;
                    cVar.oHm = r.zQA;
                    cVar.oHk = r.zQy;
                    x.d("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "handleIdleObj get username: %s, position: %d", new Object[]{cVar.username, Integer.valueOf(Fn)});
                    if (Fn >= 0 && this.oHb[Fn % 2] != null) {
                        this.oHb[Fn % 2].post(new b(this, cVar));
                    }
                    this.oHc.RO("_success");
                    this.oHg++;
                    if ((this.oHf + this.oHg) % 100 == 0) {
                        x.v("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "01_rate: 0:%d 1:%d", new Object[]{Integer.valueOf(this.oHf / (this.oHf + this.oHg)), Integer.valueOf(this.oHg / (this.oHf + this.oHg))});
                    }
                }
            } else {
                z = false;
            }
        }
        return z;
    }
}
