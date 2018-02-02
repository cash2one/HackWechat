package com.tencent.mm.plugin.game.gamewebview.jsapi;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public class GameJsApiActivityTask extends GameProcessActivityTask {
    public static final Creator<GameJsApiActivityTask> CREATOR = new Creator<GameJsApiActivityTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new GameJsApiActivityTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GameJsApiActivityTask[i];
        }
    };
    public int jcN;
    public String jfl;
    public d mWb;
    public String mWe;
    public String mWf;

    public final void a(Context context, final a aVar) {
        x.i("MicroMsg.GameJsApiActivityTask", "runInMainProcess, apiName = %s", new Object[]{this.mWe});
        Map aOM = e.aOM();
        if (aOM != null) {
            c cVar = (c) aOM.get(this.mWe);
            if (!(cVar instanceof f)) {
                ((a) cVar).a(context, this.jfl, new GameJsApiMMTask.a(this) {
                    final /* synthetic */ GameJsApiActivityTask mWg;

                    public final void sj(String str) {
                        this.mWg.mWf = str;
                        aVar.afh();
                    }
                });
            }
        }
    }

    public final void Ys() {
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

    public GameJsApiActivityTask(Context context) {
        super(context);
    }

    private GameJsApiActivityTask(Parcel parcel) {
        f(parcel);
    }
}
