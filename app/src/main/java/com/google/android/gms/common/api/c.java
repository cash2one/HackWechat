package com.google.android.gms.common.api;

import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.k.a;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public interface c {

    public interface b {
        void dh(int i);

        void e(Bundle bundle);
    }

    ConnectionResult a(TimeUnit timeUnit);

    <A extends com.google.android.gms.common.api.a.b, R extends g, T extends a<R, A>> T a(T t);

    void a(b bVar);

    void a(c cVar);

    void a(String str, PrintWriter printWriter);

    <A extends com.google.android.gms.common.api.a.b, T extends a<? extends g, A>> T b(T t);

    void b(b bVar);

    void b(c cVar);

    void connect();

    void disconnect();

    Looper getLooper();

    boolean isConnected();

    boolean isConnecting();
}
