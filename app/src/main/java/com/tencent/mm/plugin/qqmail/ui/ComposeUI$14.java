package com.tencent.mm.plugin.qqmail.ui;

class ComposeUI$14 implements Runnable {
    final /* synthetic */ ComposeUI prr;

    ComposeUI$14(ComposeUI composeUI) {
        this.prr = composeUI;
    }

    public final void run() {
        this.prr.setResult(-1);
        this.prr.finish();
    }
}
