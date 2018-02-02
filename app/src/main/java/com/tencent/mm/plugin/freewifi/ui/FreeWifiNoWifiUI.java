package com.tencent.mm.plugin.freewifi.ui;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiNoWifiUI extends MMActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new 1(this));
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final int getLayoutId() {
        return R.i.diC;
    }
}
