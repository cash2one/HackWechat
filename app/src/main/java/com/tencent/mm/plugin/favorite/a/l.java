package com.tencent.mm.plugin.favorite.a;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.tu;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bs;
import com.tencent.mm.protocal.c.bt;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.o;
import com.tencent.mm.z.u;

public final class l extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT = null;
    public f mqv;

    public l(f fVar) {
        x.i("MicroMsg.Fav.NetSceneAddFav", "NetSceneAddFavItem %s", new Object[]{Long.valueOf(fVar.field_localId)});
        a aVar = new a();
        aVar.hmj = new bs();
        aVar.hmk = new bt();
        aVar.uri = "/cgi-bin/micromsg-bin/addfavitem";
        aVar.hmi = 401;
        aVar.hml = JsApiChooseMedia.CTRL_INDEX;
        aVar.hmm = 1000000193;
        this.gJQ = aVar.JZ();
        this.mqv = fVar;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        bs bsVar = (bs) this.gJQ.hmg.hmo;
        bsVar.vGQ = o.k(this.mqv.field_xml, System.currentTimeMillis());
        bsVar.ktN = this.mqv.field_type;
        bsVar.vGR = this.mqv.field_sourceType;
        this.mqv.field_xml = f.c(this.mqv);
        h.getFavItemInfoStorage().a(this.mqv, new String[]{"localId"});
        bsVar.vGT = this.mqv.field_xml;
        bsVar.vGS = this.mqv.field_sourceId;
        this.mqv.zR("MicroMsg.Fav.NetSceneAddFav");
        this.gJT = eVar2;
        x.i("MicroMsg.Fav.NetSceneAddFav", "ADD FavItem, sourceId:%s localId:%d favId:%d", new Object[]{this.mqv.field_sourceId, Long.valueOf(this.mqv.field_localId), Integer.valueOf(this.mqv.field_id)});
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Fav.NetSceneAddFav", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if ((i2 == 0 && i3 == 0) || i3 == -400) {
            bt btVar = (bt) ((b) qVar).hmh.hmo;
            x.i("MicroMsg.Fav.NetSceneAddFav", "fav id %d, local id %d, itemStatus %d, update seq %d", new Object[]{Integer.valueOf(btVar.vGM), Long.valueOf(this.mqv.field_localId), Integer.valueOf(this.mqv.field_itemStatus), Integer.valueOf(btVar.vGP)});
            this.mqv.field_id = btVar.vGM;
            this.mqv.field_localSeq = btVar.vGP;
            if (this.mqv.field_itemStatus == 12) {
                x.v("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd wait server upload sent");
                this.mqv.field_itemStatus = 13;
            }
            if (this.mqv.field_itemStatus == 9) {
                x.v("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd item done");
                this.mqv.field_itemStatus = 10;
                h.aIs().cY(this.mqv.field_localId);
                g.pQN.h(10659, new Object[]{Integer.valueOf(0), Integer.valueOf(this.mqv.field_type), Integer.valueOf(0), Long.valueOf(j.b(this.mqv)), Long.valueOf(com.tencent.mm.plugin.fav.a.g.cU(this.mqv.field_localId))});
            }
            f dc = h.getFavItemInfoStorage().dc((long) btVar.vGM);
            if (dc != null) {
                this.mqv.field_updateSeq = dc.field_updateSeq;
                h.getFavItemInfoStorage().g(dc);
                x.i("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd aleady exist, delete old info, favId:%d", new Object[]{Integer.valueOf(dc.field_id)});
            }
            u.b hy = u.GK().hy(this.mqv.field_sessionId);
            if (!(bh.ov(this.mqv.field_sessionId) || this.mqv.field_type != 5 || hy == null)) {
                com.tencent.mm.sdk.b.b tuVar = new tu();
                tuVar.fMo.fMp = hy.getString("prePublishId", "");
                if (!(this.mqv.field_favProto == null || this.mqv.field_favProto.weS == null)) {
                    tuVar.fMo.url = this.mqv.field_favProto.weS.hOf;
                }
                if (!(!bh.ov(tuVar.fMo.url) || this.mqv.field_favProto == null || this.mqv.field_favProto.web == null || this.mqv.field_favProto.web.wfz == null)) {
                    tuVar.fMo.url = this.mqv.field_favProto.web.wfz;
                }
                if (bh.ov(tuVar.fMo.url)) {
                    tuVar.fMo.url = hy.getString(SlookSmartClipMetaTag.TAG_TYPE_URL, "");
                }
                tuVar.fMo.fMr = hy.getString("preUsername", "");
                tuVar.fMo.fMs = hy.getString("preChatName", "");
                tuVar.fMo.fMt = hy.getInt("preMsgIndex", 0);
                tuVar.fMo.fMx = hy.getInt("sendAppMsgScene", 0);
                tuVar.fMo.fMy = hy.getInt("getA8KeyScene", 0);
                tuVar.fMo.fMz = hy.getString("referUrl", null);
                tuVar.fMo.fMA = hy.getString("adExtStr", null);
                tuVar.fMo.fMu = "";
                tuVar.fMo.fMv = "";
                tuVar.fMo.fMw = 0;
                tuVar.fMo.fMq = "fav_" + com.tencent.mm.z.q.FS() + "_" + this.mqv.field_id;
                com.tencent.mm.sdk.b.a.xef.m(tuVar);
            }
            this.mqv.field_sessionId = null;
            h.getFavItemInfoStorage().a(this.mqv, new String[]{"localId"});
            j.di(btVar.vGU);
        }
        if (i2 == 4 && i3 == -401) {
            x.i("MicroMsg.Fav.NetSceneAddFav", "fav fail, full size");
            if (this.mqv.aHO()) {
                h.getFavItemInfoStorage().t(16, this.mqv.field_localId);
            } else {
                h.getFavItemInfoStorage().t(6, this.mqv.field_localId);
            }
        }
        j.z(this.mqv);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 401;
    }
}
