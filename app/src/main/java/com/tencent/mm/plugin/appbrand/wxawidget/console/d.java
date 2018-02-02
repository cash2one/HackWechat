package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.os.Bundle;
import android.os.Parcelable;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.d.b;
import com.tencent.mm.ipcinvoker.d.e;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.plugin.appbrand.wxawidget.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class d {
    private static final Map<String, List<a>> gMS = new ConcurrentHashMap();
    private static List<a> khu = new LinkedList();
    private static final e khv = new e() {
        public final /* synthetic */ void as(Object obj) {
            Bundle bundle = (Bundle) obj;
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("logList");
            if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
                x.i("MicroMsg.ConsoleLogger", "logList is null or nil.");
            } else {
                d.b(bundle.getString(SlookAirButtonFrequentContactAdapter.ID), parcelableArrayList);
            }
        }
    };

    static /* synthetic */ void b(String str, ArrayList arrayList) {
        if (!bh.ov(str) && arrayList != null && !arrayList.isEmpty()) {
            for (a ag : new LinkedList(khu)) {
                ag.ag(arrayList);
            }
            List list = (List) gMS.get(str);
            if (list != null) {
                for (a ag2 : new LinkedList(list)) {
                    ag2.ag(arrayList);
                }
            }
        }
    }

    public static boolean a(a aVar) {
        if (khu.contains(aVar)) {
            return false;
        }
        if (gMS.isEmpty() && khu.isEmpty()) {
            com.tencent.mm.ipcinvoker.d.d dVar = c.kht;
            i iVar = khv;
            com.tencent.mm.ipcinvoker.d dVar2 = dVar.gMV;
            String str = dVar.fok;
            if (!(str == null || str.length() == 0 || iVar == null)) {
                Parcelable bundle = new Bundle();
                bundle.putString("Token", com.tencent.mm.ipcinvoker.d.ar(iVar));
                bundle.putString("Event", str);
                f.a(dVar2.process, bundle, com.tencent.mm.ipcinvoker.d.a.class, iVar);
            }
        }
        return khu.add(aVar);
    }

    public static boolean b(a aVar) {
        boolean remove = khu.remove(aVar);
        if (gMS.isEmpty() && khu.isEmpty()) {
            com.tencent.mm.ipcinvoker.d.d dVar = c.kht;
            e eVar = khv;
            com.tencent.mm.ipcinvoker.d dVar2 = dVar.gMV;
            String str = dVar.fok;
            if (!(str == null || str.length() == 0 || eVar == null)) {
                Parcelable bundle = new Bundle();
                bundle.putString("Token", com.tencent.mm.ipcinvoker.d.ar(eVar));
                bundle.putString("Event", str);
                f.a(dVar2.process, bundle, b.class, null);
            }
        }
        return remove;
    }
}
