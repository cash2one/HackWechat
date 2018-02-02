package com.tencent.mm.plugin.wallet.bind.ui;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.HashMap;
import java.util.Map;

@a(3)
public class WalletUnbindBankCardProxyUI extends WalletBaseUI {
    private String sDb;
    private Bankcard sDc;
    private Map<String, String> sDd;

    public void onCreate(Bundle bundle) {
        Bankcard bankcard = null;
        super.onCreate(bundle);
        Intent intent = getIntent();
        setResult(0);
        if (intent != null) {
            this.sDb = intent.getStringExtra("packageExt");
            if (bh.ov(this.sDb)) {
                x.e("MicorMsg.WalletUnbindBankCardProxyUI", "jsapi param error");
                setResult(1);
                finish();
                return;
            }
            Map hashMap;
            String str = this.sDb;
            if (!bh.ov(str)) {
                String[] split = str.split("&");
                hashMap = new HashMap();
                if (split != null && split.length > 0) {
                    for (String str2 : split) {
                        String str22;
                        if (!bh.ov(str22)) {
                            int indexOf = str22.indexOf("=");
                            String substring = str22.substring(0, indexOf);
                            str22 = str22.substring(indexOf + 1, str22.length());
                            if (!(bh.ov(substring) || bh.ov(str22))) {
                                hashMap.put(substring, str22);
                            }
                        }
                    }
                    this.sDd = hashMap;
                    if (this.sDd.containsKey("bank_type") || !this.sDd.containsKey("bind_serial")) {
                        x.e("MicorMsg.WalletUnbindBankCardProxyUI", "jsapi param:package error.package==" + this.sDb);
                        setResult(1);
                        finish();
                        return;
                    }
                    Cursor a = o.bLo().gJP.a("select * from WalletBankcard where bindSerial = '" + ((String) this.sDd.get("bind_serial")) + "'", null, 2);
                    if (a.moveToNext()) {
                        bankcard = new Bankcard();
                        bankcard.b(a);
                    }
                    a.close();
                    this.sDc = bankcard;
                    if (this.sDc == null) {
                        x.e("MicorMsg.WalletUnbindBankCardProxyUI", "can not found bankcard");
                        setResult(0);
                        finish();
                        return;
                    }
                    intent.putExtra("key_is_show_detail", false);
                    intent.putExtra("key_bankcard", this.sDc);
                    intent.putExtra("scene", 1);
                    com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet.bind.a.class, intent.getExtras(), new 1(this));
                    return;
                }
            }
            hashMap = null;
            this.sDd = hashMap;
            if (this.sDd.containsKey("bank_type")) {
            }
            x.e("MicorMsg.WalletUnbindBankCardProxyUI", "jsapi param:package error.package==" + this.sDb);
            setResult(1);
            finish();
            return;
        }
        x.e("MicorMsg.WalletUnbindBankCardProxyUI", "intent is null");
        finish();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected void onNewIntent(Intent intent) {
        finish();
    }
}
