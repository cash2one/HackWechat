package com.tencent.mm.ui.account;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.MMWebView;

@a(3)
public class ShowAgreementsUI extends MMActivity {
    private String countryCode;
    private TextView kmC;
    private MMWebView sRe;
    private TextView sRf;
    private TextView sRg;
    private int type;
    private String xSD;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        getSupportActionBar().hide();
        overridePendingTransition(R.a.bqo, R.a.bpQ);
        this.type = getIntent().getIntExtra("agreement_type", 0);
        this.countryCode = getIntent().getStringExtra("country_code");
        this.kmC = (TextView) findViewById(R.h.bJJ);
        this.sRe = MMWebView.a.a(this, this.mController.contentView, R.h.bJL);
        this.sRe.getSettings().setJavaScriptEnabled(true);
        this.sRf = (TextView) findViewById(R.h.bJK);
        this.sRg = (TextView) findViewById(R.h.bJH);
        this.xSD = getIntent().getStringExtra("disagree_tip");
        if (bh.ov(this.xSD)) {
            this.xSD = getString(R.l.esN);
        }
        if (this.type == 0) {
            this.kmC.setVisibility(0);
            this.kmC.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ShowAgreementsUI xSE;

                {
                    this.xSE = r1;
                }

                public final void onClick(View view) {
                    g.pQN.a(712, 1, 1, false);
                    this.xSE.finish();
                }
            });
            this.sRg.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ShowAgreementsUI xSE;

                {
                    this.xSE = r1;
                }

                public final void onClick(View view) {
                    g.pQN.a(712, 2, 1, false);
                    this.xSE.setResult(-1);
                    this.xSE.finish();
                }
            });
            this.sRf.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ShowAgreementsUI xSE;

                {
                    this.xSE = r1;
                }

                public final void onClick(View view) {
                    g.pQN.a(712, 1, 1, false);
                    this.xSE.finish();
                }
            });
            g.pQN.a(712, 0, 1, false);
        } else if (this.type == 1) {
            this.sRg.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ShowAgreementsUI xSE;

                {
                    this.xSE = r1;
                }

                public final void onClick(View view) {
                    g.pQN.a(712, 5, 1, false);
                    this.xSE.setResult(102001);
                    this.xSE.finish();
                }
            });
            this.sRf.setOnClickListener(new 5(this));
            g.pQN.a(712, 3, 1, false);
        }
        if (bh.ov(this.countryCode)) {
            this.countryCode = w.cfh();
        }
        if (this.countryCode.equals("CN")) {
            this.sRe.loadUrl(getString(R.l.esR, new Object[]{w.cfi(), this.countryCode}));
            return;
        }
        this.sRe.loadUrl(getString(R.l.esQ));
    }

    protected final int getLayoutId() {
        return R.i.dsB;
    }

    public void finish() {
        x.i("MicroMsg.ShowAgreementsUI", "onRefreshed");
        super.finish();
        overridePendingTransition(R.a.bpQ, R.a.bqm);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
