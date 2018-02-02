package com.tencent.mm.plugin.i.c;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.plugin.n.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import java.io.File;

public final class b implements Runnable {
    private int count = 0;
    public boolean isStop = false;

    public final void run() {
        if (!this.isStop) {
            String Fi = c.Fi();
            this.count = 0;
            long a = a(Fi, new PLong());
            if (!this.isStop) {
                Fi = c.Fj();
                this.count = 0;
                long a2 = a(Fi, new PLong());
                if (!this.isStop) {
                    ar.Hg();
                    Fi = com.tencent.mm.z.c.getAccVideoPath();
                    this.count = 0;
                    long a3 = a(Fi, new PLong());
                    if (!this.isStop) {
                        ar.Hg();
                        Fi = com.tencent.mm.z.c.Fm();
                        this.count = 0;
                        long a4 = a(Fi, new PLong());
                        if (!this.isStop) {
                            long nB = (com.tencent.mm.plugin.i.b.asG().asH().nB(43) + com.tencent.mm.plugin.i.b.asG().asH().nB(62)) + com.tencent.mm.plugin.i.b.asG().asH().nB(44);
                            long nC = (com.tencent.mm.plugin.i.b.asG().asH().nC(43) + com.tencent.mm.plugin.i.b.asG().asH().nC(62)) + com.tencent.mm.plugin.i.b.asG().asH().nC(44);
                            if (!this.isStop) {
                                long nB2 = com.tencent.mm.plugin.i.b.asG().asH().nB(3);
                                long nC2 = com.tencent.mm.plugin.i.b.asG().asH().nC(3);
                                if (!this.isStop) {
                                    long nB3 = com.tencent.mm.plugin.i.b.asG().asH().nB(34);
                                    long nC3 = com.tencent.mm.plugin.i.b.asG().asH().nC(34);
                                    long nB4 = com.tencent.mm.plugin.i.b.asG().asH().nB(49);
                                    long nC4 = com.tencent.mm.plugin.i.b.asG().asH().nC(49);
                                    g.pQN.h(14556, new Object[]{Integer.valueOf(43), Long.valueOf(nB), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(nC)});
                                    g.pQN.h(14556, new Object[]{Integer.valueOf(3), Long.valueOf(nB2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(nC2)});
                                    g.pQN.h(14556, new Object[]{Integer.valueOf(34), Long.valueOf(nB3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(nC3)});
                                    g.pQN.h(14556, new Object[]{Integer.valueOf(49), Long.valueOf(nB4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(nC4)});
                                    g.pQN.h(14556, new Object[]{Integer.valueOf(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE.hashCode()), Long.valueOf(a), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(r3.value)});
                                    g.pQN.h(14556, new Object[]{Integer.valueOf("image2".hashCode()), Long.valueOf(a2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(r6.value)});
                                    g.pQN.h(14556, new Object[]{Integer.valueOf(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE.hashCode()), Long.valueOf(a3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(r7.value)});
                                    g.pQN.h(14556, new Object[]{Integer.valueOf("voice".hashCode()), Long.valueOf(a4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(r12.value)});
                                    long longValue = ((Long) com.tencent.mm.kernel.g.Dj().CU().get(a.xwn, Long.valueOf(0))).longValue();
                                    long longValue2 = ((Long) com.tencent.mm.kernel.g.Dj().CU().get(a.xwo, Long.valueOf(0))).longValue() - longValue;
                                    g.pQN.h(14556, new Object[]{Integer.valueOf("cost".hashCode()), Integer.valueOf(0), Long.valueOf(longValue), Long.valueOf(r34), Long.valueOf(longValue2)});
                                    x.i("MicroMsg.ReportTask", "report wx[%d %d %d %d] folder[%d %d %d %d] count_wx[%d %d %d %d] count_folder[%d %d %d %d]", new Object[]{Long.valueOf(nB), Long.valueOf(nB2), Long.valueOf(nB3), Long.valueOf(nB4), Long.valueOf(a3), Long.valueOf(a2), Long.valueOf(a4), Long.valueOf(a), Long.valueOf(nC), Long.valueOf(nC2), Long.valueOf(nC3), Long.valueOf(nC4), Long.valueOf(r7.value), Long.valueOf(r6.value), Long.valueOf(r12.value), Long.valueOf(r3.value)});
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private long a(String str, PLong pLong) {
        long j = 0;
        if (this.count >= 10) {
            if (this.isStop) {
                return -1;
            }
            this.count = 0;
        }
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                for (String str2 : list) {
                    String str22;
                    StringBuilder append = new StringBuilder().append(str);
                    if (!str.endsWith("/")) {
                        str22 = "/" + str22;
                    }
                    long a = a(append.append(str22).toString(), pLong);
                    if (a == -1) {
                        return -1;
                    }
                    j += a;
                }
                return j;
            }
        }
        long length = file.length();
        if (length <= 0) {
            return length;
        }
        pLong.value++;
        return length;
    }
}
