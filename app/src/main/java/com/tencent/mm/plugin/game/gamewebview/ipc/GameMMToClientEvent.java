package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.game.gamewebview.b.a.a;
import com.tencent.mm.plugin.game.gamewebview.b.a.c;
import com.tencent.mm.plugin.game.gamewebview.b.a.d;
import com.tencent.mm.plugin.game.gamewebview.b.a.e;
import com.tencent.mm.plugin.game.gamewebview.b.b;
import com.tencent.mm.plugin.game.gamewebview.ui.h;
import com.tencent.mm.plugin.game.gamewebview.ui.h.3;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public class GameMMToClientEvent extends GWMainProcessTask {
    public static Creator<GameMMToClientEvent> CREATOR = new Creator<GameMMToClientEvent>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new GameMMToClientEvent(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GameMMToClientEvent[i];
        }
    };
    private static GameMMToClientEvent mVS;
    private int jbs;
    private String jbt;
    public Object jbu;
    int mVR;
    public Bundle msB;

    private static GameMMToClientEvent aOE() {
        if (mVS == null) {
            synchronized (GameMMToClientEvent.class) {
                if (mVS == null) {
                    mVS = new GameMMToClientEvent();
                }
            }
        }
        return mVS;
    }

    public static void qC(int i) {
        aOE().jbs = 1;
        aOE().mVR = i;
        GameWebViewMainProcessService.a(aOE());
    }

    public static void qD(int i) {
        aOE().jbs = 2;
        aOE().mVR = i;
        GameWebViewMainProcessService.a(aOE());
    }

    public final void Yr() {
        switch (this.jbs) {
            case 1:
                a.a(this.mVR, this);
                return;
            case 2:
                a.qE(this.mVR);
                return;
            default:
                return;
        }
    }

    public final void Ys() {
        int i = this.msB.getInt("mm_to_client_notify_type");
        x.i("MicroMsg.GameMMToClientEvent", "notifyType = " + i);
        switch (i) {
            case 1:
                String string = this.msB.getString("js_event_name");
                if (!bh.ov(string)) {
                    if (b.mXG == null || b.mXG.size() == 0) {
                        b.mXG = new HashMap();
                        b.a(new c());
                        b.a(new com.tencent.mm.plugin.game.gamewebview.b.a.b());
                        b.a(new e());
                        b.a(new d());
                        b.a(new a());
                    }
                    com.tencent.mm.plugin.game.gamewebview.b.a aVar = (com.tencent.mm.plugin.game.gamewebview.b.a) b.mXG.get(string);
                    if (aVar != null) {
                        aVar.k(this.mVR, this.msB);
                        return;
                    }
                    return;
                }
                return;
            case 2:
                com.tencent.mm.plugin.game.gamewebview.ui.d qF = com.tencent.mm.plugin.game.gamewebview.model.a.qF(this.mVR);
                if (qF != null) {
                    String string2 = this.msB.getString("file_path");
                    String string3 = this.msB.getString("result");
                    int i2 = this.msB.getInt("code_type");
                    int i3 = this.msB.getInt("code_version");
                    if (qF.mZm != null) {
                        h hVar = qF.mZm;
                        x.d("MicroMsg.GameWebViewMenuListHelper", "result: " + string3);
                        if (hVar.juW != null && string2 != null && string2.equals(hVar.juW.tvd)) {
                            if (hVar.juW != null) {
                                hVar.juW.bRG();
                            }
                            hVar.juU = i2;
                            hVar.juV = i3;
                            if (string3 != null && hVar.juS != null) {
                                new af().post(new 3(hVar, string3));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void f(Parcel parcel) {
        this.jbs = parcel.readInt();
        this.mVR = parcel.readInt();
        this.msB = parcel.readBundle(getClass().getClassLoader());
        try {
            this.jbt = parcel.readString();
            if (!bh.ov(this.jbt)) {
                Class cls = Class.forName(this.jbt);
                if (cls != null) {
                    this.jbu = parcel.readParcelable(cls.getClassLoader());
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.GameMMToClientEvent", "can't parcel data ex: " + e.getMessage());
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.jbs);
        parcel.writeInt(this.mVR);
        parcel.writeBundle(this.msB);
        if (!bh.ov(this.jbt) && this.jbu != null) {
            parcel.writeString(this.jbt);
            parcel.writeParcelable((Parcelable) this.jbu, i);
        }
    }

    public int describeContents() {
        return 0;
    }

    private GameMMToClientEvent(Parcel parcel) {
        f(parcel);
    }
}
