package com.tencent.mm.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.R;
import com.tencent.mm.aq.o;
import com.tencent.mm.aq.p;
import com.tencent.mm.bc.k;
import com.tencent.mm.bc.k$a;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.gr;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.hr;
import com.tencent.mm.g.a.ip;
import com.tencent.mm.g.a.iu;
import com.tencent.mm.g.a.kw;
import com.tencent.mm.g.a.mb;
import com.tencent.mm.g.a.ne;
import com.tencent.mm.g.a.ng;
import com.tencent.mm.g.a.oo;
import com.tencent.mm.g.a.pc;
import com.tencent.mm.g.a.pf;
import com.tencent.mm.g.a.ru;
import com.tencent.mm.g.a.to;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelfriend.m$a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.m.e;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.plugin.webview.fts.l;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.q.j;
import com.tencent.mm.pluginsdk.q.z;
import com.tencent.mm.protocal.c.or;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.account.FacebookFriendUI;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.ui.bindmobile.MobileFriendUI;
import com.tencent.mm.ui.friend.FriendSnsPreference;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.z.an;
import com.tencent.mm.z.ao;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bi;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.TimeZone;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
import org.json.JSONObject;

public class h extends a implements a, b, an, ao {
    private long llS;
    private af mHandler = new 1(this, Looper.getMainLooper());
    private CheckBox oOr;
    private i oOt = null;
    c qWt = new 15(this);
    private c<to> qdj = new 3(this);
    private int qjL;
    private int status;
    private com.tencent.mm.pluginsdk.d.a vtd = new 14(this);
    private com.tencent.mm.ui.base.preference.h xEV;
    private View xEW;
    private boolean xEX = false;
    private String xEY = "";
    private int xEZ = 0;
    private String xFa = null;
    private String xFb = null;
    private String xFc = null;
    private String xFd = null;
    private boolean xFe = false;
    private boolean xFf = false;
    private boolean xFg = false;
    private boolean xFh = true;
    private int xFi;
    private View xFj;
    private TextView xFk;
    private c<oo> xFl = new 12(this);
    c xFm = new 16(this);
    c xFn = new 17(this);
    private com.tencent.mm.pluginsdk.d.a xFo = new com.tencent.mm.pluginsdk.d.a(this) {
        final /* synthetic */ h xFs;

        {
            this.xFs = r1;
        }

        public final void j(com.tencent.mm.sdk.b.b bVar) {
            if (bVar instanceof gr) {
                h.f(this.xFs);
                this.xFs.xEV.notifyDataSetChanged();
            }
        }
    };
    private com.tencent.mm.pluginsdk.d.a xFp = new com.tencent.mm.pluginsdk.d.a(this) {
        final /* synthetic */ h xFs;

        {
            this.xFs = r1;
        }

        public final void j(com.tencent.mm.sdk.b.b bVar) {
            if (bVar instanceof pc) {
                this.xFs.cmp();
                this.xFs.xEV.notifyDataSetChanged();
            }
        }
    };
    private c xFq = new 20(this);
    p.a xFr = new 5(this);

    static /* synthetic */ void f(h hVar) {
        hVar.cmn();
        hVar.xEV.notifyDataSetChanged();
    }

    public final int XB() {
        return R.o.fbL;
    }

    public boolean supportNavigationSwipeBack() {
        return false;
    }

    public boolean noActionBar() {
        return true;
    }

    private void cmk() {
        Object obj = null;
        Object obj2 = 1;
        if (this.yjv) {
            try {
                JSONObject NT = com.tencent.mm.plugin.aj.a.h.NT("discoverRecommendEntry");
                if (((com.tencent.mm.plugin.welab.a.a.a) g.h(com.tencent.mm.plugin.welab.a.a.a.class)).QC("labs_browse")) {
                    Object obj3;
                    if (((com.tencent.mm.plugin.welab.a.a.a) g.h(com.tencent.mm.plugin.welab.a.a.a.class)).QA("labs_browse")) {
                        obj3 = ((com.tencent.mm.plugin.welab.a.a.a) g.h(com.tencent.mm.plugin.welab.a.a.a.class)).QB("labs_browse") ? 1 : null;
                    } else {
                        obj3 = null;
                        obj2 = null;
                    }
                    obj = obj3;
                } else if (NT.optInt("entrySwitch") != 1) {
                    obj2 = null;
                }
                if (obj2 != null) {
                    CharSequence optString = NT.optString("wording");
                    String optString2 = NT.optString("androidIcon");
                    IconPreference iconPreference = (IconPreference) this.xEV.YN("find_friends_by_look");
                    if (bh.ov(optString)) {
                        iconPreference.setTitle(getString(R.l.ehx));
                    } else {
                        iconPreference.setTitle(optString);
                    }
                    if (bh.ov(optString2)) {
                        iconPreference.drawable = com.tencent.mm.bv.a.b(getContext(), R.k.dyz);
                        this.xFb = null;
                    } else {
                        o.Pv();
                        Bitmap iG = com.tencent.mm.aq.c.iG(optString2);
                        if (iG != null) {
                            iconPreference.drawable = new BitmapDrawable(getContext().getResources(), iG);
                            this.xFb = null;
                        } else {
                            x.i("MicroMsg.FindMoreFriendsUI", "load look icon from disk and net %s ", optString2);
                            iconPreference.drawable = com.tencent.mm.bv.a.b(getContext(), R.k.dyz);
                            o.Pz().a(optString2, this.xFr);
                            this.xFb = optString2;
                        }
                    }
                    this.xFi++;
                    this.xEV.bk("find_friends_by_look", false);
                    if (obj != null) {
                        iconPreference.EX(0);
                        iconPreference.dh(getString(R.l.dFP), R.g.bEf);
                    } else {
                        iconPreference.EX(8);
                        a(k.Re().hLe, iconPreference);
                    }
                    com.tencent.mm.bc.b.QQ();
                    return;
                }
                this.xEV.bk("find_friends_by_look", true);
            } catch (Throwable e) {
                x.e("MicroMsg.FindMoreFriendsUI", bh.i(e));
            }
        }
    }

    private void a(k$a com_tencent_mm_bc_k_a, IconPreference iconPreference) {
        ag.y(new 2(this, iconPreference, com_tencent_mm_bc_k_a));
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        x.i("MicroMsg.FindMoreFriendsUI", "onActivityCreated");
    }

    private void akJ() {
        this.xFi = 0;
        if (this.xFj != null) {
            this.xFj.setVisibility(8);
        }
        if (this.yjv) {
            boolean z;
            String optString;
            IconPreference iconPreference;
            cmo();
            boolean vU = vU(1048576);
            boolean OQ = d.OQ("scanner");
            String str = "MicroMsg.FindMoreFriendsUI";
            String str2 = "openScan %s, plugin installed %s";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(!vU);
            objArr[1] = Boolean.valueOf(OQ);
            x.i(str, str2, objArr);
            if (vU || !OQ) {
                this.xEV.bk("find_friends_by_qrcode", true);
            } else {
                this.xEV.bk("find_friends_by_qrcode", false);
                this.xFi++;
            }
            cmp();
            vU = vU(2097152);
            OQ = d.OQ("search");
            str = "MicroMsg.FindMoreFriendsUI";
            str2 = "openSearch %s, plugin installed %s";
            objArr = new Object[2];
            if (vU) {
                z = false;
            } else {
                z = true;
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Boolean.valueOf(OQ);
            x.i(str, str2, objArr);
            if (vU || !OQ) {
                this.xEV.bk("find_friends_by_search", true);
            } else {
                this.xFi++;
                this.xEV.bk("find_friends_by_search", false);
                try {
                    JSONObject NT = com.tencent.mm.plugin.aj.a.h.NT("discoverSearchEntry");
                    CharSequence optString2 = NT.optString("wording");
                    optString = NT.optString("androidIcon");
                    iconPreference = (IconPreference) this.xEV.YN("find_friends_by_search");
                    if (bh.ov(optString2)) {
                        iconPreference.setTitle(getString(R.l.ehB));
                    } else {
                        iconPreference.setTitle(optString2);
                    }
                    if (bh.ov(optString)) {
                        iconPreference.drawable = com.tencent.mm.bv.a.b(getContext(), R.k.dyC);
                        this.xFc = null;
                    } else {
                        o.Pv();
                        Bitmap iG = com.tencent.mm.aq.c.iG(optString);
                        if (iG != null) {
                            iconPreference.drawable = new BitmapDrawable(getContext().getResources(), iG);
                            this.xFc = null;
                        } else {
                            x.i("MicroMsg.FindMoreFriendsUI", "load search icon from disk and net %s ", optString);
                            iconPreference.drawable = com.tencent.mm.bv.a.b(getContext(), R.k.dyC);
                            o.Pz().a(optString, this.xFr);
                            this.xFc = optString;
                        }
                    }
                    iconPreference.EX(8);
                    a(k.Re().hLd, iconPreference);
                    com.tencent.mm.bc.b.QS();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.FindMoreFriendsUI", e, "update search entry exception!", new Object[0]);
                }
            }
            cmq();
            if ((this.qjL & 64) == 0) {
                z = true;
            } else {
                z = false;
            }
            x.i("MicroMsg.FindMoreFriendsUI", "openBottle %s, plugin installed %s", Boolean.valueOf(z), Boolean.valueOf(d.OQ("bottle")));
            if (z && r1) {
                this.xFi++;
                this.xEV.bk("voice_bottle", false);
                iconPreference = (IconPreference) this.xEV.YN("voice_bottle");
                if (iconPreference != null) {
                    int FO = com.tencent.mm.z.k.FO();
                    if (FO > 0) {
                        iconPreference.dh(String.valueOf(FO), s.gd(getContext()));
                    }
                    if (FO <= 0 || (this.status & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
                        iconPreference.EX(8);
                    } else {
                        iconPreference.EX(0);
                    }
                }
            } else {
                this.xEV.bk("voice_bottle", true);
            }
            vU = vU(4194304);
            optString = "MicroMsg.FindMoreFriendsUI";
            str = "openShoppingEntry %s";
            Object[] objArr2 = new Object[1];
            if (vU) {
                z = false;
            } else {
                z = true;
            }
            objArr2[0] = Boolean.valueOf(z);
            x.i(optString, str, objArr2);
            if (vU) {
                this.xEV.bk("jd_market_entrance", true);
            } else {
                lQ(false);
            }
            j jVar = q.a.vcu;
            if (jVar != null) {
                getContext();
                z = jVar.aRk();
            } else {
                z = false;
            }
            OQ = vU(8388608);
            str = "MicroMsg.FindMoreFriendsUI";
            str2 = "shouldShowGame %s, openGameEntry %s";
            objArr = new Object[2];
            objArr[0] = Boolean.valueOf(z);
            if (OQ) {
                vU = false;
            } else {
                vU = true;
            }
            objArr[1] = Boolean.valueOf(vU);
            x.i(str, str2, objArr);
            if (!z || OQ) {
                this.xEV.bk("more_tab_game_recommend", true);
            } else {
                this.xEV.bk("more_tab_game_recommend", false);
                cmn();
                this.xFi++;
            }
            com.tencent.mm.sdk.b.b pfVar = new pf();
            pfVar.fGZ.fHb = true;
            com.tencent.mm.sdk.b.a.xef.m(pfVar);
            vU = pfVar.fHa.fHc;
            boolean vU2 = vU(16777216);
            str2 = "MicroMsg.FindMoreFriendsUI";
            String str3 = "shouldShowMiniProgram %s, openMiniProgramEntry %s";
            Object[] objArr3 = new Object[2];
            objArr3[0] = Boolean.valueOf(vU);
            if (vU2) {
                z = false;
            } else {
                z = true;
            }
            objArr3[1] = Boolean.valueOf(z);
            x.i(str2, str3, objArr3);
            if (!vU || vU2) {
                this.xEV.bk("app_brand_entrance", true);
            } else {
                this.xFi++;
                this.xEV.bk("app_brand_entrance", false);
                iconPreference = (IconPreference) this.xEV.YN("app_brand_entrance");
                iconPreference.EX(pfVar.fHa.fHe ? 0 : 8);
                iconPreference.dh(getString(R.l.dFP), R.g.bEf);
                iconPreference.EZ(pfVar.fHa.fHd ? 0 : 8);
            }
            vU = com.tencent.mm.plugin.ipcall.d.aTd();
            OQ = vU(33554432);
            str = "MicroMsg.FindMoreFriendsUI";
            str2 = "showShowWeChatOut %s, openWeChatOutEntry %s";
            objArr = new Object[2];
            objArr[0] = Boolean.valueOf(vU);
            if (OQ) {
                z = false;
            } else {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
            if (!vU || OQ) {
                this.xEV.bk("ip_call_entrance", true);
            } else {
                this.xFi++;
                this.xEV.bk("ip_call_entrance", false);
                iconPreference = (IconPreference) this.xEV.YN("ip_call_entrance");
                ar.Hg();
                if (((Integer) com.tencent.mm.z.c.CU().get(w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(0))).intValue() < com.tencent.mm.k.g.zY().getInt("WCOEntranceRedDot", 0)) {
                    iconPreference.EX(0);
                    iconPreference.dh(getString(R.l.dFP), R.g.bEf);
                } else {
                    iconPreference.EX(8);
                }
                iconPreference.Fc(8);
                ar.Hg();
                if (((Boolean) com.tencent.mm.z.c.CU().get(w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                    iconPreference.mw(true);
                    iconPreference.EX(8);
                    OQ = true;
                } else {
                    iconPreference.mw(false);
                    OQ = false;
                }
                ar.Hg();
                String str4 = (String) com.tencent.mm.z.c.CU().get(w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, (Object) "");
                iconPreference.ac(str4, -1, -7566196);
                if (!bh.ov(str4)) {
                    OQ = true;
                }
                if (OQ) {
                    iconPreference.EY(0);
                } else {
                    iconPreference.EY(8);
                }
                this.xEV.a(new PreferenceSmallCategory(getContext()), -1);
            }
            cmk();
            this.xEV.bk("find_friends_by_facebook", true);
            this.xEV.bk("settings_emoji_store", true);
            if (this.xFi == 0) {
                ViewGroup viewGroup = (ViewGroup) findViewById(16908298).getParent();
                if (this.xFj == null) {
                    this.xFj = getContext().getLayoutInflater().inflate(R.i.dik, null);
                    this.xFk = (TextView) this.xFj.findViewById(R.h.cnO);
                    this.xFk.setOnClickListener(new 4(this));
                    viewGroup.addView(this.xFj, new LayoutParams(-1, -1));
                } else {
                    this.xFj.setVisibility(0);
                }
            }
            this.xEV.notifyDataSetChanged();
        }
    }

    private void lQ(boolean z) {
        String value;
        if (com.tencent.mm.sdk.platformtools.w.cff()) {
            value = com.tencent.mm.k.g.zY().getValue("JDEntranceConfigName");
        } else if (com.tencent.mm.sdk.platformtools.w.cfg()) {
            value = com.tencent.mm.k.g.zY().getValue("JDEntranceConfigNameHKTW");
        } else {
            value = com.tencent.mm.k.g.zY().getValue("JDEntranceConfigNameEN");
        }
        String value2 = com.tencent.mm.k.g.zY().getValue("JDEntranceConfigIconUrl");
        q.k kVar = z.vcD;
        boolean z2 = true;
        if (kVar != null) {
            String bDX = kVar.bDX();
            if (!(bh.ov(value) || bh.ov(value2) || bh.ov(bDX))) {
                Object obj;
                CharSequence charSequence;
                IconPreference iconPreference;
                Bitmap iG;
                Bitmap iG2;
                this.xFi++;
                com.tencent.mm.plugin.subapp.jdbiz.b bVar = (com.tencent.mm.plugin.subapp.jdbiz.b) kVar.bDY();
                if ((bVar.rVR < System.currentTimeMillis() / 1000 ? 1 : null) != null) {
                    if (bVar.rVS == 0 || bVar.rVS >= System.currentTimeMillis() / 1000) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj == null) {
                        if (!bh.ov(bVar.iconUrl)) {
                            value2 = bVar.iconUrl;
                        }
                        if (!bh.ov(bVar.title)) {
                            charSequence = bVar.title;
                            iconPreference = (IconPreference) this.xEV.YN("jd_market_entrance");
                            o.Pv();
                            iG = com.tencent.mm.aq.c.iG(value2);
                            if (iG == null) {
                                iconPreference.drawable = new BitmapDrawable(getContext().getResources(), iG);
                                this.xFa = null;
                            } else {
                                iconPreference.drawable = com.tencent.mm.bv.a.b(getContext(), R.k.dyS);
                                o.Pz().a(value2, this.xFr);
                                this.xFa = value2;
                            }
                            iconPreference.setTitle(charSequence);
                            iconPreference.EX(8);
                            iconPreference.EZ(8);
                            iconPreference.EY(8);
                            iconPreference.mw(false);
                            iconPreference.Fc(8);
                            if (kVar.bDP() && bVar.agj() && !bVar.bDH()) {
                                if (!bh.ov(bVar.rVN)) {
                                    iconPreference.EX(8);
                                    iconPreference.EZ(8);
                                    iconPreference.ac(bVar.rVN, -1, -7566196);
                                    iconPreference.EY(0);
                                }
                                if (!bh.ov(bVar.rVO)) {
                                    o.Pv();
                                    iG2 = com.tencent.mm.aq.c.iG(bVar.rVO);
                                    iconPreference.Fc(0);
                                    iconPreference.Fb(0);
                                    iconPreference.Fd(0);
                                    iconPreference.mw(false);
                                    if (iG2 == null) {
                                        this.xFd = null;
                                        iconPreference.V(iG2);
                                    } else {
                                        o.Pz().a(bVar.rVO, this.xFr);
                                        this.xFd = bVar.rVO;
                                    }
                                } else if (!bh.ov(bVar.rVN)) {
                                    iconPreference.mw(true);
                                } else if (bVar.rVM) {
                                    iconPreference.EZ(0);
                                    iconPreference.dh("", -1);
                                    iconPreference.EX(8);
                                }
                            }
                            if (z) {
                                this.xEV.notifyDataSetChanged();
                            }
                            if (!this.xFe) {
                                com.tencent.mm.plugin.report.service.g.pQN.h(11178, bDX, kVar.bDY().bDJ(), Integer.valueOf(cml()));
                                this.xFe = true;
                            }
                            z2 = false;
                        }
                    }
                }
                obj = value;
                iconPreference = (IconPreference) this.xEV.YN("jd_market_entrance");
                o.Pv();
                iG = com.tencent.mm.aq.c.iG(value2);
                if (iG == null) {
                    iconPreference.drawable = com.tencent.mm.bv.a.b(getContext(), R.k.dyS);
                    o.Pz().a(value2, this.xFr);
                    this.xFa = value2;
                } else {
                    iconPreference.drawable = new BitmapDrawable(getContext().getResources(), iG);
                    this.xFa = null;
                }
                iconPreference.setTitle(charSequence);
                iconPreference.EX(8);
                iconPreference.EZ(8);
                iconPreference.EY(8);
                iconPreference.mw(false);
                iconPreference.Fc(8);
                if (bh.ov(bVar.rVN)) {
                    iconPreference.EX(8);
                    iconPreference.EZ(8);
                    iconPreference.ac(bVar.rVN, -1, -7566196);
                    iconPreference.EY(0);
                }
                if (!bh.ov(bVar.rVO)) {
                    o.Pv();
                    iG2 = com.tencent.mm.aq.c.iG(bVar.rVO);
                    iconPreference.Fc(0);
                    iconPreference.Fb(0);
                    iconPreference.Fd(0);
                    iconPreference.mw(false);
                    if (iG2 == null) {
                        o.Pz().a(bVar.rVO, this.xFr);
                        this.xFd = bVar.rVO;
                    } else {
                        this.xFd = null;
                        iconPreference.V(iG2);
                    }
                } else if (!bh.ov(bVar.rVN)) {
                    iconPreference.mw(true);
                } else if (bVar.rVM) {
                    iconPreference.EZ(0);
                    iconPreference.dh("", -1);
                    iconPreference.EX(8);
                }
                if (z) {
                    this.xEV.notifyDataSetChanged();
                }
                if (this.xFe) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(11178, bDX, kVar.bDY().bDJ(), Integer.valueOf(cml()));
                    this.xFe = true;
                }
                z2 = false;
            }
        }
        this.xEV.bk("jd_market_entrance", z2);
    }

    private static int cml() {
        q.k kVar = z.vcD;
        if (kVar == null) {
            return 1;
        }
        q.d bDY = kVar.bDY();
        if (!kVar.bDP() || !bDY.agj() || bDY.bDH()) {
            return 1;
        }
        if (TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(bDY.bDM()) && !bh.ov(bDY.bDN())) {
            return 6;
        }
        if (!bh.ov(bDY.bDK())) {
            return 3;
        }
        if (bDY.bDL()) {
            return 2;
        }
        return 1;
    }

    public final boolean a(f fVar, Preference preference) {
        Intent intent;
        String str;
        com.tencent.mm.sdk.b.b hrVar;
        if ("album_dyna_photo_ui_title".equals(preference.ibD)) {
            ar.Hg();
            if (com.tencent.mm.z.c.isSDCardAvailable()) {
                com.tencent.mm.plugin.report.service.f.vz(10);
                ar.Hg();
                this.xEY = (String) com.tencent.mm.z.c.CU().get(68377, null);
                intent = new Intent();
                com.tencent.mm.modelsns.b bVar = new com.tencent.mm.modelsns.b(701, 1);
                bVar.bU(!bh.ov(this.xEY));
                bVar.mB(this.xEZ);
                intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                intent.putExtra("is_from_find_more", true);
                str = "enter_by_red";
                boolean z = !bh.ov(this.xEY) || this.xEZ > 0;
                intent.putExtra(str, z);
                ar.Hg();
                intent.putExtra("is_sns_notify_open", bh.a((Boolean) com.tencent.mm.z.c.CU().get(68384, null), true));
                intent.putExtra("sns_unread_count", n.qQA.Tq());
                if (!bh.ov(this.xEY)) {
                    ar.Hg();
                    intent.putExtra("new_feed_id", bh.az((String) com.tencent.mm.z.c.CU().get(68418, null), ""));
                }
                bVar.b(intent, "enter_log");
                hrVar = new hr();
                com.tencent.mm.sdk.b.a.xef.m(hrVar);
                z = true;
                if (!hrVar.fxZ.isResume) {
                    if (!bh.ov(this.xEY)) {
                        z = false;
                    }
                    if (n.qQA != null) {
                        this.xEZ = n.qQA.Tq();
                        if (this.xEZ > 0) {
                            z = false;
                        }
                    }
                    ar.Hg();
                    com.tencent.mm.z.c.CU().set(68377, "");
                }
                ar.Hg();
                com.tencent.mm.z.c.CU().set(589825, Boolean.valueOf(false));
                intent.putExtra("sns_resume_state", z);
                d.b(getContext(), "sns", ".ui.SnsTimeLineUI", intent);
                com.tencent.mm.plugin.report.service.g.pQN.k(10958, "1");
                new af().postDelayed(new 6(this), 500);
                return true;
            }
            u.fI(getContext());
            return true;
        } else if ("find_friends_by_near".equals(preference.ibD)) {
            x.i("MicroMsg.FindMoreFriendsUI", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(thisActivity(), "android.permission.ACCESS_COARSE_LOCATION", 66, null, null)));
            if (!com.tencent.mm.pluginsdk.g.a.a(thisActivity(), "android.permission.ACCESS_COARSE_LOCATION", 66, null, null)) {
                return true;
            }
            cmm();
            return true;
        } else if ("find_friends_by_shake".equals(preference.ibD)) {
            if (!this.xFf && com.tencent.mm.z.q.GA().booleanValue()) {
                r0 = (IconPreference) fVar.YN("find_friends_by_shake");
                if (r0 != null) {
                    r0.EZ(8);
                    ar.Hg();
                    com.tencent.mm.z.c.CU().set(340231, Boolean.valueOf(true));
                    ar.Hg();
                    com.tencent.mm.z.c.CU().lH(true);
                    com.tencent.mm.plugin.report.service.g.pQN.a(232, 4, 1, false);
                }
            }
            com.tencent.mm.plugin.report.service.g.pQN.k(10958, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
            ar.Hg();
            r1 = bh.az((String) com.tencent.mm.z.c.CU().get(w.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, null), "");
            ar.Hg();
            Boolean valueOf = (!Boolean.valueOf(bh.a((Boolean) com.tencent.mm.z.c.CU().get(w.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, null), false)).booleanValue() || r1 == null || r1.equals("")) ? Boolean.valueOf(false) : Boolean.valueOf(true);
            if (valueOf.booleanValue()) {
                com.tencent.mm.plugin.report.service.g.pQN.h(12653, Integer.valueOf(2), Integer.valueOf(2));
            }
            com.tencent.mm.sdk.b.a.xef.m(new ne());
            d.y(getContext(), "shake", ".ui.ShakeReportUI");
            return true;
        } else if ("voice_bottle".equals(preference.ibD)) {
            com.tencent.mm.plugin.report.service.g.pQN.k(10958, "5");
            bi HQ = bi.HQ();
            if (bh.a(Integer.valueOf(HQ.fWf), 0) <= 0 || bh.ov(HQ.getProvince())) {
                d.y(getContext(), "bottle", ".ui.BottleWizardStep1");
            } else {
                d.y(getContext(), "bottle", ".ui.BottleBeachUI");
            }
            return true;
        } else if ("find_friends_by_qrcode".equals(preference.ibD)) {
            if (!com.tencent.mm.p.a.aV(getContext())) {
                getContext();
                if (!com.tencent.mm.au.a.Qj()) {
                    com.tencent.mm.plugin.report.service.g.pQN.k(10958, "2");
                    r0 = new Intent();
                    r0.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
                    com.tencent.mm.plugin.report.service.g.pQN.h(11265, Integer.valueOf(2));
                    d.b(getContext(), "scanner", ".ui.BaseScanUI", r0);
                    return true;
                }
            }
            return true;
        } else if (preference.ibD.equals("more_tab_game_recommend")) {
            com.tencent.mm.plugin.report.service.g.pQN.k(10958, "6");
            ar.Hg();
            if (com.tencent.mm.z.c.isSDCardAvailable()) {
                intent = new Intent();
                intent.putExtra("from_find_more_friend", this.xFh);
                intent.putExtra("game_report_from_scene", 901);
                if (this.xFh) {
                    hrVar = new mb();
                    com.tencent.mm.sdk.b.a.xef.m(hrVar);
                    r0 = (IconPreference) fVar.YN("more_tab_game_recommend");
                    if (!(hrVar.fDH.fDI == null || r0 == null)) {
                        o.PA().hCR.a(new com.tencent.mm.aq.a.c(r0.olD, hrVar.fDH.fDI));
                    }
                }
                d.b(getContext(), "game", ".ui.GameCenterUI", intent);
                return true;
            }
            u.fI(getContext());
            return true;
        } else if ("find_friends_by_micromsg".equals(preference.ibD)) {
            d.b(getContext(), "subapp", ".ui.pluginapp.ContactSearchUI", new Intent());
            return true;
        } else if ("find_friends_by_mobile".equals(preference.ibD)) {
            if (m.NN() != m$a.SUCC) {
                r0 = new Intent(getContext(), BindMContactIntroUI.class);
                r0.putExtra("key_upload_scene", 6);
                MMWizardActivity.A(getContext(), r0);
                return true;
            }
            startActivity(new Intent(getContext(), MobileFriendUI.class));
            return true;
        } else if ("find_friends_by_facebook".equals(preference.ibD)) {
            startActivity(new Intent(getContext(), FacebookFriendUI.class));
            return true;
        } else if ("settings_mm_card_package".equals(preference.ibD)) {
            x.i("MicroMsg.FindMoreFriendsUI", "enter to cardhome");
            d.y(getContext(), "card", ".ui.CardHomePageUI");
            return true;
        } else if (preference.ibD.equals("jd_market_entrance")) {
            r0 = null;
            com.tencent.mm.pluginsdk.wallet.i.CB(9);
            q.k kVar = z.vcD;
            if (kVar != null) {
                r0 = z.vcD.bDX();
                com.tencent.mm.plugin.report.service.g.pQN.h(11179, r0, kVar.bDY().bDJ(), Integer.valueOf(cml()));
                kVar.bDS();
                kVar.bDR();
                ((IconPreference) preference).dh("", -1);
                if (!bh.ov(r0)) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", r0);
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    intent.putExtra("KPublisherId", "jd_store");
                    d.b(getContext(), "webview", ".ui.tools.WebViewUI", intent);
                }
            }
            x.i("MicroMsg.FindMoreFriendsUI", "jump to url: " + r0);
            return true;
        } else if ("ip_call_entrance".equals(preference.ibD)) {
            r0 = (IconPreference) fVar.YN("ip_call_entrance");
            r0.EZ(8);
            r0.EY(8);
            r0.mw(false);
            r0.Fc(8);
            Object obj = null;
            ar.Hg();
            r0 = (String) com.tencent.mm.z.c.CU().get(w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, (Object) "");
            ar.Hg();
            if (((Boolean) com.tencent.mm.z.c.CU().get(w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                com.tencent.mm.plugin.ipcall.a.e.i.N(1, -1, -1);
                ar.Hg();
                com.tencent.mm.z.c.CU().a(w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.valueOf(false));
                obj = 1;
            }
            ar.Hg();
            if (((Integer) com.tencent.mm.z.c.CU().get(w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(0))).intValue() < com.tencent.mm.k.g.zY().getInt("WCOEntranceRedDot", 0)) {
                obj = 1;
                com.tencent.mm.plugin.report.service.g.pQN.h(13254, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1));
                ar.Hg();
                com.tencent.mm.z.c.CU().a(w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(com.tencent.mm.k.g.zY().getInt("WCOEntranceRedDot", 0)));
            }
            if (!bh.ov(r0)) {
                ar.Hg();
                com.tencent.mm.z.c.CU().a(w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, (Object) "");
            }
            if (obj != null) {
                com.tencent.mm.sdk.b.a.xef.m(new ru());
            }
            if (com.tencent.mm.p.a.AW()) {
                com.tencent.mm.ui.base.h.a(getContext(), R.l.ewq, 0, null, null);
            } else {
                com.tencent.mm.plugin.report.service.g.pQN.h(12061, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                d.b(getContext(), "ipcall", ".ui.IPCallAddressUI", new Intent());
            }
            return true;
        } else if ("app_brand_entrance".equals(preference.ibD)) {
            ((e) g.h(e.class)).w(getContext(), 1);
            return true;
        } else if ("find_friends_by_search".equals(preference.ibD)) {
            if (com.tencent.mm.plugin.aj.a.g.zM(0)) {
                r1 = com.tencent.mm.plugin.aj.a.h.NT("discoverSearchEntry").optString("wording");
                if (bh.ov(r1)) {
                    x.e("MicroMsg.FindMoreFriendsUI", "empty title");
                } else {
                    r0 = k.Re();
                    r0.hLd = new k$a();
                    r0.save();
                    ((com.tencent.mm.plugin.welab.a.a.a) g.h(com.tencent.mm.plugin.welab.a.a.a.class)).open("labs1de6f3");
                    com.tencent.mm.bc.g.d("", 0, 0, 20);
                    r0 = com.tencent.mm.bc.b.QM();
                    r0.putExtra("ftsbizscene", 20);
                    String zH = com.tencent.mm.plugin.aj.a.g.zH(20);
                    str = com.tencent.mm.bc.b.ar(zH, com.tencent.mm.plugin.webview.modeltools.f.bRy().bPf());
                    r0.putExtra("key_session_id", zH);
                    r0.putExtra("title", r1);
                    r0.putExtra("ftsneedkeyboard", true);
                    r0.putExtra("sessionId", zH);
                    r0.putExtra("rawUrl", str);
                    r0.putExtra("key_load_js_without_delay", true);
                    r0.putExtra("zoom", false);
                    r0.putExtra("key_preload_biz", 1);
                    d.b(getContext(), "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", r0);
                    com.tencent.mm.plugin.aj.a.g.zK(0);
                }
            } else {
                x.e("MicroMsg.FindMoreFriendsUI", "fts h5 template not avail");
            }
            return true;
        } else if (!"find_friends_by_look".equals(preference.ibD)) {
            return false;
        } else {
            if (com.tencent.mm.plugin.aj.a.g.zM(1)) {
                r1 = com.tencent.mm.plugin.aj.a.h.NT("discoverRecommendEntry").optString("wording");
                if (bh.ov(r1)) {
                    x.e("MicroMsg.FindMoreFriendsUI", "empty query");
                } else {
                    x.i("MicroMsg.FindMoreFriendsUI", "look one look clikced");
                    r0 = k.Re();
                    r0.hLe = new k$a();
                    r0.save();
                    String valueOf2 = String.valueOf(System.currentTimeMillis());
                    String zH2 = com.tencent.mm.plugin.aj.a.g.zH(21);
                    String zH3 = com.tencent.mm.plugin.aj.a.g.zH(21);
                    l bPk = l.bPk();
                    if (!bPk.tmX) {
                        x.w("RecommendLogic", "do no support pre get data, h5.ver %d, seq %s, sessionId %s, subSessionId %s", Integer.valueOf(com.tencent.mm.plugin.aj.a.g.zN(1)), valueOf2, zH2, zH3);
                    } else if (System.currentTimeMillis() - bPk.tmV <= l.tmO) {
                        x.w("RecommendLogic", "pre get data fail for time interval limit");
                    } else {
                        x.w("RecommendLogic", "pre get data, h5.ver %d, seq %s, sessionId %s, subSessionId %s", Integer.valueOf(com.tencent.mm.plugin.aj.a.g.zN(1)), valueOf2, zH2, zH3);
                        bPk.tmR = true;
                        if (bPk.tmT != null) {
                            bPk.tmT.countDown();
                        }
                        bPk.tmT = new CountDownLatch(1);
                        x.i("RecommendLogic", "preGetSearchData");
                        com.tencent.mm.plugin.aj.a.d dVar = new com.tencent.mm.plugin.aj.a.d();
                        dVar.tjW = 2;
                        dVar.fod = com.tencent.mm.bc.b.QP();
                        dVar.ael = com.tencent.mm.sdk.platformtools.w.eL(ac.getContext());
                        dVar.scene = 21;
                        dVar.tjR = 2;
                        LinkedList linkedList = new LinkedList();
                        or orVar = new or();
                        orVar.aAM = DownloadInfo.NETTYPE;
                        orVar.vXy = com.tencent.mm.plugin.aj.a.g.bfF();
                        linkedList.add(orVar);
                        orVar = new or();
                        orVar.aAM = "time_zone_min";
                        orVar.vXy = String.valueOf(((-TimeZone.getDefault().getRawOffset()) / 1000) / 60);
                        linkedList.add(orVar);
                        orVar = new or();
                        orVar.aAM = "currentPage";
                        orVar.vXx = 1;
                        linkedList.add(orVar);
                        orVar = new or();
                        orVar.aAM = "is_prefetch";
                        orVar.vXx = 0;
                        linkedList.add(orVar);
                        orVar = new or();
                        orVar.aAM = TencentLocation.EXTRA_DIRECTION;
                        orVar.vXx = 2;
                        linkedList.add(orVar);
                        orVar = new or();
                        orVar.aAM = "seq";
                        orVar.vXy = valueOf2;
                        linkedList.add(orVar);
                        orVar = new or();
                        orVar.aAM = "client_exposed_info";
                        orVar.vXy = "";
                        linkedList.add(orVar);
                        orVar = new or();
                        orVar.aAM = "requestId";
                        orVar.vXy = valueOf2;
                        linkedList.add(orVar);
                        orVar = new or();
                        orVar.aAM = "recType";
                        orVar.vXx = 0;
                        linkedList.add(orVar);
                        dVar.tka = linkedList;
                        dVar.tki = true;
                        dVar.hKZ = valueOf2;
                        if (bPk.ap(linkedList)) {
                            dVar.fqu = zH2;
                            dVar.tjs = zH3;
                            bPk.tmQ.b(dVar);
                            bPk.tmV = System.currentTimeMillis();
                        } else {
                            throw new IllegalStateException("pre get data must use same commKvSets with hardcode set");
                        }
                    }
                    ((com.tencent.mm.plugin.welab.a.a.a) g.h(com.tencent.mm.plugin.welab.a.a.a.class)).open("labs_browse");
                    com.tencent.mm.plugin.aj.a.g.zK(1);
                    Intent intent2 = new Intent();
                    intent2.putExtra("key_preload_biz", 2);
                    com.tencent.mm.bc.b.a(getContext(), r1, intent2, r1, valueOf2, zH2, zH3);
                    com.tencent.mm.sdk.b.b kwVar = new kw();
                    kwVar.fCe.scene = 0;
                    com.tencent.mm.sdk.b.a.xef.m(kwVar);
                    com.tencent.mm.bc.g.u(21, r1);
                    com.tencent.mm.bc.g.bk(21, 0);
                    if (com.tencent.mm.plugin.aj.a.g.zN(1) > com.tencent.mm.plugin.aj.a.g.zL(1)) {
                        com.tencent.mm.bc.g.bk(21, 15);
                    } else {
                        com.tencent.mm.bc.g.bk(21, 14);
                    }
                }
            } else {
                x.e("MicroMsg.FindMoreFriendsUI", "fts h5 template not avail");
            }
            return true;
        }
    }

    public final void cmm() {
        com.tencent.mm.plugin.report.service.g.pQN.k(10958, "4");
        ar.Hg();
        if (bh.c((Boolean) com.tencent.mm.z.c.CU().get(4103, null))) {
            bi HR = bi.HR();
            if (HR == null) {
                d.y(getContext(), "nearby", ".ui.NearbyPersonalInfoUI");
                return;
            }
            String ou = bh.ou(HR.getProvince());
            int a = bh.a(Integer.valueOf(HR.fWf), 0);
            if (bh.ov(ou) || a == 0) {
                d.y(getContext(), "nearby", ".ui.NearbyPersonalInfoUI");
                return;
            }
            ar.Hg();
            Boolean bool = (Boolean) com.tencent.mm.z.c.CU().get(4104, null);
            if (bool == null || !bool.booleanValue()) {
                LauncherUI launcherUI = (LauncherUI) getContext();
                if (launcherUI != null) {
                    launcherUI.xGS.xGh.Yp("tab_find_friend");
                }
                com.tencent.mm.bk.a.dV(getContext());
                return;
            }
            if (this.xEW == null) {
                this.xEW = View.inflate(getContext(), R.i.dmB, null);
                this.oOr = (CheckBox) this.xEW.findViewById(R.h.csH);
                this.oOr.setChecked(false);
            }
            if (this.oOt == null) {
                this.oOt = com.tencent.mm.ui.base.h.a(getContext(), getString(R.l.dGO), this.xEW, new 7(this), null);
                return;
            } else {
                this.oOt.show();
                return;
            }
        }
        d.y(getContext(), "nearby", ".ui.NearbyFriendsIntroUI");
    }

    private void cmn() {
        IconPreference iconPreference = (IconPreference) this.xEV.YN("more_tab_game_recommend");
        if (iconPreference != null) {
            com.tencent.mm.sdk.b.b mbVar = new mb();
            com.tencent.mm.sdk.b.a.xef.m(mbVar);
            iconPreference.EZ(8);
            String str = mbVar.fDH.fDJ;
            String str2 = mbVar.fDH.appId;
            int i = mbVar.fDH.msgType;
            String str3 = mbVar.fDH.fop;
            if (mbVar.fDH.showType == 1) {
                iconPreference.dh(getString(R.l.dFP), R.g.bEf);
                a(iconPreference, 0, 8, 8, false, 8, 8, 8);
                b(str2, i, str, str3, mbVar.fDH.showType);
            } else if (mbVar.fDH.showType == 2) {
                iconPreference.ac(fK(mbVar.fDH.appName, mbVar.fDH.appId), -1, Color.parseColor("#8c8c8c"));
                a(iconPreference, 8, 8, 0, true, 8, 8, 8);
                b(str2, i, str, str3, mbVar.fDH.showType);
            } else if (mbVar.fDH.showType == 3) {
                if (bh.ov(mbVar.fDH.fDI)) {
                    iconPreference.V(com.tencent.mm.pluginsdk.model.app.g.b(mbVar.fDH.appId, 1, com.tencent.mm.bv.a.getDensity(getContext())));
                    a(iconPreference, 8, 8, 8, false, 0, 0, 0);
                    return;
                }
                a(mbVar.fDH.fDI, iconPreference, mbVar, "");
            } else if (mbVar.fDH.showType == 4) {
                String fK = fK(mbVar.fDH.appName, mbVar.fDH.appId);
                if (bh.ov(fK)) {
                    this.xFh = true;
                    a(iconPreference, 8, 8, 8, false, 8, 8, 8);
                    return;
                }
                iconPreference.ac(fK, -1, Color.parseColor("#8c8c8c"));
                if (bh.ov(mbVar.fDH.fDI)) {
                    iconPreference.V(com.tencent.mm.pluginsdk.model.app.g.b(mbVar.fDH.appId, 1, com.tencent.mm.bv.a.getDensity(getContext())));
                    a(iconPreference, 8, 8, 0, false, 0, 0, 0);
                    return;
                }
                a(mbVar.fDH.fDI, iconPreference, mbVar, fK);
            } else if (mbVar.fDH.showType == 5) {
                this.xFh = true;
                a(iconPreference, 8, 0, 8, false, 8, 8, 8);
                b(str2, i, str, str3, mbVar.fDH.showType);
            } else {
                this.xFh = true;
                a(iconPreference, 8, 8, 8, false, 8, 8, 8);
            }
        }
    }

    private synchronized void a(String str, IconPreference iconPreference, mb mbVar, String str2) {
        if (!(bh.ov(str) || iconPreference == null || iconPreference.olD == null)) {
            x.d("MicroMsg.FindMoreFriendsUI", "download entrance image : %s", str);
            String str3 = mbVar.fDH.fDJ;
            String str4 = mbVar.fDH.appId;
            int i = mbVar.fDH.msgType;
            String str5 = mbVar.fDH.fop;
            int i2 = mbVar.fDH.showType;
            com.tencent.mm.sdk.b.b gsVar = new gs();
            gsVar.fwO.pK = 1;
            gsVar.fwO.url = str;
            com.tencent.mm.sdk.b.a.xef.m(gsVar);
            if (gsVar.fwP.fwR) {
                String str6 = gsVar.fwP.fwQ + com.tencent.mm.a.g.s(str.getBytes());
                com.tencent.mm.aq.a.a.c.a aVar = new com.tencent.mm.aq.a.a.c.a();
                aVar.hDA = true;
                aVar.hDC = str6;
                com.tencent.mm.aq.a.a.c PK = aVar.PK();
                o.PA().a(str, iconPreference.olD, PK, new 8(this, gsVar), new 9(this, gsVar, iconPreference, i2, str4, i, str3, str5, str2));
            }
        }
    }

    private static void b(String str, int i, String str2, String str3, int i2) {
        g.Dk();
        String str4 = (String) g.Dj().CU().get(w.a.GAME_FIND_MORE_FRIEND_MSG_ID_STRING_SYNC, (Object) "");
        if (str2 != null && !str2.equals(str4)) {
            g.Dk();
            g.Dj().CU().a(w.a.GAME_FIND_MORE_FRIEND_MSG_ID_STRING_SYNC, (Object) str2);
            com.tencent.mm.sdk.b.b ngVar = new ng();
            ngVar.fFi.scene = 9;
            ngVar.fFi.fFj = 901;
            ngVar.fFi.action = 1;
            ngVar.fFi.appId = str;
            ngVar.fFi.msgType = i;
            ngVar.fFi.fDJ = str2;
            ngVar.fFi.fop = str3;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("function_type", "resource");
                jSONObject.put("function_value", String.valueOf(i2));
            } catch (JSONException e) {
                x.e("MicroMsg.FindMoreFriendsUI", e.getMessage());
            }
            try {
                str4 = URLEncoder.encode(jSONObject.toString(), ProtocolPackage.ServerEncoding);
            } catch (UnsupportedEncodingException e2) {
                UnsupportedEncodingException unsupportedEncodingException = e2;
                str4 = "";
                x.e("MicroMsg.FindMoreFriendsUI", unsupportedEncodingException.getMessage());
            }
            ngVar.fFi.fFk = str4;
            com.tencent.mm.sdk.b.a.xef.m(ngVar);
        }
    }

    private String fK(String str, String str2) {
        return !bh.ov(str) ? str : com.tencent.mm.pluginsdk.model.app.g.l(getContext(), str2);
    }

    private static void a(IconPreference iconPreference, int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        iconPreference.EX(i);
        iconPreference.EZ(i2);
        iconPreference.EY(i3);
        iconPreference.mw(z);
        iconPreference.Fc(i4);
        iconPreference.Fb(i5);
        iconPreference.Fd(i6);
    }

    public final void GT() {
        if ((com.tencent.mm.z.q.Gd() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0) {
            this.xEZ++;
            cmo();
            this.xEV.notifyDataSetChanged();
        }
    }

    public final void GU() {
        if ((com.tencent.mm.z.q.Gd() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0) {
            cmo();
            this.xEV.notifyDataSetChanged();
        }
    }

    public final void GV() {
    }

    public final void GX() {
        if (this.xEV != null) {
            this.status = com.tencent.mm.z.q.FW();
            akJ();
        }
    }

    protected final void clt() {
        x.i("MicroMsg.FindMoreFriendsUI", "on tab create");
        this.xEV = this.yjd;
        this.status = com.tencent.mm.z.q.FW();
        this.qjL = com.tencent.mm.z.q.Gd();
        this.llS = com.tencent.mm.z.q.FX();
        x.i("MicroMsg.FindMoreFriendsUI", "on tab create end");
    }

    protected final void clu() {
        x.i("MicroMsg.FindMoreFriendsUI", "on tab resume");
        com.tencent.mm.pluginsdk.d.a.a(ip.class.getName(), this.vtd);
        com.tencent.mm.pluginsdk.d.a.a(gr.class.getName(), this.xFo);
        com.tencent.mm.pluginsdk.d.a.a(pc.class.getName(), this.xFp);
        com.tencent.mm.sdk.b.a.xef.b(this.xFm);
        com.tencent.mm.sdk.b.a.xef.b(this.xFl);
        com.tencent.mm.sdk.b.a.xef.b(this.xFn);
        com.tencent.mm.sdk.b.a.xef.b(this.qWt);
        com.tencent.mm.sdk.b.a.xef.b(this.xFq);
        com.tencent.mm.sdk.b.a.xef.a(this.qdj);
        com.tencent.mm.bf.l.Tz().c(this);
        ar.Hg();
        com.tencent.mm.z.c.Fd().a(this);
        ar.Hg();
        com.tencent.mm.z.c.a(this);
        ar.Hg();
        com.tencent.mm.z.c.CU().a(this);
        if (n.qQC != null) {
            n.qQC.a(this);
        }
        View findViewById = findViewById(R.h.ctC);
        if (!(findViewById == null || findViewById.getVisibility() == 8)) {
            new af(Looper.getMainLooper()).post(new 10(this, findViewById));
        }
        com.tencent.mm.blink.b.wo().f(new 11(this));
        x.i("MicroMsg.FindMoreFriendsUI", "on tab resume end");
    }

    private boolean vU(int i) {
        return (this.llS & ((long) i)) != 0;
    }

    private void cmo() {
        boolean z = (this.qjL & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0;
        x.i("MicroMsg.FindMoreFriendsUI", "openSns %s, plugin installed %s", Boolean.valueOf(z), Boolean.valueOf(d.OQ("sns")));
        SharedPreferences sharedPreferences = getSharedPreferences(ac.cfs(), 0);
        String string = sharedPreferences.getString(com.tencent.mm.z.q.FS() + "_sns_entrance_disappear", "");
        if (!z) {
            boolean z2 = sharedPreferences.getBoolean(com.tencent.mm.z.q.FS() + "_has_mod_userinfo", false);
            if (string != null && string.equals("on")) {
                com.tencent.mm.plugin.report.service.g.pQN.a(150, (long) (z2 ? 110 : 111), 1, true);
                x.e("MicroMsg.FindMoreFriendsUI", "sns entrance disappear autoly, hasModUserInfo:%b", Boolean.valueOf(z2));
                com.tencent.mm.plugin.report.service.g.pQN.h(15179, Integer.valueOf(r9));
            } else if (string != null && string.equals("on_close")) {
                com.tencent.mm.plugin.report.service.g.pQN.a(150, (long) (z2 ? MMGIFException.D_GIF_ERR_IMAGE_DEFECT : 113), 1, true);
                x.i("MicroMsg.FindMoreFriendsUI", "sns entrance close by user, hasModUserInfo:%b", Boolean.valueOf(z2));
                com.tencent.mm.plugin.report.service.g.pQN.h(15179, Integer.valueOf(r9));
            }
            if (sharedPreferences.contains(com.tencent.mm.z.q.FS() + "_has_mod_userinfo") || sharedPreferences.contains(com.tencent.mm.z.q.FS() + "_sns_entrance_disappear")) {
                sharedPreferences.edit().remove(com.tencent.mm.z.q.FS() + "_has_mod_userinfo").remove(com.tencent.mm.z.q.FS() + "_sns_entrance_disappear").commit();
            }
        } else if (bh.ov(string)) {
            sharedPreferences.edit().putString(com.tencent.mm.z.q.FS() + "_sns_entrance_disappear", "on").commit();
        }
        if (z && r10) {
            this.xFi++;
            this.xEV.bk("album_dyna_photo_ui_title", false);
            FriendSnsPreference friendSnsPreference = (FriendSnsPreference) this.xEV.YN("album_dyna_photo_ui_title");
            friendSnsPreference.drawable = com.tencent.mm.bv.a.b(getContext(), R.k.dyB);
            ar.Hg();
            boolean c = bh.c((Boolean) com.tencent.mm.z.c.CU().get(48, null));
            friendSnsPreference.EX(8);
            friendSnsPreference.Fd(8);
            if (c) {
                friendSnsPreference.EX(0);
                friendSnsPreference.dh(getString(R.l.dFP), R.g.bEf);
            }
            ar.Hg();
            this.xEY = (String) com.tencent.mm.z.c.CU().get(68377, null);
            x.i("MicroMsg.FindMoreFriendsUI", "newer snsobj %s", bh.az(this.xEY, ""));
            friendSnsPreference.Fc(0);
            if (bh.ov(this.xEY)) {
                ar.Hg();
                if (((Boolean) com.tencent.mm.z.c.CU().get(589825, Boolean.valueOf(false))).booleanValue()) {
                    friendSnsPreference.Fa(R.k.dzs);
                    friendSnsPreference.Fb(0);
                    friendSnsPreference.Fd(8);
                } else {
                    friendSnsPreference.Fb(8);
                }
            } else {
                friendSnsPreference.Fb(0);
                ar.Hg();
                friendSnsPreference.Fd(bh.a((Boolean) com.tencent.mm.z.c.CU().get(68384, null), true) ? 0 : 8);
                string = this.xEY;
                friendSnsPreference.yiv = null;
                friendSnsPreference.yiw = -1;
                friendSnsPreference.zcC = string;
                if (friendSnsPreference.olD != null) {
                    com.tencent.mm.pluginsdk.ui.a.b.a(friendSnsPreference.olD, string);
                }
            }
            if (n.qQA != null) {
                this.xEZ = n.qQA.Tq();
            }
            if (this.xEZ != 0) {
                friendSnsPreference.EX(0);
                friendSnsPreference.dh(this.xEZ, s.gd(getContext()));
            }
            friendSnsPreference.EZ(8);
            friendSnsPreference.EY(8);
            com.tencent.mm.sdk.b.a.xef.m(new ru());
            return;
        }
        this.xEV.bk("album_dyna_photo_ui_title", true);
    }

    private void cmp() {
        x.i("MicroMsg.FindMoreFriendsUI", "openShake %s, plugin installed %s", Boolean.valueOf((this.qjL & 256) == 0), Boolean.valueOf(d.OQ("shake")));
        if (((this.qjL & 256) == 0) && r1) {
            boolean aR;
            this.xFi++;
            this.xEV.bk("find_friends_by_shake", false);
            IconPreference iconPreference = (IconPreference) this.xEV.YN("find_friends_by_shake");
            int Tq = com.tencent.mm.bf.l.Tz().Tq() + q.a.bXY().brv();
            if (Tq > 0) {
                iconPreference.EX(0);
                iconPreference.dh(String.valueOf(Tq), R.g.bHd);
            } else {
                iconPreference.EX(8);
                iconPreference.dh("", -1);
            }
            iconPreference.Fb(8);
            q.a.bXY().brw();
            if (q.a.bXY().brx()) {
                aR = com.tencent.mm.s.c.Bq().aR(262154, 266258);
            } else {
                aR = false;
            }
            if (aR) {
                ar.Hg();
                String str = (String) com.tencent.mm.z.c.CU().get(w.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_TEXT_STRING_SYNC, (Object) "");
                if (!TextUtils.isEmpty(str)) {
                    iconPreference.EZ(8);
                    iconPreference.EX(0);
                    iconPreference.dh(str, R.g.bHd);
                } else if (Tq > 0) {
                    iconPreference.EZ(0);
                } else {
                    iconPreference.EZ(0);
                    iconPreference.EX(8);
                    iconPreference.dh("", -1);
                }
            } else {
                iconPreference.EZ(8);
            }
            ar.Hg();
            String az = bh.az((String) com.tencent.mm.z.c.CU().get(w.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, null), "");
            ar.Hg();
            Boolean valueOf = Boolean.valueOf(bh.a((Boolean) com.tencent.mm.z.c.CU().get(w.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, null), false));
            ar.Hg();
            int intValue = ((Integer) com.tencent.mm.z.c.CU().get(w.a.USERINFO_IBEACON_SHAKE_TAB_DISPLAY_INT, Integer.valueOf(0))).intValue();
            if (!valueOf.booleanValue() || az == null || az.equals("") || Tq > 0 || aR) {
                iconPreference.EY(8);
                return;
            } else if (intValue == 0) {
                iconPreference.EZ(8);
                iconPreference.EY(0);
                String[] split = az.split(",");
                if (split.length > 0) {
                    iconPreference.ac(split[0], -1, Color.parseColor("#8c8c8c"));
                }
                iconPreference.mw(true);
                iconPreference.Fc(8);
                return;
            } else if (intValue == 1) {
                iconPreference.EY(8);
                iconPreference.EX(0);
                iconPreference.yiG = true;
                return;
            } else {
                return;
            }
        }
        this.xEV.bk("find_friends_by_shake", true);
    }

    private void cmq() {
        x.i("MicroMsg.FindMoreFriendsUI", "openNearby %s, plugin installed %s", Boolean.valueOf((this.qjL & WXMediaMessage.TITLE_LENGTH_LIMIT) == 0), Boolean.valueOf(d.OQ("nearby")));
        if (((this.qjL & WXMediaMessage.TITLE_LENGTH_LIMIT) == 0) && r3) {
            this.xFi++;
            this.xEV.bk("find_friends_by_near", false);
            IconPreference iconPreference = (IconPreference) this.xEV.YN("find_friends_by_near");
            if (iconPreference != null) {
                com.tencent.mm.sdk.b.b iuVar = new iu();
                iuVar.fzl.fut = 7;
                com.tencent.mm.sdk.b.a.xef.m(iuVar);
                if (iuVar.fzm.fpW) {
                    iconPreference.Fb(8);
                } else {
                    iconPreference.Fb(0);
                    iconPreference.Fa(R.g.bDG);
                    iconPreference.eX(-2, -2);
                }
                int Tq = com.tencent.mm.bf.l.Ty().Tq();
                if (com.tencent.mm.bk.a.bXU()) {
                    if (Tq > 0) {
                        iconPreference.EZ(0);
                        return;
                    } else {
                        iconPreference.EZ(8);
                        return;
                    }
                } else if (Tq > 0) {
                    iconPreference.EX(0);
                    iconPreference.dh(String.valueOf(Tq), s.gd(getContext()));
                    return;
                } else {
                    iconPreference.EX(8);
                    iconPreference.dh("", -1);
                    return;
                }
            }
            return;
        }
        this.xEV.bk("find_friends_by_near", true);
    }

    protected final void clv() {
        x.i("MicroMsg.FindMoreFriendsUI", "on tab start");
    }

    protected final void clw() {
        x.i("MicroMsg.FindMoreFriendsUI", "on tab pause");
        if (ar.Hj()) {
            com.tencent.mm.pluginsdk.d.a.b(ip.class.getName(), this.vtd);
            com.tencent.mm.pluginsdk.d.a.b(gr.class.getName(), this.xFo);
            com.tencent.mm.pluginsdk.d.a.b(pc.class.getName(), this.xFp);
            com.tencent.mm.sdk.b.a.xef.c(this.xFm);
            com.tencent.mm.sdk.b.a.xef.c(this.xFl);
            com.tencent.mm.sdk.b.a.xef.c(this.xFn);
            com.tencent.mm.sdk.b.a.xef.c(this.qWt);
            com.tencent.mm.sdk.b.a.xef.c(this.xFq);
            com.tencent.mm.sdk.b.a.xef.c(this.qdj);
            com.tencent.mm.bf.l.Tz().j(this);
            ar.Hg();
            com.tencent.mm.z.c.Fd().b(this);
            ar.Hg();
            com.tencent.mm.z.c.b(this);
            ar.Hg();
            com.tencent.mm.z.c.CU().b(this);
            if (this.xFa != null) {
                o.Pv().le(this.xFa);
            }
            if (this.xFd != null) {
                o.Pv().le(this.xFd);
            }
        }
        if (n.qQC != null) {
            n.qQC.b(this);
        }
    }

    protected final void clx() {
        x.i("MicroMsg.FindMoreFriendsUI", "on tab stop");
    }

    protected final void cly() {
        x.i("MicroMsg.FindMoreFriendsUI", "on tab destroy");
    }

    public final void clA() {
        x.i("MicroMsg.FindMoreFriendsUI", "turn to bg");
    }

    public final void clB() {
        x.i("MicroMsg.FindMoreFriendsUI", "turn to fg");
    }

    public final void clD() {
        x.i("MicroMsg.FindMoreFriendsUI", "on tab recreate ui");
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        Object obj = 1;
        x.i("MicroMsg.FindMoreFriendsUI", "onNotifyChange");
        if (LauncherUI.cmH() == 2) {
            Object obj2 = null;
            if (this.status != com.tencent.mm.z.q.FW()) {
                this.status = com.tencent.mm.z.q.FW();
                obj2 = 1;
            }
            if (this.llS != com.tencent.mm.z.q.FX()) {
                this.llS = com.tencent.mm.z.q.FX();
                obj2 = 1;
            }
            if (this.qjL != com.tencent.mm.z.q.Gd()) {
                this.qjL = com.tencent.mm.z.q.Gd();
            } else {
                obj = obj2;
            }
            if (obj != null) {
                akJ();
            }
        }
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        Object obj2 = 1;
        x.i("MicroMsg.FindMoreFriendsUI", "onNotifyChange");
        if (LauncherUI.cmH() == 2) {
            Object obj3 = null;
            if (this.status != com.tencent.mm.z.q.FW()) {
                this.status = com.tencent.mm.z.q.FW();
                obj3 = 1;
            }
            if (this.llS != com.tencent.mm.z.q.FX()) {
                this.llS = com.tencent.mm.z.q.FX();
                obj3 = 1;
            }
            if (this.qjL != com.tencent.mm.z.q.Gd()) {
                this.qjL = com.tencent.mm.z.q.Gd();
            } else {
                obj2 = obj3;
            }
            if (obj2 != null) {
                akJ();
            }
        }
    }

    public final void cmr() {
        x.v("MicroMsg.FindMoreFriendsUI", "on tab switch in");
        com.tencent.mm.blink.b.wo().f(new 13(this));
        com.tencent.mm.plugin.aj.a.h.zW(20);
    }

    public final void cms() {
    }

    public final void GW() {
        x.i("MicroMsg.FindMoreFriendsUI", "notify comment change");
        if ((com.tencent.mm.z.q.Gd() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0) {
            if (n.qQA != null) {
                this.xEZ = n.qQA.Tq();
            }
            cmo();
            this.xEV.notifyDataSetChanged();
        }
    }
}
