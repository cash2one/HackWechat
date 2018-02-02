package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ag.y;
import com.tencent.mm.bf.l;
import com.tencent.mm.g.b.af;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.f;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.AbstractTabChildActivity.a;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.voicesearch.b;
import com.tencent.mm.ui.widget.i;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.LinkedList;
import java.util.List;

public class AddressUI$a extends a implements e {
    private final long hTf = 180000;
    private ProgressDialog iln = null;
    private int kGp;
    private int kGq;
    private i kGt;
    d kZW = new d(new OnScrollListener(this) {
        final /* synthetic */ AddressUI$a yQF;

        {
            this.yQF = r1;
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            x.i("MicroMsg.AddressUI", "[onScroll] firstVisibleItem:%s", new Object[]{Integer.valueOf(i)});
            if (i >= 2 && !this.yQF.yQp) {
                this.yQF.yQp = true;
            }
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            x.i("MicroMsg.AddressUI", "[onScrollStateChanged] scrollState:%s", new Object[]{Integer.valueOf(i)});
            if (i == 2) {
                com.tencent.mm.ca.d.clq().de(AddressUI.class.getName() + ".Listview", 4);
            }
        }
    });
    List<String> kiU = new LinkedList();
    private p.d lVO = new 4(this);
    private Animation mib;
    private ListView nPx;
    private boolean nXt = false;
    private TextView xNY;
    private String yPI;
    private String yPJ;
    private LinearLayout yQA;
    private Animation yQB;
    private VerticalScrollBar.a yQC = new 5(this);
    List<String> yQD = new LinkedList();
    private Runnable yQE = new 13(this);
    private TextView yQg;
    private TextView yQh;
    private a yQi;
    private b yQj;
    private String yQk;
    private String yQl = "";
    private int yQm;
    private AlphabetScrollBar yQn;
    private LinearLayout yQo = null;
    private boolean yQp = false;
    private boolean yQq = false;
    private k yQr;
    private BizContactEntranceView yQs;
    private b yQt;
    private b yQu;
    private b yQv;
    private ContactCountView yQw;
    private i yQx;
    boolean yQy;
    private boolean yQz = true;

    static /* synthetic */ void a(AddressUI$a addressUI$a, String str) {
        ar.Hg();
        c.EY().b(addressUI$a.yQi);
        ar.Hg();
        com.tencent.mm.storage.x WO = c.EY().WO(str);
        WO.Ah();
        s.t(WO);
        if (s.eV(str)) {
            ar.Hg();
            c.EY().WU(str);
            ar.Hg();
            c.Fh().hJ(str);
        } else {
            ar.Hg();
            c.EY().a(str, WO);
        }
        addressUI$a.yQi.dq(str, 5);
        ar.Hg();
        c.EY().a(addressUI$a.yQi);
    }

    static /* synthetic */ void b(AddressUI$a addressUI$a) {
        addressUI$a.yQg.setVisibility(8);
        addressUI$a.nPx.setVisibility(0);
    }

    static /* synthetic */ void c(AddressUI$a addressUI$a, String str) {
        ar.Hg();
        af WO = c.EY().WO(str);
        if (com.tencent.mm.l.a.fZ(WO.field_type)) {
            Intent intent = new Intent();
            intent.setClass(addressUI$a.getContext(), ContactRemarkInfoModUI.class);
            intent.putExtra("Contact_User", WO.field_username);
            intent.putExtra("view_mode", true);
            addressUI$a.getContext().startActivity(intent);
        }
    }

    static /* synthetic */ void o(AddressUI$a addressUI$a) {
        LauncherUI launcherUI = (LauncherUI) addressUI$a.getContext();
        if (launcherUI == null || launcherUI.xGS.xGh.mnk == 1) {
            BackwardSupportUtil.c.a(addressUI$a.nPx);
            new com.tencent.mm.sdk.platformtools.af().postDelayed(new 3(addressUI$a), 300);
        }
    }

    protected int getLayoutId() {
        return R.i.daa;
    }

    protected View getLayoutView() {
        return com.tencent.mm.kiss.a.b.DY().a(getContext(), "R.layout.address", R.i.daa);
    }

    public boolean supportNavigationSwipeBack() {
        return false;
    }

    public boolean noActionBar() {
        return true;
    }

    public final void mY(boolean z) {
        if (this.yQn != null) {
            if (this.mib == null) {
                this.mib = AnimationUtils.loadAnimation(getContext(), R.a.bpX);
                this.mib.setDuration(200);
            }
            if (this.yQB == null) {
                this.yQB = AnimationUtils.loadAnimation(getContext(), R.a.bpX);
                this.yQB.setDuration(200);
            }
            if (z) {
                if (this.yQn.getVisibility() != 0) {
                    this.yQn.setVisibility(0);
                    this.yQn.startAnimation(this.mib);
                }
            } else if (4 != this.yQn.getVisibility()) {
                this.yQn.setVisibility(8);
                this.yQn.startAnimation(this.yQB);
            }
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        ar.Hg();
        af WO = c.EY().WO(this.yQl);
        if (WO == null) {
            x.e("MicroMsg.AddressUI", "onCreateContextMenu, contact is null, username = " + this.yQl);
        } else if (!q.FS().equals(WO.field_username)) {
            if (s.gC(this.yQl)) {
                contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.i.a(view.getContext(), WO.AQ()));
                contextMenu.add(adapterContextMenuInfo.position, 2, 0, R.l.dCR);
            } else if (!s.gR(this.yQl) && !s.hg(this.yQl)) {
                contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.i.a(view.getContext(), WO.AQ()));
                if (com.tencent.mm.l.a.fZ(WO.field_type) && WO.field_deleteFlag != 1) {
                    contextMenu.add(adapterContextMenuInfo.position, 7, 0, R.l.dVE);
                }
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.iln != null) {
            this.iln.dismiss();
            this.iln = null;
        }
        if (!t.bF(getContext()) || com.tencent.mm.ui.t.a.a(getContext(), i, i2, str, 4) || i != 0 || i2 == 0) {
        }
    }

    private void cvI() {
        this.kiU = new LinkedList();
        this.yQD = new LinkedList();
        com.tencent.mm.bm.d.ccW();
        this.kiU.add("tmessage");
        this.yQD.addAll(this.kiU);
        if (!this.kiU.contains("officialaccounts")) {
            this.kiU.add("officialaccounts");
        }
        this.kiU.add("helper_entry");
        if (this.yQi != null) {
            this.yQi.dr(this.kiU);
        }
        if (this.yQj != null) {
            this.yQj.dr(this.yQD);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.AddressUI", "onAcvityResult requestCode: %d", new Object[]{Integer.valueOf(i)});
        if (i == 6 && i2 == -1) {
            setResult(-1);
            finish();
        } else if (i2 == -1) {
            switch (i) {
                case 4:
                    setResult(-1, intent);
                    finish();
                    return;
                default:
                    return;
            }
        }
    }

    protected final void clt() {
        x.v("MicroMsg.AddressUI", "address ui on create");
        x.v("MicroMsg.AddressUI", "on address ui create");
        this.yQp = false;
        this.nXt = false;
        this.yQq = false;
        this.yPI = null;
        this.yPJ = null;
        this.yQk = null;
        ar.CG().a(138, this);
        this.yPI = "@all.contact.without.chatroom";
        this.yPJ = getStringExtra("Contact_GroupFilter_Str");
        this.yQk = getString(R.l.enI);
        this.yQm = getIntExtra("List_Type", 2);
        x.v("MicroMsg.AddressUI", "on address ui init view, %s", new Object[]{getResources().getDisplayMetrics()});
        if (this.nPx != null) {
            if (this.yQr != null) {
                this.nPx.removeHeaderView(this.yQr);
            }
            if (this.yQs != null) {
                this.nPx.removeHeaderView(this.yQs);
            }
            if (this.yQt != null) {
                this.nPx.removeHeaderView(this.yQt);
            }
            if (this.yQv != null) {
                this.nPx.removeHeaderView(this.yQv);
            }
        }
        this.nPx = (ListView) findViewById(R.h.bJe);
        this.nPx.setScrollingCacheEnabled(false);
        this.yQg = (TextView) findViewById(R.h.cee);
        this.yQg.setText(R.l.dCS);
        this.xNY = (TextView) findViewById(R.h.cex);
        this.xNY.setText(R.l.dCU);
        this.yQh = (TextView) findViewById(R.h.ceA);
        this.yQh.setOnClickListener(new 1(this));
        this.yQi = new a(getContext(), this.yPI, this.yPJ, this.yQm);
        this.nPx.setAdapter(null);
        this.yQi.a(new 12(this));
        this.yQi.yPV = true;
        this.yQi.l(this);
        this.yQi.a(new 15(this));
        this.yQi.a(new 16(this));
        this.yQi.a(new 17(this));
        this.yQj = new b(getContext(), 1);
        this.yQj.nz(true);
        this.yQA = new LinearLayout(getContext());
        this.yQA.setOrientation(1);
        this.nPx.addHeaderView(this.yQA);
        this.yQu = new b(getContext(), b.a.yQL);
        this.yQA.addView(this.yQu);
        ar.Hg();
        ((Boolean) c.CU().get(w.a.xpr, Boolean.valueOf(false))).booleanValue();
        this.yQu.setVisible(false);
        this.yQr = new k(getContext());
        this.yQA.addView(this.yQr);
        this.yQt = new b(getContext(), b.a.yQJ);
        this.yQA.addView(this.yQt);
        this.yQt.setVisible(true);
        this.yQv = new b(getContext(), b.a.yQK);
        this.yQA.addView(this.yQv);
        this.yQv.setVisible(true);
        ListView listView = this.nPx;
        View contactCountView = new ContactCountView(getContext());
        this.yQw = contactCountView;
        listView.addFooterView(contactCountView, null, false);
        if (com.tencent.mm.bm.d.OQ("brandservice")) {
            this.yQs = new BizContactEntranceView(getContext());
            this.yQA.addView(this.yQs);
            this.yQs.setVisible(true);
            this.yQx = new i(getContext(), new 18(this));
            if (this.yQx.cvT() <= 0) {
                this.yQx.setVisibility(8);
            }
            this.yQA.addView(this.yQx);
        }
        this.kGt = new i(getContext());
        this.yQi.yPT = new a.a(this) {
            final /* synthetic */ AddressUI$a yQF;

            {
                this.yQF = r1;
            }
        };
        this.nPx.setOnItemClickListener(new 20(this));
        this.nPx.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ AddressUI$a yQF;

            {
                this.yQF = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                x.i("MicroMsg.AddressUI", "onItemLongClick, targetview is SearchBar::ListView, pos = " + i);
                if (i < this.yQF.nPx.getHeaderViewsCount()) {
                    x.w("MicroMsg.AddressUI", "on item long click, but match header view");
                    return true;
                } else if (this.yQF.yQj != null && this.yQF.yQj.zqC) {
                    return true;
                } else {
                    f fVar = (f) this.yQF.yQi.DC(i - this.yQF.nPx.getHeaderViewsCount());
                    if (fVar == null) {
                        x.e("MicroMsg.AddressUI", "cont is null. position:%d, header count:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.yQF.nPx.getHeaderViewsCount())});
                        return true;
                    }
                    String str = fVar.field_username;
                    if (s.hd(str) || s.he(str)) {
                        return true;
                    }
                    this.yQF.yQl = str;
                    this.yQF.kGt.a(view, i, j, this.yQF, this.yQF.lVO, this.yQF.kGp, this.yQF.kGq);
                    return true;
                }
            }
        });
        this.nPx.setOnTouchListener(new 2(this));
        this.nPx.setOnScrollListener(this.kZW);
        this.nPx.setDrawingCacheEnabled(false);
        this.yQn = (AlphabetScrollBar) findViewById(R.h.bJn);
        this.yQn.yhE = this.yQC;
        ar.Hg();
        c.EY().a(this.yQi);
        if (this.yQx != null) {
            y.Mf().a(this.yQx, null);
        }
    }

    protected final void clu() {
        x.v("MicroMsg.AddressUI", "address ui on resume");
        long currentTimeMillis = System.currentTimeMillis();
        ar.Hg();
        if (currentTimeMillis - t.d((Long) c.CU().get(340226, null)) >= 180000) {
            cvK();
        }
        if (this.yQz) {
            this.yQz = false;
            this.yQy = false;
            cvI();
            this.nPx.setAdapter(this.yQi);
            this.nPx.post(new 9(this));
            this.yQj.ny(false);
        } else if (this.yQy) {
            this.yQy = false;
            com.tencent.mm.sdk.f.e.b(new 10(this), "AddressUI_updateUIData", 4);
            this.yQw.cvM();
        }
        if (this.yQs != null) {
            BizContactEntranceView bizContactEntranceView = this.yQs;
            bizContactEntranceView.cvL();
            bizContactEntranceView.setVisible(true);
        }
        if (this.yQx != null) {
            if (this.yQx.cvT() <= 0) {
                this.yQx.setVisibility(8);
            } else {
                this.yQx.setVisibility(0);
            }
        }
        ar.Hg();
        this.yQp = ((Boolean) c.CU().get(12296, Boolean.valueOf(false))).booleanValue();
        if (this.yQm == 2) {
            ar.Hg();
            af WO = c.EY().WO(q.FS());
            if (!(WO == null || (com.tencent.mm.l.a.fZ(WO.field_type) && t.ov(WO.field_conRemark) && t.ov(WO.field_conRemarkPYFull) && t.ov(WO.field_conRemarkPYShort)))) {
                WO.Ag();
                WO.da("");
                WO.dg("");
                WO.dh("");
                ar.Hg();
                c.EY().a(q.FS(), WO);
            }
        }
        if (this.yQj != null) {
            this.yQj.onResume();
        }
        this.yQi.xEx = false;
        ag.y(new 11(this));
        if (this.yQr != null) {
            this.yQr.ySA = true;
            k.cvV();
        }
        LauncherUI launcherUI = (LauncherUI) getContext();
        if (launcherUI != null) {
            launcherUI.xGS.aa(this.yQE);
        }
    }

    private synchronized void cvJ() {
        long currentTimeMillis = System.currentTimeMillis();
        cvI();
        x.i("MicroMsg.AddressUI", "KEVIN updateBlockList() LAST" + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        if (this.yQi != null) {
            x.v("MicroMsg.AddressUI", "post to do refresh");
            ag.y(new 7(this));
        }
        if (this.yQj != null) {
            ag.y(new 8(this));
        }
        x.i("MicroMsg.AddressUI", "KEVIN doRefresh() LAST" + (System.currentTimeMillis() - currentTimeMillis));
    }

    protected final void clv() {
    }

    protected final void clw() {
        x.i("MicroMsg.AddressUI", "AddressUI on Pause");
        ar.Hg();
        c.CU().set(340226, Long.valueOf(System.currentTimeMillis()));
        ar.Hg();
        c.CU().set(12296, Boolean.valueOf(this.yQp));
        if (this.yQj != null) {
            this.yQj.onPause();
        }
        this.yQi.cvG();
        ag.y(new 14(this));
        if (this.yQr != null) {
            this.yQr.ySA = false;
        }
        LauncherUI launcherUI = (LauncherUI) getContext();
        if (launcherUI != null) {
            launcherUI.xGS.ab(this.yQE);
        }
    }

    protected final void clx() {
    }

    protected final void cly() {
        x.v("MicroMsg.AddressUI", "onDestory");
        if (this.yQn != null) {
            this.yQn.yhE = null;
        }
        ar.CG().b(138, this);
        if (this.yQi != null) {
            this.yQi.lP(true);
            a aVar = this.yQi;
            if (aVar.hvU != null) {
                aVar.hvU.detach();
                aVar.hvU = null;
            }
            this.yQi.clU();
        }
        if (this.yQj != null) {
            this.yQj.detach();
            this.yQj.aUn();
        }
        if (ar.Hj() && this.yQi != null) {
            ar.Hg();
            c.EY().b(this.yQi);
        }
        if (ar.Hj() && this.yQx != null) {
            y.Mf().a(this.yQx);
        }
        if (this.yQr != null) {
            k kVar = this.yQr;
            if (ar.Hj()) {
                l.Tx().j(kVar.ySz);
            }
            this.yQr = null;
        }
        if (this.yQs != null) {
            this.yQs = null;
        }
        if (this.yQt != null) {
            this.yQt = null;
        }
        if (this.yQv != null) {
            this.yQv = null;
        }
    }

    public final void clA() {
        if (this.yQi != null) {
            a aVar = this.yQi;
            aVar.yPZ.clear();
            aVar.yPX.clear();
            aVar.yPY = false;
        }
        x.i("MicroMsg.INIT", "KEVIN Address turnTobg");
        if (this.yQs != null) {
            this.yQs.destroyDrawingCache();
        }
        if (this.yQt != null) {
            this.yQt.destroyDrawingCache();
        }
        if (this.yQv != null) {
            this.yQv.destroyDrawingCache();
        }
        if (this.yQw != null) {
            this.yQw.destroyDrawingCache();
        }
        if (this.yQr != null) {
            this.yQr.destroyDrawingCache();
        }
    }

    public final void clB() {
        x.v("MicroMsg.INIT", "KEVIN Address turnTofg");
    }

    public final void clz() {
        x.v("MicroMsg.AddressUI", "request to top");
        if (this.nPx != null) {
            BackwardSupportUtil.c.a(this.nPx);
        }
    }

    public final void cmr() {
        if (this.yQr != null) {
            k.cvV();
        }
    }

    public final void cms() {
    }

    public final void cvK() {
        if (this.nPx != null) {
            this.nPx.setSelection(0);
        }
    }
}
