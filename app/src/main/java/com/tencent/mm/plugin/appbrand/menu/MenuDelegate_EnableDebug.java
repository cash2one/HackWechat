package com.tencent.mm.plugin.appbrand.menu;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.ui.base.n;

public final class MenuDelegate_EnableDebug extends a {
    public MenuDelegate_EnableDebug() {
        super(m.jAJ - 1);
    }

    public final void a(Context context, p pVar, n nVar, String str) {
        if (h.qH(str)) {
            CharSequence string;
            if (pVar.irP.iqx.iOi) {
                string = context.getString(j.iyT);
            } else {
                string = context.getString(j.iyU);
            }
            nVar.f(m.jAJ - 1, string);
        }
    }

    public final void a(Context context, p pVar, String str, l lVar) {
        e(context, str, !pVar.irP.iqx.iOi);
    }

    public static void e(final Context context, String str, boolean z) {
        String string;
        MainProcessTask setAppDebugModeTask = new SetAppDebugModeTask((byte) 0);
        setAppDebugModeTask.appId = str;
        setAppDebugModeTask.fqP = z;
        AppBrandMainProcessService.a(setAppDebugModeTask);
        if (setAppDebugModeTask.fqP) {
            string = context.getString(j.iyN);
        } else {
            string = context.getString(j.iyM);
        }
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(new Runnable() {
                public final void run() {
                    Toast.makeText(context, string, 0).show();
                    ((Activity) context).finish();
                }
            });
        }
    }
}
