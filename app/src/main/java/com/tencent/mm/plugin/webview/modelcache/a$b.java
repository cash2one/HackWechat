package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.plugin.webview.modelcache.a.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

final class a$b extends i<a> {
    public final boolean iYd;

    static /* synthetic */ void a(a$b com_tencent_mm_plugin_webview_modelcache_a_b, String str, long j) {
        if (com_tencent_mm_plugin_webview_modelcache_a_b.iYd) {
            c aVar = new a((byte) 0);
            aVar.field_appId = str;
            if (com_tencent_mm_plugin_webview_modelcache_a_b.b(aVar, new String[0])) {
                aVar.field_occupation += j;
                com_tencent_mm_plugin_webview_modelcache_a_b.c(aVar, new String[0]);
                return;
            }
            aVar.field_occupation = j;
            com_tencent_mm_plugin_webview_modelcache_a_b.b(aVar);
        }
    }

    public a$b(e eVar) {
        super(eVar, a.bRk(), "WebViewCacheAppIdOccupation", null);
        this.iYd = eVar != null;
    }
}
