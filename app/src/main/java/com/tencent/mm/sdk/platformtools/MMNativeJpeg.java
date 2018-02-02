package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class MMNativeJpeg {
    public static final int FAKE_PARTIAL_PROGRESSIVE_QUALITY = 25;
    public static final String TAG = "MMJPEG.JAVA";

    private static String exception2String(Throwable th) {
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void Destroy() {
    }

    private static boolean checkAndroidVersion() {
        if (VERSION.SDK_INT >= 11) {
            return true;
        }
        x.i(TAG, "early version before android 3.0  unsupported.");
        return false;
    }

    private static boolean checkFileExist(String str) {
        boolean z = false;
        try {
            z = new File(str).exists();
        } catch (Throwable e) {
            x.e(TAG, "checkfileexist. exception:%s", new Object[]{exception2String(e)});
        }
        return z;
    }

    public static int queryQuality(String str) {
        if (!checkAndroidVersion() || !checkFileExist(str)) {
            return 0;
        }
        try {
            int queryQuality = mmjpeg.queryQuality(str);
            x.i(TAG, "after query quality:%d", new Object[]{Integer.valueOf(queryQuality)});
            if (queryQuality < 10000 && queryQuality >= 24) {
                return queryQuality;
            }
            if (1 == mmjpeg.isProgressiveFile(str)) {
                return 25;
            }
            x.w(TAG, "invalid jpeg file or too small quality.");
            return 0;
        } catch (Throwable e) {
            x.e(TAG, "queryQuality failed. exception:%s", new Object[]{exception2String(e)});
            return 0;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.Crash", e2, "May cause dvmFindCatchBlock crash!", new Object[0]);
            throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e2));
        } catch (Error e3) {
            x.e(TAG, "queryQuality error. java.lang.UnsatisfiedLinkError: queryQuality, %s", new Object[]{e3.toString()});
            return 0;
        }
    }

    public static boolean isProgressive(String str) {
        x.v(TAG, "isProgressive:%s", new Object[]{str});
        if (!checkAndroidVersion() || !checkFileExist(str)) {
            return false;
        }
        x.d(TAG, "check progressive for file:%s", new Object[]{str});
        try {
            int isProgressiveFile = mmjpeg.isProgressiveFile(str);
            if (1 == isProgressiveFile || isProgressiveFile == 0) {
                x.i(TAG, "file:%s progressive:%d", new Object[]{str, Integer.valueOf(isProgressiveFile)});
                if (isProgressiveFile == 1) {
                    return true;
                }
                return false;
            }
            x.e(TAG, "check failed. error:%d", new Object[]{Integer.valueOf(isProgressiveFile)});
            return false;
        } catch (Throwable e) {
            x.e(TAG, "isProgressive exception:%s", new Object[]{exception2String(e)});
            return false;
        }
    }

    public static boolean convertToProgressive(String str, int i) {
        if (!checkAndroidVersion()) {
            return false;
        }
        try {
            String str2 = str + ".prog.dat";
            x.d(TAG, "convert %s to %s use progressive.quality:%d", new Object[]{str, str2, Integer.valueOf(i)});
            if (mmjpeg.convertToProgressive(str, str2) != 0) {
                x.e(TAG, "convert failed. error:%d", new Object[]{Integer.valueOf(mmjpeg.convertToProgressive(str, str2))});
                return false;
            }
            x.i(TAG, "convert ret:%b", new Object[]{Boolean.valueOf(k.q(str2, str, true))});
            return k.q(str2, str, true);
        } catch (Throwable e) {
            x.e(TAG, "convertToProgressive exception:%s", new Object[]{exception2String(e)});
            return false;
        }
    }

    public static Bitmap decodeAsBitmap(String str) {
        x.v(TAG, "decodeAsBitmap:%s", new Object[]{str});
        try {
            JpegParams queryParams = mmjpeg.queryParams(str);
            if (queryParams == null) {
                x.e(TAG, "can't query jpeg parames.");
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(queryParams.Width, queryParams.Height, Config.ARGB_8888);
            if (mmjpeg.decodeToBitmap(str, createBitmap)) {
                x.i(TAG, "decode bitmap successed.");
                return createBitmap;
            }
            x.e(TAG, "can't decode to bmp.");
            return null;
        } catch (Throwable e) {
            x.e(TAG, "decodeAsBitmap exception:%s", new Object[]{exception2String(e)});
            return null;
        } catch (OutOfMemoryError e2) {
            x.e(TAG, "decodeAsBitmap OOM:%s", new Object[]{str});
            return null;
        }
    }

    public static boolean Convert2Baseline(String str, int i) {
        FileOutputStream fileOutputStream;
        Throwable e;
        if (isProgressive(str)) {
            FileOutputStream fileOutputStream2 = null;
            try {
                Bitmap decodeFile = BitmapFactory.decodeFile(str);
                if (decodeFile == null) {
                    x.i(TAG, "c2b:use mmjpeg to decode.");
                    decodeFile = decodeAsBitmap(str);
                }
                if (decodeFile != null) {
                    String str2 = str + ".base";
                    CompressFormat compressFormat = CompressFormat.JPEG;
                    fileOutputStream = new FileOutputStream(str2);
                    try {
                        if (decodeFile.compress(compressFormat, i, fileOutputStream)) {
                            x.i(TAG, "c2b: convert baseline %s ok.", new Object[]{str2});
                            boolean q = k.q(str2, str, true);
                            try {
                                fileOutputStream.close();
                                return q;
                            } catch (Exception e2) {
                                return q;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        fileOutputStream2 = fileOutputStream;
                        try {
                            x.e(TAG, "c2b:exception:%s", new Object[]{exception2String(e)});
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (Exception e4) {
                                }
                            }
                            return false;
                        } catch (Throwable th) {
                            e = th;
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (Exception e5) {
                                }
                            }
                            throw e;
                        }
                    } catch (OutOfMemoryError e6) {
                        fileOutputStream2 = fileOutputStream;
                        x.e(TAG, "c2b: oom");
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (Exception e7) {
                            }
                        }
                        return false;
                    } catch (Throwable th2) {
                        e = th2;
                        fileOutputStream2 = fileOutputStream;
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        throw e;
                    }
                }
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e8) {
                    }
                }
            } catch (Exception e9) {
                e = e9;
                x.e(TAG, "c2b:exception:%s", new Object[]{exception2String(e)});
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                return false;
            } catch (OutOfMemoryError e10) {
                x.e(TAG, "c2b: oom");
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                return false;
            }
            return false;
        }
        x.e(TAG, "c2b: not progressive file.%s", new Object[]{str});
        return true;
    }

    public static boolean IsJpegFile(String str) {
        try {
            if (mmjpeg.queryParams(str) != null) {
                return true;
            }
            x.e(TAG, "IsJpegFile : can't query jpeg parames.");
            return false;
        } catch (Throwable e) {
            x.e(TAG, "IsJpegFile exception:%s", new Object[]{exception2String(e)});
            return false;
        }
    }
}
