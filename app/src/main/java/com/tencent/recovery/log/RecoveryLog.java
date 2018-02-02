package com.tencent.recovery.log;

import java.util.ArrayList;

public class RecoveryLog {
    private static RecoveryLogImpl hJY = new RecoveryCacheLog();

    public interface RecoveryLogImpl {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        void v(String str, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    public static void i(String str, String str2, Object... objArr) {
        if (hJY != null) {
            hJY.i(str, str2, objArr);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (hJY != null) {
            hJY.e(str, str2, objArr);
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (hJY != null) {
            hJY.printErrStackTrace(str, th, str2, objArr);
        }
    }

    public static void a(RecoveryLogImpl recoveryLogImpl) {
        if (hJY instanceof RecoveryCacheLog) {
            RecoveryCacheLog recoveryCacheLog = (RecoveryCacheLog) hJY;
            int size = recoveryCacheLog.zRr.size();
            for (int i = 0; i < size; i++) {
                LogItem logItem = (LogItem) recoveryCacheLog.zRr.get(i);
                switch (logItem.level) {
                    case 1:
                        recoveryLogImpl.v(logItem.tag, logItem.zRs, logItem.zRt);
                        break;
                    case 2:
                        recoveryLogImpl.d(logItem.tag, logItem.zRs, logItem.zRt);
                        break;
                    case 3:
                        recoveryLogImpl.i(logItem.tag, logItem.zRs, logItem.zRt);
                        break;
                    case 4:
                        recoveryLogImpl.w(logItem.tag, logItem.zRs, logItem.zRt);
                        break;
                    case 5:
                        if (logItem.zRu == null) {
                            recoveryLogImpl.e(logItem.tag, logItem.zRs, logItem.zRt);
                            break;
                        } else {
                            recoveryLogImpl.printErrStackTrace(logItem.tag, logItem.zRu, logItem.zRs, logItem.zRt);
                            break;
                        }
                    default:
                        break;
                }
            }
            recoveryCacheLog.zRr = new ArrayList();
        }
        hJY = recoveryLogImpl;
    }

    public static void cDj() {
        if (hJY instanceof RecoveryFileLog) {
            ((RecoveryFileLog) hJY).br("", true);
        }
    }

    public static RecoveryLogImpl cDk() {
        return hJY;
    }
}
