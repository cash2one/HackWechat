package com.tencent.mm.plugin.g.a.a;

import com.tencent.mm.sdk.platformtools.x;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Vector;
import junit.framework.Assert;

public final class d {
    private final HashMap<c, Vector<Integer>> gRZ = new HashMap();
    private b kvW = null;

    public d(b bVar) {
        this.kvW = bVar;
    }

    public final void a(int i, String str, e eVar) {
        Vector vector;
        x.i("MicroMsg.exdevie.IBeaconManager", "advertismentProcess, brand = %s, rssi = %d", new Object[]{null, Integer.valueOf(i)});
        if (eVar == null) {
            x.e("MicroMsg.exdevie.IBeaconManager", "null == aProtocal");
            return;
        }
        c cVar = new c();
        cVar.kvT = null;
        cVar.kvU = eVar;
        cVar.bpq = str;
        if (this.gRZ.containsKey(cVar)) {
            vector = (Vector) this.gRZ.get(cVar);
            vector.add(Integer.valueOf(i));
            if (1 <= vector.size()) {
                try {
                    a(vector, cVar);
                    return;
                } catch (Exception e) {
                    x.e("MicroMsg.exdevie.IBeaconManager", "calDistance failed!!!, %s", new Object[]{e.getMessage()});
                    return;
                } finally {
                    vector.clear();
                }
            } else {
                return;
            }
        }
        vector = new Vector();
        vector.add(Integer.valueOf(i));
        this.gRZ.put(cVar, vector);
    }

    private void a(Vector<Integer> vector, c cVar) {
        int i;
        int[] iArr;
        x.i("MicroMsg.exdevie.IBeaconManager", "calDistance");
        int[] iArr2 = new int[vector.size()];
        for (i = 0; i < iArr2.length; i++) {
            iArr2[i] = ((Integer) vector.elementAt(i)).intValue();
        }
        a aVar = new a(iArr2);
        if (1 == aVar.kvS.length) {
            x.d("MicroMsg.exdevice.GaussianFilter", "data group length = 1, no need to filter, just return");
            iArr = aVar.kvS;
        } else {
            StringBuilder stringBuilder = new StringBuilder("");
            stringBuilder.append("Data Before GaussianFilter \r\n");
            for (int i2 : aVar.kvS) {
                stringBuilder.append(" " + i2);
            }
            x.d("MicroMsg.exdevice.GaussianFilter", stringBuilder.toString());
            double d = i.d(aVar.kvS, 5);
            double g = i.g(aVar.kvS);
            double doubleValue = i.g(0.15d, g).add(new BigDecimal(d)).doubleValue();
            double doubleValue2 = i.g(3.09d, g).add(new BigDecimal(d)).doubleValue();
            x.d("MicroMsg.exdevice.GaussianFilter", "Mean = " + d + "SD = " + g + "LowerLimit = " + doubleValue + " UpperLimit = " + doubleValue2);
            i = 0;
            int[] iArr3 = new int[aVar.kvS.length];
            int i3 = 0;
            while (i3 < aVar.kvS.length) {
                if (((double) aVar.kvS[i3]) >= doubleValue && ((double) aVar.kvS[i3]) <= doubleValue2) {
                    int i4 = i + 1;
                    iArr3[i] = aVar.kvS[i3];
                    i = i4;
                }
                i3++;
            }
            Assert.assertTrue(i != 0);
            iArr2 = new int[i];
            for (i3 = 0; i3 < i; i3++) {
                iArr2[i3] = iArr3[i3];
            }
            stringBuilder = new StringBuilder("");
            stringBuilder.append("Data After GaussianFilter \r\n");
            for (int i22 : iArr2) {
                stringBuilder.append(" " + i22);
            }
            x.d("MicroMsg.exdevice.GaussianFilter", stringBuilder.toString());
            iArr = iArr2;
        }
        if (iArr == null || iArr.length == 0) {
            throw new NullPointerException("null == ret || 0 == ret.length");
        }
        double d2 = i.d(iArr, 5);
        cVar.kvV = new BigDecimal(d2).divide(new BigDecimal(1), 3, 4).doubleValue();
        d = (1.0d * d2) / ((double) cVar.kvU.kvY.kwC);
        if (d < 1.0d) {
            d = Math.pow(d, 10.0d);
        } else {
            d = (Math.pow(d, 9.9476d) * 0.92093d) + 0.54992d;
        }
        x.i("MicroMsg.exdevie.IBeaconManager", "txPower = %f , rssi = %f,distance = %f", new Object[]{Double.valueOf(g), Double.valueOf(d2), Double.valueOf(d)});
        this.kvW.a(d, cVar);
    }
}
