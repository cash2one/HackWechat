package com.tencent.mm.plugin.sns.ui.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.MenuItem;
import android.view.View;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.qn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.plugin.sns.a.b.j$e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ad;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.ao.b;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.FlipView;
import com.tencent.mm.plugin.sns.ui.SnsBrowseUI;
import com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity;
import com.tencent.mm.plugin.sns.ui.SnsPermissionUI;
import com.tencent.mm.plugin.sns.ui.ap;
import com.tencent.mm.plugin.sns.ui.as;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bmf;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.vd;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import com.tencent.mm.z.u;
import java.net.URLEncoder;
import java.util.Map;

public final class a implements e, d {
    private Activity activity;
    private ClipboardManager mxl;
    private View rPl;
    private String rPm;
    private bnp rPn;
    private r rrH;
    private ad rrV;
    private int scene;

    public a(Activity activity, int i, ad adVar) {
        this.activity = activity;
        this.scene = i;
        this.mxl = (ClipboardManager) activity.getSystemService("clipboard");
        this.rrV = adVar;
    }

    public final void a(View view, String str, bnp com_tencent_mm_protocal_c_bnp) {
        this.rPl = view;
        this.rPm = str;
        this.rPn = com_tencent_mm_protocal_c_bnp;
    }

    private String bCn() {
        if (this.rPl != null && (this.rPl.getTag() instanceof as) && ((as) this.rPl.getTag()).bBp()) {
            b Kr = ao.Kr(ae.bvv().Lm(this.rPm).bxW());
            if (Kr != null) {
                return Kr.result;
            }
        }
        return null;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (this.rPl != null) {
            int i2;
            com.tencent.mm.sdk.b.b cfVar;
            m Lm;
            ap apVar;
            String str;
            m Lm2;
            aqr a;
            k cVar;
            String str2;
            String str3;
            String Md;
            m Lm3;
            u.b t;
            long Wo;
            m Lm4;
            bnp com_tencent_mm_protocal_c_bnp;
            ve veVar;
            vk vkVar;
            com.tencent.mm.plugin.sns.ui.m mVar;
            Context context;
            Intent intent;
            com.tencent.mm.sdk.b.b cfVar2;
            com.tencent.mm.modelsns.b iu;
            Intent intent2;
            switch (menuItem.getItemId()) {
                case 0:
                    Object bCn = bCn();
                    if (bh.ov(bCn)) {
                        bCn = this.rPn.wQl;
                    }
                    this.mxl.setText(bCn);
                    h.bu(this.activity, this.activity.getString(j.dEt));
                    i2 = com.tencent.mm.plugin.secinforeport.a.a.qff;
                    com.tencent.mm.plugin.secinforeport.a.a.d(2, this.rPn.nGJ, bh.Vy(bCn));
                    return;
                case 1:
                    CharSequence bCn2 = bCn();
                    if (bh.ov(bCn2)) {
                        bCn2 = this.rPn.wQl;
                    }
                    this.rrV.bva().ef(this.rPm, this.rPn.nGJ);
                    cfVar = new cf();
                    com.tencent.mm.plugin.sns.i.a.a(cfVar, this.rPm, bCn2);
                    cfVar.fqp.activity = this.activity;
                    cfVar.fqp.fqw = 30;
                    com.tencent.mm.sdk.b.a.xef.m(cfVar);
                    return;
                case 2:
                    this.rrV.bva().ef(this.rPm, this.rPn.nGJ);
                    cfVar = new cf();
                    Lm = com.tencent.mm.plugin.sns.storage.h.Lm(this.rPm);
                    if (Lm.xl(32) && Lm.bxR().bwt()) {
                        Me(this.rPm);
                    } else {
                        apVar = (ap) this.rPl.getTag();
                        str = this.rPm;
                        int i3 = apVar.index;
                        if (com.tencent.mm.plugin.sns.storage.u.LI(str) || i3 < 0) {
                            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or position errro");
                            cfVar.fqp.fqv = j.efh;
                        } else if (ae.bve()) {
                            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
                            cfVar.fqp.fqv = j.qJx;
                        } else {
                            Lm2 = ae.bvv().Lm(str);
                            if (Lm2 == null) {
                                x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                                cfVar.fqp.fqv = j.efi;
                            } else {
                                a = ai.a(Lm2, i3);
                                if (a == null) {
                                    x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, media obj is null");
                                    cfVar.fqp.fqv = j.efi;
                                } else {
                                    com.tencent.mm.plugin.sns.i.a.a(cfVar, Lm2, a.nGJ);
                                }
                            }
                        }
                        cfVar.fqp.activity = this.activity;
                        cfVar.fqp.fqw = 31;
                        com.tencent.mm.sdk.b.a.xef.m(cfVar);
                    }
                    if (Lm.xl(32)) {
                        cVar = new c(Lm.byz(), 11, this.scene == 0 ? 1 : 2, "", Lm.byD(), Lm.bxW());
                        g.Dk();
                        g.Di().gPJ.a(cVar, 0);
                        return;
                    }
                    return;
                case 3:
                    this.rrV.bva().ef(this.rPm, this.rPn.nGJ);
                    str2 = this.rPn.wQo.nfX;
                    str3 = this.rPn.wQn.nGJ;
                    Md = av.Md(str2);
                    if (bh.ov(Md)) {
                        x.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite url fail, url is null");
                        return;
                    }
                    com.tencent.mm.sdk.b.b cfVar3 = new cf();
                    Lm3 = com.tencent.mm.plugin.sns.storage.h.Lm(this.rPm);
                    if (Lm3 != null) {
                        str3 = u.hz(Lm3.field_snsId);
                        t = u.GK().t(str3, true);
                        t.o("prePublishId", "sns_" + i.eq(Lm3.field_snsId));
                        t.o("preUsername", Lm3.field_userName);
                        t.o("preChatName", "");
                        t.o(SlookSmartClipMetaTag.TAG_TYPE_URL, Md);
                        t.o("preMsgIndex", Integer.valueOf(0));
                        t.o("sendAppMsgScene", Integer.valueOf(1));
                        t.o("adExtStr", Lm3.bxV().rtA);
                        cfVar3.fqp.fqu = str3;
                    }
                    Lm = ae.bvv().Lm(this.rPm);
                    if (Lm != null && this.rPn.wQo.vYc == 18) {
                        com.tencent.mm.plugin.sns.a.b.j.a(com.tencent.mm.plugin.sns.a.b.j.d.qQg, com.tencent.mm.plugin.sns.a.b.j.c.qQa, j$e.Samll, 0, Lm);
                    }
                    if (bh.ov(this.rPn.rLO)) {
                        if (Lm.xl(32)) {
                            cVar = new c(Lm.byz(), 11, this.scene == 0 ? 1 : 2, "", Lm.byD(), Lm.bxW());
                            g.Dk();
                            g.Di().gPJ.a(cVar, 0);
                        }
                        com.tencent.mm.plugin.sns.i.a.a(cfVar3, Md, this.rPm);
                        cfVar3.fqp.activity = this.activity;
                        cfVar3.fqp.fqw = 28;
                        com.tencent.mm.sdk.b.a.xef.m(cfVar3);
                        if (cfVar3.fqq.ret == 0) {
                            Wo = bh.Wo();
                            if (!bh.ov(Md)) {
                                x.d("MicroMsg.TimeLineMMMenuItemSelectedListener", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13378), Md, Long.valueOf(Wo), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1)});
                                str2 = "";
                                try {
                                    str2 = URLEncoder.encode(Md, "UTF-8");
                                } catch (Throwable e) {
                                    x.printErrStackTrace("MicroMsg.TimeLineMMMenuItemSelectedListener", e, "", new Object[0]);
                                }
                                com.tencent.mm.plugin.report.service.g.pQN.h(13378, new Object[]{str2, Long.valueOf(Wo), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1)});
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    Me(Lm.byq());
                    return;
                case 4:
                    this.rrV.bva().ef(this.rPm, this.rPn.nGJ);
                    Lm4 = ae.bvv().Lm(this.rPm);
                    if (this.rPn.wQo.vYd.size() != 0) {
                        a = (aqr) this.rPn.wQo.vYd.get(0);
                        if (Lm4 == null || a == null) {
                            x.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite music fail, snsinfo or mediaobj is null");
                            return;
                        }
                        com.tencent.mm.sdk.b.b cfVar4 = new cf();
                        if (a == null || Lm4 == null || Lm4.roJ == 0) {
                            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or media is null");
                            cfVar4.fqp.fqv = j.efh;
                        } else if (ae.bve()) {
                            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
                            cfVar4.fqp.fqv = j.qJx;
                        } else {
                            String eq = i.eq(Lm4.field_snsId);
                            eq = String.format("%s#%s", new Object[]{eq, a.nGJ});
                            ve veVar2 = new ve();
                            vk vkVar2 = new vk();
                            x.i("MicroMsg.Sns.GetFavDataSource", "fav sns music, from %s", new Object[]{Lm4.field_userName});
                            vkVar2.Ui(Lm4.field_userName);
                            vkVar2.Uj(q.FS());
                            vkVar2.CS(2);
                            vkVar2.fC(((long) Lm4.field_createTime) * 1000);
                            vkVar2.Un(Lm4.bxW());
                            vkVar2.Uk(eq);
                            uq uqVar = new uq();
                            uqVar.TI(eq);
                            uqVar.Tx(a.nfX);
                            uqVar.Ty(a.wxI);
                            uqVar.Tw(Lm4.bxV().wQo.nfX);
                            eq = am.r(ae.getAccSnsPath(), a.nGJ) + i.e(a);
                            if (FileOp.bO(eq)) {
                                uqVar.TF(eq);
                            } else {
                                uqVar.lt(true);
                                uqVar.Tz(a.wxE);
                                vt vtVar = new vt();
                                vtVar.Uy(a.wxE);
                                veVar2.b(vtVar);
                            }
                            uqVar.CJ(7);
                            uqVar.Tq(a.fon);
                            uqVar.Tr(a.nfe);
                            uqVar.ls(true);
                            veVar2.weU.add(uqVar);
                            veVar2.a(vkVar2);
                            cfVar4.fqp.fqr = veVar2;
                            cfVar4.fqp.type = 7;
                            com.tencent.mm.plugin.sns.i.a.a(uqVar, Lm4);
                        }
                        cfVar4.fqp.activity = this.activity;
                        cfVar4.fqp.fqw = 25;
                        com.tencent.mm.sdk.b.a.xef.m(cfVar4);
                        return;
                    }
                    return;
                case 5:
                    this.rrV.bva().ef(this.rPm, this.rPn.nGJ);
                    if (this.rPn != null) {
                        cfVar = new cf();
                        com_tencent_mm_protocal_c_bnp = this.rPn;
                        if (com_tencent_mm_protocal_c_bnp == null) {
                            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or tlObj is null");
                            cfVar.fqp.fqv = j.efh;
                        } else {
                            veVar = new ve();
                            vkVar = new vk();
                            vd vdVar = new vd();
                            vkVar.Ui(com_tencent_mm_protocal_c_bnp.ksU);
                            vkVar.Uj(q.FS());
                            vkVar.CS(2);
                            vkVar.fC(bh.Wp());
                            if (com_tencent_mm_protocal_c_bnp.wQn != null) {
                                vkVar.Uo(com_tencent_mm_protocal_c_bnp.wQn.nGJ);
                            }
                            if (com_tencent_mm_protocal_c_bnp.wQo != null) {
                                vdVar.Ub(com_tencent_mm_protocal_c_bnp.wQo.fon);
                                vdVar.Uc(com_tencent_mm_protocal_c_bnp.wQo.nfe);
                                if (!(com_tencent_mm_protocal_c_bnp.wQo.vYd == null || com_tencent_mm_protocal_c_bnp.wQo.vYd.isEmpty())) {
                                    a = (aqr) com_tencent_mm_protocal_c_bnp.wQo.vYd.get(0);
                                    vdVar.CP(a.fpn);
                                    vdVar.Ue(a.rsn);
                                    vdVar.Ud(a.wxE);
                                }
                            }
                            cfVar.fqp.title = vdVar.title;
                            cfVar.fqp.desc = vdVar.desc;
                            cfVar.fqp.fqr = veVar;
                            cfVar.fqp.type = 10;
                            veVar.a(vkVar);
                            veVar.b(vdVar);
                        }
                        cfVar.fqp.activity = this.activity;
                        cfVar.fqp.fqw = 26;
                        com.tencent.mm.sdk.b.a.xef.m(cfVar);
                        return;
                    }
                    return;
                case 7:
                    com.tencent.mm.plugin.sns.model.q qVar;
                    str = ae.bvv().Lm(this.rPm).bxW();
                    mVar = (com.tencent.mm.plugin.sns.ui.m) this.rPl.getTag();
                    k qVar2;
                    if (com.tencent.mm.plugin.sns.storage.u.LE(str)) {
                        qVar2 = new com.tencent.mm.plugin.sns.model.q(com.tencent.mm.plugin.sns.storage.u.LF(str), 6, mVar.qTX);
                        g.Dk();
                        g.Di().gPJ.a(qVar2, 0);
                        qVar = qVar2;
                    } else {
                        qVar2 = new com.tencent.mm.plugin.sns.model.q(com.tencent.mm.plugin.sns.storage.u.LF(str), 4, mVar.qTX);
                        g.Dk();
                        g.Di().gPJ.a(qVar2, 0);
                        cVar = qVar2;
                    }
                    context = this.activity;
                    this.activity.getString(j.dGO);
                    this.rrH = h.a(context, this.activity.getString(j.qKt), true, new 1(this, qVar));
                    return;
                case 8:
                    Lm3 = ae.bvv().Lm(this.rPm);
                    if (Lm3 != null) {
                        com.tencent.mm.plugin.sns.abtest.a.b(Lm3);
                        intent = new Intent();
                        intent.putExtra("sns_permission_snsinfo_svr_id", Lm3.field_snsId);
                        intent.putExtra("sns_permission_userName", Lm3.field_userName);
                        intent.putExtra("sns_permission_anim", true);
                        intent.setClass(this.activity, SnsPermissionUI.class);
                        this.activity.startActivityForResult(intent, 11);
                        return;
                    }
                    return;
                case 9:
                    this.rrV.bva().ef(this.rPm, this.rPn.nGJ);
                    if (this.rPn != null) {
                        cfVar = new cf();
                        com_tencent_mm_protocal_c_bnp = this.rPn;
                        if (com_tencent_mm_protocal_c_bnp == null) {
                            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or tlObj is null");
                            cfVar.fqp.fqv = j.efh;
                        } else {
                            veVar = new ve();
                            vkVar = new vk();
                            vn vnVar = new vn();
                            vkVar.Ui(com_tencent_mm_protocal_c_bnp.ksU);
                            vkVar.Uj(q.FS());
                            vkVar.CS(8);
                            vkVar.fC(bh.Wp());
                            if (com_tencent_mm_protocal_c_bnp.wQn != null) {
                                vkVar.Uo(com_tencent_mm_protocal_c_bnp.wQn.nGJ);
                            }
                            if (com_tencent_mm_protocal_c_bnp.wQo != null) {
                                vnVar.Ur(com_tencent_mm_protocal_c_bnp.wQo.fon);
                                vnVar.Us(com_tencent_mm_protocal_c_bnp.wQo.nfe);
                                if (!(com_tencent_mm_protocal_c_bnp.wQo.vYd == null || com_tencent_mm_protocal_c_bnp.wQo.vYd.isEmpty())) {
                                    a = (aqr) com_tencent_mm_protocal_c_bnp.wQo.vYd.get(0);
                                    vnVar.Uu(a.rsn);
                                    vnVar.Ut(a.wxE);
                                }
                            }
                            cfVar.fqp.title = vnVar.title;
                            cfVar.fqp.desc = vnVar.desc;
                            cfVar.fqp.fqr = veVar;
                            cfVar.fqp.type = 15;
                            veVar.a(vkVar);
                            veVar.b(vnVar);
                        }
                        cfVar.fqp.activity = this.activity;
                        cfVar.fqp.fqw = 27;
                        com.tencent.mm.sdk.b.a.xef.m(cfVar);
                        return;
                    }
                    return;
                case 10:
                    this.rrV.bva().ef(this.rPm, this.rPn.nGJ);
                    Lm3 = com.tencent.mm.plugin.sns.storage.h.Lm(this.rPm);
                    if (Lm3.xl(32) && Lm3.bxR().bwt()) {
                        Lm = ae.bvv().Lm(this.rPm);
                        if (Lm != null && Lm.xl(32)) {
                            cVar = new c(Lm.byz(), 11, this.scene == 0 ? 1 : 2, "", 2, Lm.bxW());
                            g.Dk();
                            g.Di().gPJ.a(cVar, 0);
                        }
                        Me(this.rPm);
                        return;
                    }
                    m Lm5 = ae.bvv().Lm(this.rPm);
                    if (Lm5 != null) {
                        if (Lm5.xl(32)) {
                            com.tencent.mm.plugin.sns.a.b.j.a(com.tencent.mm.plugin.sns.a.b.j.d.qQf, com.tencent.mm.plugin.sns.a.b.j.c.qQa, j$e.Samll, 0, Lm5);
                            cVar = new c(Lm5.byz(), 11, this.scene == 0 ? 1 : 2, "", Lm5.byD(), Lm5.bxW());
                            g.Dk();
                            g.Di().gPJ.a(cVar, 0);
                        }
                        cfVar2 = new cf();
                        com.tencent.mm.plugin.sns.i.a.a(cfVar2, Lm5);
                        cfVar2.fqp.activity = this.activity;
                        cfVar2.fqp.fqw = 29;
                        com.tencent.mm.sdk.b.a.xef.m(cfVar2);
                        return;
                    }
                    return;
                case 11:
                    if (this.rPl.getTag() instanceof com.tencent.mm.plugin.sns.ui.m) {
                        mVar = (com.tencent.mm.plugin.sns.ui.m) this.rPl.getTag();
                        this.mxl.setText(mVar.nje);
                        h.bu(this.activity, this.activity.getString(j.dEt));
                        if (mVar.qTX != null) {
                            i2 = com.tencent.mm.plugin.secinforeport.a.a.qff;
                            com.tencent.mm.plugin.secinforeport.a.a.d(4, this.rPn.nGJ + ":" + mVar.qTX.wMw, bh.Vy(mVar.nje));
                            return;
                        }
                        return;
                    }
                    return;
                case 12:
                    a = (aqr) this.rPn.wQo.vYd.get(0);
                    str2 = am.r(ae.getAccSnsPath(), a.nGJ) + i.e(a);
                    intent = new Intent();
                    intent.putExtra("Select_Conv_Type", 3);
                    intent.putExtra("select_is_ret", true);
                    intent.putExtra("mutil_select_is_ret", true);
                    intent.putExtra("image_path", str2);
                    intent.putExtra("Retr_Msg_Type", 11);
                    com.tencent.mm.bm.d.a(this.activity, ".ui.transmit.SelectConversationUI", intent, 15);
                    return;
                case 13:
                    com.tencent.mm.plugin.sns.abtest.a.a(this.activity, ae.bvv().Lm(this.rPm));
                    return;
                case 14:
                    Lm4 = ae.bvv().Lm(this.rPm);
                    if (Lm4 != null) {
                        if (this.scene == 0) {
                            iu = com.tencent.mm.modelsns.b.iu(714);
                        } else {
                            iu = com.tencent.mm.modelsns.b.iv(714);
                        }
                        iu.mB(i.g(Lm4)).ix(Lm4.field_type).bU(Lm4.xl(32)).mB(Lm4.byA());
                        iu.Sx();
                    }
                    ao.o(Lm4);
                    return;
                case 15:
                    if (this.rPl.getTag() instanceof com.tencent.mm.plugin.sns.ui.m) {
                        mVar = (com.tencent.mm.plugin.sns.ui.m) this.rPl.getTag();
                        Lm2 = ae.bvv().Ll(mVar.rse);
                        if (Lm2 != null) {
                            com.tencent.mm.modelsns.b iu2;
                            if (this.scene == 0) {
                                iu2 = com.tencent.mm.modelsns.b.iu(715);
                            } else {
                                iu2 = com.tencent.mm.modelsns.b.iv(715);
                            }
                            iu2.mB(i.g(Lm2)).ix(Lm2.field_type).bU(Lm2.xl(32)).mB(Lm2.byA());
                            if (mVar.qTX != null) {
                                iu2.mB(mVar.qTX.wMw == 0 ? mVar.qTX.wMz : mVar.qTX.wMw);
                            } else {
                                iu2.mB("");
                            }
                            iu2.Sx();
                        }
                        ao.a((com.tencent.mm.plugin.sns.ui.m) this.rPl.getTag());
                        return;
                    }
                    return;
                case 16:
                    ao.p(ae.bvv().Lm(this.rPm));
                    return;
                case 17:
                    if (this.rPl.getTag() instanceof com.tencent.mm.plugin.sns.ui.m) {
                        ao.b((com.tencent.mm.plugin.sns.ui.m) this.rPl.getTag());
                        return;
                    }
                    return;
                case 18:
                    context = this.activity;
                    Lm2 = ae.bvv().Lm(this.rPm);
                    if (Lm2 != null) {
                        intent2 = new Intent();
                        if (Lm2.bxV().wQo.vYc == 1) {
                            apVar = (ap) this.rPl.getTag();
                            aqr a2 = ai.a(Lm2, apVar.index);
                            if (a2 == null) {
                                x.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "send photo fail, mediaObj is null");
                                return;
                            } else {
                                intent2.putExtra("sns_send_data_ui_image_path", FlipView.f(am.r(ae.getAccSnsPath(), a2.nGJ) + i.l(a2), context));
                                intent2.putExtra("sns_send_data_ui_image_position", apVar.index);
                            }
                        } else if ((Lm2.bxV().wQo.vYc == 4 || Lm2.bxV().wQo.vYc == 15 || Lm2.bxV().wQo.vYc == 3) && ((aqr) Lm2.bxV().wQo.vYd.get(0)) == null) {
                            x.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mediaObj is null, send failed!");
                            return;
                        }
                        intent2.putExtra("exdevice_open_scene_type", 1);
                        intent2.putExtra("sns_local_id", this.rPm);
                        intent2.putExtra("sns_send_data_ui_activity", true);
                        com.tencent.mm.bm.d.a(this.activity, ".ui.chatting.ChattingSendDataToDeviceUI", intent2);
                        return;
                    }
                    return;
                case 19:
                    Lm3 = ae.bvv().Lm(this.rPm);
                    if (Lm3 == null) {
                        x.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but sns info is null.");
                        return;
                    } else if (Lm3.xl(32)) {
                        x.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but it is ad");
                        return;
                    } else {
                        a = (aqr) Lm3.bxV().wQo.vYd.get(0);
                        if (a == null) {
                            x.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute paly video but media is null");
                            return;
                        }
                        str = am.r(ae.getAccSnsPath(), a.nGJ);
                        str3 = "";
                        if (FileOp.bO(str + i.j(a))) {
                            str3 = str + i.e(a);
                        }
                        if (FileOp.bO(str + i.p(a))) {
                            str3 = str + i.n(a);
                        }
                        Intent intent3 = new Intent();
                        intent3.setClass(this.activity, SnsOnlineVideoActivity.class);
                        intent3.putExtra("intent_thumbpath", str3);
                        intent3.putExtra("intent_localid", this.rPm);
                        intent3.putExtra("intent_from_scene", this.scene);
                        intent3.putExtra("intent_ismute", true);
                        if (this.rPl != null) {
                            int[] iArr = new int[2];
                            this.rPl.getLocationInWindow(iArr);
                            int width = this.rPl.getWidth();
                            int height = this.rPl.getHeight();
                            intent3.putExtra("img_gallery_left", iArr[0]);
                            intent3.putExtra("img_gallery_top", iArr[1]);
                            intent3.putExtra("img_gallery_width", width);
                            intent3.putExtra("img_gallery_height", height);
                        }
                        this.activity.startActivity(intent3);
                        this.activity.overridePendingTransition(0, 0);
                        return;
                    }
                case 20:
                    this.rrV.bva().ef(this.rPm, this.rPn.nGJ);
                    Lm3 = com.tencent.mm.plugin.sns.storage.h.Lm(this.rPm);
                    if (Lm3.xl(32) && Lm3.bxR().bwt()) {
                        Lm = ae.bvv().Lm(this.rPm);
                        if (Lm != null && Lm.xl(32)) {
                            if (this.rPn == null || this.rPn.wQo.vYc != 15 || this.rPn.wQv == 1) {
                                cVar = new c(Lm.byz(), 11, this.scene == 0 ? 1 : 2, "", 4, Lm.bxW());
                                g.Dk();
                                g.Di().gPJ.a(cVar, 0);
                            } else {
                                cVar = new c(Lm.byz(), 11, this.scene == 0 ? 1 : 2, "", 5, Lm.bxW());
                                g.Dk();
                                g.Di().gPJ.a(cVar, 0);
                            }
                        }
                        Me(this.rPm);
                        return;
                    }
                    m Lm6 = ae.bvv().Lm(this.rPm);
                    str2 = null;
                    if (Lm6 != null && Lm6.xl(32)) {
                        str2 = Lm6.byy();
                        if (bh.ov(str2)) {
                            str2 = Lm6.byx();
                        }
                    }
                    if (bh.ov(str2)) {
                        str2 = this.rPn.wQo.nfX;
                        str3 = this.rPn.wQn.nGJ;
                        Md = av.Md(str2);
                    } else {
                        Md = str2;
                    }
                    if (bh.ov(Md)) {
                        x.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite url fail, url is null");
                        return;
                    }
                    com.tencent.mm.sdk.b.b cfVar5 = new cf();
                    Lm3 = com.tencent.mm.plugin.sns.storage.h.Lm(this.rPm);
                    if (Lm3 != null) {
                        str3 = u.hz(Lm3.field_snsId);
                        t = u.GK().t(str3, true);
                        t.o("prePublishId", "sns_" + i.eq(Lm3.field_snsId));
                        t.o("preUsername", Lm3.field_userName);
                        t.o("preChatName", "");
                        t.o(SlookSmartClipMetaTag.TAG_TYPE_URL, Md);
                        t.o("preMsgIndex", Integer.valueOf(0));
                        t.o("sendAppMsgScene", Integer.valueOf(1));
                        t.o("adExtStr", Lm3.bxV().rtA);
                        cfVar5.fqp.fqu = str3;
                    }
                    if (Lm6 != null && (this.rPn.wQo.vYc == 18 || Lm6.xl(32))) {
                        com.tencent.mm.plugin.sns.a.b.j.a(com.tencent.mm.plugin.sns.a.b.j.d.qQg, com.tencent.mm.plugin.sns.a.b.j.c.qQa, j$e.Samll, 0, Lm6);
                        if (this.rPn == null || this.rPn.wQo.vYc != 15 || this.rPn.wQv == 1) {
                            cVar = new c(Lm6.byz(), 11, this.scene == 0 ? 1 : 2, "", Lm6.byD(), Lm6.bxW());
                            g.Dk();
                            g.Di().gPJ.a(cVar, 0);
                        } else {
                            cVar = new c(Lm6.byz(), 11, this.scene == 0 ? 1 : 2, "", 5, Lm6.bxW());
                            g.Dk();
                            g.Di().gPJ.a(cVar, 0);
                        }
                    }
                    if (bh.ov(this.rPn.rLO)) {
                        com.tencent.mm.plugin.sns.i.a.a(cfVar5, Md, this.rPm);
                        cfVar5.fqp.activity = this.activity;
                        cfVar5.fqp.fqw = 28;
                        com.tencent.mm.sdk.b.a.xef.m(cfVar5);
                        if (cfVar5.fqq.ret == 0) {
                            Wo = bh.Wo();
                            if (!bh.ov(Md)) {
                                x.d("MicroMsg.TimeLineMMMenuItemSelectedListener", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13378), Md, Long.valueOf(Wo), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1)});
                                str2 = "";
                                try {
                                    str2 = URLEncoder.encode(Md, "UTF-8");
                                } catch (Throwable e2) {
                                    x.printErrStackTrace("MicroMsg.TimeLineMMMenuItemSelectedListener", e2, "", new Object[0]);
                                }
                                com.tencent.mm.plugin.report.service.g.pQN.h(13378, new Object[]{str2, Long.valueOf(Wo), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1)});
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    Me(Lm6.byq());
                    return;
                case 21:
                    Lm4 = com.tencent.mm.plugin.sns.storage.h.Lm(this.rPm);
                    if (Lm4 == null) {
                        x.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "edit photo fail, info is null");
                        return;
                    }
                    apVar = (ap) this.rPl.getTag();
                    Context context2 = this.activity;
                    intent2 = menuItem.getIntent();
                    ad adVar = this.rrV;
                    if (intent2 == null) {
                        x.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] intent is null!");
                        return;
                    } else if (adVar == null) {
                        x.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] snsContext is null!");
                        return;
                    } else if (Lm4 == null) {
                        x.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] info is null!");
                        return;
                    } else {
                        g.Dk();
                        if (g.Dj().isSDCardAvailable()) {
                            String str4 = apVar.fus;
                            int i4 = apVar.index;
                            int i5 = apVar.position;
                            com_tencent_mm_protocal_c_bnp = Lm4.bxV();
                            if (com_tencent_mm_protocal_c_bnp.wQo == null || com_tencent_mm_protocal_c_bnp.wQo.vYd.size() == 0) {
                                x.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] is ContentObj null");
                                return;
                            }
                            adVar.bva().v(Lm4);
                            bnp bxV = Lm4.bxV();
                            a = i4 < bxV.wQo.vYd.size() ? (aqr) bxV.wQo.vYd.get(i4) : new aqr();
                            if (ae.bvs().B(a)) {
                                com.tencent.mm.modelsns.b iu3 = com.tencent.mm.modelsns.b.iu(716);
                                iu3.mB(i.g(Lm4)).ix(Lm4.field_type).bU(Lm4.xl(32)).mB(Lm4.byA()).mB(a.nGJ).ix(i4).ix(bxV.wQo.vYd.size());
                                iu3.Sx();
                                iu = com.tencent.mm.modelsns.b.iu(744);
                                iu.mB(i.g(Lm4)).ix(Lm4.field_type).bU(Lm4.xl(32)).mB(Lm4.byA());
                                iu.b(intent2, "intent_key_StatisticsOplog");
                                intent2.putExtra("sns_soon_enter_photoedit_ui", true);
                                intent2.putExtra("sns_gallery_localId", str4);
                                intent2.putExtra("sns_gallery_position", i4);
                                intent2.putExtra("sns_position", i5);
                                intent2.putExtra("sns_gallery_showtype", 1);
                                intent2.putExtra("K_ad_scene", 1);
                                intent2.putExtra("k_is_from_sns_main_timeline", true);
                                intent2.setClass(context2, SnsBrowseUI.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("stat_scene", 3);
                                bundle.putString("stat_msg_id", "sns_" + i.eq(Lm4.field_snsId));
                                bundle.putString("stat_send_msg_user", Lm4.field_userName);
                                intent2.putExtra("_stat_obj", bundle);
                                context2.startActivity(intent2);
                                context2.overridePendingTransition(0, 0);
                                return;
                            }
                            x.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] media[%s] is illegal", new Object[]{Integer.valueOf(a.qQY)});
                            return;
                        }
                        x.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] is not SDCardAvailable");
                        return;
                    }
                case 22:
                    if (this.rPn == null) {
                        x.e("MicroMsg.TimeLineMMMenuItemSelectedListener", "favNotelink,tlobj is null, return");
                        return;
                    }
                    cfVar2 = new cf();
                    com.tencent.mm.plugin.sns.i.a.a(cfVar2, this.rPm);
                    cfVar2.fqp.activity = this.activity;
                    cfVar2.fqp.fqw = 28;
                    com.tencent.mm.sdk.b.a.xef.m(cfVar2);
                    return;
                default:
                    return;
            }
        }
    }

    private void Me(String str) {
        m Lm = ae.bvv().Lm(str);
        if (Lm != null) {
            String w;
            if (Lm.xl(32)) {
                Lm.bxT();
                com.tencent.mm.plugin.sns.storage.e byB = Lm.byB();
                w = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(Lm);
                if (!bh.ov(w)) {
                    byB.field_adxml = w;
                }
                w = byB.field_adxml;
            } else {
                w = Lm.bxV().rLO;
            }
            Map y = bi.y(w, "adxml");
            if (y == null) {
                return;
            }
            if (y.containsKey(".adxml.adCanvasInfo")) {
                String hz = u.hz(Lm.field_snsId);
                String az = bh.az((String) y.get(".adxml.adCanvasInfo.shareTitle"), "");
                String az2 = bh.az((String) y.get(".adxml.adCanvasInfo.shareWebUrl"), "");
                String az3 = bh.az((String) y.get(".adxml.adCanvasInfo.shareDesc"), "");
                com.tencent.mm.sdk.b.b cfVar = new cf();
                com.tencent.mm.sdk.b.b qnVar = new qn();
                qnVar.fIc.fIf = str;
                qnVar.fIc.fIg = cfVar;
                qnVar.fIc.url = az2;
                com.tencent.mm.sdk.b.a.xef.m(qnVar);
                if (qnVar.fId.fpW) {
                    cfVar.fqp.fqu = hz;
                    cfVar.fqp.title = az;
                    cfVar.fqp.desc = az3;
                    ve veVar = cfVar.fqp.fqr;
                    if (!(veVar == null || veVar.weU == null || veVar.weU.size() <= 0 || veVar.weU.get(0) == null)) {
                        ((uq) veVar.weU.get(0)).TP(w);
                        if (bh.ov(((uq) veVar.weU.get(0)).title)) {
                            ((uq) veVar.weU.get(0)).Tq(cfVar.fqp.title);
                        }
                        if (bh.ov(((uq) veVar.weU.get(0)).desc)) {
                            ((uq) veVar.weU.get(0)).Tr(cfVar.fqp.desc);
                        }
                    }
                    cfVar.fqp.activity = this.activity;
                    cfVar.fqp.fqw = 28;
                    com.tencent.mm.sdk.b.a.xef.m(cfVar);
                    return;
                }
                if (cfVar.fqp.fqv == 0) {
                    cfVar.fqp.fqv = j.efp;
                }
                h.h(this.activity, cfVar.fqp.fqv, 0);
                return;
            }
            h.h(this.activity, j.efq, 0);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 15) {
                m Lm = ae.bvv().Lm(this.rPm);
                aqr com_tencent_mm_protocal_c_aqr = (aqr) this.rPn.wQo.vYd.get(0);
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                String stringExtra2 = intent.getStringExtra("custom_send_text");
                String str = am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ) + i.e(com_tencent_mm_protocal_c_aqr);
                for (String str2 : bh.F(stringExtra.split(","))) {
                    String str3;
                    if (Lm.xl(32)) {
                        com.tencent.mm.plugin.sns.a.b.j.c cVar;
                        int gl;
                        str3 = am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ) + i.j(com_tencent_mm_protocal_c_aqr);
                        bnp bxV = Lm.bxV();
                        com.tencent.mm.plugin.sns.storage.b bxR = Lm.bxR();
                        bmf com_tencent_mm_protocal_c_bmf = new bmf();
                        com_tencent_mm_protocal_c_bmf.weC = com_tencent_mm_protocal_c_aqr.rNe;
                        com_tencent_mm_protocal_c_bmf.hdo = com_tencent_mm_protocal_c_aqr.wxL;
                        if (bxV.wQo.vYc == 15) {
                            com_tencent_mm_protocal_c_bmf.hdu = Lm.bxT().qZM;
                            com_tencent_mm_protocal_c_bmf.hdv = bxV.nGJ;
                        } else {
                            com_tencent_mm_protocal_c_bmf.hdu = bxV.wQt.hdu;
                            com_tencent_mm_protocal_c_bmf.hdv = bxV.wQt.hdv;
                        }
                        com_tencent_mm_protocal_c_bmf.hdq = bxV.wQl;
                        com_tencent_mm_protocal_c_bmf.hdt = bh.ov(com_tencent_mm_protocal_c_aqr.wxO) ? com_tencent_mm_protocal_c_aqr.wxE : com_tencent_mm_protocal_c_aqr.wxO;
                        if (bxR != null && bxR.reD == 0) {
                            com_tencent_mm_protocal_c_bmf.hds = bxR.reF;
                            com_tencent_mm_protocal_c_bmf.hdr = bxR.reE;
                        }
                        x.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "send adsight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[]{str2, str3, str, com_tencent_mm_protocal_c_aqr.wxL, Integer.valueOf(com_tencent_mm_protocal_c_aqr.rNe), Integer.valueOf(i.JS(str3))});
                        f.aZh().a(this.activity, str2, str3, str, 43, r7, com_tencent_mm_protocal_c_bmf, false, false, bxV.rtA);
                        f.aZh().dj(stringExtra2, str2);
                        k cVar2 = new c(Lm.byz(), 12, this.scene == 0 ? 1 : 2, "", 2, Lm.bxW());
                        g.Dk();
                        g.Di().gPJ.a(cVar2, 0);
                        boolean eV = s.eV(str2);
                        com.tencent.mm.plugin.sns.a.b.j.d dVar = com.tencent.mm.plugin.sns.a.b.j.d.qQf;
                        if (eV) {
                            cVar = com.tencent.mm.plugin.sns.a.b.j.c.qQc;
                        } else {
                            cVar = com.tencent.mm.plugin.sns.a.b.j.c.qQb;
                        }
                        j$e com_tencent_mm_plugin_sns_a_b_j_e = j$e.Samll;
                        if (eV) {
                            gl = com.tencent.mm.z.m.gl(str2);
                        } else {
                            gl = 0;
                        }
                        com.tencent.mm.plugin.sns.a.b.j.a(dVar, cVar, com_tencent_mm_plugin_sns_a_b_j_e, gl, Lm);
                        return;
                    }
                    str3 = am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ) + i.j(com_tencent_mm_protocal_c_aqr);
                    x.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "send sight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[]{str2, str3, str, com_tencent_mm_protocal_c_aqr.wxL, Integer.valueOf(com_tencent_mm_protocal_c_aqr.rNe), Integer.valueOf(i.JS(str3))});
                    f.aZh().a(this.activity, str2, str3, str, 43, r7, this.rPn.rtA);
                    f.aZh().dj(stringExtra2, str2);
                }
                com.tencent.mm.ui.snackbar.a.h(this.activity, this.activity.getString(j.epb));
            }
        } else if (i == 15) {
            m Lm2 = ae.bvv().Lm(this.rPm);
            if (Lm2 == null) {
                x.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "menuitemselected and snsinfo is null %s", new Object[]{this.rPm});
                return;
            }
            k cVar3 = new c(Lm2.byz(), 13, this.scene == 0 ? 1 : 2, "", 2, Lm2.bxW());
            g.Dk();
            g.Di().gPJ.a(cVar3, 0);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "onSceneEnd");
        if (this.rrH != null && this.rrH.isShowing()) {
            this.rrH.dismiss();
        }
    }
}
