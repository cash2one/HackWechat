package com.tencent.mm.plugin.dbbackup;

import com.tencent.mm.plugin.dbbackup.d.4;
import com.tencent.wcdb.repair.DBDumpUtil.ExecuteSqlCallback;

class d$4$1 implements ExecuteSqlCallback {
    final /* synthetic */ int[] lqq;
    final /* synthetic */ 4 lqr;

    d$4$1(4 4, int[] iArr) {
        this.lqr = 4;
        this.lqq = iArr;
    }

    public final String preExecute(String str) {
        int[] iArr = this.lqq;
        iArr[0] = iArr[0] + 1;
        return null;
    }
}
