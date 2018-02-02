package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.g.a.lh;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.modelstat.a$a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.jsapi.bp;
import com.tencent.mm.plugin.appbrand.m.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ah;
import com.tencent.mm.ui.chatting.r.h;
import com.tencent.mm.ui.chatting.r.i;
import com.tencent.mm.ui.chatting.r.k;
import com.tencent.mm.y.e;
import com.tencent.mm.y.g;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.s;
import com.tencent.mm.z.t;
import com.tencent.wcdb.FileUtils;

public class c$d extends b {
    private boolean tRV;
    private c yHa;
    protected h yJA;
    protected k yJB;
    protected i yJC;
    private a yqa;

    public final boolean aXj() {
        return false;
    }

    public c$d() {
        c.a aVar = new c.a();
        aVar.hDP = R.k.dvG;
        aVar.bc(com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 20), com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 20)).hDy = true;
        this.yHa = aVar.PK();
    }

    public final boolean aj(int i, boolean z) {
        if ((!z && i == 49) || i == 335544369 || i == 402653233 || i == 369098801) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddj);
        view.setTag(new c.c().p(view, true));
        return view;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(b.a aVar, int i, a aVar2, au auVar, String str) {
        String substring;
        com.tencent.mm.y.k fX;
        g.a aVar3;
        ar arVar;
        Object obj;
        e eVar;
        f cQ;
        String str2;
        boolean z;
        Object obj2;
        boolean z2;
        Object obj3;
        boolean z3;
        Bitmap b;
        ar arVar2;
        Object obj4;
        Bitmap b2;
        FrameLayout frameLayout;
        WxaAttributes qK;
        CharSequence charSequence;
        String str3;
        c.c cVar = (c.c) aVar;
        this.yqa = aVar2;
        cVar.reset();
        String str4 = auVar.field_content;
        aVar2.yvP.aR(auVar);
        aVar2.yvP.aS(auVar);
        aVar2.yvP.aT(auVar);
        if (this.tRV) {
            int indexOf = auVar.field_content.indexOf(58);
            if (indexOf != -1) {
                substring = auVar.field_content.substring(indexOf + 1);
                if (substring == null) {
                    g.a I = g.a.I(substring, auVar.field_reserved);
                    fX = com.tencent.mm.y.k.fX(substring);
                    aVar3 = I;
                } else {
                    x.e("MicroMsg.ChattingItemAppMsgFrom", "amessage, msgid:%s, user:%s", new Object[]{Long.valueOf(auVar.field_msgId), str});
                    fX = null;
                    aVar3 = null;
                }
                arVar = new ar(auVar, aVar2.ypn, i, null, (byte) 0);
                obj = null;
                if (aVar3 != null) {
                    cVar.iiq.setText(aVar3.getTitle());
                    cVar.iir.setText(aVar3.getDescription());
                    cVar.nnC.setMaxLines(1);
                    cVar.iiq.setTextColor(aVar2.getContext().getResources().getColor(R.e.btv));
                    cVar.iir.setTextColor(aVar2.getContext().getResources().getColor(R.e.bsO));
                    cVar.yJf.setBackgroundResource(R.g.bAD);
                    cVar.yJf.setPadding(0, aVar2.getContext().getResources().getDimensionPixelSize(R.f.bvB), 0, 0);
                    cVar.yIL.setVisibility(0);
                    cVar.yJd.setVisibility(0);
                    cVar.iir.setVisibility(0);
                    cVar.yIR.setVisibility(8);
                    cVar.yIU.setVisibility(8);
                    cVar.yIT.setVisibility(8);
                    cVar.yJh.setVisibility(8);
                    cVar.yJi.setVisibility(8);
                    cVar.yIN.setVisibility(8);
                    cVar.yIO.setVisibility(8);
                    cVar.yJs.setVisibility(8);
                    cVar.yJl.setVisibility(8);
                    cVar.yJf.setVisibility(0);
                    c.c.O(cVar.yJe, cVar.yJw);
                    eVar = (e) aVar3.r(e.class);
                    if (cVar.yIX.m(eVar != null ? null : eVar.haX, auVar.field_talker)) {
                        cVar.yJe.setBackgroundResource(R.g.bAS);
                    } else {
                        cVar.yJe.setBackgroundResource(R.g.bAW);
                    }
                    cQ = com.tencent.mm.pluginsdk.model.app.g.cQ(aVar3.appId, aVar3.fIm);
                    if (cQ != null && cQ.Yz()) {
                        b(aVar2, aVar3, auVar);
                    }
                    if (cQ != null || cQ.field_appName == null || cQ.field_appName.trim().length() <= 0) {
                        str2 = aVar3.appName;
                    } else {
                        str2 = cQ.field_appName;
                    }
                    z = true;
                    com.tencent.mm.bv.a.fromDPToPix(aVar2.getContext(), 12);
                    if (aVar3.type == 20 || "wxaf060266bfa9a35c".equals(aVar3.appId)) {
                        z = q.a.bXY().brA();
                    }
                    if (!z && aVar3.appId != null && aVar3.appId.length() > 0 && com.tencent.mm.pluginsdk.model.app.g.cz(str2)) {
                        cVar.mxT.setText(com.tencent.mm.pluginsdk.model.app.g.a(aVar2.getContext(), cQ, str2));
                        cVar.mxT.setVisibility(0);
                        cVar.mxT.setCompoundDrawables(null, null, null, null);
                        cVar.yIP.setVisibility(0);
                        cVar.yIM.setVisibility(0);
                        if (cQ == null || !cQ.Yz()) {
                            a(aVar2, cVar.mxT, aVar3.appId);
                        } else {
                            a(aVar2, cVar.mxT, auVar, aVar3, cQ.field_packageName, auVar.field_msgSvrId);
                        }
                        a(aVar2, cVar.yIM, aVar3.appId);
                    } else if (aVar3.type != 24) {
                        cVar.mxT.setText(ac.getContext().getString(R.l.eeE));
                        cVar.yIP.setVisibility(0);
                        cVar.mxT.setVisibility(0);
                        cVar.yIM.setVisibility(8);
                    } else if (aVar3.type != 19 || fX.hea == 19) {
                        cVar.mxT.setText(ac.getContext().getString(R.l.dRw));
                        cVar.yIP.setVisibility(0);
                        cVar.mxT.setVisibility(0);
                        cVar.yIM.setVisibility(8);
                    } else if (!c.a(aVar3, cVar)) {
                        cVar.yIP.setVisibility(8);
                        cVar.mxT.setVisibility(8);
                        cVar.yIM.setVisibility(8);
                    }
                    obj2 = (aVar3.haY != null || aVar3.haY.hdS == 0) ? null : 1;
                    if (obj2 != null) {
                        cVar.yIP.setVisibility(8);
                    }
                    z2 = false;
                    cVar.yIL.setVisibility(0);
                    obj3 = (aVar3.haY == null && aVar3.haY.hdP == 1) ? 1 : null;
                    if (obj3 == null || !this.vzn) {
                        cVar.yIL.setImageBitmap(BitmapFactory.decodeResource(aVar2.getResources(), R.g.bEh));
                        z3 = false;
                    } else {
                        Bitmap bitmap = null;
                        if (!(aVar3.type == 33 || aVar3.type == 36)) {
                            bitmap = o.Pw().a(auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(aVar2.getContext()), false);
                        }
                        if (bitmap == null || bitmap.isRecycled()) {
                            z2 = true;
                        } else {
                            cVar.yIL.setImageBitmap(bitmap);
                        }
                        if (aVar3.type == 3) {
                            final c.c cVar2 = cVar;
                            final a aVar4 = aVar2;
                            cVar.yJf.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                                private boolean yJD = false;
                                final /* synthetic */ c$d yJF;

                                public final boolean onPreDraw() {
                                    if (this.yJD) {
                                        cVar2.yJf.getViewTreeObserver().removeOnPreDrawListener(this);
                                    } else {
                                        cVar2.yJf.getViewTreeObserver().removeOnPreDrawListener(this);
                                        this.yJD = true;
                                        int fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(aVar4.getContext(), 24);
                                        Bitmap bitmap = bitmap;
                                        if (bitmap == null || bitmap.isRecycled()) {
                                            bitmap = d.ag(aVar4.getContext().getResources().getColor(R.e.brQ), fromDPToPix, fromDPToPix);
                                        }
                                        int height = bitmap.getHeight();
                                        if (fromDPToPix <= height) {
                                            height = fromDPToPix;
                                        }
                                        Bitmap c = d.c(d.T(Bitmap.createScaledBitmap(bitmap, height, height, true)), 20);
                                        height = cVar2.yJf.getHeight();
                                        int width = cVar2.yJf.getWidth();
                                        if (height == 0) {
                                            height = com.tencent.mm.bv.a.aa(aVar4.getContext(), R.f.bwS);
                                        }
                                        if (width == 0) {
                                            width = com.tencent.mm.bv.a.aa(aVar4.getContext(), R.f.bwT);
                                        }
                                        cVar2.yJf.setBackgroundDrawable(new BitmapDrawable(d.a(c, R.g.bAD, width, height)));
                                    }
                                    return true;
                                }
                            });
                        }
                        z3 = z2;
                    }
                    if (aVar3.gjD != null || aVar3.gjD.length() == 0) {
                        cVar.yIW.setVisibility(8);
                    } else {
                        cVar.yIW.setVisibility(0);
                        b(aVar2, cVar.yIW, ar.Zx(aVar3.gjD));
                    }
                    cVar.yIV.setOnClickListener(null);
                    cVar.yIZ.setVisibility(0);
                    cVar.yIQ.setVisibility(8);
                    cVar.yJc.setVisibility(0);
                    cVar.yJa.setVisibility(8);
                    switch (aVar3.type) {
                        case 0:
                            if (aVar3.title != null || aVar3.title.length() <= 0) {
                                cVar.iiq.setVisibility(8);
                            } else {
                                cVar.iiq.setVisibility(0);
                            }
                            cVar.iir.setVisibility(0);
                            cVar.nnC.setVisibility(8);
                            cVar.yIV.setVisibility(8);
                            cVar.yIQ.setVisibility(4);
                            cVar.iir.setMaxLines(2);
                            if (z3) {
                                b = com.tencent.mm.pluginsdk.model.app.g.b(aVar3.appId, 1, com.tencent.mm.bv.a.getDensity(aVar2.getContext()));
                                if (b == null && !b.isRecycled()) {
                                    cVar.yIL.setImageBitmap(b);
                                    arVar2 = arVar;
                                    obj4 = null;
                                    break;
                                }
                                cVar.yIL.setImageResource(R.k.dvD);
                                arVar2 = arVar;
                                obj4 = null;
                                break;
                            }
                            break;
                        case 3:
                            if (aVar3.title != null || aVar3.title.length() <= 0) {
                                cVar.iiq.setVisibility(8);
                            } else {
                                cVar.iiq.setVisibility(0);
                                cVar.iiq.setTextColor(aVar2.getContext().getResources().getColor(R.e.white));
                            }
                            cVar.iir.setVisibility(0);
                            cVar.iir.setTextColor(aVar2.getContext().getResources().getColor(R.e.white));
                            cVar.nnC.setVisibility(8);
                            cVar.yIQ.setVisibility(4);
                            cVar.yIV.setVisibility(0);
                            if ((auVar.field_msgId).equals(aVar.yIA)) {
                                cVar.yIV.setImageResource(R.g.bDS);
                            } else {
                                cVar.yIV.setImageResource(R.g.bDR);
                            }
                            cVar.iir.setMaxLines(2);
                            if (z3) {
                                b = com.tencent.mm.pluginsdk.model.app.g.b(aVar3.appId, 1, com.tencent.mm.bv.a.getDensity(aVar2.getContext()));
                                if (b != null || b.isRecycled()) {
                                    cVar.yIL.setImageResource(R.k.dvn);
                                } else {
                                    cVar.yIL.setImageBitmap(b);
                                }
                            }
                            c$f com_tencent_mm_ui_chatting_viewitems_c_f = new c$f();
                            com_tencent_mm_ui_chatting_viewitems_c_f.fqm = auVar.field_msgId;
                            com_tencent_mm_ui_chatting_viewitems_c_f.fCs = auVar.field_content;
                            com_tencent_mm_ui_chatting_viewitems_c_f.fzs = auVar.field_imgPath;
                            cVar.yIV.setTag(com_tencent_mm_ui_chatting_viewitems_c_f);
                            cVar.yIV.setOnClickListener(aVar2.ysf.yta);
                            arVar2 = arVar;
                            obj4 = null;
                            break;
                        case 4:
                            if (aVar3.title != null || aVar3.title.length() <= 0) {
                                cVar.iiq.setVisibility(8);
                            } else {
                                cVar.iiq.setVisibility(0);
                            }
                            cVar.iir.setVisibility(0);
                            cVar.nnC.setVisibility(8);
                            cVar.yIV.setVisibility(0);
                            cVar.yIV.setImageResource(R.g.bHf);
                            cVar.yIQ.setVisibility(4);
                            cVar.iir.setMaxLines(2);
                            if (z3) {
                                b = com.tencent.mm.pluginsdk.model.app.g.b(aVar3.appId, 1, com.tencent.mm.bv.a.getDensity(aVar2.getContext()));
                                if (b != null || b.isRecycled()) {
                                    cVar.yIL.setImageResource(R.k.dvA);
                                } else {
                                    cVar.yIL.setImageBitmap(b);
                                }
                                cVar.yIV.setVisibility(8);
                                arVar2 = arVar;
                                obj4 = null;
                                break;
                            }
                            break;
                        case 5:
                            cVar.iiq.setVisibility(8);
                            if (aVar3.title != null || aVar3.title.length() <= 0) {
                                cVar.nnC.setVisibility(8);
                            } else {
                                cVar.nnC.setMaxLines(2);
                                cVar.nnC.setVisibility(0);
                                cVar.nnC.setText(aVar3.getTitle());
                            }
                            cVar.iir.setMaxLines(3);
                            if (c.i(aVar3)) {
                                cVar.yIV.setVisibility(8);
                            } else {
                                cVar.yIV.setVisibility(0);
                                cVar.yIV.setImageResource(R.g.bHf);
                            }
                            cVar.yIQ.setVisibility(4);
                            if (z3) {
                                b = com.tencent.mm.pluginsdk.model.app.g.b(aVar3.appId, 1, com.tencent.mm.bv.a.getDensity(aVar2.getContext()));
                                if (b == null && !b.isRecycled()) {
                                    cVar.yIL.setImageBitmap(b);
                                    arVar2 = arVar;
                                    obj4 = null;
                                    break;
                                }
                                c.a aVar5 = new c.a();
                                aVar5.hDP = R.k.dvD;
                                aVar5.bc(com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 50), com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 50)).hDy = true;
                                o.PA().a(aVar3.thumburl, cVar.yIL, aVar5.PK());
                                arVar2 = arVar;
                                obj4 = null;
                                break;
                            }
                            break;
                        case 6:
                            if (aVar3.title != null || aVar3.title.length() <= 0) {
                                cVar.iiq.setVisibility(8);
                            } else {
                                cVar.iiq.setVisibility(0);
                                cVar.iiq.setMaxLines(2);
                            }
                            cVar.iir.setVisibility(0);
                            cVar.nnC.setVisibility(8);
                            cVar.yIV.setVisibility(8);
                            cVar.yIQ.setVisibility(4);
                            cVar.iir.setMaxLines(2);
                            cVar.iir.setText(bh.bx((long) aVar3.hbb));
                            c.c.a(cVar, substring, aVar3.hbb);
                            c.c.a(cVar, Boolean.valueOf(true), auVar, aVar3.fny, aVar3.title);
                            if (z3) {
                                if (!bh.VW(aVar3.hbc)) {
                                    cVar.yIL.setImageResource(R.g.byY);
                                    arVar2 = arVar;
                                    obj4 = null;
                                    break;
                                }
                                cVar.yIL.setImageResource(r.Ry(aVar3.hbc));
                                arVar2 = arVar;
                                obj4 = null;
                                break;
                            }
                            break;
                        case 7:
                            cVar.iiq.setVisibility(8);
                            if (aVar3.title != null || aVar3.title.trim().length() <= 0) {
                                cVar.nnC.setVisibility(8);
                            } else {
                                cVar.nnC.setVisibility(0);
                                cVar.nnC.setText(aVar3.getTitle());
                            }
                            cVar.iir.setMaxLines(3);
                            cVar.yIV.setVisibility(8);
                            cVar.yIQ.setVisibility(0);
                            if (z3) {
                                b = com.tencent.mm.pluginsdk.model.app.g.b(aVar3.appId, 1, com.tencent.mm.bv.a.getDensity(aVar2.getContext()));
                                if (b == null && !b.isRecycled()) {
                                    cVar.yIL.setImageBitmap(b);
                                    arVar2 = arVar;
                                    obj4 = null;
                                    break;
                                }
                                cVar.yIL.setImageResource(R.k.dvD);
                                arVar2 = arVar;
                                obj4 = null;
                                break;
                            }
                            break;
                        case 10:
                            cVar.nnC.setVisibility(0);
                            if (aVar3.hbw == 1) {
                                cVar.nnC.setText(R.l.eHU);
                            } else if (aVar3.hbw == 2) {
                                cVar.nnC.setText(R.l.eHW);
                            } else if (aVar3.hbw != 3) {
                                cVar.nnC.setText(R.l.eHV);
                            } else {
                                cVar.nnC.setText(R.l.eHX);
                            }
                            if (aVar3.title != null && aVar3.title.length() > 0) {
                                cVar.iiq.setVisibility(0);
                                cVar.iiq.setText(aVar3.getTitle());
                            }
                            cVar.iir.setMaxLines(4);
                            cVar.yIQ.setVisibility(4);
                            cVar.yIV.setVisibility(8);
                            if (z3) {
                                b = o.Pw().b(auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(aVar2.getContext()), false);
                                if (b == null && !b.isRecycled()) {
                                    cVar.yIL.setImageBitmap(b);
                                    arVar2 = arVar;
                                    obj4 = null;
                                    break;
                                }
                                cVar.yIL.setImageResource(R.k.dvD);
                                arVar2 = arVar;
                                obj4 = null;
                                break;
                            }
                            break;
                        case 13:
                            cVar.iiq.setVisibility(0);
                            cVar.iiq.setText(aVar3.getTitle());
                            cVar.nnC.setVisibility(0);
                            cVar.nnC.setText(R.l.dSc);
                            cVar.iir.setMaxLines(4);
                            cVar.yIQ.setVisibility(4);
                            cVar.yIV.setVisibility(8);
                            if (z3) {
                                b = o.Pw().b(auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(aVar2.getContext()), false);
                                if (b == null && !b.isRecycled()) {
                                    cVar.yIL.setImageBitmap(b);
                                    arVar2 = arVar;
                                    obj4 = null;
                                    break;
                                }
                                cVar.yIL.setImageResource(R.k.dvD);
                                arVar2 = arVar;
                                obj4 = null;
                                break;
                            }
                            break;
                        case 15:
                            if (aVar3.title != null || aVar3.title.length() <= 0) {
                                cVar.iiq.setVisibility(8);
                            } else {
                                cVar.iiq.setVisibility(0);
                            }
                            cVar.iir.setVisibility(0);
                            cVar.nnC.setVisibility(8);
                            cVar.yIV.setVisibility(8);
                            cVar.yIQ.setVisibility(4);
                            cVar.iir.setMaxLines(2);
                            if (z3) {
                                b2 = o.Pw().b(auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(aVar2.getContext()), false);
                                if (b2 != null || b2.isRecycled()) {
                                    cVar.yIL.setImageResource(R.k.dvD);
                                } else {
                                    cVar.yIL.setImageBitmap(b2);
                                }
                            }
                            arVar = new ar(auVar, false, i, "", false, aVar3.title, aVar3.fGz, aVar3.fGA, aVar3.title, aVar3.hbE, aVar3.url, false, false);
                            cVar.yJe.setTag(arVar);
                            cVar.yJe.setOnClickListener(x(aVar2));
                            obj = 1;
                            arVar2 = arVar;
                            obj4 = null;
                            break;
                        case 16:
                            cVar.iiq.setVisibility(0);
                            cVar.iiq.setText(aVar3.description);
                            cVar.iir.setText(aVar3.hck);
                            if (aVar3.title != null || aVar3.title.length() <= 0) {
                                cVar.nnC.setVisibility(8);
                            } else {
                                cVar.nnC.setVisibility(0);
                                cVar.nnC.setText(aVar3.title);
                            }
                            cVar.iir.setMaxLines(4);
                            cVar.yIQ.setVisibility(4);
                            cVar.yIV.setVisibility(8);
                            if (z3) {
                                b = o.Pw().b(auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(aVar2.getContext()), false);
                                if (b == null) {
                                    cVar.yIL.setImageResource(R.k.dvD);
                                    arVar2 = arVar;
                                    obj4 = null;
                                    break;
                                }
                                cVar.yIL.setImageBitmap(b);
                                arVar2 = arVar;
                                obj4 = null;
                                break;
                            }
                            break;
                        case 19:
                            c.c.a(aVar2, cVar, aVar3, z3);
                            arVar2 = arVar;
                            obj4 = null;
                            break;
                        case 20:
                            if (aVar3.title != null && aVar3.title.length() > 0) {
                                cVar.iiq.setVisibility(0);
                                cVar.iiq.setText(aVar3.getTitle());
                                cVar.nnC.setVisibility(8);
                            }
                            cVar.iir.setMaxLines(4);
                            cVar.yIQ.setVisibility(4);
                            cVar.yIV.setVisibility(8);
                            if (z3) {
                                b = o.Pw().b(auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(aVar2.getContext()), false);
                                if (b == null && !b.isRecycled()) {
                                    cVar.yIL.setImageBitmap(b);
                                    arVar2 = arVar;
                                    obj4 = null;
                                    break;
                                }
                                cVar.yIL.setImageResource(R.k.dvD);
                                arVar2 = arVar;
                                obj4 = null;
                                break;
                            }
                            break;
                        case 24:
                            cVar.iiq.setVisibility(8);
                            cVar.nnC.setVisibility(0);
                            if (aVar3.title != null || aVar3.title.trim().length() <= 0) {
                                cVar.nnC.setText(com.tencent.mm.pluginsdk.ui.d.i.b(cVar.nnC.getContext(), ac.getContext().getString(R.l.egW), cVar.nnC.getTextSize()));
                            } else {
                                cVar.nnC.setText(com.tencent.mm.pluginsdk.ui.d.i.b(cVar.nnC.getContext(), aVar3.title, cVar.nnC.getTextSize()));
                            }
                            cVar.iir.setMaxLines(3);
                            cVar.yIV.setVisibility(8);
                            cVar.yIQ.setVisibility(4);
                            if (z3) {
                                cVar.yIL.setVisibility(8);
                                cVar.yJd.setVisibility(8);
                            }
                            c.c.a(aVar2, cVar, aVar3, auVar, z3);
                            arVar2 = arVar;
                            obj4 = null;
                            break;
                        case 25:
                            if (aVar3.title != null || aVar3.title.length() <= 0) {
                                cVar.iiq.setVisibility(8);
                            } else {
                                cVar.iiq.setVisibility(0);
                            }
                            cVar.iir.setVisibility(0);
                            cVar.nnC.setVisibility(8);
                            cVar.yIV.setVisibility(8);
                            cVar.yIQ.setVisibility(4);
                            cVar.iir.setMaxLines(2);
                            if (z3) {
                                b2 = o.Pw().b(auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(aVar2.getContext()), false);
                                if (b2 != null || b2.isRecycled()) {
                                    cVar.yIL.setImageResource(R.k.dvD);
                                } else {
                                    cVar.yIL.setImageBitmap(b2);
                                }
                            }
                            arVar = new ar(auVar, i, "", aVar2.csX(), aVar3.fGz, aVar3.fGA, aVar3.title, aVar3.hdl, aVar3.designerName, aVar3.designerRediretctUrl, aVar3.url);
                            cVar.yJe.setTag(arVar);
                            FrameLayout frameLayout2 = cVar.yJe;
                            if (this.yJA == null) {
                                this.yJA = new h(aVar2);
                            }
                            frameLayout2.setOnClickListener(this.yJA);
                            obj = 1;
                            arVar2 = arVar;
                            obj4 = null;
                            break;
                        case 26:
                        case 27:
                            if (aVar3.title != null || aVar3.title.length() <= 0) {
                                cVar.iiq.setVisibility(8);
                            } else {
                                cVar.iiq.setVisibility(0);
                            }
                            cVar.iir.setVisibility(0);
                            cVar.nnC.setVisibility(8);
                            cVar.yIV.setVisibility(8);
                            cVar.yIQ.setVisibility(4);
                            cVar.iir.setMaxLines(2);
                            if (z3) {
                                b2 = o.Pw().b(auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(aVar2.getContext()), false);
                                if (b2 != null || b2.isRecycled()) {
                                    cVar.yIL.setImageResource(R.k.dvD);
                                } else {
                                    cVar.yIL.setImageBitmap(b2);
                                }
                            }
                            arVar2 = new ar();
                            arVar2.fEJ = auVar;
                            arVar2.ypn = false;
                            arVar2.position = i;
                            arVar2.yOD = false;
                            arVar2.title = aVar2.csX();
                            arVar2.fGz = aVar3.fGz;
                            arVar2.fGA = aVar3.fGA;
                            arVar2.yOE = aVar3.title;
                            if (aVar3.type == 26) {
                                arVar2.tid = aVar3.tid;
                                arVar2.hdm = aVar3.hdm;
                                arVar2.desc = aVar3.desc;
                                arVar2.iconUrl = aVar3.iconUrl;
                                arVar2.secondUrl = aVar3.secondUrl;
                                arVar2.pageType = aVar3.pageType;
                                frameLayout = cVar.yJe;
                                if (this.yJB == null) {
                                    this.yJB = new k(aVar2);
                                }
                                frameLayout.setOnClickListener(this.yJB);
                                obj4 = 1;
                            } else if (aVar3.type != 27) {
                                arVar2.tid = aVar3.tid;
                                arVar2.hdm = aVar3.hdm;
                                arVar2.desc = aVar3.desc;
                                arVar2.iconUrl = aVar3.iconUrl;
                                arVar2.secondUrl = aVar3.secondUrl;
                                arVar2.pageType = aVar3.pageType;
                                frameLayout = cVar.yJe;
                                if (this.yJC == null) {
                                    this.yJC = new i(aVar2);
                                }
                                frameLayout.setOnClickListener(this.yJC);
                                obj4 = 1;
                            } else {
                                obj4 = null;
                            }
                            cVar.yJe.setTag(arVar2);
                            obj = obj4;
                            obj4 = null;
                            break;
                        case 33:
                            qK = ((b) com.tencent.mm.kernel.g.h(b.class)).qK(aVar3.hdx);
                            switch (aVar3.hdz) {
                                case 1:
                                    if (qK == null) {
                                        charSequence = qK.field_nickname;
                                    } else {
                                        obj3 = aVar3.title;
                                    }
                                    str2 = qK == null ? qK.field_brandIconURL : null;
                                    cVar.yJf.setVisibility(8);
                                    cVar.yJs.setVisibility(8);
                                    cVar.yJl.setVisibility(0);
                                    cVar.yJn.setText(charSequence);
                                    if (!bh.ov(str2)) {
                                        com.tencent.mm.modelappbrand.a.b.Jj().a(cVar.yJm, "file://" + o.Pw().ln(auVar.field_imgPath), com.tencent.mm.modelappbrand.a.a.Ji(), com.tencent.mm.modelappbrand.a.f.hkr);
                                        arVar2 = arVar;
                                        obj4 = null;
                                        break;
                                    }
                                    com.tencent.mm.modelappbrand.a.b.Jj().a(cVar.yJm, str2, com.tencent.mm.modelappbrand.a.a.Ji(), com.tencent.mm.modelappbrand.a.f.hkr);
                                    arVar2 = arVar;
                                    obj4 = null;
                                    break;
                                case 2:
                                case 3:
                                    if (qK == null) {
                                        charSequence = qK.field_nickname;
                                    } else {
                                        obj3 = aVar3.fGA;
                                    }
                                    if (qK == null) {
                                        str2 = qK.field_brandIconURL;
                                    } else {
                                        str2 = aVar3.hdG;
                                    }
                                    cVar.yJf.setVisibility(8);
                                    cVar.yJs.setVisibility(0);
                                    cVar.yJl.setVisibility(8);
                                    cVar.yJo.setVisibility(8);
                                    cVar.yJv.setText(aVar3.title);
                                    cVar.yJo.setText(aVar3.description);
                                    cVar.yJq.setText(charSequence);
                                    switch (aVar3.hdE) {
                                        case 1:
                                            cVar.yJr.setText(R.l.dEl);
                                            break;
                                        case 2:
                                            cVar.yJr.setText(R.l.dEk);
                                            break;
                                        default:
                                            cVar.yJr.setText(R.l.dDT);
                                            break;
                                    }
                                    o.PA().a(str2, cVar.yJp, this.yHa);
                                    str2 = o.Pw().ln(auVar.field_imgPath);
                                    cVar.yJt.setImageBitmap(null);
                                    cVar.yJt.setVisibility(4);
                                    cVar.yJu.setVisibility(0);
                                    com.tencent.mm.modelappbrand.a.b.Jj().a(new 2(this, cVar), "file://" + str2, null, ((com.tencent.mm.modelappbrand.g) com.tencent.mm.kernel.g.h(com.tencent.mm.modelappbrand.g.class)).aZ(bp.CTRL_INDEX, 172));
                                    arVar2 = arVar;
                                    obj4 = null;
                                    break;
                                default:
                                    arVar2 = arVar;
                                    int i2 = 1;
                                    break;
                            }
                        case 34:
                            if (aVar3.title != null || aVar3.title.length() <= 0) {
                                cVar.iiq.setVisibility(8);
                            } else {
                                cVar.iiq.setVisibility(0);
                                if (bh.ov(aVar3.hct)) {
                                    cVar.iiq.setTextColor(aVar2.getContext().getResources().getColor(R.e.black));
                                } else {
                                    cVar.iiq.setTextColor(bh.ba(aVar3.hct, aVar2.getContext().getResources().getColor(R.e.black)));
                                }
                            }
                            cVar.iir.setMaxLines(2);
                            cVar.iir.setVisibility(0);
                            if (bh.ov(aVar3.hcu)) {
                                cVar.iir.setTextColor(bh.ba(aVar3.hcu, aVar2.getContext().getResources().getColor(R.e.bsF)));
                            } else {
                                cVar.iir.setTextColor(aVar2.getContext().getResources().getColor(R.e.bsF));
                            }
                            cVar.nnC.setVisibility(8);
                            cVar.yIQ.setVisibility(4);
                            cVar.yIV.setVisibility(8);
                            cVar.yIP.setVisibility(0);
                            cVar.mxT.setVisibility(0);
                            if (bh.ov(aVar3.hcp)) {
                                cVar.mxT.setText(aVar3.hcp);
                            } else {
                                cVar.mxT.setText(R.l.dRv);
                            }
                            if (!this.vzn) {
                                b = o.Pw().a(auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(aVar2.getContext()), false);
                                if (!(b == null || b.isRecycled())) {
                                    cVar.yIL.setImageBitmap(d.a(b, false, (float) (b.getWidth() / 2)));
                                }
                                if (bh.ov(aVar3.hcs)) {
                                    cVar.yJf.getViewTreeObserver().addOnPreDrawListener(new 4(this, cVar, aVar2, b));
                                    arVar2 = arVar;
                                    obj4 = null;
                                    break;
                                }
                                com.tencent.mm.aq.a.a PA = o.PA();
                                str3 = aVar3.hcs;
                                ImageView imageView = new ImageView(aVar2.getContext());
                                c.a aVar6 = new c.a();
                                aVar6.hDA = true;
                                PA.a(str3, imageView, aVar6.PK(), new 3(this, cVar, aVar2));
                                arVar2 = arVar;
                                obj4 = null;
                                break;
                            }
                            cVar.yIL.setImageBitmap(BitmapFactory.decodeResource(aVar2.getResources(), R.g.bEh));
                            arVar2 = arVar;
                            obj4 = null;
                            break;
                            break;
                        case 36:
                            qK = ((b) com.tencent.mm.kernel.g.h(b.class)).qK(aVar3.hdx);
                            if (qK == null) {
                                charSequence = qK.field_nickname;
                            } else {
                                obj3 = aVar3.fGA;
                            }
                            if (qK == null) {
                                str2 = qK.field_brandIconURL;
                            } else {
                                str2 = aVar3.hdG;
                            }
                            cVar.yJf.setVisibility(8);
                            cVar.yJs.setVisibility(0);
                            cVar.yJl.setVisibility(8);
                            cVar.yJo.setVisibility(8);
                            cVar.yJv.setText(aVar3.title);
                            cVar.yJo.setText(aVar3.description);
                            cVar.yJq.setText(charSequence);
                            switch (aVar3.hdE) {
                                case 1:
                                    cVar.yJr.setText(R.l.dEl);
                                    break;
                                case 2:
                                    cVar.yJr.setText(R.l.dEk);
                                    break;
                                default:
                                    cVar.yJr.setText(R.l.dDT);
                                    break;
                            }
                            o.PA().a(str2, cVar.yJp, this.yHa);
                            String ln = o.Pw().ln(auVar.field_imgPath);
                            cVar.yJt.setImageBitmap(null);
                            com.tencent.mm.modelappbrand.a.b.Jj().a(cVar.yJt, "file://" + ln, null, null, ((com.tencent.mm.modelappbrand.g) com.tencent.mm.kernel.g.h(com.tencent.mm.modelappbrand.g.class)).aZ(bp.CTRL_INDEX, 172));
                            arVar2 = arVar;
                            obj4 = null;
                            break;
                        case 40:
                            if (fX.hea == 19) {
                                c.c.a(aVar2, cVar, aVar3, z3);
                                arVar2 = arVar;
                                obj4 = null;
                                break;
                            }
                        default:
                            arVar2 = arVar;
                            obj4 = 1;
                            break;
                    }
                    if (obj4 != null) {
                        if (aVar3.title != null || aVar3.title.length() <= 0) {
                            cVar.nnC.setVisibility(8);
                        } else {
                            cVar.nnC.setVisibility(0);
                            cVar.nnC.setMaxLines(2);
                            cVar.nnC.setText(aVar3.title);
                        }
                        cVar.iiq.setVisibility(8);
                        if (z3) {
                            if (aVar3.type != 33 || aVar3.type == 36) {
                                str3 = o.Pw().ln(auVar.field_imgPath);
                                cVar.yIL.setImageResource(R.k.dvD);
                                com.tencent.mm.modelappbrand.a.b.Jj().a(cVar.yIL, "file://" + str3, null, null, ((com.tencent.mm.modelappbrand.g) com.tencent.mm.kernel.g.h(com.tencent.mm.modelappbrand.g.class)).aZ(50, 50));
                            } else {
                                b2 = o.Pw().b(auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(aVar2.getContext()), false);
                                if (b2 == null || b2.isRecycled()) {
                                    b2 = o.Pw().a(auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(aVar2.getContext()), false);
                                }
                                if (b2 == null || b2.isRecycled()) {
                                    cVar.yIL.setImageResource(R.g.byY);
                                } else {
                                    cVar.yIL.setImageBitmap(b2);
                                }
                            }
                        }
                    }
                    if (!aVar2.ypn) {
                        cVar.yIY.setVisibility(8);
                        arVar = arVar2;
                    } else if (com.tencent.mm.pluginsdk.model.app.g.g(cQ)) {
                        cVar.yIY.setVisibility(8);
                        arVar = arVar2;
                    } else {
                        cVar.yIY.setVisibility(0);
                        c(aVar2, cVar.yIY, ar.a(aVar3, auVar));
                        obj4 = arVar2;
                    }
                }
                if (obj == null) {
                    cVar.yJe.setTag(obj4);
                    cVar.yJe.setOnClickListener(t(aVar2));
                }
                if (this.vzn) {
                    cVar.yJe.setOnLongClickListener(s(aVar2));
                    cVar.yJe.setOnTouchListener(aVar2.ysf.ysV);
                }
            }
        }
        substring = str4;
        if (substring == null) {
            x.e("MicroMsg.ChattingItemAppMsgFrom", "amessage, msgid:%s, user:%s", new Object[]{Long.valueOf(auVar.field_msgId), str});
            fX = null;
            aVar3 = null;
        } else {
            g.a I2 = g.a.I(substring, auVar.field_reserved);
            fX = com.tencent.mm.y.k.fX(substring);
            aVar3 = I2;
        }
        arVar = new ar(auVar, aVar2.ypn, i, null, (byte) 0);
        obj = null;
        if (aVar3 != null) {
            cVar.iiq.setText(aVar3.getTitle());
            cVar.iir.setText(aVar3.getDescription());
            cVar.nnC.setMaxLines(1);
            cVar.iiq.setTextColor(aVar2.getContext().getResources().getColor(R.e.btv));
            cVar.iir.setTextColor(aVar2.getContext().getResources().getColor(R.e.bsO));
            cVar.yJf.setBackgroundResource(R.g.bAD);
            cVar.yJf.setPadding(0, aVar2.getContext().getResources().getDimensionPixelSize(R.f.bvB), 0, 0);
            cVar.yIL.setVisibility(0);
            cVar.yJd.setVisibility(0);
            cVar.iir.setVisibility(0);
            cVar.yIR.setVisibility(8);
            cVar.yIU.setVisibility(8);
            cVar.yIT.setVisibility(8);
            cVar.yJh.setVisibility(8);
            cVar.yJi.setVisibility(8);
            cVar.yIN.setVisibility(8);
            cVar.yIO.setVisibility(8);
            cVar.yJs.setVisibility(8);
            cVar.yJl.setVisibility(8);
            cVar.yJf.setVisibility(0);
            c.c.O(cVar.yJe, cVar.yJw);
            eVar = (e) aVar3.r(e.class);
            if (eVar != null) {
            }
            if (cVar.yIX.m(eVar != null ? null : eVar.haX, auVar.field_talker)) {
                cVar.yJe.setBackgroundResource(R.g.bAS);
            } else {
                cVar.yJe.setBackgroundResource(R.g.bAW);
            }
            cQ = com.tencent.mm.pluginsdk.model.app.g.cQ(aVar3.appId, aVar3.fIm);
            b(aVar2, aVar3, auVar);
            if (cQ != null) {
            }
            str2 = aVar3.appName;
            z = true;
            com.tencent.mm.bv.a.fromDPToPix(aVar2.getContext(), 12);
            z = q.a.bXY().brA();
            if (!z) {
            }
            if (aVar3.type != 24) {
                if (aVar3.type != 19) {
                }
                cVar.mxT.setText(ac.getContext().getString(R.l.dRw));
                cVar.yIP.setVisibility(0);
                cVar.mxT.setVisibility(0);
                cVar.yIM.setVisibility(8);
            } else {
                cVar.mxT.setText(ac.getContext().getString(R.l.eeE));
                cVar.yIP.setVisibility(0);
                cVar.mxT.setVisibility(0);
                cVar.yIM.setVisibility(8);
            }
            if (aVar3.haY != null) {
            }
            if (obj2 != null) {
                cVar.yIP.setVisibility(8);
            }
            z2 = false;
            cVar.yIL.setVisibility(0);
            if (aVar3.haY == null) {
            }
            if (obj3 == null) {
            }
            cVar.yIL.setImageBitmap(BitmapFactory.decodeResource(aVar2.getResources(), R.g.bEh));
            z3 = false;
            if (aVar3.gjD != null) {
            }
            cVar.yIW.setVisibility(8);
            cVar.yIV.setOnClickListener(null);
            cVar.yIZ.setVisibility(0);
            cVar.yIQ.setVisibility(8);
            cVar.yJc.setVisibility(0);
            cVar.yJa.setVisibility(8);
            switch (aVar3.type) {
                case 0:
                    if (aVar3.title != null) {
                        break;
                    }
                    cVar.iiq.setVisibility(8);
                    cVar.iir.setVisibility(0);
                    cVar.nnC.setVisibility(8);
                    cVar.yIV.setVisibility(8);
                    cVar.yIQ.setVisibility(4);
                    cVar.iir.setMaxLines(2);
                    if (z3) {
                        b = com.tencent.mm.pluginsdk.model.app.g.b(aVar3.appId, 1, com.tencent.mm.bv.a.getDensity(aVar2.getContext()));
                        if (b == null) {
                            break;
                        }
                        cVar.yIL.setImageResource(R.k.dvD);
                        arVar2 = arVar;
                        obj4 = null;
                        break;
                    }
                case 3:
                    if (aVar3.title != null) {
                        break;
                    }
                    cVar.iiq.setVisibility(8);
                    cVar.iir.setVisibility(0);
                    cVar.iir.setTextColor(aVar2.getContext().getResources().getColor(R.e.white));
                    cVar.nnC.setVisibility(8);
                    cVar.yIQ.setVisibility(4);
                    cVar.yIV.setVisibility(0);
                    if ((auVar.field_msgId).equals(aVar.yIA)) {
                        cVar.yIV.setImageResource(R.g.bDS);
                    } else {
                        cVar.yIV.setImageResource(R.g.bDR);
                    }
                    cVar.iir.setMaxLines(2);
                    if (z3) {
                        b = com.tencent.mm.pluginsdk.model.app.g.b(aVar3.appId, 1, com.tencent.mm.bv.a.getDensity(aVar2.getContext()));
                        if (b != null) {
                            break;
                        }
                        cVar.yIL.setImageResource(R.k.dvn);
                    }
                    c$f com_tencent_mm_ui_chatting_viewitems_c_f2 = new c$f();
                    com_tencent_mm_ui_chatting_viewitems_c_f2.fqm = auVar.field_msgId;
                    com_tencent_mm_ui_chatting_viewitems_c_f2.fCs = auVar.field_content;
                    com_tencent_mm_ui_chatting_viewitems_c_f2.fzs = auVar.field_imgPath;
                    cVar.yIV.setTag(com_tencent_mm_ui_chatting_viewitems_c_f2);
                    cVar.yIV.setOnClickListener(aVar2.ysf.yta);
                    arVar2 = arVar;
                    obj4 = null;
                    break;
                case 4:
                    if (aVar3.title != null) {
                        break;
                    }
                    cVar.iiq.setVisibility(8);
                    cVar.iir.setVisibility(0);
                    cVar.nnC.setVisibility(8);
                    cVar.yIV.setVisibility(0);
                    cVar.yIV.setImageResource(R.g.bHf);
                    cVar.yIQ.setVisibility(4);
                    cVar.iir.setMaxLines(2);
                    if (z3) {
                        b = com.tencent.mm.pluginsdk.model.app.g.b(aVar3.appId, 1, com.tencent.mm.bv.a.getDensity(aVar2.getContext()));
                        if (b != null) {
                            break;
                        }
                        cVar.yIL.setImageResource(R.k.dvA);
                        cVar.yIV.setVisibility(8);
                        arVar2 = arVar;
                        obj4 = null;
                        break;
                    }
                case 5:
                    cVar.iiq.setVisibility(8);
                    if (aVar3.title != null) {
                        break;
                    }
                    cVar.nnC.setVisibility(8);
                    cVar.iir.setMaxLines(3);
                    if (c.i(aVar3)) {
                        cVar.yIV.setVisibility(8);
                    } else {
                        cVar.yIV.setVisibility(0);
                        cVar.yIV.setImageResource(R.g.bHf);
                    }
                    cVar.yIQ.setVisibility(4);
                    if (z3) {
                        b = com.tencent.mm.pluginsdk.model.app.g.b(aVar3.appId, 1, com.tencent.mm.bv.a.getDensity(aVar2.getContext()));
                        if (b == null) {
                            break;
                        }
                        c.a aVar52 = new c.a();
                        aVar52.hDP = R.k.dvD;
                        aVar52.bc(com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 50), com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 50)).hDy = true;
                        o.PA().a(aVar3.thumburl, cVar.yIL, aVar52.PK());
                        arVar2 = arVar;
                        obj4 = null;
                        break;
                    }
                case 6:
                    if (aVar3.title != null) {
                        break;
                    }
                    cVar.iiq.setVisibility(8);
                    cVar.iir.setVisibility(0);
                    cVar.nnC.setVisibility(8);
                    cVar.yIV.setVisibility(8);
                    cVar.yIQ.setVisibility(4);
                    cVar.iir.setMaxLines(2);
                    cVar.iir.setText(bh.bx((long) aVar3.hbb));
                    c.c.a(cVar, substring, aVar3.hbb);
                    c.c.a(cVar, Boolean.valueOf(true), auVar, aVar3.fny, aVar3.title);
                    if (z3) {
                        if (!bh.VW(aVar3.hbc)) {
                            cVar.yIL.setImageResource(r.Ry(aVar3.hbc));
                            arVar2 = arVar;
                            obj4 = null;
                            break;
                        }
                        cVar.yIL.setImageResource(R.g.byY);
                        arVar2 = arVar;
                        obj4 = null;
                        break;
                    }
                case 7:
                    cVar.iiq.setVisibility(8);
                    if (aVar3.title != null) {
                        break;
                    }
                    cVar.nnC.setVisibility(8);
                    cVar.iir.setMaxLines(3);
                    cVar.yIV.setVisibility(8);
                    cVar.yIQ.setVisibility(0);
                    if (z3) {
                        b = com.tencent.mm.pluginsdk.model.app.g.b(aVar3.appId, 1, com.tencent.mm.bv.a.getDensity(aVar2.getContext()));
                        if (b == null) {
                            break;
                        }
                        cVar.yIL.setImageResource(R.k.dvD);
                        arVar2 = arVar;
                        obj4 = null;
                        break;
                    }
                case 10:
                    cVar.nnC.setVisibility(0);
                    if (aVar3.hbw == 1) {
                        cVar.nnC.setText(R.l.eHU);
                    } else if (aVar3.hbw == 2) {
                        cVar.nnC.setText(R.l.eHW);
                    } else if (aVar3.hbw != 3) {
                        cVar.nnC.setText(R.l.eHX);
                    } else {
                        cVar.nnC.setText(R.l.eHV);
                    }
                    cVar.iiq.setVisibility(0);
                    cVar.iiq.setText(aVar3.getTitle());
                    cVar.iir.setMaxLines(4);
                    cVar.yIQ.setVisibility(4);
                    cVar.yIV.setVisibility(8);
                    if (z3) {
                        b = o.Pw().b(auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(aVar2.getContext()), false);
                        if (b == null) {
                            break;
                        }
                        cVar.yIL.setImageResource(R.k.dvD);
                        arVar2 = arVar;
                        obj4 = null;
                        break;
                    }
                    break;
                case 13:
                    cVar.iiq.setVisibility(0);
                    cVar.iiq.setText(aVar3.getTitle());
                    cVar.nnC.setVisibility(0);
                    cVar.nnC.setText(R.l.dSc);
                    cVar.iir.setMaxLines(4);
                    cVar.yIQ.setVisibility(4);
                    cVar.yIV.setVisibility(8);
                    if (z3) {
                        b = o.Pw().b(auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(aVar2.getContext()), false);
                        if (b == null) {
                            break;
                        }
                        cVar.yIL.setImageResource(R.k.dvD);
                        arVar2 = arVar;
                        obj4 = null;
                        break;
                    }
                case 15:
                    if (aVar3.title != null) {
                        break;
                    }
                    cVar.iiq.setVisibility(8);
                    cVar.iir.setVisibility(0);
                    cVar.nnC.setVisibility(8);
                    cVar.yIV.setVisibility(8);
                    cVar.yIQ.setVisibility(4);
                    cVar.iir.setMaxLines(2);
                    if (z3) {
                        b2 = o.Pw().b(auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(aVar2.getContext()), false);
                        if (b2 != null) {
                            break;
                        }
                        cVar.yIL.setImageResource(R.k.dvD);
                    }
                    arVar = new ar(auVar, false, i, "", false, aVar3.title, aVar3.fGz, aVar3.fGA, aVar3.title, aVar3.hbE, aVar3.url, false, false);
                    cVar.yJe.setTag(arVar);
                    cVar.yJe.setOnClickListener(x(aVar2));
                    obj = 1;
                    arVar2 = arVar;
                    obj4 = null;
                    break;
                case 16:
                    cVar.iiq.setVisibility(0);
                    cVar.iiq.setText(aVar3.description);
                    cVar.iir.setText(aVar3.hck);
                    if (aVar3.title != null) {
                        break;
                    }
                    cVar.nnC.setVisibility(8);
                    cVar.iir.setMaxLines(4);
                    cVar.yIQ.setVisibility(4);
                    cVar.yIV.setVisibility(8);
                    if (z3) {
                        b = o.Pw().b(auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(aVar2.getContext()), false);
                        if (b == null) {
                            cVar.yIL.setImageBitmap(b);
                            arVar2 = arVar;
                            obj4 = null;
                            break;
                        }
                        cVar.yIL.setImageResource(R.k.dvD);
                        arVar2 = arVar;
                        obj4 = null;
                        break;
                    }
                case 19:
                    c.c.a(aVar2, cVar, aVar3, z3);
                    arVar2 = arVar;
                    obj4 = null;
                    break;
                case 20:
                    cVar.iiq.setVisibility(0);
                    cVar.iiq.setText(aVar3.getTitle());
                    cVar.nnC.setVisibility(8);
                    cVar.iir.setMaxLines(4);
                    cVar.yIQ.setVisibility(4);
                    cVar.yIV.setVisibility(8);
                    if (z3) {
                        b = o.Pw().b(auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(aVar2.getContext()), false);
                        if (b == null) {
                            break;
                        }
                        cVar.yIL.setImageResource(R.k.dvD);
                        arVar2 = arVar;
                        obj4 = null;
                        break;
                    }
                    break;
                case 24:
                    cVar.iiq.setVisibility(8);
                    cVar.nnC.setVisibility(0);
                    if (aVar3.title != null) {
                        break;
                    }
                    cVar.nnC.setText(com.tencent.mm.pluginsdk.ui.d.i.b(cVar.nnC.getContext(), ac.getContext().getString(R.l.egW), cVar.nnC.getTextSize()));
                    cVar.iir.setMaxLines(3);
                    cVar.yIV.setVisibility(8);
                    cVar.yIQ.setVisibility(4);
                    if (z3) {
                        cVar.yIL.setVisibility(8);
                        cVar.yJd.setVisibility(8);
                    }
                    c.c.a(aVar2, cVar, aVar3, auVar, z3);
                    arVar2 = arVar;
                    obj4 = null;
                    break;
                case 25:
                    if (aVar3.title != null) {
                        break;
                    }
                    cVar.iiq.setVisibility(8);
                    cVar.iir.setVisibility(0);
                    cVar.nnC.setVisibility(8);
                    cVar.yIV.setVisibility(8);
                    cVar.yIQ.setVisibility(4);
                    cVar.iir.setMaxLines(2);
                    if (z3) {
                        b2 = o.Pw().b(auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(aVar2.getContext()), false);
                        if (b2 != null) {
                            break;
                        }
                        cVar.yIL.setImageResource(R.k.dvD);
                    }
                    arVar = new ar(auVar, i, "", aVar2.csX(), aVar3.fGz, aVar3.fGA, aVar3.title, aVar3.hdl, aVar3.designerName, aVar3.designerRediretctUrl, aVar3.url);
                    cVar.yJe.setTag(arVar);
                    FrameLayout frameLayout22 = cVar.yJe;
                    if (this.yJA == null) {
                        this.yJA = new h(aVar2);
                    }
                    frameLayout22.setOnClickListener(this.yJA);
                    obj = 1;
                    arVar2 = arVar;
                    obj4 = null;
                    break;
                case 26:
                case 27:
                    if (aVar3.title != null) {
                        break;
                    }
                    cVar.iiq.setVisibility(8);
                    cVar.iir.setVisibility(0);
                    cVar.nnC.setVisibility(8);
                    cVar.yIV.setVisibility(8);
                    cVar.yIQ.setVisibility(4);
                    cVar.iir.setMaxLines(2);
                    if (z3) {
                        b2 = o.Pw().b(auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(aVar2.getContext()), false);
                        if (b2 != null) {
                            break;
                        }
                        cVar.yIL.setImageResource(R.k.dvD);
                    }
                    arVar2 = new ar();
                    arVar2.fEJ = auVar;
                    arVar2.ypn = false;
                    arVar2.position = i;
                    arVar2.yOD = false;
                    arVar2.title = aVar2.csX();
                    arVar2.fGz = aVar3.fGz;
                    arVar2.fGA = aVar3.fGA;
                    arVar2.yOE = aVar3.title;
                    if (aVar3.type == 26) {
                        arVar2.tid = aVar3.tid;
                        arVar2.hdm = aVar3.hdm;
                        arVar2.desc = aVar3.desc;
                        arVar2.iconUrl = aVar3.iconUrl;
                        arVar2.secondUrl = aVar3.secondUrl;
                        arVar2.pageType = aVar3.pageType;
                        frameLayout = cVar.yJe;
                        if (this.yJB == null) {
                            this.yJB = new k(aVar2);
                        }
                        frameLayout.setOnClickListener(this.yJB);
                        obj4 = 1;
                    } else if (aVar3.type != 27) {
                        obj4 = null;
                    } else {
                        arVar2.tid = aVar3.tid;
                        arVar2.hdm = aVar3.hdm;
                        arVar2.desc = aVar3.desc;
                        arVar2.iconUrl = aVar3.iconUrl;
                        arVar2.secondUrl = aVar3.secondUrl;
                        arVar2.pageType = aVar3.pageType;
                        frameLayout = cVar.yJe;
                        if (this.yJC == null) {
                            this.yJC = new i(aVar2);
                        }
                        frameLayout.setOnClickListener(this.yJC);
                        obj4 = 1;
                    }
                    cVar.yJe.setTag(arVar2);
                    obj = obj4;
                    obj4 = null;
                    break;
                case 33:
                    qK = ((b) com.tencent.mm.kernel.g.h(b.class)).qK(aVar3.hdx);
                    switch (aVar3.hdz) {
                        case 1:
                            if (qK == null) {
                                obj3 = aVar3.title;
                            } else {
                                charSequence = qK.field_nickname;
                            }
                            if (qK == null) {
                            }
                            cVar.yJf.setVisibility(8);
                            cVar.yJs.setVisibility(8);
                            cVar.yJl.setVisibility(0);
                            cVar.yJn.setText(charSequence);
                            if (!bh.ov(str2)) {
                                com.tencent.mm.modelappbrand.a.b.Jj().a(cVar.yJm, str2, com.tencent.mm.modelappbrand.a.a.Ji(), com.tencent.mm.modelappbrand.a.f.hkr);
                                arVar2 = arVar;
                                obj4 = null;
                                break;
                            }
                            com.tencent.mm.modelappbrand.a.b.Jj().a(cVar.yJm, "file://" + o.Pw().ln(auVar.field_imgPath), com.tencent.mm.modelappbrand.a.a.Ji(), com.tencent.mm.modelappbrand.a.f.hkr);
                            arVar2 = arVar;
                            obj4 = null;
                            break;
                        case 2:
                        case 3:
                            if (qK == null) {
                                obj3 = aVar3.fGA;
                            } else {
                                charSequence = qK.field_nickname;
                            }
                            if (qK == null) {
                                str2 = aVar3.hdG;
                            } else {
                                str2 = qK.field_brandIconURL;
                            }
                            cVar.yJf.setVisibility(8);
                            cVar.yJs.setVisibility(0);
                            cVar.yJl.setVisibility(8);
                            cVar.yJo.setVisibility(8);
                            cVar.yJv.setText(aVar3.title);
                            cVar.yJo.setText(aVar3.description);
                            cVar.yJq.setText(charSequence);
                            switch (aVar3.hdE) {
                                case 1:
                                    cVar.yJr.setText(R.l.dEl);
                                    break;
                                case 2:
                                    cVar.yJr.setText(R.l.dEk);
                                    break;
                                default:
                                    cVar.yJr.setText(R.l.dDT);
                                    break;
                            }
                            o.PA().a(str2, cVar.yJp, this.yHa);
                            str2 = o.Pw().ln(auVar.field_imgPath);
                            cVar.yJt.setImageBitmap(null);
                            cVar.yJt.setVisibility(4);
                            cVar.yJu.setVisibility(0);
                            com.tencent.mm.modelappbrand.a.b.Jj().a(new 2(this, cVar), "file://" + str2, null, ((com.tencent.mm.modelappbrand.g) com.tencent.mm.kernel.g.h(com.tencent.mm.modelappbrand.g.class)).aZ(bp.CTRL_INDEX, 172));
                            arVar2 = arVar;
                            obj4 = null;
                            break;
                        default:
                            arVar2 = arVar;
                            int i22 = 1;
                            break;
                    }
                case 34:
                    if (aVar3.title != null) {
                        break;
                    }
                    cVar.iiq.setVisibility(8);
                    cVar.iir.setMaxLines(2);
                    cVar.iir.setVisibility(0);
                    if (bh.ov(aVar3.hcu)) {
                        cVar.iir.setTextColor(aVar2.getContext().getResources().getColor(R.e.bsF));
                    } else {
                        cVar.iir.setTextColor(bh.ba(aVar3.hcu, aVar2.getContext().getResources().getColor(R.e.bsF)));
                    }
                    cVar.nnC.setVisibility(8);
                    cVar.yIQ.setVisibility(4);
                    cVar.yIV.setVisibility(8);
                    cVar.yIP.setVisibility(0);
                    cVar.mxT.setVisibility(0);
                    if (bh.ov(aVar3.hcp)) {
                        cVar.mxT.setText(R.l.dRv);
                    } else {
                        cVar.mxT.setText(aVar3.hcp);
                    }
                    if (!this.vzn) {
                        cVar.yIL.setImageBitmap(BitmapFactory.decodeResource(aVar2.getResources(), R.g.bEh));
                        arVar2 = arVar;
                        obj4 = null;
                        break;
                    }
                    b = o.Pw().a(auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(aVar2.getContext()), false);
                    cVar.yIL.setImageBitmap(d.a(b, false, (float) (b.getWidth() / 2)));
                    if (bh.ov(aVar3.hcs)) {
                        com.tencent.mm.aq.a.a PA2 = o.PA();
                        str3 = aVar3.hcs;
                        ImageView imageView2 = new ImageView(aVar2.getContext());
                        c.a aVar62 = new c.a();
                        aVar62.hDA = true;
                        PA2.a(str3, imageView2, aVar62.PK(), new 3(this, cVar, aVar2));
                        arVar2 = arVar;
                        obj4 = null;
                        break;
                    }
                    cVar.yJf.getViewTreeObserver().addOnPreDrawListener(new 4(this, cVar, aVar2, b));
                    arVar2 = arVar;
                    obj4 = null;
                    break;
                    break;
                case 36:
                    qK = ((b) com.tencent.mm.kernel.g.h(b.class)).qK(aVar3.hdx);
                    if (qK == null) {
                        obj3 = aVar3.fGA;
                    } else {
                        charSequence = qK.field_nickname;
                    }
                    if (qK == null) {
                        str2 = aVar3.hdG;
                    } else {
                        str2 = qK.field_brandIconURL;
                    }
                    cVar.yJf.setVisibility(8);
                    cVar.yJs.setVisibility(0);
                    cVar.yJl.setVisibility(8);
                    cVar.yJo.setVisibility(8);
                    cVar.yJv.setText(aVar3.title);
                    cVar.yJo.setText(aVar3.description);
                    cVar.yJq.setText(charSequence);
                    switch (aVar3.hdE) {
                        case 1:
                            cVar.yJr.setText(R.l.dEl);
                            break;
                        case 2:
                            cVar.yJr.setText(R.l.dEk);
                            break;
                        default:
                            cVar.yJr.setText(R.l.dDT);
                            break;
                    }
                    o.PA().a(str2, cVar.yJp, this.yHa);
                    String ln2 = o.Pw().ln(auVar.field_imgPath);
                    cVar.yJt.setImageBitmap(null);
                    com.tencent.mm.modelappbrand.a.b.Jj().a(cVar.yJt, "file://" + ln2, null, null, ((com.tencent.mm.modelappbrand.g) com.tencent.mm.kernel.g.h(com.tencent.mm.modelappbrand.g.class)).aZ(bp.CTRL_INDEX, 172));
                    arVar2 = arVar;
                    obj4 = null;
                    break;
                case 40:
                    if (fX.hea == 19) {
                        c.c.a(aVar2, cVar, aVar3, z3);
                        arVar2 = arVar;
                        obj4 = null;
                        break;
                    }
                default:
                    arVar2 = arVar;
                    obj4 = 1;
                    break;
            }
            if (obj4 != null) {
                if (aVar3.title != null) {
                }
                cVar.nnC.setVisibility(8);
                cVar.iiq.setVisibility(8);
                if (z3) {
                    if (aVar3.type != 33) {
                    }
                    str3 = o.Pw().ln(auVar.field_imgPath);
                    cVar.yIL.setImageResource(R.k.dvD);
                    com.tencent.mm.modelappbrand.a.b.Jj().a(cVar.yIL, "file://" + str3, null, null, ((com.tencent.mm.modelappbrand.g) com.tencent.mm.kernel.g.h(com.tencent.mm.modelappbrand.g.class)).aZ(50, 50));
                }
            }
            if (!aVar2.ypn) {
                cVar.yIY.setVisibility(8);
                arVar = arVar2;
            } else if (com.tencent.mm.pluginsdk.model.app.g.g(cQ)) {
                cVar.yIY.setVisibility(8);
                arVar = arVar2;
            } else {
                cVar.yIY.setVisibility(0);
                c(aVar2, cVar.yIY, ar.a(aVar3, auVar));
                obj4 = arVar2;
            }
        }
        if (obj == null) {
            cVar.yJe.setTag(obj4);
            cVar.yJe.setOnClickListener(t(aVar2));
        }
        if (this.vzn) {
            cVar.yJe.setOnLongClickListener(s(aVar2));
            cVar.yJe.setOnTouchListener(aVar2.ysf.ysV);
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        int i = ((ar) view.getTag()).position;
        int RH = l.RH(this.yqa.dk(auVar.field_content, auVar.field_isSend));
        g.a fT = g.a.fT(this.yqa.dk(auVar.field_content, auVar.field_isSend));
        f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(fT.appId, false);
        if (com.tencent.mm.pluginsdk.model.app.g.h(aZ) && !com.tencent.mm.ui.chatting.i.an(auVar)) {
            if (fT.type == 6) {
                com.tencent.mm.pluginsdk.model.app.b RI = l.RI(fT.fny);
                if ((RI == null || !c.b.c(auVar, RI.field_fileFullPath)) && !auVar.cjs()) {
                    contextMenu.add(i, 111, 0, this.yqa.getString(R.l.eEC));
                }
            } else {
                contextMenu.add(i, 111, 0, this.yqa.getString(R.l.eEC));
            }
        }
        if (fT.hbb <= 0 || (fT.hbb > 0 && RH >= 100)) {
            boolean LL;
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

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        g.a aVar2;
        switch (menuItem.getItemId()) {
            case 100:
                String str = auVar.field_content;
                aVar2 = null;
                if (str != null) {
                    aVar2 = g.a.fT(str);
                }
                if (aVar2 != null) {
                    l.fq(auVar.field_msgId);
                    if (19 == aVar2.type) {
                        com.tencent.mm.sdk.b.b mtVar = new mt();
                        mtVar.fEE.type = 3;
                        mtVar.fEE.fqm = auVar.field_msgId;
                        com.tencent.mm.sdk.b.a.xef.m(mtVar);
                    }
                }
                ba.aK(auVar.field_msgId);
                f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(aVar2.appId, false);
                if (aZ != null && aZ.Yz()) {
                    a(aVar, aVar2, auVar, aZ);
                    break;
                }
            case 111:
                c.b.a(aVar, auVar, a(aVar, auVar));
                break;
            case 114:
                String str2 = auVar.field_content;
                if (str2 != null) {
                    aVar2 = g.a.fT(str2);
                    if (aVar2 != null) {
                        switch (aVar2.type) {
                            case 1:
                                ah.k(aVar.dk(auVar.field_content, auVar.field_isSend), aVar.getContext());
                                break;
                            case 2:
                                ah.a(auVar, aVar.getContext(), a(aVar, auVar), aVar.ysk);
                                break;
                            case 3:
                                ah.a(auVar, aVar.dk(auVar.field_content, auVar.field_isSend), aVar.getContext());
                                break;
                            case 4:
                                ah.a(auVar, aVar.getContext());
                                break;
                            case 5:
                                ah.c(auVar, aVar.dk(auVar.field_content, auVar.field_isSend), aVar.getContext());
                                break;
                            case 6:
                                ah.b(auVar, aVar.dk(auVar.field_content, auVar.field_isSend), aVar.getContext());
                                break;
                            case 8:
                                ah.b(auVar, aVar.getContext());
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
    public final boolean b(View view, a aVar, au auVar) {
        g.a fT;
        int i;
        com.tencent.mm.modelstat.a.a(auVar, a$a.Click);
        String str = auVar.field_content;
        Boolean valueOf = Boolean.valueOf(false);
        if (str != null) {
            fT = g.a.fT(aVar.dk(str, auVar.field_isSend));
            com.tencent.mm.y.k fX = com.tencent.mm.y.k.fX(str);
            if (fT != null) {
                if (fX.hea != 0) {
                    valueOf = Boolean.valueOf(true);
                    fT.type = fX.hea;
                }
                Boolean bool = valueOf;
                f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(fT.appId, false);
                if (aZ != null && aZ.Yz()) {
                    a(aVar, fT, c(aVar, auVar), aZ, auVar.field_msgSvrId);
                }
                Intent intent;
                String crz;
                Bundle bundle;
                Bundle bundle2;
                Object obj;
                switch (fT.type) {
                    case 3:
                        com.tencent.mm.plugin.report.service.g.pQN.h(13043, new Object[]{Integer.valueOf(2), fT.description, fT.appId});
                        break;
                    case 4:
                        break;
                    case 6:
                        if (this.vzn) {
                            intent = new Intent();
                            intent.setClassName(aVar.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                            intent.putExtra("app_msg_id", auVar.field_msgId);
                            aVar.startActivity(intent);
                            return true;
                        }
                        u.fI(aVar.getContext());
                        return true;
                    case 7:
                        if (aZ != null && aZ.Yz() && a(aVar, aZ)) {
                            return true;
                        }
                        if (fT.fny == null || fT.fny.length() == 0) {
                            aVar.ywa.aM(auVar);
                        } else if (this.vzn) {
                            intent = new Intent();
                            intent.setClassName(aVar.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                            intent.putExtra("app_msg_id", auVar.field_msgId);
                            aVar.startActivityForResult(intent, com.tencent.mm.plugin.appbrand.jsapi.share.i.CTRL_INDEX);
                        } else {
                            u.fI(aVar.getContext());
                            return true;
                        }
                        return true;
                    case 10:
                        if (bh.ov(fT.hbx)) {
                            return false;
                        }
                        intent = new Intent();
                        intent.setFlags(65536);
                        intent.putExtra("key_Product_xml", fT.hbx);
                        intent.putExtra("key_ProductUI_getProductInfoScene", 1);
                        if (auVar.field_imgPath == null) {
                            intent.putExtra("key_ProductUI_chatting_msgId", auVar.field_msgId);
                        }
                        com.tencent.mm.bm.d.b(aVar.getContext(), "scanner", ".ui.ProductUI", intent);
                        return true;
                    case 13:
                        if (bh.ov(fT.hbD)) {
                            return false;
                        }
                        intent = new Intent();
                        intent.setFlags(65536);
                        intent.putExtra("key_product_info", fT.hbD);
                        intent.putExtra("key_product_scene", 1);
                        com.tencent.mm.bm.d.b(aVar.getContext(), "product", ".ui.MallProductUI", intent);
                        return true;
                    case 16:
                        if (bh.ov(fT.fys)) {
                            return false;
                        }
                        intent = new Intent();
                        intent.setFlags(65536);
                        intent.putExtra("key_card_app_msg", fT.fys);
                        intent.putExtra("key_from_scene", fT.hcl);
                        com.tencent.mm.bm.d.b(aVar.getContext(), "card", ".ui.CardDetailUI", intent);
                        return true;
                    case 19:
                        intent = new Intent();
                        intent.putExtra("message_id", auVar.field_msgId);
                        intent.putExtra("record_xml", fT.hbB);
                        intent.putExtra("big_appmsg", bool);
                        c$a.a(intent, aVar, auVar, this);
                        com.tencent.mm.bm.d.b(aVar.getContext(), "record", ".ui.RecordMsgDetailUI", intent);
                        return true;
                    case 20:
                        if (bh.ov(fT.hbA)) {
                            return false;
                        }
                        intent = new Intent();
                        intent.setFlags(65536);
                        intent.putExtra("key_TV_xml", fT.hbA);
                        intent.putExtra("key_TV_getProductInfoScene", 1);
                        if (auVar.field_imgPath == null) {
                            intent.putExtra("key_TVInfoUI_chatting_msgId", auVar.field_msgId);
                        }
                        com.tencent.mm.bm.d.b(aVar.getContext(), "shake", ".ui.TVInfoUI", intent);
                        return true;
                    case 24:
                        com.tencent.mm.sdk.b.b lhVar = new lh();
                        lhVar.fCF.context = aVar.getContext();
                        lhVar.fCF.fqm = auVar.field_msgId;
                        lhVar.fCF.fBV = aVar.ysk;
                        lhVar.fCF.fCG = fT.hbB;
                        lhVar.fCF.scene = 6;
                        com.tencent.mm.sdk.b.a.xef.m(lhVar);
                        return true;
                    case 33:
                        x.i("MicroMsg.ChattingItemAppMsgFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[]{fT.hdx, fT.hdw, fT.hdy, fT.url, Integer.valueOf(fT.hdE), fT.hdA});
                        crz = aVar.crz();
                        String a = a(aVar, auVar);
                        bundle = new Bundle();
                        if (aVar instanceof AppBrandServiceChattingUI.a) {
                            str = "stat_scene";
                            i = 10;
                            bundle2 = bundle;
                        } else if (aVar.ysk) {
                            str = "stat_scene";
                            i = 2;
                            bundle2 = bundle;
                        } else {
                            str = "stat_scene";
                            if (s.gF(crz)) {
                                i = 7;
                                bundle2 = bundle;
                            } else {
                                i = 1;
                                bundle2 = bundle;
                            }
                        }
                        bundle2.putInt(str, i);
                        bundle.putString("stat_msg_id", "msg_" + Long.toString(auVar.field_msgSvrId));
                        bundle.putString("stat_chat_talker_username", crz);
                        bundle.putString("stat_send_msg_user", a);
                        switch (fT.hdz) {
                            case 1:
                                intent = new Intent();
                                intent.putExtra("key_username", fT.hdx);
                                if (aVar.ysk) {
                                    intent.putExtra("key_from_scene", 1);
                                    intent.putExtra("key_scene_note", crz + ":" + a);
                                } else {
                                    intent.putExtra("key_from_scene", 2);
                                    intent.putExtra("key_scene_note", crz);
                                }
                                WxaExposedParams.a aVar2 = new WxaExposedParams.a();
                                aVar2.appId = fT.hdy;
                                aVar2.fqe = 6;
                                aVar2.iGK = fT.hdE;
                                aVar2.iGL = fT.hdB;
                                intent.putExtra("key_scene_exposed_params", aVar2.ace());
                                intent.putExtra("_stat_obj", bundle);
                                com.tencent.mm.bm.d.b(aVar.getContext(), "appbrand", ".ui.AppBrandProfileUI", intent);
                                obj = null;
                                break;
                            case 2:
                                if (!(aVar instanceof AppBrandServiceChattingUI.a)) {
                                    if (!s.gF(crz)) {
                                        com.tencent.mm.modelappbrand.a.a(crz, a, aVar.ysk, fT, bundle);
                                        obj = null;
                                        break;
                                    }
                                    com.tencent.mm.modelappbrand.a.a(crz, 1074, fT, bundle);
                                    obj = null;
                                    break;
                                }
                                com.tencent.mm.modelappbrand.a.a(crz, 1073, fT, bundle);
                                obj = null;
                                break;
                            case 3:
                                com.tencent.mm.modelappbrand.a.b(crz, a, aVar.ysk, fT, bundle);
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
                        intent = new Intent();
                        intent.putExtra("key_from_user_name", a(aVar, auVar));
                        intent.putExtra("key_biz_uin", fT.hcn);
                        intent.putExtra("key_order_id", fT.hco);
                        if (!(auVar.field_talker == null || auVar.field_talker.equals("") || !auVar.field_talker.endsWith("@chatroom"))) {
                            intent.putExtra("key_chatroom_name", auVar.field_talker);
                        }
                        com.tencent.mm.bm.d.b(aVar.getContext(), "card", ".ui.CardGiftAcceptUI", intent);
                        return true;
                    case 36:
                        if (bh.ov(fT.hdy) && bh.ov(fT.hdx)) {
                            String A = p.A(fT.url, aVar.ysk ? "groupmessage" : "singlemessage");
                            Intent intent2 = new Intent();
                            intent2.putExtra("rawUrl", A);
                            intent2.putExtra("webpageTitle", fT.title);
                            intent2.putExtra("shortUrl", fT.url);
                            com.tencent.mm.bm.d.b(aVar.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                            return true;
                        }
                        String crz2 = aVar.crz();
                        crz = a(aVar, auVar);
                        bundle = new Bundle();
                        if (aVar.ysk) {
                            str = "stat_scene";
                            i = 2;
                            bundle2 = bundle;
                        } else {
                            str = "stat_scene";
                            if (s.gF(crz2)) {
                                i = 7;
                                bundle2 = bundle;
                            } else {
                                i = 1;
                                bundle2 = bundle;
                            }
                        }
                        bundle2.putInt(str, i);
                        bundle.putString("stat_msg_id", "msg_" + Long.toString(auVar.field_msgSvrId));
                        bundle.putString("stat_chat_talker_username", crz2);
                        bundle.putString("stat_send_msg_user", crz);
                        ((com.tencent.mm.plugin.appbrand.m.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.m.c.class)).a(aVar.getContext(), aVar.crz(), a(aVar, auVar), aVar.ysk, fT);
                        return true;
                    default:
                        obj = 1;
                        break;
                }
            }
            return false;
        }
        return false;
        if (r2 != null) {
            com.tencent.mm.ui.e.i.xEq = true;
            intent2.putExtra("key_search_web_data", r2);
            intent2.putExtra("key_proxy_fts_rec_ui", true);
            com.tencent.mm.bm.d.b(aVar.getContext(), "webview", ".fts.topstory.ui.TopStoryVideoListUI", intent2);
            return true;
        }
        A = p.A(fT.url, aVar.ysk ? "groupmessage" : "singlemessage");
        str = fT.url;
        PackageInfo packageInfo = getPackageInfo(aVar.getContext(), fT.appId);
        Intent intent3 = new Intent();
        intent3.putExtra("rawUrl", A);
        intent3.putExtra("webpageTitle", fT.title);
        if (fT.appId != null && ("wx751a1acca5688ba3".equals(fT.appId) || "wxfbc915ff7c30e335".equals(fT.appId) || "wx482a4001c37e2b74".equals(fT.appId))) {
            Bundle bundle3 = new Bundle();
            bundle3.putString("jsapi_args_appid", fT.appId);
            intent3.putExtra("jsapiargs", bundle3);
        }
        if (bh.ov(str)) {
            intent3.putExtra("shortUrl", fT.url);
        } else {
            intent3.putExtra("shortUrl", str);
        }
        intent3.putExtra("version_name", packageInfo == null ? null : packageInfo.versionName);
        intent3.putExtra("version_code", packageInfo == null ? 0 : packageInfo.versionCode);
        if (!bh.ov(fT.fGz)) {
            intent3.putExtra("srcUsername", fT.fGz);
            intent3.putExtra("srcDisplayname", fT.fGA);
        }
        intent3.putExtra("msg_id", auVar.field_msgId);
        intent3.putExtra("KPublisherId", "msg_" + Long.toString(auVar.field_msgSvrId));
        intent3.putExtra("KAppId", fT.appId);
        intent3.putExtra("geta8key_username", aVar.crz());
        intent3.putExtra("pre_username", a(aVar, auVar));
        intent3.putExtra("from_scence", 2);
        intent3.putExtra("expid_str", auVar.gjO);
        i = t.N(a(aVar, auVar), aVar.crz());
        intent3.putExtra("prePublishId", "msg_" + Long.toString(auVar.field_msgSvrId));
        intent3.putExtra("preUsername", a(aVar, auVar));
        intent3.putExtra("preChatName", aVar.crz());
        intent3.putExtra("preChatTYPE", i);
        intent3.putExtra("preMsgIndex", 0);
        switch (i) {
            case 1:
                i = 3;
                break;
            case 2:
                i = 2;
                break;
            case 6:
            case 7:
                i = 5;
                break;
            default:
                i = 0;
                break;
        }
        intent3.putExtra("share_report_pre_msg_url", fT.url);
        intent3.putExtra("share_report_pre_msg_title", fT.title);
        intent3.putExtra("share_report_pre_msg_desc", fT.description);
        intent3.putExtra("share_report_pre_msg_icon_url", fT.thumburl);
        intent3.putExtra("share_report_pre_msg_appid", fT.appId);
        intent3.putExtra("share_report_from_scene", i);
        if (i == 5) {
            intent3.putExtra("share_report_biz_username", aVar.crz());
        }
        com.tencent.mm.bm.d.b(aVar.getContext(), "webview", ".ui.tools.WebViewUI", intent3);
        return true;
    }
}
