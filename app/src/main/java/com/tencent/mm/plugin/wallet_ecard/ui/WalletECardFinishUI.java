package com.tencent.mm.plugin.wallet_ecard.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.le;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c;

@a(19)
public class WalletECardFinishUI extends WalletECardBaseUI {
    private Button pIM;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.uJc);
        enableBackMenu(false);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletECardFinishUI sZR;

            {
                this.sZR = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                x.i("MicroMsg.WalletECardFinishUI", "press back btn");
                this.sZR.pIM.performClick();
                return false;
            }
        });
        showHomeBtn(false);
        initView();
    }

    protected final void initView() {
        this.pIM = (Button) findViewById(f.ukG);
        this.pIM.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletECardFinishUI sZR;

            {
                this.sZR = r1;
            }

            public final void onClick(View view) {
                x.i("MicroMsg.WalletECardFinishUI", "click finish");
                com.tencent.mm.sdk.b.a.xef.m(new le());
                c cCc = this.sZR.cCc();
                if (cCc != null) {
                    cCc.b(this.sZR.mController.xIM, new Bundle());
                    return;
                }
                x.w("MicroMsg.WalletECardFinishUI", "process is null");
                this.sZR.finish();
            }
        });
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.uBN;
    }
}
