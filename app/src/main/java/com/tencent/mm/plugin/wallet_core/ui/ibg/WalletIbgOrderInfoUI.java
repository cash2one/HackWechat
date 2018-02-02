package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.c.a.c;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(3)
public class WalletIbgOrderInfoUI extends WalletBaseUI {
    public static Orders sEs;
    private String mAppId = null;
    private String mTimeStamp = null;
    private String sDb = null;
    private String sXa = null;
    private String sXb = null;
    private String sXc = null;
    private String sXd = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ji(1565);
        this.mAppId = getIntent().getStringExtra("appId");
        this.sXa = getIntent().getStringExtra("nonceStr");
        this.mTimeStamp = getIntent().getStringExtra("timeStamp");
        this.sDb = getIntent().getStringExtra("packageExt");
        this.sXb = getIntent().getStringExtra("paySignature");
        this.sXc = getIntent().getStringExtra("signtype");
        this.sXd = getIntent().getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL);
        r(new c(this.mAppId, this.sXa, this.mTimeStamp, this.sDb, this.sXb, this.sXc, this.sXd));
    }

    protected final int getLayoutId() {
        return g.uEl;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.WalletIbgOrderInfoUI", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", Integer.valueOf(i), Integer.valueOf(i2), str, kVar);
        if (kVar instanceof c) {
            jj(1565);
            if (i == 0 && i2 == 0) {
                c cVar = (c) kVar;
                sEs = cVar.sIO;
                Parcelable parcelable = sEs;
                x.i("MicroMsg.WalletIbgOrderInfoUI", "gotoIbgOrderInfoUI, useNewPage: %s, orders: %s", Integer.valueOf(cVar.sJa), parcelable);
                Intent intent;
                if (cVar.sJa == 1) {
                    intent = new Intent(this, WalletIbgOrderInfoNewUI.class);
                    intent.putExtra("key_orders", parcelable);
                    startActivity(intent);
                } else {
                    intent = new Intent(this, WalletIbgOrderInfoOldUI.class);
                    intent.putExtra("key_orders", parcelable);
                    startActivity(intent);
                }
                setResult(-1);
                finish();
                return true;
            }
            setResult(0);
            finish();
        }
        setResult(0);
        finish();
        return false;
    }

    public void onDestroy() {
        super.onDestroy();
        jj(1565);
    }
}
