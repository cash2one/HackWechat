package com.tencent.mm.plugin.game.model;

import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.game.c.av;
import com.tencent.mm.plugin.game.c.aw;
import com.tencent.mm.plugin.game.c.ay;
import com.tencent.mm.plugin.game.c.bt;
import com.tencent.mm.plugin.game.c.cr;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class am extends ad {
    private boolean ndE;
    public LinkedList<d> ndF;
    public HashMap<String, Integer> ndG;
    public bt ndY;

    public am(a aVar) {
        this.ndG = new HashMap();
        if (aVar == null) {
            this.ndY = new bt();
            return;
        }
        this.ndY = (bt) aVar;
        this.ndE = true;
        WT();
    }

    public am(byte[] bArr) {
        this.ndG = new HashMap();
        this.ndY = new bt();
        if (bArr != null && bArr.length != 0) {
            try {
                this.ndY.aF(bArr);
            } catch (IOException e) {
                x.e("MicroMsg.GamePBDataOverSea", "Parsing Failed: %s", new Object[]{e.getMessage()});
            }
            this.ndE = false;
            WT();
        }
    }

    private void WT() {
        LinkedList linkedList;
        LinkedList linkedList2 = new LinkedList();
        if (this.ndY.nii == null || this.ndY.nii.nfN == null) {
            linkedList = linkedList2;
        } else {
            Iterator it = this.ndY.nii.nfN.iterator();
            int i = 1;
            while (it.hasNext()) {
                av avVar = (av) it.next();
                if (avVar.nfh != null) {
                    d a = ad.a(avVar.nfh);
                    if (a != null) {
                        if (avVar.nfh.nfB == null) {
                            a.nbh = ap.BY(avVar.nfK);
                        } else if (avVar.nfh.nfB.nfp == null || avVar.nfh.nfB.njt == null) {
                            a.nbh = ap.BY(avVar.nfK);
                        } else {
                            a.nbd = avVar.nfh.nfB.nfp;
                            a.nbe = avVar.nfh.nfB.njt;
                            a.nbh = ap.L(avVar.nfK, "label", a.nbd);
                        }
                        if (avVar.nhr != null) {
                            Iterator it2 = avVar.nhr.iterator();
                            while (it2.hasNext()) {
                                aw awVar = (aw) it2.next();
                                if (awVar != null) {
                                    if (awVar.nhs == null || awVar.nhs.size() == 0) {
                                        a.naY.add("");
                                    } else {
                                        StringBuilder stringBuilder = new StringBuilder();
                                        for (int i2 = 0; i2 < awVar.nhs.size(); i2++) {
                                            ar.Hg();
                                            com.tencent.mm.storage.x WO = c.EY().WO((String) awVar.nhs.get(i2));
                                            if (WO == null || WO.gJd == 0) {
                                                stringBuilder.append((String) awVar.nhs.get(i2));
                                            } else {
                                                stringBuilder.append(WO.AQ());
                                            }
                                            if (i2 < awVar.nhs.size() - 1) {
                                                stringBuilder.append("、");
                                            }
                                        }
                                        stringBuilder.append(" ");
                                        a.naY.add(stringBuilder.toString());
                                    }
                                    a.naY.add(awVar.ngs);
                                }
                            }
                        }
                        a.scene = 10;
                        a.fFj = 1004;
                        int i3 = i + 1;
                        a.position = i;
                        linkedList2.add(a);
                        i = i3;
                    }
                }
            }
            linkedList = linkedList2;
        }
        this.ndF = linkedList;
        if (this.ndE) {
            d.U(this.ndF);
            aQP();
            SubCoreGameCenter.aRj().init(ac.getContext());
        }
    }

    private void aQP() {
        this.ndG = new HashMap();
        if (this.ndY.nim != null && this.ndY.nim.njp != null) {
            Iterator it = this.ndY.nim.njp.iterator();
            while (it.hasNext()) {
                cr crVar = (cr) it.next();
                d a = ad.a(crVar.nfh);
                if (a != null) {
                    this.ndG.put(a.field_appId, Integer.valueOf(a.versionCode));
                    f RF = an.bin().RF(a.field_appId);
                    if (RF != null) {
                        RF.cQ(crVar.njr);
                        if (!an.bin().a(RF, new String[0])) {
                            x.e("MicroMsg.GamePBDataOverSea", "Store rank info failed, AppID: %s", new Object[]{RF.field_appId});
                        }
                    }
                }
            }
        }
    }

    public final ay aQL() {
        return this.ndY != null ? this.ndY.nih : null;
    }
}
