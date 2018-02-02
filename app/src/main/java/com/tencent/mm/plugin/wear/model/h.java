package com.tencent.mm.plugin.wear.model;

import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.R;
import com.tencent.mm.ad.d;
import com.tencent.mm.ad.n;
import com.tencent.mm.g.a.sp;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.bxz;
import com.tencent.mm.protocal.c.byq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.y.g.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public final class h {
    public static final Bitmap NL(String str) {
        Bitmap cm = b.bZV().cm(str);
        if (cm == null) {
            n.Jz();
            x.d("MicroMsg.Wear.WearUtil", "avatar fullpath: %s", new Object[]{d.x(str, false)});
            return d.jg(d.x(str, false));
        }
        x.d("MicroMsg.Wear.WearUtil", "get wear avatar from cache: %s", new Object[]{str});
        return cm;
    }

    public static String NM(String str) {
        ar.Hg();
        af WO = c.EY().WO(str);
        if (!s.eV(str)) {
            return r.a(WO, str);
        }
        String string = ac.getContext().getString(R.l.dSN);
        String a = r.a(WO, str);
        if (WO.field_username.equals(a) || bh.ov(a)) {
            return string;
        }
        return a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byq W(au auVar) {
        int hO;
        String trim;
        byq com_tencent_mm_protocal_c_byq = new byq();
        com_tencent_mm_protocal_c_byq.wYH = auVar.field_msgId;
        com_tencent_mm_protocal_c_byq.wYM = auVar.field_createTime;
        com_tencent_mm_protocal_c_byq.ngq = 1;
        com_tencent_mm_protocal_c_byq.wYN = true;
        if (auVar.field_isSend == 1) {
            com_tencent_mm_protocal_c_byq.wvW = NM(q.FS());
            com_tencent_mm_protocal_c_byq.wYG = q.FS();
        } else if (s.eV(auVar.field_talker)) {
            String str = auVar.field_talker;
            hO = ba.hO(auVar.field_content);
            if (hO != -1) {
                trim = auVar.field_content.substring(0, hO).trim();
                if (trim != null) {
                }
            }
            trim = str;
            com_tencent_mm_protocal_c_byq.wvW = NM(trim);
            com_tencent_mm_protocal_c_byq.wYG = trim;
        } else {
            com_tencent_mm_protocal_c_byq.wvW = NM(auVar.field_talker);
            com_tencent_mm_protocal_c_byq.wYG = auVar.field_talker;
        }
        trim = null;
        if (auVar.isSystem()) {
            trim = ac.getContext().getString(R.l.ezi);
            com_tencent_mm_protocal_c_byq.ngq = 3;
        } else if (auVar.cje()) {
            trim = ac.getContext().getString(R.l.eyO);
            com_tencent_mm_protocal_c_byq.ngq = 4;
        } else if (auVar.cjg()) {
            if (!s.eV(auVar.field_talker) || auVar.field_isSend == 1) {
                trim = auVar.field_content;
            } else {
                hO = ba.hO(auVar.field_content);
                trim = hO != -1 ? auVar.field_content.substring(hO + 1).trim() : auVar.field_content;
            }
        } else if (auVar.ciW()) {
            trim = ac.getContext().getString(R.l.ezk);
            com_tencent_mm_protocal_c_byq.ngq = 6;
            com_tencent_mm_protocal_c_byq.wYN = com.tencent.mm.modelvoice.q.C(auVar);
            float bv = com.tencent.mm.modelvoice.q.bv(new com.tencent.mm.modelvoice.n(auVar.field_content).time);
            com_tencent_mm_protocal_c_byq.wYO = new com.tencent.mm.bq.b(ac.getContext().getString(R.l.ejo, new Object[]{Integer.valueOf((int) bv)}).getBytes());
        } else if (auVar.cjh()) {
            trim = ac.getContext().getString(R.l.ezj);
        } else if (auVar.cji()) {
            trim = ac.getContext().getString(R.l.ezg);
        } else if (auVar.ciX()) {
            r1 = a.fT(auVar.field_content);
            if (r1 != null) {
                if (r1.hcH.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
                    com_tencent_mm_protocal_c_byq.ngq = 5;
                    trim = auVar.field_isSend == 1 ? r1.hcB : r1.hcA;
                } else {
                    trim = auVar.field_isSend == 1 ? r1.hcB : r1.hcA;
                    trim = ac.getContext().getString(R.l.eyI, new Object[]{trim});
                }
            }
        } else if (auVar.ciY()) {
            trim = ac.getContext().getString(R.l.eyH);
            com_tencent_mm_protocal_c_byq.ngq = 5;
        } else if (auVar.aNc()) {
            r1 = a.fT(auVar.field_content);
            if (r1 != null) {
                switch (r1.type) {
                    case 2:
                        trim = String.format(ac.getContext().getString(R.l.eyO), new Object[0]);
                        break;
                    case 3:
                        trim = String.format(ac.getContext().getString(R.l.eyC), new Object[]{bh.az(r1.title, "")});
                        break;
                    case 4:
                        trim = String.format(ac.getContext().getString(R.l.eyG), new Object[]{bh.az(r1.title, "")});
                        break;
                    case 5:
                        trim = String.format(ac.getContext().getString(R.l.eyz), new Object[]{bh.az(r1.title, "")});
                        break;
                    case 6:
                        trim = String.format(ac.getContext().getString(R.l.eyy), new Object[]{bh.az(r1.title, "")});
                        break;
                    case 8:
                        trim = ac.getContext().getString(R.l.eyK, new Object[]{bh.az(r1.title, "")});
                        break;
                    case 10:
                        trim = String.format(ac.getContext().getString(R.l.eyD), new Object[]{bh.az(r1.title, "")});
                        break;
                    case 13:
                        trim = String.format(ac.getContext().getString(R.l.eyB), new Object[]{bh.az(r1.title, "")});
                        break;
                    case 15:
                        trim = String.format(ac.getContext().getString(R.l.eyx), new Object[]{bh.az(r1.title, "")});
                        break;
                    case 16:
                        trim = String.format(ac.getContext().getString(R.l.eyJ), new Object[]{bh.az(r1.title, "")});
                        break;
                    case 19:
                        trim = String.format(ac.getContext().getString(R.l.eyE), new Object[]{bh.az(r1.title, "")});
                        break;
                    case 20:
                        trim = String.format(ac.getContext().getString(R.l.eyF), new Object[]{bh.az(r1.title, "")});
                        break;
                    default:
                        break;
                }
            }
        } else if (auVar.cjj()) {
            str = ac.getContext().getString(R.l.eyL);
            if (((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr() != null) {
                EmojiInfo yc = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yc(auVar.field_imgPath);
                if (bh.ov(((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().xZ(yc.Nr()))) {
                    trim = ac.getContext().getString(R.l.eyL);
                } else {
                    trim = "[" + ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().xZ(yc.Nr()) + "]";
                }
                bxz com_tencent_mm_protocal_c_bxz = new bxz();
                com_tencent_mm_protocal_c_bxz.vZU = yc.Nr();
                if (yc.isGif()) {
                    com_tencent_mm_protocal_c_bxz.ktN = 1;
                } else {
                    com_tencent_mm_protocal_c_bxz.ktN = 2;
                }
                try {
                    com_tencent_mm_protocal_c_byq.wYO = new com.tencent.mm.bq.b(com_tencent_mm_protocal_c_bxz.toByteArray());
                } catch (IOException e) {
                }
                com_tencent_mm_protocal_c_byq.ngq = 2;
            } else {
                trim = str;
            }
        } else if (auVar.aNe()) {
            trim = ac.getContext().getString(R.l.eyP);
        } else {
            if (!(auVar.cja() || auVar.cjb())) {
                boolean z;
                if (auVar.getType() == 64) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    if (auVar.cjf()) {
                        ar.Hg();
                        au.a EK = c.Fa().EK(auVar.field_content);
                        trim = String.format(ac.getContext().getString(R.l.eyJ), new Object[]{EK.getDisplayName()});
                    } else if (auVar.getType() == -1879048186) {
                        trim = ac.getContext().getString(R.l.eyA);
                    }
                }
            }
            if (!auVar.field_content.equals(au.xzc)) {
                boolean z2;
                trim = auVar.field_content;
                com.tencent.mm.sdk.b.b spVar = new sp();
                spVar.fKq.fuL = 1;
                spVar.fKq.content = trim;
                com.tencent.mm.sdk.b.a.xef.m(spVar);
                if (spVar.fKr.type == 3) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    trim = ac.getContext().getString(R.l.ezl);
                }
            }
            trim = ac.getContext().getString(R.l.ezm);
        }
        if (trim == null) {
            trim = ac.getContext().getString(R.l.ezh);
        }
        com_tencent_mm_protocal_c_byq.nje = trim;
        return com_tencent_mm_protocal_c_byq;
    }

    public static byte[] M(Bitmap bitmap) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static boolean aBs() {
        try {
            ac.getContext().getPackageManager().getPackageInfo("com.google.android.wearable.app.cn", 1);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static boolean aBt() {
        try {
            ac.getContext().getPackageManager().getPackageInfo("com.google.android.wearable.app", 1);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static byte[] NN(String str) {
        return FileOp.d(new File(new File(com.tencent.mm.loader.stub.a.gZJ, "lib"), "lib" + str + ".so").getAbsolutePath(), 0, -1);
    }
}
