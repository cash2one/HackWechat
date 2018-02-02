package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.qq.taf.jce.JceStruct;
import com.tencent.mm.R;
import com.tencent.mm.aq.e;
import com.tencent.mm.aq.f;
import com.tencent.mm.aq.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.b;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.g.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import com.tencent.wework.api.IWWAPI;
import com.tencent.wework.api.WWAPIFactory;
import com.tencent.wework.api.model.BaseMessage;
import com.tencent.wework.api.model.WWMediaConversation;
import com.tencent.wework.api.model.WWMediaFile;
import com.tencent.wework.api.model.WWMediaImage;
import com.tencent.wework.api.model.WWMediaLink;
import com.tencent.wework.api.model.WWMediaLocation;
import com.tencent.wework.api.model.WWMediaMergedConvs;
import com.tencent.wework.api.model.WWMediaMessage;
import com.tencent.wework.api.model.WWMediaMessage$WWMediaObject;
import com.tencent.wework.api.model.WWMediaText;
import com.tencent.wework.api.model.WWMediaVideo;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;

public final class ai {
    static void a(Context context, x xVar, List<au> list, boolean z) {
        IWWAPI iN = WWAPIFactory.iN(context);
        try {
            BaseMessage a;
            if (list.size() != 1 || ((au) list.get(0)).getType() == 48) {
                a = a(xVar, list, z);
            } else {
                a = c((au) list.get(0), z);
            }
            iN.a(a);
        } catch (a e) {
            h.h(context, R.l.eKb, R.l.dGO);
        }
    }

    private static WWMediaMessage$WWMediaObject c(au auVar, boolean z) {
        int type = auVar.getType();
        if (type == 1) {
            return new WWMediaText(i.q(auVar.field_content, auVar.field_isSend, z));
        }
        String m;
        WWMediaMessage$WWMediaObject wWMediaImage;
        if (type == 3) {
            e bi;
            if (auVar.field_msgId > 0) {
                bi = o.Pw().bi(auVar.field_msgId);
            } else {
                bi = null;
            }
            if ((bi == null || bi.hzP <= 0) && auVar.field_msgSvrId > 0) {
                bi = o.Pw().bh(auVar.field_msgSvrId);
            }
            if (bi == null) {
                return null;
            }
            m = o.Pw().m(f.c(bi), "", "");
            wWMediaImage = new WWMediaImage();
            wWMediaImage.filePath = m;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", new Object[]{wWMediaImage.filePath});
            return wWMediaImage;
        } else if (type == 43) {
            wWMediaImage = new WWMediaVideo();
            r nF = t.nF(auVar.field_imgPath);
            com.tencent.mm.modelvideo.o.TU();
            wWMediaImage.filePath = s.nt(nF.getFileName());
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SendToWeWorkHelper", "send video2, path:%s", new Object[]{wWMediaImage.filePath});
            return wWMediaImage;
        } else if (type == 48) {
            wWMediaImage = new WWMediaLocation();
            m = i.q(auVar.field_content, auVar.field_isSend, z);
            ar.Hg();
            b EL = c.Fa().EL(m);
            wWMediaImage.title = EL.nTe;
            wWMediaImage.hxu = EL.label;
            wWMediaImage.longitude = EL.nQy;
            wWMediaImage.latitude = EL.nQx;
            wWMediaImage.ApC = (double) EL.fzv;
            return wWMediaImage;
        } else if (type == 49 || type == 268435505) {
            return d(auVar, z);
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.SendToWeWorkHelper", "unsupport msg type: %d", new Object[]{Integer.valueOf(type)});
            return null;
        }
    }

    private static WWMediaMessage$WWMediaObject a(x xVar, List<au> list, boolean z) {
        WWMediaMessage$WWMediaObject wWMediaMergedConvs = new WWMediaMergedConvs();
        String str = xVar.field_username;
        Context context = ac.getContext();
        if (z) {
            str = context.getString(R.l.eCA);
        } else {
            str = q.FU().equals(com.tencent.mm.z.r.gt(str)) ? context.getString(R.l.egj, new Object[]{q.FU()}) : context.getString(R.l.egi, new Object[]{q.FU(), com.tencent.mm.z.r.gt(str)});
        }
        wWMediaMergedConvs.title = str;
        for (au auVar : list) {
            WWMediaConversation wWMediaConversation = new WWMediaConversation();
            String FS = auVar.field_isSend == 1 ? q.FS() : !z ? auVar.field_talker : ba.hP(auVar.field_content);
            wWMediaConversation.name = com.tencent.mm.z.r.gt(FS);
            try {
                Bitmap a = com.tencent.mm.ad.b.a(FS, false, -1);
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                a.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
                wWMediaConversation.ApA = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (Exception e) {
            }
            wWMediaConversation.date = auVar.field_createTime;
            wWMediaConversation.ApB = c(auVar, z);
            if (wWMediaConversation.checkArgs()) {
                wWMediaMergedConvs.ApD.add(wWMediaConversation);
            }
        }
        return wWMediaMergedConvs;
    }

    private static WWMediaMessage$WWMediaObject d(au auVar, boolean z) {
        a I;
        String str = auVar.field_content;
        if (z) {
            int indexOf = auVar.field_content.indexOf(58);
            if (indexOf != -1) {
                str = auVar.field_content.substring(indexOf + 1);
            }
        }
        if (str != null) {
            I = a.I(str, auVar.field_reserved);
        } else {
            I = null;
        }
        if (I == null) {
            return null;
        }
        switch (I.type) {
            case 2:
                if (I.fny == null || I.fny.length() <= 0) {
                    return null;
                }
                com.tencent.mm.pluginsdk.model.app.b Rz = an.aqd().Rz(I.fny);
                if (Rz == null || !Rz.aOC()) {
                    return null;
                }
                str = Rz.field_fileFullPath;
                if (com.tencent.mm.a.e.bO(str)) {
                    WWMediaMessage$WWMediaObject wWMediaImage = new WWMediaImage();
                    wWMediaImage.filePath = str;
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", new Object[]{wWMediaImage.filePath});
                    return wWMediaImage;
                }
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SendToWeWorkHelper", "Img not exist, bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[]{str, Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId)});
                return null;
            case 5:
                OutputStream byteArrayOutputStream;
                WWMediaMessage wWMediaLink = new WWMediaLink();
                wWMediaLink.webpageUrl = I.url;
                wWMediaLink.title = I.title;
                wWMediaLink.description = I.description;
                Bitmap a = o.Pw().a(auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(null), false);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    a.compress(CompressFormat.JPEG, 85, byteArrayOutputStream);
                    wWMediaLink.thumbData = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                } catch (Exception e) {
                }
                try {
                    a = o.Pw().a(auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(null), false);
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    a.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
                    wWMediaLink.thumbData = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                } catch (Exception e2) {
                }
                return wWMediaLink;
            case 6:
                com.tencent.mm.pluginsdk.model.app.b RI = l.RI(I.fny);
                if (RI == null) {
                    RI = an.aqd().fo(auVar.field_msgId);
                }
                if (RI.field_totalLen > DownloadHelper.SAVE_LENGTH) {
                    throw new a((byte) 0);
                }
                WWMediaMessage$WWMediaObject wWMediaFile = new WWMediaFile();
                wWMediaFile.fileName = I.title;
                wWMediaFile.filePath = RI.field_fileFullPath;
                wWMediaFile.contentLengthLimit = JceStruct.JCE_MAX_STRING_LENGTH;
                return wWMediaFile;
            default:
                return null;
        }
    }
}
