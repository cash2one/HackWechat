package com.tencent.c.e.a.a;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.SparseArray;
import com.tencent.c.e.a.b.a;
import com.tencent.c.e.a.b.e;
import com.tencent.c.e.a.b.g;
import com.tencent.c.f.d;
import com.tencent.c.f.i;
import java.util.ArrayList;
import java.util.List;

public final class b {
    private static final int[] zTT = new int[]{1, 5, 4, 8, 9, 2};
    private static int zTU = -1;

    public static a a(int i, int i2, Context context, int i3, SparseArray<i> sparseArray, List<k> list) {
        a aVar = new a();
        aVar.zUp = 0;
        aVar.zUq = "";
        aVar.hLh = i.bF(context, context.getPackageName()).versionCode;
        aVar.zSh = "14D6ACDE3C2F2F48";
        aVar.fCR = 500000;
        aVar.requestType = i3;
        aVar.zUs = aaP(context.getPackageName());
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < sparseArray.size(); i4++) {
            arrayList.addAll(((i) sparseArray.valueAt(i4)).dG(list));
        }
        if (arrayList.size() <= 0 || arrayList.get(0) == null) {
            throw new IllegalArgumentException("invalid stateUnits");
        }
        e eVar = new e();
        eVar.zUA = ((g) arrayList.get(0)).zUF;
        eVar.zUB = arrayList;
        eVar.zTC = i;
        eVar.action = i2;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(eVar);
        aVar.zUr = arrayList2;
        aVar.imei = aaP(d.gs(context));
        aVar.imsi = aaP(d.gt(context));
        aVar.hqd = aaP(Build.BRAND);
        aVar.model = aaP(Build.MODEL);
        aVar.zUt = aaP(Build.FINGERPRINT);
        aVar.zUu = gq(context);
        aVar.sdkVer = VERSION.SDK_INT;
        aVar.zPM = 2;
        return aVar;
    }

    private static String aaP(String str) {
        return str == null ? "" : str;
    }

    private static int gq(Context context) {
        if (zTU == -1) {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager == null) {
                return zTU;
            }
            int i = 1;
            for (int i2 = 0; i2 < zTT.length; i2++) {
                int i3;
                if (sensorManager.getDefaultSensor(zTT[i2]) == null) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                i |= i3 << i2;
            }
            zTU = i;
        }
        return zTU;
    }
}
