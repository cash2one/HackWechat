package com.tencent.mm.plugin.webwx.a;

import android.content.Intent;
import com.tencent.mm.ae.d;
import com.tencent.mm.ae.d.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ag.a.i;
import com.tencent.mm.ag.y;
import com.tencent.mm.aq.d.a;
import com.tencent.mm.bf.l;
import com.tencent.mm.g.a.qw;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI;
import com.tencent.mm.plugin.webwx.ui.WebWXPopupUnlockUI;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class f implements d, a {
    public final b b(d.a aVar) {
        bw bwVar = aVar.hmq;
        if (bwVar != null && bwVar.ngq == 51) {
            x.d("MicroMsg.StatusNotifyMsgExtension", "msgType %d %d", new Object[]{Integer.valueOf(bwVar.ngq), Integer.valueOf(51)});
            String a = n.a(bwVar.vGY);
            if (!bh.ov(a)) {
                String trim = n.a(bwVar.vGZ).trim();
                Map y = bi.y(trim, "msg");
                if (y != null) {
                    int i = bh.getInt((String) y.get(".msg.op.$id"), 0);
                    x.d("MicroMsg.StatusNotifyMsgExtension", "handleStatusNotifyMsg, %d", new Object[]{Integer.valueOf(i)});
                    if (i == 1 || i == 2 || i == 5) {
                        x.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr mark conversation readed. userName = " + a);
                        com.tencent.mm.plugin.webwx.a.ifs.cancelNotification(a);
                        if (s.gJ(a)) {
                            ar.Hg();
                            c.CU().set(143618, Integer.valueOf(0));
                            l.Tx().Tk();
                        } else {
                            x.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr STATUSNOTIFY clearChatRoomMsgSeq");
                            ar.Hg();
                            c.Fd().Xa(a);
                            if (s.eV(a)) {
                                ar.Hg();
                                aj WY = c.Fd().WY(a);
                                if (WY != null && WY.field_unReadCount > 0 && WY.field_UnDeliverCount > 0) {
                                    x.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr STATUSNOTIFY clearChatRoomMsgSeq chatroom[%s], UnDeliver[%d], Unread[%d]", new Object[]{a, Integer.valueOf(WY.field_UnDeliverCount), Integer.valueOf(WY.field_unReadCount)});
                                    com.tencent.mm.plugin.webwx.a.ift.cB(a);
                                    WY.eO(0);
                                    ar.Hg();
                                    c.Fd().a(WY, a);
                                }
                            }
                        }
                    } else if (i == 3) {
                        ar.Hg();
                        List ciF = c.Fd().ciF();
                        StringBuilder stringBuilder = new StringBuilder();
                        int i2 = 0;
                        while (i2 < ciF.size()) {
                            stringBuilder.append(i2 > 0 ? "," : "");
                            stringBuilder.append((String) ciF.get(i2));
                            i2++;
                        }
                        ar.CG().a(new com.tencent.mm.modelsimple.aj(stringBuilder.toString(), 4), 0);
                    } else if (i == 6) {
                        x.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[]{Integer.valueOf(i), trim});
                    } else if (i == 7) {
                        x.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[]{Integer.valueOf(i), trim});
                        r3 = new Object[2];
                        ar.Hg();
                        r3[0] = Integer.valueOf(c.EU());
                        r3[1] = Integer.valueOf(q.RT());
                        x.d("MicroMsg.StatusNotifyMsgExtension", "onlineversion: %d,%d", r3);
                        a = bh.ou((String) y.get(".msg.op.name")).trim();
                        r0 = bh.ou((String) y.get(".msg.op.arg")).trim();
                        if ("WeixinStatus".equals(a)) {
                            ar.Hg();
                            if (c.EU() == q.RT() && q.hNp != null && q.hNp.trim().length() > 0) {
                                Intent intent = new Intent(ac.getContext(), WebWXLogoutUI.class);
                                intent.setFlags(603979776);
                                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                intent.putExtra("intent.key.online_version", q.RT());
                                ac.getContext().startActivity(intent);
                            }
                        } else if ("MomentsUnreadMsgStatus".equals(a)) {
                            r3 = new qw();
                            r3.fIH.fut = 7;
                            r3.fIH.fII = a;
                            r3.fIH.fIJ = (long) bh.getInt(r0, 0);
                            x.i("MicroMsg.StatusNotifyMsgExtension", "sns enter function, %d, %s, %d", new Object[]{Integer.valueOf(r3.fIH.fut), r3.fIH.fII, Long.valueOf(r3.fIH.fIJ)});
                            com.tencent.mm.sdk.b.a.xef.m(r3);
                        } else if ("EnterpriseChatStatus".equals(a)) {
                            y.Mq();
                            i.f(i, a, r0);
                        }
                    } else if (i == 8) {
                        x.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[]{Integer.valueOf(i), trim});
                        a = bh.ou((String) y.get(".msg.op.name")).trim();
                        r0 = bh.ou((String) y.get(".msg.op.arg")).trim();
                        if ("EnterpriseChatStatus".equals(a)) {
                            y.Mq();
                            i.f(i, a, r0);
                        } else {
                            com.tencent.mm.sdk.b.b qwVar = new qw();
                            qwVar.fIH.fut = 8;
                            com.tencent.mm.sdk.b.a.xef.m(qwVar);
                        }
                    } else if (i == 9) {
                        x.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[]{Integer.valueOf(i), trim});
                        a = bh.ou((String) y.get(".msg.op.name")).trim();
                        r0 = bh.ou((String) y.get(".msg.op.arg")).trim();
                        if ("MomentsTimelineStatus".equals(a)) {
                            String[] split = r0.split(",");
                            if (split.length == 2) {
                                r3 = new qw();
                                r3.fIH.fut = 9;
                                r3.fIH.fII = a;
                                r3.fIH.fIJ = (long) bh.getInt(split[1], 0);
                                r3.fIH.fIK = split[0];
                                com.tencent.mm.sdk.b.a.xef.m(r3);
                            }
                        } else if ("EnterpriseChatStatus".equals(a)) {
                            y.Mq();
                            i.f(i, a, r0);
                        }
                    } else if (i == 11) {
                        a = bh.ou((String) y.get(".msg.op.name")).trim();
                        r0 = bh.ou((String) y.get(".msg.op.arg")).trim();
                        if (!"DownloadFile".equals(a)) {
                            x.i("MicroMsg.StatusNotifyMsgExtension", "[MultiTerminalSyncMgr]not DownloadFile, ignore");
                        }
                        y = bi.y(r0, "downloadList");
                        if (y != null) {
                            int i3 = 0;
                            while (true) {
                                a = ".downloadList.downloadItem" + (i3 == 0 ? "" : Integer.valueOf(i3));
                                int i4 = i3 + 1;
                                r0 = a + ".username";
                                a = a + ".msgsvrid";
                                r0 = (String) y.get(r0);
                                if (!bh.ov(r0)) {
                                    long j = bh.getLong((String) y.get(a), -1);
                                    if (j == -1) {
                                        break;
                                    }
                                    ar.Hg();
                                    cf F = c.Fa().F(r0, j);
                                    if (F.field_msgSvrId == 0) {
                                        x.i("MicroMsg.StatusNotifyMsgExtension", "[MicroMsg.MultiTerminalSyncMgr] msg not exit, svrID:%d", new Object[]{Long.valueOf(j)});
                                        i3 = i4;
                                    } else {
                                        g.bVr().bVt().fm(F.field_msgId);
                                        i3 = i4;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                    } else if (i == 12) {
                        x.d("MicroMsg.StatusNotifyMsgExtension", "williamjin extdevice unlock " + trim, new Object[]{Integer.valueOf(i)});
                        try {
                            if (y.get(".msg.op.arg") != null) {
                                r0 = new JSONObject((String) y.get(".msg.op.arg")).get("deviceName").toString();
                                if (q.RS()) {
                                    Intent intent2 = new Intent(ac.getContext(), WebWXPopupUnlockUI.class);
                                    intent2.setFlags(872415232);
                                    intent2.putExtra("deviceName", r0);
                                    ac.getContext().startActivity(intent2);
                                }
                            } else {
                                x.d("MicroMsg.StatusNotifyMsgExtension", "[williamjin] can not find the tag  .msg.op.arg");
                            }
                        } catch (JSONException e) {
                            x.e("MicroMsg.StatusNotifyMsgExtension", "[williamjin] " + e.getMessage());
                        }
                    } else {
                        x.e("MicroMsg.StatusNotifyMsgExtension", "unknow opCode, %d", new Object[]{Integer.valueOf(i)});
                    }
                }
            }
        }
        return null;
    }

    public final void h(au auVar) {
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, k kVar) {
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, k kVar) {
        x.i("MicroMsg.StatusNotifyMsgExtension", "onImgTaskEnd imgLocalId:%d, msgLocalId:%d", new Object[]{Long.valueOf(j), Long.valueOf(j2)});
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
    }
}
