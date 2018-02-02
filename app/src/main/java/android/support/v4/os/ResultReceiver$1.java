package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class ResultReceiver$1 implements Creator<ResultReceiver> {
    ResultReceiver$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ResultReceiver(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ResultReceiver[i];
    }
}
