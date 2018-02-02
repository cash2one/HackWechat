package com.tencent.mm.plugin.chatroom.ui;

class SelectDateUI$1 implements Runnable {
    final /* synthetic */ SelectDateUI ldo;

    SelectDateUI$1(SelectDateUI selectDateUI) {
        this.ldo = selectDateUI;
    }

    public final void run() {
        SelectDateUI.a(this.ldo);
        SelectDateUI.f(this.ldo).post(new 1(this));
    }
}
