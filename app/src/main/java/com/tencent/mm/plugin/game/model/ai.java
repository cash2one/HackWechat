package com.tencent.mm.plugin.game.model;

import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.game.c.av;
import com.tencent.mm.plugin.game.c.aw;
import com.tencent.mm.plugin.game.c.ay;
import com.tencent.mm.plugin.game.c.bj;
import com.tencent.mm.plugin.game.c.cp;
import com.tencent.mm.plugin.game.c.cr;
import com.tencent.mm.plugin.game.c.dd;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class ai extends ad {
    public bj ndD;
    private boolean ndE;
    public LinkedList<d> ndF;
    public HashMap<String, Integer> ndG;
    public a ndH;

    public ai(a aVar) {
        this.ndG = new HashMap();
        if (aVar == null) {
            this.ndD = new bj();
            return;
        }
        this.ndD = (bj) aVar;
        this.ndE = true;
        WT();
    }

    public ai(byte[] bArr) {
        this.ndG = new HashMap();
        this.ndD = new bj();
        if (bArr != null && bArr.length != 0) {
            try {
                this.ndD.aF(bArr);
            } catch (IOException e) {
                x.e("MicroMsg.GamePBDataIndex", "Parsing Failed: %s", new Object[]{e.getMessage()});
            }
            this.ndE = false;
            WT();
        }
    }

    private void WT() {
        LinkedList linkedList;
        LinkedList linkedList2 = new LinkedList();
        if (this.ndD.nii == null || this.ndD.nii.nfN == null) {
            linkedList = linkedList2;
        } else {
            Iterator it = this.ndD.nii.nfN.iterator();
            int i = 1;
            while (it.hasNext()) {
                av avVar = (av) it.next();
                if (avVar.nfh != null) {
                    d a = a(avVar.nfh);
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
        this.ndH = aQN();
        if (this.ndE) {
            d.U(this.ndF);
            if (!(this.ndH == null || bh.cA(this.ndH.ndI))) {
                LinkedList linkedList3 = new LinkedList();
                Iterator it3 = this.ndH.ndI.iterator();
                while (it3.hasNext()) {
                    linkedList3.add(((a) it3.next()).ndK);
                }
                d.U(linkedList3);
            }
            aQP();
            SubCoreGameCenter.aRj().init(ac.getContext());
        }
    }

    public final ay aQL() {
        return this.ndD != null ? this.ndD.nih : null;
    }

    public final cp aQM() {
        return this.ndD != null ? this.ndD.nin : null;
    }

    private a aQN() {
        if (this.ndD.nil == null || bh.cA(this.ndD.nil.nfN)) {
            return null;
        }
        a aVar = new a();
        Iterator it = this.ndD.nil.nfN.iterator();
        int i = 0;
        while (it.hasNext()) {
            dd ddVar = (dd) it.next();
            d a = a(ddVar.nfh);
            if (a != null) {
                a.nbf = ddVar.nfe;
                a.scene = 10;
                a.fFj = 1002;
                i++;
                a.position = i;
                a aVar2 = new a();
                aVar2.ndK = a;
                aVar2.ndL = ddVar.njF;
                aVar.ndI.add(aVar2);
            }
        }
        aVar.ndJ = this.ndD.nil.ngV;
        return aVar;
    }

    public final LinkedList<d> aQO() {
        LinkedList<d> linkedList = new LinkedList();
        if (this.ndD.nim == null || this.ndD.nim.njp == null) {
            return linkedList;
        }
        Iterator it = this.ndD.nim.njp.iterator();
        while (it.hasNext()) {
            cr crVar = (cr) it.next();
            if (crVar != null) {
                d a = a(crVar.nfh);
                if (a != null) {
                    a.cQ(crVar.njr);
                    linkedList.addFirst(a);
                }
            }
        }
        return linkedList;
    }

    private void aQP() {
        this.ndG = new HashMap();
        if (this.ndD.nim != null && this.ndD.nim.njp != null) {
            Iterator it = this.ndD.nim.njp.iterator();
            while (it.hasNext()) {
                cr crVar = (cr) it.next();
                d a = a(crVar.nfh);
                if (a != null) {
                    this.ndG.put(a.field_appId, Integer.valueOf(a.versionCode));
                    f RF = an.bin().RF(a.field_appId);
                    if (RF != null) {
                        RF.cQ(crVar.njr);
                        if (!an.bin().a(RF, new String[0])) {
                            x.e("MicroMsg.GamePBDataIndex", "Store rank info failed, AppID: %s", new Object[]{RF.field_appId});
                        }
                    }
                }
            }
        }
    }
}
