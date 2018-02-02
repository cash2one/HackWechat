package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelfriend.u;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoCompleteTextView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import java.util.Map;

public class RegByEmailUI extends MMActivity implements e {
    private static String[] xPZ;
    private String fWi;
    private ProgressDialog iln = null;
    private String pRQ;
    private MMAutoCompleteTextView xPU;
    private EditText xPV;
    private CheckBox xPW;
    private String xPX;
    private Map<String, String> xPY;
    private String xPo;

    static /* synthetic */ void b(RegByEmailUI regByEmailUI) {
        if (bh.ov(regByEmailUI.xPU.getText().toString().trim()) || bh.ov(regByEmailUI.xPV.getText().toString().trim()) || !regByEmailUI.xPW.isChecked()) {
            regByEmailUI.enableOptionMenu(false);
        } else {
            regByEmailUI.enableOptionMenu(true);
        }
    }

    static /* synthetic */ void c(RegByEmailUI regByEmailUI) {
        regByEmailUI.fWi = regByEmailUI.xPU.getText().toString().trim();
        regByEmailUI.xPo = regByEmailUI.xPV.getText().toString();
        if (bh.ov(regByEmailUI.fWi)) {
            h.h(regByEmailUI, R.l.eDg, R.l.eDc);
        } else if (!bh.Vt(regByEmailUI.fWi)) {
            h.h(regByEmailUI, R.l.eDf, R.l.eDc);
        } else if (bh.ov(regByEmailUI.xPo)) {
            h.h(regByEmailUI, R.l.eDh, R.l.eDc);
        } else if (bh.Vv(regByEmailUI.xPo)) {
            regByEmailUI.aWs();
            k uVar = new u(regByEmailUI.fWi, regByEmailUI.xPo);
            ar.CG().a(uVar, 0);
            regByEmailUI.getString(R.l.dGO);
            regByEmailUI.iln = h.a((Context) regByEmailUI, regByEmailUI.getString(R.l.dHc), true, new 3(regByEmailUI, uVar));
        } else {
            h.h(regByEmailUI, R.l.eSN, R.l.eDc);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getString(R.l.eDl);
        if (d.vAC) {
            string = getString(R.l.app_name) + getString(R.l.dDD);
        }
        setMMTitle(string);
        a.ift.up();
        this.xPX = com.tencent.mm.modelsimple.d.bx(this);
        x.i("MicroMsg.RegByEmailUI", "get google account:[%s]", new Object[]{this.xPX});
        this.xPY = com.tencent.mm.plugin.accountsync.b.a.ikR.bI(this);
        if (!(this.xPY == null || this.xPY.isEmpty())) {
            xPZ = new String[this.xPY.size()];
            this.xPY.keySet().toArray(xPZ);
        }
        this.pRQ = b.Xn();
        initView();
    }

    protected void onResume() {
        super.onResume();
        ar.CG().a(481, this);
        b.b(true, ar.CB() + "," + getClass().getName() + ",R500_100," + ar.fH("R500_100") + ",1");
        b.oG("R500_100");
    }

    protected void onPause() {
        super.onPause();
        ar.CG().b(481, this);
        b.b(false, ar.CB() + "," + getClass().getName() + ",R500_100," + ar.fH("R500_100") + ",2");
    }

    protected final int getLayoutId() {
        return R.i.dqA;
    }

    protected final void initView() {
        this.xPU = (MMAutoCompleteTextView) findViewById(R.h.cHf);
        this.xPV = (EditText) findViewById(R.h.cHl);
        this.xPW = (CheckBox) findViewById(R.h.bJD);
        if (!bh.ov(this.xPX)) {
            this.xPV.postDelayed(new 1(this), 500);
            this.xPU.setText(this.xPX);
        }
        if (xPZ != null) {
            ListAdapter cVar = new c(this, xPZ, "@");
            MMAutoCompleteTextView mMAutoCompleteTextView = this.xPU;
            String str = "@";
            if (!bh.ov(str)) {
                mMAutoCompleteTextView.xZt = new MMAutoCompleteTextView.a(mMAutoCompleteTextView, str);
                mMAutoCompleteTextView.addTextChangedListener(mMAutoCompleteTextView.xZt);
            }
            this.xPU.setDropDownAnchor(R.h.cHg);
            this.xPU.setDropDownVerticalOffset(this.xPU.getPaddingBottom());
            this.xPU.setAdapter(cVar);
        }
        findViewById(R.h.bJC).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RegByEmailUI xQa;

            {
                this.xQa = r1;
            }

            public final void onClick(View view) {
                bh.F(this.xQa, this.xQa.getString(R.l.eSl));
            }
        });
        this.xPW.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ RegByEmailUI xQa;

            {
                this.xQa = r1;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                RegByEmailUI.b(this.xQa);
            }
        });
        addTextOptionMenu(0, getString(R.l.dFQ), new OnMenuItemClickListener(this) {
            final /* synthetic */ RegByEmailUI xQa;

            {
                this.xQa = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                RegByEmailUI.c(this.xQa);
                return true;
            }
        });
        enableOptionMenu(false);
        this.xPU.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ RegByEmailUI xQa;

            {
                this.xQa = r1;
            }

            public final void afterTextChanged(Editable editable) {
                RegByEmailUI.b(this.xQa);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.xPV.addTextChangedListener(new 9(this));
        this.xPV.setOnEditorActionListener(new 10(this));
        this.xPV.setOnKeyListener(new 11(this));
        setBackBtn(new 12(this));
    }

    private void goBack() {
        h.a((Context) this, R.l.eCZ, R.l.eDc, R.l.dFU, R.l.dEn, new 2(this), null);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.RegByEmailUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.iln != null && this.iln.isShowing()) {
            this.iln.dismiss();
            this.iln = null;
        }
        if (kVar.getType() != 481) {
            x.e("MicroMsg.RegByEmailUI", "error cgi type callback:[%d]", new Object[]{Integer.valueOf(kVar.getType())});
        } else if (i == 0 && i2 == 0) {
            b.oH("R500_200");
            Intent intent = new Intent(this, EmailVerifyUI.class);
            intent.putExtra("email_address", this.fWi);
            intent.putExtra("password", this.xPo);
            if (!(this.xPY == null || this.xPY.isEmpty())) {
                String[] split = this.fWi.split("@");
                if (split != null && split.length == 2) {
                    intent.putExtra("email_login_page", (String) this.xPY.get(split[1]));
                }
            }
            startActivity(intent);
        } else {
            boolean z;
            if (!a.ift.a(this, i, i2, str)) {
                switch (i2) {
                    case -111:
                        h.h(this, R.l.eDf, R.l.eDc);
                        z = true;
                        break;
                    case -75:
                        h.h(this, R.l.dDG, R.l.eCW);
                        z = true;
                        break;
                    case -34:
                        Toast.makeText(this, R.l.eDa, 0).show();
                        z = true;
                        break;
                    case -7:
                        b.oI(ar.CB() + "," + getClass().getName() + ",R20_email_duplicate_confirm," + ar.fH("R20_email_duplicate_confirm") + ",3");
                        h.a((Context) this, R.l.eDm, R.l.eDc, R.l.eDo, R.l.eDn, new 4(this), null);
                        z = true;
                        break;
                    default:
                        z = false;
                        break;
                }
            }
            z = true;
            if (!z) {
                if (!bh.ov(str)) {
                    Map y = bi.y(str, "e");
                    if (y != null && y.size() > 0) {
                        String str2 = (String) y.get(".e.Content");
                        if (!bh.ov(str2)) {
                            h.b(this, str2, getString(R.l.eDc), true);
                            return;
                        }
                    }
                }
                Toast.makeText(this, getString(R.l.eDj, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        }
    }
}
