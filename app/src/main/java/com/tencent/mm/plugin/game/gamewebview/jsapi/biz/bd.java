package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.network.ab;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.UploadMediaFileHelp.1;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.UploadMediaFileHelp.2;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.UploadMediaFileHelp.b;
import com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewUI;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import org.json.JSONObject;

public final class bd extends a {
    public static final int CTRL_BYTE = 237;
    public static final String NAME = "uploadMediaFile";
    private GameWebViewUI mWF;
    UploadMediaFileHelp mXm = new UploadMediaFileHelp();

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiUploadMediaFile", "invoke");
        if (jSONObject == null) {
            dVar.E(i, a.e("chooseVideo:fail_invalid_data", null));
            return;
        }
        boolean z;
        this.mWF = dVar.aPh();
        String optString = jSONObject.optString("appId");
        String optString2 = jSONObject.optString("localId");
        if (jSONObject.optInt("isShowProgressTips", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.GameJsApiUploadMediaFile", "uploadMediaFile, appid = %s, localid = %s, isShowProgressTips = %b", new Object[]{optString, optString2, Boolean.valueOf(z)});
        if (bh.ov(optString) || bh.ov(optString2)) {
            x.e("MicroMsg.GameJsApiUploadMediaFile", "appId or localid is null or nil.");
            dVar.E(i, a.e("uploadMediaFile:fail_missing arguments", null));
            return;
        }
        UploadMediaFileHelp uploadMediaFileHelp = this.mXm;
        MMActivity mMActivity = this.mWF;
        b 1 = new 1(this, dVar, i);
        uploadMediaFileHelp.iqt = mMActivity;
        uploadMediaFileHelp.mWG = dVar;
        uploadMediaFileHelp.mAppId = optString;
        uploadMediaFileHelp.mXp = optString2;
        uploadMediaFileHelp.mXq = z;
        uploadMediaFileHelp.mXr = 1;
        UploadMediaFileHelp uploadMediaFileHelp2 = this.mXm;
        WebViewJSSDKFileItem BB = com.tencent.mm.plugin.game.gamewebview.a.d.BB(uploadMediaFileHelp2.mXp);
        if (BB == null) {
            x.e("MicroMsg.UploadMediaFileHelp", "item is null");
            uploadMediaFileHelp2.mXr.a(false, null);
        } else if (BB.ftE == 1) {
            uploadMediaFileHelp2.aOP();
        } else if (bh.ov(BB.iLu) || !e.bO(BB.iLu)) {
            x.e("MicroMsg.UploadMediaFileHelp", "origFilePath is not exist");
            uploadMediaFileHelp2.mXr.a(false, null);
        } else if (ab.bC(uploadMediaFileHelp2.iqt)) {
            uploadMediaFileHelp2.aOO();
        } else {
            optString = bh.fK((long) e.bN(BB.iLu));
            h.a(uploadMediaFileHelp2.iqt, uploadMediaFileHelp2.iqt.getString(R.l.eWV, new Object[]{optString}), uploadMediaFileHelp2.iqt.getString(R.l.dGO), false, new 1(uploadMediaFileHelp2), new 2(uploadMediaFileHelp2));
        }
    }
}
