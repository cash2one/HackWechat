package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.storage.c;

class b$a implements l {
    private b$a() {
    }

    public final Bundle j(Bundle bundle) {
        int i;
        c fn = com.tencent.mm.z.c.c.IF().fn("100266");
        if (fn.isValid()) {
            i = t.getInt((String) fn.chI().get("search_wa_widget_init_out_time"), 8000);
        } else {
            i = 8000;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("search_wa_widget_init_out_time", i);
        return bundle2;
    }
}
