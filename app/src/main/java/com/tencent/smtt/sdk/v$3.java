package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.g.a;

class v$3 implements a {
    final /* synthetic */ v zYe;

    v$3(v vVar) {
        this.zYe = vVar;
    }

    public final void HY(int i) {
        TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] onHttpResponseCode:" + i);
        if (i < 300) {
            v.b(this.zYe);
        }
    }
}
