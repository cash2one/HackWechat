package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(19)
public class WalletWXCreditOpenResultUI extends WalletBaseUI {
    private CheckBox uak;

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.uGh;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Dj().CU().set(196658, Boolean.valueOf(true));
        o.bLq().sQg = bh.Wo();
        initView();
    }

    protected final void initView() {
        setMMTitle(i.uXZ);
        TextView textView = (TextView) findViewById(f.uAy);
        this.uak = (CheckBox) findViewById(f.ueH);
        if (((Bankcard) this.vf.getParcelable("key_bankcard")) != null) {
            this.uak.setText(getString(i.uYa, new Object[]{r1.field_bankName}));
            textView.setText(i.uYb);
        }
        ((Button) findViewById(f.cAg)).setOnClickListener(new 1(this));
    }

    private void bKz() {
        cCd().k(new Object[]{Boolean.valueOf(this.uak.isChecked())});
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        bKz();
        return true;
    }
}
