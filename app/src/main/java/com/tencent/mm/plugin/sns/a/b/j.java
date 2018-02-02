package com.tencent.mm.plugin.sns.a.b;

import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class j {
    public static void a(m mVar, boolean z, boolean z2) {
        int i = 2;
        bnp bxV = mVar.bxV();
        List list = bxV.wQo.vYd;
        if (list != null && !list.isEmpty()) {
            if ((bxV.wQo.vYc == 15 && mVar.xl(32)) || bxV.wQo.vYc == 18) {
                int i2;
                list.get(0);
                if (mVar.xl(32) && bxV.wQo.vYc == 15) {
                    bxV.wQt.hdu = mVar.bxT().qZM;
                    bxV.wQt.hdv = bxV.nGJ;
                }
                d dVar = new d();
                dVar.q("20source_publishid", bxV.wQt.hdv + ",");
                dVar.q("21uxinfo", bxV.wQt.hdu + ",");
                dVar.q("22clienttime", bh.Wp() + ",");
                dVar.q("23souce_type", (bxV.wQo.vYc == 15 ? 1 : 2) + ",");
                String str = "24scene";
                StringBuilder stringBuilder = new StringBuilder();
                if (z) {
                    i = 6;
                } else if (bxV.wQo.vYc == 15) {
                    i = 1;
                }
                dVar.q(str, stringBuilder.append(i).append(",").toString());
                dVar.q("25scene_chatname", ",");
                dVar.q("26scene_username", bxV.ksU + ",");
                dVar.q("27curr_publishid", bxV.nGJ + ",");
                dVar.q("28curr_msgid", ",");
                dVar.q("29curr_favid", "0,");
                String str2 = "30isdownload";
                stringBuilder = new StringBuilder();
                if (z2) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                dVar.q(str2, stringBuilder.append(i2).append(",").toString());
                dVar.q("31chatroom_membercount", "0,");
                p.a(bxV.rtA, dVar);
                x.i("MicroMsg.SnsVideoStatistic", "report snsad_video_exposure: " + dVar.Sz());
                g.pQN.h(12989, dVar);
            }
        }
    }

    public static void a(b bVar, a aVar, m mVar) {
        bnp bxV = mVar.bxV();
        List list = bxV.wQo.vYd;
        if (list != null && !list.isEmpty()) {
            if ((bxV.wQo.vYc == 15 && mVar.xl(32)) || bxV.wQo.vYc == 18) {
                list.get(0);
                if (mVar.xl(32) && bxV.wQo.vYc == 15) {
                    bxV.wQt.hdu = mVar.bxT().qZM;
                    bxV.wQt.hdv = bxV.nGJ;
                }
                d dVar = new d();
                dVar.q("20source_publishid", bxV.wQt.hdv + ",");
                dVar.q("21uxinfo", bxV.wQt.hdu + ",");
                dVar.q("22clienttime", bh.Wp() + ",");
                dVar.q("23video_statu", ",");
                dVar.q("24source_type", (bxV.wQo.vYc == 15 ? 1 : 2) + ",");
                dVar.q("25scene", bVar.value + ",");
                dVar.q("26action_type", a.a(aVar) + ",");
                dVar.q("27scene_chatname", ",");
                dVar.q("28scene_username", bxV.ksU + ",");
                dVar.q("29curr_publishid", bxV.nGJ + ",");
                dVar.q("30curr_msgid", "0,");
                dVar.q("31curr_favid", "0,");
                dVar.q("32elapsed_time", "0,");
                dVar.q("33load_time", "0,");
                dVar.q("34is_load_complete", "0,");
                dVar.q("35destination", "0,");
                dVar.q("36chatroom_membercount", "0,");
                p.a(bxV.rtA, dVar);
                x.i("MicroMsg.SnsVideoStatistic", "report snsad_video_action: " + dVar.Sz());
                ((c) com.tencent.mm.kernel.g.h(c.class)).h(12990, new Object[]{dVar});
            }
        }
    }

    public static void a(a aVar, String str, String str2, int i, int i2, String str3, String str4, String str5, long j, int i3, int i4) {
        d dVar = new d();
        dVar.q("20source_publishid", str + ",");
        dVar.q("21uxinfo", str2 + ",");
        dVar.q("22clienttime", bh.Wp() + ",");
        dVar.q("23video_statu", ",");
        dVar.q("24source_type", i + ",");
        dVar.q("25scene", i2 + ",");
        dVar.q("26action_type", a.a(aVar) + ",");
        dVar.q("27scene_chatname", str4 + ",");
        dVar.q("28scene_username", str3 + ",");
        dVar.q("29curr_publishid", str5 + ",");
        dVar.q("30curr_msgid", j + ",");
        dVar.q("31curr_favid", i3 + ",");
        dVar.q("32elapsed_time", "0,");
        dVar.q("33load_time", "0,");
        dVar.q("34is_load_complete", "0,");
        dVar.q("35destination", "0,");
        dVar.q("36chatroom_membercount", i4 + ",");
        f.a(str5, dVar);
        x.i("MicroMsg.SnsVideoStatistic", "report snsad_video_action: " + dVar.Sz());
        g.pQN.h(12990, dVar);
    }

    public static void a(d dVar, c cVar, e eVar, int i, m mVar) {
        bnp bxV = mVar.bxV();
        List list = bxV.wQo.vYd;
        if (list != null && !list.isEmpty()) {
            if ((bxV.wQo.vYc == 15 && mVar.xl(32)) || bxV.wQo.vYc == 18) {
                list.get(0);
                if (mVar.xl(32) && bxV.wQo.vYc == 15) {
                    bxV.wQt.hdu = mVar.bxT().qZM;
                    bxV.wQt.hdv = bxV.nGJ;
                }
                d dVar2 = new d();
                dVar2.q("20source_publishid", bxV.wQt.hdv + ",");
                dVar2.q("21uxinfo", bxV.wQt.hdu + ",");
                dVar2.q("22clienttime", bh.Wp() + ",");
                dVar2.q("23video_statu", e.a(eVar) + ",");
                dVar2.q("24source_type", (bxV.wQo.vYc == 15 ? 1 : 2) + ",");
                dVar2.q("25scene", dVar.value + ",");
                dVar2.q("26action_type", cVar.value + ",");
                dVar2.q("27scene_chatname", ",");
                dVar2.q("28scene_username", bxV.ksU + ",");
                dVar2.q("29curr_publishid", bxV.nGJ + ",");
                dVar2.q("30curr_msgid", "0,");
                dVar2.q("31curr_favid", "0,");
                dVar2.q("32chatroom_membercount", "0,");
                dVar2.q("33chatroom_toMemberCount", i + ",");
                p.a(bxV.rtA, dVar2);
                x.i("MicroMsg.SnsVideoStatistic", "report snsad_video_spread: " + dVar2.Sz());
                g.pQN.h(12991, dVar2);
            }
        }
    }

    public static void a(c cVar, String str, String str2, int i, int i2, String str3, String str4, String str5, long j, int i3, int i4, int i5) {
        d dVar = new d();
        dVar.q("20source_publishid", str + ",");
        dVar.q("21uxinfo", str2 + ",");
        dVar.q("22clienttime", bh.Wp() + ",");
        dVar.q("23video_statu", "3,");
        dVar.q("24source_type", i + ",");
        dVar.q("25scene", i2 + ",");
        dVar.q("26action_type", cVar.value + ",");
        dVar.q("27scene_chatname", str4 + ",");
        dVar.q("28scene_username", str3 + ",");
        dVar.q("29curr_publishid", str5 + ",");
        dVar.q("30curr_msgid", j + ",");
        dVar.q("31curr_favid", i3 + ",");
        dVar.q("32chatroom_membercount", i4 + ",");
        dVar.q("33chatroom_toMemberCount", i5 + ",");
        x.i("MicroMsg.SnsVideoStatistic", "report snsad_video_spread: " + dVar.Sz());
        f.a(str5, dVar);
        g.pQN.h(12991, dVar);
    }
}
