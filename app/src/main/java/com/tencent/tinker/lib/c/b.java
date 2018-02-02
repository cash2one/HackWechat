package com.tencent.tinker.lib.c;

import com.tencent.tinker.lib.f.a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class b {
    public static boolean a(ZipFile zipFile, ZipEntry zipEntry, File file, String str, boolean z) {
        Throwable th;
        Object obj;
        Object obj2 = null;
        boolean z2 = false;
        int i = 0;
        while (i < 2 && !z2) {
            int i2 = i + 1;
            a.i("Tinker.BasePatchInternal", "try Extracting " + file.getPath(), new Object[0]);
            try {
                InputStream bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                try {
                    OutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        byte[] bArr = new byte[16384];
                        while (true) {
                            int read = bufferedInputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            bufferedOutputStream.write(bArr, 0, read);
                        }
                        com.tencent.tinker.c.b.a.cy(bufferedOutputStream);
                        com.tencent.tinker.c.b.a.cy(bufferedInputStream);
                        z2 = str != null ? z ? SharePatchFileUtil.g(file, str) : SharePatchFileUtil.f(file, str) : true;
                        a.i("Tinker.BasePatchInternal", "isExtractionSuccessful: %b", new Object[]{Boolean.valueOf(z2)});
                        if (!z2 && (!file.delete() || file.exists())) {
                            a.e("Tinker.BasePatchInternal", "Failed to delete corrupted dex " + file.getPath(), new Object[0]);
                        }
                        i = i2;
                    } catch (Throwable th2) {
                        th = th2;
                        obj = bufferedOutputStream;
                        obj2 = bufferedInputStream;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    obj = null;
                    InputStream inputStream = bufferedInputStream;
                }
            } catch (Throwable th4) {
                th = th4;
                obj = null;
            }
        }
        return z2;
        com.tencent.tinker.c.b.a.cy(obj);
        com.tencent.tinker.c.b.a.cy(obj2);
        throw th;
    }

    public static int IR(int i) {
        if (i == 3) {
            return -3;
        }
        if (i == 5) {
            return -4;
        }
        if (i == 6) {
            return -8;
        }
        return 0;
    }
}
