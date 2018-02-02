package com.tencent.mm.plugin.readerapp.ui;

class ReaderAppUI$2 implements Runnable {
    final /* synthetic */ ReaderAppUI pAY;

    ReaderAppUI$2(ReaderAppUI readerAppUI) {
        this.pAY = readerAppUI;
    }

    public final void run() {
        if (ReaderAppUI.b(this.pAY) != null) {
            ReaderAppUI.b(this.pAY).notifyDataSetChanged();
        }
    }
}
