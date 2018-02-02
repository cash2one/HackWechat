package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ff;
import com.tencent.mm.protocal.c.fg;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class r extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    private int kLR = 0;

    public r(LinkedList<String> linkedList) {
        a aVar = new a();
        aVar.hmj = new ff();
        aVar.hmk = new fg();
        aVar.uri = "/cgi-bin/micromsg-bin/batchdelcarditem";
        aVar.hmi = 560;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((ff) this.gJQ.hmg.hmo).vLd = linkedList;
    }

    public final int getType() {
        return 560;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            LinkedList linkedList = ((fg) this.gJQ.hmh.hmo).vLe;
            String str2 = "MicroMsg.NetSceneBatchDelCardItem";
            String str3 = "onGYNetEnd, resp list count = %d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(linkedList == null ? 0 : linkedList.size());
            x.i(str2, str3, objArr);
            if (linkedList == null || linkedList.size() == 0) {
                x.e("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd fail, resp list is null");
            } else {
                this.kLR = 0;
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    boolean z;
                    String str4 = (String) it.next();
                    if (TextUtils.isEmpty(str4)) {
                        x.e("MicroMsg.NetSceneBatchDelCardItem", "processDelCardItem fail, id is null");
                        z = false;
                    } else {
                        c cardInfo = new CardInfo();
                        cardInfo.field_card_id = str4;
                        z = am.auA().a(cardInfo, new String[0]);
                        x.i("MicroMsg.NetSceneBatchDelCardItem", "processDelCardItem, delRet = %b", Boolean.valueOf(z));
                    }
                    if (!z) {
                        this.kLR++;
                    }
                }
                x.d("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd, %d fail items", Integer.valueOf(this.kLR));
            }
        }
        this.gJT.a(i2, i3, str, this);
    }
}
