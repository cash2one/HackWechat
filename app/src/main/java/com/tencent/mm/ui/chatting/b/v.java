package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.aq.i.a;
import com.tencent.mm.aq.l;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.appbrand.jsapi.media.e;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.chatting.af;
import com.tencent.mm.ui.chatting.viewitems.x.b;
import com.tencent.mm.ui.tools.a.1;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.widget.DrawedCallBackLinearLayout;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import java.util.ArrayList;

public final class v implements a {
    public p fhr;
    i onO;
    public l yvQ;
    public ad yvS;

    public v(p pVar) {
        this.fhr = pVar;
    }

    public final boolean f(int i, Intent intent) {
        int i2 = 1;
        String str;
        String crz;
        switch (i) {
            case 200:
                if (intent == null) {
                    return true;
                }
                boolean z;
                Intent intent2 = new Intent();
                intent2.setClassName(this.fhr.csq().getContext(), "com.tencent.mm.ui.tools.CropImageNewUI");
                intent2.putExtra("CropImageMode", 4);
                intent2.putExtra("CropImage_Filter", true);
                str = "CropImage_Has_Raw_Img_Btn";
                crz = this.fhr.crz();
                if (crz == null || !(x.Wx(crz) || x.Wz(crz))) {
                    z = true;
                } else {
                    z = false;
                }
                intent2.putExtra(str, z);
                intent2.putExtra("from_source", 3);
                u csq = this.fhr.csq();
                ar.Hg();
                String Fi = c.Fi();
                if (intent.getData().toString().startsWith("content://com.google.android.gallery3d")) {
                    new 1(intent, csq, Fi, null, intent2, 203).execute(new Integer[]{Integer.valueOf(0)});
                    return true;
                }
                crz = com.tencent.mm.ui.tools.a.c(csq.getContext(), intent, Fi);
                if (bh.ov(crz)) {
                    return true;
                }
                intent2.putExtra("CropImage_ImgPath", crz);
                csq.startActivityForResult(intent2, 203);
                return true;
            case 201:
                Context applicationContext = this.fhr.csq().getContext().getApplicationContext();
                ar.Hg();
                crz = k.b(applicationContext, intent, c.Fi());
                if (crz == null) {
                    return true;
                }
                Intent intent3 = new Intent();
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(crz);
                intent3.putExtra("query_source_type", 3);
                intent3.putExtra("preview_image", true);
                intent3.putExtra("isTakePhoto", true);
                intent3.putExtra("GalleryUI_FromUser", this.fhr.csv());
                intent3.putExtra("GalleryUI_ToUser", this.fhr.crz());
                intent3.putExtra("is_long_click", true);
                intent3.putStringArrayListExtra("preview_image_list", arrayList);
                intent3.addFlags(67108864);
                d.a(this.fhr.csq(), "gallery", ".ui.GalleryEntryUI", intent3, e.CTRL_INDEX);
                return true;
            case 203:
                crz = intent.getStringExtra("CropImage_OutputPath");
                if (crz != null) {
                    boolean a = q.a(crz, this.fhr.crz(), intent.getBooleanExtra("CropImage_Compress_Img", true));
                    intent.getIntExtra("from_source", 0);
                    int intExtra = intent.getIntExtra("CropImage_rotateCount", 0);
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.SendImgImp", "dkimgsource" + intent.getIntExtra("from_source", 0));
                    if (!a) {
                        i2 = 0;
                    }
                    u(i2, intExtra, crz);
                    this.fhr.csB().clearFocus();
                    break;
                }
                this.fhr.csB().clearFocus();
                return true;
            case e.CTRL_INDEX /*217*/:
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("GalleryUI_ToUser");
                    str = bh.ov(stringExtra) ? this.fhr.csk() : stringExtra;
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.SendImgImp", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE userFromIntent:%s rawUsername:%s", stringExtra, this.fhr.csk());
                    this.fhr.csB().clearFocus();
                    this.fhr.csB().cbP();
                    DrawedCallBackLinearLayout drawedCallBackLinearLayout = (DrawedCallBackLinearLayout) this.fhr.csq().getView().findViewById(R.h.bTA);
                    if (drawedCallBackLinearLayout != null) {
                        drawedCallBackLinearLayout.zsY = new 1(this, intent, str, i);
                        break;
                    }
                }
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI.SendImgImp", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE intent == null");
                return true;
                break;
        }
        return false;
    }

    public final void u(int i, int i2, String str) {
        if (str == null || str.equals("") || !com.tencent.mm.a.e.bO(str)) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.SendImgImp", " doSendImage : filePath is null or empty");
        } else if (this.fhr.csw() != null && !this.fhr.csw().isEnable()) {
            String mMString;
            Context context = this.fhr.csq().getContext();
            if (this.fhr.csw().xzU.XH("").equalsIgnoreCase("@t.qq.com")) {
                mMString = this.fhr.csq().getMMString(R.l.ejj);
            } else {
                mMString = this.fhr.csq().getMMString(R.l.ejh, com.tencent.mm.l.a.fb(this.fhr.csw().name));
            }
            h.b(context, mMString, this.fhr.csq().getMMString(R.l.dGO), true);
        } else if (!g.V(this.fhr.csi())) {
            ar.CG().a(new l(4, this.fhr.csv(), this.fhr.crz(), str, i, null, i2, "", "", true, R.g.bAH), 0);
            this.fhr.mM(true);
        }
    }

    public final boolean aP(au auVar) {
        if (!auVar.cje()) {
            return false;
        }
        ar.Hg();
        if (c.isSDCardAvailable()) {
            if (!this.fhr.csi().field_username.equals("medianote")) {
                ar.Hg();
                c.EX().b(new com.tencent.mm.ay.e(auVar.field_talker, auVar.field_msgSvrId));
            }
            af.aE(auVar);
            this.fhr.mM(true);
            return true;
        }
        com.tencent.mm.ui.base.u.fI(this.fhr.csq().getContext());
        return true;
    }

    public final void b(long j, int i, int i2) {
        com.tencent.mm.ui.chatting.q csy = this.fhr.csy();
        if (csy.ytr.containsKey(Long.valueOf(j)) && csy.yts.containsKey(Long.valueOf(j))) {
            b.a((com.tencent.mm.ui.chatting.viewitems.b.a) ((View) csy.ytr.get(Long.valueOf(j))).getTag(), i, i2);
        } else {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingListAdapter", "msg not display, " + j);
        }
    }

    public final void f(long j, boolean z) {
        com.tencent.mm.ui.chatting.q csy = this.fhr.csy();
        if (csy.ytr.containsKey(Long.valueOf(j)) && csy.yts.containsKey(Long.valueOf(j))) {
            b.a((com.tencent.mm.ui.chatting.viewitems.b.a) ((View) csy.ytr.get(Long.valueOf(j))).getTag(), z);
        } else {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingListAdapter", "msg not display, " + j);
        }
    }
}
