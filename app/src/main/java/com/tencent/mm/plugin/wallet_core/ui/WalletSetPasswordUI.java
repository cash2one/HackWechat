package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.e.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.z.q;

@a(19)
public class WalletSetPasswordUI extends WalletBaseUI {
    public EditHintPasswdView sBG;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(u.gf(this));
        initView();
        c.b(this, this.vf, 5);
    }

    protected final void initView() {
        TextView textView;
        if (this.vf.getInt("key_err_code", 0) == -1002) {
            textView = (TextView) findViewById(f.ukX);
            textView.setVisibility(0);
            textView.setText(q.Gf() ? getString(i.uWN) : getString(i.uWM));
            this.vf.putInt("key_err_code", 0);
        }
        this.sBG = (EditHintPasswdView) findViewById(f.ukY);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.sBG);
        findViewById(f.ufM).setVisibility(8);
        textView = (TextView) findViewById(f.uAg);
        com.tencent.mm.wallet_core.c ag = com.tencent.mm.wallet_core.a.ag(this);
        CharSequence string = (ag == null || !(ag instanceof com.tencent.mm.plugin.wallet_core.id_verify.a)) ? q.Gf() ? getString(i.uWL) : getString(i.uAg) : getString(i.uWK);
        textView.setText(string);
        this.sBG.zJC = new 1(this);
        e(this.sBG, 0, false);
    }

    public void onResume() {
        this.sBG.requestFocus();
        super.onResume();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
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
