package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.e.j;
import android.view.LayoutInflater;
import android.view.View;
import java.io.PrintWriter;

public abstract class l<E> extends j {
    final Activity mActivity;
    boolean mCheckedForLoaderManager;
    final Context mContext;
    final n mFragmentManager;
    final Handler mHandler;
    u mLoaderManager;
    boolean mLoadersStarted;
    final int ql;
    j<String, t> qm;
    boolean qn;

    public abstract E onGetHost();

    l(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.mHandler);
    }

    private l(Activity activity, Context context, Handler handler) {
        this.mFragmentManager = new n();
        this.mActivity = activity;
        this.mContext = context;
        this.mHandler = handler;
        this.ql = 0;
    }

    public void a(String str, PrintWriter printWriter, String[] strArr) {
    }

    public boolean aP() {
        return true;
    }

    public LayoutInflater onGetLayoutInflater() {
        return (LayoutInflater) this.mContext.getSystemService("layout_inflater");
    }

    public void aQ() {
    }

    public void a(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.mContext.startActivity(intent);
    }

    public void a(Fragment fragment, String[] strArr, int i) {
    }

    public boolean n(String str) {
        return false;
    }

    public boolean onHasWindowAnimations() {
        return true;
    }

    public int onGetWindowAnimations() {
        return this.ql;
    }

    public View onFindViewById(int i) {
        return null;
    }

    public boolean onHasView() {
        return true;
    }

    final void o(String str) {
        if (this.qm != null) {
            u uVar = (u) this.qm.get(str);
            if (uVar != null && !uVar.mRetaining) {
                uVar.bf();
                this.qm.remove(str);
            }
        }
    }

    void onAttachFragment(Fragment fragment) {
    }

    final u a(String str, boolean z, boolean z2) {
        if (this.qm == null) {
            this.qm = new j();
        }
        u uVar = (u) this.qm.get(str);
        if (uVar != null) {
            uVar.mHost = this;
            return uVar;
        } else if (!z2) {
            return uVar;
        } else {
            uVar = new u(str, this, z);
            this.qm.put(str, uVar);
            return uVar;
        }
    }

    final j<String, t> aR() {
        int i;
        int i2 = 0;
        if (this.qm != null) {
            int size = this.qm.size();
            u[] uVarArr = new u[size];
            for (int i3 = size - 1; i3 >= 0; i3--) {
                uVarArr[i3] = (u) this.qm.valueAt(i3);
            }
            i = 0;
            while (i2 < size) {
                u uVar = uVarArr[i2];
                if (uVar.mRetaining) {
                    i = 1;
                } else {
                    uVar.bf();
                    this.qm.remove(uVar.mWho);
                }
                i2++;
            }
        } else {
            i = 0;
        }
        if (i != 0) {
            return this.qm;
        }
        return null;
    }
}
