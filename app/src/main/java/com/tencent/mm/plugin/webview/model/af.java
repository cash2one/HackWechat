package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class af extends i<ae> {
    public static final String[] gJN = new String[]{i.a(ae.gJc, "WebviewLocalData")};

    public af(e eVar) {
        super(eVar, ae.gJc, "WebviewLocalData", null);
    }

    public static int ab(String str, String str2, String str3) {
        return (str + str2 + str3).hashCode();
    }
}
