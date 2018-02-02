package com.tencent.mm.plugin.wallet_ecard.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.wallet_ecard.a.b.a;
import com.tencent.mm.protocal.c.axk;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class b$1 implements OnClickListener {
    final /* synthetic */ axk sZs;
    final /* synthetic */ WalletBaseUI sZt;
    final /* synthetic */ a sZu = null;

    b$1(axk com_tencent_mm_protocal_c_axk, WalletBaseUI walletBaseUI, a aVar) {
        this.sZs = com_tencent_mm_protocal_c_axk;
        this.sZt = walletBaseUI;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (!bh.ov(this.sZs.vZl)) {
            Context context = this.sZt;
            String str = this.sZs.vZl;
            a aVar = this.sZu;
            x.i("MicroMsg.ECardUtil", "url: %s", new Object[]{str});
            if (!bh.ov(str)) {
                if (str.startsWith("native.")) {
                    x.i("MicroMsg.ECardUtil", "goto native");
                    if (aVar != null) {
                    }
                    if (!str.equals("native.qryacctdesc")) {
                        if (!str.equals("native.openecardauth")) {
                            if (!str.equals("native.cancloseecard")) {
                            }
                        }
                    }
                } else {
                    x.d("MicroMsg.ECardUtil", "url: %s", new Object[]{str});
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("showShare", false);
                    d.b(context, "webview", ".ui.tools.WebViewUI", intent);
                }
            }
        }
        dialogInterface.dismiss();
    }
}
