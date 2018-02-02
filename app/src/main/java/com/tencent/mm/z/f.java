package com.tencent.mm.z;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.Base64;
import com.tencent.mm.R;
import com.tencent.mm.ae.d;
import com.tencent.mm.ae.d.b;
import com.tencent.mm.ae.d.c;
import com.tencent.mm.ag.a.e;
import com.tencent.mm.ag.y;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.d.w;
import com.tencent.mm.g.a.hz;
import com.tencent.mm.g.a.io;
import com.tencent.mm.g.a.mj;
import com.tencent.mm.g.a.nz;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.k.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.anr;
import com.tencent.mm.protocal.c.aud;
import com.tencent.mm.protocal.c.aue;
import com.tencent.mm.protocal.c.auf;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.r.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.au;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class f implements l {
    private long heV = -1;
    public a heW;

    public interface a {
        void cD(String str);
    }

    public final b a(String str, Map<String, String> map, com.tencent.mm.ae.d.a aVar) {
        String str2;
        String str3;
        String str4;
        int i;
        ae WY;
        String str5;
        au auVar;
        int i2;
        int i3;
        String str6;
        int i4;
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_anr;
        int i5;
        bw bwVar = aVar.hmq;
        String a = n.a(bwVar.vGZ);
        b bVar = null;
        if (str != null) {
            if (str.equals("addcontact")) {
                bwVar.vGZ = n.os((String) map.get(".sysmsg.addcontact.content"));
                bwVar.ngq = 1;
                d aU = c.aU(Integer.valueOf(1));
                bVar = aU == null ? null : aU.b(aVar);
            }
        }
        if (str != null) {
            if (str.equals("dynacfg")) {
                g.zY().a(a, map, false);
                g.zZ();
                if (com.tencent.mm.k.c.zJ() == 2) {
                    com.tencent.mm.plugin.report.service.g.pQN.k(10879, "");
                }
                x.d("MicroMsg.BigBallSysCmdMsgConsumer", "Mute_Room_Disable:" + Integer.toString(bh.getInt(g.zY().getValue("MuteRoomDisable"), 0)));
            }
        }
        if (str != null) {
            if (str.equals("dynacfg_split")) {
                g.zY().a(a, map, true);
            }
        }
        if (str != null) {
            if (str.equals("banner")) {
                str2 = (String) map.get(".sysmsg.mainframebanner.$type");
                str3 = (String) map.get(".sysmsg.mainframebanner.showtype");
                str4 = (String) map.get(".sysmsg.mainframebanner.data");
                if (str2 != null && str2.length() > 0) {
                    try {
                        az.Hs().a(new ay(Integer.valueOf(str2).intValue(), Integer.valueOf(str3).intValue(), str4));
                    } catch (Exception e) {
                        x.e("MicroMsg.BigBallSysCmdMsgConsumer", e.toString());
                    }
                }
                str3 = (String) map.get(".sysmsg.friendrecommand.touser");
                if (!(((String) map.get(".sysmsg.friendrecommand.fromuser")) == null || str3 == null)) {
                    try {
                        ar.Hg().FF().a(str3, true, null);
                    } catch (Exception e2) {
                        x.e("MicroMsg.BigBallSysCmdMsgConsumer", e2.toString());
                    }
                }
                str2 = (String) map.get(".sysmsg.banner.securitybanner.chatname");
                str3 = (String) map.get(".sysmsg.banner.securitybanner.wording");
                str4 = (String) map.get(".sysmsg.banner.securitybanner.showtype");
                if (!(bh.ov(str2) || bh.ov(str4))) {
                    try {
                        boolean z;
                        if (str4.equals("1")) {
                            z = true;
                        } else {
                            z = false;
                        }
                        ar.Hg().FG().a(str2, z, new String[]{str3});
                    } catch (Exception e22) {
                        x.e("MicroMsg.BigBallSysCmdMsgConsumer", "[oneliang]" + e22.toString());
                    }
                }
                ar.Hg().FH().p(map);
            }
        }
        if (!bh.ov(str)) {
            if (str.equals("midinfo")) {
                str2 = (String) map.get(".sysmsg.midinfo.json_buffer");
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "QueryMid time[%s] json[%s]  [%s] ", (String) map.get(".sysmsg.midinfo.time_interval"), str2, a);
                i = bh.getInt(str3, 0);
                if (((long) i) > 86400 && ((long) i) < 864000) {
                    ar.Hg();
                    c.CU().set(331777, Long.valueOf(bh.Wo() + ((long) i)));
                }
                if (!bh.ov(str2)) {
                    com.tencent.mm.plugin.report.b.d.Iw(str2);
                }
            }
        }
        if (str != null) {
            if (str.equals("revokemsg")) {
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "mm hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
                str2 = (String) map.get(".sysmsg.revokemsg.session");
                str4 = (String) map.get(".sysmsg.revokemsg.replacemsg");
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "ashutest::[oneliang][xml parse] ,msgId:%s,replaceMsg:%s ", (String) map.get(".sysmsg.revokemsg.newmsgid"), str4);
                long j = 0;
                try {
                    j = bh.getLong((String) map.get(".sysmsg.revokemsg.newmsgid"), 0);
                    ar.Hg();
                    au F = c.Fa().F(str2, j);
                    au ae = au.ae(F);
                    if ((F.gjE & 4) != 4) {
                        F.setContent(str4);
                        F.setType(10000);
                        ba.a(F, aVar);
                        ar.Hg();
                        c.Fa().a(F.field_msgId, F);
                    }
                    ar.Hg();
                    WY = c.Fd().WY(F.field_talker);
                    if (WY != null && WY.field_unReadCount > 0) {
                        ar.Hg();
                        if (WY.field_unReadCount >= c.Fa().P(F)) {
                            WY.eO(WY.field_unReadCount - 1);
                            ar.Hg();
                            c.Fd().a(WY, WY.field_username);
                        }
                    }
                    if (aVar != null && aVar.hmr) {
                        com.tencent.mm.sdk.e.c aoVar = new ao();
                        aoVar.field_originSvrId = j;
                        if (F.field_msgId == 0) {
                            x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke but msg id is 0 originSvrId[%d]", Long.valueOf(j));
                            aoVar.field_content = a;
                            aoVar.field_createTime = (long) bwVar.pbl;
                            aoVar.field_flag = ba.c(aVar);
                            aoVar.field_fromUserName = n.a(bwVar.vGX);
                            aoVar.field_toUserName = n.a(bwVar.vGY);
                            aoVar.field_newMsgId = bwVar.vHe;
                            x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr insert ret[%b], systemRowid[%d]", Boolean.valueOf(ar.Hg().FK().b(aoVar)), Long.valueOf(aoVar.xjy));
                            return null;
                        }
                        x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and has done delete info, originSvrId[%d]", Long.valueOf(j));
                        ar.Hg().FK().a(aoVar, true, new String[0]);
                        ar.Hg();
                        c.Fa().dL(j);
                        if (!(WY == null || aVar.hmq == null || WY.field_lastSeq != ((long) aVar.hmq.vHf))) {
                            x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and fix fault lastseq[%s], firstUnDeliverSeq[%s]", Long.valueOf(WY.field_lastSeq), Long.valueOf(WY.field_firstUnDeliverSeq));
                            ar.Hg();
                            cf Ey = c.Fa().Ey(WY.field_username);
                            if (Ey != null) {
                                WY.al(Ey.field_msgSeq);
                                ar.Hg();
                                int a2 = c.Fd().a(WY, WY.field_username);
                                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and fix fault by [%s, %s] lastseq[%s], firstUnDeliverSeq[%s], update[%s]", Long.valueOf(Ey.field_msgSvrId), Long.valueOf(Ey.field_msgSeq), Long.valueOf(WY.field_lastSeq), Long.valueOf(WY.field_firstUnDeliverSeq), Integer.valueOf(a2));
                            }
                        }
                    }
                    if (F.field_msgId == 0 && (aVar == null || !aVar.hmr)) {
                        x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summer revoke msg id is 0 and svrid[%d]", Long.valueOf(j));
                        ar.Hg();
                        c.Fa().dL(j);
                    }
                    com.tencent.mm.sdk.b.b nzVar = new nz();
                    nzVar.fFS.fqm = F.vZ();
                    nzVar.fFS.fFT = str4;
                    nzVar.fFS.fEJ = F;
                    nzVar.fFS.fFU = ae;
                    nzVar.fFS.fFV = j;
                    com.tencent.mm.sdk.b.a.xef.m(nzVar);
                    if (ae != null) {
                        com.tencent.mm.kernel.g.Dm().F(new 2(this, ae));
                    }
                } catch (Throwable e3) {
                    long j2 = j;
                    x.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e3, "[oneliang][revokeMsg] msgId:%d,error:%s", Long.valueOf(j2), e3.toString());
                }
                return null;
            }
        }
        if (str != null) {
            if (str.equals("clouddelmsg")) {
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "mm hit MM_DATA_SYSCMD_NEWXML_CLOUD_DEL_MSG");
                str2 = (String) map.get(".sysmsg.clouddelmsg.delcommand");
                str3 = (String) map.get(".sysmsg.clouddelmsg.msgid");
                str4 = (String) map.get(".sysmsg.clouddelmsg.fromuser");
                int indexOf = a.indexOf("<msg>");
                int indexOf2 = a.indexOf("</msg>");
                if (indexOf == -1 || indexOf2 == -1) {
                    str5 = "";
                } else {
                    str5 = ax.at(bi.y(a.substring(indexOf, indexOf2 + 6), "msg"));
                }
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], delcommand:%s, msgid:%s, fromuser:%s, sysmsgcontent:%s", str2, str3, str4, str5);
                try {
                    ar.Hg();
                    LinkedList dn = c.Fa().dn(str4, str3);
                    if (dn == null || dn.size() <= 0) {
                        x.e("MicroMsg.BigBallSysCmdMsgConsumer", "get null by getByBizClientMsgId");
                        return null;
                    }
                    Iterator it = dn.iterator();
                    while (it.hasNext()) {
                        auVar = (au) it.next();
                        if (auVar == null) {
                            x.e("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], msgInfo == null");
                        } else if (auVar.wa() < 0) {
                            x.e("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], invalid msgInfo.msgId = %s, srvId = %s", Long.valueOf(auVar.vZ()), Long.valueOf(auVar.wa()));
                        } else {
                            x.i("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], msgInfo.msgId = %s, srvId = %s", Long.valueOf(auVar.vZ()), Long.valueOf(auVar.wa()));
                            i2 = bh.getInt(str2, 0);
                            if (i2 == 1) {
                                ar.Hg();
                                c.Fa().M(auVar.wd(), auVar.wa());
                            } else if (i2 == 2 && auVar.ciV()) {
                                auVar.setContent(str5);
                                ba.a(auVar, aVar);
                                ar.Hg();
                                c.Fa().b(auVar.wa(), auVar);
                                ar.Hg();
                                ae WY2 = c.Fd().WY(auVar.wd());
                                if (WY2 != null && WY2.vU() > 0) {
                                    ar.Hg();
                                    if (WY2.vU() >= c.Fa().P(auVar)) {
                                        WY2.eO(WY2.vU() - 1);
                                        ar.Hg();
                                        c.Fd().a(WY2, WY2.getUsername());
                                    }
                                }
                            }
                            com.tencent.mm.sdk.b.b nzVar2 = new nz();
                            nzVar2.fFS.fqm = auVar.vZ();
                            nzVar2.fFS.fFT = str5;
                            nzVar2.fFS.fEJ = auVar;
                            com.tencent.mm.sdk.b.a.xef.m(nzVar2);
                        }
                    }
                    return null;
                } catch (Throwable e32) {
                    x.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e32, "[hakon][clouddelmsg], BizClientMsgId:%d,error:%s", str3, e32.toString());
                }
            }
        }
        if (str != null) {
            if (str.equals("updatepackage")) {
                aU = c.aU(Integer.valueOf(-1879048175));
                if (aU == null) {
                    bVar = null;
                } else {
                    bVar = aU.b(aVar);
                }
            }
        }
        if (str != null) {
            if (str.equals("deletepackage")) {
                aU = c.aU(Integer.valueOf(-1879048174));
                if (aU == null) {
                    bVar = null;
                } else {
                    bVar = aU.b(aVar);
                }
            }
        }
        if (str != null) {
            if (str.equals("delchatroommember")) {
                str3 = n.a(bwVar.vGX);
                ar.Hg();
                auVar = c.Fa().F(str3, bwVar.vHe);
                Object obj = null;
                if (auVar.vZ() > 0) {
                    obj = 1;
                }
                auVar.ap(bwVar.vHe);
                if (!(aVar != null && aVar.hmr && aVar.hmt)) {
                    auVar.aq(ba.n(str3, (long) bwVar.pbl));
                }
                auVar.setType(10002);
                auVar.setContent(a);
                auVar.eR(0);
                auVar.dS(str3);
                auVar.dY(bwVar.vHc);
                ba.a(auVar, aVar);
                if (obj == null) {
                    ba.i(auVar);
                } else {
                    ar.Hg();
                    c.Fa().b(bwVar.vHe, auVar);
                }
            }
        }
        if (str != null) {
            if (str.equals("WakenPush") && this.heV != bwVar.vHe) {
                this.heV = bwVar.vHe;
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "dzmonster[subType wakenpush]");
                bz bzVar = new bz(map);
                String str7 = (String) bzVar.hdK.get(".sysmsg.WakenPush.PushContent");
                str3 = (String) bzVar.hdK.get(".sysmsg.WakenPush.Jump");
                str2 = (String) bzVar.hdK.get(".sysmsg.WakenPush.ExpiredTime");
                String str8 = (String) bzVar.hdK.get(".sysmsg.WakenPush.Username");
                x.d("MicroMsg.WakenPushMsgExtension", "dzmonster[xml parse of wakenpush,pushContent:%s, jump:%s, expiredTime %s]", str7, str3, str2);
                str2 = g.zY().getValue("WakenPushDeepLinkBitSet");
                x.d("MicroMsg.WakenPushMsgExtension", "dzmonster[config of WakenPushDeepLinkBitSet:%s", str2);
                j2 = !bh.ov(str2) ? bh.getLong(str2, 0) : 0;
                Bitmap iV = com.tencent.mm.ad.b.iV(str8);
                aj notification = ar.getNotification();
                if (bh.ov(str3)) {
                    x.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[url is null]");
                    str4 = "com.tencent.mm.ui.LauncherUI";
                } else if ((4 & j2) == 4 && str3.startsWith("weixin://dl/moments")) {
                    str4 = "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI";
                } else if ((j2 & HardCoderJNI.ACTION_NET_TX) == HardCoderJNI.ACTION_NET_TX && str3.startsWith("weixin://dl/recommendation")) {
                    str4 = "com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI";
                } else {
                    x.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[unable to deal with the deep link:%s)", str3);
                    str4 = "com.tencent.mm.ui.LauncherUI";
                }
                Intent intent = new Intent();
                intent.setClassName(ac.getContext(), str4);
                intent.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                intent.putExtra("LauncherUI.Show.Update.DialogMsg", (String) bzVar.hdK.get(".sysmsg.WakenPush.PushContent"));
                if (!str3.equals("weixin://dl/update_newest_version")) {
                    intent.putExtra("LauncherUI.Show.Update.Url", (String) bzVar.hdK.get(".sysmsg.WakenPush.Jump"));
                }
                com.tencent.mm.plugin.report.service.g.pQN.a(405, 32, 1, true);
                Notification a3 = notification.a(PendingIntent.getActivity(ac.getContext(), UUID.randomUUID().hashCode(), intent, 134217728), ac.getContext().getString(R.l.app_name), str7, str7, iV, str8);
                a3.flags |= 16;
                ar.getNotification().a(a3, false);
                com.tencent.mm.plugin.report.service.g.pQN.a(405, 31, 1, true);
                bVar = null;
            }
        }
        if (str != null) {
            if (str.equals("DisasterNotice")) {
                str2 = (String) map.get(".sysmsg.NoticeId");
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "disaster noticeID:%s, content:%s", str2, (String) map.get(".sysmsg.Content"));
                SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("disaster_pref", 4);
                str5 = sharedPreferences.getString("disaster_noticeid_list_key", "");
                if (!str5.contains(str2)) {
                    String[] split = str5.split(";");
                    if (split == null || split.length <= 10) {
                        str4 = str5;
                    } else {
                        str4 = "";
                        for (String str62 : split) {
                            String[] split2 = str62.split(",");
                            try {
                                if (bh.by(bh.getLong(split2[0], 0)) < 1296000) {
                                    str4 = str4 + split2[0] + "," + split2[1] + ";";
                                }
                            } catch (Exception e4) {
                                x.e("MicroMsg.BigBallSysCmdMsgConsumer", "MM_DATA_SYSCMD_NEWXML_DISASTER_NOTICE parseLong error:%s", e4);
                            }
                        }
                    }
                    x.i("MicroMsg.BigBallSysCmdMsgConsumer", "update noticeIdList %s -> %s", str5, str4 + bh.Wo() + "," + str2 + ";");
                    sharedPreferences.edit().putString("disaster_noticeid_list_key", str4).commit();
                }
                new af(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ f heY;

                    public final void run() {
                        if (this.heY.heW != null) {
                            this.heY.heW.cD(str2);
                        }
                    }
                });
                bwVar.vGZ = n.os(str3);
                bwVar.ngq = 1;
                aU = c.aU(Integer.valueOf(1));
                if (aU == null) {
                    bVar = null;
                } else {
                    bVar = aU.b(aVar);
                }
            }
        }
        if (str != null) {
            if (str.equals("EmotionKv")) {
                str2 = (String) map.get(".sysmsg.EmotionKv.K");
                a = (String) map.get(".sysmsg.EmotionKv.I");
                if (str2 == null) {
                    str3 = "";
                } else {
                    str3 = str2;
                }
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv pcKeyStr len:%d, content[%s] pcId[%s]", Integer.valueOf(str3.length()), str3, a);
                byte[] bytes = com.tencent.mm.protocal.ac.cdL().vBY.getBytes();
                byte[] bytes2 = com.tencent.mm.protocal.ac.cdL().vBZ.getBytes();
                byte[] bArr = null;
                try {
                    bArr = ar.CG().CK().Kx().Ku();
                } catch (Throwable e322) {
                    x.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE :%s ", bh.i(e322));
                }
                if (bh.bw(bArr)) {
                    x.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE  ecdh  is null .");
                    return null;
                }
                PByteArray pByteArray = new PByteArray();
                if (bh.ov(str3) || bh.bw(bytes2) || bh.bw(bytes) || bh.bw(bArr)) {
                    String str9 = "MicroMsg.BigBallSysCmdMsgConsumer";
                    String str10 = "summercck emotionkv param len err pcKeylen:%d, keynlen:%d, keyelen:%d, ecdhlen:%d";
                    Object[] objArr = new Object[4];
                    if (str3 == null) {
                        i4 = -1;
                    } else {
                        i4 = str3.length();
                    }
                    objArr[0] = Integer.valueOf(i4);
                    objArr[1] = Integer.valueOf(bytes2 == null ? -1 : bytes2.length);
                    objArr[2] = Integer.valueOf(bytes == null ? -1 : bytes.length);
                    objArr[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
                    x.w(str9, str10, objArr);
                } else {
                    ar.Hg();
                    MMProtocalJni.genClientCheckKVRes(c.Cg(), str3, bytes, bytes2, bArr, pByteArray);
                }
                byte[] bArr2 = pByteArray.value;
                com_tencent_mm_protocal_c_anr = new anr();
                if (pByteArray.value != null) {
                    com_tencent_mm_protocal_c_anr.pQt = new String(pByteArray.value);
                } else {
                    com_tencent_mm_protocal_c_anr.pQt = "";
                }
                str4 = "MicroMsg.BigBallSysCmdMsgConsumer";
                str5 = "summercck emotionkv res len:%d val len:%d, content[%s]";
                Object[] objArr2 = new Object[3];
                objArr2[0] = Integer.valueOf(bArr2 == null ? -1 : bArr2.length);
                objArr2[1] = Integer.valueOf(com_tencent_mm_protocal_c_anr.pQt.length());
                objArr2[2] = com.tencent.mm.a.g.s(com_tencent_mm_protocal_c_anr.pQt.getBytes());
                x.i(str4, str5, objArr2);
                com_tencent_mm_protocal_c_anr.wuE = a;
                ar.Hg();
                c.EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(59, com_tencent_mm_protocal_c_anr));
                return null;
            }
        }
        if (str != null) {
            if (str.equals("globalalert")) {
                str2 = (String) map.get(".sysmsg.uuid");
                i3 = bh.getInt((String) map.get(".sysmsg.id"), -1);
                int i6 = bh.getInt((String) map.get(".sysmsg.important"), -1);
                if (bh.ov(str2) || i3 < 0 || i6 < 0) {
                    x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert uuid[%s], id[%d], important[%d] is illegal ret", str2, Integer.valueOf(i3), Integer.valueOf(i6));
                    return null;
                }
                str3 = (String) map.get(".sysmsg.title");
                str4 = (String) map.get(".sysmsg.msg");
                if (bh.ov(str3) && bh.ov(str4)) {
                    x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert title[%s], msg[%s] is illegal ret", str3, str4);
                    return null;
                }
                str5 = (String) map.get(".sysmsg.btnlist.btn.$title");
                int i7 = bh.getInt((String) map.get(".sysmsg.btnlist.btn.$id"), -1);
                i5 = bh.getInt((String) map.get(".sysmsg.btnlist.btn.$actiontype"), -1);
                str62 = (String) map.get(".sysmsg.btnlist.btn");
                if (bh.ov(str5) || i7 < 0 || i5 < 0) {
                    x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert first btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal ret", str5, Integer.valueOf(i7), Integer.valueOf(i5));
                    return null;
                }
                String str11 = (String) map.get(".sysmsg.btnlist.btn1.$title");
                int i8 = bh.getInt((String) map.get(".sysmsg.btnlist.btn1.$id"), -1);
                int i9 = bh.getInt((String) map.get(".sysmsg.btnlist.btn1.$actiontype"), -1);
                a = (String) map.get(".sysmsg.btnlist.btn1");
                boolean z2 = true;
                if (bh.ov(str11) || i8 < 0 || i9 < 0) {
                    z2 = false;
                    x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert sec btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal only one btn", str5, Integer.valueOf(i7), Integer.valueOf(i5));
                }
                com.tencent.mm.sdk.b.b hzVar = new hz();
                com.tencent.mm.protocal.b.a.b bVar2 = new com.tencent.mm.protocal.b.a.b();
                hzVar.fyu.fyv = bVar2;
                bVar2.id = i3;
                bVar2.title = str3;
                bVar2.fpb = str4;
                bVar2.vCS = new LinkedList();
                com.tencent.mm.protocal.b.a.a aVar2 = new com.tencent.mm.protocal.b.a.a();
                aVar2.id = i7;
                aVar2.actionType = i5;
                aVar2.vCQ = str5;
                aVar2.vCR = str62;
                bVar2.vCS.add(aVar2);
                if (z2) {
                    com.tencent.mm.protocal.b.a.a aVar3 = new com.tencent.mm.protocal.b.a.a();
                    aVar3.id = i8;
                    aVar3.actionType = i9;
                    aVar3.vCQ = str11;
                    aVar3.vCR = a;
                    bVar2.vCS.add(aVar3);
                }
                boolean m = com.tencent.mm.sdk.b.a.xef.m(hzVar);
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert uuid[%s], id[%d], important[%d], title[%s], msg[%s], twoBtn[%b], publish[%b]", str2, Integer.valueOf(i3), Integer.valueOf(i6), str3, str4, Boolean.valueOf(z2), Boolean.valueOf(m));
                return null;
            }
        }
        if (str != null) {
            if (str.equals("yybsigcheck")) {
                com.tencent.mm.plugin.report.service.g.pQN.a(322, 14, 1, false);
                long currentTimeMillis = System.currentTimeMillis();
                str2 = (String) map.get(".sysmsg.yybsigcheck.yybsig.nocheckmarket");
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket[%s], wording[%s], url[%s]", str2, (String) map.get(".sysmsg.yybsigcheck.yybsig.wording"), (String) map.get(".sysmsg.yybsigcheck.yybsig.url"));
                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
                Object[] objArr3 = new Object[2];
                objArr3[0] = Integer.valueOf(4014);
                objArr3[1] = String.format("%s|%s|%s", new Object[]{str2, str7, str8});
                gVar.h(11098, objArr3);
                if (bh.ov(str2)) {
                    x.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket is nil and return");
                    com.tencent.mm.plugin.report.service.g.pQN.a(322, 15, 1, false);
                    com.tencent.mm.plugin.report.service.g gVar2 = com.tencent.mm.plugin.report.service.g.pQN;
                    Object[] objArr4 = new Object[2];
                    objArr4[0] = Integer.valueOf(4015);
                    objArr4[1] = String.format("%s|%s", new Object[]{str7, str8});
                    gVar2.h(11098, objArr4);
                    return null;
                }
                String[] split3 = str2.split(";");
                str4 = "MicroMsg.BigBallSysCmdMsgConsumer";
                str5 = "summertoken newxml infoStrs len is %d";
                objArr2 = new Object[1];
                objArr2[0] = Integer.valueOf(split3 == null ? -1 : split3.length);
                x.d(str4, str5, objArr2);
                if (split3 == null || split3.length == 0) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(322, 16, 1, false);
                    com.tencent.mm.plugin.report.service.g.pQN.h(11098, Integer.valueOf(4016), str2);
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (String str12 : split3) {
                    if (bh.ov(str12)) {
                        x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml infoStr is nil index:%d, continue", Integer.valueOf(i5));
                    } else {
                        String[] split4 = str12.split(",");
                        str5 = "MicroMsg.BigBallSysCmdMsgConsumer";
                        str62 = "summertoken newxml fields len is %d";
                        Object[] objArr5 = new Object[1];
                        objArr5[0] = Integer.valueOf(split4 == null ? -1 : split4.length);
                        x.d(str5, str62, objArr5);
                        if (split4 == null || split4.length != 3) {
                            x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml fields len is invalid index:%d, continue", Integer.valueOf(i5));
                        } else {
                            try {
                                arrayList.add(new u.c(split4[0], Integer.valueOf(split4[1]).intValue(), split4[2]));
                            } catch (Exception e5) {
                                x.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml parse info index:%d, e:%s", Integer.valueOf(i5), e5.getMessage());
                                com.tencent.mm.plugin.report.service.g.pQN.a(322, 17, 1, false);
                                com.tencent.mm.plugin.report.service.g.pQN.h(11098, Integer.valueOf(4017), str12);
                            }
                        }
                    }
                }
                if (arrayList.size() == 0) {
                    x.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size is 0 and return");
                    com.tencent.mm.plugin.report.service.g.pQN.a(322, 18, 1, false);
                    gVar = com.tencent.mm.plugin.report.service.g.pQN;
                    objArr3 = new Object[2];
                    objArr3[0] = Integer.valueOf(4018);
                    objArr3[1] = String.format("%s|%s|%s", new Object[]{str2, str7, str8});
                    gVar.h(11098, objArr3);
                    return null;
                }
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size[%d], usesSystemApi[%b], containLowerMarket[%b], take[%d]ms", Integer.valueOf(arrayList.size()), Boolean.valueOf(bh.getInt(g.zY().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0), Boolean.valueOf(u.a(ac.getContext(), arrayList, bh.getInt(g.zY().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0)), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                if (u.a(ac.getContext(), arrayList, bh.getInt(g.zY().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0)) {
                    ar.He().setInt(46, 0);
                    com.tencent.mm.plugin.report.service.g.pQN.a(322, 19, 1, true);
                    gVar = com.tencent.mm.plugin.report.service.g.pQN;
                    objArr3 = new Object[2];
                    objArr3[0] = Integer.valueOf(4019);
                    objArr3[1] = String.format("%s|%s|%s", new Object[]{str2, str7, str8});
                    gVar.h(11098, objArr3);
                } else {
                    ar.He().setInt(46, 4);
                    com.tencent.mm.sdk.b.b ioVar = new io();
                    ioVar.fyX.fyY = str7;
                    ioVar.fyX.url = str8;
                    com.tencent.mm.sdk.b.a.xef.m(ioVar);
                    com.tencent.mm.plugin.report.service.g.pQN.a(322, 20, 1, true);
                    gVar = com.tencent.mm.plugin.report.service.g.pQN;
                    objArr3 = new Object[2];
                    objArr3[0] = Integer.valueOf(4020);
                    objArr3[1] = String.format("%s|%s|%s", new Object[]{str2, str7, str8});
                    gVar.h(11098, objArr3);
                }
                return null;
            }
        }
        if (str != null) {
            if (str.equals("qy_status_notify")) {
                str2 = (String) map.get(".sysmsg.chat_id");
                map.get(".sysmsg.last_create_time");
                str3 = (String) map.get(".sysmsg.brand_username");
                j2 = e.kt(str2);
                if (j2 == -1) {
                    x.i("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify bizLocalId == -1,%s", str2);
                    return null;
                }
                i4 = y.Mi().aS(j2).field_newUnReadCount;
                y.Mi().aU(j2);
                com.tencent.mm.ag.a.c ag = y.Mh().ag(j2);
                ar.Hg();
                WY = c.Fd().WY(str3);
                if (WY == null) {
                    x.w("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify cvs == null:%s", str3);
                    return null;
                } else if (ag.ho(1)) {
                    if (WY.vV() <= i4) {
                        WY.eV(0);
                        ar.Hg();
                        c.Fd().a(WY, str3);
                        ar.getNotification().cancelNotification(str3);
                    } else {
                        WY.eV(WY.vV() - i4);
                        ar.Hg();
                        c.Fd().a(WY, str3);
                    }
                    return null;
                } else {
                    if (WY.vU() <= i4) {
                        ar.Hg();
                        c.Fd().Xa(str3);
                        ar.getNotification().cancelNotification(str3);
                    } else {
                        WY.eU(0);
                        WY.eX(0);
                        WY.eO(WY.vU() - i4);
                        ar.Hg();
                        c.Fd().a(WY, str3);
                    }
                    return null;
                }
            }
        }
        if (str != null) {
            if (str.equals("qy_chat_update")) {
                e.l((String) map.get(".sysmsg.brand_username"), (String) map.get(".sysmsg.chat_id"), (String) map.get(".sysmsg.ver"));
            }
        }
        if (str != null) {
            if (str.equals("bindmobiletip")) {
                i = bh.getInt((String) map.get(".sysmsg.bindmobiletip.forcebind"), 0);
                str4 = bh.ou((String) map.get(".sysmsg.bindmobiletip.deviceid"));
                Object ou = bh.ou((String) map.get(".sysmsg.bindmobiletip.wording"));
                str2 = new String(Base64.decode(str4.getBytes(), 0));
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbindmobile forceBind:%d,decodeDeviceId[%s],localDeviceId[%s],woridingStr[%s]", Integer.valueOf(i), str2, new String(com.tencent.mm.bq.b.bc(q.yF().getBytes()).CD(16).oz), ou);
                if (bh.ov(str2) || str2.equals(r4)) {
                    ar.Hg();
                    c.CU().a(com.tencent.mm.storage.w.a.USERINFO_BIND_MOBILE_XML_TIP_BOOLEAN, Boolean.valueOf(true));
                    ar.Hg();
                    c.CU().a(com.tencent.mm.storage.w.a.USERINFO_BIND_MOBILE_XML_FORCE_BIND_BOOLEAN, Boolean.valueOf(i == 1));
                    ar.Hg();
                    c.CU().a(com.tencent.mm.storage.w.a.USERINFO_BIND_MOBILE_XML_WORDING_STRING, ou);
                }
                return null;
            }
        }
        if (str != null) {
            if (str.equals("ClientCheckConsistency")) {
                com_tencent_mm_protocal_c_anr = new aud();
                com_tencent_mm_protocal_c_anr.hJu = (String) map.get(".sysmsg.ClientCheckConsistency.clientcheck.fullpathfilename");
                com_tencent_mm_protocal_c_anr.wCd = bh.getInt((String) map.get(".sysmsg.ClientCheckConsistency.clientcheck.fileoffset"), 0);
                com_tencent_mm_protocal_c_anr.wCe = bh.getInt((String) map.get(".sysmsg.ClientCheckConsistency.clientcheck.checkbuffersize"), 0);
                com_tencent_mm_protocal_c_anr.vOI = bh.getInt((String) map.get(".sysmsg.ClientCheckConsistency.clientcheck.seq"), 0);
                com_tencent_mm_protocal_c_anr.wCf = e(com_tencent_mm_protocal_c_anr.hJu, (long) com_tencent_mm_protocal_c_anr.wCd, (long) com_tencent_mm_protocal_c_anr.wCe);
                com_tencent_mm_protocal_c_anr.vYh = (int) fY(com_tencent_mm_protocal_c_anr.hJu);
                com_tencent_mm_protocal_c_anr.wCg = com.tencent.mm.plugin.normsg.a.d.oSu.bfI() ? 1 : 0;
                com_tencent_mm_protocal_c_anr.vWK = w.yV();
                com_tencent_mm_protocal_c_anr.wCh = d(com_tencent_mm_protocal_c_anr.hJu, Integer.valueOf(com_tencent_mm_protocal_c_anr.wCd), Integer.valueOf(com_tencent_mm_protocal_c_anr.wCe), Integer.valueOf(com_tencent_mm_protocal_c_anr.vOI), com_tencent_mm_protocal_c_anr.wCf, Integer.valueOf(com_tencent_mm_protocal_c_anr.vYh), Integer.valueOf(com_tencent_mm_protocal_c_anr.wCg), Integer.valueOf(com_tencent_mm_protocal_c_anr.vWK));
                ar.Hg();
                c.EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(61, com_tencent_mm_protocal_c_anr));
            }
        }
        if (str != null) {
            if (str.equals("ClientCheckHook")) {
                com_tencent_mm_protocal_c_anr = new auf();
                com_tencent_mm_protocal_c_anr.vOI = bh.getInt((String) map.get(".sysmsg.ClientCheckHook.clientcheck.seq"), 0);
                com_tencent_mm_protocal_c_anr.wCj = com.tencent.mm.plugin.normsg.a.d.oSu.hc(false);
                com_tencent_mm_protocal_c_anr.wCg = com.tencent.mm.plugin.normsg.a.d.oSu.bfI() ? 1 : 0;
                com_tencent_mm_protocal_c_anr.vWK = w.yV();
                com_tencent_mm_protocal_c_anr.wCh = d(Integer.valueOf(com_tencent_mm_protocal_c_anr.vOI), com_tencent_mm_protocal_c_anr.wCj, Integer.valueOf(com_tencent_mm_protocal_c_anr.wCg), Integer.valueOf(com_tencent_mm_protocal_c_anr.vWK));
                ar.Hg();
                c.EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(62, com_tencent_mm_protocal_c_anr));
            }
        }
        if (str != null) {
            if (str.equals("ClientCheckGetAppList")) {
                com_tencent_mm_protocal_c_anr = new aue();
                com_tencent_mm_protocal_c_anr.vOI = bh.getInt((String) map.get(".sysmsg.ClientCheckGetAppList.clientcheck.seq"), 0);
                com_tencent_mm_protocal_c_anr.wCi = com.tencent.mm.plugin.normsg.a.d.oSu.bfH();
                com_tencent_mm_protocal_c_anr.wCg = com.tencent.mm.plugin.normsg.a.d.oSu.bfI() ? 1 : 0;
                com_tencent_mm_protocal_c_anr.vWK = w.yV();
                com_tencent_mm_protocal_c_anr.wCh = d(Integer.valueOf(com_tencent_mm_protocal_c_anr.vOI), com_tencent_mm_protocal_c_anr.wCi, Integer.valueOf(com_tencent_mm_protocal_c_anr.wCg), Integer.valueOf(com_tencent_mm_protocal_c_anr.vWK));
                ar.Hg();
                c.EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(63, com_tencent_mm_protocal_c_anr));
            }
        }
        if (str != null) {
            if (str.equals("ClientCheckGetExtInfo")) {
                com.tencent.mm.plugin.secinforeport.a.d.qfi.bX(com.tencent.mm.plugin.normsg.a.d.oSu.t(true, true), bh.getInt((String) map.get(".sysmsg.ClientCheckGetExtInfo.ReportContext"), 0));
            }
        }
        if (!bh.ov(str)) {
            if (str.equals("functionmsg")) {
                x.d("MicroMsg.BigBallSysCmdMsgConsumer", "subtype functionmsg");
                com.tencent.mm.r.c Bm = i.Bm();
                x.k("MicroMsg.FunctionMsgFetcher", "fetchFromNewXml, newXmlMsgQueue.size: %s, addMsg.createTime: %s", Integer.valueOf(Bm.gJL.size()), Integer.valueOf(bwVar.pbl));
                map.put("FUNCTION_MSG_ADD_MSG_CREATE_TIME_KEY", String.valueOf(bwVar.pbl));
                Bm.gJL.add(map);
                Bm.Bc();
            }
        }
        if (!bh.ov(str)) {
            if (str.equals("paymsg")) {
                x.d("MicroMsg.BigBallSysCmdMsgConsumer", "payMsg, payMsgType: %s, MsgId: %s, fromUsername: %s, toUsername: %s, paymsgid: %s, appMsgContentEncode: %s, ", Integer.valueOf(bh.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), 0)), Long.valueOf(bwVar.vHe), (String) map.get(".sysmsg.paymsg.fromusername"), (String) map.get(".sysmsg.paymsg.tousername"), (String) map.get(".sysmsg.paymsg.paymsgid"), (String) map.get(".sysmsg.paymsg.appmsgcontent"));
                try {
                    str2 = URLDecoder.decode((String) map.get(".sysmsg.paymsg.appmsgcontent"), "UTF-8");
                    if (!bh.ov(str2)) {
                        com.tencent.mm.sdk.b.b mjVar = new mj();
                        mjVar.fEm.type = i2;
                        mjVar.fEm.content = str2;
                        mjVar.fEm.fzO = str3;
                        mjVar.fEm.toUser = str4;
                        mjVar.fEm.fEn = str5;
                        com.tencent.mm.sdk.b.a.xef.m(mjVar);
                    }
                } catch (Throwable e3222) {
                    x.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e3222, "", new Object[0]);
                    x.d("MicroMsg.BigBallSysCmdMsgConsumer", "pay msg, parse failed: %s", e3222.getMessage());
                }
            }
        }
        return bVar;
    }

    private static String e(String str, long j, long j2) {
        ZipFile zipFile;
        Throwable e;
        String str2;
        InputStream inputStream = null;
        try {
            if (str.startsWith("@")) {
                zipFile = new ZipFile(ac.getContext().getApplicationInfo().sourceDir);
                try {
                    inputStream = zipFile.getInputStream(zipFile.getEntry(str.substring(1)));
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e, "", new Object[0]);
                        str2 = "";
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e3) {
                            }
                        }
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException e4) {
                            }
                        }
                        return str2;
                    } catch (Throwable th) {
                        e = th;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e5) {
                            }
                        }
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException e6) {
                            }
                        }
                        throw e;
                    }
                }
            }
            zipFile = null;
            inputStream = FileOp.openRead(str);
            while (j > 0) {
                j -= inputStream.skip(j);
            }
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[2048];
            while (j2 > 0) {
                int read = inputStream.read(bArr, 0, (int) Math.min(2048, j2));
                if (read == -1) {
                    break;
                }
                instance.update(bArr, 0, read);
                j2 -= (long) read;
            }
            str2 = bh.by(instance.digest());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e7) {
                }
            }
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e8) {
                }
            }
        } catch (Exception e9) {
            e = e9;
            zipFile = null;
            x.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e, "", new Object[0]);
            str2 = "";
            if (inputStream != null) {
                inputStream.close();
            }
            if (zipFile != null) {
                zipFile.close();
            }
            return str2;
        } catch (Throwable th2) {
            e = th2;
            zipFile = null;
            if (inputStream != null) {
                inputStream.close();
            }
            if (zipFile != null) {
                zipFile.close();
            }
            throw e;
        }
        return str2;
    }

    private static long fY(String str) {
        ZipFile zipFile;
        Throwable e;
        Throwable th;
        long j = -1;
        if (!str.startsWith("@")) {
            return FileOp.me(str);
        }
        try {
            zipFile = new ZipFile(ac.getContext().getApplicationInfo().sourceDir);
            try {
                ZipEntry entry = zipFile.getEntry(str.substring(1));
                if (entry == null) {
                    try {
                        zipFile.close();
                        return j;
                    } catch (IOException e2) {
                        return j;
                    }
                }
                j = entry.getSize();
                try {
                    zipFile.close();
                    return j;
                } catch (IOException e3) {
                    return j;
                }
            } catch (IOException e4) {
                e = e4;
                try {
                    x.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e, "", new Object[0]);
                    if (zipFile != null) {
                        return j;
                    }
                    try {
                        zipFile.close();
                        return j;
                    } catch (IOException e5) {
                        return j;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e7) {
            e = e7;
            zipFile = null;
            x.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e, "", new Object[0]);
            if (zipFile != null) {
                return j;
            }
            zipFile.close();
            return j;
        } catch (Throwable th3) {
            th = th3;
            zipFile = null;
            if (zipFile != null) {
                zipFile.close();
            }
            throw th;
        }
    }

    private static String d(Object... objArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            for (Object obj : objArr) {
                if (obj instanceof String) {
                    byteArrayOutputStream.write(((String) obj).getBytes());
                } else if (obj instanceof Integer) {
                    int intValue = ((Integer) obj).intValue();
                    for (r0 = 0; r0 < 4; r0++) {
                        byteArrayOutputStream.write(intValue & 255);
                        intValue >>= 8;
                    }
                } else if (obj instanceof Long) {
                    long longValue = ((Long) obj).longValue();
                    for (r0 = 0; r0 < 8; r0++) {
                        byteArrayOutputStream.write((int) (255 & longValue));
                        longValue >>= 8;
                    }
                } else if (obj instanceof Boolean) {
                    if (((Boolean) obj).booleanValue()) {
                        r0 = 1;
                    } else {
                        r0 = 0;
                    }
                    byteArrayOutputStream.write(r0);
                } else {
                    x.e("MicroMsg.BigBallSysCmdMsgConsumer", "Invalid object class: %s", obj);
                    return "";
                }
            }
            return bh.by(MessageDigest.getInstance("MD5").digest(byteArrayOutputStream.toByteArray()));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e, "", new Object[0]);
            return "";
        }
    }
}
