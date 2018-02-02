package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import com.tencent.smtt.export.external.interfaces.IX5WebHistoryItem;

public class WebHistoryItem {
    private IX5WebHistoryItem zZg = null;
    private android.webkit.WebHistoryItem zZh = null;

    private WebHistoryItem() {
    }

    static WebHistoryItem a(android.webkit.WebHistoryItem webHistoryItem) {
        if (webHistoryItem == null) {
            return null;
        }
        WebHistoryItem webHistoryItem2 = new WebHistoryItem();
        webHistoryItem2.zZh = webHistoryItem;
        return webHistoryItem2;
    }

    static WebHistoryItem a(IX5WebHistoryItem iX5WebHistoryItem) {
        if (iX5WebHistoryItem == null) {
            return null;
        }
        WebHistoryItem webHistoryItem = new WebHistoryItem();
        webHistoryItem.zZg = iX5WebHistoryItem;
        return webHistoryItem;
    }

    public Bitmap getFavicon() {
        return this.zZg != null ? this.zZg.getFavicon() : this.zZh.getFavicon();
    }

    public String getOriginalUrl() {
        return this.zZg != null ? this.zZg.getOriginalUrl() : this.zZh.getOriginalUrl();
    }

    public String getTitle() {
        return this.zZg != null ? this.zZg.getTitle() : this.zZh.getTitle();
    }

    public String getUrl() {
        return this.zZg != null ? this.zZg.getUrl() : this.zZh.getUrl();
    }
}
