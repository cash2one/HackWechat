package com.samsung.android.sdk.look;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.view.PointerIcon;
import android.view.View;

public class SlookPointerIcon {
    private static final String TAG = "SlookPointerIcon";
    private Drawable mDrawable;
    private Slook mSlook = new Slook();

    public void setHoverIcon(View view, Drawable drawable) {
        if (!isSupport(1)) {
            return;
        }
        if (view == null) {
            throw new IllegalArgumentException("view is null.");
        } else if (drawable == null) {
            view.setOnHoverListener(null);
            try {
                PointerIcon.setHoveringSpenIcon(1, -1);
            } catch (RemoteException e) {
            }
        } else {
            this.mDrawable = drawable;
            view.setOnHoverListener(new 1(this));
        }
    }

    private boolean isSupport(int i) {
        if (this.mSlook.isFeatureEnabled(4)) {
            return true;
        }
        return false;
    }
}
