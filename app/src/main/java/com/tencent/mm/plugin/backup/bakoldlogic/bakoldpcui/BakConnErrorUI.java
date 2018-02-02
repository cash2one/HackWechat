package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;

public class BakConnErrorUI extends MMWizardActivity {
    private int krK;

    protected final int getLayoutId() {
        return R.i.daU;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            this.krK = getIntent().getIntExtra("cmd", -1);
            x.i("MicroMsg.BakFinishUI", "BakConnErrorUI onCreate nowCmd:%d", new Object[]{Integer.valueOf(this.krK)});
            initView();
            a.aql().aqm().krc = -1;
        }
    }

    protected final void initView() {
        setMMTitle(R.l.dKm);
        setBackBtn(new 1(this));
    }

    public void onDestroy() {
        super.onDestroy();
        a.aql().aqm().kqU = null;
        x.i("MicroMsg.BakFinishUI", "BakConnErrorUI onDestroy nowCmd:%d", new Object[]{Integer.valueOf(this.krK)});
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        DU(1);
        return true;
    }
}
