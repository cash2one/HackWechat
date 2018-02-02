package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

class j$1 implements a {
    final /* synthetic */ int gOK;
    final /* synthetic */ d mWr;

    j$1(d dVar, int i) {
        this.mWr = dVar;
        this.gOK = i;
    }

    public final void b(int i, int i2, Intent intent) {
        String stringExtra;
        WebViewJSSDKFileItem BB;
        WebViewJSSDKVideoItem webViewJSSDKVideoItem;
        if (i == 45) {
            switch (i2) {
                case -1:
                    stringExtra = intent.getStringExtra("key_pick_local_media_local_id");
                    String stringExtra2 = intent.getStringExtra("key_pick_local_media_thumb_local_id");
                    x.i("MicroMsg.GameJsApiChooseVideo", "localId:%s", new Object[]{stringExtra});
                    x.i("MicroMsg.GameJsApiChooseVideo", "thumbLocalId:%s", new Object[]{stringExtra2});
                    if (bh.ov(stringExtra)) {
                        this.mWr.E(this.gOK, com.tencent.mm.plugin.game.gamewebview.a.d.e("recordVideo:fail", null));
                        return;
                    }
                    BB = com.tencent.mm.plugin.game.gamewebview.a.d.BB(stringExtra);
                    if (BB == null || !(BB instanceof WebViewJSSDKVideoItem)) {
                        this.mWr.E(this.gOK, com.tencent.mm.plugin.game.gamewebview.a.d.e("recordVideo:fail", null));
                        return;
                    }
                    webViewJSSDKVideoItem = (WebViewJSSDKVideoItem) BB;
                    Map hashMap = new HashMap();
                    hashMap.put("localId", stringExtra);
                    hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(webViewJSSDKVideoItem.duration));
                    hashMap.put("height", Integer.valueOf(webViewJSSDKVideoItem.height));
                    hashMap.put("size", Integer.valueOf(webViewJSSDKVideoItem.size));
                    hashMap.put("width", Integer.valueOf(webViewJSSDKVideoItem.width));
                    hashMap.put("thumbLocalId", stringExtra2);
                    this.mWr.E(this.gOK, com.tencent.mm.plugin.game.gamewebview.a.d.e("recordVideo:ok", hashMap));
                    return;
                case 0:
                    this.mWr.E(this.gOK, com.tencent.mm.plugin.game.gamewebview.a.d.e("recordVideo:cancel", null));
                    return;
                default:
                    this.mWr.E(this.gOK, com.tencent.mm.plugin.game.gamewebview.a.d.e("recordVideo:fail", null));
                    return;
            }
        } else if (i == 32) {
            switch (i2) {
                case -1:
                    stringExtra = intent.getStringExtra("key_pick_local_media_local_id");
                    if (!bh.ov(stringExtra)) {
                        BB = com.tencent.mm.plugin.game.gamewebview.a.d.BB(stringExtra);
                        if (BB == null || !(BB instanceof WebViewJSSDKVideoItem)) {
                            this.mWr.E(this.gOK, com.tencent.mm.plugin.game.gamewebview.a.d.e("chooseVideo:fail", null));
                            return;
                        }
                        webViewJSSDKVideoItem = (WebViewJSSDKVideoItem) BB;
                        Map hashMap2 = new HashMap();
                        hashMap2.put("localId", stringExtra);
                        hashMap2.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(webViewJSSDKVideoItem.duration));
                        hashMap2.put("height", Integer.valueOf(webViewJSSDKVideoItem.height));
                        hashMap2.put("size", Integer.valueOf(webViewJSSDKVideoItem.size));
                        hashMap2.put("width", Integer.valueOf(webViewJSSDKVideoItem.width));
                        this.mWr.E(this.gOK, com.tencent.mm.plugin.game.gamewebview.a.d.e("chooseVideo:ok", hashMap2));
                        return;
                    }
                    break;
                case 0:
                    this.mWr.E(this.gOK, com.tencent.mm.plugin.game.gamewebview.a.d.e("chooseVideo:cancel", null));
                    return;
            }
            this.mWr.E(this.gOK, com.tencent.mm.plugin.game.gamewebview.a.d.e("chooseVideo:fail", null));
        }
    }
}
