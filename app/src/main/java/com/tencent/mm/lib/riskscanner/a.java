package com.tencent.mm.lib.riskscanner;

import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.PrintWriter;
import java.io.StringWriter;

final class a {
    private static ThreadLocal<Long> gUp = new ThreadLocal();

    public static void Eo() {
        x.i("MicroMsg.RiskScannerReportService", "Report scan triggering.");
        d.pPH.a(590, 0, 1, true);
        gUp.set(Long.valueOf(bh.Wq()));
    }

    public static void c(Throwable th) {
        StringWriter stringWriter;
        PrintWriter printWriter;
        StringWriter stringWriter2;
        Throwable th2;
        PrintWriter printWriter2 = null;
        x.i("MicroMsg.RiskScannerReportService", "Report an exception with message: %s", new Object[]{th.getMessage()});
        gUp.remove();
        d.pPH.a(590, 4, 1, true);
        try {
            stringWriter = new StringWriter();
            try {
                printWriter = new PrintWriter(stringWriter);
                try {
                    th.printStackTrace(printWriter);
                    printWriter.flush();
                    d.pPH.a(14177, "-1," + stringWriter.toString().replace(",", "##"), false, true);
                    try {
                        stringWriter.close();
                    } catch (Throwable th3) {
                    }
                    try {
                        printWriter.close();
                    } catch (Throwable th4) {
                    }
                } catch (Throwable th5) {
                    printWriter2 = printWriter;
                    th2 = th5;
                    if (stringWriter != null) {
                        try {
                            stringWriter.close();
                        } catch (Throwable th6) {
                        }
                    }
                    if (printWriter2 != null) {
                        try {
                            printWriter2.close();
                        } catch (Throwable th7) {
                        }
                    }
                    throw th2;
                }
            } catch (Throwable th8) {
                th2 = th8;
                if (stringWriter != null) {
                    stringWriter.close();
                }
                if (printWriter2 != null) {
                    printWriter2.close();
                }
                throw th2;
            }
        } catch (Throwable th9) {
            th2 = th9;
            stringWriter = null;
            if (stringWriter != null) {
                stringWriter.close();
            }
            if (printWriter2 != null) {
                printWriter2.close();
            }
            throw th2;
        }
    }

    public static void gI(int i) {
        x.i("MicroMsg.RiskScannerReportService", "Report scan result, %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case -10:
                d.pPH.a(590, 2, 1, true);
                return;
            case 0:
                Long l = (Long) gUp.get();
                if (l != null) {
                    x.i("MicroMsg.RiskScannerReportService", "Scan cost: %d ms", new Object[]{Long.valueOf(bh.Wq() - l.longValue())});
                    d.pPH.c(590, 5, 1, (int) r4, true);
                    return;
                }
                d.pPH.a(590, 1, 1, true);
                return;
            default:
                d.pPH.a(590, 3, 1, true);
                return;
        }
    }
}
