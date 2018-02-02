package com.tencent.tinker.lib.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.tinker.d.a.f;
import com.tencent.tinker.d.a.g;
import com.tencent.tinker.d.a.h;
import com.tencent.tinker.d.a.i;
import com.tencent.tinker.lib.e.a;
import com.tencent.tinker.loader.TinkerDexOptimizer;
import com.tencent.tinker.loader.TinkerDexOptimizer.ResultCallback;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareDexDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareElfFile;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public final class d extends b {
    private static ArrayList<File> Aim = new ArrayList();
    private static ArrayList<ShareDexDiffPatchInfo> Ain = new ArrayList();
    private static HashMap<ShareDexDiffPatchInfo, File> Aio = new HashMap();
    private static boolean Aip = ShareTinkerInternals.cHg();

    protected static boolean a(a aVar, ShareSecurityCheck shareSecurityCheck, Context context, String str, File file) {
        if (ShareTinkerInternals.IS(aVar.tinkerFlags)) {
            String str2 = (String) shareSecurityCheck.AlR.get("assets/dex_meta.txt");
            if (str2 == null) {
                com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "patch recover, dex is not contained", new Object[0]);
                return true;
            }
            boolean a;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            String str3 = str + "/dex/";
            if (b(context, str3, str2, file)) {
                File[] listFiles = new File(str3).listFiles();
                List arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        if (file2.isFile()) {
                            arrayList.add(file2);
                        }
                    }
                }
                a = a(context, arrayList, str + "/odex/", file);
            } else {
                com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "patch recover, extractDiffInternals fail", new Object[0]);
                a = false;
            }
            elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
            com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "recover dex result:%b, cost:%d", new Object[]{Boolean.valueOf(a), Long.valueOf(elapsedRealtime)});
            return a;
        }
        com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "patch recover, dex is not enabled", new Object[0]);
        return true;
    }

    protected static boolean a(File file, a aVar) {
        Object shareElfFile;
        Object obj = null;
        if (Aim.isEmpty()) {
            return true;
        }
        int size = Ain.size() * 8;
        if (size > 30) {
            size = 30;
        }
        com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "raw dex count: %d, dex opt dex count: %d, final wait times: %d", new Object[]{Integer.valueOf(Ain.size()), Integer.valueOf(Aim.size()), Integer.valueOf(size)});
        for (int i = 0; i < size; i++) {
            int i2;
            int i3 = i + 1;
            Iterator it = Aim.iterator();
            while (it.hasNext()) {
                if (!SharePatchFileUtil.ae((File) it.next())) {
                    com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "parallel dex optimizer file %s is not exist, just wait %d times", new Object[]{((File) it.next()).getName(), Integer.valueOf(i3)});
                    i2 = 0;
                    break;
                }
            }
            i2 = 1;
            if (i2 == 0) {
                try {
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "thread sleep InterruptedException e:" + e, new Object[0]);
                }
            }
        }
        List arrayList = new ArrayList();
        Iterator it2 = Aim.iterator();
        while (it2.hasNext()) {
            File file2 = (File) it2.next();
            com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "check dex optimizer file exist: %s, size %d", new Object[]{file2.getPath(), Long.valueOf(file2.length())});
            if (!SharePatchFileUtil.ae(file2)) {
                com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "final parallel dex optimizer file %s is not exist, return false", new Object[]{file2.getName()});
                arrayList.add(file2);
            }
        }
        if (arrayList.isEmpty()) {
            if (VERSION.SDK_INT >= 21) {
                Iterator it3 = Aim.iterator();
                Throwable th = null;
                while (it3.hasNext()) {
                    file2 = (File) it3.next();
                    com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "check dex optimizer file format: %s, size %d", new Object[]{file2.getName(), Long.valueOf(file2.length())});
                    try {
                        if (ShareElfFile.ac(file2) == 1) {
                            try {
                                shareElfFile = new ShareElfFile(file2);
                            } catch (Throwable th2) {
                                th = th2;
                                shareElfFile = "Tinker.DexDiffPatchInternal";
                                com.tencent.tinker.lib.f.a.e(shareElfFile, "final parallel dex optimizer file %s is not elf format, return false", new Object[]{file2.getName()});
                                arrayList.add(file2);
                            } finally {
                                obj = 
/*
Method generation error in method: com.tencent.tinker.lib.c.d.a(java.io.File, com.tencent.tinker.lib.e.a):boolean
jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: MERGE  (r2_3 'obj' java.lang.Object) = (r2_2 'obj' java.lang.Object), (r7_19 'shareElfFile' java.lang.Object) in method: com.tencent.tinker.lib.c.d.a(java.io.File, com.tencent.tinker.lib.e.a):boolean
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:203)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:100)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:50)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:297)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:277)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:217)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:328)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:265)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:228)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:118)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:83)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:19)
	at jadx.core.ProcessClass.process(ProcessClass.java:43)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:530)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:514)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 51 more

*/

                                private static boolean abC(String str) {
                                    File file = null;
                                    if (Ain.isEmpty() || !Aip) {
                                        return false;
                                    }
                                    boolean z;
                                    Iterator it = Ain.iterator();
                                    ShareDexDiffPatchInfo shareDexDiffPatchInfo = null;
                                    while (it.hasNext()) {
                                        ShareDexDiffPatchInfo shareDexDiffPatchInfo2;
                                        File file2;
                                        ShareDexDiffPatchInfo shareDexDiffPatchInfo3 = (ShareDexDiffPatchInfo) it.next();
                                        File file3 = new File(str + shareDexDiffPatchInfo3.gJo);
                                        if (ShareConstants.Akw.matcher(file3.getName()).matches()) {
                                            Aio.put(shareDexDiffPatchInfo3, file3);
                                        }
                                        if (shareDexDiffPatchInfo3.Akx.startsWith("test.dex")) {
                                            File file4 = file3;
                                            shareDexDiffPatchInfo2 = shareDexDiffPatchInfo3;
                                            file2 = file4;
                                        } else {
                                            file2 = file;
                                            shareDexDiffPatchInfo2 = shareDexDiffPatchInfo;
                                        }
                                        file = file2;
                                        shareDexDiffPatchInfo = shareDexDiffPatchInfo2;
                                    }
                                    if (shareDexDiffPatchInfo != null) {
                                        Aio.put(ShareTinkerInternals.a(shareDexDiffPatchInfo, Aio.size() + 1), file);
                                    }
                                    file = new File(str, "tinker_classN.apk");
                                    if (file.exists()) {
                                        for (ShareDexDiffPatchInfo shareDexDiffPatchInfo32 : Aio.keySet()) {
                                            if (!SharePatchFileUtil.b(file, shareDexDiffPatchInfo32.Akx, shareDexDiffPatchInfo32.Akz)) {
                                                com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "verify dex file md5 error, entry name; %s, file len: %d", new Object[]{shareDexDiffPatchInfo32.Akx, Long.valueOf(file.length())});
                                                z = false;
                                                break;
                                            }
                                        }
                                        z = true;
                                        if (!z) {
                                            SharePatchFileUtil.ag(file);
                                        }
                                    } else {
                                        z = false;
                                    }
                                    if (z) {
                                        for (File file22 : Aio.values()) {
                                            SharePatchFileUtil.ag(file22);
                                        }
                                    }
                                    return z;
                                }

                                private static boolean a(Context context, File file, String str) {
                                    Throwable th;
                                    g gVar;
                                    if (Ain.isEmpty() || !Aip) {
                                        return true;
                                    }
                                    File file2 = new File(str, "tinker_classN.apk");
                                    if (Aio.isEmpty()) {
                                        com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "classNDexInfo size: %d, no need to merge classN dex files", new Object[]{Integer.valueOf(Aio.size())});
                                        return true;
                                    }
                                    boolean z;
                                    long currentTimeMillis = System.currentTimeMillis();
                                    Object obj = null;
                                    Object hVar;
                                    try {
                                        hVar = new h(new BufferedOutputStream(new FileOutputStream(file2)));
                                        try {
                                            for (ShareDexDiffPatchInfo shareDexDiffPatchInfo : Aio.keySet()) {
                                                File file3 = (File) Aio.get(shareDexDiffPatchInfo);
                                                if (shareDexDiffPatchInfo.AkE) {
                                                    try {
                                                        g gVar2 = new g(file3);
                                                        try {
                                                            f abP = gVar2.abP("classes.dex");
                                                            f fVar = new f(abP, shareDexDiffPatchInfo.Akx);
                                                            obj = gVar2.a(abP);
                                                            try {
                                                                i.a(fVar, obj, hVar);
                                                                com.tencent.tinker.c.b.a.cy(obj);
                                                                com.tencent.tinker.c.b.a.cy(gVar2);
                                                            } catch (Throwable th2) {
                                                                th = th2;
                                                                gVar = gVar2;
                                                            }
                                                        } catch (Throwable th3) {
                                                            th = th3;
                                                            obj = null;
                                                            gVar = gVar2;
                                                        }
                                                    } catch (Throwable th4) {
                                                        th = th4;
                                                        obj = null;
                                                        Object obj2 = null;
                                                    }
                                                } else {
                                                    i.a(new f(shareDexDiffPatchInfo.Akx), file3, Long.parseLong(shareDexDiffPatchInfo.AkB), hVar);
                                                }
                                            }
                                            com.tencent.tinker.c.b.a.cy(hVar);
                                            z = true;
                                        } catch (Throwable th5) {
                                            th = th5;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        hVar = null;
                                        com.tencent.tinker.c.b.a.cy(hVar);
                                        throw th;
                                    }
                                    if (z) {
                                        for (ShareDexDiffPatchInfo shareDexDiffPatchInfo2 : Aio.keySet()) {
                                            if (SharePatchFileUtil.b(file2, shareDexDiffPatchInfo2.Akx, shareDexDiffPatchInfo2.Akz)) {
                                                z = false;
                                                com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "verify dex file md5 error, entry name; %s, file len: %d", new Object[]{shareDexDiffPatchInfo2.Akx, Long.valueOf(file2.length())});
                                                break;
                                            }
                                        }
                                    }
                                    if (z) {
                                        while (r4.hasNext()) {
                                            SharePatchFileUtil.ag(r2);
                                        }
                                    } else {
                                        com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "merge classN dex error, try delete temp file", new Object[0]);
                                        SharePatchFileUtil.ag(file2);
                                        a.ip(context).AiC.a(file, file2, file2.getName(), 7);
                                    }
                                    com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "merge classN dex file %s, result: %b, size: %d, use: %dms", new Object[]{file2.getPath(), Boolean.valueOf(z), Long.valueOf(file2.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                                    return z;
                                    com.tencent.tinker.c.b.a.cy(obj);
                                    com.tencent.tinker.c.b.a.cy(obj2);
                                    throw th;
                                }

                                private static boolean a(Context context, List<File> list, String str, File file) {
                                    a ip = a.ip(context);
                                    Aim.clear();
                                    File file2 = new File(str);
                                    if (file2.exists() || file2.mkdirs()) {
                                        for (File n : list) {
                                            Aim.add(new File(SharePatchFileUtil.n(n, file2)));
                                        }
                                        com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "patch recover, try to optimize dex file count:%d, optimizeDexDirectory:%s", new Object[]{Integer.valueOf(list.size()), str});
                                        final List vector = new Vector();
                                        final Throwable[] thArr = new Throwable[1];
                                        TinkerDexOptimizer.a(list, file2, new ResultCallback() {
                                            long startTime;

                                            public final void X(File file) {
                                                this.startTime = System.currentTimeMillis();
                                                com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "start to parallel optimize dex %s, size: %d", new Object[]{file.getPath(), Long.valueOf(file.length())});
                                            }

                                            public final void l(File file, File file2) {
                                                com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "success to parallel optimize dex %s, opt file:%s, opt file size: %d, use time %d", new Object[]{file.getPath(), file2.getPath(), Long.valueOf(file2.length()), Long.valueOf(System.currentTimeMillis() - this.startTime)});
                                            }

                                            public final void b(File file, Throwable th) {
                                                com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "fail to parallel optimize dex %s use time %d", new Object[]{file.getPath(), Long.valueOf(System.currentTimeMillis() - this.startTime)});
                                                vector.add(file);
                                                thArr[0] = th;
                                            }
                                        });
                                        if (vector.isEmpty()) {
                                            return true;
                                        }
                                        ip.AiC.a(file, vector, thArr[0]);
                                        return false;
                                    }
                                    com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "patch recover, make optimizeDexDirectoryFile fail", new Object[0]);
                                    return false;
                                }

                                private static boolean b(Context context, String str, String str2, File file) {
                                    ZipFile zipFile;
                                    Throwable th;
                                    ZipFile zipFile2;
                                    Throwable th2;
                                    Ain.clear();
                                    ShareDexDiffPatchInfo.m(str2, Ain);
                                    if (Ain.isEmpty()) {
                                        com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "extract patch list is empty! type:%s:", new Object[]{ShareTinkerInternals.IV(3)});
                                        return true;
                                    }
                                    File file2 = new File(str);
                                    if (!file2.exists()) {
                                        file2.mkdirs();
                                    }
                                    a ip = a.ip(context);
                                    try {
                                        ApplicationInfo applicationInfo = context.getApplicationInfo();
                                        if (applicationInfo == null) {
                                            com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "applicationInfo == null!!!!", new Object[0]);
                                            SharePatchFileUtil.a(null);
                                            SharePatchFileUtil.a(null);
                                            return false;
                                        }
                                        ZipFile zipFile3 = new ZipFile(applicationInfo.sourceDir);
                                        try {
                                            zipFile = new ZipFile(file);
                                            try {
                                                if (abC(str)) {
                                                    com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "class n dex file %s is already exist, and md5 match, just continue", new Object[]{"tinker_classN.apk"});
                                                    SharePatchFileUtil.a(zipFile3);
                                                    SharePatchFileUtil.a(zipFile);
                                                    return true;
                                                }
                                                Iterator it = Ain.iterator();
                                                while (it.hasNext()) {
                                                    String str3;
                                                    ShareDexDiffPatchInfo shareDexDiffPatchInfo = (ShareDexDiffPatchInfo) it.next();
                                                    long currentTimeMillis = System.currentTimeMillis();
                                                    if (shareDexDiffPatchInfo.path.equals("")) {
                                                        str3 = shareDexDiffPatchInfo.Akx;
                                                    } else {
                                                        str3 = shareDexDiffPatchInfo.path + "/" + shareDexDiffPatchInfo.Akx;
                                                    }
                                                    String str4 = shareDexDiffPatchInfo.AkC;
                                                    String str5 = shareDexDiffPatchInfo.AkA;
                                                    if (Aip || !shareDexDiffPatchInfo.Aky.equals("0")) {
                                                        String str6 = Aip ? shareDexDiffPatchInfo.Akz : shareDexDiffPatchInfo.Aky;
                                                        if (SharePatchFileUtil.abL(str6)) {
                                                            File file3 = new File(str + shareDexDiffPatchInfo.gJo);
                                                            if (!file3.exists()) {
                                                                file3.getParentFile().mkdirs();
                                                            } else if (SharePatchFileUtil.g(file3, str6)) {
                                                                com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "dex file %s is already exist, and md5 match, just continue", new Object[]{file3.getPath()});
                                                            } else {
                                                                com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "have a mismatch corrupted dex " + file3.getPath(), new Object[0]);
                                                                file3.delete();
                                                            }
                                                            ZipEntry entry = zipFile.getEntry(str3);
                                                            ZipEntry entry2 = zipFile3.getEntry(str3);
                                                            if (str5.equals("0")) {
                                                                if (entry == null) {
                                                                    com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "patch entry is null. path:" + str3, new Object[0]);
                                                                    ip.AiC.a(file, file3, shareDexDiffPatchInfo.Akx, 3);
                                                                    SharePatchFileUtil.a(zipFile3);
                                                                    SharePatchFileUtil.a(zipFile);
                                                                    return false;
                                                                } else if (!a(zipFile, entry, file3, shareDexDiffPatchInfo)) {
                                                                    com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "Failed to extract raw patch file " + file3.getPath(), new Object[0]);
                                                                    ip.AiC.a(file, file3, shareDexDiffPatchInfo.Akx, 3);
                                                                    SharePatchFileUtil.a(zipFile3);
                                                                    SharePatchFileUtil.a(zipFile);
                                                                    return false;
                                                                }
                                                            } else if (str4.equals("0")) {
                                                                if (!Aip) {
                                                                    continue;
                                                                } else if (entry2 == null) {
                                                                    com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "apk entry is null. path:" + str3, new Object[0]);
                                                                    ip.AiC.a(file, file3, shareDexDiffPatchInfo.Akx, 3);
                                                                    SharePatchFileUtil.a(zipFile3);
                                                                    SharePatchFileUtil.a(zipFile);
                                                                    return false;
                                                                } else {
                                                                    if (String.valueOf(entry2.getCrc()).equals(str5)) {
                                                                        a(zipFile3, entry2, file3, shareDexDiffPatchInfo);
                                                                        if (!SharePatchFileUtil.g(file3, str6)) {
                                                                            com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "Failed to recover dex file when verify patched dex: " + file3.getPath(), new Object[0]);
                                                                            ip.AiC.a(file, file3, shareDexDiffPatchInfo.Akx, 3);
                                                                            SharePatchFileUtil.ag(file3);
                                                                            SharePatchFileUtil.a(zipFile3);
                                                                            SharePatchFileUtil.a(zipFile);
                                                                            return false;
                                                                        }
                                                                    } else {
                                                                        com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "apk entry %s crc is not equal, expect crc: %s, got crc: %s", new Object[]{str3, str5, String.valueOf(entry2.getCrc())});
                                                                        ip.AiC.a(file, file3, shareDexDiffPatchInfo.Akx, 3);
                                                                        SharePatchFileUtil.a(zipFile3);
                                                                        SharePatchFileUtil.a(zipFile);
                                                                        return false;
                                                                    }
                                                                }
                                                            } else if (entry == null) {
                                                                com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "patch entry is null. path:" + str3, new Object[0]);
                                                                ip.AiC.a(file, file3, shareDexDiffPatchInfo.Akx, 3);
                                                                SharePatchFileUtil.a(zipFile3);
                                                                SharePatchFileUtil.a(zipFile);
                                                                return false;
                                                            } else if (!SharePatchFileUtil.abL(str4)) {
                                                                com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "meta file md5 invalid, type:%s, name: %s, md5: %s", new Object[]{ShareTinkerInternals.IV(3), shareDexDiffPatchInfo.Akx, str4});
                                                                ip.AiC.d(file, b.IR(3));
                                                                SharePatchFileUtil.a(zipFile3);
                                                                SharePatchFileUtil.a(zipFile);
                                                                return false;
                                                            } else if (entry2 == null) {
                                                                com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "apk entry is null. path:" + str3, new Object[0]);
                                                                ip.AiC.a(file, file3, shareDexDiffPatchInfo.Akx, 3);
                                                                SharePatchFileUtil.a(zipFile3);
                                                                SharePatchFileUtil.a(zipFile);
                                                                return false;
                                                            } else {
                                                                if (String.valueOf(entry2.getCrc()).equals(str5)) {
                                                                    a(zipFile3, zipFile, entry2, entry, shareDexDiffPatchInfo, file3);
                                                                    if (SharePatchFileUtil.g(file3, str6)) {
                                                                        com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "success recover dex file: %s, size: %d, use time: %d", new Object[]{file3.getPath(), Long.valueOf(file3.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                                                                    } else {
                                                                        com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "Failed to recover dex file when verify patched dex: " + file3.getPath(), new Object[0]);
                                                                        ip.AiC.a(file, file3, shareDexDiffPatchInfo.Akx, 3);
                                                                        SharePatchFileUtil.ag(file3);
                                                                        SharePatchFileUtil.a(zipFile3);
                                                                        SharePatchFileUtil.a(zipFile);
                                                                        return false;
                                                                    }
                                                                }
                                                                com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "apk entry %s crc is not equal, expect crc: %s, got crc: %s", new Object[]{str3, str5, String.valueOf(entry2.getCrc())});
                                                                ip.AiC.a(file, file3, shareDexDiffPatchInfo.Akx, 3);
                                                                SharePatchFileUtil.a(zipFile3);
                                                                SharePatchFileUtil.a(zipFile);
                                                                return false;
                                                            }
                                                        }
                                                        com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "meta file md5 invalid, type:%s, name: %s, md5: %s", new Object[]{ShareTinkerInternals.IV(3), shareDexDiffPatchInfo.Akx, str6});
                                                        ip.AiC.d(file, b.IR(3));
                                                        SharePatchFileUtil.a(zipFile3);
                                                        SharePatchFileUtil.a(zipFile);
                                                        return false;
                                                    }
                                                    com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "patch dex %s is only for art, just continue", new Object[]{str3});
                                                }
                                                if (a(context, file, str)) {
                                                    SharePatchFileUtil.a(zipFile3);
                                                    SharePatchFileUtil.a(zipFile);
                                                    return true;
                                                }
                                                SharePatchFileUtil.a(zipFile3);
                                                SharePatchFileUtil.a(zipFile);
                                                return false;
                                            } catch (Throwable th3) {
                                                th = th3;
                                                zipFile2 = zipFile3;
                                                th2 = th;
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            zipFile = null;
                                            zipFile2 = zipFile3;
                                            th2 = th;
                                            SharePatchFileUtil.a(zipFile2);
                                            SharePatchFileUtil.a(zipFile);
                                            throw th2;
                                        }
                                    } catch (Throwable th5) {
                                        th2 = th5;
                                        zipFile2 = null;
                                        zipFile = null;
                                        SharePatchFileUtil.a(zipFile2);
                                        SharePatchFileUtil.a(zipFile);
                                        throw th2;
                                    }
                                }

                                private static boolean b(ZipFile zipFile, ZipEntry zipEntry, File file, String str) {
                                    Throwable th;
                                    ZipOutputStream zipOutputStream;
                                    Object obj = null;
                                    boolean z = false;
                                    int i = 0;
                                    while (i < 2 && !z) {
                                        Object bufferedInputStream;
                                        int i2 = i + 1;
                                        com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "try Extracting " + file.getPath(), new Object[0]);
                                        try {
                                            ZipOutputStream zipOutputStream2 = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                                            try {
                                                bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                                                try {
                                                    byte[] bArr = new byte[16384];
                                                    zipOutputStream2.putNextEntry(new ZipEntry("classes.dex"));
                                                    for (int read = bufferedInputStream.read(bArr); read != -1; read = bufferedInputStream.read(bArr)) {
                                                        zipOutputStream2.write(bArr, 0, read);
                                                    }
                                                    zipOutputStream2.closeEntry();
                                                    com.tencent.tinker.c.b.a.cy(bufferedInputStream);
                                                    com.tencent.tinker.c.b.a.cy(zipOutputStream2);
                                                    z = SharePatchFileUtil.g(file, str);
                                                    com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "isExtractionSuccessful: %b", new Object[]{Boolean.valueOf(z)});
                                                    if (!z && (!file.delete() || file.exists())) {
                                                        com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "Failed to delete corrupted dex " + file.getPath(), new Object[0]);
                                                    }
                                                    i = i2;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    zipOutputStream = zipOutputStream2;
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                bufferedInputStream = null;
                                                zipOutputStream = zipOutputStream2;
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            bufferedInputStream = null;
                                        }
                                    }
                                    return z;
                                    com.tencent.tinker.c.b.a.cy(bufferedInputStream);
                                    com.tencent.tinker.c.b.a.cy(obj);
                                    throw th;
                                }

                                private static boolean a(ZipFile zipFile, ZipEntry zipEntry, File file, ShareDexDiffPatchInfo shareDexDiffPatchInfo) {
                                    String str = Aip ? shareDexDiffPatchInfo.Akz : shareDexDiffPatchInfo.Aky;
                                    String str2 = shareDexDiffPatchInfo.Akx;
                                    boolean z = shareDexDiffPatchInfo.AkE;
                                    if (SharePatchFileUtil.abM(str2) && z) {
                                        return b(zipFile, zipEntry, file, str);
                                    }
                                    return a(zipFile, zipEntry, file, str, true);
                                }

                                private static void a(ZipFile zipFile, ZipFile zipFile2, ZipEntry zipEntry, ZipEntry zipEntry2, ShareDexDiffPatchInfo shareDexDiffPatchInfo, File file) {
                                    Throwable th;
                                    Object obj = null;
                                    Object zipInputStream;
                                    try {
                                        InputStream bufferedInputStream;
                                        InputStream bufferedInputStream2 = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                                        if (zipEntry2 != null) {
                                            try {
                                                bufferedInputStream = new BufferedInputStream(zipFile2.getInputStream(zipEntry2));
                                            } catch (Throwable th2) {
                                                th = th2;
                                                InputStream inputStream = bufferedInputStream2;
                                                com.tencent.tinker.c.b.a.cy(zipInputStream);
                                                com.tencent.tinker.c.b.a.cy(obj);
                                                throw th;
                                            }
                                        }
                                        bufferedInputStream = null;
                                        try {
                                            boolean abM = SharePatchFileUtil.abM(shareDexDiffPatchInfo.Akx);
                                            if (!abM || shareDexDiffPatchInfo.AkE) {
                                                try {
                                                    OutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                                                    try {
                                                        zipOutputStream.putNextEntry(new ZipEntry("classes.dex"));
                                                        if (abM) {
                                                            new com.tencent.tinker.c.a.a(bufferedInputStream2, bufferedInputStream).b(zipOutputStream);
                                                        } else {
                                                            try {
                                                                ZipEntry nextEntry;
                                                                zipInputStream = new ZipInputStream(bufferedInputStream2);
                                                                do {
                                                                    try {
                                                                        nextEntry = zipInputStream.getNextEntry();
                                                                        if (nextEntry == null) {
                                                                            break;
                                                                        }
                                                                    } catch (Throwable th3) {
                                                                        th = th3;
                                                                    }
                                                                } while (!"classes.dex".equals(nextEntry.getName()));
                                                                if (nextEntry == null) {
                                                                    throw new TinkerRuntimeException("can't recognize zip dex format file:" + file.getAbsolutePath());
                                                                }
                                                                new com.tencent.tinker.c.a.a(zipInputStream, bufferedInputStream).b(zipOutputStream);
                                                                com.tencent.tinker.c.b.a.cy(zipInputStream);
                                                            } catch (Throwable th4) {
                                                                th = th4;
                                                                zipInputStream = null;
                                                                com.tencent.tinker.c.b.a.cy(zipInputStream);
                                                                throw th;
                                                            }
                                                        }
                                                        zipOutputStream.closeEntry();
                                                        com.tencent.tinker.c.b.a.cy(zipOutputStream);
                                                    } catch (Throwable th5) {
                                                        th = th5;
                                                        obj = zipOutputStream;
                                                        com.tencent.tinker.c.b.a.cy(obj);
                                                        throw th;
                                                    }
                                                } catch (Throwable th6) {
                                                    th = th6;
                                                    com.tencent.tinker.c.b.a.cy(obj);
                                                    throw th;
                                                }
                                            }
                                            com.tencent.tinker.c.a.a aVar = new com.tencent.tinker.c.a.a(bufferedInputStream2, bufferedInputStream);
                                            OutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                                            try {
                                                aVar.b(bufferedOutputStream);
                                                com.tencent.tinker.c.b.a.cy(bufferedOutputStream);
                                            } catch (Throwable th7) {
                                                th = th7;
                                                OutputStream outputStream = bufferedOutputStream;
                                                com.tencent.tinker.c.b.a.cy(obj);
                                                throw th;
                                            }
                                            com.tencent.tinker.c.b.a.cy(bufferedInputStream2);
                                            com.tencent.tinker.c.b.a.cy(bufferedInputStream);
                                        } catch (Throwable th8) {
                                            th = th8;
                                            obj = bufferedInputStream;
                                            zipInputStream = bufferedInputStream2;
                                            com.tencent.tinker.c.b.a.cy(zipInputStream);
                                            com.tencent.tinker.c.b.a.cy(obj);
                                            throw th;
                                        }
                                    } catch (Throwable th9) {
                                        th = th9;
                                        zipInputStream = null;
                                        com.tencent.tinker.c.b.a.cy(zipInputStream);
                                        com.tencent.tinker.c.b.a.cy(obj);
                                        throw th;
                                    }
                                }
                            }
