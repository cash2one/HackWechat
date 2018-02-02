package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;

public class BakToPcUI extends MMWizardActivity implements a {
    private af handler = new af(Looper.getMainLooper());
    private Button krY;
    private Button krZ;
    private TextView ksa;
    private TextView ksb;
    private int pK = -1;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            initView();
            this.pK = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aql().aqm().kqZ;
            x.i("MicroMsg.BakToPcUI", "BakToPcUI auth onCreate nowCmd:%d", new Object[]{Integer.valueOf(this.pK)});
            com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aql().aqm().kqT = this;
            aqH();
        }
    }

    public final void initView() {
        setMMTitle(R.l.dKm);
        setBackBtn(new 1(this));
        this.krY = (Button) findViewById(R.h.bMv);
        this.krY.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BakToPcUI ksc;

            {
                this.ksc = r1;
            }

            public final void onClick(View view) {
                if (this.ksc.pK == 0) {
                    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aql().aqn().hgg = 1;
                    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aql().aqm().mR(0);
                    MMWizardActivity.A(this.ksc, new Intent(this.ksc, BakWaitingUI.class));
                }
            }
        });
        this.krZ = (Button) findViewById(R.h.bMt);
        this.krZ.setOnClickListener(new 3(this));
        this.ksa = (TextView) findViewById(R.h.bMz);
        this.ksa.setText(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aql().aqm().kra);
        this.ksb = (TextView) findViewById(R.h.bMA);
        this.ksb.setText(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aql().aqm().krb);
    }

    protected final int getLayoutId() {
        return R.i.daT;
    }

    public void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.BakToPcUI", "BakToPcUI auth onDestroy nowCmd:%d", new Object[]{Integer.valueOf(this.pK)});
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aql().aqm().kqT = null;
    }

    public final void aqy() {
        this.pK = 0;
        this.krY.setVisibility(0);
        this.krZ.setVisibility(0);
        new af(Looper.getMainLooper()).post(new 4(this));
    }

    private void aqH() {
        if (this.pK == 0) {
            this.krY.setEnabled(true);
            this.krZ.setEnabled(true);
            return;
        }
        this.krY.setEnabled(false);
        this.krZ.setEnabled(false);
    }

    public final void onError(int i) {
        this.handler.post(new 5(this, i));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aql().aqn().hgg = 3;
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aql().aqn().HT();
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aql().aqm().mR(1);
        DU(1);
        return true;
    }
}
