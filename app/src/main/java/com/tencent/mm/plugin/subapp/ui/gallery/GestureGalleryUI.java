package com.tencent.mm.plugin.subapp.ui.gallery;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.AdapterView.OnItemSelectedListener;
import com.tencent.mm.R;
import com.tencent.mm.g.a.aj;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.g.a.mr;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p$c;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery$f;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.w;
import com.tencent.mm.z.w.b;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@a(3)
public class GestureGalleryUI extends MMActivity implements b {
    private String hfH = null;
    private c msq = new c<mr>(this) {
        final /* synthetic */ GestureGalleryUI rXs;

        {
            this.rXs = r2;
            this.xen = mr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            mr mrVar = (mr) bVar;
            if (mrVar == null) {
                x.e("MicroMsg.GestureGalleryUI", "RecogQBarOfImageFileResultEvent is null.");
            } else if (mrVar == null || mrVar.fED.filePath.equals(this.rXs.rsC)) {
                x.i("MicroMsg.GestureGalleryUI", "recog result: %s", new Object[]{mrVar.fED.result});
                if (this.rXs.rXr.isEmpty() || this.rXs.rXr.contains(Integer.valueOf(mrVar.fED.fqb))) {
                    this.rXs.rXn = mrVar.fED.fqb;
                    this.rXs.rsF = mrVar.fED.result;
                    this.rXs.rXo = mrVar.fED.fqc;
                    this.rXs.rsC = null;
                    if (!bh.ov(this.rXs.rsF) && this.rXs.rXl.isShowing()) {
                        GestureGalleryUI.a(this.rXs);
                    }
                } else {
                    x.i("MicroMsg.GestureGalleryUI", "Result codeType(%s) error.", new Object[]{Integer.valueOf(mrVar.fED.fqb)});
                }
            } else {
                x.e("MicroMsg.GestureGalleryUI", "not same filepath");
            }
            return false;
        }
    };
    private MMGestureGallery nqT;
    private w nqY;
    private List<String> nqZ = new ArrayList();
    private int nra = -1;
    private OnItemSelectedListener nrb = new 9(this);
    private a rXi;
    private String rXj;
    private boolean rXk = false;
    private g rXl;
    private volatile boolean rXm;
    private int rXn;
    private int rXo;
    private int rXp;
    private final Set<Integer> rXq = new HashSet();
    private final Set<Integer> rXr = new HashSet();
    private volatile String rsC;
    private String rsF;
    private c rsI = new 2(this);
    private int type = 0;

    static /* synthetic */ void a(GestureGalleryUI gestureGalleryUI) {
        if (gestureGalleryUI.rXl == null) {
            gestureGalleryUI.rXl = new g(gestureGalleryUI.mController.xIM, g.ztp, false);
        }
        gestureGalleryUI.rXl.rKC = new p$c(gestureGalleryUI) {
            final /* synthetic */ GestureGalleryUI rXs;

            {
                this.rXs = r1;
            }

            public final void a(n nVar) {
                nVar.clear();
                nVar.eQ(1, R.l.eBK);
                nVar.eQ(2, R.l.eHe);
                nVar.eQ(3, R.l.eAd);
                if (GestureGalleryUI.c(this.rXs)) {
                    nVar.eQ(4, com.tencent.mm.plugin.scanner.a.az(this.rXs.rXn, this.rXs.rsF) ? R.l.eCr : R.l.eCq);
                }
                if (this.rXs.rXm && bh.ov(this.rXs.rsF) && ar.CG().Km() != 0) {
                    com.tencent.mm.sdk.b.b mpVar = new mp();
                    mpVar.fEA.filePath = this.rXs.rXj;
                    mpVar.fEA.fEB = new HashSet(this.rXs.rXq);
                    this.rXs.rsC = this.rXs.rXj;
                    com.tencent.mm.sdk.b.a.xef.m(mpVar);
                }
            }
        };
        gestureGalleryUI.rXl.rKD = new 6(gestureGalleryUI);
        gestureGalleryUI.rXl.ztB = new 7(gestureGalleryUI);
        if (!gestureGalleryUI.mController.xIM.isFinishing()) {
            gestureGalleryUI.rXl.bUk();
        }
    }

    static /* synthetic */ void a(GestureGalleryUI gestureGalleryUI, String str) {
        if (str != null && str.length() != 0 && e.b(gestureGalleryUI.mController, str, true, new 8(gestureGalleryUI, str)) == null) {
            x.e("MicroMsg.GestureGalleryUI", "doTimeline fail, cannot show dialog");
        }
    }

    static /* synthetic */ boolean c(GestureGalleryUI gestureGalleryUI) {
        return gestureGalleryUI.rXm && !bh.ov(gestureGalleryUI.rsF);
    }

    public final void c(String str, String str2, int i) {
        if (this.rXi != null) {
            if (i == this.nqT.getSelectedItemPosition()) {
                this.rXj = str2;
                x.d("MicroMsg.GestureGalleryUI", "onDownSucc, curFilename:%s, url:%s", new Object[]{this.rXj, str});
            }
            this.rXi.notifyDataSetChanged();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        fullScreenNoTitleBar(true);
        this.rXk = getIntent().getBooleanExtra("isFromWebView", false);
        this.rXm = getIntent().getBooleanExtra("shouldShowScanQrCodeMenu", false);
        this.rXp = getIntent().getIntExtra("scanQrCodeGetA8KeyScene", 0);
        int[] intArrayExtra = getIntent().getIntArrayExtra("scanCodeTypes");
        if (intArrayExtra != null && intArrayExtra.length > 0) {
            for (int valueOf : intArrayExtra) {
                this.rXq.add(Integer.valueOf(valueOf));
            }
        }
        intArrayExtra = getIntent().getIntArrayExtra("scanResultCodeTypes");
        if (intArrayExtra != null && intArrayExtra.length > 0) {
            for (int valueOf2 : intArrayExtra) {
                this.rXr.add(Integer.valueOf(valueOf2));
            }
        }
        this.hfH = getIntent().getStringExtra("cookie");
        x.d("MicroMsg.GestureGalleryUI", "isFromWebView: %b, cookie = %s", new Object[]{Boolean.valueOf(this.rXk), this.hfH});
        this.nqY = new w(this.rXk);
        w wVar = this.nqY;
        x.d("MicroMsg.GetPicService", "addListener :" + hashCode());
        wVar.hfB = this;
        com.tencent.mm.sdk.b.a.xef.b(this.msq);
        com.tencent.mm.sdk.b.a.xef.b(this.rsI);
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
        w wVar = this.nqY;
        x.d("MicroMsg.GetPicService", "removeListener :" + hashCode());
        wVar.hfB = null;
        this.nqY.GM();
        com.tencent.mm.sdk.b.a.xef.c(this.msq);
        com.tencent.mm.sdk.b.a.xef.c(this.rsI);
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    protected void onStop() {
        super.onStop();
        if (this.rsF != null) {
            com.tencent.mm.sdk.b.b ajVar = new aj();
            ajVar.fou.activity = this;
            ajVar.fou.fov = this.rsF;
            com.tencent.mm.sdk.b.a.xef.m(ajVar);
            this.rsF = null;
            this.rXo = 0;
            this.rXn = 0;
        }
    }

    protected final int getLayoutId() {
        return R.i.dqk;
    }

    protected final void initView() {
        int i;
        String ou = bh.ou(getIntent().getStringExtra("nowUrl"));
        this.type = getIntent().getIntExtra(DownloadSettingTable$Columns.TYPE, 0);
        String[] stringArrayExtra = getIntent().getStringArrayExtra("urlList");
        if (stringArrayExtra == null || stringArrayExtra.length == 0) {
            String ou2 = bh.ou(getIntent().getStringExtra("htmlData"));
            i = 0;
            while (i >= 0) {
                int indexOf = ou2.indexOf("weixin://viewimage/", i);
                if (indexOf < 0) {
                    break;
                }
                i = ou2.indexOf("\"", indexOf);
                if (i < 0) {
                    break;
                }
                String substring = ou2.substring(indexOf + 19, i);
                x.d("MicroMsg.GestureGalleryUI", "start:" + indexOf + " end:" + i + " url:" + substring);
                this.nqZ.add(substring);
            }
        } else {
            this.nqZ = Arrays.asList(stringArrayExtra);
        }
        for (i = 0; i < this.nqZ.size(); i++) {
            if (ou.equals(this.nqZ.get(i))) {
                this.nra = i;
                break;
            }
        }
        setBackBtn(new 1(this));
        this.rXi = new a(this);
        this.nqT = (MMGestureGallery) findViewById(R.h.ckt);
        this.nqT.setVisibility(0);
        this.nqT.setVerticalFadingEdgeEnabled(false);
        this.nqT.setHorizontalFadingEdgeEnabled(false);
        this.nqT.setAdapter(this.rXi);
        this.nqT.setSelection(this.nra);
        this.nqT.setOnItemSelectedListener(this.nrb);
        this.nqT.zlf = new MMGestureGallery$f(this) {
            final /* synthetic */ GestureGalleryUI rXs;

            {
                this.rXs = r1;
            }

            public final void avW() {
                this.rXs.finish();
            }
        };
        i = getIntent().getIntExtra("nevNext", 1);
        this.nqT.zlg = new 4(this, i);
    }
}
