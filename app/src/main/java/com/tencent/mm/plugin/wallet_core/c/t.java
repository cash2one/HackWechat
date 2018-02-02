package com.tencent.mm.plugin.wallet_core.c;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.q;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.tenpay.model.i;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class t extends i {
    public String kIw;
    public String mTimeStamp;
    public String pJp;
    public List<ElementQuery> sIH;
    public ElementQuery sII;
    private int sIJ;
    private int sIK;
    private int sIL;
    public Profession[] sIM;

    public t(String str, String str2, PayInfo payInfo) {
        this(3, str, str2, payInfo, null, -1, -1);
    }

    public t(String str, String str2, PayInfo payInfo, int i) {
        this(3, str, str2, payInfo, null, -1, i);
    }

    public t(String str, String str2, PayInfo payInfo, String str3, int i, int i2) {
        this(3, str, str2, payInfo, str3, i, i2);
    }

    public t() {
        this(3, null, null, null, null, -1, -1);
    }

    private t(int i, String str, String str2, PayInfo payInfo, String str3, int i2, int i3) {
        this.sIH = null;
        this.sII = null;
        this.mTimeStamp = null;
        this.kIw = null;
        this.pJp = null;
        this.sIJ = 3;
        this.sIM = null;
        this.kIw = str2;
        this.sIJ = 3;
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        a(payInfo, hashMap, hashMap2);
        hashMap.put("req_key", str);
        hashMap.put("flag", "4");
        hashMap.put("card_id", str2);
        if (i3 > 0) {
            hashMap.put("realname_scene", String.valueOf(i3));
            x.i("MicroMsg.NetSenceTenPayBase", "realname_scene=%d", new Object[]{Integer.valueOf(i3)});
        }
        if (i2 == 8) {
            hashMap.put("scene", "1003");
        }
        hashMap.put("bank_card_tag", new StringBuilder(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL).toString());
        hashMap.put("token", str3);
        D(hashMap);
        if (o.cBs()) {
            hashMap2.put("uuid_for_bindcard", o.cBu());
            hashMap2.put("bindcard_scene", o.cBt());
        }
        aB(hashMap2);
    }

    public final int ayQ() {
        return 73;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.sIH = new ArrayList();
        try {
            String str2;
            int i2;
            JSONObject jSONObject2;
            this.mTimeStamp = jSONObject.optString("time_stamp");
            String optString = jSONObject.optString("bank_type");
            if (bh.ov(this.pJp)) {
                str2 = optString;
            } else {
                str2 = this.pJp;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("Array");
            int length = jSONArray.length();
            for (i2 = 0; i2 < length; i2++) {
                jSONObject2 = jSONArray.getJSONObject(i2);
                ElementQuery elementQuery = new ElementQuery();
                elementQuery.hou = jSONObject2;
                elementQuery.nBM = jSONObject2.optString("bank_name");
                elementQuery.oZz = jSONObject2.optString("bank_type");
                elementQuery.sMA = jSONObject2.optString("bankacc_type_name");
                elementQuery.sMC = jSONObject2.optString("bank_phone");
                elementQuery.sMF = jSONObject2.optString("forbid_word");
                elementQuery.sME = jSONObject2.optString("bank_recommend_desc");
                elementQuery.sMD = jSONObject2.optString("bank_app_user_name");
                elementQuery.sMz = jSONObject2.optInt("bankacc_type", 1);
                elementQuery.sMs = e.h(jSONObject2, "canModifyName");
                elementQuery.sMt = e.h(jSONObject2, "canModifyCreID");
                elementQuery.sMx = "0".equals(jSONObject2.optString("is_sure"));
                elementQuery.sMu = "1".equals(jSONObject2.optString("needCVV"));
                elementQuery.sMv = "1".equals(jSONObject2.optString("needValiDate"));
                elementQuery.sMr = jSONObject2.optString("time_stamp");
                elementQuery.sMw = jSONObject2.optString("uesr_name");
                elementQuery.sMB = jSONObject2.optString("bank_flag");
                elementQuery.sMG = e.h(jSONObject2, "needFirstName");
                elementQuery.sMH = e.h(jSONObject2, "needLastName");
                elementQuery.sMI = e.h(jSONObject2, "needCountry");
                elementQuery.sMJ = e.h(jSONObject2, "needArea");
                elementQuery.sMK = e.h(jSONObject2, "needCity");
                elementQuery.sML = e.h(jSONObject2, "needAddress");
                elementQuery.sMM = e.h(jSONObject2, "needZip");
                elementQuery.sMN = e.h(jSONObject2, "needPhone");
                elementQuery.sMO = e.h(jSONObject2, "needEmail");
                elementQuery.sMR = e.h(jSONObject2, "needShowProtocol");
                elementQuery.sMP = jSONObject2.optString("support_cre_type");
                elementQuery.sIJ = jSONObject2.optInt("bank_card_tag", 1);
                if (elementQuery.sIJ == 1) {
                    if (!e.h(jSONObject2, "IsSaveYfq")) {
                        elementQuery.sMy = 0;
                    } else if (e.h(jSONObject2, "canReturnYfq")) {
                        elementQuery.sMy = 4;
                    } else {
                        elementQuery.sMy = 3;
                    }
                } else if (jSONObject2.optInt("auth_mode") == 1) {
                    elementQuery.sMy = 1;
                } else {
                    elementQuery.sMy = 2;
                }
                CharSequence optString2 = jSONObject2.optString("support_micropay");
                if (TextUtils.isEmpty(optString2)) {
                    elementQuery.sMS = true;
                } else if ("1".equals(optString2)) {
                    elementQuery.sMS = true;
                } else if ("0".equals(optString2)) {
                    elementQuery.sMS = false;
                }
                elementQuery.sKA = jSONObject2.optString("arrive_type");
                if (Bankcard.dY(this.sIJ, elementQuery.sIJ)) {
                    this.sIH.add(elementQuery);
                }
                if (str2 != null && str2.equals(elementQuery.oZz)) {
                    this.sII = elementQuery;
                }
            }
            SparseArray sparseArray = new SparseArray();
            jSONArray = jSONObject.getJSONArray("cre_type_map");
            length = jSONArray.length();
            for (i2 = 0; i2 < length; i2++) {
                jSONObject2 = jSONArray.getJSONObject(i2);
                int optInt = jSONObject2.optInt("key", 0);
                if (optInt > 0) {
                    sparseArray.put(optInt, jSONObject2.getString("val"));
                }
            }
            q bLy = com.tencent.mm.plugin.wallet_core.model.o.bLy();
            List list = this.sIH;
            bLy.sPo = sparseArray;
            bLy.sIH = list;
            this.sIK = jSONObject.optInt("need_area");
            this.sIL = jSONObject.optInt("need_profession");
            if (!(this.sII == null || this.sII.sIJ == 1)) {
                x.i("MicroMsg.NetSenceTenPayBase", "oversea card, no need area and profession");
                this.sIK = 0;
                this.sIL = 0;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("profession_array");
            if (optJSONArray != null) {
                this.sIM = new Profession[optJSONArray.length()];
                for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        String optString3 = optJSONObject.optString("profession_name");
                        int optInt2 = optJSONObject.optInt("profession_type");
                        if (bh.ov(optString3)) {
                            x.i("MicroMsg.NetSenceTenPayBase", "empty profession_name!");
                        } else {
                            this.sIM[i2] = new Profession(optString3, optInt2);
                        }
                    }
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSenceTenPayBase", e, "", new Object[0]);
        }
    }

    public final int Hr() {
        return 1505;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/elementquerynew";
    }

    public final boolean bKJ() {
        return this.sIK == 1;
    }

    public final boolean bKK() {
        return this.sIL == 1;
    }
}
