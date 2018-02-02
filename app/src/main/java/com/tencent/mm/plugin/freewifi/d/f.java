package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.R;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.bio;
import com.tencent.mm.protocal.c.cn;
import com.tencent.mm.protocal.c.ei;
import com.tencent.mm.protocal.c.yl;
import com.tencent.mm.protocal.c.ym;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends c {
    private static int mEP = 7200;
    private String mac;
    private String ssid;

    protected final void aLV() {
        a aVar = new a();
        aVar.hmj = new yl();
        aVar.hmk = new ym();
        aVar.uri = "/cgi-bin/mmo2o-bin/getbackpagefor33";
        aVar.hmi = 1726;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
    }

    public final int getType() {
        return 1726;
    }

    public f(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        aLV();
        this.ssid = str;
        this.mac = str2;
        cn cnVar = new cn();
        cnVar.mac = str2;
        cnVar.ssid = str;
        yl ylVar = (yl) this.gJQ.hmg.hmo;
        ylVar.appId = str3;
        ylVar.mFp = str4;
        ylVar.mFq = str5;
        ylVar.mFr = str6;
        ylVar.fqD = str7;
        ylVar.sign = str8;
        ylVar.wiH = cnVar;
    }

    protected final void b(int i, int i2, int i3, String str) {
        int i4;
        c cVar;
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
        boolean b;
        if (i2 == 0 && i3 == 0) {
            ym ymVar = (ym) this.gJQ.hmh.hmo;
            cVar.field_ssid = this.ssid;
            cVar.field_showUrl = ymVar.vEf;
            bio com_tencent_mm_protocal_c_bio = ymVar.vEg;
            if (com_tencent_mm_protocal_c_bio != null) {
                x.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "en : %s, cn : %s, tw : %s", new Object[]{com_tencent_mm_protocal_c_bio.wLZ, com_tencent_mm_protocal_c_bio.wMa, com_tencent_mm_protocal_c_bio.wMb});
                cVar.field_showWordCn = com_tencent_mm_protocal_c_bio.wMa;
                cVar.field_showWordEn = com_tencent_mm_protocal_c_bio.wLZ;
                cVar.field_showWordTw = com_tencent_mm_protocal_c_bio.wMb;
            } else {
                cVar.field_showWordCn = ac.getContext().getResources().getString(R.l.ekd);
                cVar.field_showWordEn = ac.getContext().getResources().getString(R.l.ekd);
                cVar.field_showWordTw = ac.getContext().getResources().getString(R.l.ekd);
            }
            cVar.field_action = ymVar.vEe;
            cVar.field_verifyResult = 1;
            cVar.field_connectState = -1;
            if (ymVar.vEo <= 0) {
                ymVar.vEo = mEP;
            }
            cVar.field_expiredTime = bh.Wo() + ((long) ymVar.vEo);
            cVar.field_mac = this.mac;
            if (i4 != 0) {
                b = j.aLO().b(cVar);
                x.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "insert freewifi ret = %b", new Object[]{Boolean.valueOf(b)});
            } else {
                b = j.aLO().c(cVar, new String[0]);
                x.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "insert freewifi ret = %b", new Object[]{Boolean.valueOf(b)});
            }
            j.aLO().AS(this.ssid);
            return;
        }
        x.e("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "check this ap failed, ssid is :%s", new Object[]{this.ssid});
        if (i4 == 0) {
            b = j.aLO().a(cVar, new String[0]);
            x.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "freewifi verify failed, delte local db infos : %s, ret = %b", new Object[]{this.ssid, Boolean.valueOf(b)});
        }
    }

    public final ei aMc() {
        return ((ym) this.gJQ.hmh.hmo).mHz;
    }
}
