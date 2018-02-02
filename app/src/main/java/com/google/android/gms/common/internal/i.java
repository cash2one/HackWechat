package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;

public final class i implements OnClickListener {
    private final Intent Ks;
    private final Fragment aNU;
    private final int aNV;
    private final Activity mActivity;

    public i(Activity activity, Intent intent, int i) {
        this.mActivity = activity;
        this.aNU = null;
        this.Ks = intent;
        this.aNV = 2;
    }

    public i(Fragment fragment, Intent intent, int i) {
        this.mActivity = null;
        this.aNU = fragment;
        this.Ks = intent;
        this.aNV = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            if (this.Ks != null && this.aNU != null) {
                this.aNU.startActivityForResult(this.Ks, this.aNV);
            } else if (this.Ks != null) {
                this.mActivity.startActivityForResult(this.Ks, this.aNV);
            }
            dialogInterface.dismiss();
        } catch (ActivityNotFoundException e) {
        }
    }
}
