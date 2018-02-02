package com.tencent.mm.console;

import android.os.Debug;
import android.os.Debug.MemoryInfo;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.console.b.14;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.Thread.State;

class b$14$1 implements a {
    final /* synthetic */ 14 gIC;

    b$14$1(14 14) {
        this.gIC = 14;
    }

    public final boolean uF() {
        LineNumberReader lineNumberReader;
        Exception e;
        Throwable th;
        if (d.fM(23)) {
            x.i("MicroMsg.CommandProcessor", "gcCount: %s", new Object[]{Debug.getRuntimeStats()});
        } else {
            int globalGcInvocationCount = Debug.getGlobalGcInvocationCount();
            int threadGcInvocationCount = Debug.getThreadGcInvocationCount();
            x.i("MicroMsg.CommandProcessor", "gcCount: %d %d", new Object[]{Integer.valueOf(globalGcInvocationCount), Integer.valueOf(threadGcInvocationCount)});
        }
        long pss = Debug.getPss();
        Debug.getMemoryInfo(new MemoryInfo());
        if (d.fM(23)) {
            x.i("MicroMsg.CommandProcessor", "pss: %d, memoryInfo:%s", new Object[]{Long.valueOf(pss), r2.getMemoryStats()});
        } else {
            x.i("MicroMsg.CommandProcessor", "pss: %d, memoryInfo:%d", new Object[]{Long.valueOf(pss), Integer.valueOf(r2.nativePss)});
        }
        try {
            Process exec = Runtime.getRuntime().exec("top -m 5 -n 1");
            lineNumberReader = new LineNumberReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                try {
                    String readLine = lineNumberReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (readLine.length() > 0) {
                        x.i("MicroMsg.CommandProcessor", readLine);
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }
            exec.waitFor();
            exec.destroy();
            try {
                lineNumberReader.close();
            } catch (Exception e3) {
                x.e("MicroMsg.CommandProcessor", "getRunningProcessesByPs finally got ex = %s", new Object[]{e3.getMessage()});
            }
        } catch (Exception e4) {
            e3 = e4;
            lineNumberReader = null;
            try {
                x.e("MicroMsg.CommandProcessor", "getRunningAppProcessesByPs fail, ex = %s", new Object[]{e3.getMessage()});
                if (lineNumberReader != null) {
                    try {
                        lineNumberReader.close();
                    } catch (Exception e32) {
                        x.e("MicroMsg.CommandProcessor", "getRunningProcessesByPs finally got ex = %s", new Object[]{e32.getMessage()});
                    }
                }
                x.i("MicroMsg.CommandProcessor", "thread count:%d", new Object[]{Integer.valueOf(Thread.activeCount())});
                for (Thread name : Thread.getAllStackTraces().keySet()) {
                    if (name.getState() == State.RUNNABLE) {
                        x.i("MicroMsg.CommandProcessor", "Running thread: %s\n %s", new Object[]{name.getName(), ai.b((StackTraceElement[]) r1.get((Thread) r2.next()))});
                    }
                }
                return true;
            } catch (Throwable th2) {
                th = th2;
                if (lineNumberReader != null) {
                    try {
                        lineNumberReader.close();
                    } catch (Exception e5) {
                        x.e("MicroMsg.CommandProcessor", "getRunningProcessesByPs finally got ex = %s", new Object[]{e5.getMessage()});
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            lineNumberReader = null;
            if (lineNumberReader != null) {
                lineNumberReader.close();
            }
            throw th;
        }
        x.i("MicroMsg.CommandProcessor", "thread count:%d", new Object[]{Integer.valueOf(Thread.activeCount())});
        for (Thread name2 : Thread.getAllStackTraces().keySet()) {
            if (name2.getState() == State.RUNNABLE) {
                x.i("MicroMsg.CommandProcessor", "Running thread: %s\n %s", new Object[]{name2.getName(), ai.b((StackTraceElement[]) r1.get((Thread) r2.next()))});
            }
        }
        return true;
    }
}
