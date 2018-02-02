package com.tencent.mm.sdk.platformtools;

import java.io.File;
import java.io.IOException;

public class FLock {
    private File iFl;
    private volatile int xeF;

    private static native int nativeFree(int i);

    private static native int nativeInit(String str);

    private static native int nativeLockRead(int i, boolean z);

    private static native int nativeLockWrite(int i, boolean z);

    private static native int nativeUnlock(int i);

    public FLock(String str) {
        this(new File(str), true);
    }

    public FLock(File file, boolean z) {
        this.iFl = null;
        this.xeF = -1;
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        } else if (!file.isFile()) {
            throw new IllegalArgumentException("target is not a file.");
        }
        this.iFl = file;
    }

    protected void finalize() {
        super.finalize();
        unlock();
    }

    private synchronized int init() {
        if (!this.iFl.exists()) {
            try {
                this.iFl.createNewFile();
            } catch (IOException e) {
            }
            this.xeF = -1;
        }
        if (this.xeF == -1) {
            this.xeF = nativeInit(this.iFl.getAbsolutePath());
        }
        return this.xeF;
    }

    private synchronized void free() {
        if (this.xeF != -1) {
            nativeFree(this.xeF);
            this.xeF = -1;
        }
    }

    public final synchronized void ceS() {
        int init = init();
        while (true) {
            switch (nativeLockRead(init, true)) {
                case 4:
                case 11:
                    try {
                        Thread.sleep(0);
                    } catch (InterruptedException e) {
                    }
                case 9:
                    throw new IllegalStateException("bad file descriptor.");
                case 22:
                    throw new IllegalStateException("bad operation.");
                case 46:
                    throw new IllegalStateException("kernel lock spaces ran out.");
                default:
            }
        }
    }

    public final synchronized boolean ceT() {
        boolean z = false;
        synchronized (this) {
            int init = init();
            while (true) {
                switch (nativeLockWrite(init, false)) {
                    case 4:
                        try {
                            Thread.sleep(0);
                        } catch (InterruptedException e) {
                        }
                    case 9:
                        throw new IllegalStateException("bad file descriptor.");
                    case 11:
                        break;
                    case 22:
                        throw new IllegalStateException("bad operation.");
                    case 46:
                        throw new IllegalStateException("kernel lock spaces ran out.");
                    default:
                        z = true;
                        break;
                }
            }
        }
        return z;
    }

    public final synchronized void ceU() {
        int init = init();
        while (true) {
            switch (nativeLockWrite(init, true)) {
                case 4:
                case 11:
                    try {
                        Thread.sleep(0);
                    } catch (InterruptedException e) {
                    }
                case 9:
                    throw new IllegalStateException("bad file descriptor.");
                case 22:
                    throw new IllegalStateException("bad operation.");
                case 46:
                    throw new IllegalStateException("kernel lock spaces ran out.");
                default:
            }
        }
    }

    public final synchronized void unlock() {
        if (this.xeF != -1) {
            try {
                int nativeUnlock = nativeUnlock(this.xeF);
                switch (nativeUnlock) {
                    case 0:
                        free();
                        break;
                    case 9:
                        throw new IllegalArgumentException(this.xeF + " is not a valid fd.");
                    case 22:
                        throw new IllegalStateException("bad operation.");
                    default:
                        throw new IllegalStateException("other err: " + nativeUnlock);
                }
            } catch (Throwable th) {
                free();
            }
        }
    }
}
