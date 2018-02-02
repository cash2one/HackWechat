package com.tencent.mm.plugin.sns.ui;

class SnsMsgUI$8 implements Runnable {
    final /* synthetic */ SnsMsgUI rDE;

    SnsMsgUI$8(SnsMsgUI snsMsgUI) {
        this.rDE = snsMsgUI;
    }

    public final void run() {
        if (SnsMsgUI.d(this.rDE) != null) {
            synchronized (SnsMsgUI.d(this.rDE)) {
                SnsMsgUI.d(this.rDE).a(null, null);
                SnsMsgUI.r(this.rDE);
            }
        }
    }
}
