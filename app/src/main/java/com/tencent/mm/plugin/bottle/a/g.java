package com.tencent.mm.plugin.bottle.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.bnn;
import com.tencent.mm.protocal.c.bno;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;
    int kAL = 0;
    private com.tencent.mm.modelvoice.b kAO;
    int msgType = -1;

    public g(String str) {
        a aVar = new a();
        aVar.hmj = new bnn();
        aVar.hmk = new bno();
        aVar.uri = "/cgi-bin/micromsg-bin/throwbottle";
        aVar.hmi = JsApiMakeVoIPCall.CTRL_INDEX;
        aVar.hml = 53;
        aVar.hmm = 1000000053;
        this.gJQ = aVar.JZ();
        if (!bh.ov(str)) {
            this.msgType = 1;
            bnn com_tencent_mm_protocal_c_bnn = (bnn) this.gJQ.hmg.hmo;
            com_tencent_mm_protocal_c_bnn.wEq = 0;
            com_tencent_mm_protocal_c_bnn.ngq = this.msgType;
            com_tencent_mm_protocal_c_bnn.vIC = 0;
            com_tencent_mm_protocal_c_bnn.vIB = str.getBytes().length;
            com_tencent_mm_protocal_c_bnn.vZy = 0;
            com_tencent_mm_protocal_c_bnn.vYb = n.N(str.getBytes());
            com_tencent_mm_protocal_c_bnn.wxk = com.tencent.mm.a.g.s((str + bh.Wp()).getBytes());
        }
    }

    public g(String str, int i) {
        a aVar = new a();
        aVar.hmj = new bnn();
        aVar.hmk = new bno();
        aVar.uri = "/cgi-bin/micromsg-bin/throwbottle";
        aVar.hmi = JsApiMakeVoIPCall.CTRL_INDEX;
        aVar.hml = 53;
        aVar.hmm = 1000000053;
        this.gJQ = aVar.JZ();
        if (!bh.ov(str) && i > 0) {
            this.msgType = 3;
            bnn com_tencent_mm_protocal_c_bnn = (bnn) this.gJQ.hmg.hmo;
            com_tencent_mm_protocal_c_bnn.vZy = i;
            com_tencent_mm_protocal_c_bnn.wxk = str;
            com_tencent_mm_protocal_c_bnn.wEq = 0;
            com_tencent_mm_protocal_c_bnn.ngq = this.msgType;
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        if (this.msgType == 1) {
            this.msgType = 0 - this.msgType;
        } else if (this.msgType == 3) {
            bnn com_tencent_mm_protocal_c_bnn = (bnn) this.gJQ.hmg.hmo;
            com_tencent_mm_protocal_c_bnn.ngq = 3;
            com_tencent_mm_protocal_c_bnn.wEq = 0;
            if (this.kAO == null) {
                this.kAO = q.nT(com_tencent_mm_protocal_c_bnn.wxk);
                this.kAL = 0;
                com_tencent_mm_protocal_c_bnn.vIB = o.nv(com_tencent_mm_protocal_c_bnn.wxk);
            }
            com.tencent.mm.modelvoice.g bp = this.kAO.bp(this.kAL, 6000);
            x.d("MicroMsg.NetSceneThrowBottle", "doScene READ file[" + com_tencent_mm_protocal_c_bnn.wxk + "] read ret:" + bp.ret + " readlen:" + bp.flp + " newOff:" + bp.hWh + " netOff:" + this.kAL + " line:" + com.tencent.mm.compatible.util.g.getLine());
            if (bp.ret < 0 || bp.flp == 0) {
                x.e("MicroMsg.NetSceneThrowBottle", "Err doScene READ file[" + com_tencent_mm_protocal_c_bnn.wxk + "] read ret:" + bp.ret + " readlen:" + bp.flp + " newOff:" + bp.hWh + " netOff:" + this.kAL);
                q.nU(com_tencent_mm_protocal_c_bnn.wxk);
                return -1;
            }
            Object obj = new byte[bp.flp];
            System.arraycopy(bp.buf, 0, obj, 0, bp.flp);
            com_tencent_mm_protocal_c_bnn.vYb = n.N(obj);
            com_tencent_mm_protocal_c_bnn.vIC = this.kAL;
        } else {
            x.e("MicroMsg.NetSceneThrowBottle", "doScene Error Msg type: " + this.msgType);
            return -1;
        }
        return a(eVar, this.gJQ, this);
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        bnn com_tencent_mm_protocal_c_bnn = (bnn) ((b) qVar).hmg.hmo;
        if (com_tencent_mm_protocal_c_bnn.ngq == 1) {
            return k.b.hmP;
        }
        if (com_tencent_mm_protocal_c_bnn.ngq != 3) {
            return k.b.hmQ;
        }
        if (com_tencent_mm_protocal_c_bnn.vIB == 0 || com_tencent_mm_protocal_c_bnn.vIB <= com_tencent_mm_protocal_c_bnn.vIC || bh.ov(com_tencent_mm_protocal_c_bnn.wxk) || bh.bw(n.a(com_tencent_mm_protocal_c_bnn.vYb))) {
            return k.b.hmQ;
        }
        return k.b.hmP;
    }

    protected final int Bh() {
        return 10;
    }

    protected final void a(k.a aVar) {
        x.e("MicroMsg.NetSceneThrowBottle", "setSecurityCheckError:" + aVar + " type:" + this.msgType);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneThrowBottle", "onGYNetEnd errtype:" + i2 + " errCode:" + i3);
        bnn com_tencent_mm_protocal_c_bnn = (bnn) this.gJQ.hmg.hmo;
        bno com_tencent_mm_protocal_c_bno = (bno) this.gJQ.hmh.hmo;
        if (i2 == 4) {
            switch (i3) {
                case -56:
                    break;
                default:
                    c.nh(com_tencent_mm_protocal_c_bno.wjm);
                    c.ng(com_tencent_mm_protocal_c_bno.wjl);
                    break;
            }
        }
        if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneThrowBottle", "getStartPos " + com_tencent_mm_protocal_c_bno.vIC);
            x.d("MicroMsg.NetSceneThrowBottle", "getTotalLen " + com_tencent_mm_protocal_c_bno.vIB);
            x.d("MicroMsg.NetSceneThrowBottle", "getThrowCount " + com_tencent_mm_protocal_c_bno.wjl);
            x.d("MicroMsg.NetSceneThrowBottle", "getPickCount " + com_tencent_mm_protocal_c_bno.wjm);
            x.d("MicroMsg.NetSceneThrowBottle", "getDistance " + com_tencent_mm_protocal_c_bno.wEs);
            x.d("MicroMsg.NetSceneThrowBottle", "getBottleList " + com_tencent_mm_protocal_c_bno.wQk.size());
            for (int i4 = 0; i4 < com_tencent_mm_protocal_c_bno.wQk.size(); i4++) {
                x.d("MicroMsg.NetSceneThrowBottle", "bott id:" + com_tencent_mm_protocal_c_bno.wQk.get(i4));
            }
            if (com_tencent_mm_protocal_c_bnn.ngq == 1) {
                this.gJT.a(i2, i3, str, this);
                nj(1);
                return;
            }
            this.kAL += com_tencent_mm_protocal_c_bnn.vYb.wJB;
            if (this.kAL >= com_tencent_mm_protocal_c_bnn.vIB) {
                c.nh(com_tencent_mm_protocal_c_bno.wjm);
                c.ng(com_tencent_mm_protocal_c_bno.wjl);
                nj(3);
                q.nU(com_tencent_mm_protocal_c_bnn.wxk);
                this.gJT.a(i2, i3, str, this);
                return;
            } else if (a(this.hmA, this.gJT) == -1) {
                this.gJT.a(3, -1, "doScene failed", this);
                return;
            } else {
                return;
            }
        }
        x.d("MicroMsg.NetSceneThrowBottle", "ERR: onGYNetEnd errtype:" + i2 + " errCode:" + i3);
        q.nU(com_tencent_mm_protocal_c_bnn.wxk);
        this.gJT.a(i2, i3, str, this);
    }

    public final int arE() {
        return ((bno) this.gJQ.hmh.hmo).wEs;
    }

    private int nj(int i) {
        a aVar = new a();
        aVar.msgType = i;
        bnn com_tencent_mm_protocal_c_bnn = (bnn) this.gJQ.hmg.hmo;
        bno com_tencent_mm_protocal_c_bno = (bno) this.gJQ.hmh.hmo;
        aVar.kAD = com_tencent_mm_protocal_c_bno.wQk.size();
        aVar.kAF = 1;
        if (i == 3) {
            aVar.content = com_tencent_mm_protocal_c_bnn.wxk;
            aVar.kAG = com_tencent_mm_protocal_c_bnn.vZy;
        } else {
            aVar.content = new String(n.a(com_tencent_mm_protocal_c_bnn.vYb));
        }
        String str = "";
        for (int i2 = 0; i2 < com_tencent_mm_protocal_c_bno.wQk.size(); i2++) {
            str = str + com_tencent_mm_protocal_c_bno.wQk.get(i2);
        }
        aVar.kAC = com.tencent.mm.a.g.s(str.getBytes());
        aVar.kAH = bh.Wp();
        for (int i3 = 0; i3 < com_tencent_mm_protocal_c_bno.wQk.size(); i3++) {
            String vN = c.vN(n.a((bdo) com_tencent_mm_protocal_c_bno.wQk.get(i3)));
            if (!bh.ov(vN)) {
                aVar.kAE = vN;
                i.arG().a(aVar);
            }
        }
        return 0;
    }

    public final int getType() {
        return JsApiMakeVoIPCall.CTRL_INDEX;
    }
}
