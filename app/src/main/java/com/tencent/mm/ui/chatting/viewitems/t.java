package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ad.b;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.ui.contact.e;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import com.tencent.wcdb.FileUtils;
import junit.framework.Assert;

public final class t {

    public static class a extends b {
        private com.tencent.mm.ui.chatting.ChattingUI.a yqa;

        public final boolean aXj() {
            return false;
        }

        public final boolean aj(int i, boolean z) {
            if (i == 37 || i == 40) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = new p(layoutInflater, R.i.ddv);
            view.setTag(new b().dB(view));
            return view;
        }

        protected final boolean cvx() {
            return false;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
            this.yqa = aVar2;
            b bVar = (b) aVar;
            if (auVar.getType() == 37) {
                ar.Hg();
                d EJ = c.Fa().EJ(auVar.field_content);
                if (EJ != null && EJ.rYX != null && EJ.rYX.length() > 0) {
                    b.I(EJ.rYX, EJ.xzi);
                    if (s.gE(EJ.rYX)) {
                        bVar.yMj.setVisibility(8);
                        bVar.yMk.setVisibility(8);
                        bVar.yMl.setVisibility(0);
                        bVar.yMi.setBackgroundColor(16777215);
                        bVar.yMl.setText(aVar2.getString(R.l.ekg));
                    } else {
                        bVar.yMj.setVisibility(0);
                        bVar.yMk.setVisibility(0);
                        bVar.yMl.setVisibility(0);
                        bVar.yMi.setBackgroundResource(R.g.bBj);
                        bVar.yMl.setText(aVar2.getString(R.l.ekf));
                    }
                    switch (EJ.scene) {
                        case 13:
                            com.tencent.mm.modelfriend.b kR = af.OD().kR(EJ.rYX);
                            if (kR.Nt() != null && !kR.Nt().equals("")) {
                                bVar.yMm.setVisibility(0);
                                bVar.yMm.setText(aVar2.getString(R.l.dQU, new Object[]{kR.Nt()}));
                                break;
                            }
                            bVar.yMm.setVisibility(8);
                            break;
                            break;
                        case 18:
                            bVar.yLs.setText(R.l.dRe);
                            break;
                        case 22:
                        case 23:
                        case 24:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                            bVar.yLs.setText(R.l.dRg);
                            break;
                        case 25:
                            bVar.yLs.setText(R.l.dQZ);
                            break;
                        case 30:
                            bVar.yLs.setText(R.l.eBA);
                            break;
                    }
                }
                x.e("MicroMsg.ChattingItemFMessageFrom", "getView : parse verify msg failed");
                return;
            } else if (auVar.getType() == 40) {
                ar.Hg();
                com.tencent.mm.storage.au.a EK = c.Fa().EK(auVar.field_content);
                if (EK == null || EK.rYX == null || EK.rYX.length() <= 0) {
                    x.e("MicroMsg.ChattingItemFMessageFrom", "getView : parse possible friend msg failed");
                    return;
                }
                b.I(EK.rYX, EK.xzi);
                if (s.gE(EK.rYX)) {
                    bVar.yMj.setVisibility(8);
                    bVar.yMk.setVisibility(8);
                    bVar.yMl.setVisibility(0);
                    bVar.yMi.setBackgroundColor(16777215);
                    bVar.yMl.setText(aVar2.getString(R.l.ekg));
                } else {
                    bVar.yMj.setVisibility(0);
                    bVar.yMk.setVisibility(0);
                    bVar.yMl.setVisibility(0);
                    bVar.yMi.setBackgroundResource(R.g.bBj);
                    bVar.yMl.setText(aVar2.getString(R.l.ekf));
                }
                switch (EK.scene) {
                    case 4:
                        bVar.yLs.setText(R.l.dQQ);
                        bVar.yMh.setText(R.l.dQR);
                        CharSequence cjG = EK.cjG();
                        if (cjG == null) {
                            cjG = EK.getDisplayName();
                        }
                        bVar.qjb.setText(i.b(aVar2.getContext(), cjG, bVar.qjb.getTextSize()));
                        break;
                    case 10:
                    case 11:
                        bVar.yLs.setText(R.l.dQT);
                        String kY = m.kY(EK.xzj);
                        if (com.tencent.mm.platformtools.t.ov(kY)) {
                            kY = m.kY(EK.xzk);
                        }
                        bVar.yMh.setText(aVar2.getString(R.l.dQU, new Object[]{kY}));
                        bVar.qjb.setText(i.b(aVar2.getContext(), EK.getDisplayName(), bVar.qjb.getTextSize()));
                        break;
                    case 31:
                        bVar.yLs.setText(R.l.dRc);
                        bVar.yMh.setText(R.l.dRd);
                        bVar.qjb.setText(i.b(aVar2.getContext(), EK.getDisplayName(), bVar.qjb.getTextSize()));
                        break;
                    case 32:
                        bVar.yLs.setText(R.l.dQY);
                        bVar.yMh.setText(R.l.dQX);
                        bVar.qjb.setText(i.b(aVar2.getContext(), EK.getDisplayName(), bVar.qjb.getTextSize()));
                        break;
                    default:
                        x.d("MicroMsg.ChattingItemFMessageFrom", "prossible friend sceneType:%d", new Object[]{Integer.valueOf(EK.scene)});
                        bVar.yLs.setText(R.l.dQV);
                        bVar.yMh.setText(R.l.dQW);
                        bVar.qjb.setText(i.b(aVar2.getContext(), EK.getDisplayName(), bVar.qjb.getTextSize()));
                        break;
                }
                q(bVar.iip, EK.rYX);
            } else {
                x.w("MicroMsg.ChattingItemFMessageFrom", "FROM_FMESSAGE did not include this type, msgType = " + auVar.getType());
            }
            bVar.yIy.setTag(new ar(auVar, aVar2.ypn, i, null, (byte) 0));
            bVar.yIy.setOnClickListener(t(aVar2));
            bVar.yIy.setOnLongClickListener(s(aVar2));
            bVar.yIy.setOnTouchListener(aVar2.ysf.ysV);
        }

        public final boolean a(ContextMenu contextMenu, View view, au auVar) {
            return false;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            String str;
            if (auVar.getType() == 37) {
                str = auVar.field_content;
                x.w("MicroMsg.ChattingItemFMessageFrom", "dealClickVerifyMsgEvent : " + str);
                if (str != null && str.length() > 0) {
                    ar.Hg();
                    d EJ = c.Fa().EJ(str);
                    if (EJ != null) {
                        Assert.assertTrue(EJ.rYX.length() > 0);
                        ar.Hg();
                        com.tencent.mm.g.b.af WO = c.EY().WO(EJ.rYX);
                        Intent intent = new Intent();
                        if (WO == null || ((int) WO.gJd) <= 0 || !com.tencent.mm.l.a.fZ(WO.field_type)) {
                            intent.putExtra("Verify_ticket", EJ.mOi);
                            intent.putExtra("User_Verify", true);
                            intent.putExtra("Contact_User", EJ.rYX);
                            intent.putExtra("Contact_Alias", EJ.gfN);
                            intent.putExtra("Contact_Nick", EJ.fpL);
                            intent.putExtra("Contact_QuanPin", EJ.hwV);
                            intent.putExtra("Contact_PyInitial", EJ.hwU);
                            intent.putExtra("Contact_Sex", EJ.fWf);
                            intent.putExtra("Contact_Signature", EJ.signature);
                            intent.putExtra("Contact_Scene", EJ.scene);
                            intent.putExtra("Contact_FMessageCard", true);
                            intent.putExtra("Contact_City", EJ.getCity());
                            intent.putExtra("Contact_Province", EJ.getProvince());
                            intent.putExtra("Contact_Mobile_MD5", EJ.xzj);
                            intent.putExtra("Contact_full_Mobile_MD5", EJ.xzk);
                            intent.putExtra("Contact_KSnsIFlag", EJ.xzs);
                            intent.putExtra("Contact_KSnsBgUrl", EJ.xzt);
                        } else {
                            intent.putExtra("Contact_User", WO.field_username);
                            e.a(intent, WO.field_username);
                        }
                        str = EJ.content;
                        if (com.tencent.mm.platformtools.t.ou(str).length() <= 0) {
                            switch (EJ.scene) {
                                case 18:
                                case 22:
                                case 23:
                                case 24:
                                case 25:
                                case 26:
                                case 27:
                                case 28:
                                case 29:
                                    str = this.yqa.getString(R.l.dRf);
                                    break;
                                default:
                                    str = this.yqa.getString(R.l.dRb);
                                    break;
                            }
                        }
                        intent.putExtra("Contact_Content", str);
                        intent.putExtra("Contact_verify_Scene", EJ.scene);
                        intent.putExtra("Contact_Uin", EJ.pjS);
                        intent.putExtra("Contact_QQNick", EJ.hwW);
                        intent.putExtra("Contact_Mobile_MD5", EJ.xzj);
                        intent.putExtra("User_From_Fmessage", true);
                        intent.putExtra("Contact_from_msgType", 37);
                        intent.putExtra("Contact_KSnsIFlag", EJ.xzs);
                        intent.putExtra("Contact_KSnsBgUrl", EJ.xzt);
                        com.tencent.mm.bm.d.b(this.yqa.getContext(), "profile", ".ui.ContactInfoUI", intent);
                        com.tencent.mm.bn.a.CC(EJ.scene);
                    }
                }
            } else if (auVar.getType() == 40) {
                str = auVar.field_content;
                ar.Hg();
                com.tencent.mm.storage.au.a EK = c.Fa().EK(str);
                if (EK != null && EK.rYX.length() > 0) {
                    com.tencent.mm.bn.a.CC(EK.scene);
                    ar.Hg();
                    com.tencent.mm.g.b.af WO2 = c.EY().WO(EK.rYX);
                    if (WO2 != null && ((int) WO2.gJd) > 0 && com.tencent.mm.l.a.fZ(WO2.field_type)) {
                        e.a(this.yqa.getContext(), WO2, EK);
                    } else if (EK.pjS > 0 || (com.tencent.mm.platformtools.t.ov(EK.xzj) && com.tencent.mm.platformtools.t.ov(EK.xzk))) {
                        e.a(this.yqa.getContext(), EK);
                    } else {
                        com.tencent.mm.modelfriend.b kS = af.OD().kS(EK.xzj);
                        if (kS == null || kS.Nr() == null || kS.Nr().length() <= 0) {
                            kS = af.OD().kS(EK.xzk);
                            if (kS == null || kS.Nr() == null || kS.Nr().length() <= 0) {
                                if (WO2 == null || ((int) WO2.gJd) <= 0) {
                                    e.a(this.yqa.getContext(), EK);
                                } else {
                                    e.a(this.yqa.getContext(), WO2, EK);
                                }
                                x.e("MicroMsg.ChattingItemFMessageFrom", "error : this is not the mobile contact, MD5 = " + EK.xzj + " fullMD5:" + EK.xzk);
                            }
                        }
                        if (kS.getUsername() == null || kS.getUsername().length() <= 0) {
                            kS.username = EK.rYX;
                            kS.fDt = FileUtils.S_IWUSR;
                            if (af.OD().a(kS.Nr(), kS) == -1) {
                                x.e("MicroMsg.ChattingItemFMessageFrom", "update mobile contact username failed");
                            }
                        }
                        e.a(this.yqa.getContext(), EK);
                    }
                }
            }
            return true;
        }
    }
}
