package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c {
    private static List<a> gMW = new LinkedList();
    private static Map<String, a> gMX = new HashMap();

    public static a fm(String str) {
        return (a) gMX.get(str);
    }

    public static a av(Object obj) {
        for (a aVar : gMW) {
            if (aVar.au(obj)) {
                return aVar;
            }
        }
        return null;
    }

    public static void a(Object obj, Parcel parcel) {
        a av = av(obj);
        if (av != null) {
            av.a(obj, parcel);
        }
    }

    public static Object a(String str, Parcel parcel) {
        a fm = fm(str);
        if (fm != null) {
            return fm.d(parcel);
        }
        return null;
    }

    public static void a(a aVar) {
        if (aVar != null && !gMW.contains(aVar)) {
            gMX.put(aVar.getClass().getName(), aVar);
            gMW.add(aVar);
        }
    }
}
