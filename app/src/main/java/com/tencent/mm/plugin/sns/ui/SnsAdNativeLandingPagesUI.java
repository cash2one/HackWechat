package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v4.app.o;
import android.support.v4.view.ViewPager.e;
import android.support.v4.view.u;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Base64;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.c.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j.4;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j.5;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdlandingDummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.DummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b$a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.blt;
import com.tencent.mm.protocal.c.blu;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.snackbar.b.b;
import com.tencent.mm.ui.v;
import com.tencent.wcdb.FileUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class SnsAdNativeLandingPagesUI extends MMActivity {
    public static boolean rxR = false;
    int cOY;
    String fzW;
    private long gzo = 0;
    int hOz;
    String iUN;
    private long jIb = 0;
    private int kDP;
    private int kDQ;
    private ImageView kDe;
    private int kSc = 0;
    private int kSd = 0;
    private int kSe = 0;
    private int kSf = 0;
    private boolean klo = false;
    String lOX;
    String lOY;
    private d mfB = new d(ac.getContext());
    private ImageView mxv;
    protected b nah = new 6(this);
    String qZM;
    private int reQ;
    String reb;
    String rec;
    String rfu;
    private int rgY;
    int rha;
    private int rkh = 1000;
    private int rki = 700;
    private int rkj = 250;
    z rmT;
    private View rno;
    public LinkedList<c> rxB = new LinkedList();
    private ImageView rxC;
    private ImageView rxD;
    private TextView rxE;
    Bundle rxF;
    b rxG;
    private boolean rxH = false;
    String rxI;
    String rxJ;
    private String rxK;
    String rxL;
    String rxM;
    String rxN;
    private ImageView rxO;
    String rxP;
    String rxQ;
    public Map<String, String> rxS = new HashMap();
    g rxT = new g();
    boolean rxU = false;
    private int rxV = 0;
    private boolean rxW = false;
    String rxX;
    String rxY;
    String rxZ;
    String rya;
    private AdlandingDummyViewPager ryb;
    int ryc;
    int ryd;
    private af rye = new af();
    private LinkedList<View> ryf;
    private boolean ryg = true;
    private View ryh;
    m ryi;
    private volatile int ryj = 2;
    private BroadcastReceiver ryk = new BroadcastReceiver(this) {
        final /* synthetic */ SnsAdNativeLandingPagesUI ryv;

        {
            this.ryv = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("show", 0);
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b bVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) ((o) this.ryv.ryb.yE).R(this.ryv.ryb.yF);
            x.d("MicroMsg.SnsAdNativeLandingPagesUI", "recv videoProgressbarStatusChangeReceiver show %d", new Object[]{Integer.valueOf(intExtra)});
            if (bVar.bxK()) {
                bVar.bxJ();
            } else {
                bVar.bxI();
            }
        }
    };
    private BroadcastReceiver ryl = new 9(this);
    private b$a rym = new 12(this);
    private e ryn = new 13(this);
    private com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a ryo = new com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a(this) {
        final /* synthetic */ SnsAdNativeLandingPagesUI ryv;

        {
            this.ryv = r1;
        }

        public final void as(Object obj) {
            this.ryv.rye.removeCallbacksAndMessages(null);
            this.ryv.rye.post(new 1(this, obj));
        }

        public final void e(int i, int i2, Object obj) {
        }
    };
    private Map<Integer, Fragment> ryp = new HashMap();
    private boolean ryq = true;
    private boolean ryr = true;
    private BroadcastReceiver rys = new BroadcastReceiver(this) {
        final /* synthetic */ SnsAdNativeLandingPagesUI ryv;

        {
            this.ryv = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                x.d("MicroMsg.SnsAdNativeLandingPagesUI", "android.intent.action.SCREEN_OFF");
            } else if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
                x.d("MicroMsg.SnsAdNativeLandingPagesUI", "android.intent.action.SCREEN_ON");
                this.ryv.bAi();
            }
        }
    };
    private j ryt = null;
    private r ryu = null;
    private long startTime;
    String uin;
    Map<String, String> values;

    private class a {
        public String lOY;
        public String rfu;
        public String rfv;
        final /* synthetic */ SnsAdNativeLandingPagesUI ryv;

        private a(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
            this.ryv = snsAdNativeLandingPagesUI;
            this.lOY = "";
            this.rfu = "";
            this.rfv = "";
        }
    }

    static /* synthetic */ void M(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        if (snsAdNativeLandingPagesUI.rxB != null) {
            Iterator it = snsAdNativeLandingPagesUI.rxB.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b bVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) snsAdNativeLandingPagesUI.ryp.get(Integer.valueOf(((c) it.next()).id));
                if (bVar != null) {
                    bVar.rmW = true;
                }
            }
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) snsAdNativeLandingPagesUI.ryp.get(Integer.valueOf(((c) snsAdNativeLandingPagesUI.rxB.getFirst()).id))).bxJ();
        }
    }

    static /* synthetic */ void O(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        for (i iVar : snsAdNativeLandingPagesUI.bAh()) {
            if (iVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) {
                ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) iVar).bwF();
            }
        }
    }

    static /* synthetic */ void W(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "setFullScreen");
        if (VERSION.SDK_INT < 16) {
            snsAdNativeLandingPagesUI.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            return;
        }
        snsAdNativeLandingPagesUI.getWindow().getDecorView().setSystemUiVisibility(snsAdNativeLandingPagesUI.getWindow().getDecorView().getSystemUiVisibility() & -1025);
    }

    static /* synthetic */ void bAs() {
    }

    static /* synthetic */ void d(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        if (snsAdNativeLandingPagesUI.ryj == 0) {
            try {
                Map hashMap = new HashMap();
                hashMap.put("startIndex", Integer.valueOf(snsAdNativeLandingPagesUI.rxV));
                ((i) snsAdNativeLandingPagesUI.bAh().get(0)).Q(hashMap);
            } catch (Exception e) {
            }
            snsAdNativeLandingPagesUI.bAo();
            if (snsAdNativeLandingPagesUI.ryg && snsAdNativeLandingPagesUI.ryh != null && snsAdNativeLandingPagesUI.rxH) {
                snsAdNativeLandingPagesUI.ryg = false;
                snsAdNativeLandingPagesUI.kSc = snsAdNativeLandingPagesUI.getIntent().getIntExtra("img_gallery_top", 0);
                snsAdNativeLandingPagesUI.kSd = snsAdNativeLandingPagesUI.getIntent().getIntExtra("img_gallery_left", 0);
                snsAdNativeLandingPagesUI.kSe = snsAdNativeLandingPagesUI.getIntent().getIntExtra("img_gallery_width", 0);
                snsAdNativeLandingPagesUI.kSf = snsAdNativeLandingPagesUI.getIntent().getIntExtra("img_gallery_height", 0);
                snsAdNativeLandingPagesUI.rxG.r(snsAdNativeLandingPagesUI.kSd, snsAdNativeLandingPagesUI.kSc, snsAdNativeLandingPagesUI.kSe, snsAdNativeLandingPagesUI.kSf);
                snsAdNativeLandingPagesUI.kDe.setVisibility(8);
                snsAdNativeLandingPagesUI.rxC.setVisibility(8);
                b bVar = snsAdNativeLandingPagesUI.rxG;
                View view = snsAdNativeLandingPagesUI.ryh;
                LinkedList linkedList = snsAdNativeLandingPagesUI.ryf;
                View view2 = snsAdNativeLandingPagesUI.mxv;
                snsAdNativeLandingPagesUI.isFullScreen();
                bVar.a(view, linkedList, view2, new 3(snsAdNativeLandingPagesUI));
                return;
            }
            snsAdNativeLandingPagesUI.rno.post(new 4(snsAdNativeLandingPagesUI));
        }
    }

    static /* synthetic */ void l(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c cVar;
        snsAdNativeLandingPagesUI.bAe();
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c cVar2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c) snsAdNativeLandingPagesUI.ryb.yE;
        if (cVar2 == null) {
            u cVar3 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c(snsAdNativeLandingPagesUI.getSupportFragmentManager(), new ArrayList());
            snsAdNativeLandingPagesUI.ryb.a(cVar3);
            cVar = cVar3;
        } else {
            cVar = cVar2;
        }
        int i = 0;
        while (i < snsAdNativeLandingPagesUI.rxB.size()) {
            c cVar4 = (c) snsAdNativeLandingPagesUI.rxB.get(i);
            if (cVar4.rgW) {
                x.i("MicroMsg.SnsAdNativeLandingPagesUI", "loadLandingPages load %d", new Object[]{Integer.valueOf(i)});
                Fragment fragment = (Fragment) snsAdNativeLandingPagesUI.ryp.get(Integer.valueOf(cVar4.id));
                if (fragment == null) {
                    fragment = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b.a(cVar4, snsAdNativeLandingPagesUI.ryb, snsAdNativeLandingPagesUI.rmT, i == snsAdNativeLandingPagesUI.rxB.size() + -1, i == 0 ? snsAdNativeLandingPagesUI.rym : null, snsAdNativeLandingPagesUI.rxH, snsAdNativeLandingPagesUI.bAk());
                    snsAdNativeLandingPagesUI.ryp.put(Integer.valueOf(cVar4.id), fragment);
                } else {
                    ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) fragment).a(cVar4);
                }
                if (fragment != null) {
                    cVar.a(fragment, i);
                }
            }
            i++;
        }
        cVar.notifyDataSetChanged();
        snsAdNativeLandingPagesUI.ryb.xe(snsAdNativeLandingPagesUI.rxB.size());
    }

    static /* synthetic */ void m(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        if (snsAdNativeLandingPagesUI.reQ != 2) {
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
            Object[] objArr = new Object[7];
            objArr[0] = com.tencent.mm.plugin.sns.data.i.eq(com.tencent.mm.plugin.sns.data.i.lS(snsAdNativeLandingPagesUI.rxT.fzW));
            objArr[1] = snsAdNativeLandingPagesUI.qZM == null ? "" : snsAdNativeLandingPagesUI.qZM;
            objArr[2] = Integer.valueOf(snsAdNativeLandingPagesUI.rxT.rol);
            objArr[3] = Integer.valueOf(snsAdNativeLandingPagesUI.rxT.rom);
            objArr[4] = Long.valueOf(snsAdNativeLandingPagesUI.gzo);
            objArr[5] = Integer.valueOf(snsAdNativeLandingPagesUI.rgY);
            objArr[6] = snsAdNativeLandingPagesUI.rxT.rov;
            gVar.h(14655, objArr);
        }
    }

    static /* synthetic */ void w(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "doTransimt snsAdNativeLadingPagesUI");
        g gVar = snsAdNativeLandingPagesUI.rxT;
        gVar.mod++;
        String bAq = snsAdNativeLandingPagesUI.bAq();
        String bAr = snsAdNativeLandingPagesUI.bAr();
        a bAp = snsAdNativeLandingPagesUI.bAp();
        if (bAp != null) {
            AdLandingPagesProxy.getInstance().doTransimt(snsAdNativeLandingPagesUI, bAr, bAp.lOY, bAp.rfv, bAp.rfu, snsAdNativeLandingPagesUI.lOX, bAq);
            return;
        }
        AdLandingPagesProxy.getInstance().doTransimt(snsAdNativeLandingPagesUI, bAr, snsAdNativeLandingPagesUI.lOY, snsAdNativeLandingPagesUI.rxP, snsAdNativeLandingPagesUI.rfu, snsAdNativeLandingPagesUI.lOX, bAq);
    }

    static /* synthetic */ void x(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "doShareToTimeline snsAdNativeLadingPagesUI");
        g gVar = snsAdNativeLandingPagesUI.rxT;
        gVar.moe++;
        String str = snsAdNativeLandingPagesUI.lOX;
        a bAp = snsAdNativeLandingPagesUI.bAp();
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.SnsAdNativeLandingPagesUI", "doTimeline fail, link is null");
            return;
        }
        int i = snsAdNativeLandingPagesUI.kSe;
        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "doTimeline, init intent");
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_width", i);
        intent.putExtra("Ksnsupload_height", i);
        intent.putExtra("Ksnsupload_link", snsAdNativeLandingPagesUI.lOX);
        if (bAp != null) {
            intent.putExtra("Ksnsupload_title", bAp.lOY);
            intent.putExtra("Ksnsupload_imgurl", bAp.rfv);
        } else {
            intent.putExtra("Ksnsupload_title", snsAdNativeLandingPagesUI.lOY);
            intent.putExtra("Ksnsupload_imgurl", snsAdNativeLandingPagesUI.rxP);
        }
        intent.putExtra("Ksnsupload_canvas_info", snsAdNativeLandingPagesUI.bAr());
        intent.putExtra("Ksnsupload_contentattribute", 0);
        intent.putExtra("Ksnsupload_source", 1);
        intent.putExtra("Ksnsupload_type", 1);
        str = snsAdNativeLandingPagesUI.bAq();
        if (!bh.ov(str)) {
            intent.putExtra("key_snsad_statextstr", str);
        }
        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "doTimeline, start activity");
        intent.putExtra("need_result", true);
        str = "sns_";
        if (snsAdNativeLandingPagesUI.cOY == 1 || snsAdNativeLandingPagesUI.cOY == 2 || snsAdNativeLandingPagesUI.cOY == 3 || snsAdNativeLandingPagesUI.cOY == 4 || snsAdNativeLandingPagesUI.cOY == 9 || snsAdNativeLandingPagesUI.cOY == 10 || snsAdNativeLandingPagesUI.cOY == 11) {
            str = "sns_" + snsAdNativeLandingPagesUI.fzW;
        } else if (snsAdNativeLandingPagesUI.cOY == 5 || snsAdNativeLandingPagesUI.cOY == 6) {
            str = "msg_" + snsAdNativeLandingPagesUI.getIntent().getExtras().getLong("msg_id", -2147483648L);
        } else if (snsAdNativeLandingPagesUI.cOY == 7) {
            str = "fav_" + snsAdNativeLandingPagesUI.getIntent().getExtras().getString("sns_landing_favid");
        }
        String hz = com.tencent.mm.z.u.hz(str);
        com.tencent.mm.z.u.GK().t(hz, true).o("prePublishId", str);
        intent.putExtra("reportSessionId", hz);
        com.tencent.mm.bm.d.a(snsAdNativeLandingPagesUI.mController.xIM, "sns", ".ui.SnsUploadUI", intent, 1, false);
    }

    static /* synthetic */ void y(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        g gVar = snsAdNativeLandingPagesUI.rxT;
        gVar.hKM++;
        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "doFav snsAdNativeLadingPagesUI");
        long j = snsAdNativeLandingPagesUI.getIntent().getExtras().getLong("msg_id", -2147483648L);
        String str = null;
        if (!bh.ov(snsAdNativeLandingPagesUI.fzW)) {
            str = AdLandingPagesProxy.getInstance().getSnsInfo(snsAdNativeLandingPagesUI.fzW).byq();
        }
        String ou = bh.ou(snsAdNativeLandingPagesUI.getIntent().getStringExtra("prePublishId"));
        a bAp = snsAdNativeLandingPagesUI.bAp();
        String bAq = snsAdNativeLandingPagesUI.bAq();
        String bAr = snsAdNativeLandingPagesUI.bAr();
        if (bAp != null) {
            AdLandingPagesProxy.getInstance().doFavAdlanding(j, str, snsAdNativeLandingPagesUI.cOY, snsAdNativeLandingPagesUI.lOX, ou, bAp.lOY, bAp.rfu, bAr, 34, bAp.rfv, bAq);
        } else {
            AdLandingPagesProxy.getInstance().doFavAdlanding(j, str, snsAdNativeLandingPagesUI.cOY, snsAdNativeLandingPagesUI.lOX, ou, snsAdNativeLandingPagesUI.lOY, snsAdNativeLandingPagesUI.rfu, bAr, 34, snsAdNativeLandingPagesUI.rxP, bAq);
        }
        ((com.tencent.mm.plugin.fav.a.m) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.fav.a.m.class)).a(0, 34, snsAdNativeLandingPagesUI, snsAdNativeLandingPagesUI.nah);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.startTime = System.currentTimeMillis();
        this.gzo = System.currentTimeMillis();
        this.rxT.gzo = this.gzo;
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.a aVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.a(this);
        bAi();
        int[] dv = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac.dv(this);
        this.kDP = dv[0];
        this.kDQ = dv[1];
        this.rxF = bundle;
        this.mController.hideTitleView();
        getWindow().addFlags(FileUtils.S_IWUSR);
        AdLandingPagesProxy.create(this.mfB);
        this.mfB.I(new 15(this));
        this.cOY = getIntent().getIntExtra("sns_landig_pages_from_source", 1);
        this.rgY = getIntent().getIntExtra("sns_landig_pages_origin_from_source", 0);
        this.rxI = getIntent().getStringExtra("sns_landing_pages_xml");
        String stringExtra = getIntent().getStringExtra("sns_landing_pages_too_large_xml_path");
        if (bh.ov(this.rxI) && !bh.ov(stringExtra)) {
            this.rxI = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac.Le(stringExtra);
        }
        if (bh.ov(this.rxI)) {
            finish();
            return;
        }
        this.rxI = this.rxI.replaceAll("</*RecXml[\\s|\\S]*?>", "");
        this.rxT.qZP = getIntent().getStringExtra("sns_landing_pages_expid");
        this.rxJ = getIntent().getStringExtra("sns_landing_pages_xml_prefix");
        this.fzW = getIntent().getStringExtra("sns_landing_pages_share_sns_id");
        this.rxQ = getIntent().getStringExtra("sns_landing_pages_rawSnsId");
        this.qZM = getIntent().getStringExtra("sns_landing_pages_ux_info");
        this.reb = getIntent().getStringExtra("sns_landing_pages_aid");
        this.iUN = getIntent().getStringExtra("sns_landing_pages_traceid");
        Object stringExtra2 = getIntent().getStringExtra("sns_landing_pages_search_extra");
        g gVar = this.rxT;
        if (!TextUtils.isEmpty(stringExtra2)) {
            if (gVar.extra.length() > 0) {
                gVar.extra += "&";
            }
            gVar.extra += "searchextra=" + URLEncoder.encode(stringExtra2);
        }
        stringExtra2 = getIntent().getStringExtra("sns_landing_pages_extra");
        gVar = this.rxT;
        if (!TextUtils.isEmpty(stringExtra2)) {
            gVar.extra += "&extra1=" + URLEncoder.encode(stringExtra2);
        }
        rxR = getIntent().getBooleanExtra("sns_landing_is_native_sight_ad", false);
        this.reQ = getIntent().getIntExtra("sns_landing_pages_rec_src", 0);
        this.rxV = getIntent().getIntExtra("sns_landing_pages_from_outer_index", 0);
        this.rxK = getIntent().getStringExtra("sns_landing_pages_ad_info");
        this.rxH = getIntent().getBooleanExtra("sns_landing_pages_need_enter_and_exit_animation", false);
        if (this.rxH) {
            this.rxT.rol = 0;
            this.rxT.gyO = 0;
        } else {
            this.rxT.rol = 1;
            this.rxT.gyO = 1;
        }
        this.rxT.rom = this.cOY;
        this.rxT.ron = 0;
        this.rxT.roo = 0;
        this.rxT.rop = 1;
        this.rxT.roq = 0;
        this.rxT.rgY = this.rgY;
        if (this.rxJ == null || "".equals(this.rxI)) {
            this.rxJ = "adxml";
        }
        if (bh.ov(this.rxI) || bh.ov(this.rxJ)) {
            x.e("MicroMsg.SnsAdNativeLandingPagesUI", "landingPagesXml is " + this.rxI + ",landingPagesXmlPrex is " + this.rxJ);
            return;
        }
        this.values = f.y(this.rxI, this.rxJ);
        this.rxT.rov = bh.az((String) this.values.get("." + this.rxJ + ".adCanvasInfo.canvasId"), "");
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void onDestroy() {
        getWindow().clearFlags(FileUtils.S_IWUSR);
        if (this.klo) {
            x.i("MicroMsg.SnsAdNativeLandingPagesUI", "the SnsAdNativeLadingPagesUI is destroy");
            if (!this.rxU) {
                bAc();
                wW();
            }
        }
        unregisterReceiver(this.rys);
        super.onDestroy();
    }

    private void bAc() {
        for (Fragment fragment : ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c) this.ryb.yE).qj) {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b bVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) fragment;
            if (bVar.rmS != null && bVar.getUserVisibleHint()) {
                bVar.rmS.bxz();
            }
        }
    }

    private void wW() {
        int i;
        Iterator it;
        List<i> bAg = bAg();
        this.jIb += System.currentTimeMillis() - this.startTime;
        this.rxT.ros = (int) this.jIb;
        g gVar = this.rxT;
        if (this.rxB == null) {
            i = 0;
        } else {
            it = this.rxB.iterator();
            i = 0;
            while (it.hasNext()) {
                i = ((c) it.next()).rnP.size() + i;
            }
        }
        gVar.ror = i;
        g gVar2 = this.rxT;
        JSONArray jSONArray = new JSONArray();
        for (i iVar : bAg) {
            if (!iVar.bxe().rgX) {
                JSONObject jSONObject = new JSONObject();
                if (!iVar.s(jSONArray)) {
                    if (iVar.S(jSONObject)) {
                        jSONArray.put(jSONObject);
                    }
                    if (iVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o) {
                        it = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o) iVar).bxp().iterator();
                        while (it.hasNext()) {
                            jSONArray.put((JSONObject) it.next());
                        }
                    }
                }
            }
        }
        gVar2.rot = jSONArray.toString();
        x.d("MicroMsg.AdLandingPagesReportInfo", "componentsStatStr:%s", new Object[]{gVar2.rot});
        if (!bh.ov(gVar2.rot)) {
            try {
                gVar2.rot = URLEncoder.encode(gVar2.rot, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                x.e("MicroMsg.AdLandingPagesReportInfo", "not support encode " + e.toString());
            }
        }
        String bxP = this.rxT.bxP();
        if (this.rha == 2) {
            AdLandingPagesProxy.getInstance().doCgiReportCanvasBrowseInfo(15041, bxP);
            x.i("MicroMsg.SnsAdNativeLandingPagesUI", "post cgi stat 15041 data: " + bxP);
        } else if (AdLandingPagesProxy.getInstance().isRecExpAd(this.rxT.fzW)) {
            com.tencent.mm.plugin.report.service.g.pQN.k(14650, bxP);
            x.i("MicroMsg.SnsAdNativeLandingPagesUI", "post kv stat 14650 data: " + bxP);
        } else {
            com.tencent.mm.plugin.report.service.g.pQN.k(13387, bxP);
            x.i("MicroMsg.SnsAdNativeLandingPagesUI", "post kv stat 13387 data: " + bxP);
        }
    }

    protected void onResume() {
        super.onResume();
        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "onResume");
        bAi();
        android.support.v4.content.d.m(this).a(this.ryk, new IntentFilter("com.tencent.mm.adlanding.video_progressbar_change"));
        android.support.v4.content.d.m(this).a(this.ryl, new IntentFilter("com.tencent.mm.adlanding.set_uioption"));
        if (this.klo) {
            this.startTime = System.currentTimeMillis();
        }
        registerReceiver(this.rys, new IntentFilter("android.intent.action.SCREEN_ON"));
        if (this.rxW) {
            iG(false);
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.klo) {
            this.jIb += System.currentTimeMillis() - this.startTime;
        }
        android.support.v4.content.d.m(this).unregisterReceiver(this.ryk);
        android.support.v4.content.d.m(this).unregisterReceiver(this.ryl);
        if (this.ryt != null) {
            this.ryt.bxh();
        }
    }

    public void onSwipeBack() {
        this.rxT.gyO = 2;
        g gVar = this.rxT;
        gVar.roq++;
        super.onSwipeBack();
    }

    final void bAd() {
        if (bh.ov(this.rxK) && !bh.ov(this.rec)) {
            this.rxK = String.format("<ADInfo><adCanvasExt>%s</adCanvasExt></ADInfo>", new Object[]{this.rec});
        }
        if (!bh.ov(this.rxK)) {
            String az;
            String str = "ADInfo";
            Map y = f.y(this.rxK, str);
            this.qZM = bh.az((String) y.get("." + str + ".uxInfo"), "");
            this.rxT.qZM = this.qZM;
            this.reb = bh.az((String) y.get("." + str + ".session_data.aid"), "");
            this.iUN = bh.az((String) y.get("." + str + ".session_data.trace_id"), "");
            Map hashMap = new HashMap();
            str = "." + str + ".adCanvasExt.adCardItemList.cardItem";
            int i = 0;
            while (true) {
                String str2;
                if (i > 0) {
                    str2 = str + i;
                } else {
                    str2 = str;
                }
                if (!y.containsKey(str2 + ".cardTpId")) {
                    break;
                }
                String az2 = bh.az((String) y.get(str2 + ".cardTpId"), "");
                az = bh.az((String) y.get(str2 + ".cardExt"), "");
                if (!(bh.ov(az2) || bh.ov(az))) {
                    hashMap.put(az2, az);
                }
                i++;
            }
            this.rxS = hashMap;
            az = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.m(this.rxI, hashMap);
            if (!bh.ov(az)) {
                this.rxI = az;
            }
            if (!bh.ov(this.reb)) {
                if (this.rxI.contains("<originAid>")) {
                    this.rxI = this.rxI.replaceFirst("<originAid>[\\s\\S]*</originAid>", "<originAid>" + this.reb + "</originAid>");
                } else {
                    this.rxI = this.rxI.replace("<" + this.rxJ + ">", "<" + this.rxJ + "><originAid>" + this.reb + "</originAid>");
                }
            }
            if (!bh.ov(this.iUN)) {
                if (this.rxI.contains("<originTraceId>")) {
                    this.rxI = this.rxI.replaceFirst("<originTraceId>[\\s\\S]*</originTraceId>", "<originTraceId>" + this.iUN + "</originTraceId>");
                } else {
                    this.rxI = this.rxI.replace("<" + this.rxJ + ">", "<" + this.rxJ + "><originTraceId>" + this.iUN + "</originTraceId>");
                }
            }
            if (!bh.ov(this.qZM)) {
                if (this.rxI.contains("<originUxInfo>")) {
                    this.rxI = this.rxI.replaceFirst("<originUxInfo>[\\s\\S]*</originUxInfo>", "<originUxInfo>" + this.qZM + "</originUxInfo>");
                } else {
                    this.rxI = this.rxI.replace("<" + this.rxJ + ">", "<" + this.rxJ + "><originUxInfo>" + this.qZM + "</originUxInfo>");
                }
            }
        }
    }

    private void bAe() {
        if (this.rxB != null) {
            Iterator it = this.rxB.iterator();
            while (it.hasNext()) {
                List<s> list = ((c) it.next()).rnP;
                if (list != null) {
                    for (s sVar : list) {
                        sVar.wV(this.rgY == 0 ? this.cOY : this.rgY);
                        sVar.iB(rxR);
                        sVar.KW(this.qZM);
                        sVar.KX(this.uin);
                        sVar.wW(this.rha);
                    }
                }
            }
        }
    }

    private void bAf() {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c cVar;
        boolean z = false;
        bAe();
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c cVar2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c) this.ryb.yE;
        if (cVar2 == null) {
            u cVar3 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c(getSupportFragmentManager(), new ArrayList());
            this.ryb.a(cVar3);
            cVar = cVar3;
        } else {
            cVar = cVar2;
        }
        int i = 0;
        while (i < this.rxB.size()) {
            c cVar4 = (c) this.rxB.get(i);
            if (cVar4.rgW) {
                x.i("MicroMsg.SnsAdNativeLandingPagesUI", "loadFirstPage load %d", new Object[]{Integer.valueOf(i)});
                Fragment fragment = (Fragment) this.ryp.get(Integer.valueOf(cVar4.id));
                if (fragment == null) {
                    DummyViewPager dummyViewPager = this.ryb;
                    z zVar = this.rmT;
                    if (i == this.rxB.size() - 1) {
                        z = true;
                    }
                    fragment = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b.a(cVar4, dummyViewPager, zVar, z, i == 0 ? this.rym : null, this.rxH, bAk());
                    this.ryp.put(Integer.valueOf(cVar4.id), fragment);
                } else {
                    ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) fragment).a(cVar4);
                }
                if (fragment != null) {
                    cVar.a(fragment, i);
                }
                cVar.notifyDataSetChanged();
                this.ryb.xe(this.rxB.size());
            }
            i++;
        }
        cVar.notifyDataSetChanged();
        this.ryb.xe(this.rxB.size());
    }

    private List<i> bAg() {
        List<i> arrayList = new ArrayList();
        for (Fragment fragment : ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c) this.ryb.yE).qj) {
            arrayList.addAll(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) fragment).bxH());
        }
        return arrayList;
    }

    private List<i> bAh() {
        List<i> arrayList = new ArrayList();
        arrayList.addAll(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) this.ryp.get(Integer.valueOf(((c) this.rxB.getFirst()).id))).bxH());
        return arrayList;
    }

    @TargetApi(16)
    protected final void initView() {
        int identifier;
        super.initView();
        this.rno = findViewById(com.tencent.mm.plugin.sns.i.f.cIu);
        this.ryb = (AdlandingDummyViewPager) findViewById(com.tencent.mm.plugin.sns.i.f.qGc);
        this.ryb.rmH.add(this.ryn);
        if (this.rha == 2 && !bAl()) {
            LayoutParams layoutParams = (LayoutParams) this.ryb.getLayoutParams();
            Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            Point fz = ai.fz(this);
            if ((Math.max(fz.y, fz.x) > Math.max(point.y, point.x) ? 1 : 0) != 0) {
                identifier = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
                if (identifier > 0) {
                    identifier = Resources.getSystem().getDimensionPixelSize(identifier);
                    layoutParams.setMargins(0, 0, 0, identifier);
                    this.ryb.setLayoutParams(layoutParams);
                }
            }
            identifier = 0;
            layoutParams.setMargins(0, 0, 0, identifier);
            this.ryb.setLayoutParams(layoutParams);
        }
        this.mxv = (ImageView) findViewById(com.tencent.mm.plugin.sns.i.f.ckv);
        this.rxD = (ImageView) findViewById(com.tencent.mm.plugin.sns.i.f.qDF);
        this.kDe = (ImageView) findViewById(com.tencent.mm.plugin.sns.i.f.qDE);
        this.kDe.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsAdNativeLandingPagesUI ryv;

            {
                this.ryv = r1;
            }

            public final void onClick(View view) {
                if (this.ryv.mController.xJg == 1) {
                    this.ryv.aWs();
                }
                this.ryv.avV();
            }
        });
        this.rxC = (ImageView) findViewById(com.tencent.mm.plugin.sns.i.f.qDU);
        int i = com.tencent.mm.plugin.sns.i.c.white;
        if (!bAl()) {
            identifier = getResources().getColor(com.tencent.mm.plugin.sns.i.c.black);
            if (this.rxB == null || this.rxB.size() <= 0 || bh.ov(((c) this.rxB.getFirst()).iMN)) {
                i = identifier;
            } else {
                i = Color.parseColor(((c) this.rxB.getFirst()).iMN);
            }
            this.rxD.setBackgroundColor(i);
            i = com.tencent.mm.plugin.sns.i.c.black;
        }
        Drawable drawable = this.kDe.getDrawable();
        if (drawable != null) {
            android.support.v4.b.a.a.a(drawable, android.support.v4.content.a.c(this, i));
            this.kDe.setImageDrawable(drawable);
        }
        drawable = this.rxC.getDrawable();
        if (drawable != null) {
            android.support.v4.b.a.a.a(drawable, android.support.v4.content.a.c(this, i));
            this.rxC.setImageDrawable(drawable);
        }
        this.rxE = (TextView) findViewById(com.tencent.mm.plugin.sns.i.f.qDV);
        if (bAm() && !bAn() && this.rha == 2) {
            this.rxC.setVisibility(8);
            this.rxE.setVisibility(0);
            this.rxE.setText(this.rxL);
            this.rxE.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SnsAdNativeLandingPagesUI ryv;

                {
                    this.ryv = r1;
                }

                public final void onClick(View view) {
                    this.ryv.s(this.ryv, this.ryv.rxM, this.ryv.rxN);
                }
            });
        } else if (bAj()) {
            this.rxC.setOnClickListener(new 18(this));
        } else {
            this.rxC.setVisibility(8);
        }
        this.rxO = (ImageView) findViewById(com.tencent.mm.plugin.sns.i.f.qEX);
        if (this.rxB == null || this.rxB.size() == 0) {
            x.e("MicroMsg.SnsAdNativeLandingPagesUI", "landingPages is null");
            return;
        }
        bAf();
        this.rxG = new b(this.mController.xIM);
        this.rno.addOnLayoutChangeListener(new 2(this));
    }

    private boolean isFullScreen() {
        boolean z;
        if (this.rxB != null) {
            Iterator it = this.rxB.iterator();
            z = false;
            while (it.hasNext()) {
                Iterator it2 = ((c) it.next()).rnP.iterator();
                while (it2.hasNext()) {
                    if (((s) it2.next()).type == 82) {
                        z = true;
                        break;
                    }
                }
            }
        }
        z = false;
        if (z) {
            return false;
        }
        return true;
    }

    private void bAi() {
        if (bAl()) {
            x.i("MicroMsg.SnsAdNativeLandingPagesUI", "setFullScreen");
            if (VERSION.SDK_INT < 16) {
                getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                return;
            } else {
                getWindow().getDecorView().setSystemUiVisibility(5126);
                return;
            }
        }
        int i;
        if (VERSION.SDK_INT >= 21) {
            int color = getResources().getColor(com.tencent.mm.plugin.sns.i.c.white);
            if (this.rxB == null || this.rxB.size() <= 0 || bh.ov(((c) this.rxB.getFirst()).iMN)) {
                i = color;
            } else {
                i = Color.parseColor(((c) this.rxB.getFirst()).iMN);
            }
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(i);
        }
        i = getWindow().getDecorView().getSystemUiVisibility();
        if (VERSION.SDK_INT >= 17) {
            i &= -1031;
        }
        if (VERSION.SDK_INT >= 23) {
            i |= 8192;
        }
        getWindow().getDecorView().setSystemUiVisibility(i);
    }

    protected final int getLayoutId() {
        return i$g.qGZ;
    }

    private boolean bAj() {
        if (this.ryc == 0 || (this.ryc & 4) == 0 || (this.ryc & 2) == 0) {
            return true;
        }
        if ((bAn() && this.rha == 2) || (this.ryc & 1) == 0) {
            return true;
        }
        return false;
    }

    private boolean bAk() {
        return (this.ryc & 8) == 0;
    }

    private boolean bAl() {
        return this.ryd == 0;
    }

    private boolean bAm() {
        return (bh.ov(this.rxL) || bh.ov(this.rxM)) ? false : true;
    }

    private boolean bAn() {
        return (this.ryc & 16) == 0;
    }

    private void bAo() {
        Iterator it;
        List<i> bAh = bAh();
        LinkedList linkedList = new LinkedList();
        for (i view : bAh) {
            linkedList.add((View) view.getView().getParent());
        }
        this.ryh = null;
        if (this.ryf != null) {
            this.ryf.clear();
        }
        if (!linkedList.isEmpty()) {
            this.ryh = (View) linkedList.removeFirst();
            if (this.ryf == null) {
                this.ryf = new LinkedList();
            }
            this.ryf.clear();
            int height = this.ryh.getHeight();
            it = linkedList.iterator();
            int i = height;
            while (it.hasNext()) {
                View view2 = (View) it.next();
                i += view2.getHeight();
                this.ryf.add(view2);
                if (i >= this.kDQ) {
                    return;
                }
            }
        }
    }

    public final void avV() {
        bAc();
        wW();
        this.rxU = true;
        if (this.rxH) {
            try {
                ((i) bAh().get(0)).bxg();
            } catch (Exception e) {
            }
            this.ryb.d(0, false);
            RecyclerView bxG = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) this.ryp.get(Integer.valueOf(((c) this.rxB.getFirst()).id))).bxG();
            if (bxG != null) {
                ((LinearLayoutManager) bxG.TV).N(0, 0);
            }
            bAc();
            if (this.ryh != null) {
                this.ryh.postDelayed(new 5(this), 10);
                return;
            }
            finish();
            overridePendingTransition(0, 0);
            return;
        }
        finish();
    }

    public void onBackPressed() {
        avV();
    }

    private a bAp() {
        com.tencent.mm.plugin.sns.storage.b bVar = new com.tencent.mm.plugin.sns.storage.b(this.rxI);
        if (bVar.bwA()) {
            int adVoteIndex = AdLandingPagesProxy.getInstance().getAdVoteIndex(bVar.rfn.rfs, this.qZM, this.uin);
            if (adVoteIndex > 0 && adVoteIndex <= bVar.rfn.rft.size()) {
                com.tencent.mm.plugin.sns.storage.b.d dVar = (com.tencent.mm.plugin.sns.storage.b.d) bVar.rfn.rft.get(adVoteIndex - 1);
                a aVar = new a();
                if (bh.ov(dVar.lOY)) {
                    aVar.lOY = this.lOY;
                } else {
                    aVar.lOY = dVar.lOY;
                }
                if (bh.ov(dVar.rfu)) {
                    aVar.rfu = this.rfu;
                } else {
                    aVar.rfu = dVar.rfu;
                }
                if (bh.ov(dVar.rfv)) {
                    aVar.rfv = this.rxP;
                } else {
                    aVar.rfv = dVar.rfv;
                }
                return aVar;
            }
        }
        return null;
    }

    private String bAq() {
        blt com_tencent_mm_protocal_c_blt = new blt();
        com_tencent_mm_protocal_c_blt.wPl = new blu();
        com_tencent_mm_protocal_c_blt.wPl.wPp = this.rxT.qZM;
        com_tencent_mm_protocal_c_blt.wPl.wPo = this.rxT.fzW;
        com_tencent_mm_protocal_c_blt.wPl.hOz = this.hOz;
        try {
            return Base64.encodeToString(com_tencent_mm_protocal_c_blt.toByteArray(), 2);
        } catch (Exception e) {
            return "";
        }
    }

    private String bAr() {
        return this.rxI.replaceAll("(?s)<adCanvasInfoLeft[^>]*>.*?</adCanvasInfoLeft>", "").replaceAll("(?s)<adCanvasInfoRight[^>]*>.*?</adCanvasInfoRight>", "");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            if (i2 == -1) {
                h.bu(this.mController.xIM, this.mController.xIM.getString(com.tencent.mm.plugin.sns.i.j.dGG));
            }
        } else if (i == 2) {
            if (intent.getBooleanExtra("kfavorite", false)) {
                ((com.tencent.mm.plugin.fav.a.m) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.fav.a.m.class)).a(AdLandingPagesProxy.getInstance().doFav(intent, 42), 42, this, this.nah);
            }
        } else if (i == w.rlq) {
            try {
                String stringExtra = intent.getStringExtra("KComponentCid");
                for (i iVar : bAg()) {
                    if (iVar.bxf().equals(stringExtra)) {
                        w wVar = (w) iVar;
                        int intExtra = intent.getIntExtra("KStreamVideoPlayCount", 0);
                        int intExtra2 = intent.getIntExtra("KStreamVideoPlayCompleteCount", 0);
                        int intExtra3 = intent.getIntExtra("KStreamVideoTotalPlayTimeInMs", 0);
                        wVar.qPp = intExtra + wVar.qPp;
                        wVar.qPq += intExtra2;
                        wVar.qPr += intExtra3;
                        break;
                    }
                }
            } catch (Exception e) {
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void onKeyboardStateChanged() {
        super.onKeyboardStateChanged();
        if (this.ryb != null) {
            this.ryb.postDelayed(new Runnable(this) {
                final /* synthetic */ SnsAdNativeLandingPagesUI ryv;

                {
                    this.ryv = r1;
                }

                public final void run() {
                    if (this.ryv.mController.xJg != 1) {
                        this.ryv.bAi();
                    } else {
                        SnsAdNativeLandingPagesUI.W(this.ryv);
                    }
                    ArrayList arrayList = new ArrayList();
                    for (Fragment fragment : ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c) this.ryv.ryb.yE).qj) {
                        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b bVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) fragment;
                        int i = this.ryv.mController.xJg;
                        bVar.bxD();
                    }
                }
            }, 500);
        }
    }

    public final void iG(boolean z) {
        if (z && this.rha == 1) {
            AdLandingPagesProxy.getInstance().doDynamicUpdateScene(this.rxX, this.rxY, this.rxZ, this.ryo);
        }
        if (this.rha == 2 && !bh.ov(this.rya)) {
            AdLandingPagesProxy.getInstance().doSearchDynamicUpdateScene(this.rya, this.ryo);
        }
        this.rxW = true;
    }

    public final void a(s sVar, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        if (this.ryt == null || z3) {
            final boolean z4 = z3;
            com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a anonymousClass10 = new com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a(this) {
                final /* synthetic */ SnsAdNativeLandingPagesUI ryv;

                public final void as(Object obj) {
                }

                public final void e(int i, int i2, Object obj) {
                    this.ryv.iG(false);
                    if (z4) {
                        if (this.ryv.ryt != null) {
                            this.ryv.ryt.bxh();
                        }
                        if (this.ryv.ryu != null) {
                            this.ryv.ryu.dismiss();
                            this.ryv.ryu = null;
                        }
                    }
                }
            };
            if (!z3) {
                int i;
                Context context = this.mController.xIM;
                ViewGroup linearLayout = new LinearLayout(this.mController.xIM);
                v.fv(this.mController.xIM);
                if (bh.ov(sVar.rgT)) {
                    i = -1;
                } else {
                    i = Color.parseColor(sVar.rgT);
                }
                i a = am.a(context, sVar, linearLayout, i);
                this.ryt = new j(this.mController.xIM, a, str, str2, str3, z, z2);
                View view = a.getView();
                this.ryt.rjs = new 11(this, view);
                j jVar = this.ryt;
                if (!(jVar.kND == null || jVar.rjn == null)) {
                    jVar.rjn.getWindow().setFlags(8, 8);
                    jVar.rjn.getWindow().addFlags(131200);
                    if (jVar.rjs != null) {
                        jVar.rjn.setOnDismissListener(new 4(jVar));
                        jVar.rjn.setOnCancelListener(new 5(jVar));
                    }
                    jVar.rjn.setContentView(jVar.kND);
                    BottomSheetBehavior.i((View) jVar.kND.getParent()).q(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac.dv(jVar.mContext)[1]);
                    jVar.rjn.show();
                }
            }
            if (!bh.ov(str)) {
                AdLandingPagesProxy.getInstance().doFavOfficialItemScene(str, anonymousClass10);
                if (z3) {
                    this.ryu = h.a(this, getString(com.tencent.mm.plugin.sns.i.j.qLz), false, null);
                    return;
                }
                return;
            }
            return;
        }
        x.w("MicroMsg.SnsAdNativeLandingPagesUI", "bottom sheet appear several times");
        this.ryt.bxh();
        if (this.ryu != null) {
            this.ryu.dismiss();
            this.ryu = null;
        }
    }

    public final void s(Context context, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("sns_landig_pages_from_source", 14);
        intent.putExtra("sns_landig_pages_origin_from_source", this.rgY == 0 ? this.cOY : this.rgY);
        intent.putExtra("sns_landing_pages_canvasid", str);
        intent.putExtra("sns_landing_pages_canvas_ext", str2);
        intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
        intent.putExtra("sns_landing_pages_no_store", 1);
        String stringExtra = ((Activity) context).getIntent().getStringExtra("sns_landing_pages_sessionId");
        String stringExtra2 = ((Activity) context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
        if (!bh.ov(stringExtra)) {
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sessionId", valueOf);
                jSONObject.put("cid", "");
                jSONObject.put("adBuffer", !bh.ov(stringExtra2) ? stringExtra2 : "");
                jSONObject.put("preSessionId", stringExtra);
            } catch (Exception e) {
            }
            intent.putExtra("sns_landing_pages_search_extra", jSONObject.toString());
            intent.putExtra("sns_landing_pages_sessionId", valueOf);
            intent.putExtra("sns_landing_pages_ad_buffer", stringExtra2);
        }
        com.tencent.mm.bm.d.b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
    }
}
