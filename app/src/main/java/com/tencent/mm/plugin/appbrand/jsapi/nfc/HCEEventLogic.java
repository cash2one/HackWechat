package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.g.a.ia;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.d;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.platformtools.x;

public class HCEEventLogic {
    private static String joF = null;
    private static b joG = null;
    private static b joH = new 1();

    public static final class HCEMMToAppBrandMessageEvent implements Parcelable {
        public static final Creator<HCEMMToAppBrandMessageEvent> CREATOR = new 1();
        private String appId;
        private int joJ;
        private Bundle joK;

        private HCEMMToAppBrandMessageEvent(int i, String str, Bundle bundle) {
            this.joJ = i;
            this.appId = str;
            this.joK = bundle;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.joJ);
            parcel.writeString(this.appId);
            parcel.writeBundle(this.joK);
        }

        HCEMMToAppBrandMessageEvent(Parcel parcel) {
            this.joJ = parcel.readInt();
            this.appId = parcel.readString();
            this.joK = parcel.readBundle();
        }
    }

    private static class SendHCEEventToMMTask extends MainProcessTask {
        public static final Creator<SendHCEEventToMMTask> CREATOR = new Creator<SendHCEEventToMMTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SendHCEEventToMMTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SendHCEEventToMMTask[i];
            }
        };
        private String appId;
        private int joJ;
        private Bundle joK;

        private SendHCEEventToMMTask(String str, int i, Bundle bundle) {
            this.joJ = i;
            this.appId = str;
            this.joK = bundle;
        }

        protected SendHCEEventToMMTask(Parcel parcel) {
            f(parcel);
        }

        public final void Yr() {
            com.tencent.mm.sdk.b.b iaVar = new ia();
            iaVar.fyy.type = this.joJ;
            iaVar.fyy.appId = this.appId;
            iaVar.fyy.extras = this.joK;
            com.tencent.mm.sdk.b.a.xef.m(iaVar);
            afp();
        }

        public final void Ys() {
            super.Ys();
            c.bk(this);
        }

        public int describeContents() {
            return 0;
        }

        public final void f(Parcel parcel) {
            super.f(parcel);
            this.joJ = parcel.readInt();
            this.appId = parcel.readString();
            this.joK = parcel.readBundle();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.joJ);
            parcel.writeString(this.appId);
            parcel.writeBundle(this.joK);
        }
    }

    public static final class a {
        private static boolean joI = false;

        public static synchronized void agD() {
            synchronized (a.class) {
                if (!joI) {
                    MMToClientEvent.a(new 1());
                    joI = true;
                }
            }
        }
    }

    static /* synthetic */ void k(String str, int i, String str2) {
        synchronized (HCEEventLogic.class) {
            b bVar = joG;
        }
        if (bVar != null) {
            bVar.l(str, i, str2);
        }
    }

    public static void sE(String str) {
        if (!(joF == null || joH == null)) {
            x.i("MicroMsg.HCEEventLogic", "alvinluo remove HCELifeCycleListener before add, appId: %s", new Object[]{joF});
            com.tencent.mm.plugin.appbrand.c.b(joF, joH);
        }
        joF = str;
        com.tencent.mm.plugin.appbrand.c.a(str, joH);
    }

    public static void sF(String str) {
        if (str != null) {
            com.tencent.mm.plugin.appbrand.c.b(str, joH);
        }
    }

    public static void a(b bVar) {
        synchronized (HCEEventLogic.class) {
            joG = bVar;
        }
    }

    public static void b(String str, int i, Bundle bundle) {
        x.i("MicroMsg.HCEEventLogic", "alvinluo HCE EVENT mm to AppBrand, type: %d, appId: %s", new Object[]{Integer.valueOf(i), str});
        d.a(new HCEMMToAppBrandMessageEvent(i, str, bundle));
    }

    public static void c(String str, int i, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        x.i("MicroMsg.HCEEventLogic", "alvinluo HCEEventLogic sendHCEEventToMM appId: %s, eventType: %d", new Object[]{str, Integer.valueOf(i)});
        MainProcessTask sendHCEEventToMMTask = new SendHCEEventToMMTask(str, i, bundle);
        c.bj(sendHCEEventToMMTask);
        AppBrandMainProcessService.a(sendHCEEventToMMTask);
    }
}
