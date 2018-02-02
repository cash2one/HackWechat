package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.aq.o;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.g;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import com.tencent.wcdb.FileUtils;

public final class i$b extends b {
    private final long yKp = 259200000;
    private a yqa;

    public final boolean aXj() {
        return false;
    }

    public final boolean aj(int i, boolean z) {
        if (z || i != 268435505) {
            return false;
        }
        return true;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddn);
        view.setTag(new i.a().dv(view));
        return view;
    }

    public final void a(b.a aVar, int i, a aVar2, au auVar, String str) {
        i.a aVar3 = (i.a) aVar;
        this.yqa = aVar2;
        aVar2.yvP.aT(auVar);
        g.a aVar4 = null;
        String str2 = auVar.field_content;
        if (aVar2.ysk) {
            int indexOf = auVar.field_content.indexOf(58);
            if (indexOf != -1) {
                str2 = auVar.field_content.substring(indexOf + 1);
            }
        }
        if (str2 != null) {
            aVar4 = g.a.I(str2, auVar.field_reserved);
        }
        if (aVar4 != null) {
            f cQ = com.tencent.mm.pluginsdk.model.app.g.cQ(aVar4.appId, aVar4.fIm);
            if (cQ != null && cQ.Yz()) {
                b.b(aVar2, aVar4, auVar);
            }
            str2 = (cQ == null || cQ.field_appName == null || cQ.field_appName.trim().length() <= 0) ? aVar4.appName : cQ.field_appName;
            if (aVar4.appId == null || aVar4.appId.length() <= 0 || !com.tencent.mm.pluginsdk.model.app.g.cz(str2)) {
                aVar3.mxT.setVisibility(8);
            } else {
                aVar3.mxT.setText(com.tencent.mm.pluginsdk.model.app.g.a(aVar2.getContext(), cQ, str2));
                aVar3.mxT.setVisibility(0);
                if (cQ == null || !cQ.Yz()) {
                    b.a(aVar2, aVar3.mxT, aVar4.appId);
                } else {
                    b.a(aVar2, aVar3.mxT, auVar, aVar4, cQ.field_packageName, auVar.field_msgSvrId);
                }
                b.a(aVar2, aVar3.mxT, aVar4.appId);
            }
            if (aVar4.gjD == null || aVar4.gjD.length() == 0) {
                aVar3.yIW.setVisibility(8);
            } else {
                aVar3.yIW.setVisibility(0);
                b(aVar2, aVar3.yIW, (Object) ar.Zx(aVar4.gjD));
            }
            switch (aVar4.type) {
                case 2:
                    aVar3.mRY.setVisibility(0);
                    b Rz = an.aqd().Rz(aVar4.fny);
                    String str3 = auVar.field_imgPath;
                    Boolean valueOf = Boolean.valueOf(false);
                    if (Rz != null) {
                        str3 = Rz.field_fileFullPath;
                        valueOf = Boolean.valueOf(true);
                    }
                    if (!o.Pw().a(aVar3.mRY, str3, valueOf.booleanValue(), com.tencent.mm.bv.a.getDensity(aVar2.getContext()), aVar4.hbm, aVar4.hbl, true, R.g.bAH, aVar3.mSe, R.g.bAE, 1, true, null)) {
                        if (this.vzn) {
                            aVar3.mRY.setImageResource(R.k.dxp);
                        } else {
                            aVar3.mRY.setImageBitmap(BitmapFactory.decodeResource(aVar2.getResources(), R.g.bEl));
                        }
                        aVar3.mRY.post(new 1(this, aVar3));
                        break;
                    }
                    break;
            }
            if (aVar2.ypn) {
                aVar3.yKo.setVisibility(8);
            } else if (com.tencent.mm.pluginsdk.model.app.g.g(cQ)) {
                aVar3.yKo.setVisibility(0);
                aVar3.yIW.setVisibility(8);
                b.c(aVar2, aVar3.yKo, ar.a(aVar4, auVar));
            } else {
                aVar3.yKo.setVisibility(8);
            }
        }
        aVar3.yIy.setTag(new ar(auVar, aVar2.ypn, i, null, (byte) 0));
        aVar3.yIy.setOnClickListener(t(aVar2));
        if (this.vzn) {
            aVar3.yIy.setOnLongClickListener(s(aVar2));
            aVar3.yIy.setOnTouchListener(aVar2.ysf.ysV);
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        if (!(view == null || auVar == null)) {
            int i = ((ar) view.getTag()).position;
            l.RH(this.yqa.dk(auVar.field_content, auVar.field_isSend));
            if (com.tencent.mm.pluginsdk.model.app.g.h(com.tencent.mm.pluginsdk.model.app.g.aZ(g.a.fT(this.yqa.dk(auVar.field_content, auVar.field_isSend)).appId, false))) {
                contextMenu.add(i, 111, 0, this.yqa.getString(R.l.eEC));
            }
            if (d.OQ("favorite")) {
                contextMenu.add(i, 116, 0, this.yqa.getString(R.l.eAd));
            }
            com.tencent.mm.sdk.b.b dhVar = new dh();
            dhVar.frQ.fqm = auVar.field_msgId;
            com.tencent.mm.sdk.b.a.xef.m(dhVar);
            boolean m = com.tencent.mm.pluginsdk.model.app.g.m(this.yqa.getContext(), 2);
            if (dhVar.frR.frp || m) {
                contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dRM));
            }
            if (d.OQ("photoedit") && auVar.field_status != 5) {
                int width;
                int height;
                MenuItem add = contextMenu.add(i, 130, 0, view.getContext().getString(R.l.dRk));
                int[] iArr = new int[2];
                if (view != null) {
                    width = view.getWidth();
                    height = view.getHeight();
                    view.getLocationInWindow(iArr);
                } else {
                    height = 0;
                    width = 0;
                }
                Intent intent = new Intent();
                intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                add.setIntent(intent);
            }
            if (!this.yqa.csV()) {
                contextMenu.add(i, 100, 0, this.yqa.getString(R.l.dRH));
            }
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        g.a fT;
        String str = null;
        String str2 = auVar.field_content;
        if (str2 != null) {
            fT = g.a.fT(str2);
        } else {
            fT = null;
        }
        switch (menuItem.getItemId()) {
            case 100:
                l.fq(auVar.field_msgId);
                ba.aK(auVar.field_msgId);
                if (fT != null) {
                    f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(fT.appId, false);
                    if (aZ != null && aZ.Yz()) {
                        b.a(aVar, fT, auVar, aZ);
                        break;
                    }
                }
                break;
            case 111:
                if (!(fT == null || fT.fny == null || fT.fny.length() <= 0)) {
                    b Rz = an.aqd().Rz(fT.fny);
                    if (Rz != null) {
                        str = Rz.field_fileFullPath;
                    }
                }
                if (!auVar.cjs()) {
                    boolean z;
                    if (System.currentTimeMillis() - auVar.field_createTime <= 259200000 || (!bh.ov(str) && e.bO(str))) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        new af().post(new 3(this, auVar));
                        Intent intent = new Intent(aVar.getContext(), MsgRetransmitUI.class);
                        intent.putExtra("Retr_File_Name", str);
                        intent.putExtra("Retr_Msg_content", aVar.dk(auVar.field_content, auVar.field_isSend));
                        intent.putExtra("Retr_Msg_Type", 16);
                        intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
                        aVar.startActivity(intent);
                        break;
                    }
                }
                x.i("MicroMsg.ChattingItemAppMsgFromImg", "img is expired or clean!!!");
                h.a(aVar.getContext(), aVar.getContext().getString(R.l.epp), aVar.getContext().getString(R.l.dGO), new 2(this));
                break;
        }
        return false;
    }

    public final boolean b(View view, a aVar, au auVar) {
        ar.Hg();
        if (c.isSDCardAvailable()) {
            g.a aVar2 = null;
            String dk = aVar.dk(auVar.field_content, auVar.field_isSend);
            if (dk != null) {
                aVar2 = g.a.fT(dk);
            }
            if (aVar2 == null) {
                x.e("MicroMsg.ChattingItemAppMsgFromImg", "content is null");
                return true;
            }
            int height;
            int i;
            int[] iArr = new int[2];
            if (view != null) {
                view.getLocationInWindow(iArr);
                int width = view.getWidth();
                height = view.getHeight();
                i = width;
            } else {
                height = 0;
                i = 0;
            }
            f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(aVar2.appId, true);
            if (aZ != null && aZ.Yz()) {
                b.a(aVar, aVar2, b.c(aVar, auVar), aZ, auVar.field_msgSvrId);
            }
            String str;
            if (aVar2.fny != null && aVar2.fny.length() > 0) {
                b Rz = an.aqd().Rz(aVar2.fny);
                long j;
                if (Rz != null && Rz.aOC()) {
                    dk = Rz.field_fileFullPath;
                    if (!e.bO(dk)) {
                        x.i("MicroMsg.ChattingItemAppMsgFromImg", "Img not exist, bigImgPath: %s, msgId: %d, msgSvrId: %d", dk, Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId));
                        Intent intent = new Intent();
                        intent.setClassName(aVar.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
                        intent.putExtra("clean_view_type", 1);
                        aVar.startActivity(intent);
                        return true;
                    } else if (dk == null || dk.equals("") || !e.bO(dk)) {
                        x.d("MicroMsg.ChattingItemAppMsgFromImg", "showImg : imgPath is null");
                    } else {
                        String str2;
                        int i2;
                        Bundle bundle;
                        j = auVar.field_msgId;
                        long j2 = auVar.field_msgSvrId;
                        str = auVar.field_talker;
                        Intent intent2 = new Intent(this.yqa.getContext(), ImageGalleryUI.class);
                        intent2.putExtra("img_gallery_msg_id", j);
                        intent2.putExtra("img_gallery_talker", str);
                        intent2.putExtra("img_gallery_left", iArr[0]);
                        intent2.putExtra("img_gallery_top", iArr[1]);
                        intent2.putExtra("img_gallery_width", i);
                        intent2.putExtra("img_gallery_height", height);
                        String crz = this.yqa.crz();
                        String a = a(this.yqa, auVar);
                        Bundle bundle2 = new Bundle();
                        if (this.yqa.ysk) {
                            str2 = "stat_scene";
                            i2 = 2;
                            bundle = bundle2;
                        } else {
                            str2 = "stat_scene";
                            if (s.gF(crz)) {
                                i2 = 7;
                                bundle = bundle2;
                            } else {
                                i2 = 1;
                                bundle = bundle2;
                            }
                        }
                        bundle.putInt(str2, i2);
                        bundle2.putString("stat_msg_id", "msg_" + Long.toString(j2));
                        bundle2.putString("stat_chat_talker_username", crz);
                        bundle2.putString("stat_send_msg_user", a);
                        intent2.putExtra("_stat_obj", bundle2);
                        this.yqa.startActivity(intent2);
                    }
                } else if (auVar.field_isSend == 0) {
                    j = auVar.field_msgId;
                    Intent intent3 = new Intent();
                    intent3.setClassName(this.yqa.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                    intent3.putExtra("app_msg_id", j);
                    this.yqa.startActivity(intent3);
                }
            } else if (aVar2.url != null && aVar2.url.length() > 0) {
                str = p.A(aVar2.url, "message");
                PackageInfo packageInfo = b.getPackageInfo(aVar.getContext(), aVar2.appId);
                a(aVar, str, str, packageInfo == null ? null : packageInfo.versionName, packageInfo == null ? 0 : packageInfo.versionCode, aVar2.appId, false, auVar.field_msgId, auVar.field_msgSvrId, auVar);
            }
            return true;
        }
        u.fI(aVar.getContext());
        return true;
    }
}
