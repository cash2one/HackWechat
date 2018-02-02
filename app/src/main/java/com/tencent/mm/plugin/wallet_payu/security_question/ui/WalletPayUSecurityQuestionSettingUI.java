package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.tools.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;

@a(3)
public class WalletPayUSecurityQuestionSettingUI extends WalletBaseUI {
    private Button lRZ;
    private WalletPayUSecurityQuestionView tdJ;
    private WalletFormView tdK;
    private m tdO;
    private String tdP = "";
    private a tdQ;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.tdO = new m(this);
        this.tdO.nv(true);
        this.tdO.rKC = new c(this) {
            final /* synthetic */ WalletPayUSecurityQuestionSettingUI tdR;

            {
                this.tdR = r1;
            }

            public final void a(n nVar) {
                nVar.clear();
                ArrayList a = this.tdR.vf.getParcelableArrayList("key_security_question_list");
                if (a != null) {
                    for (int i = 0; i < a.size(); i++) {
                        nVar.add(((PayUSecurityQuestion) a.get(i)).desc);
                    }
                }
            }
        };
        this.tdO.rKD = new d(this) {
            final /* synthetic */ WalletPayUSecurityQuestionSettingUI tdR;

            {
                this.tdR = r1;
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                this.tdR.tdJ.NB(((PayUSecurityQuestion) this.tdR.vf.getParcelableArrayList("key_security_question_list").get(i)).desc);
                this.tdR.tdP = ((PayUSecurityQuestion) this.tdR.vf.getParcelableArrayList("key_security_question_list").get(i)).id;
                this.tdR.tdK.bmK();
                a.a(this.tdR.tdQ);
            }
        };
        this.tdQ = new a(this);
        this.tdJ = (WalletPayUSecurityQuestionView) findViewById(f.utt);
        this.tdK = (WalletFormView) findViewById(f.uts);
        com.tencent.mm.wallet_core.ui.formview.a.f(this.tdK);
        this.lRZ = (Button) findViewById(f.utr);
        this.tdJ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletPayUSecurityQuestionSettingUI tdR;

            {
                this.tdR = r1;
            }

            public final void onClick(View view) {
                this.tdR.tdO.dM();
            }
        });
        this.tdK.zJH = new WalletFormView.a(this) {
            final /* synthetic */ WalletPayUSecurityQuestionSettingUI tdR;

            {
                this.tdR = r1;
            }

            public final void hx(boolean z) {
                a.a(this.tdR.tdQ);
            }
        };
        this.lRZ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletPayUSecurityQuestionSettingUI tdR;

            {
                this.tdR = r1;
            }

            public final void onClick(View view) {
                if (this.tdR.tdQ.bNw()) {
                    this.tdR.vf.putString("key_question_id", this.tdR.tdP);
                    this.tdR.vf.putString("key_question_answer", this.tdR.tdK.getText());
                    com.tencent.mm.wallet_core.a.j(this.tdR, this.tdR.vf);
                    return;
                }
                a.a(this.tdR.tdQ);
            }
        });
        a.a(this.tdQ);
    }

    public void onResume() {
        super.onResume();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if ((kVar instanceof com.tencent.mm.plugin.wallet_payu.security_question.model.d) && this.tdO.isShowing()) {
            this.tdO.dismiss();
        }
        return false;
    }

    protected final int getLayoutId() {
        return g.uDq;
    }

    protected final boolean bKa() {
        return true;
    }
}
