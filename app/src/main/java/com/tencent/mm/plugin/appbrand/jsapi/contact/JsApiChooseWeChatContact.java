package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ax;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiChooseWeChatContact extends a {
    public static final int CTRL_INDEX = 195;
    public static final String NAME = "chooseWeChatContact";

    public final void a(final j jVar, JSONObject jSONObject, final int i) {
        MMActivity a = a(jVar);
        if (a == null) {
            x.e("MicroMsg.JsApiChooseWeChatContact", "ChooseWeChatContact context is null, appId is %s", new Object[]{jVar.mAppId});
            jVar.E(i, e("fail", null));
            return;
        }
        x.i("MicroMsg.JsApiChooseWeChatContact", "ChooseWeChatContact appId:%s", new Object[]{jVar.mAppId});
        Intent intent = new Intent();
        String string = a.getString(q.j.iBV);
        int i2 = 259;
        int[] iArr = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075};
        x.i("MicroMsg.JsApiChooseWeChatContact", "ChooseWeChatContact data %s:", new Object[]{jSONObject});
        if (!(jSONObject == null || jSONObject.optJSONArray("contactMode") == null || jSONObject.optJSONArray("contactMode").length() <= 0)) {
            String jSONArray = jSONObject.optJSONArray("contactMode").toString();
            if (jSONArray.contains("singleContact") && !jSONArray.contains("chatroom")) {
                i2 = 263;
                string = a.getString(q.j.iBU);
                iArr = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
            } else if (jSONArray.contains("chatroom") && !jSONArray.contains("singleContact")) {
                i2 = ax.CTRL_BYTE;
                iArr = new int[]{131075};
            }
        }
        intent.putExtra("Select_Conv_Type", i2);
        intent.putExtra("jsapi_select_mode", 1);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("scene_from", 9);
        intent.putExtra("Select_Conv_ui_title", string);
        intent.putExtra("search_range", iArr);
        MainProcessTask getUserDataTask = new GetUserDataTask("");
        AppBrandMainProcessService.b(getUserDataTask);
        intent.putExtra("Select_block_List", getUserDataTask.jiJ);
        d.a(a, ".ui.transmit.SelectConversationUI", intent, 100, new MMActivity.a(this) {
            final /* synthetic */ JsApiChooseWeChatContact jiI;

            public final void b(int i, int i2, Intent intent) {
                if (100 != i) {
                    x.e("MicroMsg.JsApiChooseWeChatContact", "selectSingleContact requestCode not equal, requestCode = %d", new Object[]{Integer.valueOf(i)});
                    jVar.E(i, this.jiI.e("fail", null));
                } else if (i2 == 0 || i2 == 1) {
                    x.e("MicroMsg.JsApiChooseWeChatContact", "selectSingleContact user cancel, resultCode = %d", new Object[]{Integer.valueOf(i)});
                    jVar.E(i, this.jiI.e("cancel", null));
                } else if (i2 == -1) {
                    String str;
                    if (intent == null) {
                        str = null;
                    } else {
                        str = intent.getStringExtra("Select_Conv_User");
                    }
                    if (str == null || str.length() == 0) {
                        x.e("MicroMsg.JsApiChooseWeChatContact", "mmOnActivityResult, selectSingleContact fail, user is null");
                        jVar.E(i, this.jiI.e("fail", null));
                        return;
                    }
                    MainProcessTask getUserDataTask = new GetUserDataTask(str);
                    AppBrandMainProcessService.b(getUserDataTask);
                    String str2 = getUserDataTask.bgo;
                    String str3 = getUserDataTask.bgp;
                    String str4 = getUserDataTask.jiK;
                    Map hashMap = new HashMap();
                    hashMap.put("avatarUrl", str4);
                    hashMap.put("userName", str);
                    hashMap.put("nickName", str2);
                    hashMap.put("remarkName", str3);
                    x.i("MicroMsg.JsApiChooseWeChatContact", "selectSingleContact: nickName:%s, remarkName:%s", new Object[]{str2, str3});
                    jVar.E(i, this.jiI.e("ok", hashMap));
                }
            }
        });
    }
}
