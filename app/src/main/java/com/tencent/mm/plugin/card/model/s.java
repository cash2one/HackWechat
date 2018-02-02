package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.fp;
import com.tencent.mm.protocal.c.fq;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class s extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    private LinkedList<ak> kLS;
    public LinkedList<ak> kLT = new LinkedList();

    public s(LinkedList<ak> linkedList) {
        this.kLS = linkedList;
        a aVar = new a();
        aVar.hmj = new fp();
        aVar.hmk = new fq();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetcarditem";
        aVar.hmi = 559;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((fp) this.gJQ.hmg.hmo).vLd = D(linkedList);
    }

    public final int getType() {
        return 559;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            Object obj = ((fq) this.gJQ.hmh.hmo).kLN;
            if (TextUtils.isEmpty(obj)) {
                x.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd fail, resp json_ret is null");
                this.gJT.a(4, -1, null, this);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList wH = f.wH(obj);
            if (wH != null) {
                if (this.kLS != null) {
                    this.kLT.addAll(this.kLS);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                ar.Hg();
                long dz = c.EV().dz(Thread.currentThread().getId());
                int i4 = 0;
                Iterator it = wH.iterator();
                int i5 = 0;
                while (it.hasNext()) {
                    CardInfo cardInfo = (CardInfo) it.next();
                    i5++;
                    if (!l.b(cardInfo)) {
                        i4++;
                        LinkedList linkedList = this.kLT;
                        if (cardInfo != null) {
                            ak akVar = new ak();
                            akVar.field_cardUserId = cardInfo.field_card_id;
                            linkedList.remove(akVar);
                        }
                    }
                    i4 = i4;
                }
                ar.Hg();
                c.EV().fS(dz);
                x.i("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd do transaction use time %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
                x.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, deal CardObject %d fail of %d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i5)});
                l.axe();
                if (wH.size() > 0) {
                    int currentTimeMillis3 = (int) (System.currentTimeMillis() - currentTimeMillis);
                    ArrayList arrayList = new ArrayList();
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(281);
                    iDKey.SetKey(43);
                    iDKey.SetValue(1);
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(281);
                    iDKey2.SetKey(44);
                    iDKey2.SetValue((long) currentTimeMillis3);
                    IDKey iDKey3 = new IDKey();
                    iDKey3.SetID(281);
                    iDKey3.SetKey(45);
                    iDKey3.SetValue((long) wH.size());
                    IDKey iDKey4 = new IDKey();
                    iDKey4.SetID(281);
                    iDKey4.SetKey(47);
                    iDKey4.SetValue((long) (currentTimeMillis3 / wH.size()));
                    arrayList.add(iDKey);
                    arrayList.add(iDKey2);
                    arrayList.add(iDKey3);
                    arrayList.add(iDKey4);
                    g.pQN.a(arrayList, true);
                }
            }
            this.gJT.a(0, 0, str, this);
            return;
        }
        x.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.gJT.a(i2, i3, str, this);
    }

    private static LinkedList<String> D(LinkedList<ak> linkedList) {
        LinkedList<String> linkedList2 = new LinkedList();
        if (linkedList == null || linkedList.size() == 0) {
            return linkedList2;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ak akVar = (ak) it.next();
            if (akVar != null) {
                linkedList2.add(akVar.field_cardUserId);
            }
        }
        return linkedList2;
    }
}
