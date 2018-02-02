package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.tb;
import com.tencent.mm.plugin.wallet_core.c.x;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.z.q;

@a(19)
public class WalletPwdConfirmUI extends WalletBaseUI {
    private c gyH = new 4(this);
    public EditHintPasswdView sBG;
    private PayInfo sEO;
    private TextView sVj;
    private boolean sVk = false;
    private ak sVl = new ak(new 3(this), false);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(u.gf(this));
        this.sEO = (PayInfo) this.vf.getParcelable("key_pay_info");
        initView();
        com.tencent.mm.plugin.wallet_core.e.c.b(this, this.vf, 6);
    }

    protected final void initView() {
        ((TextView) findViewById(f.uAg)).setText(q.Gf() ? getString(i.uTW) : getString(i.uTV));
        this.sVj = (TextView) findViewById(f.ukZ);
        if (bh.M(um(0))) {
            this.sVj.setText(i.dFl);
        } else {
            this.sVj.setText(i.uWO);
        }
        this.sVj.setVisibility(0);
        this.sVj.setOnClickListener(new 1(this));
        this.sVj.setEnabled(false);
        this.sVj.setClickable(false);
        this.sBG = (EditHintPasswdView) findViewById(f.ukY);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.sBG);
        this.sBG.zJC = new EditHintPasswdView.a(this) {
            final /* synthetic */ WalletPwdConfirmUI sVm;

            {
                this.sVm = r1;
            }

            public final void hx(boolean z) {
                if (z) {
                    String string = this.sVm.vf.getString("key_new_pwd1");
                    String cCk = this.sVm.sBG.cCk();
                    if (string == null || !string.equals(cCk)) {
                        com.tencent.mm.wallet_core.a.m(this.sVm, -1002);
                        return;
                    }
                    this.sVm.sVj.setEnabled(z);
                    this.sVm.sVj.setClickable(z);
                    return;
                }
                this.sVm.sVj.setEnabled(z);
                this.sVm.sVj.setClickable(z);
            }
        };
        findViewById(f.ufM).setVisibility(8);
        e(this.sBG, 0, false);
    }

    public void onResume() {
        this.sBG.requestFocus();
        super.onResume();
        com.tencent.mm.sdk.b.a.xef.b(this.gyH);
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.sdk.b.a.xef.c(this.gyH);
    }

    private void bMJ() {
        Bundle bundle = this.vf;
        bundle.putBoolean("intent_bind_end", true);
        com.tencent.mm.wallet_core.a.j(this, bundle);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        this.vf.putString("key_pwd1", this.sBG.getText());
        if (kVar instanceof x) {
            if (!this.sVk) {
                bMJ();
            }
        } else if (com.tencent.mm.wallet_core.a.ag(this) == null || !com.tencent.mm.wallet_core.a.ag(this).c(this, null)) {
            com.tencent.mm.wallet_core.a.j(this, this.vf);
        } else {
            r(new x(this.sEO != null ? this.sEO.fuH : "", 22));
            b tbVar = new tb();
            if (com.tencent.mm.sdk.b.a.xef.B(tbVar.getClass())) {
                this.sVk = true;
                com.tencent.mm.sdk.b.a.xef.m(tbVar);
            }
            this.sVl.J(10000, 10000);
        }
        return true;
    }

    protected final int getLayoutId() {
        return g.uFQ;
    }

    protected final boolean bKa() {
        return true;
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
