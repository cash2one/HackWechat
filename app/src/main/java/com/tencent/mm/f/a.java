package com.tencent.mm.f;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import com.tencent.mm.a.g;
import com.tencent.mm.loader.stub.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tinker.loader.shareutil.ShareFileLockHelper;
import com.tencent.wcdb.database.SQLiteDatabase;
import dalvik.system.PathClassLoader;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

public final class a {
    private static boolean fmB = false;
    private static String fmC;
    private static String fmD;
    private static String fmE;
    private static Set<a> fmF;
    public static final boolean oG = l(System.getProperty("java.vm.version"));

    private static class a {
        String fmG;
        String fmH;
        String fmI;

        public a(String str, String str2, String str3) {
            this.fmG = str;
            this.fmH = str2;
            this.fmI = str3;
        }
    }

    private static final class b {
        static Object[] a(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) {
            Method b;
            try {
                b = a.a(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class);
            } catch (NoSuchMethodException e) {
                x.e("MicroMsg.MultiDex", "NoSuchMethodException: makeDexElements(ArrayList,File,ArrayList) failure");
                try {
                    b = a.a(obj, "makeDexElements", List.class, File.class, List.class);
                } catch (NoSuchMethodException e2) {
                    x.e("MicroMsg.MultiDex", "NoSuchMethodException: makeDexElements(List,File,List) failure");
                    try {
                        b = a.a(obj, "makePathElements", List.class, File.class, List.class);
                    } catch (NoSuchMethodException e3) {
                        x.e("MicroMsg.MultiDex", "NoSuchMethodException: makePathElements(List,File,List) failure");
                        throw e3;
                    }
                }
            }
            return (Object[]) b.invoke(obj, new Object[]{arrayList, file, arrayList2});
        }
    }

    private static /* synthetic */ void b(Object obj, String str, Object[] objArr) {
        Field a = a(obj, str);
        Object[] objArr2 = (Object[]) a.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        a.set(obj, objArr3);
    }

    private a() {
    }

    public static void aw(Context context) {
        long blockSize;
        long j = 0;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
            blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
        } catch (Exception e) {
            blockSize = 0;
            x.e("MicroMsg.MultiDex", "get db spare space error");
        }
        x.i("MicroMsg.MultiDex", "ifRomSpaceEnough available:%d all:%d", Long.valueOf(j), Long.valueOf(blockSize));
        if (blockSize != 0 && j < 31457280) {
            String r = d.r(context, Process.myPid());
            x.i("MicroMsg.MultiDex", "space not enough process:%s, available:%d, RESTRICTION_SPACE_SIZE: %d", r, Long.valueOf(j), Long.valueOf(31457280));
            if (!r.equals("") && !r.endsWith(":nospace")) {
                Intent intent = new Intent();
                intent.setClassName(context, "com.tencent.mm.ui.NoRomSpaceDexUI");
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                context.startActivity(intent);
                Process.killProcess(Process.myPid());
            }
        }
    }

    public static boolean ax(Context context) {
        int i = -1;
        if (oG) {
            x.i("MultiDex", "if need dexopt: VM has multidex support, MultiDex support library is disabled.");
            return false;
        } else if (fmB) {
            x.i("MultiDex", "if need dexopt: has inited.");
            return false;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            az(context);
            if (fmF == null || fmF.size() <= 0) {
                return true;
            }
            fmC = context.getDir("cache", 0).getAbsolutePath();
            fmD = context.getDir("dex", 0).getAbsolutePath();
            fmE = context.getDir("cache", 0).getParentFile().getAbsolutePath() + "/dex.lock";
            File file = new File(fmD);
            if ((file.exists() && file.isDirectory()) || file.mkdirs()) {
                int size = fmF.size();
                File file2 = new File(fmC);
                if ((file2.exists() && file2.isDirectory()) || file2.mkdirs()) {
                    x.i("MicroMsg.MultiDex", "if need dexopt: install Build.VERSION: %d, tryLoadDexFileCount: %d, installDir: %d, optDir: %d", Integer.valueOf(VERSION.SDK_INT), Integer.valueOf(size), Integer.valueOf(file.list().length), Integer.valueOf(file2.list().length));
                    if (file.list() == null || file.list().length < size || file2.list() == null || file2.list().length < size) {
                        String str = "MicroMsg.MultiDex";
                        String str2 = "if need dexopt: dex file count not equal, install path: %s vs %s, opt path: %s vs %s";
                        Object[] objArr = new Object[4];
                        objArr[0] = Integer.valueOf(file.list() == null ? -1 : file.list().length);
                        objArr[1] = Integer.valueOf(size);
                        if (file2.list() != null) {
                            i = file2.list().length;
                        }
                        objArr[2] = Integer.valueOf(i);
                        objArr[3] = Integer.valueOf(size);
                        x.i(str, str2, objArr);
                        return true;
                    } else if (context.getApplicationInfo() == null) {
                        return false;
                    } else {
                        for (a aVar : fmF) {
                            synchronized (a.class) {
                                x.i("MicroMsg.MultiDex", "if need dexopt: prepare dex to load, file: %s, md5: %s, loadClass: %s", aVar.fmG, aVar.fmH, aVar.fmI);
                            }
                            if (a(aVar)) {
                                x.i("MicroMsg.MultiDex", "if need dexopt: verify dex for check md5: targetFilePath: [%s] time: %d", aVar.fmG, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            } else {
                                x.e("MicroMsg.MultiDex", "if need dexopt: targetDexFile md5 mismatch or not exists: %s", aVar.fmG);
                                return true;
                            }
                        }
                        return false;
                    }
                }
                x.f("MicroMsg.MultiDex", "if need dexopt: extractZipEntryToFile: create target dexopt directory failed");
                return true;
            }
            x.f("MicroMsg.MultiDex", "if need dexopt: extractZipEntryToFile: create target dex directory failed");
            return true;
        }
    }

    public static synchronized boolean ay(Context context) {
        boolean z;
        synchronized (a.class) {
            x.i("MicroMsg.MultiDex", "install multidex hasinit: %b, force: %b", Boolean.valueOf(fmB), Boolean.valueOf(true));
            if (oG) {
                x.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
                z = true;
            } else if (fmB) {
                z = true;
            } else {
                if (context.getClassLoader() != null) {
                    x.i("MicroMsg.MultiDex", "classloader: " + context.getClassLoader().toString());
                } else {
                    x.e("MicroMsg.MultiDex", "classloader is null");
                }
                long currentTimeMillis = System.currentTimeMillis();
                az(context);
                if (fmF == null || fmF.size() <= 0) {
                    z = false;
                } else {
                    ApplicationInfo applicationInfo = context.getApplicationInfo();
                    if (applicationInfo == null) {
                        z = false;
                    } else {
                        fmC = context.getDir("cache", 0).getAbsolutePath();
                        fmD = context.getDir("dex", 0).getAbsolutePath();
                        fmE = context.getDir("cache", 0).getParentFile().getAbsolutePath() + "/dex.lock";
                        File file = new File(fmD);
                        if ((file.exists() && file.isDirectory()) || file.mkdirs()) {
                            int size = fmF.size();
                            File file2 = new File(fmC);
                            if ((file2.exists() && file2.isDirectory()) || file2.mkdirs()) {
                                x.i("MicroMsg.MultiDex", "install Build.VERSION: %d, tryLoadDexFileCount: %d, installDir: %d, optDir: %d", Integer.valueOf(VERSION.SDK_INT), Integer.valueOf(size), Integer.valueOf(file.list().length), Integer.valueOf(file2.list().length));
                                List arrayList = new ArrayList(fmF.size());
                                Object obj = null;
                                for (int i = 0; i < 5 && r2 == null; i++) {
                                    arrayList.clear();
                                    for (a aVar : fmF) {
                                        x.i("MicroMsg.MultiDex", "prepare dex to load, file: %s, md5: %s, loadClass: %s", aVar.fmG, aVar.fmH, aVar.fmI);
                                        if (a(aVar)) {
                                            x.i("MicroMsg.MultiDex", "verify dex for check md5: targetFilePath: [%s] time: %d", aVar.fmG, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                            if (b(context, aVar.fmI, false)) {
                                                x.i("MicroMsg.MultiDex", "dex has been loaded, skip. targetFilePath: [%s]", aVar.fmG);
                                            } else {
                                                try {
                                                    x.w("MicroMsg.MultiDex", "dex [%s] is not load, it should be reload in further steps.", aVar.fmG);
                                                } catch (Throwable th) {
                                                    x.e("MicroMsg.MultiDex", "Multidex installation failure", th);
                                                    x.printErrStackTrace("MicroMsg.MultiDex", th, "Multidex installation failure", new Object[0]);
                                                    aw(context);
                                                    RuntimeException runtimeException = new RuntimeException("Multi dex installation failed (" + th.getMessage() + ").", th);
                                                }
                                            }
                                        } else {
                                            x.e("MicroMsg.MultiDex", "targetDexFile md5 mismatch or not exists: %s, force: %b", aVar.fmG, Boolean.valueOf(true));
                                            ZipFile zipFile = new ZipFile(applicationInfo.sourceDir);
                                            boolean a = a(zipFile, aVar);
                                            try {
                                                zipFile.close();
                                            } catch (Exception e) {
                                                x.w("MicroMsg.MultiDex", "base apk file close quietly failed");
                                            }
                                            if (!a) {
                                                throw new Exception("overwriteLocalSecondaryDexFromApk fail");
                                            }
                                        }
                                        arrayList.add(new File(fmD + "/" + aVar.fmG));
                                    }
                                    if (arrayList.isEmpty()) {
                                        x.i("MicroMsg.MultiDex", "Nothing needs to be installed.");
                                        obj = 1;
                                        break;
                                    }
                                    a(context, fmC, arrayList);
                                    for (a aVar2 : fmF) {
                                        if (!b(context, aVar2.fmI, true)) {
                                            x.w("MicroMsg.MultiDex", "Failed to load dex [%s] in %d round, retry.", aVar2.fmG, Integer.valueOf(i + 1));
                                            String name = new File(fmD + "/" + aVar2.fmG).getName();
                                            if (!name.endsWith(".dex")) {
                                                size = name.lastIndexOf(".");
                                                if (size < 0) {
                                                    name = name + ".dex";
                                                } else {
                                                    StringBuilder stringBuilder = new StringBuilder(size + 4);
                                                    stringBuilder.append(name, 0, size);
                                                    stringBuilder.append(".dex");
                                                    name = stringBuilder.toString();
                                                }
                                            }
                                            File file3 = new File(file2, name);
                                            if (file3.exists()) {
                                                x.w("MicroMsg.MultiDex", "Remove perhaps broken odex file: " + file3.getAbsolutePath());
                                                if (!file3.delete()) {
                                                    x.w("MicroMsg.MultiDex", "Failed to remove perhaps broken odex file: " + file3.getAbsolutePath());
                                                }
                                            }
                                            obj = null;
                                        }
                                    }
                                    int i2 = 1;
                                }
                                if (obj == null) {
                                    throw new RuntimeException("Some dex is not installed successfully after 5 times retry !!");
                                }
                                fmB = true;
                                x.i("MicroMsg.MultiDex", "install done");
                                z = true;
                            } else {
                                x.f("MicroMsg.MultiDex", "extractZipEntryToFile: create target dexopt directory failed");
                                z = false;
                            }
                        } else {
                            x.f("MicroMsg.MultiDex", "extractZipEntryToFile: create target dex directory failed");
                            z = false;
                        }
                    }
                }
            }
        }
        return z;
    }

    private static boolean b(Context context, String str, boolean z) {
        try {
            if (Class.forName(str, false, context.getClassLoader()) != null) {
                return true;
            }
        } catch (Throwable e) {
            if (z) {
                x.printErrStackTrace("MicroMsg.MultiDex", e, "Failed to load a dex.", new Object[0]);
            }
        }
        if (!z) {
            return false;
        }
        x.w("MicroMsg.MultiDex", "checkDexLoaded fail.... " + str);
        return false;
    }

    private static boolean a(ZipFile zipFile, a aVar) {
        BufferedOutputStream bufferedOutputStream;
        x.i("MicroMsg.MultiDex", "enter overwriteLocalSecondaryDexFromApk, please keep concerned at which process calls it.");
        File file = new File(fmE);
        String str = fmD + "/" + aVar.fmG;
        ShareFileLockHelper shareFileLockHelper = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            shareFileLockHelper = ShareFileLockHelper.ad(file);
            x.i("MicroMsg.MultiDex", "extract dex waiting for write lock cost %dms on file: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), fmE);
            Closeable inputStream = zipFile.getInputStream(zipFile.getEntry(aVar.fmG));
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
                byte[] bArr = new byte[16384];
                for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                    bufferedOutputStream.write(bArr, 0, read);
                }
                bufferedOutputStream.close();
                b(inputStream);
                x.i("MicroMsg.MultiDex", "extract dex from apk done: %s", fmE);
                try {
                    shareFileLockHelper.close();
                    return true;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MultiDex", e, "", new Object[0]);
                    return true;
                }
            } catch (Throwable th) {
                b(inputStream);
            }
        } catch (Throwable e2) {
            try {
                x.printErrStackTrace("MicroMsg.MultiDex", e2, "", new Object[0]);
                x.e("MicroMsg.MultiDex", "overwrite local secondary dex failed, cannot lock file: %s", file.getAbsolutePath());
                if (shareFileLockHelper != null) {
                    try {
                        shareFileLockHelper.close();
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.MultiDex", e22, "", new Object[0]);
                    }
                }
                return false;
            } catch (Throwable th2) {
                if (shareFileLockHelper != null) {
                    try {
                        shareFileLockHelper.close();
                    } catch (Throwable e3) {
                        x.printErrStackTrace("MicroMsg.MultiDex", e3, "", new Object[0]);
                    }
                }
            }
        }
    }

    private static boolean l(String str) {
        boolean z = false;
        if (str != null) {
            Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
            if (matcher.matches()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    int parseInt2 = Integer.parseInt(matcher.group(2));
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 > 0)) {
                        z = true;
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
        x.i("MicroMsg.MultiDex", "VM with version " + str + (z ? " has multidex support" : " does not have multidex support"));
        return z;
    }

    private static boolean a(a aVar) {
        Closeable fileInputStream;
        Throwable e;
        ShareFileLockHelper shareFileLockHelper = null;
        String str = fmD + "/" + aVar.fmG;
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            File file2 = new File(fmE);
            ShareFileLockHelper ad;
            try {
                long currentTimeMillis = System.currentTimeMillis();
                ad = ShareFileLockHelper.ad(file2);
                try {
                    x.i("MicroMsg.MultiDex", "extract dex waiting for verify lock cost %dms on file: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), fmE);
                    fileInputStream = new FileInputStream(str);
                } catch (IOException e2) {
                    e = e2;
                    fileInputStream = null;
                    shareFileLockHelper = ad;
                    try {
                        x.printErrStackTrace("MicroMsg.MultiDex", e, "", new Object[0]);
                        x.e("MicroMsg.MultiDex", "verify local secondary dex failed, cannot lock file: %s", file2.getAbsolutePath());
                        if (shareFileLockHelper != null) {
                            try {
                                shareFileLockHelper.close();
                            } catch (Exception e3) {
                                x.e("MicroMsg.MultiDex", "verify local secondary dex failed to close lock file: %s", file2.getAbsolutePath());
                            }
                        }
                        b(fileInputStream);
                        return false;
                    } catch (Throwable th) {
                        e = th;
                        ad = shareFileLockHelper;
                        if (ad != null) {
                            try {
                                ad.close();
                            } catch (Exception e4) {
                                x.e("MicroMsg.MultiDex", "verify local secondary dex failed to close lock file: %s", file2.getAbsolutePath());
                            }
                        }
                        b(fileInputStream);
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    fileInputStream = null;
                    if (ad != null) {
                        ad.close();
                    }
                    b(fileInputStream);
                    throw e;
                }
                try {
                    str = g.a(fileInputStream, 102400);
                    if (str == null || !str.equalsIgnoreCase(aVar.fmH)) {
                        try {
                            ad.close();
                        } catch (Exception e5) {
                            x.e("MicroMsg.MultiDex", "verify local secondary dex failed to close lock file: %s", file2.getAbsolutePath());
                        }
                        b(fileInputStream);
                        return false;
                    }
                    try {
                        ad.close();
                    } catch (Exception e6) {
                        x.e("MicroMsg.MultiDex", "verify local secondary dex failed to close lock file: %s", file2.getAbsolutePath());
                    }
                    b(fileInputStream);
                    return true;
                } catch (IOException e7) {
                    e = e7;
                    shareFileLockHelper = ad;
                    x.printErrStackTrace("MicroMsg.MultiDex", e, "", new Object[0]);
                    x.e("MicroMsg.MultiDex", "verify local secondary dex failed, cannot lock file: %s", file2.getAbsolutePath());
                    if (shareFileLockHelper != null) {
                        shareFileLockHelper.close();
                    }
                    b(fileInputStream);
                    return false;
                } catch (Throwable th3) {
                    e = th3;
                    if (ad != null) {
                        ad.close();
                    }
                    b(fileInputStream);
                    throw e;
                }
            } catch (IOException e8) {
                e = e8;
                fileInputStream = null;
                x.printErrStackTrace("MicroMsg.MultiDex", e, "", new Object[0]);
                x.e("MicroMsg.MultiDex", "verify local secondary dex failed, cannot lock file: %s", file2.getAbsolutePath());
                if (shareFileLockHelper != null) {
                    shareFileLockHelper.close();
                }
                b(fileInputStream);
                return false;
            } catch (Throwable th4) {
                e = th4;
                fileInputStream = null;
                ad = null;
                if (ad != null) {
                    ad.close();
                }
                b(fileInputStream);
                throw e;
            }
        }
        x.i("MicroMsg.MultiDex", "dex file not exist: %s", str);
        return false;
    }

    private static void a(Context context, String str, List<File> list) {
        Object obj = (PathClassLoader) context.getClassLoader();
        x.i("MicroMsg.MultiDex", "before reflectPathClassLoader for debug: ClassLoader " + obj);
        Collections.sort(list, new Comparator<File>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                File file = (File) obj;
                File file2 = (File) obj2;
                if (file == null || file2 == null) {
                    return 0;
                }
                String name = file.getName();
                String name2 = file2.getName();
                return (name.contains("classes") && name2.contains("classes")) ? name.charAt(7) - name2.charAt(7) : 0;
            }
        });
        for (File name : list) {
            x.i("MicroMsg.MultiDex", "real reflectPathClassLoader dexname: " + name.getName());
        }
        File name2 = new File(str);
        if (!list.isEmpty()) {
            Object obj2;
            if (VERSION.SDK_INT >= 19) {
                obj2 = a(obj, "pathList").get(obj);
                ArrayList arrayList = new ArrayList();
                b(obj2, "dexElements", b.a(obj2, new ArrayList(list), name2, arrayList));
                if (arrayList.size() > 0) {
                    Iterator it = arrayList.iterator();
                    if (it.hasNext()) {
                        x.w("MicroMsg.MultiDex", "Exception in makeDexElement", (IOException) it.next());
                        throw ((IOException) it.next());
                    }
                }
            }
            obj2 = a(obj, "pathList").get(obj);
            ArrayList arrayList2 = new ArrayList(list);
            b(obj2, "dexElements", (Object[]) a(obj2, "makeDexElements", ArrayList.class, File.class).invoke(obj2, new Object[]{arrayList2, name2}));
        }
        x.i("MicroMsg.MultiDex", "after reflectPathClassloader for debug: ClassLoader " + obj);
    }

    private static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                x.w("MicroMsg.MultiDex", "Failed to close resource", e);
            }
        }
    }

    private static int az(Context context) {
        if (fmF != null) {
            x.w("MicroMsg.MultiDex", "preloaded dex files not empty, skipped preloading");
            return 1;
        }
        try {
            Set set;
            String convertStreamToString = d.convertStreamToString(context.getAssets().open("secondary-program-dex-jars/metadata.txt"));
            if (convertStreamToString == null || convertStreamToString.length() <= 0) {
                set = null;
            } else {
                set = new HashSet();
                for (String str : convertStreamToString.split("\n")) {
                    if (str != null && str.length() > 0) {
                        String[] split = str.split(" ", 3);
                        if (split != null && split.length >= 3) {
                            String trim = split[0].trim();
                            x.i("MicroMsg.MultiDex", "try parse dexname: %s, dexmd5:%s, classname:%s", trim, split[1].trim(), split[2].trim());
                            if (trim != null && trim.length() > 0) {
                                set.add(new a(trim, r7, str));
                            }
                        }
                    }
                }
            }
            fmF = set;
        } catch (Throwable e) {
            x.e("MicroMsg.MultiDex", "load preload libraries failed");
            x.printErrStackTrace("MicroMsg.MultiDex", e, "", new Object[0]);
        }
        return 0;
    }

    private static Field a(Object obj, String str) {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException e) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    private static Method a(Object obj, String str, Class<?>... clsArr) {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException e) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }
}
