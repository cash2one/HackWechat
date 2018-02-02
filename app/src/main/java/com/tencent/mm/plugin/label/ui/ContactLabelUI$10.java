package com.tencent.mm.plugin.label.ui;

class ContactLabelUI$10 implements Runnable {
    final /* synthetic */ ContactLabelUI nPX;

    ContactLabelUI$10(ContactLabelUI contactLabelUI) {
        this.nPX = contactLabelUI;
    }

    public final void run() {
        ContactLabelUI.b(this.nPX).cpF();
        this.nPX.showVKB();
    }
}
