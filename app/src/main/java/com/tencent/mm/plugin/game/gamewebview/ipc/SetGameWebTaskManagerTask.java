package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.game.gamewebview.model.b;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.ArrayList;
import java.util.Iterator;

public class SetGameWebTaskManagerTask extends GWMainProcessTask {
    public static final Creator<SetGameWebTaskManagerTask> CREATOR = new 1();
    public String className;
    public int type;
    public ArrayList<String> urlList;

    public final void Yr() {
        Iterator it;
        switch (this.type) {
            case 1:
                if (!bh.cA(this.urlList)) {
                    it = this.urlList.iterator();
                    while (it.hasNext()) {
                        b.BH((String) it.next());
                    }
                    return;
                }
                return;
            case 2:
                if (!bh.cA(this.urlList)) {
                    it = this.urlList.iterator();
                    while (it.hasNext()) {
                        b.cG((String) it.next(), this.className);
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void f(Parcel parcel) {
        this.type = parcel.readInt();
        this.className = parcel.readString();
        this.urlList = parcel.readArrayList(SetGameWebTaskManagerTask.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeString(this.className);
        parcel.writeList(this.urlList);
    }

    public int describeContents() {
        return 0;
    }

    private SetGameWebTaskManagerTask(Parcel parcel) {
        f(parcel);
    }
}
