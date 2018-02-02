package com.tencent.mm.app.plugin;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d.f;

@a
class URISpanHandlerSet$LuckyMoneyUriSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet fhe;

    URISpanHandlerSet$LuckyMoneyUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.fhe = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final k cH(String str) {
        if (str.trim().toLowerCase().startsWith("weixin://weixinhongbao/")) {
            return new k(str, 33, null);
        }
        return null;
    }

    final int[] uC() {
        return new int[]{33};
    }

    final boolean a(k kVar, f fVar) {
        if (kVar.type != 33) {
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("key_native_url", kVar.url);
        d.b(URISpanHandlerSet.a(this.fhe), "luckymoney", ".ui.LuckyMoneyDetailUI", intent);
        g.pQN.h(12097, new Object[]{Integer.valueOf(11), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis())});
        g.pQN.h(11850, new Object[]{Integer.valueOf(4), Integer.valueOf(1)});
        return true;
    }

    final boolean a(String str, boolean z, t tVar, Bundle bundle) {
        return false;
    }
}
