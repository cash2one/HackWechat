package com.tencent.mm.plugin.safedevice.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.modelfriend.t;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.plugin.safedevice.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

public class SecurityAccountVerifyUI extends MMWizardActivity implements e {
    private String fAf;
    private ak fhK;
    private String fxT;
    private String fxV;
    private ProgressDialog iln = null;
    private String pRM;
    private Button pRP;
    private String pRQ;
    private EditText pRU;
    private TextView pRV;
    private TextView pRW;
    private Button pRX;
    private boolean pRY = false;

    protected final int getLayoutId() {
        return R.i.dry;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pRQ = b.Xn();
        initView();
    }

    protected void onResume() {
        ar.CG().a(c.CTRL_INDEX, this);
        ar.CG().a(132, this);
        super.onResume();
        if (!this.pRY) {
            b.b(true, ar.CB() + "," + getClass().getName() + ",L600_200," + ar.fH("L600_200") + ",1");
            b.oG("L600_200");
        }
    }

    protected void onPause() {
        ar.CG().b(c.CTRL_INDEX, this);
        ar.CG().b(132, this);
        super.onPause();
        if (!this.pRY) {
            b.b(false, ar.CB() + "," + getClass().getName() + ",L600_200," + ar.fH("L600_200") + ",2");
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.fhK.TG();
    }

    protected final void initView() {
        this.fAf = getIntent().getStringExtra("binded_mobile");
        this.pRM = getIntent().getStringExtra("auth_ticket");
        this.pRY = getIntent().getBooleanExtra("re_open_verify", false);
        this.pRU = (EditText) findViewById(R.h.bNA);
        this.pRV = (TextView) findViewById(R.h.cwK);
        this.pRW = (TextView) findViewById(R.h.cHK);
        this.pRX = (Button) findViewById(R.h.cHJ);
        this.pRU.addTextChangedListener(new 1(this));
        this.pRV.setText(bh.VQ(this.fAf));
        this.pRW.setTag(Integer.valueOf(60));
        this.fhK = new ak(new 2(this), true);
        this.pRX.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SecurityAccountVerifyUI pRZ;

            {
                this.pRZ = r1;
            }

            public final void onClick(View view) {
                x.v("MicroMsg.SecurityAccountVerifyUI", "on resend verify code button click");
                this.pRZ.pRX.setVisibility(8);
                this.pRZ.pRW.setTag(Integer.valueOf(60));
                this.pRZ.fhK.TG();
                this.pRZ.fhK.J(1000, 1000);
                k sVar = new s(this.pRZ.fAf, 10, "", 0, "", this.pRZ.pRM);
                ar.CG().a(sVar, 0);
                SecurityAccountVerifyUI securityAccountVerifyUI = this.pRZ;
                Context context = this.pRZ.mController.xIM;
                this.pRZ.getString(R.l.dGO);
                securityAccountVerifyUI.iln = h.a(context, this.pRZ.getString(R.l.eGX), true, new 1(this, sVar));
            }
        });
        if (!this.pRY) {
            this.pRP = (Button) findViewById(R.h.bWj);
            this.pRP.setVisibility(0);
            this.pRP.setOnClickListener(new 4(this));
        }
        setBackBtn(new 5(this));
        addTextOptionMenu(0, getString(R.l.dFQ), new OnMenuItemClickListener(this) {
            final /* synthetic */ SecurityAccountVerifyUI pRZ;

            {
                this.pRZ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                String trim = this.pRZ.pRU.getText().toString().trim();
                if (bh.ov(trim)) {
                    h.h(this.pRZ, R.l.dLG, R.l.dGO);
                } else {
                    k tVar;
                    this.pRZ.aWs();
                    this.pRZ.fxT = com.tencent.mm.plugin.safedevice.a.e.dq(this.pRZ);
                    this.pRZ.fxV = com.tencent.mm.plugin.safedevice.a.e.boq();
                    if (this.pRZ.pRY) {
                        tVar = new t(this.pRZ.fAf, 11, trim, "", this.pRZ.fxT, this.pRZ.fxV);
                    } else {
                        tVar = new s(this.pRZ.fAf, trim, "", this.pRZ.pRM, this.pRZ.fxT, this.pRZ.fxV);
                    }
                    ar.CG().a(tVar, 0);
                    SecurityAccountVerifyUI securityAccountVerifyUI = this.pRZ;
                    Context context = this.pRZ;
                    this.pRZ.getString(R.l.dGO);
                    securityAccountVerifyUI.iln = h.a(context, this.pRZ.getString(R.l.dLx), true, new 1(this, tVar));
                }
                return true;
            }
        });
        enableOptionMenu(false);
        setMMTitle(R.l.eGR);
        this.fhK.J(1000, 1000);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        bov();
        return true;
    }

    private void bov() {
        cancel();
        DU(1);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.iln != null && this.iln.isShowing()) {
            this.iln.dismiss();
            this.iln = null;
        }
        Intent intent;
        switch (kVar.getType()) {
            case 132:
                if (i == 0 && i2 == 0) {
                    com.tencent.mm.plugin.safedevice.a.e.x(true, true);
                    intent = new Intent(this, MySafeDeviceListUI.class);
                    intent.addFlags(67108864);
                    startActivity(intent);
                    finish();
                    return;
                } else if (!o(i, i2, str)) {
                    Toast.makeText(this, getString(R.l.eGY, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    return;
                } else {
                    return;
                }
            case c.CTRL_INDEX /*145*/:
                s sVar = (s) kVar;
                if (sVar.IS() == 10) {
                    if (i == 0 && i2 == 0) {
                        x.i("MicroMsg.SecurityAccountVerifyUI", "resend verify code successfully");
                        return;
                    }
                    x.w("MicroMsg.SecurityAccountVerifyUI", "resend verify code fail, errType %d, errCode %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    if (!o(i, i2, str)) {
                        Toast.makeText(this.mController.xIM, getString(R.l.eGW, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                        return;
                    }
                    return;
                } else if (sVar.IS() != 11) {
                    x.w("MicroMsg.SecurityAccountVerifyUI", "unknow bind mobile for reg op code %d, errType %d, errCode %d", new Object[]{Integer.valueOf(sVar.IS()), Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                } else if (i == 0 && i2 == 0) {
                    this.pRM = sVar.NX();
                    x.d("MicroMsg.SecurityAccountVerifyUI", "duanyi test bind opmobile verify authticket = " + this.pRM);
                    int intExtra = getIntent().getIntExtra("from_source", 1);
                    Intent intent2 = new Intent();
                    intent2.putExtra("from_source", intExtra);
                    intent2.putExtra("binded_mobile", this.fAf);
                    switch (intExtra) {
                        case 1:
                        case 2:
                        case 5:
                        case 6:
                            intent2.addFlags(67108864);
                            intent2.putExtra("auth_ticket", this.pRM);
                            a.a(this, intent2, null);
                            finish();
                            return;
                        case 3:
                            intent2.addFlags(67108864);
                            intent2.putExtra("auth_ticket", this.pRM);
                            Object stringExtra = getIntent().getStringExtra("WizardTransactionId");
                            if (stringExtra == null) {
                                stringExtra = "";
                            }
                            intent = (Intent) xKw.get(stringExtra);
                            xKw.clear();
                            if (intent != null) {
                                a.a(this, intent2, intent);
                            } else {
                                a.a(this, intent2, null);
                            }
                            finish();
                            return;
                        default:
                            DU(1);
                            return;
                    }
                } else {
                    x.w("MicroMsg.SecurityAccountVerifyUI", "verify verify-code fail, errType %d, errCode %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    if (!o(i, i2, str)) {
                        Toast.makeText(this.mController.xIM, getString(R.l.eGY, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                        return;
                    }
                    return;
                }
            default:
                return;
        }
    }

    private boolean o(int i, int i2, String str) {
        if (com.tencent.mm.plugin.c.a.ift.a(this.mController.xIM, i, i2, str)) {
            return true;
        }
        switch (i2) {
            case -74:
                h.a(this.mController.xIM, R.l.dKP, R.l.dGO, null);
                return true;
            case -57:
            case -1:
                Toast.makeText(this.mController.xIM, R.l.dEP, 0).show();
                return true;
            case -41:
                Toast.makeText(this.mController.xIM, R.l.dKS, 0).show();
                return true;
            case -34:
                Toast.makeText(this, R.l.dKT, 0).show();
                return true;
            case -33:
                h.a(this.mController.xIM, R.l.dLA, R.l.bNB, null);
                return true;
            case -32:
                h.a(this.mController.xIM, R.l.dLB, R.l.bNB, null);
                return true;
            default:
                return false;
        }
    }
}
