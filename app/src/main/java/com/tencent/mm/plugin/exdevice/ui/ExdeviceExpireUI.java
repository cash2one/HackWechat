package com.tencent.mm.plugin.exdevice.ui;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class ExdeviceExpireUI extends MMActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.edH);
        setBackBtn(new 1(this));
    }

    protected final int getLayoutId() {
        return R.i.dgK;
    }
}
