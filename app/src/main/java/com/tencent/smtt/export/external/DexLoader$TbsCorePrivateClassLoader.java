package com.tencent.smtt.export.external;

import dalvik.system.DexClassLoader;

class DexLoader$TbsCorePrivateClassLoader extends DexClassLoader {
    public DexLoader$TbsCorePrivateClassLoader(String str, String str2, String str3, ClassLoader classLoader) {
        super(str, str2, str3, classLoader);
    }

    protected Class<?> loadClass(String str, boolean z) {
        if (str == null || !str.startsWith("org.chromium")) {
            return super.loadClass(str, z);
        }
        Class<?> findLoadedClass = findLoadedClass(str);
        if (findLoadedClass != null) {
            return findLoadedClass;
        }
        try {
            findLoadedClass = findClass(str);
        } catch (ClassNotFoundException e) {
        }
        if (findLoadedClass != null) {
            return findLoadedClass;
        }
        ClassLoader parent = getParent();
        return parent != null ? parent.loadClass(str) : findLoadedClass;
    }
}
