package com.tencent.mm.plugin.wallet.ui;

import android.content.Intent;
import android.os.Bundle;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;

@a(7)
public class WalletJsApiAdapterUI extends WalletBaseUI {
    protected boolean pLL = false;
    protected String packageName = "";
    protected String sId = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        uD(8);
        this.packageName = getIntent().getStringExtra("intent_jump_package");
        this.sId = getIntent().getStringExtra("intent_jump_ui");
        ji(580);
        if (getIntent() == null) {
            x.d("MicroMsg.WalletJsApiAdapterUI", "func[doCheckPayNetscene] intent null");
            setResult(0);
            finish();
            return;
        }
        k aVar = new com.tencent.mm.plugin.wallet_core.c.a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL), 3, "openWCPayCardList", getIntent().getIntExtra("pay_channel", 0));
        aVar.gOs = "RemittanceProcess";
        r(aVar);
    }

    protected void onNewIntent(Intent intent) {
        x.v("MicroMsg.WalletJsApiAdapterUI", "onNewIntent");
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
            x.d("MicroMsg.WalletJsApiAdapterUI", "back press but lock");
            return;
        }
        x.d("MicroMsg.WalletJsApiAdapterUI", "back press not lock");
        finish();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            setResult(-1);
            finish();
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.WalletJsApiAdapterUI", "onSceneEnd errType %s errCode %s errMsg %s scene %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, kVar});
        if (i != 0 || i2 != 0) {
            setResult(DownloadResult.CODE_UNDEFINED);
            h.bu(this, str);
            finish();
            return true;
        } else if (!(kVar instanceof com.tencent.mm.plugin.wallet_core.c.a)) {
            return false;
        } else {
            f.Ta(((com.tencent.mm.plugin.wallet_core.c.a) kVar).bKH());
            Intent intent = new Intent();
            intent.putExtra("intent_finish_self", true);
            d.b(this, this.packageName, this.sId, intent, 1);
            return true;
        }
    }

    protected final int getLayoutId() {
        return -1;
    }
}
