package com.tencent.mm.plugin.order.model;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.order.a.b;
import com.tencent.mm.plugin.order.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class c {
    public List<j> kJF = new ArrayList();
    private List<a> paj = new ArrayList();

    public c() {
        loadFromDB();
        biz();
        biy();
        biA();
    }

    public final void a(j jVar, String str, String str2) {
        if (jVar != null && !TextUtils.isEmpty(str)) {
            a aVar = new a();
            aVar.field_msgId = jVar.fDJ;
            aVar.field_msgContentXml = str;
            aVar.field_isRead = str2;
            b.bit();
            if (!b.biv().a(aVar)) {
                x.e("MicroMsg.MallPayMsgManager", "insert CommonMsgXml failed! id:" + jVar.fDJ);
            }
            this.paj.add(aVar);
        }
    }

    private void loadFromDB() {
        b.bit();
        Cursor Tj = b.biv().Tj();
        if (Tj != null && Tj.getCount() > 0) {
            Tj.moveToFirst();
            int columnIndex = Tj.getColumnIndex("msgId");
            int columnIndex2 = Tj.getColumnIndex("msgContentXml");
            int columnIndex3 = Tj.getColumnIndex("isRead");
            while (!Tj.isAfterLast()) {
                a aVar = new a();
                aVar.field_msgId = Tj.getString(columnIndex);
                aVar.field_msgContentXml = Tj.getString(columnIndex2);
                aVar.field_isRead = Tj.getString(columnIndex3);
                Tj.moveToNext();
                this.paj.add(aVar);
            }
        }
        if (Tj != null) {
            Tj.close();
        }
    }

    private void biy() {
        if (this.kJF != null && this.kJF.size() != 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.kJF);
            for (int i = 0; i < arrayList.size(); i++) {
                j jVar = (j) arrayList.get(i);
                if (jVar.pbC != null && com.tencent.mm.plugin.order.c.c.wP(jVar.pbC)) {
                    int intValue = Integer.valueOf(jVar.pbC).intValue();
                    if (!(intValue == 2 || intValue == 1)) {
                        Hj(jVar.fDJ);
                    }
                }
            }
        }
    }

    public static j Hi(String str) {
        Map y = bi.y(str, "sysmsg");
        if (y == null) {
            return null;
        }
        String str2;
        j jVar = new j();
        jVar.pbC = (String) y.get(".sysmsg.paymsg.PayMsgType");
        jVar.pbD = (String) y.get(".sysmsg.paymsg.Brief.IconUrl");
        jVar.pbE = (String) y.get(".sysmsg.paymsg.Brief.CreateTime");
        jVar.pbF = (String) y.get(".sysmsg.paymsg.StatusSection.IconUrl");
        jVar.pbG = (String) y.get(".sysmsg.paymsg.StatusSection.StatusDesc");
        jVar.fDP = (String) y.get(".sysmsg.paymsg.StatusSection.Content");
        jVar.pbH = (String) y.get(".sysmsg.paymsg.StatusSection.JumpUrl");
        jVar.pbI = (String) y.get(".sysmsg.paymsg.ContactSection.AppUserName");
        jVar.pbs = (String) y.get(".sysmsg.paymsg.ContactSection.AppNickName");
        jVar.pbJ = (String) y.get(".sysmsg.paymsg.ContactSection.AppTelephone");
        int i = 0;
        while (true) {
            if (i == 0) {
                Object obj = (String) y.get(".sysmsg.paymsg.StatusSection.Button.Name");
                str2 = (String) y.get(".sysmsg.paymsg.StatusSection.Button.JumpUrl");
            } else {
                String str3 = (String) y.get(".sysmsg.paymsg.StatusSection.Button" + i + ".Name");
                str2 = (String) y.get(".sysmsg.paymsg.StatusSection.Button" + i + ".JumpUrl");
            }
            if (TextUtils.isEmpty(obj)) {
                break;
            }
            j$a com_tencent_mm_plugin_order_model_j_a = new j$a();
            com_tencent_mm_plugin_order_model_j_a.name = obj;
            com_tencent_mm_plugin_order_model_j_a.jumpUrl = str2;
            if (jVar.pbK == null) {
                jVar.pbK = new ArrayList();
            }
            jVar.pbK.add(com_tencent_mm_plugin_order_model_j_a);
            i++;
        }
        i = 0;
        while (true) {
            String str4;
            if (i == 0) {
                obj = (String) y.get(".sysmsg.paymsg.NormalSection.Name");
                str2 = (String) y.get(".sysmsg.paymsg.NormalSection.Value");
                str4 = (String) y.get(".sysmsg.paymsg.NormalSection.JumpUrl");
            } else {
                str3 = (String) y.get(".sysmsg.paymsg.NormalSection" + i + ".Name");
                str2 = (String) y.get(".sysmsg.paymsg.NormalSection" + i + ".Value");
                str4 = (String) y.get(".sysmsg.paymsg.NormalSection" + i + ".JumpUrl");
            }
            if (TextUtils.isEmpty(obj)) {
                return jVar;
            }
            j.b bVar = new j.b();
            bVar.name = obj;
            bVar.value = str2;
            bVar.jumpUrl = str4;
            if (jVar.pbL == null) {
                jVar.pbL = new ArrayList();
            }
            jVar.pbL.add(bVar);
            i++;
        }
    }

    public final boolean Hj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        j Hl = Hl(str);
        if (Hl == null) {
            return false;
        }
        this.kJF.remove(Hl);
        if (Hl != null) {
            for (int i = 0; i < this.paj.size(); i++) {
                a aVar = (a) this.paj.get(i);
                if (Hl.fDJ.equals(aVar.field_msgId)) {
                    this.paj.remove(aVar);
                    b.bit();
                    b.biv().a(aVar, new String[0]);
                    break;
                }
            }
        }
        return true;
    }

    private void biz() {
        for (int i = 0; i < this.paj.size(); i++) {
            a aVar = (a) this.paj.get(i);
            String str = aVar.field_msgContentXml;
            j Hi = Hi(str);
            Hi.fDJ = aVar.field_msgId;
            this.kJF.add(Hi);
            x.v("MicroMsg.MallPayMsgManager", "parsePayMsgFromMsgXmlList xml:" + str);
        }
    }

    public final boolean Hk(String str) {
        if (this.kJF == null || TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < this.kJF.size(); i++) {
            j jVar = (j) this.kJF.get(i);
            if (jVar != null && jVar.fDJ.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public final j Hl(String str) {
        if (this.kJF == null || TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i = 0; i < this.kJF.size(); i++) {
            j jVar = (j) this.kJF.get(i);
            if (str.equals(jVar.fDJ)) {
                return jVar;
            }
        }
        return null;
    }

    public final a Hm(String str) {
        if (this.paj == null || TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i = 0; i < this.paj.size(); i++) {
            a aVar = (a) this.paj.get(i);
            if (str.equals(aVar.field_msgId)) {
                return aVar;
            }
        }
        return null;
    }

    public final void biA() {
        int biB = biB();
        g.Dk();
        g.Dj().CU().set(204820, Integer.valueOf(biB));
        x.v("MicroMsg.MallPayMsgManager", "save unread msg is :" + biB);
    }

    public final int biB() {
        if (this.paj == null || this.paj.size() == 0) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.paj.size(); i2++) {
            a aVar = (a) this.paj.get(i2);
            if (aVar != null && "0".equals(aVar.field_isRead)) {
                i++;
            }
        }
        x.v("MicroMsg.MallPayMsgManager", "msg xml unread msg is %s:" + i);
        return i;
    }

    public static MallOrderDetailObject a(j jVar) {
        if (jVar == null) {
            return null;
        }
        int i;
        MallOrderDetailObject mallOrderDetailObject = new MallOrderDetailObject();
        MallOrderDetailObject$b mallOrderDetailObject$b = new MallOrderDetailObject$b();
        mallOrderDetailObject$b.pae = jVar.pbG;
        if (TextUtils.isEmpty(jVar.pbE) || !com.tencent.mm.plugin.order.c.c.wP(jVar.pbE)) {
            mallOrderDetailObject$b.time = (int) (System.currentTimeMillis() / 1000);
        } else {
            mallOrderDetailObject$b.time = Integer.valueOf(jVar.pbE).intValue();
        }
        mallOrderDetailObject$b.thumbUrl = jVar.pbF;
        mallOrderDetailObject$b.nfg = jVar.pbH;
        mallOrderDetailObject$b.paf = jVar.fDP;
        mallOrderDetailObject.oZW = mallOrderDetailObject$b;
        List list = jVar.pbK;
        if (list != null && list.size() > 0) {
            mallOrderDetailObject.oZY = new ArrayList();
            for (i = 0; i < list.size(); i++) {
                j$a com_tencent_mm_plugin_order_model_j_a = (j$a) list.get(i);
                MallOrderDetailObject.a aVar = new MallOrderDetailObject.a();
                aVar.name = com_tencent_mm_plugin_order_model_j_a.name;
                aVar.value = "";
                aVar.jumpUrl = com_tencent_mm_plugin_order_model_j_a.jumpUrl;
                aVar.kKb = false;
                mallOrderDetailObject.oZY.add(aVar);
            }
        }
        list = jVar.pbL;
        if (list != null && list.size() > 0) {
            if (mallOrderDetailObject.oZY == null) {
                mallOrderDetailObject.oZY = new ArrayList();
            }
            for (i = 0; i < list.size(); i++) {
                j.b bVar = (j.b) list.get(i);
                aVar = new MallOrderDetailObject.a();
                aVar.name = bVar.name;
                aVar.value = bVar.value;
                aVar.jumpUrl = bVar.jumpUrl;
                aVar.kKb = false;
                if (i == 0) {
                    aVar.kKb = true;
                }
                mallOrderDetailObject.oZY.add(aVar);
            }
        }
        mallOrderDetailObject.pac = jVar.pbJ;
        mallOrderDetailObject.fvL = jVar.pbI;
        if (TextUtils.isEmpty(jVar.pbE) || !com.tencent.mm.plugin.order.c.c.wP(jVar.pbE)) {
            mallOrderDetailObject.pad = (int) (System.currentTimeMillis() / 1000);
        } else {
            mallOrderDetailObject.pad = Integer.valueOf(jVar.pbE).intValue();
        }
        return mallOrderDetailObject;
    }
}
