package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
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
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.g;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import com.tencent.wcdb.FileUtils;

public class i$c extends b {
    private a yqa;

    public final boolean aXj() {
        return true;
    }

    public final boolean aj(int i, boolean z) {
        if (z && i == 268435505) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddS);
        view.setTag(new i.a().dv(view));
        return view;
    }

    public final void a(b.a aVar, int i, a aVar2, au auVar, String str) {
        aVar = (i.a) aVar;
        this.yqa = aVar2;
        aVar2.yvP.aT(auVar);
        g.a aVar3 = null;
        String str2 = auVar.field_content;
        if (str2 != null) {
            aVar3 = g.a.I(str2, auVar.field_reserved);
        }
        if (aVar3 != null) {
            f cQ = com.tencent.mm.pluginsdk.model.app.g.cQ(aVar3.appId, aVar3.fIm);
            String str3 = (cQ == null || cQ.field_appName == null || cQ.field_appName.trim().length() <= 0) ? aVar3.appName : cQ.field_appName;
            if (aVar3.appId == null || aVar3.appId.length() <= 0 || !com.tencent.mm.pluginsdk.model.app.g.cz(str3)) {
                aVar.mxT.setVisibility(8);
            } else {
                aVar.mxT.setText(com.tencent.mm.pluginsdk.model.app.g.a(aVar2.getContext(), cQ, str3));
                aVar.mxT.setVisibility(0);
                if (cQ == null || !cQ.Yz()) {
                    a(aVar2, aVar.mxT, aVar3.appId);
                } else {
                    a(aVar2, aVar.mxT, auVar, aVar3, cQ.field_packageName, auVar.field_msgSvrId);
                }
                a(aVar2, aVar.mxT, aVar3.appId);
            }
            switch (aVar3.type) {
                case 2:
                    aVar.mRY.setVisibility(0);
                    b Rz = an.aqd().Rz(aVar3.fny);
                    String str4 = auVar.field_imgPath;
                    Boolean valueOf = Boolean.valueOf(false);
                    if (Rz != null) {
                        str4 = Rz.field_fileFullPath;
                        valueOf = Boolean.valueOf(true);
                    }
                    if (!o.Pw().a(aVar.mRY, str4, valueOf.booleanValue(), com.tencent.mm.bv.a.getDensity(aVar2.getContext()), aVar3.hbo, aVar3.hbn, true, R.g.bAH, aVar.mSe, R.g.bAE, 0, true, null)) {
                        if (this.vzn) {
                            aVar.mRY.setImageResource(R.k.dxp);
                        } else {
                            aVar.mRY.setImageBitmap(BitmapFactory.decodeResource(aVar2.getResources(), R.g.bEl));
                        }
                        final b.a aVar4 = aVar;
                        aVar.mRY.post(new Runnable(this) {
                            final /* synthetic */ i$c yKs;

                            public final void run() {
                                aVar4.mRY.setLayoutParams(new LayoutParams(-2, -2));
                                aVar4.mSe.setLayoutParams(new LayoutParams(aVar4.mRY.getWidth(), aVar4.mRY.getHeight()));
                            }
                        });
                        break;
                    }
                    break;
            }
        }
        aVar.yIy.setTag(new ar(auVar, aVar2.ypn, i, null, (byte) 0));
        aVar.yIy.setOnClickListener(t(aVar2));
        if (this.vzn) {
            aVar.yIy.setOnLongClickListener(s(aVar2));
            aVar.yIy.setOnTouchListener(aVar2.ysf.ysV);
        }
        int RH = l.RH(str2);
        if (RH == -1 || RH >= 100 || aVar3.hbb <= 0 || auVar.field_status == 5) {
            aVar.mwb.setVisibility(8);
            aVar.mRY.setAlpha(255);
            aVar.mRY.setBackgroundDrawable(null);
        } else {
            aVar.mwb.setVisibility(0);
            aVar.yKn.setText(RH + "%");
            aVar.mRY.setAlpha(64);
            aVar.mRY.setBackgroundResource(R.g.bFK);
        }
        a(i, aVar, auVar, aVar2.ysf.hlJ, aVar2.ypn, aVar2);
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        if (view == null) {
            x.e("MicroMsg.ChattingItemAppMsgToImg", "[onCreateContextMenu] v is null");
            return false;
        }
        ar arVar = (ar) view.getTag();
        if (arVar == null) {
            x.e("MicroMsg.ChattingItemAppMsgToImg", "[onCreateContextMenu] tag is null");
            return false;
        }
        int i = arVar.position;
        g.a fT = g.a.fT(this.yqa.dk(auVar.field_content, auVar.field_isSend));
        if (fT != null && com.tencent.mm.pluginsdk.model.app.g.h(com.tencent.mm.pluginsdk.model.app.g.aZ(fT.appId, false))) {
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
        if (!auVar.ciV() && auVar.cjm() && ((auVar.field_status == 2 || auVar.gjJ == 1) && a(auVar, this.yqa) && Zq(auVar.field_talker))) {
            contextMenu.add(i, 123, 0, view.getContext().getString(R.l.dRQ));
        }
        if (!this.yqa.csV()) {
            contextMenu.add(i, 100, 0, this.yqa.getString(R.l.dRH));
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
                if (fT != null) {
                    l.fq(auVar.field_msgId);
                }
                ba.aK(auVar.field_msgId);
                f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(fT.appId, false);
                if (aZ != null && aZ.Yz()) {
                    a(aVar, fT, auVar, aZ);
                    break;
                }
            case 111:
                if (!(fT == null || fT.fny == null || fT.fny.length() <= 0)) {
                    b Rz = an.aqd().Rz(fT.fny);
                    if (Rz != null) {
                        str = Rz.field_fileFullPath;
                    }
                }
                Intent intent = new Intent(aVar.getContext(), MsgRetransmitUI.class);
                intent.putExtra("Retr_Msg_content", auVar.field_content);
                intent.putExtra("Retr_File_Name", str);
                intent.putExtra("Retr_Msg_Type", 16);
                intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
                aVar.startActivity(intent);
                break;
        }
        return false;
    }

    public final boolean b(View view, a aVar, au auVar) {
        ar.Hg();
        if (!c.isSDCardAvailable()) {
            u.fI(aVar.getContext());
            return true;
        } else if (view == null) {
            return true;
        } else {
            view.getTag();
            g.a aVar2 = null;
            String str = auVar.field_content;
            if (str != null) {
                aVar2 = g.a.fT(str);
            }
            if (aVar2 == null) {
                x.e("MicroMsg.ChattingItemAppMsgToImg", "content is null");
                return true;
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int width = view.getWidth();
            int height = view.getHeight();
            f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(aVar2.appId, false);
            if (aZ != null && aZ.Yz()) {
                a(aVar, aVar2, q.FS(), aZ, auVar.field_msgSvrId);
            }
            String str2;
            if (aVar2.fny != null && aVar2.fny.length() > 0) {
                b Rz = an.aqd().Rz(aVar2.fny);
                if (Rz != null) {
                    ar.Hg();
                    if (!c.isSDCardAvailable()) {
                        u.fI(aVar.getContext());
                    } else if (auVar.field_isSend == 1) {
                        str = Rz.field_fileFullPath;
                        if (!e.bO(str)) {
                            x.i("MicroMsg.ChattingItemAppMsgToImg", "onItemClick::bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[]{str, Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId)});
                            Intent intent = new Intent();
                            intent.setClassName(aVar.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
                            intent.putExtra("clean_view_type", 1);
                            aVar.startActivity(intent);
                            return true;
                        } else if (str == null || str.equals("") || !e.bO(str)) {
                            x.d("MicroMsg.ChattingItemAppMsgToImg", "showImg : imgPath is null");
                        } else {
                            String str3;
                            int i;
                            Bundle bundle;
                            long j = auVar.field_msgId;
                            long j2 = auVar.field_msgSvrId;
                            str2 = auVar.field_talker;
                            Intent intent2 = new Intent(this.yqa.getContext(), ImageGalleryUI.class);
                            intent2.putExtra("img_gallery_msg_id", j);
                            intent2.putExtra("img_gallery_talker", str2);
                            intent2.putExtra("img_gallery_left", iArr[0]);
                            intent2.putExtra("img_gallery_top", iArr[1]);
                            intent2.putExtra("img_gallery_width", width);
                            intent2.putExtra("img_gallery_height", height);
                            String crz = this.yqa.crz();
                            String a = a(this.yqa, auVar);
                            Bundle bundle2 = new Bundle();
                            if (this.yqa.ysk) {
                                str3 = "stat_scene";
                                i = 2;
                                bundle = bundle2;
                            } else {
                                str3 = "stat_scene";
                                if (s.gF(crz)) {
                                    i = 7;
                                    bundle = bundle2;
                                } else {
                                    i = 1;
                                    bundle = bundle2;
                                }
                            }
                            bundle.putInt(str3, i);
                            bundle2.putString("stat_msg_id", "msg_" + Long.toString(j2));
                            bundle2.putString("stat_chat_talker_username", crz);
                            bundle2.putString("stat_send_msg_user", a);
                            intent2.putExtra("_stat_obj", bundle2);
                            this.yqa.startActivity(intent2);
                        }
                    }
                    return true;
                }
            } else if (aVar2.url != null && aVar2.url.length() > 0) {
                str2 = p.A(aVar2.url, "message");
                PackageInfo packageInfo = getPackageInfo(aVar.getContext(), aVar2.appId);
                a(aVar, str2, str2, packageInfo == null ? null : packageInfo.versionName, packageInfo == null ? 0 : packageInfo.versionCode, aVar2.appId, false, auVar.field_msgId, auVar.field_msgSvrId, auVar);
            }
            return false;
        }
    }
}
