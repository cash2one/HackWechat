package com.tencent.mm.plugin.appbrand.widget.recentview;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public long kfe = 0;
    public int kff;
    private int kfg;
    private int kfh;
    public int kfi;
    public int kfj;
    public int kfk;
    public StringBuilder kfl = new StringBuilder();
    public StringBuilder kfm = new StringBuilder();

    public final void bY(int i, int i2) {
        this.kfg = i;
        this.kfh = i2;
        if (this.kfe <= 0) {
            x.d("MicroMsg.AppBrandRecentViewReporter", "[report] mOpenTime <= 0");
            return;
        }
        x.i("MicroMsg.AppBrandRecentViewReporter", "[report] mOpenTime:%s mCountAtOpen:%s mCountAtClose:%s mCloseType:%s mScrollCount:%s mOpenAppBrandList:%s mDeleteCount:%s mDeleteAppBrandList:%s", new Object[]{Long.valueOf(this.kfe), Integer.valueOf(this.kff), Integer.valueOf(this.kfg), Integer.valueOf(this.kfh), Integer.valueOf(this.kfi), this.kfl.toString(), Integer.valueOf(this.kfj), this.kfm.toString()});
        g.pQN.h(15081, new Object[]{Long.valueOf(this.kfe), Integer.valueOf(this.kff), Integer.valueOf(this.kfg), Integer.valueOf(this.kfh), Integer.valueOf(this.kfi), this.kfl.toString(), Integer.valueOf(this.kfj), this.kfm.toString(), Integer.valueOf(this.kfk)});
        this.kfe = 0;
        this.kfj = 0;
        this.kfi = 0;
        this.kfh = 0;
        this.kfg = 0;
        this.kff = 0;
        this.kfl = new StringBuilder();
        this.kfm = new StringBuilder();
    }
}
