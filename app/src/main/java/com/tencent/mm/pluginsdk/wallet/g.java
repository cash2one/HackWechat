package com.tencent.mm.pluginsdk.wallet;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import org.json.JSONObject;

public final class g {
    public String appId;
    public String extInfo;
    public String fCT;
    public String fCU;
    public int fCV;
    public int fCW;
    public int fqJ;
    public String nonceStr;
    public String packageExt;
    public String partnerId;
    public String signType;
    public String timeStamp;
    public String url;
    public int vzJ = 0;
    public String vzK;
    public int vzL = 0;

    public g(Map<String, Object> map) {
        this.appId = (String) map.get("appId");
        this.partnerId = (String) map.get("partnerId");
        this.signType = (String) map.get("signType");
        this.nonceStr = (String) map.get("nonceStr");
        this.timeStamp = (String) map.get("timeStamp");
        this.packageExt = (String) map.get("package");
        this.fCT = (String) map.get("paySign");
        this.url = (String) map.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        this.fCU = (String) map.get("src_username");
        this.fCV = bh.getInt((String) map.get("scene"), 0);
        if (this.fCV == 0) {
            this.fCV = bh.getInt((String) map.get("pay_scene"), 0);
        }
        this.fqJ = bh.getInt((String) map.get("pay_channel"), 0);
        this.extInfo = bh.ou((String) map.get("ext_info"));
        this.vzK = bh.ou((String) map.get("token"));
        this.vzL = bh.getInt(bh.az((String) map.get("result_jump_mode"), "0"), 0);
    }

    public g(JSONObject jSONObject) {
        this.appId = jSONObject.optString("appId");
        this.partnerId = jSONObject.optString("partnerId");
        this.signType = jSONObject.optString("signType");
        this.nonceStr = jSONObject.optString("nonceStr");
        this.timeStamp = jSONObject.optString("timeStamp");
        this.packageExt = jSONObject.optString("package");
        this.fCT = jSONObject.optString("paySign");
        this.url = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        this.fCU = jSONObject.optString("src_username");
        this.fCV = jSONObject.optInt("scene", 0);
        if (this.fCV == 0) {
            this.fCV = jSONObject.optInt("pay_scene", 0);
        }
        this.fqJ = jSONObject.optInt("pay_channel", 0);
        this.extInfo = jSONObject.optString("ext_info", "");
        this.vzK = jSONObject.optString("token", "");
        this.vzL = bh.getInt(jSONObject.optString("result_jump_mode", "0"), 0);
        this.vzJ = jSONObject.optInt("pay_for_wallet_type", 0);
    }

    public g(ln lnVar) {
        if (lnVar != null && lnVar.fCS != null) {
            this.appId = lnVar.fCS.appId;
            this.partnerId = lnVar.fCS.partnerId;
            this.signType = lnVar.fCS.signType;
            this.nonceStr = lnVar.fCS.nonceStr;
            this.timeStamp = lnVar.fCS.timeStamp;
            this.packageExt = lnVar.fCS.packageExt;
            this.fCT = lnVar.fCS.fCT;
            this.url = lnVar.fCS.url;
            this.fCU = lnVar.fCS.fCU;
            this.fCV = lnVar.fCS.fCV;
            this.fqJ = lnVar.fCS.fqJ;
            this.fCW = lnVar.fCS.fCW;
        }
    }

    public static int eD(int i, int i2) {
        int i3;
        if (i != 1037) {
            i3 = i;
        } else if (i2 > 0) {
            i3 = i2;
        } else {
            i3 = i;
        }
        i3 = (i3 == 1000 || i3 == 1018 || i3 == 1017 || i3 == 1033) ? 0 : i3 == 1019 ? 1 : i3 == 1010 ? 5 : (i3 == 1007 || i3 == 1008) ? 6 : i3 == 1009 ? 7 : (i3 == 1035 || i3 == 1020) ? 8 : (i3 == 1011 || i3 == 1047 || i3 == 1025) ? 12 : (i3 == 1012 || i3 == 1032 || i3 == 1048 || i3 == 1050) ? 13 : (i3 == 1005 || i3 == 1027 || i3 == 1042 || i3 == 1006) ? 15 : (i3 == 1024 || i3 == 1021) ? 16 : (i3 == 1029 || i3 == 1028) ? 23 : (i3 == 1013 || i3 == 1031 || i3 == 1049) ? 24 : (i3 == 1001 || i3 == 1003) ? 25 : (i3 == 1045 || i3 == 1046) ? 26 : i3 == 1022 ? 27 : i3 == 1023 ? 28 : i3 == 1026 ? 29 : i3 == 1039 ? 30 : (i3 == 1034 || i3 == 1060) ? 31 : (i3 == 1014 || i3 == 1043 || i3 == 1044 || i3 == 1036) ? 32 : 0;
        x.i("MicroMsg.WalletJsapiData", "parsePayChannelByScene, scene: %s, rawScene: %s, resultChannel: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        return i3;
    }
}
