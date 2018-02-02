package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.remittance.bankcard.a.h;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.x;

public class BankRemitSelectBankUI extends BankRemitBaseUI {
    private BankRemitSortView pJG;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(a$i.uHS);
        ji(1399);
        initView();
        x.i("MicroMsg.BankRemitSelectBankUI", "do fetch data");
        k hVar = new h();
        hVar.k(this);
        l(hVar);
    }

    protected final void initView() {
        this.pJG = (BankRemitSortView) findViewById(f.ugM);
        this.pJG.XC = new 1(this);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof h) {
            h hVar = (h) kVar;
            hVar.a(new 4(this, hVar)).b(new 3(this, hVar)).c(new 2(this, hVar));
        }
        return false;
    }

    protected final int getLayoutId() {
        return a$g.uBh;
    }

    public void onDestroy() {
        super.onDestroy();
        jj(1399);
    }
}
