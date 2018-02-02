package com.tencent.tinker.loader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.ArrayMap;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class TinkerResourcePatcher {
    private static AssetManager AjA = null;
    private static Method AjB = null;
    private static Method AjC = null;
    private static Field AjD = null;
    private static Field AjE = null;
    private static Field AjF = null;
    private static Field AjG = null;
    private static Field AjH = null;
    private static Field AjI = null;
    private static Collection<WeakReference<Resources>> Ajy = null;
    private static Object Ajz = null;

    TinkerResourcePatcher() {
    }

    public static void iv(Context context) {
        Class cls;
        Class cls2 = Class.forName("android.app.ActivityThread");
        Ajz = ShareReflectUtil.c(context, cls2);
        try {
            cls = Class.forName("android.app.LoadedApk");
        } catch (ClassNotFoundException e) {
            cls = Class.forName("android.app.ActivityThread$PackageInfo");
        }
        Field declaredField = cls.getDeclaredField("mResDir");
        AjF = declaredField;
        declaredField.setAccessible(true);
        declaredField = cls2.getDeclaredField("mPackages");
        AjG = declaredField;
        declaredField.setAccessible(true);
        declaredField = cls2.getDeclaredField("mResourcePackages");
        AjH = declaredField;
        declaredField.setAccessible(true);
        if (context.getAssets().getClass().getName().equals("android.content.res.BaiduAssetManager")) {
            AjA = (AssetManager) Class.forName("android.content.res.BaiduAssetManager").getConstructor(new Class[0]).newInstance(new Object[0]);
        } else {
            AjA = (AssetManager) AssetManager.class.getConstructor(new Class[0]).newInstance(new Object[0]);
        }
        Method declaredMethod = AssetManager.class.getDeclaredMethod("addAssetPath", new Class[]{String.class});
        AjB = declaredMethod;
        declaredMethod.setAccessible(true);
        declaredMethod = AssetManager.class.getDeclaredMethod("ensureStringBlocks", new Class[0]);
        AjC = declaredMethod;
        declaredMethod.setAccessible(true);
        if (VERSION.SDK_INT >= 19) {
            cls2 = Class.forName("android.app.ResourcesManager");
            declaredMethod = cls2.getDeclaredMethod("getInstance", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            try {
                declaredField = cls2.getDeclaredField("mActiveResources");
                declaredField.setAccessible(true);
                Ajy = ((ArrayMap) declaredField.get(invoke)).values();
            } catch (NoSuchFieldException e2) {
                declaredField = cls2.getDeclaredField("mResourceReferences");
                declaredField.setAccessible(true);
                Ajy = (Collection) declaredField.get(invoke);
            }
        } else {
            declaredField = cls2.getDeclaredField("mActiveResources");
            declaredField.setAccessible(true);
            Ajy = ((HashMap) declaredField.get(Ajz)).values();
        }
        if (Ajy == null) {
            throw new IllegalStateException("resource references is null");
        }
        if (VERSION.SDK_INT >= 24) {
            try {
                declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                AjE = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable th) {
                declaredField = Resources.class.getDeclaredField("mAssets");
                AjD = declaredField;
                declaredField.setAccessible(true);
            }
        } else {
            declaredField = Resources.class.getDeclaredField("mAssets");
            AjD = declaredField;
            declaredField.setAccessible(true);
        }
        try {
            AjI = ShareReflectUtil.d(ApplicationInfo.class, "publicSourceDir");
        } catch (NoSuchFieldException e3) {
        }
    }

    public static void bV(Context context, String str) {
        Object obj;
        Field a;
        if (str != null) {
            Field[] fieldArr = new Field[]{AjG, AjH};
            for (int i = 0; i < 2; i++) {
                for (Entry value : ((Map) fieldArr[i].get(Ajz)).entrySet()) {
                    obj = ((WeakReference) value.getValue()).get();
                    if (!(obj == null || str == null)) {
                        AjF.set(obj, str);
                    }
                }
            }
            if (((Integer) AjB.invoke(AjA, new Object[]{str})).intValue() == 0) {
                throw new IllegalStateException("Could not create new AssetManager");
            }
            AjC.invoke(AjA, new Object[0]);
            for (WeakReference weakReference : Ajy) {
                Resources resources = (Resources) weakReference.get();
                if (resources != null) {
                    try {
                        AjD.set(resources, AjA);
                    } catch (Throwable th) {
                        obj = AjE.get(resources);
                        a = ShareReflectUtil.a(obj, "mAssets");
                        a.setAccessible(true);
                        a.set(obj, AjA);
                    }
                    try {
                        a = ShareReflectUtil.d(Resources.class, "mTypedArrayPool");
                        obj = a.get(resources);
                        Field a2 = ShareReflectUtil.a(obj, "mPool");
                        Constructor constructor = obj.getClass().getConstructor(new Class[]{Integer.TYPE});
                        constructor.setAccessible(true);
                        a.set(resources, constructor.newInstance(new Object[]{Integer.valueOf(((Object[]) a2.get(obj)).length)}));
                    } catch (Throwable th2) {
                        new StringBuilder("clearPreloadTypedArrayIssue failed, ignore error: ").append(th2);
                    }
                    resources.updateConfiguration(resources.getConfiguration(), resources.getDisplayMetrics());
                }
            }
            if (VERSION.SDK_INT >= 24) {
                try {
                    if (AjI != null) {
                        AjI.set(context.getApplicationInfo(), str);
                    }
                } catch (Throwable th3) {
                }
            }
            if (!iw(context)) {
                throw new TinkerRuntimeException("checkResInstall failed");
            }
        }
    }

    private static boolean iw(Context context) {
        Object open;
        Object obj = null;
        try {
            open = context.getAssets().open("only_use_to_test_tinker_resource.txt");
        } catch (Throwable th) {
            open = th;
            StringBuilder stringBuilder = new StringBuilder("checkResUpdate failed, can't find test resource assets file only_use_to_test_tinker_resource.txt e:");
            open = open.getMessage();
            stringBuilder.append(open);
            return false;
        } finally {
            SharePatchFileUtil.cy(
/*
Method generation error in method: com.tencent.tinker.loader.TinkerResourcePatcher.iw(android.content.Context):boolean
jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0027: INVOKE  (wrap: java.lang.Object
  ?: MERGE  (r3_1 java.lang.Object) = (r3_0 'obj' java.lang.Object), (r0_5 'open' java.lang.Object)) com.tencent.tinker.loader.shareutil.SharePatchFileUtil.cy(java.lang.Object):void type: STATIC in method: com.tencent.tinker.loader.TinkerResourcePatcher.iw(android.content.Context):boolean
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
Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: MERGE  (r3_1 java.lang.Object) = (r3_0 'obj' java.lang.Object), (r0_5 'open' java.lang.Object) in method: com.tencent.tinker.loader.TinkerResourcePatcher.iw(android.content.Context):boolean
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:101)
	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:679)
	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:649)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:343)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 20 more
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:530)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:514)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:211)
	... 25 more

*/
        }
