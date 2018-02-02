package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.12;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

class WebViewUI$12$30 implements Runnable {
    final /* synthetic */ Bundle fhp;
    final /* synthetic */ 12 tAx;
    final /* synthetic */ int tvF;

    WebViewUI$12$30(12 12, int i, Bundle bundle) {
        this.tAx = 12;
        this.tvF = i;
        this.fhp = bundle;
    }

    public final void run() {
        if (this.tAx.tAv.ptK != null) {
            x.i("MicroMsg.WebViewUI", "setMenuItemsVisible, actionCode = " + this.tvF);
            Set<Object> hashSet = new HashSet();
            if (this.tvF == 3003 || this.tvF == TXLiveConstants.PUSH_WARNING_SERVER_DISCONNECT) {
                hashSet.add("menuItem:share:brand");
                hashSet.add("menuItem:share:appMessage");
                hashSet.add("menuItem:share:dataMessage");
                hashSet.add("menuItem:share:timeline");
                hashSet.add("menuItem:favorite");
                hashSet.add("menuItem:profile");
                hashSet.add("menuItem:addContact");
                hashSet.add("menuItem:copyUrl");
                hashSet.add("menuItem:openWithSafari");
                hashSet.add("menuItem:share:email");
                hashSet.add("menuItem:delete");
                hashSet.add("menuItem:editTag");
                hashSet.add("menuItem:readMode");
                hashSet.add("menuItem:originPage");
                hashSet.add("menuItem:share:qq");
                hashSet.add("menuItem:share:weiboApp");
                hashSet.add("menuItem:share:QZone");
                hashSet.add("menuItem:share:Facebook");
                hashSet.add("menuItem:share:enterprise");
                hashSet.add("menuItem:share:wework");
                hashSet.add("menuItem:share:weread");
                hashSet.add("menuItem:addShortcut");
            } else if (this.fhp == null) {
                x.w("MicroMsg.WebViewUI", "setMenuItemsVisible data is null.");
                return;
            } else {
                Collection stringArrayList = this.fhp.getStringArrayList("menu_item_list");
                if (stringArrayList == null || stringArrayList.size() == 0) {
                    x.w("MicroMsg.WebViewUI", "setMenuItemsVisible menuItems is null or nil.");
                    return;
                }
                hashSet.addAll(stringArrayList);
                hashSet.remove("menuItem:exposeArticle");
                hashSet.remove("menuItem:setFont");
                hashSet.remove("menuItem:keepTop");
                hashSet.remove("menuItem:cancelKeepTop");
                hashSet.remove("menuItem:profile");
                hashSet.remove("menuItem:addContact");
                hashSet.remove("menuItem:refresh");
            }
            String url = this.tAx.tAv.ptK.getUrl();
            SparseBooleanArray sparseBooleanArray = (SparseBooleanArray) WebViewUI.f(this.tAx.tAv).get(url);
            switch (this.tvF) {
                case 3001:
                case 3003:
                    SparseBooleanArray sparseBooleanArray2;
                    if (sparseBooleanArray == null) {
                        sparseBooleanArray = new SparseBooleanArray();
                        WebViewUI.f(this.tAx.tAv).put(url, sparseBooleanArray);
                        sparseBooleanArray2 = sparseBooleanArray;
                    } else {
                        sparseBooleanArray2 = sparseBooleanArray;
                    }
                    for (Object obj : hashSet) {
                        int a = bh.a((Integer) WebViewUI.g(this.tAx.tAv).get(obj), -1);
                        if (a >= 0) {
                            sparseBooleanArray2.put(a, true);
                        }
                    }
                    return;
                case 3002:
                case TXLiveConstants.PUSH_WARNING_SERVER_DISCONNECT /*3004*/:
                    if (sparseBooleanArray != null) {
                        for (Object obj2 : hashSet) {
                            int a2 = bh.a((Integer) WebViewUI.g(this.tAx.tAv).get(obj2), -1);
                            if (a2 >= 0) {
                                sparseBooleanArray.delete(a2);
                            }
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
