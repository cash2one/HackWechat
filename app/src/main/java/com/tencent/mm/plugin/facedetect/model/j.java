package com.tencent.mm.plugin.facedetect.model;

import com.tencent.mm.g.a.hk;
import com.tencent.mm.g.a.hk.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends c<hk> {
    public j() {
        this.xen = hk.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z = false;
        hk hkVar = (hk) bVar;
        if (hkVar == null) {
            x.e("MicroMsg.FaceGetIsSupportListener", "hy: event is null");
            return false;
        }
        f fVar = f.mgf;
        boolean aGC = f.aGC();
        f fVar2 = f.mgf;
        boolean aGD = f.aGD();
        if (!aGC) {
            hkVar.fxI.fxK = 10001;
            hkVar.fxI.fxL = "No front camera";
        } else if (aGD) {
            hkVar.fxI.fxL = "ok";
        } else {
            hkVar.fxI.fxK = 10002;
            hkVar.fxI.fxL = "No necessary model found";
        }
        a aVar = hkVar.fxI;
        f fVar3 = f.mgf;
        aVar.fxM = f.aGG();
        aVar = hkVar.fxI;
        if (aGC && aGD) {
            z = true;
        }
        aVar.fxJ = z;
        return true;
    }
}
