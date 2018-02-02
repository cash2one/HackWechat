package com.tencent.recovery.model;

import android.os.Parcelable;

public abstract class RecoveryPersistentItem implements Parcelable {
    public abstract boolean aaM(String str);

    public abstract String cDl();

    public String toString() {
        return cDl();
    }
}
