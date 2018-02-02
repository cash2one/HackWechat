package com.tencent.mm.plugin.webview.fts.topstory.a;

import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.y.d;
import java.util.Map;

public class a extends d {
    public String bhd;
    public String lOX;
    public String lOY;
    public String pes;
    public String rfu;
    public String seA;
    public String seB;
    public String seF;
    public String seG;
    public String sez;
    public String tnm;
    public String tnn;
    public String tno;
    public String tnp;
    public long tnq;

    public final /* synthetic */ d EJ() {
        d aVar = new a();
        aVar.tnm = this.tnm;
        aVar.tnn = this.tnn;
        aVar.tno = this.tno;
        aVar.tnp = this.tnp;
        aVar.tnq = this.tnq;
        aVar.lOX = this.lOX;
        aVar.lOY = this.lOY;
        aVar.rfu = this.rfu;
        aVar.sez = this.sez;
        aVar.seA = this.seA;
        aVar.seB = this.seB;
        aVar.bhd = this.bhd;
        aVar.pes = this.pes;
        aVar.seF = this.seF;
        aVar.seG = this.seG;
        return aVar;
    }

    public final void a(StringBuilder stringBuilder, com.tencent.mm.y.g.a aVar, String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, int i, int i2) {
        stringBuilder.append("<websearch>");
        if (!bh.ov(this.tnm)) {
            stringBuilder.append("<relevant_vid>");
            stringBuilder.append(com.tencent.mm.y.g.a.fU(this.tnm));
            stringBuilder.append("</relevant_vid>");
        }
        if (!bh.ov(this.tnn)) {
            stringBuilder.append("<relevant_expand>");
            stringBuilder.append(com.tencent.mm.y.g.a.fU(this.tnn));
            stringBuilder.append("</relevant_expand>");
        }
        if (!bh.ov(this.tnn)) {
            stringBuilder.append("<relevant_expand>");
            stringBuilder.append(com.tencent.mm.y.g.a.fU(this.tnn));
            stringBuilder.append("</relevant_expand>");
        }
        if (!bh.ov(this.tno)) {
            stringBuilder.append("<relevant_pre_searchid>");
            stringBuilder.append(com.tencent.mm.y.g.a.fU(this.tno));
            stringBuilder.append("</relevant_pre_searchid>");
        }
        if (!bh.ov(this.tnp)) {
            stringBuilder.append("<relevant_shared_openid>");
            stringBuilder.append(com.tencent.mm.y.g.a.fU(this.tnp));
            stringBuilder.append("</relevant_shared_openid>");
        }
        if (this.tnq >= 0) {
            stringBuilder.append("<rec_category>");
            stringBuilder.append(this.tnq);
            stringBuilder.append("</rec_category>");
        }
        if (!bh.ov(this.lOX)) {
            stringBuilder.append("<shareUrl>");
            stringBuilder.append(com.tencent.mm.y.g.a.fU(this.lOX));
            stringBuilder.append("</shareUrl>");
        }
        if (!bh.ov(this.lOY)) {
            stringBuilder.append("<shareTitle>");
            stringBuilder.append(com.tencent.mm.y.g.a.fU(this.lOY));
            stringBuilder.append("</shareTitle>");
        }
        if (!bh.ov(this.rfu)) {
            stringBuilder.append("<shareDesc>");
            stringBuilder.append(com.tencent.mm.y.g.a.fU(this.rfu));
            stringBuilder.append("</shareDesc>");
        }
        if (!bh.ov(this.sez)) {
            stringBuilder.append("<shareImgUrl>");
            stringBuilder.append(com.tencent.mm.y.g.a.fU(this.sez));
            stringBuilder.append("</shareImgUrl>");
        }
        if (!bh.ov(this.seA)) {
            stringBuilder.append("<shareString>");
            stringBuilder.append(com.tencent.mm.y.g.a.fU(this.seA));
            stringBuilder.append("</shareString>");
        }
        if (!bh.ov(this.seB)) {
            stringBuilder.append("<shareStringUrl>");
            stringBuilder.append(com.tencent.mm.y.g.a.fU(this.seB));
            stringBuilder.append("</shareStringUrl>");
        }
        if (!bh.ov(this.bhd)) {
            stringBuilder.append("<source>");
            stringBuilder.append(com.tencent.mm.y.g.a.fU(this.bhd));
            stringBuilder.append("</source>");
        }
        if (!bh.ov(this.pes)) {
            stringBuilder.append("<sourceUrl>");
            stringBuilder.append(com.tencent.mm.y.g.a.fU(this.pes));
            stringBuilder.append("</sourceUrl>");
        }
        if (!bh.ov(this.seF)) {
            stringBuilder.append("<strPlayCount>");
            stringBuilder.append(com.tencent.mm.y.g.a.fU(this.seF));
            stringBuilder.append("</strPlayCount>");
        }
        if (!bh.ov(this.seG)) {
            stringBuilder.append("<titleUrl>");
            stringBuilder.append(com.tencent.mm.y.g.a.fU(this.seG));
            stringBuilder.append("</titleUrl>");
        }
        stringBuilder.append("</websearch>");
    }

    public final void a(Map<String, String> map, com.tencent.mm.y.g.a aVar) {
        this.tnm = (String) map.get(".msg.appmsg.websearch.relevant_vid");
        this.tnn = (String) map.get(".msg.appmsg.websearch.relevant_expand");
        this.tno = (String) map.get(".msg.appmsg.websearch.relevant_pre_searchid");
        this.tnp = (String) map.get(".msg.appmsg.websearch.relevant_shared_openid");
        this.tnq = (long) bh.getInt((String) map.get(".msg.appmsg.websearch.rec_category"), -1);
        this.lOX = (String) map.get(".msg.appmsg.websearch.shareUrl");
        this.lOY = (String) map.get(".msg.appmsg.websearch.shareTitle");
        this.rfu = (String) map.get(".msg.appmsg.websearch.shareDesc");
        this.sez = (String) map.get(".msg.appmsg.websearch.shareImgUrl");
        this.seA = (String) map.get(".msg.appmsg.websearch.shareString");
        this.seB = (String) map.get(".msg.appmsg.websearch.shareStringUrl");
        this.bhd = (String) map.get(".msg.appmsg.websearch.source");
        this.pes = (String) map.get(".msg.appmsg.websearch.sourceUrl");
        this.seF = (String) map.get(".msg.appmsg.websearch.strPlayCount");
        this.seG = (String) map.get(".msg.appmsg.websearch.titleUrl");
    }
}
