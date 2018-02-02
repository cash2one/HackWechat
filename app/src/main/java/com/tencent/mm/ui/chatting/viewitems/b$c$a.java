package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.ViewStub;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.aq.e;
import com.tencent.mm.aq.f;
import com.tencent.mm.g.a.os;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.ChattingFooterMoreBtnBar;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ChattingUI.a.14;
import com.tencent.mm.ui.chatting.ChattingUI.a.15;
import com.tencent.mm.ui.chatting.ChattingUI.a.24;
import com.tencent.mm.ui.chatting.ah;
import com.tencent.mm.ui.chatting.ah.4;
import com.tencent.mm.ui.chatting.ah.7;
import com.tencent.mm.ui.chatting.ah.8;
import com.tencent.mm.ui.chatting.b.ac;
import com.tencent.mm.ui.chatting.b.ac.1;
import com.tencent.mm.ui.chatting.b.ad;
import com.tencent.mm.ui.chatting.b.ad.2;
import com.tencent.mm.ui.chatting.b.ae;
import com.tencent.mm.ui.chatting.b.l;
import com.tencent.mm.ui.chatting.b.v;
import com.tencent.mm.ui.chatting.b.v.3;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.ui.chatting.viewitems.b.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.g;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.m;
import com.tencent.mm.z.s;
import com.tencent.wcdb.FileUtils;
import java.util.LinkedList;
import java.util.List;

class b$c$a implements d {
    public au fnB;
    final /* synthetic */ c yIH;

    b$c$a(c cVar) {
        this.yIH = cVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (this.fnB == null) {
            x.e("MicroMsg.ChattingItem", "context item select failed, null msg");
            return;
        }
        this.yIH.yIF.a(menuItem, c.a(this.yIH), this.fnB);
        a a = c.a(this.yIH);
        b bVar = this.yIH.yIF;
        au auVar = (au) a.ysf.getItem(menuItem.getGroupId());
        if (auVar == null) {
            x.e("MicroMsg.ChattingUI", "context item select failed, null msg");
            return;
        }
        boolean aN;
        g.a aVar;
        String str;
        l lVar = a.yvQ;
        EmojiInfo yc;
        aj Xp;
        switch (menuItem.getItemId()) {
            case 103:
                aN = lVar.aN(auVar);
                break;
            case 104:
                if (auVar.cjj() || auVar.cjk()) {
                    if (auVar.cjj()) {
                        yc = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yc(auVar.field_imgPath);
                    } else {
                        Xp = aj.Xp(auVar.field_content);
                        g.a I = g.a.I(auVar.field_content, auVar.field_reserved);
                        if (I == null) {
                            I = new g.a();
                            I.hbd = Xp.fqR;
                            aVar = I;
                        } else {
                            aVar = I;
                        }
                        if (!(bh.ov(aVar.hbd) || aVar.hbd.equals("-1"))) {
                            yc = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yc(aVar.hbd);
                        }
                    }
                    str = auVar.field_talker;
                    if (((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(lVar.fhr.csq().getContext(), yc, 0, s.eV(str) ? ba.hP(auVar.field_content) : str)) {
                        lVar.fhr.csB().cbM();
                    }
                }
                aN = true;
                break;
            case 113:
                if (auVar.cjj() || auVar.cjk()) {
                    List linkedList = new LinkedList();
                    linkedList.add(auVar);
                    j.a(lVar.fhr.csq().getContext(), linkedList, lVar.fhr.csd(), lVar.fhr.csi().field_username, null);
                    if (auVar.cjj()) {
                        yc = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yc(auVar.field_imgPath);
                    } else {
                        Xp = aj.Xp(auVar.field_content);
                        if (!(bh.ov(Xp.fqR) || Xp.fqR.equals("-1"))) {
                            yc = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yc(Xp.fqR);
                        }
                    }
                    if (yc != null) {
                        str = lVar.fhr.csi().field_username;
                        if (s.eV(str)) {
                            str = ba.hP(auVar.field_content);
                        }
                        com.tencent.mm.plugin.report.service.g.pQN.h(12789, Integer.valueOf(1), yc.Nr(), Integer.valueOf(0), yc.field_designerID, yc.field_groupId, str, "", "", "", yc.field_activityid);
                    }
                }
                aN = true;
                break;
            case 114:
                if (!auVar.cjj() && !auVar.cjk()) {
                    aN = false;
                    break;
                }
                ah.b(auVar, lVar.fhr.csq().getContext());
                aN = true;
                break;
                break;
            case 127:
                EmojiInfo yc2;
                if (!auVar.cjj()) {
                    Xp = aj.Xp(auVar.field_content);
                    if (!(bh.ov(Xp.fqR) || Xp.fqR.equals("-1"))) {
                        yc2 = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yc(Xp.fqR);
                    }
                    aN = true;
                    break;
                }
                yc2 = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yc(auVar.field_imgPath);
                if (yc2 != null) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(12789, Integer.valueOf(2), yc2.Nr(), Integer.valueOf(0), yc2.field_designerID, yc2.field_groupId, "", "", "", "", "", yc2.field_activityid);
                }
                str = yc2 == null ? "" : yc2.field_groupId;
                if (!bh.ov(str)) {
                    Intent intent = new Intent();
                    intent.putExtra("preceding_scence", 3);
                    intent.putExtra("download_entrance_scene", 16);
                    intent.putExtra("extra_id", str);
                    com.tencent.mm.bm.d.b(lVar.fhr.csq().getContext(), "emoji", ".ui.EmojiStoreDetailUI", intent);
                }
                aN = true;
            default:
                aN = false;
                break;
        }
        if (!aN) {
            int i2;
            Intent intent2;
            Object obj;
            Intent intent3;
            ad adVar = a.yvS;
            switch (menuItem.getItemId()) {
                case 106:
                    r nr = o.TU().nr(auVar.field_imgPath);
                    if (nr == null) {
                        x.e("MicroMsg.ChattingUI.VideoImp", "save video but videoInfo is null!");
                    } else if (nr.status == 199) {
                        o.TU();
                        String nt = com.tencent.mm.modelvideo.s.nt(auVar.field_imgPath);
                        if (nr != null) {
                            i2 = 0;
                            if (s.eV(nr.Ud())) {
                                i2 = m.gl(nr.Ud());
                            }
                            com.tencent.mm.plugin.report.service.g.pQN.a(106, 215, 1, false);
                            com.tencent.mm.plugin.report.service.g.pQN.h(12084, Integer.valueOf(nr.hlp), Integer.valueOf(nr.hVH * 1000), Integer.valueOf(0), Integer.valueOf(2), nr.Ud(), Integer.valueOf(i2), r.nq(nr.Ug()), Long.valueOf(nr.hVE));
                        }
                        str = t.nG(nt);
                        if (bh.ov(str)) {
                            Toast.makeText(adVar.fhr.csq().getContext(), adVar.fhr.csq().getMMString(R.l.eTd), 1).show();
                        } else {
                            Toast.makeText(adVar.fhr.csq().getContext(), adVar.fhr.csq().getMMString(R.l.eTe, str), 1).show();
                            k.b(str, adVar.fhr.csq().getContext());
                        }
                    } else {
                        adVar.dn(nr.getFileName(), 6);
                        intent2 = new Intent(adVar.fhr.csq().getContext(), ImageGalleryUI.class);
                        intent2.putExtra("img_gallery_msg_id", auVar.field_msgId);
                        intent2.putExtra("img_gallery_msg_svr_id", auVar.field_msgSvrId);
                        intent2.putExtra("img_gallery_talker", auVar.field_talker);
                        intent2.putExtra("img_gallery_chatroom_name", auVar.field_talker);
                        intent2.putExtra("img_gallery_enter_video_opcode", t.d(auVar.field_msgId, 2));
                        com.tencent.mm.ui.chatting.b.g.a(adVar.fhr, auVar, intent2);
                        adVar.fhr.csq().startActivity(intent2);
                        adVar.fhr.csq().overridePendingTransition(0, 0);
                    }
                    obj = 1;
                    break;
                case 107:
                    ar.Hg();
                    if (!com.tencent.mm.z.c.isSDCardAvailable()) {
                        u.fI(adVar.fhr.csq().getContext());
                        break;
                    }
                    r nF = t.nF(auVar.field_imgPath);
                    if (nF != null) {
                        if (!auVar.cjs()) {
                            o.TU();
                            if (!com.tencent.mm.ui.chatting.b.g.c(auVar, com.tencent.mm.modelvideo.s.nt(auVar.field_imgPath))) {
                                if (nF.status != 199) {
                                    if (!auVar.cjh() && !auVar.cji()) {
                                        x.w("MicroMsg.ChattingUI.VideoImp", "retranmist video unknow status.");
                                        break;
                                    }
                                    adVar.dn(nF.getFileName(), 3);
                                    intent = new Intent(adVar.fhr.csq().getContext(), ImageGalleryUI.class);
                                    intent.putExtra("img_gallery_msg_id", auVar.field_msgId);
                                    intent.putExtra("img_gallery_msg_svr_id", auVar.field_msgSvrId);
                                    intent.putExtra("img_gallery_talker", auVar.field_talker);
                                    intent.putExtra("img_gallery_chatroom_name", auVar.field_talker);
                                    intent.putExtra("img_gallery_enter_video_opcode", t.d(auVar.field_msgId, 1));
                                    com.tencent.mm.ui.chatting.b.g.a(adVar.fhr, auVar, intent);
                                    adVar.fhr.csq().startActivity(intent);
                                    adVar.fhr.csq().overridePendingTransition(0, 0);
                                    if (!nF.Ui()) {
                                        x.i("MicroMsg.ChattingUI.VideoImp", "start complete offline video");
                                        t.nB(auVar.field_imgPath);
                                        break;
                                    }
                                    x.i("MicroMsg.ChattingUI.VideoImp", "start complete online video");
                                    t.nJ(auVar.field_imgPath);
                                    break;
                                }
                                intent = new Intent(adVar.fhr.csq().getContext(), MsgRetransmitUI.class);
                                intent.putExtra("Retr_length", nF.hVH);
                                intent.putExtra("Retr_File_Name", auVar.field_imgPath);
                                intent.putExtra("Retr_video_isexport", nF.hVL);
                                intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
                                intent.putExtra("Retr_From", "chattingui");
                                x.d("MicroMsg.ChattingUI.VideoImp", "dkvideo msg.getType():" + auVar.getType());
                                if (auVar.cji()) {
                                    intent.putExtra("Retr_Msg_Type", 11);
                                } else {
                                    intent.putExtra("Retr_Msg_Type", 1);
                                }
                                adVar.fhr.csq().startActivity(intent);
                                break;
                            }
                            x.i("MicroMsg.ChattingUI.VideoImp", "video is expired");
                            adVar.dn(nF.getFileName(), 3);
                            intent = new Intent(adVar.fhr.csq().getContext(), ImageGalleryUI.class);
                            intent.putExtra("img_gallery_msg_id", auVar.field_msgId);
                            intent.putExtra("img_gallery_msg_svr_id", auVar.field_msgSvrId);
                            intent.putExtra("img_gallery_talker", auVar.field_talker);
                            intent.putExtra("img_gallery_chatroom_name", auVar.field_talker);
                            intent.putExtra("img_gallery_enter_video_opcode", t.d(auVar.field_msgId, 1));
                            com.tencent.mm.ui.chatting.b.g.a(adVar.fhr, auVar, intent);
                            adVar.fhr.csq().startActivity(intent);
                            adVar.fhr.csq().overridePendingTransition(0, 0);
                            if (!nF.Ui()) {
                                x.i("MicroMsg.ChattingUI.VideoImp", "start complete offline video");
                                t.nB(auVar.field_imgPath);
                                break;
                            }
                            x.i("MicroMsg.ChattingUI.VideoImp", "start complete online video");
                            t.nJ(auVar.field_imgPath);
                            break;
                        }
                        x.i("MicroMsg.ChattingUI.VideoImp", "video is clean!!!");
                        h.a(adVar.fhr.csq().getContext(), adVar.fhr.csq().getContext().getString(R.l.eSR), adVar.fhr.csq().getContext().getString(R.l.dGO), new 2(adVar));
                        break;
                    }
                    x.e("MicroMsg.ChattingUI.VideoImp", "retransmit video but videoInfo is null!");
                    break;
                    break;
                case 129:
                    intent3 = menuItem.getIntent();
                    int i3 = 0;
                    i2 = 0;
                    int[] iArr = new int[2];
                    if (intent3 == null) {
                        x.e("MicroMsg.ChattingUI.VideoImp", "[LONGCLICK_MENU_MUTE_PLAY] intent is null!");
                    } else {
                        i3 = intent3.getIntExtra("img_gallery_width", 0);
                        i2 = intent3.getIntExtra("img_gallery_height", 0);
                        iArr[0] = intent3.getIntExtra("img_gallery_left", 0);
                        iArr[1] = intent3.getIntExtra("img_gallery_top", 0);
                    }
                    intent3 = new Intent(adVar.fhr.csq().getContext(), ImageGalleryUI.class);
                    intent3.putExtra("img_gallery_msg_id", auVar.field_msgId);
                    intent3.putExtra("img_gallery_msg_svr_id", auVar.field_msgSvrId);
                    intent3.putExtra("img_gallery_talker", auVar.field_talker);
                    intent3.putExtra("img_gallery_chatroom_name", auVar.field_talker);
                    intent3.putExtra("img_gallery_left", iArr[0]);
                    intent3.putExtra("img_gallery_top", iArr[1]);
                    intent3.putExtra("img_gallery_width", i3);
                    intent3.putExtra("img_gallery_height", i2);
                    intent3.putExtra("img_gallery_enter_video_opcode", t.d(auVar.field_msgId, 3));
                    com.tencent.mm.ui.chatting.b.g.a(adVar.fhr, auVar, intent3);
                    adVar.fhr.csq().startActivity(intent3);
                    adVar.fhr.csq().overridePendingTransition(0, 0);
                    obj = 1;
                    break;
            }
            obj = null;
            if (obj == null) {
                ac acVar = a.yvI;
                switch (menuItem.getItemId()) {
                    case 124:
                        x.d("MicroMsg.ChattingUI.TranslateImp", "longclick transalte type: %d isShowTranslated: %s", Integer.valueOf(auVar.getType()), Boolean.valueOf(auVar.cjw()));
                        ar.Hg();
                        if (((Boolean) com.tencent.mm.z.c.CU().get(327712, Boolean.valueOf(false))).booleanValue()) {
                            menuItem.getGroupId();
                            acVar.aV(auVar);
                        } else {
                            ar.Hg();
                            com.tencent.mm.z.c.CU().set(327712, Boolean.valueOf(true));
                            i.a aVar2 = new i.a(acVar.fhr.csq().getContext());
                            aVar2.YG(acVar.fhr.csq().getMMString(R.l.dTl));
                            aVar2.YF(acVar.fhr.csq().getMMString(R.l.dTm));
                            aVar2.EC(R.l.epk).a(new 1(acVar, auVar, menuItem));
                            aVar2.akx().show();
                        }
                        obj = 1;
                        break;
                    default:
                        obj = null;
                        break;
                }
                if (obj == null) {
                    e eVar;
                    e bh;
                    com.tencent.mm.ui.chatting.b.o oVar = a.yvN;
                    switch (menuItem.getItemId()) {
                        case 130:
                            x.i("MicroMsg.ChattingUI.GetImageImp", "long click go to photo eidt");
                            intent2 = menuItem.getIntent();
                            if (intent2 != null) {
                                int intExtra = intent2.getIntExtra("img_gallery_width", 0);
                                int intExtra2 = intent2.getIntExtra("img_gallery_height", 0);
                                int[] iArr2 = new int[]{intent2.getIntExtra("img_gallery_left", 0), intent2.getIntExtra("img_gallery_top", 0)};
                                String str2 = null;
                                if (oVar.fhr.csd()) {
                                    str2 = auVar.field_talker;
                                }
                                eVar = null;
                                if (auVar.field_msgId > 0) {
                                    eVar = com.tencent.mm.aq.o.Pw().bi(auVar.field_msgId);
                                }
                                bh = ((eVar == null || eVar.hzP <= 0) && auVar.field_msgSvrId > 0) ? com.tencent.mm.aq.o.Pw().bh(auVar.field_msgSvrId) : eVar;
                                str = bh == null ? "" : com.tencent.mm.aq.o.Pw().m(bh.hzQ, "", "");
                                if (bh == null || bh.status == -1 || auVar.field_status == 5) {
                                    x.e("MicroMsg.ChattingUI.GetImageImp", "raw img not get successfully ,msgId:%s", Long.valueOf(auVar.field_msgId));
                                } else {
                                    x.i("MicroMsg.ChattingUI.GetImageImp", "[LONGCLICK_MENU_PHOTO_EDIT] msgId:%s imgFullPath:%s", Long.valueOf(auVar.field_msgId), str);
                                    x.c.a((a) oVar.fhr.csq(), auVar, auVar.field_msgId, auVar.field_msgSvrId, auVar.field_talker, str2, iArr2, intExtra, intExtra2, true);
                                }
                                obj = 1;
                                break;
                            }
                            x.e("MicroMsg.ChattingUI.GetImageImp", "[LONGCLICK_MENU_PHOTO_EDIT] intent is null!");
                            obj = 1;
                            break;
                        default:
                            obj = null;
                            break;
                    }
                    if (obj == null) {
                        v vVar = a.yvT;
                        switch (menuItem.getItemId()) {
                            case 110:
                                ar.Hg();
                                if (com.tencent.mm.z.c.isSDCardAvailable()) {
                                    eVar = null;
                                    if (auVar.field_msgId > 0) {
                                        eVar = com.tencent.mm.aq.o.Pw().bi(auVar.field_msgId);
                                    }
                                    bh = ((eVar == null || eVar.hzP <= 0) && auVar.field_msgSvrId > 0) ? com.tencent.mm.aq.o.Pw().bh(auVar.field_msgSvrId) : eVar;
                                    if (bh != null) {
                                        if (auVar.field_isSend == 1) {
                                            i2 = bh.Pe() ? 1 : 0;
                                        } else if (bh.Pe()) {
                                            i2 = !com.tencent.mm.a.e.bO(com.tencent.mm.aq.o.Pw().m(f.a(bh).hzQ, "", "")) ? 0 : 1;
                                        } else {
                                            i2 = 0;
                                        }
                                        if (auVar.cjs()) {
                                            x.i("MicroMsg.ChattingUI.SendImgImp", "image is clean!!!");
                                            h.a(vVar.fhr.csq().getContext(), vVar.fhr.csq().getContext().getString(R.l.epm), vVar.fhr.csq().getContext().getString(R.l.dGO), new 3(vVar));
                                        } else if (com.tencent.mm.ui.chatting.b.g.c(auVar, com.tencent.mm.aq.o.Pw().m(f.c(bh), "", ""))) {
                                            x.i("MicroMsg.ChattingUI.SendImgImp", "img is expired or clean!!!");
                                            intent2 = new Intent(vVar.fhr.csq().getContext(), ImageGalleryUI.class);
                                            intent2.putExtra("img_gallery_msg_id", auVar.field_msgId);
                                            intent2.putExtra("img_gallery_msg_svr_id", auVar.field_msgSvrId);
                                            intent2.putExtra("img_gallery_talker", auVar.field_talker);
                                            intent2.putExtra("img_gallery_chatroom_name", auVar.field_talker);
                                            intent2.putExtra("img_gallery_is_restransmit_after_download", true);
                                            intent2.putExtra("Retr_show_success_tips", true);
                                            com.tencent.mm.ui.chatting.b.g.a(vVar.fhr, auVar, intent2);
                                            vVar.fhr.csq().startActivity(intent2);
                                        } else if (bh.offset < bh.hlp || bh.hlp == 0) {
                                            intent = new Intent(vVar.fhr.csq().getContext(), MsgRetransmitUI.class);
                                            intent.putExtra("Retr_File_Name", com.tencent.mm.aq.o.Pw().B(auVar.field_imgPath, true));
                                            intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
                                            intent.putExtra("Retr_Msg_Type", 0);
                                            intent.putExtra("Retr_show_success_tips", true);
                                            intent.putExtra("Retr_Compress_Type", i2);
                                            vVar.fhr.csq().startActivity(intent);
                                        } else {
                                            Intent intent4 = new Intent(vVar.fhr.csq().getContext(), MsgRetransmitUI.class);
                                            intent4.putExtra("Retr_File_Name", com.tencent.mm.aq.o.Pw().m(f.c(bh), "", ""));
                                            intent4.putExtra("Retr_Msg_Id", auVar.field_msgId);
                                            intent4.putExtra("Retr_Msg_Type", 0);
                                            intent4.putExtra("Retr_show_success_tips", true);
                                            intent4.putExtra("Retr_Compress_Type", i2);
                                            vVar.fhr.csq().startActivity(intent4);
                                        }
                                    }
                                } else {
                                    u.fI(vVar.fhr.csq().getContext());
                                }
                                obj = 1;
                                break;
                            default:
                                obj = null;
                                break;
                        }
                        if (obj == null) {
                            ae aeVar = a.yqp;
                            switch (menuItem.getItemId()) {
                                case 109:
                                    ar.Hg();
                                    if (com.tencent.mm.z.c.isSDCardAvailable()) {
                                        n nVar = new n(auVar.field_content);
                                        intent3 = new Intent(aeVar.fhr.csq().getContext(), MsgRetransmitUI.class);
                                        intent3.putExtra("Retr_File_Name", auVar.field_imgPath);
                                        intent3.putExtra("Retr_length", (int) nVar.time);
                                        x.d("MicroMsg.ChattingUI.VoiceImp", "voice msg.getType():" + auVar.getType());
                                        intent3.putExtra("Retr_Msg_Type", 7);
                                        aeVar.fhr.csq().startActivity(intent3);
                                    } else {
                                        u.fI(aeVar.fhr.csq().getContext());
                                    }
                                    obj = 1;
                                    break;
                                default:
                                    obj = null;
                                    break;
                            }
                            if (obj == null) {
                                com.tencent.mm.ui.chatting.b.m mVar = a.yvV;
                                switch (menuItem.getItemId()) {
                                    case 116:
                                        mVar.aO(auVar);
                                        obj = 1;
                                        break;
                                    default:
                                        obj = null;
                                        break;
                                }
                                if (obj == null) {
                                    com.tencent.mm.ui.chatting.b.r rVar = a.yvX;
                                    switch (menuItem.getItemId()) {
                                        case 126:
                                            if (auVar.aNe()) {
                                                List linkedList2 = new LinkedList();
                                                linkedList2.add(auVar);
                                                j.a(rVar.fhr.csq().getContext(), linkedList2, rVar.fhr.csd(), rVar.fhr.csi().field_username, null);
                                            }
                                            obj = 1;
                                            break;
                                        default:
                                            obj = null;
                                            break;
                                    }
                                    if (obj == null) {
                                        switch (menuItem.getItemId()) {
                                            case 100:
                                                aeVar = a.yqp;
                                                if (auVar.ciW()) {
                                                    if (auVar.field_msgId == aeVar.ysR.yqm) {
                                                        aeVar.ysR.crh();
                                                    }
                                                    obj = 1;
                                                } else {
                                                    obj = null;
                                                }
                                                if (obj == null) {
                                                    if (auVar.aNc()) {
                                                        com.tencent.mm.ui.chatting.b.s sVar = a.yvK;
                                                        ar.Dm().F(new com.tencent.mm.ui.chatting.b.s.2(sVar, auVar.field_content, sVar.fhr.csi().field_username, auVar.field_msgId));
                                                    } else if (auVar.cjh()) {
                                                        com.tencent.mm.pluginsdk.model.k.Rw(auVar.field_imgPath);
                                                    }
                                                }
                                                ba.aK(auVar.field_msgId);
                                                if (auVar.aNc()) {
                                                    b.hPA.c(auVar, com.tencent.mm.y.h.g(auVar));
                                                } else {
                                                    b.hPA.v(auVar);
                                                }
                                                x.i("MicroMsg.ChattingUI", "delete msg, id:%d", Long.valueOf(auVar.field_msgId));
                                                if (!a.fAh.field_username.equals("medianote")) {
                                                    ar.Hg();
                                                    com.tencent.mm.z.c.EX().b(new com.tencent.mm.ay.e(auVar.field_talker, auVar.field_msgSvrId));
                                                }
                                                if (auVar.field_status == 1 && auVar.field_isSend == 1) {
                                                    x.d("MicroMsg.ChattingUI", "delete a sending msg, publish SendMsgFailEvent");
                                                    com.tencent.mm.sdk.b.b osVar = new os();
                                                    osVar.fGK.fnB = auVar;
                                                    com.tencent.mm.sdk.b.a.xef.m(osVar);
                                                    return;
                                                }
                                                return;
                                            case 102:
                                                str = ((au) a.ysf.getItem(menuItem.getGroupId())).field_content;
                                                x.d("MicroMsg.ChattingUI", "groupId = " + menuItem.getGroupId() + ", content length: " + (str == null ? 0 : str.length()));
                                                Object aA = a.aA((au) a.ysf.getItem(menuItem.getGroupId()));
                                                try {
                                                    a.mxl.setText(aA);
                                                } catch (Exception e) {
                                                    x.e("MicroMsg.ChattingUI", "clip.setText error ");
                                                }
                                                h.bu(a.getContext(), a.getContext().getString(R.l.dEt));
                                                i2 = com.tencent.mm.plugin.secinforeport.a.a.qff;
                                                com.tencent.mm.plugin.secinforeport.a.a.d(1, ((au) a.ysf.getItem(menuItem.getGroupId())).field_msgSvrId, bh.Vy(aA));
                                                return;
                                            case 103:
                                                if (!a.yqp.aP(auVar) && !a.yvT.aP(auVar)) {
                                                    if (auVar.cjg()) {
                                                        a.ywb.aH(auVar);
                                                        return;
                                                    } else if (!a.yvX.aP(auVar)) {
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                }
                                                return;
                                            case 108:
                                                intent = new Intent(a.getContext(), MsgRetransmitUI.class);
                                                str = a.aA((au) a.ysf.getItem(menuItem.getGroupId()));
                                                if (auVar.ciZ()) {
                                                    intent.putExtra("Retr_Msg_content", str);
                                                    intent.putExtra("Retr_Msg_Type", 6);
                                                } else {
                                                    intent.putExtra("Retr_Msg_content", str);
                                                    intent.putExtra("Retr_Msg_Type", 4);
                                                }
                                                a.startActivity(intent);
                                                return;
                                            case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
                                                ar.Hg();
                                                if (com.tencent.mm.z.c.isSDCardAvailable()) {
                                                    eVar = null;
                                                    if (auVar.field_msgId > 0) {
                                                        eVar = com.tencent.mm.aq.o.Pw().bi(auVar.field_msgId);
                                                    }
                                                    if ((eVar == null || eVar.hzP <= 0) && auVar.field_msgSvrId > 0) {
                                                        eVar = com.tencent.mm.aq.o.Pw().bh(auVar.field_msgSvrId);
                                                    }
                                                    if (eVar != null) {
                                                        CharSequence m = com.tencent.mm.aq.o.Pw().m(eVar.hzQ, "", "");
                                                        if (com.tencent.mm.a.e.bO(m)) {
                                                            com.tencent.mm.pluginsdk.h.c.a(a.getContext(), a.getMMString(R.l.dGj), m);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                u.fI(a.getContext());
                                                return;
                                            case 114:
                                                if (auVar.cjg()) {
                                                    ah.k(a.dk(auVar.field_content, auVar.field_isSend), a.getContext());
                                                } else if (auVar.ciW()) {
                                                    Context context = a.getContext();
                                                    if (context == null) {
                                                        x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: context is null");
                                                    } else if (auVar == null) {
                                                        x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: msg is null");
                                                    } else {
                                                        ar.Hg();
                                                        if (com.tencent.mm.z.c.isSDCardAvailable()) {
                                                            ah.a(ah.dj(com.tencent.mm.ag.f.LM()), context, new 4(auVar, context));
                                                        } else {
                                                            u.fI(context);
                                                            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: sd card not available");
                                                        }
                                                    }
                                                } else if (auVar.cje()) {
                                                    ah.a(auVar, a.getContext(), bVar.a(a, auVar), a.ysk);
                                                } else if (auVar.cjh()) {
                                                    ah.a(auVar, a.getContext());
                                                } else if (auVar.aNe()) {
                                                    str = auVar.field_content;
                                                    r3 = a.getContext();
                                                    if (r3 == null) {
                                                        x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptLocationConnector: context is null");
                                                    } else if (bh.ov(str)) {
                                                        x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptLocationConnector: locationXML is null");
                                                    } else {
                                                        ah.a(ah.dj(com.tencent.mm.ag.f.LP()), r3, new 7(str, r3));
                                                    }
                                                } else if (auVar.cjf()) {
                                                    str = auVar.field_content;
                                                    r3 = a.getContext();
                                                    if (r3 == null) {
                                                        x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptPersonalCardConnector: context is null");
                                                    } else if (bh.ov(str)) {
                                                        x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptPersonalCardConnector: locationXML is null");
                                                    } else {
                                                        ah.a(ah.dj(com.tencent.mm.ag.f.LR()), r3, new 8(str, r3));
                                                    }
                                                }
                                                x.i("MicroMsg.ChattingUI", "type is %d", Integer.valueOf(auVar.getType()));
                                                return;
                                            case 122:
                                                if (a.ywE == null) {
                                                    if (a.ywD == null) {
                                                        ViewStub viewStub = (ViewStub) a.findViewById(R.h.cVS);
                                                        if (viewStub != null) {
                                                            viewStub.inflate();
                                                        }
                                                        a.ywD = (ChattingFooterMoreBtnBar) a.findViewById(R.h.bUa);
                                                    }
                                                    a.ywE = new com.tencent.mm.ui.chatting.s(a, a.ywD, a.ysf, a.ywe.csB(), a.ywe.csC(), a.fAh, a.ypn);
                                                } else {
                                                    a.ywE.b(a.fAh, a.ypn);
                                                }
                                                a.ywD.crG();
                                                a.ywE.aw(auVar);
                                                a.ywE.ysa = a.yvY.yAM;
                                                if (a.fAh.cia()) {
                                                    a.removeOptionMenu(R.h.cvP);
                                                }
                                                a.csU();
                                                return;
                                            case 123:
                                                x.d("MicroMsg.ChattingUI", "[oneliang][longclick_menu_revoke] type:%d,item.getGroupId:%d", Integer.valueOf(auVar.getType()), Integer.valueOf(menuItem.getGroupId()));
                                                a.ywG = menuItem.getGroupId();
                                                com.tencent.mm.ae.k zVar = new z(auVar, a.getMMString(R.l.dSM));
                                                a.tipDialog = h.a(a.getContext(), a.getMMString(R.l.dSL), true, new 24(a, auVar, zVar));
                                                ar.CG().a(zVar, 0);
                                                return;
                                            case FileUtils.S_IWUSR /*128*/:
                                                aVar = g.a.fT(a.dk(auVar.field_content, auVar.field_isSend));
                                                intent3 = new Intent(a.getContext(), ChattingSendDataToDeviceUI.class);
                                                obj = 1;
                                                if (aVar != null && (aVar.type == 6 || aVar.type == 2)) {
                                                    com.tencent.mm.pluginsdk.model.app.b Rz = an.aqd().Rz(aVar.fny);
                                                    if (Rz == null || !FileOp.bO(Rz.field_fileFullPath)) {
                                                        obj = null;
                                                    }
                                                } else if (auVar.cje()) {
                                                    com.tencent.mm.aq.o.Pw();
                                                    if (bh.ov(com.tencent.mm.aq.g.p(auVar))) {
                                                        obj = null;
                                                    }
                                                }
                                                if (auVar.cjh()) {
                                                    o.TU();
                                                    if (!FileOp.bO(com.tencent.mm.modelvideo.s.nt(auVar.field_imgPath))) {
                                                        obj = null;
                                                    }
                                                } else if (auVar.cji()) {
                                                    o.TU();
                                                    if (!FileOp.bO(com.tencent.mm.modelvideo.s.nt(auVar.field_imgPath))) {
                                                        obj = null;
                                                    }
                                                }
                                                if (obj == null) {
                                                    h.a(a.getContext(), a.getMMString(R.l.dXB), "", new 14(a), null);
                                                    return;
                                                }
                                                intent3.putExtra("exdevice_open_scene_type", 1);
                                                intent3.putExtra("Retr_Msg_Id", auVar.field_msgId);
                                                a.startActivity(intent3);
                                                return;
                                            case com.tencent.mm.plugin.appbrand.jsapi.map.d.CTRL_INDEX /*133*/:
                                                ar.Hg();
                                                if (((Boolean) com.tencent.mm.z.c.CU().get(w.a.USERINFO_POSITION_REMIND_MSG_TIP_IN_BOOLEAN, Boolean.valueOf(true))).booleanValue()) {
                                                    h.a(a.getContext(), a.getMMString(R.l.eEw), a.getMMString(R.l.eEx), new 15(a, auVar));
                                                    ar.Hg();
                                                    com.tencent.mm.z.c.CU().a(w.a.USERINFO_POSITION_REMIND_MSG_TIP_IN_BOOLEAN, Boolean.valueOf(false));
                                                    return;
                                                }
                                                a.az(auVar);
                                                return;
                                            default:
                                                return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
