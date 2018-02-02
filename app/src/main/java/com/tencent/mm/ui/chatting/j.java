package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ad.h;
import com.tencent.mm.ad.n;
import com.tencent.mm.ag.f;
import com.tencent.mm.aq.e;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.chatting.k.1;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.g.a;
import com.tencent.mm.y.i;
import com.tencent.mm.y.l;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.m;
import com.tencent.mm.z.s;
import com.tencent.mm.z.u;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

public final class j {
    private static a yrC = new a((byte) 0);

    static /* synthetic */ void d(Context context, String str, au auVar, boolean z) {
        x.i("MicroMsg.ChattingEditModeRetransmitMsg", "retransmitSingleMsg %s", new Object[]{Long.valueOf(auVar.field_msgId)});
        if (!i.al(auVar) && !i.am(auVar)) {
            if (f.eE(str) && !auVar.cje() && !auVar.cjg() && !auVar.ciW()) {
                x.i("MicroMsg.ChattingEditModeRetransmitMsg", "not bizChatSupport msg:type:%d", new Object[]{Integer.valueOf(auVar.getType())});
            } else if (auVar.cje()) {
                i.b(context, str, auVar);
            } else if (auVar.cjh()) {
                i.c(context, str, auVar);
            } else if (auVar.cji()) {
                i.c(context, str, auVar);
                r1 = s.eV(str);
                a.a(r1 ? a$c.Chatroom : a$c.Chat, d.ypg, auVar, r1 ? m.gl(str) : 0);
            } else if (auVar.cjg()) {
                i.a(context, str, auVar, z);
            } else if (auVar.ciZ() || auVar.aNc()) {
                r1 = s.eV(str);
                a.a(r1 ? a$c.Chatroom : a$c.Chat, d.ypg, auVar, r1 ? m.gl(str) : 0);
                if (auVar.cjk()) {
                    if (i.a(context, str, auVar, "appEmoji")) {
                        a aVar;
                        aj Xp = aj.Xp(auVar.field_content);
                        a I = a.I(auVar.field_content, auVar.field_reserved);
                        if (I == null) {
                            I = new a();
                            I.hbd = Xp.fqR;
                            aVar = I;
                        } else {
                            aVar = I;
                        }
                        if (bh.ov(aVar.hbd) || aVar.hbd.equalsIgnoreCase("-1")) {
                            x.e("MicroMsg.ChattingEditModeLogic", "emoji md5 is null. ignore resend");
                            return;
                        }
                        x.d("MicroMsg.ChattingEditModeLogic", "jacks send App Emoji: %s, %s", new Object[]{str, aVar.hbd});
                        EmojiInfo yc = ((c) g.k(c.class)).getEmojiMgr().yc(aVar.hbd);
                        if (yc != null) {
                            i.b(yc, str);
                        } else {
                            x.i("MicroMsg.ChattingEditModeLogic", "emoji is null. content:%s", new Object[]{Xp});
                        }
                    }
                } else if (auVar.ciV()) {
                    try {
                        l vL = ((com.tencent.mm.plugin.biz.a.a) g.h(com.tencent.mm.plugin.biz.a.a.class)).vL(auVar.field_content);
                        List<com.tencent.mm.y.m> list = vL.hdX;
                        if (list != null) {
                            for (com.tencent.mm.y.m mVar : list) {
                                a aVar2 = new a();
                                if (i.fV(mVar.hei)) {
                                    k.b(str, k.a(str, mVar), mVar.hen);
                                } else {
                                    aVar2.title = mVar.title;
                                    aVar2.description = mVar.hef;
                                    aVar2.action = "view";
                                    aVar2.type = 5;
                                    aVar2.url = mVar.url;
                                    aVar2.fGz = vL.fGz;
                                    aVar2.fGA = vL.fGA;
                                    aVar2.gjD = vL.gjD;
                                    aVar2.thumburl = mVar.hed;
                                    if (bh.ov(aVar2.thumburl)) {
                                        h jm = n.JQ().jm(auVar.field_talker);
                                        if (jm != null) {
                                            aVar2.thumburl = jm.JG();
                                        }
                                    }
                                    i.a(context, str, a.a(aVar2, null, null), auVar.field_isSend, z);
                                }
                            }
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.ChattingEditModeLogic", e, "", new Object[0]);
                        x.e("MicroMsg.ChattingEditModeLogic", "[oneliang]retransmit multi app msg error : %s", new Object[]{e.getLocalizedMessage()});
                    }
                } else {
                    a fT = a.fT(auVar.field_isSend == 0 ? ba.hQ(auVar.field_content) : auVar.field_content);
                    if (fT == null) {
                        x.e("MicroMsg.ChattingEditModeRetransmitMsg", "parse app message content fail");
                        return;
                    }
                    com.tencent.mm.pluginsdk.model.app.f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(fT.appId, false);
                    if (aZ != null && aZ.Yz()) {
                        x.w("MicroMsg.ChattingEditModeRetransmitMsg", "do not forward game msg");
                    } else if (fT.type == 19) {
                        b mtVar = new mt();
                        mtVar.fEE.type = 4;
                        mtVar.fEE.fEJ = auVar;
                        mtVar.fEE.toUser = str;
                        com.tencent.mm.sdk.b.a.xef.m(mtVar);
                    } else {
                        if (fT.type == 5 && !bh.ov(fT.url)) {
                            String str2 = "";
                            try {
                                str2 = URLEncoder.encode(fT.url, "UTF-8");
                            } catch (Throwable e2) {
                                x.printErrStackTrace("MicroMsg.ChattingEditModeRetransmitMsg", e2, "", new Object[0]);
                            }
                            long Wo = bh.Wo();
                            x.d("MicroMsg.ChattingEditModeRetransmitMsg", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13378), fT.url, Long.valueOf(Wo), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1)});
                            com.tencent.mm.plugin.report.service.g.pQN.h(13378, new Object[]{str2, Long.valueOf(Wo), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1)});
                        }
                        i.b(context, str, auVar, z);
                    }
                }
            } else if (auVar.cjf()) {
                if (i.a(context, str, auVar, "friendcard")) {
                    com.tencent.mm.plugin.messenger.a.f.aZh().A(str, i.q(auVar.field_content, auVar.field_isSend, z), 42);
                }
            } else if (auVar.cjj() || auVar.cjk()) {
                if (!i.ai(auVar)) {
                    i.a(context, str, auVar);
                }
            } else if (auVar.aNe()) {
                i.c(context, str, auVar, z);
            }
        }
    }

    public static void a(Context context, List<au> list, boolean z, String str, ac acVar) {
        crr();
        if (context == null) {
            x.w("MicroMsg.ChattingEditModeRetransmitMsg", "do retransmit fail, context is null");
        } else if (list == null || list.isEmpty()) {
            x.w("MicroMsg.ChattingEditModeRetransmitMsg", "do retransmit fail, select item empty");
        } else if (i.a(list, acVar)) {
            Object obj;
            if (list != null && !list.isEmpty()) {
                for (au auVar : list) {
                    String str2 = null;
                    if (!auVar.cjs()) {
                        if (auVar.cje()) {
                            e eVar = null;
                            if (auVar.field_msgId > 0) {
                                eVar = o.Pw().bi(auVar.field_msgId);
                            }
                            if ((eVar == null || eVar.hzP <= 0) && auVar.field_msgSvrId > 0) {
                                eVar = o.Pw().bh(auVar.field_msgSvrId);
                            }
                            if (eVar != null) {
                                str2 = o.Pw().m(com.tencent.mm.aq.f.c(eVar), "", "");
                            }
                        } else if (auVar.cji() || auVar.cjh()) {
                            com.tencent.mm.modelvideo.o.TU();
                            str2 = com.tencent.mm.modelvideo.s.nt(auVar.field_imgPath);
                        } else if (auVar.aNc()) {
                            a fT = a.fT(auVar.field_content);
                            if (fT != null) {
                                com.tencent.mm.pluginsdk.model.app.b RI = com.tencent.mm.pluginsdk.model.app.l.RI(fT.fny);
                                if (RI != null) {
                                    str2 = RI.field_fileFullPath;
                                }
                            }
                        } else {
                            str2 = auVar.field_imgPath;
                        }
                        if (auVar.cje() || auVar.cjh() || auVar.cji() || i.av(auVar)) {
                            obj = (System.currentTimeMillis() - auVar.field_createTime <= 259200000 || (!bh.ov(str2) && com.tencent.mm.a.e.bO(str2))) ? null : 1;
                            if (obj == null) {
                            }
                        }
                        obj = null;
                        break;
                    }
                }
            } else {
                x.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to friend msg error, select item empty");
            }
            obj = 1;
            if (obj != null) {
                x.i("MicroMsg.ChattingEditModeRetransmitMsg", "slected msg is all expired or clean!!!");
                if (acVar == null) {
                    return;
                }
                if (acVar.crU() || list.size() == 1) {
                    com.tencent.mm.ui.base.h.a(context, context.getString(R.l.edT), context.getString(R.l.dGO), new 2());
                    return;
                }
                return;
            }
            b(context, list, z, str, acVar);
        } else {
            final List<au> list2 = list;
            final ac acVar2 = acVar;
            final Context context2 = context;
            final boolean z2 = z;
            final String str3 = str;
            com.tencent.mm.ui.base.h.a(context, context.getString(R.l.epD), "", context.getString(R.l.dGA), context.getString(R.l.dEn), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Object obj;
                    List<au> list = list2;
                    if (list != null && !list.isEmpty()) {
                        for (au auVar : list) {
                            if (!i.an(auVar)) {
                                if (!auVar.ciW() && !i.ai(auVar) && !i.ak(auVar) && !i.at(auVar) && !i.al(auVar) && auVar.getType() != -1879048186 && !i.as(auVar) && !i.am(auVar) && !i.ar(auVar) && !i.an(auVar) && auVar.getType() != 318767153) {
                                    obj = null;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    x.w("MicroMsg.ChattingEditModeLogic", "check contain only invalid send to friend msg error, select item empty");
                    obj = 1;
                    if (obj != null) {
                        x.w("MicroMsg.ChattingEditModeRetransmitMsg", "only contain invalid msg, exit long click mode");
                        if (acVar2 != null) {
                            acVar2.b(ac.a.yxj);
                            return;
                        }
                        return;
                    }
                    j.b(context2, list2, z2, str3, acVar2);
                }
            }, null);
        }
    }

    private static void b(Context context, List<au> list, boolean z, String str, ac acVar) {
        if (i.de(list)) {
            com.tencent.mm.ui.base.h.a(context, context.getString(R.l.dXy), "", context.getString(R.l.dBP), new 3(acVar));
            return;
        }
        int i;
        yrC.yrI = new LinkedList(list);
        yrC.ypn = z;
        yrC.yrB = acVar;
        yrC.fEL = str;
        Intent intent = new Intent(context, MsgRetransmitUI.class);
        if (list.size() == 1) {
            String hz;
            int i2;
            au auVar = (au) list.get(0);
            if (auVar.aNc() || auVar.ciV()) {
                hz = u.hz(auVar.field_msgSvrId);
                u.b t = u.GK().t(hz, true);
                t.o("prePublishId", "msg_" + auVar.field_msgSvrId);
                t.o("preUsername", com.tencent.mm.ui.chatting.viewitems.b.a(auVar, z, false));
                t.o("preChatName", auVar.field_talker);
                t.o("preMsgIndex", Integer.valueOf(0));
                t.o("sendAppMsgScene", Integer.valueOf(1));
                t.o("moreRetrAction", Boolean.valueOf(true));
                if (z) {
                    t.o("fromScene", Integer.valueOf(2));
                } else {
                    t.o("fromScene", Integer.valueOf(1));
                }
                ((com.tencent.mm.plugin.sns.b.i) g.h(com.tencent.mm.plugin.sns.b.i.class)).a("adExtStr", t, auVar);
                intent.putExtra("reportSessionId", hz);
            }
            String str2 = auVar.field_content;
            int i3 = 12;
            if (auVar.aNe()) {
                i3 = 9;
                hz = str2;
            } else if (auVar.cjj()) {
                i3 = 5;
                intent.putExtra("Retr_File_Name", auVar.field_imgPath);
                hz = str2;
            } else if (auVar.cjf()) {
                i3 = 8;
                hz = str2;
            } else {
                if (auVar.cjg()) {
                    i3 = 4;
                    if (z && auVar.field_isSend == 0) {
                        hz = ba.hQ(str2);
                    }
                } else if (auVar.cje()) {
                    e eVar = null;
                    if (auVar.field_msgId > 0) {
                        eVar = o.Pw().bi(auVar.field_msgId);
                    }
                    if ((eVar == null || eVar.hzP <= 0) && auVar.field_msgSvrId > 0) {
                        eVar = o.Pw().bh(auVar.field_msgSvrId);
                    }
                    intent.putExtra("Retr_File_Name", o.Pw().m(com.tencent.mm.aq.f.c(eVar), "", ""));
                    i3 = 0;
                    hz = str2;
                } else if (auVar.cji()) {
                    r1 = t.nF(auVar.field_imgPath);
                    if (r1 != null) {
                        intent.putExtra("Retr_length", r1.hVH);
                    }
                    i3 = 11;
                    intent.putExtra("Retr_File_Name", auVar.field_imgPath);
                    hz = str2;
                } else if (auVar.cjh()) {
                    r1 = t.nF(auVar.field_imgPath);
                    if (r1 != null) {
                        intent.putExtra("Retr_length", r1.hVH);
                    }
                    i3 = 1;
                    intent.putExtra("Retr_File_Name", auVar.field_imgPath);
                    hz = str2;
                } else if (auVar.aNc()) {
                    a fT = a.fT(str2);
                    if (fT != null && 19 == fT.type) {
                        i3 = 10;
                    } else if (fT != null && 24 == fT.type) {
                        i3 = 10;
                    } else if (fT == null || 16 != fT.type) {
                        i3 = 2;
                    } else {
                        i3 = 14;
                    }
                    if (auVar.ciV()) {
                        intent.putExtra("is_group_chat", z);
                    }
                }
                hz = str2;
            }
            if (auVar.ciV()) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            if (acVar == null || acVar.crU()) {
                intent.putExtra("Retr_Msg_Type", i3);
            } else {
                intent.putExtra("Retr_Msg_Type", 13);
                intent.putExtra("Retr_Multi_Msg_List_from", str);
            }
            intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
            intent.putExtra("Retr_Msg_content", hz);
            intent.putExtra("Edit_Mode_Sigle_Msg", true);
            i = i2;
        } else if ((acVar == null || !acVar.crU()) && ((!s.gF(str) || f.eE(str)) && !s.ho(str))) {
            intent.putExtra("Retr_Msg_Type", 13);
            intent.putExtra("Retr_Multi_Msg_List_from", str);
            i = 2;
        } else {
            intent.putExtra("Retr_Msg_Type", 12);
            i = 2;
        }
        intent.putExtra("Retr_MsgFromScene", i);
        intent.putExtra("Retr_show_success_tips", true);
        context.startActivity(intent);
        ar.Dm().F(new 1(yrC.yrI));
    }

    public static void j(Context context, String str, boolean z) {
        b mtVar = new mt();
        mtVar.fEE.type = 5;
        mtVar.fEE.fEK = yrC.yrI;
        mtVar.fEE.toUser = str;
        mtVar.fEE.fEL = yrC.fEL;
        mtVar.fEE.context = context;
        mtVar.fEE.fEg = yrC.fEg;
        mtVar.fEE.fEN = yrC.yrJ;
        com.tencent.mm.sdk.b.a.xef.m(mtVar);
        if (yrC.yrI != null) {
            com.tencent.mm.plugin.report.service.g.pQN.h(10811, new Object[]{Integer.valueOf(8), Integer.valueOf(yrC.yrI.size()), Integer.valueOf(yrC.yrI.size() - i.dc(yrC.yrI))});
            for (au auVar : yrC.yrI) {
                long Wo = bh.Wo();
                a fT = a.fT(bh.VH(auVar.field_content));
                if (!(fT == null || fT.type != 5 || bh.ov(fT.url))) {
                    int i;
                    if (auVar.ciV()) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    String str2 = "";
                    try {
                        str2 = URLEncoder.encode(fT.url, "UTF-8");
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.ChattingEditModeRetransmitMsg", e, "", new Object[0]);
                    }
                    x.d("MicroMsg.ChattingEditModeRetransmitMsg", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13378), fT.url, Long.valueOf(Wo), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1)});
                    com.tencent.mm.plugin.report.service.g.pQN.h(13378, new Object[]{str2, Long.valueOf(Wo), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1)});
                }
            }
        }
        if (z && yrC.yrB != null) {
            yrC.yrB.b(ac.a.yxj);
        }
    }

    public static void mD(boolean z) {
        if (z && yrC.yrB != null) {
            yrC.yrB.b(ac.a.yxj);
        }
    }

    public static mt fL(Context context) {
        b mtVar = new mt();
        mtVar.fEE.type = 6;
        mtVar.fEE.fEK = yrC.yrI;
        mtVar.fEE.fEL = yrC.fEL;
        mtVar.fEE.context = context;
        com.tencent.mm.sdk.b.a.xef.m(mtVar);
        yrC.fEg = mtVar.fEF.fEg;
        yrC.yrJ = mtVar.fEF.fEN;
        return mtVar;
    }

    public static void k(Context context, String str, boolean z) {
        if (context == null) {
            x.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, context is null");
        } else if (bh.ov(str)) {
            x.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, username is empty");
        } else if (yrC.yrI == null || yrC.yrI.isEmpty()) {
            x.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, select items empty");
        } else {
            x.v("MicroMsg.ChattingEditModeRetransmitMsg", "post to do job, send to %s", new Object[]{str});
            s.ytO.c(new 4(context, str, z, null));
        }
    }

    public static void crr() {
        yrC.yrI = null;
        yrC.ypn = false;
        yrC.yrB = null;
        yrC.fEL = null;
        yrC.fEg = null;
        yrC.yrJ = null;
    }
}
