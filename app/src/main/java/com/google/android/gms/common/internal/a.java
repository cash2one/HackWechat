package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import com.google.android.gms.common.e;

public final class a extends com.google.android.gms.common.internal.p.a {
    private Account aIz;
    int aNp;
    private Context mContext;

    public static Account b(p pVar) {
        Account account = null;
        if (pVar != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = pVar.oE();
            } catch (RemoteException e) {
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return account;
    }

    public final boolean equals(Object obj) {
        return this == obj ? true : !(obj instanceof a) ? false : this.aIz.equals(((a) obj).aIz);
    }

    public final Account oE() {
        int callingUid = Binder.getCallingUid();
        if (callingUid == this.aNp) {
            return this.aIz;
        }
        if (e.m(this.mContext, callingUid)) {
            this.aNp = callingUid;
            return this.aIz;
        }
        throw new SecurityException("Caller is not GooglePlayServices");
    }
}
