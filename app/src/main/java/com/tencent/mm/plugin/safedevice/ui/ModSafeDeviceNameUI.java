package com.tencent.mm.plugin.safedevice.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.safedevice.a.f;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMEditText.b;
import com.tencent.mm.ui.widget.MMEditText.c;
import com.tencent.mm.z.ar;

public class ModSafeDeviceNameUI extends MMActivity implements e {
    private String frg;
    private long hVE;
    private ProgressDialog iln = null;
    private String lad;
    private EditText pRo;
    private String pRp;
    private String pRq;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected void onResume() {
        ar.CG().a(361, (e) this);
        super.onResume();
    }

    protected void onPause() {
        ar.CG().b(361, (e) this);
        super.onPause();
    }

    protected final void initView() {
        this.pRp = getIntent().getStringExtra("safe_device_name");
        this.pRq = getIntent().getStringExtra("safe_device_uid");
        this.frg = getIntent().getStringExtra("safe_device_type");
        setMMTitle(a.ac(this, R.l.eGP));
        setBackBtn(new 1(this));
        addTextOptionMenu(0, getString(R.l.dGx), new 2(this));
        b 3 = new 3(this);
        this.pRo = (EditText) findViewById(R.h.cwY);
        TextWatcher cVar = new c(this.pRo, null, 32);
        cVar.ztR = 3;
        this.pRo.addTextChangedListener(cVar);
        if (bh.ov(this.pRp)) {
            enableOptionMenu(false);
        } else {
            this.pRo.setText(this.pRp);
        }
    }

    protected final int getLayoutId() {
        return R.i.cwY;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.iln != null && this.iln.isShowing()) {
            this.iln.dismiss();
            this.iln = null;
        }
        if (i == 0 && i2 == 0) {
            com.tencent.mm.sdk.e.c cVar = new com.tencent.mm.plugin.safedevice.a.c();
            cVar.field_devicetype = this.frg;
            cVar.field_name = this.lad;
            cVar.field_uid = this.pRq;
            cVar.field_createtime = this.hVE;
            f.bos().c(cVar, new String[0]);
            h.bu(this, a.ac(this, R.l.eGT));
            new af().postDelayed(new 4(this), 1000);
        } else if (!com.tencent.mm.plugin.c.a.ift.a(this, i, i2, str)) {
        }
    }
}
