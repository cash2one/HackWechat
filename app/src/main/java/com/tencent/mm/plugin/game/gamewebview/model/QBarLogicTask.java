package com.tencent.mm.plugin.game.gamewebview.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public class QBarLogicTask extends GWMainProcessTask {
    public static final Creator<QBarLogicTask> CREATOR = new Creator<QBarLogicTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new QBarLogicTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new QBarLogicTask[i];
        }
    };
    private static c gLY = new 1();
    private static Map<String, Integer> mXU;
    public String fzs;
    public int type;

    public final void Yr() {
        String str;
        b mpVar;
        switch (this.type) {
            case 1:
                str = this.fzs;
                if (mXU == null) {
                    mXU = new HashMap();
                    a.xef.b(gLY);
                }
                mpVar = new mp();
                mpVar.fEA.filePath = str;
                a.xef.m(mpVar);
                mXU.put(str, Integer.valueOf(1));
                return;
            case 2:
                str = this.fzs;
                if (mXU == null || !mXU.containsKey(str)) {
                    x.e("MicroMsg.QBarLogicTask", "%s is not recognizing", str);
                    return;
                }
                mpVar = new ak();
                mpVar.fow.filePath = str;
                a.xef.m(mpVar);
                mXU.remove(str);
                return;
            default:
                return;
        }
    }

    public final void Ys() {
    }

    public final void f(Parcel parcel) {
        this.type = parcel.readInt();
        this.fzs = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeString(this.fzs);
    }

    private QBarLogicTask(Parcel parcel) {
        f(parcel);
    }
}
