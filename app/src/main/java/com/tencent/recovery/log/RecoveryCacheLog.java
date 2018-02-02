package com.tencent.recovery.log;

import com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl;
import java.util.ArrayList;
import java.util.List;

public class RecoveryCacheLog implements RecoveryLogImpl {
    List<LogItem> zRr = new ArrayList(100);

    private class LogItem {
        int level;
        String tag;
        String zRs;
        Object[] zRt;
        Throwable zRu;
        final /* synthetic */ RecoveryCacheLog zRv;

        private LogItem(RecoveryCacheLog recoveryCacheLog) {
            this.zRv = recoveryCacheLog;
        }
    }

    public final void v(String str, String str2, Object... objArr) {
        if (this.zRr.size() < 100) {
            LogItem logItem = new LogItem();
            logItem.level = 1;
            logItem.tag = str;
            logItem.zRs = str2;
            logItem.zRt = objArr;
            this.zRr.add(logItem);
        }
        String.format(str2, objArr);
    }

    public final void d(String str, String str2, Object... objArr) {
        if (this.zRr.size() < 100) {
            LogItem logItem = new LogItem();
            logItem.level = 2;
            logItem.tag = str;
            logItem.zRs = str2;
            logItem.zRt = objArr;
            this.zRr.add(logItem);
        }
        String.format(str2, objArr);
    }

    public final void i(String str, String str2, Object... objArr) {
        if (this.zRr.size() < 100) {
            LogItem logItem = new LogItem();
            logItem.level = 3;
            logItem.tag = str;
            logItem.zRs = str2;
            logItem.zRt = objArr;
            this.zRr.add(logItem);
        }
        String.format(str2, objArr);
    }

    public final void w(String str, String str2, Object... objArr) {
        if (this.zRr.size() < 100) {
            LogItem logItem = new LogItem();
            logItem.level = 4;
            logItem.tag = str;
            logItem.zRs = str2;
            logItem.zRt = objArr;
            this.zRr.add(logItem);
        }
        String.format(str2, objArr);
    }

    public final void e(String str, String str2, Object... objArr) {
        if (this.zRr.size() < 100) {
            LogItem logItem = new LogItem();
            logItem.level = 5;
            logItem.tag = str;
            logItem.zRs = str2;
            logItem.zRt = objArr;
            this.zRr.add(logItem);
        }
        String.format(str2, objArr);
    }

    public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (this.zRr.size() < 100) {
            LogItem logItem = new LogItem();
            logItem.level = 5;
            logItem.tag = str;
            logItem.zRs = str2;
            logItem.zRt = objArr;
            logItem.zRu = th;
            this.zRr.add(logItem);
        }
        String.format(str2, objArr);
    }
}
