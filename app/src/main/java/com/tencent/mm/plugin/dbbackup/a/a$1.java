package com.tencent.mm.plugin.dbbackup.a;

import android.database.Cursor;
import com.tencent.wcdb.repair.RepairKit.Callback;

class a$1 implements Callback {
    private int lqN = 0;
    private boolean lqO = false;
    final /* synthetic */ int[] lqP;
    final /* synthetic */ a lqQ;
    private int sm = 0;

    a$1(a aVar, int[] iArr) {
        this.lqQ = aVar;
        this.lqP = iArr;
    }

    public final int onProgress(String str, int i, Cursor cursor) {
        if (this.lqN == 0) {
            if (str.equalsIgnoreCase("message")) {
                this.lqN = i;
            }
            return 0;
        } else if (this.lqN != i) {
            if (!this.lqO) {
                this.lqO = true;
                a.a(this.lqQ, new Integer[]{Integer.valueOf(3)});
            }
            return 0;
        }
        int i2 = this.sm;
        this.sm = i2 + 1;
        if (i2 % 1000 == 0) {
            a.b(this.lqQ, new Integer[]{Integer.valueOf(2), Integer.valueOf(this.sm - 1), Integer.valueOf(a.a(this.lqQ))});
        }
        int[] iArr = this.lqP;
        iArr[0] = iArr[0] + 1;
        return 0;
    }
}
