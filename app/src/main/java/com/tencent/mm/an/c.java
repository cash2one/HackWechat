package com.tencent.mm.an;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.mm.a.f;
import com.tencent.mm.ae.u;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.au;
import com.tencent.mm.protocal.c.abe;
import com.tencent.mm.protocal.c.abf;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ak.b;
import com.tencent.mm.z.ak.b.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

final class c implements b {
    boolean hkG = false;
    private long hkQ = 0;
    long hyA = 0;
    final int hyB = 500;
    final int hyC = 10000;
    ak hyD = new ak(ar.Dm().oAt.getLooper(), new 1(this), false);
    final ak hyE = new ak(ar.Dm().oAt.getLooper(), new 4(this), true);
    private f<String, Integer> hyw = new f(200);
    Map<String, a> hyx = new HashMap();
    Queue<abe> hyy = new LinkedList();
    Queue<a> hyz = new LinkedList();

    c() {
    }

    public final void hK(String str) {
        this.hyx.remove(str);
    }

    public final void Q(String str, String str2) {
        x.i("MicroMsg.GetContactService", "dkverify add Contact :" + str + " chatroom: " + str2 + " stack:" + bh.cgy());
        if (am(str, str2)) {
            this.hyD.J(500, 500);
        }
    }

    public final void R(String str, String str2) {
        boolean z = false;
        if (!bh.ov(str)) {
            String FS = q.FS();
            String FT = q.FT();
            if (str.equals(FS) || str.equals(FT)) {
                x.i("MicroMsg.GetContactService", "addToStg username: " + str + " equal to user: " + FS + " alias: " + FT + " ret");
            } else {
                a aVar = new a();
                aVar.username = str;
                aVar.hho = bh.ou(str2);
                aVar.hwo = bh.e(Integer.valueOf(1));
                aVar.hyu = bh.Wp();
                z = d.OY().a(aVar);
            }
        }
        if (z) {
            this.hyD.J(500, 500);
        }
    }

    public final void a(String str, String str2, a aVar) {
        x.i("MicroMsg.GetContactService", "dkverify getNow :" + str + " chatroom: " + str2 + " stack:" + bh.cgy());
        if (am(str, str2)) {
            this.hyx.put(str, aVar);
            this.hyD.J(0, 0);
        }
    }

    private static boolean am(String str, String str2) {
        if (bh.ov(str)) {
            return false;
        }
        String FS = q.FS();
        String FT = q.FT();
        if (str.equals(FS) || str.equals(FT)) {
            x.i("MicroMsg.GetContactService", "addToStg username: " + str + " equal to user: " + FS + " alias: " + FT + " ret");
            return false;
        }
        a aVar = new a();
        aVar.username = str;
        aVar.hhn = bh.ou(str2);
        aVar.hyu = bh.Wp();
        return d.OY().a(aVar);
    }

    private void OV() {
        String[] strArr = new String[]{String.valueOf(this.hyA), "80"};
        Cursor a = d.OY().hhp.a("select getcontactinfov2.username,getcontactinfov2.inserttime,getcontactinfov2.type,getcontactinfov2.lastgettime,getcontactinfov2.reserved1,getcontactinfov2.reserved2,getcontactinfov2.reserved3,getcontactinfov2.reserved4 from getcontactinfov2 where inserttime> ?  order by inserttime asc limit ?", strArr, 0);
        if (a != null) {
            x.i("MicroMsg.GetContactService", "getFromDb count:%d", new Object[]{Integer.valueOf(a.getCount())});
            if (a.getCount() <= 0) {
                a.close();
                return;
            }
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            LinkedList linkedList3 = new LinkedList();
            LinkedList linkedList4 = new LinkedList();
            while (a.moveToNext()) {
                LinkedList linkedList5;
                a aVar = new a();
                aVar.username = a.getString(0);
                aVar.hyu = a.getLong(1);
                aVar.type = a.getInt(2);
                aVar.hyv = a.getInt(3);
                aVar.hhl = a.getInt(4);
                aVar.hwo = a.getInt(5);
                aVar.hhn = a.getString(6);
                aVar.hho = a.getString(7);
                String username = aVar.getUsername();
                String ou = bh.ou(aVar.HN());
                int e = bh.e(Integer.valueOf(aVar.hwo));
                String ou2 = bh.ou(aVar.OU());
                this.hyA = aVar.hyu;
                String str = username + "#" + ou;
                int a2 = bh.a((Integer) this.hyw.get(str), 0);
                if (a2 < 3) {
                    this.hyw.l(str, Integer.valueOf(a2 + 1));
                    if (e == 1) {
                        linkedList3.add(new Pair(new bdo().UA(username), new bdo().UA(ou2)));
                        x.i("MicroMsg.GetContactService", "getFromDb add user:%s scene:%s ticket:%s", new Object[]{username, Integer.valueOf(e), ou2});
                    } else {
                        linkedList.add(new bdo().UA(username));
                        linkedList2.add(new bdo().UA(ou));
                        x.i("MicroMsg.GetContactService", "getFromDb add user:%s room:%s", new Object[]{username, ou});
                    }
                } else {
                    linkedList4.add(username);
                    ag.y(new 2(this, username, false));
                }
                if (linkedList.size() >= 20 || a.isLast()) {
                    abe com_tencent_mm_protocal_c_abe = new abe();
                    com_tencent_mm_protocal_c_abe.vLm = linkedList;
                    com_tencent_mm_protocal_c_abe.wkd = linkedList.size();
                    com_tencent_mm_protocal_c_abe.wkh = linkedList2;
                    com_tencent_mm_protocal_c_abe.wkg = linkedList2.size();
                    this.hyy.add(com_tencent_mm_protocal_c_abe);
                    linkedList2 = new LinkedList();
                    linkedList5 = new LinkedList();
                    x.i("MicroMsg.GetContactService", "getFromDb now reqlist size:%d , this req usr count:%d", new Object[]{Integer.valueOf(this.hyy.size()), Integer.valueOf(com_tencent_mm_protocal_c_abe.vLm.size())});
                } else {
                    linkedList5 = linkedList2;
                    linkedList2 = linkedList;
                }
                linkedList = linkedList2;
                linkedList2 = linkedList5;
            }
            a.close();
            Iterator it = linkedList3.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                abe com_tencent_mm_protocal_c_abe2 = new abe();
                LinkedList linkedList6 = new LinkedList();
                linkedList6.add(pair.first);
                com_tencent_mm_protocal_c_abe2.vLm = linkedList6;
                com_tencent_mm_protocal_c_abe2.wkd = linkedList6.size();
                com_tencent_mm_protocal_c_abe2.wki = 1;
                com_tencent_mm_protocal_c_abe2.wkj = (bdo) pair.second;
                this.hyy.add(com_tencent_mm_protocal_c_abe2);
            }
            linkedList3.clear();
            for (int i = 0; i < linkedList4.size(); i++) {
                String str2 = (String) linkedList4.get(i);
                x.w("MicroMsg.GetContactService", "getFromDb try getContact Too much usr:%s; remove from table:%s ", new Object[]{str2, Boolean.valueOf(s.eV(str2))});
                if (s.eV(str2)) {
                    d.OY().ld(str2);
                }
            }
        }
    }

    final synchronized void OW() {
        if (com.tencent.mm.plugin.subapp.b.ift.ut()) {
            x.w("MicroMsg.GetContactService", "tryStartNetscene need init , never get contact");
        } else {
            long Wp = bh.Wp();
            if (this.hkG && Wp - this.hkQ > 600000) {
                x.w("MicroMsg.GetContactService", "tryStartNetscene Not Callback too long:%d . Force Run Now", new Object[]{Long.valueOf(Wp - this.hkQ)});
                this.hkG = false;
            }
            if (this.hkG) {
                x.i("MicroMsg.GetContactService", "tryStartNetscene netSceneRunning: " + this.hkG + " ret");
            } else {
                com.tencent.mm.bq.a aVar = (abe) this.hyy.poll();
                if (aVar == null) {
                    OV();
                    aVar = (abe) this.hyy.poll();
                    if (aVar == null || aVar.vLm == null || aVar.vLm.size() == 0) {
                        x.i("MicroMsg.GetContactService", "tryStartNetscene Not any more contact.");
                    }
                }
                this.hkQ = Wp;
                this.hkG = true;
                com.tencent.mm.ae.b.a aVar2 = new com.tencent.mm.ae.b.a();
                aVar2.hmj = aVar;
                aVar2.hmk = new abf();
                aVar2.uri = "/cgi-bin/micromsg-bin/getcontact";
                aVar2.hmi = au.CTRL_BYTE;
                u.a(aVar2.JZ(), new 3(this), true);
            }
        }
    }
}
