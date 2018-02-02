package com.tencent.mm.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class MMAppMgr$12 implements OnCheckedChangeListener {
    MMAppMgr$12() {
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        ar.Hg();
        c.CU().set(61, Boolean.valueOf(z));
    }
}
