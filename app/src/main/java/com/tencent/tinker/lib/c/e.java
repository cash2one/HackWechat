package com.tencent.tinker.lib.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.tinker.d.a.d;
import com.tencent.tinker.d.a.f;
import com.tencent.tinker.d.a.g;
import com.tencent.tinker.d.a.g.1;
import com.tencent.tinker.d.a.h;
import com.tencent.tinker.d.a.i;
import com.tencent.tinker.lib.f.a;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareResPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareResPatchInfo.LargeModeInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class e extends b {
    static boolean c(Context context, String str, String str2, File file) {
        g gVar;
        Throwable th;
        Object obj;
        h hVar;
        Object obj2;
        g gVar2;
        ShareResPatchInfo shareResPatchInfo = new ShareResPatchInfo();
        ShareResPatchInfo.a(str2, shareResPatchInfo);
        a.i("Tinker.ResDiffPatchInternal", "res dir: %s, meta: %s", new Object[]{str, shareResPatchInfo.toString()});
        com.tencent.tinker.lib.e.a ip = com.tencent.tinker.lib.e.a.ip(context);
        if (SharePatchFileUtil.abL(shareResPatchInfo.AlH)) {
            File file2 = new File(str);
            File file3 = new File(file2, "res_temp");
            File file4 = new File(file2, "resources.apk");
            if (!file4.exists()) {
                file4.getParentFile().mkdirs();
            } else if (SharePatchFileUtil.h(file4, shareResPatchInfo.AlH)) {
                a.w("Tinker.ResDiffPatchInternal", "resource file %s is already exist, and md5 match, just return true", new Object[]{file4.getPath()});
                return true;
            } else {
                a.w("Tinker.ResDiffPatchInternal", "have a mismatch corrupted resource " + file4.getPath(), new Object[0]);
                file4.delete();
            }
            try {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                if (applicationInfo == null) {
                    a.w("Tinker.ResDiffPatchInternal", "applicationInfo == null!!!!", new Object[0]);
                    return false;
                }
                String str3 = applicationInfo.sourceDir;
                if (!a(context, str3, file2, file3, file, shareResPatchInfo, 6)) {
                    return false;
                }
                Object obj3 = null;
                try {
                    h hVar2 = new h(new BufferedOutputStream(new FileOutputStream(file4)));
                    try {
                        gVar = new g(str3);
                    } catch (Throwable th2) {
                        th = th2;
                        obj = null;
                        hVar = hVar2;
                        com.tencent.tinker.c.b.a.cy(obj2);
                        com.tencent.tinker.c.b.a.cy(obj3);
                        com.tencent.tinker.c.b.a.cy(obj);
                        SharePatchFileUtil.g(file3);
                        throw th;
                    }
                    try {
                        f fVar;
                        gVar2 = new g(file);
                        gVar.cHm();
                        Enumeration 1 = new 1(gVar, gVar.Amg.values().iterator());
                        int i = 0;
                        while (1.hasMoreElements()) {
                            fVar = (f) 1.nextElement();
                            if (fVar == null) {
                                throw new TinkerRuntimeException("zipEntry is null when get from oldApk");
                            }
                            try {
                                String str4 = fVar.name;
                                if (!str4.contains("../")) {
                                    int i2;
                                    if (!ShareResPatchInfo.a(shareResPatchInfo.AlO, str4) || shareResPatchInfo.AlJ.contains(str4) || shareResPatchInfo.AlK.contains(str4) || shareResPatchInfo.AlM.contains(str4) || str4.equals("AndroidManifest.xml")) {
                                        i2 = i;
                                    } else {
                                        i.a(gVar, fVar, hVar2);
                                        i2 = i + 1;
                                    }
                                    i = i2;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                obj = gVar2;
                                obj2 = hVar2;
                                obj3 = gVar;
                            }
                        }
                        fVar = gVar.abP("AndroidManifest.xml");
                        if (fVar == null) {
                            a.w("Tinker.ResDiffPatchInternal", "manifest patch entry is null. path:AndroidManifest.xml", new Object[0]);
                            ip.AiC.a(file, file4, "AndroidManifest.xml", 6);
                            com.tencent.tinker.c.b.a.cy(hVar2);
                            com.tencent.tinker.c.b.a.cy(gVar);
                            com.tencent.tinker.c.b.a.cy(gVar2);
                            SharePatchFileUtil.g(file3);
                            return false;
                        }
                        String str5;
                        f abP;
                        i.a(gVar, fVar, hVar2);
                        i++;
                        Iterator it = shareResPatchInfo.AlM.iterator();
                        while (it.hasNext()) {
                            str5 = (String) it.next();
                            abP = gVar.abP(str5);
                            if (abP == null) {
                                a.w("Tinker.ResDiffPatchInternal", "large patch entry is null. path:" + str5, new Object[0]);
                                ip.AiC.a(file, file4, str5, 6);
                                com.tencent.tinker.c.b.a.cy(hVar2);
                                com.tencent.tinker.c.b.a.cy(gVar);
                                com.tencent.tinker.c.b.a.cy(gVar2);
                                SharePatchFileUtil.g(file3);
                                return false;
                            }
                            LargeModeInfo largeModeInfo = (LargeModeInfo) shareResPatchInfo.AlN.get(str5);
                            i.a(abP, largeModeInfo.file, largeModeInfo.AlP, hVar2);
                            i++;
                        }
                        it = shareResPatchInfo.AlI.iterator();
                        while (it.hasNext()) {
                            str5 = (String) it.next();
                            abP = gVar2.abP(str5);
                            if (abP == null) {
                                a.w("Tinker.ResDiffPatchInternal", "add patch entry is null. path:" + str5, new Object[0]);
                                ip.AiC.a(file, file4, str5, 6);
                                com.tencent.tinker.c.b.a.cy(hVar2);
                                com.tencent.tinker.c.b.a.cy(gVar);
                                com.tencent.tinker.c.b.a.cy(gVar2);
                                SharePatchFileUtil.g(file3);
                                return false;
                            }
                            if (shareResPatchInfo.AlL.containsKey(str5)) {
                                i.a(abP, (File) shareResPatchInfo.AlL.get(str5), abP.AlP, hVar2);
                            } else {
                                i.a(gVar2, abP, hVar2);
                            }
                            i++;
                        }
                        it = shareResPatchInfo.AlK.iterator();
                        while (it.hasNext()) {
                            str5 = (String) it.next();
                            abP = gVar2.abP(str5);
                            if (abP == null) {
                                a.w("Tinker.ResDiffPatchInternal", "mod patch entry is null. path:" + str5, new Object[0]);
                                ip.AiC.a(file, file4, str5, 6);
                                com.tencent.tinker.c.b.a.cy(hVar2);
                                com.tencent.tinker.c.b.a.cy(gVar);
                                com.tencent.tinker.c.b.a.cy(gVar2);
                                SharePatchFileUtil.g(file3);
                                return false;
                            }
                            if (shareResPatchInfo.AlL.containsKey(str5)) {
                                i.a(abP, (File) shareResPatchInfo.AlL.get(str5), abP.AlP, hVar2);
                            } else {
                                i.a(gVar2, abP, hVar2);
                            }
                            i++;
                        }
                        gVar.cHm();
                        str5 = gVar.wLD;
                        if (str5 == null) {
                            hVar2.Amo = h.Amk;
                        } else {
                            byte[] bytes = str5.getBytes(d.UTF_8);
                            h.x("Comment", bytes);
                            hVar2.Amo = bytes;
                        }
                        com.tencent.tinker.c.b.a.cy(hVar2);
                        com.tencent.tinker.c.b.a.cy(gVar);
                        com.tencent.tinker.c.b.a.cy(gVar2);
                        SharePatchFileUtil.g(file3);
                        if (SharePatchFileUtil.h(file4, shareResPatchInfo.AlH)) {
                            a.i("Tinker.ResDiffPatchInternal", "final new resource file:%s, entry count:%d, size:%d", new Object[]{file4.getAbsolutePath(), Integer.valueOf(i), Long.valueOf(file4.length())});
                            return true;
                        }
                        a.i("Tinker.ResDiffPatchInternal", "check final new resource file fail path:%s, entry count:%d, size:%d", new Object[]{file4.getAbsolutePath(), Integer.valueOf(i), Long.valueOf(file4.length())});
                        SharePatchFileUtil.ag(file4);
                        ip.AiC.a(file, file4, "resources.apk", 6);
                        return false;
                    } catch (Throwable th4) {
                        th = th4;
                        obj = null;
                        gVar2 = gVar;
                        hVar = hVar2;
                        com.tencent.tinker.c.b.a.cy(obj2);
                        com.tencent.tinker.c.b.a.cy(obj3);
                        com.tencent.tinker.c.b.a.cy(obj);
                        SharePatchFileUtil.g(file3);
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    obj = null;
                    obj2 = null;
                    com.tencent.tinker.c.b.a.cy(obj2);
                    com.tencent.tinker.c.b.a.cy(obj3);
                    com.tencent.tinker.c.b.a.cy(obj);
                    SharePatchFileUtil.g(file3);
                    throw th;
                }
            } catch (Throwable th6) {
                TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("patch " + ShareTinkerInternals.IV(6) + " extract failed (" + th6.getMessage() + ").", th6);
            }
        } else {
            a.w("Tinker.ResDiffPatchInternal", "resource meta file md5 mismatch, type:%s, md5: %s", new Object[]{ShareTinkerInternals.IV(6), shareResPatchInfo.AlH});
            ip.AiC.d(file, b.IR(6));
            return false;
        }
    }

    private static boolean a(Context context, String str, File file, File file2, File file3, ShareResPatchInfo shareResPatchInfo, int i) {
        Object obj;
        InputStream inputStream;
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.tinker.lib.e.a ip = com.tencent.tinker.lib.e.a.ip(context);
        ZipFile zipFile = null;
        ZipFile zipFile2 = null;
        ZipFile zipFile3;
        ZipFile zipFile4;
        Throwable th;
        try {
            zipFile3 = new ZipFile(str);
            try {
                Object obj2;
                ZipEntry entry = zipFile3.getEntry("resources.arsc");
                File file4 = new File(file, "resources.arsc");
                if (entry == null) {
                    a.w("Tinker.ResDiffPatchInternal", "resources apk entry is null. path:resources.arsc", new Object[0]);
                    ip.AiC.a(file3, file4, "resources.arsc", 6);
                    SharePatchFileUtil.a(zipFile3);
                    SharePatchFileUtil.a(null);
                    return false;
                }
                if (!String.valueOf(entry.getCrc()).equals(shareResPatchInfo.AlG)) {
                    a.e("Tinker.ResDiffPatchInternal", "resources.arsc's crc is not equal, expect crc: %s, got crc: %s", new Object[]{shareResPatchInfo.AlG, String.valueOf(entry.getCrc())});
                    ip.AiC.a(file3, file4, "resources.arsc", 6);
                    SharePatchFileUtil.a(zipFile3);
                    SharePatchFileUtil.a(null);
                    return false;
                } else if (shareResPatchInfo.AlM.isEmpty() && shareResPatchInfo.AlL.isEmpty()) {
                    a.i("Tinker.ResDiffPatchInternal", "no large modify or store resources, just return", new Object[0]);
                    SharePatchFileUtil.a(zipFile3);
                    SharePatchFileUtil.a(null);
                    return true;
                } else {
                    zipFile4 = new ZipFile(file3);
                    try {
                        String str2;
                        for (String str22 : shareResPatchInfo.AlL.keySet()) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            File file5 = new File(file2, str22);
                            SharePatchFileUtil.ai(file5);
                            ZipEntry entry2 = zipFile4.getEntry(str22);
                            if (entry2 == null) {
                                a.w("Tinker.ResDiffPatchInternal", "store patch entry is null. path:" + str22, new Object[0]);
                                ip.AiC.a(file3, file5, str22, 6);
                                SharePatchFileUtil.a(zipFile3);
                                SharePatchFileUtil.a(zipFile4);
                                return false;
                            }
                            a(zipFile4, entry2, file5, null, false);
                            if (entry2.getSize() != file5.length()) {
                                a.w("Tinker.ResDiffPatchInternal", "resource meta file size mismatch, type:%s, name: %s, patch size: %d, file size; %d", new Object[]{ShareTinkerInternals.IV(6), str22, Long.valueOf(entry2.getSize()), Long.valueOf(file5.length())});
                                ip.AiC.d(file3, b.IR(6));
                                SharePatchFileUtil.a(zipFile3);
                                SharePatchFileUtil.a(zipFile4);
                                return false;
                            }
                            shareResPatchInfo.AlL.put(str22, file5);
                            a.w("Tinker.ResDiffPatchInternal", "success recover store file:%s, file size:%d, use time:%d", new Object[]{file5.getPath(), Long.valueOf(file5.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
                        }
                        Iterator it = shareResPatchInfo.AlM.iterator();
                        while (it.hasNext()) {
                            str22 = (String) it.next();
                            long currentTimeMillis3 = System.currentTimeMillis();
                            LargeModeInfo largeModeInfo = (LargeModeInfo) shareResPatchInfo.AlN.get(str22);
                            if (largeModeInfo == null) {
                                a.w("Tinker.ResDiffPatchInternal", "resource not found largeModeInfo, type:%s, name: %s", new Object[]{ShareTinkerInternals.IV(6), str22});
                                ip.AiC.d(file3, b.IR(6));
                                SharePatchFileUtil.a(zipFile3);
                                SharePatchFileUtil.a(zipFile4);
                                return false;
                            }
                            largeModeInfo.file = new File(file2, str22);
                            SharePatchFileUtil.ai(largeModeInfo.file);
                            if (SharePatchFileUtil.abL(largeModeInfo.fqR)) {
                                ZipEntry entry3 = zipFile4.getEntry(str22);
                                if (entry3 == null) {
                                    a.w("Tinker.ResDiffPatchInternal", "large mod patch entry is null. path:" + str22, new Object[0]);
                                    ip.AiC.a(file3, largeModeInfo.file, str22, 6);
                                    SharePatchFileUtil.a(zipFile3);
                                    SharePatchFileUtil.a(zipFile4);
                                    return false;
                                }
                                ZipEntry entry4 = zipFile3.getEntry(str22);
                                if (entry4 == null) {
                                    a.w("Tinker.ResDiffPatchInternal", "resources apk entry is null. path:" + str22, new Object[0]);
                                    ip.AiC.a(file3, largeModeInfo.file, str22, 6);
                                    SharePatchFileUtil.a(zipFile3);
                                    SharePatchFileUtil.a(zipFile4);
                                    return false;
                                }
                                Object obj3 = null;
                                obj = null;
                                try {
                                    InputStream inputStream2 = zipFile3.getInputStream(entry4);
                                    try {
                                        inputStream = zipFile4.getInputStream(entry3);
                                        try {
                                            com.tencent.tinker.b.a.a(inputStream2, inputStream, largeModeInfo.file);
                                            com.tencent.tinker.c.b.a.cy(inputStream2);
                                            com.tencent.tinker.c.b.a.cy(inputStream);
                                            if (SharePatchFileUtil.f(largeModeInfo.file, largeModeInfo.fqR)) {
                                                a.w("Tinker.ResDiffPatchInternal", "success recover large modify file:%s, file size:%d, use time:%d", new Object[]{largeModeInfo.file.getPath(), Long.valueOf(largeModeInfo.file.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis3)});
                                            } else {
                                                a.w("Tinker.ResDiffPatchInternal", "Failed to recover large modify file:%s", new Object[]{largeModeInfo.file.getPath()});
                                                SharePatchFileUtil.ag(largeModeInfo.file);
                                                ip.AiC.a(file3, largeModeInfo.file, str22, 6);
                                                SharePatchFileUtil.a(zipFile3);
                                                SharePatchFileUtil.a(zipFile4);
                                                return false;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            InputStream inputStream3 = inputStream;
                                            inputStream = inputStream2;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        obj2 = obj;
                                        inputStream = inputStream2;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    obj2 = obj;
                                    obj = obj3;
                                }
                            } else {
                                a.w("Tinker.ResDiffPatchInternal", "resource meta file md5 mismatch, type:%s, name: %s, md5: %s", new Object[]{ShareTinkerInternals.IV(6), str22, largeModeInfo.fqR});
                                ip.AiC.d(file3, b.IR(6));
                                SharePatchFileUtil.a(zipFile3);
                                SharePatchFileUtil.a(zipFile4);
                                return false;
                            }
                        }
                        a.w("Tinker.ResDiffPatchInternal", "success recover all large modify and store resources use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        SharePatchFileUtil.a(zipFile3);
                        SharePatchFileUtil.a(zipFile4);
                        return true;
                    } catch (Throwable th5) {
                        th = th5;
                    }
                }
                com.tencent.tinker.c.b.a.cy(obj);
                com.tencent.tinker.c.b.a.cy(obj2);
                throw th;
            } catch (Throwable th6) {
                th = th6;
                zipFile4 = null;
                SharePatchFileUtil.a(zipFile3);
                SharePatchFileUtil.a(zipFile4);
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            zipFile4 = null;
            zipFile3 = null;
            SharePatchFileUtil.a(zipFile3);
            SharePatchFileUtil.a(zipFile4);
            throw th;
        }
    }
}
