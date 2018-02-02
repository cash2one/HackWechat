package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class SettingDeleteAccountUI extends MMActivity {
    protected final int getLayoutId() {
        return R.i.drT;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.eKj);
        initView();
    }

    protected final void initView() {
        setBackBtn(new 1(this));
        ((TextView) findViewById(R.h.caM)).setOnClickListener(new 2(this));
    }
}
