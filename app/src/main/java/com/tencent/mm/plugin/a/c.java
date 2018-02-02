package com.tencent.mm.plugin.a;

import com.tencent.mm.sdk.platformtools.x;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;

public final class c {
    public static boolean oy(String str) {
        Throwable e;
        if (ov(str)) {
            return false;
        }
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[8];
                if (fileInputStream.read(bArr, 0, 8) < 8) {
                    try {
                        fileInputStream.close();
                        return false;
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.AtomUtil", e2, "", new Object[0]);
                        return false;
                    }
                }
                int y = y(bArr, 0);
                if (y(bArr, 4) != a.ajn || y <= 0) {
                    try {
                        fileInputStream.close();
                        return false;
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.AtomUtil", e22, "", new Object[0]);
                        return false;
                    }
                }
                try {
                    fileInputStream.close();
                } catch (Throwable e222) {
                    x.printErrStackTrace("MicroMsg.AtomUtil", e222, "", new Object[0]);
                }
                return true;
            } catch (Exception e3) {
                e222 = e3;
                try {
                    x.printErrStackTrace("MicroMsg.AtomUtil", e222, "", new Object[0]);
                    if (fileInputStream != null) {
                        return false;
                    }
                    try {
                        fileInputStream.close();
                        return false;
                    } catch (Throwable e2222) {
                        x.printErrStackTrace("MicroMsg.AtomUtil", e2222, "", new Object[0]);
                        return false;
                    }
                } catch (Throwable th) {
                    e2222 = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e4) {
                            x.printErrStackTrace("MicroMsg.AtomUtil", e4, "", new Object[0]);
                        }
                    }
                    throw e2222;
                }
            }
        } catch (Exception e5) {
            e2222 = e5;
            fileInputStream = null;
            x.printErrStackTrace("MicroMsg.AtomUtil", e2222, "", new Object[0]);
            if (fileInputStream != null) {
                return false;
            }
            fileInputStream.close();
            return false;
        } catch (Throwable th2) {
            e2222 = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e2222;
        }
    }

    public static boolean ov(String str) {
        if (str == null || str.length() <= 0) {
            return true;
        }
        return false;
    }

    public static int ak(String str) {
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            i2 = (i2 << 8) | str.charAt(i);
            i++;
        }
        return i2;
    }

    public static int y(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return ((((bArr[i2] & 255) << 16) | ((bArr[i] & 255) << 24)) | ((bArr[i3] & 255) << 8)) | (bArr[i3 + 1] & 255);
    }

    public static long z(byte[] bArr, int i) {
        Object obj = new byte[8];
        Arrays.fill(obj, (byte) 0);
        System.arraycopy(bArr, i, obj, 4, 4);
        return P(obj);
    }

    public static long P(byte[] bArr) {
        return ((((((((((long) bArr[0]) & 255) << 56) | ((((long) bArr[1]) & 255) << 48)) | ((((long) bArr[2]) & 255) << 40)) | ((((long) bArr[3]) & 255) << 32)) | ((((long) bArr[4]) & 255) << 24)) | ((((long) bArr[5]) & 255) << 16)) | ((((long) bArr[6]) & 255) << 8)) | (((long) bArr[7]) & 255);
    }

    public static a a(RandomAccessFile randomAccessFile, byte[] bArr, int i) {
        try {
            int read = randomAccessFile.read(bArr);
            while (read >= 8) {
                int y = y(bArr, 0);
                int y2 = y(bArr, 4);
                if (y2 != i) {
                    if (y2 != a.ajO && y2 != a.ajS) {
                        if (!a(randomAccessFile, (long) (y - 8))) {
                            break;
                        }
                        read = randomAccessFile.read(bArr);
                    } else {
                        read = randomAccessFile.read(bArr);
                    }
                } else {
                    long filePointer = randomAccessFile.getFilePointer() - ((long) read);
                    if (y2 == a.ajQ) {
                        return new i(y, filePointer, y2, 0);
                    }
                    if (y2 == a.ajR) {
                        return new e(y, filePointer, y2, 0);
                    }
                    return y2 == a.ajT ? new h(y, filePointer, y2, 0) : new a(y, filePointer, y2, 0);
                }
            }
            return null;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AtomUtil", e, "", new Object[0]);
            x.e("MicroMsg.AtomUtil", "find Atom error: " + e.toString());
            return null;
        }
    }

    public static boolean a(RandomAccessFile randomAccessFile, long j) {
        long j2 = 0;
        while (j > 2147483647L) {
            j2 += (long) randomAccessFile.skipBytes(Integer.MAX_VALUE);
            j -= 2147483647L;
        }
        j2 += (long) randomAccessFile.skipBytes((int) j);
        if (j2 == j) {
            return true;
        }
        x.w("MicroMsg.AtomUtil", "can not skip.skip: " + j + " trueSkip : " + j2);
        return false;
    }
}
