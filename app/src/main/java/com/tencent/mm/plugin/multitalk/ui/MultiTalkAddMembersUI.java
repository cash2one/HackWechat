package com.tencent.mm.plugin.multitalk.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.multitalk.ui.widget.b;

public class MultiTalkAddMembersUI extends MultiTalkSelectContactUI {
    protected final void initView() {
        super.initView();
        this.ooa.setBackgroundResource(R.e.brX);
        this.ooa.setPadding(b.oHW, b.oHW, b.oHW, 0);
    }
}
