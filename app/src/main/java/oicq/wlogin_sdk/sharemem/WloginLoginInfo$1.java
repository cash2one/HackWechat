package oicq.wlogin_sdk.sharemem;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class WloginLoginInfo$1 implements Creator<WloginLoginInfo> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new WloginLoginInfo(parcel, null);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new WloginLoginInfo[i];
    }

    WloginLoginInfo$1() {
    }
}
