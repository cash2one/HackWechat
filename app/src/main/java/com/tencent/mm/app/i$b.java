package com.tencent.mm.app;

import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class i$b implements Runnable {
    final /* synthetic */ i ffx;

    private i$b(i iVar) {
        this.ffx = iVar;
    }

    private static ProcessErrorStateInfo tW() {
        List<ProcessErrorStateInfo> processesInErrorState = ((ActivityManager) ac.getContext().getSystemService("activity")).getProcessesInErrorState();
        if (processesInErrorState == null) {
            return null;
        }
        for (ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
            if (processErrorStateInfo.uid == Process.myUid() && processErrorStateInfo.condition == 2) {
                return processErrorStateInfo;
            }
        }
        return null;
    }

    public final void run() {
        ArrayList arrayList;
        long currentTimeMillis = System.currentTimeMillis();
        x.i("MicroMsg.MMCrashReporter", "ANR Parser started.");
        ProcessErrorStateInfo processErrorStateInfo = null;
        while (this.ffx.ffp.block(10000)) {
            this.ffx.ffp.close();
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
            processErrorStateInfo = tW();
            if (processErrorStateInfo != null) {
                break;
            }
        }
        if (processErrorStateInfo == null) {
            processErrorStateInfo = tW();
            if (processErrorStateInfo == null) {
                x.w("MicroMsg.MMCrashReporter", "ANR process not found, exit thread.");
                this.ffx.ffv = null;
                return;
            }
        }
        ProcessErrorStateInfo processErrorStateInfo2 = processErrorStateInfo;
        x.i("MicroMsg.MMCrashReporter", "Got ANR process: " + processErrorStateInfo2.processName + " @ " + processErrorStateInfo2.pid);
        synchronized (this.ffx.ffm) {
            String str;
            arrayList = new ArrayList(this.ffx.ffm.size());
            int lastIndexOf = this.ffx.ffo.lastIndexOf(46);
            if (lastIndexOf != -1) {
                str = this.ffx.ffo.substring(0, lastIndexOf) + '_' + processErrorStateInfo2.processName + this.ffx.ffo.substring(lastIndexOf);
                if (this.ffx.ffm.remove(str)) {
                    arrayList.add(str);
                }
            }
            if (this.ffx.ffm.remove(this.ffx.ffo)) {
                arrayList.add(this.ffx.ffo);
            }
            arrayList.addAll(this.ffx.ffm);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            str = i.a(this.ffx.ffn + '/' + ((String) it.next()), processErrorStateInfo2.pid, currentTimeMillis, processErrorStateInfo2);
            if (str != null) {
                x.i("MicroMsg.MMCrashReporter", "Parse ANR trace '%s': OK.", new Object[]{r0});
                this.ffx.r(str, processErrorStateInfo2.pid);
                break;
            }
            x.i("MicroMsg.MMCrashReporter", "Parse ANR trace '%s': Not found.", new Object[]{r0});
        }
        x.i("MicroMsg.MMCrashReporter", "ANR Parser ended.");
        this.ffx.ffv = null;
    }
}
