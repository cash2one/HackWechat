package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.m;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.c.c;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.w;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public final class u extends Fragment implements OnCancelListener {
    boolean aLO;
    private int aLP = -1;
    private ConnectionResult aLQ;
    private final Handler aLR = new Handler(Looper.getMainLooper());
    final SparseArray<a> aLS = new SparseArray();
    boolean oO;

    public static u a(FragmentActivity fragmentActivity) {
        w.aN("Must be called from main thread of process");
        try {
            u uVar = (u) fragmentActivity.getSupportFragmentManager().p("GmsSupportLifecycleFragment");
            return (uVar == null || uVar.isRemoving()) ? null : uVar;
        } catch (Throwable e) {
            throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFragment is not a SupportLifecycleFragment", e);
        }
    }

    private void a(int i, ConnectionResult connectionResult) {
        a aVar = (a) this.aLS.get(i);
        if (aVar != null) {
            a aVar2 = (a) this.aLS.get(i);
            this.aLS.remove(i);
            if (aVar2 != null) {
                aVar2.aLU.b(aVar2);
                aVar2.aLU.disconnect();
            }
            c cVar = aVar.aLV;
            if (cVar != null) {
                cVar.a(connectionResult);
            }
        }
        ov();
    }

    public static u b(FragmentActivity fragmentActivity) {
        u a = a(fragmentActivity);
        m supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        if (a != null) {
            return a;
        }
        Fragment uVar = new u();
        supportFragmentManager.aS().a(uVar, "GmsSupportLifecycleFragment").commitAllowingStateLoss();
        supportFragmentManager.executePendingTransactions();
        return uVar;
    }

    private void ov() {
        this.aLO = false;
        this.aLP = -1;
        this.aLQ = null;
        for (int i = 0; i < this.aLS.size(); i++) {
            ((a) this.aLS.valueAt(i)).aLU.connect();
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (int i = 0; i < this.aLS.size(); i++) {
            a aVar = (a) this.aLS.valueAt(i);
            printWriter.append(str).append("GoogleApiClient #").print(aVar.aLT);
            printWriter.println(":");
            aVar.aLU.a(str + "  ", printWriter);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityResult(int i, int i2, Intent intent) {
        Object obj = 1;
        switch (i) {
            case 1:
                if (i2 == -1) {
                    break;
                }
            case 2:
                if (e.C(getActivity()) == 0) {
                    break;
                }
            default:
                obj = null;
                break;
        }
        if (obj != null) {
            ov();
        } else {
            a(this.aLP, this.aLQ);
        }
    }

    public final void onCancel(DialogInterface dialogInterface) {
        a(this.aLP, new ConnectionResult(13, null));
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.aLO = bundle.getBoolean("resolving_error", false);
            this.aLP = bundle.getInt("failed_client_id", -1);
            if (this.aLP >= 0) {
                this.aLQ = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution"));
            }
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("resolving_error", this.aLO);
        if (this.aLP >= 0) {
            bundle.putInt("failed_client_id", this.aLP);
            bundle.putInt("failed_status", this.aLQ.aJD);
            bundle.putParcelable("failed_resolution", this.aLQ.aJE);
        }
    }

    public final void onStart() {
        super.onStart();
        this.oO = true;
        if (!this.aLO) {
            for (int i = 0; i < this.aLS.size(); i++) {
                ((a) this.aLS.valueAt(i)).aLU.connect();
            }
        }
    }

    public final void onStop() {
        super.onStop();
        this.oO = false;
        for (int i = 0; i < this.aLS.size(); i++) {
            ((a) this.aLS.valueAt(i)).aLU.disconnect();
        }
    }
}
