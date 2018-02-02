package com.tencent.mm.plugin.soter.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.d.a.c.h;
import com.tencent.mm.plugin.ag.a$b;
import com.tencent.mm.plugin.ag.a.a;
import com.tencent.mm.ui.MMActivity;

public class SoterTestUI extends MMActivity {
    private Button rSA = null;
    private Button rSB = null;
    private Button rSC = null;
    private TextView rSD = null;
    private Button rSu = null;
    private Button rSv = null;
    private Button rSw = null;
    private Button rSx = null;
    private Button rSy = null;
    private Button rSz = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.rSu = (Button) findViewById(a.rSQ);
        this.rSv = (Button) findViewById(a.rSL);
        this.rSw = (Button) findViewById(a.rSP);
        this.rSx = (Button) findViewById(a.rSN);
        this.rSy = (Button) findViewById(a.rSK);
        this.rSz = (Button) findViewById(a.rSO);
        this.rSA = (Button) findViewById(a.rSM);
        this.rSB = (Button) findViewById(a.rSJ);
        this.rSC = (Button) findViewById(a.rSI);
        this.rSD = (TextView) findViewById(a.rSH);
        this.rSu.setOnClickListener(new 1(this));
        this.rSv.setOnClickListener(new 2(this));
        this.rSw.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SoterTestUI rSE;

            {
                this.rSE = r1;
            }

            public final void onClick(View view) {
                this.rSE.rSD.setText(com.tencent.d.a.a.cFK().isSuccess() ? "passed" : "not passed");
            }
        });
        this.rSx.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SoterTestUI rSE;

            {
                this.rSE = r1;
            }

            public final void onClick(View view) {
                h cFN = com.tencent.d.a.a.cFN();
                if (cFN == null) {
                    this.rSE.rSD.setText("not passed: no certificate");
                } else {
                    this.rSE.rSD.setText("model available: " + cFN.toString());
                }
            }
        });
        this.rSy.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SoterTestUI rSE;

            {
                this.rSE = r1;
            }

            public final void onClick(View view) {
                this.rSE.rSD.setText(com.tencent.d.a.a.abs("sample_auth_key_name").isSuccess() ? "pass" : "not passed");
            }
        });
        this.rSz.setOnClickListener(new 6(this));
        this.rSA.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SoterTestUI rSE;

            {
                this.rSE = r1;
            }

            public final void onClick(View view) {
                h abv = com.tencent.d.a.a.abv("sample_auth_key_name");
                if (abv == null) {
                    this.rSE.rSD.setText("not passed: no certificate");
                } else {
                    this.rSE.rSD.setText("model available: " + abv.toString());
                }
            }
        });
        this.rSB.setOnClickListener(new 8(this));
    }

    protected final int getLayoutId() {
        return a$b.rSR;
    }
}
