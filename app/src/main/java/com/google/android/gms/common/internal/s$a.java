package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import org.xwalk.core.R$styleable;

public abstract class s$a extends Binder implements s {

    private static class a implements s {
        private IBinder aFi;

        a(IBinder iBinder) {
            this.aFi = iBinder;
        }

        public final void a(r rVar, int i) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                this.aFi.transact(4, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void a(r rVar, int i, String str) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                this.aFi.transact(3, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void a(r rVar, int i, String str, Bundle bundle) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                if (bundle != null) {
                    obtain.writeInt(1);
                    bundle.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
                this.aFi.transact(2, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void a(r rVar, int i, String str, IBinder iBinder, Bundle bundle) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                obtain.writeStrongBinder(iBinder);
                if (bundle != null) {
                    obtain.writeInt(1);
                    bundle.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
                this.aFi.transact(19, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void a(r rVar, int i, String str, String str2) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                obtain.writeString(str2);
                this.aFi.transact(34, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void a(r rVar, int i, String str, String str2, String str3, String[] strArr) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                obtain.writeString(str2);
                obtain.writeString(str3);
                obtain.writeStringArray(strArr);
                this.aFi.transact(33, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void a(r rVar, int i, String str, String str2, String[] strArr) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                obtain.writeString(str2);
                obtain.writeStringArray(strArr);
                this.aFi.transact(10, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void a(r rVar, int i, String str, String str2, String[] strArr, Bundle bundle) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                obtain.writeString(str2);
                obtain.writeStringArray(strArr);
                if (bundle != null) {
                    obtain.writeInt(1);
                    bundle.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
                this.aFi.transact(30, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void a(r rVar, int i, String str, String str2, String[] strArr, String str3, Bundle bundle) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                obtain.writeString(str2);
                obtain.writeStringArray(strArr);
                obtain.writeString(str3);
                if (bundle != null) {
                    obtain.writeInt(1);
                    bundle.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
                this.aFi.transact(1, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void a(r rVar, int i, String str, String str2, String[] strArr, String str3, IBinder iBinder, String str4, Bundle bundle) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                obtain.writeString(str2);
                obtain.writeStringArray(strArr);
                obtain.writeString(str3);
                obtain.writeStrongBinder(iBinder);
                obtain.writeString(str4);
                if (bundle != null) {
                    obtain.writeInt(1);
                    bundle.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
                this.aFi.transact(9, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void a(r rVar, int i, String str, String[] strArr, String str2, Bundle bundle) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                obtain.writeStringArray(strArr);
                obtain.writeString(str2);
                if (bundle != null) {
                    obtain.writeInt(1);
                    bundle.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
                this.aFi.transact(20, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void a(r rVar, GetServiceRequest getServiceRequest) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                if (getServiceRequest != null) {
                    obtain.writeInt(1);
                    getServiceRequest.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
                this.aFi.transact(46, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void a(r rVar, ValidateAccountRequest validateAccountRequest) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                if (validateAccountRequest != null) {
                    obtain.writeInt(1);
                    validateAccountRequest.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
                this.aFi.transact(47, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final IBinder asBinder() {
            return this.aFi;
        }

        public final void b(r rVar, int i, String str) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                this.aFi.transact(21, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void b(r rVar, int i, String str, Bundle bundle) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                if (bundle != null) {
                    obtain.writeInt(1);
                    bundle.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
                this.aFi.transact(5, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void c(r rVar, int i, String str) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                this.aFi.transact(22, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void c(r rVar, int i, String str, Bundle bundle) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                if (bundle != null) {
                    obtain.writeInt(1);
                    bundle.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
                this.aFi.transact(6, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void d(r rVar, int i, String str) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                this.aFi.transact(24, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void d(r rVar, int i, String str, Bundle bundle) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                if (bundle != null) {
                    obtain.writeInt(1);
                    bundle.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
                this.aFi.transact(7, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void e(r rVar, int i, String str) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                this.aFi.transact(26, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void e(r rVar, int i, String str, Bundle bundle) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                if (bundle != null) {
                    obtain.writeInt(1);
                    bundle.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
                this.aFi.transact(8, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void f(r rVar, int i, String str) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                this.aFi.transact(31, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void f(r rVar, int i, String str, Bundle bundle) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                if (bundle != null) {
                    obtain.writeInt(1);
                    bundle.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
                this.aFi.transact(11, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void g(r rVar, int i, String str) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                this.aFi.transact(32, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void g(r rVar, int i, String str, Bundle bundle) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                if (bundle != null) {
                    obtain.writeInt(1);
                    bundle.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
                this.aFi.transact(12, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void h(r rVar, int i, String str) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                this.aFi.transact(35, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void h(r rVar, int i, String str, Bundle bundle) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                if (bundle != null) {
                    obtain.writeInt(1);
                    bundle.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
                this.aFi.transact(13, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void i(r rVar, int i, String str) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                this.aFi.transact(36, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void i(r rVar, int i, String str, Bundle bundle) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                if (bundle != null) {
                    obtain.writeInt(1);
                    bundle.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
                this.aFi.transact(14, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void j(r rVar, int i, String str) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                this.aFi.transact(40, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void j(r rVar, int i, String str, Bundle bundle) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                if (bundle != null) {
                    obtain.writeInt(1);
                    bundle.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
                this.aFi.transact(15, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void k(r rVar, int i, String str) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                this.aFi.transact(42, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void k(r rVar, int i, String str, Bundle bundle) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                if (bundle != null) {
                    obtain.writeInt(1);
                    bundle.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
                this.aFi.transact(16, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void l(r rVar, int i, String str) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                this.aFi.transact(44, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void l(r rVar, int i, String str, Bundle bundle) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                if (bundle != null) {
                    obtain.writeInt(1);
                    bundle.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
                this.aFi.transact(17, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void m(r rVar, int i, String str) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                this.aFi.transact(45, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void m(r rVar, int i, String str, Bundle bundle) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                if (bundle != null) {
                    obtain.writeInt(1);
                    bundle.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
                this.aFi.transact(18, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void n(r rVar, int i, String str, Bundle bundle) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                if (bundle != null) {
                    obtain.writeInt(1);
                    bundle.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
                this.aFi.transact(23, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void o(r rVar, int i, String str, Bundle bundle) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                if (bundle != null) {
                    obtain.writeInt(1);
                    bundle.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
                this.aFi.transact(25, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void oS() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                this.aFi.transact(28, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void p(r rVar, int i, String str, Bundle bundle) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                if (bundle != null) {
                    obtain.writeInt(1);
                    bundle.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
                this.aFi.transact(27, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void q(r rVar, int i, String str, Bundle bundle) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                if (bundle != null) {
                    obtain.writeInt(1);
                    bundle.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
                this.aFi.transact(37, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void r(r rVar, int i, String str, Bundle bundle) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                if (bundle != null) {
                    obtain.writeInt(1);
                    bundle.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
                this.aFi.transact(38, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void s(r rVar, int i, String str, Bundle bundle) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                if (bundle != null) {
                    obtain.writeInt(1);
                    bundle.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
                this.aFi.transact(41, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void t(r rVar, int i, String str, Bundle bundle) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                obtain.writeInt(i);
                obtain.writeString(str);
                if (bundle != null) {
                    obtain.writeInt(1);
                    bundle.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
                this.aFi.transact(43, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public static s i(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof s)) ? new a(iBinder) : (s) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        ValidateAccountRequest validateAccountRequest = null;
        r h;
        int readInt;
        String readString;
        Bundle bundle;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a(com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.createStringArray(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                h = com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                a(h, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a(com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a(com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                h = com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                b(h, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case 6:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                h = com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                c(h, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case 7:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                h = com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                d(h, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case 8:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                h = com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                e(h, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case 9:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a(com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.createStringArray(), parcel.readString(), parcel.readStrongBinder(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 10:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a(com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.createStringArray());
                parcel2.writeNoException();
                return true;
            case 11:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                h = com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                f(h, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case 12:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                h = com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                g(h, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case 13:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                h = com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                h(h, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case 14:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                h = com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                i(h, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case 15:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                h = com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                j(h, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case 16:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                h = com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                k(h, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case 17:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                h = com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                l(h, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case 18:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                h = com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                m(h, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case 19:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a(com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readStrongBinder(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 20:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a(com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.createStringArray(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 21:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                b(com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 22:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                c(com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 23:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                h = com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                n(h, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case 24:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                d(com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 25:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                h = com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                o(h, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case 26:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                e(com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 27:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                h = com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                p(h, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case 28:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                oS();
                parcel2.writeNoException();
                return true;
            case 30:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a(com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.createStringArray(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 31:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                f(com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 32:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                g(com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 33:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a(com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArray());
                parcel2.writeNoException();
                return true;
            case 34:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a(com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 35:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                h(com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 36:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                i(com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 37:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                h = com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                q(h, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case 38:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                h = com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                r(h, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case 40:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                j(com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 41:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                h = com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                s(h, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case R$styleable.AppCompatTheme_dialogTheme /*42*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                k(com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case R$styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                h = com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                t(h, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case R$styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                l(com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case R$styleable.AppCompatTheme_actionDropDownStyle /*45*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                m(com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 46:
                GetServiceRequest getServiceRequest;
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                h = com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    getServiceRequest = (GetServiceRequest) GetServiceRequest.CREATOR.createFromParcel(parcel);
                }
                a(h, getServiceRequest);
                parcel2.writeNoException();
                return true;
            case 47:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                h = com.google.android.gms.common.internal.r.a.h(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    validateAccountRequest = (ValidateAccountRequest) ValidateAccountRequest.CREATOR.createFromParcel(parcel);
                }
                a(h, validateAccountRequest);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.common.internal.IGmsServiceBroker");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
