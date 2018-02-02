package com.tencent.mm.plugin.qqmail.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;

class EmbedWebView$1 extends SimpleOnGestureListener {
    final /* synthetic */ EmbedWebView psi;

    EmbedWebView$1(EmbedWebView embedWebView) {
        this.psi = embedWebView;
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        WebView webView = this.psi;
        x.d("MicroMsg.EmbedWebView", "onDoubleTapm, before scale:" + webView.getScale());
        int i = 10;
        while (webView.getScale() != 1.0f) {
            i--;
            if (i <= 0) {
                break;
            } else if (webView.getScale() > 1.0f) {
                webView.zoomOut();
            } else {
                webView.zoomIn();
            }
        }
        x.d("MicroMsg.EmbedWebView", "onDoubleTapm, after scale:" + this.psi.getScale());
        return true;
    }
}
