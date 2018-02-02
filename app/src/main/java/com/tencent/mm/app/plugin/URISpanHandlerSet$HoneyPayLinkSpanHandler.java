package com.tencent.mm.app.plugin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.sdk.platformtools.x;

@a
class URISpanHandlerSet$HoneyPayLinkSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet fhe;

    URISpanHandlerSet$HoneyPayLinkSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.fhe = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final k cH(String str) {
        if (str.trim().startsWith("native://wcpay/honeypay")) {
            return new k(str, 46, null);
        }
        return str.trim().startsWith("weixin://wcpay/bankCardList") ? new k(str, 47, null) : null;
    }

    final int[] uC() {
        return new int[]{46, 47};
    }

    final boolean a(k kVar, f fVar) {
        if (kVar.type == 46) {
            x.i("MicroMsg.URISpanHandlerSet", "go to honey pay proxy");
            if (kVar.data != null && (kVar.data instanceof Bundle)) {
                Uri parse = Uri.parse(kVar.url);
                String queryParameter = parse.getQueryParameter("cardNo");
                boolean equals = parse.getQueryParameter("isPayer").equals("1");
                Intent intent = new Intent();
                intent.putExtra("key_card_no", queryParameter);
                intent.putExtra("key_is_payer", equals);
                d.b(URISpanHandlerSet.a(this.fhe), "honey_pay", ".ui.HoneyPayProxyUI", intent);
            }
        } else if (kVar.type == 47) {
            x.i("MicroMsg.URISpanHandlerSet", "go to bank card list");
            Intent intent2 = new Intent();
            intent2.putExtra("intent_finish_self", true);
            d.b(URISpanHandlerSet.a(this.fhe), "wallet", ".bind.ui.WalletBankcardManageUI", intent2);
            g.pQN.h(15191, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
        }
        return false;
    }

    final boolean a(String str, boolean z, t tVar, Bundle bundle) {
        return false;
    }
}
