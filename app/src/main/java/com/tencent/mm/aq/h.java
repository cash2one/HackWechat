package com.tencent.mm.aq;

import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.e;
import com.tencent.mm.z.s;
import java.util.Map;

public final class h extends e {
    protected final au a(bw bwVar, String str, String str2, String str3) {
        g Pw = o.Pw();
        cf a = super.a(bwVar, str, str2, str3);
        if (a.field_msgId != 0) {
            return a;
        }
        long j = bwVar.vHe;
        e bh = Pw.bh(j);
        if (bh.fFo == j) {
            FileOp.deleteFile(Pw.m(bh.hzQ, "", ""));
            FileOp.deleteFile(Pw.m(bh.hzS, "", ""));
            FileOp.deleteFile(Pw.m(bh.hzS, "", "") + "hd");
            Pw.hhp.delete("ImgInfo2", "msgSvrId=?", new String[]{String.valueOf(j)});
            if (bh.Pe()) {
                bh = Pw.hQ(bh.hzZ);
                if (bh != null) {
                    FileOp.deleteFile(Pw.m(bh.hzQ, "", ""));
                    FileOp.deleteFile(Pw.m(bh.hzS, "", ""));
                    FileOp.deleteFile(Pw.m(bh.hzS, "", "") + "hd");
                    Pw.hhp.delete("ImgInfo2", "id=?", new String[]{bh.hzP});
                }
            }
        }
        if (bwVar.vHa != 2) {
            x.e("MicroMsg.ImgMsgExtension", "data type img, but has no imgstatus_hasimg ?!");
            return a;
        }
        byte[] bArr;
        int i;
        byte[] a2 = n.a(bwVar.vHb);
        if (r.idz) {
            x.w("MicroMsg.ImgMsgExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
            bArr = null;
        } else {
            bArr = a2;
        }
        Map y = bi.y(a.field_content, "msg");
        long j2 = -1;
        if (!bh.ov(a.field_content)) {
            Map y2;
            x.i("MicroMsg.ImgMsgExtension", "cdntra content:[%s]", new Object[]{a.field_content});
            if (y == null) {
                g.pQN.a(111, 190, 1, false);
            }
            if (y != null) {
                if (bh.getInt((String) y.get(".msg.img.$hdlength"), 0) > 0) {
                    i = bwVar.vHa;
                    j = Pw.a(bArr, bwVar.vHe, true, a.field_content, new PString(), new PInt(), new PInt());
                    y2 = bi.y(a.field_content, "msgoperation");
                    if (y2 != null) {
                        a.ea((String) y2.get(".msgoperation.expinfo.expidstr"));
                        a.ff(bh.getInt((String) y2.get(".msgoperation.imagemsg.downloadcontroltype"), 0));
                        x.i("MicroMsg.ImgMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", new Object[]{a.gjO, Integer.valueOf(a.gjP)});
                    }
                    j2 = j;
                }
            }
            j = -1;
            y2 = bi.y(a.field_content, "msgoperation");
            if (y2 != null) {
                a.ea((String) y2.get(".msgoperation.expinfo.expidstr"));
                a.ff(bh.getInt((String) y2.get(".msgoperation.imagemsg.downloadcontroltype"), 0));
                x.i("MicroMsg.ImgMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", new Object[]{a.gjO, Integer.valueOf(a.gjP)});
            }
            j2 = j;
        }
        PString pString = new PString();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        i = bwVar.vHa;
        j = Pw.a(bArr, bwVar.vHe, false, a.field_content, pString, pInt, pInt2);
        if (j > 0) {
            a.dT(pString.value);
            a.fc(pInt.value);
            a.fd(pInt2.value);
            if (j2 > 0) {
                bh = o.Pw().b(Long.valueOf(j));
                bh.hM((int) j2);
                o.Pw().a(Long.valueOf(j), bh);
            }
        }
        if (bh.bw(bArr) && y != null) {
            String str4 = (String) y.get(".msg.img.$cdnthumbaeskey");
            String str5 = (String) y.get(".msg.img.$cdnthumburl");
            int i2 = bh.getInt((String) y.get(".msg.img.$cdnthumblength"), 0);
            String m = Pw.m(com.tencent.mm.a.g.s(("SERVERID://" + a.field_msgSvrId).getBytes()), "th_", "");
            j = a.field_msgSvrId;
            x.i("MicroMsg.ImgMsgExtension", "getThumbByCdn msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", new Object[]{Long.valueOf(j), str, str5, m});
            long Wp = bh.Wp();
            String str6 = m + ".tmp";
            i iVar = new i();
            iVar.field_mediaId = d.a("downimgthumb", a.field_createTime, str, String.valueOf(j));
            iVar.field_fullpath = str6;
            iVar.field_fileType = b.MediaType_THUMBIMAGE;
            iVar.field_totalLen = i2;
            iVar.field_aesKey = str4;
            iVar.field_fileId = str5;
            iVar.field_priority = b.hrL;
            iVar.field_chattype = s.eV(str) ? 1 : 0;
            x.d("MicroMsg.ImgMsgExtension", "get thumb by cdn [image] chatType[%d] fromUser[%s] ", new Object[]{Integer.valueOf(iVar.field_chattype), str});
            iVar.htt = new 1(this, j, str, str5, m, a, Wp, i2, str6);
            a.eQ(4);
            com.tencent.mm.modelcdntran.g.MJ().b(iVar, -1);
        }
        return a;
    }

    public final void h(au auVar) {
        o.Pw().o(auVar);
    }
}
