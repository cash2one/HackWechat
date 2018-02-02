package com.tencent.mm.plugin.favorite.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.ut;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class h {

    public enum b {
        Sight(1),
        AdUrl(2),
        Chat(3),
        TalkChat(4),
        Fav(5);
        
        public int value;

        private b(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public enum d {
        Samll(1),
        Full(2),
        Complete(3);
        
        private int value;

        private d(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public static void m(f fVar) {
        if (fVar.field_favProto.weU != null && !fVar.field_favProto.weU.isEmpty()) {
            uq uqVar = (uq) fVar.field_favProto.weU.getFirst();
            ut utVar = uqVar.wdJ;
            if (utVar != null) {
                com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
                dVar.q("20source_publishid", utVar.hdv + ",");
                dVar.q("21uxinfo", utVar.hdu + ",");
                dVar.q("22clienttime", bh.Wp() + ",");
                dVar.q("23source_type", (fVar.field_type == 16 ? 1 : 2) + ",");
                dVar.q("24scene", "5,");
                dVar.q("25scene_chatname", ",");
                dVar.q("26scene_username", fVar.field_fromUser + ",");
                dVar.q("27curr_publishid", ",");
                dVar.q("28curr_msgid", "0,");
                dVar.q("29curr_favid", fVar.field_id + ",");
                dVar.q("30isdownload", "0,");
                dVar.q("31chatroom_membercount", "0,");
                ((i) g.h(i.class)).b(uqVar.fGG, dVar);
                x.i("MicroMsg.FavVideoStatistic", "report snsad_video_exposure: " + dVar.Sz());
                com.tencent.mm.plugin.report.service.g.pQN.h(12989, new Object[]{dVar});
            }
        }
    }

    public static void a(a aVar, f fVar) {
        if (fVar.field_favProto.weU != null && !fVar.field_favProto.weU.isEmpty()) {
            ut utVar = ((uq) fVar.field_favProto.weU.getFirst()).wdJ;
            if (utVar != null) {
                com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
                dVar.q("20source_publishid", utVar.hdv + ",");
                dVar.q("21uxinfo", utVar.hdu + ",");
                dVar.q("22clienttime", bh.Wp() + ",");
                dVar.q("23video_statu", ",");
                dVar.q("24source_type", (fVar.field_type == 16 ? 1 : 2) + ",");
                dVar.q("25scene", "5,");
                dVar.q("26action_type", a.a(aVar) + ",");
                dVar.q("27scene_chatname", ",");
                dVar.q("28scene_username", fVar.field_fromUser + ",");
                dVar.q("29curr_publishid", ",");
                dVar.q("30curr_msgid", "0,");
                dVar.q("31curr_favid", fVar.field_id + ",");
                dVar.q("32elapsed_time", "0,");
                dVar.q("33load_time", "0,");
                dVar.q("34is_load_complete", "0,");
                dVar.q("35destination", "0,");
                dVar.q("36chatroom_membercount", "0,");
                x.i("MicroMsg.FavVideoStatistic", "report snsad_video_action: " + dVar.Sz());
                ((c) g.h(c.class)).h(12990, new Object[]{dVar});
            }
        }
    }

    public static void a(c cVar, f fVar, d dVar, int i) {
        if (fVar.field_favProto.weU != null && !fVar.field_favProto.weU.isEmpty()) {
            ut utVar = ((uq) fVar.field_favProto.weU.getFirst()).wdJ;
            if (utVar != null) {
                com.tencent.mm.modelsns.d dVar2 = new com.tencent.mm.modelsns.d();
                dVar2.q("20source_publishid", utVar.hdv + ",");
                dVar2.q("21uxinfo", utVar.hdu + ",");
                dVar2.q("22clienttime", bh.Wp() + ",");
                dVar2.q("23video_statu", dVar.value + ",");
                dVar2.q("24source_type", (fVar.field_type == 16 ? 1 : 2) + ",");
                dVar2.q("25scene", "5,");
                dVar2.q("26action_type", c.a(cVar) + ",");
                dVar2.q("27scene_chatname", ",");
                dVar2.q("28scene_username", fVar.field_fromUser + ",");
                dVar2.q("29curr_publishid", ",");
                dVar2.q("30curr_msgid", "0,");
                dVar2.q("31curr_favid", fVar.field_id + ",");
                dVar2.q("32chatroom_membercount", "0,");
                dVar2.q("33chatroom_toMemberCount", i + ",");
                x.i("MicroMsg.FavVideoStatistic", "report snsad_video_spread: " + dVar2.Sz());
                com.tencent.mm.plugin.report.service.g.pQN.h(12991, new Object[]{dVar2});
            }
        }
    }
}
