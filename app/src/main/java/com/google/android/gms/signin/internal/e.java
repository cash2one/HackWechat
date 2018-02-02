package com.google.android.gms.signin.internal;

import android.os.IInterface;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.signin.GoogleSignInAccount;

public interface e extends IInterface {
    void a(ConnectionResult connectionResult, AuthAccountResult authAccountResult);

    void a(Status status, GoogleSignInAccount googleSignInAccount);

    void d(Status status);

    void e(Status status);
}
