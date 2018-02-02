package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.su;
import com.tencent.mm.g.a.su.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.List;

public final class v extends c<su> implements e {
    private boolean fKG;
    private boolean mza;
    private su sPv;

    public v() {
        this.mza = false;
        this.fKG = false;
        this.xen = su.class.getName().hashCode();
    }

    private boolean a(su suVar) {
        if (suVar instanceof su) {
            this.mza = false;
            this.sPv = suVar;
            this.fKG = suVar.fKE.fKG;
            g.Dk();
            g.Di().gPJ.a(385, (e) this);
            g.Dk();
            g.Di().gPJ.a(1518, (e) this);
            if (o.bLq().bLL()) {
                x.i("MicroMsg.WalletGetUserInfoEventListener", "data is invalid. doScene");
                if (q.Gf()) {
                    g.Dk();
                    g.Di().gPJ.a(new a(), 0);
                } else {
                    g.Dk();
                    g.Di().gPJ.a(new com.tencent.mm.plugin.wallet_core.c.x(null, zj(suVar.fKE.scene) ? suVar.fKE.scene : 0), 0);
                }
            } else if (suVar.fKE.fKG) {
                x.i("MicroMsg.WalletGetUserInfoEventListener", "use cache");
                r0 = o.bLq();
                x.i("MicroMsg.WalletUserInfoManger", "checkCacheTimeout, nowSecs: %s, cacheDeadTime: %s", Long.valueOf(bh.Wo()), Long.valueOf(r0.sQh));
                Object obj = (r0.sQh <= 0 || bh.Wo() > r0.sQh) ? 1 : null;
                if (obj == null) {
                    this.mza = true;
                    x.i("MicroMsg.WalletGetUserInfoEventListener", "cache data is ok. doCallback");
                    a(0, "", null);
                    if (q.Gf()) {
                        g.Dk();
                        g.Di().gPJ.a(new a(), 0);
                    } else {
                        g.Dk();
                        g.Di().gPJ.a(new com.tencent.mm.plugin.wallet_core.c.x(null, zj(suVar.fKE.scene) ? suVar.fKE.scene : 0), 0);
                    }
                } else {
                    x.i("MicroMsg.WalletGetUserInfoEventListener", "cache timeout, do NetSceneTenpayQueryBoundBankcard");
                    if (q.Gf()) {
                        g.Dk();
                        g.Di().gPJ.a(new a(), 0);
                    } else {
                        g.Dk();
                        g.Di().gPJ.a(new com.tencent.mm.plugin.wallet_core.c.x(null, zj(suVar.fKE.scene) ? suVar.fKE.scene : 0), 0);
                    }
                }
            } else {
                long by = bh.by(o.bLq().sQg);
                x.i("MicroMsg.WalletUserInfoManger", "dead time : %d, nowSec: %d, pass time " + by, Long.valueOf(r0.sQg), Long.valueOf(System.currentTimeMillis() / 1000));
                if ((by > 0 ? 1 : null) != null) {
                    x.i("MicroMsg.WalletGetUserInfoEventListener", "data is checkTimeOut, do NetSceneTenpayQueryBoundBankcard");
                    if (q.Gf()) {
                        g.Dk();
                        g.Di().gPJ.a(new a(), 0);
                    } else {
                        g.Dk();
                        g.Di().gPJ.a(new com.tencent.mm.plugin.wallet_core.c.x(null, zj(suVar.fKE.scene) ? suVar.fKE.scene : 0), 0);
                    }
                } else {
                    this.mza = true;
                    x.i("MicroMsg.WalletGetUserInfoEventListener", "data is ok. doCallback");
                    a(0, "", null);
                }
            }
            return true;
        }
        x.f("MicroMsg.WalletGetUserInfoEventListener", "mismatched event");
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if ((kVar instanceof com.tencent.mm.plugin.wallet_core.c.x) || (kVar instanceof a)) {
            g.Dk();
            g.Di().gPJ.b(385, (e) this);
            g.Dk();
            g.Di().gPJ.b(1518, (e) this);
            if (this.fKG && this.mza) {
                x.i("MicroMsg.WalletGetUserInfoEventListener", "onSceneEnd, useCache and event end");
                return;
            }
            this.mza = true;
            a(i2, str, kVar);
        }
    }

    private void a(int i, String str, k kVar) {
        boolean z = false;
        if (this.sPv != null) {
            int i2;
            String str2;
            this.sPv.fKF.errCode = i;
            this.sPv.fKF.fnL = str;
            this.sPv.fKF.fKH = o.bLq().bLM();
            b bVar = this.sPv.fKF;
            ag bLq = o.bLq();
            boolean z2 = (bLq.sQb != null && bLq.sQb.bLD()) || (bLq.sCt != null && bLq.sCt.size() > 0);
            z2 = z2 ? false : bLq.sCs == null || bLq.sCs.size() <= 0;
            bVar.fKI = z2;
            bVar = this.sPv.fKF;
            ag bLq2 = o.bLq();
            ArrayList arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            bLq2.d(arrayList, arrayList2);
            if (ag.ce(arrayList2)) {
                z2 = true;
            } else {
                z2 = false;
            }
            bVar.fKJ = z2;
            this.sPv.fKF.fKK = o.bLq().bLQ().bLD();
            this.sPv.fKF.fKL = o.bLq().bLP();
            this.sPv.fKF.fKM = o.bLq().azp();
            this.sPv.fKF.fKN = o.bLq().bLN();
            this.sPv.fKF.fKO = o.bLq().bLQ().bLG();
            this.sPv.fKF.fKP = "";
            bVar = this.sPv.fKF;
            bLq2 = o.bLq();
            if (bLq2.sPZ == null) {
                z2 = false;
            } else if (bLq2.sPZ.field_paymenu_use_new == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            bVar.fLd = z2;
            if (kVar != null && (kVar instanceof com.tencent.mm.plugin.wallet_core.c.x)) {
                this.sPv.fKF.fKP = ((com.tencent.mm.plugin.wallet_core.c.x) kVar).fKP;
                this.sPv.fKF.fKQ = ((com.tencent.mm.plugin.wallet_core.c.x) kVar).fKQ;
                this.sPv.fKF.fKR = ((com.tencent.mm.plugin.wallet_core.c.x) kVar).fKR;
                this.sPv.fKF.fKS = ((com.tencent.mm.plugin.wallet_core.c.x) kVar).fKS;
                this.sPv.fKF.fKT = ((com.tencent.mm.plugin.wallet_core.c.x) kVar).fKT;
                this.sPv.fKF.scene = ((com.tencent.mm.plugin.wallet_core.c.x) kVar).scene;
                this.sPv.fKF.fKU = ((com.tencent.mm.plugin.wallet_core.c.x) kVar).fKU;
                this.sPv.fKF.fKV = ((com.tencent.mm.plugin.wallet_core.c.x) kVar).fKV;
                this.sPv.fKF.fKW = ((com.tencent.mm.plugin.wallet_core.c.x) kVar).fKW;
                this.sPv.fKF.fKX = ((com.tencent.mm.plugin.wallet_core.c.x) kVar).fKX;
                this.sPv.fKF.fKY = ((com.tencent.mm.plugin.wallet_core.c.x) kVar).fKY;
                this.sPv.fKF.fKZ = ((com.tencent.mm.plugin.wallet_core.c.x) kVar).fKZ;
                this.sPv.fKF.fLa = ((com.tencent.mm.plugin.wallet_core.c.x) kVar).fLa;
                this.sPv.fKF.title = ((com.tencent.mm.plugin.wallet_core.c.x) kVar).title;
                this.sPv.fKF.fLb = ((com.tencent.mm.plugin.wallet_core.c.x) kVar).fLb;
                this.sPv.fKF.fLc = ((com.tencent.mm.plugin.wallet_core.c.x) kVar).fLc;
            }
            this.sPv.fKF.fLe = o.bLq().bLW() ? 1 : 0;
            bVar = this.sPv.fKF;
            bLq2 = o.bLq();
            if (bLq2.sPZ != null) {
                i2 = bLq2.sPZ.field_is_show_lqb;
            } else {
                i2 = 0;
            }
            bVar.fLf = i2;
            b bVar2 = this.sPv.fKF;
            ag bLq3 = o.bLq();
            if (bLq3.sPZ != null && bLq3.sPZ.field_is_open_lqb == 1) {
                z = true;
            }
            bVar2.fLg = z;
            b bVar3 = this.sPv.fKF;
            bLq2 = o.bLq();
            if (bLq2.sPZ != null) {
                str2 = bLq2.sPZ.field_lqb_open_url;
            } else {
                str2 = null;
            }
            bVar3.fLh = str2;
            x.d("MicroMsg.WalletGetUserInfoEventListener", "mUserInfo needBind : " + this.sPv.fKF.fKI + " hasNewTips : " + this.sPv.fKF.fKJ + " swipeOn : " + this.sPv.fKF.fKK);
            if (this.sPv.fqI != null) {
                this.sPv.fqI.run();
            }
            if (this.sPv.fKF.fKz != null) {
                this.sPv.fKF.fKz.run();
            }
        }
        if (this.mza) {
            this.sPv = null;
        }
    }

    private static boolean zj(int i) {
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 6 || i == 8 || i == 9 || i == 10 || i == 11 || i == 12 || i == 13 || i == 14 || i == 15 || i == 16 || i == 17 || i == 18 || i == 19 || i == 20 || i == 21 || i == 22 || i == 23) {
            return true;
        }
        return false;
    }
}
