package com.tencent.smtt.export.external;

import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.TimerTask;

class DexClassLoaderProvider$1 extends TimerTask {
    final /* synthetic */ String val$dexName;
    final /* synthetic */ String val$dexPath;
    final /* synthetic */ String val$libraryPath;
    final /* synthetic */ String val$optimizedDirectory;
    final /* synthetic */ ClassLoader val$parent;

    DexClassLoaderProvider$1(String str, String str2, String str3, ClassLoader classLoader, String str4) {
        this.val$dexPath = str;
        this.val$optimizedDirectory = str2;
        this.val$libraryPath = str3;
        this.val$parent = classLoader;
        this.val$dexName = str4;
    }

    public final void run() {
        File file = new File(this.val$dexPath.replace(".jar", ".dex"));
        boolean z = file.exists() && file.length() != 0;
        long currentTimeMillis = System.currentTimeMillis();
        DexClassLoader dexClassLoader = new DexClassLoader(this.val$dexPath, this.val$optimizedDirectory, this.val$libraryPath, this.val$parent);
        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
        DexClassLoaderProvider.access$000(this.val$optimizedDirectory, this.val$dexName);
        String.format("load_dex completed -- cl_cost: %d, existed: %b", new Object[]{Long.valueOf(currentTimeMillis), Boolean.valueOf(z)});
        if (DexClassLoaderProvider.access$100() && "tbs_jars_fusion_dex.jar".equals(this.val$dexName) && DexClassLoaderProvider.mService != null) {
            DexClassLoaderProvider.mService.stopSelf();
        }
    }
}
