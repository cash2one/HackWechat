package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aur;
import com.tencent.mm.protocal.c.aus;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class d extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;
    public int liH;
    public String liI;
    public aus sZw;
    public String sZx;
    public String sZy;
    public String sZz;

    public d(String str, String str2, String str3, String str4, String str5, int i, boolean z) {
        this(str, str2, str3, str4, str5, i, z, false);
    }

    public d(String str, String str2, String str3, String str4, String str5, int i, boolean z, boolean z2) {
        this.liH = 0;
        this.liI = "";
        a aVar = new a();
        aVar.hmj = new aur();
        aVar.hmk = new aus();
        aVar.hmi = Exif.PARSE_EXIF_ERROR_CORRUPT;
        aVar.uri = "/cgi-bin/mmpay-bin/openecard";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        aur com_tencent_mm_protocal_c_aur = (aur) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_aur.vLI = str;
        com_tencent_mm_protocal_c_aur.vLJ = str2;
        this.gJQ.hmx = true;
        if (z) {
            com_tencent_mm_protocal_c_aur.wCE = str3;
        } else {
            com_tencent_mm_protocal_c_aur.wCF = str3;
        }
        if (z2) {
            com_tencent_mm_protocal_c_aur.wCG = 1;
        } else {
            com_tencent_mm_protocal_c_aur.wCG = 0;
        }
        com_tencent_mm_protocal_c_aur.sIF = str4;
        com_tencent_mm_protocal_c_aur.oZz = str5;
        com_tencent_mm_protocal_c_aur.fCy = i;
        this.sZx = str3;
        this.sZy = str4;
        this.sZz = str5;
        x.d("MicroMsg.NetSceneOpenECard", "cardNo: %s", new Object[]{str3});
        x.i("MicroMsg.NetSceneOpenECard", "cardType: %s, reqSerial: %s, openScene: %s, mobileNo: %s, bankType: %s", new Object[]{str, str2, Integer.valueOf(i), str4, str5});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneOpenECard", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.sZw = (aus) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneOpenECard", "ret_code: %d, ret_msg: %s", new Object[]{Integer.valueOf(this.sZw.kLO), this.sZw.kLP});
        if (!bh.ov(this.sZw.wCC)) {
            x.d("MicroMsg.NetSceneOpenECard", "rettext: %s", new Object[]{this.sZw.wCC});
            try {
                JSONObject jSONObject = new JSONObject(this.sZw.wCC);
                this.liH = jSONObject.optInt("retcode", 0);
                this.liI = jSONObject.optString("retmsg", "");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneOpenECard", e, "", new Object[0]);
            }
        }
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return Exif.PARSE_EXIF_ERROR_CORRUPT;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
