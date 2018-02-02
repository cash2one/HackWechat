package com.tencent.mm.ui;

class HomeUI$2 implements Runnable {
    final /* synthetic */ HomeUI xGv;

    HomeUI$2(HomeUI homeUI) {
        this.xGv = homeUI;
    }

    public final void run() {
        HomeUI.d(this.xGv).supportInvalidateOptionsMenu();
    }

    public final String toString() {
        return super.toString() + "|supportInvalidateOptionsMenu";
    }
}
