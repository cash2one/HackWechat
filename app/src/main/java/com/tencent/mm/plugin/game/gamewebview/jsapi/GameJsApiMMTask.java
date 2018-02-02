package com.tencent.mm.plugin.game.gamewebview.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Map;

public class GameJsApiMMTask extends GWMainProcessTask {
    public static final Creator<GameJsApiMMTask> CREATOR = new 2();
    public int jcN;
    public String jfl;
    public d mWb;
    public String mWe;
    public String mWf;

    public final void Yr() {
        Map aOM = e.aOM();
        if (aOM != null) {
            c cVar = (c) aOM.get(this.mWe);
            if (!(cVar instanceof f)) {
                ((a) cVar).a(ac.getContext(), this.jfl, new 1(this));
            }
        }
    }

    public final void Ys() {
        afj();
        if (this.mWb != null) {
            this.mWb.E(this.jcN, this.mWf);
        }
    }

    public final void f(Parcel parcel) {
        this.jfl = parcel.readString();
        this.mWe = parcel.readString();
        this.mWf = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.jfl);
        parcel.writeString(this.mWe);
        parcel.writeString(this.mWf);
    }

    private GameJsApiMMTask(Parcel parcel) {
        f(parcel);
    }
}
