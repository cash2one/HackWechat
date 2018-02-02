package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ix;
import com.tencent.mm.g.a.ky;
import com.tencent.mm.g.a.m;
import com.tencent.mm.g.a.p;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.b;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.d;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.z.ar;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class AppBrandServiceChattingUI extends MMFragmentActivity {
    public a ypM;
    public af ypN = new af();

    @SuppressLint({"ValidFragment"})
    public static class a extends com.tencent.mm.ui.chatting.ChattingUI.a {
        private com.tencent.mm.ui.appbrand.a appBrandServiceActionSheet;
        private String appId;
        private int fromScene;
        private b iPm;
        private WxaExposedParams jLv;
        private String jiM;
        private String jiN;
        private String jiO;
        private boolean jiP;
        private int jiQ;
        private String mSceneId;
        private boolean ypQ;
        private String ypR = "";
        private c<ky> ypS;
        private final d ypT = new 1(this);
        private f ypU = new f(this) {
            final /* synthetic */ a ypW;

            {
                this.ypW = r1;
            }

            public final Object a(k kVar) {
                switch (kVar.type) {
                    case 1:
                    case 25:
                    case 30:
                    case 31:
                        return this.ypW.crz();
                    default:
                        return null;
                }
            }

            public final Object b(k kVar) {
                if (kVar.type != 45) {
                    return null;
                }
                String str = new String(Base64.decode(kVar.url, 0));
                String str2 = new String(Base64.decode(bh.az((String) kVar.A(String.class), ""), 0));
                x.d("MicroMsg.AppBrandServiceChattingUI", "appId:%s,path:%s", new Object[]{str, str2});
                if (this.ypW.fromScene == 2 && this.ypW.jLv.appId.equals(str)) {
                    x.i("MicroMsg.AppBrandServiceChattingUI", "onBackFromContact appId:%s path:%s", new Object[]{str, str2});
                    a.a(this.ypW, str2);
                    return Boolean.valueOf(true);
                }
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1081;
                ((com.tencent.mm.plugin.appbrand.m.c) g.h(com.tencent.mm.plugin.appbrand.m.c.class)).a(this.ypW.getContext(), null, str, 0, 0, str2, appBrandStatObject);
                return null;
            }
        };
        private com.tencent.mm.ui.appbrand.c ypV;

        static /* synthetic */ void a(a aVar, String str) {
            Intent intent = new Intent();
            intent.putExtra("keyOutPagePath", str);
            aVar.thisActivity().setResult(-1, intent);
            aVar.finish();
        }

        static /* synthetic */ void h(a aVar) {
            Bitmap a;
            com.tencent.mm.y.g.a aVar2 = new com.tencent.mm.y.g.a();
            aVar2.title = aVar.jiM;
            aVar2.type = 33;
            aVar2.hdx = aVar.jLv.username;
            aVar2.hdw = bh.ov(aVar.jiN) ? aVar.jLv.fCp : aVar.jiN;
            aVar2.hdy = aVar.jLv.appId;
            aVar2.hdE = aVar.jLv.iGK;
            aVar2.hdF = aVar.jLv.iGL;
            aVar2.hdA = aVar.jLv.iPL;
            aVar2.hdz = 2;
            aVar2.url = aVar.jLv.iPM;
            aVar2.hdG = aVar.jLv.iconUrl;
            aVar2.fGF = "wxapp_" + aVar.jLv.appId + aVar.jLv.fCp;
            aVar2.fGz = aVar.jLv.username;
            aVar2.fGA = aVar.jLv.fpL;
            byte[] bArr = new byte[0];
            if (aVar.jiQ == 4) {
                a = com.tencent.mm.modelappbrand.a.b.Jj().a(aVar.jiO, null);
            } else if (bh.ov(aVar.jiO)) {
                a = null;
            } else {
                a = com.tencent.mm.modelappbrand.a.b.Jj().a(aVar.jiO, null);
                if (a == null || a.isRecycled()) {
                    a = com.tencent.mm.sdk.platformtools.d.UN(aVar.jiO);
                    if (aVar.jiQ != 2) {
                        boolean deleteFile = com.tencent.mm.loader.stub.b.deleteFile(aVar.jiO);
                        x.v("MicroMsg.AppBrandServiceChattingUI", "decode thumb icon bitmap by path(%s), and deleted(%s) file.", new Object[]{aVar.jiO, Boolean.valueOf(deleteFile)});
                    }
                }
            }
            if (a == null || a.isRecycled()) {
                x.e("MicroMsg.AppBrandServiceChattingUI", "thumb image is null");
            } else {
                x.i("MicroMsg.AppBrandServiceChattingUI", "thumb image is not null ");
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                a.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                bArr = byteArrayOutputStream.toByteArray();
            }
            l.a(aVar2, aVar.getAppId(), aVar.jiM, aVar.fAh.field_username, null, bArr);
        }

        public a(byte b) {
            super(true);
        }

        public final void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.fromScene = getIntExtra("app_brand_chatting_from_scene", 1);
            String str = "app_brand_chatting_expose_params";
            Parcelable parcelable = null;
            if (this.isCurrentActivity && thisActivity() != null) {
                parcelable = thisActivity().getIntent().getParcelableExtra(str);
            }
            if (parcelable == null && getArguments() != null) {
                parcelable = super.getArguments().getParcelable(str);
            }
            this.jLv = (WxaExposedParams) parcelable;
            this.mSceneId = bh.ou(getStringExtra("key_scene_id"));
            this.jiM = getStringExtra("sendMessageTitle");
            this.jiN = getStringExtra("sendMessagePath");
            this.jiO = getStringExtra("sendMessageImg");
            this.jiP = getBooleanExtra("showMessageCard", false).booleanValue();
            this.jiQ = getIntExtra("isBitmapFrom", 1);
            x.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate fromScene:%d", new Object[]{Integer.valueOf(this.fromScene)});
            x.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate wxaExposedParams:%s", new Object[]{this.jLv});
            x.i("MicroMsg.AppBrandServiceChattingUI", "mSceneId:%s, sendMessageTitle:%s, sendMessagePath:%s, sendMessageImg:%s, showMessageCard:%b, isBitmapFrom:%d", new Object[]{this.mSceneId, this.jiM, this.jiN, this.jiO, Boolean.valueOf(this.jiP), Integer.valueOf(this.jiQ)});
        }

        public final void onResume() {
            super.onResume();
            i.a(this.ypU);
        }

        public final void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            if (this.fromScene == 2) {
                ar.CG().a(new com.tencent.mm.modelsimple.k(crz(), 19, getStringExtra("key_temp_session_from")), 0);
                x.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onActivityCreated NetSceneEnterTempSession");
            }
            this.ypS = new 3(this);
            com.tencent.mm.sdk.b.a.xef.b(this.ypS);
        }

        public final void cqW() {
            b bVar;
            boolean z;
            String str = null;
            super.cqW();
            this.ywe.csB().cbm();
            this.ywe.csB().cbu();
            this.ywe.csB().cbG();
            this.ywe.csB().cbJ();
            this.ywe.csB().cbz();
            this.ywe.csB().cbv();
            this.ywe.csB().cbx();
            this.ywe.csB().cby();
            this.ywe.csB().cbw();
            this.ywe.csB().cbz();
            this.ywe.csB().cbv();
            this.ywe.csB().cbI();
            this.ywe.csB().tj();
            this.ywe.csB().cbA();
            this.ywe.csB().cbB();
            this.ywe.csB().lj(true);
            this.ywe.csB().lk(true);
            this.ywe.csB().cbC();
            this.ywe.csB().cbD();
            this.ywe.csB().cbE();
            this.ywe.csB().cby();
            this.ywe.csB().cbF();
            this.ywe.csB().li(com.tencent.mm.bm.d.ccW());
            Object crz = crz();
            if (TextUtils.isEmpty(crz)) {
                bVar = null;
            } else {
                WxaAttributes qK = ((com.tencent.mm.plugin.appbrand.m.b) g.h(com.tencent.mm.plugin.appbrand.m.b.class)).qK(crz);
                if (qK != null) {
                    bVar = qK.acd();
                } else {
                    x.e("MicroMsg.AppBrandServiceHelper", "username:%s, attr is null or getWxaBizMenuByUsername return null", new Object[]{crz});
                    bVar = null;
                }
            }
            this.iPm = bVar;
            if (this.iPm != null && this.iPm.iPw.size() == 1) {
                this.ywe.csB().Cm(1);
                this.ywe.csB().a(this.ypT);
            } else if (this.iPm == null || this.iPm.iPw == null) {
                x.e("MicroMsg.AppBrandServiceChattingUI", "wxaBizMenu or wxaBizMenu.buttonList is empty");
            } else {
                x.e("MicroMsg.AppBrandServiceChattingUI", "wxaBizMenu.buttonList.size():%d", new Object[]{Integer.valueOf(this.iPm.iPw.size())});
            }
            WxaAttributes qK2 = ((com.tencent.mm.plugin.appbrand.m.b) g.h(com.tencent.mm.plugin.appbrand.m.b.class)).qK(this.fAh.field_username);
            if (qK2 == null || (qK2.field_appOpt & 2) <= 0) {
                z = false;
            } else {
                z = true;
            }
            this.ypQ = z;
            if (qK2 != null) {
                str = qK2.field_appId;
            }
            this.appId = str;
            if (this.ypQ) {
                Fz(0);
            } else {
                Fz(8);
            }
            if (this.fromScene == 2) {
                String appId = getAppId();
                str = this.fAh.field_username;
                int i = this.fromScene;
                ar.Hg();
                aj WY = com.tencent.mm.z.c.Fd().WY(str);
                if (WY == null) {
                    x.e("MicroMsg.AppBrandServiceChattingUI", "cvs:%s is null, error", new Object[]{str});
                } else {
                    int i2 = WY.field_unReadCount;
                    String ou = bh.ou(this.mSceneId);
                    x.d("MicroMsg.AppBrandServiceChattingUI", "stev report(%s), appId : %s, scene %s, unReadCount %d, sceneId %s", new Object[]{Integer.valueOf(13799), appId, Integer.valueOf(i), Integer.valueOf(i2), ou});
                    com.tencent.mm.plugin.report.service.g.pQN.h(13799, new Object[]{appId, Integer.valueOf(i), Integer.valueOf(i2), ou, Long.valueOf(bh.Wo())});
                }
            }
            this.appBrandServiceActionSheet = new com.tencent.mm.ui.appbrand.a(getContext());
        }

        private String getAppId() {
            if (bh.ov(this.appId)) {
                WxaAttributes qK = ((com.tencent.mm.plugin.appbrand.m.b) g.h(com.tencent.mm.plugin.appbrand.m.b.class)).qK(this.fAh.field_username);
                this.appId = qK == null ? null : qK.field_appId;
            }
            if (bh.ov(this.appId)) {
                x.e("MicroMsg.AppBrandServiceChattingUI", "error, appId is null");
            }
            return this.appId;
        }

        protected final void cqX() {
            super.cqX();
            setMMSubTitle(R.l.dEj);
            if (TextUtils.isEmpty(this.ypR)) {
                this.ypR = com.tencent.mm.ui.appbrand.b.YC(com.tencent.mm.ui.appbrand.b.YB(this.fAh.field_username));
            }
            if (TextUtils.isEmpty(this.ypR)) {
                setMMSubTitle(R.l.dEj);
            } else {
                setMMSubTitle(getResources().getString(R.l.dEj) + "-" + this.ypR);
            }
        }

        public final void cqY() {
            setMMTitle(this.fAh.field_nickname);
            if (this.ypQ) {
                Fz(0);
            } else {
                Fz(8);
            }
        }

        public final void cqZ() {
            addIconOptionMenu(0, R.l.dDZ, R.g.bDI, new s(this) {
                final /* synthetic */ a ypW;

                {
                    this.ypW = r1;
                }

                public final void bKg() {
                    int i;
                    boolean hideVKB = this.ypW.hideVKB();
                    Runnable 1 = new 1(this);
                    if (hideVKB) {
                        i = 100;
                    } else {
                        i = 0;
                    }
                    ag.h(1, (long) i);
                }
            });
            showOptionMenu(true);
        }

        protected final void cra() {
            super.cra();
            com.tencent.mm.sdk.b.b ixVar = new ix();
            ixVar.fzx.fzr = 0;
            ixVar.fzx.ael = w.cfi();
            if (com.tencent.mm.z.s.eV(crz())) {
                ixVar.fzx.fzz = true;
            } else {
                ixVar.fzx.fzz = false;
            }
            com.tencent.mm.sdk.b.a.xef.m(ixVar);
        }

        protected final boolean crb() {
            com.tencent.mm.sdk.b.b pVar;
            if (this.fromScene == 2) {
                ar.Hg();
                aj WY = com.tencent.mm.z.c.Fd().WY("appbrandcustomerservicemsg");
                if (WY == null || bh.ov(WY.field_username)) {
                    x.e("MicroMsg.AppBrandServiceChattingUI", "update Unread: can not find SPUSER_APP_BRAND_SERVICE cvs");
                } else {
                    int i = WY.field_unReadCount;
                    com.tencent.mm.sdk.b.b mVar = new m();
                    mVar.fnj.fnl = this.fAh.field_username;
                    com.tencent.mm.sdk.b.a.xef.m(mVar);
                    x.i("MicroMsg.AppBrandServiceChattingUI", "parUnReadCount:%d, unReadCount:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(mVar.fnk.fnm)});
                    WY.eO(Math.max(0, i - r2));
                    ar.Hg();
                    if (com.tencent.mm.z.c.Fd().a(WY, WY.field_username) == -1) {
                        x.e("MicroMsg.AppBrandServiceChattingUI", "update SPUSER_APP_BRAND_SERVICE cvs unread failed");
                    } else {
                        pVar = new p();
                        pVar.fnw.fnl = this.fAh.field_username;
                        pVar.fnw.fnm = 0;
                        com.tencent.mm.sdk.b.a.xef.m(pVar);
                    }
                }
            } else {
                x.i("MicroMsg.AppBrandServiceChattingUI", "writeOpLogAndMarkRead clear AppBrandKvData username:%s", new Object[]{this.fAh.field_username});
                pVar = new p();
                pVar.fnw.fnl = this.fAh.field_username;
                pVar.fnw.fnm = 0;
                com.tencent.mm.sdk.b.a.xef.m(pVar);
            }
            return super.crb();
        }

        public final void onViewAttachedToWindow(View view) {
            super.onViewAttachedToWindow(view);
            if (this.fromScene == 2 && this.jiP) {
                if (this.ypV == null) {
                    this.ypV = new com.tencent.mm.ui.appbrand.c(getActivity(), this.ywe.csB().getRootView(), this.ywe.csB(), !bh.ov(this.ywe.csB().cbs()));
                    this.ypV.vrv = false;
                }
                if (!bh.ov(this.jiO)) {
                    int Cp = (int) Cp(75);
                    int Cp2 = (int) Cp(60);
                    if (!(this.jiQ == 4 || this.jiO.startsWith("file://"))) {
                        this.jiO = "file://" + this.jiO;
                    }
                    com.tencent.mm.modelappbrand.a.b.Jj().a(this.ypV, this.jiO, null, ((com.tencent.mm.modelappbrand.g) g.h(com.tencent.mm.modelappbrand.g.class)).aZ(Cp, Cp2));
                }
                this.ypV.xVK = new com.tencent.mm.ui.appbrand.c.a(this) {
                    final /* synthetic */ a ypW;

                    {
                        this.ypW = r1;
                    }

                    public final void coD() {
                        this.ypW.hideVKB();
                        ar.Dm().F(new Runnable(this) {
                            final /* synthetic */ AnonymousClass6 ypZ;

                            {
                                this.ypZ = r1;
                            }

                            public final void run() {
                                a.h(this.ypZ.ypW);
                            }
                        });
                    }
                };
                com.tencent.mm.ui.appbrand.c cVar = this.ypV;
                x.d("MicroMsg.AppBrandServiceImageBubble", "show");
                ar.Dm().F(new Runnable(cVar) {
                    final /* synthetic */ c xVM;

                    {
                        this.xVM = r1;
                    }

                    public final void run() {
                        this.xVM.xVL.sendEmptyMessage(0);
                    }

                    public final String toString() {
                        return super.toString() + "MicroMsg.AppBrandServiceImageBubbleshow";
                    }
                });
            }
        }

        private float Cp(int i) {
            return TypedValue.applyDimension(1, (float) i, getContext().getResources().getDisplayMetrics());
        }

        public final void onPause() {
            super.onPause();
            i.b(this.ypU);
        }

        public final void onDestroy() {
            super.onDestroy();
            com.tencent.mm.sdk.b.a.xef.c(this.ypS);
        }
    }

    protected void onCreate(Bundle bundle) {
        getWindow().setFormat(-2);
        e.O(this);
        overridePendingTransition(0, 0);
        super.onCreate(null);
        if (getIntent().getStringExtra("Chat_User") == null) {
            finish();
            x.e("MicroMsg.AppBrandServiceChattingUI", "talker is null !!!");
            return;
        }
        setContentView(R.i.der);
        this.ypM = new a((byte) 0);
        Bundle extras = getIntent().getExtras();
        extras.putBoolean("FROM_APP_BRAND_CHATTING_ACTIVITY", true);
        this.ypM.setArguments(extras);
        getSupportFragmentManager().aS().a(R.h.cws, this.ypM).commit();
        getSupportActionBar().show();
        if (getIntent().getBooleanExtra("resend_fail_messages", false)) {
            ag.h(new Runnable(this) {
                final /* synthetic */ AppBrandServiceChattingUI ypO;

                {
                    this.ypO = r1;
                }

                public final void run() {
                    h.a(this.ypO, this.ypO.getString(R.l.eyT), "", this.ypO.getString(R.l.eyU), this.ypO.getString(R.l.dEn), new 1(this), new 2(this));
                }
            }, 500);
            getIntent().putExtra("is_need_resend_sns", false);
        }
        com.tencent.mm.permission.a.VZ().Wa();
        initNavigationSwipeBack();
        this.ypN.post(new 2(this));
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        x.d("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingUI dispatch key event %s", new Object[]{keyEvent});
        if (this.ypM == null || !this.ypM.onKeyDown(keyEvent.getKeyCode(), keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }
}
