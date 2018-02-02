package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.ae.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.l;
import com.tencent.mm.protocal.c.ke;
import com.tencent.mm.protocal.c.ki;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bs.a;
import com.tencent.mm.z.c;
import com.tencent.wcdb.FileUtils;
import java.util.Map;

class am$5 implements a {
    final /* synthetic */ am kMO;

    am$5(am amVar) {
        this.kMO = amVar;
    }

    public final void a(final d.a aVar) {
        final String a = n.a(aVar.hmq.vGZ);
        if (a == null || a.length() == 0) {
            x.e("MicroMsg.SubCoreCard.CardMsgListener", "onReceiveMsg, msgContent is null");
        } else {
            am.a(this.kMO).post(new Runnable(this) {
                final /* synthetic */ am$5 kMR;

                public final void run() {
                    l auE = am.auE();
                    Object obj = a;
                    String str = aVar.hmq.vHe;
                    x.i("MicroMsg.CardMsgManager", "card onReceiveMsg msgId is " + str);
                    if (!TextUtils.isEmpty(obj)) {
                        g gVar;
                        String str2;
                        Map y = bi.y(obj, "sysmsg");
                        if (y == null) {
                            gVar = null;
                        } else {
                            g gVar2 = new g();
                            str2 = (String) y.get(".sysmsg.carditemmsg.card_type");
                            if (TextUtils.isEmpty(str2) || !com.tencent.mm.plugin.card.b.l.wP(str2)) {
                                gVar2.field_card_type = 0;
                            } else {
                                gVar2.field_card_type = Integer.valueOf(str2).intValue();
                            }
                            gVar2.field_title = (String) y.get(".sysmsg.carditemmsg.title");
                            gVar2.field_description = (String) y.get(".sysmsg.carditemmsg.description");
                            gVar2.field_logo_url = (String) y.get(".sysmsg.carditemmsg.logo_url");
                            gVar2.field_logo_color = (String) y.get(".sysmsg.carditemmsg.logo_color");
                            str2 = (String) y.get(".sysmsg.carditemmsg.time");
                            if (TextUtils.isEmpty(str2) || !com.tencent.mm.plugin.card.b.l.wP(str2)) {
                                gVar2.field_time = (int) (System.currentTimeMillis() / 1000);
                            } else if (Long.valueOf(str2).longValue() >= 2147483647L) {
                                gVar2.field_time = Integer.MAX_VALUE;
                            } else {
                                gVar2.field_time = Integer.valueOf(str2).intValue();
                            }
                            gVar2.field_card_id = (String) y.get(".sysmsg.carditemmsg.card_id");
                            gVar2.field_card_tp_id = (String) y.get(".sysmsg.carditemmsg.card_tp_id");
                            gVar2.field_msg_id = (String) y.get(".sysmsg.carditemmsg.msg_id");
                            str2 = (String) y.get(".sysmsg.carditemmsg.msg_type");
                            if (TextUtils.isEmpty(str2) || !com.tencent.mm.plugin.card.b.l.wP(str2)) {
                                gVar2.field_msg_type = 0;
                            } else {
                                gVar2.field_msg_type = Integer.valueOf(str2).intValue();
                            }
                            str2 = (String) y.get(".sysmsg.carditemmsg.jump_type");
                            if (TextUtils.isEmpty(str2) || !com.tencent.mm.plugin.card.b.l.wP(str2)) {
                                gVar2.field_jump_type = 1;
                            } else {
                                gVar2.field_jump_type = Integer.valueOf(str2).intValue();
                            }
                            gVar2.field_url = (String) y.get(".sysmsg.carditemmsg.url");
                            str2 = (String) y.get(".sysmsg.carditemmsg.button.text");
                            if (!TextUtils.isEmpty(str2)) {
                                ke keVar = new ke();
                                keVar.text = str2;
                                keVar.url = (String) y.get(".sysmsg.carditemmsg.button.url");
                                str2 = (String) y.get(".sysmsg.carditemmsg.button.action_type");
                                if (TextUtils.isEmpty(str2) || !com.tencent.mm.plugin.card.b.l.wP(str2)) {
                                    keVar.kLy = 0;
                                } else {
                                    keVar.kLy = Integer.valueOf(str2).intValue();
                                }
                                gVar2.kLn = keVar;
                                try {
                                    gVar2.field_buttonData = gVar2.kLn.toByteArray();
                                } catch (Throwable e) {
                                    x.e("MicroMsg.CardMsgInfo", "setCardButton fail, ex = %s", new Object[]{e.getMessage()});
                                    x.printErrStackTrace("MicroMsg.CardMsgInfo", e, "", new Object[0]);
                                }
                            }
                            str2 = (String) y.get(".sysmsg.carditemmsg.opt_region.text");
                            if (!TextUtils.isEmpty(str2)) {
                                ki kiVar = new ki();
                                kiVar.text = str2;
                                kiVar.url = (String) y.get(".sysmsg.carditemmsg.opt_region.url");
                                str2 = (String) y.get(".sysmsg.carditemmsg.opt_region.type");
                                if (TextUtils.isEmpty(str2) || !com.tencent.mm.plugin.card.b.l.wP(str2)) {
                                    kiVar.type = 0;
                                } else {
                                    kiVar.type = Integer.valueOf(str2).intValue();
                                }
                                str2 = (String) y.get(".sysmsg.carditemmsg.opt_region.endtime");
                                if (TextUtils.isEmpty(str2) || !com.tencent.mm.plugin.card.b.l.wP(str2)) {
                                    kiVar.qox = (int) (System.currentTimeMillis() / 1000);
                                } else if (Long.valueOf(str2).longValue() >= 2147483647L) {
                                    kiVar.qox = Integer.MAX_VALUE;
                                } else {
                                    kiVar.qox = Integer.valueOf(str2).intValue();
                                }
                                gVar2.kLo = kiVar;
                                try {
                                    gVar2.field_operData = gVar2.kLo.toByteArray();
                                } catch (Throwable e2) {
                                    x.e("MicroMsg.CardMsgInfo", "setOperationRegion fail, ex = %s", new Object[]{e2.getMessage()});
                                    x.printErrStackTrace("MicroMsg.CardMsgInfo", e2, "", new Object[0]);
                                }
                            }
                            str2 = (String) y.get(".sysmsg.carditemmsg.report_scene");
                            if (TextUtils.isEmpty(str2) || !com.tencent.mm.plugin.card.b.l.wP(str2)) {
                                gVar2.field_report_scene = 2;
                            } else {
                                gVar2.field_report_scene = Integer.valueOf(str2).intValue();
                            }
                            gVar2.field_read_state = 1;
                            gVar2.field_accept_buttons = l.i(y, ".sysmsg.carditemmsg");
                            gVar2.field_jump_buttons = l.h(y, ".sysmsg.carditemmsg");
                            str2 = (String) y.get(".sysmsg.carditemmsg.get_layout_scene");
                            if (TextUtils.isEmpty(str2) || !com.tencent.mm.plugin.card.b.l.wP(str2)) {
                                gVar2.kLr = 0;
                            } else {
                                gVar2.kLr = Integer.valueOf(str2).intValue();
                            }
                            gVar2.field_consumed_box_id = (String) y.get(".sysmsg.carditemmsg.consumed_box_id");
                            gVar2.kLh = (String) y.get(".sysmsg.carditemmsg.reddot_wording");
                            gVar2.kLi = (String) y.get(".sysmsg.carditemmsg.reddot_buff");
                            gVar2.kLj = (String) y.get(".sysmsg.carditemmsg.reddot_icon_url");
                            gVar2.kLk = (String) y.get(".sysmsg.carditemmsg.msg_tips.title");
                            gVar2.kLl = (String) y.get(".sysmsg.carditemmsg.msg_tips.icon_url");
                            str2 = (String) y.get(".sysmsg.carditemmsg.msg_scene");
                            if (TextUtils.isEmpty(str2) || !com.tencent.mm.plugin.card.b.l.wP(str2)) {
                                gVar2.kLs = 0;
                            } else {
                                gVar2.kLs = Integer.valueOf(str2).intValue();
                                x.i("MicroMsg.CardMsgManager", "msg_scene is " + str2);
                            }
                            str2 = (String) y.get(".sysmsg.carditemmsg.need_check");
                            x.i("MicroMsg.CardMsgManager", "need_check:" + str2);
                            if (TextUtils.isEmpty(str2)) {
                                gVar2.kLm = false;
                            } else {
                                gVar2.kLm = str2.equals("true");
                            }
                            String str3 = (String) y.get(".sysmsg.carditemmsg.all_unavailable");
                            x.i("MicroMsg.CardMsgManager", "all_Unavailable:" + str2);
                            if (TextUtils.isEmpty(str3)) {
                                gVar2.kLt = false;
                            } else {
                                gVar2.kLt = str3.equals("true");
                            }
                            gVar2.field_unavailable_qr_code_list = l.j(y, ".sysmsg.carditemmsg");
                            gVar = gVar2;
                        }
                        if (gVar == null) {
                            x.e("MicroMsg.CardMsgManager", "card msg == null");
                            return;
                        }
                        if (TextUtils.isEmpty(gVar.field_card_id)) {
                            x.e("MicroMsg.CardMsgManager", "card id == null");
                        }
                        str2 = gVar.field_msg_id;
                        gVar.field_msg_id = str;
                        if (TextUtils.isEmpty(gVar.field_msg_id)) {
                            gVar.field_msg_id = str2;
                        }
                        if (TextUtils.isEmpty(gVar.field_msg_id)) {
                            gVar.field_msg_id = System.currentTimeMillis();
                        }
                        x.i("MicroMsg.CardMsgManager", "msg.field_msg_id : " + gVar.field_msg_id);
                        x.i("MicroMsg.CardMsgManager", "msg for msg_type ==  " + gVar.field_msg_type);
                        if (gVar.kLr != 0) {
                            ar.Hg();
                            c.CU().a(w.a.xoo, Integer.valueOf(gVar.kLr));
                        }
                        x.i("MicroMsg.CardMsgManager", "reddot_buff is " + gVar.kLi);
                        if (TextUtils.isEmpty(gVar.kLi)) {
                            x.e("MicroMsg.CardMsgManager", "reddot_buff is empty");
                        } else {
                            ar.Hg();
                            c.CU().a(w.a.xok, gVar.kLi);
                        }
                        if ((gVar.field_msg_type & 1) != 0) {
                            x.i("MicroMsg.CardMsgManager", "msg_tips_title is " + gVar.kLk);
                            x.i("MicroMsg.CardMsgManager", "msg_tips_icon_url is " + gVar.kLl);
                            ar.Hg();
                            c.CU().a(w.a.xom, gVar.kLk);
                            ar.Hg();
                            c.CU().a(w.a.xon, gVar.kLl);
                        }
                        boolean aQ = com.tencent.mm.s.c.Bq().aQ(262152, 266256);
                        if (!(aQ || (gVar.field_msg_type & 64) == 0)) {
                            com.tencent.mm.s.c.Bq().o(262152, true);
                            aQ = true;
                        }
                        if (aQ) {
                            x.i("MicroMsg.CardMsgManager", "has card new msg, return");
                        } else {
                            x.i("MicroMsg.CardMsgManager", "not has new!");
                            obj = null;
                            if ((gVar.field_msg_type & 32) != 0) {
                                com.tencent.mm.s.c.Bq().p(262152, true);
                                x.i("MicroMsg.CardMsgManager", "has reddot");
                                obj = 1;
                            } else {
                                x.e("MicroMsg.CardMsgManager", "not has reddot!");
                            }
                            Object obj2 = null;
                            if (TextUtils.isEmpty(gVar.kLh)) {
                                x.e("MicroMsg.CardMsgManager", "reddot_wording is empty!");
                            } else {
                                x.i("MicroMsg.CardMsgManager", "reddot_wording is " + gVar.kLh);
                                ar.Hg();
                                c.CU().a(w.a.xoi, gVar.kLh);
                                com.tencent.mm.s.c.Bq().a(w.a.xoc, true);
                                obj2 = 1;
                            }
                            Object obj3 = null;
                            x.i("MicroMsg.CardMsgManager", "reddot_icon_url is " + gVar.kLj);
                            if (TextUtils.isEmpty(gVar.kLj)) {
                                x.e("MicroMsg.CardMsgManager", "reddot_icon_url is empty");
                            } else {
                                ar.Hg();
                                c.CU().a(w.a.xol, gVar.kLj);
                                com.tencent.mm.s.c.Bq().a(w.a.xod, true);
                                obj3 = 1;
                            }
                            if (obj == null || r1 == null || r2 == null) {
                                if (obj != null && r1 != null && r2 == null) {
                                    com.tencent.mm.s.c.Bq().a(w.a.xod, false);
                                    ar.Hg();
                                    c.CU().a(w.a.xol, "");
                                } else if (obj != null && r1 == null && r2 != null) {
                                    com.tencent.mm.s.c.Bq().a(w.a.xoc, false);
                                    ar.Hg();
                                    c.CU().a(w.a.xoi, "");
                                } else if (obj == null && r1 != null && r2 != null) {
                                    com.tencent.mm.s.c.Bq().p(262152, false);
                                } else if (obj != null && r1 == null && r2 == null) {
                                    com.tencent.mm.s.c.Bq().a(w.a.xod, false);
                                    ar.Hg();
                                    c.CU().a(w.a.xol, "");
                                    com.tencent.mm.s.c.Bq().a(w.a.xoc, false);
                                    ar.Hg();
                                    c.CU().a(w.a.xoi, "");
                                } else if (obj == null && r1 != null && r2 == null) {
                                    com.tencent.mm.s.c.Bq().a(w.a.xod, false);
                                    ar.Hg();
                                    c.CU().a(w.a.xol, "");
                                    com.tencent.mm.s.c.Bq().p(262152, false);
                                } else if (obj == null && r1 == null && r2 != null) {
                                    com.tencent.mm.s.c.Bq().a(w.a.xoc, false);
                                    ar.Hg();
                                    c.CU().a(w.a.xoi, "");
                                    com.tencent.mm.s.c.Bq().p(262152, false);
                                }
                            }
                            if (!(obj == null && r1 == null && r2 == null)) {
                                ar.Hg();
                                c.CU().a(w.a.xoz, gVar.field_card_id);
                                ar.Hg();
                                c.CU().a(w.a.xoA, Boolean.valueOf(gVar.kLm));
                                x.i("MicroMsg.CardMsgManager", "card_id:" + gVar.field_card_id + "  need_check:" + gVar.kLm);
                            }
                        }
                        if ((gVar.field_msg_type & 1) != 0) {
                            if (auE.wb(gVar.field_msg_id)) {
                                x.e("MicroMsg.CardMsgManager", "msg for id " + gVar.field_msg_id + " is exist!!");
                                auE.wc(gVar.field_msg_id);
                                auE.kJF.add(gVar);
                                l.c(gVar);
                            } else {
                                auE.kJF.add(gVar);
                                l.c(gVar);
                                if ((gVar.field_msg_type & FileUtils.S_IWUSR) != 0) {
                                    auE.kJG++;
                                }
                            }
                            ar.Hg();
                            c.CU().set(139268, Integer.valueOf(auE.kJG));
                            auE.a(gVar);
                        }
                        if ((gVar.field_msg_type & 2) != 0) {
                            am.auz();
                            b.nF(gVar.kLr);
                        }
                        if ((gVar.field_msg_type & 4) != 0) {
                            auE.asi();
                        }
                        if ((gVar.field_msg_type & 8) != 0) {
                            am.auG().m(gVar.field_card_id, gVar.field_card_tp_id, gVar.field_report_scene);
                        }
                        if ((gVar.field_msg_type & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                            gVar.auu();
                            am.auQ().b(gVar);
                        }
                        com.tencent.mm.plugin.card.b.l.axe();
                    }
                }
            });
        }
    }
}
