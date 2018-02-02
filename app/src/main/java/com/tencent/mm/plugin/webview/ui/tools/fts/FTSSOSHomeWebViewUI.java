package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AccelerateInterpolator;
import android.widget.AbsoluteLayout;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.bc.b;
import com.tencent.mm.bv.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.fts.widget.FTSEditTextView;
import com.tencent.mm.ui.fts.widget.FTSMainUIEducationLayout;
import com.tencent.mm.ui.fts.widget.FTSMainUIEducationLayoutWithAll;
import com.tencent.mm.ui.fts.widget.FTSMainUIHotWordLayout;
import com.tencent.mm.ui.fts.widget.SOSEditTextView;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class FTSSOSHomeWebViewUI extends BaseSOSWebViewUI {
    private FTSMainUIEducationLayout qcQ;
    private OnClickListener qdi = new 16(this);
    private View qlf;
    private View qvO;
    private View tCG;
    private a tCH;
    private b tCI;
    private c tCJ;
    private d tCK;
    private float tCL = Float.MAX_VALUE;
    private FTSMainUIHotWordLayout tCM;
    private FTSMainUIEducationLayoutWithAll tCN;
    private View tCO;
    private TextView tCP;
    private View tCQ;
    private View tCR;
    private View tCS;
    private View tCT;
    private b tCU;
    private int tCV;
    private boolean tCW;
    private int tCX = 0;
    private String tCY = "";
    boolean tCZ;
    boolean tDa;
    private int tDb = 0;
    private int tDc = 0;
    private String tDd = "";
    private OnClickListener tDe = new 17(this);
    private a$a tDf = new 2(this);
    private a$a tDg = new a$a(this) {
        final /* synthetic */ FTSSOSHomeWebViewUI tDo;

        {
            this.tDo = r1;
        }

        public final void onAnimationEnd() {
            this.tDo.tCU.Dh(9);
            FTSSOSHomeWebViewUI.v(this.tDo);
        }

        public final void onAnimationStart() {
            FTSSOSHomeWebViewUI.w(this.tDo);
        }
    };
    private a$a tDh = new 4(this);
    private String tDi;
    int tDj;
    private OnClickListener tDk = new 5(this);
    private OnItemClickListener tDl = new 6(this);
    private OnClickListener tDm = new 7(this);
    private boolean tDn;
    private TextView titleView;

    private class c {
        String content;
        int icon;
        int position;
        int tDD;
        final /* synthetic */ FTSSOSHomeWebViewUI tDo;
        int type;

        private c(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
            this.tDo = fTSSOSHomeWebViewUI;
        }

        public final boolean equals(Object obj) {
            return this.content.equals(((c) obj).content);
        }
    }

    static /* synthetic */ void B(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        if (fTSSOSHomeWebViewUI.tCN.getVisibility() == 0) {
            fTSSOSHomeWebViewUI.bTM();
        } else if (fTSSOSHomeWebViewUI.tCN.getVisibility() != 0) {
            fTSSOSHomeWebViewUI.tCN.setVisibility(0);
            fTSSOSHomeWebViewUI.tCQ.setVisibility(0);
            fTSSOSHomeWebViewUI.tCN.getViewTreeObserver().addOnPreDrawListener(new 8(fTSSOSHomeWebViewUI));
        }
    }

    static /* synthetic */ void F(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        x.i("MicroMsg.FTS.FTSSOSHomeWebViewUI", "setInitStatus originInputX %f, x %f ", new Object[]{Float.valueOf(fTSSOSHomeWebViewUI.tCL), Float.valueOf(fTSSOSHomeWebViewUI.tCf.getX())});
        if (fTSSOSHomeWebViewUI.tCL != Float.MAX_VALUE) {
            fTSSOSHomeWebViewUI.tCf.setX(fTSSOSHomeWebViewUI.tCL);
        }
        fTSSOSHomeWebViewUI.tCT.setBackgroundColor(fTSSOSHomeWebViewUI.getResources().getColor(R.e.bug));
        fTSSOSHomeWebViewUI.titleView.setVisibility(0);
        fTSSOSHomeWebViewUI.tCR.setVisibility(0);
        fTSSOSHomeWebViewUI.qcQ.setVisibility(0);
        fTSSOSHomeWebViewUI.tCM.setVisibility(0);
        View view = fTSSOSHomeWebViewUI.tCG;
        int i = (fTSSOSHomeWebViewUI.tCl || fTSSOSHomeWebViewUI.tEd) ? 0 : 4;
        view.setVisibility(i);
        fTSSOSHomeWebViewUI.qvO.setVisibility(8);
        if (d.fM(23) && !h.zj()) {
            fTSSOSHomeWebViewUI.T(fTSSOSHomeWebViewUI.getResources().getColor(R.e.bug), true);
        }
        fTSSOSHomeWebViewUI.oNG.setVisibility(0);
        fTSSOSHomeWebViewUI.tCO.setVisibility(8);
        fTSSOSHomeWebViewUI.tCN.setVisibility(8);
        fTSSOSHomeWebViewUI.qgW.setVisibility(8);
        fTSSOSHomeWebViewUI.tCg.cxc();
        fTSSOSHomeWebViewUI.AQ(0);
        fTSSOSHomeWebViewUI.qcQ.setVisibility(0);
        fTSSOSHomeWebViewUI.tCM.setVisibility(0);
        fTSSOSHomeWebViewUI.tCA = 0;
        fTSSOSHomeWebViewUI.tDd = "";
        fTSSOSHomeWebViewUI.bTt();
        fTSSOSHomeWebViewUI.bTy().yig.clearFocus();
        fTSSOSHomeWebViewUI.tCH.clear();
        fTSSOSHomeWebViewUI.tCW = false;
        fTSSOSHomeWebViewUI.bTy().LW(fTSSOSHomeWebViewUI.getHint());
        fTSSOSHomeWebViewUI.tCg.Gy(0);
    }

    static /* synthetic */ void T(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        fTSSOSHomeWebViewUI.tCN.setVisibility(8);
        fTSSOSHomeWebViewUI.tCQ.setVisibility(8);
    }

    static /* synthetic */ void a(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI, c cVar, int i) {
        Map hashMap = new HashMap();
        hashMap.put("scene", Integer.valueOf(fTSSOSHomeWebViewUI.aRr()));
        hashMap.put("businessType", "0");
        hashMap.put("scene", Integer.valueOf(fTSSOSHomeWebViewUI.aRr()));
        hashMap.put("docid", cVar.content);
        hashMap.put("docpos", Integer.valueOf(cVar.position + 1));
        hashMap.put("typepos", Integer.valueOf(1));
        hashMap.put("suggestionid", fTSSOSHomeWebViewUI.tDi);
        hashMap.put("clicktype", Integer.valueOf(i));
        hashMap.put("clicksource", Integer.valueOf(1));
        hashMap.put("sceneactiontype", Integer.valueOf(1));
        hashMap.put("h5version", Integer.valueOf(g.zN(0)));
        hashMap.put("query", fTSSOSHomeWebViewUI.bTE());
        hashMap.put("sessionid", fTSSOSHomeWebViewUI.bPL());
        com.tencent.mm.bc.g.lU(b.s(hashMap));
    }

    static /* synthetic */ void g(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI, int i) {
        fTSSOSHomeWebViewUI.tCK.AU(i);
        fTSSOSHomeWebViewUI.tCJ.AU(i);
        fTSSOSHomeWebViewUI.tCI.AU(i);
        if (i == a.b.tEF) {
            fTSSOSHomeWebViewUI.qcQ.setVisibility(8);
        }
    }

    static /* synthetic */ void h(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        if (!fTSSOSHomeWebViewUI.tEd) {
            StringBuilder stringBuilder = new StringBuilder(fTSSOSHomeWebViewUI.fIG);
            x.v("MicroMsg.FTS.FTSSOSHomeWebViewUI", "beginLoadingUrl edu.bottom %d, title.bottom %d", new Object[]{Integer.valueOf(fTSSOSHomeWebViewUI.qcQ.getBottom()), Integer.valueOf(fTSSOSHomeWebViewUI.qlf.getBottom())});
            stringBuilder.append("&nativeHeight=").append(a.ad(fTSSOSHomeWebViewUI, fTSSOSHomeWebViewUI.qcQ.getBottom() - fTSSOSHomeWebViewUI.qlf.getBottom()));
            fTSSOSHomeWebViewUI.fIG = stringBuilder.toString();
            fTSSOSHomeWebViewUI.getIntent().putExtra("rawUrl", fTSSOSHomeWebViewUI.fIG);
            fTSSOSHomeWebViewUI.tyD = fTSSOSHomeWebViewUI.fIG;
            fTSSOSHomeWebViewUI.ptK.loadUrl(fTSSOSHomeWebViewUI.fIG);
        }
    }

    static /* synthetic */ void v(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        fTSSOSHomeWebViewUI.tCX--;
        fTSSOSHomeWebViewUI.tCG.setVisibility(0);
    }

    static /* synthetic */ void w(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        fTSSOSHomeWebViewUI.tCX++;
        fTSSOSHomeWebViewUI.tCG.setVisibility(4);
        fTSSOSHomeWebViewUI.tCg.Gy(8);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected final void akN() {
        String string;
        boolean z = true;
        super.akN();
        this.tCU = new b(this, "sos_home_webview_ui", getMainLooper());
        this.qlf = findViewById(R.h.cSm);
        this.tCT = findViewById(R.h.cSn);
        this.tCS = findViewById(R.h.cJn);
        this.tCQ = findViewById(R.h.cvN);
        this.tCO = findViewById(R.h.ccZ);
        this.tCP = (TextView) findViewById(R.h.ccY);
        this.tCO.setOnClickListener(this.tDm);
        this.tCR = findViewById(R.h.cSo);
        this.titleView = (TextView) findViewById(R.h.cSu);
        this.tCG = findViewById(R.h.cYR);
        ((WebViewKeyboardLinearLayout) this.tCG).xGO = new 1(this);
        this.qcQ = (FTSMainUIEducationLayout) findViewById(R.h.cJC);
        this.qcQ.q(this.qdi);
        this.qcQ.zei = false;
        this.qcQ.getViewTreeObserver().addOnGlobalLayoutListener(new 10(this));
        this.tCN = (FTSMainUIEducationLayoutWithAll) findViewById(R.h.cJD);
        this.tCN.q(this.qdi);
        this.tCN.zei = true;
        this.tCM = (FTSMainUIHotWordLayout) findViewById(R.h.cJG);
        this.tCM.q(this.tDe);
        this.tCI = new b(this, this.tCf, this.titleView, bTy().jCP, this.oNG, this.qgW, bTy().yig, this.tCS, this.qlf, this.tCT);
        this.tCI.a(this.tDf);
        this.tCJ = new c(this, this.tCf, this.titleView, bTy().jCP, this.oNG, this.qgW, bTy().yig, this.tCS, this.qlf, this.tCT);
        this.tCJ.a(this.tDh);
        this.tCK = new d(this, this.tCf, this.titleView, bTy().jCP, this.oNG, this.qgW, bTy().yig, this.tCS, this.qlf, this.tCT);
        this.tCK.a(this.tDg);
        this.tCH = new a(this, (byte) 0);
        this.qvO = findViewById(R.h.cOX);
        try {
            Bundle bundle = new Bundle();
            bundle.putString("key", "educationTab");
            Bundle o = this.juQ.o(2, bundle);
            String string2 = o.getString("result");
            string = o.getString("result_1");
            if (string != null) {
                string2 = string;
            }
            this.qcQ.ah(new JSONObject(string2));
        } catch (Exception e) {
        }
        try {
            bundle = new Bundle();
            bundle.putString("key", "tabSlice");
            this.tCN.ah(new JSONObject(this.juQ.o(2, bundle).getString("result")));
        } catch (Exception e2) {
        }
        findViewById(R.h.bYO).setOnTouchListener(new 11(this));
        this.tCQ.setOnClickListener(new 12(this));
        this.titleView.setText(getIntent().getStringExtra("title"));
        this.tCV = ((LayoutParams) this.titleView.getLayoutParams()).leftMargin - ((int) getResources().getDimension(R.f.byc));
        bTy().cxj();
        boolean z2 = getIntent() != null && getIntent().getBooleanExtra("ftsInitToSearch", false);
        this.tCZ = z2;
        if (getIntent() == null || !getIntent().getBooleanExtra("ftsHardcodeTitle", false)) {
            z = false;
        }
        this.tDa = z;
        if (this.tCZ) {
            this.tCT.setBackgroundColor(getResources().getColor(R.e.transparent));
            this.tCU.bTO();
        } else {
            this.tCU.bTN();
        }
        this.tCU.start();
        try {
            bundle = new Bundle();
            bundle.putString("key", "searchID");
            this.tCY = this.juQ.o(6, bundle).getString("result");
            string = this.tCY;
            String bPL = bPL();
            FTSMainUIEducationLayout fTSMainUIEducationLayout = this.qcQ;
            com.tencent.mm.bc.g.n(string, bPL, fTSMainUIEducationLayout.zeg == null ? "" : fTSMainUIEducationLayout.zeg);
        } catch (Exception e3) {
        }
        com.tencent.mm.bc.g.io(aRr());
        AbsoluteLayout absoluteLayout = (AbsoluteLayout) this.ptK.getView();
        absoluteLayout.setOnTouchListener(new 13(this, absoluteLayout));
        this.tCf.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
            final /* synthetic */ FTSSOSHomeWebViewUI tDo;

            {
                this.tDo = r1;
            }

            public final boolean onPreDraw() {
                this.tDo.tCf.getViewTreeObserver().removeOnPreDrawListener(this);
                this.tDo.tCL = this.tDo.tCf.getX();
                return true;
            }
        });
        if (this.tEd) {
            this.tCG.setVisibility(0);
        } else {
            this.tCG.setVisibility(4);
        }
        SOSEditTextView sOSEditTextView = this.tCg;
        OnClickListener 15 = new 15(this);
        if (sOSEditTextView.zew != null) {
            sOSEditTextView.zew.setOnClickListener(15);
        }
        AQ(this.tCA);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (intent != null) {
                    Object stringExtra = intent.getStringExtra("text");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        x.i("MicroMsg.FTS.FTSSOSHomeWebViewUI", "voice input final text len %d , text %s", new Object[]{Integer.valueOf(Pw(stringExtra).length()), r0});
                        this.tCg.t(r0, null);
                        akL();
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    private static String Pw(String str) {
        int i = 0;
        if (str != null) {
            try {
                if (com.tencent.mm.ui.tools.h.ZY(str) > 100) {
                    if (str.length() > 200) {
                        str = str.substring(0, 200);
                    }
                    char[] toCharArray = str.toCharArray();
                    int length = toCharArray.length;
                    int i2 = 0;
                    int i3 = 0;
                    while (i < length) {
                        i3 += com.tencent.mm.ui.tools.h.ZY(String.valueOf(toCharArray[i]));
                        if (i3 >= 100) {
                            str = str.substring(0, i2) + '…';
                            break;
                        }
                        i2++;
                        i++;
                    }
                }
            } catch (Exception e) {
            }
        }
        return str;
    }

    public final int bTJ() {
        return 1;
    }

    protected void onResume() {
        super.onResume();
        com.tencent.mm.bc.g.QY();
    }

    protected void onPause() {
        super.onPause();
        com.tencent.mm.bc.g.QZ();
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.bc.g.Ra();
        com.tencent.mm.bc.g.Rb();
    }

    protected final Map<String, Object> bTK() {
        Map<String, Object> hashMap = new HashMap();
        if (this.qcQ == null || this.qlf == null) {
            return hashMap;
        }
        int bottom;
        x.i("MicroMsg.FTS.FTSSOSHomeWebViewUI", "getOnUiInitParams edu.bottom %d, title.bottom %d", new Object[]{Integer.valueOf(this.qcQ.getBottom()), Integer.valueOf(this.qlf.getBottom())});
        if (this.qcQ.getTop() < this.qlf.getBottom()) {
            bottom = this.qcQ.getBottom() - this.qlf.getBottom();
        } else {
            bottom = this.qcQ.getBottom();
        }
        hashMap.put("nativeHeight", Integer.valueOf(a.ad(this, bottom)));
        try {
            Bundle o = this.juQ.o(7, null);
            CharSequence string = o == null ? "" : o.getString(SlookAirButtonFrequentContactAdapter.DATA);
            if (!TextUtils.isEmpty(string)) {
                hashMap.put("operationData", string);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FTS.FTSSOSHomeWebViewUI", e, "", new Object[0]);
        }
        return hashMap;
    }

    protected final int akH() {
        if (!d.fM(23) || h.zj()) {
            return super.akH();
        }
        return getResources().getColor(R.e.bug);
    }

    public final void hL(boolean z) {
        if (this.tCU.bTP()) {
            super.hL(z);
        }
        this.tCU.Dh(5);
    }

    protected final void bTt() {
        super.bTt();
        AQ(this.tCA);
        bTy().LW(AR(this.tCA));
    }

    private void bTL() {
        try {
            this.tCH.clear();
            x.i("MicroMsg.FTS.FTSSOSHomeWebViewUI", "start to update history");
            Bundle bundle = new Bundle();
            bundle.putInt("webview_id", hashCode());
            bundle.putString("query", bTE());
            bundle.putInt("count", 6);
            bundle.putInt("scene", aRr());
            this.juQ.h(3, bundle);
        } catch (RemoteException e) {
        }
    }

    public final void a(String str, String str2, List<com.tencent.mm.ui.fts.widget.a.b> list, FTSEditTextView.b bVar) {
        if (bVar == FTSEditTextView.b.zea) {
            this.tDj = 0;
        }
        if (this.tCU.bTP()) {
            super.a(str, str2, list, bVar);
        } else if (bTC().length() == 0) {
            this.qcQ.setVisibility(0);
            this.tCM.setVisibility(0);
            this.tCG.setVisibility(0);
            this.tCH.clear();
        } else {
            this.qcQ.setVisibility(8);
            this.tCM.setVisibility(8);
            this.tCG.setVisibility(4);
            if (bVar != FTSEditTextView.b.zec) {
                bTL();
            }
        }
    }

    public final boolean akL() {
        if (this.tCl) {
            this.tCU.Dh(0);
            super.akL();
        }
        return true;
    }

    private void AQ(int i) {
        this.tCN.Gw(i);
        this.tCP.setText(this.tCN.Gx(i));
        bTy().w(b.b(i, this.mController.xIM));
    }

    public final String bTw() {
        if (this.tDj == 0) {
            return "";
        }
        return this.tDi;
    }

    protected final void bTs() {
        super.bTs();
        this.tCU.Dh(11);
    }

    public final int bTx() {
        return this.tDj;
    }

    protected final void bTu() {
        if (this.tCX <= 0) {
            super.bTu();
            bTy().LW(getHint());
            this.tCU.Dh(2);
            this.tCf.setBackgroundResource(R.g.bGt);
            this.qvO.setVisibility(8);
            this.tDi = null;
            this.tDj = 0;
        }
    }

    protected final void bTv() {
        super.bTv();
        if (!this.tEd) {
            this.tCG.setVisibility(0);
            if (this.ptK.getTopView() != null && (this.ptK.getTopView() instanceof AbsoluteLayout)) {
                ((ViewGroup) this.qcQ.getParent()).removeView(this.qcQ);
                ((AbsoluteLayout) this.ptK.getTopView()).addView(this.qcQ, new AbsoluteLayout.LayoutParams(-1, -2, 0, this.tDc - this.qlf.getHeight()));
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dsO;
    }

    protected final String getHint() {
        return AR(bTD());
    }

    protected final void h(int i, Bundle bundle) {
        super.h(i, bundle);
        switch (i) {
            case 119:
                this.tCU.Dh(8);
                return;
            case 122:
                this.tCU.Dh(10);
                return;
            case 126:
                List arrayList = new ArrayList();
                if (bTy().yig.hasFocus()) {
                    String string = bundle.getString("query");
                    if (bTE().equals(string)) {
                        int i2 = 0;
                        for (String str : bundle.getStringArrayList("result")) {
                            if (b.aq(str, string)) {
                                i2++;
                                if (i2 <= 2) {
                                    c cVar = new c();
                                    cVar.type = 1;
                                    cVar.icon = R.k.dAP;
                                    cVar.content = str;
                                    cVar.tDD = R.g.bGs;
                                    arrayList.add(cVar);
                                }
                            }
                        }
                    }
                }
                ag.y(new 1(this.tCH, arrayList));
                return;
            case 127:
                List arrayList2 = new ArrayList();
                if (bTy().yig.hasFocus()) {
                    if (bTE().equals(bundle.getString("query"))) {
                        this.tDi = bundle.getString("suggestionId");
                        for (String str2 : bundle.getStringArrayList("result")) {
                            c cVar2 = new c();
                            cVar2.type = 2;
                            cVar2.icon = 0;
                            cVar2.content = str2;
                            cVar2.tDD = R.g.bGu;
                            arrayList2.add(cVar2);
                        }
                    }
                }
                ag.y(new 3(this.tCH, arrayList2));
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.map.h.CTRL_INDEX /*136*/:
                bundle.getString("fts_key_new_query", "");
                this.tCU.Dh(13);
                return;
            default:
                return;
        }
    }

    private String AR(int i) {
        int i2 = -1;
        switch (i) {
            case 1:
                i2 = R.l.eIQ;
                break;
            case 2:
                i2 = R.l.eIP;
                break;
            case 8:
                i2 = R.l.ekA;
                break;
            case 16:
                i2 = R.l.ekz;
                break;
            case 64:
                i2 = R.l.dDT;
                break;
            case FileUtils.S_IWUSR /*128*/:
                i2 = R.l.ekv;
                break;
            case 256:
            case 384:
                i2 = R.l.eku;
                break;
            case WXMediaMessage.TITLE_LENGTH_LIMIT /*512*/:
                i2 = R.l.ekx;
                break;
            case WXMediaMessage.DESCRIPTION_LENGTH_LIMIT /*1024*/:
                i2 = R.l.eky;
                break;
        }
        if (i2 < 0) {
            return getString(R.l.eIO, new Object[]{this.tDd});
        }
        return getString(R.l.eIO, new Object[]{getString(i2)});
    }

    private void bTM() {
        if (this.tCN.getVisibility() == 0 && !this.tDn) {
            this.tDn = true;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.tCN, View.TRANSLATION_Y, new float[]{0.0f, (float) (-this.tCN.getHeight())});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.tCQ, View.ALPHA, new float[]{1.0f, 0.0f});
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(300);
            animatorSet.setInterpolator(new AccelerateInterpolator());
            animatorSet.playTogether(new Animator[]{ofFloat2, ofFloat});
            animatorSet.addListener(new 9(this));
            animatorSet.start();
        }
    }

    public void onBackPressed() {
        if (this.tCN.getVisibility() == 0) {
            bTM();
        } else {
            super.onBackPressed();
        }
        bTy().cxd();
    }

    protected final boolean bTG() {
        return (!this.tCU.bTP() || this.tCI.isAnimating || this.tCJ.isAnimating || this.tCK.isAnimating) ? false : true;
    }

    protected final boolean bSj() {
        return true;
    }

    public final void onWebViewScrollChanged(int i, int i2, int i3, int i4) {
        super.onWebViewScrollChanged(i, i2, i3, i4);
        int min = Math.min(i2, Math.max(a.fromDPToPix(this, this.ptK.getContentHeight()) - this.ptK.getHeight(), 0));
        this.tCI.AT(this.tDb - min);
        this.tCJ.AT(this.tDb - min);
        this.tCK.AT(this.tDb - min);
        if (!this.tCU.bTP()) {
            this.tCf.setTranslationY((float) (-min));
        }
    }
}
