package com.tencent.mm.pluginsdk.model;

import android.text.TextUtils;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bsk;
import com.tencent.mm.protocal.c.bsm;
import com.tencent.mm.protocal.c.bsn;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.g;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class o extends k implements com.tencent.mm.network.k {
    public int fuL;
    public final b gJQ;
    private e gJT;
    public String hzc;
    private List<String> vdA;
    public List<String> vdy;
    public String vdz;

    private o(int i, String str, String str2, int i2) {
        this.vdy = null;
        this.fuL = 0;
        this.vdA = null;
        Assert.assertTrue("This NetSceneVerifyUser init MUST use opcode == MM_VERIFYUSER_VERIFYOK", true);
        this.vdy = new LinkedList();
        this.vdy.add(str);
        this.fuL = 3;
        a aVar = new a();
        aVar.hmj = new bsm();
        aVar.hmk = new bsn();
        aVar.uri = "/cgi-bin/micromsg-bin/verifyuser";
        aVar.hmi = 137;
        aVar.hml = 44;
        aVar.hmm = 1000000044;
        this.gJQ = aVar.JZ();
        bsm com_tencent_mm_protocal_c_bsm = (bsm) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bsm.vJL = 3;
        com_tencent_mm_protocal_c_bsm.wnL = "";
        LinkedList linkedList = new LinkedList();
        bsk com_tencent_mm_protocal_c_bsk = new bsk();
        com_tencent_mm_protocal_c_bsk.pQt = str;
        com_tencent_mm_protocal_c_bsk.wTF = str2;
        com_tencent_mm_protocal_c_bsk.whR = com.tencent.mm.plugin.d.a.XW().FI().Wr(str);
        com_tencent_mm_protocal_c_bsk.wJu = null;
        linkedList.add(com_tencent_mm_protocal_c_bsk);
        com_tencent_mm_protocal_c_bsm.wTM = linkedList;
        com_tencent_mm_protocal_c_bsm.wTL = linkedList.size();
        linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(i2));
        com_tencent_mm_protocal_c_bsm.wTO = linkedList;
        com_tencent_mm_protocal_c_bsm.wTN = linkedList.size();
        com_tencent_mm_protocal_c_bsm.wvs = new bdn().bj(d.oSu.bfJ());
        x.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify scene:%d user:%d ticket:%s anti:%s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bsm.wTM.size()), Integer.valueOf(com_tencent_mm_protocal_c_bsm.wTO.size()), str2, com_tencent_mm_protocal_c_bsk.whR});
    }

    public o(int i, List<String> list, List<Integer> list2, List<String> list3, String str, String str2, Map<String, Integer> map, String str3, String str4) {
        int i2;
        this.vdy = null;
        this.fuL = 0;
        this.vdA = null;
        Assert.assertTrue("This NetSceneVerifyUser init NEVER use opcode == MM_VERIFYUSER_VERIFYOK", i != 3);
        this.fuL = i;
        this.vdy = list;
        if (list3 == null || list3.size() == 0) {
            list3 = new LinkedList();
        }
        a aVar = new a();
        aVar.hmj = new bsm();
        aVar.hmk = new bsn();
        aVar.uri = "/cgi-bin/micromsg-bin/verifyuser";
        aVar.hmi = 137;
        aVar.hml = 44;
        aVar.hmm = 1000000044;
        this.gJQ = aVar.JZ();
        if (list3 != null && list3.size() > 0) {
            if (list3.size() != list.size()) {
                x.e("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify Error lstAntispamTicket:%d lstVerifyUser:%d", new Object[]{Integer.valueOf(list3.size()), Integer.valueOf(list.size())});
            } else {
                for (i2 = 0; i2 < list3.size(); i2++) {
                    com.tencent.mm.plugin.d.a.XW().FI().x((String) list.get(i2), 2147483633, (String) list3.get(i2));
                }
            }
        }
        if (i == 2) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                list3.add(bh.az(com.tencent.mm.plugin.d.a.XW().FI().Wr((String) list.get(i3)), ""));
            }
        }
        bsm com_tencent_mm_protocal_c_bsm = (bsm) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bsm.vJL = i;
        com_tencent_mm_protocal_c_bsm.wnL = str;
        this.vdz = str;
        LinkedList linkedList = new LinkedList();
        i2 = 0;
        while (i2 < list.size()) {
            String str5;
            bsk com_tencent_mm_protocal_c_bsk = new bsk();
            com_tencent_mm_protocal_c_bsk.pQt = (String) list.get(i2);
            if (str2 == null) {
                str5 = "";
            } else {
                str5 = str2;
            }
            com_tencent_mm_protocal_c_bsk.wTF = str5;
            g FI = com.tencent.mm.plugin.d.a.XW().FI();
            String str6 = com_tencent_mm_protocal_c_bsk.pQt;
            ((Integer) list2.get(i2)).intValue();
            com_tencent_mm_protocal_c_bsk.whR = bh.az(FI.Wr(str6), "");
            if (TextUtils.isEmpty(com_tencent_mm_protocal_c_bsk.whR) && list3 != null && list3.size() > i2) {
                com_tencent_mm_protocal_c_bsk.whR = (String) list3.get(i2);
            }
            com_tencent_mm_protocal_c_bsk.wJu = str3;
            if (map != null) {
                if (map.containsKey(com_tencent_mm_protocal_c_bsk.pQt)) {
                    com_tencent_mm_protocal_c_bsk.wTG = ((Integer) map.get(com_tencent_mm_protocal_c_bsk.pQt)).intValue();
                }
            }
            com_tencent_mm_protocal_c_bsk.wTK = str4;
            x.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify op:%s idx:%s user:%s anti:%s chatroom:%s, reportInfo:%s", new Object[]{Integer.valueOf(this.fuL), Integer.valueOf(i2), com_tencent_mm_protocal_c_bsk.pQt, com_tencent_mm_protocal_c_bsk.whR, str3, str4});
            linkedList.add(com_tencent_mm_protocal_c_bsk);
            i2++;
        }
        com_tencent_mm_protocal_c_bsm.wTM = linkedList;
        com_tencent_mm_protocal_c_bsm.wTL = linkedList.size();
        LinkedList linkedList2 = new LinkedList();
        linkedList2.addAll(list2);
        com_tencent_mm_protocal_c_bsm.wTO = linkedList2;
        com_tencent_mm_protocal_c_bsm.wTN = linkedList2.size();
        com_tencent_mm_protocal_c_bsm.wvs = new bdn().bj(d.oSu.bfJ());
        x.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify op:%d scene:%d user:%d antitickets:%s chatroom:%s stack:%s", new Object[]{Integer.valueOf(this.fuL), Integer.valueOf(com_tencent_mm_protocal_c_bsm.wTM.size()), Integer.valueOf(com_tencent_mm_protocal_c_bsm.wTO.size()), bh.d(list3, ","), str3, bh.cgy()});
    }

    public o(int i, List<String> list, List<Integer> list2, String str, String str2, Map<String, Integer> map, String str3) {
        this(2, list, list2, null, str, str2, map, str3, "");
    }

    public o(String str, String str2, int i) {
        this(3, str, str2, i);
    }

    public o(int i, List<String> list, List<Integer> list2, String str, String str2) {
        this(i, list, list2, null, str, str2, null, null, "");
    }

    public final void fc(String str, String str2) {
        Iterator it = ((bsm) this.gJQ.hmg.hmo).wTM.iterator();
        while (it.hasNext()) {
            bsk com_tencent_mm_protocal_c_bsk = (bsk) it.next();
            com_tencent_mm_protocal_c_bsk.wTH = str;
            com_tencent_mm_protocal_c_bsk.wTI = str2;
        }
    }

    public final String bYs() {
        if (this.gJQ == null || this.gJQ.hmh == null) {
            return "";
        }
        return ((bsn) this.gJQ.hmh.hmo).ksU;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int bYt() {
        return this.fuL;
    }

    public final int getType() {
        return 30;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (!(i2 == 0 && i3 == 0)) {
            x.e("MicroMsg.NetSceneVerifyUser.dkverify", "errType:%d, errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        }
        this.gJT.a(i2, i3, str, this);
    }
}
