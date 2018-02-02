package com.tencent.mm.plugin.clean.b;

import com.tencent.mm.a.e;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.plugin.i.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class a implements Runnable {
    private static final Long leU = Long.valueOf(604800000);
    private static final Long leV = Long.valueOf(7776000000L);
    private boolean isStop;
    private long leW;
    private long leX;
    private long leY;
    private long leZ;
    private HashMap<String, Long> lfa;
    private HashSet<String> lfb;
    private c lfc;

    public a(c cVar) {
        this.isStop = false;
        this.isStop = false;
        this.lfc = cVar;
        this.lfa = new HashMap();
        this.lfb = new HashSet();
    }

    public final void stop() {
        this.isStop = true;
        this.lfc = null;
    }

    private String asN() {
        return hashCode();
    }

    public final void run() {
        long Wq = bh.Wq();
        if (this.isStop) {
            x.i("MicroMsg.CleanCalcLogic", "%s start run but stop", new Object[]{asN()});
            return;
        }
        String str;
        long xk;
        List arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        a(arrayList, hashSet);
        int size = arrayList.size();
        int i = 0;
        while (!this.isStop && i < size) {
            str = (String) arrayList.get(i);
            if (!bh.ov(str)) {
                if (str.endsWith(File.separator + "sns" + File.separator)) {
                    xk = xk(str);
                } else if (str.endsWith(File.separator + "music")) {
                    xk = xl(str);
                } else {
                    xk = xj(str);
                }
                this.lfa.put(str, Long.valueOf(xk));
                x.d("MicroMsg.CleanCalcLogic", "%s path[%s] size[%d]", new Object[]{asN(), str, Long.valueOf(xk)});
                this.leW += xk;
                if (hashSet.contains(str)) {
                    this.leY = xk + this.leY;
                }
                int i2 = i + 1;
                if (this.lfc != null) {
                    this.lfc.cj(i2, size);
                }
                i = i2;
            }
        }
        this.leX = b.asG().asH().asQ();
        this.leW += this.leX;
        if (this.leW <= 0) {
            this.leW = 1;
            g.pQN.a(714, 60, 1, false);
        }
        x.i("MicroMsg.CleanCalcLogic", "%s scan finish cost[%d] micromsg[%d] acc[%d] otherAcc[%d]", new Object[]{asN(), Long.valueOf(bh.bA(Wq)), Long.valueOf(this.leW), Long.valueOf(this.leX), Long.valueOf(this.leY)});
        HashSet hashSet2 = this.lfb;
        if (this.lfc != null) {
            this.lfc.a(this.leW, this.leX, this.leY, hashSet2, this.lfa);
        }
        j.ayv();
        long ayc = j.ayc();
        j.ayv();
        xk = j.ayd();
        int i3 = (int) ((this.leW * 100) / ayc);
        int i4 = (int) ((this.leX * 100) / this.leW);
        size = (int) ((this.leY * 100) / this.leW);
        long j = (this.leW - this.leX) - this.leY;
        int i5 = (int) ((100 * j) / this.leW);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.leZ).append(",");
        stringBuffer.append(this.leW).append(",");
        stringBuffer.append(i3).append(",");
        stringBuffer.append(ayc - xk).append(",");
        stringBuffer.append(xk).append(",");
        stringBuffer.append(ayc).append(",");
        stringBuffer.append(this.leX).append(",");
        stringBuffer.append(i4).append(",");
        stringBuffer.append(this.leY).append(",");
        stringBuffer.append(size).append(",");
        stringBuffer.append(j).append(",");
        stringBuffer.append(i5);
        x.i("MicroMsg.CleanCalcLogic", "rpt content %s", new Object[]{stringBuffer.toString()});
        g.pQN.k(14762, str);
        stop();
    }

    private long xj(String str) {
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                long j = 0;
                for (String str2 : list) {
                    String str22;
                    StringBuilder append = new StringBuilder().append(str);
                    if (!str.endsWith("/")) {
                        str22 = "/" + str22;
                    }
                    long xj = xj(append.append(str22).toString());
                    if (xj == -1) {
                        return -1;
                    }
                    j += xj;
                }
                return j;
            }
        }
        return file.length();
    }

    private int a(List<String> list, HashSet<String> hashSet) {
        String str = com.tencent.mm.kernel.g.Dj().gQh;
        String str2 = com.tencent.mm.kernel.g.Dj().gQi;
        x.i("MicroMsg.CleanCalcLogic", "%s get MicroMsg path root[%s] acc[%s]", new Object[]{asN(), str, str2});
        int i = 0;
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list2 = file.list();
            if (list2 != null) {
                int length = list2.length;
                int i2 = 0;
                while (i2 < length) {
                    int i3;
                    String str3 = list2[i2];
                    String str4 = str + str3 + "/";
                    x.d("MicroMsg.CleanCalcLogic", "%s sub file path[%s] sub[%s]", new Object[]{asN(), str4, str3});
                    if (!new File(str4).isDirectory()) {
                        list.add(str4);
                        i3 = i + 1;
                    } else if (str3.length() < 32) {
                        list.add(str4);
                        i3 = i + 1;
                    } else if (bh.fu(str2, str4)) {
                        list.add(str2.endsWith("/") ? str2 + "music" : str2 + File.separator + "music");
                        ar.Hg();
                        list.add(c.Fp());
                        ar.Hg();
                        list.add(c.getAccSnsPath());
                        ar.Hg();
                        list.add(c.Fw());
                        i3 = i;
                    } else {
                        hashSet.add(str4);
                        list.add(str4);
                        i3 = i + 1;
                        this.lfb.add(str3);
                    }
                    i2++;
                    i = i3;
                }
            }
        }
        return i;
    }

    private long xk(String str) {
        long j = 0;
        int i = 0;
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                int length = list.length;
                while (i < length) {
                    i++;
                    j = xk(str + "/" + list[i]) + j;
                }
                return j;
            }
        } else if (System.currentTimeMillis() - file.lastModified() > leU.longValue()) {
            x.i("MicroMsg.CleanCalcLogic", "Clean 7 days file in sns rootPath=%s", new Object[]{str});
            long bN = (long) e.bN(str);
            if (!file.delete()) {
                return 0;
            }
            this.leZ += bN;
            return 0;
        }
        return (long) e.bN(str);
    }

    private long xl(String str) {
        long j = 0;
        int i = 0;
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                int length = list.length;
                while (i < length) {
                    i++;
                    j = xl(str + "/" + list[i]) + j;
                }
                return j;
            }
        } else if (System.currentTimeMillis() - file.lastModified() > leV.longValue()) {
            x.i("MicroMsg.CleanCalcLogic", "Clean 90 days file in music rootPath=%s", new Object[]{str});
            long bN = (long) e.bN(str);
            if (!file.delete()) {
                return 0;
            }
            this.leZ += bN;
            return 0;
        }
        return (long) e.bN(str);
    }
}
