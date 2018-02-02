package com.tencent.mm.plugin.wallet_index.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_index.c.a.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

public class WalletBrandUI$a implements WalletBrandUI$b {
    final /* synthetic */ WalletBrandUI tbb;
    private int tbc = 0;

    public WalletBrandUI$a(WalletBrandUI walletBrandUI) {
        this.tbb = walletBrandUI;
    }

    public final int bNo() {
        return 1563;
    }

    public final k bNp() {
        WalletBrandUI.a(this.tbb, this.tbb.getIntent().getStringExtra("appId"));
        String stringExtra = this.tbb.getIntent().getStringExtra("signtype");
        String stringExtra2 = this.tbb.getIntent().getStringExtra("nonceStr");
        String stringExtra3 = this.tbb.getIntent().getStringExtra("timeStamp");
        String stringExtra4 = this.tbb.getIntent().getStringExtra("packageExt");
        String stringExtra5 = this.tbb.getIntent().getStringExtra("paySignature");
        String stringExtra6 = this.tbb.getIntent().getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL);
        this.tbc = this.tbb.getIntent().getIntExtra("result_jump_mode", 0);
        WalletBrandUI.b(this.tbb, this.tbb.getIntent().getStringExtra("bizUsername"));
        k aVar = new a(WalletBrandUI.c(this.tbb), stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra, stringExtra6, WalletBrandUI.d(this.tbb), this.tbb.getIntent().getIntExtra("pay_channel", 0));
        g.Dk();
        g.Di().gPJ.a(aVar, 0);
        return aVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0 && (kVar instanceof a)) {
            String str2 = ((a) kVar).jumpUrl;
            x.i("MicroMsg.WalletBrandUI", "hy: gen prepay success! url is: %s", str2);
            String str3 = ((a) kVar).tay;
            Intent intent;
            if (this.tbc == 1) {
                intent = new Intent();
                intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, str2);
                intent.putExtra("jsInjectCode", str3);
                this.tbb.setResult(-1, intent);
            } else {
                intent = new Intent();
                intent.putExtra("rawUrl", str2);
                intent.putExtra("showShare", false);
                if (!bh.ov(str3)) {
                    intent.putExtra("shouldForceViewPort", true);
                    intent.putExtra("view_port_code", str3);
                }
                d.b(this.tbb, "webview", ".ui.tools.WebViewUI", intent);
                this.tbb.setResult(-1);
            }
            this.tbb.finish();
            return;
        }
        x.i("MicroMsg.WalletBrandUI", "hy: gen prepay failed! errType: %d, errCode: %d, errmsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        h.a(this.tbb, str, "", new 1(this), new OnClickListener(this) {
            final /* synthetic */ WalletBrandUI$a tbd;

            {
                this.tbd = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.tbd.tbb.setResult(0);
                this.tbd.tbb.finish();
            }
        });
    }
}
