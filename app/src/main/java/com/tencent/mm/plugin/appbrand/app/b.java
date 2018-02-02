package com.tencent.mm.plugin.appbrand.app;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.a;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public final class b {
    private static volatile boolean iCT = false;

    static void YY() {
        ag.y(new 1());
        MMToClientEvent.a(new a() {
            public final void aY(Object obj) {
                if (obj instanceof AppBrandLaunchErrorAction) {
                    AppBrandLaunchErrorAction appBrandLaunchErrorAction = (AppBrandLaunchErrorAction) obj;
                    e oQ = com.tencent.mm.plugin.appbrand.a.oQ(appBrandLaunchErrorAction.appId);
                    if (oQ != null && appBrandLaunchErrorAction.iKd == oQ.iqw.iGA) {
                        Context context;
                        e Yu = oQ.Yu();
                        oQ.finish();
                        if (Yu == null) {
                            context = ac.getContext();
                        } else {
                            n nVar = Yu.iqC;
                            if (nVar != null) {
                                MMActivity mMActivity = (MMActivity) nVar.getContext();
                                if (!mMActivity.isFinishing()) {
                                    if (mMActivity.xIq) {
                                        return;
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        appBrandLaunchErrorAction.ca(context);
                    }
                }
            }
        });
    }

    public static void YZ() {
        x.i("MicroMsg.AppBrandProcessProfileInit[applaunch]", "setSkipMiscPreload %b", new Object[]{Boolean.valueOf(true)});
        iCT = true;
    }
}
