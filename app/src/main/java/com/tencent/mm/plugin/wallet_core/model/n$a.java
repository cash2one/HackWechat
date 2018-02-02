package com.tencent.mm.plugin.wallet_core.model;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import org.json.JSONObject;

public class n$a {
    public String name;
    public String peY;
    public String sNx;
    public String sNy;
    public String title;
    public int type;
    public String url;

    public final void X(JSONObject jSONObject) {
        this.url = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        this.name = jSONObject.optString("wording");
        this.peY = jSONObject.optString("icon");
        this.sNx = jSONObject.optString("btn_text");
        this.type = jSONObject.optInt(DownloadSettingTable$Columns.TYPE);
        this.title = jSONObject.optString("title");
        this.sNy = jSONObject.optString("small_title");
    }
}
