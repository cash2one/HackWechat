package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.a.b;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class WalletIbgAdapterUI extends WalletBaseUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        uD(4);
        this.zIY.ji(1564);
        r(new b());
    }

    public void onResume() {
        super.onResume();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0 && (kVar instanceof b)) {
            int i3 = ((b) kVar).sIZ;
            String str2 = ((b) kVar).jumpUrl;
            x.i("MicroMsg.WalletH5AdapterUI", "hy: get success! url is: %s, download x5 = %b", new Object[]{str2, Integer.valueOf(i3)});
            if (i3 == 1) {
                boolean z;
                x.i("MicroMsg.WalletH5AdapterUI", "now status = %d", new Object[]{Integer.valueOf(com.tencent.mm.pluginsdk.model.x.a.bYy())});
                switch (com.tencent.mm.pluginsdk.model.x.a.bYy()) {
                    case 1:
                    case 4:
                        z = true;
                        break;
                    case 2:
                    case 3:
                        g.Dk();
                        if (((Boolean) g.Dj().CU().get(w.a.xrh, Boolean.valueOf(false))).booleanValue()) {
                            Toast.makeText(this, getString(i.uYo), 1).show();
                            com.tencent.mm.pluginsdk.model.x.a.eg(this);
                            finish();
                        } else {
                            bMY();
                        }
                        z = false;
                        break;
                    default:
                        bMY();
                        z = false;
                        break;
                }
                if (z) {
                    Nu(str2);
                    finish();
                }
            } else {
                Nu(str2);
                finish();
            }
        } else {
            com.tencent.mm.wallet_core.a.c(this, null, 0);
        }
        return false;
    }

    public void onDestroy() {
        this.zIY.jj(1564);
        super.onDestroy();
    }

    private void Nu(String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        d.b(this, "webview", ".ui.tools.WebViewUI", intent);
    }

    private void bMY() {
        g.Dk();
        g.Dj().CU().a(w.a.xrh, Boolean.valueOf(true));
        h.a(this, false, getString(i.uYp), "", getString(i.uYm), getString(i.uYl), new 1(this), new 2(this));
    }

    protected final int getLayoutId() {
        return -1;
    }
}
