package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.n;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.plugin.product.b.h;
import com.tencent.mm.plugin.product.b.i;
import com.tencent.mm.plugin.product.b.j;
import com.tencent.mm.plugin.product.b.l;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.protocal.c.vd;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ag.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import java.util.HashMap;
import java.util.LinkedList;

public final class f implements e {
    static int irz = 0;
    Activity iQz;
    boolean pfF = false;
    private boolean pfG = false;
    c pfH;
    private a pfI;
    private com.tencent.mm.sdk.b.c pfJ = new 3(this);

    class AnonymousClass1 implements a {
        final /* synthetic */ m pfK;
        final /* synthetic */ f pfL;
        private volatile int result;
        final /* synthetic */ Intent val$intent;

        AnonymousClass1(f fVar, Intent intent, m mVar) {
            this.pfL = fVar;
            this.val$intent = intent;
            this.pfK = mVar;
        }

        public final boolean JB() {
            this.result = f.a(this.pfL, this.val$intent, this.pfK);
            return true;
        }

        public final boolean JC() {
            switch (this.result) {
                case -1:
                    if (this.pfL.pfI != null) {
                        this.pfL.pfI.m(0, -1, this.pfL.iQz.getString(a$i.uLu));
                        break;
                    }
                    break;
                case 0:
                    if (this.pfL.pfI != null) {
                        this.pfL.pfI.m(0, 0, "");
                        break;
                    }
                    break;
            }
            return true;
        }

        public final String toString() {
            return super.toString() + "|initData";
        }
    }

    static /* synthetic */ int a(f fVar, Intent intent, m mVar) {
        irz = intent.getIntExtra("key_product_scene", 3);
        String stringExtra = intent.getStringExtra("key_product_info");
        String stringExtra2 = intent.getStringExtra("key_product_id");
        String stringExtra3 = intent.getStringExtra("key_source_url");
        c cVar = fVar.pfH;
        if (!bh.ov(stringExtra3)) {
            cVar.pdN = stringExtra3;
        }
        int i = -2;
        x.i("MicroMsg.MallProductUI", "Scene : " + irz);
        switch (irz) {
            case 1:
            case 2:
            case 4:
                if (!bh.ov(stringExtra)) {
                    mVar = m.b(mVar, stringExtra);
                    if (mVar == null) {
                        i = -1;
                        break;
                    }
                    fVar.pfH.a(mVar, null);
                    stringExtra2 = mVar.pek;
                    i = 0;
                    break;
                }
                break;
            case 3:
                if (!bh.ov(stringExtra)) {
                    mVar = m.a(mVar, stringExtra);
                    if (mVar == null) {
                        i = -1;
                        break;
                    }
                    fVar.pfH.a(mVar, null);
                    stringExtra2 = mVar.pek;
                    i = 0;
                    break;
                }
                break;
        }
        if (bh.ov(stringExtra2)) {
            return -1;
        }
        g.Dk();
        g.Di().gPJ.a(new h(mVar, stringExtra2), 0);
        return i;
    }

    public f(Activity activity, a aVar) {
        this.iQz = activity;
        com.tencent.mm.plugin.product.a.a.biM();
        this.pfH = com.tencent.mm.plugin.product.a.a.biN();
        this.pfI = aVar;
    }

    public final void onStart() {
        g.Dk();
        g.Di().gPJ.a(553, this);
        g.Dk();
        g.Di().gPJ.a(554, this);
        g.Dk();
        g.Di().gPJ.a(555, this);
        g.Dk();
        g.Di().gPJ.a(556, this);
        g.Dk();
        g.Di().gPJ.a(557, this);
        g.Dk();
        g.Di().gPJ.a(578, this);
        g.Dk();
        g.Di().gPJ.a(579, this);
    }

    public final void onStop() {
        g.Dk();
        g.Di().gPJ.b(553, this);
        g.Dk();
        g.Di().gPJ.b(554, this);
        g.Dk();
        g.Di().gPJ.b(555, this);
        g.Dk();
        g.Di().gPJ.b(556, this);
        g.Dk();
        g.Di().gPJ.b(557, this);
        g.Dk();
        g.Di().gPJ.b(578, this);
        g.Dk();
        g.Di().gPJ.b(579, this);
    }

    public final void bjm() {
        m mVar = this.pfH.pdK;
        b cfVar = new cf();
        ve veVar = new ve();
        vk vkVar = new vk();
        vd vdVar = new vd();
        vkVar.Ui(q.FS());
        vkVar.Uj(q.FS());
        vkVar.CS(11);
        vkVar.fC(bh.Wp());
        vdVar.Ub(mVar.peo.name);
        vdVar.Uc(this.pfH.bjg());
        vdVar.CP(mVar.pel);
        vdVar.Ue(this.pfH.a(mVar));
        vdVar.Ud(mVar.bji());
        cfVar.fqp.title = mVar.peo.name;
        cfVar.fqp.desc = this.pfH.bjg();
        cfVar.fqp.fqr = veVar;
        cfVar.fqp.type = 11;
        veVar.a(vkVar);
        veVar.b(vdVar);
        cfVar.fqp.activity = this.iQz;
        cfVar.fqp.fqw = 5;
        com.tencent.mm.sdk.b.a.xef.m(cfVar);
    }

    private void bjn() {
        d biO = com.tencent.mm.plugin.product.a.a.biM().biO();
        bbk biU = this.pfH.biU();
        if (!(biU == null || bh.ov(biU.ngs) || biU.ngs.contains(";"))) {
            biO.pec.remove(biU.ngs);
            biO.pec.add(biU.ngs);
            biO.bjh();
        }
        Intent intent = new Intent(this.iQz, MallProductUI.class);
        intent.putExtra("key_go_finish", true);
        intent.addFlags(67108864);
        this.iQz.startActivity(intent);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.MallProductUI", "errCode: " + i2 + ", errMsg: " + str);
        h hVar;
        if (i != 0 || i2 != 0) {
            switch (i2) {
                case -10010003:
                    x.i("MicroMsg.MallProductUI", "deal with MMBIZPAY_FUNC_ERR_NO_EXISTED_PRODUCT");
                    if (kVar instanceof h) {
                        hVar = (h) kVar;
                        this.pfH.a(hVar.peg, hVar.peh);
                        if (this.pfI != null) {
                            this.pfI.m(i, i2, str);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    x.i("MicroMsg.MallProductUI", "unkown errCode " + i2);
                    if (bh.ov(str)) {
                        str = i2 + " : " + this.iQz.getString(a$i.uLu);
                    }
                    if (this.pfI != null) {
                        this.pfI.m(i, i2, str);
                        return;
                    }
                    return;
            }
        } else if (kVar instanceof h) {
            hVar = (h) kVar;
            this.pfH.a(hVar.peg, hVar.peh);
            if (this.pfI != null) {
                this.pfI.m(i, i2, str);
            }
            if (bh.ov(hVar.peg.pek)) {
                com.tencent.mm.plugin.report.service.g.pQN.h(TXCStreamUploader.TXE_UPLOAD_INFO_SERVER_REFUSE, new Object[]{this.pfH.biV(), hVar.pef, Integer.valueOf(irz), Integer.valueOf(1)});
                return;
            }
            com.tencent.mm.plugin.report.service.g.pQN.h(TXCStreamUploader.TXE_UPLOAD_INFO_SERVER_REFUSE, new Object[]{this.pfH.biV(), hVar.peg.pek, Integer.valueOf(irz), Integer.valueOf(1)});
        } else if (kVar instanceof j) {
            j jVar = (j) kVar;
            r0 = this.pfH;
            r1 = jVar.pdM;
            r2 = jVar.pdX;
            LinkedList linkedList = jVar.pdY;
            r0.pdM = r1;
            r0.pdY = linkedList;
            r0.pdX = r2;
            r0.uC(0);
            this.iQz.startActivity(new Intent(this.iQz, MallProductSubmitUI.class));
            com.tencent.mm.plugin.report.service.g.pQN.h(11009, new Object[]{this.pfH.biV(), this.pfH.pdK.pek, Integer.valueOf(irz), Integer.valueOf(1)});
        } else if (!(kVar instanceof com.tencent.mm.plugin.product.b.f)) {
            if (kVar instanceof l) {
                r1 = ((l) kVar).pej;
                int i3 = 6;
                if (irz == 7) {
                    i3 = 1001;
                }
                x.d("MicroMsg.MallProductUI", "payScene:" + i3);
                com.tencent.mm.pluginsdk.wallet.h.a(this.iQz, r1, this.pfH.getAppId(), i3, 3);
                com.tencent.mm.sdk.b.a.xef.b(this.pfJ);
            } else if (kVar instanceof com.tencent.mm.plugin.product.b.k) {
                com.tencent.mm.ui.base.h.bu(this.iQz, this.iQz.getString(a$i.uLE));
                bjn();
            } else if (kVar instanceof com.tencent.mm.plugin.product.b.g) {
                try {
                    this.iQz.dismissDialog(-10002);
                } catch (Exception e) {
                    x.e("MicroMsg.MallProductUI", e.toString());
                }
                r0 = this.pfH;
                r0.pdX = ((com.tencent.mm.plugin.product.b.g) kVar).pdX;
                r0.uC(0);
            } else if (kVar instanceof i) {
                try {
                    this.iQz.dismissDialog(-10002);
                } catch (Exception e2) {
                    x.e("MicroMsg.MallProductUI", e2.toString());
                }
                i iVar = (i) kVar;
                r0 = this.pfH;
                r1 = iVar.mUrl;
                r2 = iVar.pei;
                if (!(bh.ov(r1) || r2 == null || r2.size() <= 0)) {
                    if (r0.peb == null) {
                        r0.peb = new HashMap();
                    }
                    r0.peb.put(r1, r2);
                }
                if (this.pfI != null) {
                    this.pfI.m(i, i2, str);
                }
            }
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    this.pfH.S(intent);
                    if (this.pfI != null) {
                        this.pfI.m(0, 0, "");
                    }
                    g.Dk();
                    n nVar = g.Di().gPJ;
                    c cVar = this.pfH;
                    nVar.a(new com.tencent.mm.plugin.product.b.g(cVar.pdK != null ? cVar.pdK.pek : "", this.pfH.pdM, this.pfH.pdQ), 0);
                    return;
                }
                return;
            case 2:
                if (i2 == -1 && intent != null) {
                    this.pfH.S(intent);
                    g.Dk();
                    g.Di().gPJ.a(new j(this.pfH.bjc(), irz), 0);
                    return;
                }
                return;
            case 3:
                b szVar = new sz();
                szVar.fLs.result = i;
                szVar.fLs.intent = intent;
                this.pfJ.a(szVar);
                return;
            case 4:
                if (this.pfI != null) {
                    this.pfI.m(0, 0, "");
                    return;
                }
                return;
            case 10000:
                this.iQz.showDialog(-10002);
                g.Dk();
                g.Di().gPJ.a(new i(this.pfH.pdM, this.pfH.pdT), 0);
                return;
            default:
                return;
        }
    }
}
