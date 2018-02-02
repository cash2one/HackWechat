package com.tencent.mm.plugin.subapp;

import android.annotation.SuppressLint;
import com.tencent.mm.an.d;
import com.tencent.mm.by.h;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.plugin.subapp.d.c;
import com.tencent.mm.pluginsdk.q.k;
import com.tencent.mm.pluginsdk.q.z;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bl;
import com.tencent.mm.z.ak.f;
import com.tencent.mm.z.ap;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class a implements ap {
    static bl rUV;
    private Map<String, ap> rUW = new HashMap();
    private a rUX;
    private com.tencent.mm.plugin.subapp.d.a rUY;
    private c rUZ;

    public a() {
        x.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp constructor: " + System.currentTimeMillis());
        x.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getSubCoreMap: " + System.currentTimeMillis());
        Map hashMap = new HashMap();
        hashMap.put(d.class.getName(), new d());
        hashMap.put(com.tencent.mm.plugin.subapp.b.c.class.getName(), new com.tencent.mm.plugin.subapp.b.c());
        hashMap.put(com.tencent.mm.plugin.subapp.a.c.class.getName(), new com.tencent.mm.plugin.subapp.a.c());
        f dVar = new com.tencent.mm.plugin.subapp.c.d();
        com.tencent.mm.z.ak.a.hfO = dVar;
        hashMap.put(com.tencent.mm.plugin.subapp.c.d.class.getName(), dVar);
        k cVar = new com.tencent.mm.plugin.subapp.jdbiz.c();
        hashMap.put(com.tencent.mm.plugin.subapp.jdbiz.c.class.getName(), cVar);
        z.vcD = cVar;
        hashMap.put(p.class.getName(), new p());
        this.rUW = hashMap;
    }

    @SuppressLint({"UseSparseArrays"})
    public final HashMap<Integer, h.d> Bn() {
        x.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getBaseDBFactories: " + System.currentTimeMillis());
        HashMap<Integer, h.d> hashMap = new HashMap();
        for (Entry entry : this.rUW.entrySet()) {
            if (((ap) entry.getValue()).Bn() != null) {
                hashMap.putAll(((ap) entry.getValue()).Bn());
            }
        }
        return hashMap;
    }

    public final void gd(int i) {
        x.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp clearPluginData: " + System.currentTimeMillis());
        for (Entry value : this.rUW.entrySet()) {
            ((ap) value.getValue()).gd(i);
        }
    }

    public final void bq(boolean z) {
        x.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onAccountPostReset: " + System.currentTimeMillis());
        for (Entry value : this.rUW.entrySet()) {
            ((ap) value.getValue()).bq(z);
        }
        if (this.rUX == null) {
            this.rUX = new a();
        }
        if (this.rUY == null) {
            this.rUY = new com.tencent.mm.plugin.subapp.d.a();
        }
        if (this.rUZ == null) {
            this.rUZ = new c();
        }
        com.tencent.mm.sdk.b.a.xef.b(this.rUX);
        com.tencent.mm.sdk.b.a.xef.b(this.rUZ);
        com.tencent.mm.sdk.b.a.xef.b(this.rUY);
    }

    public final void br(boolean z) {
        x.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onSdcardMount: " + System.currentTimeMillis());
        for (Entry value : this.rUW.entrySet()) {
            ((ap) value.getValue()).br(z);
        }
    }

    public final void onAccountRelease() {
        x.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onAccountRelease: " + System.currentTimeMillis());
        for (Entry value : this.rUW.entrySet()) {
            ((ap) value.getValue()).onAccountRelease();
        }
        if (this.rUX != null) {
            com.tencent.mm.sdk.b.a.xef.c(this.rUX);
        }
        if (this.rUY != null) {
            com.tencent.mm.sdk.b.a.xef.c(this.rUY);
        }
        if (this.rUZ != null) {
            com.tencent.mm.sdk.b.a.xef.c(this.rUZ);
        }
    }

    public final ap Mi(String str) {
        return (ap) this.rUW.get(str);
    }

    public final void b(String str, ap apVar) {
        this.rUW.put(str, apVar);
    }
}
