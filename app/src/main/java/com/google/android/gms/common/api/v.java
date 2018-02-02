package com.google.android.gms.common.api;

import android.app.Activity;
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
import android.support.v4.app.t;
import android.support.v4.app.t.a;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.c.c;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.w;

public final class v extends Fragment implements OnCancelListener, a<ConnectionResult> {
    private boolean aLO;
    private int aLP = -1;
    private ConnectionResult aLQ;
    private final Handler aLR = new Handler(Looper.getMainLooper());
    public final SparseArray<b> aLS = new SparseArray();

    private void a(int i, ConnectionResult connectionResult) {
        b bVar = (b) this.aLS.get(i);
        if (bVar != null) {
            this.aLS.remove(i);
            getLoaderManager().destroyLoader(i);
            c cVar = bVar.aLV;
            if (cVar != null) {
                cVar.a(connectionResult);
            }
        }
        ov();
    }

    public static v c(FragmentActivity fragmentActivity) {
        w.aN("Must be called from main thread of process");
        m supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        try {
            v vVar = (v) supportFragmentManager.p("GmsSupportLoaderLifecycleFragment");
            if (vVar != null && !vVar.isRemoving()) {
                return vVar;
            }
            Fragment vVar2 = new v();
            supportFragmentManager.aS().a(vVar2, "GmsSupportLoaderLifecycleFragment").commit();
            supportFragmentManager.executePendingTransactions();
            return vVar2;
        } catch (Throwable e) {
            throw new IllegalStateException("Fragment with tag GmsSupportLoaderLifecycleFragment is not a SupportLoaderLifecycleFragment", e);
        }
    }

    private void ov() {
        int i = 0;
        this.aLO = false;
        this.aLP = -1;
        this.aLQ = null;
        t loaderManager = getLoaderManager();
        while (i < this.aLS.size()) {
            int keyAt = this.aLS.keyAt(i);
            a dk = dk(keyAt);
            if (dk != null && dk.aLZ) {
                loaderManager.destroyLoader(keyAt);
                loaderManager.a(keyAt, this);
            }
            i++;
        }
    }

    public final android.support.v4.content.c<ConnectionResult> T(int i) {
        return new a(getActivity(), ((b) this.aLS.get(i)).aLU);
    }

    public final /* synthetic */ void a(android.support.v4.content.c cVar, Object obj) {
        ConnectionResult connectionResult = (ConnectionResult) obj;
        if (!connectionResult.isSuccess()) {
            int i = cVar.mId;
            if (!this.aLO) {
                this.aLO = true;
                this.aLP = i;
                this.aLQ = connectionResult;
                this.aLR.post(new c(this, i, connectionResult));
            }
        }
    }

    public final a dk(int i) {
        try {
            return (a) getLoaderManager().S(i);
        } catch (Throwable e) {
            throw new IllegalStateException("Unknown loader in SupportLoaderLifecycleFragment", e);
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

    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        int i = 0;
        while (i < this.aLS.size()) {
            int keyAt = this.aLS.keyAt(i);
            a dk = dk(keyAt);
            if (dk == null || ((b) this.aLS.valueAt(i)).aLU == dk.aLU) {
                getLoaderManager().a(keyAt, this);
            } else {
                getLoaderManager().b(keyAt, this);
            }
            i++;
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
        if (!this.aLO) {
            for (int i = 0; i < this.aLS.size(); i++) {
                getLoaderManager().a(this.aLS.keyAt(i), this);
            }
        }
    }
}
