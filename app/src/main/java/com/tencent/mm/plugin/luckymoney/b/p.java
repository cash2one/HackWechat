package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.g.a.pg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.akf;
import com.tencent.mm.protocal.c.akg;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.wallet_core.c.l;
import com.tencent.mm.z.q;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

public abstract class p extends l {
    b gJQ;
    private e gJT;

    public abstract void a(int i, String str, JSONObject jSONObject);

    public abstract String ayN();

    public final void D(Map<String, String> map) {
        String FS = q.FS();
        g.Dk();
        x WO = ((h) g.h(h.class)).EY().WO(FS);
        if (WO != null) {
            map.put("province", WO.cie());
            map.put("city", WO.getCityCode());
        }
        if (this.gJQ == null) {
            a aVar = new a();
            aVar.hmj = new akf();
            aVar.hmk = new akg();
            aVar.uri = ayN();
            aVar.hmi = getType();
            aVar.hml = 0;
            aVar.hmm = 0;
            this.gJQ = aVar.JZ();
            this.gJQ.hmx = true;
        }
        akf com_tencent_mm_protocal_c_akf = (akf) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_akf.wru = ayO();
        com_tencent_mm_protocal_c_akf.wrv = 1;
        Object[] toArray = map.keySet().toArray();
        Arrays.sort(toArray);
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (Object obj : toArray) {
            String str = (String) map.get(obj);
            if (!bh.ov(str)) {
                if (i != 0) {
                    stringBuilder.append("&");
                }
                stringBuilder.append(obj);
                stringBuilder.append("=");
                stringBuilder.append(str);
                i = true;
            }
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + com_tencent_mm_protocal_c_akf.wru + ", req = " + stringBuilder.toString());
        com_tencent_mm_protocal_c_akf.wrw = new bdn().bj(stringBuilder.toString().getBytes());
    }

    public final void e(int i, int i2, String str, com.tencent.mm.network.q qVar) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + ayO() + ", errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        akg com_tencent_mm_protocal_c_akg = (akg) ((b) qVar).hmh.hmo;
        if (i == 0 && i2 == 0) {
            int i3 = com_tencent_mm_protocal_c_akg.wry;
            String b = n.b(com_tencent_mm_protocal_c_akg.wrx);
            if (i3 != 0 || bh.ov(b)) {
                str = com_tencent_mm_protocal_c_akg.wrz;
                i2 = 2;
                i = 1000;
            } else {
                i3 = com_tencent_mm_protocal_c_akg.fqv;
                try {
                    JSONObject jSONObject = new JSONObject(b);
                    int i4 = jSONObject.getInt("retcode");
                    b = com_tencent_mm_protocal_c_akg.errorMsg;
                    if (bh.ov(b)) {
                        b = jSONObject.optString("retmsg");
                    }
                    if (jSONObject.has("showmess")) {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneLuckyMoneyBase", "has alert item");
                        com.tencent.mm.plugin.wallet_core.model.a K = ad.K(jSONObject);
                        com.tencent.mm.sdk.b.b pgVar = new pg();
                        pgVar.fHf.fHg = K;
                        com.tencent.mm.sdk.b.a.xef.m(pgVar);
                    } else if (i4 == 0 && i3 == 0) {
                        a(i4, b, jSONObject);
                    } else {
                        int i5;
                        if (i3 == 0) {
                            i5 = DownloadResult.CODE_UNDEFINED;
                        } else {
                            i5 = i3;
                        }
                        str = b;
                        i2 = i5;
                        i = 1000;
                    }
                } catch (Throwable e) {
                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.NetSceneLuckyMoneyBase", e, "", new Object[0]);
                    str = ac.getContext().getString(i.uRf);
                    i2 = 2;
                    i = 1000;
                }
            }
        } else {
            Map y = bi.y(str, "e");
            if (y != null) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneLuckyMoneyBase", "CDN error!");
                str = (String) y.get(".e.Content");
            } else {
                str = ac.getContext().getString(i.uRf);
            }
        }
        if (i != 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + ayO() + ", errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        }
        this.gJT.a(i, i2, str, this);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public int ayO() {
        return -1;
    }

    public final int aXh() {
        return ayO();
    }
}
