package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.z.aq;
import com.tencent.mm.z.ar;

public class RegByQQAuthUI extends MMActivity implements e {
    private String fDB;
    private String frP;
    private String hNv;
    private ProgressDialog iln = null;
    private String xPo;
    private EditText xRE = null;
    private int xRF;

    protected final int getLayoutId() {
        return R.i.dqH;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        ar.CG().a(126, (e) this);
    }

    public void onPause() {
        super.onPause();
        ar.CG().b(126, (e) this);
    }

    protected final void initView() {
        this.xRF = getIntent().getIntExtra("RegByQQ_BindUin", 0);
        this.xPo = getIntent().getStringExtra("RegByQQ_RawPsw");
        this.hNv = getIntent().getStringExtra("RegByQQ_Account");
        this.frP = getIntent().getStringExtra("RegByQQ_Ticket");
        this.fDB = getIntent().getStringExtra("RegByQQ_Nick");
        x.v("MicroMsg.RegByQQAuthUI", "values : bindUin:" + this.xRF + "  pass:" + this.xPo + "  ticket:" + this.frP);
        this.xRE = (EditText) findViewById(R.h.cAi);
        if (!(this.fDB == null || this.fDB.equals(""))) {
            this.xRE.setText(this.fDB);
        }
        setMMTitle(R.l.eEf);
        addTextOptionMenu(0, getString(R.l.dFQ), new 1(this));
        setBackBtn(new 2(this));
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.RegByQQAuthUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.iln != null) {
            this.iln.dismiss();
            this.iln = null;
        }
        if (!bh.bF(this)) {
            return;
        }
        if (i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 126:
                    ar.unhold();
                    aq.hfP.S("login_user_name", this.hNv);
                    Intent intent = new Intent(this, BindMContactIntroUI.class);
                    intent.putExtra("key_upload_scene", 1);
                    intent.putExtra("skip", true);
                    Intent at = a.ifs.at(this);
                    at.addFlags(67108864);
                    at.putExtra("LauncherUI.enter_from_reg", true);
                    MMWizardActivity.b(this, intent, at);
                    return;
                default:
                    return;
            }
        }
        boolean z;
        if (kVar.getType() == 126) {
            com.tencent.mm.h.a eA = com.tencent.mm.h.a.eA(str);
            if (eA != null) {
                eA.a(this, null, null);
                return;
            }
        }
        if (a.ift.a(this.mController.xIM, i, i2, str)) {
            z = true;
        } else {
            if (i == 4) {
                switch (i2) {
                    case -75:
                        h.h(this.mController.xIM, R.l.dDG, R.l.dGO);
                        z = true;
                        break;
                    case -72:
                        h.h(this.mController.xIM, R.l.eEb, R.l.dGO);
                        z = true;
                        break;
                    case -12:
                        h.h(this, R.l.eEe, R.l.eEd);
                        z = true;
                        break;
                    case -11:
                        h.h(this, R.l.eEc, R.l.eEd);
                        z = true;
                        break;
                    case -4:
                        h.h(this, R.l.dEL, R.l.eEd);
                        z = true;
                        break;
                    case -1:
                        if (ar.CG().Km() == 5) {
                            h.h(this, R.l.exG, R.l.exF);
                            z = true;
                            break;
                        }
                    case -3:
                        h.h(this, R.l.dEM, R.l.eEd);
                        z = true;
                        break;
                }
            }
            z = false;
        }
        if (!z) {
            Toast.makeText(this, getString(R.l.eiZ, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }
}
