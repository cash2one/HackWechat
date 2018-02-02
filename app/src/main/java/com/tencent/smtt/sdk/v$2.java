package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.g.a;

class v$2 implements a {
    final /* synthetic */ v zYe;

    v$2(v vVar) {
        this.zYe = vVar;
    }

    public final void HY(int i) {
        TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportTbsLog] httpResponseCode=" + i);
    }
}
