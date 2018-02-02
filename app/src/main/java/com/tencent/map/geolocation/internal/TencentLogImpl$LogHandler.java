package com.tencent.map.geolocation.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import c.t.m.g.j;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

final class TencentLogImpl$LogHandler extends Handler {
    private static final String TXWATCHDOG = "txwatchdog";
    private File mDest;
    final /* synthetic */ TencentLogImpl this$0;

    private TencentLogImpl$LogHandler(TencentLogImpl tencentLogImpl, Looper looper) {
        this.this$0 = tencentLogImpl;
        super(looper);
        this.mDest = makeSureDest();
    }

    public final void handleMessage(Message message) {
        Closeable bufferedOutputStream;
        IOException e;
        Throwable th;
        super.handleMessage(message);
        if (this.mDest == null || !"txwatchdog".equals(this.mDest.getName())) {
            this.mDest = makeSureDest();
        }
        try {
            byte[] bytes = message.obj.toString().getBytes("GBK");
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.mDest, true));
                try {
                    bufferedOutputStream.write(bytes);
                    bufferedOutputStream.flush();
                    j.a(bufferedOutputStream);
                    File access$500 = TencentLogImpl.access$500(this.this$0);
                    File file = this.mDest;
                    if (access$500 != null && file != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (file.length() > 409600) {
                            file.renameTo(new File(access$500, new StringBuilder(TencentLog.PREFIX).append(currentTimeMillis).toString()));
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (IOException e3) {
                e = e3;
                bufferedOutputStream = null;
                throw e;
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
                j.a(bufferedOutputStream);
                throw th;
            }
        } catch (IOException e4) {
            this.mDest = null;
        }
    }

    private File makeSureDest() {
        File access$500 = TencentLogImpl.access$500(this.this$0);
        if (!access$500.exists()) {
            access$500.mkdirs();
        }
        return new File(access$500, "txwatchdog");
    }
}
