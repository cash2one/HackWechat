package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a$a;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.MMWebView;

@a(3)
public class ShowWxPayAgreementsUI extends MMActivity {
    private String content;
    private MMWebView sRe;
    private TextView sRf;
    private TextView sRg;
    private int type;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        g.pQN.h(15236, Integer.valueOf(1));
        getSupportActionBar().hide();
        overridePendingTransition(a$a.bqo, a$a.bpQ);
        this.type = getIntent().getIntExtra("agreement_type", 0);
        this.sRe = MMWebView.a.a(this, this.mController.contentView, a$f.bJL);
        this.sRe.getSettings().setJavaScriptEnabled(true);
        this.sRf = (TextView) findViewById(a$f.bJK);
        this.sRg = (TextView) findViewById(a$f.bJH);
        this.content = getIntent().getStringExtra("agreement_content");
        this.sRg.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ShowWxPayAgreementsUI sRh;

            {
                this.sRh = r1;
            }

            public final void onClick(View view) {
                g.pQN.h(15236, Integer.valueOf(2));
                this.sRh.setResult(-1);
                this.sRh.finish();
            }
        });
        this.sRf.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ShowWxPayAgreementsUI sRh;

            {
                this.sRh = r1;
            }

            public final void onClick(View view) {
                g.pQN.h(15236, Integer.valueOf(3));
                this.sRh.finish();
            }
        });
        this.sRe.setWebViewClient(new e(this));
        this.sRe.loadData(this.content, "text/html; charset=UTF-8", null);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uEi;
    }

    public void finish() {
        x.i("MicroMsg.ShowWxPayAgreementsUI", "onRefreshed");
        super.finish();
        overridePendingTransition(a$a.bpQ, a$a.bqm);
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
