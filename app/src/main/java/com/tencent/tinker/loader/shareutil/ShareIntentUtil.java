package com.tencent.tinker.loader.shareutil;

import android.content.Intent;
import android.os.Bundle;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;

public class ShareIntentUtil {
    public static void a(Intent intent, int i) {
        intent.putExtra("intent_return_code", i);
    }

    public static int ar(Intent intent) {
        return p(intent, "intent_return_code");
    }

    public static void a(Intent intent, long j) {
        intent.putExtra("intent_patch_cost_time", j);
    }

    public static long as(Intent intent) {
        return intent.getLongExtra("intent_patch_cost_time", 0);
    }

    public static Throwable at(Intent intent) {
        Serializable o = o(intent, "intent_patch_exception");
        if (o != null) {
            return (Throwable) o;
        }
        return null;
    }

    public static Throwable au(Intent intent) {
        Serializable o = o(intent, "intent_patch_interpret_exception");
        if (o != null) {
            return (Throwable) o;
        }
        return null;
    }

    public static HashMap<String, String> av(Intent intent) {
        Serializable o = o(intent, "intent_patch_dexes_path");
        if (o != null) {
            return (HashMap) o;
        }
        return null;
    }

    public static HashMap<String, String> aw(Intent intent) {
        Serializable o = o(intent, "intent_patch_libs_path");
        if (o != null) {
            return (HashMap) o;
        }
        return null;
    }

    public static HashMap<String, String> ax(Intent intent) {
        Serializable o = o(intent, "intent_patch_package_config");
        if (o != null) {
            return (HashMap) o;
        }
        return null;
    }

    public static String j(Intent intent, String str) {
        String str2 = null;
        if (intent != null) {
            try {
                str2 = intent.getStringExtra(str);
            } catch (Exception e) {
                new StringBuilder("getStringExtra exception:").append(e.getMessage());
            }
        }
        return str2;
    }

    public static Serializable o(Intent intent, String str) {
        Serializable serializable = null;
        if (intent != null) {
            try {
                serializable = intent.getSerializableExtra(str);
            } catch (Exception e) {
                new StringBuilder("getSerializableExtra exception:").append(e.getMessage());
            }
        }
        return serializable;
    }

    private static int p(Intent intent, String str) {
        int i = -10000;
        if (intent != null) {
            try {
                i = intent.getIntExtra(str, -10000);
            } catch (Exception e) {
                new StringBuilder("getIntExtra exception:").append(e.getMessage());
            }
        }
        return i;
    }

    public static boolean q(Intent intent, String str) {
        boolean z = false;
        if (intent != null) {
            try {
                z = intent.getBooleanExtra(str, false);
            } catch (Exception e) {
                new StringBuilder("getBooleanExtra exception:").append(e.getMessage());
            }
        }
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(Intent intent, ClassLoader classLoader) {
        try {
            Field d = ShareReflectUtil.d(Intent.class, "mExtras");
            if (((Bundle) d.get(intent)) == null) {
                d.set(intent, new Bundle());
            }
            intent.setExtrasClassLoader(classLoader);
        } catch (Throwable th) {
            intent.setExtrasClassLoader(classLoader);
        }
    }
}
