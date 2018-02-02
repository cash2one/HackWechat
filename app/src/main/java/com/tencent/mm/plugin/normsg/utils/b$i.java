package com.tencent.mm.plugin.normsg.utils;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.IInterface;
import android.os.Parcel;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileDescriptor;
import java.lang.reflect.Method;

final class b$i implements IBinder {
    final /* synthetic */ b oTi;
    private final Class<?> oTv;
    private a<String> oTw = null;
    private String oTx = null;

    b$i(b bVar, Class<?> cls) {
        this.oTi = bVar;
        this.oTv = cls;
    }

    public final synchronized SparseArray<String> bgf() {
        SparseArray<String> sparseArray;
        if (this.oTw != null) {
            sparseArray = this.oTw;
        } else {
            this.oTw = new a(this, (byte) 0);
            IInterface iInterface = (IInterface) g.a(this.oTv, "asInterface", g.b(new Class[]{IBinder.class}), new Object[]{this});
            for (Class cls : this.oTv.getInterfaces()) {
                if (IInterface.class.isAssignableFrom(cls)) {
                    for (Method method : cls.getDeclaredMethods()) {
                        if (!"asBinder".equals(method.getName())) {
                            this.oTx = method.getName();
                            if (!method.isAccessible()) {
                                method.setAccessible(true);
                            }
                            Class[] parameterTypes = method.getParameterTypes();
                            int length = parameterTypes.length;
                            Object[] objArr = new Object[length];
                            for (int i = 0; i < length; i++) {
                                Class cls2 = parameterTypes[i];
                                if (!cls2.isPrimitive()) {
                                    try {
                                        if (Number.class.isAssignableFrom(cls2)) {
                                            objArr[i] = Integer.valueOf(0);
                                        } else if (Character.class.isAssignableFrom(cls2)) {
                                            objArr[i] = Character.valueOf('\u0000');
                                        } else if (Boolean.class.isAssignableFrom(cls2)) {
                                            objArr[i] = Boolean.valueOf(false);
                                        } else {
                                            objArr[i] = null;
                                        }
                                    } catch (Throwable th) {
                                        x.printErrStackTrace("MicroMsg.AED", th, "unexpected exception.", new Object[0]);
                                        b.a(this.oTi, th);
                                        this.oTw.clear();
                                    }
                                } else if (Boolean.TYPE.isAssignableFrom(cls2)) {
                                    objArr[i] = Boolean.valueOf(false);
                                } else {
                                    objArr[i] = Integer.valueOf(0);
                                }
                            }
                            method.invoke(iInterface, objArr);
                        }
                    }
                    continue;
                }
            }
            sparseArray = this.oTw;
        }
        return sparseArray;
    }

    public final String getInterfaceDescriptor() {
        return null;
    }

    public final boolean pingBinder() {
        return false;
    }

    public final boolean isBinderAlive() {
        return false;
    }

    public final IInterface queryLocalInterface(String str) {
        return null;
    }

    public final void dump(FileDescriptor fileDescriptor, String[] strArr) {
    }

    public final void dumpAsync(FileDescriptor fileDescriptor, String[] strArr) {
    }

    public final boolean transact(int i, Parcel parcel, Parcel parcel2, int i2) {
        synchronized (this) {
            if (this.oTw != null) {
                this.oTw.put(i, this.oTx);
            }
        }
        return false;
    }

    public final void linkToDeath(DeathRecipient deathRecipient, int i) {
    }

    public final boolean unlinkToDeath(DeathRecipient deathRecipient, int i) {
        return false;
    }
}
