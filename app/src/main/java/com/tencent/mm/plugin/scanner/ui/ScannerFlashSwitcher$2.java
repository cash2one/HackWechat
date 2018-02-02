package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class ScannerFlashSwitcher$2 extends AnimatorListenerAdapter {
    final /* synthetic */ ScannerFlashSwitcher pYM;

    ScannerFlashSwitcher$2(ScannerFlashSwitcher scannerFlashSwitcher) {
        this.pYM = scannerFlashSwitcher;
    }

    public final void onAnimationEnd(Animator animator) {
        ScannerFlashSwitcher.a(this.pYM).setAlpha(1.0f);
    }
}
