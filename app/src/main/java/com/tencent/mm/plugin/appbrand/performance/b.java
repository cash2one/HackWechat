package com.tencent.mm.plugin.appbrand.performance;

import android.util.SparseArray;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact;
import com.tencent.mm.plugin.appbrand.jsapi.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.ap;
import com.tencent.mm.plugin.appbrand.jsapi.au;
import com.tencent.mm.plugin.appbrand.q.j;

public final class b {
    public static final int[] jFZ = new int[4];
    public static final SparseArray<Integer> jGa = new SparseArray();

    static {
        jFZ[0] = j.iAm;
        jFZ[1] = j.iAz;
        jFZ[2] = j.iAF;
        jFZ[3] = j.iAD;
        jGa.put(101, Integer.valueOf(j.iAn));
        jGa.put(102, Integer.valueOf(j.iAB));
        jGa.put(103, Integer.valueOf(j.iAC));
        jGa.put(201, Integer.valueOf(j.iAq));
        jGa.put(202, Integer.valueOf(j.iAA));
        jGa.put(203, Integer.valueOf(j.iAH));
        jGa.put(301, Integer.valueOf(j.iAx));
        jGa.put(HardCoderJNI.SCENE_QUIT_CHATTING, Integer.valueOf(j.iAE));
        jGa.put(303, Integer.valueOf(j.iAy));
        jGa.put(401, Integer.valueOf(j.iAG));
        jGa.put(e.CTRL_INDEX, Integer.valueOf(j.iAJ));
        jGa.put(ap.CTRL_INDEX, Integer.valueOf(j.iAK));
        jGa.put(TencentLocation.ERROR_UNKNOWN, Integer.valueOf(j.iAL));
        jGa.put(405, Integer.valueOf(j.iAM));
        jGa.put(au.CTRL_INDEX, Integer.valueOf(j.iAN));
        jGa.put(JsApiPrivateAddContact.CTRL_INDEX, Integer.valueOf(j.iAO));
    }
}
