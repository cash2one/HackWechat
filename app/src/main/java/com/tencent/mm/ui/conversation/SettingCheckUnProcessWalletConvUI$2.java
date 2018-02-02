package com.tencent.mm.ui.conversation;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class SettingCheckUnProcessWalletConvUI$2 implements OnTouchListener {
    final /* synthetic */ SettingCheckUnProcessWalletConvUI zaj;

    SettingCheckUnProcessWalletConvUI$2(SettingCheckUnProcessWalletConvUI settingCheckUnProcessWalletConvUI) {
        this.zaj = settingCheckUnProcessWalletConvUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.zaj.aWs();
                SettingCheckUnProcessWalletConvUI.a(this.zaj)[0] = (int) motionEvent.getRawX();
                SettingCheckUnProcessWalletConvUI.a(this.zaj)[1] = (int) motionEvent.getRawY();
                break;
        }
        return false;
    }
}
