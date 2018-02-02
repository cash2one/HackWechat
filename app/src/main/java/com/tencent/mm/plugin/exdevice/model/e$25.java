package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.df;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.g.7;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class e$25 extends c<df> {
    final /* synthetic */ e lLO;

    e$25(e eVar) {
        this.lLO = eVar;
        this.xen = df.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        df dfVar = (df) bVar;
        e eVar = this.lLO;
        dfVar = dfVar;
        eVar.lLK = new g();
        g gVar = eVar.lLK;
        x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "startScanWCLanDevice...");
        Java2CExDevice.startScanWCLanDevice(new byte[0], 1000);
        gVar.lLT = false;
        new ak(new 7(gVar), false).J(3000, 3000);
        g gVar2 = eVar.lLK;
        long j = dfVar.frF.fqm;
        String str = dfVar.frF.frH;
        String str2 = dfVar.frF.frI;
        int i = dfVar.frF.frJ;
        List arrayList = new ArrayList();
        gVar2.gAc = j;
        gVar2.lLW = str;
        gVar2.lLX = str2;
        gVar2.lLY = i;
        int size = gVar2.lMi.size();
        for (int i2 = 0; i2 < size; i2++) {
            HashMap hashMap = new HashMap();
            hashMap.put("deviceType", ((com.tencent.mm.plugin.exdevice.h.b) gVar2.lMi.get(i2)).field_deviceType);
            hashMap.put("deviceID", ((com.tencent.mm.plugin.exdevice.h.b) gVar2.lMi.get(i2)).field_deviceID);
            hashMap.put("displayName", g.c((com.tencent.mm.plugin.exdevice.h.b) gVar2.lMi.get(i2)));
            hashMap.put("iconUrl", ((com.tencent.mm.plugin.exdevice.h.b) gVar2.lMi.get(i2)).iconUrl);
            hashMap.put("ability", ((com.tencent.mm.plugin.exdevice.h.b) gVar2.lMi.get(i2)).gfT);
            hashMap.put("abilityInf", ((com.tencent.mm.plugin.exdevice.h.b) gVar2.lMi.get(i2)).gfU);
            arrayList.add(hashMap);
        }
        if (arrayList.size() > 0) {
            dfVar.frG.frK = arrayList;
            dfVar.frG.frp = true;
        } else {
            dfVar.frG.frp = false;
        }
        return true;
    }
}
