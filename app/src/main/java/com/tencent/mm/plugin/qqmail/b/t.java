package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.plugin.qqmail.b.v.e;
import com.tencent.mm.plugin.qqmail.b.v.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public final class t {
    ArrayList<u> pps = new ArrayList();
    v ppt = w.bkt();
    s ppu = null;
    boolean ppv = false;
    f ppw = new f(this) {
        final /* synthetic */ t ppy;

        {
            this.ppy = r1;
        }

        public final void O(String str, int i, int i2) {
            if (i == i2) {
                x.i("MicroMsg.ShareMailQueue", "finished one job, queue.size = %d", new Object[]{Integer.valueOf(this.ppy.pps.size())});
                if (this.ppy.ppu != null) {
                    this.ppy.ppu.HM(str);
                }
                if (this.ppy.pps.size() > 0) {
                    x.i("MicroMsg.ShareMailQueue", "continue to send next mail");
                    this.ppy.b((u) this.ppy.pps.remove(0));
                    this.ppy.ppt.a(this, this.ppy.ppx);
                    return;
                }
                x.i("MicroMsg.ShareMailQueue", "finished sent all mails");
                this.ppy.ppv = false;
            }
        }
    };
    e ppx = new e(this) {
        final /* synthetic */ t ppy;

        {
            this.ppy = r1;
        }

        public final void HO(String str) {
            if (this.ppy.ppu != null) {
                s sVar = this.ppy.ppu;
                if (bh.ov(str)) {
                    x.w("MicroMsg.ShareMailInfoMgr", "notify fail error, subject is null");
                } else {
                    s.HN(str);
                    sVar.HM(str);
                }
            }
            if (this.ppy.pps.size() > 0) {
                x.i("MicroMsg.ShareMailQueue", "continue to send next mail");
                this.ppy.b((u) this.ppy.pps.remove(0));
                this.ppy.ppt.a(this.ppy.ppw, this);
                return;
            }
            x.i("MicroMsg.ShareMailQueue", "final job fail");
            this.ppy.ppv = false;
        }
    };

    public final void a(u uVar) {
        if (ar.Hj()) {
            if (this.ppu == null) {
                this.ppu = new s();
            }
            s sVar = this.ppu;
            String str = uVar.poi;
            if (bh.ov(str)) {
                x.w("MicroMsg.ShareMailInfoMgr", "add info fail, info is null");
            } else {
                q qVar = new q();
                qVar.poi = str;
                sVar.ppr.omU.add(qVar);
                sVar.save();
            }
            this.pps.add(uVar);
            x.d("MicroMsg.ShareMailQueue", "add a new job, queue.size: %d", new Object[]{Integer.valueOf(this.pps.size())});
            if (!this.ppv) {
                x.d("MicroMsg.ShareMailQueue", "start execute");
                if (this.pps.size() > 0) {
                    this.ppv = true;
                    b((u) this.pps.remove(0));
                    this.ppt.a(this.ppw, this.ppx);
                }
            }
        }
    }

    final void b(u uVar) {
        v vVar = this.ppt;
        vVar.ppI.clear();
        vVar.poO = null;
        vVar.ppK = 0;
        vVar.ppM = null;
        vVar.ppN = null;
        vVar.ppO.clear();
        vVar.ppL.clear();
        vVar.fzO = null;
        vVar.ppH.clear();
        vVar.ppA.clear();
        vVar.ppz = null;
        vVar.poi = null;
        vVar.ppR = 0;
        vVar.poM = null;
        vVar.ppB.clear();
        vVar.ppF.clear();
        vVar.ppJ.clear();
        vVar.ppG = null;
        vVar.ppx = null;
        this.ppt.fzO = uVar.fzO;
        this.ppt.poi = uVar.poi;
        this.ppt.poM = uVar.poM;
        this.ppt.poN = uVar.poN;
        this.ppt.ppz = uVar.ppz;
        vVar = this.ppt;
        Map map = uVar.ppA;
        vVar.ppA = new HashMap();
        vVar.ppA.putAll(map);
        vVar = this.ppt;
        map = uVar.ppB;
        vVar.ppB = new LinkedHashMap();
        vVar.ppB.putAll(map);
        vVar = this.ppt;
        map = uVar.ppC;
        vVar.ppC = new LinkedHashMap();
        vVar.ppC.putAll(map);
    }
}
