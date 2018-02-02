package org.xwalk.core;

class WebViewExtension$1 extends WebViewExtensionInterface {
    WebViewExtension$1() {
    }

    public final Object onMiscCallBack(String str, Object... objArr) {
        if (WebViewExtension.access$000() != null) {
            return WebViewExtension.access$000().onMiscCallBack(str, objArr);
        }
        return null;
    }
}
