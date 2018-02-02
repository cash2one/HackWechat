package com.tencent.mm.plugin.report.service;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.os.StatFs;
import android.util.SparseArray;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting;
import com.tencent.mm.plugin.appbrand.jsapi.be;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetOpenDeviceId;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public final class f {
    private static SparseArray<Long> pQC = new SparseArray();
    private static SparseArray<HashMap<Integer, Integer>> pQD = new SparseArray();
    private static boolean pQE = true;
    private static long pQF = 0;
    private static long pQG = 0;
    private static long pQH = 0;

    public static final class a {
        public static a pQM;
        public volatile boolean hasInit;
        public long[] pQI;
        public int pQJ;
        public String pQK;
        public long pQL;

        public static synchronized a bom() {
            a aVar;
            synchronized (a.class) {
                if (pQM == null) {
                    aVar = new a();
                    pQM = aVar;
                    aVar.pQJ = yy();
                    pQM.pQK = ys();
                    a aVar2 = pQM;
                    ActivityManager activityManager = (ActivityManager) ac.getContext().getSystemService("activity");
                    MemoryInfo memoryInfo = new MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    aVar2.pQL = memoryInfo.availMem >> 10;
                    aVar = pQM;
                    long[] jArr = new long[2];
                    StatFs statFs = new StatFs(h.getDataDirectory().getPath());
                    jArr[0] = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
                    StatFs statFs2 = new StatFs(h.getDataDirectory().getPath());
                    jArr[1] = ((long) statFs2.getAvailableBlocks()) * ((long) statFs2.getBlockSize());
                    aVar.pQI = jArr;
                    pQM.hasInit = true;
                }
                aVar = pQM;
            }
            return aVar;
        }

        private static String ys() {
            FileReader fileReader;
            BufferedReader bufferedReader;
            String trim;
            Throwable e;
            Throwable th;
            String str = "N/A";
            try {
                fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq");
                try {
                    bufferedReader = new BufferedReader(fileReader);
                    try {
                        trim = bufferedReader.readLine().trim();
                        try {
                            bufferedReader.close();
                            try {
                                fileReader.close();
                            } catch (Throwable e2) {
                                x.printErrStackTrace("MicroMsg.ReportLogInfo", e2, "", new Object[0]);
                            }
                            try {
                                bufferedReader.close();
                            } catch (Throwable e22) {
                                x.printErrStackTrace("MicroMsg.ReportLogInfo", e22, "", new Object[0]);
                            }
                        } catch (FileNotFoundException e3) {
                            e22 = e3;
                            try {
                                x.printErrStackTrace("MicroMsg.ReportLogInfo", e22, "", new Object[0]);
                                if (fileReader != null) {
                                    try {
                                        fileReader.close();
                                    } catch (Throwable e222) {
                                        x.printErrStackTrace("MicroMsg.ReportLogInfo", e222, "", new Object[0]);
                                    }
                                }
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Throwable e2222) {
                                        x.printErrStackTrace("MicroMsg.ReportLogInfo", e2222, "", new Object[0]);
                                    }
                                }
                                return trim;
                            } catch (Throwable th2) {
                                th = th2;
                                if (fileReader != null) {
                                    try {
                                        fileReader.close();
                                    } catch (Throwable e22222) {
                                        x.printErrStackTrace("MicroMsg.ReportLogInfo", e22222, "", new Object[0]);
                                    }
                                }
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Throwable e222222) {
                                        x.printErrStackTrace("MicroMsg.ReportLogInfo", e222222, "", new Object[0]);
                                    }
                                }
                                throw th;
                            }
                        } catch (IOException e4) {
                            e222222 = e4;
                            x.printErrStackTrace("MicroMsg.ReportLogInfo", e222222, "", new Object[0]);
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Throwable e2222222) {
                                    x.printErrStackTrace("MicroMsg.ReportLogInfo", e2222222, "", new Object[0]);
                                }
                            }
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable e22222222) {
                                    x.printErrStackTrace("MicroMsg.ReportLogInfo", e22222222, "", new Object[0]);
                                }
                            }
                            return trim;
                        }
                    } catch (Throwable th3) {
                        e22222222 = th3;
                        trim = str;
                        x.printErrStackTrace("MicroMsg.ReportLogInfo", e22222222, "", new Object[0]);
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return trim;
                    } catch (Throwable th32) {
                        e22222222 = th32;
                        trim = str;
                        x.printErrStackTrace("MicroMsg.ReportLogInfo", e22222222, "", new Object[0]);
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return trim;
                    }
                } catch (Throwable th322) {
                    bufferedReader = null;
                    e22222222 = th322;
                    trim = str;
                    x.printErrStackTrace("MicroMsg.ReportLogInfo", e22222222, "", new Object[0]);
                    if (fileReader != null) {
                        fileReader.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return trim;
                } catch (Throwable th3222) {
                    bufferedReader = null;
                    e22222222 = th3222;
                    trim = str;
                    x.printErrStackTrace("MicroMsg.ReportLogInfo", e22222222, "", new Object[0]);
                    if (fileReader != null) {
                        fileReader.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return trim;
                } catch (Throwable th4) {
                    th3222 = th4;
                    bufferedReader = null;
                    if (fileReader != null) {
                        fileReader.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th3222;
                }
            } catch (Throwable th32222) {
                bufferedReader = null;
                fileReader = null;
                e22222222 = th32222;
                trim = str;
                x.printErrStackTrace("MicroMsg.ReportLogInfo", e22222222, "", new Object[0]);
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return trim;
            } catch (Throwable th322222) {
                bufferedReader = null;
                fileReader = null;
                e22222222 = th322222;
                trim = str;
                x.printErrStackTrace("MicroMsg.ReportLogInfo", e22222222, "", new Object[0]);
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return trim;
            } catch (Throwable th5) {
                th322222 = th5;
                bufferedReader = null;
                fileReader = null;
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th322222;
            }
            return trim;
        }

        private static int yy() {
            try {
                return new File("/sys/devices/system/cpu/").listFiles(new a()).length;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ReportLogInfo", e, "", new Object[0]);
                return 1;
            }
        }
    }

    public static void vz(int i) {
        if (pQE) {
            pQC.put(i, Long.valueOf(bh.Wp()));
            x.d("MicroMsg.ReportLogInfo", "ReportLogInfo operationBegin eventID:%d  time:%d", Integer.valueOf(i), Long.valueOf(bh.Wp()));
        }
    }

    public static void ed(long j) {
        if (pQE) {
            x.d("MicroMsg.ReportLogInfo", "ReportLogInfo operationBegin eventID:%d  with time:%d", Integer.valueOf(8), Long.valueOf(j));
            pQC.put(8, Long.valueOf(j));
        }
    }

    public static void vA(int i) {
        if (pQE) {
            Long l = (Long) pQC.get(i);
            if (l != null && l.longValue() != -1) {
                pQC.put(i, Long.valueOf(-1));
                long Wp = bh.Wp() - l.longValue();
                if (Wp > 0) {
                    switch (i) {
                        case 8:
                            if (!ac.xft) {
                                F(1, Wp);
                                E(GameJsApiGetOpenDeviceId.CTRL_BYTE, Wp);
                                g.pQN.c(23, 1, 2, (int) Wp, false);
                                break;
                            }
                            g.pQN.c(23, 4, 5, (int) Wp, false);
                            break;
                        case 9:
                            F(3, Wp);
                            E(be.CTRL_INDEX, Wp);
                            g.pQN.c(27, 1, 2, (int) Wp, false);
                            break;
                        case 10:
                            F(2, Wp);
                            E(JsApiOpenWeRunSetting.CTRL_INDEX, Wp);
                            g.pQN.c(28, 1, 2, (int) Wp, false);
                            break;
                        case 12:
                            F(6, Wp);
                            break;
                        case 13:
                            F(7, Wp);
                            break;
                        case 14:
                            F(8, Wp);
                            break;
                        case 18:
                            F(10, Wp);
                            break;
                        case 19:
                            F(9, Wp);
                            break;
                        case 20:
                            F(12, Wp);
                            break;
                        case 21:
                            F(11, Wp);
                            break;
                        case 22:
                            F(13, Wp);
                            break;
                        case 23:
                            F(16, Wp);
                            break;
                        case 24:
                            F(15, Wp);
                            break;
                        case 25:
                            F(14, Wp);
                            break;
                    }
                    x.i("MicroMsg.ReportLogInfo", "ReportLogInfo operationEnd eventID:%d  time:%d", Integer.valueOf(i), Long.valueOf(Wp));
                }
            }
        }
    }

    private static void E(int i, long j) {
        if (j > 0) {
            if (j < 1000) {
                g.pQN.V(i, 0, 1);
            } else if (j < 2000) {
                g.pQN.V(i, 0, 3);
            } else if (j < 5000) {
                g.pQN.V(i, 0, 5);
            } else if (j < 10000) {
                g.pQN.V(i, 0, 7);
            } else {
                g.pQN.V(i, 0, 9);
            }
        }
    }

    private static void F(int i, long j) {
        long currentTimeMillis;
        if (i == 6) {
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis >= pQF + 60000) {
                pQF = currentTimeMillis;
            } else {
                return;
            }
        } else if (i == 7) {
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis >= pQG + 60000) {
                pQG = currentTimeMillis;
            } else {
                return;
            }
        } else if (i == 8) {
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis >= pQH + 60000) {
                pQH = currentTimeMillis;
            } else {
                return;
            }
        }
        if (a.bom().hasInit) {
            g.pQN.a(11335, true, false, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(r0.pQJ), Long.valueOf(r0.pQI[0]), Long.valueOf(r0.pQI[1]), Long.valueOf(r0.pQL));
            return;
        }
        g.pQN.a(11335, true, false, Integer.valueOf(i), Long.valueOf(j));
    }

    public static void vB(int i) {
        if (pQE) {
            x.d("MicroMsg.ReportLogInfo", "ReportLogInfo stopOperation stop eventID:%d", Integer.valueOf(i));
            pQC.put(i, Long.valueOf(-1));
        }
    }
}
