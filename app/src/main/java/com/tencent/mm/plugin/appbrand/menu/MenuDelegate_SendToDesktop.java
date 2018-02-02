package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n;

public final class MenuDelegate_SendToDesktop extends a {
    public MenuDelegate_SendToDesktop() {
        super(m.jAP - 1);
    }

    public final void a(Context context, p pVar, n nVar, String str) {
        if (pVar.irP.iqH.scene != 1023) {
            nVar.f(this.jAX, context.getString(j.iBm));
        }
    }

    public final void a(Context context, p pVar, String str, l lVar) {
        AppBrandSysConfig appBrandSysConfig = pVar.irP.iqx;
        Object obj = appBrandSysConfig.fnl;
        if (context == null || TextUtils.isEmpty(obj)) {
            x.i("MicroMsg.MenuDelegate_SendToDesktop", "performItemClick failed, context or username is null or nil.");
            return;
        }
        AppBrandMainProcessService.a(new SendShortcutToDesktopTask(context, obj, str, appBrandSysConfig.iOI.iGK));
        com.tencent.mm.plugin.appbrand.report.a.a(str, pVar.getURL(), 14, "", bh.Wo(), 1, 0);
    }
}
