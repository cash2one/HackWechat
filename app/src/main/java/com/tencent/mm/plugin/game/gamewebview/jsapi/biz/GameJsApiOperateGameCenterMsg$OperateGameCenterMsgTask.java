package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.g.a.gq;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;

class GameJsApiOperateGameCenterMsg$OperateGameCenterMsgTask extends GWMainProcessTask {
    public static Creator<GameJsApiOperateGameCenterMsg$OperateGameCenterMsgTask> CREATOR = new 1();
    public String fwF;
    public Runnable jcI;
    public int pK;
    public String result;

    public final void Yr() {
        b gqVar = new gq();
        gqVar.fwK.pK = this.pK;
        gqVar.fwK.fwF = this.fwF;
        a.xef.m(gqVar);
        this.result = gqVar.fwL.fwM;
        afp();
    }

    public final void Ys() {
        if (this.jcI != null) {
            this.jcI.run();
        }
    }

    public final void f(Parcel parcel) {
        this.pK = parcel.readInt();
        this.fwF = parcel.readString();
        this.result = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.pK);
        parcel.writeString(this.fwF);
        parcel.writeString(this.result);
    }

    private GameJsApiOperateGameCenterMsg$OperateGameCenterMsgTask(Parcel parcel) {
        f(parcel);
    }
}
