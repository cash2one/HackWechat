package com.tencent.smtt.sdk;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

class n {
    private static Context mContext = null;
    private static n zXj = null;

    private n() {
    }

    static File cEg() {
        t.cEF();
        File file = new File(t.hi(mContext), "tbscoreinstall.txt");
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException e) {
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static Properties cEh() {
        BufferedInputStream bufferedInputStream;
        Properties properties;
        Throwable th;
        BufferedInputStream bufferedInputStream2 = null;
        Properties properties2;
        try {
            File cEg = cEg();
            properties2 = new Properties();
            if (cEg != null) {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(cEg));
                try {
                    properties2.load(bufferedInputStream);
                } catch (Exception e) {
                    bufferedInputStream2 = bufferedInputStream;
                    properties = properties2;
                    if (bufferedInputStream2 != null) {
                        return properties;
                    }
                    try {
                        bufferedInputStream2.close();
                        return properties;
                    } catch (IOException e2) {
                        return properties;
                    }
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    bufferedInputStream2 = bufferedInputStream;
                    th = th3;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th;
                }
            }
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e4) {
                }
            }
            return properties2;
        } catch (Exception e5) {
            properties = properties2;
            if (bufferedInputStream2 != null) {
                return properties;
            }
            bufferedInputStream2.close();
            return properties;
        } catch (Throwable th4) {
            th = th4;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            throw th;
        }
    }

    static n gF(Context context) {
        if (zXj == null) {
            synchronized (n.class) {
                if (zXj == null) {
                    zXj = new n();
                }
            }
        }
        mContext = context.getApplicationContext();
        return zXj;
    }

    final int abf(String str) {
        Properties cEh = cEh();
        return (cEh == null || cEh.getProperty(str) == null) ? -1 : Integer.parseInt(cEh.getProperty(str));
    }

    final int abg(String str) {
        Properties cEh = cEh();
        return (cEh == null || cEh.getProperty(str) == null) ? 0 : Integer.parseInt(cEh.getProperty(str));
    }

    final void dH(String str, int i) {
        fW(str, String.valueOf(i));
    }

    final void fE(int i, int i2) {
        dH("copy_core_ver", i);
        dH("copy_status", i2);
    }

    final void fF(int i, int i2) {
        dH("install_core_ver", i);
        dH("install_status", i2);
    }

    final void fW(String str, String str2) {
        FileOutputStream fileOutputStream;
        Throwable th;
        FileOutputStream fileOutputStream2 = null;
        try {
            Properties cEh = cEh();
            if (cEh != null) {
                cEh.setProperty(str, str2);
                File cEg = cEg();
                if (cEg != null) {
                    fileOutputStream = new FileOutputStream(cEg);
                    try {
                        cEh.store(fileOutputStream, "update " + str + " and status!");
                        fileOutputStream2 = fileOutputStream;
                    } catch (Exception e) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e2) {
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        fileOutputStream2 = fileOutputStream;
                        th = th3;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e3) {
                            }
                        }
                        throw th;
                    }
                }
            }
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e4) {
                }
            }
        } catch (Exception e5) {
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (Throwable th4) {
            th = th4;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th;
        }
    }

    final String getStringValue(String str) {
        Properties cEh = cEh();
        return (cEh == null || cEh.getProperty(str) == null) ? null : cEh.getProperty(str);
    }
}
