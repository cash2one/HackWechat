package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class x extends i {
    public String fKP;
    public String fKQ;
    public String fKR;
    public String fKS;
    public String fKT;
    public String fKU;
    public int fKV;
    public String fKW;
    public String fKX;
    public String fKY;
    public String fKZ;
    public String fLa;
    public LinkedList<String> fLb;
    public ECardInfo fLc;
    public Map<String, String> oWX;
    public Map<String, String> sEq;
    public int scene;
    public String title;

    public x() {
        this(null, 0);
    }

    public x(String str, int i) {
        this.fKU = "";
        this.fKV = 0;
        this.fKW = "";
        this.fKX = "";
        this.fKY = "";
        this.fKZ = "";
        this.fLa = "";
        this.title = "";
        this.fLb = new LinkedList();
        this.scene = 0;
        this.oWX = new HashMap();
        this.scene = i;
        this.oWX.put("req_key", str);
        this.oWX.put("bind_query_scene", String.valueOf(i));
        l lVar = (l) g.h(l.class);
        this.oWX.put("is_root", "0");
        if (lVar != null) {
            this.oWX.put("is_device_open_touch", "1");
            Map aKm = lVar.aKm();
            if (aKm != null) {
                this.oWX.putAll(aKm);
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "is_device_open_touch is true");
        } else {
            this.oWX.put("is_device_open_touch", "0");
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "is_device_open_touch is false");
        }
        D(this.oWX);
        this.sEq = new HashMap();
        g.Dk();
        String str2 = (String) g.Dj().CU().get(196612, null);
        g.Dk();
        String str3 = (String) g.Dj().CU().get(196613, null);
        this.sEq.put("bind_serial", str2);
        this.sEq.put("last_bind_serial", str3);
        aB(this.sEq);
    }

    public int ayQ() {
        return 72;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            JSONObject optJSONObject;
            if (jSONObject.has("real_name_info")) {
                JSONObject optJSONObject2 = jSONObject.optJSONObject("real_name_info");
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "get real_name_info %s", optJSONObject2.toString());
                this.fKP = optJSONObject2.optString("guide_flag");
                this.fKQ = optJSONObject2.optString("guide_wording");
                this.fKR = optJSONObject2.optString("left_button_wording");
                this.fKS = optJSONObject2.optString("right_button_wording");
                this.fKT = optJSONObject2.optString("upload_credit_url");
                this.fKU = optJSONObject2.optString("done_button_wording");
                this.fKV = optJSONObject2.optInt("is_show_protocol", 0);
                this.fKW = optJSONObject2.optString("left_protocol_wording");
                this.fKX = optJSONObject2.optString("new_upload_credit_url");
                this.fKY = optJSONObject2.optString("protocol_url");
                this.fKZ = optJSONObject2.optString("right_protocol_wording");
                this.fLa = optJSONObject2.optString("subtitle");
                this.title = optJSONObject2.optString("title");
                JSONArray optJSONArray = optJSONObject2.optJSONArray("upload_reasons");
                this.fLb.clear();
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        this.fLb.add(optJSONArray.optString(i2));
                    }
                }
                if (optJSONObject2.has("ecard_info")) {
                    optJSONObject = optJSONObject2.optJSONObject("ecard_info");
                    this.fLc = new ECardInfo();
                    this.fLc.title = this.title;
                    this.fLc.sMl = new ArrayList(this.fLb);
                    this.fLc.sMn = this.fKY;
                    this.fLc.sMo = this.fKW;
                    this.fLc.sMp = this.fKZ;
                    this.fLc.sMm = this.fKU;
                    this.fLc.sMe = optJSONObject.optInt("ecard_open_scene", 0);
                    this.fLc.fqF = optJSONObject.optString("ecard_type", "");
                    this.fLc.sMf = optJSONObject.optInt("show_check_box", 0);
                    this.fLc.sMg = optJSONObject.optInt("check_box_selected", 0);
                    this.fLc.sMh = optJSONObject.optString("check_box_left_wording", "");
                    this.fLc.sMi = optJSONObject.optString("check_box_right_wording", "");
                    this.fLc.sMj = optJSONObject.optString("check_box_url", "");
                    this.fLc.sMk = optJSONObject.optInt("is_upload_credid", 0);
                    this.fLc.fKT = optJSONObject.optString("upload_credit_url", "");
                }
            }
            if (jSONObject.has("paymenu_array") && this.scene == 1) {
                JSONArray optJSONArray2 = jSONObject.optJSONArray("paymenu_array");
                if (optJSONArray2 != null) {
                    w.MV(optJSONArray2.toString());
                }
            }
            long optLong = jSONObject.optLong("time_stamp");
            if (optLong > 0) {
                n.setTimeStamp(String.valueOf(optLong));
            } else {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.NetSceneTenpayQueryBindBankcard", "no time_stamp in bindquerynew.");
            }
            ab.a(jSONObject, this.scene);
            if (ab.zk(this.scene) || this.scene == 1) {
                optJSONObject = jSONObject.optJSONObject("bind_card_menu");
                if (optJSONObject != null) {
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneTenpayQueryBindBankcard", "bind card menu: %s", optJSONObject.toString());
                    g.Dk();
                    g.Dj().CU().a(a.USERINFO_WALLET_BIND_CARD_MENU_STRING_SYNC, optJSONObject.toString());
                } else {
                    g.Dk();
                    g.Dj().CU().a(a.USERINFO_WALLET_BIND_CARD_MENU_STRING_SYNC, (Object) "");
                }
            }
            l lVar = (l) g.h(l.class);
            if (lVar != null) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "IFingerPrintMgr is not null");
                lVar.aKf();
                lVar.fi(o.bLq().bLO());
                return;
            }
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneTenpayQueryBindBankcard", "IFingerPrintMgr is null");
        }
    }

    public int Hr() {
        return 1501;
    }

    public String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/bindquerynew";
    }
}
