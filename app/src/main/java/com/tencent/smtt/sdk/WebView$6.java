package com.tencent.smtt.sdk;

import android.graphics.Picture;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener;

class WebView$6 implements PictureListener {
    final /* synthetic */ WebView this$0;
    final /* synthetic */ WebView.PictureListener val$listner;

    WebView$6(WebView webView, WebView.PictureListener pictureListener) {
        this.this$0 = webView;
        this.val$listner = pictureListener;
    }

    public void onNewPicture(IX5WebViewBase iX5WebViewBase, Picture picture, boolean z) {
        this.this$0.zZl = iX5WebViewBase;
        this.val$listner.onNewPicture(this.this$0, picture);
    }

    public void onNewPictureIfHaveContent(IX5WebViewBase iX5WebViewBase, Picture picture) {
    }
}
