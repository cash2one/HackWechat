package com.tencent.mm.compatible.util;

import android.content.Intent;
import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.compatible.d.y;
import com.tencent.mm.loader.stub.BaseBuildInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tinker.lib.e.b;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import junit.framework.Assert;

public final class k {
    private static String gHS = null;
    private static boolean gHT = false;
    private static HashMap<String, String> gHU = null;
    private static final HashMap<String, WeakReference<ClassLoader>> mLoadedLibs = new HashMap();

    private static class a implements UncaughtExceptionHandler {
        private UncaughtExceptionHandler mParent;

        public a(UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.mParent = uncaughtExceptionHandler;
        }

        public final void uncaughtException(Thread thread, Throwable th) {
            Object obj = 1;
            Object obj2 = ((th instanceof UnsatisfiedLinkError) || ((th instanceof NoSuchMethodError) && th.getMessage().matches(".*sig(nature)?[=:].*"))) ? 1 : null;
            if (obj2 != null) {
                try {
                    k.ub();
                } catch (Exception e) {
                }
                if (obj != null) {
                    th = new UnsatisfiedLinkError("Invalid JNI libraries detected and recovered.").initCause(th);
                }
                this.mParent.uncaughtException(thread, th);
            }
            obj = null;
            if (obj != null) {
                th = new UnsatisfiedLinkError("Invalid JNI libraries detected and recovered.").initCause(th);
            }
            this.mParent.uncaughtException(thread, th);
        }
    }

    static /* synthetic */ void ub() {
        List generateAbiList = generateAbiList();
        File dir = ac.getContext().getDir("recover_lib", 0);
        ZipFile zipFile = new ZipFile(ac.getContext().getApplicationInfo().sourceDir);
        try {
            HashSet hashSet = new HashSet();
            Pattern compile = Pattern.compile("lib/[A-Za-z0-9-_=]+/lib([A-Za-z0-9-_=]+)\\.so");
            Enumeration entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                Matcher matcher = compile.matcher(((ZipEntry) entries.nextElement()).getName());
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    if (!hashSet.contains(group)) {
                        extractLibrary(zipFile, group, generateAbiList, new File(dir, "lib" + group + ".so"));
                        hashSet.add(group);
                    }
                }
            }
        } finally {
            zipFile.close();
        }
    }

    private k() {
    }

    public static boolean eL(String str) {
        boolean containsKey;
        synchronized (mLoadedLibs) {
            containsKey = mLoadedLibs.containsKey(str);
        }
        return containsKey;
    }

    public static String eM(String str) {
        String str2;
        try {
            ClassLoader classLoader = k.class.getClassLoader();
            Method declaredMethod = ClassLoader.class.getDeclaredMethod("findLibrary", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            str2 = (String) declaredMethod.invoke(classLoader, new Object[]{str});
        } catch (Exception e) {
            str2 = null;
        }
        if (str2 != null) {
            return str2;
        }
        File file = new File(ac.getContext().getDir("recover_lib", 0), "lib" + str + ".so");
        if (file.canRead()) {
            return file.getAbsolutePath();
        }
        return str2;
    }

    private static boolean a(String str, ClassLoader classLoader) {
        if (!BaseBuildInfo.patchEnabled()) {
            return false;
        }
        ApplicationLike tinkerApplicationLike;
        String d;
        if (!gHT) {
            tinkerApplicationLike = MMApplicationLike.getTinkerApplicationLike();
            if (tinkerApplicationLike == null) {
                throw new RuntimeException("tinker application is null when try to load from patch libs");
            }
            gHT = true;
            if (tinkerApplicationLike == null || tinkerApplicationLike.getApplication() == null) {
                throw new TinkerRuntimeException("tinkerApplication is null");
            }
            Intent tinkerResultIntent = tinkerApplicationLike.getTinkerResultIntent();
            HashMap aw = (tinkerResultIntent == null || ShareIntentUtil.ar(tinkerResultIntent) != 0) ? null : ShareIntentUtil.aw(tinkerResultIntent);
            gHU = aw;
            d = b.d(tinkerApplicationLike);
            if (ShareTinkerInternals.ov(d)) {
                gHS = null;
            } else {
                File iy = SharePatchFileUtil.iy(tinkerApplicationLike.getApplication());
                d = SharePatchFileUtil.abJ(d);
                if (!(iy == null || d == null)) {
                    gHS = new File(iy.getAbsolutePath() + "/" + d).getAbsolutePath() + "/lib";
                }
            }
        }
        if (!str.startsWith("lib")) {
            str = "lib" + str;
        }
        if (!str.endsWith(".so")) {
            str = str + ".so";
        }
        String str2 = "lib/armeabi/" + str;
        tinkerApplicationLike = MMApplicationLike.getTinkerApplicationLike();
        if (b.b(tinkerApplicationLike) && b.c(tinkerApplicationLike) && gHU != null) {
            for (String d2 : gHU.keySet()) {
                if (d2.equals(str2)) {
                    String str3 = gHS + "/" + d2;
                    File file = new File(str3);
                    if (!file.exists()) {
                        continue;
                    } else if (!tinkerApplicationLike.getTinkerLoadVerifyFlag() || SharePatchFileUtil.f(file, (String) gHU.get(d2))) {
                        try {
                            x.w("MicroMsg.LoadLibrary", "succ load from patch path: %s", str3);
                            reflectSystemLoad(str3, classLoader);
                            synchronized (mLoadedLibs) {
                                mLoadedLibs.put(str, new WeakReference(classLoader));
                            }
                            return true;
                        } catch (InvocationTargetException e) {
                            throw ((UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed loading library: " + str).initCause(e.getCause()));
                        } catch (Throwable e2) {
                            throw ((UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed loading library: " + str).initCause(e2));
                        }
                    } else {
                        x.e("MicroMsg.LoadLibrary", "loadLibraryFromTinker md5mismatch fail: %s", str3);
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(String str, ClassLoader classLoader) {
        UnsatisfiedLinkError unsatisfiedLinkError;
        String str2 = "libName or callerClassLoader is null";
        boolean z = bh.ov(str) || classLoader == null;
        Assert.assertFalse(str2, z);
        synchronized (mLoadedLibs) {
            ClassLoader classLoader2;
            WeakReference weakReference = (WeakReference) mLoadedLibs.get(str);
            if (weakReference != null) {
                classLoader2 = (ClassLoader) weakReference.get();
            } else {
                classLoader2 = null;
            }
            if (classLoader2 != null) {
                if (classLoader2 == classLoader) {
                    return;
                }
                throw new UnsatisfiedLinkError("Library '" + str + "' was loaded by a different ClassLoader.");
            }
        }
        r4.delete();
        UnsatisfiedLinkError unsatisfiedLinkError2 = unsatisfiedLinkError;
        try {
            reflectSystemLoadlibrary(str, classLoader);
            synchronized (mLoadedLibs) {
                mLoadedLibs.put(str, new WeakReference(classLoader));
            }
            return;
        } catch (UnsatisfiedLinkError e) {
            unsatisfiedLinkError = e;
            if (unsatisfiedLinkError2 != null) {
                unsatisfiedLinkError = unsatisfiedLinkError2;
            }
        } catch (InvocationTargetException e2) {
            if (!(e2.getCause() instanceof UnsatisfiedLinkError)) {
                throw ((UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed recovering native library: " + str).initCause(e2.getCause()));
            } else if (unsatisfiedLinkError2 == null) {
                unsatisfiedLinkError = (UnsatisfiedLinkError) e2.getCause();
            } else {
                unsatisfiedLinkError = unsatisfiedLinkError2;
            }
        } catch (Throwable th) {
            unsatisfiedLinkError = (UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed recovering native library: " + str).initCause(th);
        }
        try {
            reflectSystemLoad(r4.getAbsolutePath(), classLoader);
            synchronized (mLoadedLibs) {
                mLoadedLibs.put(str, new WeakReference(classLoader));
            }
        } catch (InvocationTargetException e3) {
            if (unsatisfiedLinkError == null) {
                throw ((UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed recovering native library: " + str).initCause(e3.getCause()));
            }
            throw unsatisfiedLinkError;
        } catch (Throwable e4) {
            if (unsatisfiedLinkError == null) {
                throw ((UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed recovering native library.").initCause(e4));
            }
            throw unsatisfiedLinkError;
        }
    }

    private static void reflectSystemLoad(String str, ClassLoader classLoader) {
        Runtime runtime = Runtime.getRuntime();
        Method declaredMethod = runtime.getClass().getDeclaredMethod("load", new Class[]{String.class, ClassLoader.class});
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(runtime, new Object[]{str, classLoader});
    }

    private static void reflectSystemLoadlibrary(String str, ClassLoader classLoader) {
        Runtime runtime = Runtime.getRuntime();
        Method declaredMethod = runtime.getClass().getDeclaredMethod("loadLibrary", new Class[]{String.class, ClassLoader.class});
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(runtime, new Object[]{str, classLoader});
    }

    private static List<String> generateAbiList() {
        List arrayList = new ArrayList(3);
        String str = y.get("ro.product.cpu.abi");
        if (str != null && str.length() > 0) {
            arrayList.add(str);
        }
        str = y.get("ro.product.cpu.abi2");
        if (str != null && str.length() > 0) {
            arrayList.add(str);
        }
        arrayList.add("armeabi");
        return arrayList;
    }

    private static boolean extractLibrary(ZipFile zipFile, String str, List<String> list, File file) {
        if (file.isFile()) {
            return true;
        }
        for (String str2 : list) {
            ZipEntry entry = zipFile.getEntry("lib/" + str2 + "/lib" + str + ".so");
            if (entry != null) {
                InputStream inputStream = zipFile.getInputStream(entry);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[2048];
                while (true) {
                    try {
                        int read = inputStream.read(bArr, 0, 2048);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    } finally {
                        inputStream.close();
                        fileOutputStream.close();
                    }
                }
                file.setReadOnly();
                return true;
            }
        }
        return false;
    }

    public static void setupBrokenLibraryHandler() {
        Thread.setDefaultUncaughtExceptionHandler(new a(Thread.getDefaultUncaughtExceptionHandler()));
    }
}
