package com.tencent.smtt.sdk;

import android.graphics.Picture;
import android.webkit.WebView;
import android.webkit.WebView.PictureListener;

class WebView$5 implements PictureListener {
    final /* synthetic */ WebView this$0;
    final /* synthetic */ WebView.PictureListener val$listner;

    WebView$5(WebView webView, WebView.PictureListener pictureListener) {
        this.this$0 = webView;
        this.val$listner = pictureListener;
    }

    public void onNewPicture(WebView webView, Picture picture) {
        this.val$listner.onNewPicture(this.this$0, picture);
    }
}
