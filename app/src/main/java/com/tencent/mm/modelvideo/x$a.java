package com.tencent.mm.modelvideo;

import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.appbrand.jsapi.g.f;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import junit.framework.Assert;

public class x$a implements e {
    private static int flV = 0;
    Queue<String> flN = new LinkedList();
    Queue<String> flO = new LinkedList();
    Map<String, a> flP = new HashMap();
    boolean flQ = false;
    private boolean flR = false;
    private boolean flS = false;
    int flT = 0;
    private long flU = 0;
    a flX = new a();
    private ak flY = null;
    HandlerThread hWl = com.tencent.mm.sdk.f.e.cZ("VideoService_runThread", 0);
    af hWm;
    boolean hWn = false;
    public List<v> hWo = new ArrayList();
    Queue<String> hWp = new LinkedList();
    Queue<String> hWq = new LinkedList();
    public d hWr = null;
    g hWs = null;

    static /* synthetic */ int JO() {
        int i = flV;
        flV = i + 1;
        return i;
    }

    static /* synthetic */ int Ut() {
        int i = flV;
        flV = i - 1;
        return i;
    }

    static /* synthetic */ void a(x$a com_tencent_mm_modelvideo_x_a) {
        String str;
        boolean z = true;
        com_tencent_mm_modelvideo_x_a.flU = System.currentTimeMillis();
        if ((!com_tencent_mm_modelvideo_x_a.flQ && com_tencent_mm_modelvideo_x_a.flO.size() + com_tencent_mm_modelvideo_x_a.hWp.size() == 0) || (!com_tencent_mm_modelvideo_x_a.flR && com_tencent_mm_modelvideo_x_a.flN.size() == 0)) {
            long Wq = bh.Wq();
            List<String> Uq = o.TU().Uq();
            List<String> Un = o.TU().Un();
            List<String> Uo = o.TU().Uo();
            List<String> Up = o.TU().Up();
            if (Uq != null) {
                x.d("MicroMsg.VideoService", "getNeedRunInfo needSendList size: " + Uq.size());
                for (String str2 : Uq) {
                    if (com_tencent_mm_modelvideo_x_a.flP.containsKey(str2)) {
                        x.d("MicroMsg.VideoService", "need sendList File is Already running:" + str2);
                    } else {
                        com_tencent_mm_modelvideo_x_a.flN.offer(str2);
                        com_tencent_mm_modelvideo_x_a.flP.put(str2, null);
                    }
                }
            }
            if (Un != null) {
                x.d("MicroMsg.VideoService", "getNeedRunInfo needRecvList size: " + Un.size());
                for (String str22 : Un) {
                    if (com_tencent_mm_modelvideo_x_a.flP.containsKey(str22)) {
                        x.d("MicroMsg.VideoService", "need recvList File is Already running:" + str22);
                    } else {
                        com_tencent_mm_modelvideo_x_a.flO.offer(str22);
                        com_tencent_mm_modelvideo_x_a.flP.put(str22, null);
                    }
                }
            }
            if (Uo != null) {
                x.d("MicroMsg.VideoService", "getNeedRunInfo online video list size: " + Uo.size());
                for (String str222 : Uo) {
                    if (com_tencent_mm_modelvideo_x_a.flP.containsKey(str222)) {
                        x.d("MicroMsg.VideoService", "online videoList File is Already running:" + str222);
                    } else {
                        com_tencent_mm_modelvideo_x_a.hWp.offer(str222);
                        com_tencent_mm_modelvideo_x_a.flP.put(str222, null);
                    }
                }
            }
            if (Up != null) {
                x.d("MicroMsg.VideoService", "getNeedRunInfo hevc video list size: " + Up.size());
                for (String str2222 : Up) {
                    if (com_tencent_mm_modelvideo_x_a.flP.containsKey(str2222)) {
                        x.d("MicroMsg.VideoService", "hevc videoList File is Already running:" + str2222);
                    } else {
                        com_tencent_mm_modelvideo_x_a.hWq.offer(str2222);
                        com_tencent_mm_modelvideo_x_a.flP.put(str2222, null);
                    }
                }
            }
            x.i("MicroMsg.VideoService", "GetNeedRun cost time[%d] procing[%d] [recv:%d, online:%d, send:%d hevc:%d]", Long.valueOf(bh.bA(Wq)), Integer.valueOf(com_tencent_mm_modelvideo_x_a.flP.size()), Integer.valueOf(com_tencent_mm_modelvideo_x_a.flO.size()), Integer.valueOf(com_tencent_mm_modelvideo_x_a.hWp.size()), Integer.valueOf(com_tencent_mm_modelvideo_x_a.flN.size()), Integer.valueOf(com_tencent_mm_modelvideo_x_a.hWq.size()));
            com_tencent_mm_modelvideo_x_a.flO.size();
            com_tencent_mm_modelvideo_x_a.flN.size();
            com_tencent_mm_modelvideo_x_a.hWp.size();
            com_tencent_mm_modelvideo_x_a.hWq.size();
        }
        int i = (com_tencent_mm_modelvideo_x_a.hWq.size() == 0 || !d.Nc()) ? true : 0;
        if (com_tencent_mm_modelvideo_x_a.flQ || com_tencent_mm_modelvideo_x_a.flO.size() + com_tencent_mm_modelvideo_x_a.hWp.size() != 0 || i == 0 || com_tencent_mm_modelvideo_x_a.flR || com_tencent_mm_modelvideo_x_a.flN.size() != 0) {
            if (!com_tencent_mm_modelvideo_x_a.flQ && (com_tencent_mm_modelvideo_x_a.flO.size() > 0 || com_tencent_mm_modelvideo_x_a.hWp.size() > 0 || i == 0)) {
                if (com_tencent_mm_modelvideo_x_a.hWp.size() > 0) {
                    str2222 = (String) com_tencent_mm_modelvideo_x_a.hWp.poll();
                    x.i("MicroMsg.VideoService", "Start Recv :" + str2222);
                    if (!bh.ov(str2222)) {
                        com_tencent_mm_modelvideo_x_a.flP.put(str2222, new a());
                        com_tencent_mm_modelvideo_x_a.flQ = true;
                        Assert.assertTrue("sceneDown should null", com_tencent_mm_modelvideo_x_a.hWr == null);
                        com_tencent_mm_modelvideo_x_a.hWr = new d(str2222, true);
                        g.CG().a(com_tencent_mm_modelvideo_x_a.hWr, 0);
                    }
                }
                if (!com_tencent_mm_modelvideo_x_a.flQ && com_tencent_mm_modelvideo_x_a.flO.size() > 0) {
                    str2222 = (String) com_tencent_mm_modelvideo_x_a.flO.poll();
                    x.i("MicroMsg.VideoService", "Start Recv :" + str2222);
                    if (str2222 != null) {
                        com_tencent_mm_modelvideo_x_a.flP.put(str2222, new a());
                        com_tencent_mm_modelvideo_x_a.flQ = true;
                        Assert.assertTrue("sceneDown should null", com_tencent_mm_modelvideo_x_a.hWr == null);
                        com_tencent_mm_modelvideo_x_a.hWr = new d(str2222);
                        g.CG().a(com_tencent_mm_modelvideo_x_a.hWr, 0);
                    }
                }
                if (!com_tencent_mm_modelvideo_x_a.flQ) {
                    str2222 = (String) com_tencent_mm_modelvideo_x_a.hWq.poll();
                    x.i("MicroMsg.VideoService", "Start recv hecv: " + str2222);
                    if (!bh.ov(str2222)) {
                        com_tencent_mm_modelvideo_x_a.flP.put(str2222, new a());
                        com_tencent_mm_modelvideo_x_a.flQ = true;
                        Assert.assertTrue("sceneDown should null", com_tencent_mm_modelvideo_x_a.hWr == null);
                        com_tencent_mm_modelvideo_x_a.hWr = new d(str2222, true);
                        g.CG().a(com_tencent_mm_modelvideo_x_a.hWr, 0);
                    }
                }
            }
            if (!com_tencent_mm_modelvideo_x_a.flR && com_tencent_mm_modelvideo_x_a.flN.size() > 0) {
                str2222 = (String) com_tencent_mm_modelvideo_x_a.flN.poll();
                x.i("MicroMsg.VideoService", "Start Send :" + str2222);
                if (str2222 != null) {
                    com_tencent_mm_modelvideo_x_a.flP.put(str2222, new a());
                    com_tencent_mm_modelvideo_x_a.flR = true;
                    String str3 = "sceneUp should null";
                    if (com_tencent_mm_modelvideo_x_a.hWs != null) {
                        z = false;
                    }
                    Assert.assertTrue(str3, z);
                    if (com_tencent_mm_modelvideo_x_a.hWo != null && com_tencent_mm_modelvideo_x_a.hWo.size() > 0) {
                        for (v nK : com_tencent_mm_modelvideo_x_a.hWo) {
                            nK.nK(str2222);
                        }
                    }
                    com_tencent_mm_modelvideo_x_a.hWs = new g(str2222);
                    g.CG().a(com_tencent_mm_modelvideo_x_a.hWs, 0);
                    return;
                }
                return;
            }
            return;
        }
        com_tencent_mm_modelvideo_x_a.vB();
        x.d("MicroMsg.VideoService", "No Data Any More , Stop Service");
    }

    public x$a() {
        g.CG().a((int) f.CTRL_INDEX, (e) this);
        g.CG().a(150, (e) this);
        this.hWl.start();
        this.hWn = true;
        this.hWm = new af(this.hWl.getLooper());
        this.flY = new ak(this.hWl.getLooper(), new 1(this), false);
        x.i("MicroMsg.VideoService", "create VideoService, start video send thread");
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.hWl == null || !this.hWn || this.hWm == null) {
            x.e("MicroMsg.VideoService", "onSceneEnd error!, handler or thread is null!");
        } else {
            this.hWm.post(new 2(this, kVar, i, i2));
        }
    }

    public final void vB() {
        this.flP.clear();
        this.flN.clear();
        this.flO.clear();
        this.hWp.clear();
        this.hWq.clear();
        this.flR = false;
        this.flQ = false;
        this.flS = false;
        x.i("MicroMsg.VideoService", "Finish service use time(ms):" + this.flX.zi());
    }

    public final void run() {
        if (this.hWl == null || !this.hWn || this.hWm == null) {
            x.e("MicroMsg.VideoService", "run error!, handler or thread is null!");
        } else {
            this.hWm.post(new Runnable(this) {
                final /* synthetic */ x$a hWt;

                {
                    this.hWt = r1;
                }

                public final void run() {
                    long currentTimeMillis = System.currentTimeMillis() - this.hWt.flU;
                    x.d("MicroMsg.VideoService", "Try Run service runningFlag:" + this.hWt.flS + " timeWait:" + currentTimeMillis + " sending:" + this.hWt.flR + " recving:" + this.hWt.flQ);
                    if (this.hWt.flS) {
                        if (currentTimeMillis >= 60000) {
                            x.e("MicroMsg.VideoService", "ERR: Try Run service runningFlag:" + this.hWt.flS + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + this.hWt.flR + " recving:" + this.hWt.flQ);
                        } else {
                            return;
                        }
                    }
                    this.hWt.flT = 3;
                    this.hWt.flS = true;
                    this.hWt.flR = false;
                    this.hWt.flQ = false;
                    this.hWt.hWs = null;
                    this.hWt.hWr = null;
                    this.hWt.flX.gHJ = SystemClock.elapsedRealtime();
                    this.hWt.flY.J(10, 10);
                }

                public final String toString() {
                    return super.toString() + "|run";
                }
            });
        }
    }

    public final boolean Us() {
        boolean z;
        if (this.hWr != null) {
            g.CG().c(this.hWr);
            z = true;
            this.flS = false;
        } else {
            z = false;
        }
        this.flP.clear();
        this.flN.clear();
        this.flO.clear();
        this.hWp.clear();
        this.hWq.clear();
        return z;
    }
}
