package com.tencent.recovery.crash;

import java.lang.Thread.UncaughtExceptionHandler;

public class DefaultExceptionHandler extends RecoveryExceptionHandler {
    private UncaughtExceptionHandler zRq;

    public DefaultExceptionHandler(UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zRq = uncaughtExceptionHandler;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        super.uncaughtException(thread, th);
        if (this.zRq != null) {
            this.zRq.uncaughtException(thread, th);
        }
    }
}
