package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import org.json.JSONObject;

public abstract class f extends b {
    private e irP;
    private int jca;
    public String mData;

    public final f a(c cVar) {
        if (cVar != null) {
            this.irP = cVar.YQ();
            this.jca = cVar.hashCode();
        }
        return this;
    }

    public final f az(String str, int i) {
        this.irP = a.oQ(str);
        this.jca = i;
        return this;
    }

    public final f v(Map<String, Object> map) {
        c.m(map);
        this.mData = new JSONObject(map).toString();
        return this;
    }

    public final boolean b(c cVar) {
        if (com.tencent.mm.plugin.appbrand.permission.c.r(this.irP).a(cVar, this, null).code == 1) {
            return true;
        }
        return false;
    }

    public final boolean afs() {
        b bVar;
        int i;
        boolean z;
        int i2;
        boolean z2;
        boolean b;
        boolean z3;
        b bVar2 = null;
        if (this.irP != null) {
            bVar2 = this.irP.iqO;
            if (bVar2 != null) {
                bVar = bVar2;
                i = 1;
                if (com.tencent.mm.sdk.a.b.ceK() || com.tencent.mm.sdk.a.b.ceI()) {
                    z = false;
                } else {
                    i2 = 1;
                }
                if (i != 0 && r4 == 0) {
                    return false;
                }
                if (bVar.iGV.iHf.get()) {
                    z2 = bVar.iGV.aas() != com.tencent.mm.plugin.appbrand.b.a.iGS;
                    b = b(this.irP.iqB);
                    if (!z2 || b) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (com.tencent.mm.compatible.loader.a.a(m.jcl, getClass())) {
                        i2 = 1;
                    } else {
                        z = false;
                    }
                    if (i2 != 0) {
                        x.i("MicroMsg.AppBrandJsApiEvent", "dispatchToService, canSend %B, event %s, index %d, suspend %b, hasPermission %b", new Object[]{Boolean.valueOf(z3), getName(), Integer.valueOf(afq()), Boolean.valueOf(z2), Boolean.valueOf(b)});
                    }
                    if (z3 || this.irP == null || this.irP.iqB == null) {
                        return false;
                    }
                    this.irP.iqB.h(getName(), this.mData, this.jca);
                    return true;
                }
                x.i("MicroMsg.AppBrandJsApiEvent", "dispatchToService(%s), runtime stopped, just return", new Object[]{getName()});
                return false;
            }
        }
        bVar = bVar2;
        z2 = false;
        if (com.tencent.mm.sdk.a.b.ceK()) {
        }
        z = false;
        if (i != 0) {
        }
        if (bVar.iGV.iHf.get()) {
            if (bVar.iGV.aas() != com.tencent.mm.plugin.appbrand.b.a.iGS) {
            }
            b = b(this.irP.iqB);
            if (z2) {
            }
            z3 = true;
            if (com.tencent.mm.compatible.loader.a.a(m.jcl, getClass())) {
                z = false;
            } else {
                i2 = 1;
            }
            if (i2 != 0) {
                x.i("MicroMsg.AppBrandJsApiEvent", "dispatchToService, canSend %B, event %s, index %d, suspend %b, hasPermission %b", new Object[]{Boolean.valueOf(z3), getName(), Integer.valueOf(afq()), Boolean.valueOf(z2), Boolean.valueOf(b)});
            }
            return z3 ? false : false;
        } else {
            x.i("MicroMsg.AppBrandJsApiEvent", "dispatchToService(%s), runtime stopped, just return", new Object[]{getName()});
            return false;
        }
    }

    public final boolean f(int[] iArr) {
        try {
            if (!b(this.irP.iqC.aiT().aex())) {
                x.d("MicroMsg.AppBrandJsApiEvent", "event name = %s, ctrlIndex = %d, perm denied", new Object[]{getName(), Integer.valueOf(afq())});
                return false;
            } else if (this.irP == null || this.irP.iqC == null) {
                return false;
            } else {
                this.irP.iqC.c(getName(), this.mData, iArr);
                return true;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrandJsApiEvent", e, "", new Object[0]);
            return false;
        }
    }
}
