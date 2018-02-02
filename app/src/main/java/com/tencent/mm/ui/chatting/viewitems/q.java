package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ag.m;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.o;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.ky;
import com.tencent.mm.g.b.af;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams$a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.chatting.ChattingUI$a;
import com.tencent.mm.ui.chatting.ChattingUI.b;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.s;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class q extends b {
    static int yLF = Color.parseColor("#888888");
    static int yLG = Color.parseColor("#888888");
    private OnClickListener lUQ;
    private String mAppId;
    private r xMp;
    private c xMy;
    private OnClickListener yLA;
    private b yLB;
    private OnClickListener yLC;
    private String yLD;
    private int yLE;
    private OnClickListener yLx;
    private OnClickListener yLy;
    private OnClickListener yLz;
    private com.tencent.mm.sdk.b.c<ky> ypS;
    private ChattingUI$a yqa;

    static /* synthetic */ void a(q qVar, String str) {
        WxaAttributes qK = ((com.tencent.mm.plugin.appbrand.m.b) g.h(com.tencent.mm.plugin.appbrand.m.b.class)).qK(str);
        if (qK != null) {
            A(1, qK.field_appId, qVar.yLD);
        }
        Intent intent = new Intent();
        intent.putExtra("key_username", str);
        intent.putExtra("key_from_scene", 5);
        if (qK != null) {
            WxaExposedParams$a wxaExposedParams$a = new WxaExposedParams$a();
            wxaExposedParams$a.appId = qK.field_appId;
            wxaExposedParams$a.fqe = 6;
            intent.putExtra("key_scene_exposed_params", wxaExposedParams$a.ace());
        }
        d.b(qVar.yqa.getContext(), "appbrand", ".ui.AppBrandProfileUI", intent);
    }

    static /* synthetic */ void b(Context context, String str, long j) {
        if (str == null) {
            x.e("MicroMsg.ChattingItemDyeingTemplate", "[gotoChattingUIWithPosition] username is null");
            return;
        }
        ar.Hg();
        x.i("MicroMsg.ChattingItemDyeingTemplate", "[gotoChattingUIWithPosition] msgLocalId:%s", new Object[]{Long.valueOf(com.tencent.mm.z.c.Fa().F(str, j).field_msgId)});
        if (str.contains("@")) {
            ar.Hg();
            if (com.tencent.mm.z.c.Fh().hD(str) == null) {
                x.w("MicroMsg.ChattingItemDyeingTemplate", "[gotoChattingUIWithPosition] member is null! username:%s", new Object[]{str});
                h.a(context, context.getString(R.l.eEv), context.getString(R.l.cRU), null);
                return;
            }
        }
        ar.Hg();
        af WO = com.tencent.mm.z.c.EY().WO(str);
        if (WO == null || !a.fZ(WO.field_type)) {
            if (WO == null) {
                x.w("MicroMsg.ChattingItemDyeingTemplate", "[gotoChattingUIWithPosition] contact is null! username:%s", new Object[]{str});
            } else {
                x.w("MicroMsg.ChattingItemDyeingTemplate", "[gotoChattingUIWithPosition] isContact not ! username:%s", new Object[]{str});
            }
            h.a(context, context.getString(R.l.eEv), context.getString(R.l.cRU), null);
            return;
        }
        com.tencent.mm.plugin.chatroom.a.ifs.e(new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", r0), context);
    }

    public final boolean aXj() {
        return false;
    }

    public q() {
        c.a aVar = new c.a();
        aVar.hDY = true;
        aVar.hDP = R.g.bzZ;
        this.xMy = aVar.PK();
        this.yLy = new a(this, (byte) 0);
        this.yLx = new OnClickListener(this) {
            final /* synthetic */ q yLH;

            {
                this.yLH = r1;
            }

            public final void onClick(View view) {
                au auVar = (au) view.getTag(R.h.czI);
                if (auVar == null) {
                    x.w("MicroMsg.ChattingItemDyeingTemplate", "on more view click, but msg is null.");
                    return;
                }
                Map y = bi.y(auVar.field_content, "msg");
                if (y != null && y.size() != 0) {
                    String ou = bh.ou((String) y.get(".msg.fromusername"));
                    WxaAttributes qK = ((com.tencent.mm.plugin.appbrand.m.b) g.h(com.tencent.mm.plugin.appbrand.m.b.class)).qK(ou);
                    int o = bh.o(y.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), -1);
                    int o2 = bh.o(y.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_version"), -1);
                    com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(view.getContext(), com.tencent.mm.ui.widget.g.ztp, false);
                    boolean z = qK != null && (qK.field_appOpt & 1) > 0;
                    if (z) {
                        gVar.e(view.getResources().getString(R.l.ezC), 3);
                    } else {
                        gVar.e(view.getResources().getString(R.l.ezp), 3);
                    }
                    gVar.rKC = new 1(this, z, view);
                    gVar.rKD = new 2(this, view, ou, auVar, o, o2);
                    gVar.bUk();
                }
            }
        };
        this.yLC = new OnClickListener(this) {
            final /* synthetic */ q yLH;

            {
                this.yLH = r1;
            }

            public final void onClick(View view) {
                ar arVar = (ar) view.getTag();
                x.i("MicroMsg.ChattingItemDyeingTemplate", "on header (%s) name click", new Object[]{arVar.userName});
                Map y = bi.y(arVar.fEJ.field_content, "msg");
                String ou = bh.ou((String) y.get(".msg.fromusername"));
                com.tencent.mm.plugin.report.service.g.pQN.h(11608, new Object[]{this.yLH.yLD, ou, Integer.valueOf(66666)});
                String ou2 = bh.ou((String) y.get(".msg.appmsg.mmreader.template_header.weapp_username"));
                if (bh.ov(ou2)) {
                    String ou3 = bh.ou((String) y.get(".msg.appmsg.mmreader.template_header.header_jump_url"));
                    if (!bh.ov(ou3)) {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", ou3);
                        d.b(this.yLH.yqa.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                        return;
                    }
                    return;
                }
                String ou4 = bh.ou((String) y.get(".msg.appmsg.mmreader.template_header.weapp_path"));
                int i = bh.getInt((String) y.get(".msg.appmsg.mmreader.template_header.weapp_state"), 0);
                int i2 = bh.getInt((String) y.get(".msg.appmsg.mmreader.template_header.weapp_version"), 0);
                ou = bh.ou((String) y.get(".msg.appmsg.template_id"));
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.fnp = arVar.fEJ.field_msgSvrId + ":" + arVar.userName + ":" + this.yLH.yqa.crz() + ":" + ou;
                appBrandStatObject.scene = HardCoderJNI.FUNC_CANCEL_UNIFY_CPU_IO_THREAD_CORE;
                ((com.tencent.mm.plugin.appbrand.m.c) g.h(com.tencent.mm.plugin.appbrand.m.c.class)).a(this.yLH.yqa.getContext(), ou2, null, i, i2, ou4, appBrandStatObject);
            }
        };
        this.yLz = new OnClickListener(this) {
            final /* synthetic */ q yLH;

            {
                this.yLH = r1;
            }

            public final void onClick(View view) {
                ar arVar = (ar) view.getTag();
                x.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) name click", new Object[]{arVar.userName});
                Map y = bi.y(arVar.fEJ.field_content, "msg");
                if (!(y == null || y.size() == 0)) {
                    bh.getInt((String) y.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
                }
                q qVar = this.yLH;
                view.getContext();
                q.a(qVar, arVar.userName);
            }
        };
        this.ypS = new 11(this);
        this.yLB = new 12(this);
        this.yLA = new 13(this);
        this.lUQ = new 14(this);
    }

    public final boolean aj(int i, boolean z) {
        if (i == 318767153) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddg);
        ap apVar = new ap();
        apVar.mSc = (CheckBox) view.findViewById(R.h.bTC);
        apVar.jWc = view.findViewById(R.h.bUC);
        apVar.qhg = (TextView) view.findViewById(R.h.bVk);
        apVar.iip = (ImageView) view.findViewById(R.h.bTu);
        apVar.ldK = (TextView) view.findViewById(R.h.bVf);
        apVar.yKM = (LinearLayout) view.findViewById(R.h.bTJ);
        apVar.yOv.pBg = view.findViewById(R.h.bUp);
        apVar.yOv.yOx = view.findViewById(R.h.cok);
        apVar.yOv.jpW = (TextView) apVar.yOv.pBg.findViewById(R.h.title);
        apVar.yOv.nou = (TextView) apVar.yOv.pBg.findViewById(R.h.time);
        apVar.yOv.yOB = (LinearLayout) apVar.yOv.pBg.findViewById(R.h.cce);
        apVar.yOv.yOA = (TextView) apVar.yKM.findViewById(R.h.cbk);
        apVar.yOv.yOC = apVar.yKM.findViewById(R.h.cLC);
        apVar.yOv.yOy = view.findViewById(R.h.cxt);
        apVar.yOv.yOz = view.findViewById(R.h.cxu);
        apVar.yOw.yOU = view.findViewById(R.h.bUo);
        apVar.yOw.yOV = (ImageView) view.findViewById(R.h.czG);
        apVar.yOw.yOW = view.findViewById(R.h.czE);
        apVar.yOw.yOY = (TextView) view.findViewById(R.h.czW);
        apVar.yOw.yOX = (ImageView) view.findViewById(R.h.czo);
        apVar.yOw.yOZ = view.findViewById(R.h.czp);
        apVar.yOw.yPa = (ImageView) view.findViewById(R.h.czK);
        apVar.yOw.yPb = view.findViewById(R.h.czI);
        apVar.yOw.yPc = view.findViewById(R.h.czJ);
        apVar.yOw.yPd = (TextView) view.findViewById(R.h.czP);
        apVar.yOw.yPe = (TextView) view.findViewById(R.h.czO);
        apVar.yOw.yPf = (TextView) view.findViewById(R.h.czD);
        apVar.yOw.yPg = view.findViewById(R.h.czF);
        apVar.yOw.yPh = (LinearLayout) view.findViewById(R.h.czQ);
        apVar.yOw.yPi = (TextView) view.findViewById(R.h.czS);
        apVar.yOw.yPk = (TextView) view.findViewById(R.h.czT);
        apVar.yOw.yPj = (TextView) view.findViewById(R.h.czU);
        apVar.yOw.yPl = (TextView) view.findViewById(R.h.czV);
        apVar.yOw.yPm = view.findViewById(R.h.czR);
        apVar.yOw.yPn = (LinearLayout) view.findViewById(R.h.czH);
        apVar.yOw.yPr = view.findViewById(R.h.czC);
        apVar.yOw.yPo = view.findViewById(R.h.bOP);
        apVar.yOw.yPp = (LinearLayout) view.findViewById(R.h.czA);
        apVar.yOw.yPq = (LinearLayout) view.findViewById(R.h.cda);
        apVar.yOw.yPs = (LinearLayout) view.findViewById(R.h.czq);
        apVar.yOw.yPv = (TextView) view.findViewById(R.h.czs);
        apVar.yOw.yPx = (ImageView) view.findViewById(R.h.czr);
        apVar.yOw.yPu = view.findViewById(R.h.czB);
        apVar.yOw.yPt = (LinearLayout) view.findViewById(R.h.czt);
        apVar.yOw.yPw = (TextView) view.findViewById(R.h.czv);
        apVar.yOw.yPy = (ImageView) view.findViewById(R.h.czu);
        apVar.yOw.yPz = (ImageView) view.findViewById(R.h.czn);
        apVar.yIY = (ImageView) view.findViewById(R.h.bUn);
        apVar.yOw.yPA = view.findViewById(R.h.czL);
        apVar.yOw.yPB = (ImageView) view.findViewById(R.h.czM);
        apVar.yOw.yPC = (TextView) view.findViewById(R.h.czN);
        view.setTag(apVar);
        return view;
    }

    protected final boolean cvx() {
        return false;
    }

    public final void a(b.a aVar, int i, ChattingUI$a chattingUI$a, au auVar, String str) {
        this.yqa = chattingUI$a;
        aVar = (ap) aVar;
        Map y = bi.y(auVar.field_content, "msg");
        if (y == null || y.size() == 0) {
            x.e("MicroMsg.ChattingItemDyeingTemplate", "filling fail, values is empty");
            aVar.yKM.setVisibility(8);
            return;
        }
        aVar.yKM.setVisibility(0);
        int i2 = bh.getInt((String) y.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
        this.yLD = bh.ou((String) y.get(".msg.appmsg.mmreader.template_header.template_msg_id"));
        this.yLE = bh.getInt((String) y.get(".msg.appmsg.mmreader.template_header.pay_style"), 0);
        com.tencent.mm.sdk.b.a.xef.c(this.ypS);
        chattingUI$a.b(this.yLB);
        String ou;
        String str2;
        String str3;
        View view;
        ar arVar;
        if (i2 != 0) {
            CharSequence charSequence;
            int paddingLeft;
            int i3;
            String ou2;
            Object obj;
            boolean z;
            int d;
            int d2;
            View inflate;
            ar arVar2;
            aVar.yOv.pBg.setVisibility(8);
            aw awVar = aVar.yOw;
            if (bh.getInt((String) y.get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0) == 1) {
                a(awVar, bh.ou((String) y.get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url")), bh.ou((String) y.get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name")), y, auVar, false);
            } else if (bh.getInt((String) y.get(".msg.appmsg.mmreader.template_header.show_icon_and_display_name"), 0) != 0) {
                a(awVar, bh.ou((String) y.get(".msg.appmsg.mmreader.template_header.icon_url")), bh.ou((String) y.get(".msg.appmsg.mmreader.template_header.display_name")), y, auVar, true);
            } else {
                ((View) awVar.yPa.getParent()).setVisibility(8);
                if ("notifymessage".equals(auVar.field_talker)) {
                    ou = bh.ou((String) y.get(".msg.fromusername"));
                    if (((com.tencent.mm.plugin.biz.a.a) g.h(com.tencent.mm.plugin.biz.a.a.class)).fV(ou)) {
                        WxaAttributes qK = ((com.tencent.mm.plugin.appbrand.m.b) g.h(com.tencent.mm.plugin.appbrand.m.b.class)).qK(ou);
                        a(awVar.yOX, this.yqa, ou, auVar, qK == null ? null : qK.field_brandIconURL);
                        charSequence = qK == null ? ou : qK.field_nickname;
                    } else {
                        a(awVar.yOX, this.yqa, ou, auVar, null);
                        charSequence = this.yqa.gu(ou);
                    }
                    awVar.yOY.setText(i.b(this.yqa.getContext(), charSequence, awVar.yOY.getTextSize()));
                    if (((com.tencent.mm.plugin.biz.a.a) g.h(com.tencent.mm.plugin.biz.a.a.class)).fV(ou)) {
                        awVar.yOW.setTag(new ar(auVar, ou));
                        awVar.yOW.setOnClickListener(this.yLz);
                    } else {
                        awVar.yOW.setTag(new ar(ou, this.yqa.ysk ? this.yqa.crz() : null));
                        awVar.yOW.setOnClickListener(u(this.yqa));
                    }
                    awVar.yOW.setVisibility(0);
                } else {
                    awVar.yOW.setVisibility(8);
                }
            }
            if (bh.getInt((String) y.get(".msg.appmsg.mmreader.template_header.hide_icon_and_display_name_line"), 0) != 0) {
                awVar.yOW.setBackgroundResource(R.g.bDJ);
            } else {
                paddingLeft = awVar.yOW.getPaddingLeft();
                awVar.yOW.setBackgroundResource(R.g.bDp);
                awVar.yOW.setPadding(paddingLeft, 0, 0, 0);
            }
            if (bh.getInt((String) y.get(".msg.appmsg.mmreader.template_header.ignore_hide_title_and_time"), 0) == 0) {
                i3 = bh.getInt((String) y.get(".msg.appmsg.mmreader.template_header.hide_title_and_time"), 0);
            } else {
                i3 = 0;
            }
            int i4 = bh.getInt((String) y.get(".msg.appmsg.mmreader.template_header.hide_title"), 0);
            int i5 = bh.getInt((String) y.get(".msg.appmsg.mmreader.template_header.hide_time"), 0);
            awVar.yPd.setVisibility(8);
            awVar.yPe.setVisibility(8);
            if (i3 == 0) {
                if (i4 == 0) {
                    awVar.yPd.setVisibility(0);
                    charSequence = bh.ou((String) y.get(".msg.appmsg.mmreader.template_header.title"));
                    awVar.yPd.setTextColor(d(y, ".msg.appmsg.mmreader.template_header.title_color", WebView.NIGHT_MODE_COLOR));
                    awVar.yPd.setText(charSequence);
                }
                if (i5 == 0) {
                    long j = bh.getLong(bh.ou((String) y.get(".msg.appmsg.mmreader.template_header.pub_time")), 0);
                    if (j > 0) {
                        awVar.yPe.setText(n.ag(this.yqa.getString(R.l.eix), j));
                        awVar.yPe.setVisibility(0);
                    } else {
                        awVar.yPe.setVisibility(8);
                    }
                }
            }
            charSequence = bh.ou((String) y.get(".msg.appmsg.mmreader.template_header.first_data"));
            i4 = d(y, ".msg.appmsg.mmreader.template_header.first_color", yLG);
            if (bh.ov(charSequence)) {
                awVar.yPf.setVisibility(8);
            } else {
                awVar.yPf.setTextColor(i4);
                awVar.yPf.setText(charSequence);
                awVar.yPf.setVisibility(0);
                if (i2 == 2) {
                    awVar.yPf.setPadding(0, this.yqa.getResources().getDimensionPixelOffset(R.f.bvv), 0, 0);
                } else {
                    awVar.yPf.setPadding(0, 0, 0, 0);
                }
            }
            if (i3 == 0 || !bh.ov(charSequence)) {
                awVar.yPg.setVisibility(0);
            } else {
                awVar.yPg.setVisibility(8);
            }
            if ("notifymessage".equals(auVar.field_talker)) {
                ou2 = bh.ou((String) y.get(".msg.fromusername"));
                boolean fV = ((com.tencent.mm.plugin.biz.a.a) g.h(com.tencent.mm.plugin.biz.a.a.class)).fV(ou2);
                if (fV) {
                    this.yqa.a(this.yLB);
                    com.tencent.mm.sdk.b.a.xef.b(this.ypS);
                    WxaAttributes qK2 = ((com.tencent.mm.plugin.appbrand.m.b) g.h(com.tencent.mm.plugin.appbrand.m.b.class)).qK(ou2);
                    if (qK2 != null) {
                        obj = (qK2.field_appOpt & 1) > 0 ? 1 : null;
                        this.mAppId = qK2.field_appId;
                        z = fV;
                    } else {
                        x.i("MicroMsg.ChattingItemDyeingTemplate", "try2HandleAppBrandLogic, sync attr username %s", new Object[]{ou2});
                        ((com.tencent.mm.plugin.appbrand.m.b) g.h(com.tencent.mm.plugin.appbrand.m.b.class)).a(ou2, new 15(this, awVar));
                    }
                }
                obj = null;
                z = fV;
            } else {
                z = false;
                obj = null;
            }
            awVar.yOZ.setVisibility(obj != null ? 0 : 8);
            awVar.yPb.setVisibility(z ? 0 : 8);
            awVar.yPb.setTag(R.h.czI, auVar);
            awVar.yPb.setTag(R.h.czp, awVar);
            awVar.yPb.setOnClickListener(this.yLx);
            awVar.yOV.setVisibility(8);
            awVar.yPf.setText(bh.ou((String) y.get(".msg.appmsg.mmreader.template_header.first_data")));
            str2 = (String) y.get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.word");
            str3 = (String) y.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.word");
            String str4 = (String) y.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.strikethrough_word");
            if (bh.ov(str3)) {
                awVar.yPh.setVisibility(8);
            } else {
                d = d(y, ".msg.appmsg.mmreader.template_detail.line_content.topline.key.color", WebView.NIGHT_MODE_COLOR);
                d2 = d(y, ".msg.appmsg.mmreader.template_detail.line_content.topline.value.color", WebView.NIGHT_MODE_COLOR);
                int d3 = d(y, ".msg.appmsg.mmreader.template_detail.line_content.topline.value.strikethrough_word_color", WebView.NIGHT_MODE_COLOR);
                i5 = bh.getInt((String) y.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.small_text_count"), 0);
                awVar.yPi.setTextColor(d);
                awVar.yPk.setTextColor(d2);
                awVar.yPl.setTextColor(d3);
                awVar.yPl.getPaint().setFlags(16);
                awVar.yPi.setText(str2);
                if (i5 <= 0 || i5 >= str3.length()) {
                    awVar.yPj.setTypeface(Typeface.DEFAULT);
                    awVar.yPj.setVisibility(8);
                    awVar.yPk.setTypeface(Typeface.DEFAULT);
                    awVar.yPk.setText(str3);
                } else {
                    awVar.yPj.setVisibility(0);
                    awVar.yPj.setText(str3.substring(0, i5));
                    awVar.yPj.setTextColor(d2);
                    awVar.yPj.setTypeface(((com.tencent.mm.pluginsdk.wallet.b) g.h(com.tencent.mm.pluginsdk.wallet.b.class)).de(this.yqa.getContext()));
                    awVar.yPk.setTypeface(((com.tencent.mm.pluginsdk.wallet.b) g.h(com.tencent.mm.pluginsdk.wallet.b.class)).de(this.yqa.getContext()));
                    awVar.yPk.setText(str3.substring(i5));
                }
                if (bh.ov(str4)) {
                    awVar.yPl.setVisibility(8);
                } else {
                    awVar.yPl.setText(str4);
                    awVar.yPl.setVisibility(0);
                }
                awVar.yPh.setVisibility(0);
            }
            int i6 = bh.getInt((String) y.get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
            if (i6 == 2) {
                x.i("MicroMsg.ChattingItemDyeingTemplate", "[fillingCustomView]");
                awVar.yPe.setVisibility(8);
                awVar.yPn.setVisibility(8);
                ViewGroup viewGroup = (ViewGroup) awVar.yPn.getParent();
                View findViewById = viewGroup.findViewById(R.h.cak);
                if (findViewById == null) {
                    inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.i.dqM, null);
                    ao aoVar = new ao();
                    aoVar.jMv = (ImageView) inflate.findViewById(R.h.bLC);
                    aoVar.yOu = (TextView) inflate.findViewById(R.h.cAl);
                    aoVar.nou = (TextView) inflate.findViewById(R.h.time);
                    aoVar.jpW = (TextView) inflate.findViewById(R.h.title);
                    inflate.setTag(aoVar);
                    viewGroup.addView(inflate);
                    view = inflate;
                } else {
                    view = findViewById;
                }
                view.setVisibility(0);
                ao aoVar2 = (ao) view.getTag();
                str3 = (String) y.get(".msg.appmsg.mmreader.category.item.schedule_content");
                str4 = (String) y.get(".msg.appmsg.mmreader.category.item.schedule_username");
                CharSequence charSequence2 = (String) y.get(".msg.appmsg.mmreader.category.item.schedule_nickname");
                String str5 = (String) y.get(".msg.appmsg.mmreader.category.item.schedule_time");
                d2 = bh.getInt((String) y.get(".msg.appmsg.mmreader.category.item.schedule_remindsubtype"), -1);
                aoVar2.jpW.setText(i.a(aoVar2.jpW.getContext(), str3));
                TextView textView = aoVar2.yOu;
                Context context = aoVar2.jpW.getContext();
                if (bh.ov(str4)) {
                    charSequence2 = "";
                } else {
                    str3 = null;
                    if (s.eV(str4)) {
                        ar.Hg();
                        com.tencent.mm.storage.x WO = com.tencent.mm.z.c.EY().WO(str4);
                        if (WO != null) {
                            str3 = WO.AQ() == null ? WO.AP() : WO.AQ();
                        }
                    } else {
                        ar.Hg();
                        com.tencent.mm.storage.x WO2 = com.tencent.mm.z.c.EY().WO(str4);
                        str3 = WO2.AQ() == null ? WO2.AP() : WO2.AQ();
                    }
                    if (bh.ov(str3)) {
                        x.i("MicroMsg.ChattingItemDyeingTemplate", "[getDisplayName] username:%s nickname:%s", new Object[]{str4, charSequence2});
                        if (charSequence2 == null) {
                            charSequence2 = ac.getContext().getString(R.l.dSN);
                        }
                    } else {
                        Object obj2 = str3;
                    }
                }
                textView.setText(i.a(context, charSequence2));
                aoVar2.nou.setText(str5);
                if (d2 == 2) {
                    aoVar2.jMv.setImageDrawable(ac.getContext().getResources().getDrawable(R.g.byU));
                } else {
                    com.tencent.mm.pluginsdk.ui.a.b.a(aoVar2.jMv, str4);
                }
            } else {
                List arrayList = new ArrayList();
                i4 = 0;
                d = 0;
                while (d < 100) {
                    ou2 = d == 0 ? ".msg.appmsg.mmreader.template_detail.line_content.lines.line" : ".msg.appmsg.mmreader.template_detail.line_content.lines.line" + d;
                    str2 = (String) y.get(ou2 + ".value.word");
                    str3 = (String) y.get(ou2 + ".key.word");
                    if (bh.ov(str2) && bh.ov(str3)) {
                        x.i("MicroMsg.ChattingItemDyeingTemplate", "fillingLines: lines count=%d", new Object[]{Integer.valueOf(d)});
                        break;
                    }
                    at atVar = new at();
                    atVar.yON = str2;
                    atVar.yOM = bh.ou(str3);
                    atVar.yOO = d(y, ou2 + ".key.color", yLF);
                    atVar.yOP = d(y, ou2 + ".value.color", WebView.NIGHT_MODE_COLOR);
                    atVar.yOQ = bh.getInt((String) y.get(new StringBuilder().append(ou2).append(".key.hide").toString()), 0) != 0;
                    paddingLeft = (Zs(atVar.yOM) + 1) / 2;
                    if (paddingLeft <= i4) {
                        paddingLeft = i4;
                    }
                    arrayList.add(atVar);
                    d++;
                    i4 = paddingLeft;
                }
                i5 = i4 > 8 ? 8 : i4;
                LinearLayout linearLayout = awVar.yPn;
                linearLayout.setVisibility(0);
                view = ((ViewGroup) awVar.yPn.getParent()).findViewById(R.h.cak);
                if (view != null) {
                    view.setVisibility(8);
                }
                if (linearLayout.getChildCount() > arrayList.size()) {
                    if (arrayList.size() == 0) {
                        linearLayout.removeAllViews();
                    } else {
                        linearLayout.removeViews(arrayList.size(), linearLayout.getChildCount() - arrayList.size());
                    }
                }
                int childCount = linearLayout.getChildCount();
                for (d = 0; d < arrayList.size(); d++) {
                    LinearLayout linearLayout2;
                    at atVar2 = (at) arrayList.get(d);
                    if (d < childCount) {
                        linearLayout2 = (LinearLayout) linearLayout.getChildAt(d);
                    } else {
                        linearLayout2 = (LinearLayout) LayoutInflater.from(this.yqa.getContext()).inflate(R.i.dcX, null, false);
                        au auVar2 = new au();
                        auVar2.yOR = (TextView) linearLayout2.findViewById(R.h.csV);
                        auVar2.yOS = (TextView) linearLayout2.findViewById(R.h.csW);
                        linearLayout2.setTag(auVar2);
                        linearLayout.addView(linearLayout2);
                    }
                    au auVar3 = (au) linearLayout2.getTag();
                    if (atVar2.yOQ) {
                        auVar3.yOR.setVisibility(8);
                    } else {
                        auVar3.yOR.setVisibility(0);
                        auVar3.yOR.setEms(i5);
                        auVar3.yOR.setTextColor(atVar2.yOO);
                        auVar3.yOR.setText(atVar2.yOM);
                    }
                    auVar3.yOS.setTextColor(atVar2.yOP);
                    auVar3.yOS.setText(atVar2.yON);
                }
                if (linearLayout.getChildCount() == 0) {
                    awVar.yPm.setVisibility(8);
                    linearLayout.setVisibility(8);
                } else {
                    if (bh.getInt((String) y.get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.hide_dash_line"), 0) != 0) {
                        awVar.yPm.setVisibility(8);
                    } else {
                        awVar.yPm.setVisibility(0);
                    }
                    linearLayout.setVisibility(0);
                }
            }
            if (bh.getInt((String) y.get(".msg.appmsg.mmreader.template_detail.opitems.show_type"), 0) != 0) {
                awVar.yPA.setVisibility(8);
                awVar.yPp.setVisibility(8);
                awVar.yPr.setVisibility(8);
                awVar.yPq.setVisibility(0);
                a(awVar, auVar, y);
            } else {
                String ou3;
                String str6;
                awVar.yPq.setVisibility(8);
                str2 = (String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.word");
                str3 = (String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.icon");
                if (bh.ov(str2)) {
                    awVar.yPs.setVisibility(8);
                } else {
                    awVar.yPv.setTextColor(d(y, ".msg.appmsg.mmreader.template_detail.opitems.opitem.color", WebView.NIGHT_MODE_COLOR));
                    awVar.yPv.setText(str2);
                    if (bh.ov(str3)) {
                        awVar.yPx.setVisibility(8);
                        awVar.yPv.setPadding(0, 0, 0, 0);
                    } else {
                        awVar.yPx.setVisibility(0);
                        h(awVar.yPx, str3);
                        awVar.yPv.setPadding(0, 0, com.tencent.mm.bv.a.fromDPToPix(this.yqa.getContext(), 16), 0);
                    }
                    str2 = (String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
                    ou3 = bh.ou((String) y.get(".msg.fromusername"));
                    i4 = bh.getInt((String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
                    str6 = (String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
                    arVar2 = new ar(auVar, ou3, str2);
                    awVar.yPs.setTag(arVar2);
                    awVar.yPA.setTag(arVar2);
                    if (i4 != 1 || TextUtils.isEmpty(str6)) {
                        final String str7 = ou3;
                        awVar.yPs.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ q yLH;

                            public final void onClick(View view) {
                                if (!bh.ov(str2)) {
                                    Intent intent = new Intent();
                                    intent.putExtra("rawUrl", str2);
                                    d.b(this.yLH.yqa.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                    com.tencent.mm.plugin.report.service.g.pQN.h(11608, new Object[]{this.yLH.yLD, str7, Integer.valueOf(1)});
                                }
                            }
                        });
                        awVar.yPA.setOnClickListener(null);
                    } else {
                        OnClickListener 16 = new 16(this, str6, bh.ou((String) y.get(".msg.appmsg.template_id")), bh.getInt((String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_state"), 0), bh.getInt((String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_version"), 0), (String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_path"), ou3);
                        awVar.yPs.setOnClickListener(16);
                        awVar.yPA.setOnClickListener(16);
                    }
                    awVar.yPs.setVisibility(0);
                }
                str2 = (String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.word");
                str4 = (String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.icon");
                if (bh.ov(str2)) {
                    awVar.yPt.setVisibility(8);
                } else {
                    awVar.yPw.setTextColor(d(y, ".msg.appmsg.mmreader.template_detail.opitems.opitem1.color", WebView.NIGHT_MODE_COLOR));
                    awVar.yPw.setText(str2);
                    if (bh.ov(str4)) {
                        awVar.yPy.setVisibility(8);
                        awVar.yPw.setPadding(0, 0, 0, 0);
                    } else {
                        awVar.yPy.setVisibility(0);
                        h(awVar.yPy, str4);
                        awVar.yPw.setPadding(0, 0, com.tencent.mm.bv.a.fromDPToPix(this.yqa.getContext(), 16), 0);
                    }
                    str2 = (String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.url");
                    ou3 = bh.ou((String) y.get(".msg.fromusername"));
                    i5 = bh.getInt((String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.op_type"), 0);
                    str6 = (String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_username");
                    awVar.yPt.setTag(new ar(auVar, ou3, str2));
                    if (i5 != 1 || TextUtils.isEmpty(str6)) {
                        awVar.yPt.setOnClickListener(new 4(this, str2, ou3));
                    } else {
                        awVar.yPt.setOnClickListener(new 3(this, str6, bh.ou((String) y.get(".msg.appmsg.template_id")), bh.getInt((String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_state"), 0), bh.getInt((String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_version"), 0), (String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_path"), ou3));
                    }
                    awVar.yPt.setVisibility(0);
                }
                awVar.yPz.setVisibility(8);
                if (awVar.yPs.getVisibility() == 8 && awVar.yPt.getVisibility() == 8) {
                    awVar.yPp.setVisibility(8);
                    awVar.yPo.setVisibility(8);
                    awVar.yPr.setVisibility(8);
                } else {
                    awVar.yPr.setVisibility(0);
                    paddingLeft = this.yqa.getResources().getDimensionPixelOffset(R.f.bvv);
                    if (awVar.yPs.getVisibility() == 0 && awVar.yPt.getVisibility() == 0) {
                        awVar.yPs.setGravity(17);
                        awVar.yPt.setGravity(17);
                        awVar.yPs.setPadding(paddingLeft, 0, paddingLeft, 0);
                        awVar.yPt.setPadding(paddingLeft, 0, paddingLeft, 0);
                    } else if (awVar.yPs.getVisibility() == 0) {
                        if (bh.ov(str3)) {
                            awVar.yPs.setGravity(19);
                            awVar.yPs.setPadding(paddingLeft, 0, 0, 0);
                            awVar.yPz.setVisibility(0);
                        } else {
                            awVar.yPs.setGravity(17);
                            awVar.yPs.setPadding(paddingLeft, 0, paddingLeft, 0);
                        }
                    } else if (bh.ov(str4)) {
                        awVar.yPt.setGravity(19);
                        awVar.yPt.setPadding(this.yqa.getResources().getDimensionPixelOffset(R.f.bvv), 0, 0, 0);
                        awVar.yPz.setVisibility(0);
                    } else {
                        awVar.yPt.setGravity(17);
                        awVar.yPt.setPadding(paddingLeft, 0, paddingLeft, 0);
                    }
                    awVar.yPp.setVisibility(0);
                    awVar.yPo.setVisibility(0);
                }
                if (awVar.yPs.getVisibility() == 0 && awVar.yPt.getVisibility() == 0) {
                    awVar.yPu.setVisibility(0);
                } else {
                    awVar.yPu.setVisibility(8);
                }
                str3 = bh.ou((String) y.get(".msg.fromusername"));
                i4 = bh.getInt((String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
                str2 = (String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
                if (!com.tencent.mm.storage.x.fV(str3) && awVar.yPs.getVisibility() != 8 && awVar.yPt.getVisibility() == 8 && i4 == 1 && com.tencent.mm.storage.x.fV(str2)) {
                    WxaAttributes qK3 = ((com.tencent.mm.plugin.appbrand.m.b) g.h(com.tencent.mm.plugin.appbrand.m.b.class)).qK(str2);
                    str4 = qK3 == null ? null : qK3.field_brandIconURL;
                    CharSequence charSequence3 = qK3 == null ? str2 : qK3.field_nickname;
                    o.PA().a(str4, awVar.yPB, this.xMy);
                    awVar.yPC.setText(charSequence3);
                    if (qK3 == null) {
                        ((com.tencent.mm.plugin.appbrand.m.b) g.h(com.tencent.mm.plugin.appbrand.m.b.class)).a(str2, new 5(this, awVar, str2));
                    }
                    awVar.yPA.setVisibility(0);
                    awVar.yPp.setVisibility(8);
                } else {
                    awVar.yPA.setVisibility(8);
                }
            }
            String ou4 = bh.ou((String) y.get(".msg.fromusername"));
            String str8 = null;
            if (!bh.ov(ou4)) {
                ar.Hg();
                str8 = com.tencent.mm.z.c.EY().WO(ou4).AP();
            }
            String str9 = (String) y.get(".msg.appmsg.mmreader.category.item.title");
            String str10 = (String) y.get(".msg.appmsg.mmreader.category.item.url");
            str2 = (String) y.get(".msg.appmsg.mmreader.category.item.native_url");
            str3 = (String) y.get(".msg.appmsg.template_id");
            str4 = (String) y.get(".msg.appmsg.mmreader.category.item.weapp_username");
            if (i6 == 1 && !TextUtils.isEmpty(str4)) {
                arVar = new ar(auVar, ou4, str10);
                arVar.position = i;
                awVar.yOU.setTag(arVar);
                awVar.yOU.setOnClickListener(this.lUQ);
            } else if (i6 == -1 && ((com.tencent.mm.plugin.biz.a.a) g.h(com.tencent.mm.plugin.biz.a.a.class)).fV(ou4)) {
                str4 = (String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
                View view2 = awVar.yOU;
                arVar2 = new ar(auVar, false, i, ou4, false, this.yqa.csX(), ou4, str8, str9);
                arVar2.fLC = str2;
                arVar2.yOJ = str4;
                view2.setTag(arVar2);
                awVar.yOU.setOnClickListener(this.yLA);
            } else if (i6 == 2) {
                arVar = new ar(auVar, ou4, str10);
                arVar.position = i;
                awVar.yOU.setTag(arVar);
                awVar.yOU.setOnClickListener(this.lUQ);
            } else {
                inflate = awVar.yOU;
                ar arVar3 = new ar(auVar, false, i, str10, false, this.yqa.csX(), ou4, str8, str9);
                arVar3.fLC = str2;
                inflate.setTag(arVar3);
                awVar.yOU.setOnClickListener(w(this.yqa));
            }
            awVar.yOU.setOnLongClickListener(s(this.yqa));
            if (com.tencent.mm.k.g.zZ().zM()) {
                aVar.yIY.setVisibility(0);
                c(this.yqa, aVar.yIY, new com.tencent.mm.ui.chatting.r.n(str3, auVar, str8));
            }
            if (((com.tencent.mm.plugin.biz.a.a) g.h(com.tencent.mm.plugin.biz.a.a.class)).fV(bh.ou((String) y.get(".msg.fromusername"))) && "notifymessage".equals(auVar.field_talker)) {
                x.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew handled by app brand");
                awVar.yPc.setTag(null);
                awVar.yPc.setVisibility(8);
            } else {
                if ((bh.getInt((String) y.get(".msg.appmsg.mmreader.template_header.show_complaint_button"), 0) == 1 ? 1 : null) == null) {
                    x.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew showMoreV false");
                } else if (awVar.yOW.getVisibility() == 0) {
                    awVar.yPb.setTag(auVar);
                    awVar.yPb.setOnClickListener(this.yLy);
                    awVar.yPb.setVisibility(0);
                    awVar.yPc.setVisibility(8);
                } else if (awVar.yPg.getVisibility() == 0) {
                    awVar.yPc.setTag(auVar);
                    awVar.yPc.setOnClickListener(this.yLy);
                    awVar.yPc.setVisibility(0);
                    awVar.yPb.setVisibility(8);
                }
                awVar.yPb.setTag(null);
                awVar.yPc.setTag(null);
                awVar.yPb.setVisibility(8);
                awVar.yPc.setVisibility(8);
            }
            aVar.yOw.yOU.setVisibility(0);
            return;
        }
        aVar.yOw.yOU.setVisibility(8);
        ou = bh.ou((String) y.get(".msg.fromusername"));
        int i7 = bh.getInt((String) y.get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0);
        x.i("MicroMsg.ChattingItemDyeingTemplate", "fillingOld extType=%d", new Object[]{Integer.valueOf(i7)});
        if (i7 == 1) {
            str3 = bh.ou((String) y.get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url"));
            a(aVar, i.b(this.yqa.getContext(), bh.ou((String) y.get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name")), aVar.qhg.getTextSize()));
            aVar.iip.setTag(null);
            aVar.iip.setOnClickListener(null);
            o.PA().a(str3, aVar.iip, this.xMy);
        } else {
            a(aVar, this.yqa, auVar, ou);
            a(aVar.iip, this.yqa, ou, auVar, null);
            if (((com.tencent.mm.plugin.biz.a.a) g.h(com.tencent.mm.plugin.biz.a.a.class)).fV(ou)) {
                aVar.yOv.yOx.setTag(new ar(auVar, ou));
                aVar.yOv.yOx.setOnClickListener(this.yLz);
            } else {
                aVar.yOv.yOx.setTag(new ar(ou, this.yqa.ysk ? this.yqa.crz() : null));
                aVar.yOv.yOx.setOnClickListener(u(this.yqa));
            }
        }
        x.d("MicroMsg.ChattingItemDyeingTemplate", "dyeing template talker(%s).", new Object[]{auVar.field_talker});
        if ("notifymessage".equals(auVar.field_talker) || i7 == 1) {
            aVar.yOv.yOx.setVisibility(0);
            aVar.yOv.jpW.setTextSize(0, (float) com.tencent.mm.bv.a.aa(aVar.yOv.jpW.getContext(), R.f.bvK));
        } else {
            aVar.yOv.yOx.setVisibility(8);
            aVar.yOv.jpW.setTextSize(0, (float) com.tencent.mm.bv.a.aa(aVar.yOv.jpW.getContext(), R.f.bum));
        }
        aVar.yOv.pBg.setVisibility(0);
        b ay = b.ay(y);
        aVar.yOv.jpW.setText(ay.title);
        aVar.yOv.nou.setText(n.ag(this.yqa.getString(R.l.eiw), ay.time));
        r.a(aVar.yOv.yOB, y);
        String str11 = null;
        if (!bh.ov(ou)) {
            ar.Hg();
            str11 = com.tencent.mm.z.c.EY().WO(ou).AP();
        }
        Object obj3 = !bh.ov(ay.url) ? 1 : null;
        str2 = (String) y.get(".msg.appmsg.mmreader.category.item.weapp_username");
        if (bh.getInt((String) y.get(".msg.appmsg.mmreader.category.item.template_op_type"), 0) != 1 || TextUtils.isEmpty(str2)) {
            view = aVar.yOv.pBg;
            ar arVar4 = new ar(auVar, false, i, ay.url, false, this.yqa.csX(), ou, str11, ay.title);
            arVar4.fLC = ay.fLC;
            view.setTag(arVar4);
            aVar.yOv.pBg.setOnClickListener(w(this.yqa));
        } else {
            arVar = new ar(auVar, ou, ay.url);
            arVar.position = i;
            aVar.yOv.pBg.setTag(arVar);
            aVar.yOv.pBg.setOnClickListener(this.lUQ);
            obj3 = 1;
        }
        aVar.yOv.pBg.setOnLongClickListener(s(this.yqa));
        if (obj3 == null) {
            aVar.yOv.yOC.setVisibility(8);
            aVar.yOv.yOA.setVisibility(8);
        } else {
            aVar.yOv.yOC.setVisibility(0);
            aVar.yOv.yOA.setVisibility(0);
        }
        if (com.tencent.mm.k.g.zZ().zM()) {
            aVar.yIY.setVisibility(0);
            c(this.yqa, aVar.yIY, new com.tencent.mm.ui.chatting.r.n(ay.hcc, auVar, str11));
        }
        aq aqVar = aVar.yOv;
        if ((bh.getInt((String) y.get(".msg.appmsg.mmreader.template_header.show_complaint_button"), 0) == 1 ? 1 : null) == null) {
            x.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew showMoreV false");
            aqVar.yOy.setTag(null);
            aqVar.yOz.setTag(null);
            aqVar.yOy.setVisibility(8);
            aqVar.yOz.setVisibility(8);
        } else if (aqVar.yOx.getVisibility() == 0) {
            aqVar.yOy.setTag(auVar);
            aqVar.yOy.setOnClickListener(this.yLy);
            aqVar.yOy.setVisibility(0);
            aqVar.yOz.setVisibility(8);
        } else {
            aqVar.yOz.setTag(auVar);
            aqVar.yOz.setOnClickListener(this.yLy);
            aqVar.yOz.setVisibility(0);
            aqVar.yOy.setVisibility(8);
        }
        aVar.yOv.pBg.setVisibility(0);
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        ar arVar = (ar) view.getTag();
        if (arVar == null) {
            return false;
        }
        int i = arVar.position;
        if (!this.yqa.csV()) {
            contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dRH));
        }
        return true;
    }

    protected final boolean cvz() {
        return this.yLE == 0;
    }

    public final boolean b(View view, ChattingUI$a chattingUI$a, au auVar) {
        return false;
    }

    public final boolean a(MenuItem menuItem, ChattingUI$a chattingUI$a, au auVar) {
        switch (menuItem.getItemId()) {
            case 100:
                Map y = bi.y(auVar.field_content, "msg");
                if (!(y == null || y.size() == 0)) {
                    if (((com.tencent.mm.plugin.biz.a.a) g.h(com.tencent.mm.plugin.biz.a.a.class)).fV(bh.ou((String) y.get(".msg.fromusername")))) {
                        A(7, this.mAppId, this.yLD);
                        break;
                    }
                }
                break;
        }
        return false;
    }

    protected final void a(b.a aVar, ChattingUI$a chattingUI$a, au auVar, String str) {
        if (str != null && aVar.qhg != null) {
            a(aVar, i.b(chattingUI$a.getContext(), chattingUI$a.gu(str), aVar.qhg.getTextSize()));
        }
    }

    private void a(ImageView imageView, ChattingUI$a chattingUI$a, String str, au auVar, String str2) {
        if (imageView != null) {
            if (s.hn(str)) {
                imageView.setVisibility(8);
                return;
            }
            imageView.setVisibility(0);
            if (((com.tencent.mm.plugin.biz.a.a) g.h(com.tencent.mm.plugin.biz.a.a.class)).fV(str)) {
                o.PA().a(str2, imageView, this.xMy);
                imageView.setTag(new ar(auVar, str));
                imageView.setOnClickListener(this.yLz);
            } else {
                String crz;
                Bitmap d = m.d(str, null, 0);
                if (d != null) {
                    imageView.setImageBitmap(d);
                } else {
                    imageView.setImageResource(R.g.bzZ);
                }
                if (chattingUI$a.ysk) {
                    crz = chattingUI$a.crz();
                } else {
                    crz = null;
                }
                imageView.setTag(new ar(str, crz));
                imageView.setOnClickListener(u(chattingUI$a));
            }
            imageView.setOnLongClickListener(v(chattingUI$a));
            imageView.setContentDescription(com.tencent.mm.z.r.gu(str) + chattingUI$a.getContext().getString(R.l.bLI));
        }
    }

    private void a(aw awVar, String str, String str2, Map<String, String> map, au auVar, boolean z) {
        awVar.yOY.setText(i.b(this.yqa.getContext(), str2, awVar.yOY.getTextSize()));
        o.PA().a(str, awVar.yOX, this.xMy);
        awVar.yOX.setTag(null);
        awVar.yOX.setOnClickListener(null);
        awVar.yOW.setTag(null);
        awVar.yOW.setOnClickListener(null);
        awVar.yOW.setVisibility(0);
        String ou = bh.ou((String) map.get(".msg.appmsg.mmreader.template_header.weapp_username"));
        String ou2 = bh.ou((String) map.get(".msg.appmsg.mmreader.template_header.header_jump_url"));
        if (bh.ov(ou) && bh.ov(ou2)) {
            awVar.yOW.setOnClickListener(null);
        } else {
            awVar.yOW.setTag(new ar(auVar, bh.ou((String) map.get(".msg.fromusername"))));
            awVar.yOW.setOnClickListener(this.yLC);
        }
        ou = bh.ou((String) map.get(".msg.appmsg.mmreader.template_header.shortcut_icon_url"));
        if (!z || bh.ov(ou)) {
            ((View) awVar.yPa.getParent()).setVisibility(8);
            return;
        }
        ((View) awVar.yPa.getParent()).setVisibility(0);
        o.PA().a(ou, awVar.yPa, this.xMy);
    }

    private void a(aw awVar, au auVar, Map<String, String> map) {
        LinearLayout linearLayout = awVar.yPq;
        int childCount = linearLayout.getChildCount();
        int i = 0;
        while (i < 10) {
            String str = i == 0 ? ".msg.appmsg.mmreader.template_detail.opitems.opitem" : ".msg.appmsg.mmreader.template_detail.opitems.opitem" + i;
            String str2 = (String) map.get(str + ".word");
            String str3 = (String) map.get(str + ".hint_word");
            if (bh.ov(str2)) {
                x.i("MicroMsg.ChattingItemDyeingTemplate", "fillingVerticalButtons: count=%d", new Object[]{Integer.valueOf(i)});
                int childCount2 = linearLayout.getChildCount();
                if (childCount2 <= i) {
                    return;
                }
                if (i == 0) {
                    linearLayout.removeAllViews();
                    return;
                } else {
                    linearLayout.removeViews(i, childCount2 - i);
                    return;
                }
            }
            LinearLayout linearLayout2;
            if (i < childCount) {
                linearLayout2 = (LinearLayout) linearLayout.getChildAt(i);
            } else {
                linearLayout2 = (LinearLayout) LayoutInflater.from(this.yqa.getContext()).inflate(R.i.dcW, null, false);
                a aVar = new a();
                aVar.jpW = (TextView) linearLayout2.findViewById(R.h.czz);
                aVar.jMv = (ImageView) linearLayout2.findViewById(R.h.czy);
                aVar.yIk = (LinearLayout) linearLayout2.findViewById(R.h.czw);
                aVar.xUr = (TextView) linearLayout2.findViewById(R.h.czx);
                linearLayout2.setTag(aVar);
                linearLayout.addView(linearLayout2);
            }
            a aVar2 = (a) linearLayout2.getTag();
            String str4 = (String) map.get(str + ".icon");
            aVar2.jpW.setTextColor(d(map, str + ".color", WebView.NIGHT_MODE_COLOR));
            aVar2.jpW.setText(str2);
            aVar2.xUr.setText(str3);
            if (bh.ov(str4)) {
                aVar2.jMv.setVisibility(8);
                aVar2.jpW.setPadding(0, 0, 0, 0);
            } else {
                aVar2.jMv.setVisibility(0);
                h(aVar2.jMv, str4);
                aVar2.jpW.setPadding(0, 0, com.tencent.mm.bv.a.fromDPToPix(this.yqa.getContext(), 28), 0);
            }
            str2 = (String) map.get(str + ".url");
            String ou = bh.ou((String) map.get(".msg.fromusername"));
            int i2 = bh.getInt((String) map.get(str + ".op_type"), 0);
            str4 = (String) map.get(str + ".weapp_username");
            aVar2.yIk.setTag(new ar(auVar, ou, str2));
            final int i3 = i + 1;
            if (i2 == 1 && !TextUtils.isEmpty(str4)) {
                String str5 = (String) map.get(str + ".weapp_path");
                aVar2.yIk.setOnClickListener(new 6(this, str4, bh.ou((String) map.get(".msg.appmsg.template_id")), bh.getInt((String) map.get(str + ".weapp_state"), 0), bh.getInt((String) map.get(str + ".weapp_version"), 0), str5, ou, i3));
            } else if (i2 == 2) {
                final Map<String, String> map2 = map;
                aVar2.yIk.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ q yLH;

                    public final void onClick(View view) {
                        if (i3 == 1) {
                            q.b(view.getContext(), (String) map2.get(".msg.appmsg.mmreader.category.item.schedule_username"), bh.getLong((String) map2.get(".msg.appmsg.mmreader.category.item.schedule_messvrid"), -1));
                            com.tencent.mm.plugin.report.service.g.pQN.a(795, 2, 1, false);
                            x.i("MicroMsg.ChattingItemDyeingTemplate", "[onClick] Remind! username:%s svrMsgId:%s", new Object[]{r0, Long.valueOf(r10)});
                        } else if (i3 == 2) {
                            d.a(view.getContext(), ".ui.AllRemindMsgUI", new Intent());
                        }
                    }
                });
            } else {
                aVar2.yIk.setOnClickListener(new 8(this, str2, ou, i3));
            }
            i++;
        }
    }

    private static void h(ImageView imageView, String str) {
        if (!bh.ov(str) && imageView != null) {
            c.a aVar = new c.a();
            ar.Hg();
            aVar.hDD = com.tencent.mm.z.c.Fj();
            aVar.hDA = true;
            aVar.hDX = true;
            o.PA().a(str, imageView, aVar.PK());
        }
    }

    private static void A(int i, String str, String str2) {
        x.d("MicroMsg.ChattingItemDyeingTemplate", "stev report(%s), eventId : %d, appId %s, templateId %s", new Object[]{Integer.valueOf(13796), Integer.valueOf(i), str, str2});
        com.tencent.mm.plugin.report.service.g.pQN.h(13796, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(0), Long.valueOf(bh.Wo())});
    }

    private static int d(Map<String, String> map, String str, int i) {
        if (!(map == null || bh.ov(str))) {
            try {
                i = Color.parseColor(bh.ou((String) map.get(str)));
            } catch (Exception e) {
            }
        }
        return i;
    }

    private static int Zs(String str) {
        int i = 0;
        if (bh.ov(str)) {
            return 0;
        }
        String str2 = "[Α-￥]";
        int i2 = 0;
        while (i < str.length()) {
            if (str.substring(i, i + 1).matches(str2)) {
                i2 += 2;
            } else {
                i2++;
            }
            i++;
        }
        return i2;
    }
}
