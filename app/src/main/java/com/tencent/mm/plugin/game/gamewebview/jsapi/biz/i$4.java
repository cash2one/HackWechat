package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashMap;
import java.util.Map;

class i$4 implements a {
    final /* synthetic */ i mWH;

    i$4(i iVar) {
        this.mWH = iVar;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == (this.mWH.hashCode() & 65535)) {
            switch (i2) {
                case -1:
                    if (intent == null) {
                        x.e("MicroMsg.GameJsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA bundle is null,");
                        this.mWH.mWG.E(this.mWH.jcs, d.e("chooseMedia:fail", null));
                        return;
                    }
                    int intExtra = intent.getIntExtra("key_pick_local_media_callback_type", 0);
                    String stringExtra;
                    Map hashMap;
                    if (intExtra == 1) {
                        stringExtra = intent.getStringExtra("key_pick_local_media_local_id");
                        String stringExtra2 = intent.getStringExtra("key_pick_local_media_thumb_local_id");
                        x.i("MicroMsg.GameJsApiChooseMedia", "video localId:%s", new Object[]{stringExtra});
                        x.i("MicroMsg.GameJsApiChooseMedia", "video thumbLocalId:%s", new Object[]{stringExtra2});
                        if (bh.ov(stringExtra)) {
                            x.e("MicroMsg.GameJsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA video localId is null");
                            this.mWH.mWG.E(this.mWH.jcs, d.e("chooseMedia:fail", null));
                            return;
                        }
                        WebViewJSSDKFileItem BB = d.BB(stringExtra);
                        if (BB == null || !(BB instanceof WebViewJSSDKVideoItem)) {
                            x.e("MicroMsg.GameJsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA nor the videoitem");
                            break;
                        }
                        WebViewJSSDKVideoItem webViewJSSDKVideoItem = (WebViewJSSDKVideoItem) BB;
                        x.i("MicroMsg.GameJsApiChooseMedia", "after parse to json data : %s", new Object[]{ai.b(stringExtra, stringExtra2, webViewJSSDKVideoItem.duration, webViewJSSDKVideoItem.height, webViewJSSDKVideoItem.width, webViewJSSDKVideoItem.size)});
                        hashMap = new HashMap();
                        hashMap.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(1));
                        hashMap.put("localIds", stringExtra);
                        this.mWH.mWG.E(this.mWH.jcs, d.e("chooseMedia:ok", hashMap));
                        return;
                    } else if (intExtra == 2) {
                        stringExtra = intent.getStringExtra("key_pick_local_media_local_ids");
                        x.i("MicroMsg.GameJsApiChooseMedia", "chooseMedia localIds:%s", new Object[]{stringExtra});
                        if (bh.ov(stringExtra)) {
                            x.e("MicroMsg.GameJsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA image localIds is null");
                            this.mWH.mWG.E(this.mWH.jcs, d.e("chooseMedia:fail", null));
                            return;
                        }
                        hashMap = new HashMap();
                        hashMap.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(2));
                        hashMap.put("localIds", stringExtra);
                        this.mWH.mWG.E(this.mWH.jcs, d.e("chooseMedia:ok", hashMap));
                        return;
                    } else {
                        x.e("MicroMsg.GameJsApiChooseMedia", "type:%d is error", new Object[]{Integer.valueOf(intExtra)});
                        this.mWH.mWG.E(this.mWH.jcs, d.e("chooseMedia:fail", null));
                        return;
                    }
                    break;
                case 0:
                    this.mWH.mWG.E(this.mWH.jcs, d.e("chooseMedia:cancel", null));
                    return;
            }
            this.mWH.mWG.E(this.mWH.jcs, d.e("chooseMedia:fail", null));
        }
    }
}
