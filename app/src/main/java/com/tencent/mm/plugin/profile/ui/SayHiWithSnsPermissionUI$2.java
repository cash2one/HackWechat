package com.tencent.mm.plugin.profile.ui;

class SayHiWithSnsPermissionUI$2 implements Runnable {
    final /* synthetic */ SayHiWithSnsPermissionUI plm;

    SayHiWithSnsPermissionUI$2(SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI) {
        this.plm = sayHiWithSnsPermissionUI;
    }

    public final void run() {
        this.plm.showVKB();
    }
}
