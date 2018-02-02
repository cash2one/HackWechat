package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.protocal.c.blp;
import com.tencent.mm.protocal.c.fn;
import com.tencent.mm.protocal.c.fo;
import com.tencent.mm.protocal.c.kp;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;
import java.util.LinkedList;

public final class t extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    public LinkedList<CardInfo> kLU = new LinkedList();

    public t(LinkedList<kp> linkedList, blp com_tencent_mm_protocal_c_blp, int i) {
        a aVar = new a();
        aVar.hmj = new fn();
        aVar.hmk = new fo();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetcarditembytpinfo";
        aVar.hmi = 699;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        fn fnVar = (fn) this.gJQ.hmg.hmo;
        fnVar.hdX = linkedList;
        fnVar.vEK = com_tencent_mm_protocal_c_blp;
        fnVar.fGW = i;
    }

    public final int getType() {
        return 699;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            Object obj = ((fo) this.gJQ.hmh.hmo).kLN;
            if (TextUtils.isEmpty(obj)) {
                x.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd fail, resp json_ret is null");
                this.gJT.a(4, -1, null, this);
                return;
            }
            Collection wH = f.wH(obj);
            if (wH != null) {
                l.axe();
                this.kLU.addAll(wH);
            }
            this.gJT.a(0, 0, str, this);
            return;
        }
        x.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.gJT.a(i2, i3, str, this);
    }
}
