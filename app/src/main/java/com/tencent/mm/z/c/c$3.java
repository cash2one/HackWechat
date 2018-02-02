package com.tencent.mm.z.c;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import java.util.Map;

class c$3 implements a {
    final /* synthetic */ c hiE;

    c$3(c cVar) {
        this.hiE = cVar;
    }

    public final void a(String str, l lVar) {
        if (str != null && str.length() > 0 && "event_updated".equals(str)) {
            c fn = c.IF().fn("100205");
            if (fn.isValid()) {
                Map chI = fn.chI();
                int i = bh.getInt((String) chI.get("main_thread_watch_enable"), 65535);
                int i2 = bh.getInt((String) chI.get("main_thread_watch_timeout"), 5000);
                int i3 = bh.getInt((String) chI.get("main_thread_watch_log_loop"), 0);
                ac.getContext().getSharedPreferences("system_config_prefs", 4).edit().putInt("main_thread_watch_enable", i).putInt("main_thread_watch_timeout", i2).putInt("main_thread_watch_log_loop", i3).putInt("main_thread_watch_report", bh.getInt((String) chI.get("main_thread_watch_report"), 0)).commit();
                x.i("MicroMsg.SubCoreNewABTest", "summeranr MM_MAIN_THREAD_WATCH enable[%d] timeout[%d], loop[%d] report[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(r0)});
            }
            c.IH();
        }
    }
}
