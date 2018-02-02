package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.widget.EditText;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.ag;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class RegByFacebookSetPwdUI extends SetPwdUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.frP = getIntent().getStringExtra("setpwd_ticket");
        setMMTitle(R.l.eDC);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dqC;
    }

    protected final void initView() {
        setMMTitle(R.l.eDC);
    }

    protected final ProgressDialog a(Context context, String str, String str2, OnCancelListener onCancelListener) {
        return h.a(context, getString(R.l.eDx), true, onCancelListener);
    }

    protected final k a(String str, String str2, bdn com_tencent_mm_protocal_c_bdn) {
        return new ag(str);
    }

    protected final String cnW() {
        return ((EditText) findViewById(R.h.cHo)).getText().toString();
    }

    protected final String cnX() {
        return ((EditText) findViewById(R.h.cHn)).getText().toString();
    }

    protected final int cnY() {
        return 382;
    }

    protected final void Eg(int i) {
        switch (2.xQc[i - 1]) {
            case 1:
                h.h(this, R.l.eDt, R.l.eDv);
                return;
            case 2:
                h.h(this, R.l.eDu, R.l.eDv);
                return;
            case 3:
                h.h(this, R.l.eSL, R.l.dEN);
                return;
            case 4:
                h.h(this, R.l.eSN, R.l.dEN);
                return;
            default:
                return;
        }
    }

    protected final boolean s(int i, int i2, String str) {
        if (i != 0 || i2 != 0) {
            return o(i, i2, str);
        }
        ar.Hg();
        c.CU().set(57, Integer.valueOf(0));
        ar.Hg();
        String str2 = (String) c.CU().get(5, null);
        h.a(this, getString(R.l.eDB, new Object[]{str2}), getString(R.l.eDv), new 1(this));
        return true;
    }
}
