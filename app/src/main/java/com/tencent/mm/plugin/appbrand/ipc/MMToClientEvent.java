package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MMToClientEvent extends MainProcessTask {
    public static final Creator<MMToClientEvent> CREATOR = new 2();
    private static volatile MMToClientEvent jbv;
    private static final Set<a> jbw = new HashSet();
    public String appId;
    int fnm;
    String fun;
    public int jbs;
    String jbt;
    Object jbu;
    public int type;

    public interface a {
        void aY(Object obj);
    }

    private MMToClientEvent() {
    }

    private MMToClientEvent(Parcel parcel) {
        f(parcel);
    }

    private static MMToClientEvent afo() {
        if (jbv == null) {
            synchronized (MMToClientEvent.class) {
                if (jbv == null) {
                    jbv = new MMToClientEvent();
                }
            }
        }
        return jbv;
    }

    public final void Yr() {
        switch (this.jbs) {
            case 1:
                d.a(this);
                return;
            case 2:
                d.b(this);
                return;
            default:
                return;
        }
    }

    public static void sa(String str) {
        afo().jbs = 1;
        afo().appId = str;
        AppBrandMainProcessService.a(afo());
    }

    public static void sb(String str) {
        afo().jbs = 2;
        afo().appId = str;
        AppBrandMainProcessService.a(afo());
    }

    public static void a(a aVar) {
        synchronized (jbw) {
            jbw.add(aVar);
        }
    }

    public static void b(a aVar) {
        if (aVar != null) {
            synchronized (jbw) {
                jbw.remove(aVar);
            }
        }
    }

    private void bb(Object obj) {
        if (obj != null) {
            List linkedList = new LinkedList();
            synchronized (jbw) {
                for (a add : jbw) {
                    linkedList.add(add);
                }
            }
            c.Dm().F(new 1(this, linkedList, obj));
        }
    }

    public final void Ys() {
        Map hashMap;
        switch (this.jbs) {
            case 3:
                com.tencent.mm.plugin.appbrand.jsapi.w.a aVar = new com.tencent.mm.plugin.appbrand.jsapi.w.a();
                hashMap = new HashMap();
                hashMap.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(this.type));
                hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, this.fun);
                aVar.az(this.appId, 0).v(hashMap).afs();
                return;
            case 4:
                com.tencent.mm.plugin.appbrand.jsapi.contact.d.a aVar2 = new com.tencent.mm.plugin.appbrand.jsapi.contact.d.a();
                hashMap = new HashMap();
                hashMap.put("count", Integer.valueOf(this.fnm));
                hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, this.fun);
                aVar2.az(this.appId, 0).v(hashMap).afs();
                return;
            case 5:
                bb(this.jbu);
                return;
            default:
                return;
        }
    }

    public final void f(Parcel parcel) {
        this.jbs = parcel.readInt();
        this.appId = parcel.readString();
        this.type = parcel.readInt();
        this.fun = parcel.readString();
        this.fnm = parcel.readInt();
        try {
            this.jbt = parcel.readString();
            if (!bh.ov(this.jbt)) {
                Class cls = Class.forName(this.jbt);
                if (cls != null) {
                    this.jbu = parcel.readParcelable(cls.getClassLoader());
                }
            }
        } catch (Exception e) {
            x.v("MicroMsg.MMToClientEvent", "unparcel custom data e %s", new Object[]{e});
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.jbs);
        parcel.writeString(this.appId);
        parcel.writeInt(this.type);
        parcel.writeString(this.fun);
        parcel.writeInt(this.fnm);
        if (!bh.ov(this.jbt) && this.jbu != null) {
            parcel.writeString(this.jbt);
            parcel.writeParcelable((Parcelable) this.jbu, i);
        }
    }
}
