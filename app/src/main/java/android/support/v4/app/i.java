package android.support.v4.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class i extends Fragment implements OnCancelListener, OnDismissListener {
    int pW = 0;
    int pX = 0;
    boolean pY = true;
    public boolean pZ = true;
    int qa = -1;
    Dialog qb;
    boolean qc;
    boolean qd;
    boolean qe;

    public void a(m mVar, String str) {
        this.qd = false;
        this.qe = true;
        q aS = mVar.aS();
        aS.a((Fragment) this, str);
        aS.commit();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!this.qe) {
            this.qd = false;
        }
    }

    public void onDetach() {
        super.onDetach();
        if (!this.qe && !this.qd) {
            this.qd = true;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pZ = this.mContainerId == 0;
        if (bundle != null) {
            this.pW = bundle.getInt("android:style", 0);
            this.pX = bundle.getInt("android:theme", 0);
            this.pY = bundle.getBoolean("android:cancelable", true);
            this.pZ = bundle.getBoolean("android:showsDialog", this.pZ);
            this.qa = bundle.getInt("android:backStackId", -1);
        }
    }

    public LayoutInflater getLayoutInflater(Bundle bundle) {
        if (!this.pZ) {
            return super.getLayoutInflater(bundle);
        }
        this.qb = aO();
        if (this.qb == null) {
            return (LayoutInflater) this.mHost.mContext.getSystemService("layout_inflater");
        }
        Dialog dialog = this.qb;
        switch (this.pW) {
            case 1:
            case 2:
                break;
            case 3:
                dialog.getWindow().addFlags(24);
                break;
        }
        dialog.requestWindowFeature(1);
        return (LayoutInflater) this.qb.getContext().getSystemService("layout_inflater");
    }

    public Dialog aO() {
        return new Dialog(getActivity(), this.pX);
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.qc && !this.qd) {
            this.qd = true;
            this.qe = false;
            if (this.qb != null) {
                this.qb.dismiss();
                this.qb = null;
            }
            this.qc = true;
            if (this.qa >= 0) {
                getFragmentManager().O(this.qa);
                this.qa = -1;
                return;
            }
            q aS = getFragmentManager().aS();
            aS.a(this);
            aS.commitAllowingStateLoss();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.pZ) {
            View view = getView();
            if (view != null) {
                if (view.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                this.qb.setContentView(view);
            }
            this.qb.setOwnerActivity(getActivity());
            this.qb.setCancelable(this.pY);
            this.qb.setOnCancelListener(this);
            this.qb.setOnDismissListener(this);
            if (bundle != null) {
                Bundle bundle2 = bundle.getBundle("android:savedDialogState");
                if (bundle2 != null) {
                    this.qb.onRestoreInstanceState(bundle2);
                }
            }
        }
    }

    public void onStart() {
        super.onStart();
        if (this.qb != null) {
            this.qc = false;
            this.qb.show();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.qb != null) {
            Bundle onSaveInstanceState = this.qb.onSaveInstanceState();
            if (onSaveInstanceState != null) {
                bundle.putBundle("android:savedDialogState", onSaveInstanceState);
            }
        }
        if (this.pW != 0) {
            bundle.putInt("android:style", this.pW);
        }
        if (this.pX != 0) {
            bundle.putInt("android:theme", this.pX);
        }
        if (!this.pY) {
            bundle.putBoolean("android:cancelable", this.pY);
        }
        if (!this.pZ) {
            bundle.putBoolean("android:showsDialog", this.pZ);
        }
        if (this.qa != -1) {
            bundle.putInt("android:backStackId", this.qa);
        }
    }

    public void onStop() {
        super.onStop();
        if (this.qb != null) {
            this.qb.hide();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.qb != null) {
            this.qc = true;
            this.qb.dismiss();
            this.qb = null;
        }
    }
}
