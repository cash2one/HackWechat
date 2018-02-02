package com.tencent.mm.plugin.wallet_core.ui;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import org.json.JSONObject;

class WalletOrderInfoOldUI$b {
    public String fDI;
    public String fyY;
    final /* synthetic */ WalletOrderInfoOldUI sUK;
    public String sUr;
    public String title;
    public String url;

    public WalletOrderInfoOldUI$b(WalletOrderInfoOldUI walletOrderInfoOldUI, JSONObject jSONObject) {
        this.sUK = walletOrderInfoOldUI;
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("activity_change_info");
            if (optJSONObject != null) {
                this.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                this.fyY = optJSONObject.optString("wording");
                this.fDI = optJSONObject.optString("icon");
                this.sUr = optJSONObject.optString("btn_text");
                this.title = optJSONObject.optString("title");
            }
        }
    }

    public final String toString() {
        return this.url + " , " + this.fyY + " , " + this.fDI + " , " + this.sUr + " , " + this.title;
    }
}
