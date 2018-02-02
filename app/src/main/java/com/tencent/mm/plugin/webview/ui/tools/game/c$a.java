package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.x;

public class c$a {
    public final /* synthetic */ c tFu;

    public c$a(c cVar) {
        this.tFu = cVar;
    }

    public final void bUg() {
        this.tFu.tFs = null;
        this.tFu.mStartTime = 0;
        this.tFu.nlI = 0;
        this.tFu.mStartTime = 0;
        this.tFu.nlJ = 0;
    }

    public final void bUh() {
        this.tFu.mStartTime = System.currentTimeMillis();
        this.tFu.nlJ = System.currentTimeMillis();
    }

    public final void Z(Bundle bundle) {
        this.tFu.tFs = bundle;
        x.i("MicroMsg.GamePageTimeReport", "setGamePageReportData");
        if (bundle != null && bundle.getBoolean("game_page_report_time_begin")) {
            this.tFu.nlI = 0;
            this.tFu.mStartTime = System.currentTimeMillis();
            this.tFu.nlJ = System.currentTimeMillis();
        }
    }

    public final void onResume() {
        if (this.tFu.nlJ != 0) {
            this.tFu.nlJ = System.currentTimeMillis();
        }
    }

    public final void onPause() {
        if (this.tFu.nlJ != 0) {
            this.tFu.nlI += System.currentTimeMillis() - this.tFu.nlJ;
        }
    }
}
