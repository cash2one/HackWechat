package com.tencent.mm.storage;

import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

final class ah {
    protected final long xyx = 86400;
    private ag xyy = new ag();

    public ah() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Dk();
        byte[] e = e.e(stringBuilder.append(g.Dj().cachePath).append("checkmsgid.ini").toString(), 0, -1);
        if (!bh.bw(e)) {
            try {
                this.xyy.aF(e);
                if (ciM()) {
                    ciL();
                }
            } catch (Throwable e2) {
                x.w("MicroMsg.DelSvrIdMgr", "DelSvrIDs parse Error");
                x.e("MicroMsg.DelSvrIdMgr", "exception:%s", bh.i(e2));
            }
        }
    }

    private void ciL() {
        x.i("MicroMsg.DelSvrIdMgr", "summerdel toFile tid[%d] [%d, %d ,%d] stack[%s]", Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(this.xyy.xyu.size()), Integer.valueOf(this.xyy.xyv.size()), Integer.valueOf(this.xyy.xyw.size()), bh.cgy());
        try {
            this.xyy.xyt.clear();
            this.xyy.xyr.clear();
            this.xyy.xyq.clear();
            ag agVar = new ag();
            agVar.xyu.addAll(this.xyy.xyu);
            agVar.xyv.addAll(this.xyy.xyv);
            agVar.xyw.addAll(this.xyy.xyw);
            byte[] toByteArray = agVar.toByteArray();
            StringBuilder stringBuilder = new StringBuilder();
            g.Dk();
            e.b(stringBuilder.append(g.Dj().cachePath).append("checkmsgid.ini").toString(), toByteArray, toByteArray.length);
            String str = "MicroMsg.DelSvrIdMgr";
            String str2 = "summerdel toFile done [%d, %d, %d] data len[%d]";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(agVar.xyu.size());
            objArr[1] = Integer.valueOf(agVar.xyv.size());
            objArr[2] = Integer.valueOf(agVar.xyw.size());
            objArr[3] = Integer.valueOf(toByteArray == null ? -1 : toByteArray.length);
            x.i(str, str2, objArr);
        } catch (Throwable e) {
            d.pPH.a(111, 168, 1, false);
            x.printErrStackTrace("MicroMsg.DelSvrIdMgr", e, "summerdel ", new Object[0]);
        }
    }

    protected final boolean fP(long j) {
        if (ciM()) {
            ciL();
        }
        return this.xyy.xyu.contains(Long.valueOf(j)) || this.xyy.xyv.contains(Long.valueOf(j)) || this.xyy.xyw.contains(Long.valueOf(j));
    }

    protected final void j(int i, long j, long j2) {
        a(i, j, j2, true);
    }

    protected final void a(int i, long j, long j2, boolean z) {
        if (j != 0) {
            if (z) {
                ciM();
            }
            switch (i - ((int) (j2 / 86400))) {
                case 0:
                    this.xyy.xyu.add(Long.valueOf(j));
                    break;
                case 1:
                    this.xyy.xyv.add(Long.valueOf(j));
                    break;
                case 2:
                    this.xyy.xyw.add(Long.valueOf(j));
                    break;
                default:
                    x.e("MicroMsg.DelSvrIdMgr", "should not add to thease lists, dayIndex:%d", Integer.valueOf(i - ((int) (j2 / 86400))));
                    break;
            }
            if (z) {
                ciL();
            }
        }
    }

    protected final void i(List<Integer> list, List<Long> list2) {
        x.i("MicroMsg.DelSvrIdMgr", "add size:%d", Integer.valueOf(list.size()));
        ciM();
        int Wo = (int) (bh.Wo() / 86400);
        for (int i = 0; i < list.size(); i++) {
            a(Wo, (long) ((Integer) list.get(i)).intValue(), ((Long) list2.get(i)).longValue(), false);
        }
        ciL();
    }

    private boolean ciM() {
        x.v("MicroMsg.DelSvrIdMgr", "checkOldData todayIndex:%d, t0Size:%d, t1Size:%d, t2Size:%d", Integer.valueOf(this.xyy.xyp), Integer.valueOf(this.xyy.xyu.size()), Integer.valueOf(this.xyy.xyv.size()), Integer.valueOf(this.xyy.xyw.size()));
        int Wo = (int) (bh.Wo() / 86400);
        int i = Wo - this.xyy.xyp;
        this.xyy.xyp = Wo;
        switch (i) {
            case 0:
                return false;
            case 1:
                this.xyy.xyw = this.xyy.xyv;
                this.xyy.xyv = this.xyy.xyu;
                this.xyy.xyu.clear();
                return true;
            case 2:
                this.xyy.xyw = this.xyy.xyu;
                this.xyy.xyv.clear();
                this.xyy.xyu.clear();
                return true;
            default:
                this.xyy.xyw.clear();
                this.xyy.xyv.clear();
                this.xyy.xyu.clear();
                return true;
        }
    }
}
