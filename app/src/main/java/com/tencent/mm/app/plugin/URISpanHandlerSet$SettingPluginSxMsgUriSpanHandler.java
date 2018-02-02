package com.tencent.mm.app.plugin;

import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d.f;

@a
class URISpanHandlerSet$SettingPluginSxMsgUriSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet fhe;

    URISpanHandlerSet$SettingPluginSxMsgUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.fhe = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final k cH(String str) {
        if (str.trim().startsWith("weixin://setting/plugin/sxmsg")) {
            return new k(str, 11, null);
        }
        return null;
    }

    final int[] uC() {
        return new int[]{11};
    }

    final boolean a(k kVar, f fVar) {
        return false;
    }

    final boolean a(String str, boolean z, t tVar, Bundle bundle) {
        return false;
    }
}
