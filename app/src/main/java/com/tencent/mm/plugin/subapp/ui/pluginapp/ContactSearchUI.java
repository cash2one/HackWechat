package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.protocal.c.bem;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

public class ContactSearchUI extends MMActivity implements e {
    private ProgressDialog iln = null;
    private EditText rYv;

    protected final int getLayoutId() {
        return R.i.deY;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected void onResume() {
        ar.CG().a(106, (e) this);
        super.onResume();
    }

    protected void onPause() {
        ar.CG().b(106, (e) this);
        super.onPause();
    }

    protected final void initView() {
        setMMTitle(R.l.dXo);
        this.rYv = (EditText) findViewById(R.h.bYr);
        this.rYv.addTextChangedListener(new 1(this));
        this.rYv.setImeOptions(3);
        this.rYv.setOnEditorActionListener(new 2(this));
        addTextOptionMenu(0, getString(R.l.dFk), new 3(this));
        setBackBtn(new 4(this));
        if (getIntent().getBooleanExtra("from_webview", false)) {
            this.rYv.setText(getIntent().getStringExtra("userName"));
            bEi();
        }
    }

    private void bEi() {
        String trim = this.rYv.getText().toString().trim();
        if (trim == null || trim.length() <= 0) {
            h.h(this.mController.xIM, R.l.eSK, R.l.dGO);
            return;
        }
        x.d("MicroMsg.ContactSearchUI", "always search contact from internet!!!");
        k acVar = new ac(trim, 1);
        ar.CG().a(acVar, 0);
        Context context = this.mController.xIM;
        getString(R.l.dGO);
        this.iln = h.a(context, getString(R.l.dDg), true, new 5(this, acVar));
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.ContactSearchUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.iln != null) {
            this.iln.dismiss();
            this.iln = null;
        }
        if (!b.ift.b(this.mController.xIM, i, i2, str)) {
            if (i == 4 && i2 == -4) {
                h.h(this.mController.xIM, R.l.dDd, R.l.dGO);
            } else if (i == 0 && i2 == 0) {
                bem So = ((ac) kVar).So();
                if (So.wkk > 0) {
                    Intent intent = new Intent();
                    intent.setClass(this, ContactSearchResultUI.class);
                    try {
                        intent.putExtra("result", So.toByteArray());
                        startActivity(intent);
                        return;
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.ContactSearchUI", e, "", new Object[0]);
                        return;
                    }
                }
                String a = n.a(So.vYI);
                Intent intent2 = new Intent();
                ((j) g.h(j.class)).a(intent2, So, Mn(this.rYv.getText().toString().trim()));
                if (bh.ou(a).length() > 0) {
                    if ((So.wvf & 8) > 0) {
                        com.tencent.mm.plugin.report.service.g.pQN.k(10298, a + "," + Mn(this.rYv.getText().toString().trim()));
                    }
                    d.b(this, "profile", ".ui.ContactInfoUI", intent2);
                }
            } else {
                Toast.makeText(this, getString(R.l.ejf), 0).show();
                x.w("MicroMsg.ContactSearchUI", getString(R.l.eje, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
            }
        }
    }

    private static int Mn(String str) {
        if (bh.Vs(str)) {
            return 1;
        }
        if (bh.Vt(str)) {
            return 2;
        }
        return bh.Vu(str) ? 3 : 3;
    }
}
