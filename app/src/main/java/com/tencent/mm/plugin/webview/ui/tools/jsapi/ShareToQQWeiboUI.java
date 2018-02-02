package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText.c;
import com.tencent.mm.z.ar;

public class ShareToQQWeiboUI extends MMActivity implements e {
    private ProgressDialog iln = null;
    private EditText pqM;
    private TextView qgF;

    protected final int getLayoutId() {
        return R.i.dfy;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.CG().a(26, this);
        initView();
    }

    public void onDestroy() {
        ar.CG().b(26, this);
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.ePk);
        this.pqM = (EditText) findViewById(R.h.content);
        this.qgF = (TextView) findViewById(R.h.cZH);
        String stringExtra = getIntent().getStringExtra("content");
        Object stringExtra2 = getIntent().getStringExtra("shortUrl");
        this.pqM.addTextChangedListener(new c(this.pqM, this.qgF, 280));
        if (stringExtra.contains(stringExtra2)) {
            this.pqM.setText(stringExtra.trim());
        } else {
            this.pqM.setText(stringExtra + " " + stringExtra2);
        }
        setBackBtn(new 1(this));
        addTextOptionMenu(0, getString(R.l.dGE), new 2(this));
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.ShareToQQWeiboUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (kVar.getType() == 26) {
            if (this.iln != null) {
                this.iln.dismiss();
                this.iln = null;
            }
            if (i == 0 && i2 == 0) {
                aWs();
                setResult(-1);
                finish();
                return;
            }
            setResult(1, new Intent().putExtra("err_code", i2));
            Toast.makeText(this, getString(R.l.ePh, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }
}
