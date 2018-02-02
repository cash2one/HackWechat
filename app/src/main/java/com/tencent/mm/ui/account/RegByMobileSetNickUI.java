package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ay.g;
import com.tencent.mm.modelfriend.a;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.bindqq.BindQQUI;
import com.tencent.mm.ui.widget.MMEditText.c;
import com.tencent.mm.z.aq;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;

@Deprecated
public class RegByMobileSetNickUI extends MMActivity implements e {
    private String fAf;
    private ProgressDialog iln = null;
    private EditText xRb;
    private i xRc = null;
    private boolean xRd;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.xRd = getIntent().getBooleanExtra("is_sync_addr", false);
        this.fAf = getIntent().getExtras().getString("bindmcontact_mobile");
        initView();
        ar.CG().a(126, this);
    }

    public void onDestroy() {
        if (this.xRc != null) {
            i iVar = this.xRc;
            u uVar = iVar.xPT;
            uVar.cancel();
            uVar.fhK.TG();
            uVar.reset();
            iVar.text = null;
        }
        ar.CG().b(126, this);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dqF;
    }

    protected final void initView() {
        setMMTitle(R.l.eDO);
        this.xRb = (EditText) findViewById(R.h.cHs);
        this.xRb.addTextChangedListener(new c(this.xRb, null, 16));
        addTextOptionMenu(0, getString(R.l.dFl), new 1(this));
        setBackBtn(new 2(this));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.RegByMobileSetNickUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.iln != null) {
            this.iln.dismiss();
            this.iln = null;
        }
        if (!bh.bF(this)) {
            return;
        }
        if (i == 0 && i2 == 0) {
            int FW = q.FW();
            x.d("MicroMsg.RegByMobileSetNickUI", "Reg By mobile status = " + FW + " isSync = " + this.xRd);
            if (this.xRd) {
                FW &= -131073;
                m.NK();
                getApplicationContext();
                a.Nm();
            } else {
                FW |= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
            }
            x.d("MicroMsg.RegByMobileSetNickUI", "Reg By mobile update = " + FW);
            ar.Hg();
            com.tencent.mm.z.c.CU().set(7, Integer.valueOf(FW));
            if (this.xRd) {
                FW = 2;
            } else {
                FW = 1;
            }
            ar.Hg();
            com.tencent.mm.z.c.EX().b(new g(17, FW));
            com.tencent.mm.plugin.c.a.ift.um();
            aq.hfP.S("login_user_name", this.fAf);
            Intent at = com.tencent.mm.plugin.c.a.ifs.at(this);
            at.putExtra("LauncherUI.enter_from_reg", true);
            at.addFlags(67108864);
            if (((y) kVar).hNW) {
                MMWizardActivity.b(this, new Intent(this, BindQQUI.class).putExtra("bindqq_regbymobile", 1), at);
                return;
            } else {
                MMWizardActivity.b(this, new Intent(this, BindFacebookUI.class), at);
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
        if (!com.tencent.mm.plugin.c.a.ift.a(this.mController.xIM, i, i2, str)) {
            switch (i) {
                case 4:
                    if (i2 != -7 && i2 != -10) {
                        if (i2 == -75) {
                            h.h(this, R.l.dDG, R.l.eCW);
                            z = true;
                            break;
                        }
                    }
                    h.h(this, R.l.eCV, R.l.eCW);
                    z = true;
                    break;
                    break;
                default:
                    z = false;
                    break;
            }
        }
        z = true;
        if (!z) {
            Toast.makeText(this, getString(R.l.eiZ, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }
}
