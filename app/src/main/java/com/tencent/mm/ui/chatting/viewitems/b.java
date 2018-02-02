package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ag.a.j;
import com.tencent.mm.ag.g;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.y;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.a.cn;
import com.tencent.mm.g.a.gm;
import com.tencent.mm.g.a.nh;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.ui.chat.l$a;
import com.tencent.mm.pluginsdk.ui.chat.l$b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a.5;
import com.tencent.mm.ui.chatting.p;
import com.tencent.mm.ui.chatting.r$g;
import com.tencent.mm.ui.chatting.r$j;
import com.tencent.mm.ui.chatting.r$o;
import com.tencent.mm.ui.chatting.r.c;
import com.tencent.mm.ui.chatting.r.m;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.q;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;
import com.tencent.mm.z.t;

public abstract class b {
    private static long yDU = 0;
    private static boolean yIl = false;
    protected boolean vzn;
    private c yIm;
    private d yIn;
    private boolean yIo = false;
    protected com.tencent.mm.ui.chatting.r.b yIp;
    protected c yIq;
    protected r$o yIr;
    protected r$g yIs;
    protected r$j yIt;
    protected m yIu;
    private final long yIv = 120000;
    public boolean ypn;

    public static class a {
        public ImageView iip;
        public View jWc;
        public TextView ldK;
        public CheckBox mSc;
        public View mUL;
        public ProgressBar psA;
        public TextView qhg;
        public String yIA;
        public b yIB;
        public ViewStub yIw;
        public View yIx;
        public View yIy;
        public ImageView yIz;

        public final void ds(View view) {
            this.mUL = view;
            this.ldK = (TextView) view.findViewById(R.h.bVf);
            this.iip = (ImageView) view.findViewById(R.h.bTu);
            this.yIx = view.findViewById(R.h.bUh);
            this.yIy = view.findViewById(R.h.bTD);
            this.yIz = (ImageView) view.findViewById(R.h.bVb);
            this.yIw = (ViewStub) view.findViewById(R.h.bUX);
        }

        public final void mW(boolean z) {
            int i = z ? 0 : 8;
            if (!(this.mSc == null || this.mSc.getVisibility() == i)) {
                this.mSc.setVisibility(i);
            }
            if (this.jWc != null && this.jWc.getVisibility() != i) {
                this.jWc.setVisibility(i);
            }
        }

        public static void O(View view, int i) {
            if (view != null) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                layoutParams.width = i;
                view.setLayoutParams(layoutParams);
                view.requestLayout();
            }
        }
    }

    public static class d extends com.tencent.mm.ui.chatting.r.d {
        private b yIB;

        public d(com.tencent.mm.ui.chatting.ChattingUI.a aVar, b bVar) {
            super(aVar);
            this.yIB = bVar;
        }

        public void a(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            view.getTag();
            this.yIB.b(view, aVar, auVar);
        }
    }

    public abstract View a(LayoutInflater layoutInflater, View view);

    public abstract void a(a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str);

    public abstract boolean a(ContextMenu contextMenu, View view, au auVar);

    public abstract boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar);

    abstract boolean aXj();

    public abstract boolean aj(int i, boolean z);

    public abstract boolean b(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar);

    public static void q(ImageView imageView, String str) {
        if (bh.ov(str)) {
            imageView.setImageResource(R.g.bBB);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.a(imageView, str);
        }
    }

    public static int fO(Context context) {
        float eu = com.tencent.mm.bv.a.eu(context);
        if (eu == 0.875f) {
            return com.tencent.mm.bv.a.ab(context, R.f.bwV);
        }
        if (eu == 1.125f) {
            return com.tencent.mm.bv.a.ab(context, R.f.bwR);
        }
        if (eu == 1.25f) {
            return com.tencent.mm.bv.a.ab(context, R.f.bwW);
        }
        if (eu == 1.375f) {
            return com.tencent.mm.bv.a.ab(context, R.f.bwM);
        }
        if (eu == 1.625f || eu == 1.875f || eu == 2.025f) {
            return com.tencent.mm.bv.a.ab(context, R.f.bwN);
        }
        return com.tencent.mm.bv.a.ab(context, R.f.bwU);
    }

    public static int fP(Context context) {
        float eu = com.tencent.mm.bv.a.eu(context);
        if (!(eu == 0.875f || eu == 1.125f)) {
            if (eu == 1.25f) {
                return com.tencent.mm.bv.a.ab(context, R.f.bwL);
            }
            if (eu == 1.375f) {
                return com.tencent.mm.bv.a.ab(context, R.f.bwJ);
            }
            if (eu == 1.625f || eu == 1.875f || eu == 2.025f) {
                return com.tencent.mm.bv.a.ab(context, R.f.bwN);
            }
        }
        return com.tencent.mm.bv.a.ab(context, R.f.bwK);
    }

    public static void r(ImageView imageView, String str) {
        if (bh.ov(str)) {
            imageView.setImageResource(R.g.bzZ);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.o(imageView, str);
        }
    }

    public final void a(a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar) {
        long j = yDU + 30000;
        long currentTimeMillis = System.currentTimeMillis();
        yDU = currentTimeMillis;
        if (j < currentTimeMillis) {
            ar.Hg();
            yIl = com.tencent.mm.z.c.isSDCardAvailable();
        }
        this.vzn = yIl;
        String str = null;
        if (cvx()) {
            str = a(aVar2, auVar);
            a(aVar, aVar2, auVar, str);
            a(aVar, aVar2, str, auVar);
        }
        a(aVar, i, aVar2, auVar, str);
    }

    protected boolean cvx() {
        return true;
    }

    protected void a(a aVar, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
        if (str != null && aVar.qhg != null && auVar != null) {
            CharSequence charSequence = null;
            if (auVar.field_isSend == 0 && !bh.ov(auVar.gjN)) {
                g kb = y.Me().kb(auVar.gjN);
                Object obj = 1;
                if (kb == null || bh.ov(kb.field_openId) || bh.ov(kb.field_nickname)) {
                    x.i("MicroMsg.ChattingItem", "fillingUsername:need getKfInfo");
                } else {
                    charSequence = kb.field_nickname;
                    obj = null;
                }
                if (obj != null || i.a(kb)) {
                    y.Mg().a(new b(aVar2.ysf, auVar.gjN));
                    y.Mg().af(aVar2.ysf.talker, auVar.gjN);
                }
            } else if (r(aVar2) && aVar2.ywc.ctm()) {
                charSequence = aVar2.ywd.yyK ? com.tencent.mm.pluginsdk.ui.d.i.b(aVar2.getContext(), aVar2.gu(auVar.field_bizChatUserId), aVar.qhg.getTextSize()) : com.tencent.mm.pluginsdk.ui.d.i.b(aVar2.getContext(), aVar2.gu(str), aVar.qhg.getTextSize());
            }
            a(aVar, charSequence);
        }
    }

    protected boolean r(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
        if (aXj()) {
            return false;
        }
        if (aVar.ysk || aVar.ywd.vnK) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public String a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
        if (aXj()) {
            return aVar.ysf.hlJ;
        }
        String str = aVar.ysf.talker;
        if (!r(aVar)) {
            return str;
        }
        String hP;
        if (aVar.ysk) {
            hP = ba.hP(auVar.field_content);
            if (str != null) {
                if (hP != null) {
                }
            }
            hP = str;
        } else {
            if (auVar != null) {
                hP = auVar.field_bizChatUserId;
            }
            hP = str;
        }
        return hP;
    }

    protected static String b(com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
        String str = auVar.field_talker;
        if (!aVar.ywd.vnK || aVar.ywd.ync == null) {
            return str;
        }
        return aVar.ywd.ync.field_bizChatServId;
    }

    public static String a(au auVar, boolean z, boolean z2) {
        String str = null;
        if (auVar == null) {
            return null;
        }
        if (auVar.field_isSend == 1) {
            return q.FS();
        }
        if (z) {
            str = ba.hP(auVar.field_content);
        } else if (z2) {
            str = auVar.field_bizChatUserId;
        }
        if (bh.ov(str)) {
            return auVar.field_talker;
        }
        return str;
    }

    protected static void a(a aVar, CharSequence charSequence) {
        if (aVar != null && aVar.qhg != null) {
            if (charSequence == null) {
                aVar.qhg.setVisibility(8);
                return;
            }
            aVar.qhg.setText(charSequence);
            aVar.qhg.setVisibility(0);
        }
    }

    protected final c s(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
        if (this.yIm == null) {
            this.yIm = new c(this, aVar);
        }
        return this.yIm;
    }

    protected final d t(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
        if (this.yIn == null) {
            if (aVar instanceof com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a) {
                com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a aVar2 = (com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a) aVar;
                this.yIn = new 5(aVar2, aVar2, this);
            } else {
                this.yIn = new d(aVar, this);
            }
        }
        return this.yIn;
    }

    protected final com.tencent.mm.ui.chatting.r.b u(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
        if (this.yIp == null) {
            this.yIp = new com.tencent.mm.ui.chatting.r.b(aVar);
        }
        return this.yIp;
    }

    protected final c v(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
        if (this.yIq == null) {
            this.yIq = new c(aVar);
        }
        return this.yIq;
    }

    protected final r$o w(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
        if (this.yIr == null) {
            this.yIr = new r$o(aVar);
        }
        return this.yIr;
    }

    protected final r$j x(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
        if (this.yIt == null) {
            this.yIt = new r$j(aVar);
        }
        return this.yIt;
    }

    protected final void a(a aVar, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, String str, au auVar) {
        String str2 = null;
        if (aVar.iip != null) {
            if (!s.hn(str) || str.equals(s.hfr[0])) {
                Object obj;
                ar arVar;
                if (auVar != null && !bh.ov(auVar.gjN)) {
                    if (aVar2.ysk) {
                        str2 = aVar2.crz();
                    }
                    arVar = new ar(str, str2);
                    arVar.yOH = auVar.gjN;
                    com.tencent.mm.pluginsdk.ui.a.b.g(aVar.iip, auVar.gjN, R.g.bzD);
                    obj = arVar;
                } else if (auVar == null || !aVar2.ywd.vnK) {
                    if (aVar2.ysk) {
                        str2 = aVar2.crz();
                    }
                    arVar = new ar(str, str2);
                    q(aVar.iip, str);
                    r0 = arVar;
                } else {
                    arVar = new ar(auVar.field_bizChatUserId, null);
                    com.tencent.mm.aq.a.a PA = o.PA();
                    com.tencent.mm.ui.chatting.b.c cVar = aVar2.ywd;
                    j kk = cVar.ync.kk(auVar.field_bizChatUserId);
                    if (kk != null) {
                        str2 = kk.field_headImageUrl;
                    }
                    PA.a(str2, aVar.iip, aVar2.ysf.lcT);
                    r0 = arVar;
                }
                aVar.iip.setVisibility(0);
                aVar.iip.setTag(obj);
                if (!this.yIo) {
                    this.yIo = true;
                    if (!(aVar2 instanceof com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a)) {
                        if (auVar == null || bh.ov(auVar.gjN)) {
                            this.yIp = new com.tencent.mm.ui.chatting.r.b(aVar2);
                            this.yIq = new c(aVar2);
                        } else {
                            this.yIp = new com.tencent.mm.ui.chatting.r.a(aVar2);
                        }
                        aVar.iip.setOnClickListener(this.yIp);
                        aVar.iip.setOnLongClickListener(this.yIq);
                    }
                }
                p.dn(aVar.iip);
                aVar.iip.setContentDescription(r.gu(str) + aVar2.getContext().getString(R.l.bLI));
                if (aVar.yIw == null) {
                    return;
                }
                if (auVar == null || auVar.gjF == null || !auVar.gjF.contains("watch_msg_source_type")) {
                    aVar.yIw.setVisibility(8);
                    return;
                }
                int intValue;
                try {
                    intValue = Integer.valueOf((String) bi.y(auVar.gjF, "msgsource").get(".msgsource.watch_msg_source_type")).intValue();
                } catch (Exception e) {
                    intValue = 0;
                }
                if (intValue <= 0 || intValue > 4) {
                    aVar.yIw.setVisibility(8);
                    return;
                } else {
                    aVar.yIw.setVisibility(0);
                    return;
                }
            }
            aVar.iip.setVisibility(8);
        }
    }

    protected static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, View view, String str) {
        if (com.tencent.mm.pluginsdk.model.app.g.RB(str)) {
            Object com_tencent_mm_pluginsdk_ui_chat_l_b = new l$b();
            com_tencent_mm_pluginsdk_ui_chat_l_b.appId = str;
            com_tencent_mm_pluginsdk_ui_chat_l_b.fEL = "message";
            a(aVar, view, com_tencent_mm_pluginsdk_ui_chat_l_b);
            return;
        }
        view.setTag(new l$b());
    }

    protected static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, View view, au auVar, com.tencent.mm.y.g.a aVar2, String str, long j) {
        if (com.tencent.mm.pluginsdk.model.app.g.RB(aVar2.appId)) {
            int i = aVar.ypn ? 2 : 1;
            Object com_tencent_mm_pluginsdk_ui_chat_l_a = new l$a();
            com_tencent_mm_pluginsdk_ui_chat_l_a.appId = aVar2.appId;
            com_tencent_mm_pluginsdk_ui_chat_l_a.fEL = "message";
            com_tencent_mm_pluginsdk_ui_chat_l_a.ffw = str;
            com_tencent_mm_pluginsdk_ui_chat_l_a.fFh = c(aVar, auVar);
            com_tencent_mm_pluginsdk_ui_chat_l_a.vrA = aVar2.type;
            com_tencent_mm_pluginsdk_ui_chat_l_a.scene = i;
            com_tencent_mm_pluginsdk_ui_chat_l_a.vrB = aVar2.mediaTagName;
            com_tencent_mm_pluginsdk_ui_chat_l_a.fFo = j;
            a(aVar, view, com_tencent_mm_pluginsdk_ui_chat_l_a);
            return;
        }
        view.setTag(new l$b());
    }

    private static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, View view, Object obj) {
        view.setTag(obj);
        view.setOnClickListener(aVar.ysf.ysY);
    }

    protected static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, ImageView imageView, String str) {
        Bitmap b = com.tencent.mm.pluginsdk.model.app.g.b(str, 2, com.tencent.mm.bv.a.getDensity(aVar.getContext()));
        if (b == null || b.isRecycled()) {
            a(aVar, imageView, BitmapFactory.decodeResource(aVar.getResources(), R.g.bEm));
        } else {
            a(aVar, imageView, b);
        }
    }

    private static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, ImageView imageView, Bitmap bitmap) {
        Drawable bitmapDrawable = new BitmapDrawable(bitmap);
        int dimension = (int) aVar.getResources().getDimension(R.f.bvW);
        bitmapDrawable.setBounds(0, 0, dimension, dimension);
        imageView.setImageDrawable(bitmapDrawable);
    }

    protected static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, TextView textView, String str) {
        Bitmap b = com.tencent.mm.pluginsdk.model.app.g.b(str, 2, com.tencent.mm.bv.a.getDensity(aVar.getContext()));
        if (b == null || b.isRecycled()) {
            a(aVar, textView, BitmapFactory.decodeResource(aVar.getResources(), R.g.bEm));
        } else {
            a(aVar, textView, b);
        }
    }

    private static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, TextView textView, Bitmap bitmap) {
        Drawable bitmapDrawable = new BitmapDrawable(bitmap);
        int dimension = (int) aVar.getResources().getDimension(R.f.bvW);
        bitmapDrawable.setBounds(0, 0, dimension, dimension);
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
    }

    protected final void b(com.tencent.mm.ui.chatting.ChattingUI.a aVar, View view, Object obj) {
        view.setTag(obj);
        if (this.yIs == null) {
            this.yIs = new r$g(aVar);
        }
        view.setOnClickListener(this.yIs);
    }

    protected static void c(com.tencent.mm.ui.chatting.ChattingUI.a aVar, View view, Object obj) {
        view.setTag(obj);
        view.setOnClickListener(aVar.ysf.ytc);
    }

    public final boolean a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, com.tencent.mm.y.g.a aVar2, au auVar) {
        if (bh.ov(aVar2.hdo)) {
            return false;
        }
        com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.a.yoP, auVar, aVar2.hdv, aVar2.hdu);
        String str = auVar.field_imgPath;
        Intent intent = new Intent();
        intent.putExtra("IsAd", false);
        intent.putExtra("KStremVideoUrl", aVar2.hdo);
        intent.putExtra("KThumUrl", aVar2.hdt);
        intent.putExtra("KThumbPath", str);
        intent.putExtra("KSta_StremVideoAduxInfo", aVar2.hdu);
        intent.putExtra("KSta_StremVideoPublishId", aVar2.hdv);
        intent.putExtra("KSta_SourceType", 2);
        intent.putExtra("KSta_Scene", aVar.ysk ? com.tencent.mm.ui.chatting.a.b.yoY.value : com.tencent.mm.ui.chatting.a.b.yoX.value);
        intent.putExtra("KSta_FromUserName", a(aVar, auVar));
        intent.putExtra("KSta_ChatName", aVar.crz());
        intent.putExtra("KSta_MsgId", auVar.field_msgSvrId);
        intent.putExtra("KSta_SnsStatExtStr", aVar2.fGG);
        if (aVar.ysk) {
            intent.putExtra("KSta_ChatroomMembercount", com.tencent.mm.z.m.gl(aVar.crz()));
        }
        intent.putExtra("KMediaId", "fakeid_" + auVar.field_msgId);
        intent.putExtra("KMediaVideoTime", aVar2.hdp);
        intent.putExtra("StremWebUrl", aVar2.hds);
        intent.putExtra("StreamWording", aVar2.hdr);
        intent.putExtra("KMediaTitle", aVar2.title);
        com.tencent.mm.bm.d.b(aVar.getContext(), "sns", ".ui.VideoAdPlayerUI", intent);
        return true;
    }

    protected final void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, String str, String str2, String str3, int i, String str4, boolean z, long j, long j2, au auVar) {
        if ((str == null || str.length() == 0) && (str2 == null || str2.length() == 0)) {
            x.e("MicroMsg.ChattingItem", "url, lowUrl both are empty");
            return;
        }
        if (an.isMobile(aVar.getContext()) ? str2 != null && str2.length() > 0 : str == null || str.length() <= 0) {
            str = str2;
        }
        Intent intent = new Intent();
        intent.putExtra("msg_id", j);
        intent.putExtra("rawUrl", str);
        intent.putExtra("version_name", str3);
        intent.putExtra("version_code", i);
        intent.putExtra("usePlugin", z);
        intent.putExtra("geta8key_username", aVar.crz());
        intent.putExtra("KPublisherId", "msg_" + Long.toString(j2));
        intent.putExtra("KAppId", str4);
        intent.putExtra("pre_username", a(aVar, auVar));
        intent.putExtra("prePublishId", "msg_" + Long.toString(j2));
        if (auVar != null) {
            intent.putExtra("preUsername", a(aVar, auVar));
        }
        intent.putExtra("preChatName", aVar.crz());
        intent.putExtra("preChatTYPE", t.N(a(aVar, auVar), aVar.crz()));
        intent.putExtra("preMsgIndex", 0);
        com.tencent.mm.bm.d.b(aVar.getContext(), "webview", ".ui.tools.WebViewUI", intent);
    }

    protected static boolean cz(String str) {
        return com.tencent.mm.pluginsdk.model.app.g.cz(str);
    }

    protected static PackageInfo getPackageInfo(Context context, String str) {
        String str2;
        PackageInfo packageInfo = null;
        if (str == null || str.length() == 0) {
            str2 = packageInfo;
        } else {
            f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(str, true);
            if (aZ == null) {
                Object obj = packageInfo;
            } else {
                str2 = aZ.field_packageName;
            }
        }
        if (str2 != null) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ChattingItem", e, "", new Object[0]);
            }
        }
        return packageInfo;
    }

    protected final void a(int i, a aVar, au auVar, String str, boolean z, com.tencent.mm.ui.chatting.ChattingUI.a aVar2) {
        if (auVar.field_isSend == 1) {
            int i2;
            aVar.yIz.setTag(new ar(auVar, z, i, str, (byte) 0));
            ImageView imageView = aVar.yIz;
            if (this.yIu == null) {
                this.yIu = new m(aVar2);
            }
            imageView.setOnClickListener(this.yIu);
            switch (auVar.field_status) {
                case 1:
                case 2:
                case 3:
                case 4:
                    i2 = -1;
                    break;
                case 5:
                    i2 = R.g.bGv;
                    break;
                default:
                    x.e("MicroMsg.ChattingItem", "getMsgStateResId: not found this state");
                    i2 = -1;
                    break;
            }
            if (i2 != -1) {
                aVar.yIz.setImageResource(i2);
                aVar.yIz.setVisibility(0);
                aVar.yIz.setContentDescription(ac.getContext().getString(R.l.evJ));
                if (aVar.psA != null) {
                    aVar.psA.setVisibility(8);
                    return;
                }
                return;
            }
            aVar.yIz.setVisibility(8);
        }
    }

    public static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, com.tencent.mm.y.g.a aVar2, String str, f fVar, long j) {
        int i = aVar.ypn ? 2 : 1;
        int i2 = (fVar == null || !com.tencent.mm.pluginsdk.model.app.p.m(aVar.getContext(), fVar.field_packageName)) ? 6 : 3;
        if (aVar2.type == 2) {
            i2 = 4;
        } else if (aVar2.type == 5) {
            i2 = 1;
        }
        com.tencent.mm.sdk.b.b nhVar = new nh();
        nhVar.fFl.context = aVar.getContext();
        nhVar.fFl.scene = i;
        nhVar.fFl.fFm = aVar2.appId;
        nhVar.fFl.packageName = fVar == null ? null : fVar.field_packageName;
        nhVar.fFl.msgType = aVar2.type;
        nhVar.fFl.fzO = str;
        nhVar.fFl.fFn = i2;
        nhVar.fFl.mediaTagName = aVar2.mediaTagName;
        nhVar.fFl.fFo = j;
        nhVar.fFl.fFp = "";
        com.tencent.mm.sdk.b.a.xef.m(nhVar);
    }

    protected static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, com.tencent.mm.y.g.a aVar2, au auVar, f fVar) {
        com.tencent.mm.pluginsdk.q.j jVar = com.tencent.mm.pluginsdk.q.a.vcu;
        if (jVar != null) {
            int i = aVar.ysk ? 2 : 1;
            jVar.a(aVar.getContext(), aVar2.appId, fVar == null ? null : fVar.field_packageName, c(aVar, auVar), aVar2.type, aVar2.mediaTagName, i);
        }
    }

    protected static void b(com.tencent.mm.ui.chatting.ChattingUI.a aVar, com.tencent.mm.y.g.a aVar2, au auVar) {
        com.tencent.mm.pluginsdk.q.j jVar = com.tencent.mm.pluginsdk.q.a.vcu;
        if (jVar != null) {
            int i = aVar.ysk ? 2 : 1;
            String c = c(aVar, auVar);
            aVar.getContext();
            jVar.a(aVar2.appId, c, aVar2.type, i, aVar2.mediaTagName, auVar.field_msgSvrId);
        }
    }

    protected static boolean a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, f fVar) {
        com.tencent.mm.pluginsdk.q.j jVar = com.tencent.mm.pluginsdk.q.a.vcu;
        if (com.tencent.mm.pluginsdk.model.app.g.a(aVar.getContext(), fVar) || jVar == null) {
            return false;
        }
        if (!bh.ov(fVar.fQK)) {
            x.i("MicroMsg.ChattingItem", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", fVar.fQK, Boolean.valueOf(com.tencent.mm.pluginsdk.model.app.q.aY(aVar.getContext(), fVar.fQK)));
            if (com.tencent.mm.pluginsdk.model.app.q.aY(aVar.getContext(), fVar.fQK)) {
                return true;
            }
        }
        int i = aVar.ypn ? 2 : 1;
        com.tencent.mm.sdk.b.b gmVar = new gm();
        gmVar.fwC.actionCode = 2;
        gmVar.fwC.scene = i;
        gmVar.fwC.appId = fVar.field_appId;
        gmVar.fwC.context = aVar.getContext();
        com.tencent.mm.sdk.b.a.xef.m(gmVar);
        aVar.getContext();
        jVar.I(fVar.field_appId, i, i);
        return true;
    }

    public static String c(com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
        String crz = aVar.crz();
        if (s.eV(crz)) {
            return ba.hP(auVar.field_content);
        }
        return crz;
    }

    public static void a(au auVar, EmojiInfo emojiInfo) {
        com.tencent.mm.sdk.b.b cnVar = new cn();
        cnVar.fqL.fqM = emojiInfo;
        cnVar.fqL.fqM.talker = auVar != null ? auVar.field_talker : null;
        cnVar.fqL.scene = 0;
        com.tencent.mm.sdk.b.a.xef.m(cnVar);
    }

    protected static boolean a(au auVar, com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
        if (System.currentTimeMillis() - auVar.field_createTime > 120000) {
            int i = 1;
        } else {
            boolean z = false;
        }
        if (i != 0) {
            return false;
        }
        if (aVar != null && aVar.ysf.talker.equals(aVar.ysf.hlJ) && auVar.field_status == 2) {
            return false;
        }
        x.d("MicroMsg.ChattingItem", "[oneliang][isRevokeMsgEnable] enable:%d", Integer.valueOf(com.tencent.mm.k.g.zY().getInt("ShowRevokeMsgEntry", 1)));
        if (1 == com.tencent.mm.k.g.zY().getInt("ShowRevokeMsgEntry", 1)) {
            return true;
        }
        return false;
    }

    protected static boolean Zq(String str) {
        return !(s.gR(str) || s.hg(str) || s.gF(str) || s.ho(str)) || s.eV(str);
    }

    protected static boolean cvy() {
        String value = com.tencent.mm.k.g.zY().getValue("ShowSendOK");
        if (1 == (bh.ov(value) ? 0 : bh.VI(value))) {
            return true;
        }
        return false;
    }

    protected static boolean a(com.tencent.mm.ui.chatting.q qVar, long j) {
        if (j > 0) {
            if (qVar.ytq == -1) {
                qVar.ytq = 0;
                Cursor cursor = qVar.getCursor();
                int position = cursor.getPosition();
                int count = cursor.getCount();
                x.i("MicroMsg.ChattingListAdapter", "curPos %d, curCount %d", Integer.valueOf(position), Integer.valueOf(count));
                if (cursor.moveToLast()) {
                    do {
                        qVar.ytv = null;
                        qVar.ytv = com.tencent.mm.ui.chatting.q.a(qVar.ytv, cursor);
                        if (qVar.ytv.field_isSend == 1) {
                            if ((qVar.ytv.gjE & 4) != 4) {
                                qVar.ytq = qVar.ytv.field_msgId;
                            }
                        }
                    } while (cursor.moveToPrevious());
                }
                if (count < 0) {
                    if (count > 0) {
                        cursor.moveToPosition(0);
                    }
                } else if (position < count) {
                    cursor.moveToPosition(position);
                } else if (count > 0) {
                    cursor.moveToPosition(count - 1);
                }
            }
            if (qVar.ytq == j) {
                return true;
            }
        }
        return false;
    }

    protected boolean cvz() {
        return true;
    }
}
