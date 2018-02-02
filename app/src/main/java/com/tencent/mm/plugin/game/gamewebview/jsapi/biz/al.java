package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class al extends a {
    public static final int CTRL_BYTE = 252;
    public static final String NAME = "previewVideo";

    public final void a(final d dVar, JSONObject jSONObject, final int i) {
        x.i("MicroMsg.GameJsApiPreviewVideo", "invoke");
        if (jSONObject == null || bh.ov(jSONObject.optString("localId"))) {
            x.i("MicroMsg.GameJsApiPreviewVideo", "data is invalid");
            dVar.E(i, a.e("previewVideo:fail_invalid_data", null));
            return;
        }
        WebViewJSSDKFileItem BB = com.tencent.mm.plugin.game.gamewebview.a.d.BB(jSONObject.optString("localId"));
        if (BB == null || TextUtils.isEmpty(BB.iLu) || !e.bO(BB.iLu)) {
            x.e("MicroMsg.GameJsApiPreviewVideo", "the item is null or the File item not exist for localId: %s", new Object[]{r0});
            dVar.E(i, a.e("previewVideo:fail", null));
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("key_video_path", BB.iLu);
        Context aPh = dVar.aPh();
        aPh.jwN = new MMActivity.a(this) {
            final /* synthetic */ al mXc;

            public final void b(int i, int i2, Intent intent) {
                if (i == (this.mXc.hashCode() & 65535)) {
                    d dVar;
                    int i3;
                    al alVar;
                    switch (i2) {
                        case -1:
                            dVar = dVar;
                            i3 = i;
                            alVar = this.mXc;
                            dVar.E(i3, a.e("previewVideo:ok", null));
                            return;
                        case 0:
                            dVar = dVar;
                            i3 = i;
                            alVar = this.mXc;
                            dVar.E(i3, a.e("previewVideo:cancel", null));
                            return;
                        default:
                            dVar = dVar;
                            i3 = i;
                            alVar = this.mXc;
                            dVar.E(i3, a.e("previewVideo:fail", null));
                            return;
                    }
                }
            }
        };
        com.tencent.mm.bm.d.b(aPh, "card", ".ui.CardGiftVideoUI", intent, hashCode() & 65535);
    }
}
