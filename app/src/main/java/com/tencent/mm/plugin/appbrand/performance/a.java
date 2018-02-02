package com.tencent.mm.plugin.appbrand.performance;

import android.annotation.SuppressLint;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class a {
    private static List<a> jFV = Collections.synchronizedList(new LinkedList());
    private static long sAppStartTime;

    public static void bF(long j) {
        sAppStartTime = j;
    }

    public static void a(String str, String str2, long j, long j2) {
        a(str, "Native", str2, j, j2, null);
    }

    public static void a(String str, String str2, String str3, long j, long j2, String str4) {
        a(str, str2, str3, "X", j, j2, str4);
    }

    public static void a(String str, String str2, String str3, double d) {
        long currentTimeMillis = System.currentTimeMillis();
        String format = String.format("{ \"%s\": %f }", new Object[]{str3, Double.valueOf(d)});
        a(str, str2, str3, "C", currentTimeMillis, currentTimeMillis, format);
    }

    public static void a(String str, String str2, String str3, String str4, long j, long j2, String str5) {
        if (AppBrandPerformanceManager.tT(str)) {
            a aVar = new a();
            aVar.appId = str;
            aVar.name = str3;
            aVar.category = str2;
            aVar.jFW = str4;
            aVar.start = j;
            aVar.jFX = j2;
            aVar.jFY = str5 != null ? p.encode(str5) : "";
            if (jFV.size() < 10000) {
                jFV.add(aVar);
            }
        }
    }

    public static final boolean tW(String str) {
        if (!AppBrandPerformanceManager.tT(str)) {
            return false;
        }
        StringBuffer stringBuffer = new StringBuffer();
        synchronized (jFV) {
            x.d("MicroMsg.AppBrandPerformanceTracer", "dumpTrace events size: %d", new Object[]{Integer.valueOf(jFV.size())});
            for (a aVar : jFV) {
                if (aVar.appId.equals(str) && aVar.start >= sAppStartTime) {
                    stringBuffer.append(aVar.toString()).append("\n");
                }
            }
            jFV.clear();
        }
        return bw(str, stringBuffer.toString());
    }

    private static final boolean bw(String str, String str2) {
        Object e;
        Throwable th;
        boolean z = true;
        if (f.ze()) {
            FileWriter fileWriter = null;
            try {
                File file = new File(h.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MicroMsg/appbrand/trace/");
                if (!file.exists()) {
                    file.mkdirs();
                }
                FileWriter fileWriter2 = new FileWriter(new File(file, String.format("trace_%s_%d", new Object[]{str, Long.valueOf(sAppStartTime)})), true);
                try {
                    fileWriter2.write(str2);
                    try {
                        fileWriter2.close();
                    } catch (Exception e2) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileWriter = fileWriter2;
                    try {
                        x.e("MicroMsg.AppBrandPerformanceTracer", "dump file error: " + e);
                        if (fileWriter == null) {
                            try {
                                fileWriter.close();
                                z = false;
                            } catch (Exception e4) {
                                z = false;
                            }
                        } else {
                            z = false;
                        }
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (Exception e5) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileWriter = fileWriter2;
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                x.e("MicroMsg.AppBrandPerformanceTracer", "dump file error: " + e);
                if (fileWriter == null) {
                    z = false;
                } else {
                    fileWriter.close();
                    z = false;
                }
                return z;
            }
            return z;
        }
        x.e("MicroMsg.AppBrandPerformanceTracer", "dumpToFile error, SDCard is unavailable.");
        return false;
    }
}
