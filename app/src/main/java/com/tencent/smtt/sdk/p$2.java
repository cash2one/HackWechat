package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.g$a;

class p$2 implements g$a {
    final /* synthetic */ o zXA;
    final /* synthetic */ boolean zXz;

    p$2(boolean z, o oVar) {
        this.zXz = z;
        this.zXA = oVar;
    }

    public final void HY(int i) {
        TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] httpResponseCode=" + i);
        if (i < 300) {
            return;
        }
        if (this.zXz) {
            this.zXA.HU(-107);
        } else {
            this.zXA.HU(-207);
        }
    }
}
