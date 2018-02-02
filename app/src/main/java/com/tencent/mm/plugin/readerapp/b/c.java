package com.tencent.mm.plugin.readerapp.b;

import com.tencent.mm.ae.d;
import com.tencent.mm.ae.d.a;
import com.tencent.mm.ae.d.b;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bf;
import com.tencent.mm.z.q;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public final class c implements d {
    public final b b(a aVar) {
        int i;
        Throwable th;
        int i2;
        bw bwVar = aVar.hmq;
        if (bwVar == null) {
            x.e("MicroMsg.ReaderAppMsgExtension", "onPreAddMessage cmdAM is null");
            return null;
        }
        Object valueOf;
        int i3;
        String str;
        g.bmp().aM((long) bwVar.vGW);
        String a = n.a(bwVar.vGZ);
        long Wp = bh.Wp();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
        int i4 = 0;
        List<bf> arrayList = new ArrayList();
        int i5 = 0;
        try {
            Map y = bi.y(a, "mmreader");
            i4 = 0;
            i = 0;
            while (i4 <= 0) {
                StringBuilder stringBuilder = new StringBuilder(".mmreader.category");
                if (i4 > 0) {
                    valueOf = Integer.valueOf(i4);
                } else {
                    try {
                        valueOf = "";
                    } catch (Throwable e) {
                        th = e;
                        i2 = i;
                        i = i4;
                    }
                }
                String stringBuilder2 = stringBuilder.append(valueOf).toString();
                i5 = bh.getInt((String) y.get(stringBuilder2 + ".$type"), 0);
                if (i5 != 0) {
                    if (i5 != 20 && i5 != 11) {
                        x.e("MicroMsg.ReaderAppMsgExtension", "get " + stringBuilder2 + ".$type  error Type:" + i5);
                        i3 = i4;
                        break;
                    }
                    a = (String) y.get(stringBuilder2 + ".name");
                    if (bh.ov(a)) {
                        x.e("MicroMsg.ReaderAppMsgExtension", "get " + stringBuilder2 + ".name  error");
                        i = i5;
                        i3 = i4;
                        break;
                    }
                    String str2 = (String) y.get(stringBuilder2 + ".topnew.cover");
                    str = (String) y.get(stringBuilder2 + ".topnew.digest");
                    int i6 = bh.getInt((String) y.get(stringBuilder2 + ".$count"), 0);
                    if (i6 == 0) {
                        x.e("MicroMsg.ReaderAppMsgExtension", "get " + stringBuilder2 + ".$count  error");
                        i = i5;
                        i3 = i4;
                        break;
                    }
                    if (i6 > 1) {
                        stringBuilder2 = stringBuilder2 + (i5 == 20 ? ".newitem" : ".item");
                    } else {
                        stringBuilder2 = stringBuilder2 + ".item";
                    }
                    int i7 = 0;
                    while (i7 < i6) {
                        String str3 = stringBuilder2 + (i7 > 0 ? Integer.valueOf(i7) : "");
                        bf bfVar = new bf();
                        bfVar.aL((long) bwVar.vGW);
                        bfVar.title = (String) y.get(str3 + ".title");
                        if (i7 == 0) {
                            long j = bh.getLong((String) y.get(str3 + ".pub_time"), 0);
                            if (j > 0) {
                                Wp = 1000 * j;
                            }
                            bfVar.hhk = 1;
                            bfVar.hed = str2;
                            bfVar.hef = bh.ov(str) ? (String) y.get(str3 + ".digest") : str;
                        } else {
                            bfVar.hed = (String) y.get(str3 + ".cover");
                            bfVar.hef = (String) y.get(str3 + ".digest");
                        }
                        bfVar.hhl = y.containsKey(new StringBuilder().append(str3).append(".vedio").toString()) ? 1 : 0;
                        bfVar.url = (String) y.get(str3 + ".url");
                        bfVar.hhf = (String) y.get(str3 + ".shorturl");
                        bfVar.hhg = (String) y.get(str3 + ".longurl");
                        bfVar.hhh = bh.getLong((String) y.get(str3 + ".pub_time"), 0);
                        String str4 = (String) y.get(str3 + ".tweetid");
                        if (str4 == null || "".equals(str4)) {
                            str4 = "N" + simpleDateFormat.format(new Date(System.currentTimeMillis() + ((long) i7)));
                            x.d("MicroMsg.ReaderAppMsgExtension", "create tweetID = " + str4);
                        }
                        bfVar.hhe = str4;
                        bfVar.hhi = (String) y.get(str3 + ".sources.source.name");
                        bfVar.hhj = (String) y.get(str3 + ".sources.source.icon");
                        bfVar.time = ((long) i4) + Wp;
                        bfVar.type = i5;
                        bfVar.name = a;
                        arrayList.add(bfVar);
                        i7++;
                    }
                    i4++;
                    i = i5;
                } else {
                    x.e("MicroMsg.ReaderAppMsgExtension", "get " + stringBuilder2 + ".$type  error");
                    i3 = i4;
                    break;
                }
            }
            i3 = i4;
        } catch (Throwable e2) {
            th = e2;
            i = i4;
            i2 = i5;
        }
        x.d("MicroMsg.ReaderAppMsgExtension", "type = " + i + ", want to receive news? " + bmn());
        for (bf bfVar2 : arrayList) {
            bf bfVar22;
            if (bh.ov(bfVar22.getTitle())) {
                if (bh.ov(bfVar22.getUrl())) {
                    x.e("MicroMsg.ReaderAppMsgExtension", "readerAppInfo.getUrl() is null, appInfo.tweetid = " + bfVar22.HH() + ", type = " + bfVar22.type);
                    valueOf = null;
                    break;
                }
            }
            x.e("MicroMsg.ReaderAppMsgExtension", "readerAppInfo.getTitle() is null, appInfo.tweetid = " + bfVar22.HH() + ", type = " + bfVar22.type);
            valueOf = null;
            break;
        }
        i2 = 1;
        if (arrayList.size() > 0 || r4 == null) {
            return null;
        }
        int i8 = 0;
        bf bfVar3 = null;
        i5 = 0;
        while (i5 < arrayList.size()) {
            int i9;
            if (g.bmp().a((bf) arrayList.get(i5))) {
                if (bfVar3 == null) {
                    bfVar22 = (bf) arrayList.get(i5);
                    bfVar22.hhk = 1;
                } else {
                    bfVar22 = bfVar3;
                }
                i9 = i8 + 1;
            } else {
                bfVar22 = bfVar3;
                i9 = i8;
            }
            i5++;
            i8 = i9;
            bfVar3 = bfVar22;
        }
        if (i8 > 0) {
            ar.Hg();
            aj WY = com.tencent.mm.z.c.Fd().WY(bf.gT(i));
            if (WY == null || !WY.field_username.equals(bf.gT(i))) {
                ae aeVar = new ae();
                aeVar.setUsername(bf.gT(i));
                aeVar.setContent(bfVar3 == null ? "" : bfVar3.getTitle());
                aeVar.aj(bfVar3 == null ? bh.Wp() : bfVar3.time);
                aeVar.eR(0);
                aeVar.eO(i3);
                ar.Hg();
                com.tencent.mm.z.c.Fd().d(aeVar);
            } else {
                WY.setContent(bfVar3.getTitle());
                WY.aj(bfVar3.time);
                WY.eR(0);
                WY.eO(i3 + WY.field_unReadCount);
                ar.Hg();
                com.tencent.mm.z.c.Fd().a(WY, bf.gT(i));
            }
            g.bmp().doNotify();
            str = bfVar3.getTitle();
            au auVar = new au();
            auVar.setContent(str);
            auVar.dS(bf.gT(i));
            auVar.setType(1);
            auVar.ao(7377812);
            return new b(auVar, true);
        }
        x.e("MicroMsg.ReaderAppMsgExtension", "insert error");
        return null;
        x.printErrStackTrace("MicroMsg.ReaderAppMsgExtension", th, "", new Object[0]);
        i3 = i;
        i = i2;
        x.d("MicroMsg.ReaderAppMsgExtension", "type = " + i + ", want to receive news? " + bmn());
        for (bf bfVar222 : arrayList) {
            if (bh.ov(bfVar222.getTitle())) {
                if (bh.ov(bfVar222.getUrl())) {
                    x.e("MicroMsg.ReaderAppMsgExtension", "readerAppInfo.getUrl() is null, appInfo.tweetid = " + bfVar222.HH() + ", type = " + bfVar222.type);
                    valueOf = null;
                    break;
                }
            }
            x.e("MicroMsg.ReaderAppMsgExtension", "readerAppInfo.getTitle() is null, appInfo.tweetid = " + bfVar222.HH() + ", type = " + bfVar222.type);
            valueOf = null;
            break;
        }
        i2 = 1;
        if (arrayList.size() > 0) {
        }
        return null;
    }

    public static boolean bmn() {
        return (q.FY() & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == 0;
    }

    public final void h(au auVar) {
    }
}
