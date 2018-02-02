package com.tencent.mm.plugin.auto.a;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.ah;
import android.support.v4.app.z.f;
import android.support.v4.app.z.g;
import com.tencent.mm.R;
import com.tencent.mm.g.a.sp;
import com.tencent.mm.g.a.v;
import com.tencent.mm.g.a.v.a;
import com.tencent.mm.g.b.af;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;
import java.util.List;

class a$1 extends c<v> {
    final /* synthetic */ a kin;

    a$1(a aVar) {
        this.kin = aVar;
        this.xen = v.class.getName().hashCode();
    }

    private static boolean a(v vVar) {
        if (vVar instanceof v) {
            try {
                g gVar;
                a aVar = vVar.fnN;
                String str = vVar.fnN.username;
                String str2 = vVar.fnN.title;
                if (a.aoc()) {
                    PendingIntent broadcast = PendingIntent.getBroadcast(ac.getContext(), str.hashCode(), new Intent().addFlags(32).setAction("com.tencent.mm.permission.MM_AUTO_HEARD_MESSAGE").putExtra("key_username", str), 134217728);
                    PendingIntent broadcast2 = PendingIntent.getBroadcast(ac.getContext(), str.hashCode(), new Intent().addFlags(32).setAction("com.tencent.mm.permission.MM_AUTO_REPLY_MESSAGE").putExtra("key_username", str), 134217728);
                    ah.a aVar2 = new ah.a("key_voice_reply_text");
                    aVar2.tl = ac.getContext().getString(R.l.dGu);
                    ah ahVar = new ah(aVar2.tk, aVar2.tl, aVar2.tm, aVar2.tn, aVar2.mExtras, (byte) 0);
                    f.a.a aVar3 = new f.a.a(str2);
                    aVar3.sD = broadcast;
                    aVar3.sB = ahVar;
                    aVar3.sC = broadcast2;
                    int eT = com.tencent.mm.k.f.eT(str);
                    if (eT > 10) {
                        eT = 10;
                    }
                    ar.Hg();
                    List bw = com.tencent.mm.z.c.Fa().bw(str, eT);
                    for (int size = bw.size() - 1; size >= 0; size--) {
                        int hO;
                        String trim;
                        Object obj;
                        Object string;
                        au auVar = (au) bw.get(size);
                        if (s.eV(auVar.field_talker)) {
                            String str3 = auVar.field_talker;
                            hO = ba.hO(auVar.field_content);
                            if (hO != -1) {
                                trim = auVar.field_content.substring(0, hO).trim();
                                if (trim != null && trim.length() > 0) {
                                    str3 = trim;
                                }
                            }
                            ar.Hg();
                            af WO = com.tencent.mm.z.c.EY().WO(str3);
                            trim = r.a(WO, str3);
                            if (s.eV(str3) && (WO.field_username.equals(trim) || bh.ov(trim))) {
                                trim = ac.getContext().getString(R.l.dSN);
                            }
                            obj = trim;
                        } else {
                            obj = null;
                        }
                        if (auVar.cje()) {
                            string = ac.getContext().getString(R.l.eyO);
                        } else if (auVar.cjg()) {
                            if (!s.eV(auVar.field_talker) || auVar.field_isSend == 1) {
                                string = auVar.field_content;
                            } else {
                                hO = ba.hO(auVar.field_content);
                                string = hO != -1 ? auVar.field_content.substring(hO + 1).trim() : auVar.field_content;
                            }
                        } else if (auVar.ciW()) {
                            string = ac.getContext().getString(R.l.ezk);
                        } else if (auVar.cjh()) {
                            string = ac.getContext().getString(R.l.ezj);
                        } else if (auVar.cji()) {
                            string = ac.getContext().getString(R.l.ezg);
                        } else {
                            if (auVar.aNc()) {
                                com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(auVar.field_content);
                                if (fT != null) {
                                    switch (fT.type) {
                                        case 2:
                                            string = String.format(ac.getContext().getString(R.l.eyO), new Object[0]);
                                            break;
                                        case 3:
                                            string = String.format(ac.getContext().getString(R.l.eyC), new Object[]{bh.az(fT.title, "")});
                                            break;
                                        case 4:
                                            string = String.format(ac.getContext().getString(R.l.eyG), new Object[]{bh.az(fT.title, "")});
                                            break;
                                        case 5:
                                            string = String.format(ac.getContext().getString(R.l.eyz), new Object[]{bh.az(fT.title, "")});
                                            break;
                                        case 6:
                                            string = String.format(ac.getContext().getString(R.l.eyy), new Object[]{bh.az(fT.title, "")});
                                            break;
                                        case 8:
                                            string = String.format(ac.getContext().getString(R.l.eyK), new Object[]{bh.az(fT.title, "")});
                                            break;
                                        case 10:
                                            string = String.format(ac.getContext().getString(R.l.eyD), new Object[]{bh.az(fT.title, "")});
                                            break;
                                        case 13:
                                            string = String.format(ac.getContext().getString(R.l.eyB), new Object[]{bh.az(fT.title, "")});
                                            break;
                                        case 15:
                                            string = String.format(ac.getContext().getString(R.l.eyx), new Object[]{bh.az(fT.title, "")});
                                            break;
                                        case 16:
                                            string = String.format(ac.getContext().getString(R.l.eyJ), new Object[]{bh.az(fT.title, "")});
                                            break;
                                        case 19:
                                            string = String.format(ac.getContext().getString(R.l.eyE), new Object[]{bh.az(fT.title, "")});
                                            break;
                                        case 20:
                                            string = String.format(ac.getContext().getString(R.l.eyF), new Object[]{bh.az(fT.title, "")});
                                            break;
                                        case 24:
                                            string = ac.getContext().getString(R.l.egY);
                                            break;
                                    }
                                }
                            } else if (auVar.cjj()) {
                                String string2 = ac.getContext().getString(R.l.eyL);
                                d emojiMgr = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr();
                                if (emojiMgr != null) {
                                    EmojiInfo yc = emojiMgr.yc(auVar.field_imgPath);
                                    string = (yc == null || bh.ov(emojiMgr.xZ(yc.Nr()))) ? ac.getContext().getString(R.l.eyL) : "[" + emojiMgr.xZ(yc.Nr()) + "]";
                                } else {
                                    trim = string2;
                                }
                            } else if (auVar.aNe()) {
                                string = ac.getContext().getString(R.l.eyP);
                            } else if (auVar.cja() || auVar.cjb()) {
                                if (!auVar.field_content.equals(au.xzc)) {
                                    trim = auVar.field_content;
                                    b spVar = new sp();
                                    spVar.fKq.fuL = 1;
                                    spVar.fKq.content = trim;
                                    com.tencent.mm.sdk.b.a.xef.m(spVar);
                                    if ((spVar.fKr.type == 3 ? 1 : null) == null) {
                                        string = ac.getContext().getString(R.l.ezl);
                                    }
                                }
                                string = ac.getContext().getString(R.l.ezm);
                            } else if (auVar.cjf()) {
                                ar.Hg();
                                au.a EK = com.tencent.mm.z.c.Fa().EK(auVar.field_content);
                                string = String.format(ac.getContext().getString(R.l.eyJ), new Object[]{EK.getDisplayName()});
                            } else if (auVar.getType() == -1879048186) {
                                string = ac.getContext().getString(R.l.eyA);
                            }
                            trim = null;
                        }
                        if (string == null) {
                            string = ac.getContext().getString(R.l.ezh);
                        }
                        if (obj != null) {
                            string = String.format("%s: %s", new Object[]{obj, string});
                        }
                        aVar3.sH.add(string);
                        if (size == 0) {
                            aVar3.sF = auVar.field_createTime;
                        }
                    }
                    f fVar = new f();
                    fVar.sz = new f.a((String[]) aVar3.sH.toArray(new String[aVar3.sH.size()]), aVar3.sB, aVar3.sC, aVar3.sD, new String[]{aVar3.sI}, aVar3.sF);
                    Object obj2 = fVar;
                } else {
                    gVar = null;
                }
                aVar.fnO = gVar;
            } catch (Throwable th) {
                x.printErrStackTrace("MicroMsg.auto.AutoLogic", th, "", new Object[0]);
            }
        }
        return false;
    }
}
