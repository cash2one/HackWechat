package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.model.p;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.c.bje;
import com.tencent.mm.protocal.c.bju;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.v;

public class SnsMsgUI extends MMActivity implements e, b {
    private af handler = ae.aNT();
    private String hlJ;
    private View jMa;
    private d kBR = new 4(this);
    private View kUE = null;
    private boolean kUF = false;
    private ListView nKG;
    private View nKI;
    private int[] rDA = new int[2];
    private OnClickListener rDB = new 1(this);
    private a rDC = new 7(this);
    Runnable rDD = new 8(this);
    private a rDv;
    private boolean rDw = false;
    private boolean rDx = false;
    private boolean rDy = false;
    private r rDz;
    long raS;
    int roN;
    private ao rry;
    private SnsCmdList rti = new SnsCmdList();
    private ar rzI;

    static /* synthetic */ void a(SnsMsgUI snsMsgUI, int i) {
        ae.bvA().delete((long) i);
        snsMsgUI.rDv.a(null, null);
    }

    static /* synthetic */ void a(SnsMsgUI snsMsgUI, i iVar) {
        long j = iVar.field_snsID;
        if ((iVar.field_commentflag & 2) > 0) {
            h.h(snsMsgUI, j.qLH, j.dGO);
            return;
        }
        Intent intent = new Intent();
        if (iVar.field_type == 3 || iVar.field_type == 5) {
            intent.setClass(snsMsgUI, SnsStrangerCommentDetailUI.class);
            intent.putExtra("INTENT_TALKER", iVar.field_talker);
            try {
                intent.putExtra("INTENT_SOURCE", ((bje) new bje().aF(iVar.field_curActionBuf)).vHW);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SnsMsgUI", e, "", new Object[0]);
            }
        } else {
            intent.setClass(snsMsgUI, SnsCommentDetailUI.class);
        }
        if (iVar.field_type == 7 || iVar.field_type == 8) {
            intent.putExtra("INTENT_SNSID", u.ab("ad_table_", j));
            if (ae.bvv().Ll(u.ab("ad_table_", j)) == null) {
                x.i("MicroMsg.SnsMsgUI", "id " + j + " has delete");
                return;
            }
        }
        intent.putExtra("INTENT_SNSID", u.ab("sns_table_", j));
        if (iVar.field_type == 2) {
            intent.putExtra("INTENT_FROMSUI", true);
            intent.putExtra("INTENT_FROMSUI_COMMENTID", iVar.field_commentSvrID);
        } else if (iVar.field_type == 8) {
            intent.putExtra("INTENT_FROMSUI", true);
            intent.putExtra("INTENT_FROMSUI_COMMENTID", iVar.field_commentSvrID);
        }
        snsMsgUI.startActivityForResult(intent, 1);
    }

    static /* synthetic */ void a(SnsMsgUI snsMsgUI, boolean z) {
        Object com_tencent_mm_protocal_c_bju = new bju();
        com_tencent_mm_protocal_c_bju.wMV = z ? 1 : 0;
        k qVar = new q(snsMsgUI.raS, 12, com_tencent_mm_protocal_c_bju);
        g.Dk();
        if (g.Di().gPJ.a(qVar, 0)) {
            if (snsMsgUI.rDz != null) {
                snsMsgUI.rDz.dismiss();
            }
            snsMsgUI.getString(j.dGO);
            snsMsgUI.rDz = h.a(snsMsgUI, snsMsgUI.getString(j.qJI), true, new 5(snsMsgUI, qVar));
            snsMsgUI.rDz.show();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.Dk();
        g.Di().gPJ.a(com.tencent.mm.plugin.appbrand.jsapi.share.i.CTRL_INDEX, this);
        g.Dk();
        g.Di().gPJ.a(683, this);
        g.Dk();
        g.Di().gPJ.a(218, this);
        this.hlJ = com.tencent.mm.z.q.FS();
        this.rzI = ae.bvj();
        this.rDx = getIntent().getBooleanExtra("sns_msg_force_show_all", false);
        if (this.rDx) {
            this.kUF = true;
        }
        ae.bvA().c(this.rDC);
        initView();
    }

    public void onDestroy() {
        x.d("MicroMsg.SnsMsgUI", "msgui onDestroy");
        ae.bvA().auv();
        g.Dk();
        g.Di().gPJ.b(com.tencent.mm.plugin.appbrand.jsapi.share.i.CTRL_INDEX, this);
        g.Dk();
        g.Di().gPJ.b(683, this);
        g.Dk();
        g.Di().gPJ.b(218, this);
        ae.bvA().j(this.rDC);
        this.rDv.aUn();
        ae.bvs().K(this);
        if (this.rDz != null) {
            this.rDz.dismiss();
            this.rDz = null;
        }
        super.onDestroy();
    }

    public void onResume() {
        ae.bvq().a((b) this);
        super.onResume();
    }

    public void onPause() {
        ae.bvq().b((b) this);
        super.onPause();
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.sns.i.g.qHD;
    }

    protected final void initView() {
        setMMTitle(j.qLK);
        addTextOptionMenu(0, getString(j.dEo), new 9(this));
        this.rry = new ao(this);
        this.nKI = findViewById(f.qEP);
        this.nKG = (ListView) findViewById(f.qER);
        this.jMa = v.fv(this).inflate(com.tencent.mm.plugin.sns.i.g.qHB, null);
        this.kUE = v.fv(this).inflate(com.tencent.mm.plugin.sns.i.g.dns, null);
        x.d("MicroMsg.SnsMsgUI", "autoLoad " + this.kUF);
        if (this.kUF) {
            this.nKG.addFooterView(this.kUE);
        } else {
            this.nKG.addFooterView(this.jMa);
        }
        this.rDv = new a(this, this, new i());
        this.rDv.a(new 10(this));
        this.rDv.a(new 11(this));
        this.rDv.b(new 12(this));
        this.rDv.xIi = new 13(this);
        this.nKG.setAdapter(this.rDv);
        this.nKG.setOnItemClickListener(new 14(this));
        l lVar = new l(this);
        this.nKG.setOnTouchListener(new 15(this));
        this.nKG.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ SnsMsgUI rDE;

            {
                this.rDE = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < this.rDE.nKG.getHeaderViewsCount()) {
                    x.w("MicroMsg.SnsMsgUI", "on header view long click, ignore");
                    return true;
                }
                new com.tencent.mm.ui.widget.i(this.rDE).a(view, i, j, this.rDE, this.rDE.kBR, this.rDE.rDA[0], this.rDE.rDA[1]);
                return true;
            }
        });
        this.nKG.setOnScrollListener(new 2(this));
        if (this.rDv.getCount() == 0) {
            this.nKG.setVisibility(8);
            this.nKI.setVisibility(0);
            enableOptionMenu(false);
        } else {
            this.nKG.setVisibility(0);
            this.nKI.setVisibility(8);
            enableOptionMenu(true);
        }
        if ((this.rDv.awe() && ae.bvA().Tq() == 0) || ae.bvA().Tq() == ae.bvA().byc()) {
            this.jMa.setVisibility(8);
        }
        if (this.rDv.awe() && this.kUF) {
            this.nKG.removeFooterView(this.kUE);
        }
        setBackBtn(new 3(this));
        if (this.rDv.awe() && this.kUF) {
            this.nKG.removeFooterView(this.kUE);
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        i iVar = (i) this.rDv.getItem(adapterContextMenuInfo.position);
        if (iVar != null) {
            this.roN = iVar.roN;
            this.raS = iVar.field_snsID;
            try {
                bje com_tencent_mm_protocal_c_bje = (bje) new bje().aF(iVar.field_curActionBuf);
                if (com_tencent_mm_protocal_c_bje != null) {
                    String AQ;
                    com.tencent.mm.l.a WO = this.rzI.WO(com_tencent_mm_protocal_c_bje.wFM);
                    if (WO != null) {
                        AQ = WO.AQ();
                    } else if (bh.ov(com_tencent_mm_protocal_c_bje.wMt)) {
                        AQ = com_tencent_mm_protocal_c_bje.wFM;
                    } else {
                        AQ = com_tencent_mm_protocal_c_bje.wMt;
                    }
                    contextMenu.setHeaderTitle(bh.ou(AQ));
                    if (iVar.field_isSilence == 0) {
                        contextMenu.add(adapterContextMenuInfo.position, 1, 1, getString(j.qJE));
                    } else {
                        contextMenu.add(adapterContextMenuInfo.position, 2, 1, getString(j.qJD));
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SnsMsgUI", e, "", new Object[0]);
            }
            contextMenu.add(adapterContextMenuInfo.position, 0, 0, getString(j.dEw));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.SnsMsgUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            if (intent != null && intent.getBooleanExtra("result_finish", false)) {
                finish();
            } else if (intent != null) {
                this.rti.wt(intent.getIntExtra("sns_gallery_op_id", 0));
            }
        }
    }

    public final void JT(String str) {
        this.rDv.notifyDataSetChanged();
    }

    public final void aE(String str, boolean z) {
    }

    public final void bun() {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        x.d("MicroMsg.SnsMsgUI", "dispatchKeyEvent");
        Intent intent = new Intent();
        intent.putExtra("sns_cmd_list", this.rti);
        setResult(-1, intent);
        finish();
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0 && (kVar instanceof p)) {
            x.d("MicroMsg.SnsMsgUI", "onSceneEnd errtype errcode");
            if (!this.rDw) {
                this.rDw = true;
                this.handler.postDelayed(this.rDD, 500);
            } else {
                return;
            }
        }
        if (kVar.getType() == 218 && ((q) kVar).type == 12) {
            if (i == 0 && i2 == 0) {
                this.rDv.a(null, null);
                Toast.makeText(this, getString(j.qJH), 0).show();
            } else {
                Toast.makeText(this, getString(j.qJG), 0).show();
            }
            if (this.rDz != null) {
                this.rDz.dismiss();
                this.rDz = null;
            }
        }
    }

    public final void aF(String str, boolean z) {
    }
}
