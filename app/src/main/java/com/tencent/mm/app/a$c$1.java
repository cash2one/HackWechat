package com.tencent.mm.app;

import android.content.SharedPreferences;
import com.tencent.mm.app.a.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

class a$c$1 implements Runnable {
    final /* synthetic */ c feH;

    a$c$1(c cVar) {
        this.feH = cVar;
    }

    public final void run() {
        this.feH.feF = (this.feH.feF + 1) % Integer.MAX_VALUE;
        if (this.feH.feF % a.ts() == 0) {
            SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("system_config_prefs", 4);
            int i = sharedPreferences.getInt("main_thread_watch_enable", 65535);
            int i2 = sharedPreferences.getInt("main_thread_watch_timeout", 0);
            int i3 = sharedPreferences.getInt("main_thread_watch_log_loop", 0);
            int i4 = sharedPreferences.getInt("main_thread_watch_report", 0);
            x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ticker tname[%s], tick[%d] enable[%d], timeout[%d], loop[%d], report[%d]", new Object[]{Thread.currentThread().getName(), Integer.valueOf(this.feH.feF), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            if (a.q(a.el(), i)) {
                if (i2 > 0 && i2 != a.tt()) {
                    x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr reset timeout[%d, %d] by new setting", new Object[]{Integer.valueOf(a.tt()), Integer.valueOf(i2)});
                    a.ek(i2);
                }
                if (i3 > 0 && i3 != a.ts()) {
                    x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr reset loop[%d, %d] by new setting", new Object[]{Integer.valueOf(a.ts()), Integer.valueOf(i3)});
                    a.el(i3);
                    return;
                }
                return;
            }
            g.pQN.a(510, 12, 1, true);
            if (a.tu() != null) {
                a.tu().interrupt();
            }
            x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr disable by new setting and interrupt watch");
        }
    }
}
