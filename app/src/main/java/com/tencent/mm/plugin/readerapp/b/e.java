package com.tencent.mm.plugin.readerapp.b;

import com.tencent.mm.R;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.r.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bf;
import com.tencent.mm.z.c;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public final class e implements f {
    public static e pAA = new e();

    private e() {
    }

    public final void a(int i, Map<String, bw> map, boolean z) {
        x.i("MicroMsg.ReaderFuncMsgUpdateMgr", "onFunctionMsgUpdate, op: %s, msgIdMap.size: %s, needUpdateTime: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(map.size()), Boolean.valueOf(z)});
        for (String str : map.keySet()) {
            bw bwVar = (bw) map.get(str);
            List<bf> a = a(bwVar, str);
            if (a != null) {
                long j = ((long) bwVar.pbl) * 1000;
                if (!(a == null || a.size() == 0)) {
                    x.i("MicroMsg.ReaderFuncMsgUpdateMgr", "processInfoList, op: %s, infoList.size: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(a.size())});
                    bf bfVar;
                    if (i == 1) {
                        for (bf bfVar2 : a) {
                            x.i("MicroMsg.ReaderFuncMsgUpdateMgr", "delete info, functionMsgId: %s", new Object[]{bfVar2.HN()});
                            g.bmp().a(bfVar2.HN(), bfVar2.type, true, true);
                        }
                    } else if (i == 0) {
                        bf bfVar3 = null;
                        List<bf> H = g.bmp().H(str, ((bf) a.get(0)).type);
                        bf bfVar4 = null;
                        x.i("MicroMsg.ReaderFuncMsgUpdateMgr", "update info, functionMsgId: %s, oldInfoList: %s", new Object[]{str, H});
                        Object obj = null;
                        int i2 = 0;
                        int i3 = 0;
                        for (bf bfVar5 : a) {
                            if (bfVar3 == null) {
                                i3 = bfVar5.type;
                                bfVar5.hhk = 1;
                                bfVar3 = bfVar5;
                            }
                            if (H == null) {
                                x.i("MicroMsg.ReaderFuncMsgUpdateMgr", "update info, insert new msg, functionMsgId: %s", new Object[]{bfVar5.HN()});
                                i2++;
                                g.bmp().a(bfVar5);
                            } else {
                                int i4;
                                Object obj2;
                                if (z) {
                                    bfVar5.time = j;
                                    if (bfVar3 != null) {
                                        bfVar3.time = j;
                                    }
                                    i4 = i2 + 1;
                                } else {
                                    if (bfVar4 == null) {
                                        bfVar2 = (bf) H.get(0);
                                        bfVar4 = bfVar2;
                                        for (bf bfVar22 : H) {
                                            if (bfVar22.hhk != 1) {
                                                bfVar22 = bfVar4;
                                            }
                                            bfVar4 = bfVar22;
                                        }
                                    }
                                    bfVar5.time = bfVar4.time;
                                    if (bfVar3 != null) {
                                        bfVar3.time = bfVar4.time;
                                    }
                                    i4 = i2;
                                }
                                x.i("MicroMsg.ReaderFuncMsgUpdateMgr", "update info, update the exist one, functionMsgId: %s, time: %s", new Object[]{bfVar5.HN(), Long.valueOf(bfVar5.time)});
                                if (obj == null) {
                                    g.bmp().a(bfVar5.HN(), bfVar5.type, false, false);
                                    obj2 = 1;
                                } else {
                                    obj2 = obj;
                                }
                                g.bmp().a(bfVar5);
                                obj = obj2;
                                i2 = i4;
                            }
                        }
                        if (i2 > 0) {
                            ar.Hg();
                            aj WY = c.Fd().WY(bf.gT(i3));
                            if (WY == null || !WY.field_username.equals(bf.gT(i3))) {
                                ae aeVar = new ae();
                                aeVar.setUsername(bf.gT(i3));
                                aeVar.setContent(bfVar3 == null ? "" : bfVar3.getTitle());
                                aeVar.aj(bfVar3 == null ? bh.Wp() : bfVar3.time);
                                aeVar.eR(0);
                                aeVar.eO(1);
                                ar.Hg();
                                c.Fd().d(aeVar);
                            } else {
                                WY.aj(bfVar3.time);
                                WY.eR(0);
                                if (!(bh.ov(bfVar3.getTitle()) || bfVar3.getTitle().equals(WY.field_content)) || WY.field_unReadCount == 0) {
                                    WY.setContent(bfVar3.getTitle());
                                    WY.eO(WY.field_unReadCount + 1);
                                }
                                ar.Hg();
                                c.Fd().a(WY, bf.gT(i3));
                            }
                        }
                        g.bmp().doNotify();
                    }
                }
            }
        }
    }

    private static List<bf> a(bw bwVar, String str) {
        String trim = n.a(bwVar.vGZ).trim();
        if (trim.indexOf("<") != -1) {
            trim = trim.substring(trim.indexOf("<"));
        }
        long j = ((long) bwVar.pbl) * 1000;
        x.d("MicroMsg.ReaderFuncMsgUpdateMgr", "parseMsg, createTime: %s, content: %s", new Object[]{Integer.valueOf(bwVar.pbl), trim});
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
        List<bf> arrayList = new ArrayList();
        try {
            Map y = bi.y(trim, "mmreader");
            int i = 0;
            while (i <= 0) {
                String str2 = ".mmreader.category" + (i > 0 ? Integer.valueOf(i) : "");
                int i2 = bh.getInt((String) y.get(str2 + ".$type"), 0);
                if (i2 != 0) {
                    if (i2 != 20 && i2 != 11) {
                        x.e("MicroMsg.ReaderFuncMsgUpdateMgr", "get " + str2 + ".$type  error Type:" + i2);
                        break;
                    }
                    trim = (String) y.get(str2 + ".name");
                    if (bh.ov(trim)) {
                        x.e("MicroMsg.ReaderFuncMsgUpdateMgr", "get " + str2 + ".name  error");
                        break;
                    }
                    String str3 = (String) y.get(str2 + ".topnew.cover");
                    String str4 = (String) y.get(str2 + ".topnew.digest");
                    int i3 = bh.getInt((String) y.get(str2 + ".$count"), 0);
                    if (i3 == 0) {
                        x.e("MicroMsg.ReaderFuncMsgUpdateMgr", "get " + str2 + ".$count  error");
                        break;
                    }
                    if (i3 > 1) {
                        str2 = str2 + (i2 == 20 ? ".newitem" : ".item");
                    } else {
                        str2 = str2 + ".item";
                    }
                    int i4 = 0;
                    while (i4 < i3) {
                        String str5 = str2 + (i4 > 0 ? Integer.valueOf(i4) : "");
                        bf bfVar = new bf();
                        bfVar.aL((long) bwVar.vGW);
                        bfVar.title = (String) y.get(str5 + ".title");
                        if (i4 == 0) {
                            bfVar.hhk = 1;
                            bfVar.hed = str3;
                            bfVar.hef = bh.ov(str4) ? (String) y.get(str5 + ".digest") : str4;
                        } else {
                            bfVar.hed = (String) y.get(str5 + ".cover");
                            bfVar.hef = (String) y.get(str5 + ".digest");
                        }
                        bfVar.hhl = y.containsKey(new StringBuilder().append(str5).append(".vedio").toString()) ? 1 : 0;
                        bfVar.url = (String) y.get(str5 + ".url");
                        bfVar.hhf = (String) y.get(str5 + ".shorturl");
                        bfVar.hhg = (String) y.get(str5 + ".longurl");
                        bfVar.hhh = bh.getLong((String) y.get(str5 + ".pub_time"), 0);
                        String str6 = (String) y.get(str5 + ".tweetid");
                        if (str6 == null || "".equals(str6)) {
                            str6 = "N" + simpleDateFormat.format(new Date(System.currentTimeMillis() + ((long) i4)));
                            x.d("MicroMsg.ReaderFuncMsgUpdateMgr", "create tweetID = " + str6);
                        }
                        bfVar.hhe = str6;
                        bfVar.hhi = (String) y.get(str5 + ".sources.source.name");
                        bfVar.hhj = (String) y.get(str5 + ".sources.source.icon");
                        bfVar.time = ((long) i) + j;
                        bfVar.type = i2;
                        bfVar.name = trim;
                        bfVar.hhn = str;
                        arrayList.add(bfVar);
                        String[] strArr = new Object[2];
                        strArr[0] = com.tencent.mm.pluginsdk.h.n.ag(ac.getContext().getString(R.l.eiw), bfVar.hhh);
                        strArr[1] = com.tencent.mm.pluginsdk.h.n.c(ac.getContext(), bfVar.time, false);
                        x.d("MicroMsg.ReaderFuncMsgUpdateMgr", "parse info, pubtime: %s, time: %s", strArr);
                        i4++;
                    }
                    i++;
                } else {
                    x.e("MicroMsg.ReaderFuncMsgUpdateMgr", "get " + str2 + ".$type  error");
                    break;
                }
            }
            return arrayList;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ReaderFuncMsgUpdateMgr", e, "", new Object[0]);
            x.e("MicroMsg.ReaderFuncMsgUpdateMgr", "parseMsg error: %s", new Object[]{e.getMessage()});
            return null;
        }
    }
}
