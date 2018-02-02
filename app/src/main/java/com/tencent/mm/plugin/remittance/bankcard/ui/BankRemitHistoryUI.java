package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.remittance.bankcard.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.ake;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.wallet_core.c.g$a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankRemitHistoryUI extends BankRemitBaseUI implements d {
    private int asN = 20;
    private boolean iic = false;
    private boolean iid = false;
    private l juS;
    private View lGk;
    private int offset = 0;
    private ListView pIR;
    private a pIS;
    private List<ake> pIT = new ArrayList();

    private class a extends BaseAdapter {
        final /* synthetic */ BankRemitHistoryUI pIU;
        private SimpleDateFormat pIX;

        private a(BankRemitHistoryUI bankRemitHistoryUI) {
            this.pIU = bankRemitHistoryUI;
            this.pIX = new SimpleDateFormat(this.pIU.mController.xIM.getString(i.uHK));
        }

        public final int getCount() {
            return this.pIU.pIT.size();
        }

        public final Object getItem(int i) {
            return this.pIU.pIT.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            boolean z;
            if (view == null) {
                view = LayoutInflater.from(this.pIU.mController.xIM).inflate(g.uBb, viewGroup, false);
                view.setTag(new b(this.pIU, view));
            }
            b bVar = (b) view.getTag();
            ake com_tencent_mm_protocal_c_ake = (ake) getItem(i);
            Object bp = bp(com_tencent_mm_protocal_c_ake.wrq);
            if (i == 0) {
                z = true;
            } else if (bp.equals(bp(((ake) getItem(i - 1)).wrq))) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                bVar.pIY.setText(bp);
                bVar.pIY.setVisibility(0);
            } else {
                bVar.pIY.setVisibility(8);
            }
            bVar.pJb.setUrl(com_tencent_mm_protocal_c_ake.pHq);
            bVar.iXX.setText(com_tencent_mm_protocal_c_ake.title);
            bVar.pIZ.setText(com_tencent_mm_protocal_c_ake.wrr);
            bVar.ihT.setText(com_tencent_mm_protocal_c_ake.wrp);
            if (bh.ov(com_tencent_mm_protocal_c_ake.wrs)) {
                bVar.pJa.setVisibility(8);
            } else {
                if (!bh.ov(com_tencent_mm_protocal_c_ake.wrt)) {
                    bVar.pJa.setTextColor(Color.parseColor(com_tencent_mm_protocal_c_ake.wrt));
                }
                bVar.pJa.setText(com_tencent_mm_protocal_c_ake.wrs);
                bVar.pJa.setVisibility(0);
            }
            return view;
        }

        private String bp(long j) {
            return this.pIX.format(new Date(1000 * j));
        }
    }

    private class b {
        TextView iXX;
        TextView ihT;
        final /* synthetic */ BankRemitHistoryUI pIU;
        TextView pIY;
        TextView pIZ;
        TextView pJa;
        CdnImageView pJb;

        public b(BankRemitHistoryUI bankRemitHistoryUI, View view) {
            this.pIU = bankRemitHistoryUI;
            this.pIY = (TextView) view.findViewById(f.ugt);
            this.iXX = (TextView) view.findViewById(f.ugs);
            this.pIZ = (TextView) view.findViewById(f.ugu);
            this.ihT = (TextView) view.findViewById(f.ugr);
            this.pJa = (TextView) view.findViewById(f.ugv);
            this.pJb = (CdnImageView) view.findViewById(f.ugq);
        }
    }

    static /* synthetic */ void a(BankRemitHistoryUI bankRemitHistoryUI, String str) {
        for (int size = bankRemitHistoryUI.pIT.size() - 1; size >= 0; size--) {
            if (((ake) bankRemitHistoryUI.pIT.get(size)).vPj.equals(str)) {
                bankRemitHistoryUI.pIT.remove(size);
                bankRemitHistoryUI.pIS.notifyDataSetChanged();
                return;
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ji(1511);
        ji(1737);
        setMMTitle(i.uHL);
        initView();
        bnw();
    }

    protected final void initView() {
        this.pIR = (ListView) findViewById(f.ugw);
        this.lGk = LayoutInflater.from(this).inflate(g.uAU, null);
        this.juS = new l(this);
        this.pIS = new a();
        this.pIR.addFooterView(this.lGk);
        this.pIR.setAdapter(this.pIS);
        this.pIR.setOnItemLongClickListener(new 1(this));
        this.pIR.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ BankRemitHistoryUI pIU;

            {
                this.pIU = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (this.pIU.pIR.getLastVisiblePosition() == this.pIU.pIR.getCount() - 1 && this.pIU.pIR.getCount() > 0 && !this.pIU.iid && !this.pIU.iic) {
                    this.pIU.bnw();
                }
            }
        });
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 1, 0, i.uHT);
    }

    public void onMMMenuItemSelected(MenuItem menuItem, int i) {
        ake com_tencent_mm_protocal_c_ake = (ake) this.pIR.getItemAtPosition(((AdapterContextMenuInfo) menuItem.getMenuInfo()).position);
        if (menuItem.getItemId() == 1 && com_tencent_mm_protocal_c_ake != null) {
            x.i("MicroMsg.BankRemitHistoryUI", "delete record: %s", new Object[]{com_tencent_mm_protocal_c_ake.vPj});
            k eVar = new e(r0);
            eVar.k(this);
            l(eVar);
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.remittance.bankcard.a.i) {
            final com.tencent.mm.plugin.remittance.bankcard.a.i iVar = (com.tencent.mm.plugin.remittance.bankcard.a.i) kVar;
            iVar.a(new 5(this, iVar)).b(new g$a(this) {
                final /* synthetic */ BankRemitHistoryUI pIU;

                public final void f(int i, int i2, String str, k kVar) {
                    x.e("MicroMsg.BankRemitHistoryUI", "history response error: %s, %s", new Object[]{Integer.valueOf(iVar.pHk.liH), iVar.pHk.liI});
                }
            }).c(new 3(this));
            this.iic = false;
        } else if (kVar instanceof e) {
            final e eVar = (e) kVar;
            eVar.a(new 8(this, eVar)).b(new g$a(this) {
                final /* synthetic */ BankRemitHistoryUI pIU;

                public final void f(int i, int i2, String str, k kVar) {
                    x.e("MicroMsg.BankRemitHistoryUI", "history response: %s, %s", new Object[]{Integer.valueOf(eVar.pHg.liH), eVar.pHg.liI});
                }
            }).c(new 6(this));
        }
        return false;
    }

    protected final int getLayoutId() {
        return g.uBc;
    }

    public void onDestroy() {
        super.onDestroy();
        jj(1511);
        jj(1737);
    }

    private void bnw() {
        x.i("MicroMsg.BankRemitHistoryUI", "fetch data: %s, %s", new Object[]{Integer.valueOf(this.asN), Integer.valueOf(this.offset)});
        this.iic = true;
        k iVar = new com.tencent.mm.plugin.remittance.bankcard.a.i(this.asN, this.offset);
        iVar.k(this);
        b(iVar, false);
    }
}
