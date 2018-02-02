package com.google.android.gms.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.WorkSource;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ac {
    private static final Method aXR = pI();
    private static final Method aXS = pJ();
    private static final Method aXT = pK();
    private static final Method aXU = pL();
    private static final Method aXV = pM();

    public static boolean R(Context context) {
        return context.getPackageManager().checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) == 0;
    }

    private static int a(WorkSource workSource) {
        if (aXT != null) {
            try {
                return ((Integer) aXT.invoke(workSource, new Object[0])).intValue();
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource");
            }
        }
        return 0;
    }

    private static String a(WorkSource workSource, int i) {
        if (aXV != null) {
            try {
                return (String) aXV.invoke(workSource, new Object[]{Integer.valueOf(i)});
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource");
            }
        }
        return null;
    }

    public static List<String> b(WorkSource workSource) {
        int i = 0;
        int a = workSource == null ? 0 : a(workSource);
        if (a == 0) {
            return Collections.EMPTY_LIST;
        }
        List<String> arrayList = new ArrayList();
        while (i < a) {
            String a2 = a(workSource, i);
            if (!ab.aZ(a2)) {
                arrayList.add(a2);
            }
            i++;
        }
        return arrayList;
    }

    private static WorkSource d(int i, String str) {
        WorkSource workSource = new WorkSource();
        if (aXS != null) {
            if (str == null) {
                str = "";
            }
            try {
                aXS.invoke(workSource, new Object[]{Integer.valueOf(i), str});
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource");
            }
        } else if (aXR != null) {
            try {
                aXR.invoke(workSource, new Object[]{Integer.valueOf(i)});
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource");
            }
        }
        return workSource;
    }

    public static WorkSource h(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            return applicationInfo != null ? d(applicationInfo.uid, str) : null;
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    private static Method pI() {
        Method method = null;
        try {
            method = WorkSource.class.getMethod("add", new Class[]{Integer.TYPE});
        } catch (Exception e) {
        }
        return method;
    }

    private static Method pJ() {
        Method method = null;
        if (z.ds(18)) {
            try {
                method = WorkSource.class.getMethod("add", new Class[]{Integer.TYPE, String.class});
            } catch (Exception e) {
            }
        }
        return method;
    }

    private static Method pK() {
        Method method = null;
        try {
            method = WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception e) {
        }
        return method;
    }

    private static Method pL() {
        Method method = null;
        try {
            method = WorkSource.class.getMethod("get", new Class[]{Integer.TYPE});
        } catch (Exception e) {
        }
        return method;
    }

    private static Method pM() {
        Method method = null;
        if (z.ds(18)) {
            try {
                method = WorkSource.class.getMethod("getName", new Class[]{Integer.TYPE});
            } catch (Exception e) {
            }
        }
        return method;
    }
}
