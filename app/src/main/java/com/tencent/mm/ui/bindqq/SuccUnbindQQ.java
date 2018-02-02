package com.tencent.mm.ui.bindqq;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMWizardActivity;

public class SuccUnbindQQ extends MMWizardActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        initView();
    }

    protected final int getLayoutId() {
        return R.i.dsT;
    }

    protected final void initView() {
        setMMTitle(R.l.eRF);
        addTextOptionMenu(0, getString(R.l.dFl), new 1(this));
    }
}
