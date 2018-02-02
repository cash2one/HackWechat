package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.os.Bundle;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet.pwd.c;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;

@a(7)
public class WalletResetPwdAdapterUI extends WalletBaseUI {
    protected String gAb = null;
    protected boolean pLL = false;
    protected com.tencent.mm.plugin.wallet.a pLM = null;
    protected String sHu = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        uD(8);
        this.sHu = getIntent().getStringExtra("reset_pwd_token");
        x.i("MicroMsg.WalletResetPwdAdapterUI", "token_by_resetPwd %s", new Object[]{this.sHu});
        ji(580);
        if (getIntent() == null) {
            x.d("MicroMsg.WalletResetPwdAdapterUI", "func[doCheckPayNetscene] intent null");
            setResult(0);
            finish();
            return;
        }
        k aVar = new com.tencent.mm.plugin.wallet_core.c.a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL), 13, "setWCPayPassword", getIntent().getIntExtra("pay_channel", 0));
        aVar.gOs = "RemittanceProcess";
        r(aVar);
    }

    protected void onNewIntent(Intent intent) {
        x.v("MicroMsg.WalletResetPwdAdapterUI", "onNewIntent");
        int intExtra = intent.getIntExtra("RESET_PWD_USER_ACTION", 0);
        if (intExtra == 1) {
            setResult(-1);
            finish();
        } else if (intExtra == 2) {
            setResult(DownloadResult.CODE_UNDEFINED);
            finish();
        } else {
            setResult(0);
            finish();
        }
    }

    public void onDestroy() {
        jj(580);
        super.onDestroy();
    }

    public void onBackPressed() {
        if (this.pLL) {
            x.d("MicroMsg.WalletResetPwdAdapterUI", "back press but lock");
            return;
        }
        x.d("MicroMsg.WalletResetPwdAdapterUI", "back press not lock");
        finish();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            setResult(DownloadResult.CODE_UNDEFINED);
            h.bu(this, str);
            finish();
            return true;
        } else if (!(kVar instanceof com.tencent.mm.plugin.wallet_core.c.a)) {
            return false;
        } else {
            f.Ta(((com.tencent.mm.plugin.wallet_core.c.a) kVar).bKH());
            Bundle bundle = new Bundle();
            bundle.putString("kreq_token", this.sHu);
            com.tencent.mm.wallet_core.a.a(this, c.class, bundle, null);
            return true;
        }
    }

    protected final int getLayoutId() {
        return -1;
    }
}
