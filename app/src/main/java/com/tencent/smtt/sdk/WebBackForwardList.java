package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.interfaces.IX5WebBackForwardList;

public class WebBackForwardList {
    private IX5WebBackForwardList zZe = null;
    private android.webkit.WebBackForwardList zZf = null;

    static WebBackForwardList a(android.webkit.WebBackForwardList webBackForwardList) {
        if (webBackForwardList == null) {
            return null;
        }
        WebBackForwardList webBackForwardList2 = new WebBackForwardList();
        webBackForwardList2.zZf = webBackForwardList;
        return webBackForwardList2;
    }

    static WebBackForwardList a(IX5WebBackForwardList iX5WebBackForwardList) {
        if (iX5WebBackForwardList == null) {
            return null;
        }
        WebBackForwardList webBackForwardList = new WebBackForwardList();
        webBackForwardList.zZe = iX5WebBackForwardList;
        return webBackForwardList;
    }

    public int getCurrentIndex() {
        return this.zZe != null ? this.zZe.getCurrentIndex() : this.zZf.getCurrentIndex();
    }

    public WebHistoryItem getCurrentItem() {
        return this.zZe != null ? WebHistoryItem.a(this.zZe.getCurrentItem()) : WebHistoryItem.a(this.zZf.getCurrentItem());
    }

    public WebHistoryItem getItemAtIndex(int i) {
        return this.zZe != null ? WebHistoryItem.a(this.zZe.getItemAtIndex(i)) : WebHistoryItem.a(this.zZf.getItemAtIndex(i));
    }

    public int getSize() {
        return this.zZe != null ? this.zZe.getSize() : this.zZf.getSize();
    }
}
