package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aah;
import com.tencent.mm.protocal.c.aai;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class ac extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    public int kIA;
    public int kIB;
    public LinkedList<String> kIx;
    public int kIz;

    public ac(String str) {
        a aVar = new a();
        aVar.hmj = new aah();
        aVar.hmk = new aai();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardserial";
        aVar.hmi = 577;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((aah) this.gJQ.hmg.hmo).fGU = str;
    }

    public final int getType() {
        return 577;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            aai com_tencent_mm_protocal_c_aai = (aai) this.gJQ.hmh.hmo;
            this.kIx = com_tencent_mm_protocal_c_aai.kIx;
            this.kIz = com_tencent_mm_protocal_c_aai.kIz;
            this.kIA = com_tencent_mm_protocal_c_aai.kIA;
            this.kIB = com_tencent_mm_protocal_c_aai.kIB;
        }
        x.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp request_time = %d, request_count = %d, refresh_interval = %d,", new Object[]{Integer.valueOf(this.kIz), Integer.valueOf(this.kIA), Integer.valueOf(this.kIB)});
        if (this.kIx != null) {
            x.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp codes size is " + this.kIx.size());
        }
        this.gJT.a(i2, i3, str, this);
    }
}
