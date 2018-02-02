package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.menu.MenuDelegate_SendToDesktop.SendShortcutToDesktopTask;
import com.tencent.mm.plugin.report.service.g;

class MenuDelegate_SendToDesktop$SendShortcutToDesktopTask$1 implements Runnable {
    final /* synthetic */ SendShortcutToDesktopTask jAC;
    final /* synthetic */ Context val$context;

    MenuDelegate_SendToDesktop$SendShortcutToDesktopTask$1(SendShortcutToDesktopTask sendShortcutToDesktopTask, Context context) {
        this.jAC = sendShortcutToDesktopTask;
        this.val$context = context;
    }

    public final void run() {
        if (SendShortcutToDesktopTask.a(this.jAC, k.d(this.val$context, SendShortcutToDesktopTask.a(this.jAC), SendShortcutToDesktopTask.b(this.jAC)))) {
            g.pQN.a(443, 1, 1, false);
        }
        SendShortcutToDesktopTask.c(this.jAC);
    }
}
