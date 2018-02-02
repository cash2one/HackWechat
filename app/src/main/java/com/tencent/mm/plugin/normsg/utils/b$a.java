package com.tencent.mm.plugin.normsg.utils;

import android.graphics.Region;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.tencent.mm.plugin.normsg.utils.b.d;
import com.tencent.mm.plugin.normsg.utils.b.i;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

final class b$a extends d {
    final /* synthetic */ b oTi;
    private i oTk = null;
    private WeakReference<Object> oTl = null;

    b$a(b bVar, Object obj, IBinder iBinder) {
        this.oTi = bVar;
        super(bVar, iBinder);
        try {
            this.oTl = new WeakReference(obj);
            this.oTk = new i(bVar, g.findClass(b.aqF() + "$Stub"));
        } catch (Throwable th) {
            b.a(bVar, th);
        }
    }

    protected final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i <= 0 || i > 16777215) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        if (this.oTk == null) {
            x.e("MicroMsg.AED", "init failed, give up intercepting.");
            return super.onTransact(i, parcel, parcel2, i2);
        } else if (this.oTl.get() == null) {
            x.e("MicroMsg.AED", "lost viewRootImpl instance, give up intercepting.");
            return super.onTransact(i, parcel, parcel2, i2);
        } else {
            String str = (String) this.oTk.bgf().get(i);
            try {
                parcel.enforceInterface(b.aqF());
                int i3;
                IBinder readStrongBinder;
                if (b.Jk().equals(str)) {
                    i3 = VERSION.SDK_INT;
                    if (i3 < 16) {
                        parcel.readInt();
                    } else {
                        parcel.readLong();
                    }
                    if (i3 >= 16 && i3 < 17) {
                        parcel.readInt();
                        parcel.readInt();
                    } else if (i3 >= 21) {
                        if (parcel.readInt() != 0) {
                            Region.CREATOR.createFromParcel(parcel);
                        }
                    }
                    parcel.readInt();
                    readStrongBinder = parcel.readStrongBinder();
                    if (i3 >= 16) {
                        parcel.readInt();
                    }
                    b.c(this.oTi).put(readStrongBinder, Integer.valueOf(parcel.readInt()));
                } else if (b.IN().equals(str)) {
                    i3 = VERSION.SDK_INT;
                    if (i3 < 16) {
                        parcel.readInt();
                    } else {
                        parcel.readLong();
                    }
                    if (i3 >= 16) {
                        parcel.readInt();
                        if (i3 < 17) {
                            parcel.readInt();
                            parcel.readInt();
                        }
                    }
                    parcel.readInt();
                    readStrongBinder = parcel.readStrongBinder();
                    if (i3 >= 16) {
                        parcel.readInt();
                    }
                    b.c(this.oTi).put(readStrongBinder, Integer.valueOf(parcel.readInt()));
                } else if (b.bfW().equals(str)) {
                    i3 = VERSION.SDK_INT;
                    parcel.readLong();
                    parcel.readString();
                    if (i3 >= 21 && parcel.readInt() != 0) {
                        Region.CREATOR.createFromParcel(parcel);
                    }
                    parcel.readInt();
                    r0 = parcel.readStrongBinder();
                    parcel.readInt();
                    b.c(this.oTi).put(r0, Integer.valueOf(parcel.readInt()));
                } else if (b.bfX().equals(str)) {
                    i3 = VERSION.SDK_INT;
                    parcel.readLong();
                    parcel.readString();
                    if (i3 >= 16 && i3 < 17) {
                        parcel.readInt();
                        parcel.readInt();
                    } else if (i3 >= 21 && parcel.readInt() != 0) {
                        Region.CREATOR.createFromParcel(parcel);
                    }
                    parcel.readInt();
                    r0 = parcel.readStrongBinder();
                    parcel.readInt();
                    b.c(this.oTi).put(r0, Integer.valueOf(parcel.readInt()));
                } else if (b.bfY().equals(str)) {
                    i3 = VERSION.SDK_INT;
                    parcel.readLong();
                    parcel.readInt();
                    if (i3 >= 16 && i3 < 17) {
                        parcel.readInt();
                        parcel.readInt();
                    } else if (i3 >= 21 && parcel.readInt() != 0) {
                        Region.CREATOR.createFromParcel(parcel);
                    }
                    parcel.readInt();
                    r0 = parcel.readStrongBinder();
                    parcel.readInt();
                    b.c(this.oTi).put(r0, Integer.valueOf(parcel.readInt()));
                } else if (b.bfZ().equals(str)) {
                    i3 = VERSION.SDK_INT;
                    parcel.readLong();
                    parcel.readInt();
                    if (i3 >= 16 && i3 < 17) {
                        parcel.readInt();
                        parcel.readInt();
                    } else if (i3 >= 21 && parcel.readInt() != 0) {
                        Region.CREATOR.createFromParcel(parcel);
                    }
                    parcel.readInt();
                    r0 = parcel.readStrongBinder();
                    parcel.readInt();
                    b.c(this.oTi).put(r0, Integer.valueOf(parcel.readInt()));
                } else if (b.bga().equals(str)) {
                    i3 = VERSION.SDK_INT;
                    if (i3 < 16) {
                        parcel.readInt();
                    } else {
                        parcel.readLong();
                    }
                    parcel.readInt();
                    if (i3 >= 16 && parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel.readInt();
                    readStrongBinder = parcel.readStrongBinder();
                    if (i3 >= 16) {
                        parcel.readInt();
                    }
                    b.c(this.oTi).put(readStrongBinder, Integer.valueOf(parcel.readInt()));
                }
            } catch (Throwable th) {
                x.printErrStackTrace("MicroMsg.AED", th, "unexpected exception.", new Object[0]);
                b.a(this.oTi, th);
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
