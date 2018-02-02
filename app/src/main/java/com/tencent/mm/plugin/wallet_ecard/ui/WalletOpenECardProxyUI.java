package com.tencent.mm.plugin.wallet_ecard.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c;

@a(3)
public class WalletOpenECardProxyUI extends WalletECardBaseUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        uD(4);
        c cCc = cCc();
        if (cCc != null) {
            int i = this.vf.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.sYX, 0);
            String string = this.vf.getString(com.tencent.mm.plugin.wallet_ecard.a.a.sYY);
            boolean z = this.vf.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.sZa, false);
            x.i("MicroMsg.WalletOpenECardProxyUI", "onCreate, openScene: %s, token==null:%s, isTokenInvalid: %s", new Object[]{Integer.valueOf(i), Boolean.valueOf(bh.ov(string)), Boolean.valueOf(z)});
            if (bh.ov(string)) {
                cCc.a(this.mController.xIM, 0, this.vf);
                return;
            }
            cCd().k(Integer.valueOf(i), string);
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.WalletOpenECardProxyUI", "activity result, request:%s, result: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            setResult(0);
            c cCc = cCc();
            if (cCc != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("key_process_result_code", 0);
                cCc.l(this, bundle);
                return;
            }
            finish();
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        x.i("MicroMsg.WalletOpenECardProxyUI", "new intent, resultCode: %d, isEnd: %s", new Object[]{Integer.valueOf(intent.getIntExtra("key_process_result_code", -1)), Boolean.valueOf(intent.getBooleanExtra("key_process_is_end", false))});
        if (intent.getIntExtra("key_process_result_code", -1) == -1) {
            setResult(-1);
        } else {
            setResult(0);
        }
        c cCc = cCc();
        if (r1) {
            finish();
        } else if (cCc != null) {
            cCc.ah(this.mController.xIM);
        }
    }
}
