package android.support.multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import com.tencent.wcdb.FileUtils;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

public final class a {
    private static final String oE = ("code_cache" + File.separator + "secondary-dexes");
    private static final Set<String> oF = new HashSet();
    private static final boolean oG = l(System.getProperty("java.vm.version"));

    private static final class a {
        static void a(ClassLoader classLoader, List<File> list) {
            int size = list.size();
            Field b = a.a(classLoader, "path");
            StringBuilder stringBuilder = new StringBuilder((String) b.get(classLoader));
            Object[] objArr = new String[size];
            Object[] objArr2 = new File[size];
            Object[] objArr3 = new ZipFile[size];
            Object[] objArr4 = new DexFile[size];
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File file = (File) listIterator.next();
                String absolutePath = file.getAbsolutePath();
                stringBuilder.append(':').append(absolutePath);
                int previousIndex = listIterator.previousIndex();
                objArr[previousIndex] = absolutePath;
                objArr2[previousIndex] = file;
                objArr3[previousIndex] = new ZipFile(file);
                objArr4[previousIndex] = DexFile.loadDex(absolutePath, absolutePath + ".dex", 0);
            }
            b.set(classLoader, stringBuilder.toString());
            a.a((Object) classLoader, "mPaths", objArr);
            a.a((Object) classLoader, "mFiles", objArr2);
            a.a((Object) classLoader, "mZips", objArr3);
            a.a((Object) classLoader, "mDexs", objArr4);
        }
    }

    static /* synthetic */ void a(Object obj, String str, Object[] objArr) {
        Field a = a(obj, str);
        Object[] objArr2 = (Object[]) a.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        a.set(obj, objArr3);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void f(Context context) {
        if (!oG) {
            if (VERSION.SDK_INT < 4) {
                throw new RuntimeException("Multi dex installation failed. SDK " + VERSION.SDK_INT + " is unsupported. Min SDK version is 4.");
            }
            try {
                ApplicationInfo g = g(context);
                if (g != null) {
                    synchronized (oF) {
                        String str = g.sourceDir;
                        if (oF.contains(str)) {
                            return;
                        }
                        oF.add(str);
                        if (VERSION.SDK_INT > 20) {
                            new StringBuilder("MultiDex is not guaranteed to work in SDK version ").append(VERSION.SDK_INT).append(": SDK version higher than 20 should be backed by runtime with built-in multidex capabilty but it's not the ").append("case here: java.vm.version=\"").append(System.getProperty("java.vm.version")).append("\"");
                        }
                        try {
                            ClassLoader classLoader = context.getClassLoader();
                            if (classLoader == null) {
                                return;
                            }
                            try {
                                h(context);
                            } catch (Throwable th) {
                            }
                            File file = new File(g.dataDir, oE);
                            List a = b.a(context, g, file, false);
                            if (d(a)) {
                                a(classLoader, file, a);
                            } else {
                                List a2 = b.a(context, g, file, true);
                                if (d(a2)) {
                                    a(classLoader, file, a2);
                                } else {
                                    throw new RuntimeException("Zip files were not valid.");
                                }
                            }
                        } catch (RuntimeException e) {
                        }
                    }
                }
            } catch (Exception e2) {
                throw new RuntimeException("Multi dex installation failed (" + e2.getMessage() + ").");
            }
        }
    }

    private static ApplicationInfo g(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            if (packageManager == null || packageName == null) {
                return null;
            }
            return packageManager.getApplicationInfo(packageName, FileUtils.S_IWUSR);
        } catch (RuntimeException e) {
            return null;
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
        new StringBuilder("VM with version ").append(str).append(z ? " has multidex support" : " does not have multidex support");
        return z;
    }

    private static void a(ClassLoader classLoader, File file, List<File> list) {
        if (!list.isEmpty()) {
            Object obj;
            ArrayList arrayList;
            if (VERSION.SDK_INT >= 19) {
                obj = a(classLoader, "pathList").get(classLoader);
                ArrayList arrayList2 = new ArrayList();
                arrayList = new ArrayList(list);
                a(obj, "dexElements", (Object[]) a(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class).invoke(obj, new Object[]{arrayList, file, arrayList2}));
                if (arrayList2.size() > 0) {
                    Object obj2;
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                    Field a = a(classLoader, "dexElementsSuppressedExceptions");
                    IOException[] iOExceptionArr = (IOException[]) a.get(classLoader);
                    if (iOExceptionArr == null) {
                        obj2 = (IOException[]) arrayList2.toArray(new IOException[arrayList2.size()]);
                    } else {
                        obj = new IOException[(arrayList2.size() + iOExceptionArr.length)];
                        arrayList2.toArray(obj);
                        System.arraycopy(iOExceptionArr, 0, obj, arrayList2.size(), iOExceptionArr.length);
                        obj2 = obj;
                    }
                    a.set(classLoader, obj2);
                }
            } else if (VERSION.SDK_INT >= 14) {
                obj = a(classLoader, "pathList").get(classLoader);
                arrayList = new ArrayList(list);
                a(obj, "dexElements", (Object[]) a(obj, "makeDexElements", ArrayList.class, File.class).invoke(obj, new Object[]{arrayList, file}));
            } else {
                a.a(classLoader, list);
            }
        }
    }

    private static boolean d(List<File> list) {
        for (File c : list) {
            if (!b.c(c)) {
                return false;
            }
        }
        return true;
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

    private static void h(Context context) {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            new StringBuilder("Clearing old secondary dex dir (").append(file.getPath()).append(").");
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                new StringBuilder("Failed to list secondary dex dir content (").append(file.getPath()).append(").");
                return;
            }
            for (File file2 : listFiles) {
                new StringBuilder("Trying to delete old file ").append(file2.getPath()).append(" of size ").append(file2.length());
                if (file2.delete()) {
                    new StringBuilder("Deleted old file ").append(file2.getPath());
                } else {
                    new StringBuilder("Failed to delete old file ").append(file2.getPath());
                }
            }
            if (file.delete()) {
                new StringBuilder("Deleted old secondary dex dir ").append(file.getPath());
            } else {
                new StringBuilder("Failed to delete secondary dex dir ").append(file.getPath());
            }
        }
    }
}
