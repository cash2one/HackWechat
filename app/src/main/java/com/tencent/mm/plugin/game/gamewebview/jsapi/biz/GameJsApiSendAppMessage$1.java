package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h;
import org.json.JSONObject;

class GameJsApiSendAppMessage$1 implements a {
    final /* synthetic */ int gOK;
    final /* synthetic */ JSONObject jel;
    final /* synthetic */ d mWr;
    final /* synthetic */ GameJsApiSendAppMessage mXe;

    GameJsApiSendAppMessage$1(GameJsApiSendAppMessage gameJsApiSendAppMessage, JSONObject jSONObject, d dVar, int i) {
        this.mXe = gameJsApiSendAppMessage;
        this.jel = jSONObject;
        this.mWr = dVar;
        this.gOK = i;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == 1) {
            String str;
            String optString = this.jel.optString("appid");
            if (this.mXe.mWa == null || !bh.ov(optString)) {
                str = optString;
            } else {
                str = this.mXe.mWa.getString("jsapi_args_appid");
            }
            switch (i2) {
                case -1:
                    if (intent == null) {
                        optString = null;
                    } else {
                        optString = intent.getStringExtra("Select_Conv_User");
                    }
                    d dVar;
                    int i3;
                    GameJsApiSendAppMessage gameJsApiSendAppMessage;
                    if (optString == null || optString.length() == 0) {
                        x.e("MicroMsg.GameJsApiSendAppMessage", "mmOnActivityResult fail, toUser is null");
                        dVar = this.mWr;
                        i3 = this.gOK;
                        gameJsApiSendAppMessage = this.mXe;
                        dVar.E(i3, com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("send_app_msg:fail", null));
                        return;
                    }
                    GameJsApiSendAppMessage$SendAppMessageTask gameJsApiSendAppMessage$SendAppMessageTask = new GameJsApiSendAppMessage$SendAppMessageTask(this.mWr.aPh());
                    gameJsApiSendAppMessage$SendAppMessageTask.scene = GameJsApiSendAppMessage.fMx;
                    gameJsApiSendAppMessage$SendAppMessageTask.appId = str;
                    gameJsApiSendAppMessage$SendAppMessageTask.toUser = optString;
                    gameJsApiSendAppMessage$SendAppMessageTask.thumbUrl = (String) this.jel.opt("img_url");
                    gameJsApiSendAppMessage$SendAppMessageTask.fGz = (String) this.jel.opt("src_username");
                    gameJsApiSendAppMessage$SendAppMessageTask.mXf = (String) this.jel.opt("src_displayname");
                    gameJsApiSendAppMessage$SendAppMessageTask.jqV = intent.getStringExtra("custom_send_text");
                    gameJsApiSendAppMessage$SendAppMessageTask.title = this.jel.optString("title");
                    gameJsApiSendAppMessage$SendAppMessageTask.description = this.jel.optString("desc");
                    gameJsApiSendAppMessage$SendAppMessageTask.mXg = this.mWr.BP(this.jel.optString("link"));
                    gameJsApiSendAppMessage$SendAppMessageTask.fIG = bh.ou(this.mWr.mXZ);
                    gameJsApiSendAppMessage$SendAppMessageTask.jIW = this.mWr.aPk();
                    gameJsApiSendAppMessage$SendAppMessageTask.verifyAppId = this.mWr.aPl();
                    gameJsApiSendAppMessage$SendAppMessageTask.extInfo = this.jel.optString("review_data");
                    gameJsApiSendAppMessage$SendAppMessageTask.aKE();
                    h.bu(this.mWr.aPh(), this.mWr.getResources().getString(R.l.dGG));
                    dVar = this.mWr;
                    i3 = this.gOK;
                    gameJsApiSendAppMessage = this.mXe;
                    dVar.E(i3, com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("send_app_msg:ok", null));
                    return;
                default:
                    return;
            }
        }
    }
}
