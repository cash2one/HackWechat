package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.g;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.m.b;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.x;

public class JsApiChattingTask extends MainProcessTask {
    public static final Creator<JsApiChattingTask> CREATOR = new Creator<JsApiChattingTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new JsApiChattingTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiChattingTask[i];
        }
    };
    public String fpL;
    public Runnable jcI;
    public String sessionFrom;
    public String username;

    public JsApiChattingTask(Parcel parcel) {
        f(parcel);
    }

    public final void Yr() {
        a WO = ((h) g.h(h.class)).EY().WO(this.username);
        x.d("MicroMsg.JsApiChattingTask", "sessionFrom:%s,username:%s,nickname:%s", new Object[]{this.sessionFrom, this.username, this.fpL});
        if (WO == null || ((int) WO.gJd) == 0) {
            com.tencent.mm.storage.x xVar = new com.tencent.mm.storage.x(this.username);
            xVar.setType(0);
            xVar.dc(this.fpL);
            ((h) g.h(h.class)).EY().R(xVar);
            x.i("MicroMsg.JsApiChattingTask", "%s save to contact_table", new Object[]{this.username});
        }
        ((b) g.h(b.class)).qL(this.username);
        afp();
    }

    public final void Ys() {
        if (this.jcI != null) {
            this.jcI.run();
        }
    }

    public final void f(Parcel parcel) {
        this.sessionFrom = parcel.readString();
        this.username = parcel.readString();
        this.fpL = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.sessionFrom);
        parcel.writeString(this.username);
        parcel.writeString(this.fpL);
    }
}
