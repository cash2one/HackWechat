package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.bh.a;
import com.tencent.mm.sdk.platformtools.x;

public class GameKeepPageTopTask extends GWMainProcessTask {
    public static final Creator<GameKeepPageTopTask> CREATOR = new 1();
    public boolean mVQ;
    public String title;
    public int type;
    public String url;
    public String username;

    public final void Yr() {
        x.i("MicroMsg.GameKeepPageTopTask", "type = " + this.type);
        a aVar;
        switch (this.type) {
            case 1:
                aVar = a.hZm;
                this.mVQ = a.Vb();
                aVar = a.hZm;
                this.url = a.Vc();
                return;
            case 2:
                aVar = a.hZm;
                a.q(this.url, this.title, this.username);
                return;
            default:
                return;
        }
    }

    public final void f(Parcel parcel) {
        boolean z = true;
        this.type = parcel.readInt();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.mVQ = z;
        this.url = parcel.readString();
        this.title = parcel.readString();
        this.username = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeByte((byte) (this.mVQ ? 1 : 0));
        parcel.writeString(this.url);
        parcel.writeString(this.title);
        parcel.writeString(this.username);
    }

    public int describeContents() {
        return 0;
    }

    private GameKeepPageTopTask(Parcel parcel) {
        f(parcel);
    }
}
