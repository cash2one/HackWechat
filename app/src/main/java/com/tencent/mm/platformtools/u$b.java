package com.tencent.mm.platformtools;

import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class u$b {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String p(File file) {
        JarFile jarFile;
        Throwable e;
        JarFile jarFile2;
        InputStream inputStream = null;
        InputStream inputStream2;
        try {
            jarFile = new JarFile(file);
            try {
                X509Certificate x509Certificate;
                Object obj;
                String bt;
                byte[] bArr = new byte[8192];
                Enumeration entries = jarFile.entries();
                inputStream2 = null;
                while (entries.hasMoreElements()) {
                    try {
                        JarEntry jarEntry = (JarEntry) entries.nextElement();
                        if (!(jarEntry.isDirectory() || jarEntry.getName().startsWith("META-INF/"))) {
                            String name = jarEntry.getName();
                            if (!("resources.arsc".equals(name) || "AndroidManifest.xml".equals(name) || jarEntry.getSize() > 5120)) {
                                long currentTimeMillis = System.currentTimeMillis();
                                x.d("voken", "name = " + name);
                                inputStream2 = jarFile.getInputStream(jarEntry);
                                x.d("voken", "get is cost " + (System.currentTimeMillis() - currentTimeMillis));
                                if (inputStream2 != null) {
                                    do {
                                    } while (inputStream2.read(bArr, 0, 8192) != -1);
                                    inputStream2.close();
                                }
                                Certificate[] certificates = jarEntry.getCertificates();
                                if (certificates == null || certificates.length == 0) {
                                    throw new SecurityException("The apk file has unsigned res:" + jarEntry.getName());
                                }
                                if (inputStream == null) {
                                    x509Certificate = (X509Certificate) certificates[0];
                                    if (x509Certificate != null) {
                                        inputStream = inputStream2;
                                        break;
                                    }
                                }
                                obj = inputStream;
                                inputStream = x509Certificate;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        inputStream = inputStream2;
                        jarFile2 = jarFile;
                    } catch (Throwable th) {
                        e = th;
                    }
                }
                obj = inputStream;
                inputStream = inputStream2;
                if (x509Certificate != null) {
                    bt = ab.bt(new String(O(x509Certificate.getEncoded())).getBytes());
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e3) {
                            x.printErrStackTrace("MicroMsg.YYBMarketVerify", e3, "", new Object[0]);
                        }
                    }
                    try {
                        jarFile.close();
                    } catch (Throwable e32) {
                        x.printErrStackTrace("MicroMsg.YYBMarketVerify", e32, "", new Object[0]);
                    }
                } else {
                    bt = "";
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e322) {
                            x.printErrStackTrace("MicroMsg.YYBMarketVerify", e322, "", new Object[0]);
                        }
                    }
                    try {
                        jarFile.close();
                    } catch (Throwable e3222) {
                        x.printErrStackTrace("MicroMsg.YYBMarketVerify", e3222, "", new Object[0]);
                    }
                }
                return bt;
            } catch (Exception e4) {
                e = e4;
                jarFile2 = jarFile;
                try {
                    x.printErrStackTrace("MicroMsg.YYBMarketVerify", e, "", new Object[0]);
                    throw e;
                } catch (Throwable th2) {
                    e = th2;
                    jarFile = jarFile2;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Throwable e32222) {
                            x.printErrStackTrace("MicroMsg.YYBMarketVerify", e32222, "", new Object[0]);
                        }
                    }
                    if (jarFile != null) {
                        try {
                            jarFile.close();
                        } catch (Throwable e322222) {
                            x.printErrStackTrace("MicroMsg.YYBMarketVerify", e322222, "", new Object[0]);
                        }
                    }
                    throw e;
                }
            } catch (Throwable th3) {
                e = th3;
                inputStream2 = null;
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (jarFile != null) {
                    jarFile.close();
                }
                throw e;
            }
        } catch (Exception e5) {
            e = e5;
            Object obj2 = null;
            x.printErrStackTrace("MicroMsg.YYBMarketVerify", e, "", new Object[0]);
            throw e;
        } catch (Throwable th4) {
            e = th4;
            inputStream2 = null;
            jarFile = null;
            if (inputStream2 != null) {
                inputStream2.close();
            }
            if (jarFile != null) {
                jarFile.close();
            }
            throw e;
        }
    }

    private static char[] O(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[(length * 2)];
        for (int i = 0; i < length; i++) {
            byte b = bArr[i];
            int i2 = (b >> 4) & 15;
            cArr[i * 2] = (char) (i2 >= 10 ? (i2 + 97) - 10 : i2 + 48);
            i2 = b & 15;
            int i3 = (i * 2) + 1;
            if (i2 >= 10) {
                i2 = (i2 + 97) - 10;
            } else {
                i2 += 48;
            }
            cArr[i3] = (char) i2;
        }
        return cArr;
    }
}
