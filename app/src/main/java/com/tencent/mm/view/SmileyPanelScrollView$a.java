package com.tencent.mm.view;

import android.os.SystemClock;
import com.tencent.mm.plugin.report.service.g;

public class SmileyPanelScrollView$a implements Runnable {
    long mStartTime;
    long zDR;
    final /* synthetic */ SmileyPanelScrollView zDS;

    public SmileyPanelScrollView$a(SmileyPanelScrollView smileyPanelScrollView) {
        this.zDS = smileyPanelScrollView;
    }

    final void cAp() {
        this.zDR = 300;
        this.mStartTime = SystemClock.uptimeMillis();
        g.pQN.h(13361, new Object[]{Integer.valueOf(0)});
    }

    public final void run() {
        cAp();
    }
}
