package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;

class GameJsApiGetOpenDeviceId$GetDeviceIdTask extends GWMainProcessTask {
    public static final Creator<GameJsApiGetOpenDeviceId$GetDeviceIdTask> CREATOR = new 1();
    public String ffq;
    public String mWM;

    public final void Yr() {
        this.ffq = q.yE();
        this.mWM = q.yF();
    }

    public final void f(Parcel parcel) {
        this.ffq = parcel.readString();
        this.mWM = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.ffq);
        parcel.writeString(this.mWM);
    }

    private GameJsApiGetOpenDeviceId$GetDeviceIdTask(Parcel parcel) {
        f(parcel);
    }
}
