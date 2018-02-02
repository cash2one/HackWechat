package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelfriend.u;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.protocal.p;
import com.tencent.mm.protocal.p.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoSwitchEditTextView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

public class EmailVerifyUI extends MMActivity implements e {
    private ProgressDialog iln = null;
    private String pRQ;
    private TextView xNA;
    private TextView xNB;
    private MMAutoSwitchEditTextView xNC;
    private Button xND;
    private Button xNE;
    private String xNF;
    private String xNG;
    private String xNH;
    private String xNI;
    private boolean xNJ = false;

    static /* synthetic */ void a(EmailVerifyUI emailVerifyUI, String str) {
        if (emailVerifyUI.xNJ) {
            x.i("MicroMsg.EmailVerifyUI", "is verifying, wait a minute");
            return;
        }
        emailVerifyUI.xNJ = true;
        k uVar = new u(emailVerifyUI.xNF, emailVerifyUI.xNH, str);
        ar.CG().a(uVar, 0);
        emailVerifyUI.getString(R.l.dGO);
        emailVerifyUI.iln = h.a(emailVerifyUI, emailVerifyUI.getString(R.l.eDp), true, new 7(emailVerifyUI, uVar));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        this.pRQ = b.Xn();
    }

    protected void onResume() {
        super.onResume();
        ar.CG().a(481, this);
        b.b(true, ar.CB() + "," + getClass().getName() + ",R500_200," + ar.fH("R500_200") + ",1");
        b.oG("R500_200");
    }

    protected void onPause() {
        super.onPause();
        ar.CG().b(481, this);
        b.b(false, ar.CB() + "," + getClass().getName() + ",R500_200," + ar.fH("R500_200") + ",2");
    }

    protected final int getLayoutId() {
        return R.i.dtr;
    }

    protected final void initView() {
        setMMTitle(R.l.eDr);
        this.xNA = (TextView) findViewById(R.h.cUz);
        this.xNA.setText(Html.fromHtml(getString(R.l.eDe)));
        this.xNB = (TextView) findViewById(R.h.cdk);
        this.xNF = getIntent().getStringExtra("email_address");
        if (bh.ov(this.xNF)) {
            x.w("MicroMsg.EmailVerifyUI", "email add is null or nill");
        } else {
            this.xNB.setText(this.xNF);
        }
        this.xNH = getIntent().getStringExtra("password");
        this.xNG = getIntent().getStringExtra("email_login_page");
        x.i("MicroMsg.EmailVerifyUI", "user register:email add:[%s], password not allowed to printf, login page:[%s]", new Object[]{this.xNF, this.xNG});
        this.xNC = (MMAutoSwitchEditTextView) findViewById(R.h.bLz);
        this.xNC.xZH = new 1(this);
        this.xNC.xZI = new MMAutoSwitchEditTextView.b(this) {
            final /* synthetic */ EmailVerifyUI xNK;

            {
                this.xNK = r1;
            }

            public final void cnK() {
                this.xNK.enableOptionMenu(false);
            }
        };
        this.xNE = (Button) findViewById(R.h.cFs);
        this.xNE.setOnClickListener(new 3(this));
        this.xND = (Button) findViewById(R.h.cBH);
        if (bh.ov(this.xNG) || bh.ov(this.xNF)) {
            this.xND.setVisibility(8);
        } else {
            this.xND.setVisibility(0);
            this.xND.setOnClickListener(new 4(this));
        }
        setBackBtn(new 5(this));
        addTextOptionMenu(0, getString(R.l.dFQ), new 6(this));
        enableOptionMenu(false);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        b.oH(this.pRQ);
        finish();
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.EmailVerifyUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        this.xNJ = false;
        if (this.iln != null && this.iln.isShowing()) {
            this.iln.dismiss();
            this.iln = null;
        }
        if (kVar.getType() != 481) {
            x.e("MicroMsg.EmailVerifyUI", "error cgi type callback:[%d]", new Object[]{Integer.valueOf(kVar.getType())});
            return;
        }
        int i3 = ((a) ((u) kVar).hnp.Kb()).vBC.vJL;
        if (i != 0 || i2 != 0) {
            int i4;
            if (!com.tencent.mm.plugin.c.a.ift.a((Context) this, i, i2, str)) {
                switch (i2) {
                    case -34:
                        Toast.makeText(this, R.l.eDa, 0).show();
                        i4 = 1;
                        break;
                    case -33:
                        h.a(this, R.l.eDb, R.l.eDc, null);
                        i4 = 1;
                        break;
                    case -32:
                        h.a(this, R.l.eDd, R.l.eDc, null);
                        b.oI(ar.CB() + "," + getClass().getName() + ",R500_260," + ar.fH("R500_260") + ",3");
                        i4 = 1;
                        break;
                    default:
                        boolean z = false;
                        break;
                }
            }
            i4 = 1;
            if (i4 != 0) {
                return;
            }
            if (i3 == 2) {
                Toast.makeText(this, getString(R.l.eDs, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            } else if (i3 == 1) {
                Toast.makeText(this, getString(R.l.eDj, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        } else if (i3 == 2) {
            b.oH("R200_900_email");
            Intent intent = new Intent(this, RegSetInfoUI.class);
            intent.putExtra("regsetinfo_ticket", ((p.b) ((u) kVar).hnp.Hp()).vBD.vZK);
            intent.putExtra("regsetinfo_user", this.xNF);
            intent.putExtra("regsetinfo_ismobile", 3);
            intent.putExtra("regsetinfo_NextStyle", ((u) kVar).Og());
            intent.putExtra("regsetinfo_pwd", this.xNH);
            intent.putExtra("regsetinfo_bind_email", this.xNF);
            startActivity(intent);
        } else if (i3 == 1) {
            b.oI(ar.CB() + "," + getClass().getName() + ",R22_resend_email_code_alert," + ar.fH("R22_resend_email_code_alert") + ",3");
            h.bu(this, getString(R.l.eDk));
        } else {
            x.e("MicroMsg.EmailVerifyUI", "err opcode");
        }
    }
}
