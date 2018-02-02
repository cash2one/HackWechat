package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pluginsdk.ui.d.l;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;

public class WalletLqtSaveFetchFinishUI extends WalletBaseUI {
    private Button oDx;
    private TextView sAT;
    private WalletTextView sAU;
    private TextView sAV;
    private TextView sAW;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.sAT = (TextView) findViewById(f.uwE);
        this.sAU = (WalletTextView) findViewById(f.ueF);
        this.oDx = (Button) findViewById(f.ukH);
        this.sAV = (TextView) findViewById(f.utI);
        this.sAW = (TextView) findViewById(f.uxo);
        int intExtra = getIntent().getIntExtra("key_mode", 1);
        double doubleExtra = getIntent().getDoubleExtra("key_amount", 0.0d);
        CharSequence stringExtra = getIntent().getStringExtra("profile_date_wording");
        CharSequence stringExtra2 = getIntent().getStringExtra("profile_upgrade_wording");
        if (intExtra == 1) {
            this.sAT.setText(getString(a$i.uSY));
            setMMTitle(getString(a$i.uSY));
        } else if (intExtra == 2) {
            this.sAT.setText(getString(a$i.uSJ));
            setMMTitle(getString(a$i.uSJ));
        }
        this.sAU.setText(e.t(doubleExtra));
        this.oDx.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletLqtSaveFetchFinishUI sAX;

            {
                this.sAX = r1;
            }

            public final void onClick(View view) {
                this.sAX.finish();
            }
        });
        if (!bh.ov(stringExtra)) {
            this.sAV.setText(stringExtra);
            this.sAV.setVisibility(0);
        }
        if (!bh.ov(stringExtra2)) {
            this.sAW.setText(i.e(this, stringExtra2, (int) this.sAW.getTextSize()));
            this.sAW.setClickable(true);
            this.sAW.setOnTouchListener(new l());
            this.sAW.setVisibility(0);
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return a$g.uFh;
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
