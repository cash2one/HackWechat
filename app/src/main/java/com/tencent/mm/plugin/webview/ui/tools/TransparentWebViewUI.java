package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.ui.base.a;

@a(3)
public class TransparentWebViewUI extends GameWebViewUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.screenOrientation == 1001) {
            this.screenOrientation = 0;
            if (this.tyy != null) {
                this.tyy.enable();
            }
        } else if (this.screenOrientation == 1002) {
            this.screenOrientation = 1;
            if (this.tyy != null) {
                this.tyy.enable();
            }
        }
    }

    protected final void initView() {
        boolean z = true;
        super.initView();
        this.tAe.tyg = true;
        this.tAe.iMZ = false;
        this.tAe.kr(true);
        this.tAe.AF(0);
        if (!(getIntent() != null && getIntent().hasExtra("show_full_screen") && getIntent().getBooleanExtra("show_full_screen", false))) {
            z = false;
        }
        if (z && this.tyv != null) {
            this.tyv.tKF = false;
        }
    }

    protected final void bSr() {
        setBackGroundColorResource(0);
        this.mController.contentView.setBackgroundResource(0);
        this.ptK.setBackgroundResource(17170445);
        this.ptK.setBackgroundColor(0);
        findViewById(R.h.cYR).setBackgroundResource(17170445);
    }
}
