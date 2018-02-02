package com.tencent.mm.ui.chatting;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bmf;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.g$a;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.m;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;

public final class a {
    public static void a(a aVar, au auVar) {
        PString pString = new PString();
        PString pString2 = new PString();
        if (a(auVar, pString, pString2)) {
            a(aVar, auVar, pString.value, pString2.value);
        }
    }

    public static void a(a aVar, au auVar, String str, String str2) {
        String str3 = auVar.field_talker;
        boolean endsWith = str3.endsWith("@chatroom");
        String FS = auVar.field_isSend == 1 ? q.FS() : endsWith ? ba.hP(auVar.field_content) : str3;
        d dVar = new d();
        dVar.q("20source_publishid", str + ",");
        dVar.q("21uxinfo", str2 + ",");
        dVar.q("22clienttime", bh.Wp() + ",");
        dVar.q("23video_statu", ",");
        dVar.q("24source_type", (auVar.getType() == 62 ? 1 : 2) + ",");
        dVar.q("25scene", (endsWith ? 4 : 3) + ",");
        dVar.q("26action_type", a.a(aVar) + ",");
        dVar.q("27scene_chatname", str3 + ",");
        dVar.q("28scene_username", FS + ",");
        dVar.q("29curr_publishid", ",");
        dVar.q("30curr_msgid", auVar.field_msgSvrId + ",");
        dVar.q("31curr_favid", "0,");
        dVar.q("32elapsed_time", "0,");
        dVar.q("33load_time", "0,");
        dVar.q("34is_load_complete", "0,");
        dVar.q("35destination", "0,");
        dVar.q("36chatroom_membercount", (endsWith ? m.gl(str3) : 0) + ",");
        x.i("MicroMsg.AdVideoStatistic", "report snsad_video_action: " + dVar.Sz());
        ((c) g.h(c.class)).h(12990, new Object[]{dVar});
    }

    public static void a(c cVar, d dVar, au auVar, int i) {
        PString pString = new PString();
        PString pString2 = new PString();
        if (a(auVar, pString, pString2)) {
            String str = pString.value;
            String str2 = pString2.value;
            String str3 = auVar.field_talker;
            boolean endsWith = str3.endsWith("@chatroom");
            String FS = auVar.field_isSend == 1 ? q.FS() : endsWith ? ba.hP(auVar.field_content) : str3;
            d dVar2 = new d();
            dVar2.q("20source_publishid", str + ",");
            dVar2.q("21uxinfo", str2 + ",");
            dVar2.q("22clienttime", bh.Wp() + ",");
            dVar2.q("23video_statu", d.a(dVar) + ",");
            dVar2.q("24source_type", (auVar.getType() == 62 ? 1 : 2) + ",");
            dVar2.q("25scene", (endsWith ? 4 : 3) + ",");
            dVar2.q("26action_type", c.a(cVar) + ",");
            dVar2.q("27scene_chatname", str3 + ",");
            dVar2.q("28scene_username", FS + ",");
            dVar2.q("29curr_publishid", ",");
            dVar2.q("30curr_msgid", auVar.field_msgSvrId + ",");
            dVar2.q("31curr_favid", "0,");
            dVar2.q("32chatroom_membercount", (endsWith ? m.gl(str3) : 0) + ",");
            dVar2.q("33chatroom_toMemberCount", i + ",");
            x.i("MicroMsg.AdVideoStatistic", "report snsad_video_spread: " + dVar2.Sz());
            com.tencent.mm.plugin.report.service.g.pQN.h(12991, new Object[]{dVar2});
        }
    }

    public static boolean a(au auVar, PString pString, PString pString2) {
        if (auVar.getType() == 62) {
            r nF = t.nF(auVar.field_imgPath);
            if (nF == null) {
                return false;
            }
            bmf com_tencent_mm_protocal_c_bmf = nF.hVQ;
            if (com_tencent_mm_protocal_c_bmf == null || bh.ov(com_tencent_mm_protocal_c_bmf.hdu)) {
                return false;
            }
            pString.value = com_tencent_mm_protocal_c_bmf.hdv;
            pString2.value = com_tencent_mm_protocal_c_bmf.hdu;
            return true;
        } else if (auVar.getType() != 49) {
            return false;
        } else {
            boolean eV = s.eV(auVar.field_talker);
            String str = auVar.field_content;
            if (eV && auVar.field_content != null && auVar.field_isSend == 0) {
                str = ba.hQ(auVar.field_content);
            }
            g$a fT = g$a.fT(str);
            if (fT == null || fT.type != 4 || bh.ov(fT.hdo)) {
                return false;
            }
            pString.value = fT.hdv;
            pString2.value = fT.hdu;
            return true;
        }
    }
}
