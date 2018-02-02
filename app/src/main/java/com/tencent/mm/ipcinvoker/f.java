package com.tencent.mm.ipcinvoker;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import com.tencent.mm.ipcinvoker.b.a;
import com.tencent.mm.sdk.platformtools.x;

public class f {
    public static <T extends a> boolean a(String str, Bundle bundle, Class<T> cls, c cVar) {
        if (str != null && str.length() != 0) {
            return m.g(new 1(str, cls, bundle, cVar));
        }
        x.e("IPC.IPCInvoker", "invokeAsync failed, process is null or nil.");
        return false;
    }

    public static <T extends l> Bundle a(String str, Bundle bundle, Class<T> cls) {
        if (str.length() == 0) {
            x.e("IPC.IPCInvoker", "invokeSync failed, process is null or nil.");
            return null;
        } else if (e.fh(str)) {
            l lVar = (l) o.a(cls, l.class);
            if (lVar != null) {
                return lVar.j(bundle);
            }
            x.e("IPC.IPCInvoker", "invokeSync failed, newInstance(%s) return null.", new Object[]{cls});
            return null;
        } else {
            a ff = b.Bs().ff(str);
            if (ff == null) {
                x.e("IPC.IPCInvoker", "invokeSync failed, get bridge is null by process(%s).", new Object[]{str});
                return null;
            }
            try {
                Bundle d = ff.d(bundle, cls.getName());
                if (d == null) {
                    return d;
                }
                d.setClassLoader(f.class.getClassLoader());
                return d;
            } catch (RemoteException e) {
                x.d("IPC.IPCInvoker", "invokeSync failed, ipc invoke error : %s", new Object[]{e});
                return null;
            }
        }
    }

    public static <T extends h<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean a(String str, InputType inputType, Class<T> cls, i<ResultType> iVar) {
        if (str != null && str.length() != 0) {
            return m.g(new 2(str, inputType, cls, iVar));
        }
        x.e("IPC.IPCInvoker", "invokeAsync failed, process is null or nil.");
        return false;
    }

    public static <T extends j<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> ResultType a(String str, InputType inputType, Class<T> cls) {
        if (str == null || str.length() == 0) {
            x.e("IPC.IPCInvoker", "invokeSync failed, process is null or nil.");
            return null;
        } else if (e.fh(str)) {
            r0 = ((b) o.a(b.class, b.class)).j(a(inputType, cls));
            if (r0 == null) {
                return null;
            }
            r0.setClassLoader(f.class.getClassLoader());
            return r0.getParcelable("__remote_task_result_data");
        } else {
            a ff = b.Bs().ff(str);
            if (ff == null) {
                x.e("IPC.IPCInvoker", "invokeSync failed, get bridge is null by process(%s).", new Object[]{str});
                return null;
            }
            try {
                r0 = ff.d(a(inputType, cls), b.class.getName());
                if (r0 == null) {
                    return null;
                }
                r0.setClassLoader(f.class.getClassLoader());
                return r0.getParcelable("__remote_task_result_data");
            } catch (RemoteException e) {
                x.d("IPC.IPCInvoker", "invokeSync failed, ipc invoke error : %s", new Object[]{e});
                return null;
            }
        }
    }

    private static Bundle a(Parcelable parcelable, Class<?> cls) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("__remote_task_data", parcelable);
        bundle.putString("__remote_task_class", cls.getName());
        return bundle;
    }
}
