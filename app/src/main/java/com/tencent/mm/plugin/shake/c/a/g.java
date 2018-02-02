package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.shake.b.l;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class g extends b implements e {
    private static int qol = 0;
    private float gyA = -1000.0f;
    private a gyF = new 1(this);
    private float gyz = -85.0f;
    private c hpO;
    public String jcA = "";
    public int kFm = 0;
    public int kLy;
    private af mHandler = new af();
    private boolean neb = false;
    private c qoG;
    private e qoH = new e();
    private boolean qoI = false;
    private long qom = 0;

    public g(l.a aVar) {
        super(aVar);
    }

    public final void init() {
        qol = m.brI().qol;
        this.qom = m.brI().qom;
        this.gyz = m.brI().gyz;
        this.gyA = m.brI().gyA;
        ar.CG().a(1250, (e) this);
        bro();
    }

    public final void reset() {
        if (this.qoG != null) {
            ar.CG().c(this.qoG);
        }
    }

    public final void start() {
        init();
        reset();
        if (this.hpO == null) {
            bro();
        }
        this.hpO.b(this.gyF, true);
        d brI = m.brI();
        CharSequence charSequence = "key_shake_card_item";
        Object obj = (TextUtils.isEmpty(charSequence) || !brI.kIN.containsKey(charSequence)) ? null : brI.kIN.get(charSequence);
        long currentTimeMillis = (System.currentTimeMillis() / 1000) - this.qom;
        if (obj == null || !(obj instanceof e)) {
            boolean z;
            if (this.qom == 0) {
                z = true;
            } else if (currentTimeMillis >= 0) {
                z = true;
            } else {
                com.tencent.mm.plugin.report.service.g.pQN.h(11666, Integer.valueOf(this.kFm));
                this.mHandler.postDelayed(new Runnable(this) {
                    final /* synthetic */ g qoJ;

                    {
                        this.qoJ = r1;
                    }

                    public final void run() {
                        this.qoJ.qoH.kLy = 3;
                        this.qoJ.kLy = this.qoJ.qoH.kLy;
                        this.qoJ.qoH.qos = m.brI().qon;
                        if (this.qoJ.qnR != null) {
                            this.qoJ.qnR.a(1250, this.qoJ.qoH, 2);
                        }
                    }
                }, 3000);
                x.i("MicroMsg.ShakeCardService", "ShakeCardService do not doNetSceneShakeCard, because time is not expire");
                z = false;
            }
            if (!z) {
                return;
            }
            if (this.neb) {
                x.i("MicroMsg.ShakeCardService", "ShakeCardService is doing netscene, return");
                return;
            } else if (this.gyz == -85.0f || this.gyA == -1000.0f) {
                this.qoI = true;
                x.i("MicroMsg.ShakeCardService", "ShakeCardService location is not geted, wait 4 second");
                this.mHandler.postDelayed(new 3(this), 4000);
                return;
            } else {
                brM();
                return;
            }
        }
        this.qnR.a(1250, (e) obj, 1);
        m.brI().putValue("key_shake_card_item", null);
        x.i("MicroMsg.ShakeCardService", "getlbscard return data is no empty, don't do doNetSceneShakeCard, return ok");
    }

    private void brM() {
        if (this.neb) {
            x.i("MicroMsg.ShakeCardService", "ShakeCardService is doing doNetSceneShakeCard, return");
            return;
        }
        this.neb = true;
        this.qoI = false;
        x.i("MicroMsg.ShakeCardService", "ShakeCardService do doNetSceneShakeCard");
        this.qoG = new c(this.gyA, this.gyz, this.kFm, this.jcA);
        ar.CG().a(this.qoG, 0);
    }

    public final void pause() {
        ata();
    }

    public final void resume() {
        if (this.hpO != null) {
            this.hpO.a(this.gyF, true);
        }
    }

    public final void brp() {
        ar.CG().b(1250, (e) this);
        ata();
        super.brp();
    }

    private void bro() {
        this.hpO = c.OP();
        this.hpO.a(this.gyF, true);
    }

    private void ata() {
        if (this.hpO != null) {
            this.hpO.c(this.gyF);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof c) {
            c cVar = (c) kVar;
            e eVar = this.qoH;
            e eVar2 = cVar.qok;
            eVar.kLy = eVar2.kLy;
            eVar.kJN = eVar2.kJN;
            eVar.fGV = eVar2.fGV;
            eVar.title = eVar2.title;
            eVar.kJQ = eVar2.kJQ;
            eVar.kJR = eVar2.kJR;
            eVar.kLa = eVar2.kLa;
            eVar.kJP = eVar2.kJP;
            eVar.hbM = eVar2.hbM;
            eVar.qol = eVar2.qol;
            eVar.qoo = eVar2.qoo;
            eVar.qop = eVar2.qop;
            eVar.qoq = eVar2.qoq;
            eVar.qor = eVar2.qor;
            eVar.qos = eVar2.qos;
            eVar.cey = eVar2.cey;
            eVar.qot = eVar2.qot;
            eVar.qou = eVar2.qou;
            this.kLy = this.qoH.kLy;
            x.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd()  action_type:" + this.kLy + "  frequency_level:" + qol + " control_flag:" + this.qoH.qoo);
            if (i == 0 && i2 == 0) {
                qol = this.qoH.qol;
                x.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd is OK ");
                if (this.qnR != null) {
                    this.qnR.a(1250, this.qoH, 1);
                }
                brN();
            } else if (!(i == 5 && i2 == -1) && (i != 4 || i2 == 0)) {
                x.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + i + " errCode is " + i2);
                if (this.qnR != null) {
                    this.qnR.a(1250, this.qoH, 2);
                }
                brN();
            } else {
                x.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + i + " errCode is " + i2);
                if (this.qnR != null) {
                    this.qnR.a(1250, this.qoH, 2);
                }
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                long wd = (long) com.tencent.mm.plugin.shake.c.c.a.wd(com.tencent.mm.plugin.shake.c.c.a.bsa());
                x.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd wait nextInterval is " + wd);
                this.qom = currentTimeMillis + wd;
            }
            m.brI().qol = qol;
            m.brI().qom = this.qom;
            this.neb = false;
        }
    }

    private void brN() {
        long wc;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (com.tencent.mm.plugin.shake.c.c.a.wb(qol)) {
            x.i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is valid");
            wc = (long) com.tencent.mm.plugin.shake.c.c.a.wc(qol);
        } else {
            x.i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is not valid");
            wc = (long) com.tencent.mm.plugin.shake.c.c.a.wd(com.tencent.mm.plugin.shake.c.c.a.bsa());
        }
        x.i("MicroMsg.ShakeCardService", "ShakeCardService updateWaitingTime wait nextInterval is " + wc);
        this.qom = wc + currentTimeMillis;
    }
}
