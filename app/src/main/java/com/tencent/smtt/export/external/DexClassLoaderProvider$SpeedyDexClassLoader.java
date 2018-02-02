package com.tencent.smtt.export.external;

import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.net.URL;
import java.util.Enumeration;

class DexClassLoaderProvider$SpeedyDexClassLoader extends BaseDexClassLoader {
    public DexClassLoaderProvider$SpeedyDexClassLoader(String str, File file, String str2, ClassLoader classLoader) {
        super(str, null, str2, classLoader);
    }

    public Package definePackage(String str, String str2, String str3, String str4, String str5, String str6, String str7, URL url) {
        return super.definePackage(str, str2, str3, str4, str5, str6, str7, url);
    }

    public Class<?> findClass(String str) {
        return super.findClass(str);
    }

    public URL findResource(String str) {
        return super.findResource(str);
    }

    public Enumeration<URL> findResources(String str) {
        return super.findResources(str);
    }

    public synchronized Package getPackage(String str) {
        return super.getPackage(str);
    }

    public Package[] getPackages() {
        return super.getPackages();
    }

    public Class<?> loadClass(String str, boolean z) {
        return super.loadClass(str, z);
    }
}
