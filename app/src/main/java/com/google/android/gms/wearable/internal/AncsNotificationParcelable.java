package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AncsNotificationParcelable implements SafeParcelable {
    public static final Creator<AncsNotificationParcelable> CREATOR = new av();
    final String aYv;
    String baH;
    final String bea;
    final String beb;
    final String bec;
    final String bed;
    byte bee;
    byte bef;
    byte beg;
    byte beh;
    int mId;
    final int mVersionCode;

    AncsNotificationParcelable(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, byte b, byte b2, byte b3, byte b4) {
        this.mId = i2;
        this.mVersionCode = i;
        this.aYv = str;
        this.bea = str2;
        this.beb = str3;
        this.bec = str4;
        this.bed = str5;
        this.baH = str6;
        this.bee = b;
        this.bef = b2;
        this.beg = b3;
        this.beh = b4;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AncsNotificationParcelable ancsNotificationParcelable = (AncsNotificationParcelable) obj;
        return this.beh != ancsNotificationParcelable.beh ? false : this.beg != ancsNotificationParcelable.beg ? false : this.bef != ancsNotificationParcelable.bef ? false : this.bee != ancsNotificationParcelable.bee ? false : this.mId != ancsNotificationParcelable.mId ? false : this.mVersionCode != ancsNotificationParcelable.mVersionCode ? false : !this.aYv.equals(ancsNotificationParcelable.aYv) ? false : (this.bea == null ? ancsNotificationParcelable.bea != null : !this.bea.equals(ancsNotificationParcelable.bea)) ? false : !this.baH.equals(ancsNotificationParcelable.baH) ? false : !this.beb.equals(ancsNotificationParcelable.beb) ? false : !this.bed.equals(ancsNotificationParcelable.bed) ? false : this.bec.equals(ancsNotificationParcelable.bec);
    }

    public int hashCode() {
        return (((((((((((((((((this.bea != null ? this.bea.hashCode() : 0) + (((((this.mVersionCode * 31) + this.mId) * 31) + this.aYv.hashCode()) * 31)) * 31) + this.beb.hashCode()) * 31) + this.bec.hashCode()) * 31) + this.bed.hashCode()) * 31) + this.baH.hashCode()) * 31) + this.bee) * 31) + this.bef) * 31) + this.beg) * 31) + this.beh;
    }

    public String toString() {
        return "AncsNotificationParcelable{mVersionCode=" + this.mVersionCode + ", mId=" + this.mId + ", mAppId='" + this.aYv + '\'' + ", mDateTime='" + this.bea + '\'' + ", mNotificationText='" + this.beb + '\'' + ", mTitle='" + this.bec + '\'' + ", mSubtitle='" + this.bed + '\'' + ", mDisplayName='" + this.baH + '\'' + ", mEventId=" + this.bee + ", mEventFlags=" + this.bef + ", mCategoryId=" + this.beg + ", mCategoryCount=" + this.beh + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        av.a(this, parcel);
    }
}
