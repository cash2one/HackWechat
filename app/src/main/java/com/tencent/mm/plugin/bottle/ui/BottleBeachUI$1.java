package com.tencent.mm.plugin.bottle.ui;

class BottleBeachUI$1 implements Runnable {
    final /* synthetic */ BottleBeachUI kBA;

    BottleBeachUI$1(BottleBeachUI bottleBeachUI) {
        this.kBA = bottleBeachUI;
    }

    public final void run() {
        if (BottleBeachUI.a(this.kBA) != null && BottleBeachUI.b(this.kBA) == 0 && BottleBeachUI.c(this.kBA)) {
            BottleBeachUI.d(this.kBA);
        }
    }
}
