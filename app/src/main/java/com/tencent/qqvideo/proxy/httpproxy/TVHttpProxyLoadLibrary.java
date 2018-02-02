package com.tencent.qqvideo.proxy.httpproxy;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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

public final class TVHttpProxyLoadLibrary {
    public static final String ASSETS_LIBRARY_SRC_DIR = "libs/";
    private static Context mContext = null;
    private static final HashMap<String, WeakReference<ClassLoader>> mLoadedLibs = new HashMap();

    private TVHttpProxyLoadLibrary() {
    }

    public static String find(String str, Context context) {
        if (context == null) {
            return null;
        }
        String str2;
        try {
            ClassLoader classLoader = TVHttpProxyLoadLibrary.class.getClassLoader();
            Method declaredMethod = ClassLoader.class.getDeclaredMethod("findLibrary", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            str2 = (String) declaredMethod.invoke(classLoader, new Object[]{str});
        } catch (Exception e) {
            str2 = null;
        }
        if (str2 != null) {
            return str2;
        }
        File file = new File(context.getDir("recover_lib", 0), "lib" + str + ".so");
        if (file.canRead()) {
            return file.getAbsolutePath();
        }
        return str2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void load(String str, ClassLoader classLoader, Context context) {
        ZipFile zipFile;
        Throwable e;
        if (str != null && str.length() != 0 && classLoader != null) {
            mContext = context;
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
        }
        return;
        UnsatisfiedLinkError unsatisfiedLinkError;
        r3.delete();
        UnsatisfiedLinkError unsatisfiedLinkError2 = unsatisfiedLinkError;
        try {
            reflectSystemLoadlibrary(str, classLoader);
            synchronized (mLoadedLibs) {
                mLoadedLibs.put(str, new WeakReference(classLoader));
            }
        } catch (UnsatisfiedLinkError e2) {
            unsatisfiedLinkError = e2;
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof UnsatisfiedLinkError) {
                if (unsatisfiedLinkError2 == null) {
                    unsatisfiedLinkError = (UnsatisfiedLinkError) e3.getCause();
                    zipFile = new ZipFile(context.getApplicationInfo().sourceDir);
                    if (extractLibrary(zipFile, str, generateAbiList(), r3)) {
                        throw new RuntimeException("Can't find recover library: " + str);
                    }
                    try {
                        zipFile.close();
                    } catch (IOException e4) {
                    }
                    try {
                        reflectSystemLoad(r3.getAbsolutePath(), classLoader);
                        synchronized (mLoadedLibs) {
                            mLoadedLibs.put(str, new WeakReference(classLoader));
                        }
                        return;
                    } catch (InvocationTargetException e5) {
                        if (unsatisfiedLinkError == null) {
                            throw ((UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed recovering native library: " + str).initCause(e5.getCause()));
                        }
                        throw unsatisfiedLinkError;
                    } catch (Throwable e6) {
                        if (unsatisfiedLinkError == null) {
                            throw ((UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed recovering native library.").initCause(e6));
                        }
                        throw unsatisfiedLinkError;
                    }
                }
                unsatisfiedLinkError = unsatisfiedLinkError2;
                try {
                    zipFile = new ZipFile(context.getApplicationInfo().sourceDir);
                    try {
                        if (extractLibrary(zipFile, str, generateAbiList(), r3)) {
                            zipFile.close();
                            reflectSystemLoad(r3.getAbsolutePath(), classLoader);
                            synchronized (mLoadedLibs) {
                                mLoadedLibs.put(str, new WeakReference(classLoader));
                            }
                            return;
                        }
                        throw new RuntimeException("Can't find recover library: " + str);
                    } catch (Exception e7) {
                        e = e7;
                        try {
                            throw ((UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed recovering native library.").initCause(e));
                        } catch (Throwable th) {
                            e = th;
                            if (zipFile != null) {
                                try {
                                    zipFile.close();
                                } catch (IOException e8) {
                                }
                            }
                            throw e;
                        }
                    }
                } catch (Exception e9) {
                    e = e9;
                    zipFile = null;
                    throw ((UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed recovering native library.").initCause(e));
                } catch (Throwable th2) {
                    e = th2;
                    zipFile = null;
                    if (zipFile != null) {
                        zipFile.close();
                    }
                    throw e;
                }
            }
            throw ((UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed recovering native library: " + str).initCause(e3.getCause()));
        } catch (Throwable e10) {
            unsatisfiedLinkError = (UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed recovering native library: " + str).initCause(e10);
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
        Method method = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class});
        String str = (String) method.invoke(null, new Object[]{"ro.product.cpu.abi"});
        if (str != null && str.length() > 0) {
            arrayList.add(str);
        }
        str = (String) method.invoke(null, new Object[]{"ro.product.cpu.abi2"});
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

    private static void extractAllLibraries(Context context) {
        if (context != null) {
            List generateAbiList = generateAbiList();
            File dir = context.getDir("recover_lib", 0);
            ZipFile zipFile = new ZipFile(context.getApplicationInfo().sourceDir);
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
    }

    public static void setupBrokenLibraryHandler() {
        Thread.setDefaultUncaughtExceptionHandler(new LibraryBrokenHandler(Thread.getDefaultUncaughtExceptionHandler()));
    }
}
