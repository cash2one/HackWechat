package com.tencent.mm.pluginsdk.i.a.e;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public final class a {
    public static long Gr(String str) {
        if (bh.ov(str)) {
            return 0;
        }
        File file = new File(str);
        if (file.isFile()) {
            return file.length();
        }
        return 0;
    }

    public static boolean u(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        Throwable e;
        if (bh.bw(bArr)) {
            return false;
        }
        File file = new File(str);
        file.delete();
        file.getParentFile().mkdirs();
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr);
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e2, "", new Object[0]);
                }
                return true;
            } catch (FileNotFoundException e3) {
                e2 = e3;
                try {
                    x.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e2, "", new Object[0]);
                    if (fileOutputStream != null) {
                        return false;
                    }
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return false;
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e22, "", new Object[0]);
                        return false;
                    }
                } catch (Throwable th) {
                    e22 = th;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                        } catch (Throwable e4) {
                            x.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e4, "", new Object[0]);
                        }
                    }
                    throw e22;
                }
            } catch (IOException e5) {
                e22 = e5;
                fileOutputStream2 = fileOutputStream;
                try {
                    x.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e22, "", new Object[0]);
                    if (fileOutputStream2 != null) {
                        return false;
                    }
                    try {
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                        return false;
                    } catch (Throwable e222) {
                        x.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e222, "", new Object[0]);
                        return false;
                    }
                } catch (Throwable th2) {
                    e222 = th2;
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                    }
                    throw e222;
                }
            }
        } catch (FileNotFoundException e6) {
            e222 = e6;
            fileOutputStream = null;
            x.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e222, "", new Object[0]);
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            return false;
        } catch (IOException e7) {
            e222 = e7;
            x.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e222, "", new Object[0]);
            if (fileOutputStream2 != null) {
                return false;
            }
            fileOutputStream2.flush();
            fileOutputStream2.close();
            return false;
        }
    }

    public static byte[] RZ(String str) {
        Throwable e;
        Throwable th;
        byte[] bArr = null;
        Closeable fileInputStream;
        Closeable byteArrayOutputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (FileNotFoundException e2) {
                e = e2;
                byteArrayOutputStream = bArr;
                try {
                    x.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
                    g(fileInputStream);
                    g(byteArrayOutputStream);
                    return bArr;
                } catch (Throwable th2) {
                    th = th2;
                    g(fileInputStream);
                    g(byteArrayOutputStream);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                byteArrayOutputStream = bArr;
                x.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
                g(fileInputStream);
                g(byteArrayOutputStream);
                return bArr;
            } catch (Throwable e4) {
                byteArrayOutputStream = bArr;
                th = e4;
                g(fileInputStream);
                g(byteArrayOutputStream);
                throw th;
            }
            try {
                byte[] bArr2 = new byte[Downloads.RECV_BUFFER_SIZE];
                while (true) {
                    int read = fileInputStream.read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                byteArrayOutputStream.flush();
                bArr = byteArrayOutputStream.toByteArray();
                g(fileInputStream);
                g(byteArrayOutputStream);
            } catch (FileNotFoundException e5) {
                e4 = e5;
                x.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e4, "", new Object[0]);
                g(fileInputStream);
                g(byteArrayOutputStream);
                return bArr;
            } catch (IOException e6) {
                e4 = e6;
                x.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e4, "", new Object[0]);
                g(fileInputStream);
                g(byteArrayOutputStream);
                return bArr;
            }
        } catch (FileNotFoundException e7) {
            e4 = e7;
            byteArrayOutputStream = bArr;
            fileInputStream = bArr;
            x.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e4, "", new Object[0]);
            g(fileInputStream);
            g(byteArrayOutputStream);
            return bArr;
        } catch (IOException e8) {
            e4 = e8;
            byteArrayOutputStream = bArr;
            fileInputStream = bArr;
            x.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e4, "", new Object[0]);
            g(fileInputStream);
            g(byteArrayOutputStream);
            return bArr;
        } catch (Throwable e42) {
            byteArrayOutputStream = bArr;
            fileInputStream = bArr;
            th = e42;
            g(fileInputStream);
            g(byteArrayOutputStream);
            throw th;
        }
        return bArr;
    }

    public static void g(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", e, "", new Object[0]);
                x.e("MicroMsg.ResDownloaderFileUtils", String.format("%s close failed (%s)", new Object[]{closeable.getClass().getSimpleName(), e.getMessage()}));
            }
        }
    }

    public static boolean Sa(String str) {
        if (bh.ov(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || file.delete()) {
            return true;
        }
        return false;
    }

    public static boolean bO(String str) {
        if (bh.ov(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            return true;
        }
        return false;
    }
}
