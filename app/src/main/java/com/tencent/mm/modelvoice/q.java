package com.tencent.mm.modelvoice;

import android.database.Cursor;
import com.tencent.mm.ae.d;
import com.tencent.mm.ae.h;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.g.a.it;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.j.a$a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.f.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.ba.b;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import junit.framework.Assert;

public final class q {
    private static HashMap<String, WeakReference<h>> hXF = new HashMap();
    public static volatile HashMap<String, Integer> hXG = new HashMap();
    public static volatile HashMap<String, Integer> hXH = new HashMap();
    public static volatile HashMap<String, Integer> hXI = new HashMap();

    public static boolean nS(String str) {
        if (str == null) {
            return false;
        }
        p of = m.UD().of(str);
        if (of == null || of.hVJ >= 250) {
            return false;
        }
        of.hVJ++;
        of.fDt = 8192;
        return a(of);
    }

    public static int iK(int i) {
        return ((i - 6) / 32) * 20;
    }

    public static b ay(String str, String str2) {
        u UD = m.UD();
        String fullPath = getFullPath(str2);
        switch (bh.getInt(str, -1)) {
            case 1:
                if (UD.hXS.get(fullPath) == null) {
                    UD.hXS.put(fullPath, new l(fullPath));
                }
                return (b) UD.hXS.get(fullPath);
            case 4:
                if (UD.hXT.get(fullPath) == null) {
                    UD.hXT.put(fullPath, new h(fullPath));
                }
                return (b) UD.hXT.get(fullPath);
            default:
                if (UD.hXR.get(fullPath) == null) {
                    UD.hXR.put(fullPath, new a(fullPath));
                }
                return (b) UD.hXR.get(fullPath);
        }
    }

    public static b nT(String str) {
        u UD = m.UD();
        String fullPath = getFullPath(str);
        switch (o.nQ(str)) {
            case 0:
                if (UD.hXR.get(fullPath) == null) {
                    UD.hXR.put(fullPath, new a(fullPath));
                }
                return (b) UD.hXR.get(fullPath);
            case 1:
                if (UD.hXS.get(fullPath) == null) {
                    UD.hXS.put(fullPath, new l(fullPath));
                }
                return (b) UD.hXS.get(fullPath);
            case 2:
                if (UD.hXT.get(fullPath) == null) {
                    UD.hXT.put(fullPath, new h(fullPath));
                }
                return (b) UD.hXT.get(fullPath);
            default:
                if (UD.hXR.get(fullPath) == null) {
                    UD.hXR.put(fullPath, new a(fullPath));
                }
                return (b) UD.hXR.get(fullPath);
        }
    }

    public static void nU(String str) {
        u UD = m.UD();
        String fullPath = getFullPath(str);
        a aVar;
        switch (o.nQ(str)) {
            case 0:
                aVar = (a) UD.hXR.get(fullPath);
                if (aVar != null) {
                    aVar.Uu();
                    UD.hXR.remove(fullPath);
                    return;
                }
                return;
            case 1:
                l lVar = (l) UD.hXS.get(fullPath);
                if (lVar != null) {
                    lVar.Uu();
                    UD.hXS.remove(fullPath);
                    return;
                }
                return;
            case 2:
                h hVar = (h) UD.hXT.get(fullPath);
                if (hVar != null) {
                    hVar.Uu();
                    UD.hXT.remove(fullPath);
                    return;
                }
                return;
            default:
                aVar = (a) UD.hXR.get(fullPath);
                if (aVar != null) {
                    aVar.Uu();
                    UD.hXR.remove(fullPath);
                    return;
                }
                return;
        }
    }

    public static String getFullPath(String str) {
        if (bh.ov(str)) {
            return null;
        }
        return M(str, false);
    }

    public static String M(String str, boolean z) {
        a aVar = new a();
        String a = i.a(Fm(), "msg_", str, ".amr", 2);
        x.i("MicroMsg.VoiceLogic", "getAmrFullPath cost: " + aVar.zi() + " " + a);
        if (bh.ov(a)) {
            return null;
        }
        if (z || new File(a).exists()) {
            return a;
        }
        String str2 = Fl() + str;
        if (new File(str2 + ".amr").exists()) {
            k.q(str2 + ".amr", a, true);
            return a;
        } else if (!new File(str2).exists()) {
            return a;
        } else {
            k.q(str2, a, true);
            return a;
        }
    }

    public static String nV(String str) {
        String oe = u.oe(com.tencent.mm.z.q.FS());
        p pVar = new p();
        pVar.fileName = oe;
        pVar.fDC = str;
        pVar.hVE = System.currentTimeMillis() / 1000;
        pVar.clientId = oe;
        pVar.hVF = System.currentTimeMillis() / 1000;
        pVar.status = 1;
        pVar.hVz = com.tencent.mm.z.q.FS();
        pVar.fDt = -1;
        if (!m.UD().b(pVar)) {
            return null;
        }
        x.i("MicroMsg.VoiceLogic", "startRecord insert voicestg success");
        return oe;
    }

    public static boolean a(String str, h hVar) {
        if (str == null) {
            return false;
        }
        p of = m.UD().of(str);
        if (of == null) {
            x.d("MicroMsg.VoiceLogic", "startSend null record : " + str);
            return false;
        } else if (of.status != 1) {
            return false;
        } else {
            of.status = 2;
            of.fDt = 64;
            hXF.put(str, new WeakReference(hVar));
            return a(of);
        }
    }

    public static boolean nW(String str) {
        if (str == null) {
            return false;
        }
        x.d("MicroMsg.VoiceLogic", "Mark Canceled fileName[" + str + "]");
        p of = m.UD().of(str);
        if (of == null) {
            return false;
        }
        of.status = 8;
        of.hlp = o.nv(str);
        of.fDt = 96;
        return a(of);
    }

    public static boolean nX(String str) {
        if (str == null) {
            return false;
        }
        p of = m.UD().of(str);
        if (of == null) {
            x.d("MicroMsg.VoiceLogic", "cancel null download : " + str);
            return true;
        }
        x.d("MicroMsg.VoiceLogic", "cancel download : " + str + " SvrlId:" + of.fFo);
        if (of.fFo != 0) {
            ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().M(of.fDC, of.fFo);
        }
        return nZ(str);
    }

    public static boolean nY(String str) {
        if (str == null) {
            return false;
        }
        p of = m.UD().of(str);
        if (of == null) {
            x.i("MicroMsg.VoiceLogic", "cancel null record : " + str);
            return true;
        }
        x.i("MicroMsg.VoiceLogic", "cancel record : " + str + " LocalId:" + of.hVI);
        if (of.hVI != 0) {
            ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().dI((long) of.hVI);
        }
        return nZ(str);
    }

    public static boolean nZ(String str) {
        if (bh.ov(str)) {
            return false;
        }
        m.UD().iF(str);
        nU(str);
        return new File(getFullPath(str)).delete();
    }

    public static boolean aa(String str, int i) {
        return k(str, i, 0);
    }

    private static boolean k(String str, int i, int i2) {
        if (str == null) {
            return false;
        }
        x.d("MicroMsg.VoiceLogic", "StopRecord fileName[" + str + "], fullPath[" + getFullPath(str) + "]");
        p of = m.UD().of(str);
        if (of == null) {
            return false;
        }
        if (!(of.status == 97 || of.status == 98)) {
            of.status = 3;
        }
        of.hlp = o.nv(str);
        if (of.hlp <= 0) {
            ny(str);
            return false;
        }
        of.hVF = System.currentTimeMillis() / 1000;
        of.hXC = i;
        of.fDt = 3424;
        au auVar = new au();
        auVar.dS(of.fDC);
        auVar.setType(34);
        auVar.eR(1);
        auVar.dT(str);
        if (of.status == 97) {
            auVar.eQ(2);
            auVar.setContent(n.b(of.hVz, (long) of.hXC, false));
        } else if (of.status == 98) {
            auVar.eQ(5);
            auVar.setContent(n.b(of.hVz, -1, true));
        } else {
            auVar.eQ(1);
            auVar.setContent(n.b(of.hVz, (long) of.hXC, false));
        }
        auVar.aq(ba.hR(of.fDC));
        auVar.Dq(i2);
        a$a.xD().b(auVar);
        of.hVI = (int) ba.i(auVar);
        boolean a = a(of);
        hXF.remove(str);
        return a;
    }

    public static int a(String str, int i, long j, String str2, int i2, int i3) {
        if (str == null) {
            return -1;
        }
        x.d("MicroMsg.VoiceLogic", "dkmsgid UpdateAfterSend file:[" + str + "] newOff:" + i + " SvrID:" + j + " clientID:" + str2 + " hasSendEndFlag " + i2);
        p of = m.UD().of(str);
        if (of == null) {
            return -1;
        }
        of.hUp = i;
        of.hVF = System.currentTimeMillis() / 1000;
        of.fDt = 264;
        if (bh.ov(of.clientId) && str2 != null) {
            of.clientId = str2;
            of.fDt |= WXMediaMessage.TITLE_LENGTH_LIMIT;
        }
        if (of.fFo == 0 && j != 0) {
            of.fFo = j;
            of.fDt |= 4;
        }
        int i4 = 0;
        if (of.hlp <= i && of.status == 3 && i2 == 1) {
            of.status = 99;
            of.fDt |= 64;
            au dH = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().dH((long) of.hVI);
            dH.dS(of.fDC);
            dH.ap(of.fFo);
            dH.eQ(2);
            dH.setContent(n.b(of.hVz, (long) of.hXC, false));
            dH.Dq(i3);
            Integer num = (Integer) hXG.get(getFullPath(str));
            if (num != null) {
                of.hXE = num.intValue();
                of.fDt |= SQLiteGlobal.journalSizeLimit;
            }
            ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().a((long) of.hVI, dH);
            x.d("MicroMsg.VoiceLogic", "END!!! updateSend  file:" + str + " total:" + of.hlp + " status:" + of.status + " netTimes:" + of.hVJ + " msgId:" + dH.field_msgId);
            i4 = 1;
            nU(str);
        }
        if (a(of)) {
            return i4;
        }
        return -4;
    }

    public static synchronized void a(String str, byte[] bArr, int i, int i2) {
        int i3 = 0;
        synchronized (q.class) {
            int intValue;
            int intValue2;
            if (hXG.containsKey(str)) {
                intValue = ((Integer) hXG.get(str)).intValue();
                intValue2 = ((Integer) hXH.get(str)).intValue();
                i3 = ((Integer) hXI.get(str)).intValue();
            } else {
                intValue2 = 0;
                intValue = 0;
            }
            intValue = b(intValue, bArr, i, i2);
            i3 = a(i3, bArr, i, i2);
            hXG.put(str, Integer.valueOf(intValue));
            hXI.put(str, Integer.valueOf(i3));
            hXH.put(str, Integer.valueOf(intValue2 + i2));
        }
    }

    public static synchronized int a(int i, byte[] bArr, int i2, int i3) {
        synchronized (q.class) {
            if (bArr != null) {
                if (bArr.length != 0) {
                    for (int i4 = 0; i4 < i3; i4++) {
                        i += bArr[i2 + i4];
                    }
                }
            }
        }
        return i;
    }

    public static int b(int i, byte[] bArr, int i2, int i3) {
        if (!(bArr == null || bArr.length == 0)) {
            int hashCode;
            if (i == 0) {
                hashCode = bArr.hashCode() & 255;
                i = hashCode;
            } else {
                hashCode = i & 255;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                i += (bArr[i2 + i4] & hashCode) * 256;
            }
        }
        return i;
    }

    public static int c(String str, byte[] bArr, int i) {
        p of = m.UD().of(str);
        if (of == null) {
            return -1;
        }
        of.hXE = b(of.hXE, bArr, 0, i);
        of.fDt |= SQLiteGlobal.journalSizeLimit;
        if (a(of)) {
            return of.hXE;
        }
        return 0;
    }

    public static boolean oa(String str) {
        p of = m.UD().of(str);
        if (of == null) {
            return true;
        }
        File file = new File(getFullPath(str));
        b nT = nT(str);
        if (nT != null && (nT instanceof a) && Math.abs(file.length() - ((long) of.hlp)) == 6) {
            x.i("MicroMsg.VoiceLogic", "maybe amr, ignore for the moment. %d %d", Long.valueOf(file.length()), Integer.valueOf(of.hlp));
            return true;
        } else if (file.length() != ((long) of.hlp)) {
            x.e("MicroMsg.VoiceLogic", "checkChecksum fail. %d, %d", Long.valueOf(file.length()), Integer.valueOf(of.hlp));
            return false;
        } else {
            g bp = nT.bp(0, of.hlp);
            if (bp.ret != 0 || of.hXE == 0 || of.hXE == b(of.hXE & 255, bp.buf, 0, bp.flp)) {
                return true;
            }
            x.e("MicroMsg.VoiceLogic", "checkChecksum fail2. %d", Integer.valueOf(of.hXE));
            return false;
        }
    }

    public static int a(p pVar, byte[] bArr, int i, String str, String str2, d.a aVar) {
        a aVar2 = new a();
        p bw = m.UD().bw(pVar.fFo);
        if (bw != null && bw.status == 99) {
            return 0;
        }
        if (((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().F(pVar.fDC, pVar.fFo).field_msgSvrId == pVar.fFo && bw == null) {
            return 0;
        }
        if (bw != null) {
            pVar.fileName = bw.fileName;
        } else {
            pVar.fileName = u.oe(pVar.hVz);
        }
        pVar.fDt |= 1;
        x.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.g.zh() + "checktime :" + aVar2.zi());
        boolean z = false;
        if (bArr != null && bArr.length > 1) {
            boolean z2;
            if (bw != null) {
                x.e("MicroMsg.VoiceLogic", "Sync Voice Buf , But VoiceInfo is not new!");
            }
            String str3 = pVar.hWv;
            String str4 = pVar.fileName;
            int write = ay(str3, str4).write(bArr, bArr.length, 0);
            if (write < 0) {
                x.e("MicroMsg.VoiceLogic", "Write Failed File:" + str4 + " newOffset:" + write + " voiceFormat:" + str3);
                z2 = false;
            } else if (bArr.length != write) {
                x.e("MicroMsg.VoiceLogic", "Write File:" + str4 + " fileOff:" + write + " bufLen:" + bArr.length + " voiceFormat:" + str3);
                z2 = false;
            } else {
                x.i("MicroMsg.VoiceLogic", "writeVoiceFile file:[" + str4 + "] + buf:" + bArr.length + " voiceFormat:" + str3);
                nU(str4);
                z2 = true;
            }
            pVar.hXE = b(pVar.hXE, bArr, 0, bArr.length);
            pVar.fDt |= SQLiteGlobal.journalSizeLimit;
            z = z2;
        }
        x.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.g.zh() + "checktime :" + aVar2.zi());
        pVar.hVF = System.currentTimeMillis() / 1000;
        pVar.fDt |= 256;
        if (z) {
            pVar.status = 99;
        } else if (pVar.hlp == 0) {
            pVar.status = 5;
        } else {
            pVar.status = 6;
        }
        pVar.fDt |= 64;
        if (bw == null) {
            if (z) {
                pVar.hVI = (int) a(pVar, z, i, str, str2, aVar);
            }
            if (aVar != null) {
                pVar.gjE = ba.c(aVar);
                if (aVar.hmq != null) {
                    pVar.hEK = aVar.hmq.vHf;
                }
            }
            x.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.g.zh() + "checktime :" + aVar2.zi());
            pVar.fDt = -1;
            x.d("MicroMsg.VoiceLogic", "Insert fileName:" + pVar.fileName + " stat:" + pVar.status + " net:" + pVar.hUp + " total:" + pVar.hlp);
            if (m.UD().b(pVar)) {
                x.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.g.zh() + "checktime :" + aVar2.zi());
                if (z) {
                    return 1;
                }
            }
            x.d("MicroMsg.VoiceLogic", "Insert Error fileName:" + pVar.fileName + " stat:" + pVar.status + " net:" + pVar.hUp + " total:" + pVar.hlp);
            return -2;
        }
        x.d("MicroMsg.VoiceLogic", "Sync Update file:" + pVar.fileName + " stat:" + pVar.status);
        if (!a(pVar)) {
            return -44;
        }
        if (z) {
            a(pVar, aVar);
            return 1;
        }
        if (bw != null && bw.hVB == pVar.hlp) {
            a(bw.fileName, bw.hVB, aVar);
            x.w("MicroMsg.VoiceLogic", "Sync TotalLen not Change (send endflag but TotoalLen == FileLen) :" + bw.fileName);
        }
        x.i("MicroMsg.VoiceLogic", "summerbadcr setRecvSync end ret 0 and start run addMsgInfo[%s], syncWithBufSucc[%b], stack[%s]", aVar, Boolean.valueOf(z), bh.cgy());
        m.UF().run();
        return 0;
    }

    private static boolean a(p pVar, d.a aVar) {
        try {
            pVar.hVI = (int) a(pVar, true, 3, "", pVar.gjF, aVar);
            pVar.fDt |= 2048;
            return a(pVar);
        } catch (Throwable e) {
            x.e("MicroMsg.VoiceLogic", "exception:%s", bh.i(e));
            return false;
        }
    }

    private static long a(p pVar, boolean z, int i, String str, String str2, d.a aVar) {
        if (((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().dJ(pVar.fFo)) {
            x.i("MicroMsg.VoiceLogic", "[oneliang] msg svrid:%s,it is in delete msg list,may be revoke msg come first,msg info insert last,so no need to add msg info and delete voice info", Long.valueOf(pVar.fFo));
            if (bh.ou(pVar.fileName).length() > 0) {
                m.UD().iF(pVar.fileName);
            } else {
                x.i("MicroMsg.VoiceLogic", "[oneliang] the length of voice info file name is zero");
            }
            return -1;
        }
        au auVar = new au();
        auVar.ap(pVar.fFo);
        auVar.dT(pVar.fileName);
        auVar.aq(ba.n(pVar.fDC, pVar.hVE));
        auVar.dS(pVar.fDC);
        auVar.eR(com.tencent.mm.z.q.gr(pVar.hVz) ? 1 : 0);
        auVar.setType(34);
        auVar.dX(str);
        auVar.Dq(pVar.hWC);
        auVar.eQ(i);
        if (aVar == null) {
            int i2 = pVar.gjE;
            if (i2 != 0) {
                x.i("MicroMsg.VoiceLogic", "summerbadcr createMsgInfo flag has set[%d]", Integer.valueOf(i2));
                auVar.fa(i2);
                if (auVar.field_msgId == 0 && auVar.field_isSend == 0 && (i2 & 2) != 0) {
                    auVar.aq(ba.a(auVar.field_talker, pVar.hVE, true, auVar.field_msgSeq));
                }
            }
            if (pVar.hEK != 0) {
                auVar.as((long) pVar.hEK);
            }
            x.i("MicroMsg.VoiceLogic", "summerbadcr insert voice addMsgInfo is null but flag[%d], msgSeq[%d]", Integer.valueOf(i2), Integer.valueOf(pVar.hEK));
        } else {
            ba.a(auVar, aVar);
        }
        x.i("MicroMsg.VoiceLogic", "summerbadcr create voice msg info, msgSource : %s", str2);
        if (!bh.ov(str2)) {
            auVar.dY(str2);
            auVar.dZ(ba.hU(str2));
        }
        if (z) {
            auVar.setContent(n.b(pVar.hVz, (long) pVar.hXC, false));
        } else {
            auVar.setContent(n.b(pVar.hVz, 0, false));
        }
        if (!bh.ov(str2)) {
            auVar.dY(str2);
            auVar.dZ(ba.hU(str2));
            b hT = ba.hT(str2);
            if (hT != null) {
                auVar.dZ(hT.hgH);
                auVar.dW(hT.hgG);
                x.i("MicroMsg.VoiceLogic", "bizClientMsgId = %s", hT.hgG);
                if (hT.hgI != null) {
                    com.tencent.mm.sdk.b.b itVar = new it();
                    itVar.fzj.fnB = auVar;
                    itVar.fzj.fzk = hT;
                    com.tencent.mm.sdk.b.a.xef.m(itVar);
                }
            }
        }
        x.i("MicroMsg.VoiceLogic", "summerbadcr parseVoiceMsg svrId[%d], msgseq[%d]", Long.valueOf(auVar.field_msgSvrId), Long.valueOf(auVar.field_msgSeq));
        return ba.i(auVar);
    }

    public static int a(String str, int i, d.a aVar) {
        if (str == null) {
            return -1;
        }
        p of = m.UD().of(str);
        if (of == null) {
            return -1;
        }
        of.hVB = i;
        of.hVF = System.currentTimeMillis() / 1000;
        of.fDt = e.CTRL_INDEX;
        int i2 = 0;
        if (of.hlp > 0 && i >= of.hlp) {
            a(of, aVar);
            of.status = 99;
            of.fDt |= 64;
            x.d("MicroMsg.VoiceLogic", "END!!! updateRecv  file:" + str + " newsize:" + i + " total:" + of.hlp + " status:" + of.status + " netTimes:" + of.hVJ);
            i2 = 1;
            nU(str);
        }
        x.d("MicroMsg.VoiceLogic", "updateRecv file:" + str + " newsize:" + i + " total:" + of.hlp + " status:" + of.status);
        if (a(of)) {
            return i2;
        }
        return -3;
    }

    public static boolean nz(String str) {
        p of = m.UD().of(str);
        if (of == null) {
            return false;
        }
        if (of.status == 3) {
            au dH = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().dH((long) of.hVI);
            dH.setContent(n.b(of.hVz, (long) of.hXC, false));
            dH.eQ(2);
            ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().a((long) of.hVI, dH);
        }
        of.status = 97;
        of.hVF = System.currentTimeMillis() / 1000;
        of.fDt = 320;
        return a(of);
    }

    public static boolean iL(int i) {
        au dH = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().dH((long) i);
        if (dH.field_msgId == 0 || dH.field_imgPath == null) {
            return false;
        }
        if (bh.ov(dH.field_imgPath)) {
            return false;
        }
        p of = m.UD().of(dH.field_imgPath);
        if (of == null || bh.ov(of.fileName)) {
            return false;
        }
        of.status = 3;
        of.hUp = 0;
        of.hVE = System.currentTimeMillis() / 1000;
        of.hVF = System.currentTimeMillis() / 1000;
        of.fDt = 8648;
        boolean a = a(of);
        x.d("MicroMsg.VoiceLogic", " file:" + of.fileName + " msgid:" + of.hVI + "  stat:" + of.status);
        if (of.hVI == 0 || bh.ov(of.fDC)) {
            x.e("MicroMsg.VoiceLogic", " failed msg id:" + of.hVI + " user:" + of.fDC);
            return a;
        }
        dH.eQ(1);
        ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().a(dH.field_msgId, dH);
        m.UF().run();
        return true;
    }

    public static String e(String str, String str2, int i) {
        if (bh.ov(str)) {
            return null;
        }
        if (!(bh.ov(str2) || str2.startsWith("amr_") || str2.startsWith("spx_"))) {
            str2.startsWith("silk_");
        }
        String nV = nV(str);
        if (bh.ov(nV) || !k.q(getFullPath(str2), getFullPath(nV), false)) {
            return null;
        }
        k(nV, i, 1);
        return nV;
    }

    public static boolean ny(String str) {
        com.tencent.mm.plugin.report.service.g.pQN.a(111, 234, 1, false);
        if (str == null) {
            return false;
        }
        p of = m.UD().of(str);
        if (of == null) {
            x.e("MicroMsg.VoiceLogic", "Set error failed file:" + str);
            return false;
        }
        of.status = 98;
        of.hVF = System.currentTimeMillis() / 1000;
        of.fDt = 320;
        boolean a = a(of);
        x.d("MicroMsg.VoiceLogic", "setError file:" + str + " msgid:" + of.hVI + " old stat:" + of.status);
        if (of.hVI == 0 || bh.ov(of.fDC)) {
            x.e("MicroMsg.VoiceLogic", "setError failed msg id:" + of.hVI + " user:" + of.fDC);
            return a;
        }
        au dH = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().dH((long) of.hVI);
        com.tencent.mm.plugin.report.d.pPH.a(111, 33, 1, true);
        dH.ao((long) of.hVI);
        dH.eQ(5);
        dH.dS(of.fDC);
        dH.setContent(n.b(of.hVz, -1, true));
        ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().a(dH.field_msgId, dH);
        return a;
    }

    public static au ob(String str) {
        if (str == null) {
            return null;
        }
        p of = m.UD().of(str);
        if (of != null) {
            return ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().dH((long) of.hVI);
        }
        return null;
    }

    public static p oc(String str) {
        return m.UD().of(str);
    }

    public static List<p> UI() {
        int i;
        List<p> list;
        u UD = m.UD();
        Cursor a = UD.hhp.a(("SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum" + " FROM voiceinfo") + " WHERE Status<97 and User!=\"_USER_FOR_THROWBOTTLE_\"   order by CreateTime", null, 2);
        int i2 = 0;
        if (a.moveToFirst()) {
            List<p> arrayList = new ArrayList();
            do {
                p pVar = new p();
                pVar.b(a);
                arrayList.add(pVar);
                i2++;
            } while (a.moveToNext());
            List<p> list2 = arrayList;
            i = i2;
            list = list2;
        } else {
            i = 0;
            list = null;
        }
        x.d("MicroMsg.VoiceStorage", "getUnfinishInfo resCount:" + i);
        a.close();
        return list;
    }

    private static boolean a(p pVar) {
        if (pVar == null || pVar.fDt == -1) {
            return false;
        }
        return m.UD().a(pVar.fileName, pVar);
    }

    public static float B(au auVar) {
        boolean z = auVar != null && auVar.ciW();
        Assert.assertTrue(z);
        float f = ((float) new n(auVar.field_content).time) / 1000.0f;
        if (f < 1.0f) {
            f = 1.0f;
        }
        return ((float) Math.round(f * 10.0f)) / 10.0f;
    }

    public static float bv(long j) {
        float f = 60.0f;
        float f2 = 1.0f;
        float f3 = ((float) j) / 1000.0f;
        if (f3 >= 1.0f) {
            f2 = f3;
        }
        if (f2 <= 60.0f) {
            f = f2;
        }
        return (float) Math.round(f);
    }

    public static boolean C(au auVar) {
        if (auVar == null || !auVar.ciW()) {
            return false;
        }
        return new n(auVar.field_content).hVA;
    }

    public static boolean D(au auVar) {
        if (auVar == null || !auVar.ciW() || auVar.field_isSend == 1) {
            return false;
        }
        if (new n(auVar.field_content).time != 0) {
            return false;
        }
        return true;
    }

    public static void E(au auVar) {
        if (auVar != null && auVar.ciW()) {
            cf dH = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().dH(auVar.field_msgId);
            if (dH.field_msgId == auVar.field_msgId) {
                n nVar = new n(dH.field_content);
                if (!nVar.hVA) {
                    nVar.hVA = true;
                    auVar.setContent(nVar.hVz + ":" + nVar.time + ":" + (nVar.hVA ? 1 : 0) + "\n");
                    ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().a(auVar.field_msgId, auVar);
                }
            }
        }
    }

    public static int od(String str) {
        if (hXF.get(str) != null) {
            h hVar = (h) ((WeakReference) hXF.get(str)).get();
            if (hVar != null) {
                return (int) hVar.vy();
            }
        }
        return -1;
    }

    public static String Fl() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Dk();
        return stringBuilder.append(g.Dj().gQi).append("voice/").toString();
    }

    public static String Fm() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Dk();
        return stringBuilder.append(g.Dj().gQi).append("voice2/").toString();
    }
}
