package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class SettingDeleteAccountInputPassUI extends MMActivity {
    protected final int getLayoutId() {
        return R.i.drV;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.eKj);
        initView();
    }

    protected final void initView() {
        setBackBtn(new 1(this));
        addTextOptionMenu(0, getString(R.l.dFl), new 2(this));
    }
}
