package com.tencent.mm.compatible.d;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public final class p {
    private RandomAccessFile gFJ;
    private RandomAccessFile gFK;
    private a gFL;
    private ArrayList<a> gFM;
    private long pid = 0;

    public class a {
        int gFN;
        long gFO;
        long gFP;
        long gFQ;
        int gFR;
        final /* synthetic */ p gFS;
        long mLastIdle;

        public a(p pVar) {
            this.gFS = pVar;
            this.gFN = 0;
            this.gFO = 0;
            this.mLastIdle = 0;
            this.gFP = 0;
            this.gFQ = 0;
            this.gFR = 0;
        }

        public a(p pVar, long j) {
            this.gFS = pVar;
            this.gFP = j;
        }

        public final void a(String[] strArr, String str) {
            if (this.gFP <= 0) {
                e(strArr);
                return;
            }
            if (str != null && str.length() > 0) {
                String[] split = str.split("[ ]+");
                if (split != null && split.length > 0 && split[0] != null && Long.parseLong(split[0], 10) == this.gFP) {
                    long parseLong = Long.parseLong(split[13], 10);
                    long parseLong2 = Long.parseLong(split[14], 10);
                    long parseLong3 = ((parseLong + parseLong2) + Long.parseLong(split[15], 10)) + Long.parseLong(split[16], 10);
                    long parseLong4 = Long.parseLong(strArr[4], 10);
                    Object obj = 1;
                    long j = 0;
                    for (String str2 : strArr) {
                        if (obj != null) {
                            obj = null;
                        } else {
                            j += Long.parseLong(str2, 10);
                        }
                    }
                    long j2 = j - this.gFO;
                    long j3 = parseLong3 - this.gFQ;
                    this.gFN = (int) ((((float) (j2 - (parseLong4 - this.mLastIdle))) / ((float) j2)) * 100.0f);
                    this.gFR = (int) ((((float) j3) / ((float) j2)) * 100.0f);
                    this.gFO = j;
                    this.mLastIdle = parseLong4;
                    this.gFQ = parseLong3;
                    x.i(" MicroMsg.CpuUsage", "CpuUsageInfo(%d) CPU total=%d idle=%d usage=%d pid=%d pidTotal=%d mPidUsage=%d [%d, %d, %d, %d], [%d, %d, %d]", Integer.valueOf(hashCode()), Long.valueOf(j), Long.valueOf(parseLong4), Integer.valueOf(this.gFN), Long.valueOf(this.gFP), Long.valueOf(parseLong3), Integer.valueOf(this.gFR), Long.valueOf(parseLong), Long.valueOf(parseLong2), Long.valueOf(r12), Long.valueOf(r14), Long.valueOf(j2), Long.valueOf(r6), Long.valueOf(j3));
                    return;
                }
            }
            x.e(" MicroMsg.CpuUsage", "update but pid not match[%d, %s] update nothing", Long.valueOf(this.gFP), str);
        }

        public final void e(String[] strArr) {
            long parseLong = Long.parseLong(strArr[4], 10);
            long j = 0;
            Object obj = 1;
            for (String str : strArr) {
                if (obj != null) {
                    obj = null;
                } else {
                    j += Long.parseLong(str, 10);
                }
            }
            long j2 = j - this.gFO;
            this.gFN = (int) ((((float) (j2 - (parseLong - this.mLastIdle))) / ((float) j2)) * 100.0f);
            this.gFO = j;
            this.mLastIdle = parseLong;
            x.i(" MicroMsg.CpuUsage", "CpuUsageInfo(" + hashCode() + ") CPU total=" + j + "; idle=" + parseLong + "; usage=" + this.gFN);
        }
    }

    public p(long j) {
        this.pid = j;
    }

    private void update() {
        try {
            this.gFJ = new RandomAccessFile("/proc/stat", "r");
            if (this.pid > 0) {
                this.gFK = new RandomAccessFile("/proc/" + this.pid + "/stat", "r");
            }
            yA();
            if (this.gFJ != null) {
                this.gFJ.close();
            }
            if (this.gFK != null) {
                this.gFK.close();
            }
        } catch (Throwable e) {
            x.printErrStackTrace(" MicroMsg.CpuUsage", e, "update e:", new Object[0]);
            if (this.gFJ != null) {
                try {
                    this.gFJ.close();
                } catch (Exception e2) {
                }
                this.gFJ = null;
            }
            if (this.gFK != null) {
                try {
                    this.gFK.close();
                } catch (Exception e3) {
                }
                this.gFK = null;
            }
        }
    }

    private void yA() {
        String readLine;
        int i;
        String readLine2;
        int i2;
        String str = null;
        if (this.gFK != null) {
            try {
                this.gFK.seek(0);
                readLine = this.gFK.readLine();
            } catch (IOException e) {
                x.e(" MicroMsg.CpuUsage", "Ops pidStatFile: " + e);
            }
            if (this.gFJ != null) {
                this.gFJ.seek(0);
                i = -1;
                while (true) {
                    readLine2 = this.gFJ.readLine();
                    if (readLine2 != null || readLine2.length() <= 0) {
                        x.e(" MicroMsg.CpuUsage", "unable to get cpu line cpuId[%d]", Integer.valueOf(i));
                    } else {
                        String[] split = readLine2.split("[ ]+");
                        if (split[0].indexOf("cpu") != -1) {
                            if (i == -1) {
                                if (this.gFL == null) {
                                    this.gFL = new a(this, this.pid);
                                }
                                this.gFL.a(split, readLine);
                            } else {
                                try {
                                    if (this.gFM == null) {
                                        this.gFM = new ArrayList();
                                    }
                                    if (i < this.gFM.size()) {
                                        ((a) this.gFM.get(i)).e(split);
                                    } else {
                                        a aVar = new a(this);
                                        aVar.e(split);
                                        this.gFM.add(aVar);
                                    }
                                } catch (IOException e2) {
                                    x.e(" MicroMsg.CpuUsage", "Ops statFile: " + e2);
                                    return;
                                }
                            }
                        }
                    }
                    i2 = i + 1;
                    if (readLine2 == null) {
                        i = i2;
                    } else {
                        return;
                    }
                }
            }
        }
        readLine = str;
        if (this.gFJ != null) {
            this.gFJ.seek(0);
            i = -1;
            while (true) {
                readLine2 = this.gFJ.readLine();
                if (readLine2 != null) {
                }
                x.e(" MicroMsg.CpuUsage", "unable to get cpu line cpuId[%d]", Integer.valueOf(i));
                i2 = i + 1;
                if (readLine2 == null) {
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }

    public final int yB() {
        return bh.cA(this.gFM) ? 1 : this.gFM.size();
    }

    public final int yC() {
        update();
        return this.gFL != null ? this.gFL.gFN : 0;
    }

    public final int yD() {
        int i = 0;
        if (this.gFL != null) {
            i = this.gFL.gFR;
        }
        if (this.gFM == null || this.gFM.size() <= 1) {
            return i;
        }
        return i * this.gFM.size();
    }

    public final String toString() {
        update();
        StringBuffer stringBuffer = new StringBuffer();
        if (this.gFL != null) {
            stringBuffer.append("Cpu Total : ");
            stringBuffer.append(this.gFL.gFN);
            stringBuffer.append("%");
            if (this.pid > 0) {
                stringBuffer.append("pid(");
                stringBuffer.append(this.pid + ") :");
                stringBuffer.append(this.gFL.gFR);
                stringBuffer.append("%");
            }
        }
        if (this.gFM != null) {
            for (int i = 0; i < this.gFM.size(); i++) {
                a aVar = (a) this.gFM.get(i);
                stringBuffer.append(" Cpu Core(" + i + ") : ");
                stringBuffer.append(aVar.gFN);
                stringBuffer.append("%");
            }
        }
        return stringBuffer.toString();
    }
}
