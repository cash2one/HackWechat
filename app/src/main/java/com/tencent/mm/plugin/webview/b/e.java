package com.tencent.mm.plugin.webview.b;

import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends i<d> {
    public static final String[] gJN = new String[]{i.a(d.gJc, "WebViewHistory")};

    static /* synthetic */ void a(e eVar) {
        int count = eVar.getCount() - 500;
        if (count > 0) {
            x.i("MicroMsg.WebViewHistoryStorage", "deleteItem: " + eVar.fx("WebViewHistory", "delete from WebViewHistory order by timeStamp limit " + count));
        }
    }

    public e(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, d.gJc, "WebViewHistory", null);
    }

    public final boolean iF(String str) {
        boolean fx = fx("WebViewHistory", "delete from WebViewHistory where recordId='" + str + "'");
        x.i("MicroMsg.WebViewHistoryStorage", "delete: " + fx);
        return fx;
    }
}
