package com.tencent.mm.ui.chatting.e;

import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.a.b.b;
import com.tencent.mm.ui.chatting.e.b.2;
import java.util.ArrayList;
import java.util.Iterator;

class b$2$1 implements a {
    final /* synthetic */ 2 yHm;

    b$2$1(2 2) {
        this.yHm = 2;
    }

    public final boolean uF() {
        String str = "MicroMsg.BaseHistoryListPresenter";
        String str2 = "[onTimerExpired]  mDataListCache is null?:%s mSearchText is null?:%s";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.yHm.yHl.yHi == null);
        objArr[1] = Boolean.valueOf(bh.ov(this.yHm.yyw));
        x.i(str, str2, objArr);
        if (bh.ov(this.yHm.yyw)) {
            this.yHm.yHl.yHg.yyw = this.yHm.yyw;
            if (this.yHm.yHl.yHi == null) {
                this.yHm.yHl.cur();
            } else {
                this.yHm.yHl.jRt = this.yHm.yHl.yHi;
                ag.y(new Runnable(this) {
                    final /* synthetic */ b$2$1 yHn;

                    {
                        this.yHn = r1;
                    }

                    public final void run() {
                        this.yHn.yHm.yHl.yHf.bn(this.yHn.yHm.yyw, false);
                        this.yHn.yHm.yHl.yHg.UR.notifyChanged();
                    }
                });
            }
        } else {
            this.yHm.yHl.jRt = this.yHm.yHl.yHi;
            ArrayList arrayList = new ArrayList();
            Iterator it = this.yHm.yHl.jRt.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar.Zf(this.yHm.yyw)) {
                    arrayList.add(bVar);
                }
            }
            this.yHm.yHl.jRt = arrayList;
            this.yHm.yHl.yHg.yyw = this.yHm.yyw;
            ag.y(new 2(this));
        }
        return false;
    }
}
