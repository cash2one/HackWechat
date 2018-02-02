package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.os.Bundle;
import android.widget.Button;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUSecurityQuestionAnswerUI extends WalletBaseUI {
    private Button lRZ;
    private WalletPayUSecurityQuestionView tdJ;
    private WalletFormView tdK;
    private PayUSecurityQuestion tdL;
    private a tdM;

    protected class a {
        final /* synthetic */ WalletPayUSecurityQuestionAnswerUI tdN;

        protected a(WalletPayUSecurityQuestionAnswerUI walletPayUSecurityQuestionAnswerUI) {
            this.tdN = walletPayUSecurityQuestionAnswerUI;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.tdM = new a(this);
        this.tdJ = (WalletPayUSecurityQuestionView) findViewById(f.utt);
        this.tdK = (WalletFormView) findViewById(f.uts);
        com.tencent.mm.wallet_core.ui.formview.a.f(this.tdK);
        this.lRZ = (Button) findViewById(f.utr);
        this.tdK.zJH = new com.tencent.mm.wallet_core.ui.formview.WalletFormView.a(this) {
            final /* synthetic */ WalletPayUSecurityQuestionAnswerUI tdN;

            {
                this.tdN = r1;
            }

            public final void hx(boolean z) {
                boolean z2;
                a a = this.tdN.tdM;
                if (a.tdN.tdK.XO()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    a.tdN.lRZ.setEnabled(true);
                } else {
                    a.tdN.lRZ.setEnabled(false);
                }
            }
        };
        this.lRZ.setOnClickListener(new 2(this));
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            this.tdL = (PayUSecurityQuestion) this.vf.getParcelable("key_security_question");
            x.d("MicroMsg.WalletPayUSecurityQuestionAnswerUI", "hy: updating view");
            if (this.tdL != null) {
                this.tdJ.NB(this.tdL.desc);
            }
            this.tdK.bmK();
        }
        return false;
    }

    protected final int getLayoutId() {
        return g.uDp;
    }

    protected final boolean bKa() {
        return true;
    }
}
