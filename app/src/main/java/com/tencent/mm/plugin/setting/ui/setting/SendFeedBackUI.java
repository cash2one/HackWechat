package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

public class SendFeedBackUI extends MMActivity implements e {
    private ProgressDialog iln = null;
    private EditText pqM;
    private TextView qhH = null;

    protected final int getLayoutId() {
        return R.i.dfA;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onDestroy() {
        ar.CG().b(153, this);
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.eLt);
        this.pqM = (EditText) findViewById(R.h.content);
        String stringExtra = getIntent().getStringExtra("intentKeyFrom");
        if (stringExtra != null && stringExtra.equals("fromEnjoyAppDialog")) {
            this.qhH = (TextView) findViewById(R.h.cVO);
            this.qhH.setVisibility(0);
            this.qhH.setOnClickListener(new 1(this));
        }
        setBackBtn(new 2(this));
        addTextOptionMenu(0, getString(R.l.dGA), new 3(this));
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.iln != null) {
            this.iln.dismiss();
            this.iln = null;
        }
        if (i == 0 && i2 == 0) {
            h.a(this, getString(R.l.eLs), getString(R.l.dGO), new 4(this));
        } else {
            h.a(this, getString(R.l.eLr), getString(R.l.dGO), new 5(this));
        }
    }
}
