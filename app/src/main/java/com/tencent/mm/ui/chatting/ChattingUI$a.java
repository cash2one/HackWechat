package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.ActionBarContainer;
import android.text.ClipboardManager;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ag.d$b;
import com.tencent.mm.g.a.bj;
import com.tencent.mm.g.a.du;
import com.tencent.mm.g.a.ep;
import com.tencent.mm.g.a.ff;
import com.tencent.mm.g.a.ix;
import com.tencent.mm.g.a.jw;
import com.tencent.mm.g.a.kb;
import com.tencent.mm.g.a.lc;
import com.tencent.mm.g.a.ll;
import com.tencent.mm.g.a.mn;
import com.tencent.mm.g.a.rt;
import com.tencent.mm.g.a.so;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsimple.ah;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect;
import com.tencent.mm.plugin.appbrand.jsapi.bp;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetOpenDeviceId;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.q$a;
import com.tencent.mm.pluginsdk.q$f;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.protocal.c.aqc;
import com.tencent.mm.protocal.c.asr;
import com.tencent.mm.protocal.c.bca;
import com.tencent.mm.protocal.c.bdl;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.AllRemindMsgUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.chatting.b.aa;
import com.tencent.mm.ui.chatting.b.ab;
import com.tencent.mm.ui.chatting.b.ab.3;
import com.tencent.mm.ui.chatting.b.ac;
import com.tencent.mm.ui.chatting.b.ad;
import com.tencent.mm.ui.chatting.b.ae;
import com.tencent.mm.ui.chatting.b.c.13;
import com.tencent.mm.ui.chatting.b.c.14;
import com.tencent.mm.ui.chatting.b.c.15;
import com.tencent.mm.ui.chatting.b.c.16;
import com.tencent.mm.ui.chatting.b.c.8;
import com.tencent.mm.ui.chatting.b.d;
import com.tencent.mm.ui.chatting.b.f;
import com.tencent.mm.ui.chatting.b.f.4;
import com.tencent.mm.ui.chatting.b.i;
import com.tencent.mm.ui.chatting.b.i.2;
import com.tencent.mm.ui.chatting.b.j;
import com.tencent.mm.ui.chatting.b.k;
import com.tencent.mm.ui.chatting.b.l;
import com.tencent.mm.ui.chatting.b.m;
import com.tencent.mm.ui.chatting.b.n;
import com.tencent.mm.ui.chatting.b.o;
import com.tencent.mm.ui.chatting.b.p;
import com.tencent.mm.ui.chatting.b.s;
import com.tencent.mm.ui.chatting.b.u.1;
import com.tencent.mm.ui.chatting.b.u.10;
import com.tencent.mm.ui.chatting.b.u.11;
import com.tencent.mm.ui.chatting.b.u.12;
import com.tencent.mm.ui.chatting.b.u.9;
import com.tencent.mm.ui.chatting.b.v;
import com.tencent.mm.ui.chatting.b.w;
import com.tencent.mm.ui.chatting.b.x.5;
import com.tencent.mm.ui.chatting.b.y;
import com.tencent.mm.ui.chatting.b.z;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.bd;
import com.tencent.recovery.wx.util.NetUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class ChattingUI$a extends u implements e, com.tencent.mm.plugin.messenger.foundation.a.a.c.a, com.tencent.mm.sdk.e.j.a, b, p {
    public static String ywi;
    public static boolean ywx = false;
    public x fAh;
    private String fzi = null;
    private final c gzG = new ag(com.tencent.mm.ui.chatting.ag.a.yxx, null);
    public boolean hHG = false;
    @SuppressLint({"HandlerLeak"})
    private af handler = new af();
    private long mBackOnKeyDownTS = 0;
    private boolean mHasBackOnKeyDown = false;
    public ClipboardManager mxl;
    public boolean nWQ = true;
    MMPullDownView onH;
    public r tipDialog = null;
    boolean vqi = false;
    private boolean xLk = false;
    private int yi = 0;
    public boolean ypn = false;
    public ae yqp;
    private q yqq;
    private long[] ysb = null;
    public q ysf;
    private String ysi;
    public boolean ysk = false;
    public ac yvI;
    public ab yvJ;
    public s yvK;
    public i yvL;
    public aa yvM;
    public o yvN;
    public w yvO;
    public com.tencent.mm.ui.chatting.b.x yvP;
    public l yvQ;
    public com.tencent.mm.ui.chatting.b.q yvR;
    public ad yvS;
    public v yvT;
    public com.tencent.mm.ui.chatting.b.b yvU;
    public m yvV;
    public d yvW;
    public com.tencent.mm.ui.chatting.b.r yvX;
    public com.tencent.mm.ui.chatting.b.u yvY;
    public j yvZ;
    private boolean ywA = false;
    private long ywB = 0;
    boolean ywC = false;
    public ChattingFooterMoreBtnBar ywD;
    public s ywE;
    private n ywF = null;
    public int ywG = -1;
    private com.tencent.mm.ui.bindqq.b ywH;
    private final ak ywI = new ak(new com.tencent.mm.sdk.platformtools.ak.a(this) {
        final /* synthetic */ ChattingUI$a ywR;

        {
            this.ywR = r1;
        }

        public final boolean uF() {
            this.ywR.ysf.crL();
            return true;
        }
    }, true);
    private View ywJ;
    private boolean ywK = false;
    private Runnable ywL = new 12(this);
    private boolean ywM = false;
    private boolean ywN = false;
    private int ywO = 0;
    private final int ywP = 10;
    public boolean ywQ = false;
    public com.tencent.mm.ui.chatting.b.a ywa;
    public y ywb;
    public com.tencent.mm.ui.chatting.b.e ywc;
    public com.tencent.mm.ui.chatting.b.c ywd;
    public n ywe;
    private z ywf;
    public k ywg;
    public f ywh;
    private int ywj = -1;
    private View ywk;
    private TextView ywl;
    public boolean ywm = false;
    private boolean ywn = false;
    private bc ywo;
    ListView ywp;
    private boolean ywq = true;
    private boolean ywr = false;
    private final List<ChattingUI.b> yws = new LinkedList();
    private int ywt = 0;
    private com.tencent.mm.ui.base.i ywu = null;
    public boolean ywv = false;
    protected boolean yww = false;
    protected boolean ywy = true;
    private long ywz = -1;

    interface a {
    }

    static /* synthetic */ boolean o(ChattingUI$a chattingUI$a) {
        if (!com.tencent.mm.z.s.hn(chattingUI$a.crz()) && com.tencent.mm.z.s.eV(chattingUI$a.crz())) {
            ar.Hg();
            aj WY = com.tencent.mm.z.c.Fd().WY(chattingUI$a.crz());
            if (WY == null || (WY.field_showTips & 1) > 0) {
                return false;
            }
            ar.Hg();
            if (com.tencent.mm.z.c.EY().WO(chattingUI$a.crz()).fWn == 1 && chattingUI$a.ywt >= 40) {
                return true;
            }
        }
        return false;
    }

    public final boolean csd() {
        return this.ypn;
    }

    public final boolean cse() {
        return this.ysk;
    }

    public final boolean csf() {
        return this.ywd.vnK;
    }

    public final boolean csg() {
        return this.ywd.yyK;
    }

    public final boolean csh() {
        return this.ywv;
    }

    public final x csi() {
        return this.fAh;
    }

    public final void U(x xVar) {
        this.fAh = xVar;
    }

    public final String vS() {
        return this.fzi;
    }

    public final String crz() {
        if (this.fAh == null) {
            return null;
        }
        if (x.gy(this.fAh.field_username)) {
            return this.ysi;
        }
        return this.fAh.field_username;
    }

    public final boolean csj() {
        return this.ywn;
    }

    public final void mH(boolean z) {
        this.ywn = z;
    }

    public final void Zd(String str) {
        this.ysi = str;
    }

    public final String csk() {
        return this.ysi;
    }

    public final boolean csl() {
        return this.vqi;
    }

    public final void mI(boolean z) {
        this.vqi = z;
    }

    public final boolean csm() {
        return this.ywE != null && this.ywE.ytm;
    }

    public final com.tencent.mm.ag.d csn() {
        return this.ywd.kEC;
    }

    public final com.tencent.mm.ag.a.c cso() {
        return this.ywd.ync;
    }

    public final com.tencent.mm.ag.a.j csp() {
        return this.ywd.piK;
    }

    public final u csq() {
        return this;
    }

    public final boolean csr() {
        return this.ywC;
    }

    public final af css() {
        return this.handler;
    }

    public final void cpl() {
        if (this.ysf != null) {
            this.ysf.notifyDataSetChanged();
        }
    }

    public final long cst() {
        return this.ywB;
    }

    public final boolean csu() {
        return this.xLk;
    }

    public final void mJ(boolean z) {
        this.xLk = z;
    }

    public final String csv() {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "getSender " + (this.ywo == null) + " " + (this.ywo == null ? com.tencent.mm.z.q.FS() : this.ywo.name));
        return this.ywo == null ? com.tencent.mm.z.q.FS() : this.ywo.name;
    }

    public final bc csw() {
        return this.ywo;
    }

    public final ListView csx() {
        return this.ywp;
    }

    public final q csy() {
        return this.ysf;
    }

    public final MMPullDownView csz() {
        return this.onH;
    }

    public final s csA() {
        return this.ywE;
    }

    public final ChatFooter csB() {
        return this.ywe.csB();
    }

    public final ChatFooterCustom csC() {
        return this.ywe.csC();
    }

    public final void dismissDialog() {
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
    }

    public final void b(r rVar) {
        this.tipDialog = rVar;
    }

    public final void cri() {
        if (this.yqq != null) {
            this.yqq.dismiss();
        }
    }

    public final boolean csD() {
        return this.yvY.ysa;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cqY() {
        f fVar = this.ywh;
        if (com.tencent.mm.z.s.gB(fVar.fhr.crz())) {
            fVar.fhr.csq().setMMTitle(fVar.fhr.csi().AP());
        } else if (fVar.yvY.yAH) {
            fVar.fhr.csq().setMMTitle(R.l.eIv);
        } else if (x.Wx(fVar.fhr.crz())) {
            ChatFooter csB = fVar.fhr.csB();
            csB.vpU = (TextView) csB.lWv.findViewById(R.h.bVE);
            csB.okv.setFilters(new InputFilter[]{new LengthFilter(com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX)});
            fVar.fhr.csq().setMMTitle(fVar.fhr.csi().AQ());
        } else if (com.tencent.mm.z.s.hk(fVar.fhr.crz())) {
            fVar.fhr.csq().setMMTitle(fVar.fhr.csi().AP());
        } else if (x.gy(fVar.fhr.crz())) {
            String city;
            u csq = fVar.fhr.csq();
            u csq2 = fVar.fhr.csq();
            int i = R.l.dMG;
            Object[] objArr = new Object[1];
            x csi = fVar.fhr.csi();
            if (csi != null) {
                if (RegionCodeDecoder.XE(csi.getCountryCode())) {
                    city = csi.getCity();
                    if (bh.ov(city)) {
                        city = com.tencent.mm.z.r.gw(csi.getProvince());
                        if (bh.ov(city)) {
                            RegionCodeDecoder.cjP();
                            city = RegionCodeDecoder.getLocName(csi.getCountryCode());
                        }
                    }
                } else {
                    city = com.tencent.mm.z.r.gw(csi.getProvince());
                }
                objArr[0] = city;
                csq.setMMTitle(csq2.getMMString(i, objArr).trim());
            }
            city = fVar.fhr.csq().getMMString(R.l.dMZ);
            objArr[0] = city;
            csq.setMMTitle(csq2.getMMString(i, objArr).trim());
        } else if (!fVar.fhr.cse()) {
            int i2;
            com.tencent.mm.ui.chatting.b.c cVar = fVar.ywd;
            if (cVar.vnK) {
                if (cVar.yyK) {
                    int aY = com.tencent.mm.ag.a.e.aY(cVar.cti());
                    if (!bh.ov(cVar.ync.field_chatName)) {
                        cVar.fhr.csq().setMMTitle(cVar.fhr.csq().getMMString(R.l.eiu, new Object[]{cVar.ync.field_chatName, Integer.valueOf(aY)}));
                    } else if (aY == 0) {
                        cVar.fhr.csq().setMMTitle(cVar.fhr.csq().getMMString(R.l.dSN));
                    } else {
                        cVar.fhr.csq().setMMTitle(cVar.fhr.csq().getMMString(R.l.eiu, new Object[]{cVar.fhr.csq().getMMString(R.l.dSN), Integer.valueOf(aY)}));
                    }
                } else {
                    cVar.fhr.csq().setMMTitle(cVar.piK.field_userName);
                }
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 == 0) {
                fVar.fhr.csq().setMMTitle(fVar.fhr.csi().AQ());
                fVar.yzp.lL(x.Wz(fVar.fhr.crz()));
            }
        } else if (!bh.ov(fVar.fhr.csi().field_nickname)) {
            fVar.fhr.csq().setMMTitle(fVar.fhr.csq().getMMString(R.l.eiu, new Object[]{fVar.fhr.csi().AP(), Integer.valueOf(com.tencent.mm.z.m.gl(fVar.fhr.crz()))}));
        } else if (com.tencent.mm.z.m.gl(fVar.fhr.crz()) == 0) {
            fVar.fhr.csq().setMMTitle(fVar.fhr.csq().getMMString(R.l.dSN));
        } else {
            fVar.fhr.csq().setMMTitle(fVar.fhr.csq().getMMString(R.l.eiu, new Object[]{fVar.fhr.csq().getMMString(R.l.dSN), Integer.valueOf(com.tencent.mm.z.m.gl(fVar.fhr.crz()))}));
        }
    }

    public static ChattingUI$a csE() {
        return new ChattingUI$a();
    }

    public ChattingUI$a() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "ChattingUIFragmet: %d ", new Object[]{Integer.valueOf(hashCode())});
        Bundle bundle = new Bundle();
        bundle.putInt(getClass().getName(), Integer.MAX_VALUE);
        setArguments(bundle);
        csF();
    }

    @SuppressLint({"ValidFragment"})
    public ChattingUI$a(boolean z) {
        super(true);
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "ChattingUIFragmet(%b): %d ", new Object[]{Boolean.valueOf(true), Integer.valueOf(hashCode())});
        Bundle bundle = new Bundle();
        bundle.putInt(getClass().getName(), Integer.MAX_VALUE);
        setArguments(bundle);
        csF();
    }

    private void csF() {
        if (this.yvI == null) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "initConponentImp");
            this.yvI = new ac(this);
            this.yvJ = new ab(this);
            this.yvK = new s(this);
            this.yvL = new i(this);
            this.yvM = new aa(this);
            this.yvN = new o(this);
            this.yvO = new w(this);
            this.yvP = new com.tencent.mm.ui.chatting.b.x(this);
            this.yvQ = new l(this);
            this.yvR = new com.tencent.mm.ui.chatting.b.q(this);
            this.yvS = new ad(this);
            this.yvT = new v(this);
            this.yvU = new com.tencent.mm.ui.chatting.b.b(this);
            this.yqp = new ae(this);
            this.yvV = new m(this);
            this.yvW = new d(this);
            this.yvX = new com.tencent.mm.ui.chatting.b.r(this);
            this.yvY = new com.tencent.mm.ui.chatting.b.u(this);
            this.yvZ = new j(this);
            this.ywa = new com.tencent.mm.ui.chatting.b.a(this);
            this.ywf = new z(this);
            this.ywd = new com.tencent.mm.ui.chatting.b.c(this);
            this.ywe = new n(this);
            this.ywb = new y(this);
            this.ywc = new com.tencent.mm.ui.chatting.b.e(this);
            this.ywg = new k(this);
            this.ywh = new f(this);
            this.yvT.yvQ = this.yvQ;
            this.yvT.yvS = this.yvS;
            this.yvR.yAv = this.ywh;
            this.yvX.yvM = this.yvM;
            n nVar = this.ywe;
            com.tencent.mm.ui.chatting.b.u uVar = this.yvY;
            com.tencent.mm.ui.chatting.b.q qVar = this.yvR;
            com.tencent.mm.ui.chatting.b.c cVar = this.ywd;
            v vVar = this.yvT;
            i iVar = this.yvL;
            j jVar = this.yvZ;
            nVar.yvY = uVar;
            nVar.yvR = qVar;
            nVar.ywd = cVar;
            nVar.yvT = vVar;
            nVar.yvL = iVar;
            nVar.yvZ = jVar;
            this.ywd.ywe = this.ywe;
            j jVar2 = this.yvZ;
            n nVar2 = this.ywe;
            com.tencent.mm.ui.chatting.b.c cVar2 = this.ywd;
            jVar2.ywe = nVar2;
            jVar2.ywd = cVar2;
            y yVar = this.ywb;
            com.tencent.mm.ui.chatting.b.c cVar3 = this.ywd;
            qVar = this.yvR;
            com.tencent.mm.ui.chatting.b.a aVar = this.ywa;
            com.tencent.mm.ui.chatting.b.e eVar = this.ywc;
            yVar.ywd = cVar3;
            yVar.yvR = qVar;
            yVar.ywa = aVar;
            yVar.ywc = eVar;
            com.tencent.mm.ui.chatting.b.e eVar2 = this.ywc;
            cVar3 = this.ywd;
            aa aaVar = this.yvM;
            eVar2.ywd = cVar3;
            eVar2.yvM = aaVar;
            k kVar = this.ywg;
            uVar = this.yvY;
            v vVar2 = this.yvT;
            ad adVar = this.yvS;
            com.tencent.mm.ui.chatting.b.a aVar2 = this.ywa;
            y yVar2 = this.ywb;
            kVar.yvY = uVar;
            kVar.yvT = vVar2;
            kVar.yvS = adVar;
            kVar.ywa = aVar2;
            kVar.ywb = yVar2;
            f fVar = this.ywh;
            cVar3 = this.ywd;
            com.tencent.mm.ui.chatting.b.u uVar2 = this.yvY;
            com.tencent.mm.ui.chatting.b.q qVar2 = this.yvR;
            com.tencent.mm.ui.chatting.b.b bVar = this.yvU;
            j jVar3 = this.yvZ;
            fVar.ywd = cVar3;
            fVar.yvY = uVar2;
            fVar.yvR = qVar2;
            fVar.yvU = bVar;
            fVar.yvZ = jVar3;
        }
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
        if (bundle != null && !bundle.containsKey(getClass().getName())) {
            bundle.putInt(getClass().getName(), Integer.MAX_VALUE);
        }
    }

    @SuppressLint({"DefaultLocale"})
    public final String gu(String str) {
        return this.ywc.gu(str);
    }

    @TargetApi(9)
    public final void mK(boolean z) {
        if (!getLandscapeMode()) {
            return;
        }
        if (!z) {
            setRequestedOrientation(-1);
        } else if (VERSION.SDK_INT >= 9) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "rotation %d", new Object[]{Integer.valueOf(getWindowManager().getDefaultDisplay().getOrientation())});
            switch (getWindowManager().getDefaultDisplay().getOrientation()) {
                case 0:
                    setRequestedOrientation(1);
                    return;
                case 1:
                    setRequestedOrientation(0);
                    return;
                case 2:
                    setRequestedOrientation(9);
                    return;
                case 3:
                    setRequestedOrientation(8);
                    return;
                default:
                    return;
            }
        } else if (getMMResources().getConfiguration().orientation == 2) {
            setRequestedOrientation(0);
        } else if (getMMResources().getConfiguration().orientation == 1) {
            setRequestedOrientation(1);
        }
    }

    public boolean getUserVisibleHint() {
        return !csP();
    }

    protected int getLayoutId() {
        return R.i.dcT;
    }

    protected View getLayoutView() {
        boolean z = true;
        String str = "MicroMsg.ChattingUI";
        String str2 = "call getLayoutView, result is NULL ? %B";
        Object[] objArr = new Object[1];
        if (this.ywJ != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        com.tencent.mm.sdk.platformtools.x.d(str, str2, objArr);
        return this.ywJ;
    }

    protected void dealContentView(View view) {
        super.dealContentView(view);
        f fVar = this.ywh;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.ChattingHeadereMgr", "dealContentView");
        if (fVar.ctq()) {
            if (fVar.yzn == null) {
                fVar.yzn = (ActionBarContainer) ((ViewStub) view.findViewById(R.h.bTN)).inflate();
            }
            fVar.yzo.xJY.Fl = (ViewGroup) view;
        }
    }

    public final void d(View view, View view2) {
        boolean z;
        boolean z2 = true;
        String str = "MicroMsg.ChattingUI";
        String str2 = "call prepareLayoutView, mLayoutViewCache cache is NULL ? %B";
        Object[] objArr = new Object[1];
        if (this.ywJ == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        com.tencent.mm.sdk.platformtools.x.d(str, str2, objArr);
        this.ywJ = view;
        f fVar = this.ywh;
        str = "MicroMsg.ChattingUI.ChattingHeadereMgr";
        str2 = "call prepareLayoutView, mAbContentViewCache cache is NULL ? %B";
        objArr = new Object[1];
        if (view2 != null) {
            z2 = false;
        }
        objArr[0] = Boolean.valueOf(z2);
        com.tencent.mm.sdk.platformtools.x.d(str, str2, objArr);
        fVar.yzq = view2;
    }

    public void setMMTitle(int i) {
        setMMTitle(getMMString(i));
    }

    public void setMMTitle(String str) {
        f fVar = this.ywh;
        fVar.fhr.csq().thisResources().getDimensionPixelSize(R.f.bus);
        fVar.yzp.setTitle(com.tencent.mm.pluginsdk.ui.d.i.c(fVar.fhr.csq().getContext(), str, com.tencent.mm.bv.a.aa(fVar.fhr.csq().getContext(), R.f.bus)));
        fVar.fhr.csq().updateDescription(fVar.fhr.csq().getMMString(R.l.dQB, new Object[]{r1}));
    }

    public void setMMSubTitle(String str) {
        f fVar = this.ywh;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.ChattingHeadereMgr", "now connect state, text : %s", new Object[]{str});
        CharSequence c = com.tencent.mm.pluginsdk.ui.d.i.c(fVar.fhr.csq().getContext(), str, com.tencent.mm.bv.a.aa(fVar.fhr.csq().getContext(), R.f.bvs));
        com.tencent.mm.ui.b bVar = fVar.yzp;
        if (c == null || bh.ov(c.toString())) {
            bVar.xDw.setVisibility(8);
            return;
        }
        bVar.xDw.setVisibility(0);
        bVar.xDw.setText(c);
        if (com.tencent.mm.bv.a.ey(bVar.xDw.getContext())) {
            bVar.xDw.setTextSize(1, 14.0f);
            bVar.iiq.setTextSize(1, 18.0f);
        }
    }

    public void setMMSubTitle(int i) {
        setMMSubTitle(getMMString(i));
    }

    public void setBackBtn(OnMenuItemClickListener onMenuItemClickListener) {
        this.ywh.setBackBtn(onMenuItemClickListener);
    }

    public void setTitlePhoneIconVisibility(int i) {
        int i2;
        int i3 = 0;
        com.tencent.mm.ui.b bVar = this.ywh.yzp;
        if (i == 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        ImageView imageView = bVar.xDy;
        if (i2 == 0) {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    public void setTitleMuteIconVisibility(int i) {
        com.tencent.mm.ui.b bVar;
        com.tencent.mm.ui.b bVar2;
        int i2;
        ImageView imageView;
        int i3 = 0;
        f fVar = this.ywh;
        if (com.tencent.mm.z.s.hi(fVar.fhr.crz())) {
            bVar = fVar.yzp;
        } else {
            bVar = fVar.yzp;
            if (i == 0) {
                bVar2 = bVar;
                i2 = 1;
                imageView = bVar2.xDx;
                if (i2 == 0) {
                    i3 = 8;
                }
                imageView.setVisibility(i3);
            }
        }
        bVar2 = bVar;
        i2 = 0;
        imageView = bVar2.xDx;
        if (i2 == 0) {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    public final void Fz(int i) {
        int i2;
        int i3 = 0;
        com.tencent.mm.ui.b bVar = this.ywh.yzp;
        if (i == 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        ImageView imageView = bVar.xDA;
        if (i2 == 0) {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    public final void csG() {
        q qVar;
        int i = 100;
        this.ywr = true;
        this.ywm = true;
        w wVar = this.yvO;
        wVar.yBi = false;
        wVar.yBj = false;
        ywi = this.fAh.field_username;
        ar.Hg();
        aj WY = com.tencent.mm.z.c.Fd().WY(this.fAh.field_username);
        if (WY != null) {
            this.ywt = WY.field_unReadCount;
            List list = null;
            if (this.ywd.vnK) {
                com.tencent.mm.ui.chatting.b.c cVar = this.ywd;
                com.tencent.mm.ag.a.a aS = com.tencent.mm.ag.y.Mi().aS(cVar.cti());
                if (aS.field_unReadCount <= 100) {
                    i = aS.field_unReadCount;
                }
                ar.Hg();
                list = com.tencent.mm.z.c.Fb().h(cVar.fhr.csi().field_username, cVar.cti(), i);
            } else if (WY != null && WY.field_unReadCount > 0) {
                if (WY.field_unReadCount <= 100) {
                    i = WY.field_unReadCount;
                }
                ar.Hg();
                list = com.tencent.mm.z.c.Fa().bx(this.fAh.field_username, i);
            }
            if (list != null) {
                if (list.size() > 0) {
                    this.ywB = ((au) list.get(0)).field_createTime;
                }
                x xVar = this.ywb.yBL;
                if (!(xVar.ywZ == null || xVar.fhr == null)) {
                    z zVar = xVar.ywZ;
                    Activity thisActivity = xVar.fhr.csq().thisActivity();
                    zVar.kJF = list;
                    zVar.yxe = thisActivity;
                    if (zVar.mHandler != null) {
                        zVar.mHandler.sendEmptyMessageDelayed(0, 800);
                    }
                }
            }
            if (this.ywB == 0) {
                cf ak;
                if (this.ywd.vnK) {
                    ar.Hg();
                    ak = com.tencent.mm.z.c.Fb().ak(this.fAh.field_username, this.ywd.cti());
                } else {
                    ar.Hg();
                    ak = com.tencent.mm.z.c.Fa().Ew(this.fAh.field_username);
                }
                if (!(ak == null || bh.ov(ak.field_talker))) {
                    this.ywB = ak.field_createTime;
                }
            }
        }
        removeAllOptionMenu();
        cqZ();
        if (this.ypn) {
            com.tencent.mm.be.d.chatType = 1;
        } else {
            com.tencent.mm.be.d.chatType = 0;
        }
        cqY();
        this.ywg.ctE();
        this.yvU.bSr();
        if (this.ywA && this.ywF == null) {
            this.ywF = new n(this, this.ysf, this.ywe.csB(), this.ywe.csC(), this.fAh, this.ypn, this.ysb);
            n nVar = this.ywF;
            nVar.yrW.yvY.ctV();
            qVar = nVar.yrX;
            qVar.ytn = true;
            qVar.crP();
            nVar.yrX.crO();
            if (nVar.ysb != null) {
                for (long fW : nVar.ysb) {
                    nVar.yrX.fW(fW);
                }
            }
            if (nVar.yrY != null) {
                nVar.yrY.setVisibility(8);
            }
            if (nVar.yrZ != null) {
                nVar.yrZ.setVisibility(8);
            }
            nVar.yrW.ywg.ctD();
            nVar.yrW.hideVKB();
            nVar.yrW.csN();
            nVar.yrW.showOptionMenu(2, true);
        }
        qVar = this.ysf;
        String crz = crz();
        d dVar = this.yqp.ysR;
        String csv = csv();
        qVar.ytp = new TreeSet();
        qVar.ysS = crz;
        if (x.gy(crz)) {
            qVar.hlJ = x.WD(csv);
        } else {
            qVar.hlJ = csv;
        }
        qVar.ysR = dVar;
        com.tencent.mm.sdk.b.b ixVar = new ix();
        ixVar.fzx.fzr = 0;
        ixVar.fzx.ael = com.tencent.mm.sdk.platformtools.w.cfi();
        if (com.tencent.mm.z.s.eV(crz)) {
            ixVar.fzx.fzz = true;
        } else {
            ixVar.fzx.fzz = false;
        }
        com.tencent.mm.sdk.b.a.xef.m(ixVar);
        qVar.talker = crz;
        qVar.kGB = qVar.ysg.ywd.cti();
        qVar.crI();
    }

    public final void csH() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "jacks onFragment Close");
        this.ywr = false;
        j jVar = this.yvZ;
        if (jVar.fhr.csf()) {
            com.tencent.mm.ag.a.a aS = com.tencent.mm.ag.y.Mi().aS(jVar.ywd.cti());
            if (jVar.fhr.csB() != null && (jVar.yzP == null || !jVar.fhr.csB().cbs().trim().equals(jVar.yzP))) {
                jVar.yzP = jVar.fhr.csB().cbs().trim();
                aS.field_editingMsg = jVar.yzP;
                aS.field_flag = com.tencent.mm.ag.a.b.a(aS, 1, bh.ov(aS.field_editingMsg) ? aS.field_lastMsgTime : System.currentTimeMillis());
                com.tencent.mm.ag.y.Mi().b(aS);
                com.tencent.mm.sdk.platformtools.x.v("MicroMsg.ChattingUI.SearchImp", "set editMsg history");
            }
        } else {
            aj WY;
            aj ajVar;
            if (g.Dh().Cy()) {
                ar.Hg();
                WY = com.tencent.mm.z.c.Fd().WY(jVar.fhr.crz());
            } else {
                WY = null;
            }
            if (WY != null || jVar.fhr.csB() == null || bh.ov(jVar.fhr.csB().cbs().trim())) {
                ajVar = WY;
            } else {
                WY = new com.tencent.mm.storage.ae(jVar.fhr.csi().field_username);
                WY.aj(System.currentTimeMillis());
                if (jVar.fhr.csj()) {
                    WY.gb(4194304);
                }
                ar.Hg();
                com.tencent.mm.z.c.Fd().d(WY);
                ajVar = WY;
            }
            if (!(ajVar == null || jVar.fhr.csB() == null || (jVar.yzP != null && jVar.fhr.csB().cbs().trim().equals(jVar.yzP)))) {
                jVar.yzP = jVar.fhr.csB().cbs().trim();
                ajVar.dI(jVar.fhr.csB().cbs().trim());
                ajVar.ak(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(ajVar, 1, bh.ov(ajVar.field_editingMsg) ? ajVar.field_conversationTime : System.currentTimeMillis()));
                ar.Hg();
                com.tencent.mm.z.c.Fd().a(ajVar, ajVar.field_username, false);
                com.tencent.mm.sdk.platformtools.x.v("MicroMsg.ChattingUI.SearchImp", "jacks set editMsg history");
            }
        }
        com.tencent.mm.ui.chatting.b.c cVar = this.ywd;
        com.tencent.mm.z.bc.w("bizflag", false);
        if (cVar.vnK) {
            cVar.ctk();
            com.tencent.mm.ag.y.Mq();
            com.tencent.mm.ag.a.c cVar2 = cVar.ync;
            if (com.tencent.mm.kernel.a.gB(g.Dh().gPs)) {
                com.tencent.mm.modelsimple.aj.a(cVar2.field_brandUserName, 8, "EnterpriseChatStatus", String.format("%s;%s;%d", new Object[]{cVar2.field_brandUserName, cVar2.field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000)}));
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BizChatStatusNotifyService", "quitChat:arg:%s", new Object[]{r2});
            }
        }
        if (ar.Hj()) {
            if (cVar.vnK) {
                com.tencent.mm.ag.y.Mh().a(cVar.ynH);
            }
            if (cVar.fhr.csi() != null && cVar.fhr.csi().cia()) {
                com.tencent.mm.ag.y.Mf().a(cVar.yyP);
            }
            if (com.tencent.mm.l.a.fZ(cVar.fhr.csi().field_type) && cVar.fhr.csi().cia() && !com.tencent.mm.ag.f.eE(cVar.fhr.crz())) {
                com.tencent.mm.ag.y.Mo();
                com.tencent.mm.ag.k.kd(cVar.fhr.crz());
            }
            com.tencent.mm.ag.y.Mn().b(cVar.yyN);
        }
        if (com.tencent.mm.app.plugin.a.a.a(cVar.kEC) && cVar.yyI != null) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.BizMgr", "hardevice brand account, init event : %s, notify exit chattingui", new Object[]{cVar.fhr.csX()});
            cVar.yyI.a(2, cVar.kEC);
            cVar.fhr.csq().setMMSubTitle(null);
        }
        if (com.tencent.mm.l.a.fZ(cVar.fhr.csi().field_type) && cVar.fhr.csi().cia() && cVar.yyJ != 0 && cVar.fhr.csq().getIntExtra("biz_click_item_position", 0) > 0) {
            com.tencent.mm.plugin.report.service.g.pQN.h(10638, new Object[]{cVar.fhr.crz(), Integer.valueOf(((int) (System.currentTimeMillis() - cVar.yyJ)) / 1000), Integer.valueOf(cVar.fhr.csq().getIntExtra("biz_click_item_unread_count", 0)), Integer.valueOf(cVar.fhr.csq().getIntExtra("biz_click_item_position", 0))});
            cVar.yyJ = 0;
        }
        if (cVar.yyI != null) {
            com.tencent.mm.app.plugin.a.a aVar = cVar.yyI;
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now release the event listener");
            if (aVar.fhs != null) {
                com.tencent.mm.sdk.b.a.xef.c(aVar.fhs);
                aVar.fhs = null;
                if (aVar.fhv != null) {
                    aVar.fhv.clear();
                }
            }
            aVar.fhw = false;
            if (aVar.fht != null) {
                com.tencent.mm.sdk.b.a.xef.c(aVar.fht);
                aVar.fht = null;
            }
            cVar.yyI = null;
        }
        com.tencent.mm.sdk.b.b rtVar = new rt();
        rtVar.fJy.type = 3;
        com.tencent.mm.sdk.b.a.xef.m(rtVar);
        this.yvS.yCC.clear();
        com.tencent.mm.plugin.sight.decode.a.b.Es();
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "[unregitListener]");
        com.tencent.mm.aq.o.Pu().hBa = null;
        ar.CG().b(522, this);
        ar.CG().b(110, this);
        ar.CG().b(10, this);
        ar.CG().b(127, this);
        ar.CG().b(594, this);
        ar.CG().b(551, this);
        ar.CG().b(525, this);
        ar.CG().b(610, this);
        ar.CG().b(137, this);
        com.tencent.mm.ui.chatting.b.e eVar = this.ywc;
        com.tencent.mm.pluginsdk.d.b.b(jw.class.getName(), eVar.yze);
        com.tencent.mm.pluginsdk.d.b.b(kb.class.getName(), eVar.yze);
        if (ar.Hj()) {
            ar.Hg();
            com.tencent.mm.z.c.Fh().j(eVar.yzc);
            com.tencent.mm.sdk.b.a.xef.c(eVar.yzb);
            com.tencent.mm.sdk.b.a.xef.c(eVar.yzd);
        }
        ar.CG().b(223, this);
        com.tencent.mm.ui.chatting.b.a aVar2 = this.ywa;
        am amVar = aVar2.yyA;
        aVar2.fhr.csq().getContext();
        am.yya.remove(amVar);
        amVar.yxZ.clear();
        am.a(amVar.yxY.getContext(), null);
        if (ar.Hj()) {
            an.aqd().j(aVar2.yyB);
            an.bin().j(aVar2.yyC);
        }
        o oVar = this.yvN;
        oVar.TG();
        com.tencent.mm.sdk.b.a.xef.c(oVar.yAr);
        com.tencent.mm.ui.chatting.gallery.f fVar = oVar.yAt;
        fVar.tj.clear();
        fVar.aOt();
        if (ar.Hj()) {
            ar.Hg();
            com.tencent.mm.z.c.EY().b(this);
            com.tencent.mm.sdk.b.a.xef.c(this.yvI.yCy);
            com.tencent.mm.sdk.b.a.xef.c(this.yvR.yAz);
            com.tencent.mm.storage.as.a aVar3 = this.yvO;
            com.tencent.mm.sdk.b.a.xef.c(aVar3.yBm);
            ar.Hg();
            com.tencent.mm.z.c.Fd().a(aVar3);
            ar.Hg();
            com.tencent.mm.z.c.Fa().a(this);
            com.tencent.mm.sdk.b.a.xef.c(this.yvK.jeX);
            com.tencent.mm.ad.n.Jz().b(this.ywh.yzt);
            l lVar = this.yvQ;
            com.tencent.mm.sdk.b.a.xef.c(lVar.yzW);
            com.tencent.mm.sdk.b.a.xef.c(lVar.yzX);
        }
        y yVar = this.ywb;
        if (yVar.yBL != null) {
            x xVar = yVar.yBL;
            if (xVar.ywZ != null) {
                z zVar = xVar.ywZ;
                zVar.mHandler.removeMessages(0);
                if (zVar.yxd != null) {
                    zVar.yxd.stop();
                }
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.EggMgr", "egg has been stop");
            }
        }
        HardCoderJNI.stopPerformace(HardCoderJNI.hcSendMsgEnable, yVar.yBR);
        yVar.yBR = 0;
        com.tencent.mm.sdk.b.a.xef.m(new bj());
        cri();
        if (this.ysf != null) {
            this.ysf.crI();
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "ChattingUI resetAdapter");
        }
    }

    public void onActivityCreated(Bundle bundle) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "onActivityCreated %d", new Object[]{Integer.valueOf(hashCode())});
        super.onActivityCreated(bundle);
        cqW();
    }

    private void csI() {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "doCreateOnerousJob!!! rawUserName:%s", new Object[]{this.ysi});
        com.tencent.mm.sdk.b.b rtVar = new rt();
        rtVar.fJy.type = 4;
        com.tencent.mm.sdk.b.a.xef.m(rtVar);
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "[regitListener]");
        ar.CG().a(522, this);
        ar.CG().a(110, this);
        ar.CG().a(10, this);
        ar.CG().a(127, this);
        ar.CG().a(610, this);
        ar.CG().a(594, this);
        ar.CG().a(551, this);
        ar.CG().a(525, this);
        ar.CG().a(137, this);
        ar.Hg();
        com.tencent.mm.z.c.EY().a(this);
        ar.Hg();
        com.tencent.mm.z.c.Fa().a(this, Looper.getMainLooper());
        ar.CG().a(223, this);
        com.tencent.mm.sdk.b.a.xef.b(this.yvI.yCy);
        com.tencent.mm.sdk.b.a.xef.b(this.yvR.yAz);
        Object obj = this.yvO;
        ar.Hg();
        com.tencent.mm.z.c.Fd().a(obj, Looper.getMainLooper());
        com.tencent.mm.sdk.b.a.xef.b(obj.yBm);
        com.tencent.mm.sdk.b.a.xef.b(this.yvK.jeX);
        com.tencent.mm.sdk.b.a.xef.b(this.yvN.yAr);
        com.tencent.mm.ui.chatting.b.b bVar = this.yvU;
        com.tencent.mm.az.r.QI().c(bVar.yyG);
        com.tencent.mm.az.r.QH().c(bVar.yyG);
        com.tencent.mm.aq.o.Pu().hBa = this.yvT;
        l lVar = this.yvQ;
        com.tencent.mm.sdk.b.a.xef.b(lVar.yzW);
        com.tencent.mm.sdk.b.a.xef.b(lVar.yzX);
        com.tencent.mm.ui.chatting.b.e eVar = this.ywc;
        if (!com.tencent.mm.z.s.hn(eVar.fhr.crz()) && com.tencent.mm.z.s.eV(eVar.fhr.crz())) {
            ar.Hg();
            aj WY = com.tencent.mm.z.c.Fd().WY(eVar.fhr.crz());
            if (WY == null || (WY.field_showTips & 2) > 0) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.ChatroomImp", "jacks ont need auto display name because : already tips");
            } else {
                ar.Hg();
                com.tencent.mm.storage.q hD = com.tencent.mm.z.c.Fh().hD(eVar.fhr.crz());
                if (hD == null || hD.Ms().size() < 20) {
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.ChatroomImp", "jacks ont need auto display name because : member nums too few");
                } else if (!(hD == null || hD.chV())) {
                    com.tencent.mm.z.m.a(eVar.fhr.crz(), hD, true);
                    WY.field_showTips = 2;
                    WY.fXa = true;
                    ar.Hg();
                    com.tencent.mm.z.c.Fd().a(WY, eVar.fhr.crz());
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.ChatroomImp", "Jacks Show auto Display name tips");
                    com.tencent.mm.z.l.a(eVar.fhr.crz(), null, eVar.fhr.csq().getMMString(R.l.dTa), false, "", 0);
                }
            }
        }
        ar.Hg();
        com.tencent.mm.z.c.Fh().c(eVar.yzc);
        com.tencent.mm.pluginsdk.d.b.a(jw.class.getName(), eVar.yze);
        com.tencent.mm.pluginsdk.d.b.a(kb.class.getName(), eVar.yze);
        com.tencent.mm.sdk.b.a.xef.b(eVar.yzb);
        com.tencent.mm.sdk.b.a.xef.b(eVar.yzd);
        if (com.tencent.mm.z.s.eV(eVar.fhr.csi().field_username) && com.tencent.mm.z.m.ge(eVar.fhr.csi().field_username)) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.ChatroomImp", "chattingui find chatroom contact need update %s", new Object[]{eVar.fhr.csi().field_username});
            com.tencent.mm.z.ak.a.hfL.Q(eVar.fhr.csi().field_username, "");
        }
        if (!(q$a.vcv == null || eVar.fhr.csi().field_username.equals(q$a.vcv.aVB()))) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.ChatroomImp", "chatting oncreate end track %s", new Object[]{q$a.vcv.aVB()});
            rtVar = new ep();
            rtVar.ftg.username = eVar.fhr.csi().field_username;
            com.tencent.mm.sdk.b.a.xef.m(rtVar);
        }
        eVar.cto();
        ar.Hg();
        if (com.tencent.mm.z.c.ET()) {
            com.tencent.mm.modelsimple.aj.S(this.ysi, 2);
        }
        rtVar = new lc();
        rtVar.fCt.talker = this.fAh.field_username;
        com.tencent.mm.sdk.b.a.xef.m(rtVar);
    }

    public void cqW() {
        int i;
        x xVar;
        String str;
        String str2;
        boolean z;
        com.tencent.mm.ui.chatting.b.x xVar2 = this.yvP;
        xVar2.yBD = System.currentTimeMillis();
        xVar2.yBE = true;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "do Create !!!!");
        this.mHasBackOnKeyDown = false;
        this.ywQ = false;
        this.mBackOnKeyDownTS = 0;
        boolean ov = bh.ov(this.ysi);
        getStringExtra("Chat_User").equals(this.ysi);
        this.ywM = false;
        this.ywN = false;
        this.ywq = true;
        this.ywn = false;
        this.yvI.yCx.clear();
        this.ywy = true;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "resetBaseParams rawUserName from :%s to :%s ", new Object[]{this.ysi, getStringExtra("Chat_User")});
        this.ywn = getBooleanExtra("key_is_temp_session", false).booleanValue();
        this.ysi = getStringExtra("Chat_User");
        this.yww = getBooleanExtra("finish_direct", false).booleanValue();
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "isFromSearch  " + this.yww);
        ar.Hg();
        this.fAh = com.tencent.mm.z.c.EY().WO(this.ysi);
        com.tencent.mm.g.b.af afVar = this.fAh;
        String str3 = this.ysi;
        String str4 = "MicroMsg.ChattingUI";
        String str5 = "protectContactNotExist user:%s contact:%d ";
        Object[] objArr = new Object[2];
        objArr[0] = str3;
        if (afVar == null) {
            i = -1;
        } else {
            i = (int) afVar.gJd;
        }
        objArr[1] = Integer.valueOf(i);
        com.tencent.mm.sdk.platformtools.x.w(str4, str5, objArr);
        if (afVar == null || ((int) afVar.gJd) == 0 || bh.ov(afVar.field_username)) {
            xVar = new x();
            xVar.setUsername(str3);
            xVar.Ah();
            xVar.eC(3);
            ar.Hg();
            com.tencent.mm.z.c.EY().Q(xVar);
            ar.Hg();
            x WO = com.tencent.mm.z.c.EY().WO(str3);
            if (WO == null) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI", "protectContactNotExist contact get from db is null!");
            } else {
                xVar = WO;
            }
        } else {
            com.tencent.mm.g.b.af afVar2 = afVar;
        }
        this.fAh = xVar;
        if (bh.ov(this.fAh.field_encryptUsername)) {
            str = this.fAh.field_username;
        } else {
            str = this.fAh.field_encryptUsername;
        }
        this.fzi = str;
        this.ywA = getBooleanExtra("expose_edit_mode", false).booleanValue();
        this.ysb = getArguments().getLongArray("expose_selected_ids");
        com.tencent.mm.ui.chatting.b.q qVar = this.yvR;
        boolean booleanValue = qVar.fhr.csq().getBooleanExtra("lbs_mode", false).booleanValue();
        qVar.fhr.mI(booleanValue);
        qVar.kvB = qVar.fhr.csq().getStringExtra("lbs_ticket");
        if (booleanValue) {
            str2 = qVar.fhr.csi().field_username;
            if (!(str2 == null || com.tencent.mm.z.s.gD(str2))) {
                qVar.fhr.csi().setUsername(qVar.fhr.csk());
                qVar.fhr.csi().di(null);
                ar.Hg();
                com.tencent.mm.z.c.EY().a(str2, qVar.fhr.csi());
                qVar.fhr.Zd(qVar.fhr.csi().field_username);
            }
        }
        str = new com.tencent.mm.storage.bc.a(crz()).XH("");
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "new RoleInfo.Parser(getTalkerUserName())" + str);
        ar.Hg();
        this.ywo = com.tencent.mm.z.c.Fg().EY(str);
        str = crz();
        this.ysk = str.endsWith("@chatroom");
        this.ywv = Ze(str);
        if (this.ysk) {
            this.xLk = com.tencent.mm.z.m.gd(crz());
        }
        if (this.ysk || this.ywd.yyK) {
            z = true;
        } else {
            z = false;
        }
        this.ypn = z;
        w wVar = this.yvO;
        wVar.yBi = false;
        wVar.yBl = wVar.fhr.cse();
        f fVar = this.ywh;
        fVar.qra = fVar.fhr.csq().getIntExtra("add_scene", 0);
        fVar.ctr();
        com.tencent.mm.ad.n.Jz().a(fVar.yzt);
        fVar.setBackBtn(fVar.yzu);
        if (bh.ov(this.ysi)) {
            com.tencent.mm.plugin.report.service.g.pQN.a(110, 0, 1, true);
        }
        com.tencent.mm.booter.notification.queue.b xi = com.tencent.mm.booter.notification.queue.b.xi();
        str2 = this.fAh.field_username;
        if (!t.ov(str2)) {
            xi.gAo.eq(str2);
        }
        if (ov) {
            this.mxl = (ClipboardManager) getContext().getSystemService("clipboard");
            ar.CG().a(new bd(new 2(this.yvL)), 0);
            this.handler.post(new 23(this));
        }
        cra();
        com.tencent.mm.ui.chatting.b.c cVar = this.ywd;
        if (cVar.fhr.csq().getIntExtra("biz_click_item_position", 0) > 0) {
            cVar.yyJ = System.currentTimeMillis();
        }
        cVar.vnK = cVar.fhr.csq().getBooleanExtra("key_is_biz_chat", false).booleanValue();
        cVar.fhr.csq().getLongExtra("key_biz_chat_id", -1);
        if (cVar.vnK) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.BizMgr", "getBizChatInfo");
            ar.Dm().g(new 8(cVar), 500);
        }
        if (cVar.fhr.csi() != null && cVar.fhr.csi().cia()) {
            com.tencent.mm.ag.y.Mp().jw(cVar.fhr.csi().field_username);
        }
        cVar.ywz = cVar.fhr.csq().getLongExtra("key_biz_chat_id", -1);
        cVar.kEC = com.tencent.mm.ag.f.jS(cVar.fhr.crz());
        if (cVar.vnK) {
            cVar.ync = com.tencent.mm.ag.y.Mh().ag(cVar.ywz);
            cVar.ync = com.tencent.mm.ag.a.e.a(cVar.ync, cVar.ywz);
        }
        z = cVar.vnK && com.tencent.mm.ag.a.e.kn(cVar.ync.field_bizChatServId);
        cVar.yyK = z;
        if (cVar.vnK && !cVar.yyK) {
            cVar.piK = com.tencent.mm.ag.y.Mj().ca(cVar.ync.field_bizChatServId);
            cVar.piK = com.tencent.mm.ag.a.e.a(cVar.piK, cVar.ync.field_bizChatServId);
        }
        if (cVar.yyK) {
            cVar.fhr.mJ(com.tencent.mm.ag.a.e.c(cVar.ync));
        }
        if (com.tencent.mm.app.plugin.a.a.a(cVar.kEC) && cVar.yyI == null) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.BizMgr", "hardevice brand account, init event : %s", new Object[]{cVar.fhr.csX()});
            cVar.yyI = new com.tencent.mm.app.plugin.a.a(cVar.fhr);
        }
        if (cVar.fhr.csi().cia()) {
            com.tencent.mm.be.d.chatType = 2;
        }
        if (com.tencent.mm.l.a.fZ(cVar.fhr.csi().field_type) && cVar.fhr.csi().cia() && !com.tencent.mm.ag.f.eE(cVar.fhr.crz())) {
            com.tencent.mm.ag.y.Mo().b(cVar.fhr.crz(), cVar.fhr.csy().getCount() > 0 ? (au) cVar.fhr.csy().getItem(cVar.fhr.csy().getCount() - 1) : null);
        }
        if (cVar.vnK) {
            com.tencent.mm.ag.y.Mh().a(cVar.ynH, Looper.getMainLooper());
            com.tencent.mm.ag.y.Mn().a(cVar.yyN);
        }
        if (cVar.fhr.csi() != null && cVar.fhr.csi().cia()) {
            com.tencent.mm.ag.y.Mf().a(cVar.yyP, Looper.getMainLooper());
        }
        j jVar = this.yvZ;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.SearchImp", "jacks mark reset keybord state");
        jVar.yzQ = com.tencent.mm.ui.chatting.b.j.a.yzR;
        if (jVar.fhr.csi() != null) {
            if (jVar.fhr.csf()) {
                str2 = com.tencent.mm.ag.y.Mi().aS(jVar.ywd.cti()).field_editingMsg;
                jVar.yzO = str2;
                jVar.yzP = str2;
            } else {
                ar.Hg();
                aj WY = com.tencent.mm.z.c.Fd().WY(jVar.fhr.crz());
                if (WY != null) {
                    str2 = WY.field_editingMsg;
                    jVar.yzO = str2;
                    jVar.yzP = str2;
                }
            }
        }
        this.ywe.cqW();
        com.tencent.mm.ui.chatting.b.r rVar = this.yvX;
        com.tencent.mm.sdk.b.b ixVar = new ix();
        ixVar.fzx.fzr = 0;
        ixVar.fzx.ael = com.tencent.mm.sdk.platformtools.w.cfi();
        if (com.tencent.mm.z.s.eV(rVar.fhr.csi().field_username)) {
            ixVar.fzx.fzz = true;
        } else {
            ixVar.fzx.fzz = false;
        }
        com.tencent.mm.sdk.b.a.xef.m(ixVar);
        com.tencent.mm.ui.chatting.b.a aVar = this.ywa;
        aVar.pLQ = com.tencent.mm.plugin.wallet.a.cp(aVar.fhr.csi().field_username, 1);
        aVar.pLQ.aK(1, aVar.fhr.csi().field_username);
        an.aqd().c(aVar.yyB);
        an.bin().c(aVar.yyC);
        if (aVar.yyA == null) {
            aVar.yyA = new am(aVar.fhr);
        }
        am amVar = aVar.yyA;
        aVar.fhr.csq().getContext();
        am.yya.a(amVar, null);
        csG();
        com.tencent.mm.ui.chatting.b.u uVar = this.yvY;
        uVar.yAT = uVar.fhr.csq().getBooleanExtra("need_hight_item", false).booleanValue();
        uVar.yAH = uVar.fhr.csq().getBooleanExtra("search_chat_content", false).booleanValue();
        uVar.ysa = uVar.fhr.csq().getBooleanExtra("show_search_chat_content_result", false).booleanValue();
        uVar.yAL = uVar.fhr.csq().getStringArrayList("highlight_keyword_list");
        uVar.yAK = uVar.fhr.csq().getLongExtra("msg_local_id", -1);
        uVar.yAJ = uVar.fhr.csq().getBooleanExtra("from_global_search", false).booleanValue();
        uVar.yAI = uVar.fhr.csq().getBooleanExtra("img_gallery_enter_from_chatting_ui", false).booleanValue();
        if (uVar.yAK >= 0 && !uVar.yAU) {
            ag.h(new 1(uVar), 2000);
        }
        if (uVar.yAH) {
            com.tencent.mm.plugin.report.service.g.pQN.a(219, 11, 1, true);
            com.tencent.mm.ui.chatting.b.g.a(uVar.fhr.csq(), R.h.cJs);
            uVar.yAG = uVar.fhr.csq().findViewById(R.h.cJx);
            uVar.yAP = uVar.fhr.csq().findViewById(R.h.cJq);
            uVar.fhr.csx().setFocusable(false);
            uVar.fhr.csx().setFocusableInTouchMode(false);
            uVar.yAP.setOnClickListener(new u$6(uVar));
            if (uVar.yAN == null) {
                com.tencent.mm.ui.chatting.b.g.a(uVar.fhr.csq(), R.h.cVU);
                uVar.yAN = (TextView) uVar.fhr.csq().findViewById(R.h.ceo);
            }
            uVar.ytQ = new u(uVar.fhr.csq().getContext(), new au(), uVar.fhr.crz(), uVar.fhr.csv(), uVar.fhr.csd());
            uVar.ytQ.yuy = new u$7(uVar);
            uVar.yAO = (ListView) uVar.fhr.csq().findViewById(R.h.cJr);
            uVar.yAO.setAdapter(uVar.ytQ);
            uVar.yAO.setOnItemClickListener(new com.tencent.mm.ui.chatting.b.u.8(uVar));
            uVar.yAO.setOnTouchListener(new 9(uVar));
            uVar.lcZ = new com.tencent.mm.ui.tools.p();
            uVar.lcZ.zms = new 10(uVar);
            uVar.fhr.csq().addSearchMenu(true, uVar.lcZ);
            uVar.lcZ.nu(true);
        }
        if (uVar.ysa || uVar.yAJ) {
            long longExtra = uVar.fhr.csq().getLongExtra("msg_local_id", -1);
            int r = uVar.fhr.csy().r(longExtra, uVar.yAJ);
            Window window = uVar.fhr.csq().getWindow();
            if (window != null) {
                window.getDecorView().post(new 11(uVar, longExtra, r));
            } else {
                uVar.fhr.csx().postDelayed(new 12(uVar, longExtra, r), 100);
            }
        }
        if (this.nWQ) {
            csI();
        }
        this.yvP.cqW();
        this.handler.postDelayed(new 25(this), 3000);
    }

    public final void csJ() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "ashutest::doJobOnAnimInEnd");
        if (this.nWQ) {
            csI();
            cqX();
            y yVar = this.ywb;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.TextImp", "hardCoderEnterChattingStart %s", new Object[]{Integer.valueOf(yVar.yBP)});
            HardCoderJNI.stopPerformace(HardCoderJNI.hcEnterChattingEnable, yVar.yBP);
            yVar.yBP = 0;
        }
    }

    public final void csK() {
        int i = 10;
        if (!(this.yvY.ysa || this.yvY.yAJ)) {
            int i2 = this.ywO;
            this.ywO = i2 + 1;
            if (i2 < 10 && ((thisActivity() instanceof ChattingUI) || (thisActivity() instanceof AppBrandServiceChattingUI))) {
                ListView listView = this.ywp;
                Runnable 27 = new 27(this);
                if (this.ywO != 1) {
                    i = 100;
                }
                listView.postDelayed(27, (long) i);
                return;
            }
        }
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "scrollToLastProtect:%s, %s ,%s", new Object[]{Boolean.valueOf(this.yvY.ysa), Boolean.valueOf(this.yvY.yAJ), Integer.valueOf(this.ywO)});
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        LayoutParams layoutParams = onCreateView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -1);
        }
        onCreateView.setLayoutParams(layoutParams);
        return onCreateView;
    }

    public void onDestroy() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "dktask FragmentonDestroy %s#0x%x task:%s ", new Object[]{thisActivity().getClass().getSimpleName(), Integer.valueOf(thisActivity().hashCode()), bh.fb(thisActivity())});
        if (this.ysi != null) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "onDestroy %d", new Object[]{Integer.valueOf(hashCode())});
            this.ywe.bf();
            csH();
            com.tencent.mm.sdk.b.b ixVar = new ix();
            ixVar.fzx.fzr = 2;
            com.tencent.mm.sdk.b.a.xef.m(ixVar);
            com.tencent.mm.ui.chatting.b.b bVar = this.yvU;
            if (ar.Hj()) {
                com.tencent.mm.az.r.QI().j(bVar.yyG);
                com.tencent.mm.az.r.QH().j(bVar.yyG);
            }
            bVar.ctg();
            ae aeVar = this.yqp;
            com.tencent.mm.modelvoice.r.b(aeVar.ysR);
            com.tencent.mm.modelvoice.e.b(aeVar.ysR);
            aeVar.releaseWakeLock();
            if (aeVar.ysR != null) {
                aeVar.ysR.crc();
                com.tencent.mm.z.ad adVar = aeVar.ysR;
                adVar.release();
                adVar.yqo = null;
                adVar.yqt = false;
                com.tencent.mm.sdk.b.a.xef.c(adVar.yqy);
                ar.ux().b(adVar);
            }
            this.ysf.aUn();
            com.tencent.mm.ui.chatting.b.u uVar = this.yvY;
            uVar.yAU = true;
            if (uVar.ytQ != null) {
                uVar.ytQ.aUn();
            }
            if (uVar.lcZ != null) {
                uVar.lcZ.clearFocus();
            }
            this.ysf.xIi = null;
            ar.Hg();
            if (com.tencent.mm.z.c.ET()) {
                com.tencent.mm.modelsimple.aj.S(crz(), 5);
            }
            if (this.yvM.yCh != null) {
                this.yvM.yCh.stop();
            }
            this.ywI.TG();
            if (this.ywH != null) {
                this.ywH.onDetach();
            }
        }
        this.yvP.ctW();
        super.onDestroy();
        this.yws.clear();
    }

    public void onStart() {
        f fVar = this.ywh;
        ar.Hg().FF().a(new f$3(fVar));
        ar.Hg().FG().a(new 4(fVar));
        com.tencent.mm.z.b.b FH = ar.Hg().FH();
        com.tencent.mm.z.b.b.a aVar = fVar.yzs;
        synchronized (com.tencent.mm.z.b.b.class) {
            FH.mListeners.add(aVar);
        }
        super.onStart();
    }

    public void onStop() {
        f fVar = this.ywh;
        if (g.Dh().Cy()) {
            ar.Hg().FF().a(null);
            ar.Hg().FG().a(null);
            com.tencent.mm.z.b.b FH = ar.Hg().FH();
            com.tencent.mm.z.b.b.a aVar = fVar.yzs;
            synchronized (com.tencent.mm.z.b.b.class) {
                FH.mListeners.remove(aVar);
            }
        }
        com.tencent.mm.ui.chatting.b.q qVar = this.yvR;
        ag.K(qVar.yAx);
        ag.K(qVar.yAy);
        super.onStop();
    }

    public final boolean AI() {
        return this.yqp.AI();
    }

    public void onCreate(Bundle bundle) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "dktask FragmentonCreate:%s#0x%x task:%s hc:%d", new Object[]{thisActivity().getClass().getSimpleName(), Integer.valueOf(thisActivity().hashCode()), bh.fb(thisActivity()), Integer.valueOf(hashCode())});
        csF();
        f fVar = this.ywh;
        if (fVar.ctq()) {
            fVar.yzo = new com.tencent.mm.ui.q();
            Object obj = fVar.yzo;
            u csq = fVar.fhr.csq();
            obj.xJX = csq;
            obj.xJY = new com.tencent.mm.ui.b.b(csq.thisActivity(), obj);
            fVar.fhr.csq().setActivityController(fVar.yzo);
        }
        if (this.mController != null) {
            this.mController.ad(3, true);
        }
        super.onCreate(bundle);
    }

    protected void cqX() {
        boolean z;
        q$f com_tencent_mm_pluginsdk_q_f;
        ae aeVar;
        long currentTimeMillis;
        d dVar;
        d$b bI;
        com.tencent.mm.platformtools.j.a aVar;
        com.tencent.mm.sdk.b.b llVar;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "onResumeOnerousJob!!!");
        com.tencent.mm.modelstat.d.b(3, "ChattingUI" + getIdentString(), hashCode());
        com.tencent.mm.sdk.b.b rtVar = new rt();
        rtVar.fJy.type = 0;
        if (this.ywp != null) {
            rtVar.fJy.fJB = this.ywp.getHeaderViewsCount();
            rtVar.fJy.fJz = this.ywp.getFirstVisiblePosition();
            rtVar.fJy.fJA = this.ywp.getLastVisiblePosition();
        }
        com.tencent.mm.sdk.b.a.xef.m(rtVar);
        if (!this.isCurrentActivity && (thisActivity() instanceof LauncherUI)) {
            ((LauncherUI) thisActivity()).xGS.xGh.cnh();
        }
        com.tencent.mm.ui.chatting.b.c cVar = this.ywd;
        com.tencent.mm.z.bc.w("bizflag", cVar.fhr.csj());
        if (com.tencent.mm.app.plugin.a.a.a(cVar.kEC)) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.BizMgr", "hardevice brand account, onresume: %s, notify switch view enter chattingui", new Object[]{cVar.fhr.csX()});
            if (cVar.yyI != null) {
                cVar.yyI.a(1, cVar.kEC);
            }
        } else {
            cVar.fhr.csq().setMMSubTitle(null);
        }
        com.tencent.mm.ag.d dVar2 = cVar.kEC;
        if (!(dVar2 == null || dVar2 == null)) {
            d$b bI2 = dVar2.bI(false);
            if (bI2 != null && bI2.Lp()) {
                z = true;
                if (z) {
                    ar.Dm().F(new 13(cVar));
                }
                if (!com.tencent.mm.l.a.fZ(cVar.fhr.csi().field_type) && cVar.fhr.csi().cia() && cVar.kEC != null) {
                    bI2 = cVar.kEC.bI(false);
                    if (bI2 != null && bI2.La()) {
                        if (com.tencent.mm.modelgeo.c.OQ() || com.tencent.mm.modelgeo.c.OR()) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (cVar.kEC.field_hadAlert == 0 || (cVar.kEC.KX() && z)) {
                            String mMString = (cVar.kEC.field_hadAlert == 0 && z) ? cVar.fhr.csq().getMMString(R.l.dQF, new Object[]{cVar.fhr.csi().AQ()}) : z ? cVar.fhr.csq().getMMString(R.l.dQG, new Object[]{cVar.fhr.csi().AQ()}) : cVar.fhr.csq().getMMString(R.l.dQE, new Object[]{cVar.fhr.csi().AQ()});
                            cVar.piT = h.a(cVar.fhr.csq().getContext(), mMString, cVar.fhr.csq().getMMString(R.l.dGO), new 14(cVar, z), new 15(cVar));
                        } else {
                            com.tencent.mm.ag.y.Mo().ke(cVar.fhr.crz());
                        }
                    }
                    if (cVar.kEC.KY() && !(cVar.fhr.csi().cia() && com.tencent.mm.ag.a.KV())) {
                        com.tencent.mm.z.ak.a.hfL.Q(cVar.fhr.csi().field_username, "");
                        com.tencent.mm.ad.b.iX(cVar.fhr.csi().field_username);
                    }
                    if (cVar.kEC.field_status == 1) {
                        cVar.kEC.field_status = 0;
                        com.tencent.mm.ag.y.Mf().e(cVar.kEC);
                    }
                } else if (!(cVar.fhr.csq().getBooleanExtra("key_has_add_contact", false).booleanValue() || com.tencent.mm.l.a.fZ(cVar.fhr.csi().field_type) || !cVar.fhr.csi().cia())) {
                    ag.y(new 16(cVar));
                }
                cVar.ctj();
                this.ywh.cts();
                ar.getNotification().eo(crz());
                MMAppMgr.up();
                if (ywx) {
                    ywx = false;
                    mM(true);
                }
                this.yvM.mO(true);
                this.ywe.ctn();
                com_tencent_mm_pluginsdk_q_f = this.yvM;
                if (q$a.vcp != null) {
                    q$a.vcp.a(com_tencent_mm_pluginsdk_q_f);
                }
                if (q$a.vcw != null) {
                    q$a.vcw.a(com_tencent_mm_pluginsdk_q_f);
                }
                if (q$a.vcx != null) {
                    q$a.vcx.a(com_tencent_mm_pluginsdk_q_f);
                }
                if (!com.tencent.mm.sdk.b.a.xef.d(this.gzG)) {
                    com.tencent.mm.sdk.b.a.xef.b(this.gzG);
                }
                aeVar = this.yqp;
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.VoiceImp", "summeranrt resetAutoPlay looper[%s]", new Object[]{Looper.myLooper()});
                currentTimeMillis = System.currentTimeMillis();
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.VoiceImp", "resetAutoPlay autoPlay is:%s tid:%d looper:%s", new Object[]{aeVar.ysR, Long.valueOf(Thread.currentThread().getId()), Looper.myLooper()});
                if (aeVar.ysR != null) {
                    aeVar.ysR = new d(aeVar.fhr, aeVar, aeVar.fhr.csi().field_username);
                    com.tencent.mm.modelvoice.r.c(aeVar.ysR);
                    com.tencent.mm.modelvoice.e.a(aeVar.ysR);
                } else {
                    aeVar.ysR.YZ(aeVar.fhr.csi().field_username);
                }
                ar.Hg();
                z = bh.a((Boolean) com.tencent.mm.z.c.CU().get(16387, null), true);
                dVar = aeVar.ysR;
                if (!dVar.yqt) {
                    dVar.yqr = z;
                    dVar.crc();
                }
                if (aeVar.fhr.csn() != null) {
                    bI = aeVar.fhr.csn().bI(false);
                    if (bI != null) {
                        if (bI.hou != null) {
                            bI.hoJ = bI.hou.optInt("AudioPlayType", 0) != 1;
                        }
                        if (bI.hoJ) {
                            aeVar.ysR.yqs = false;
                        }
                    }
                }
                aeVar.fhr.csy().ysR = aeVar.ysR;
                aeVar.ysR.kCS = aeVar.kCV;
                aeVar.ysR.bdr();
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.VoiceImp", "summeranrt resetAutoPlay end take[%s]ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                if (com.tencent.mm.z.s.hb(aeVar.fhr.crz()) && com.tencent.mm.z.ak.a.hfO != null) {
                    com.tencent.mm.z.ak.a.hfO.a(aeVar.rYQ);
                }
                if (!com.tencent.mm.ar.b.PP()) {
                    aeVar.fhr.csB().vqq = aeVar.yCI;
                }
                aeVar.cuf();
                com.tencent.mm.modelvideo.o.TU().a(this.ysf, ar.Dm().oAt.getLooper());
                aVar = this.yvN;
                llVar = new ll();
                llVar.fCN.fCO = true;
                com.tencent.mm.sdk.b.a.xef.a(llVar, Looper.getMainLooper());
                com.tencent.mm.platformtools.j.b(aVar);
            }
        }
        z = false;
        if (z) {
            ar.Dm().F(new 13(cVar));
        }
        if (!com.tencent.mm.l.a.fZ(cVar.fhr.csi().field_type)) {
        }
        ag.y(new 16(cVar));
        cVar.ctj();
        this.ywh.cts();
        ar.getNotification().eo(crz());
        MMAppMgr.up();
        if (ywx) {
            ywx = false;
            mM(true);
        }
        this.yvM.mO(true);
        this.ywe.ctn();
        com_tencent_mm_pluginsdk_q_f = this.yvM;
        if (q$a.vcp != null) {
            q$a.vcp.a(com_tencent_mm_pluginsdk_q_f);
        }
        if (q$a.vcw != null) {
            q$a.vcw.a(com_tencent_mm_pluginsdk_q_f);
        }
        if (q$a.vcx != null) {
            q$a.vcx.a(com_tencent_mm_pluginsdk_q_f);
        }
        if (com.tencent.mm.sdk.b.a.xef.d(this.gzG)) {
            com.tencent.mm.sdk.b.a.xef.b(this.gzG);
        }
        aeVar = this.yqp;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.VoiceImp", "summeranrt resetAutoPlay looper[%s]", new Object[]{Looper.myLooper()});
        currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.VoiceImp", "resetAutoPlay autoPlay is:%s tid:%d looper:%s", new Object[]{aeVar.ysR, Long.valueOf(Thread.currentThread().getId()), Looper.myLooper()});
        if (aeVar.ysR != null) {
            aeVar.ysR.YZ(aeVar.fhr.csi().field_username);
        } else {
            aeVar.ysR = new d(aeVar.fhr, aeVar, aeVar.fhr.csi().field_username);
            com.tencent.mm.modelvoice.r.c(aeVar.ysR);
            com.tencent.mm.modelvoice.e.a(aeVar.ysR);
        }
        ar.Hg();
        z = bh.a((Boolean) com.tencent.mm.z.c.CU().get(16387, null), true);
        dVar = aeVar.ysR;
        if (dVar.yqt) {
            dVar.yqr = z;
            dVar.crc();
        }
        if (aeVar.fhr.csn() != null) {
            bI = aeVar.fhr.csn().bI(false);
            if (bI != null) {
                if (bI.hou != null) {
                    if (bI.hou.optInt("AudioPlayType", 0) != 1) {
                    }
                    bI.hoJ = bI.hou.optInt("AudioPlayType", 0) != 1;
                }
                if (bI.hoJ) {
                    aeVar.ysR.yqs = false;
                }
            }
        }
        aeVar.fhr.csy().ysR = aeVar.ysR;
        if (aeVar.kCV) {
        }
        aeVar.ysR.kCS = aeVar.kCV;
        aeVar.ysR.bdr();
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.VoiceImp", "summeranrt resetAutoPlay end take[%s]ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        com.tencent.mm.z.ak.a.hfO.a(aeVar.rYQ);
        if (com.tencent.mm.ar.b.PP()) {
            aeVar.fhr.csB().vqq = aeVar.yCI;
        }
        aeVar.cuf();
        com.tencent.mm.modelvideo.o.TU().a(this.ysf, ar.Dm().oAt.getLooper());
        aVar = this.yvN;
        llVar = new ll();
        llVar.fCN.fCO = true;
        com.tencent.mm.sdk.b.a.xef.a(llVar, Looper.getMainLooper());
        com.tencent.mm.platformtools.j.b(aVar);
    }

    public void onResume() {
        if (getWindow() != null) {
            getWindow().setBackgroundDrawableResource(R.e.btE);
        }
        List arrayList = new ArrayList(this.yws);
        for (int i = 0; i < arrayList.size(); i++) {
            ChattingUI.b bVar = (ChattingUI.b) arrayList.get(i);
            if (bVar != null) {
                bVar.csZ();
            }
        }
        boolean isShown = getContentView() != null ? getContentView().isShown() : false;
        boolean isShown2 = getView() != null ? getView().isShown() : false;
        if (csP()) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "onResume fragment not foreground, return,  chatting contentview is show %b, viewShow %b", new Object[]{Boolean.valueOf(isShown), Boolean.valueOf(isShown2)});
            super.onResume();
            this.yvP.ctX();
        } else if (ar.Hj()) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "ashutest::onResume %d,  chatting is show %b, viewShow %b", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(isShown), Boolean.valueOf(isShown2)});
            long currentTimeMillis = System.currentTimeMillis();
            this.ywc.ctn();
            Object obj = this.ywb;
            com.tencent.mm.plugin.bbom.q.a(obj.yBL);
            obj.yBO = new com.tencent.mm.ui.chatting.g.d(obj);
            obj.yBN = new com.tencent.mm.ui.chatting.g.c(obj);
            obj.yBM = new com.tencent.mm.ui.chatting.g.b(obj);
            if (this.ysf != null) {
                com.tencent.mm.pluginsdk.ui.d.i.a(this.ysf.ypU);
            }
            super.onResume();
            com.tencent.mm.ui.chatting.b.x xVar = this.yvP;
            xVar.yBF = null;
            if (!com.tencent.mm.z.q.FS().equals(xVar.fhr.crz()) && ((xVar.fhr.cse() && xVar.fhr.csi().fWn == 0) || !com.tencent.mm.protocal.d.vAA)) {
                xVar.yBF = xVar.fhr.crz();
                xVar.kvt = System.currentTimeMillis();
                xVar.yBH = 0;
                ar.Dm().F(new com.tencent.mm.ui.chatting.b.x.4(xVar, xVar.yBF));
            }
            com.tencent.mm.pluginsdk.wallet.i.CB(6);
            this.ywC = true;
            this.ywI.J(300000, 300000);
            com.tencent.mm.sdk.platformtools.ae.Vc("keep_chatting_silent" + crz());
            ar.Hg();
            com.tencent.mm.z.c.Fa().a(this.ysf.ytz, Looper.getMainLooper());
            this.ysf.ffC = true;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingListAdapter", "adapter resume");
            this.ysf.crK();
            obj = (this.ywM || this.yvY.ysa || this.yvY.yAJ) ? null : 1;
            if (obj != null) {
                this.ywM = true;
                this.ywN = true;
                if (this.yvY.ysa || this.yvY.yAJ) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "From Show Search ChatResult %b, From Gloabl Search %b", new Object[]{Boolean.valueOf(this.yvY.ysa), Boolean.valueOf(this.yvY.yAJ)});
                } else {
                    this.ywK = false;
                    this.ywp.getViewTreeObserver().addOnGlobalLayoutListener(new 26(this));
                }
            }
            if (this.ysk) {
                w wVar = this.yvO;
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = wVar.fhr.csi().field_username;
                ar.Hg();
                aj WY = com.tencent.mm.z.c.Fd().WY(str);
                if (WY != null) {
                    long j = WY.field_lastSeq;
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onResume filterSeq[%d], lastSeq[%d], undeliverCount[%d], chatRoomId[%s]", new Object[]{Long.valueOf(WY.field_firstUnDeliverSeq), Long.valueOf(j), Integer.valueOf(WY.field_UnDeliverCount), str});
                    if (j > 0) {
                        ar.Hg();
                        cf G = com.tencent.mm.z.c.Fa().G(str, j);
                        if (G.field_msgId == 0 && G.field_msgSeq != j) {
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onResume need getChatRoomMsg up msg == null[%b] svrid[%d], msgseq[%d], take[%d]ms", new Object[]{Boolean.valueOf(false), Long.valueOf(G.field_msgSvrId), Long.valueOf(G.field_msgSeq), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
                            ag.y(new w.2(wVar, str, r6, j, r10));
                        }
                    }
                }
            }
            if (isSupportNavigationSwipeBack()) {
                getSwipeBackLayout().mEnable = true;
                getSwipeBackLayout().init();
            }
            if (this.nWQ) {
                cqX();
            }
            com.tencent.mm.sdk.platformtools.x.v("Test", "KEVIN Chatting OnResume: diff:%d  rawUserName:%s ", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), this.ysi});
            this.yvP.ctX();
            z zVar = this.ywf;
            if (com.tencent.mm.z.q.GA().booleanValue()) {
                if (!zVar.fhr.csi().cia()) {
                    ar.Hg();
                    zVar.yCb = bh.c((Boolean) com.tencent.mm.z.c.CU().get(340228, null));
                    if (!(zVar.yCb || zVar.fhr.csu())) {
                        zVar.i(Boolean.valueOf(true));
                    }
                    ar.Hg();
                    zVar.yCc = bh.c((Boolean) com.tencent.mm.z.c.CU().get(340229, null));
                    long currentTimeMillis3 = System.currentTimeMillis();
                    ar.Hg();
                    currentTimeMillis3 -= bh.a((Long) com.tencent.mm.z.c.CU().get(340240, null), 0);
                    if (zVar.yCb && !zVar.yCc && currentTimeMillis3 >= 259200000) {
                        zVar.i(Boolean.valueOf(false));
                    }
                }
                zVar.fhr.csB().vqp = zVar.yCe;
            }
            f fVar = this.ywh;
            if (com.tencent.mm.z.s.gB(fVar.fhr.crz())) {
                fVar.fhr.csq().addIconOptionMenu(0, R.l.dCn, R.k.dvc, Boolean.valueOf(com.tencent.mm.plugin.x.a.bfo().ig(com.tencent.mm.aw.b.hIf)).booleanValue(), fVar.yzr);
            }
        } else {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingUI", "account not ready, mabey not call onDestroy!!!");
            finish();
            this.yvP.ctX();
        }
    }

    public boolean hideVKB() {
        if (this.ywe.csB() != null) {
            return bh.hideVKB(this.ywe.csB());
        }
        return super.hideVKB();
    }

    public void onPause() {
        List arrayList = new ArrayList(this.yws);
        for (int i = 0; i < arrayList.size(); i++) {
            ChattingUI.b bVar = (ChattingUI.b) arrayList.get(i);
            if (bVar != null) {
                bVar.csY();
            }
        }
        p.dismiss();
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "on chatting ui pause  rawuser:%s", new Object[]{this.ysi});
        com.tencent.mm.sdk.b.b rtVar = new rt();
        rtVar.fJy.type = 1;
        com.tencent.mm.sdk.b.a.xef.m(rtVar);
        if (this.ysf != null) {
            com.tencent.mm.pluginsdk.ui.d.i.b(this.ysf.ypU);
        }
        this.ywe.ctG();
        if (this.ysi == null) {
            super.onPause();
            return;
        }
        boolean isShown;
        if (getContentView() != null) {
            isShown = getContentView().isShown();
        } else {
            isShown = false;
        }
        if (csP() || !(this.isCurrentActivity || this.ywC)) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "onPause fragment not foreground, hasPause:%b, chattingShow:%b", new Object[]{Boolean.valueOf(this.ywC), Boolean.valueOf(isShown)});
            super.onPause();
            return;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "onPause %d, chattingShow:%b", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(isShown)});
        super.onPause();
        this.ywC = false;
        this.ysf.ffC = false;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingListAdapter", "adapter pause");
        j jVar = this.yvZ;
        if (jVar.fhr.csB() != null) {
            if (jVar.fhr.csB().cbU()) {
                jVar.yzQ = com.tencent.mm.ui.chatting.b.j.a.yzS;
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.SearchImp", "jacks mark refreshKeyBordState keybord state: show");
            } else {
                jVar.yzQ = com.tencent.mm.ui.chatting.b.j.a.yzR;
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.SearchImp", "jacks mark refreshKeyBordState keybord state: hide");
            }
            jVar.yzO = jVar.fhr.csB().cbs();
        }
        this.yvL.stopSignalling();
        com.tencent.mm.ui.chatting.b.u uVar = this.yvY;
        if (uVar.yAQ) {
            uVar.ctV();
            if (uVar.fhr.csA() != null) {
                uVar.fhr.csA().crS();
            }
        }
        ae aeVar = this.yqp;
        if (com.tencent.mm.z.s.hb(aeVar.fhr.crz()) && com.tencent.mm.z.ak.a.hfO != null) {
            com.tencent.mm.z.ak.a.hfO.b(aeVar.rYQ);
        }
        if (aeVar.yCH != null && aeVar.yCH.getVisibility() == 0) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.VoiceImp", "doPause set voiceinputMask GONE");
            aeVar.yCH.setVisibility(8);
        }
        aeVar.fhr.csB().vqq = null;
        ar.Hg();
        com.tencent.mm.z.c.CU().set(26, Boolean.valueOf(aeVar.kCV));
        if (!(com.tencent.mm.ui.p.cna() || aeVar.ysR == null)) {
            aeVar.ysR.crc();
            aeVar.ysR.crh();
            aeVar.ysR.release();
        }
        rtVar = new so();
        com.tencent.mm.sdk.b.a.xef.m(rtVar);
        if (!(rtVar.fKm.fKp || com.tencent.mm.p.a.AW())) {
            ar.Hh().xJ();
        }
        this.ywI.TG();
        crb();
        ar.getNotification().eo("");
        y yVar = this.ywb;
        com.tencent.mm.plugin.bbom.q.b(yVar.yBL);
        if (yVar.yBM != null) {
            yVar.yBM.release();
            yVar.yBM = null;
        }
        if (yVar.yBN != null) {
            yVar.yBN.release();
            yVar.yBN = null;
        }
        if (yVar.yBO != null) {
            yVar.yBO.release();
            yVar.yBO = null;
        }
        ar.Hg();
        com.tencent.mm.z.c.Fa().a(this.ysf.ytz);
        com.tencent.mm.modelvideo.o.TU().a(this.ysf);
        Object obj = this.yvN;
        com.tencent.mm.platformtools.j.c(obj);
        obj.TG();
        com.tencent.mm.sdk.platformtools.ae.Vd("keep_app_silent");
        com.tencent.mm.sdk.platformtools.ae.Vd("keep_chatting_silent" + crz());
        cri();
        q$f com_tencent_mm_pluginsdk_q_f = this.yvM;
        if (q$a.vcp != null) {
            q$a.vcp.b(com_tencent_mm_pluginsdk_q_f);
        }
        if (q$a.vcw != null) {
            q$a.vcw.b(com_tencent_mm_pluginsdk_q_f);
        }
        if (q$a.vcx != null) {
            q$a.vcx.b(com_tencent_mm_pluginsdk_q_f);
        }
        com.tencent.mm.ui.chatting.b.c cVar = this.ywd;
        if (com.tencent.mm.l.a.fZ(cVar.fhr.csi().field_type) && cVar.fhr.csi().cia() && cVar.kEC != null) {
            com.tencent.mm.ag.y.Mo().LY();
            if (cVar.piT != null) {
                cVar.piT.dismiss();
            }
        }
        hideVKB();
        rtVar = new ll();
        rtVar.fCN.fCO = false;
        com.tencent.mm.sdk.b.a.xef.a(rtVar, Looper.getMainLooper());
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "chattingui cancel pause auto download logic");
        com.tencent.mm.sdk.b.a.xef.c(this.gzG);
        aj.clear();
        com.tencent.mm.ui.chatting.b.x xVar = this.yvP;
        if (!TextUtils.isEmpty(xVar.yBF) && xVar.fhr.cse()) {
            xVar.yBG = System.currentTimeMillis();
            String str = xVar.yBF;
            xVar.yBF = "";
            ar.Dm().F(new 5(xVar, str));
        }
        z zVar = this.ywf;
        if (!zVar.fhr.csi().cia() && com.tencent.mm.z.q.GA().booleanValue()) {
            zVar.c(Boolean.valueOf(false), Boolean.valueOf(false));
        }
    }

    public final String csL() {
        return getIdentString();
    }

    protected String getIdentString() {
        if (this.fAh == null || ((int) this.fAh.gJd) == 0 || bh.ov(this.fAh.field_username)) {
            return "";
        }
        String str;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "getIdentString %s", new Object[]{this.fAh.field_username});
        com.tencent.mm.ui.chatting.b.c cVar = this.ywd;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.BizMgr", "getIdentString %s", new Object[]{cVar.fhr.csi().field_username});
        if (ar.Hj()) {
            if (com.tencent.mm.ag.f.eE(cVar.fhr.csi().field_username)) {
                str = "_EnterpriseChat";
            } else if (com.tencent.mm.ag.f.jX(cVar.fhr.csi().field_username)) {
                str = "_EnterpriseFatherBiz";
            } else if (com.tencent.mm.ag.f.jW(cVar.fhr.csi().field_username)) {
                str = "_EnterpriseChildBiz";
            }
            if (str == null) {
                return str;
            }
            if (com.tencent.mm.z.s.eV(this.fAh.field_username)) {
                return "_chatroom";
            }
            if (com.tencent.mm.z.s.gy(this.fAh.field_username)) {
                return "_bottle";
            }
            if (com.tencent.mm.z.s.gz(this.fAh.field_username)) {
                return "";
            }
            return "_QQ";
        }
        str = cVar.fhr.csi().cia() ? "_bizContact" : null;
        if (str == null) {
            return str;
        }
        if (com.tencent.mm.z.s.eV(this.fAh.field_username)) {
            return "_chatroom";
        }
        if (com.tencent.mm.z.s.gy(this.fAh.field_username)) {
            return "_bottle";
        }
        if (com.tencent.mm.z.s.gz(this.fAh.field_username)) {
            return "";
        }
        return "_QQ";
    }

    public void onKeyboardStateChanged() {
        if (keyboardState() == 1) {
            this.ywp.post(new Runnable(this) {
                final /* synthetic */ ChattingUI$a ywR;

                {
                    this.ywR = r1;
                }

                public final void run() {
                    this.ywR.a(true, false, null);
                }
            });
        }
    }

    public final boolean csM() {
        if (isScreenEnable()) {
            goBack();
        } else {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingUI", "Actionbar customView onclick screen not enable");
        }
        return true;
    }

    public final void csN() {
        if (this.ywE != null) {
            if (this.ywE.ytm) {
                showOptionMenu(false);
            } else {
                cqZ();
            }
        }
        this.yqp.cuf();
    }

    public void cqZ() {
        f fVar = this.ywh;
        if (fVar.yvY.yAH || fVar.yvY.ysa) {
            fVar.fhr.csq().showOptionMenu(false);
            return;
        }
        if (com.tencent.mm.z.s.gB(fVar.fhr.crz())) {
            fVar.fhr.csq().addIconOptionMenu(0, R.l.dCn, R.k.dvc, Boolean.valueOf(com.tencent.mm.plugin.x.a.bfo().ig(com.tencent.mm.aw.b.hIf)).booleanValue(), fVar.yzr);
        } else if (com.tencent.mm.z.s.gI(fVar.fhr.crz())) {
            fVar.fhr.csq().addIconOptionMenu(0, R.l.dCn, R.k.dvc, fVar.yzr);
            com.tencent.mm.plugin.report.service.g.pQN.k(10071, "1");
        } else if (com.tencent.mm.z.s.gJ(fVar.fhr.crz())) {
            fVar.fhr.csq().addIconOptionMenu(0, R.l.dCn, R.k.dvc, fVar.yzr);
        } else if (com.tencent.mm.z.s.hi(fVar.fhr.crz())) {
            fVar.fhr.csq().addIconOptionMenu(0, R.l.dCn, R.k.dvc, fVar.yzr);
        } else if (com.tencent.mm.z.s.hn(fVar.fhr.crz())) {
            if (com.tencent.mm.z.s.gU(fVar.fhr.crz())) {
                fVar.fhr.csq().showOptionMenu(false);
                return;
            }
            fVar.fhr.csq().addIconOptionMenu(0, R.l.dCn, R.k.dvc, fVar.yzr);
        } else if (x.Wx(fVar.fhr.crz()) || x.Wz(fVar.fhr.crz()) || x.gy(fVar.fhr.crz())) {
            fVar.fhr.csq().addIconOptionMenu(0, R.l.dSC, R.k.duZ, fVar.yzr);
        } else if (fVar.fhr.csj() && com.tencent.mm.ui.chatting.b.g.Zi(fVar.fhr.crz())) {
            fVar.fhr.csq().addIconOptionMenu(0, R.l.dSC, R.k.dzz, fVar.yzr);
        } else if (!fVar.fhr.crz().endsWith("@chatroom") && !fVar.ywd.vnK) {
            if (!(!(1 == bh.getInt(com.tencent.mm.k.g.zY().getValue("VOIPShowInChat"), 0)) || com.tencent.mm.z.s.gF(fVar.fhr.crz()) || fVar.fhr.crz().endsWith("@chatroom") || x.Wx(fVar.fhr.crz()) || x.Wz(fVar.fhr.crz()) || x.gy(fVar.fhr.crz()))) {
                if (1 == bh.getInt(com.tencent.mm.k.g.zY().getValue("VOIPCallType"), 0)) {
                    fVar.fhr.csq().addIconOptionMenu(2, R.l.dTp, R.k.dvd, fVar.yzx);
                } else {
                    fVar.fhr.csq().addIconOptionMenu(1, R.l.dTq, R.k.dve, fVar.yzx);
                }
            }
            fVar.fhr.csq().addIconOptionMenu(0, R.l.dSC, R.k.duZ, fVar.yzr);
        } else if (fVar.fhr.csu()) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.ChattingHeadereMgr", "cpan show chatroom right btn");
            fVar.fhr.csq().addIconOptionMenu(0, R.l.dSC, R.k.duR, fVar.yzr);
            fVar.fhr.csq().showOptionMenu(true);
        } else if (!fVar.ywd.vnK || fVar.ywd.yyK) {
            fVar.fhr.csq().showOptionMenu(false);
            return;
        } else {
            fVar.fhr.csq().addIconOptionMenu(0, R.l.dSC, R.k.duZ, fVar.yzr);
            fVar.fhr.csq().showOptionMenu(true);
        }
        if (x.gy(fVar.fhr.crz())) {
            fVar.fhr.csq().showOptionMenu(2, true);
        } else {
            fVar.fhr.csq().showOptionMenu(true);
        }
    }

    public final int csO() {
        return this.ywh.ctA();
    }

    protected void cra() {
        this.ywp = (ListView) findViewById(R.h.bUg);
        this.ywp.setVisibility(0);
        this.yi = 0;
        this.onH = (MMPullDownView) findViewById(R.h.bUP);
        this.onH.ycJ = false;
        this.onH.mq(false);
        this.onH.ycp = new 2(this);
        this.onH.ycq = new 3(this);
        this.onH.mp(true);
        this.onH.ycB = new 4(this);
        this.onH.ycC = new 5(this);
        this.onH.ycU = new 6(this);
        this.onH.mn(true);
        this.onH.mo(this.yvY.ysa);
        this.onH.mr(false);
        this.ywp.setOnScrollListener(new 7(this));
        if (this.ysf == null) {
            au auVar = new au();
            String crz = crz();
            csv();
            this.ysf = new q(this, auVar, crz);
            if (this.vqi) {
                this.ysf.yto = true;
            }
        }
        this.ysf.lU(true);
        this.ysf.lFk = this.handler;
        this.ysf.xIi = new 29(this);
        this.ywh.ctp();
        ar.Hg();
        com.tencent.mm.storage.ae WY = com.tencent.mm.z.c.Fd().WY(this.fAh.field_username);
        if (WY == null || WY.field_UnDeliverCount == 0) {
            a(WY, false);
        } else if (this.ywk != null) {
            this.ywk.setVisibility(8);
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "summerbadcr not updateGoBacktoHistroyMessage initList UnDeliver:%d, UnRead:%d", new Object[]{Integer.valueOf(WY.field_UnDeliverCount), Integer.valueOf(WY.field_unReadCount)});
        }
        if (this.ywp.getAdapter() == null) {
            this.ywp.setAdapter(this.ysf);
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "chatHistoryList.setAdapter");
        }
        if (this.yvY.ysa) {
            this.ywp.setTranscriptMode(0);
        } else {
            this.ywp.setTranscriptMode(1);
        }
        this.ywp.setOnTouchListener(new 30(this));
        registerForContextMenu(this.ywp);
    }

    public final void mL(boolean z) {
        if (this.ysf != null) {
            this.ysf.mF(z);
        }
    }

    private static boolean Ze(String str) {
        return x.gy(str) || x.Wz(str) || x.Wx(str) || com.tencent.mm.z.s.gU(str);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (!csP()) {
            super.onCreateOptionsMenu(menu, menuInflater);
        }
    }

    public final boolean csP() {
        return (this.hHG || this.isCurrentActivity) ? false : true;
    }

    protected final void csQ() {
        this.yvP.ctW();
        if (this.isCurrentActivity || !isSupportNavigationSwipeBack()) {
            csT();
            return;
        }
        SwipeBackLayout swipeBackLayout = getSwipeBackLayout();
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SwipeBackLayout", "scrollToFinishActivity, Scrolling %B, hasTranslucent %B, hasCallPopOut %B", new Object[]{Boolean.valueOf(swipeBackLayout.zsB), Boolean.valueOf(swipeBackLayout.zww), Boolean.valueOf(swipeBackLayout.zwx)});
        if (!swipeBackLayout.czd()) {
            com.tencent.mm.ui.widget.l.aI(0.0f);
            swipeBackLayout.zsB = true;
            swipeBackLayout.zwx = false;
            int width = (swipeBackLayout.Iv.getWidth() + swipeBackLayout.zwt.getIntrinsicWidth()) + 10;
            com.tencent.mm.ui.mogic.a aVar = swipeBackLayout.zwr;
            aVar.Fj = swipeBackLayout.Iv;
            aVar.fu = -1;
            aVar.f(width, 0, 0, 0);
            swipeBackLayout.invalidate();
            if (swipeBackLayout.zwz != null) {
                swipeBackLayout.zwz.onDrag();
            }
            com.tencent.mm.ui.widget.l.B(true, 0);
        }
        this.ywb.yBQ = HardCoderJNI.startPerformance(HardCoderJNI.hcQuitChattingEnable, HardCoderJNI.hcQuitChattingDelay, HardCoderJNI.hcQuitChattingCPU, HardCoderJNI.hcQuitChattingIO, HardCoderJNI.hcQuitChattingThr ? g.Dm().cfD() : 0, HardCoderJNI.hcQuitChattingTimeout, HardCoderJNI.SCENE_QUIT_CHATTING, HardCoderJNI.hcQuitChattingAction, "MicroMsg.ChattingUI.TextImp");
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.TextImp", "hardCoderExitChattingStart %s", new Object[]{Integer.valueOf(r11.yBQ)});
    }

    private void goBack() {
        if (hideVKB()) {
            ag.h(new 8(this), 300);
        } else {
            csR();
        }
    }

    public void onSwipeBack() {
        this.yvP.ctW();
        csT();
        if (isSupportNavigationSwipeBack()) {
            getSwipeBackLayout().mEnable = false;
            if (this.ysf != null) {
                this.ysf.mF(false);
            }
        }
    }

    public void onDragBegin() {
        if (isSupportNavigationSwipeBack() && this.ysf != null) {
            this.ysf.mF(true);
            this.ywy = false;
        }
    }

    public void onCancelDrag() {
        if (isSupportNavigationSwipeBack() && this.ysf != null) {
            this.ysf.mF(false);
            this.ywy = true;
        }
    }

    private void csR() {
        aa aaVar = this.yvM;
        Runnable 9 = new 9(this);
        if (q$a.vcw == null || !q$a.vcw.de(aaVar.fhr.csi().field_username, aaVar.fhr.csv())) {
            9.run();
        } else {
            h.a(aaVar.fhr.csq().getContext(), aaVar.fhr.csq().getMMString(R.l.eRk), aaVar.fhr.csq().getMMString(R.l.dGO), true, new aa$1(aaVar, 9), new aa.4(aaVar));
        }
    }

    public final boolean csS() {
        if (this.ywE == null || !this.ywE.ytm) {
            return false;
        }
        if (this.yvY.yAQ) {
            this.yvY.ctV();
            this.ywE.crS();
        } else {
            this.ywE.crR();
        }
        return true;
    }

    private void csT() {
        boolean z = true;
        boolean z2 = false;
        csS();
        ab abVar = this.yvJ;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TransformImp", "clear VoiceTransTextAct");
        abVar.cua();
        if (abVar.yCs) {
            com.tencent.mm.sdk.b.b ffVar = new ff();
            ffVar.fuq.fut = 3;
            com.tencent.mm.sdk.b.a.xef.m(ffVar);
        }
        abVar = this.yvJ;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TransformImp", "alvinluo hide transformText");
        com.tencent.mm.sdk.f.e.post(new 3(abVar), "UnsetTransformFlag");
        List arrayList = new ArrayList(this.yws);
        for (int i = 0; i < arrayList.size(); i++) {
            ChattingUI.b bVar = (ChattingUI.b) arrayList.get(i);
            if (bVar != null) {
                bVar.cta();
            }
        }
        super.onStop();
        Intent intent;
        if (x.Wx(crz())) {
            intent = new Intent();
            intent.addFlags(67108864);
            com.tencent.mm.bm.d.b(getContext(), "tmessage", ".ui.TConversationUI", intent);
        } else if (getIntExtra("chat_from_scene", 0) == 4) {
            finish();
            return;
        } else if ((getIntExtra("chat_from_scene", 0) == 1 || getIntExtra("chat_from_scene", 0) == 3) && this.fAh != null && this.fAh.cia() && this.ywd.kEC != null && this.ywd.kEC.Lf() && this.ywd.kEC.bI(false) != null && this.ywd.kEC.bI(false).LG() != null && !bh.ov(this.ywd.kEC.Lm())) {
            finish();
            return;
        } else if (this.vqi) {
            finish();
        } else if (!this.yww) {
            if (this.isCurrentActivity) {
                intent = new Intent(getContext(), LauncherUI.class);
                intent.addFlags(67108864);
                startActivity(intent);
                overridePendingTransition(com.tencent.mm.ui.MMFragmentActivity.a.xKi, com.tencent.mm.ui.MMFragmentActivity.a.xKj);
                finish();
                return;
            } else if (thisActivity() instanceof LauncherUI) {
                LauncherUI launcherUI = (LauncherUI) thisActivity();
                if (launcherUI != null) {
                    if (!isSupportNavigationSwipeBack()) {
                        z2 = true;
                    }
                    launcherUI.closeChatting(z2);
                    return;
                }
                return;
            } else if (thisActivity() instanceof BaseConversationUI) {
                BaseConversationUI baseConversationUI = (BaseConversationUI) thisActivity();
                if (baseConversationUI != null) {
                    if (isSupportNavigationSwipeBack()) {
                        z = false;
                    }
                    baseConversationUI.closeChatting(z);
                    return;
                }
                return;
            } else {
                return;
            }
        }
        finish();
    }

    public final void mM(boolean z) {
        a(z, Looper.myLooper() != Looper.getMainLooper(), null);
    }

    @Deprecated
    protected final void a(boolean z, boolean z2, a aVar) {
        if (z2) {
            this.handler.postDelayed(new 10(this, z, null), 10);
        } else {
            mN(z);
        }
    }

    private void mN(boolean z) {
        int count = this.ywp.getCount() - 1;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "mFirstScroll : %s, last visible/adapter=%s/%s %s", new Object[]{Boolean.valueOf(this.ywq), Integer.valueOf(this.ywp.getLastVisiblePosition()), Integer.valueOf(count), Boolean.valueOf(z)});
        this.ywq = false;
        if (this.ywp.getLastVisiblePosition() >= count - 1 || z) {
            int count2 = this.ysf.getCount();
            if (count2 <= 1 || !((au) this.ysf.getItem(count2 - 2)).isSystem()) {
                com.tencent.mm.ui.chatting.b.t.a(this.ywp, count, true);
                return;
            }
            com.tencent.mm.ui.chatting.b.t.a(this.ywp, count - 1, 0, false);
        }
    }

    protected int getForceOrientation() {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "getForceOrientation");
        return -1;
    }

    public boolean supportNavigationSwipeBack() {
        if (this.isCurrentActivity) {
            return false;
        }
        g.Dk();
        if (!com.tencent.mm.compatible.e.b.aK(((com.tencent.mm.kernel.b.h) g.Dg().CN()).gSI)) {
            return true;
        }
        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingUI", "Running on a Chromebook, so we not support swipeback and so on");
        return false;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        int i2 = false;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "chatting onKeyDown, code:%d action:%d", new Object[]{Integer.valueOf(keyEvent.getKeyCode()), Integer.valueOf(keyEvent.getAction())});
        if (keyEvent.getKeyCode() == 4) {
            if (csP()) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "onKeyDown back key fragment not foreground");
                return false;
            } else if (isSupportNavigationSwipeBack() && getSwipeBackLayout().czc()) {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingUI", "ashutest::onKeyDown back ScrollToFinishing");
                return true;
            } else {
                if (keyEvent.getAction() == 0) {
                    this.mHasBackOnKeyDown = true;
                    this.mBackOnKeyDownTS = System.currentTimeMillis();
                }
                if (keyEvent.getAction() == 1) {
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "hasBack %B, %d", new Object[]{Boolean.valueOf(this.mHasBackOnKeyDown), Long.valueOf(System.currentTimeMillis() - this.mBackOnKeyDownTS)});
                    if (!this.mHasBackOnKeyDown || System.currentTimeMillis() - this.mBackOnKeyDownTS > 30000) {
                        return true;
                    }
                    this.ywQ = true;
                    if (this.ywE == null || !this.ywE.ytm) {
                        if (this.ywe.csB() == null || !this.ywe.csB().cbN()) {
                            goBack();
                        } else {
                            this.ywe.csB().p(2, 23, false);
                        }
                    } else if (this.yvY.yAQ) {
                        this.yvY.ctV();
                        this.ywE.crS();
                    } else {
                        this.ywE.crR();
                    }
                }
                return true;
            }
        } else if (keyEvent.getKeyCode() == 67 && csP()) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "onKeyDown back key fragment not foreground");
            return false;
        } else {
            j jVar = this.yvZ;
            if (keyEvent.getKeyCode() == 67) {
                ChatFooter csB;
                if (keyEvent.getAction() == 0) {
                    char c;
                    csB = jVar.fhr.csB();
                    int selectionStart = csB.okv.getSelectionStart();
                    if (selectionStart <= 0) {
                        c = 'x';
                    } else {
                        c = csB.cbs().charAt(selectionStart - 1);
                    }
                    if (c == ' ') {
                        jVar.yzN = true;
                    } else {
                        jVar.yzN = false;
                    }
                }
                if (keyEvent.getAction() == 1 && jVar.yzN) {
                    jVar.yzN = false;
                    csB = jVar.fhr.csB();
                    int selectionStart2 = csB.okv.getSelectionStart();
                    String substring = csB.cbs().substring(0, selectionStart2);
                    int lastIndexOf = substring.lastIndexOf(64);
                    if (lastIndexOf < substring.length() && lastIndexOf >= 0) {
                        substring = substring.substring(0, lastIndexOf);
                        String substring2 = csB.cbs().substring(selectionStart2);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(substring).append(substring2);
                        csB.Sy(stringBuilder.toString());
                        csB.okv.setSelection(lastIndexOf);
                    }
                }
            }
            com.tencent.mm.ui.chatting.b.c cVar = this.ywd;
            if (keyEvent.getKeyCode() == 82 && keyEvent.getAction() == 1 && (cVar.kEC == null || cVar.kEC.bI(false) == null || cVar.kEC.bI(false).LE() == null || cVar.kEC.bI(false).LE().hpe == null || cVar.kEC.bI(false).LE().hpe.isEmpty())) {
                cVar.fhr.csB().cbn();
            }
            if (csP()) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "onKeyDown fragment not foreground");
                return false;
            }
            ae aeVar = this.yqp;
            if (i == 25 && aeVar.ysR != null && aeVar.ysR.isPlaying() && (aeVar.kCV || !aeVar.ysR.kCS)) {
                if (keyEvent.getAction() == 0) {
                    if (ar.Hh().xL() && !ar.Hh().xR()) {
                        i2 = ar.Hh().xX();
                    }
                    ar.Hh().fz(i2);
                }
                i2 = 1;
            } else if (i == 24 && aeVar.ysR != null && aeVar.ysR.isPlaying() && (aeVar.kCV || !aeVar.ysR.kCS)) {
                if (keyEvent.getAction() == 0) {
                    if (ar.Hh().xL() && !ar.Hh().xR()) {
                        i2 = ar.Hh().xX();
                    }
                    ar.Hh().fy(i2);
                }
                i2 = 1;
            }
            if (i2 != 0) {
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "chatting ui fragment on key up, %d, %s", new Object[]{Integer.valueOf(i), keyEvent});
        return super.onKeyUp(i, keyEvent);
    }

    public final void a(com.tencent.mm.storage.ae aeVar, boolean z) {
        this.ywk = findViewById(R.h.bUe);
        if (this.ywk != null) {
            com.tencent.mm.ag.a.a aVar = null;
            if (this.ywd.vnK) {
                aVar = com.tencent.mm.ag.y.Mi().aS(this.ywd.cti());
            }
            if (!(aeVar == null && aVar == null) && (!(Ze(this.fAh.field_username) || com.tencent.mm.z.s.hl(this.fAh.field_username) || com.tencent.mm.z.s.gF(this.fAh.field_username) || com.tencent.mm.z.s.hg(this.fAh.field_username) || com.tencent.mm.z.s.gI(this.fAh.field_username)) || this.ysk || this.ywd.vnK || csW())) {
                if (this.ywd.vnK && aVar != null) {
                    this.ywj = aVar.field_unReadCount;
                } else if (aeVar != null) {
                    this.ywj = aeVar.field_unReadCount;
                } else {
                    this.ywk.setVisibility(8);
                    return;
                }
                int i = this.ywj;
                if (z && aeVar != null && aeVar.field_UnDeliverCount > 0) {
                    i += aeVar.field_UnDeliverCount;
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "summerbadcr updateGoBacktoHistroyMessage mUnreadMessage fixUnreadMessage[%d, %d]", new Object[]{Integer.valueOf(i), Integer.valueOf(this.ywj)});
                    this.yvO.yBk = this.ywj;
                }
                int i2 = i;
                if (i2 >= (csW() ? 5 : 10)) {
                    this.ywk.setVisibility(0);
                    this.ywl = (TextView) findViewById(R.h.bUf);
                    com.tencent.mm.booter.z zVar = com.tencent.mm.booter.z.gyU;
                    if (zVar.gyY == null) {
                        zVar.gyZ = 1;
                    } else {
                        zVar.gyY.gzq = 1;
                    }
                    if (i2 > 999) {
                        this.ywl.setText(String.format(getMMString(R.l.dRi), new Object[]{Integer.valueOf(999)}));
                    } else {
                        this.ywl.setText(String.format(getMMString(R.l.dRi), new Object[]{Integer.valueOf(i2)}));
                    }
                    if (this.ywd.vnK) {
                        ar.Hg();
                        i = com.tencent.mm.z.c.Fb().ao(this.fAh.field_username, this.ywd.cti()) - this.ywj;
                    } else {
                        ar.Hg();
                        i = com.tencent.mm.z.c.Fa().EM(this.fAh.field_username) - this.ywj;
                    }
                    this.ywk.setOnClickListener(new 11(this, aeVar, i));
                    this.ywk.post(new 13(this));
                    return;
                }
            }
            this.ywk.setVisibility(8);
        }
    }

    public final void csU() {
        if (this.ywk != null) {
            this.ywj = -1;
            if (this.ywk.getVisibility() == 0) {
                Animation translateAnimation = new TranslateAnimation(0.0f, (float) this.ywk.getWidth(), 0.0f, 0.0f);
                translateAnimation.setDuration(300);
                translateAnimation.setInterpolator(AnimationUtils.loadInterpolator(getContext(), 17432581));
                this.ywk.startAnimation(translateAnimation);
            }
            this.ywk.setVisibility(8);
        }
    }

    public final void FA(int i) {
        if (this.ywj >= (csW() ? 5 : 10) && this.ywk != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ywk.getLayoutParams();
            switch (i) {
                case -2:
                    if (this.yvM.yCh == null || this.yvM.yCh.getVisibility() != 0) {
                        layoutParams.setMargins(0, getMMResources().getDimensionPixelSize(R.f.bvv), 0, 0);
                        return;
                    }
                    return;
                case 0:
                    layoutParams.setMargins(0, getMMResources().getDimensionPixelSize(R.f.bvv), 0, 0);
                    return;
                case 1:
                    int i2;
                    int i3;
                    if (this.yvM.yCh == null || this.yvM.yCh.getVisibility() != 0) {
                        i2 = 0;
                    } else {
                        i2 = this.yvM.yCh.getHeight();
                    }
                    if (this.yvM.yCi == null || this.yvM.yCi.getVisibility() != 0) {
                        i3 = 0;
                    } else {
                        i3 = getMMResources().getDimensionPixelSize(R.f.bvG);
                    }
                    if (i3 > i2) {
                        i2 = i3;
                    }
                    layoutParams.setMargins(0, i2 + getMMResources().getDimensionPixelSize(R.f.bvv), 0, 0);
                    return;
                case 3:
                    layoutParams.setMargins(0, getMMResources().getDimensionPixelSize(R.f.bvv) * 3, 0, 0);
                    return;
                default:
                    return;
            }
        }
    }

    public final boolean csV() {
        if ((this.fAh.cia() || com.tencent.mm.z.s.hk(crz()) || x.Wx(crz())) && !this.ywd.vnK) {
            return false;
        }
        return true;
    }

    private boolean csW() {
        if (com.tencent.mm.z.s.hi(crz())) {
            return true;
        }
        if (this.fAh.cia() && this.ywd.kEC != null && (this.ywd.kEC.Lc() || this.ywd.kEC.Lb())) {
            return true;
        }
        return false;
    }

    public final void af(int i, boolean z) {
        int i2;
        int count;
        int count2 = this.ysf.getCount();
        int i3 = this.ysf.hKb - i;
        if (i3 <= 18) {
            i2 = count2 - i3;
        } else if (count2 > i3) {
            i2 = count2 - i3;
        } else {
            this.ysf.Fv(i3 - count2);
            this.ysf.crL();
            i2 = 0;
        }
        if (z) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "summerbadcr goBackToHistroyMsg dzmonster get pos=%d, preCount=%d, totalCount=%d, msgCount =%d, select=%d, newTotalCount=%d, newCount=%d, stack[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(count2), Integer.valueOf(r4), Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(this.ysf.hKb), Integer.valueOf(this.ysf.getCount()), bh.cgy()});
            count = this.ysf.getCount() - count2;
        } else {
            count = i2;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "summerbadcr goBackToHistroyMsg dzmonster pos=%d, preCount=%d, totalCount=%d, msgCount =%d, fSelect=%d, newTotalCount=%d, newCount=%d, stack[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(count2), Integer.valueOf(r4), Integer.valueOf(i3), Integer.valueOf(count), Integer.valueOf(this.ysf.hKb), Integer.valueOf(this.ysf.getCount()), bh.cgy()});
        q qVar = this.ysf;
        au auVar = (au) qVar.getItem(count);
        if (!(auVar == null || auVar.field_msgId == 0)) {
            qVar.ysP = auVar.field_msgId;
        }
        csU();
        this.ywp.post(new 16(this, count));
    }

    public final void az(final au auVar) {
        final com.tencent.mm.ui.chatting.h.b bVar = new com.tencent.mm.ui.chatting.h.b(getContext());
        bVar.yIh = new com.tencent.mm.ui.chatting.h.b.a(this) {
            final /* synthetic */ ChattingUI$a ywR;

            public final void fX(long j) {
                bVar.hide();
                com.tencent.mm.plugin.report.service.g.pQN.a(795, 1, 1, false);
                if (NetUtil.isConnected(this.ywR.getContext())) {
                    bca com_tencent_mm_protocal_c_bca = new bca();
                    com_tencent_mm_protocal_c_bca.lOD = (int) (j / 1000);
                    com_tencent_mm_protocal_c_bca.ktN = 1;
                    com_tencent_mm_protocal_c_bca.wFj = 1;
                    try {
                        String str;
                        asr com_tencent_mm_protocal_c_asr = new asr();
                        com_tencent_mm_protocal_c_asr.ksU = this.ywR.crz();
                        com_tencent_mm_protocal_c_asr.vHe = auVar.field_msgSvrId;
                        ChattingUI$a chattingUI$a = this.ywR;
                        cf cfVar = auVar;
                        if (cfVar.cjg() || cfVar.cjl()) {
                            str = cfVar.field_content;
                            int hO = ba.hO(str);
                            if (hO != -1) {
                                str = str.substring(hO + 1).trim();
                            }
                        } else {
                            Context context = chattingUI$a.getContext();
                            int type = cfVar.getType();
                            String str2 = cfVar.field_content;
                            chattingUI$a.crz();
                            str = AllRemindMsgUI.a(context, type, str2, cfVar.field_isSend);
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "[getRemindTitle] msgId:%s type:%s title:%s", new Object[]{Long.valueOf(cfVar.field_msgId), Integer.valueOf(cfVar.getType()), str});
                        }
                        com_tencent_mm_protocal_c_asr.fon = str;
                        com_tencent_mm_protocal_c_bca.vYR = new com.tencent.mm.bq.b(com_tencent_mm_protocal_c_asr.toByteArray());
                    } catch (IOException e) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI", "[onOk] %s", new Object[]{e.toString()});
                    }
                    ar.CG().a(new ah(1, com_tencent_mm_protocal_c_bca), 0);
                    return;
                }
                h.b(this.ywR.getContext(), this.ywR.getString(R.l.exE), this.ywR.getString(R.l.eEu), true);
            }

            public final void onCancel() {
                bVar.hide();
            }
        };
        if (bVar.yIe != null) {
            bVar.yIe.show();
        }
        com.tencent.mm.plugin.report.service.g.pQN.a(795, 0, 1, false);
    }

    public final String aA(au auVar) {
        Object obj = (com.tencent.mm.app.plugin.b.uA() && auVar.cjw()) ? 1 : null;
        if (obj != null) {
            return dk(auVar.field_content, auVar.field_isSend) + "\n\n" + dk(auVar.field_transContent, auVar.field_isSend);
        }
        return dk(auVar.field_content, auVar.field_isSend);
    }

    public final String dk(String str, int i) {
        if (this.ywd.yyK || !this.ypn || str == null || i != 0) {
            return str;
        }
        return ba.hQ(str);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (csP()) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "onActivityResult not foreground, return, requestCode:%d", new Object[]{Integer.valueOf(i)});
            return;
        }
        Object obj;
        String str = "MicroMsg.ChattingUI";
        String str2 = "onActivityResult requestCode:%d, data is null:%b  rawUserName:%s ";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Boolean.valueOf(intent == null);
        objArr[2] = this.ysi;
        com.tencent.mm.sdk.platformtools.x.i(str, str2, objArr);
        if (intent == null && i == com.tencent.mm.plugin.appbrand.jsapi.media.e.CTRL_INDEX) {
            com.tencent.mm.aq.n Pn = com.tencent.mm.aq.n.Pn();
            str = crz();
            ArrayList arrayList = new ArrayList();
            if (!bh.ov(str)) {
                for (com.tencent.mm.aq.n.e eVar : Pn.hBZ.values()) {
                    if (str.equals(eVar.toUserName)) {
                        arrayList.add(eVar.hCn);
                    }
                }
            }
            if (arrayList.size() > 0) {
                intent = new Intent();
                intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(Integer.valueOf(-1));
                intent.putIntegerArrayListExtra("GalleryUI_ImgIdList", arrayList2);
                i2 = -1;
                com.tencent.mm.plugin.report.service.g.pQN.a(594, 4, 1, true);
            }
        }
        if (this.ysf.ytm && this.yvY.yAQ) {
            this.yvY.ctV();
        }
        com.tencent.mm.ui.chatting.b.c cVar = this.ywd;
        switch (i) {
            case TXCStreamDownloader.TXE_DOWNLOAD_INFO_CONNECT_SUCCESS /*12001*/:
                if (cVar.yyI != null) {
                    com.tencent.mm.app.plugin.a.a aVar = cVar.yyI;
                    if (aVar.fhr == null) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null, maybe has been released");
                    } else if (i2 == -1) {
                        Toast.makeText(aVar.fhr.csq().getContext(), R.l.edn, 0).show();
                        com.tencent.mm.sdk.b.b duVar = new du();
                        duVar.fss.op = 0;
                        duVar.fss.userName = aVar.fhr.crz();
                        duVar.fss.context = aVar.fhr.csq().getContext();
                        com.tencent.mm.sdk.b.a.xef.m(duVar);
                    } else if (i2 == 0) {
                        Toast.makeText(aVar.fhr.csq().getContext(), R.l.edm, 0).show();
                    }
                }
                obj = 1;
                break;
            default:
                obj = null;
                break;
        }
        if (obj != null) {
            return;
        }
        String stringExtra;
        if (i == 221) {
            if (intent != null) {
                stringExtra = intent.getStringExtra("result_msg");
                if (!bh.ov(stringExtra)) {
                    h.b(getContext(), stringExtra, "", false);
                }
            }
        } else if (i2 != -1) {
            if (i == 200 || i == 201 || i == 203) {
                this.ywe.csB().clearFocus();
            }
        } else if (!this.ywe.e(i, intent)) {
            ad adVar = this.yvS;
            switch (i) {
                case com.tencent.mm.plugin.appbrand.jsapi.a.f.CTRL_INDEX /*208*/:
                    adVar.al(intent);
                    obj = 1;
                    break;
                case bp.CTRL_INDEX /*215*/:
                    adVar.al(intent);
                    obj = 1;
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.media.f.CTRL_INDEX /*216*/:
                    adVar.am(intent);
                    obj = 1;
                    break;
                case 218:
                    if (intent != null) {
                        if (intent.getBooleanExtra("from_record", false)) {
                            adVar.am(intent);
                        } else {
                            adVar.al(intent);
                        }
                    }
                    obj = 1;
                    break;
                default:
                    obj = null;
                    break;
            }
            if (obj == null && !this.yvT.f(i, intent)) {
                m mVar = this.yvV;
                switch (i) {
                    case 2002:
                        if (intent.getBooleanExtra("kfavorite", false)) {
                            duVar = new com.tencent.mm.g.a.cf();
                            com.tencent.mm.pluginsdk.model.f.a(duVar, intent);
                            duVar.fqp.pL = mVar.fhr.csq();
                            duVar.fqp.fqw = 42;
                            com.tencent.mm.sdk.b.a.xef.m(duVar);
                        }
                        obj = 1;
                        break;
                    default:
                        obj = null;
                        break;
                }
                if (obj == null) {
                    String gu;
                    String stringExtra2;
                    d dVar = this.yvW;
                    switch (i) {
                        case 223:
                            if (i2 == -1 && intent != null) {
                                str2 = intent.getStringExtra("be_send_card_name");
                                gu = com.tencent.mm.z.r.gu(str2);
                                stringExtra2 = intent.getStringExtra("received_card_name");
                                boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                                com.tencent.mm.pluginsdk.ui.applet.e.a aVar2 = new com.tencent.mm.pluginsdk.ui.applet.e.a(dVar.fhr.csq().getContext());
                                com.tencent.mm.ad.b.a(str2, true, -1);
                                ar.Hg();
                                aVar2.bS(stringExtra2).Sp(new StringBuffer(!com.tencent.mm.z.s.gM(com.tencent.mm.z.c.EY().WM(str2).field_verifyFlag) ? dVar.fhr.csq().getResources().getString(R.l.dFp) : dVar.fhr.csq().getResources().getString(R.l.dFo)).append(gu).toString()).f(Boolean.valueOf(true)).BW(R.l.dGA).a(new d$1(dVar, str2, stringExtra2, booleanExtra)).pyk.show();
                            }
                            obj = 1;
                            break;
                        case 224:
                            if (i2 == -1 && intent != null) {
                                stringExtra = intent.getStringExtra("be_send_card_name");
                                str2 = intent.getStringExtra("received_card_name");
                                gu = intent.getStringExtra("custom_send_text");
                                boolean booleanExtra2 = intent.getBooleanExtra("Is_Chatroom", false);
                                Intent intent2 = new Intent(dVar.fhr.csq().getContext(), ChattingUI.class);
                                intent2.putExtra("Chat_User", str2);
                                intent2.putExtra("send_card_username", stringExtra);
                                intent2.putExtra("send_card_edittext", gu);
                                intent2.putExtra("Is_Chatroom", booleanExtra2);
                                dVar.fhr.csq().startActivity(intent2);
                            }
                            obj = 1;
                            break;
                        default:
                            obj = null;
                            break;
                    }
                    if (obj == null) {
                        l lVar = this.yvQ;
                        switch (i) {
                            case JsApiCheckIsSupportFaceDetect.CTRL_INDEX /*214*/:
                                ChatFooter.cbO();
                                lVar.fhr.csB().cbM();
                                obj = 1;
                                break;
                            default:
                                obj = null;
                                break;
                        }
                        if (obj == null) {
                            j jVar = this.yvZ;
                            switch (i) {
                                case com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX /*212*/:
                                    if (intent != null) {
                                        str = intent.getStringExtra("select_raw_user_name");
                                        str2 = intent.getStringExtra("Select_Conv_User");
                                        if (bh.ov(str2)) {
                                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.SearchImp", "@ %s", new Object[]{"[nobody]"});
                                            jVar.fhr.csB().Sw("");
                                            jVar.yzM = false;
                                        } else {
                                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.SearchImp", "@ %s", new Object[]{str2});
                                            jVar.fhr.csB().Sw(str2);
                                            jVar.fhr.csB().ad(jVar.fhr.crz(), str, str2);
                                            jVar.yzM = true;
                                        }
                                        obj = 1;
                                        break;
                                    }
                                    obj = 1;
                                    break;
                                default:
                                    obj = null;
                                    break;
                            }
                            if (obj == null) {
                                long longExtra;
                                com.tencent.mm.ui.chatting.b.a aVar3 = this.ywa;
                                switch (i) {
                                    case com.tencent.mm.plugin.appbrand.jsapi.share.i.CTRL_INDEX /*210*/:
                                        if (i2 == -1) {
                                            longExtra = intent.getLongExtra("App_MsgId", 0);
                                            ar.Hg();
                                            aVar3.aM(com.tencent.mm.z.c.Fa().dH(longExtra));
                                        }
                                        obj = 1;
                                        break;
                                    case 222:
                                        if (i2 == -1 && intent != null) {
                                            str2 = intent.getStringExtra("service_app_package_name");
                                            gu = intent.getStringExtra("service_app_openid");
                                            stringExtra2 = intent.getStringExtra("service_app_appid");
                                            String str3 = "MicroMsg.ChattingUI.AppImp";
                                            String str4 = "request send wx msg, wxmessage[%b], package[%s], appId[%s], openId[%s]";
                                            Object[] objArr2 = new Object[4];
                                            objArr2[0] = Boolean.valueOf(aVar3.yyA != null);
                                            objArr2[1] = str2;
                                            objArr2[2] = stringExtra2;
                                            objArr2[3] = gu;
                                            com.tencent.mm.sdk.platformtools.x.i(str3, str4, objArr2);
                                            if (bh.ov(stringExtra2)) {
                                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI.AppImp", "REQUEST_CODE_SERVICE_APP openId is null");
                                                obj = 1;
                                                break;
                                            } else if (aVar3.yyA == null || bh.ov(str2)) {
                                                aVar3.n(com.tencent.mm.pluginsdk.model.app.g.aZ(stringExtra2, true));
                                                obj = 1;
                                                break;
                                            } else if (bh.ov(gu)) {
                                                an.bip().OI(stringExtra2);
                                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI.AppImp", "request send wx msg fail, openId is null, go get it");
                                                obj = 1;
                                                break;
                                            } else {
                                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.AppImp", "request send wx msg success = %b", new Object[]{Boolean.valueOf(aVar3.yyA.fM(str2, gu))});
                                                if (!aVar3.yyA.fM(str2, gu)) {
                                                    aVar3.n(com.tencent.mm.pluginsdk.model.app.g.aZ(stringExtra2, true));
                                                }
                                            }
                                        }
                                        obj = 1;
                                        break;
                                    default:
                                        obj = null;
                                        break;
                                }
                                if (obj == null) {
                                    y yVar = this.ywb;
                                    switch (i) {
                                        case 207:
                                            yVar.dm(intent.getStringExtra("art_smiley_slelct_data"), 4);
                                            obj = 1;
                                            break;
                                        default:
                                            obj = null;
                                            break;
                                    }
                                    if (obj == null) {
                                        int nv;
                                        switch (i) {
                                            case com.tencent.mm.plugin.appbrand.jsapi.a.d.CTRL_INDEX /*204*/:
                                                return;
                                            case com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX /*211*/:
                                                if (i2 == -1) {
                                                    Cursor managedQuery = managedQuery(intent.getData(), null, null, null, null);
                                                    if (managedQuery.moveToFirst()) {
                                                        startActivity(new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/" + managedQuery.getString(managedQuery.getColumnIndexOrThrow("_id")))));
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            case com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX /*213*/:
                                                if (intent != null && intent.getBooleanExtra("_delete_ok_", false)) {
                                                    finish();
                                                    return;
                                                }
                                                return;
                                            case 220:
                                                if (-1 == i2 && this.ywE != null && this.ywE.ytm) {
                                                    this.ywE.crR();
                                                    return;
                                                }
                                                return;
                                            case 225:
                                                stringExtra = intent.getStringExtra("enterprise_biz_name");
                                                longExtra = intent.getLongExtra("key_biz_chat_id", -1);
                                                s sVar = this.ywE;
                                                l.a(sVar.yrW, sVar, stringExtra, longExtra);
                                                return;
                                            case com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX /*226*/:
                                                SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                                                if (sightCaptureResult == null) {
                                                    return;
                                                }
                                                boolean z;
                                                if (sightCaptureResult.oqz) {
                                                    v vVar = this.yvT;
                                                    stringExtra2 = sightCaptureResult.oqH;
                                                    if (!bh.ov(stringExtra2)) {
                                                        try {
                                                            z = sightCaptureResult.oqA;
                                                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.SendImgImp", "doSendChattingImage, path: %s", new Object[]{stringExtra2});
                                                            ar.CG().a(new com.tencent.mm.aq.l(z ? 2 : 1, com.tencent.mm.z.q.FS(), vVar.fhr.csi().field_username, stringExtra2, 0, null, 0, "", "", true, R.g.bAH), 0);
                                                            return;
                                                        } catch (Exception e) {
                                                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI.SendImgImp", "doSendChattingImage error: %s", new Object[]{e.getMessage()});
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                }
                                                ad adVar2 = this.yvS;
                                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.VideoImp", "video path %s thumb path ", new Object[]{sightCaptureResult.oqB, sightCaptureResult.oqC});
                                                com.tencent.mm.modelvideo.o.TU();
                                                str2 = com.tencent.mm.modelvideo.s.nt(sightCaptureResult.oqD);
                                                if (!sightCaptureResult.oqB.equals(str2)) {
                                                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.VideoImp", "filepath not videopath and move it %s %s", new Object[]{sightCaptureResult.oqB, str2});
                                                    FileOp.at(sightCaptureResult.oqB, str2);
                                                }
                                                str2 = sightCaptureResult.oqD;
                                                int i3 = sightCaptureResult.oqF;
                                                str = adVar2.fhr.csi().field_username;
                                                aqc com_tencent_mm_protocal_c_aqc = sightCaptureResult.oqG;
                                                com.tencent.mm.modelvideo.r rVar = new com.tencent.mm.modelvideo.r();
                                                rVar.fileName = str2;
                                                rVar.hVH = i3;
                                                rVar.fDC = str;
                                                rVar.hVz = (String) g.Dj().CU().get(2, "");
                                                rVar.hVE = bh.Wo();
                                                rVar.hVF = bh.Wo();
                                                rVar.hVR = com_tencent_mm_protocal_c_aqc;
                                                rVar.hVL = 0;
                                                rVar.hVO = 1;
                                                com.tencent.mm.modelvideo.o.TU();
                                                nv = com.tencent.mm.modelvideo.s.nv(com.tencent.mm.modelvideo.s.nt(str2));
                                                if (nv <= 0) {
                                                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.VideoLogic", "get Video size failed :" + str2);
                                                    z = false;
                                                } else {
                                                    rVar.hlp = nv;
                                                    com.tencent.mm.modelvideo.o.TU();
                                                    str = com.tencent.mm.modelvideo.s.nu(str2);
                                                    i3 = com.tencent.mm.modelvideo.s.nv(str);
                                                    if (i3 <= 0) {
                                                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.VideoLogic", "get Thumb size failed :" + str + " size:" + i3);
                                                        z = false;
                                                    } else {
                                                        rVar.hVD = i3;
                                                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.VideoLogic", "prepareMMSightRecord file:" + str2 + " thumbsize:" + rVar.hVD + " videosize:" + rVar.hlp);
                                                        rVar.status = 102;
                                                        au auVar = new au();
                                                        auVar.dS(rVar.Ud());
                                                        auVar.setType(43);
                                                        auVar.eR(1);
                                                        auVar.dT(str2);
                                                        auVar.eQ(1);
                                                        auVar.aq(ba.hR(rVar.Ud()));
                                                        rVar.hVI = (int) ba.i(auVar);
                                                        z = com.tencent.mm.modelvideo.o.TU().a(rVar);
                                                    }
                                                }
                                                if (z) {
                                                    com.tencent.mm.modelvideo.t.nA(sightCaptureResult.oqD);
                                                    return;
                                                } else {
                                                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI.VideoImp", "prepareMMSightRecord failed");
                                                    return;
                                                }
                                            case GameJsApiGetOpenDeviceId.CTRL_BYTE /*227*/:
                                                if (i2 == -1 && intent != null) {
                                                    int gl;
                                                    this.yvT.f(com.tencent.mm.plugin.appbrand.jsapi.media.e.CTRL_INDEX, intent);
                                                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra("selected_file_lst");
                                                    if (this.ysk) {
                                                        gl = com.tencent.mm.z.m.gl(this.ysi);
                                                    } else {
                                                        gl = 0;
                                                    }
                                                    Iterator it = stringArrayListExtra.iterator();
                                                    while (it.hasNext()) {
                                                        str = (String) it.next();
                                                        IMediaObject wXFileObject = new WXFileObject();
                                                        wXFileObject.setFilePath(str);
                                                        WXMediaMessage wXMediaMessage = new WXMediaMessage();
                                                        wXMediaMessage.mediaObject = wXFileObject;
                                                        File file = new File(str);
                                                        wXMediaMessage.title = file.getName();
                                                        wXMediaMessage.description = bh.bx(file.length());
                                                        com.tencent.mm.pluginsdk.model.app.l.a(wXMediaMessage, "", "", this.ysi, 4, null);
                                                        nv = file.getName().lastIndexOf(".");
                                                        stringExtra = "";
                                                        if (nv >= 0 && nv < file.getName().length() - 1) {
                                                            stringExtra = file.getName().substring(nv + 1);
                                                        }
                                                        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
                                                        Object[] objArr3 = new Object[5];
                                                        objArr3[0] = Long.valueOf(file.length());
                                                        objArr3[1] = Integer.valueOf(0);
                                                        objArr3[2] = Integer.valueOf(this.ysk ? 1 : 0);
                                                        objArr3[3] = Integer.valueOf(gl);
                                                        objArr3[4] = stringExtra;
                                                        gVar.h(14986, objArr3);
                                                    }
                                                    stringExtra = intent.getStringExtra("with_text_content");
                                                    if (!bh.ov(stringExtra)) {
                                                        com.tencent.mm.plugin.messenger.a.f.aZh().dj(stringExtra, this.ysi);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            default:
                                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI", "onActivityResult: not found this requestCode");
                                                return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    protected boolean crb() {
        boolean z = false;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "writeOpLogAndMarkRead :" + crz());
        if (x.Wx(crz())) {
            ar.Hg();
            Cursor EH = com.tencent.mm.z.c.Fa().EH(crz());
            EH.moveToFirst();
            while (!EH.isAfterLast()) {
                cf auVar = new au();
                auVar.b(EH);
                if (auVar.getType() != 34) {
                    auVar.eQ(4);
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "writeOpLog: msgSvrId = " + auVar.field_msgSvrId + " status = " + auVar.field_status);
                }
                EH.moveToNext();
                z = true;
            }
            EH.close();
            if (!z) {
                return z;
            }
            ar.Hg();
            com.tencent.mm.z.c.Fd().Xa(crz());
            ar.Hg();
            com.tencent.mm.z.c.Fa().EF(crz());
            return z;
        }
        com.tencent.mm.ui.chatting.b.c cVar = this.ywd;
        if (cVar.fhr.csi().cia() && cVar.kEC != null) {
            if (cVar.vnK) {
                return com.tencent.mm.ag.y.Mi().aU(cVar.cti());
            }
            if (cVar.kEC.Lf()) {
                if (!(cVar.kEC.bI(false) == null || cVar.kEC.bI(false).LG() == null || bh.ov(cVar.kEC.Lm()))) {
                    ar.Hg();
                    aj Xk = com.tencent.mm.z.c.Fd().Xk(cVar.kEC.Lm());
                    if (Xk != null && Xk.field_username.equals(cVar.fhr.crz()) && Xk.field_unReadCount > 0) {
                        if (cVar.fhr.csq().getIntExtra("chat_from_scene", 0) == 2) {
                            return false;
                        }
                        ar.Hg();
                        com.tencent.mm.z.c.Fd().Xa(cVar.kEC.Lm());
                    }
                }
            } else if (!(cVar.kEC.Lb() || cVar.kEC.Ld())) {
                ar.Hg();
                aj ciK = com.tencent.mm.z.c.Fd().ciK();
                if (ciK != null && ciK.field_username.equals(cVar.fhr.crz()) && ciK.field_unReadCount > 0) {
                    ar.Hg();
                    com.tencent.mm.z.c.Fd().Xa("officialaccounts");
                }
            }
        }
        ar.Hg();
        return com.tencent.mm.z.c.Fd().Xa(cVar.fhr.crz());
    }

    public void finish() {
        hideVKB();
        ag.h(new 18(this), 100);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " sceneType:" + kVar.getType());
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (this.ywu != null) {
            this.ywu.dismiss();
            this.ywu = null;
        }
        y yVar = this.ywb;
        if (522 == kVar.getType()) {
            HardCoderJNI.stopPerformace(HardCoderJNI.hcSendMsgEnable, yVar.yBR);
            yVar.yBR = 0;
        }
        if (csP()) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "onSceneEnd fragment not foreground, return");
        } else if (!bh.bF(getContext())) {
        } else {
            if (10 != kVar.getType() && o(i, i2, str)) {
                return;
            }
            if (i == 0 && i2 == 0) {
                switch (kVar.getType()) {
                    case 10:
                        if (!this.yvY.ysa && !this.yvY.yAH && !this.yvY.yAM) {
                            i iVar = this.yvL;
                            com.tencent.mm.modelsimple.j jVar = (com.tencent.mm.modelsimple.j) kVar;
                            if (jVar.hMK != null && jVar.hMK.equals(iVar.fhr.crz())) {
                                if (jVar.content == null || jVar.content.length != 4) {
                                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.DirectScendImp", "unknown directsend op");
                                    return;
                                }
                                int p = com.tencent.mm.a.n.p(jVar.content, 0);
                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.DirectScendImp", "directsend: status=" + p);
                                switch (p) {
                                    case 1:
                                        iVar.yzK = true;
                                        iVar.fhr.csq().setMMTitle(R.l.dTc);
                                        iVar.handler.sendMessageDelayed(new Message(), 15000);
                                        com.tencent.mm.sdk.b.a.xef.m(new mn());
                                        return;
                                    case 3:
                                        iVar.yzK = true;
                                        iVar.fhr.csq().setMMTitle(R.l.dTd);
                                        iVar.handler.sendMessageDelayed(new Message(), 15000);
                                        return;
                                    default:
                                        iVar.yzK = false;
                                        iVar.fhr.cqY();
                                        iVar.fhr.cpl();
                                        return;
                                }
                            }
                            return;
                        }
                        return;
                    case 110:
                    case 522:
                        return;
                    case 127:
                        com.tencent.mm.modelvoice.p oc = com.tencent.mm.modelvoice.q.oc(((com.tencent.mm.modelvoice.f) kVar).fileName);
                        if (oc != null && oc.status == 99) {
                            com.tencent.mm.sdk.platformtools.ar.H(getContext(), R.l.dDx);
                            return;
                        }
                        return;
                    case 137:
                        List list = ((com.tencent.mm.pluginsdk.model.o) kVar).vdy;
                        if (list == null || list.contains(this.fAh.field_username)) {
                            com.tencent.mm.g.b.af afVar = this.fAh;
                            ar.Hg();
                            x WO = com.tencent.mm.z.c.EY().WO(afVar.field_username);
                            if (WO == null || ((int) WO.gJd) == 0) {
                                ar.Hg();
                                if (com.tencent.mm.z.c.EY().Q(afVar)) {
                                    ar.Hg();
                                    WO = com.tencent.mm.z.c.EY().WO(afVar.field_username);
                                } else {
                                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI.ChattingLogic", "insert contact failed, username = " + afVar.field_username);
                                    WO = null;
                                }
                            }
                            if (WO != null) {
                                com.tencent.mm.z.s.p(WO);
                                return;
                            }
                            return;
                        }
                        return;
                    case 525:
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "set msg remind!");
                        com.tencent.mm.ui.snackbar.a.a(getContext(), getContentView(), getString(R.l.epa), "");
                        return;
                    case 551:
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "cpan[refresh top btn]");
                        this.xLk = com.tencent.mm.z.m.gd(crz());
                        cqZ();
                        return;
                    case 594:
                        bdl Sl = ((com.tencent.mm.modelsimple.z) kVar).Sl();
                        if (!bh.ov(Sl.wJz)) {
                            h.a(getContext(), Sl.wJz, "", getMMString(R.l.dSJ), new 19(this));
                            return;
                        }
                        return;
                    case 610:
                        cf cfVar = ((com.tencent.mm.plugin.chatroom.d.k) kVar).fEJ;
                        cfVar.cjy();
                        ar.Hg();
                        com.tencent.mm.z.c.Fa().b(cfVar.field_msgSvrId, cfVar);
                        Toast.makeText(getContext(), getMMString(R.l.epS), 0).show();
                        com.tencent.mm.plugin.report.service.g.pQN.a(219, 24, (long) ((com.tencent.mm.plugin.chatroom.d.k) kVar).kZx, true);
                        return;
                    default:
                        return;
                }
            }
            if (i2 == -49) {
                if (this.ywH == null) {
                    this.ywH = new com.tencent.mm.ui.bindqq.b(getContext(), new 22(this));
                }
                this.ywH.cqF();
            } else if (kVar.getType() == 109) {
                h.h(getContext(), R.l.dRh, R.l.dGO);
            }
            if (kVar.getType() == 594) {
                Object obj;
                bdl Sl2 = ((com.tencent.mm.modelsimple.z) kVar).Sl();
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "[oneliang][revokeMsgTimeout] sysWording:%s", new Object[]{Sl2.wJA});
                if (i2 == 0 || bh.ov(Sl2.wJA)) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "[oneliang][revokeMsg] sysWording:%s", new Object[]{Sl2.wJA});
                    this.ywu = h.a(getContext(), Sl2.wJA, "", getMMString(R.l.dSJ), new 20(this));
                } else {
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "[oneliang][revokeMsg] errorCode:%s,sysWording:%s", new Object[]{Integer.valueOf(i2), Sl2.wJA});
                    this.ywu = h.a(getContext(), getMMString(R.l.dSK), "", getMMString(R.l.dSJ), new 21(this));
                }
            }
            if (kVar.getType() == 525) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI", "[setMsgRemind] scene type:%s errCode:%s, errType:%s, errMsg:%s", new Object[]{Integer.valueOf(525), Integer.valueOf(i2), Integer.valueOf(i), bh.ou(str)});
                h.b(getContext(), bh.ov(str) ? getString(R.l.eEt) : str, getString(R.l.eEu), true);
                com.tencent.mm.plugin.report.service.g.pQN.a(795, 4, 1, false);
            }
            if (kVar.getType() == 610) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "scene type:%s errCode:%s, errType:%s, errMsg:%s", new Object[]{Integer.valueOf(610), Integer.valueOf(i2), Integer.valueOf(i), bh.ou(str)});
                h.b(getContext(), getString(R.l.epQ), getString(R.l.dGO), true);
            }
        }
    }

    public final String csX() {
        if (this.ywd.vnK) {
            if (this.ywd.yyK) {
                if (this.ywd.ync == null) {
                    return null;
                }
                return this.ywd.ync.field_chatName;
            } else if (this.ywd.piK != null) {
                return this.ywd.piK.field_userName;
            } else {
                return null;
            }
        } else if (this.fAh != null) {
            return this.fAh.field_nickname;
        } else {
            return null;
        }
    }

    protected final boolean o(int i, int i2, String str) {
        if (com.tencent.mm.ui.t.a.a(getContext(), i, i2, str, 7) || com.tencent.mm.ui.t.a(getContext(), i, i2, new Intent().setClass(getContext(), LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str)) {
            return true;
        }
        return false;
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        if (csP()) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "onNotifyChange fragment not foreground, return");
            return;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "onNotifyChange " + str);
        ar.Hg();
        com.tencent.mm.g.b.af WO = com.tencent.mm.z.c.EY().WO(crz());
        if (WO != null && ((int) WO.gJd) != 0) {
            if (bh.ov(WO.field_nickname)) {
                WO.dc(this.fAh.field_nickname);
            }
            this.fAh = WO;
            cqY();
            cpl();
            if (this.ywd.yyK) {
                this.xLk = com.tencent.mm.ag.a.e.c(this.ywd.ync);
            } else {
                this.xLk = com.tencent.mm.z.m.gd(crz());
            }
            this.ywh.cts();
        }
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        a((String) obj, null);
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i;
        int i2 = 1;
        super.onConfigurationChanged(configuration);
        f fVar = this.ywh;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.ChattingHeadereMgr", "getConfiguration().orientation = " + fVar.fhr.csq().getMMResources().getConfiguration().orientation + ", newConfig.orientation = " + configuration.orientation);
        fVar.fhr.csq().getMMResources().getConfiguration().orientation = configuration.orientation;
        ChatFooter csB = fVar.fhr.csB();
        csB.caw();
        csB.cbS();
        csB.Cn(-1);
        csB.vqB = true;
        if (csB.okx != null) {
            csB.okx.th();
        }
        fVar.yvU.bSr();
        j jVar = fVar.yvZ;
        jVar.yzO = jVar.fhr.csB().cbs();
        jVar.ctB();
        if (fVar.yzn != null) {
            i = 1;
        } else {
            i = 0;
        }
        if (fVar.yzq == null) {
            i2 = 0;
        }
        if ((i & i2) != 0) {
            i2 = com.tencent.mm.compatible.util.a.g(fVar.fhr.csq().thisActivity());
            fVar.yzq.setMinimumHeight(i2);
            LayoutParams layoutParams = fVar.yzq.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LayoutParams(-1, -1);
            }
            layoutParams.height = i2;
            fVar.yzq.setLayoutParams(layoutParams);
            layoutParams = fVar.yzn.getLayoutParams();
            layoutParams.height = i2;
            fVar.yzn.setLayoutParams(layoutParams);
        }
        if (fVar.yzo != null) {
            fVar.yzo.xJY.mActionBar.onConfigurationChanged(configuration);
        }
    }

    public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.c cVar, com.tencent.mm.plugin.messenger.foundation.a.a.c.c cVar2) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI", "on msg notify change");
        if (this.fAh.field_username.equals(cVar2.talker) && "insert".equals(cVar2.ooU) && cVar2.ooV.size() > 0 && ((au) cVar2.ooV.get(0)).field_isSend == 0) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI", "summerbadcr oreh onNotifyChange receive a new msg flag[%d], msgSeq[%d]", new Object[]{Integer.valueOf(((au) cVar2.ooV.get(0)).field_flag), Long.valueOf(((au) cVar2.ooV.get(0)).field_msgSeq)});
            this.ywB = bh.Wp();
        }
    }

    public final boolean a(ChattingUI.b bVar) {
        if (bVar == null || this.yws.contains(bVar)) {
            return false;
        }
        return this.yws.add(bVar);
    }

    public final boolean b(ChattingUI.b bVar) {
        return this.yws.remove(bVar);
    }
}
