package com.tencent.mm.ui.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.modelfriend.t;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

public class RegByMobileVoiceVerifyUI extends MMActivity implements e {
    private String fAf;
    private TextView imw;
    private String pRQ;
    private String qjx;
    private String xOl;
    private s xRm;
    private t xRn;
    private int xRo = 0;

    static /* synthetic */ int d(RegByMobileVoiceVerifyUI regByMobileVoiceVerifyUI) {
        switch (regByMobileVoiceVerifyUI.xRo) {
            case 0:
                return 14;
            case 2:
                return 8;
            default:
                return 16;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fAf = getIntent().getExtras().getString("bindmcontact_mobile");
        this.xRo = getIntent().getExtras().getInt("voice_verify_type");
        if (this.xRo == 0 || this.xRo == 2 || this.xRo == 3) {
            ar.CG().a(c.CTRL_INDEX, this);
        } else if (this.xRo == 4 || this.xRo == 1) {
            ar.CG().a(132, this);
        }
        this.pRQ = b.Xn();
        initView();
    }

    protected void onResume() {
        super.onResume();
        if (this.xRo == 0 || this.xRo == 2 || this.xRo == 3) {
            b.b(true, ar.CB() + "," + getClass().getName() + ",R200_500," + ar.fH("R200_500") + ",1");
            b.oG("R200_500");
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        ar.CG().b(132, this);
        ar.CG().b(c.CTRL_INDEX, this);
        if (this.xRo == 0 || this.xRo == 2 || this.xRo == 3) {
            b.b(false, ar.CB() + "," + getClass().getName() + ",R200_500," + ar.fH("R200_500") + ",2");
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        b.oH(this.pRQ);
        aWs();
        finish();
        return true;
    }

    protected final void initView() {
        setMMTitle(R.l.dLL);
        setBackBtn(new 1(this));
        this.imw = (TextView) findViewById(R.h.csv);
        Button button = (Button) findViewById(R.h.bND);
        this.xOl = RegByMobileVoiceVerifySelectUI.YA(this.fAf);
        this.imw.setText(this.xOl);
        this.qjx = com.tencent.mm.ar.b.lH(this.fAf);
        findViewById(R.h.ctg).setOnClickListener(new 2(this));
        button.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RegByMobileVoiceVerifyUI xRp;

            {
                this.xRp = r1;
            }

            public final void onClick(View view) {
                if (this.xRp.xRo == 0 || this.xRp.xRo == 2 || this.xRp.xRo == 3) {
                    this.xRp.xRm = new s(this.xRp.fAf, RegByMobileVoiceVerifyUI.d(this.xRp), "", 1, this.xRp.qjx);
                    ar.CG().a(this.xRp.xRm, 0);
                    h.a(this.xRp, R.l.dLJ, R.l.dGO, new 1(this));
                } else if (this.xRp.xRo == 4 || this.xRp.xRo == 1) {
                    this.xRp.xRn = new t(this.xRp.fAf, 1, "", 1, this.xRp.qjx);
                    ar.CG().a(this.xRp.xRn, 0);
                    h.a(this.xRp, R.l.dLJ, R.l.dGO, new 2(this));
                }
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10000 && intent != null) {
            this.xOl = intent.getStringExtra("voice_verify_language");
            this.qjx = intent.getStringExtra("voice_verify_code");
            this.imw.setText(this.xOl);
        }
    }

    protected final int getLayoutId() {
        return R.i.dbk;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.RegByMobileVoiceVerifyUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
    }
}
