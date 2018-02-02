package com.tencent.mm.app.plugin;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.base.h;

@a
class URISpanHandlerSet$TransferUriSpanHandler extends URISpanHandlerSet$BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet fhe;

    URISpanHandlerSet$TransferUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.fhe = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final k cH(String str) {
        if (str.trim().toLowerCase().startsWith("weixin://wcpay/transfer/retrysendmsg")) {
            return new k(str, 39, null);
        }
        if (str.trim().toLowerCase().startsWith("weixin://wcpay/transfer/rebacksendmsg")) {
            return new k(str, 40, null);
        }
        if (str.trim().toLowerCase().startsWith("weixin://wcpay/transfer/watchbalance")) {
            return new k(str, 41, null);
        }
        return str.trim().toLowerCase().startsWith("weixin://wcpay/transfer/watchlqt") ? new k(str, 42, null) : null;
    }

    final int[] uC() {
        return new int[]{39, 40, 41, 42};
    }

    final boolean a(k kVar, f fVar) {
        if (kVar != null) {
            if (kVar.type == 42) {
                d.y(URISpanHandlerSet.a(this.fhe), "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                return true;
            } else if (kVar.type == 41) {
                d.y(URISpanHandlerSet.a(this.fhe), "wallet", ".balance.ui.WalletBalanceManagerUI");
                return true;
            } else if (kVar.type == 39) {
                if (kVar.data != null && (kVar.data instanceof Bundle)) {
                    h.a(URISpanHandlerSet.a(this.fhe), URISpanHandlerSet.a(this.fhe).getString(R.l.eQg), URISpanHandlerSet.a(this.fhe).getString(R.l.dGt), URISpanHandlerSet.a(this.fhe).getString(R.l.eQh), URISpanHandlerSet.a(this.fhe).getString(R.l.dEn), new 1(this, (Bundle) kVar.data), new 2(this));
                }
                return true;
            } else if (kVar.type == 40) {
                if (kVar.data != null && (kVar.data instanceof Bundle)) {
                    Bundle bundle = (Bundle) kVar.data;
                    b nbVar = new nb();
                    nbVar.fEY.fuI = bundle.getString("transaction_id");
                    nbVar.fEY.fEs = bundle.getString("transfer_id");
                    nbVar.fEY.fEZ = bundle.getInt("total_fee");
                    nbVar.fEY.fFa = bundle.getString("sender_name");
                    com.tencent.mm.sdk.b.a.xef.m(nbVar);
                }
                return true;
            }
        }
        return false;
    }

    final boolean a(String str, boolean z, t tVar, Bundle bundle) {
        return false;
    }
}
