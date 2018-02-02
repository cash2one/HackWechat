package com.tencent.mm.plugin.wallet.pay.a.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.wallet.pay.a.c;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class e extends i {
    private int fCV = 0;
    public String fKP;
    public String fKQ;
    public String fKR;
    public String fKS;
    public String fKT;
    public Orders pPl = null;
    private String sEE = null;
    public c sEF = null;
    private int scene = 0;

    public e(PayInfo payInfo, int i) {
        if (payInfo == null) {
            x.e("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "error payinfo is null %s", new Object[]{bh.cgy().toString()});
            this.sEE = "";
        } else {
            this.sEE = payInfo.fuH;
        }
        this.scene = i;
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        hashMap.put("support_cardtag3", "1");
        hashMap.put("req_key", this.sEE);
        hashMap.put("bind_query_scene", String.valueOf(i));
        hashMap.put("is_merge", "1");
        l lVar = (l) g.h(l.class);
        hashMap.put("is_root", "0");
        if (lVar == null || !lVar.aJX()) {
            hashMap.put("is_device_open_touch", "0");
            x.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "is_device_open_touch is false");
        } else {
            hashMap.put("is_device_open_touch", "1");
            Map aKm = lVar.aKm();
            if (aKm != null) {
                hashMap.putAll(aKm);
            }
            x.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "is_device_open_touch is true");
        }
        if (payInfo != null) {
            this.fCV = payInfo.fCV;
        }
        a(payInfo, hashMap, hashMap2);
        D(hashMap);
        aB(hashMap2);
    }

    public final int ayQ() {
        return MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
    }

    public final void a(com.tencent.mm.wallet_core.c.c cVar, JSONObject jSONObject) {
        super.a(cVar, jSONObject);
        int i = this.fCV;
        String str = this.sEE;
        int i2 = cVar.errCode;
        x.v("Micromsg.WalletPayLinkReport", "kvQrcode scene %s reqKey %s errcode %s", new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)});
        com.tencent.mm.plugin.report.service.g.pQN.h(15000, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)});
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        try {
            this.pPl = Orders.Y(jSONObject);
            if (this.pPl != null) {
                this.pPl.fuH = this.sEE;
            }
            long optLong = jSONObject.optJSONObject("bindqueryresp").optLong("time_stamp");
            if (optLong > 0) {
                n.setTimeStamp(String.valueOf(optLong));
            } else {
                x.w("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "no time_stamp in qrcodeusebindquery.");
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("query_order_info");
            if (optJSONObject != null) {
                x.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "get query_order_info");
                o.bLq().sQk = optJSONObject.optInt("query_order_time", 5) * 1000;
                o.bLq().mRetryCount = optJSONObject.optInt("query_order_count", 0);
                o.bLq().sQl = optJSONObject.optString("default_query_order_wording", "");
            }
            o.bLq().sQm = jSONObject.optString("pay_remind_wording");
            ab.a(jSONObject.optJSONObject("bindqueryresp"), this.fCV);
            l lVar = (l) g.h(l.class);
            if (lVar != null) {
                x.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "IFingerPrintMgr is not null");
                lVar.aKf();
            } else {
                x.e("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "IFingerPrintMgr is null");
            }
            if (jSONObject.has("real_name_info")) {
                optJSONObject = jSONObject.optJSONObject("real_name_info");
                this.fKP = optJSONObject.optString("guide_flag");
                this.fKQ = optJSONObject.optString("guide_wording");
                this.fKR = optJSONObject.optString("left_button_wording");
                this.fKS = optJSONObject.optString("right_button_wording");
                this.fKT = optJSONObject.optString("upload_credit_url");
            }
            if (jSONObject.has("user_notify_info")) {
                c cVar;
                optJSONObject = jSONObject.optJSONObject("user_notify_info");
                if (optJSONObject == null) {
                    cVar = null;
                } else {
                    int optInt = optJSONObject.optInt("notify_flag", 0);
                    String optString = optJSONObject.optString("notify_wording", "");
                    String optString2 = optJSONObject.optString("left_button_wording", "");
                    String optString3 = optJSONObject.optString("right_button_wording", "");
                    String optString4 = optJSONObject.optString("confirm_button_wording", "");
                    if (optInt == 0) {
                        cVar = null;
                    } else {
                        cVar = new c();
                        cVar.sEn = optInt;
                        cVar.sEo = optString;
                        cVar.odw = optString2;
                        cVar.odx = optString3;
                        cVar.sEp = optString4;
                    }
                }
                this.sEF = cVar;
            }
        } catch (Exception e) {
            x.e("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "hy: " + e.toString());
        }
    }

    public int Hr() {
        return 1593;
    }

    public String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/qrcodeusebindquery";
    }
}
