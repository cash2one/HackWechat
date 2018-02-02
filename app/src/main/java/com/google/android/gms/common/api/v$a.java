package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.c;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.c.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class v$a extends c<ConnectionResult> implements b, c.c {
    public final c aLU;
    boolean aLZ;
    private ConnectionResult aMa;

    public v$a(Context context, c cVar) {
        super(context);
        this.aLU = cVar;
    }

    private void g(ConnectionResult connectionResult) {
        this.aMa = connectionResult;
        if (this.oO && !this.tE) {
            deliverResult(connectionResult);
        }
    }

    public final void a(ConnectionResult connectionResult) {
        this.aLZ = true;
        g(connectionResult);
    }

    public final void dh(int i) {
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        this.aLU.a(str, printWriter);
    }

    public final void e(Bundle bundle) {
        this.aLZ = false;
        g(ConnectionResult.aJC);
    }

    protected final void onReset() {
        this.aMa = null;
        this.aLZ = false;
        this.aLU.b(this);
        this.aLU.b(this);
        this.aLU.disconnect();
    }

    protected final void onStartLoading() {
        super.onStartLoading();
        this.aLU.a(this);
        this.aLU.a(this);
        if (this.aMa != null) {
            deliverResult(this.aMa);
        }
        if (!this.aLU.isConnected() && !this.aLU.isConnecting() && !this.aLZ) {
            this.aLU.connect();
        }
    }

    protected final void onStopLoading() {
        this.aLU.disconnect();
    }
}
