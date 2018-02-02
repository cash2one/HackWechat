package com.tencent.smtt.utils;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public final class r {
    private static r Abp = null;
    private File Abd = null;
    public boolean Abn = false;
    private boolean Abo = false;
    private File Abq = null;
    private Context mContext = null;

    private r(Context context) {
        this.mContext = context.getApplicationContext();
        cFE();
    }

    private synchronized void cFE() {
        Throwable th;
        BufferedInputStream bufferedInputStream = null;
        BufferedInputStream bufferedInputStream2;
        try {
            if (this.Abq == null) {
                this.Abq = cFF();
            }
            if (this.Abq != null) {
                bufferedInputStream2 = new BufferedInputStream(new FileInputStream(this.Abq));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream2);
                    String property = properties.getProperty("setting_forceUseSystemWebview", "");
                    if (!"".equals(property)) {
                        this.Abn = Boolean.parseBoolean(property);
                    }
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception e) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (Exception e2) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            bufferedInputStream2 = null;
            th = th4;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            throw th;
        }
        return;
    }

    private File cFF() {
        File file;
        try {
            if (this.Abd == null) {
                this.Abd = new File(this.mContext.getDir("tbs", 0), "core_private");
                if (this.Abd == null || !this.Abd.isDirectory()) {
                    return null;
                }
            }
            file = new File(this.Abd, "debug.conf");
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Throwable th) {
            file = null;
        }
        return file;
    }

    public static synchronized r cFG() {
        r rVar;
        synchronized (r.class) {
            rVar = Abp;
        }
        return rVar;
    }

    public static synchronized r ia(Context context) {
        r rVar;
        synchronized (r.class) {
            if (Abp == null) {
                Abp = new r(context);
            }
            rVar = Abp;
        }
        return rVar;
    }

    public final void nT(boolean z) {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        Throwable th;
        BufferedOutputStream bufferedOutputStream2 = null;
        this.Abo = z;
        try {
            File cFF = cFF();
            if (cFF == null) {
                BufferedInputStream bufferedInputStream3 = null;
                try {
                    bufferedInputStream3.close();
                } catch (Exception e) {
                }
                bufferedOutputStream = null;
                try {
                    bufferedOutputStream.close();
                    return;
                } catch (Exception e2) {
                    return;
                }
            }
            Properties properties;
            bufferedInputStream = new BufferedInputStream(new FileInputStream(cFF));
            try {
                properties = new Properties();
                properties.load(bufferedInputStream);
                properties.setProperty("setting_forceUseSystemWebview", Boolean.toString(this.Abn));
                properties.setProperty("result_systemWebviewForceUsed", Boolean.toString(this.Abo));
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(cFF));
            } catch (Throwable th2) {
                th = th2;
                try {
                    bufferedInputStream.close();
                } catch (Exception e3) {
                }
                try {
                    bufferedOutputStream2.close();
                } catch (Exception e4) {
                }
                throw th;
            }
            try {
                properties.store(bufferedOutputStream, null);
                try {
                    bufferedInputStream.close();
                } catch (Exception e5) {
                }
                try {
                    bufferedOutputStream.close();
                } catch (Exception e6) {
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                bufferedOutputStream2 = bufferedOutputStream;
                th = th4;
                bufferedInputStream.close();
                bufferedOutputStream2.close();
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedInputStream = null;
            bufferedInputStream.close();
            bufferedOutputStream2.close();
            throw th;
        }
    }
}
