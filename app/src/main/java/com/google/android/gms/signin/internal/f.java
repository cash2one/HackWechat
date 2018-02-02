package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.IInterface;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.t;

public interface f extends IInterface {
    void a(int i, Account account, e eVar);

    void a(AuthAccountRequest authAccountRequest, e eVar);

    void a(ResolveAccountRequest resolveAccountRequest, t tVar);

    void a(p pVar, int i, boolean z);

    void a(CheckServerAuthResult checkServerAuthResult);

    void a(RecordConsentRequest recordConsentRequest, e eVar);

    void a(e eVar);

    void au(boolean z);

    void dL(int i);
}
