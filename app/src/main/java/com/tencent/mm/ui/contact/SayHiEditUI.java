package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.e.a;
import com.tencent.mm.ui.p.b;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import org.xwalk.core.XWalkUpdater;

public class SayHiEditUI extends MMActivity implements e {
    private ProgressDialog iln = null;
    private MMEditText yUb;

    static /* synthetic */ String a(SayHiEditUI sayHiEditUI) {
        String trim = sayHiEditUI.yUb.getText().toString().trim();
        return trim.length() <= 50 ? trim : trim.substring(0, 50);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.CG().a(30, this);
        setMMTitle(R.l.exm);
        initView();
    }

    protected final int getLayoutId() {
        return R.i.dqR;
    }

    public void onDestroy() {
        ar.CG().b(30, this);
        super.onDestroy();
    }

    protected final void initView() {
        this.yUb = (MMEditText) findViewById(R.h.cIG);
        this.yUb.addTextChangedListener(new a((byte) 0));
        c.d(this.yUb).GN(100).a(null);
        a(0, getString(R.l.dGA), new 1(this, getIntent().getStringExtra("Contact_User"), getIntent().getIntExtra("Contact_Scene", 18), getIntent().getStringExtra(a.xEi)), b.xJz);
        setBackBtn(new 2(this));
    }

    public final void a(int i, int i2, String str, k kVar) {
        Object obj = 1;
        x.i("MicroMsg.SayHiEditUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        try {
            if (this.iln != null) {
                this.iln.dismiss();
                this.iln = null;
            }
            switch (i2) {
                case -34:
                case DownloadResult.CODE_CONNECTION_EXCEPTION /*-24*/:
                    Toast.makeText(this, R.l.exp, 0).show();
                    break;
                case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
                    Toast.makeText(this, R.l.exn, 0).show();
                    break;
                default:
                    obj = null;
                    break;
            }
            if (obj == null) {
                if (i == 0 && i2 == 0) {
                    h.bu(this, getString(R.l.dUd));
                    finish();
                } else if (i == 4 && i2 == -24 && !t.ov(str)) {
                    Toast.makeText(this, str, 1).show();
                } else if (i2 != XWalkUpdater.ERROR_SET_VERNUM || t.ov(str)) {
                    Toast.makeText(this, R.l.exo, 0).show();
                } else {
                    h.a(this, str, getString(R.l.dGO), getString(R.l.dFU), null);
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.SayHiEditUI", "exception in onSceneEnd : " + e.getMessage());
        }
    }
}
