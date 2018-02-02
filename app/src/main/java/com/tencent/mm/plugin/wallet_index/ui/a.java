package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.plugin.wallet_index.b.a.b;
import com.tencent.mm.plugin.wallet_index.b.a.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.p;
import java.util.ArrayList;

public final class a implements b {
    public static long taC = 0;
    BroadcastReceiver jhN = new 1(this);
    String lyH;
    private d taA = null;
    private c taB;
    private d taD;
    private com.tencent.mm.plugin.wallet_index.b.a.a taE;
    private b taF;
    String taG;
    private String taj;
    String tak;
    private d taz = null;

    public a(Activity activity, c cVar, d dVar) {
        this.taD = dVar;
        taC = 0;
        this.taB = cVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE");
        intentFilter.addAction("com.tencent.mm.gwallet.ACTION_PAY_RESPONSE");
        activity.registerReceiver(this.jhN, intentFilter);
        this.taE = new com.tencent.mm.plugin.wallet_index.b.a.a();
    }

    public final int bNm() {
        return 3;
    }

    public final void a(MMActivity mMActivity, d dVar) {
        this.taz = dVar;
        this.lyH = this.taB.tao.pek;
        this.tak = this.taB.tao.pbN;
        this.taj = this.taB.tao.wil;
        Intent intent = new Intent("com.tencent.mm.gwallet.ACTION_PAY_REQUEST");
        intent.setPackage("com.tencent.mm");
        intent.putExtra("product_id", this.lyH);
        this.taG = this.taB.tao.wsj;
        String str = "developer_pay_load";
        String str2 = this.taG;
        String str3 = this.tak;
        String str4 = this.taj;
        if (bh.ov(str2)) {
            str2 = "";
        }
        if (bh.ov(str3)) {
            str3 = "";
        }
        if (bh.ov(str4)) {
            str4 = "";
        }
        intent.putExtra(str, str2 + "[#]" + str3 + "[#]" + str4);
        if (mMActivity.getPackageManager().queryIntentActivities(intent, 65536).isEmpty()) {
            x.i("MicroMsg.GoogleWallet", "Try to downloading GWallet Moudle!");
            com.tencent.mm.plugin.wallet_index.c.a aL = com.tencent.mm.plugin.wallet_index.c.a.aL(3, "");
            if (this.taz != null) {
                this.taz.a(aL, null);
                return;
            }
            return;
        }
        taC = bh.Wp();
        x.i("MicroMsg.GoogleWallet", "GWallet Found!");
        mMActivity.startActivityForResult(intent, 10001);
    }

    public final void g(MMActivity mMActivity) {
        try {
            mMActivity.unregisterReceiver(this.jhN);
        } catch (IllegalArgumentException e) {
            x.e("MicroMsg.GoogleWallet", e.toString());
        }
        if (!bh.bF(mMActivity)) {
            x.d("MicroMsg.GoogleWallet", "close front UI.");
            Intent intent = new Intent("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST");
            intent.setPackage("com.tencent.mm");
            mMActivity.sendBroadcast(intent);
        }
        x.d("MicroMsg.GoogleWallet", "Destroying helper.");
    }

    private static void c(MMActivity mMActivity, int i) {
        com.tencent.mm.plugin.wallet_index.c.a aL = com.tencent.mm.plugin.wallet_index.c.a.aL(i, "");
        Intent intent = new Intent();
        intent.putExtra("key_err_code", aL.nAh);
        intent.putExtra("key_err_msg", aL.mMessage);
        intent.putExtra("key_launch_ts", taC);
        mMActivity.setResult(-1, intent);
        mMActivity.finish();
    }

    public final boolean a(MMActivity mMActivity, int i, int i2, Intent intent) {
        if (i == 10001) {
            x.i("MicroMsg.GoogleWallet", "purchase flow!result_code: %d", Integer.valueOf(i2));
            if (intent != null) {
                int intExtra = intent.getIntExtra("RESPONSE_CODE", 0);
                if (intExtra == 3 || intExtra == 105) {
                    p.c(this.taG, this.lyH, this.tak, intExtra, "");
                    c(mMActivity, intExtra);
                } else if (intExtra == 100000001) {
                    c(mMActivity, intExtra);
                }
            } else {
                c(mMActivity, 1);
            }
            return true;
        }
        d dVar = this.taA;
        String str = this.taG;
        String str2 = this.lyH;
        String str3 = this.tak;
        int Z = com.tencent.mm.plugin.wallet_index.b.a.a.Z(intent);
        x.d("MicroMsg.IabResolver", "Owned items response: " + String.valueOf(Z));
        com.tencent.mm.plugin.wallet_index.c.a aL = com.tencent.mm.plugin.wallet_index.c.a.aL(Z, "");
        p.c(str, str2, str3, Z, aL.mMessage);
        if (dVar != null) {
            dVar.a(aL, null);
        }
        return true;
    }

    public final void c(MMActivity mMActivity, boolean z) {
        x.d("MicroMsg.GoogleWallet", "restorePurchase. Querying inventory.");
        x.d("MicroMsg.GoogleWallet", "is direct? " + z);
        Intent intent = new Intent("com.tencent.mm.gwallet.ACTION_QUERY_REQUEST");
        intent.setPackage("com.tencent.mm");
        intent.putExtra("is_direct", z);
        mMActivity.startActivityForResult(intent, 10001);
    }

    public final void a(MMActivity mMActivity, ArrayList<String> arrayList, d dVar, boolean z) {
        this.taA = dVar;
        x.d("MicroMsg.GoogleWallet", "consumePurchase. consume...");
        b bVar = this.taF;
        ArrayList arrayList2 = new ArrayList();
        for (String str : arrayList) {
            c cVar = (c) bVar.tab.get(str);
            if (cVar != null) {
                arrayList2.add(cVar.hzj);
            }
        }
        if (arrayList2.size() > 0) {
            Intent intent = new Intent("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST");
            intent.setPackage("com.tencent.mm");
            intent.putStringArrayListExtra("tokens", arrayList2);
            intent.putExtra("IS_FAILED_CONSUME", z);
            mMActivity.sendBroadcast(intent);
            return;
        }
        com.tencent.mm.plugin.wallet_index.c.a aL = com.tencent.mm.plugin.wallet_index.c.a.aL(0, "");
        if (this.taA != null) {
            this.taA.a(aL, null);
        }
    }
}
