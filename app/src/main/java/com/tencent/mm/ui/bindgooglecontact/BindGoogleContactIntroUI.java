package com.tencent.mm.ui.bindgooglecontact;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ap.a;
import com.tencent.mm.modelfriend.n;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.rtmp.TXLiveConstants;

public class BindGoogleContactIntroUI extends MMActivity implements e {
    private int jxi;
    private ProgressDialog ltM;
    private ImageView ykl;
    private TextView ykm;
    private Button ykn;
    private Button yko;
    private boolean ykp = false;
    private boolean ykq = false;
    private String ykr;
    private a yks;
    private OnClickListener ykt = new 1(this);
    private OnClickListener yku = new 2(this);

    static /* synthetic */ void b(BindGoogleContactIntroUI bindGoogleContactIntroUI) {
        bindGoogleContactIntroUI.yks = new a(a.a.hyZ, bindGoogleContactIntroUI.ykr, a.hyS);
        ar.CG().a(bindGoogleContactIntroUI.yks, 0);
        bindGoogleContactIntroUI.getString(R.l.dGO);
        bindGoogleContactIntroUI.ltM = h.a(bindGoogleContactIntroUI, bindGoogleContactIntroUI.getString(R.l.dHc), true, new 4(bindGoogleContactIntroUI));
    }

    protected final int getLayoutId() {
        return R.i.dbd;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.dKC);
        this.jxi = getIntent().getIntExtra("enter_scene", 0);
        this.ykp = n.bj(this);
        if (this.ykp) {
            startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), TXLiveConstants.PLAY_EVT_PLAY_PROGRESS);
        }
    }

    protected void onResume() {
        super.onResume();
        ar.Hg();
        this.ykr = (String) c.CU().get(208903, null);
        if (TextUtils.isEmpty(this.ykr)) {
            this.ykq = false;
        } else {
            this.ykq = true;
        }
        initView();
        if (this.ykq) {
            this.yko.setVisibility(0);
            this.ykn.setVisibility(8);
            this.ykm.setVisibility(0);
            this.ykm.setText(getString(R.l.dKA, new Object[]{this.ykr}));
            this.yko.setOnClickListener(this.yku);
        } else {
            cqt();
        }
        ar.CG().a(487, this);
    }

    protected void onStop() {
        super.onStop();
        ar.CG().b(487, this);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final void initView() {
        setBackBtn(new 3(this));
        this.ykl = (ImageView) findViewById(R.h.cLQ);
        this.ykm = (TextView) findViewById(R.h.cLR);
        this.ykn = (Button) findViewById(R.h.cLP);
        this.yko = (Button) findViewById(R.h.cMe);
    }

    private void cqt() {
        this.yko.setVisibility(8);
        this.ykn.setVisibility(0);
        this.ykl.setVisibility(0);
        this.ykm.setVisibility(0);
        this.ykm.setText(R.l.dKB);
        this.ykn.setText(R.l.dKz);
        this.ykn.setOnClickListener(this.ykt);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "requestCode:%d, resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            if (i == TXLiveConstants.PLAY_EVT_PLAY_PROGRESS) {
                this.ykp = intent.getBooleanExtra("gpservices", false);
            }
        } else if (i == TXLiveConstants.PLAY_EVT_PLAY_PROGRESS) {
            this.ykp = intent.getBooleanExtra("gpservices", false);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = "MicroMsg.GoogleContact.BindGoogleContactIntroUI";
        String str3 = "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        objArr[2] = str;
        x.i(str2, str3, objArr);
        if (this.ltM != null && this.ltM.isShowing()) {
            this.ltM.dismiss();
        }
        if (i == 0 && i2 == 0) {
            ar.Hg();
            c.CU().set(208903, "");
            ar.Hg();
            c.CU().set(208901, "");
            ar.Hg();
            c.CU().set(208902, "");
            ar.Hg();
            c.CU().set(208905, Boolean.valueOf(true));
            ar.Hg();
            c.CU().lH(true);
            cqt();
            h.bu(this, getString(R.l.eRE));
            return;
        }
        x.i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "unbind failed");
        Toast.makeText(this, R.l.enx, 0).show();
    }
}
