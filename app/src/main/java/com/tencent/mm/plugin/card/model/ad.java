package com.tencent.mm.plugin.card.model;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aal;
import com.tencent.mm.protocal.c.aam;
import com.tencent.mm.protocal.c.aap;
import com.tencent.mm.protocal.c.lh;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class ad extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    public boolean kMd = false;

    public ad(double d, double d2, int i) {
        a aVar = new a();
        aVar.hmj = new aal();
        aVar.hmk = new aam();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardslayout";
        aVar.hmi = 984;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        aal com_tencent_mm_protocal_c_aal = (aal) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_aal.latitude = d;
        com_tencent_mm_protocal_c_aal.longitude = d2;
        com_tencent_mm_protocal_c_aal.scene = i;
        ar.Hg();
        com_tencent_mm_protocal_c_aal.wjx = (String) c.CU().get(w.a.xoh, null);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetCardsLayout", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        aam com_tencent_mm_protocal_c_aam = (aam) this.gJQ.hmh.hmo;
        x.v("MicroMsg.NetSceneGetCardsLayout", "json:" + com_tencent_mm_protocal_c_aam.kLN);
        if (i2 == 0 && i3 == 0) {
            boolean z;
            ar.Hg();
            c.CU().a(w.a.xoh, com_tencent_mm_protocal_c_aam.wjx);
            String str2 = com_tencent_mm_protocal_c_aam.kLN;
            long currentTimeMillis = System.currentTimeMillis();
            ar.Hg();
            String str3 = (String) c.CU().get(w.a.xog, null);
            if (!bh.ov(str3)) {
                str2 = str3;
            }
            aap wN = j.wN(str2);
            am.auA().gJP.fx("UserCardInfo", "update UserCardInfo set stickyIndex=0, stickyEndTime=0 , label_wording='' where stickyIndex>0");
            if (wN == null) {
                x.w("MicroMsg.CardStickyHelper", "[doUpdateStickyInfoLogic] resp null");
                z = false;
            } else {
                int i4;
                if (wN.wjA != null) {
                    lh lhVar = wN.wjA;
                    Map hashMap = new HashMap();
                    hashMap.put("expiring_list", Integer.valueOf(2));
                    hashMap.put("member_card_list", Integer.valueOf(2));
                    hashMap.put("nearby_list", Integer.valueOf(3));
                    hashMap.put("first_list", Integer.valueOf(5));
                    if (wN.wjD == 100) {
                        hashMap.put("expiring_list", Integer.valueOf(4));
                    } else if (wN.wjD == 102) {
                        hashMap.put("member_card_list", Integer.valueOf(4));
                    } else if (wN.wjD == 101) {
                        hashMap.put("nearby_list", Integer.valueOf(4));
                    }
                    ar.Hg();
                    long dz = c.EV().dz(Thread.currentThread().getId());
                    if (wN.wjA.vUf == null || wN.wjA.vUf.vUe == null || wN.wjA.vUf.vUe.size() <= 0) {
                        z = false;
                        i4 = 0;
                    } else {
                        j.a(wN.wjA.vUf.vUe, (((Integer) hashMap.get("expiring_list")).intValue() * 100000) + 3);
                        z = true;
                        i4 = wN.wjA.vUf.vUe.size() + 0;
                    }
                    if (!(wN.wjA.vUg == null || wN.wjA.vUg.vUe == null || wN.wjA.vUg.vUe.size() <= 0)) {
                        j.a(wN.wjA.vUg.vUe, (((Integer) hashMap.get("member_card_list")).intValue() * 100000) + 2);
                        i4 += wN.wjA.vUg.vUe.size();
                        z = true;
                    }
                    if (!(wN.wjA.vUh == null || wN.wjA.vUh.vUe == null || wN.wjA.vUh.vUe.size() <= 0)) {
                        j.a(wN.wjA.vUh.vUe, (((Integer) hashMap.get("nearby_list")).intValue() * 100000) + 1);
                        i4 += wN.wjA.vUh.vUe.size();
                        z = true;
                    }
                    if (!(wN.wjA.vUi == null || wN.wjA.vUi.vUe == null || wN.wjA.vUi.vUe.size() <= 0)) {
                        z = true;
                        i4 += wN.wjA.vUi.vUe.size();
                        j.b(wN.wjA.vUi.vUe, 0);
                    }
                    if (!(wN.wjA.vUj == null || wN.wjA.vUj.vUe == null || wN.wjA.vUj.vUe.size() <= 0)) {
                        int intValue = (((Integer) hashMap.get("first_list")).intValue() * 100000) + 4;
                        j.a(wN.wjA.vUj.vUe, intValue);
                        j.b(wN.wjA.vUj.vUe, intValue);
                        i4 += wN.wjA.vUj.vUe.size();
                        z = true;
                    }
                    ar.Hg();
                    c.EV().fS(dz);
                } else {
                    z = false;
                    i4 = 0;
                }
                am.auF().putValue("key_get_card_layout_resp", wN);
                ar.Hg();
                c.CU().a(w.a.xop, str2);
                if (i4 > 0) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    ArrayList arrayList = new ArrayList();
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(281);
                    iDKey.SetKey(36);
                    iDKey.SetValue(1);
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(281);
                    iDKey2.SetKey(37);
                    iDKey2.SetValue((long) ((int) (currentTimeMillis2 - currentTimeMillis)));
                    IDKey iDKey3 = new IDKey();
                    iDKey3.SetID(281);
                    iDKey3.SetKey(38);
                    iDKey3.SetValue((long) i4);
                    IDKey iDKey4 = new IDKey();
                    iDKey4.SetID(281);
                    iDKey4.SetKey(40);
                    iDKey4.SetValue((long) (((int) (currentTimeMillis2 - currentTimeMillis)) / i4));
                    arrayList.add(iDKey);
                    arrayList.add(iDKey2);
                    arrayList.add(iDKey3);
                    arrayList.add(iDKey4);
                    g.pQN.a(arrayList, true);
                }
            }
            this.kMd = z;
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 984;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
