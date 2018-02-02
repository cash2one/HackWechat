package com.tencent.mm.av;

import com.tencent.mm.av.a.a;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.y.g;

public final class e implements a {
    public final asv a(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        asv com_tencent_mm_protocal_c_asv = new asv();
        com_tencent_mm_protocal_c_asv.wAi = i;
        com_tencent_mm_protocal_c_asv.wAn = str;
        com_tencent_mm_protocal_c_asv.wAk = str2;
        com_tencent_mm_protocal_c_asv.wAl = str3;
        com_tencent_mm_protocal_c_asv.wAq = str4;
        com_tencent_mm_protocal_c_asv.wAp = str5;
        com_tencent_mm_protocal_c_asv.wAo = str6;
        com_tencent_mm_protocal_c_asv.wAt = str8;
        com_tencent_mm_protocal_c_asv.ngo = str11;
        com_tencent_mm_protocal_c_asv.wAs = str9;
        com_tencent_mm_protocal_c_asv.vVZ = str7;
        com_tencent_mm_protocal_c_asv.wAj = 0.0f;
        com_tencent_mm_protocal_c_asv.wAm = str10;
        com_tencent_mm_protocal_c_asv.vLj = 1;
        com_tencent_mm_protocal_c_asv.wAr = null;
        com_tencent_mm_protocal_c_asv.vZq = str7;
        return com_tencent_mm_protocal_c_asv;
    }

    public final asv a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        asv com_tencent_mm_protocal_c_asv = new asv();
        com_tencent_mm_protocal_c_asv.wAi = 7;
        com_tencent_mm_protocal_c_asv.wAn = str;
        com_tencent_mm_protocal_c_asv.wAv = str2;
        com_tencent_mm_protocal_c_asv.wAk = str3;
        com_tencent_mm_protocal_c_asv.wAl = str4;
        com_tencent_mm_protocal_c_asv.wAq = str5;
        com_tencent_mm_protocal_c_asv.wAp = str6;
        com_tencent_mm_protocal_c_asv.wAo = str7;
        com_tencent_mm_protocal_c_asv.wAt = str9;
        com_tencent_mm_protocal_c_asv.ngo = str12;
        com_tencent_mm_protocal_c_asv.wAs = str10;
        com_tencent_mm_protocal_c_asv.vVZ = str8;
        com_tencent_mm_protocal_c_asv.wAj = 0.0f;
        com_tencent_mm_protocal_c_asv.wAm = str11;
        com_tencent_mm_protocal_c_asv.vLj = 1;
        com_tencent_mm_protocal_c_asv.wAr = null;
        com_tencent_mm_protocal_c_asv.vZq = str8;
        return com_tencent_mm_protocal_c_asv;
    }

    public final asv a(String str, bnp com_tencent_mm_protocal_c_bnp, int i) {
        String str2 = null;
        if (com_tencent_mm_protocal_c_bnp == null || com_tencent_mm_protocal_c_bnp.wQo == null || com_tencent_mm_protocal_c_bnp.wQo.vYd == null || com_tencent_mm_protocal_c_bnp.wQo.vYd.size() <= 0) {
            return null;
        }
        aqr com_tencent_mm_protocal_c_aqr = (aqr) com_tencent_mm_protocal_c_bnp.wQo.vYd.get(0);
        if (com_tencent_mm_protocal_c_aqr == null) {
            return null;
        }
        asv com_tencent_mm_protocal_c_asv = new asv();
        com_tencent_mm_protocal_c_asv.wAi = i;
        com_tencent_mm_protocal_c_asv.vVZ = com_tencent_mm_protocal_c_bnp.nGJ;
        com_tencent_mm_protocal_c_asv.wAj = 0.0f;
        com_tencent_mm_protocal_c_asv.wAm = "";
        com_tencent_mm_protocal_c_asv.wAn = com_tencent_mm_protocal_c_aqr.wxE;
        com_tencent_mm_protocal_c_asv.wAs = null;
        com_tencent_mm_protocal_c_asv.vLj = 1;
        com_tencent_mm_protocal_c_asv.wAr = null;
        com_tencent_mm_protocal_c_asv.wAk = com_tencent_mm_protocal_c_aqr.fon;
        com_tencent_mm_protocal_c_asv.wAl = com_tencent_mm_protocal_c_aqr.nfe;
        if (com_tencent_mm_protocal_c_bnp.wQo != null) {
            str2 = com_tencent_mm_protocal_c_bnp.wQo.nfX;
        }
        com_tencent_mm_protocal_c_asv.wAq = str2;
        com_tencent_mm_protocal_c_asv.wAp = com_tencent_mm_protocal_c_aqr.wxI;
        com_tencent_mm_protocal_c_asv.wAo = com_tencent_mm_protocal_c_aqr.nfX;
        com_tencent_mm_protocal_c_asv.wAu = com_tencent_mm_protocal_c_aqr.wxF;
        com_tencent_mm_protocal_c_asv.vZq = com_tencent_mm_protocal_c_aqr.nGJ;
        com_tencent_mm_protocal_c_asv.wAt = str;
        com_tencent_mm_protocal_c_asv.ngo = com_tencent_mm_protocal_c_bnp.wQn.nGJ;
        com_tencent_mm_protocal_c_asv.wAz = com_tencent_mm_protocal_c_bnp.ksU;
        return com_tencent_mm_protocal_c_asv;
    }

    public final asv a(g.a aVar, String str, String str2, String str3, String str4) {
        if (aVar == null) {
            return null;
        }
        asv com_tencent_mm_protocal_c_asv = new asv();
        com_tencent_mm_protocal_c_asv.wAi = 0;
        com_tencent_mm_protocal_c_asv.vVZ = str;
        com_tencent_mm_protocal_c_asv.wAj = 0.0f;
        com_tencent_mm_protocal_c_asv.wAm = "";
        com_tencent_mm_protocal_c_asv.wAn = str2;
        com_tencent_mm_protocal_c_asv.wAs = str4;
        com_tencent_mm_protocal_c_asv.vLj = 1;
        com_tencent_mm_protocal_c_asv.wAr = null;
        com_tencent_mm_protocal_c_asv.wAk = aVar.title;
        com_tencent_mm_protocal_c_asv.wAl = aVar.description;
        com_tencent_mm_protocal_c_asv.wAq = aVar.url;
        com_tencent_mm_protocal_c_asv.wAp = aVar.hba;
        com_tencent_mm_protocal_c_asv.wAo = aVar.hbs;
        com_tencent_mm_protocal_c_asv.ngo = aVar.appId;
        com_tencent_mm_protocal_c_asv.wAt = str3;
        return com_tencent_mm_protocal_c_asv;
    }
}
