package com.tencent.mm.pluginsdk.ui;

import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.6;

class MultiSelectContactView$6$1 implements Runnable {
    final /* synthetic */ 6 vkF;

    MultiSelectContactView$6$1(6 6) {
        this.vkF = 6;
    }

    public final void run() {
        MultiSelectContactView.h(this.vkF.vkE).removeView(this.vkF.zS);
        MultiSelectContactView.i(this.vkF.vkE);
        MultiSelectContactView.a(this.vkF.vkE, MultiSelectContactView.h(this.vkF.vkE).getChildCount());
    }
}
