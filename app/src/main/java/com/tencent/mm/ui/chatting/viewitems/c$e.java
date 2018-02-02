package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.a.a.c.a;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.g.a.hy;
import com.tencent.mm.g.a.lh;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams$a;
import com.tencent.mm.plugin.appbrand.jsapi.bp;
import com.tencent.mm.plugin.appbrand.m.b;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.q$a;
import com.tencent.mm.protocal.c.bzu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI;
import com.tencent.mm.ui.chatting.ChattingUI$a;
import com.tencent.mm.ui.chatting.ah;
import com.tencent.mm.ui.chatting.q;
import com.tencent.mm.ui.chatting.r.h;
import com.tencent.mm.ui.chatting.r.i;
import com.tencent.mm.ui.chatting.r.k;
import com.tencent.mm.ui.e$i;
import com.tencent.mm.ui.tools.ShowImageUI;
import com.tencent.mm.y.g$a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.s;
import com.tencent.mm.z.t;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteDatabase;

public class c$e extends b {
    private c yHa;
    protected h yJA;
    protected k yJB;
    protected i yJC;
    private ChattingUI$a yqa;

    public final boolean aXj() {
        return true;
    }

    public c$e() {
        a aVar = new a();
        aVar.hDP = R.k.dvG;
        aVar.bc(com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 20), com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 20)).hDy = true;
        this.yHa = aVar.PK();
    }

    public final boolean aj(int i, boolean z) {
        if ((z && i == 49) || i == 335544369 || i == 402653233 || i == 369098801) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddO);
        view.setTag(new c.c().p(view, false));
        return view;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(b.a aVar, int i, ChattingUI$a chattingUI$a, au auVar, String str) {
        com.tencent.mm.y.k fX;
        g$a com_tencent_mm_y_g_a;
        Object obj;
        b.a aVar2 = (c.c) aVar;
        this.yqa = chattingUI$a;
        chattingUI$a.yvP.aT(auVar);
        aVar2.reset();
        String str2 = auVar.field_content;
        chattingUI$a.yvP.aR(auVar);
        if (str2 != null) {
            g$a I = g$a.I(str2, auVar.field_reserved);
            fX = com.tencent.mm.y.k.fX(str2);
            com_tencent_mm_y_g_a = I;
        } else {
            fX = null;
            com_tencent_mm_y_g_a = null;
        }
        ar arVar = new ar(auVar, chattingUI$a.ypn, i, null, (byte) 0);
        Object obj2 = null;
        if (com_tencent_mm_y_g_a != null) {
            boolean z;
            ar arVar2;
            Bitmap b;
            String str3;
            f cQ = g.cQ(com_tencent_mm_y_g_a.appId, com_tencent_mm_y_g_a.fIm);
            aVar2.iiq.setText(com_tencent_mm_y_g_a.title);
            aVar2.iir.setText(com_tencent_mm_y_g_a.description);
            aVar2.nnC.setMaxLines(1);
            aVar2.iiq.setTextColor(chattingUI$a.getContext().getResources().getColor(R.e.btv));
            aVar2.iir.setTextColor(chattingUI$a.getContext().getResources().getColor(R.e.bsO));
            aVar2.yJf.setBackgroundResource(R.g.bAP);
            aVar2.yJf.setPadding(0, chattingUI$a.getContext().getResources().getDimensionPixelSize(R.f.bvB), 0, 0);
            aVar2.yIL.setVisibility(0);
            aVar2.yJd.setVisibility(0);
            aVar2.iir.setVisibility(0);
            aVar2.yJh.setVisibility(8);
            aVar2.yJi.setVisibility(8);
            aVar2.yIU.setVisibility(8);
            aVar2.yIT.setVisibility(8);
            aVar2.yIQ.setVisibility(8);
            aVar2.yIO.setVisibility(8);
            aVar2.yIN.setVisibility(8);
            aVar2.yJs.setVisibility(8);
            aVar2.yJl.setVisibility(8);
            aVar2.yJf.setVisibility(0);
            c.c.O(aVar2.yJe, aVar2.yJw);
            String str4 = (cQ == null || cQ.field_appName == null || cQ.field_appName.trim().length() <= 0) ? com_tencent_mm_y_g_a.appName : cQ.field_appName;
            boolean z2 = true;
            com.tencent.mm.bv.a.fromDPToPix(chattingUI$a.getContext(), 12);
            if (com_tencent_mm_y_g_a.type == 20 || "wxaf060266bfa9a35c".equals(com_tencent_mm_y_g_a.appId)) {
                z2 = q$a.bXY().brA();
            }
            if (z2 && com_tencent_mm_y_g_a.appId != null && com_tencent_mm_y_g_a.appId.length() > 0 && g.cz(str4)) {
                aVar2.mxT.setText(g.a(chattingUI$a.getContext(), cQ, str4));
                aVar2.yIP.setVisibility(0);
                aVar2.mxT.setVisibility(0);
                aVar2.mxT.setCompoundDrawables(null, null, null, null);
                aVar2.yIM.setVisibility(0);
                if (cQ == null || !cQ.Yz()) {
                    a(chattingUI$a, aVar2.mxT, com_tencent_mm_y_g_a.appId);
                } else {
                    a(chattingUI$a, aVar2.mxT, auVar, com_tencent_mm_y_g_a, cQ.field_packageName, auVar.field_msgSvrId);
                }
                a(chattingUI$a, aVar2.yIM, com_tencent_mm_y_g_a.appId);
            } else if (com_tencent_mm_y_g_a.type == 24) {
                aVar2.mxT.setText(ac.getContext().getString(R.l.eeE));
                aVar2.yIP.setVisibility(0);
                aVar2.mxT.setVisibility(0);
                aVar2.yIM.setVisibility(8);
            } else if (com_tencent_mm_y_g_a.type == 19 || fX.hea == 19) {
                aVar2.mxT.setText(ac.getContext().getString(R.l.dRw));
                aVar2.yIP.setVisibility(0);
                aVar2.mxT.setVisibility(0);
                aVar2.yIM.setVisibility(8);
            } else if (!c.a(com_tencent_mm_y_g_a, aVar2)) {
                aVar2.yIP.setVisibility(8);
                aVar2.mxT.setVisibility(8);
                aVar2.yIM.setVisibility(8);
            }
            boolean z3 = false;
            aVar2.yIL.setVisibility(0);
            if (this.vzn) {
                Bitmap bitmap = null;
                if (!(com_tencent_mm_y_g_a.type == 33 || com_tencent_mm_y_g_a.type == 36)) {
                    bitmap = o.Pw().a(auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(chattingUI$a.getContext()), false);
                }
                if (bitmap == null || bitmap.isRecycled()) {
                    z3 = true;
                } else {
                    aVar2.yIL.setImageBitmap(bitmap);
                }
                if (com_tencent_mm_y_g_a.type == 3) {
                    aVar2.yJf.getViewTreeObserver().addOnPreDrawListener(new 1(this, aVar2, chattingUI$a, bitmap));
                }
                z = z3;
            } else {
                aVar2.yIL.setImageBitmap(BitmapFactory.decodeResource(chattingUI$a.getResources(), R.g.bEh));
                z = false;
            }
            aVar2.yIV.setOnClickListener(null);
            Bitmap b2;
            WxaAttributes qK;
            CharSequence charSequence;
            Object obj3;
            switch (com_tencent_mm_y_g_a.type) {
                case 0:
                    if (com_tencent_mm_y_g_a.title == null || com_tencent_mm_y_g_a.title.length() <= 0) {
                        aVar2.iiq.setVisibility(8);
                    } else {
                        aVar2.iiq.setVisibility(0);
                    }
                    aVar2.iir.setVisibility(0);
                    aVar2.nnC.setVisibility(8);
                    aVar2.yIQ.setVisibility(8);
                    aVar2.yIV.setVisibility(4);
                    aVar2.iir.setMaxLines(2);
                    if (z) {
                        b2 = g.b(com_tencent_mm_y_g_a.appId, 1, com.tencent.mm.bv.a.getDensity(chattingUI$a.getContext()));
                        if (b2 != null && !b2.isRecycled()) {
                            aVar2.yIL.setImageBitmap(b2);
                            arVar2 = arVar;
                            obj = null;
                            break;
                        }
                        aVar2.yIL.setImageResource(R.k.dvD);
                        arVar2 = arVar;
                        obj = null;
                        break;
                    }
                    break;
                case 3:
                    if (com_tencent_mm_y_g_a.title == null || com_tencent_mm_y_g_a.title.length() <= 0) {
                        aVar2.iiq.setVisibility(8);
                    } else {
                        aVar2.iiq.setVisibility(0);
                        aVar2.iiq.setTextColor(chattingUI$a.getContext().getResources().getColor(R.e.white));
                    }
                    aVar2.iir.setVisibility(0);
                    aVar2.iir.setTextColor(chattingUI$a.getContext().getResources().getColor(R.e.white));
                    aVar2.nnC.setVisibility(8);
                    aVar2.yIQ.setVisibility(4);
                    aVar2.iir.setMaxLines(2);
                    aVar2.yIV.setVisibility(0);
                    if ((auVar.field_msgId).equals(aVar.yIA)) {
                        aVar2.yIV.setImageResource(R.g.bDR);
                    } else {
                        aVar2.yIV.setImageResource(R.g.bDS);
                    }
                    c.f fVar = new c.f();
                    fVar.fqm = auVar.field_msgId;
                    fVar.fCs = auVar.field_content;
                    fVar.fzs = auVar.field_imgPath;
                    aVar2.yIV.setTag(fVar);
                    aVar2.yIV.setOnClickListener(chattingUI$a.ysf.yta);
                    if (z) {
                        b2 = g.b(com_tencent_mm_y_g_a.appId, 1, com.tencent.mm.bv.a.getDensity(chattingUI$a.getContext()));
                        if (b2 == null || b2.isRecycled()) {
                            aVar2.yIL.setImageResource(R.k.dvn);
                        } else {
                            aVar2.yIL.setImageBitmap(b2);
                        }
                    }
                    if (!cvy()) {
                        if (aVar2.psA != null) {
                            aVar2.psA.setVisibility(0);
                            if (auVar.field_status >= 2) {
                                aVar2.psA.setVisibility(8);
                                arVar2 = arVar;
                                obj = null;
                                break;
                            }
                        }
                    } else if (aVar2.psA != null) {
                        aVar2.psA.setVisibility(8);
                        arVar2 = arVar;
                        obj = null;
                        break;
                    }
                    break;
                case 4:
                    if (com_tencent_mm_y_g_a.title == null || com_tencent_mm_y_g_a.title.length() <= 0) {
                        aVar2.iiq.setVisibility(8);
                    } else {
                        aVar2.iiq.setVisibility(0);
                    }
                    aVar2.iir.setVisibility(0);
                    aVar2.nnC.setVisibility(8);
                    aVar2.iir.setMaxLines(2);
                    aVar2.yIQ.setVisibility(4);
                    aVar2.yIV.setVisibility(0);
                    aVar2.yIV.setImageResource(R.g.bHf);
                    if (z) {
                        b2 = g.b(com_tencent_mm_y_g_a.appId, 1, com.tencent.mm.bv.a.getDensity(chattingUI$a.getContext()));
                        if (b2 == null || b2.isRecycled()) {
                            aVar2.yIL.setImageResource(R.k.dvA);
                        } else {
                            aVar2.yIL.setImageBitmap(b2);
                        }
                        aVar2.yIV.setVisibility(8);
                        arVar2 = arVar;
                        obj = null;
                        break;
                    }
                    break;
                case 5:
                    aVar2.iiq.setVisibility(8);
                    if (com_tencent_mm_y_g_a.title == null || com_tencent_mm_y_g_a.title.length() <= 0) {
                        aVar2.nnC.setVisibility(8);
                    } else {
                        aVar2.nnC.setMaxLines(2);
                        aVar2.nnC.setVisibility(0);
                        aVar2.nnC.setText(com_tencent_mm_y_g_a.title);
                    }
                    aVar2.iir.setMaxLines(3);
                    aVar2.yIQ.setVisibility(4);
                    if (c.i(com_tencent_mm_y_g_a)) {
                        aVar2.yIV.setImageResource(R.g.bHf);
                        aVar2.yIV.setVisibility(0);
                    } else {
                        aVar2.yIV.setVisibility(8);
                    }
                    if (z) {
                        b2 = g.b(com_tencent_mm_y_g_a.appId, 1, com.tencent.mm.bv.a.getDensity(chattingUI$a.getContext()));
                        if (b2 == null) {
                            a aVar3 = new a();
                            aVar3.hDP = R.k.dvD;
                            aVar3.bc(com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 50), com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 50)).hDy = true;
                            o.PA().a(com_tencent_mm_y_g_a.thumburl, aVar2.yIL, aVar3.PK());
                        } else if (b2.isRecycled()) {
                            aVar2.yIL.setImageResource(R.k.dvD);
                        } else {
                            aVar2.yIL.setImageBitmap(b2);
                        }
                    }
                    if (!cvy()) {
                        if (aVar2.psA != null) {
                            aVar2.psA.setVisibility(0);
                            if (auVar.field_status >= 2) {
                                aVar2.psA.setVisibility(8);
                                arVar2 = arVar;
                                obj = null;
                                break;
                            }
                        }
                    }
                    a((c.c) aVar2, chattingUI$a.ysf, auVar);
                    if (aVar2.psA != null) {
                        aVar2.psA.setVisibility(8);
                        arVar2 = arVar;
                        obj = null;
                        break;
                    }
                    break;
                case 6:
                    if (com_tencent_mm_y_g_a.title == null || com_tencent_mm_y_g_a.title.length() <= 0) {
                        aVar2.iiq.setVisibility(8);
                    } else {
                        aVar2.iiq.setVisibility(0);
                        aVar2.iiq.setMaxLines(2);
                    }
                    aVar2.iir.setVisibility(0);
                    aVar2.nnC.setVisibility(8);
                    aVar2.yIQ.setVisibility(4);
                    aVar2.iir.setMaxLines(2);
                    aVar2.iir.setText(bh.bx((long) com_tencent_mm_y_g_a.hbb));
                    aVar2.yIV.setVisibility(8);
                    c.c.a(aVar2, str2, com_tencent_mm_y_g_a.hbb);
                    c.c.a(aVar2, Boolean.valueOf(false), auVar, com_tencent_mm_y_g_a.fny, com_tencent_mm_y_g_a.title);
                    if (z) {
                        if (!bh.VW(com_tencent_mm_y_g_a.hbc)) {
                            aVar2.yIL.setImageResource(r.Ry(com_tencent_mm_y_g_a.hbc));
                            arVar2 = arVar;
                            obj = null;
                            break;
                        }
                        aVar2.yIL.setImageResource(R.g.byY);
                        arVar2 = arVar;
                        obj = null;
                        break;
                    }
                    break;
                case 7:
                    aVar2.iiq.setVisibility(8);
                    if (com_tencent_mm_y_g_a.title == null || com_tencent_mm_y_g_a.title.length() <= 0) {
                        aVar2.nnC.setVisibility(8);
                    } else {
                        aVar2.nnC.setVisibility(0);
                        aVar2.nnC.setText(com_tencent_mm_y_g_a.title);
                    }
                    aVar2.iir.setMaxLines(3);
                    aVar2.yIQ.setVisibility(0);
                    aVar2.yIV.setVisibility(8);
                    if (z) {
                        b2 = g.b(com_tencent_mm_y_g_a.appId, 1, com.tencent.mm.bv.a.getDensity(chattingUI$a.getContext()));
                        if (b2 == null || b2.isRecycled()) {
                            aVar2.yIL.setImageResource(R.k.dvD);
                        } else {
                            aVar2.yIL.setImageBitmap(b2);
                        }
                    }
                    if (!cvy()) {
                        if (aVar2.psA != null) {
                            aVar2.psA.setVisibility(0);
                            if (auVar.field_status >= 2) {
                                aVar2.psA.setVisibility(8);
                                arVar2 = arVar;
                                obj = null;
                                break;
                            }
                        }
                    } else if (aVar2.psA != null) {
                        aVar2.psA.setVisibility(8);
                        arVar2 = arVar;
                        obj = null;
                        break;
                    }
                    break;
                case 10:
                    aVar2.nnC.setVisibility(0);
                    if (com_tencent_mm_y_g_a.hbw == 1) {
                        aVar2.nnC.setText(R.l.eHU);
                    } else if (com_tencent_mm_y_g_a.hbw == 2) {
                        aVar2.nnC.setText(R.l.eHW);
                    } else if (com_tencent_mm_y_g_a.hbw == 3) {
                        aVar2.nnC.setText(R.l.eHV);
                    } else {
                        aVar2.nnC.setText(R.l.eHX);
                    }
                    if (com_tencent_mm_y_g_a.title != null && com_tencent_mm_y_g_a.title.length() > 0) {
                        aVar2.iiq.setVisibility(0);
                        aVar2.iiq.setText(com_tencent_mm_y_g_a.title);
                    }
                    aVar2.iir.setMaxLines(4);
                    aVar2.yIQ.setVisibility(4);
                    aVar2.yIV.setVisibility(8);
                    if (z) {
                        b2 = o.Pw().b(auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(chattingUI$a.getContext()), false);
                        if (b2 != null && !b2.isRecycled()) {
                            aVar2.yIL.setImageBitmap(b2);
                            arVar2 = arVar;
                            obj = null;
                            break;
                        }
                        aVar2.yIL.setImageResource(R.k.dvD);
                        arVar2 = arVar;
                        obj = null;
                        break;
                    }
                    break;
                case 13:
                    aVar2.iiq.setVisibility(0);
                    aVar2.iiq.setText(com_tencent_mm_y_g_a.title);
                    aVar2.nnC.setVisibility(0);
                    aVar2.nnC.setText(R.l.dSc);
                    aVar2.iir.setMaxLines(4);
                    aVar2.yIQ.setVisibility(4);
                    aVar2.yIV.setVisibility(8);
                    if (z) {
                        b2 = o.Pw().b(auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(chattingUI$a.getContext()), false);
                        if (b2 != null && !b2.isRecycled()) {
                            aVar2.yIL.setImageBitmap(b2);
                            arVar2 = arVar;
                            obj = null;
                            break;
                        }
                        aVar2.yIL.setImageResource(R.k.dvD);
                        arVar2 = arVar;
                        obj = null;
                        break;
                    }
                    break;
                case 15:
                    if (com_tencent_mm_y_g_a.title == null || com_tencent_mm_y_g_a.title.length() <= 0) {
                        aVar2.iiq.setVisibility(8);
                    } else {
                        aVar2.iiq.setVisibility(0);
                    }
                    aVar2.iir.setVisibility(0);
                    aVar2.nnC.setVisibility(8);
                    aVar2.yIV.setVisibility(8);
                    aVar2.yIQ.setVisibility(4);
                    aVar2.iir.setMaxLines(2);
                    if (z) {
                        b = o.Pw().b(auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(chattingUI$a.getContext()), false);
                        if (b == null || b.isRecycled()) {
                            aVar2.yIL.setImageResource(R.k.dvD);
                        } else {
                            aVar2.yIL.setImageBitmap(b);
                        }
                    }
                    arVar = new ar(auVar, false, i, "", false, chattingUI$a.csX(), com_tencent_mm_y_g_a.fGz, com_tencent_mm_y_g_a.fGA, com_tencent_mm_y_g_a.title, com_tencent_mm_y_g_a.hbE, com_tencent_mm_y_g_a.url, false, false);
                    aVar2.yJe.setTag(arVar);
                    aVar2.yJe.setOnClickListener(x(chattingUI$a));
                    obj2 = 1;
                    arVar2 = arVar;
                    obj = null;
                    break;
                case 16:
                    aVar2.iiq.setVisibility(0);
                    aVar2.iiq.setText(com_tencent_mm_y_g_a.description);
                    aVar2.iir.setText(com_tencent_mm_y_g_a.hck);
                    if (com_tencent_mm_y_g_a.title == null || com_tencent_mm_y_g_a.title.length() <= 0) {
                        aVar2.nnC.setVisibility(8);
                    } else {
                        aVar2.nnC.setVisibility(0);
                        aVar2.nnC.setText(com_tencent_mm_y_g_a.title);
                    }
                    aVar2.iir.setMaxLines(4);
                    aVar2.yIQ.setVisibility(4);
                    aVar2.yIV.setVisibility(8);
                    if (z) {
                        b2 = o.Pw().b(auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(chattingUI$a.getContext()), false);
                        if (b2 == null) {
                            aVar2.yIL.setImageResource(R.k.dvD);
                            arVar2 = arVar;
                            obj = null;
                            break;
                        }
                        aVar2.yIL.setImageBitmap(b2);
                        arVar2 = arVar;
                        obj = null;
                        break;
                    }
                    break;
                case 19:
                    c.c.a(chattingUI$a, aVar2, com_tencent_mm_y_g_a, z);
                    if (!cvy()) {
                        if (aVar2.psA != null) {
                            aVar2.psA.setVisibility(0);
                            if (auVar.field_status >= 2) {
                                aVar2.psA.setVisibility(8);
                                arVar2 = arVar;
                                obj = null;
                                break;
                            }
                        }
                    }
                    a((c.c) aVar2, chattingUI$a.ysf, auVar);
                    if (aVar2.psA != null) {
                        aVar2.psA.setVisibility(8);
                        arVar2 = arVar;
                        obj = null;
                        break;
                    }
                case 20:
                    if (com_tencent_mm_y_g_a.title != null && com_tencent_mm_y_g_a.title.length() > 0) {
                        aVar2.iiq.setVisibility(0);
                        aVar2.iiq.setText(com_tencent_mm_y_g_a.title);
                        aVar2.nnC.setVisibility(8);
                    }
                    aVar2.iir.setMaxLines(4);
                    aVar2.yIQ.setVisibility(4);
                    aVar2.yIV.setVisibility(8);
                    if (z) {
                        b2 = o.Pw().b(auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(chattingUI$a.getContext()), false);
                        if (b2 != null && !b2.isRecycled()) {
                            aVar2.yIL.setImageBitmap(b2);
                            arVar2 = arVar;
                            obj = null;
                            break;
                        }
                        aVar2.yIL.setImageResource(R.k.dvD);
                        arVar2 = arVar;
                        obj = null;
                        break;
                    }
                    break;
                case 24:
                    aVar2.iiq.setVisibility(8);
                    aVar2.nnC.setVisibility(0);
                    if (com_tencent_mm_y_g_a.title == null || com_tencent_mm_y_g_a.title.length() <= 0) {
                        aVar2.nnC.setText(com.tencent.mm.pluginsdk.ui.d.i.c(aVar2.nnC.getContext(), ac.getContext().getString(R.l.egW), (int) aVar2.nnC.getTextSize()));
                    } else {
                        aVar2.nnC.setText(com.tencent.mm.pluginsdk.ui.d.i.c(aVar2.nnC.getContext(), com_tencent_mm_y_g_a.title, (int) aVar2.nnC.getTextSize()));
                    }
                    aVar2.iir.setMaxLines(3);
                    aVar2.yIQ.setVisibility(4);
                    aVar2.yIV.setVisibility(8);
                    if (z) {
                        aVar2.yIL.setVisibility(8);
                    }
                    c.c.a(chattingUI$a, aVar2, com_tencent_mm_y_g_a, auVar, z);
                    if (!cvy()) {
                        if (aVar2.psA != null) {
                            aVar2.psA.setVisibility(0);
                            if (auVar.field_status >= 2) {
                                aVar2.psA.setVisibility(8);
                                arVar2 = arVar;
                                obj = null;
                                break;
                            }
                        }
                    }
                    a((c.c) aVar2, chattingUI$a.ysf, auVar);
                    if (aVar2.psA != null) {
                        aVar2.psA.setVisibility(8);
                        arVar2 = arVar;
                        obj = null;
                        break;
                    }
                    break;
                case 25:
                    if (com_tencent_mm_y_g_a.title == null || com_tencent_mm_y_g_a.title.length() <= 0) {
                        aVar2.iiq.setVisibility(8);
                    } else {
                        aVar2.iiq.setVisibility(0);
                    }
                    aVar2.iir.setVisibility(0);
                    aVar2.nnC.setVisibility(8);
                    aVar2.yIV.setVisibility(8);
                    aVar2.yIQ.setVisibility(4);
                    aVar2.iir.setMaxLines(2);
                    if (z) {
                        b = o.Pw().b(auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(chattingUI$a.getContext()), false);
                        if (b == null || b.isRecycled()) {
                            aVar2.yIL.setImageResource(R.k.dvD);
                        } else {
                            aVar2.yIL.setImageBitmap(b);
                        }
                    }
                    arVar = new ar(auVar, i, "", chattingUI$a.csX(), com_tencent_mm_y_g_a.fGz, com_tencent_mm_y_g_a.fGA, com_tencent_mm_y_g_a.title, com_tencent_mm_y_g_a.hdl, com_tencent_mm_y_g_a.designerName, com_tencent_mm_y_g_a.designerRediretctUrl, com_tencent_mm_y_g_a.url);
                    aVar2.yJe.setTag(arVar);
                    FrameLayout frameLayout = aVar2.yJe;
                    if (this.yJA == null) {
                        this.yJA = new h(chattingUI$a);
                    }
                    frameLayout.setOnClickListener(this.yJA);
                    obj2 = 1;
                    arVar2 = arVar;
                    obj = null;
                    break;
                case 26:
                case 27:
                    if (com_tencent_mm_y_g_a.title == null || com_tencent_mm_y_g_a.title.length() <= 0) {
                        aVar2.iiq.setVisibility(8);
                    } else {
                        aVar2.iiq.setVisibility(0);
                    }
                    aVar2.iir.setVisibility(0);
                    aVar2.nnC.setVisibility(8);
                    aVar2.yIV.setVisibility(8);
                    aVar2.yIQ.setVisibility(4);
                    aVar2.iir.setMaxLines(2);
                    if (z) {
                        if (bh.ov(auVar.field_imgPath)) {
                            o.PA().a(com_tencent_mm_y_g_a.thumburl, aVar2.yIL);
                        } else {
                            b = o.Pw().b(auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(chattingUI$a.getContext()), false);
                            if (b == null || b.isRecycled()) {
                                aVar2.yIL.setImageResource(R.k.dvD);
                            } else {
                                aVar2.yIL.setImageBitmap(b);
                            }
                        }
                    }
                    arVar2 = new ar();
                    arVar2.fEJ = auVar;
                    arVar2.ypn = false;
                    arVar2.position = i;
                    arVar2.yOD = false;
                    arVar2.title = chattingUI$a.csX();
                    arVar2.fGz = com_tencent_mm_y_g_a.fGz;
                    arVar2.fGA = com_tencent_mm_y_g_a.fGA;
                    arVar2.yOE = com_tencent_mm_y_g_a.title;
                    FrameLayout frameLayout2;
                    if (com_tencent_mm_y_g_a.type == 26) {
                        arVar2.tid = com_tencent_mm_y_g_a.tid;
                        arVar2.hdm = com_tencent_mm_y_g_a.hdm;
                        arVar2.desc = com_tencent_mm_y_g_a.desc;
                        arVar2.iconUrl = com_tencent_mm_y_g_a.iconUrl;
                        arVar2.secondUrl = com_tencent_mm_y_g_a.secondUrl;
                        arVar2.pageType = com_tencent_mm_y_g_a.pageType;
                        frameLayout2 = aVar2.yJe;
                        if (this.yJB == null) {
                            this.yJB = new k(chattingUI$a);
                        }
                        frameLayout2.setOnClickListener(this.yJB);
                        obj = 1;
                    } else if (com_tencent_mm_y_g_a.type == 27) {
                        arVar2.tid = com_tencent_mm_y_g_a.tid;
                        arVar2.hdm = com_tencent_mm_y_g_a.hdm;
                        arVar2.desc = com_tencent_mm_y_g_a.desc;
                        arVar2.iconUrl = com_tencent_mm_y_g_a.iconUrl;
                        arVar2.secondUrl = com_tencent_mm_y_g_a.secondUrl;
                        arVar2.pageType = com_tencent_mm_y_g_a.pageType;
                        frameLayout2 = aVar2.yJe;
                        if (this.yJC == null) {
                            this.yJC = new i(chattingUI$a);
                        }
                        frameLayout2.setOnClickListener(this.yJC);
                        obj = 1;
                    } else {
                        x.i("MicroMsg.ChattingItemAppMsgTo", "unknow view type");
                        obj = null;
                    }
                    aVar2.yJe.setTag(arVar2);
                    obj2 = obj;
                    obj = null;
                    break;
                case 33:
                    Object obj4;
                    qK = ((b) com.tencent.mm.kernel.g.h(b.class)).qK(com_tencent_mm_y_g_a.hdx);
                    switch (com_tencent_mm_y_g_a.hdz) {
                        case 1:
                            if (qK != null) {
                                charSequence = qK.field_nickname;
                            } else {
                                obj3 = com_tencent_mm_y_g_a.title;
                            }
                            str4 = qK != null ? qK.field_brandIconURL : null;
                            aVar2.yJf.setVisibility(8);
                            aVar2.yJs.setVisibility(8);
                            aVar2.yJl.setVisibility(0);
                            aVar2.yJn.setText(charSequence);
                            if (!bh.ov(str4)) {
                                com.tencent.mm.modelappbrand.a.b.Jj().a(aVar2.yJm, str4, com.tencent.mm.modelappbrand.a.a.Ji(), com.tencent.mm.modelappbrand.a.f.hkr);
                                obj4 = null;
                                break;
                            }
                            com.tencent.mm.modelappbrand.a.b.Jj().a(aVar2.yJm, "file://" + o.Pw().ln(auVar.field_imgPath), com.tencent.mm.modelappbrand.a.a.Ji(), com.tencent.mm.modelappbrand.a.f.hkr);
                            obj4 = null;
                            break;
                        case 2:
                        case 3:
                            if (qK != null) {
                                charSequence = qK.field_nickname;
                            } else {
                                obj3 = com_tencent_mm_y_g_a.fGA;
                            }
                            if (qK != null) {
                                str4 = qK.field_brandIconURL;
                            } else {
                                str4 = com_tencent_mm_y_g_a.hdG;
                            }
                            aVar2.yJf.setVisibility(8);
                            aVar2.yJs.setVisibility(0);
                            aVar2.yJl.setVisibility(8);
                            aVar2.yJo.setVisibility(8);
                            aVar2.yJv.setText(com_tencent_mm_y_g_a.title);
                            aVar2.yJo.setText(com_tencent_mm_y_g_a.description);
                            aVar2.yJq.setText(charSequence);
                            switch (com_tencent_mm_y_g_a.hdE) {
                                case 1:
                                    aVar2.yJr.setText(R.l.dEl);
                                    break;
                                case 2:
                                    aVar2.yJr.setText(R.l.dEk);
                                    break;
                                default:
                                    aVar2.yJr.setText(R.l.dDT);
                                    break;
                            }
                            o.PA().a(str4, aVar2.yJp, this.yHa);
                            str4 = o.Pw().ln(auVar.field_imgPath);
                            aVar2.yJt.setImageBitmap(null);
                            com.tencent.mm.modelappbrand.a.b.Jj().a(new 2(this, aVar2), "file://" + str4, null, ((com.tencent.mm.modelappbrand.g) com.tencent.mm.kernel.g.h(com.tencent.mm.modelappbrand.g.class)).aZ(bp.CTRL_INDEX, 172));
                            obj4 = null;
                            break;
                        default:
                            obj4 = 1;
                            break;
                    }
                    if (obj4 == null) {
                        if (!cvy()) {
                            if (aVar2.psA != null) {
                                aVar2.psA.setVisibility(0);
                                if (auVar.field_status >= 2) {
                                    aVar2.psA.setVisibility(8);
                                    arVar2 = arVar;
                                    obj = obj4;
                                    break;
                                }
                            }
                        }
                        a((c.c) aVar2, chattingUI$a.ysf, auVar);
                        if (aVar2.psA != null) {
                            aVar2.psA.setVisibility(8);
                            arVar2 = arVar;
                            obj = obj4;
                            break;
                        }
                    }
                    arVar2 = arVar;
                    obj = obj4;
                    break;
                case 34:
                    if (com_tencent_mm_y_g_a.title == null || com_tencent_mm_y_g_a.title.length() <= 0) {
                        aVar2.iiq.setVisibility(8);
                    } else {
                        aVar2.iiq.setVisibility(0);
                        if (bh.ov(com_tencent_mm_y_g_a.hct)) {
                            aVar2.iiq.setTextColor(chattingUI$a.getContext().getResources().getColor(R.e.black));
                        } else if (bh.ov(com_tencent_mm_y_g_a.hct)) {
                            aVar2.iiq.setTextColor(chattingUI$a.getContext().getResources().getColor(R.e.black));
                        } else {
                            aVar2.iiq.setTextColor(bh.ba(com_tencent_mm_y_g_a.hct, chattingUI$a.getContext().getResources().getColor(R.e.black)));
                        }
                    }
                    aVar2.iir.setMaxLines(2);
                    aVar2.iir.setVisibility(0);
                    if (bh.ov(com_tencent_mm_y_g_a.hcu)) {
                        aVar2.iir.setTextColor(chattingUI$a.getContext().getResources().getColor(R.e.bsF));
                    } else {
                        aVar2.iir.setTextColor(bh.ba(com_tencent_mm_y_g_a.hcu, chattingUI$a.getContext().getResources().getColor(R.e.bsF)));
                    }
                    aVar2.nnC.setVisibility(8);
                    aVar2.yIQ.setVisibility(4);
                    aVar2.yIV.setVisibility(8);
                    aVar2.yIP.setVisibility(0);
                    aVar2.mxT.setVisibility(0);
                    if (bh.ov(com_tencent_mm_y_g_a.hcp)) {
                        aVar2.mxT.setText(R.l.dRv);
                    } else {
                        aVar2.mxT.setText(com_tencent_mm_y_g_a.hcp);
                    }
                    if (!this.vzn) {
                        aVar2.yIL.setImageBitmap(BitmapFactory.decodeResource(chattingUI$a.getResources(), R.g.bEh));
                        arVar2 = arVar;
                        obj = null;
                        break;
                    }
                    b2 = o.Pw().a(auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(chattingUI$a.getContext()), false);
                    if (!(b2 == null || b2.isRecycled())) {
                        aVar2.yIL.setImageBitmap(d.a(b2, false, (float) (b2.getWidth() / 2)));
                    }
                    if (!bh.ov(com_tencent_mm_y_g_a.hcs)) {
                        com.tencent.mm.aq.a.a PA = o.PA();
                        str3 = com_tencent_mm_y_g_a.hcs;
                        ImageView imageView = new ImageView(chattingUI$a.getContext());
                        a aVar4 = new a();
                        aVar4.hDA = true;
                        PA.a(str3, imageView, aVar4.PK(), new 3(this, aVar2, chattingUI$a));
                        arVar2 = arVar;
                        obj = null;
                        break;
                    }
                    aVar2.yJf.getViewTreeObserver().addOnPreDrawListener(new 4(this, aVar2, chattingUI$a, b2));
                    arVar2 = arVar;
                    obj = null;
                    break;
                    break;
                case 36:
                    qK = ((b) com.tencent.mm.kernel.g.h(b.class)).qK(com_tencent_mm_y_g_a.hdx);
                    if (qK != null) {
                        charSequence = qK.field_nickname;
                    } else {
                        obj3 = com_tencent_mm_y_g_a.fGA;
                    }
                    if (qK != null) {
                        str4 = qK.field_brandIconURL;
                    } else {
                        str4 = com_tencent_mm_y_g_a.hdG;
                    }
                    aVar2.yJf.setVisibility(8);
                    aVar2.yJs.setVisibility(0);
                    aVar2.yJl.setVisibility(8);
                    aVar2.yJo.setVisibility(8);
                    aVar2.yJv.setText(com_tencent_mm_y_g_a.title);
                    aVar2.yJo.setText(com_tencent_mm_y_g_a.description);
                    aVar2.yJq.setText(charSequence);
                    switch (com_tencent_mm_y_g_a.hdE) {
                        case 1:
                            aVar2.yJr.setText(R.l.dEl);
                            break;
                        case 2:
                            aVar2.yJr.setText(R.l.dEk);
                            break;
                        default:
                            aVar2.yJr.setText(R.l.dDT);
                            break;
                    }
                    o.PA().a(str4, aVar2.yJp, this.yHa);
                    String ln = o.Pw().ln(auVar.field_imgPath);
                    aVar2.yJt.setImageBitmap(null);
                    com.tencent.mm.modelappbrand.a.b.Jj().a(aVar2.yJt, "file://" + ln, null, null, ((com.tencent.mm.modelappbrand.g) com.tencent.mm.kernel.g.h(com.tencent.mm.modelappbrand.g.class)).aZ(bp.CTRL_INDEX, 172));
                    if (!cvy()) {
                        if (aVar2.psA != null) {
                            aVar2.psA.setVisibility(0);
                            if (auVar.field_status >= 2) {
                                aVar2.psA.setVisibility(8);
                                arVar2 = arVar;
                                obj = null;
                                break;
                            }
                        }
                    }
                    a((c.c) aVar2, chattingUI$a.ysf, auVar);
                    if (aVar2.psA != null) {
                        aVar2.psA.setVisibility(8);
                        arVar2 = arVar;
                        obj = null;
                        break;
                    }
                case 40:
                    if (fX.hea == 19) {
                        c.c.a(chattingUI$a, aVar2, com_tencent_mm_y_g_a, z);
                        arVar2 = arVar;
                        obj = null;
                        break;
                    }
                default:
                    arVar2 = arVar;
                    obj = 1;
                    break;
            }
            if (obj != null) {
                if (com_tencent_mm_y_g_a.title == null || com_tencent_mm_y_g_a.title.length() <= 0) {
                    aVar2.nnC.setVisibility(8);
                } else {
                    aVar2.nnC.setVisibility(0);
                    aVar2.nnC.setMaxLines(2);
                    aVar2.nnC.setText(com_tencent_mm_y_g_a.title);
                }
                aVar2.iiq.setVisibility(8);
                if (z) {
                    if (com_tencent_mm_y_g_a.type == 33 || com_tencent_mm_y_g_a.type == 36) {
                        str3 = o.Pw().ln(auVar.field_imgPath);
                        aVar2.yIL.setImageResource(R.k.dvD);
                        com.tencent.mm.modelappbrand.a.b.Jj().a(aVar2.yIL, "file://" + str3, null, null, ((com.tencent.mm.modelappbrand.g) com.tencent.mm.kernel.g.h(com.tencent.mm.modelappbrand.g.class)).aZ(50, 50));
                        obj = arVar2;
                    } else {
                        b = o.Pw().b(auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(chattingUI$a.getContext()), false);
                        if (b == null || b.isRecycled()) {
                            b = o.Pw().a(auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(chattingUI$a.getContext()), false);
                        }
                        if (b == null || b.isRecycled()) {
                            aVar2.yIL.setImageResource(R.g.byY);
                        } else {
                            aVar2.yIL.setImageBitmap(b);
                            arVar = arVar2;
                        }
                    }
                }
            }
            arVar = arVar2;
        }
        if (obj2 == null) {
            aVar2.yJe.setTag(obj);
            aVar2.yJe.setOnClickListener(t(chattingUI$a));
        }
        if (this.vzn) {
            aVar2.yJe.setOnLongClickListener(s(chattingUI$a));
            aVar2.yJe.setOnTouchListener(chattingUI$a.ysf.ysV);
        }
        a(i, aVar2, auVar, chattingUI$a.ysf.hlJ, chattingUI$a.ypn, chattingUI$a);
    }

    private static void a(c.c cVar, q qVar, au auVar) {
        if (auVar.field_status == 2 && a(qVar, auVar.field_msgId)) {
            if (cVar.yJk != null) {
                cVar.yJk.setVisibility(0);
            }
        } else if (cVar.yJk != null) {
            cVar.yJk.setVisibility(8);
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        int i = ((ar) view.getTag()).position;
        String str = auVar.field_content;
        if (str == null) {
            return true;
        }
        g$a fT = g$a.fT(this.yqa.dk(str, auVar.field_isSend));
        if (fT == null) {
            return true;
        }
        boolean LL;
        f aZ = g.aZ(fT.appId, false);
        if (g.h(aZ) && !com.tencent.mm.ui.chatting.i.an(auVar)) {
            contextMenu.add(i, 111, 0, this.yqa.getString(R.l.eEC));
        }
        if ((auVar.field_status == 2 || auVar.gjJ == 1) && a(auVar, this.yqa) && Zq(auVar.field_talker)) {
            contextMenu.add(i, 123, 0, view.getContext().getString(R.l.dRQ));
        }
        switch (fT.type) {
            case 1:
                LL = com.tencent.mm.ag.f.LL();
                break;
            case 2:
                LL = com.tencent.mm.ag.f.LN();
                break;
            case 3:
                LL = com.tencent.mm.ag.f.LW();
                break;
            case 4:
                LL = com.tencent.mm.ag.f.LO();
                break;
            case 5:
                LL = com.tencent.mm.ag.f.LU();
                break;
            case 6:
                LL = com.tencent.mm.ag.f.LV();
                break;
            case 8:
                LL = com.tencent.mm.ag.f.LS();
                break;
            case 16:
                if (fT.hcl != 5 && fT.hcl != 6 && fT.hcl != 2) {
                    LL = false;
                    break;
                }
                if (fT.hcl != 2) {
                    contextMenu.clear();
                }
                contextMenu.add(i, 100, 0, this.yqa.getString(R.l.dRH));
                return false;
                break;
            case 34:
                contextMenu.clear();
                contextMenu.add(i, 100, 0, this.yqa.getString(R.l.dRH));
                return false;
            default:
                LL = false;
                break;
        }
        if (LL && !this.yqa.csV()) {
            contextMenu.add(i, 114, 0, view.getContext().getString(R.l.dRD));
        }
        if (com.tencent.mm.bm.d.OQ("favorite") && (aZ == null || !aZ.Yz())) {
            switch (fT.type) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 10:
                case 13:
                case 19:
                case 20:
                case 24:
                    contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eAd));
                    break;
            }
        }
        com.tencent.mm.sdk.b.b dhVar = new dh();
        dhVar.frQ.fqm = auVar.field_msgId;
        com.tencent.mm.sdk.b.a.xef.m(dhVar);
        if (dhVar.frR.frp || c.b.a(this.yqa.getContext(), fT)) {
            contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dRM));
        }
        if (!this.yqa.csV()) {
            contextMenu.add(i, 100, 0, this.yqa.getString(R.l.dRH));
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, ChattingUI$a chattingUI$a, au auVar) {
        g$a com_tencent_mm_y_g_a;
        com.tencent.mm.sdk.b.b mtVar;
        String str;
        switch (menuItem.getItemId()) {
            case 100:
                String str2 = auVar.field_content;
                com_tencent_mm_y_g_a = null;
                if (str2 != null) {
                    com_tencent_mm_y_g_a = g$a.fT(str2);
                }
                if (com_tencent_mm_y_g_a != null && 19 == com_tencent_mm_y_g_a.type) {
                    mtVar = new mt();
                    mtVar.fEE.type = 3;
                    mtVar.fEE.fqm = auVar.field_msgId;
                    com.tencent.mm.sdk.b.a.xef.m(mtVar);
                }
                ba.aK(auVar.field_msgId);
                if (com_tencent_mm_y_g_a != null) {
                    f aZ = g.aZ(com_tencent_mm_y_g_a.appId, false);
                    if (aZ != null && aZ.Yz()) {
                        a(chattingUI$a, com_tencent_mm_y_g_a, auVar, aZ);
                        break;
                    }
                }
                break;
            case 103:
                str = auVar.field_content;
                if (str != null) {
                    com_tencent_mm_y_g_a = g$a.fT(str);
                    if (com_tencent_mm_y_g_a != null) {
                        switch (com_tencent_mm_y_g_a.type) {
                            case 16:
                                mtVar = new hy();
                                mtVar.fyr.fys = com_tencent_mm_y_g_a.fys;
                                mtVar.fyr.fpG = auVar.field_msgId;
                                mtVar.fyr.fyt = auVar.field_talker;
                                com.tencent.mm.sdk.b.a.xef.m(mtVar);
                                break;
                            default:
                                break;
                        }
                    }
                }
                break;
            case 111:
                c.b.a(chattingUI$a, auVar, a(chattingUI$a, auVar));
                break;
            case 114:
                str = auVar.field_content;
                if (str != null) {
                    com_tencent_mm_y_g_a = g$a.fT(str);
                    if (com_tencent_mm_y_g_a != null) {
                        switch (com_tencent_mm_y_g_a.type) {
                            case 1:
                                ah.k(chattingUI$a.dk(auVar.field_content, auVar.field_isSend), chattingUI$a.getContext());
                                break;
                            case 2:
                                ah.a(auVar, chattingUI$a.getContext(), a(chattingUI$a, auVar), chattingUI$a.ysk);
                                break;
                            case 3:
                                ah.a(auVar, chattingUI$a.dk(auVar.field_content, auVar.field_isSend), chattingUI$a.getContext());
                                break;
                            case 4:
                                ah.a(auVar, chattingUI$a.getContext());
                                break;
                            case 5:
                                ah.c(auVar, chattingUI$a.dk(auVar.field_content, auVar.field_isSend), chattingUI$a.getContext());
                                break;
                            case 6:
                                ah.b(auVar, chattingUI$a.dk(auVar.field_content, auVar.field_isSend), chattingUI$a.getContext());
                                break;
                            case 8:
                                ah.b(auVar, chattingUI$a.getContext());
                                break;
                            default:
                                break;
                        }
                    }
                }
                break;
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(View view, ChattingUI$a chattingUI$a, au auVar) {
        String str;
        view.getTag();
        String str2 = auVar.field_content;
        if (str2 == null) {
            return false;
        }
        g$a fT = g$a.fT(str2);
        if (fT == null) {
            return false;
        }
        Intent intent;
        byte[] bArr;
        Intent intent2;
        Bundle bundle;
        int N;
        f aZ = g.aZ(fT.appId, true);
        if (!(aZ == null || bh.ov(aZ.field_appId) || !aZ.Yz())) {
            a(chattingUI$a, fT, com.tencent.mm.z.q.FS(), aZ, auVar.field_msgSvrId);
        }
        Intent intent3;
        Object obj;
        String crz;
        Bundle bundle2;
        Bundle bundle3;
        switch (fT.type) {
            case 3:
                com.tencent.mm.plugin.report.service.g.pQN.h(13043, new Object[]{Integer.valueOf(2), fT.description, fT.appId});
                break;
            case 4:
                break;
            case 5:
                if (bh.ov(fT.canvasPageXml)) {
                    com.tencent.mm.plugin.webview.fts.topstory.a.a aVar = (com.tencent.mm.plugin.webview.fts.topstory.a.a) fT.r(com.tencent.mm.plugin.webview.fts.topstory.a.a.class);
                    if (!(aVar == null || bh.ov(aVar.tnm))) {
                        intent = new Intent();
                        intent.putExtra("key_scene", 2);
                        bzu com_tencent_mm_protocal_c_bzu = new bzu();
                        com_tencent_mm_protocal_c_bzu.tnm = aVar.tnm;
                        com_tencent_mm_protocal_c_bzu.tnn = aVar.tnn;
                        com_tencent_mm_protocal_c_bzu.tno = aVar.tno;
                        com_tencent_mm_protocal_c_bzu.tnp = aVar.tnp;
                        com_tencent_mm_protocal_c_bzu.tnq = aVar.tnq;
                        com_tencent_mm_protocal_c_bzu.seF = aVar.seF;
                        com_tencent_mm_protocal_c_bzu.lOX = aVar.lOX;
                        com_tencent_mm_protocal_c_bzu.lOY = aVar.lOY;
                        com_tencent_mm_protocal_c_bzu.rfu = aVar.rfu;
                        com_tencent_mm_protocal_c_bzu.sez = aVar.sez;
                        com_tencent_mm_protocal_c_bzu.seA = aVar.seA;
                        com_tencent_mm_protocal_c_bzu.seB = aVar.seB;
                        com_tencent_mm_protocal_c_bzu.bhd = aVar.bhd;
                        com_tencent_mm_protocal_c_bzu.pes = aVar.pes;
                        com_tencent_mm_protocal_c_bzu.seG = aVar.seG;
                        bArr = null;
                        try {
                            bArr = com_tencent_mm_protocal_c_bzu.toByteArray();
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.ChattingItemAppMsgTo", e, "", new Object[0]);
                        }
                        if (bArr != null) {
                            e$i.xEq = true;
                            intent.putExtra("key_search_web_data", bArr);
                            intent.putExtra("key_proxy_fts_rec_ui", true);
                            com.tencent.mm.bm.d.b(chattingUI$a.getContext(), "webview", ".fts.topstory.ui.TopStoryVideoListUI", intent);
                            return true;
                        }
                    }
                    if (!(fT.url == null || fT.url.equals(""))) {
                        str2 = p.A(fT.url, chattingUI$a.ysk ? "groupmessage" : "singlemessage");
                        str = fT.hba;
                        PackageInfo packageInfo = getPackageInfo(chattingUI$a.getContext(), fT.appId);
                        intent2 = new Intent();
                        intent2.putExtra("rawUrl", str2);
                        intent2.putExtra("webpageTitle", fT.title);
                        bundle = new Bundle();
                        bundle.putString("key_snsad_statextstr", fT.fGG);
                        if (fT.appId != null && ("wx751a1acca5688ba3".equals(fT.appId) || "wxfbc915ff7c30e335".equals(fT.appId) || "wx482a4001c37e2b74".equals(fT.appId))) {
                            bundle.putString("jsapi_args_appid", fT.appId);
                        }
                        intent2.putExtra("jsapiargs", bundle);
                        if (bh.ov(str)) {
                            intent2.putExtra("shortUrl", fT.url);
                        } else {
                            intent2.putExtra("shortUrl", str);
                        }
                        intent2.putExtra("version_name", packageInfo == null ? null : packageInfo.versionName);
                        intent2.putExtra("version_code", packageInfo == null ? 0 : packageInfo.versionCode);
                        if (!bh.ov(fT.fGz)) {
                            intent2.putExtra("srcUsername", fT.fGz);
                            intent2.putExtra("srcDisplayname", fT.fGA);
                        }
                        intent2.putExtra("msg_id", auVar.field_msgId);
                        intent2.putExtra("KPublisherId", "msg_" + Long.toString(auVar.field_msgSvrId));
                        intent2.putExtra("KAppId", fT.appId);
                        intent2.putExtra("geta8key_username", chattingUI$a.crz());
                        intent2.putExtra("pre_username", a(chattingUI$a, auVar));
                        intent2.putExtra("from_scence", 2);
                        N = t.N(a(chattingUI$a, auVar), chattingUI$a.crz());
                        intent2.putExtra("prePublishId", "msg_" + Long.toString(auVar.field_msgSvrId));
                        intent2.putExtra("preUsername", a(chattingUI$a, auVar));
                        intent2.putExtra("preChatName", chattingUI$a.crz());
                        intent2.putExtra("preChatTYPE", N);
                        intent2.putExtra("preMsgIndex", 0);
                        switch (N) {
                            case 1:
                                N = 3;
                                break;
                            case 2:
                                N = 2;
                                break;
                            case 6:
                            case 7:
                                N = 5;
                                break;
                            default:
                                N = 0;
                                break;
                        }
                        intent2.putExtra("share_report_pre_msg_url", fT.url);
                        intent2.putExtra("share_report_pre_msg_title", fT.title);
                        intent2.putExtra("share_report_pre_msg_desc", fT.description);
                        intent2.putExtra("share_report_pre_msg_icon_url", fT.thumburl);
                        intent2.putExtra("share_report_pre_msg_appid", fT.appId);
                        intent2.putExtra("share_report_from_scene", N);
                        if (N == 5) {
                            intent2.putExtra("share_report_biz_username", chattingUI$a.crz());
                        }
                        com.tencent.mm.bm.d.b(chattingUI$a.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                    }
                    return true;
                }
                intent3 = new Intent();
                intent3.putExtra("sns_landig_pages_from_source", 5);
                intent3.putExtra("msg_id", auVar.field_msgId);
                intent3.putExtra("sns_landing_pages_xml", fT.canvasPageXml);
                intent3.putExtra("sns_landing_pages_share_thumb_url", auVar.field_imgPath);
                intent3.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                com.tencent.mm.bm.d.b(chattingUI$a.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent3);
                return true;
            case 6:
                ar.Hg();
                if (com.tencent.mm.z.c.isSDCardAvailable()) {
                    if (bh.VW(fT.hbc)) {
                        long j = auVar.field_msgId;
                        com.tencent.mm.pluginsdk.model.app.b Rz = an.aqd().Rz(fT.fny);
                        if (Rz == null || !Rz.aOC()) {
                            obj = null;
                        } else {
                            ar.Hg();
                            if (com.tencent.mm.z.c.Fa().dH(j).cjs()) {
                                x.i("MicroMsg.ChattingItemAppMsgTo", "openImg:: msg is clean, attachId %s, msgId: %d, msgSvrId: %d, imgPath: %s", new Object[]{str2, Long.valueOf(j), Long.valueOf(com.tencent.mm.z.c.Fa().dH(j).field_msgSvrId), com.tencent.mm.z.c.Fa().dH(j).field_imgPath});
                                intent3 = new Intent();
                                intent3.setClassName(this.yqa.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
                                intent3.putExtra("clean_view_type", 1);
                                this.yqa.startActivity(intent3);
                                obj = 1;
                            } else {
                                intent3 = new Intent(this.yqa.getContext(), ShowImageUI.class);
                                intent3.putExtra("key_image_path", Rz.field_fileFullPath);
                                intent3.putExtra("key_message_id", j);
                                intent3.putExtra("key_favorite", true);
                                this.yqa.startActivity(intent3);
                                obj = 1;
                            }
                        }
                        if (obj != null) {
                            return true;
                        }
                    }
                    intent3 = new Intent();
                    intent3.setClassName(chattingUI$a.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                    intent3.putExtra("app_msg_id", auVar.field_msgId);
                    chattingUI$a.startActivity(intent3);
                    return true;
                }
                u.fI(chattingUI$a.getContext());
                return true;
            case 7:
                if (aZ != null && aZ.Yz() && a(chattingUI$a, aZ)) {
                    return true;
                }
                chattingUI$a.ywa.aM(auVar);
                return true;
            case 10:
                if (bh.ov(fT.hbx)) {
                    return false;
                }
                intent3 = new Intent();
                intent3.setFlags(65536);
                intent3.putExtra("key_Product_xml", fT.hbx);
                intent3.putExtra("key_ProductUI_getProductInfoScene", 1);
                if (auVar.field_imgPath == null) {
                    intent3.putExtra("key_ProductUI_chatting_msgId", auVar.field_msgId);
                }
                com.tencent.mm.bm.d.b(chattingUI$a.getContext(), "scanner", ".ui.ProductUI", intent3);
                return true;
            case 13:
                if (bh.ov(fT.hbD)) {
                    return false;
                }
                intent3 = new Intent();
                intent3.setFlags(65536);
                intent3.putExtra("key_product_info", fT.hbD);
                intent3.putExtra("key_product_scene", 1);
                com.tencent.mm.bm.d.b(chattingUI$a.getContext(), "product", ".ui.MallProductUI", intent3);
                return true;
            case 16:
                if (bh.ov(fT.fys)) {
                    return false;
                }
                intent3 = new Intent();
                intent3.setFlags(65536);
                intent3.putExtra("key_card_app_msg", fT.fys);
                intent3.putExtra("key_from_scene", fT.hcl);
                com.tencent.mm.bm.d.b(chattingUI$a.getContext(), "card", ".ui.CardDetailUI", intent3);
                return true;
            case 19:
                intent3 = new Intent();
                intent3.putExtra("message_id", auVar.field_msgId);
                intent3.putExtra("record_xml", fT.hbB);
                c.a.a(intent3, chattingUI$a, auVar, this);
                com.tencent.mm.bm.d.b(chattingUI$a.getContext(), "record", ".ui.RecordMsgDetailUI", intent3);
                return true;
            case 20:
                if (bh.ov(fT.hbA)) {
                    return false;
                }
                intent3 = new Intent();
                intent3.setFlags(65536);
                intent3.putExtra("key_TV_xml", fT.hbA);
                intent3.putExtra("key_TV_getProductInfoScene", 1);
                if (auVar.field_imgPath == null) {
                    intent3.putExtra("key_TVInfoUI_chatting_msgId", auVar.field_msgId);
                }
                com.tencent.mm.bm.d.b(chattingUI$a.getContext(), "shake", ".ui.TVInfoUI", intent3);
                return true;
            case 24:
                com.tencent.mm.sdk.b.b lhVar = new lh();
                lhVar.fCF.context = chattingUI$a.getContext();
                lhVar.fCF.fqm = auVar.field_msgId;
                lhVar.fCF.fBV = chattingUI$a.ysk;
                lhVar.fCF.fCG = fT.hbB;
                lhVar.fCF.scene = 6;
                com.tencent.mm.sdk.b.a.xef.m(lhVar);
                return true;
            case 33:
                x.i("MicroMsg.ChattingItemAppMsgTo", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[]{fT.hdx, fT.hdw, fT.hdy, fT.url, Integer.valueOf(fT.hdE), fT.hdA});
                crz = chattingUI$a.crz();
                String a = a(chattingUI$a, auVar);
                bundle2 = new Bundle();
                if (chattingUI$a instanceof AppBrandServiceChattingUI.a) {
                    str = "stat_scene";
                    N = 10;
                    bundle3 = bundle2;
                } else if (chattingUI$a.ysk) {
                    str = "stat_scene";
                    N = 2;
                    bundle3 = bundle2;
                } else {
                    str = "stat_scene";
                    if (s.gF(crz)) {
                        N = 7;
                        bundle3 = bundle2;
                    } else {
                        N = 1;
                        bundle3 = bundle2;
                    }
                }
                bundle3.putInt(str, N);
                bundle2.putString("stat_msg_id", "msg_" + Long.toString(auVar.field_msgSvrId));
                bundle2.putString("stat_chat_talker_username", crz);
                bundle2.putString("stat_send_msg_user", a);
                switch (fT.hdz) {
                    case 1:
                        intent3 = new Intent();
                        intent3.putExtra("key_username", fT.hdx);
                        if (chattingUI$a.ysk) {
                            intent3.putExtra("key_from_scene", 1);
                            intent3.putExtra("key_scene_note", chattingUI$a.crz() + ":" + a);
                        } else {
                            intent3.putExtra("key_from_scene", 2);
                            intent3.putExtra("key_scene_note", crz);
                        }
                        intent3.putExtra("_stat_obj", bundle2);
                        WxaExposedParams$a wxaExposedParams$a = new WxaExposedParams$a();
                        wxaExposedParams$a.appId = fT.hdy;
                        wxaExposedParams$a.fqe = 6;
                        wxaExposedParams$a.iGK = fT.hdE;
                        wxaExposedParams$a.iGL = fT.hdB;
                        intent3.putExtra("key_scene_exposed_params", wxaExposedParams$a.ace());
                        com.tencent.mm.bm.d.b(chattingUI$a.getContext(), "appbrand", ".ui.AppBrandProfileUI", intent3);
                        obj = null;
                        break;
                    case 2:
                        if (!(chattingUI$a instanceof AppBrandServiceChattingUI.a)) {
                            if (!s.gF(crz)) {
                                com.tencent.mm.modelappbrand.a.a(crz, a, chattingUI$a.ysk, fT, bundle2);
                                obj = null;
                                break;
                            }
                            com.tencent.mm.modelappbrand.a.a(crz, 1074, fT, bundle2);
                            obj = null;
                            break;
                        }
                        com.tencent.mm.modelappbrand.a.a(crz, 1073, fT, bundle2);
                        obj = null;
                        break;
                    case 3:
                        com.tencent.mm.modelappbrand.a.b(crz, a, chattingUI$a.ysk, fT, bundle2);
                        obj = null;
                        break;
                    default:
                        obj = 1;
                        break;
                }
                if (obj == null) {
                    return true;
                }
                break;
            case 34:
                intent3 = new Intent();
                intent3.putExtra("key_biz_uin", fT.hcn);
                intent3.putExtra("key_order_id", fT.hco);
                if (!(auVar.field_talker == null || auVar.field_talker.equals("") || !auVar.field_talker.endsWith("@chatroom"))) {
                    intent3.putExtra("key_chatroom_name", auVar.field_talker);
                }
                com.tencent.mm.bm.d.b(chattingUI$a.getContext(), "card", ".ui.CardGiftAcceptUI", intent3);
                return true;
            case 36:
                if (bh.ov(fT.hdy) && bh.ov(fT.hdx)) {
                    str2 = p.A(fT.url, chattingUI$a.ysk ? "groupmessage" : "singlemessage");
                    intent = new Intent();
                    intent.putExtra("rawUrl", str2);
                    intent.putExtra("webpageTitle", fT.title);
                    intent.putExtra("shortUrl", fT.url);
                    com.tencent.mm.bm.d.b(chattingUI$a.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    return true;
                }
                String crz2 = chattingUI$a.crz();
                crz = a(chattingUI$a, auVar);
                bundle2 = new Bundle();
                if (chattingUI$a.ysk) {
                    str = "stat_scene";
                    N = 2;
                    bundle3 = bundle2;
                } else {
                    str = "stat_scene";
                    if (s.gF(crz2)) {
                        N = 7;
                        bundle3 = bundle2;
                    } else {
                        N = 1;
                        bundle3 = bundle2;
                    }
                }
                bundle3.putInt(str, N);
                bundle2.putString("stat_msg_id", "msg_" + Long.toString(auVar.field_msgSvrId));
                bundle2.putString("stat_chat_talker_username", crz2);
                bundle2.putString("stat_send_msg_user", crz);
                ((com.tencent.mm.plugin.appbrand.m.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.m.c.class)).a(chattingUI$a.getContext(), chattingUI$a.crz(), a(chattingUI$a, auVar), chattingUI$a.ysk, fT);
                return true;
        }
        if (bArr != null) {
            e$i.xEq = true;
            intent.putExtra("key_proxy_fts_rec_ui", true);
            intent.putExtra("key_search_web_data", bArr);
            com.tencent.mm.bm.d.b(chattingUI$a.getContext(), "webview", ".fts.topstory.ui.TopStoryVideoListUI", intent);
            return true;
        }
        str2 = p.A(fT.url, chattingUI$a.ysk ? "groupmessage" : "singlemessage");
        str = fT.url;
        packageInfo = getPackageInfo(chattingUI$a.getContext(), fT.appId);
        intent2 = new Intent();
        intent2.putExtra("rawUrl", str2);
        intent2.putExtra("webpageTitle", fT.title);
        if (fT.appId != null && ("wx751a1acca5688ba3".equals(fT.appId) || "wxfbc915ff7c30e335".equals(fT.appId) || "wx482a4001c37e2b74".equals(fT.appId))) {
            bundle = new Bundle();
            bundle.putString("jsapi_args_appid", fT.appId);
            intent2.putExtra("jsapiargs", bundle);
        }
        if (bh.ov(str)) {
            intent2.putExtra("shortUrl", fT.url);
        } else {
            intent2.putExtra("shortUrl", str);
        }
        intent2.putExtra("version_name", packageInfo == null ? null : packageInfo.versionName);
        intent2.putExtra("version_code", packageInfo == null ? 0 : packageInfo.versionCode);
        if (!bh.ov(fT.fGz)) {
            intent2.putExtra("srcUsername", fT.fGz);
            intent2.putExtra("srcDisplayname", fT.fGA);
        }
        intent2.putExtra("msg_id", auVar.field_msgId);
        intent2.putExtra("KPublisherId", "msg_" + Long.toString(auVar.field_msgSvrId));
        intent2.putExtra("KAppId", fT.appId);
        intent2.putExtra("geta8key_username", chattingUI$a.crz());
        intent2.putExtra("pre_username", a(chattingUI$a, auVar));
        intent2.putExtra("from_scence", 2);
        intent2.putExtra("expid_str", auVar.gjO);
        N = t.N(a(chattingUI$a, auVar), chattingUI$a.crz());
        intent2.putExtra("prePublishId", "msg_" + Long.toString(auVar.field_msgSvrId));
        intent2.putExtra("preUsername", a(chattingUI$a, auVar));
        intent2.putExtra("preChatName", chattingUI$a.crz());
        intent2.putExtra("preChatTYPE", N);
        intent2.putExtra("preMsgIndex", 0);
        switch (N) {
            case 1:
                N = 3;
                break;
            case 2:
                N = 2;
                break;
            case 6:
            case 7:
                N = 5;
                break;
            default:
                N = 0;
                break;
        }
        intent2.putExtra("share_report_pre_msg_url", fT.url);
        intent2.putExtra("share_report_pre_msg_title", fT.title);
        intent2.putExtra("share_report_pre_msg_desc", fT.description);
        intent2.putExtra("share_report_pre_msg_icon_url", fT.thumburl);
        intent2.putExtra("share_report_pre_msg_appid", fT.appId);
        intent2.putExtra("share_report_from_scene", N);
        if (N == 5) {
            intent2.putExtra("share_report_biz_username", chattingUI$a.crz());
        }
        com.tencent.mm.bm.d.b(chattingUI$a.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
        return true;
    }
}
