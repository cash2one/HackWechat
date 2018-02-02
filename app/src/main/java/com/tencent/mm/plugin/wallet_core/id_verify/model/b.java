package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.c.afg;
import com.tencent.mm.protocal.c.afh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.util.Iterator;
import org.json.JSONObject;

public final class b extends k implements com.tencent.mm.network.k {
    private com.tencent.mm.ae.b gJQ;
    private e gJT;
    public boolean sIl = false;
    private long sJQ = 10;

    public b() {
        x.i("MicroMsg.NetSceneGetRealnameWording", "NetSceneGetRealnameWording call");
        a aVar = new a();
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_afg = new afg();
        com_tencent_mm_protocal_c_afg.vQS = i.bLf();
        if (!f.ccT()) {
            com_tencent_mm_protocal_c_afg.vUz = f.ccU();
        }
        aVar.hmj = com_tencent_mm_protocal_c_afg;
        aVar.hmk = new afh();
        aVar.uri = "/cgi-bin/mmpay-bin/getrealnamewording";
        aVar.hmi = 1666;
        this.gJQ = aVar.JZ();
        this.gJQ.hmx = true;
    }

    public final int getType() {
        return 1666;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetRealnameWording", "onGYNetEnd,errType=" + i2 + "errCode=" + i3);
        if (i2 == 0 && i3 == 0) {
            long j;
            afh com_tencent_mm_protocal_c_afh = (afh) ((com.tencent.mm.ae.b) qVar).hmh.hmo;
            if (com_tencent_mm_protocal_c_afh.wnl <= 0) {
                j = this.sJQ;
            } else {
                j = com_tencent_mm_protocal_c_afh.wnl;
            }
            this.sIl = com_tencent_mm_protocal_c_afh.sIl;
            x.i("MicroMsg.NetSceneGetRealnameWording", "need_agree_duty %s", new Object[]{Boolean.valueOf(this.sIl)});
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("bindcardTitle", com_tencent_mm_protocal_c_afh.wne);
                jSONObject.put("bindcardSubTitle", com_tencent_mm_protocal_c_afh.wnf);
                jSONObject.put("bindIdTitle", com_tencent_mm_protocal_c_afh.wng);
                jSONObject.put("bindIdSubTitle", com_tencent_mm_protocal_c_afh.wnh);
                jSONObject.put("extral_wording", com_tencent_mm_protocal_c_afh.wni);
                jSONObject.put("question_answer_switch", com_tencent_mm_protocal_c_afh.wnj);
                jSONObject.put("question_answer_url", com_tencent_mm_protocal_c_afh.wnk);
                jSONObject.put("cache_time", j);
                jSONObject.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
                jSONObject.put("isShowBindCard", com_tencent_mm_protocal_c_afh.wnm);
                jSONObject.put("isShowBindCardVerify", com_tencent_mm_protocal_c_afh.wno);
                jSONObject.put("isShowBindId", com_tencent_mm_protocal_c_afh.wnn);
                jSONObject.put("bindCardVerifyTitle", com_tencent_mm_protocal_c_afh.wnp);
                jSONObject.put("bindCardVerifySubtitle", com_tencent_mm_protocal_c_afh.wnq);
                jSONObject.put("bindCardVerifyAlertViewRightBtnTxt", com_tencent_mm_protocal_c_afh.wnr);
                jSONObject.put("bindCardVerifyAlertViewContent", com_tencent_mm_protocal_c_afh.wns);
                jSONObject.put("isShowBindCardVerifyAlertView", com_tencent_mm_protocal_c_afh.wnt);
                if (com_tencent_mm_protocal_c_afh.wnu != null && com_tencent_mm_protocal_c_afh.wnu.size() > 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    Object obj = null;
                    Iterator it = com_tencent_mm_protocal_c_afh.wnu.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        if (obj != null) {
                            stringBuffer.append("\n");
                        }
                        stringBuffer.append(str2);
                        int i4 = 1;
                    }
                    jSONObject.put("cache_header_titles", stringBuffer.toString());
                }
                g.Dk();
                g.Dj().CU().a(w.a.xro, jSONObject.toString());
                g.Dk();
                g.Dj().CU().lH(true);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneGetRealnameWording", e, "", new Object[0]);
            }
        }
        this.gJT.a(i2, i3, str, this);
    }
}
