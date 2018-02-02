package com.tencent.mm.pluginsdk.ui;

class MultiSelectContactView$7 implements Runnable {
    final /* synthetic */ MultiSelectContactView vkE;

    MultiSelectContactView$7(MultiSelectContactView multiSelectContactView) {
        this.vkE = multiSelectContactView;
    }

    public final void run() {
        MultiSelectContactView.j(this.vkE).scrollTo(MultiSelectContactView.h(this.vkE).getMeasuredWidth(), 0);
    }
}
