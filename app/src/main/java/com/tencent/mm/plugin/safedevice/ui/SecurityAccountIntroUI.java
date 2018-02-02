package com.tencent.mm.plugin.safedevice.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.modelfriend.t;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.protocal.c.gy;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import java.util.Map;

public class SecurityAccountIntroUI extends MMWizardActivity implements e {
    private String fAf;
    private ProgressDialog iln = null;
    private String jumpUrl;
    private String pRM;
    private String pRN;
    private boolean pRO = false;
    private Button pRP;
    private String pRQ;

    protected final int getLayoutId() {
        return R.i.drw;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pRM = getIntent().getStringExtra("auth_ticket");
        this.fAf = getIntent().getStringExtra("binded_mobile");
        this.pRO = getIntent().getBooleanExtra("re_open_verify", false);
        String stringExtra = getIntent().getStringExtra("close_safe_device_style");
        x.i("MicroMsg.SecurityAccountIntroUI", "summerphone authTicket[%s], showStyle[%s]", bh.VT(this.pRM), stringExtra);
        if (!bh.ov(stringExtra)) {
            Map y = bi.y(stringExtra, "wording");
            if (y != null) {
                this.pRN = (String) y.get(".wording.title");
                this.jumpUrl = (String) y.get(".wording.url");
                x.i("MicroMsg.SecurityAccountIntroUI", "summerphone closeBtnText[%s], jumpUrl[%s]", this.pRN, this.jumpUrl);
            }
        }
        this.pRQ = b.Xn();
        initView();
    }

    protected void onResume() {
        super.onResume();
        ar.CG().a((int) c.CTRL_INDEX, (e) this);
        ar.CG().a(132, (e) this);
        if (!this.pRO) {
            b.b(true, ar.CB() + "," + getClass().getName() + ",L600_100," + ar.fH("L600_100") + ",1");
            b.oG("L600_100");
        }
    }

    protected void onPause() {
        super.onPause();
        ar.CG().b((int) c.CTRL_INDEX, (e) this);
        ar.CG().b(132, (e) this);
        if (!this.pRO) {
            b.b(false, ar.CB() + "," + getClass().getName() + ",L600_100," + ar.fH("L600_100") + ",2");
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        bov();
        return true;
    }

    protected final void initView() {
        setMMTitle(R.l.eGZ);
        findViewById(R.h.cBM).setOnClickListener(new 1(this));
        if (!this.pRO) {
            this.pRP = (Button) findViewById(R.h.bWj);
            if (!bh.ov(this.pRN)) {
                this.pRP.setText(this.pRN);
            }
            this.pRP.setVisibility(0);
            this.pRP.setOnClickListener(new 2(this));
        }
        setBackBtn(new 3(this));
    }

    private void bov() {
        b.oH(this.pRQ);
        cancel();
        DU(1);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.iln != null && this.iln.isShowing()) {
            this.iln.dismiss();
            this.iln = null;
        }
        if (i == 0 && i2 == 0) {
            String str2;
            if (this.pRO) {
                str2 = ((gy) ((t) kVar).gJQ.hmh.hmo).vJl;
            } else {
                str2 = ((s) kVar).NX();
            }
            x.d("MicroMsg.SecurityAccountIntroUI", "duanyi test authTicket_login = " + this.pRM + "duanyi test authTicket_check = " + str2);
            Intent intent = new Intent(this, SecurityAccountVerifyUI.class);
            intent.putExtra("auth_ticket", str2);
            intent.putExtra("binded_mobile", this.fAf);
            intent.putExtra("re_open_verify", this.pRO);
            intent.putExtra("from_source", getIntent().getIntExtra("from_source", 1));
            A(this, intent);
            if (getIntent().getIntExtra("from_source", 1) == 3) {
                finish();
                return;
            }
            return;
        }
        int i3;
        switch (i2) {
            case -74:
                h.a(this, R.l.dKP, R.l.dGO, null);
                i3 = 1;
                break;
            case -57:
            case -1:
                Toast.makeText(this, R.l.dEP, 0).show();
                i3 = 1;
                break;
            case -41:
                Toast.makeText(this, R.l.dKS, 0).show();
                i3 = 1;
                break;
            case -34:
                Toast.makeText(this, R.l.dKT, 0).show();
                i3 = 1;
                break;
            default:
                i3 = 0;
                break;
        }
        if (i3 == 0 && !a.ift.a(this, i, i2, str)) {
            Toast.makeText(this, getString(R.l.eGW, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }
}
