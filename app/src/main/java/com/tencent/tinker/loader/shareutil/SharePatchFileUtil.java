package com.tencent.tinker.loader.shareutil;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class SharePatchFileUtil {
    private static char[] xfo = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static File iy(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return null;
        }
        return new File(applicationInfo.dataDir, "tinker");
    }

    public static File iz(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return null;
        }
        return new File(applicationInfo.dataDir, "tinker_temp");
    }

    public static File iA(Context context) {
        File iz = iz(context);
        if (iz == null) {
            return null;
        }
        return new File(iz, "tinker_last_crash");
    }

    public static File abH(String str) {
        return new File(str + "/patch.info");
    }

    public static File abI(String str) {
        return new File(str + "/info.lock");
    }

    public static String abJ(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        return "patch-" + str.substring(0, 8);
    }

    public static String abK(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        return abJ(str) + ".apk";
    }

    public static boolean abL(String str) {
        if (str == null || str.length() != 32) {
            return false;
        }
        return true;
    }

    public static String iB(Context context) {
        Object bufferedReader;
        Object e;
        Throwable th;
        File iA = iA(context);
        if (!ae(iA)) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(iA)));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        stringBuffer.append(readLine);
                        stringBuffer.append("\n");
                    } else {
                        cy(bufferedReader);
                        return stringBuffer.toString();
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
            try {
                new StringBuilder("checkTinkerLastUncaughtCrash exception: ").append(e);
                cy(bufferedReader);
                return null;
            } catch (Throwable th2) {
                th = th2;
                cy(bufferedReader);
                throw th;
            }
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            cy(bufferedReader);
            throw th;
        }
    }

    @SuppressLint({"NewApi"})
    public static void cy(Object obj) {
        if (obj != null) {
            if (obj instanceof Closeable) {
                try {
                    ((Closeable) obj).close();
                } catch (Throwable th) {
                }
            } else if (VERSION.SDK_INT >= 19 && (obj instanceof AutoCloseable)) {
                try {
                    ((AutoCloseable) obj).close();
                } catch (Throwable th2) {
                }
            } else if (obj instanceof ZipFile) {
                try {
                    ((ZipFile) obj).close();
                } catch (Throwable th3) {
                }
            } else {
                throw new IllegalArgumentException("obj: " + obj + " cannot be closed.");
            }
        }
    }

    public static final boolean ae(File file) {
        return file != null && file.exists() && file.canRead() && file.isFile() && file.length() > 0;
    }

    public static long af(File file) {
        long j = 0;
        if (file == null || !file.exists()) {
            return 0;
        }
        if (file.isFile()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                j += af(file2);
            } else {
                j += file2.length();
            }
        }
        return j;
    }

    public static final boolean ag(File file) {
        boolean z = true;
        if (file != null && file.exists()) {
            new StringBuilder("safeDeleteFile, try to delete path: ").append(file.getPath());
            z = file.delete();
            if (!z) {
                new StringBuilder("Failed to delete file, try to delete when exit. path: ").append(file.getPath());
                file.deleteOnExit();
            }
        }
        return z;
    }

    public static final boolean bP(String str) {
        if (str == null) {
            return false;
        }
        return g(new File(str));
    }

    public static final boolean g(File file) {
        int i = 0;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isFile()) {
            ag(file);
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                while (i < length) {
                    g(listFiles[i]);
                    i++;
                }
                ag(file);
            }
        }
        return true;
    }

    public static boolean f(File file, String str) {
        if (str == null) {
            return false;
        }
        String ah = ah(file);
        if (ah != null) {
            return str.equals(ah);
        }
        return false;
    }

    public static boolean abM(String str) {
        if (str == null) {
            return false;
        }
        return str.endsWith(".dex");
    }

    public static boolean g(File file, String str) {
        return b(file, "classes.dex", str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(File file, String str, String str2) {
        Throwable th;
        ZipFile zipFile = null;
        if (file == null || str2 == null || str == null) {
            return false;
        }
        Object ah;
        if (abM(file.getName())) {
            ah = ah(file);
        } else {
            ZipFile zipFile2;
            try {
                zipFile2 = new ZipFile(file);
                try {
                    ZipEntry entry = zipFile2.getEntry(str);
                    if (entry == null) {
                        new StringBuilder("There's no entry named: classes.dex in ").append(file.getAbsolutePath());
                        a(zipFile2);
                        return false;
                    }
                    try {
                        InputStream inputStream = zipFile2.getInputStream(entry);
                        w(inputStream);
                        cy(inputStream);
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        Object obj = zipFile;
                        Throwable th4 = th3;
                        cy(obj);
                        throw th4;
                    }
                    ah = w(zipFile2.getInputStream(entry));
                    a(zipFile2);
                } catch (Throwable th5) {
                    th = th5;
                    a(zipFile2);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                zipFile2 = zipFile;
                a(zipFile2);
                throw th;
            }
        }
        return str2.equals(ah);
    }

    public static void m(File file, File file2) {
        Object fileOutputStream;
        Throwable th;
        Object obj = null;
        if (ae(file) && file2 != null && !file.getAbsolutePath().equals(file2.getAbsolutePath())) {
            File parentFile = file2.getParentFile();
            if (!(parentFile == null || parentFile.exists())) {
                parentFile.mkdirs();
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2, false);
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                    FileInputStream fileInputStream2 = fileInputStream;
                    cy(obj);
                    cy(fileOutputStream);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            cy(fileInputStream);
                            cy(fileOutputStream);
                            return;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    obj = fileInputStream;
                    cy(obj);
                    cy(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                cy(obj);
                cy(fileOutputStream);
                throw th;
            }
        }
    }

    public static String a(JarFile jarFile, JarEntry jarEntry) {
        Throwable th;
        StringBuilder stringBuilder = new StringBuilder();
        Object bufferedInputStream;
        try {
            byte[] bArr = new byte[16384];
            bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
            while (true) {
                try {
                    int read = bufferedInputStream.read(bArr);
                    if (read > 0) {
                        stringBuilder.append(new String(bArr, 0, read));
                    } else {
                        cy(bufferedInputStream);
                        return stringBuilder.toString();
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            cy(bufferedInputStream);
            throw th;
        }
    }

    private static String w(InputStream inputStream) {
        String str = null;
        if (inputStream != null) {
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                MessageDigest instance = MessageDigest.getInstance("MD5");
                StringBuilder stringBuilder = new StringBuilder(32);
                byte[] bArr = new byte[102400];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                }
                byte[] digest = instance.digest();
                for (byte b : digest) {
                    stringBuilder.append(Integer.toString((b & 255) + 256, 16).substring(1));
                }
                str = stringBuilder.toString();
            } catch (Exception e) {
            }
        }
        return str;
    }

    public static String bQ(byte[] bArr) {
        int i = 0;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            int length = digest.length;
            char[] cArr = new char[(length * 2)];
            int i2 = 0;
            while (i < length) {
                byte b = digest[i];
                int i3 = i2 + 1;
                cArr[i2] = xfo[(b >>> 4) & 15];
                i2 = i3 + 1;
                cArr[i3] = xfo[b & 15];
                i++;
            }
            return new String(cArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static String ah(File file) {
        Object fileInputStream;
        Throwable th;
        String str = null;
        if (file != null && file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    str = w(fileInputStream);
                    cy(fileInputStream);
                } catch (Exception e) {
                    cy(fileInputStream);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    cy(fileInputStream);
                    throw th;
                }
            } catch (Exception e2) {
                fileInputStream = str;
                cy(fileInputStream);
                return str;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                fileInputStream = str;
                th = th4;
                cy(fileInputStream);
                throw th;
            }
        }
        return str;
    }

    public static String n(File file, File file2) {
        String name;
        if (ShareTinkerInternals.cHi()) {
            try {
                String cHj = ShareTinkerInternals.cHj();
                File parentFile = file.getParentFile();
                name = file.getName();
                int lastIndexOf = name.lastIndexOf(46);
                if (lastIndexOf > 0) {
                    name = name.substring(0, lastIndexOf);
                }
                return parentFile.getAbsolutePath() + "/oat/" + cHj + "/" + name + ".odex";
            } catch (Throwable e) {
                throw new TinkerRuntimeException("getCurrentInstructionSet fail:", e);
            }
        }
        name = file.getName();
        if (!name.endsWith(".dex")) {
            int lastIndexOf2 = name.lastIndexOf(".");
            if (lastIndexOf2 < 0) {
                name = name + ".dex";
            } else {
                StringBuilder stringBuilder = new StringBuilder(lastIndexOf2 + 4);
                stringBuilder.append(name, 0, lastIndexOf2);
                stringBuilder.append(".dex");
                name = stringBuilder.toString();
            }
        }
        return new File(file2, name).getPath();
    }

    public static void a(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException e) {
            }
        }
    }

    public static boolean h(File file, String str) {
        Throwable th;
        Throwable th2;
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry("resources.arsc");
                if (entry == null) {
                    a(zipFile2);
                    return false;
                }
                InputStream inputStream = zipFile2.getInputStream(entry);
                String w = w(inputStream);
                if (w == null || !w.equals(str)) {
                    cy(inputStream);
                    a(zipFile2);
                    return false;
                }
                cy(inputStream);
                a(zipFile2);
                return true;
            } catch (Throwable th3) {
                th2 = th3;
                zipFile = zipFile2;
                a(zipFile);
                throw th2;
            }
        } catch (Throwable th4) {
            th = th4;
            new StringBuilder("checkResourceArscMd5 throwable:").append(th.getMessage());
            a(zipFile);
            return false;
        }
    }

    public static void ai(File file) {
        if (file != null) {
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
        }
    }
}
