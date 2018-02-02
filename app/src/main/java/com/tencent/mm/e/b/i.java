package com.tencent.mm.e.b;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.f;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class i implements e {
    private static int flV = 0;
    public static boolean flW = true;
    Queue<String> flN = new LinkedList();
    Queue<p> flO = new LinkedList();
    Map<String, a> flP = new HashMap();
    private boolean flQ = false;
    private boolean flR = false;
    private boolean flS = false;
    public int flT = 0;
    private long flU = 0;
    a flX = new a();
    private ak flY = new ak(g.Dm().oAt.getLooper(), new 3(this), false);

    static /* synthetic */ void h(i iVar) {
        p pVar;
        iVar.flU = System.currentTimeMillis();
        if ((!iVar.flQ && iVar.flO.size() == 0) || (!iVar.flR && iVar.flN.size() == 0)) {
            List<p> UI = q.UI();
            if (!(UI == null || UI.size() == 0)) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                String fJ = bh.fJ(currentTimeMillis);
                for (p pVar2 : UI) {
                    if (iVar.flP.containsKey(pVar2.fileName)) {
                        x.d("MicroMsg.SceneVoiceService", "File is Already running:" + pVar2.fileName);
                    } else {
                        x.i("MicroMsg.SceneVoiceService", "Get file:" + pVar2.fileName + " status:" + pVar2.status + " user" + pVar2.fDC + " human:" + pVar2.hVz + " create:" + bh.fJ(pVar2.hVE) + " last:" + bh.fJ(pVar2.hVF) + " now:" + bh.fJ(currentTimeMillis) + " " + (currentTimeMillis - pVar2.hVF));
                        if (pVar2.UG()) {
                            if (currentTimeMillis - pVar2.hVF > 80 && pVar2.status == 5) {
                                x.e("MicroMsg.SceneVoiceService", "time out file: " + pVar2.fileName + " last:" + bh.fJ(pVar2.hVF) + " now:" + fJ + " msgLocalId:" + pVar2.hVI + " status:" + pVar2.status);
                                if (pVar2.hVI == 0) {
                                    pVar2.hVF = System.currentTimeMillis() / 1000;
                                    pVar2.fDt = 320;
                                    m.UD().a(pVar2.fileName, pVar2);
                                } else {
                                    q.ny(pVar2.fileName);
                                }
                            }
                            if (currentTimeMillis - pVar2.hVF > 300 && pVar2.status == 6) {
                                x.e("MicroMsg.SceneVoiceService", "time out file: " + pVar2.fileName + " last:" + bh.fJ(pVar2.hVF) + " now:" + fJ + " msgLocalId:" + pVar2.hVI + " status:" + pVar2.status);
                                if (pVar2.hVI == 0) {
                                    pVar2.hVF = System.currentTimeMillis() / 1000;
                                    pVar2.fDt = 320;
                                    m.UD().a(pVar2.fileName, pVar2);
                                } else {
                                    q.ny(pVar2.fileName);
                                }
                            }
                            if (pVar2.hVB >= pVar2.hUp) {
                                x.i("MicroMsg.SceneVoiceService", "file: " + pVar2.fileName + " stat:" + pVar2.status + " now:" + pVar2.hVB + " net:" + pVar2.hUp);
                            } else {
                                iVar.flO.offer(pVar2);
                                iVar.flP.put(pVar2.fileName, null);
                            }
                        }
                        if (pVar2.UH()) {
                            x.i("MicroMsg.SceneVoiceService", "now " + currentTimeMillis + "info.getLastModifyTime()  " + pVar2.hVF + "  info.getStatus() " + pVar2.status + "  info.getCreateTime() " + pVar2.hVE);
                            if (currentTimeMillis - pVar2.hVF > 10 && (pVar2.status == 2 || pVar2.status == 1)) {
                                x.e("MicroMsg.SceneVoiceService", "time out file: " + pVar2.fileName + " last:" + bh.fJ(pVar2.hVF) + " now:" + fJ);
                                q.ny(pVar2.fileName);
                            } else if (currentTimeMillis - pVar2.hVE > 600 && pVar2.status == 3) {
                                x.e("MicroMsg.SceneVoiceService", "time out file: " + pVar2.fileName + " last:" + bh.fJ(pVar2.hVF) + " now:" + fJ);
                                q.ny(pVar2.fileName);
                            } else if (pVar2.fDC.length() <= 0) {
                                x.e("MicroMsg.SceneVoiceService", "Create a new ChatRoom? , set username first :" + pVar2.fileName);
                            } else {
                                iVar.flN.offer(pVar2.fileName);
                                iVar.flP.put(pVar2.fileName, null);
                            }
                        }
                    }
                }
                x.i("MicroMsg.SceneVoiceService", "GetNeedRun procing:" + iVar.flP.size() + " [recv:" + iVar.flO.size() + ",send:" + iVar.flN.size() + "]");
                iVar.flO.size();
                iVar.flN.size();
            }
        }
        if (iVar.flQ || iVar.flO.size() != 0 || iVar.flR || iVar.flN.size() != 0) {
            if (!iVar.flQ && iVar.flO.size() > 0) {
                Object obj;
                pVar2 = (p) iVar.flO.poll();
                String str = pVar2.fileName;
                if (((h) g.h(h.class)).aZi().dJ(pVar2.fFo)) {
                    x.i("MicroMsg.SceneVoiceService", "[oneliang] msg svrid:%s,it is in delete msg list,may be revoke msg come first,msg info insert last,so no need to add msg info and delete voice info", Long.valueOf(pVar2.fFo));
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    x.i("MicroMsg.SceneVoiceService", "Start Recv :" + str);
                    if (str != null) {
                        iVar.flP.put(str, new a());
                        iVar.flQ = true;
                        g.CG().a(new com.tencent.mm.modelvoice.e(pVar2), 0);
                    }
                } else if (bh.ou(pVar2.fileName).length() > 0) {
                    m.UD().iF(pVar2.fileName);
                    return;
                } else {
                    x.i("MicroMsg.SceneVoiceService", "[oneliang] the length of voice info file name is zero");
                    return;
                }
            }
            if (!iVar.flR && iVar.flN.size() > 0) {
                String str2 = (String) iVar.flN.poll();
                x.i("MicroMsg.SceneVoiceService", "Start Send :" + str2);
                if (str2 != null) {
                    iVar.flP.put(str2, new a());
                    iVar.flR = true;
                    g.CG().a(new f(str2), 0);
                    return;
                }
                return;
            }
            return;
        }
        iVar.vB();
        x.i("MicroMsg.SceneVoiceService", "No Data Any More , Stop Service");
    }

    static /* synthetic */ int vC() {
        int i = flV;
        flV = i + 1;
        return i;
    }

    static /* synthetic */ int vD() {
        int i = flV;
        flV = i - 1;
        return i;
    }

    public i() {
        g.CG().a(127, (e) this);
        g.CG().a((int) FileUtils.S_IWUSR, (e) this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        g.Dm().F(new 1(this, kVar, i, i2));
    }

    private void vB() {
        this.flP.clear();
        this.flN.clear();
        this.flO.clear();
        this.flR = false;
        this.flQ = false;
        this.flS = false;
        x.i("MicroMsg.SceneVoiceService", "Finish service use time(ms):" + this.flX.zi());
    }

    public final void run() {
        g.Dm().F(new 2(this));
    }
}
