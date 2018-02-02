package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ResultReceiver implements Parcelable {
    public static final Creator<ResultReceiver> CREATOR = new 1();
    public final Handler mHandler = null;
    public final boolean vD = false;
    public a vE;

    class a extends android.support.v4.os.a.a {
        final /* synthetic */ ResultReceiver vF;

        a(ResultReceiver resultReceiver) {
            this.vF = resultReceiver;
        }

        public final void send(int i, Bundle bundle) {
            if (this.vF.mHandler != null) {
                this.vF.mHandler.post(new b(this.vF, i, bundle));
            } else {
                this.vF.onReceiveResult(i, bundle);
            }
        }
    }

    public void onReceiveResult(int i, Bundle bundle) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.vE == null) {
                this.vE = new a(this);
            }
            parcel.writeStrongBinder(this.vE.asBinder());
        }
    }

    ResultReceiver(Parcel parcel) {
        this.vE = android.support.v4.os.a.a.b(parcel.readStrongBinder());
    }
}
