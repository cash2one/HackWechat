package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.aa;
import com.tencent.mm.protocal.c.ab;
import com.tencent.mm.protocal.c.azp;
import com.tencent.mm.protocal.c.bio;
import com.tencent.mm.protocal.c.cn;
import com.tencent.mm.protocal.c.ei;
import com.tencent.mm.protocal.c.wi;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLDecoder;
import java.util.LinkedList;

public final class a extends c {
    private static int mEP = 7200;
    private int fut;
    private String mac;
    private String ssid;

    protected final void aLV() {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new aa();
        aVar.hmk = new ab();
        aVar.uri = "/cgi-bin/micromsg-bin/apauth";
        aVar.hmi = 640;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
    }

    public final int getType() {
        return 640;
    }

    public a(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7) {
        aLV();
        this.ssid = str2;
        this.mac = str3;
        aa aaVar = (aa) this.gJQ.hmg.hmo;
        String decode = URLDecoder.decode(str5);
        aaVar.vDW = 0;
        aaVar.URL = str;
        aaVar.SSID = str2;
        aaVar.vDT = str4;
        aaVar.vDU = decode;
        aaVar.vDV = str6;
        aaVar.vDY = i;
        aaVar.vDZ = str7;
        LinkedList linkedList = new LinkedList();
        cn cnVar = new cn();
        cnVar.ssid = str2;
        cnVar.mac = str3;
        linkedList.add(cnVar);
        aaVar.vDX = linkedList;
        x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "url : %s, ssid : %s, mid : %s, mac : %s, apauthdata : %s, decoded apauthdata :%s,  token : %s", new Object[]{str, str2, str4, str3, str5, decode, str6});
    }

    public a(String str, String str2, String str3, int i, int i2, String str4) {
        aLV();
        this.ssid = str3;
        this.mac = str2;
        this.fut = 1;
        LinkedList linkedList = new LinkedList();
        cn cnVar = new cn();
        cnVar.ssid = str3;
        cnVar.mac = str2;
        cnVar.vHB = i;
        linkedList.add(cnVar);
        aa aaVar = (aa) this.gJQ.hmg.hmo;
        aaVar.vDW = 1;
        aaVar.vDX = linkedList;
        aaVar.URL = str;
        aaVar.vDY = i2;
        aaVar.vDZ = str4;
        aaVar.vEb = m.AF("MicroMsg.FreeWifi.NetSceneAPAuth");
        x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "opcode = %d, mac = %s, ssid = %s, rssi = %d", new Object[]{Integer.valueOf(1), str2, str3, Integer.valueOf(i)});
    }

    public a(String str, int i, String str2) {
        aLV();
        this.fut = 4;
        aa aaVar = (aa) this.gJQ.hmg.hmo;
        aaVar.vDW = 4;
        aaVar.URL = str;
        aaVar.vDY = i;
        aaVar.vDZ = str2;
        aaVar.vEa = m.aLk();
        aaVar.vDX = new LinkedList();
        cn cnVar = new cn();
        cnVar.ssid = m.AD("MicroMsg.FreeWifi.NetSceneAPAuth");
        cnVar.mac = m.AE("MicroMsg.FreeWifi.NetSceneAPAuth");
        aaVar.vDX.add(cnVar);
        aaVar.vEb = m.AF("MicroMsg.FreeWifi.NetSceneAPAuth");
        x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "Constructing get front page request, HasMobile=%d, Ap_info[0].ssid=%s, Ap_info[0].mac=%s", new Object[]{Integer.valueOf(aaVar.vEa), cnVar.ssid, cnVar.mac});
        x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "opCode = %d, url = %s", new Object[]{Integer.valueOf(4), str});
    }

    protected final void b(int i, int i2, int i3, String str) {
        x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, opCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(this.fut)});
        c AR;
        c cVar;
        Object obj;
        ab abVar;
        bio com_tencent_mm_protocal_c_bio;
        switch (this.fut) {
            case 0:
                if (i2 == 0 && i3 == 0) {
                    AR = j.aLO().AR(this.ssid);
                    String str2 = "MicroMsg.FreeWifi.NetSceneAPAuth";
                    String str3 = "get freewifi by ssid :%s, is wifi info = null ? %b";
                    Object[] objArr = new Object[2];
                    objArr[0] = this.ssid;
                    objArr[1] = Boolean.valueOf(AR == null);
                    x.i(str2, str3, objArr);
                    if (AR == null) {
                        AR = new com.tencent.mm.plugin.freewifi.g.c();
                        AR.field_ssidmd5 = com.tencent.mm.sdk.platformtools.ab.UZ(this.ssid);
                        cVar = AR;
                        obj = 1;
                    } else {
                        cVar = AR;
                        obj = null;
                    }
                    cVar.field_wifiType = 1;
                    abVar = (ab) this.gJQ.hmh.hmo;
                    com_tencent_mm_protocal_c_bio = abVar.vEg;
                    if (com_tencent_mm_protocal_c_bio != null) {
                        x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", new Object[]{com_tencent_mm_protocal_c_bio.wLZ, com_tencent_mm_protocal_c_bio.wMa, com_tencent_mm_protocal_c_bio.wMb});
                        cVar.field_showWordCn = com_tencent_mm_protocal_c_bio.wMa;
                        cVar.field_showWordEn = com_tencent_mm_protocal_c_bio.wLZ;
                        cVar.field_showWordTw = com_tencent_mm_protocal_c_bio.wMb;
                    } else {
                        cVar.field_showWordCn = ac.getContext().getResources().getString(R.l.ekd);
                        cVar.field_showWordEn = ac.getContext().getResources().getString(R.l.ekd);
                        cVar.field_showWordTw = ac.getContext().getResources().getString(R.l.ekd);
                    }
                    cVar.field_action = abVar.vEe;
                    cVar.field_verifyResult = 1;
                    cVar.field_connectState = -1;
                    if (abVar.vEo <= 0) {
                        abVar.vEo = mEP;
                    }
                    cVar.field_expiredTime = bh.Wo() + ((long) abVar.vEo);
                    cVar.field_showUrl = abVar.vEf;
                    cVar.field_action = abVar.vEe;
                    cVar.field_ssid = this.ssid;
                    cVar.field_mac = this.mac;
                    cVar.field_wifiType = 1;
                    boolean b;
                    if (obj != null) {
                        b = j.aLO().b(cVar);
                        x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[]{Boolean.valueOf(b)});
                        x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert local freewifi info : %s, %b, expiredTime : %d, action :%d, showurl : %s", new Object[]{this.ssid, Boolean.valueOf(b), Integer.valueOf(abVar.vEd), Integer.valueOf(abVar.vEe), abVar.vEf});
                        return;
                    }
                    b = j.aLO().c(cVar, new String[0]);
                    x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "update local freewifi info : %s, %b, expiredTime : %d, action :%d, showurl : %s", new Object[]{this.ssid, Boolean.valueOf(b), Integer.valueOf(abVar.vEd), Integer.valueOf(abVar.vEe), abVar.vEf});
                    return;
                }
                return;
            case 1:
                AR = j.aLO().AR(this.ssid);
                if (AR == null) {
                    AR = new com.tencent.mm.plugin.freewifi.g.c();
                    AR.field_ssidmd5 = com.tencent.mm.sdk.platformtools.ab.UZ(this.ssid);
                    cVar = AR;
                    obj = 1;
                } else {
                    cVar = AR;
                    obj = null;
                }
                boolean b2;
                if (i2 == 0 && i3 == 0) {
                    abVar = (ab) this.gJQ.hmh.hmo;
                    cVar.field_ssid = this.ssid;
                    cVar.field_showUrl = abVar.vEf;
                    com_tencent_mm_protocal_c_bio = abVar.vEg;
                    x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "get resp info : %s, expiredTime : %d, action :%d, showurl : %s", new Object[]{this.ssid, Integer.valueOf(abVar.vEd), Integer.valueOf(abVar.vEe), abVar.vEf});
                    if (com_tencent_mm_protocal_c_bio != null) {
                        x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", new Object[]{com_tencent_mm_protocal_c_bio.wLZ, com_tencent_mm_protocal_c_bio.wMa, com_tencent_mm_protocal_c_bio.wMb});
                        cVar.field_showWordCn = com_tencent_mm_protocal_c_bio.wMa;
                        cVar.field_showWordEn = com_tencent_mm_protocal_c_bio.wLZ;
                        cVar.field_showWordTw = com_tencent_mm_protocal_c_bio.wMb;
                    } else {
                        cVar.field_showWordCn = ac.getContext().getResources().getString(R.l.ekd);
                        cVar.field_showWordEn = ac.getContext().getResources().getString(R.l.ekd);
                        cVar.field_showWordTw = ac.getContext().getResources().getString(R.l.ekd);
                    }
                    cVar.field_action = abVar.vEe;
                    cVar.field_verifyResult = 1;
                    cVar.field_connectState = -1;
                    if (abVar.vEo <= 0) {
                        abVar.vEo = mEP;
                    }
                    cVar.field_expiredTime = bh.Wo() + ((long) abVar.vEo);
                    cVar.field_mac = this.mac;
                    if (obj != null) {
                        b2 = j.aLO().b(cVar);
                        x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[]{Boolean.valueOf(b2)});
                    } else {
                        b2 = j.aLO().c(cVar, new String[0]);
                        x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[]{Boolean.valueOf(b2)});
                    }
                    j.aLO().AS(this.ssid);
                    return;
                }
                x.e("MicroMsg.FreeWifi.NetSceneAPAuth", "check this ap failed, ssid is :%s", new Object[]{this.ssid});
                if (obj == null) {
                    b2 = j.aLO().a(cVar, new String[0]);
                    x.i("MicroMsg.FreeWifi.NetSceneAPAuth", "freewifi verify failed, delte local db infos : %s, ret = %b", new Object[]{this.ssid, Boolean.valueOf(b2)});
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final String aLW() {
        ab abVar = (ab) this.gJQ.hmh.hmo;
        if (abVar != null) {
            return abVar.vEc;
        }
        return null;
    }

    public final azp aLX() {
        ab abVar = (ab) this.gJQ.hmh.hmo;
        if (abVar != null) {
            return abVar.vEj;
        }
        return null;
    }

    public final boolean aLY() {
        ab abVar = (ab) this.gJQ.hmh.hmo;
        if (abVar == null || abVar.vEk == null) {
            return false;
        }
        if (abVar.vEk.vEa == 1) {
            return true;
        }
        return false;
    }

    public final wi aLZ() {
        ab abVar = (ab) this.gJQ.hmh.hmo;
        if (abVar != null) {
            return abVar.vEk;
        }
        return null;
    }

    public final String aMa() {
        ab abVar = (ab) this.gJQ.hmh.hmo;
        if (abVar != null) {
            return abVar.vEm;
        }
        return null;
    }

    public final String aMb() {
        ab abVar = (ab) this.gJQ.hmh.hmo;
        if (abVar != null) {
            return abVar.vEn;
        }
        return null;
    }

    public final ei aMc() {
        ab abVar = (ab) this.gJQ.hmh.hmo;
        if (abVar != null) {
            return abVar.vEl;
        }
        return null;
    }
}
