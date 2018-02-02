package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.protocal.c.na;
import com.tencent.mm.protocal.c.nb;

public final class d extends c {
    protected final void aLV() {
        a aVar = new a();
        aVar.hmj = new na();
        aVar.hmk = new nb();
        aVar.uri = "/cgi-bin/mmo2o-bin/checkifcallup";
        aVar.hmi = 1155;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
    }

    public final int getType() {
        return 1155;
    }

    public d(String str, String str2, String str3, String str4, String str5, long j, String str6, String str7) {
        aLV();
        na naVar = (na) this.gJQ.hmg.hmo;
        naVar.vVL = str;
        naVar.vVM = str2;
        naVar.vVN = str3;
        naVar.vVO = str4;
        naVar.vVP = str5;
        naVar.vVQ = j;
        naVar.vVR = str6;
        naVar.vVS = str7;
    }

    public final nb aMd() {
        return (nb) this.gJQ.hmh.hmo;
    }
}
