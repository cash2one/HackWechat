package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.R;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.plugin.freewifi.i;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.ac;
import com.tencent.mm.protocal.c.ad;
import com.tencent.mm.protocal.c.bio;
import com.tencent.mm.protocal.c.cn;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class b extends c {
    private static int mEP = 7200;
    public String mac;
    private String ssid;

    protected final void aLV() {
        a aVar = new a();
        aVar.hmj = new ac();
        aVar.hmk = new ad();
        aVar.uri = "/cgi-bin/mmo2o-bin/apcheck";
        aVar.hmi = 1744;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
    }

    public final int getType() {
        return 1744;
    }

    public b(String str, String str2, int i, int i2) {
        aLV();
        this.ssid = str2;
        this.mac = str;
        LinkedList linkedList = new LinkedList();
        cn cnVar = new cn();
        cnVar.ssid = str2;
        cnVar.mac = str;
        cnVar.vHB = i;
        linkedList.add(cnVar);
        ac acVar = (ac) this.gJQ.hmg.hmo;
        acVar.vEp = com.tencent.mm.plugin.freewifi.h.b.aLc().aKW();
        acVar.vDX = linkedList;
        acVar.vEq = m.aLm();
        acVar.vEr = i2;
        x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "new apcheck request. mac = %s, ssid = %s, rssi = %d", new Object[]{str, str2, Integer.valueOf(i)});
    }

    protected final void b(int i, int i2, int i3, String str) {
        int i4;
        boolean z;
        c cVar;
        x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "apcheck returns. onGYNetEnd : errType : %d, errCode : %d, errMsg : %s ", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (!(this.gJQ == null || this.gJQ.hmh.hmo == null)) {
            com.tencent.mm.plugin.freewifi.h.b.aLc().a((ad) this.gJQ.hmh.hmo);
            if (m.cz(i2, i3) || m.cA(i2, i3)) {
                ad adVar = (ad) this.gJQ.hmh.hmo;
                i4 = adVar.vEu;
                z = adVar.vEt;
                if (!(i4 == 0 || i4 == i.a.aLd().getInt("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", 7))) {
                    i.a.aLd().bm("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", i4);
                }
                if (z) {
                    i.a.aLd().A("LOCAL_CONFIG_LAST_APCHECK_SAVE_DELAY_CRD_TIMEMILLIS", System.currentTimeMillis());
                }
            }
        }
        c AR = j.aLO().AR(this.ssid);
        if (AR == null) {
            AR = new com.tencent.mm.plugin.freewifi.g.c();
            AR.field_ssidmd5 = ab.UZ(this.ssid);
            i4 = 1;
            cVar = AR;
        } else {
            i4 = 0;
            cVar = AR;
        }
        if (i2 == 0 && i3 == 0) {
            adVar = (ad) this.gJQ.hmh.hmo;
            cVar.field_ssid = this.ssid;
            cVar.field_showUrl = adVar.vEf;
            bio com_tencent_mm_protocal_c_bio = adVar.vEg;
            if (com_tencent_mm_protocal_c_bio != null) {
                x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", new Object[]{com_tencent_mm_protocal_c_bio.wLZ, com_tencent_mm_protocal_c_bio.wMa, com_tencent_mm_protocal_c_bio.wMb});
                cVar.field_showWordCn = com_tencent_mm_protocal_c_bio.wMa;
                cVar.field_showWordEn = com_tencent_mm_protocal_c_bio.wLZ;
                cVar.field_showWordTw = com_tencent_mm_protocal_c_bio.wMb;
            } else {
                cVar.field_showWordCn = com.tencent.mm.sdk.platformtools.ac.getContext().getResources().getString(R.l.ekd);
                cVar.field_showWordEn = com.tencent.mm.sdk.platformtools.ac.getContext().getResources().getString(R.l.ekd);
                cVar.field_showWordTw = com.tencent.mm.sdk.platformtools.ac.getContext().getResources().getString(R.l.ekd);
            }
            cVar.field_action = adVar.vEe;
            cVar.field_verifyResult = 1;
            cVar.field_connectState = -1;
            if (adVar.vEo <= 0) {
                adVar.vEo = mEP;
            }
            cVar.field_expiredTime = bh.Wo() + ((long) adVar.vEo);
            cVar.field_mac = this.mac;
            if (i4 != 0) {
                z = j.aLO().b(cVar);
                x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[]{Boolean.valueOf(z)});
            } else {
                z = j.aLO().c(cVar, new String[0]);
                x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[]{Boolean.valueOf(z)});
            }
            j.aLO().AS(this.ssid);
            return;
        }
        x.e("MicroMsg.FreeWifi.NetSceneAPAuth", "check this ap failed, ssid is :%s", new Object[]{this.ssid});
        if (i4 == 0) {
            z = j.aLO().a(cVar, new String[0]);
            x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "freewifi verify failed, delte local db infos : %s, ret = %b", new Object[]{this.ssid, Boolean.valueOf(z)});
        }
    }
}
