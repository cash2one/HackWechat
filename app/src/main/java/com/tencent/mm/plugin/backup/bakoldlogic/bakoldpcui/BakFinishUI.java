package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;

public class BakFinishUI extends MMWizardActivity implements e {
    private af handler = new af(Looper.getMainLooper());
    private int krK;
    private TextView krM;

    protected final int getLayoutId() {
        return R.i.daV;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            this.krK = getIntent().getIntExtra("cmd", -1);
            x.i("MicroMsg.BakFinishUI", "BakFinishUI onCreate nowCmd:%d", new Object[]{Integer.valueOf(this.krK)});
            initView();
            a.aql().aqm().kqU = this;
        }
    }

    protected final void initView() {
        setMMTitle(R.l.dKm);
        this.krM = (TextView) findViewById(R.h.bMu);
        if (6 == this.krK) {
            this.krM.setText(getString(R.l.dKl));
        } else if (1 == this.krK) {
            this.krM.setText(getString(R.l.dKe));
        }
        setBackBtn(new 1(this));
    }

    public void onDestroy() {
        super.onDestroy();
        a.aql().aqm().kqU = null;
        x.i("MicroMsg.BakFinishUI", "BakFinishUI onDestroy nowCmd:%d", new Object[]{Integer.valueOf(this.krK)});
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        a.aql().aqm().krc = -1;
        DU(1);
        return true;
    }

    public final void aqB() {
        this.handler.post(new 2(this));
    }

    public final void onError(int i) {
        this.handler.post(new 3(this));
    }
}
