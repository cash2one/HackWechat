package org.xwalk.core;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import g.a.b.a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

class XWalkDecompressor {
    private static final int LZMA_OUTSIZE = 8;
    private static final int LZMA_PROP_SIZE = 5;
    private static final String[] MANDATORY_LIBRARIES = new String[]{"libxwalkcore.so"};
    private static final String[] MANDATORY_RESOURCES = XWalkEnvironment.MANDATORY_RESOURCES;
    private static final int STREAM_BUFFER_SIZE = 1048576;
    private static final String TAG = "XWalkLib";

    XWalkDecompressor() {
    }

    public static boolean extractResource(String str, String str2) {
        IOException e;
        Throwable th;
        Log.i(TAG, "Extract resource from Apk " + str);
        long uptimeMillis = SystemClock.uptimeMillis();
        ZipFile zipFile;
        try {
            zipFile = new ZipFile(str);
            try {
                for (String str3 : MANDATORY_RESOURCES) {
                    ZipEntry entry;
                    if (isNativeLibrary(str3)) {
                        entry = zipFile.getEntry("lib" + File.separator + "armeabi" + File.separator + str3);
                    } else if (isAsset(str3)) {
                        entry = zipFile.getEntry("assets" + File.separator + str3);
                    } else {
                        entry = zipFile.getEntry(str3);
                    }
                    if (entry == null) {
                        Log.e(TAG, str3 + " not found");
                        try {
                            zipFile.close();
                            return false;
                        } catch (IOException e2) {
                            return false;
                        } catch (NullPointerException e3) {
                            return false;
                        }
                    }
                    Log.d(TAG, "Extracting " + str3);
                    File file = new File(str2, str3);
                    if (file.isFile() && file.exists()) {
                        file.delete();
                    }
                    extractStreamToFile(zipFile.getInputStream(entry), new File(str2, str3));
                }
                try {
                    zipFile.close();
                } catch (IOException e4) {
                } catch (NullPointerException e5) {
                }
                System.gc();
                Log.d(TAG, "Time to extract : " + (SystemClock.uptimeMillis() - uptimeMillis) + " ms");
                return true;
            } catch (IOException e6) {
                e = e6;
            }
        } catch (IOException e7) {
            e = e7;
            zipFile = null;
            try {
                Log.e(TAG, "Extract error:" + e.getLocalizedMessage());
                try {
                    zipFile.close();
                    return false;
                } catch (IOException e8) {
                    return false;
                } catch (NullPointerException e9) {
                    return false;
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    zipFile.close();
                } catch (IOException e10) {
                } catch (NullPointerException e11) {
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            zipFile = null;
            zipFile.close();
            throw th;
        }
    }

    public static boolean decompressDownloadFullZip(String str, int i) {
        IOException e;
        Throwable th;
        Log.i(TAG, "decompress full zip from zip " + str + ",version:" + i);
        long uptimeMillis = SystemClock.uptimeMillis();
        ZipFile zipFile;
        try {
            zipFile = new ZipFile(str);
            Enumeration entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                File file;
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                InputStream inputStream = zipFile.getInputStream(zipEntry);
                String encode = URLEncoder.encode(zipEntry.getName(), "UTF-8");
                Log.i(TAG, "decompressDownloadFullZip fileName:" + encode);
                if (encode.equals(XWalkEnvironment.XWALK_CORE_APK_NAME)) {
                    file = new File(XWalkEnvironment.getDownloadApkPath(i));
                } else {
                    file = new File(XWalkEnvironment.getExtractedCoreFile(i, encode));
                }
                if (file.exists()) {
                    file.delete();
                } else {
                    File parentFile = file.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                }
                OutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[STREAM_BUFFER_SIZE];
                for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                    fileOutputStream.write(bArr, 0, read);
                }
                try {
                    fileOutputStream.close();
                    inputStream.close();
                } catch (IOException e2) {
                    e = e2;
                }
            }
            try {
                zipFile.close();
            } catch (IOException e3) {
            } catch (NullPointerException e4) {
            }
            System.gc();
            Log.d(TAG, "Time to decompress : " + (SystemClock.uptimeMillis() - uptimeMillis) + " ms");
            return true;
        } catch (IOException e5) {
            e = e5;
            zipFile = null;
            try {
                Log.e(TAG, "decompressDownloadPatchZip error:" + e.getLocalizedMessage());
                try {
                    zipFile.close();
                } catch (IOException e6) {
                } catch (NullPointerException e7) {
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                try {
                    zipFile.close();
                } catch (IOException e8) {
                } catch (NullPointerException e9) {
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            zipFile = null;
            zipFile.close();
            throw th;
        }
    }

    public static boolean decompressDownloadPatchZip(String str, String str2) {
        IOException e;
        Throwable th;
        Log.d(TAG, "decompress from zip " + str);
        long uptimeMillis = SystemClock.uptimeMillis();
        ZipFile zipFile;
        try {
            zipFile = new ZipFile(str);
            try {
                Enumeration entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                    InputStream inputStream = zipFile.getInputStream(zipEntry);
                    File file = new File(str2, URLEncoder.encode(zipEntry.getName(), "UTF-8"));
                    if (file.exists()) {
                        file.delete();
                    } else {
                        File parentFile = file.getParentFile();
                        if (!parentFile.exists()) {
                            parentFile.mkdirs();
                        }
                    }
                    OutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] bArr = new byte[STREAM_BUFFER_SIZE];
                    for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.close();
                    inputStream.close();
                }
                try {
                    zipFile.close();
                } catch (IOException e2) {
                } catch (NullPointerException e3) {
                }
                System.gc();
                Log.d(TAG, "Time to decompress : " + (SystemClock.uptimeMillis() - uptimeMillis) + " ms");
                return true;
            } catch (IOException e4) {
                e = e4;
            }
        } catch (IOException e5) {
            e = e5;
            zipFile = null;
            try {
                Log.e(TAG, "decompressDownloadPatchZip error:" + e.getLocalizedMessage());
                try {
                    zipFile.close();
                } catch (IOException e6) {
                } catch (NullPointerException e7) {
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                try {
                    zipFile.close();
                } catch (IOException e8) {
                } catch (NullPointerException e9) {
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            zipFile = null;
            zipFile.close();
            throw th;
        }
    }

    private static boolean isNativeLibrary(String str) {
        return str.endsWith(".so");
    }

    private static boolean isAsset(String str) {
        return str.endsWith(".dat") || str.endsWith(".pak");
    }

    private static InputStream openRawResource(String str) {
        Context applicationContext = XWalkEnvironment.getApplicationContext();
        Resources resources = applicationContext.getResources();
        return resources.openRawResource(resources.getIdentifier(str.split("\\.")[0], "raw", applicationContext.getPackageName()));
    }

    private static void extractLzmaToFile(InputStream inputStream, File file) {
        InputStream bufferedInputStream;
        OutputStream bufferedOutputStream;
        IOException e;
        Throwable th;
        InputStream inputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            } catch (IOException e2) {
                e = e2;
                bufferedOutputStream = null;
                inputStream2 = bufferedInputStream;
                try {
                    if (file.isFile()) {
                        file.delete();
                    }
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = inputStream2;
                    try {
                        bufferedOutputStream.flush();
                    } catch (IOException e3) {
                    } catch (NullPointerException e4) {
                    }
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e5) {
                    } catch (NullPointerException e6) {
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e7) {
                    } catch (NullPointerException e8) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                bufferedInputStream.close();
                throw th;
            }
            try {
                byte[] bArr = new byte[5];
                if (bufferedInputStream.read(bArr, 0, 5) != 5) {
                    throw new IOException("Input lzma file is too short");
                }
                a aVar = new a();
                if (aVar.ci(bArr)) {
                    long j = 0;
                    for (int i = 0; i < 8; i++) {
                        int read = bufferedInputStream.read();
                        if (read < 0) {
                            Log.w(TAG, "Can't read stream size");
                        }
                        j |= ((long) read) << (i * 8);
                    }
                    if (aVar.a(bufferedInputStream, bufferedOutputStream, j)) {
                        try {
                            bufferedOutputStream.flush();
                        } catch (IOException e9) {
                        } catch (NullPointerException e10) {
                        }
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e11) {
                        } catch (NullPointerException e12) {
                        }
                        try {
                            bufferedInputStream.close();
                            return;
                        } catch (IOException e13) {
                            return;
                        } catch (NullPointerException e14) {
                            return;
                        }
                    }
                    throw new IOException("Error in data stream");
                }
                throw new IOException("Incorrect lzma properties");
            } catch (IOException e15) {
                e = e15;
                inputStream2 = bufferedInputStream;
                if (file.isFile()) {
                    file.delete();
                }
                throw e;
            } catch (Throwable th4) {
                th = th4;
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                bufferedInputStream.close();
                throw th;
            }
        } catch (IOException e16) {
            e = e16;
            bufferedOutputStream = null;
            if (file.isFile()) {
                file.delete();
            }
            throw e;
        } catch (Throwable th5) {
            th = th5;
            bufferedOutputStream = null;
            bufferedInputStream = null;
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            bufferedInputStream.close();
            throw th;
        }
    }

    private static void extractStreamToFile(InputStream inputStream, File file) {
        OutputStream fileOutputStream;
        IOException e;
        Throwable th;
        try {
            inputStream.available();
            fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[STREAM_BUFFER_SIZE];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read >= 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        try {
                            break;
                        } catch (IOException e2) {
                        } catch (NullPointerException e3) {
                        }
                    }
                }
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                } catch (NullPointerException e5) {
                }
                try {
                    inputStream.close();
                } catch (IOException e6) {
                } catch (NullPointerException e7) {
                }
            } catch (IOException e8) {
                e = e8;
                try {
                    if (file.isFile()) {
                        file.delete();
                    }
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        fileOutputStream.flush();
                    } catch (IOException e9) {
                    } catch (NullPointerException e10) {
                    }
                    try {
                        fileOutputStream.close();
                    } catch (IOException e11) {
                    } catch (NullPointerException e12) {
                    }
                    try {
                        inputStream.close();
                    } catch (IOException e13) {
                    } catch (NullPointerException e14) {
                    }
                    throw th;
                }
            }
        } catch (IOException e15) {
            e = e15;
            fileOutputStream = null;
            if (file.isFile()) {
                file.delete();
            }
            throw e;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            fileOutputStream.flush();
            fileOutputStream.close();
            inputStream.close();
            throw th;
        }
    }

    public static void copyApkToLocal(String str, String str2) {
        Log.d(TAG, "Copy to local from Apk " + str);
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    fileOutputStream.close();
                    return;
                }
            }
        } catch (Exception e) {
            Log.e("copyApkToLocal error:", e.getMessage());
        }
    }
}
