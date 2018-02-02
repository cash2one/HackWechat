package com.tencent.mm.plugin.card.sharecard.model;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.afx;
import com.tencent.mm.protocal.c.afy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class e extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private com.tencent.mm.ae.e gJT;
    public LinkedList<String> kLS;
    public LinkedList<String> kLT = new LinkedList();

    public e(LinkedList<String> linkedList) {
        this.kLS = linkedList;
        a aVar = new a();
        aVar.hmj = new afx();
        aVar.hmk = new afy();
        aVar.uri = "/cgi-bin/micromsg-bin/getsharecardlist";
        aVar.hmi = 903;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((afx) this.gJQ.hmg.hmo).vLd = linkedList;
        x.i("MicroMsg.NetSceneGetShareCardList", "card_ids length is " + linkedList.size());
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(903), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            afy com_tencent_mm_protocal_c_afy = (afy) this.gJQ.hmh.hmo;
            x.v("MicroMsg.NetSceneGetShareCardList", "json:" + com_tencent_mm_protocal_c_afy.kLN);
            Object obj = com_tencent_mm_protocal_c_afy.kLN;
            if (TextUtils.isEmpty(obj)) {
                x.e("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd fail, resp json_ret is null");
                this.gJT.a(4, -1, null, this);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList wG = f.wG(obj);
            if (wG != null) {
                if (this.kLS != null) {
                    this.kLT.addAll(this.kLS);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                ar.Hg();
                long dz = c.EV().dz(Thread.currentThread().getId());
                Iterator it = wG.iterator();
                int i4 = 0;
                int i5 = 0;
                while (it.hasNext()) {
                    ShareCardInfo shareCardInfo = (ShareCardInfo) it.next();
                    i4++;
                    if (l.a(shareCardInfo)) {
                        x.i("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd update share card count");
                        com.tencent.mm.plugin.card.sharecard.a.b.R(ac.getContext(), shareCardInfo.field_card_tp_id);
                        if (shareCardInfo.field_status != 0) {
                            com.tencent.mm.plugin.card.sharecard.a.b.bQ(shareCardInfo.field_card_id, shareCardInfo.field_card_tp_id);
                        }
                    } else {
                        i5++;
                        this.kLT.remove(shareCardInfo.field_card_id);
                    }
                }
                ar.Hg();
                c.EV().fS(dz);
                x.i("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd do transaction use time %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
                x.e("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd, deal CardObject %d fail of %d", new Object[]{Integer.valueOf(i5), Integer.valueOf(i4)});
                l.axg();
                if (wG.size() > 0) {
                    int currentTimeMillis3 = (int) (System.currentTimeMillis() - currentTimeMillis);
                    ArrayList arrayList = new ArrayList();
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(281);
                    iDKey.SetKey(17);
                    iDKey.SetValue(1);
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(281);
                    iDKey2.SetKey(18);
                    iDKey2.SetValue((long) currentTimeMillis3);
                    IDKey iDKey3 = new IDKey();
                    iDKey3.SetID(281);
                    iDKey3.SetKey(19);
                    iDKey3.SetValue((long) wG.size());
                    IDKey iDKey4 = new IDKey();
                    iDKey4.SetID(281);
                    iDKey4.SetKey(21);
                    iDKey4.SetValue((long) (currentTimeMillis3 / wG.size()));
                    arrayList.add(iDKey);
                    arrayList.add(iDKey2);
                    arrayList.add(iDKey3);
                    arrayList.add(iDKey4);
                    g.pQN.a(arrayList, true);
                }
            }
            this.gJT.a(i2, i3, str, this);
            return;
        }
        x.e("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 903;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
