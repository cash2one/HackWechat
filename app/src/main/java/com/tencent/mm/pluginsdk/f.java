package com.tencent.mm.pluginsdk;

import com.tencent.mm.a.e;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.hardcoder.d.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public final class f implements a {
    private static String vcm = null;
    private static Long vcn = null;
    public static boolean vco = false;

    public final void a(int i, int i2, int i3, int i4, long j, int i5, int i6, int[] iArr, int i7, int i8, int i9, int i10, int i11, long j2, int[] iArr2, int[] iArr3) {
        if (x.getLogLevel() <= 1 || HardCoderJNI.hcKVPerReport) {
            int i12;
            if (vcn == null) {
                ar.Hg();
                vcn = (Long) c.CU().get(w.a.xtT, Long.valueOf(0));
            }
            if (vcm == null) {
                vcm = bh.eX(ac.getContext());
            }
            String str = vcm;
            int longValue = (int) vcn.longValue();
            StringBuilder stringBuilder = new StringBuilder();
            if (iArr != null) {
                for (int i13 : iArr) {
                    stringBuilder.append(i13 + "#");
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            if (iArr2 != null) {
                for (int i122 : iArr2) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    if (i122 < 0) {
                        i122 = 0;
                    }
                    stringBuilder2.append(stringBuilder3.append(i122).append("#").toString());
                }
            }
            StringBuilder stringBuilder4 = new StringBuilder();
            if (iArr3 != null) {
                for (int i1222 : iArr3) {
                    StringBuilder stringBuilder5 = new StringBuilder();
                    if (i1222 < 0) {
                        i1222 = 0;
                    }
                    stringBuilder4.append(stringBuilder5.append(i1222).append("#").toString());
                }
            }
            String format = String.format("[oneliang]performance report,imei:%s,threadId:%s,heavy:%s,speedUp:%s,cancelInDelay:%s,scene:%s,action:%s,cpuLevel:%s,ioLevel:%s,bindCoreIds:%s,executeTime:%s,runtime:%s,threadJiffies:%s, phonePower:%s, phoneHZ:%s, processJiffies:%s,cpuLevelTimeArray:%s, ioLevelTimeArray:%s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(longValue), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j), Integer.valueOf(i5), Integer.valueOf(i6), stringBuilder.toString(), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Long.valueOf(j2), stringBuilder2.toString(), stringBuilder4.toString()});
            String format2 = String.format("time:%s,imei:%s,threadId:%s,heavy:%s,speedUp:%s,cancelInDelay:%s,scene:%s,action:%s,cpuLevel:%s,ioLevel:%s,bindCoreIds:%s,executeTime:%s,runtime:%s,threadJiffies:%s, phonePower:%s, phoneHZ:%s, processJiffies:%s,cpuLevelTimeArray:%s, ioLevelTimeArray:%s", new Object[]{Long.valueOf(System.currentTimeMillis()), str, Integer.valueOf(i), Integer.valueOf(longValue), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j), Integer.valueOf(i5), Integer.valueOf(i6), stringBuilder.toString(), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Long.valueOf(j2), stringBuilder2.toString(), stringBuilder4.toString()});
            if (HardCoderJNI.hcDebug) {
                x.i("MicroMsg.HardCoderReporterImpl", format);
            }
            g gVar = g.pQN;
            Object[] objArr = new Object[19];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(longValue);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = Integer.valueOf(i3);
            objArr[4] = Integer.valueOf(i4);
            objArr[5] = Long.valueOf(j);
            objArr[6] = Integer.valueOf(i5);
            objArr[7] = Integer.valueOf(i6);
            objArr[8] = stringBuilder.toString();
            if (i7 < 0) {
                i7 = 0;
            }
            objArr[9] = Integer.valueOf(i7);
            objArr[10] = Integer.valueOf(i8);
            objArr[11] = Integer.valueOf(i9);
            objArr[12] = Integer.valueOf(i10);
            objArr[13] = Integer.valueOf(i11);
            objArr[14] = Long.valueOf(j2);
            objArr[15] = stringBuilder2.toString();
            objArr[16] = stringBuilder4.toString();
            objArr[17] = "";
            objArr[18] = Integer.valueOf(0);
            gVar.h(14607, objArr);
            Rj(format2);
        }
    }

    public final void a(int i, long j, int i2, int i3, int i4) {
        if (vcm == null) {
            vcm = bh.eX(ac.getContext());
        }
        String str = vcm;
        if (j <= 0) {
            j = System.currentTimeMillis();
        }
        String format = String.format("errorReport imei:%s,callbackType:%s,errorTimestamp:%s,errCode:%s,funcId:%s,dataType:%s", new Object[]{str, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        String format2 = String.format("time:%s,imei:%s,callbackType:%s,errorTimestamp:%s,errCode:%s,funcId:%s,dataType:%s", new Object[]{Long.valueOf(System.currentTimeMillis()), str, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        x.i("MicroMsg.HardCoderReporterImpl", format);
        g.pQN.h(14610, new Object[]{str, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        Rj(format2);
    }

    private static void Rj(String str) {
        Exception e;
        OutputStream fileOutputStream;
        Throwable th;
        if (vco) {
            StringBuilder stringBuilder = new StringBuilder();
            ar.Hg();
            e.c(new String[]{stringBuilder.append(c.ER()).append("/hcstat").toString()});
            File file = new File(r0, "data.txt");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e2) {
                    x.i("MicroMsg.HardCoderReporterImpl", "create new file exception:" + e2.getMessage());
                }
            }
            try {
                fileOutputStream = new FileOutputStream(file, true);
                try {
                    fileOutputStream.write((str + "\n").getBytes("UTF-8"));
                    fileOutputStream.flush();
                    try {
                        fileOutputStream.close();
                    } catch (Exception e22) {
                        x.i("MicroMsg.HardCoderReporterImpl", "close exception:" + e22.getMessage());
                    }
                } catch (Exception e3) {
                    e22 = e3;
                    try {
                        x.i("MicroMsg.HardCoderReporterImpl", "exception:" + e22.getMessage());
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e222) {
                                x.i("MicroMsg.HardCoderReporterImpl", "close exception:" + e222.getMessage());
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e4) {
                                x.i("MicroMsg.HardCoderReporterImpl", "close exception:" + e4.getMessage());
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e5) {
                e222 = e5;
                fileOutputStream = null;
                x.i("MicroMsg.HardCoderReporterImpl", "exception:" + e222.getMessage());
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        }
    }

    public final void reportIDKey(boolean z, int i, int i2, boolean z2) {
        x.i("MicroMsg.HardCoderReporterImpl", "reportIDKey feature[%b] key[%d], value[%d]", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z2)});
        g.pQN.a(z ? 678 : 679, (long) i, (long) i2, z2);
    }
}
