package com.tencent.map.geolocation.internal;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.format.DateFormat;
import java.io.File;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public final class TencentLogImpl implements TencentLog {
    private static boolean DEBUG = false;
    private static final String TAG = "TencentLogImpl";
    private final File mBackupDir;
    private Handler mHandler;
    private final Runnable mKiller;
    private boolean mPrepared;
    private HandlerThread mWorker;

    public TencentLogImpl(Context context, @Nullable File file) {
        this.mBackupDir = file;
        boolean z = file != null && (file.exists() || file.mkdirs());
        this.mPrepared = z;
        if (this.mPrepared) {
            this.mWorker = new HandlerThread("log_worker", 10);
            this.mWorker.start();
            this.mHandler = new LogHandler(this, this.mWorker.getLooper(), null);
        }
        this.mKiller = new 1(this);
        if (DEBUG) {
            new StringBuilder("log dir=").append(this.mBackupDir);
            if (!this.mPrepared) {
                new StringBuilder("init failed: mPrepared=").append(this.mPrepared);
            }
        }
    }

    public final void shutdown(long j) {
        if (_isPrepared()) {
            this.mHandler.removeCallbacks(this.mKiller);
            this.mHandler.postDelayed(this.mKiller, j);
        }
    }

    public final boolean tryRestart() {
        if (!_isPrepared()) {
            return false;
        }
        this.mHandler.removeCallbacks(this.mKiller);
        return true;
    }

    private boolean _isPrepared() {
        return this.mPrepared && this.mHandler != null;
    }

    final boolean isPrepared() {
        return this.mPrepared;
    }

    public static void setDebugEnabled(boolean z) {
        DEBUG = z;
    }

    public static boolean isDebugEnabled() {
        return DEBUG;
    }

    public final void println(String str, int i, @NonNull String str2) {
        if (_isPrepared()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(DateFormat.format("yyyy-MM-dd kk:mm:ss", System.currentTimeMillis()));
            stringBuilder.append(":").append(str);
            stringBuilder.append(":").append(str2).append("\n");
            this.mHandler.obtainMessage(1, stringBuilder.toString()).sendToTarget();
        }
    }

    public final String getDirString() {
        if (this.mBackupDir != null) {
            return this.mBackupDir.getName();
        }
        return null;
    }
}
