package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.g.a.fc;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;

class g$67 implements Runnable {
    final /* synthetic */ WebViewJSSDKFileItem tIY;
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;

    g$67(g gVar, WebViewJSSDKFileItem webViewJSSDKFileItem, i iVar) {
        this.tIj = gVar;
        this.tIY = webViewJSSDKFileItem;
        this.tIg = iVar;
    }

    public final void run() {
        b fcVar = new fc();
        fcVar.fua.op = 1;
        fcVar.fua.filePath = this.tIY.iLu;
        fcVar.fua.duration = bh.getInt((String) this.tIg.pox.get(FFmpegMetadataRetriever.METADATA_KEY_DURATION), 60);
        fcVar.fua.fhP = new 1(this, fcVar);
        a.xef.m(fcVar);
    }
}
