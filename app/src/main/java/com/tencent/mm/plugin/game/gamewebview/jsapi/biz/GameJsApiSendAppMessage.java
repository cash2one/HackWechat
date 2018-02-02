package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Intent;
import android.os.Bundle;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.model.h;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;

public final class GameJsApiSendAppMessage extends a {
    public static final int CTRL_BYTE = 6;
    public static final String NAME = "sendAppMessage";
    public static int fMx;

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiSendAppMessage", "invoke");
        if (jSONObject == null) {
            x.e("MicroMsg.GameJsApiSendAppMessage", "sendAppMessage fail, appmsg is null");
            dVar.E(i, a.e("send_app_msg:fail_null_params", null));
        } else if (bh.ov(jSONObject.optString("link"))) {
            x.e("MicroMsg.GameJsApiSendAppMessage", "link is null");
            dVar.E(i, a.e("send_app_msg:fail_invalid_params", null));
        } else {
            switch (fMx) {
                case 1:
                    SendAppMessageTask sendAppMessageTask = new SendAppMessageTask(dVar.aPh());
                    sendAppMessageTask.scene = fMx;
                    sendAppMessageTask.appId = jSONObject.optString("appid");
                    sendAppMessageTask.thumbUrl = jSONObject.optString("img_url");
                    sendAppMessageTask.fGz = jSONObject.optString("src_username");
                    sendAppMessageTask.mXf = jSONObject.optString("src_displayname");
                    sendAppMessageTask.title = jSONObject.optString("title");
                    sendAppMessageTask.description = jSONObject.optString("desc");
                    sendAppMessageTask.mXg = dVar.BP(jSONObject.optString("link"));
                    sendAppMessageTask.fIG = bh.ou(dVar.mXZ);
                    sendAppMessageTask.jIW = dVar.aPk();
                    sendAppMessageTask.verifyAppId = dVar.aPl();
                    sendAppMessageTask.extInfo = jSONObject.optString("review_data");
                    Bundle bundle = new Bundle();
                    bundle.putString("KPublisherId", bh.ou(dVar.vf.getString("KPublisherId")));
                    int ak = com.tencent.mm.plugin.game.gamewebview.a.d.ak(dVar.scene, dVar.vf.getString("geta8key_username"));
                    bundle.putString("preChatName", dVar.vf.getString("preChatName"));
                    bundle.putInt("preMsgIndex", dVar.vf.getInt("preMsgIndex", 0));
                    bundle.putString("prePublishId", dVar.vf.getString("prePublishId"));
                    bundle.putString("preUsername", dVar.vf.getString("preUsername"));
                    bundle.putInt("getA8KeyScene", ak);
                    bundle.putString("referUrl", dVar.mZd);
                    sendAppMessageTask.mXi = bundle;
                    sendAppMessageTask.aKE();
                    dVar.E(i, "send_app_msg:ok");
                    break;
                default:
                    h.a(dVar, jSONObject);
                    Serializable hashMap = new HashMap();
                    hashMap.put("img_url", jSONObject.optString("img_url"));
                    hashMap.put("desc", jSONObject.optString("desc"));
                    hashMap.put("title", jSONObject.optString("title"));
                    hashMap.put(SlookSmartClipMetaTag.TAG_TYPE_URL, jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL));
                    Intent intent = new Intent();
                    intent.putExtra("Select_Conv_Type", 3);
                    intent.putExtra("scene_from", 2);
                    intent.putExtra("mutil_select_is_ret", true);
                    intent.putExtra("webview_params", hashMap);
                    intent.putExtra("Retr_Msg_Type", 2);
                    com.tencent.mm.bm.d.a(dVar.aPh(), ".ui.transmit.SelectConversationUI", intent, 1, new 1(this, jSONObject, dVar, i));
                    break;
            }
            fMx = 0;
        }
    }
}
