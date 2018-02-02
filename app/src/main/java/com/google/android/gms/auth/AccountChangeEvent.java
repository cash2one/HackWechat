package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.internal.w;
import java.util.Arrays;

public class AccountChangeEvent implements SafeParcelable {
    public static final Creator<AccountChangeEvent> CREATOR = new e();
    final int aIt;
    final long aIu;
    final String aIv;
    final int aIw;
    final int aIx;
    final String aIy;

    AccountChangeEvent(int i, long j, String str, int i2, int i3, String str2) {
        this.aIt = i;
        this.aIu = j;
        this.aIv = (String) w.ag(str);
        this.aIw = i2;
        this.aIx = i3;
        this.aIy = str2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountChangeEvent)) {
            return false;
        }
        AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
        return this.aIt == accountChangeEvent.aIt && this.aIu == accountChangeEvent.aIu && v.b(this.aIv, accountChangeEvent.aIv) && this.aIw == accountChangeEvent.aIw && this.aIx == accountChangeEvent.aIx && v.b(this.aIy, accountChangeEvent.aIy);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.aIt), Long.valueOf(this.aIu), this.aIv, Integer.valueOf(this.aIw), Integer.valueOf(this.aIx), this.aIy});
    }

    public String toString() {
        String str = "UNKNOWN";
        switch (this.aIw) {
            case 1:
                str = "ADDED";
                break;
            case 2:
                str = "REMOVED";
                break;
            case 3:
                str = "RENAMED_FROM";
                break;
            case 4:
                str = "RENAMED_TO";
                break;
        }
        return "AccountChangeEvent {accountName = " + this.aIv + ", changeType = " + str + ", changeData = " + this.aIy + ", eventIndex = " + this.aIx + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        e.a(this, parcel);
    }
}
