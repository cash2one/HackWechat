package com.tencent.mm.wallet_core;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static Map<String, Class<?>> zHb = new HashMap();
    private static SparseArray<c> zHc = new SparseArray();

    public static void i(String str, Class<?> cls) {
        if (zHb.containsKey(str)) {
            throw new IllegalArgumentException("register process fail, exist process=" + str);
        }
        zHb.put(str, cls);
    }

    private static String ak(Bundle bundle) {
        return bundle == null ? "" : bundle.toString();
    }

    public static void remove(int i) {
        zHc.remove(i);
    }

    public static void a(Activity activity, Class<?> cls, Bundle bundle) {
        a(activity, (Class) cls, bundle, null);
    }

    public static void a(Activity activity, Class<?> cls, Bundle bundle, com.tencent.mm.wallet_core.c.a aVar) {
        x.i("MicroMsg.ProcessManager", "startProcess to1 context:%s proc name: %s bundle %s", new Object[]{activity, cls.getSimpleName(), ak(bundle)});
        if (bundle == null) {
            try {
                bundle = new Bundle();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ProcessManager", e, "", new Object[0]);
                return;
            }
        }
        if (bundle.getLong("key_SessionId", 0) == 0) {
            bundle.putLong("key_SessionId", System.currentTimeMillis());
        }
        c cVar = (c) cls.newInstance();
        cVar.al(bundle);
        cVar.a(aVar);
        cVar.a(activity, bundle);
        zHc.put(cls.hashCode(), cVar);
    }

    public static void b(Activity activity, String str, Bundle bundle) {
        a(activity, str, bundle, null);
    }

    public static void a(Activity activity, String str, Bundle bundle, com.tencent.mm.wallet_core.c.a aVar) {
        try {
            x.i("MicroMsg.ProcessManager", "startProcess to2 context:%s proc name: %s bundle %s", new Object[]{activity, str, ak(bundle)});
            Class cls = (Class) zHb.get(str);
            if (cls == null) {
                CharSequence format = String.format("start process=%s fail, process not register or plugin no import", new Object[]{str});
                x.e("MicroMsg.ProcessManager", format);
                u.makeText(activity, format, 1).show();
                return;
            }
            a(activity, cls, bundle, aVar);
        } catch (Throwable e) {
            x.e("MicroMsg.ProcessManager", "plugin load failed : " + e.toString());
            x.printErrStackTrace("MicroMsg.ProcessManager", e, "", new Object[0]);
        }
    }

    public static void j(Activity activity, Bundle bundle) {
        c ag = ag(activity);
        String str = "MicroMsg.ProcessManager";
        String str2 = "forwardProcess to1 context: %s bundle: %s procName %s";
        Object[] objArr = new Object[3];
        objArr[0] = activity;
        objArr[1] = ak(bundle);
        objArr[2] = ag == null ? "" : ag.aKG();
        x.i(str, str2, objArr);
        if (ag != null) {
            ag.a(activity, 0, bundle);
        }
    }

    public static void ad(Activity activity) {
        c ag = ag(activity);
        String str = "MicroMsg.ProcessManager";
        String str2 = "backProcess to1 context: %s procname %s";
        Object[] objArr = new Object[2];
        objArr[0] = activity;
        objArr[1] = ag == null ? "" : ag.aKG();
        x.i(str, str2, objArr);
        if (ag != null) {
            ag.d(activity, 0);
        }
    }

    public static void m(Activity activity, int i) {
        if (activity == null) {
            x.w("MicroMsg.ProcessManager", "hy: back context is null");
        }
        c ag = ag(activity);
        String str = "MicroMsg.ProcessManager";
        String str2 = "backProcess to1 context: %s errCode %s procname %s ";
        Object[] objArr = new Object[3];
        objArr[0] = activity;
        objArr[1] = Integer.valueOf(i);
        objArr[2] = ag == null ? "" : ag.aKG();
        x.i(str, str2, objArr);
        if (ag != null) {
            ag.d(activity, i);
        } else if (!activity.isFinishing()) {
            activity.finish();
        }
    }

    public static void c(Activity activity, Bundle bundle, int i) {
        x.i("MicroMsg.ProcessManager", "endProcess with errCode : " + i);
        if (activity == null) {
            x.w("MicroMsg.ProcessManager", "hy: end context is null");
        }
        c ag = ag(activity);
        String str = "MicroMsg.ProcessManager";
        String str2 = "endProcess to1 context: %s bundle: %s procName %s";
        Object[] objArr = new Object[3];
        objArr[0] = activity;
        objArr[1] = ak(bundle);
        objArr[2] = ag == null ? "" : ag.aKG();
        x.i(str, str2, objArr);
        if (ag != null) {
            ag.b(activity, bundle);
        } else if (!activity.isFinishing()) {
            activity.finish();
        }
    }

    public static boolean ae(Activity activity) {
        return ag(activity) != null;
    }

    public static Bundle af(Activity activity) {
        c ag = ag(activity);
        if (ag != null) {
            return ag.msB;
        }
        return new Bundle();
    }

    public static boolean k(Activity activity, Bundle bundle) {
        c ag = ag(activity);
        if (ag == null) {
            return false;
        }
        ag.al(bundle);
        return true;
    }

    public static c ag(Activity activity) {
        if (activity == null) {
            x.w("MicroMsg.ProcessManager", "hy: ac is null");
            return null;
        } else if (activity.getIntent() != null) {
            return (c) zHc.get(activity.getIntent().getIntExtra("process_id", 0));
        } else {
            x.w("MicroMsg.ProcessManager", "hy: get intent is null");
            return null;
        }
    }
}
