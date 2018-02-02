package com.tencent.mm.app.plugin;

import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.ui.LauncherUI;

@a
class URISpanHandlerSet$FlowStatUriSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet fhe;

    URISpanHandlerSet$FlowStatUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.fhe = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final k cH(String str) {
        if (str.trim().startsWith("weixin://flowstat")) {
            return new k(str, 16, null);
        }
        return null;
    }

    final int[] uC() {
        return new int[]{16};
    }

    final boolean a(k kVar, f fVar) {
        if (kVar.type != 16) {
            return false;
        }
        if (fVar != null) {
            fVar.a(kVar);
        }
        LauncherUI cmG = LauncherUI.cmG();
        if (cmG != null) {
            cmG.xGS.xGh.Yp("tab_settings");
        }
        if (fVar != null) {
            fVar.b(kVar);
        }
        return true;
    }

    final boolean a(String str, boolean z, t tVar, Bundle bundle) {
        if (!str.equals("weixin://flowstat")) {
            return false;
        }
        LauncherUI cmG = LauncherUI.cmG();
        if (cmG != null) {
            cmG.xGS.xGh.Yp("tab_settings");
        }
        return true;
    }
}
