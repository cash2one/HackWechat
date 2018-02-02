package com.tencent.mm.modelsimple;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.axl;
import com.tencent.mm.protocal.c.bea;
import com.tencent.mm.protocal.c.beb;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class ab extends k implements com.tencent.mm.network.k {
    public int errCode;
    public int errType;
    public long fqm = -1;
    public b gJQ;
    private e gJT;
    private final long hOd = 60000;
    private Runnable hOe;

    public ab(float f, float f2, long j) {
        axl com_tencent_mm_protocal_c_axl = new axl();
        com_tencent_mm_protocal_c_axl.vQt = f;
        com_tencent_mm_protocal_c_axl.vQu = f2;
        com_tencent_mm_protocal_c_axl.wcu = 1;
        com_tencent_mm_protocal_c_axl.wcr = 0;
        a(com_tencent_mm_protocal_c_axl, 1, -10000.0f, -10000.0f);
        this.fqm = j;
    }

    public ab(bea com_tencent_mm_protocal_c_bea) {
        a aVar = new a();
        aVar.hmj = com_tencent_mm_protocal_c_bea;
        aVar.hmk = new beb();
        aVar.uri = "/cgi-bin/micromsg-bin/scanstreetview";
        aVar.hmi = 424;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
    }

    public ab(axl com_tencent_mm_protocal_c_axl, float f, float f2) {
        a(com_tencent_mm_protocal_c_axl, 0, f, f2);
    }

    private void a(axl com_tencent_mm_protocal_c_axl, int i, float f, float f2) {
        a aVar = new a();
        aVar.hmj = new bea();
        aVar.hmk = new beb();
        aVar.uri = "/cgi-bin/micromsg-bin/scanstreetview";
        aVar.hmi = 424;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bea com_tencent_mm_protocal_c_bea = (bea) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bea.wJN = com_tencent_mm_protocal_c_axl;
        com_tencent_mm_protocal_c_bea.rYW = i;
        com_tencent_mm_protocal_c_bea.wJO = f;
        com_tencent_mm_protocal_c_bea.wJP = f2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    protected final int a(q qVar) {
        if (((bea) ((b) qVar).hmg.hmo).wJN != null) {
            return b.hmP;
        }
        x.e("MicroMsg.NetSceneScanStreetView", "req.rImpl.UserPos == null");
        return b.hmQ;
    }

    public final beb Sn() {
        if (this.gJQ == null || this.gJQ.hmh.hmo == null) {
            return null;
        }
        return (beb) this.gJQ.hmh.hmo;
    }

    protected final int Bh() {
        return 10;
    }

    protected final void a(a aVar) {
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneScanStreetView", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.errType = i2;
        this.errCode = i3;
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        } else {
            x.e("MicroMsg.NetSceneScanStreetView", "callback null");
        }
        x.d("MicroMsg.NetSceneScanStreetView", "xml is %s", Sn().vNZ);
        if (this.hOe != null) {
            this.hOe.run();
        }
    }

    public final int getType() {
        return 424;
    }

    public static String my(String str) {
        Map y = bi.y(str, "streetview");
        if (y == null) {
            return null;
        }
        return (String) y.get(".streetview.link");
    }
}
