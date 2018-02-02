package com.tencent.mm.ui;

import com.tencent.mm.sdk.platformtools.x;

class CheckCanSubscribeBizUI$3 implements Runnable {
    final /* synthetic */ String hpU;
    final /* synthetic */ CheckCanSubscribeBizUI xEb;

    CheckCanSubscribeBizUI$3(CheckCanSubscribeBizUI checkCanSubscribeBizUI, String str) {
        this.xEb = checkCanSubscribeBizUI;
        this.hpU = str;
    }

    public final void run() {
        x.d("MicroMsg.CheckCanSubscribeBizUI", "onNotifyChange toUserName = " + CheckCanSubscribeBizUI.d(this.xEb) + ", userName = " + this.hpU);
        if (CheckCanSubscribeBizUI.d(this.xEb).equals(this.hpU)) {
            CheckCanSubscribeBizUI.e(this.xEb);
            if (!CheckCanSubscribeBizUI.f(this.xEb)) {
                CheckCanSubscribeBizUI.b(this.xEb);
            }
        }
    }
}
