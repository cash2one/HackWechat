package com.tencent.mm.plugin.wallet.pwd.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a$c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a.b;

@a(3)
public class WalletIdCardCheckUI extends WalletBaseUI implements OnEditorActionListener, WalletFormView.a {
    private WalletFormView sGY;
    private TextView sGZ;
    private TextView sHa;
    private Button sHb;
    private int sHc = 1;

    static /* synthetic */ boolean a(WalletIdCardCheckUI walletIdCardCheckUI) {
        boolean z = true;
        if (!walletIdCardCheckUI.sGY.dQ(walletIdCardCheckUI.sHa)) {
            walletIdCardCheckUI.sHa.setText(i.uyt);
            walletIdCardCheckUI.sHa.setTextColor(walletIdCardCheckUI.getResources().getColor(a$c.btB));
            z = false;
        }
        if (z) {
            walletIdCardCheckUI.sHa.setVisibility(4);
        } else {
            walletIdCardCheckUI.sHa.setVisibility(0);
        }
        return z;
    }

    protected final int getLayoutId() {
        return g.uEN;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.uUd);
        ji(1580);
        initView();
        setBackBtn(new 1(this));
    }

    protected final void aXc() {
        x.d("Micromsg.WalletIdCardCheckUI", "check pwd ");
        this.zIY.aXc();
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        jj(1580);
    }

    protected final void initView() {
        String O;
        this.sGY = (WalletFormView) findViewById(f.ukS);
        this.sHa = (TextView) findViewById(f.uyt);
        this.sGZ = (TextView) findViewById(f.uyu);
        this.sGY.zJH = this;
        this.sGY.setOnEditorActionListener(this);
        this.sHa.setVisibility(4);
        this.sHb = (Button) findViewById(f.uld);
        com.tencent.mm.wallet_core.ui.formview.a.c(this.sGY);
        e(this.sGY, 1, false);
        this.sHb.setOnClickListener(new 2(this));
        this.sHc = o.bLq().bLS();
        ag bLq = o.bLq();
        String str = bLq.sPZ != null ? bLq.sPZ.field_cre_name : "";
        x.i("Micromsg.WalletIdCardCheckUI", "mIdentityType %d %s", new Object[]{Integer.valueOf(this.sHc), str});
        if (bh.ov(str)) {
            O = o.bLy().O(this, this.sHc);
        } else {
            O = str;
        }
        WalletFormView walletFormView = this.sGY;
        int i = this.sHc;
        b bVar = walletFormView.zJJ;
        if (bVar instanceof com.tencent.mm.wallet_core.ui.formview.a.a) {
            ((com.tencent.mm.wallet_core.ui.formview.a.a) bVar).HG(i);
        }
        this.sGY.xv(O);
        this.sGY.bmK();
        if (this.sHc == 1) {
            e(this.sGY, 1, false);
        } else {
            e(this.sGY, 1, true);
        }
        str = o.bLq().azp();
        this.sGY.setHint(getString(i.uUb, new Object[]{e.aaD(str)}));
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.ofs == null || !this.ofs.isShown()) {
            return super.onKeyUp(i, keyEvent);
        }
        this.ofs.setVisibility(8);
        return true;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public final boolean j(int i, int i2, String str, k kVar) {
        x.d("Micromsg.WalletIdCardCheckUI", " errCode: " + i2 + " errMsg :" + str);
        if (i == 0 && i2 == 0 && (kVar instanceof com.tencent.mm.wallet_core.c.f)) {
            h.a(this, getString(i.uUc), "", getString(i.uRP), false, new 3(this));
        }
        return true;
    }

    public final void hx(boolean z) {
        this.sHa.setVisibility(4);
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return false;
    }
}
