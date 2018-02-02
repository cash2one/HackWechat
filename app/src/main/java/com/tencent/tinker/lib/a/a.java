package com.tencent.tinker.lib.a;

import android.os.Build.VERSION;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class a {

    private static final class a {
        static /* synthetic */ void b(ClassLoader classLoader, File file) {
            Object obj = ShareReflectUtil.a((Object) classLoader, "pathList").get(classLoader);
            Field a = ShareReflectUtil.a(obj, "nativeLibraryDirectories");
            File[] fileArr = (File[]) a.get(obj);
            List arrayList = new ArrayList(fileArr.length + 1);
            arrayList.add(file);
            for (Object obj2 : fileArr) {
                if (!file.equals(obj2)) {
                    arrayList.add(obj2);
                }
            }
            a.set(obj, arrayList.toArray(new File[0]));
        }
    }

    private static final class b {
        static /* synthetic */ void c(ClassLoader classLoader, File file) {
            Collection arrayList;
            Object obj = ShareReflectUtil.a((Object) classLoader, "pathList").get(classLoader);
            List list = (List) ShareReflectUtil.a(obj, "nativeLibraryDirectories").get(obj);
            if (list == null) {
                arrayList = new ArrayList(2);
            } else {
                Object obj2 = list;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (file.equals((File) it.next())) {
                    it.remove();
                    break;
                }
            }
            arrayList.add(0, file);
            Collection collection = (List) ShareReflectUtil.a(obj, "systemNativeLibraryDirectories").get(obj);
            if (collection == null) {
                collection = new ArrayList(2);
            }
            List arrayList2 = new ArrayList((arrayList.size() + collection.size()) + 1);
            arrayList2.addAll(arrayList);
            arrayList2.addAll(collection);
            Method a = ShareReflectUtil.a(obj, "makePathElements", List.class, File.class, List.class);
            ArrayList arrayList3 = new ArrayList();
            ShareReflectUtil.a(obj, "nativeLibraryPathElements").set(obj, (Object[]) a.invoke(obj, new Object[]{arrayList2, null, arrayList3}));
        }
    }

    private static final class c {
        static void d(ClassLoader classLoader, File file) {
            String path = file.getPath();
            Field a = ShareReflectUtil.a((Object) classLoader, "libPath");
            String[] split = ((String) a.get(classLoader)).split(":");
            StringBuilder stringBuilder = new StringBuilder(path);
            for (String str : split) {
                if (!(str == null || path.equals(str))) {
                    stringBuilder.append(':').append(str);
                }
            }
            a.set(classLoader, stringBuilder.toString());
            Field a2 = ShareReflectUtil.a((Object) classLoader, "libraryPathElements");
            List list = (List) a2.get(classLoader);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (path.equals((String) it.next())) {
                    it.remove();
                    break;
                }
            }
            list.add(0, path);
            a2.set(classLoader, list);
        }
    }

    public static boolean a(ApplicationLike applicationLike, String str) {
        String d = com.tencent.tinker.lib.e.b.d(applicationLike);
        if (ShareTinkerInternals.ov(d)) {
            com.tencent.tinker.lib.f.a.e("Tinker.LoadLibrary", "failed to get current patch version.", new Object[0]);
            return false;
        }
        File iy = SharePatchFileUtil.iy(applicationLike.getApplication());
        if (iy == null) {
            com.tencent.tinker.lib.f.a.e("Tinker.LoadLibrary", "failed to get current patch directory.", new Object[0]);
            return false;
        }
        File file = new File(new File(iy.getAbsolutePath() + "/" + SharePatchFileUtil.abJ(d)).getAbsolutePath() + "/lib/lib/" + str);
        if (file.exists()) {
            ClassLoader classLoader = applicationLike.getApplication().getClassLoader();
            if (classLoader == null) {
                com.tencent.tinker.lib.f.a.e("Tinker.LoadLibrary", "classloader is null", new Object[0]);
                return false;
            }
            com.tencent.tinker.lib.f.a.i("Tinker.LoadLibrary", "before hack classloader:" + classLoader.toString(), new Object[0]);
            try {
                Method declaredMethod = a.class.getDeclaredMethod("a", new Class[]{ClassLoader.class, File.class});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, new Object[]{classLoader, file});
                com.tencent.tinker.lib.f.a.i("Tinker.LoadLibrary", "after hack classloader:" + classLoader.toString(), new Object[0]);
                return true;
            } catch (Throwable th) {
                com.tencent.tinker.lib.f.a.i("Tinker.LoadLibrary", "after hack classloader:" + classLoader.toString(), new Object[0]);
            }
        } else {
            com.tencent.tinker.lib.f.a.e("Tinker.LoadLibrary", "tinker lib path [%s] is not exists.", file);
            return false;
        }
    }

    private static void a(ClassLoader classLoader, File file) {
        if (file == null || !file.exists()) {
            com.tencent.tinker.lib.f.a.e("Tinker.LoadLibrary", "installNativeLibraryPath, folder %s is illegal", file);
        } else if ((VERSION.SDK_INT == 25 && VERSION.PREVIEW_SDK_INT != 0) || VERSION.SDK_INT > 25) {
            try {
                Collection arrayList;
                Object obj = ShareReflectUtil.a((Object) classLoader, "pathList").get(classLoader);
                List list = (List) ShareReflectUtil.a(obj, "nativeLibraryDirectories").get(obj);
                if (list == null) {
                    arrayList = new ArrayList(2);
                } else {
                    Object obj2 = list;
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (file.equals((File) it.next())) {
                        it.remove();
                        break;
                    }
                }
                arrayList.add(0, file);
                Collection collection = (List) ShareReflectUtil.a(obj, "systemNativeLibraryDirectories").get(obj);
                if (collection == null) {
                    collection = new ArrayList(2);
                }
                List arrayList2 = new ArrayList((arrayList.size() + collection.size()) + 1);
                arrayList2.addAll(arrayList);
                arrayList2.addAll(collection);
                ShareReflectUtil.a(obj, "nativeLibraryPathElements").set(obj, (Object[]) ShareReflectUtil.a(obj, "makePathElements", List.class).invoke(obj, new Object[]{arrayList2}));
            } catch (Throwable th) {
                com.tencent.tinker.lib.f.a.e("Tinker.LoadLibrary", "installNativeLibraryPath, v25 fail, sdk: %d, error: %s, try to fallback to V23", Integer.valueOf(VERSION.SDK_INT), th.getMessage());
                b.c(classLoader, file);
            }
        } else if (VERSION.SDK_INT >= 23) {
            try {
                b.c(classLoader, file);
            } catch (Throwable th2) {
                com.tencent.tinker.lib.f.a.e("Tinker.LoadLibrary", "installNativeLibraryPath, v23 fail, sdk: %d, error: %s, try to fallback to V14", Integer.valueOf(VERSION.SDK_INT), th2.getMessage());
                a.b(classLoader, file);
            }
        } else if (VERSION.SDK_INT >= 14) {
            a.b(classLoader, file);
        } else {
            c.d(classLoader, file);
        }
    }
}
