package com.tencent.mm.plugin.appbrand.jsapi.live;

import java.util.ArrayList;
import java.util.List;

class a$1 implements Runnable {
    final /* synthetic */ a$a jkL;
    final /* synthetic */ String val$url;

    a$1(String str, a$a com_tencent_mm_plugin_appbrand_jsapi_live_a_a) {
        this.val$url = str;
        this.jkL = com_tencent_mm_plugin_appbrand_jsapi_live_a_a;
    }

    public final void run() {
        if (!a.agr().containsKey(this.val$url)) {
            a.agr().put(this.val$url, new ArrayList());
        }
        ((List) a.agr().get(this.val$url)).add(this.jkL);
    }
}
