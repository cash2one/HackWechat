package com.tencent.mm.compatible.util;

import android.annotation.TargetApi;
import android.os.Environment;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public final class h {
    private static Boolean gHK = null;

    public static File getExternalStorageDirectory() {
        if (bh.ov(q.gGe.gFn)) {
            return Environment.getExternalStorageDirectory();
        }
        return new File(q.gGe.gFn);
    }

    @TargetApi(8)
    public static File getExternalStoragePublicDirectory(String str) {
        if (bh.ov(q.gGe.gFo)) {
            return Environment.getExternalStoragePublicDirectory(str);
        }
        return new File(q.gGe.gFo);
    }

    public static File getDataDirectory() {
        if (bh.ov(q.gGe.gFp)) {
            return Environment.getDataDirectory();
        }
        return new File(q.gGe.gFp);
    }

    public static File getRootDirectory() {
        if (bh.ov(q.gGe.gFq)) {
            return Environment.getRootDirectory();
        }
        return new File(q.gGe.gFq);
    }

    public static File getDownloadCacheDirectory() {
        if (bh.ov(q.gGe.gFs)) {
            return Environment.getDownloadCacheDirectory();
        }
        return new File(q.gGe.gFs);
    }

    public static String getExternalStorageState() {
        if (bh.ov(q.gGe.gFr)) {
            return Environment.getExternalStorageState();
        }
        return q.gGe.gFr;
    }

    public static boolean zj() {
        FileInputStream fileInputStream;
        Throwable e;
        if (gHK == null) {
            try {
                fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                try {
                    Properties properties = new Properties();
                    properties.load(fileInputStream);
                    gHK = Boolean.valueOf(properties.containsKey("ro.miui.ui.version.name"));
                    try {
                        fileInputStream.close();
                    } catch (Exception e2) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        x.printErrStackTrace("MicroMsg.Environment", e, "** failed to fetch miui prop, assume we are not on miui. **", new Object[0]);
                        gHK = Boolean.valueOf(false);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        return gHK.booleanValue();
                    } catch (Throwable th) {
                        e = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e5) {
                            }
                        }
                        throw e;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                fileInputStream = null;
                x.printErrStackTrace("MicroMsg.Environment", e, "** failed to fetch miui prop, assume we are not on miui. **", new Object[0]);
                gHK = Boolean.valueOf(false);
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return gHK.booleanValue();
            } catch (Throwable th2) {
                e = th2;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e;
            }
        }
        return gHK.booleanValue();
    }
}
