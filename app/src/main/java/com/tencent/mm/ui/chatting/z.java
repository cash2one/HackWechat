package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.os.Looper;
import android.view.ViewStub;
import com.tencent.mm.R;
import com.tencent.mm.az.d;
import com.tencent.mm.az.e;
import com.tencent.mm.az.f;
import com.tencent.mm.az.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import java.util.Iterator;
import java.util.List;

public final class z {
    public List<au> kJF;
    public af mHandler = new 1(this, Looper.getMainLooper());
    public ChattingAnimFrame yxd = null;
    public Activity yxe;

    public final void a(Activity activity, List<au> list) {
        if (list != null) {
            for (au auVar : list) {
                Object obj;
                ar.Hg();
                if (t.by(t.d((Long) c.CU().get(68108, null))) * 1000 > 21600000) {
                    new af().postDelayed(new 2(this), 10000);
                }
                f aAY = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().aAY();
                if (aAY == null) {
                    x.d("MicroMsg.EggMgr", "eggList is null");
                    obj = null;
                    continue;
                } else {
                    int Wo = (int) bh.Wo();
                    x.d("MicroMsg.EggMgr", "cursecond is %d, getEggList.size is %d", new Object[]{Integer.valueOf(Wo), Integer.valueOf(aAY.hJz.size())});
                    Iterator it = aAY.hJz.iterator();
                    while (it.hasNext()) {
                        d dVar = (d) it.next();
                        String str = dVar.hJt;
                        Object obj2 = null;
                        if (t.ov(str)) {
                            obj2 = 1;
                        } else {
                            for (String equals : str.split(",")) {
                                if (equals.equals(w.cfi())) {
                                    obj2 = 1;
                                    break;
                                }
                            }
                        }
                        if (obj2 != null) {
                            Iterator it2 = dVar.hJo.iterator();
                            while (it2.hasNext()) {
                                e eVar = (e) it2.next();
                                String str2 = eVar.hJy;
                                if (t.ov(str2)) {
                                    x.e("MicroMsg.EggMgr", "error egg keyWord");
                                } else {
                                    str = auVar.field_content;
                                    if (s.eV(auVar.field_talker)) {
                                        int hO = ba.hO(str);
                                        if (hO != -1) {
                                            str = str.substring(hO + 1).trim();
                                        }
                                    }
                                    if (ak(str, str2, eVar.lang)) {
                                        if (this.yxd == null) {
                                            ViewStub viewStub = (ViewStub) activity.findViewById(R.h.cVR);
                                            if (viewStub != null) {
                                                viewStub.inflate();
                                            }
                                            this.yxd = (ChattingAnimFrame) activity.findViewById(R.h.bSN);
                                        }
                                        if (this.yxd == null) {
                                            x.e("MicroMsg.EggMgr", "AnimFrameView should not be null");
                                        } else if (dVar.hJr <= Wo && ((long) Wo) <= ((long) dVar.hJs) + 86400) {
                                            this.yxd.a(dVar);
                                            ag(dVar.hJq, auVar.field_isSend == 1);
                                            x.d("MicroMsg.EggMgr", "match keyWord[%s], time[%d - %d]", new Object[]{str2, Integer.valueOf(dVar.hJr), Integer.valueOf(dVar.hJs)});
                                            obj = 1;
                                            continue;
                                        } else if (dVar.hJr == dVar.hJs && dVar.hJr == 0) {
                                            this.yxd.a(dVar);
                                            ag(dVar.hJq, auVar.field_isSend == 1);
                                            x.d("MicroMsg.EggMgr", "match keyWord[%s], time[0 - 0]", new Object[]{str2});
                                            obj = 1;
                                            continue;
                                        } else {
                                            x.d("MicroMsg.EggMgr", "match keyWord[%s], but not match time[%d - %d]", new Object[]{str2, Integer.valueOf(dVar.hJr), Integer.valueOf(dVar.hJs)});
                                            obj = null;
                                            continue;
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            }
                            continue;
                        }
                    }
                    x.d("MicroMsg.EggMgr", "no match");
                    obj = null;
                    continue;
                }
                if (obj != null) {
                    return;
                }
            }
        }
    }

    private static boolean ak(String str, String str2, String str3) {
        if (t.ov(str) || t.ov(str2) || ac.getContext() == null) {
            return false;
        }
        String toLowerCase = str.toLowerCase();
        int indexOf = toLowerCase.indexOf(str2.toLowerCase());
        if (indexOf == -1) {
            return false;
        }
        do {
            int i = indexOf;
            try {
                boolean z;
                if (i >= toLowerCase.length() - 1 || t.ov(str3)) {
                    z = true;
                } else {
                    if (i > 0 && toLowerCase.charAt(i - 1) >= 'a' && toLowerCase.charAt(i - 1) <= 'z') {
                        x.v("MicroMsg.EggMgr", "letter in the prefix");
                        String substring = str.substring(0, i);
                        indexOf = substring.lastIndexOf(47);
                        if (indexOf != -1) {
                            substring = substring.subSequence(indexOf, substring.length());
                            com.tencent.mm.bx.g.chg();
                            f$a Wk = com.tencent.mm.bx.f.chd().Wk(substring);
                            substring = Wk != null ? Wk.text : null;
                            if (!t.ov(substring) && substring.length() + indexOf == i) {
                                x.v("MicroMsg.EggMgr", "letter in the prefix is smiley");
                                indexOf = -2;
                            }
                        }
                        if (indexOf != -2) {
                            z = false;
                            if (z && str2.length() + i < toLowerCase.length() && toLowerCase.charAt(str2.length() + i) >= 'a' && toLowerCase.charAt(str2.length() + i) <= 'z') {
                                x.v("MicroMsg.EggMgr", "letter in the suffix");
                                z = false;
                            }
                        }
                    }
                    z = true;
                    x.v("MicroMsg.EggMgr", "letter in the suffix");
                    z = false;
                }
                if (z) {
                    x.v("MicroMsg.EggMgr", "full match, matchPos = %s, TextLength = %s, keyLength = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(toLowerCase.length()), Integer.valueOf(str2.length())});
                    return z;
                }
                indexOf = toLowerCase.indexOf(str2.toLowerCase(), i + 1);
            } catch (Throwable e) {
                x.v("MicroMsg.EggMgr", "Exception in isKeywordMatch, %s", new Object[]{e.getMessage()});
                x.printErrStackTrace("MicroMsg.EggMgr", e, "", new Object[0]);
                return false;
            }
        } while (indexOf != -1);
        return false;
    }

    private static void ag(int i, boolean z) {
        try {
            h hVar;
            com.tencent.mm.az.g gVar;
            int i2;
            StringBuilder stringBuilder;
            StringBuilder stringBuilder2 = new StringBuilder();
            ar.Hg();
            byte[] e = com.tencent.mm.a.e.e(stringBuilder2.append(c.FB()).append("eggresult.rep").toString(), 0, -1);
            if (e != null) {
                x.d("MicroMsg.EggMgr", "data not null, parse it");
                hVar = (h) new h().aF(e);
            } else {
                x.d("MicroMsg.EggMgr", "data is null, new one");
                hVar = new h();
            }
            Iterator it = hVar.hJD.iterator();
            while (it.hasNext()) {
                gVar = (com.tencent.mm.az.g) it.next();
                if (gVar.hJq == i) {
                    if (z) {
                        gVar.hJB++;
                    } else {
                        gVar.hJC++;
                    }
                    i2 = 1;
                    if (i2 == 0) {
                        gVar = new com.tencent.mm.az.g();
                        gVar.hJq = i;
                        if (z) {
                            gVar.hJC = 1;
                        } else {
                            gVar.hJB = 1;
                        }
                        hVar.hJD.add(gVar);
                    }
                    e = hVar.toByteArray();
                    x.d("MicroMsg.EggMgr", "report list is %s, then save it", new Object[]{hVar.toString()});
                    stringBuilder = new StringBuilder();
                    ar.Hg();
                    com.tencent.mm.a.e.b(stringBuilder.append(c.FB()).append("eggresult.rep").toString(), e, e.length);
                }
            }
            i2 = 0;
            if (i2 == 0) {
                gVar = new com.tencent.mm.az.g();
                gVar.hJq = i;
                if (z) {
                    gVar.hJC = 1;
                } else {
                    gVar.hJB = 1;
                }
                hVar.hJD.add(gVar);
            }
            e = hVar.toByteArray();
            x.d("MicroMsg.EggMgr", "report list is %s, then save it", new Object[]{hVar.toString()});
            stringBuilder = new StringBuilder();
            ar.Hg();
            com.tencent.mm.a.e.b(stringBuilder.append(c.FB()).append("eggresult.rep").toString(), e, e.length);
        } catch (Throwable e2) {
            x.w("MicroMsg.EggMgr", "statistics crash : %s", new Object[]{e2.getLocalizedMessage()});
            x.printErrStackTrace("MicroMsg.EggMgr", e2, "", new Object[0]);
        }
    }
}
