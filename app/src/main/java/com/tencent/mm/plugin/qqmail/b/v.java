package com.tencent.mm.plugin.qqmail.b;

import android.util.Base64;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.f;
import com.tencent.mm.ae.k;
import com.tencent.mm.protocal.c.mu;
import com.tencent.mm.protocal.c.pc;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public final class v implements e {
    String fzO;
    String[] poM;
    String[] poN;
    String[] poO;
    String poi;
    Map<String, String> ppA = new HashMap();
    Map<String, String> ppB = new LinkedHashMap();
    Map<String, String> ppC = new LinkedHashMap();
    private b ppD;
    public t ppE;
    Map<String, String> ppF = new HashMap();
    f ppG = null;
    HashMap<Long, Integer> ppH = new HashMap();
    HashMap<Long, String> ppI = new HashMap();
    HashMap<String, Integer> ppJ = new HashMap();
    int ppK = 0;
    ArrayList<g> ppL = new ArrayList();
    String ppM = null;
    String ppN = null;
    HashMap<String, String> ppO = new HashMap();
    c ppP;
    d ppQ;
    int ppR = 0;
    f ppS = new 7(this);
    e ppx = null;
    String ppz;

    static /* synthetic */ void a(v vVar, HashMap hashMap) {
        if (vVar.ppF == null) {
            vVar.ppF = new HashMap();
        }
        for (Long l : hashMap.keySet()) {
            String str = (String) hashMap.get(l);
            String str2 = (String) vVar.ppA.get(String.valueOf(l));
            x.i("MicroMsg.ShareModeMailAppService", "appendDownloadImgToAttachIdMap, filePath: %s, attachId: %s", new Object[]{str2, str});
            if (!bh.ov(str2)) {
                vVar.ppF.put(str2, str);
            }
        }
    }

    public v() {
        ar.CG().a(483, this);
        ar.CG().a(484, this);
        ar.CG().a(485, this);
    }

    public final void va(int i) {
        if (this.ppG != null) {
            ag.y(new 1(this, i, 100));
        }
    }

    public final void a(f fVar, e eVar) {
        this.ppG = fVar;
        this.ppx = eVar;
        if (this.ppA.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : this.ppA.keySet()) {
                x.i("MicroMsg.ShareModeMailAppService", "check img status, msgSvrId: %s", new Object[]{str});
                arrayList.add(Long.valueOf(bh.getLong(str, 0)));
            }
            b 2 = new 2(this);
            x.i("MicroMsg.ShareModeMailAppService", "checkImgStatus");
            this.ppK = 0;
            L(arrayList);
            if (this.ppI != null) {
                this.ppI.clear();
                this.ppI = null;
            }
            this.ppI = new HashMap();
            this.ppD = 2;
            ar.CG().a(new l(arrayList), 0);
            return;
        }
        va(90);
        bko();
    }

    final void bko() {
        int i;
        int i2;
        k$a[] com_tencent_mm_plugin_qqmail_b_k_aArr;
        int i3;
        StringBuilder stringBuilder;
        String stringBuilder2;
        int i4 = 0;
        k$a[] com_tencent_mm_plugin_qqmail_b_k_aArr2 = null;
        if (this.ppB != null && this.ppB.size() > 0) {
            k$a[] com_tencent_mm_plugin_qqmail_b_k_aArr3 = new k$a[this.ppB.size()];
            int i5 = 0;
            i = 0;
            for (String str : this.ppB.keySet()) {
                k$a com_tencent_mm_plugin_qqmail_b_k_a = new k$a();
                com_tencent_mm_plugin_qqmail_b_k_a.poS = (String) this.ppB.get(str);
                com_tencent_mm_plugin_qqmail_b_k_a.fileName = str;
                com_tencent_mm_plugin_qqmail_b_k_a.name = (String) this.ppC.get(str);
                com_tencent_mm_plugin_qqmail_b_k_a.fileSize = com.tencent.mm.a.e.bN(str);
                com_tencent_mm_plugin_qqmail_b_k_aArr3[i] = com_tencent_mm_plugin_qqmail_b_k_a;
                x.i("MicroMsg.ShareModeMailAppService", "fileInfos[%d], attachId: %s, fileName: %s, name: %s, fileSize: %d", new Object[]{Integer.valueOf(i), com_tencent_mm_plugin_qqmail_b_k_a.poS, com_tencent_mm_plugin_qqmail_b_k_a.fileName, com_tencent_mm_plugin_qqmail_b_k_a.name, Integer.valueOf(com_tencent_mm_plugin_qqmail_b_k_a.fileSize)});
                i5 = com_tencent_mm_plugin_qqmail_b_k_a.fileSize + i5;
                i++;
            }
            i4 = i5;
            com_tencent_mm_plugin_qqmail_b_k_aArr2 = com_tencent_mm_plugin_qqmail_b_k_aArr3;
        }
        if (this.ppF == null || this.ppF.size() <= 0) {
            i2 = i4;
            com_tencent_mm_plugin_qqmail_b_k_aArr = null;
        } else {
            k$a[] com_tencent_mm_plugin_qqmail_b_k_aArr4 = new k$a[this.ppF.size()];
            i = i4;
            i3 = 0;
            for (String str2 : this.ppF.keySet()) {
                k$a com_tencent_mm_plugin_qqmail_b_k_a2 = new k$a();
                com_tencent_mm_plugin_qqmail_b_k_a2.poS = (String) this.ppF.get(str2);
                com_tencent_mm_plugin_qqmail_b_k_a2.fileName = str2;
                com_tencent_mm_plugin_qqmail_b_k_a2.fileSize = bh.a((Integer) this.ppJ.get(com_tencent_mm_plugin_qqmail_b_k_a2.poS), 0);
                if (com_tencent_mm_plugin_qqmail_b_k_a2.fileSize == 0) {
                    com_tencent_mm_plugin_qqmail_b_k_a2.fileSize = com.tencent.mm.a.e.bN(str2);
                }
                com_tencent_mm_plugin_qqmail_b_k_aArr4[i3] = com_tencent_mm_plugin_qqmail_b_k_a2;
                x.i("MicroMsg.ShareModeMailAppService", "imagesFileInfos[%d], attachId: %s, fileName: %s, fileSize: %d", new Object[]{Integer.valueOf(i3), com_tencent_mm_plugin_qqmail_b_k_a2.poS, com_tencent_mm_plugin_qqmail_b_k_a2.fileName, Integer.valueOf(com_tencent_mm_plugin_qqmail_b_k_a2.fileSize)});
                i = com_tencent_mm_plugin_qqmail_b_k_a2.fileSize + i;
                i3++;
            }
            com_tencent_mm_plugin_qqmail_b_k_aArr = com_tencent_mm_plugin_qqmail_b_k_aArr4;
            i2 = i;
        }
        x.i("MicroMsg.ShareModeMailAppService", "totalFileSize = %d", new Object[]{Integer.valueOf(i2)});
        k$a[] com_tencent_mm_plugin_qqmail_b_k_aArr5 = (com_tencent_mm_plugin_qqmail_b_k_aArr == null || com_tencent_mm_plugin_qqmail_b_k_aArr.length == 0) ? null : com_tencent_mm_plugin_qqmail_b_k_aArr;
        k$a[] com_tencent_mm_plugin_qqmail_b_k_aArr6 = (com_tencent_mm_plugin_qqmail_b_k_aArr2 == null || com_tencent_mm_plugin_qqmail_b_k_aArr2.length == 0) ? null : com_tencent_mm_plugin_qqmail_b_k_aArr2;
        a 5 = new 5(this);
        k kVar = new k(this.fzO, this.poM, this.poN, this.poO, this.poi);
        kVar.poP = this.ppz;
        if (com_tencent_mm_plugin_qqmail_b_k_aArr6 == null || com_tencent_mm_plugin_qqmail_b_k_aArr6.length <= 0) {
            kVar.poR = null;
        } else {
            kVar.poR = new k$a[com_tencent_mm_plugin_qqmail_b_k_aArr6.length];
            int i6;
            for (i6 = 0; i6 < kVar.poR.length; i6++) {
                kVar.poR[i6] = com_tencent_mm_plugin_qqmail_b_k_aArr6[i6];
            }
            x.i("MicroMsg.MailContentFormatter", "setFileInfo, fileInfos.length = %d", new Object[]{Integer.valueOf(kVar.poR.length)});
        }
        if (com_tencent_mm_plugin_qqmail_b_k_aArr5 == null || com_tencent_mm_plugin_qqmail_b_k_aArr5.length <= 0) {
            kVar.poQ = null;
        } else {
            kVar.poQ = com_tencent_mm_plugin_qqmail_b_k_aArr5;
        }
        StringBuilder stringBuilder3 = new StringBuilder("");
        StringBuilder stringBuilder4 = new StringBuilder("");
        if (kVar.fzO != null) {
            stringBuilder = new StringBuilder("");
            stringBuilder.append("From: ");
            stringBuilder.append("\"");
            stringBuilder.append("=?utf-8?B?");
            stringBuilder.append(Base64.encodeToString(kVar.fzO.getBytes(), 2));
            stringBuilder.append("?=");
            stringBuilder.append("\"");
            stringBuilder.append(" ");
            stringBuilder.append("<");
            stringBuilder.append(kVar.fzO);
            stringBuilder.append(">");
            stringBuilder2 = stringBuilder.toString();
        } else {
            stringBuilder2 = null;
        }
        if (stringBuilder2 != null) {
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append("\n");
        }
        stringBuilder2 = kVar.bkj();
        if (stringBuilder2 != null) {
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append("\n");
        }
        stringBuilder2 = kVar.bkk();
        if (stringBuilder2 != null) {
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append("\n");
        }
        stringBuilder2 = kVar.bkl();
        if (stringBuilder2 != null) {
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append("\n");
        }
        stringBuilder4.append("Subject: ");
        if (kVar.poi != null) {
            stringBuilder4.append(kVar.poi);
        }
        stringBuilder4.append("\n");
        stringBuilder4.append("Mime-Version: 1.0");
        stringBuilder4.append("\n");
        stringBuilder4.append("Content-Type: multipart/mixed;boundary=\"----=_NextPart_5208D22F_0929AFA8_5112E4AB\"");
        stringBuilder4.append("\n");
        stringBuilder4.append("Content-Transfer-Encoding: 8Bit");
        stringBuilder4.append("\n");
        stringBuilder4.append("Date: " + new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", new Locale("en")).format(new Date()));
        stringBuilder4.append("\n");
        stringBuilder4.append("X-QQ-MIME: TCMime 1.0 by Tencent");
        stringBuilder4.append("\n");
        stringBuilder4.append("X-Mailer: QQMail 2.x");
        stringBuilder4.append("\n");
        stringBuilder4.append("X-QQ-Mailer: QQMail 2.x");
        stringBuilder4.append("\n");
        stringBuilder3.append(stringBuilder4.toString());
        stringBuilder3.append("\r\n");
        stringBuilder3.append("This is a multi-part message in MIME format.");
        stringBuilder3.append("\n");
        stringBuilder3.append("\r\n");
        stringBuilder = new StringBuilder("");
        stringBuilder.append("------=_NextPart_5208D22F_0929AFA8_5112E4AB");
        stringBuilder.append("\n");
        stringBuilder.append("Content-Type:text/html;charset=\"utf-8\"");
        stringBuilder.append("\n");
        stringBuilder.append("Content-Transfer-Encoding:base64");
        stringBuilder.append("\n");
        stringBuilder.append("\r\n");
        stringBuilder.append(Base64.encodeToString(kVar.poP.getBytes(), 0));
        stringBuilder.append("\n");
        stringBuilder3.append(stringBuilder.toString());
        stringBuilder3.append("\r\n");
        if (kVar.poQ != null && kVar.poQ.length > 0) {
            for (k$a com_tencent_mm_plugin_qqmail_b_k_a3 : kVar.poQ) {
                String str3 = com_tencent_mm_plugin_qqmail_b_k_a3.poS;
                String str4 = com_tencent_mm_plugin_qqmail_b_k_a3.fileName;
                int i7 = com_tencent_mm_plugin_qqmail_b_k_a3.fileSize;
                StringBuilder stringBuilder5 = new StringBuilder("");
                stringBuilder5.append("------=_NextPart_5208D22F_0929AFA8_5112E4AB");
                stringBuilder5.append("\n");
                stringBuilder5.append(String.format("Content-Type:image/jpeg;name=\"%s\"", new Object[]{str4}));
                stringBuilder5.append("\n");
                stringBuilder5.append("Content-Transfer-Encoding:base64");
                stringBuilder5.append("\n");
                stringBuilder5.append(String.format("Content-ID:<%s>", new Object[]{str4}));
                stringBuilder5.append("\n");
                stringBuilder5.append("\r\n");
                stringBuilder5.append(String.format("QQMail-LinkID:%s", new Object[]{str3}));
                stringBuilder5.append("\n");
                stringBuilder5.append(String.format("QQMail-LinkSize:%d", new Object[]{Integer.valueOf(i7)}));
                stringBuilder5.append("\n");
                stringBuilder5.append("QQMail-LineLen:72");
                stringBuilder5.append("\n");
                stringBuilder5.append("QQMail-BreakType:1");
                stringBuilder5.append("\n");
                stringBuilder5.append(String.format("QQMail-Key:%s", new Object[]{k.HL(str3)}));
                stringBuilder5.append("\n");
                stringBuilder5.append("QQMail-LinkEnd");
                stringBuilder5.append("\n");
                stringBuilder3.append(stringBuilder5.toString());
                stringBuilder3.append("\r\n");
            }
        }
        stringBuilder3.append("\r\n");
        if (kVar.poR != null && kVar.poR.length > 0) {
            for (k$a com_tencent_mm_plugin_qqmail_b_k_a4 : kVar.poR) {
                String str5 = com_tencent_mm_plugin_qqmail_b_k_a4.poS;
                int i8 = com_tencent_mm_plugin_qqmail_b_k_a4.fileSize;
                String str6 = com_tencent_mm_plugin_qqmail_b_k_a4.name;
                StringBuilder stringBuilder6 = new StringBuilder("");
                stringBuilder6.append("------=_NextPart_5208D22F_0929AFA8_5112E4AB");
                stringBuilder6.append("\n");
                stringBuilder6.append(String.format("Content-Type:application/octet-stream;charset=\"utf-8\";name=\"=?utf-8?B?%s?=\"", new Object[]{Base64.encodeToString(str6.getBytes(), 2)}));
                stringBuilder6.append("\n");
                stringBuilder6.append(String.format("Content-Disposition: attachment; filename=\"=?utf-8?B?%s?=\"", new Object[]{Base64.encodeToString(str6.getBytes(), 2)}));
                stringBuilder6.append("\n");
                stringBuilder6.append("Content-Transfer-Encoding:base64");
                stringBuilder6.append("\n");
                stringBuilder6.append(String.format("Content-ID:<%s>", new Object[]{Long.valueOf(System.currentTimeMillis())}));
                stringBuilder6.append("\n");
                stringBuilder6.append("\r\n");
                stringBuilder6.append(String.format("QQMail-LinkID:%s", new Object[]{str5}));
                stringBuilder6.append("\n");
                stringBuilder6.append(String.format("QQMail-LinkSize:%d", new Object[]{Integer.valueOf(i8)}));
                stringBuilder6.append("\n");
                stringBuilder6.append("QQMail-LineLen:72");
                stringBuilder6.append("\n");
                stringBuilder6.append("QQMail-BreakType:1");
                stringBuilder6.append("\n");
                stringBuilder6.append(String.format("QQMail-Key:%s", new Object[]{k.HL(str5)}));
                stringBuilder6.append("\n");
                stringBuilder6.append("QQMail-LinkEnd");
                stringBuilder6.append("\n");
                stringBuilder3.append(stringBuilder6.toString());
                stringBuilder3.append("\r\n");
            }
        }
        stringBuilder3.append("------=_NextPart_5208D22F_0929AFA8_5112E4AB--");
        ar.CG().a(new m(stringBuilder3.toString(), this.fzO, this.poM, i2, new 8(this, 5)), 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.ShareModeMailAppService", "onSceneEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i != 0 || i2 != 0) {
            x.e("MicroMsg.ShareModeMailAppService", "errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            if (kVar.getType() == 483) {
                a((l) kVar);
            } else if (this.ppx != null) {
                ag.y(new 6(this));
            }
        } else if (kVar.getType() == 483) {
            a((l) kVar);
        } else if (kVar.getType() != 484) {
            kVar.getType();
        }
    }

    private void L(ArrayList<Long> arrayList) {
        if (this.ppH != null) {
            this.ppH.clear();
            this.ppH = null;
        }
        this.ppH = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.ppH.put(Long.valueOf(((Long) it.next()).longValue()), Integer.valueOf(1));
        }
    }

    private static ArrayList<Long> m(HashMap<Long, Integer> hashMap) {
        ArrayList<Long> arrayList = new ArrayList();
        for (Long add : hashMap.keySet()) {
            arrayList.add(add);
        }
        return arrayList;
    }

    private void a(l lVar) {
        this.ppK++;
        x.i("MicroMsg.ShareModeMailAppService", "processCheckImgStatusSceneEnd, checkTimes: %d", new Object[]{Integer.valueOf(this.ppK)});
        Iterator it = ((mu) lVar.gJQ.hmh.hmo).vVx.iterator();
        while (it.hasNext()) {
            pc pcVar = (pc) it.next();
            long j = (long) pcVar.vGW;
            int i = pcVar.ktm;
            if (this.ppH.containsKey(Long.valueOf(j))) {
                x.i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, status: %d", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
                if (i == 0) {
                    this.ppH.remove(Long.valueOf(j));
                    if (pcVar.vYg != null) {
                        x.i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, attachId: %s", new Object[]{Long.valueOf(j), pcVar.vYg});
                        this.ppI.put(Long.valueOf(j), pcVar.vYg);
                        this.ppJ.put(pcVar.vYg, Integer.valueOf(pcVar.vYh));
                    }
                } else {
                    this.ppH.put(Long.valueOf(j), Integer.valueOf(i));
                }
            }
        }
        if (this.ppH.isEmpty()) {
            x.i("MicroMsg.ShareModeMailAppService", "all image is in server");
            if (this.ppD != null) {
                this.ppD.a(new ArrayList(), this.ppI);
            }
        } else if (this.ppK < 3) {
            x.i("MicroMsg.ShareModeMailAppService", "checkTime small than limit, doScene again");
            ar.CG().a(new l(m(this.ppH)), 0);
        } else {
            this.ppD.a(m(this.ppH), this.ppI);
        }
    }
}
