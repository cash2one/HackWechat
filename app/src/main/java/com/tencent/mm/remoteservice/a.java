package com.tencent.mm.remoteservice;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class a extends com.tencent.mm.remoteservice.b.a {
    private final d mfB;
    protected RemoteService xba;
    public b xbb;

    public a(d dVar) {
        this.mfB = dVar;
    }

    public void onCallback(String str, Bundle bundle, boolean z) {
        x.d("MicroMsg.BaseClientRequest", "class:%s, method:%s, clientCall:%B", new Object[]{getClass().getName(), str, Boolean.valueOf(z)});
        Method method = null;
        try {
            for (Method method2 : getClass().getMethods()) {
                if (method2.getName().equalsIgnoreCase(str)) {
                    method = method2;
                    break;
                }
            }
            if (method != null) {
                if (method.isAnnotationPresent(z ? e.class : f.class)) {
                    Object invoke = method.invoke(this, getArgs(bundle));
                    if (method.getReturnType() != Void.TYPE) {
                        bundle.putSerializable("result_key", (Serializable) invoke);
                    }
                }
            }
        } catch (Throwable e) {
            x.e("MicroMsg.BaseClientRequest", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public Object REMOTE_CALL(final String str, final Object... objArr) {
        if (this.mfB.isConnected()) {
            Bundle objectsToBundle = objectsToBundle(objArr);
            this.mfB.a(this, str, objectsToBundle);
            objectsToBundle.setClassLoader(getClass().getClassLoader());
            return objectsToBundle.get("result_key");
        }
        this.mfB.I(new Runnable(this) {
            final /* synthetic */ a xbd;

            public final void run() {
                this.xbd.mfB.a(this.xbd, str, this.xbd.objectsToBundle(objArr));
            }
        });
        return null;
    }

    public Object CLIENT_CALL(String str, Object... objArr) {
        Bundle objectsToBundle = objectsToBundle(objArr);
        try {
            this.xbb.onCallback(str, objectsToBundle, true);
        } catch (Throwable e) {
            x.e("MicroMsg.BaseClientRequest", "exception:%s", new Object[]{bh.i(e)});
        }
        return objectsToBundle.get("result_key");
    }

    public Bundle objectsToBundle(Object... objArr) {
        Bundle bundle = new Bundle();
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (objArr[i] instanceof Bundle) {
                bundle.putBundle(String.valueOf(i), (Bundle) objArr[i]);
            } else if (objArr[i] instanceof Parcelable) {
                bundle.putParcelable(String.valueOf(i), (Parcelable) objArr[i]);
            } else {
                bundle.putSerializable(String.valueOf(i), (Serializable) objArr[i]);
            }
        }
        return bundle;
    }

    public Object[] getArgs(Bundle bundle) {
        List linkedList = new LinkedList();
        int size = bundle.size();
        for (int i = 0; i < size; i++) {
            String valueOf = String.valueOf(i);
            if (bundle.containsKey(valueOf)) {
                linkedList.add(bundle.get(valueOf));
            }
        }
        return linkedList.toArray();
    }
}
