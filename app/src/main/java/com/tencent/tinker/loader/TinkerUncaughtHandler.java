package com.tencent.tinker.loader;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.UncaughtExceptionHandler;

public class TinkerUncaughtHandler implements UncaughtExceptionHandler {
    private final File AjJ;
    private final Context context;
    private final UncaughtExceptionHandler xfM = Thread.getDefaultUncaughtExceptionHandler();

    public TinkerUncaughtHandler(Context context) {
        this.context = context;
        this.AjJ = SharePatchFileUtil.iA(context);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        Object printWriter;
        Throwable e;
        new StringBuilder("TinkerUncaughtHandler catch exception:").append(Log.getStackTraceString(th));
        this.xfM.uncaughtException(thread, th);
        if (this.AjJ != null && (Thread.getDefaultUncaughtExceptionHandler() instanceof TinkerUncaughtHandler)) {
            File parentFile = this.AjJ.getParentFile();
            if (parentFile.exists() || parentFile.mkdirs()) {
                try {
                    printWriter = new PrintWriter(new FileWriter(this.AjJ, false));
                    try {
                        printWriter.println("process:" + ShareTinkerInternals.iI(this.context));
                        printWriter.println(ShareTinkerInternals.j(th));
                        SharePatchFileUtil.cy(printWriter);
                    } catch (IOException e2) {
                        e = e2;
                        try {
                            new StringBuilder("print crash file error:").append(Log.getStackTraceString(e));
                            SharePatchFileUtil.cy(printWriter);
                            Process.killProcess(Process.myPid());
                        } catch (Throwable th2) {
                            e = th2;
                            SharePatchFileUtil.cy(printWriter);
                            throw e;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    printWriter = null;
                    new StringBuilder("print crash file error:").append(Log.getStackTraceString(e));
                    SharePatchFileUtil.cy(printWriter);
                    Process.killProcess(Process.myPid());
                } catch (Throwable th3) {
                    e = th3;
                    printWriter = null;
                    SharePatchFileUtil.cy(printWriter);
                    throw e;
                }
                Process.killProcess(Process.myPid());
            }
        }
    }
}
