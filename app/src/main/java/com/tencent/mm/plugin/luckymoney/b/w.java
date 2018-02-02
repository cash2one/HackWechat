package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.a.a;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class w extends aa {
    public int liR;
    public String liT;
    public String obH;
    public String obI;
    public String obN;
    public ah ocd;
    public String ode;
    public boolean odf;
    public int odg;
    public String odh;
    public ah odi;
    public ah odj;
    public ah odk;
    public int odl = 0;
    public LinkedList<k> odm;

    public w(String str) {
        Map hashMap = new HashMap();
        hashMap.put("scene", "8");
        hashMap.put("ver", str);
        g.Dk();
        hashMap.put("walletType", String.valueOf(g.Dj().CU().get(339975, null)));
        D(hashMap);
    }

    public w(String str, byte b) {
        Map hashMap = new HashMap();
        hashMap.put("ver", str);
        g.Dk();
        hashMap.put("walletType", String.valueOf(g.Dj().CU().get(339975, null)));
        D(hashMap);
    }

    public final int getType() {
        return 1554;
    }

    public final String ayN() {
        return "/cgi-bin/mmpay-bin/operationwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            this.odg = jSONObject.optInt("randomAmount");
            this.ode = jSONObject.optString("randomWishing");
            this.liT = jSONObject.optString("notice");
            this.odh = jSONObject.optString("notice_url");
            this.odf = jSONObject.optInt("hasCanShareHongBao") == 1;
            this.liR = jSONObject.optInt("currency");
            this.obH = jSONObject.optString("currencyUint");
            this.obI = jSONObject.optString("currencyWording");
            x.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "currency=" + this.liR + ";currencyUint=" + this.obH + ";currencyWording=" + this.obI);
            c cVar = new c();
            cVar.obB = jSONObject.optString("groupHint");
            cVar.obC = jSONObject.optString("personalHint");
            cVar.obA = ((double) jSONObject.optLong("totalAmount", 200000)) / 100.0d;
            cVar.obz = jSONObject.optInt("totalNum", 100);
            cVar.obD = ((double) jSONObject.optLong("perPersonMaxValue", 20000)) / 100.0d;
            cVar.obE = ((double) jSONObject.optLong("perGroupMaxValue", 20000)) / 100.0d;
            cVar.obF = ((double) jSONObject.optLong("perMinValue", 1)) / 100.0d;
            cVar.obG = jSONObject.optInt("payShowBGFlag");
            cVar.liR = this.liR;
            cVar.obH = this.obH;
            cVar.obI = this.obI;
            a.aWP();
            d aWQ = a.aWQ();
            aWQ.obJ = cVar;
            x.i("MicroMsg.LuckyMoneyConfigManager", "setConfig maxTotalAmount:" + aWQ.obJ.obA + " maxTotalNum:" + aWQ.obJ.obz + " perGroupMaxValue:" + aWQ.obJ.obE + " perMinValue:" + aWQ.obJ.obF + " perPersonMaxValue:" + aWQ.obJ.obD);
            try {
                String str2 = new String(aWQ.obJ.toByteArray(), "ISO-8859-1");
                g.Dk();
                g.Dj().CU().set(356355, str2);
                g.Dk();
                g.Dj().CU().lH(true);
            } catch (UnsupportedEncodingException e) {
                x.w("MicroMsg.LuckyMoneyConfigManager", "save config exp, " + e.getLocalizedMessage());
            } catch (IOException e2) {
                x.w("MicroMsg.LuckyMoneyConfigManager", "save config exp, " + e2.getLocalizedMessage());
            }
            this.odi = l.J(jSONObject.optJSONObject("operationHeader"));
            this.ocd = l.J(jSONObject.optJSONObject("operationTail"));
            this.odj = l.J(jSONObject.optJSONObject("operationNext"));
            this.odk = l.J(jSONObject.optJSONObject("operationMiddle"));
            int optInt = jSONObject.optInt("sceneSwitch");
            g.Dk();
            g.Dj().CU().a(com.tencent.mm.storage.w.a.xnD, Integer.valueOf(optInt));
            x.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "sceneSwitch:" + optInt);
            this.odl = jSONObject.optInt("scenePicSwitch");
            x.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "scenePicSwitch:" + this.odl);
            this.obN = jSONObject.optString("wishing");
            x.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "wishing: %s", new Object[]{this.obN});
            JSONArray optJSONArray = jSONObject.optJSONArray("yearMess");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                x.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "yearMessJson is empty!");
                return;
            }
            x.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "yearMessJson length:" + optJSONArray.length());
            this.odm = new LinkedList();
            for (optInt = 0; optInt < optJSONArray.length(); optInt++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(optInt);
                k kVar = new k();
                kVar.ocB = optJSONObject.optInt("yearAmount", 0);
                kVar.ocC = optJSONObject.optString("yearWish");
                this.odm.add(kVar);
            }
            return;
        }
        x.e("MicroMsg.NetSceneLuckyMoneyGetConfig", "hongbao operation fail, errCode:" + i + ", errMsg:" + str);
    }
}
