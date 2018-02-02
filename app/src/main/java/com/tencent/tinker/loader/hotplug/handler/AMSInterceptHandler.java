package com.tencent.tinker.loader.hotplug.handler;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Parcelable;
import com.tencent.tinker.loader.hotplug.ActivityStubManager;
import com.tencent.tinker.loader.hotplug.IncrementComponentManager;
import com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor.BinderInvocationHandler;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.reflect.Method;

public class AMSInterceptHandler implements BinderInvocationHandler {
    private static final int[] Ake = new int[]{16842840};
    private static final int Akf;
    private final Context mContext;

    static {
        int intValue;
        try {
            intValue = ((Integer) ShareReflectUtil.d(ActivityManager.class, "INTENT_SENDER_ACTIVITY").get(null)).intValue();
        } catch (Throwable th) {
            intValue = 2;
        }
        Akf = intValue;
    }

    public AMSInterceptHandler(Context context) {
        Context context2 = context;
        while (context2 instanceof ContextWrapper) {
            context = ((ContextWrapper) context2).getBaseContext();
            if (context == null) {
                break;
            }
            context2 = context;
        }
        this.mContext = context2;
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        int i = 0;
        String name = method.getName();
        if ("startActivity".equals(name)) {
            return a(obj, method, objArr);
        }
        if ("startActivities".equals(name)) {
            int i2 = 0;
            while (i2 < objArr.length) {
                if (objArr[i2] instanceof Intent[]) {
                    break;
                }
                i2++;
            }
            i2 = -1;
            if (i2 != -1) {
                Intent[] intentArr = (Intent[]) objArr[i2];
                while (i < intentArr.length) {
                    Intent intent = new Intent(intentArr[i]);
                    aq(intent);
                    intentArr[i] = intent;
                    i++;
                }
            }
            return method.invoke(obj, objArr);
        } else if ("startActivityAndWait".equals(name)) {
            return a(obj, method, objArr);
        } else {
            if ("startActivityWithConfig".equals(name)) {
                return a(obj, method, objArr);
            }
            if ("startActivityAsUser".equals(name)) {
                return a(obj, method, objArr);
            }
            if ("getIntentSender".equals(name)) {
                return b(obj, method, objArr);
            }
            return method.invoke(obj, objArr);
        }
    }

    private Object a(Object obj, Method method, Object[] objArr) {
        int i;
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (objArr[i2] instanceof Intent) {
                i = i2;
                break;
            }
        }
        i = -1;
        if (i != -1) {
            Intent intent = new Intent((Intent) objArr[i]);
            aq(intent);
            objArr[i] = intent;
        }
        return method.invoke(obj, objArr);
    }

    private Object b(Object obj, Method method, Object[] objArr) {
        int i;
        int i2 = 0;
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (objArr[i3] instanceof Intent[]) {
                i = i3;
                break;
            }
        }
        i = -1;
        if (i != -1 && ((Integer) objArr[0]).intValue() == Akf) {
            Intent[] intentArr = (Intent[]) objArr[i];
            while (i2 < intentArr.length) {
                Intent intent = new Intent(intentArr[i2]);
                aq(intent);
                intentArr[i2] = intent;
                i2++;
            }
        }
        return method.invoke(obj, objArr);
    }

    private void aq(Intent intent) {
        String packageName;
        String str = null;
        if (intent.getComponent() != null) {
            packageName = intent.getComponent().getPackageName();
            str = intent.getComponent().getClassName();
        } else {
            ResolveInfo ap;
            ResolveInfo resolveActivity = this.mContext.getPackageManager().resolveActivity(intent, 0);
            if (resolveActivity == null) {
                ap = IncrementComponentManager.ap(intent);
            } else {
                ap = resolveActivity;
            }
            if (ap == null || ap.filter == null || !ap.filter.hasCategory("android.intent.category.DEFAULT")) {
                packageName = null;
            } else {
                packageName = ap.activityInfo.packageName;
                str = ap.activityInfo.name;
            }
        }
        if (IncrementComponentManager.abF(str)) {
            ActivityInfo abG = IncrementComponentManager.abG(str);
            String s = ActivityStubManager.s(str, abG.launchMode, a(abG));
            Parcelable componentName = new ComponentName(packageName, str);
            ShareIntentUtil.a(intent, this.mContext.getClassLoader());
            intent.putExtra("tinker_iek_old_component", componentName);
            intent.setComponent(new ComponentName(packageName, s));
        }
    }

    private boolean a(ActivityInfo activityInfo) {
        boolean z = false;
        int themeResource = activityInfo.getThemeResource();
        Theme newTheme = this.mContext.getResources().newTheme();
        newTheme.applyStyle(themeResource, true);
        TypedArray typedArray = null;
        try {
            typedArray = newTheme.obtainStyledAttributes(Ake);
            z = typedArray.getBoolean(0, false);
            if (typedArray != null) {
                typedArray.recycle();
            }
        } catch (Throwable th) {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
        return z;
    }
}
