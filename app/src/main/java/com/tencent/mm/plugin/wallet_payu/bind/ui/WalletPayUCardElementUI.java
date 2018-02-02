package com.tencent.mm.plugin.wallet_payu.bind.ui;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_payu.a.c;
import com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery;
import com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery.PayUBankcardElement;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView$a;
import java.util.HashMap;
import java.util.HashSet;

@a(19)
public class WalletPayUCardElementUI extends WalletBaseUI implements WalletFormView$a {
    private Button lRZ;
    private WalletFormView tbF;
    WalletFormView tbG;
    private WalletFormView tbH;
    private TextView tbI;
    private TextView tbJ;
    private TextView tbK;
    private b tbL;
    private boolean tbM = false;
    private boolean tbN = false;
    private boolean tbO = false;
    private HashMap<String, PayUBankcardElement> tbP = null;
    private HashSet<String> tbQ = null;

    static /* synthetic */ void a(WalletPayUCardElementUI walletPayUCardElementUI, View view, Editable editable) {
        if (!(editable == null || editable.length() == 0)) {
            if (view.getId() == walletPayUCardElementUI.tbF.getId()) {
                walletPayUCardElementUI.tbM = true;
            } else if (view.getId() == walletPayUCardElementUI.tbH.getId()) {
                walletPayUCardElementUI.tbO = true;
            } else if (view.getId() == walletPayUCardElementUI.tbG.getId()) {
                walletPayUCardElementUI.tbN = true;
            }
        }
        walletPayUCardElementUI.tbL.bNr();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.tbL = new b(this);
        this.tbP = new HashMap();
        this.tbQ = new HashSet();
        this.tbF = (WalletFormView) findViewById(a$f.uhu);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.tbF);
        this.tbG = (WalletFormView) findViewById(a$f.ujb);
        com.tencent.mm.wallet_core.ui.formview.a.a(this, this.tbG);
        this.tbH = (WalletFormView) findViewById(a$f.uja);
        com.tencent.mm.wallet_core.ui.formview.a.b(this, this.tbH);
        this.tbI = (TextView) findViewById(a$f.uyv);
        this.tbJ = (TextView) findViewById(a$f.uym);
        this.lRZ = (Button) findViewById(a$f.cAg);
        e(this.tbF, 0, false);
        e(this.tbH, 0, false);
        this.tbF.zJH = this;
        this.tbH.zJH = this;
        this.tbG.zJH = this;
        this.tbF.zJL = 0;
        this.tbH.a(new a(this) {
            final /* synthetic */ WalletPayUCardElementUI tbR;

            {
                this.tbR = r2;
            }

            public final void afterTextChanged(Editable editable) {
                WalletPayUCardElementUI.a(this.tbR, this.tbR.tbH, editable);
            }
        });
        this.tbG.a(new 2(this));
        this.tbF.a(new a(this) {
            final /* synthetic */ WalletPayUCardElementUI tbR;

            {
                this.tbR = r2;
            }

            public final void afterTextChanged(Editable editable) {
                WalletPayUCardElementUI.a(this.tbR, this.tbR.tbF, editable);
            }
        });
        this.lRZ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletPayUCardElementUI tbR;

            {
                this.tbR = r1;
            }

            public final void onClick(View view) {
                PayUBankcardElement payUBankcardElement = (PayUBankcardElement) this.tbR.tbP.get(this.tbR.tbF.getText());
                if (payUBankcardElement == null) {
                    x.e("MicroMsg.WalletPayUCardElementUI", "hy: should not be NULL!!!");
                    return;
                }
                this.tbR.tbF.zJL = 50;
                this.tbR.vf.putParcelable("key_card_element", payUBankcardElement);
                this.tbR.vf.putString("key_card_id", this.tbR.tbF.getText());
                this.tbR.vf.putString("key_cvv", this.tbR.tbH.getText());
                this.tbR.vf.putString("key_expire_data", this.tbR.tbG.getText());
                this.tbR.cCd().k(new Object[0]);
            }
        });
        ((TextView) findViewById(a$f.uzT)).setText(u.cBC());
        this.tbK = (TextView) findViewById(a$f.uwz);
        c.a(this, this.tbK);
    }

    public void onResume() {
        super.onResume();
        this.tbL.bNr();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof NetScenePayUElementQuery) {
            this.tbP.put(((NetScenePayUElementQuery) kVar).tbx, (PayUBankcardElement) this.vf.getParcelable("key_card_element"));
            this.tbL.bNr();
            this.tbQ.remove(((NetScenePayUElementQuery) kVar).tbx);
            return true;
        } else if (!(kVar instanceof com.tencent.mm.plugin.wallet_payu.bind.model.a)) {
            return false;
        } else {
            if (i == 0 && i2 == 0) {
                return false;
            }
            this.tbF.zJL = 0;
            return false;
        }
    }

    protected final int getLayoutId() {
        return g.uDo;
    }

    public final void hx(boolean z) {
    }

    protected final boolean bKa() {
        return true;
    }
}
