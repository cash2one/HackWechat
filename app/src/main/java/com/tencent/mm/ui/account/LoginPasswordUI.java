package com.tencent.mm.ui.account;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

public class LoginPasswordUI extends LoginHistoryUI {
    private static String TAG = "LoginPasswordUI";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!this.xOO) {
            this.jge = 2;
            this.xON.setVisibility(0);
            this.xOr.setVisibility(0);
            this.lTk.setTypeface(Typeface.DEFAULT);
            this.lTk.setTransformationMethod(new PasswordTransformationMethod());
            this.lTk.setOnEditorActionListener(new 1(this));
            this.lTk.setOnKeyListener(new 2(this));
            this.lTk.addTextChangedListener(new 3(this));
            if (this.lTk.getText().toString().length() > 0) {
                this.xOr.setEnabled(true);
            } else {
                this.xOr.setEnabled(false);
            }
            this.xOr.setOnClickListener(new 4(this));
            this.pRM = getIntent().getStringExtra("auth_ticket");
            if (!bh.ov(this.pRM)) {
                this.xOq.setText(bh.ou(f.cnT()));
                this.lTk.setText(bh.ou(f.cnU()));
                new af().postDelayed(new 5(this), 500);
            }
        }
    }

    protected final void afF() {
        super.afF();
        if (isFinishing() || getWindow() == null) {
            x.e(TAG, "LoginHistoryUI is finishing");
            return;
        }
        this.xOA.xPo = this.lTk.getText().toString();
        if (this.xOA.hNv.equals("")) {
            h.h(this, R.l.eSP, R.l.etw);
        } else if (this.xOA.xPo.equals("")) {
            h.h(this, R.l.eSM, R.l.etw);
        } else {
            aWs();
            cnN();
            k vVar = new v(this.xOA.hNv, this.xOA.xPo, this.pRM, 0);
            ar.CG().a(vVar, 0);
            getString(R.l.dGO);
            this.iln = h.a((Context) this, getString(R.l.etF), true, new 6(this, vVar));
        }
    }
}
