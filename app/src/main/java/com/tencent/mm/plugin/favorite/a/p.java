package com.tencent.mm.plugin.favorite.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.vl;
import com.tencent.mm.protocal.c.vm;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.LinkedList;

public final class p extends k implements com.tencent.mm.network.k {
    private int cLl = 1;
    final b gJQ;
    e gJT = null;
    private a mqG = new a(this);
    long mqH = -1;
    public boolean mqI = false;

    public p() {
        x.i("MicroMsg.Fav.NetSceneFavSync", "NetSceneFavSync");
        a aVar = new a();
        aVar.hmj = new vl();
        aVar.hmk = new vm();
        aVar.uri = "/cgi-bin/micromsg-bin/favsync";
        aVar.hmi = 400;
        aVar.hml = JsApiChooseWeChatContact.CTRL_INDEX;
        aVar.hmm = 1000000195;
        aVar.hmn = false;
        this.gJQ = aVar.JZ();
    }

    public p(int i) {
        x.i("MicroMsg.Fav.NetSceneFavSync", "NetSceneFavSync %d", new Object[]{Integer.valueOf(i)});
        a aVar = new a();
        aVar.hmj = new vl();
        aVar.hmk = new vm();
        aVar.uri = "/cgi-bin/micromsg-bin/favsync";
        aVar.hmi = 400;
        aVar.hml = JsApiChooseWeChatContact.CTRL_INDEX;
        aVar.hmm = 1000000195;
        aVar.hmn = false;
        this.gJQ = aVar.JZ();
        this.cLl = i;
    }

    public final boolean Kd() {
        return true;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        vl vlVar = (vl) this.gJQ.hmg.hmo;
        vlVar.vRz = this.cLl;
        byte[] aHW = h.getFavConfigStorage().aHW();
        if (this.cLl == 2) {
            aHW = new byte[0];
        }
        vlVar.vRA = n.N(aHW);
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Fav.NetSceneFavSync", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (h.aIn().flR) {
            x.w("MicroMsg.Fav.NetSceneFavSync", "sending item, skip sync onGYNetEnd");
            this.gJT.a(i2, i3, str, this);
        } else if (i2 == 0 && i3 == 0) {
            vm vmVar = (vm) ((b) qVar).hmh.hmo;
            LinkedList linkedList = vmVar.vRD.ksP;
            if (linkedList == null || linkedList.size() <= 0) {
                if (vmVar.vRA.wJD != null) {
                    byte[] g = ad.g(((vl) ((b) qVar).hmg.hmo).vRA.wJD.toByteArray(), vmVar.vRA.wJD.toByteArray());
                    if (g != null && g.length > 0) {
                        h.getFavConfigStorage().av(g);
                    }
                } else {
                    x.e("MicroMsg.Fav.NetSceneFavSync", "merge key should not be null");
                }
                ar.Hg();
                c.CU().set(8217, Integer.valueOf(1));
                this.gJT.a(i2, i3, str, this);
                return;
            }
            x.i("MicroMsg.Fav.NetSceneFavSync", "cmdList size:" + linkedList.size());
            if (this.cLl != 2) {
                a aVar = this.mqG;
                aVar.mqJ = linkedList;
                if (aVar.mqJ != null && aVar.mqJ.size() > 0) {
                    ar.CG().a(new q(), 0);
                }
                aVar.mqK.sendEmptyMessage(0);
                return;
            }
            this.gJT.a(i2, i3, str, this);
        } else {
            this.gJT.a(i2, i3, str, this);
        }
    }

    protected final int Bh() {
        return 50;
    }

    protected final int a(q qVar) {
        return k.b.hmP;
    }

    public final int getType() {
        return 400;
    }
}
