package com.tencent.mm.ca;

import android.app.ActivityManager;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Environment;
import android.os.Process;
import android.widget.Toast;
import com.tencent.mm.a.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b {
    public static final String xCV = (Environment.getExternalStorageDirectory() + "/tencent/MicroMsg/memory/");

    private static boolean clm() {
        if (c.ze()) {
            File file = new File(xCV);
            if (!file.exists()) {
                file.mkdirs();
            }
            return true;
        }
        x.i("MicroMsg.MemoryDumpManager", "Hprof sdcard is invalid");
        return false;
    }

    private static boolean Q(boolean z, boolean z2) {
        if (!clm()) {
            return false;
        }
        File file = new File(xCV);
        File[] listFiles = file.listFiles();
        if (listFiles.length == 0) {
            return true;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        long time = new Date().getTime();
        boolean z3 = true;
        for (File file2 : listFiles) {
            String name = file2.getName();
            int indexOf = name.indexOf(".hprof");
            if (indexOf > 0) {
                Object substring = name.substring(0, indexOf);
                try {
                    Date parse = simpleDateFormat.parse(substring);
                    if (parse == null) {
                        file2.delete();
                    } else {
                        long time2 = parse.getTime();
                        if (time2 >= time) {
                            file2.delete();
                        } else {
                            time2 = (time - time2) / 86400000;
                            if (time2 >= 3) {
                                file2.delete();
                            } else if (z && time2 < 1) {
                                z3 = false;
                            }
                        }
                    }
                } catch (ParseException e) {
                    x.e("MicroMsg.MemoryDumpManager", "hprofFileCheck parse date fail %s", new Object[]{substring});
                    file2.delete();
                }
            } else {
                file2.delete();
            }
        }
        File[] listFiles2 = file.listFiles();
        if (listFiles2.length <= 5) {
            return z3;
        }
        if (z2) {
            Toast.makeText(ac.getContext(), "dump fail, hprof file size exceed", 0).show();
        }
        x.w("MicroMsg.MemoryDumpManager", "hprofFileCheck hprofFileDir.length() too large " + listFiles2.length);
        return false;
    }

    public static String R(boolean z, boolean z2) {
        if (!Q(z, z2)) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(xCV).append(format).append(".hprof");
        String stringBuffer2 = stringBuffer.toString();
        if (J(new File(stringBuffer2).getParentFile())) {
            try {
                cln();
                Debug.dumpHprofData(stringBuffer2);
                if (z2) {
                    Toast.makeText(ac.getContext(), stringBuffer2 + " hprof file has saved ", 0).show();
                }
                x.i("MicroMsg.MemoryDumpManager", "dump file %s, use time %d", new Object[]{format, Long.valueOf(bh.bz(currentTimeMillis))});
                return stringBuffer2;
            } catch (Exception e) {
                x.e("MicroMsg.MemoryDumpManager", " dumpHprofFile Exception");
                return null;
            }
        }
        x.i("MicroMsg.MemoryDumpManager", "failed to create dir for hprof file: %s", new Object[]{stringBuffer2});
        return null;
    }

    public static String Yk(String str) {
        if (!clm()) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(xCV).append(str).append(".hprof");
        String stringBuffer2 = stringBuffer.toString();
        if (J(new File(stringBuffer2).getParentFile())) {
            try {
                cln();
                Debug.dumpHprofData(stringBuffer2);
                Toast.makeText(ac.getContext(), stringBuffer2 + " hprof file has saved ", 0).show();
                x.i("MicroMsg.MemoryDumpManager", "dump file %s, use time %d", new Object[]{str, Long.valueOf(bh.bz(currentTimeMillis))});
                File file = new File(stringBuffer2);
                if (file.exists()) {
                    stringBuffer2 = p.a(file, true, null);
                    if (stringBuffer2 != null) {
                        return stringBuffer2;
                    }
                    x.e("MicroMsg.MemoryDumpManager", "zip hprof file fail");
                    return null;
                }
                x.e("MicroMsg.MemoryDumpManager", "Hprof dump file is not exist");
                return null;
            } catch (Exception e) {
                x.e("MicroMsg.MemoryDumpManager", " dumpHprofFile Exception");
                return null;
            }
        }
        x.i("MicroMsg.MemoryDumpManager", "failed to create dir for hprof file: %s", new Object[]{stringBuffer2});
        return null;
    }

    private static boolean J(File file) {
        if (file.exists() || file.mkdirs()) {
            return true;
        }
        return file.exists();
    }

    public static void cln() {
        Runtime.getRuntime().gc();
        System.runFinalization();
    }

    public static void clo() {
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2;
        Throwable th;
        Throwable th2;
        LineNumberReader lineNumberReader = null;
        if (VERSION.SDK_INT >= 14) {
            clp();
            return;
        }
        LineNumberReader lineNumberReader2;
        try {
            Process exec = Runtime.getRuntime().exec("dumpsys meminfo " + Process.myPid());
            inputStreamReader = new InputStreamReader(exec.getInputStream());
            try {
                lineNumberReader2 = new LineNumberReader(inputStreamReader);
                while (true) {
                    try {
                        String readLine = lineNumberReader2.readLine();
                        if (readLine != null) {
                            x.i("MicroMsg.MemoryDumpManager", readLine);
                        } else {
                            exec.waitFor();
                            exec.destroy();
                            try {
                                lineNumberReader2.close();
                                inputStreamReader.close();
                                return;
                            } catch (IOException e) {
                                return;
                            }
                        }
                    } catch (IOException e2) {
                        inputStreamReader2 = inputStreamReader;
                    } catch (InterruptedException e3) {
                        lineNumberReader = lineNumberReader2;
                    } catch (Throwable th3) {
                        th = th3;
                        lineNumberReader = lineNumberReader2;
                        th2 = th;
                    }
                }
            } catch (IOException e4) {
                lineNumberReader2 = null;
                inputStreamReader2 = inputStreamReader;
                try {
                    x.e("MicroMsg.MemoryDumpManager", " dumpSysMeminfo IOException");
                    if (lineNumberReader2 != null) {
                        try {
                            lineNumberReader2.close();
                        } catch (IOException e5) {
                            return;
                        }
                    }
                    if (inputStreamReader2 != null) {
                        inputStreamReader2.close();
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStreamReader = inputStreamReader2;
                    lineNumberReader = lineNumberReader2;
                    th2 = th;
                    if (lineNumberReader != null) {
                        try {
                            lineNumberReader.close();
                        } catch (IOException e6) {
                            throw th2;
                        }
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    throw th2;
                }
            } catch (InterruptedException e7) {
                try {
                    x.e("MicroMsg.MemoryDumpManager", " dumpSysMeminfo InterruptedException");
                    if (lineNumberReader != null) {
                        try {
                            lineNumberReader.close();
                        } catch (IOException e8) {
                            return;
                        }
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                } catch (Throwable th5) {
                    th2 = th5;
                    if (lineNumberReader != null) {
                        lineNumberReader.close();
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    throw th2;
                }
            }
        } catch (IOException e9) {
            lineNumberReader2 = null;
            x.e("MicroMsg.MemoryDumpManager", " dumpSysMeminfo IOException");
            if (lineNumberReader2 != null) {
                lineNumberReader2.close();
            }
            if (inputStreamReader2 != null) {
                inputStreamReader2.close();
            }
        } catch (InterruptedException e10) {
            inputStreamReader = null;
            x.e("MicroMsg.MemoryDumpManager", " dumpSysMeminfo InterruptedException");
            if (lineNumberReader != null) {
                lineNumberReader.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
        } catch (Throwable th6) {
            th2 = th6;
            inputStreamReader = null;
            if (lineNumberReader != null) {
                lineNumberReader.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            throw th2;
        }
    }

    public static void clp() {
        ActivityManager activityManager = (ActivityManager) ac.getContext().getSystemService("activity");
        x.i("MicroMsg.MemoryDumpManager", " wechat heap info ");
        x.i("MicroMsg.MemoryDumpManager", " Runtime.totalMemory " + Runtime.getRuntime().totalMemory());
        x.i("MicroMsg.MemoryDumpManager", " Runtime.freeMemory " + Runtime.getRuntime().freeMemory());
        x.i("MicroMsg.MemoryDumpManager", " Runtime.maxMemory " + Runtime.getRuntime().maxMemory());
        x.i("MicroMsg.MemoryDumpManager", " Debug.nativeHeapSize " + Debug.getNativeHeapSize());
        x.i("MicroMsg.MemoryDumpManager", " Debug.nativeHeapAllocatedSize " + Debug.getNativeHeapAllocatedSize());
        for (MemoryInfo memoryInfo : activityManager.getProcessMemoryInfo(new int[]{Process.myPid()})) {
            x.i("MicroMsg.MemoryDumpManager", " wechat memory info");
            x.i("MicroMsg.MemoryDumpManager", " pidMemoryInfo.getTotalPrivateDirty(): " + memoryInfo.getTotalPrivateDirty() + "\n");
            x.i("MicroMsg.MemoryDumpManager", " pidMemoryInfo.getTotalPss(): " + memoryInfo.getTotalPss() + "\n");
            x.i("MicroMsg.MemoryDumpManager", " pidMemoryInfo.getTotalSharedDirty(): " + memoryInfo.getTotalSharedDirty() + "\n");
        }
    }
}
