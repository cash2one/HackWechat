package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.content.Intent;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.g.a.pu;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.model.h;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.s;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import org.json.JSONObject;

public final class ay extends a {
    public static final int CTRL_BYTE = 4;
    public static final String NAME = "shareTimeline";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiSendAppMessage", "invoke");
        Context aPh = dVar.aPh();
        if (jSONObject == null) {
            x.e("MicroMsg.GameJsApiSendAppMessage", "sendAppMessage fail, appmsg is null");
            dVar.E(i, a.e("share_timeline:fail_null_params", null));
            return;
        }
        String optString = jSONObject.optString("link");
        if (bh.ov(optString)) {
            x.e("MicroMsg.GameJsApiSendAppMessage", "link is null");
            dVar.E(i, a.e("share_timeline:fail_invalid_params", null));
            return;
        }
        int i2;
        h.a(dVar, jSONObject);
        String optString2 = jSONObject.optString("desc");
        if (optString2 != null) {
            if (optString2.startsWith("http://")) {
                optString2.substring(7);
            } else if (optString2.startsWith("https://")) {
                optString2.substring(8);
            }
        }
        int i3 = 1;
        String str = "";
        int i4 = 0;
        if (this.mWa != null) {
            this.mWa.setClassLoader(getClass().getClassLoader());
            i3 = this.mWa.getInt("snsWebSource", 1);
            str = this.mWa.getString("jsapi_args_appid");
            i4 = bh.getInt(this.mWa.getString("urlAttribute"), 0);
            this.mWa.remove("urlAttribute");
        }
        int i5 = i3;
        if (bh.ov(str)) {
            str = jSONObject.optString("appid");
        }
        String optString3 = jSONObject.optString("img_width");
        String optString4 = jSONObject.optString("img_height");
        x.i("MicroMsg.GameJsApiSendAppMessage", "doTimeline, rawUrl:[%s], shareUrl:[%s]", new Object[]{optString, dVar.BP(optString)});
        String optString5 = jSONObject.optString(DownloadSettingTable$Columns.TYPE);
        String optString6 = jSONObject.optString("title");
        String optString7 = jSONObject.optString("img_url");
        String optString8 = jSONObject.optString("src_username");
        String optString9 = jSONObject.optString("src_displayname");
        i3 = -1;
        try {
            i3 = Integer.valueOf(optString3).intValue();
            Integer.valueOf(optString4);
            i2 = i3;
        } catch (Exception e) {
            i2 = i3;
        }
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_width", i2);
        intent.putExtra("Ksnsupload_height", i2);
        intent.putExtra("Ksnsupload_link", r11);
        intent.putExtra("Ksnsupload_title", optString6);
        intent.putExtra("Ksnsupload_imgurl", optString7);
        intent.putExtra("Ksnsupload_contentattribute", i4);
        if (s.gF(optString8)) {
            intent.putExtra("src_username", optString8);
            intent.putExtra("src_displayname", optString9);
        }
        intent.putExtra("Ksnsupload_source", i5);
        intent.putExtra("Ksnsupload_type", 1);
        if (!bh.ov(optString5) && optString5.equals("music")) {
            intent.putExtra("ksnsis_music", true);
        }
        if (!bh.ov(optString5) && optString5.equals(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
            intent.putExtra("ksnsis_video", true);
        }
        if (str != null && str.length() > 0) {
            intent.putExtra("Ksnsupload_appid", str);
        }
        str = "MicroMsg.GameJsApiSendAppMessage";
        String str2 = "doTimeline, init intent, jsapiArgs == null ? %b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.mWa == null);
        x.i(str, str2, objArr);
        if (this.mWa != null) {
            optString2 = this.mWa.getString("K_sns_thumb_url");
            str = this.mWa.getString("K_sns_raw_url");
            str2 = bh.az(this.mWa.getString("KSnsStrId"), "");
            optString3 = bh.az(this.mWa.getString("KSnsLocalId"), "");
            intent.putExtra("key_snsad_statextstr", this.mWa.getString("key_snsad_statextstr"));
            x.i("MicroMsg.GameJsApiSendAppMessage", "currentUrl %s contentUrl %s thumbUrl %s", new Object[]{optString, str, optString2});
            if (!(str == null || optString == null || !str.equals(optString))) {
                intent.putExtra("KlinkThumb_url", optString2);
            }
            intent.putExtra("KSnsStrId", str2);
            intent.putExtra("KSnsLocalId", optString3);
            if (str2 != null && this.mWa.getBoolean("KFromTimeline", false)) {
                b puVar = new pu();
                puVar.fHx.fzW = str2;
                puVar.fHx.frH = optString3;
                com.tencent.mm.sdk.b.a.xef.m(puVar);
            }
        }
        intent.putExtra("ShareUrlOriginal", bh.ou(dVar.mXZ));
        intent.putExtra("ShareUrlOpen", dVar.aPk());
        intent.putExtra("JsAppId", dVar.aPl());
        intent.putExtra("need_result", true);
        x.i("MicroMsg.GameJsApiSendAppMessage", "doTimeline, start activity");
        aPh.jwN = new 1(this, dVar, i);
        com.tencent.mm.bm.d.a(aPh, "sns", ".ui.SnsUploadUI", intent, 2, false);
    }
}
