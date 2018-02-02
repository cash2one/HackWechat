package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.c.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class ad {
    public static d a(e eVar) {
        d dVar = null;
        if (eVar == null) {
            x.e("MicroMsg.GamePBData", "Invalid pb object");
        } else if (bh.ov(eVar.nfn)) {
            x.e("MicroMsg.GamePBData", "No AppID field, abort");
        } else {
            x.i("MicroMsg.GamePBData", "Parsing AppID: %s", new Object[]{eVar.nfn});
            dVar = new d();
            dVar.field_appId = eVar.nfn;
            dVar.field_appName = eVar.nfp;
            dVar.field_appIconUrl = eVar.nfo;
            dVar.field_appType = ",1,";
            dVar.field_packageName = eVar.nfr;
            dVar.field_appVersion = eVar.ktM;
            dVar.field_appInfoFlag = eVar.nfu;
            if (eVar.nft != null) {
                dVar.cO(eVar.nft.ngf);
                dVar.cR(eVar.nft.ngg);
                dVar.ev(eVar.nft.ngj);
                dVar.cS(eVar.nft.ngh);
                dVar.nbj = eVar.nft.ngl;
                dVar.nbk = (long) eVar.nft.ngk;
                dVar.fwH = eVar.nft.ngm;
            }
            if (!(eVar.nft == null || eVar.nft.ngi == null)) {
                dVar.cX(eVar.nft.ngi.ngf);
                dVar.cY(eVar.nft.ngi.nkz);
                dVar.cV(eVar.nft.ngi.nkA);
                dVar.cW(eVar.nft.ngi.nkB);
                dVar.ew(eVar.nft.ngi.nkD);
            }
            dVar.naQ = eVar.nfe;
            dVar.naP = eVar.nfq;
            dVar.status = eVar.ktm;
            dVar.naS = eVar.nfj;
            dVar.versionCode = eVar.nfs;
            dVar.fop = eVar.nfl;
            dVar.naU = eVar.nfv;
            dVar.nbc = eVar.nfA;
            if (!(eVar.nft == null || eVar.nft.ngi == null)) {
                dVar.naV = eVar.nft.ngi.nkC;
                dVar.naW = eVar.nft.ngi.nkE;
                dVar.naX = eVar.nft.ngi.nkF;
            }
            dVar.hts = eVar.nfC;
            dVar.nbl = eVar.nfD;
        }
        return dVar;
    }
}
