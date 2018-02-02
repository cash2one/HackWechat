package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.remittance.bankcard.a.j;
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.plugin.wallet_core.ui.view.a;
import com.tencent.mm.plugin.wxpay.a$c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.tools.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BankRemitSelectPayeeUI extends BankRemitBaseUI implements d {
    private l juS;
    private ListView pJJ;
    private b pJK;
    private List<TransferRecordParcel> pJL;
    private ArrayList<TransferRecordParcel> pJM;
    private ArrayList<String> pJN;
    private int pJO = -1;
    private int pJP = -1;
    private Intent pJQ;

    private class b extends BaseAdapter {
        final /* synthetic */ BankRemitSelectPayeeUI pJR;

        private b(BankRemitSelectPayeeUI bankRemitSelectPayeeUI) {
            this.pJR = bankRemitSelectPayeeUI;
        }

        public final int getCount() {
            int size = this.pJR.pJL.size();
            if (bny()) {
                size++;
            }
            if (bnz()) {
                return size + 1;
            }
            return size;
        }

        public final Object getItem(int i) {
            if (i == this.pJR.pJO || i == this.pJR.pJP) {
                return null;
            }
            if (i < this.pJR.pJP) {
                return this.pJR.pJL.get(i - 1);
            }
            if (!bnz() || i <= this.pJR.pJP) {
                if (bny()) {
                    return this.pJR.pJL.get(i - 1);
                }
                x.i("MicroMsg.BankRemitSelectPayeeUI", "maybe wrong pos: [%s,%s,%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(this.pJR.pJO), Integer.valueOf(this.pJR.pJP)});
                return null;
            } else if (bny()) {
                return this.pJR.pJL.get(i - 2);
            } else {
                return this.pJR.pJL.get(i - 1);
            }
        }

        public final boolean isEnabled(int i) {
            if (i == this.pJR.pJO || i == this.pJR.pJP) {
                return false;
            }
            return true;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getItemViewType(int i) {
            if (i == this.pJR.pJO || i == this.pJR.pJP) {
                return 0;
            }
            return 1;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i);
            if (view == null) {
                if (itemViewType == 0) {
                    view = LayoutInflater.from(this.pJR.mController.xIM).inflate(g.uBi, viewGroup, false);
                } else {
                    view = LayoutInflater.from(this.pJR.mController.xIM).inflate(g.uBj, viewGroup, false);
                    a aVar = new a(this.pJR, (byte) 0);
                    aVar.pJW = (CdnImageView) view.findViewById(f.ugO);
                    aVar.pHI = (TextView) view.findViewById(f.ugQ);
                    aVar.pJX = (TextView) view.findViewById(f.ugP);
                    view.setTag(aVar);
                }
            }
            switch (itemViewType) {
                case 0:
                    boolean z;
                    TextView textView = (TextView) view.findViewById(f.ugN);
                    if (this.pJR.pJO == i) {
                        itemViewType = 1;
                    } else {
                        z = false;
                    }
                    if (itemViewType == 0) {
                        if (this.pJR.pJP == i) {
                            itemViewType = 1;
                        } else {
                            z = false;
                        }
                        if (itemViewType == 0) {
                            textView.setText("");
                            x.w("MicroMsg.BankRemitSelectPayeeUI", "wrong header pos: %s", new Object[]{Integer.valueOf(i)});
                            break;
                        }
                        textView.setText(i.uHV);
                        break;
                    }
                    textView.setText(i.uHX);
                    break;
                case 1:
                    a aVar2 = (a) view.getTag();
                    TransferRecordParcel transferRecordParcel = (TransferRecordParcel) getItem(i);
                    if (transferRecordParcel == null) {
                        aVar2.pJW.setImageResource(a$c.transparent);
                        aVar2.pHI.setText("");
                        aVar2.pJX.setText("");
                        x.w("MicroMsg.BankRemitSelectPayeeUI", "empty record");
                        break;
                    }
                    aVar2.pJW.i(transferRecordParcel.pHq, 0, 0, a$c.transparent);
                    if (bh.ov(transferRecordParcel.pHN)) {
                        aVar2.pHI.setText(transferRecordParcel.pHM);
                    } else {
                        aVar2.pHI.setText(com.tencent.mm.pluginsdk.ui.d.i.a(aVar2.pJR.mController.xIM, aVar2.pJR.mController.xIM.getString(i.uHU, new Object[]{transferRecordParcel.pHM, transferRecordParcel.pHN})));
                    }
                    aVar2.pJX.setText(aVar2.pJR.getString(i.uHU, new Object[]{transferRecordParcel.nBM, transferRecordParcel.pHL}));
                    break;
                default:
                    x.w("MicroMsg.BankRemitSelectPayeeUI", "unknown type: %d", new Object[]{Integer.valueOf(itemViewType)});
                    break;
            }
            return view;
        }

        private boolean bny() {
            return this.pJR.pJO >= 0;
        }

        private boolean bnz() {
            return this.pJR.pJP >= 0;
        }
    }

    static /* synthetic */ void a(BankRemitSelectPayeeUI bankRemitSelectPayeeUI, String str) {
        x.i("MicroMsg.BankRemitSelectPayeeUI", "do remove record");
        for (int size = bankRemitSelectPayeeUI.pJL.size() - 1; size >= 0; size--) {
            if (((TransferRecordParcel) bankRemitSelectPayeeUI.pJL.get(size)).pHK.equals(str)) {
                bankRemitSelectPayeeUI.pJL.remove(size);
                break;
            }
        }
        bankRemitSelectPayeeUI.pJK.notifyDataSetChanged();
        if (bankRemitSelectPayeeUI.pJN == null) {
            bankRemitSelectPayeeUI.pJN = new ArrayList();
        }
        bankRemitSelectPayeeUI.pJN.add(str);
        bankRemitSelectPayeeUI.pJQ.putStringArrayListExtra("key_delete_seq_no_list", bankRemitSelectPayeeUI.pJN);
        bankRemitSelectPayeeUI.setResult(0, bankRemitSelectPayeeUI.pJQ);
    }

    static /* synthetic */ void a(BankRemitSelectPayeeUI bankRemitSelectPayeeUI, String str, String str2) {
        x.i("MicroMsg.BankRemitSelectPayeeUI", "do modify remark: %s", new Object[]{str2});
        bankRemitSelectPayeeUI.b(new j(str, str2), true);
    }

    static /* synthetic */ void b(BankRemitSelectPayeeUI bankRemitSelectPayeeUI, String str, String str2) {
        x.i("MicroMsg.BankRemitSelectPayeeUI", "do modify record");
        if (bankRemitSelectPayeeUI.pJM == null) {
            bankRemitSelectPayeeUI.pJM = new ArrayList();
        }
        for (int size = bankRemitSelectPayeeUI.pJL.size() - 1; size >= 0; size--) {
            TransferRecordParcel transferRecordParcel = (TransferRecordParcel) bankRemitSelectPayeeUI.pJL.get(size);
            if (transferRecordParcel.pHK.equals(str)) {
                transferRecordParcel.pHN = str2;
                bankRemitSelectPayeeUI.pJM.add(transferRecordParcel);
                break;
            }
        }
        bankRemitSelectPayeeUI.pJK.notifyDataSetChanged();
        bankRemitSelectPayeeUI.pJQ.putParcelableArrayListExtra("key_modified_record_list", bankRemitSelectPayeeUI.pJM);
        bankRemitSelectPayeeUI.setResult(0, bankRemitSelectPayeeUI.pJQ);
        com.tencent.mm.plugin.report.service.g.pQN.h(14673, new Object[]{Integer.valueOf(5)});
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Collection parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("key_self_transfer_record_list");
        Collection parcelableArrayListExtra2 = getIntent().getParcelableArrayListExtra("key_freq_transfer_record_list");
        this.pJL = new ArrayList();
        if (!(parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty())) {
            this.pJO = 0;
            this.pJL.addAll(parcelableArrayListExtra);
        }
        if (!(parcelableArrayListExtra2 == null || parcelableArrayListExtra2.isEmpty())) {
            this.pJP = (this.pJL.size() + this.pJO) + 1;
            this.pJL.addAll(parcelableArrayListExtra2);
        }
        x.i("MicroMsg.BankRemitSelectPayeeUI", "selfHeaderPos: %s, otherHeaderPos: %s", new Object[]{Integer.valueOf(this.pJO), Integer.valueOf(this.pJP)});
        for (TransferRecordParcel transferRecordParcel : this.pJL) {
            x.d("MicroMsg.BankRemitSelectPayeeUI", "seqno: %s, tail: %s, bank_logo: %s, bank_name: %s, bank_type: %s, payee: %s, explain: %s", new Object[]{transferRecordParcel.pHK, transferRecordParcel.pHL, transferRecordParcel.pHq, transferRecordParcel.nBM, transferRecordParcel.oZz, transferRecordParcel.pHM, transferRecordParcel.pHN});
        }
        this.pJQ = new Intent();
        initView();
        setMMTitle(i.uHY);
        ji(1590);
        ji(1395);
    }

    public final void initView() {
        this.pJJ = (ListView) findViewById(f.ugR);
        this.juS = new l(this);
        this.pJK = new b();
        this.pJJ.setAdapter(this.pJK);
        this.pJJ.setOnItemClickListener(new 1(this));
        this.pJJ.setOnItemLongClickListener(new 3(this));
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 1, 0, i.uHW);
        contextMenu.add(0, 0, 0, i.uHT);
    }

    public void onMMMenuItemSelected(MenuItem menuItem, int i) {
        int itemId = menuItem.getItemId();
        TransferRecordParcel transferRecordParcel = (TransferRecordParcel) this.pJJ.getItemAtPosition(((AdapterContextMenuInfo) menuItem.getMenuInfo()).position);
        if (transferRecordParcel == null) {
            x.i("MicroMsg.BankRemitSelectPayeeUI", "select record is null");
        } else if (itemId == 1) {
            a.a(this, getString(i.uIx), transferRecordParcel.pHN, "", 32, new 4(this, transferRecordParcel), new 5(this));
        } else if (itemId == 0) {
            String str = transferRecordParcel.pHK;
            x.i("MicroMsg.BankRemitSelectPayeeUI", "do delete record");
            b(new com.tencent.mm.plugin.remittance.bankcard.a.f(str), true);
            com.tencent.mm.plugin.report.service.g.pQN.h(14673, new Object[]{Integer.valueOf(7)});
        } else {
            x.i("MicroMsg.BankRemitSelectPayeeUI", "unknown itemId: %s", new Object[]{Integer.valueOf(itemId)});
        }
    }

    protected final int getLayoutId() {
        return g.uBk;
    }

    public void onDestroy() {
        super.onDestroy();
        jj(1590);
        jj(1395);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof j) {
            j jVar = (j) kVar;
            jVar.a(new 8(this, jVar)).b(new 7(this, jVar)).c(new 6(this));
        } else if (kVar instanceof com.tencent.mm.plugin.remittance.bankcard.a.f) {
            final com.tencent.mm.plugin.remittance.bankcard.a.f fVar = (com.tencent.mm.plugin.remittance.bankcard.a.f) kVar;
            fVar.a(new com.tencent.mm.wallet_core.c.g.a(this) {
                final /* synthetic */ BankRemitSelectPayeeUI pJR;

                public final void f(int i, int i2, String str, k kVar) {
                    BankRemitSelectPayeeUI.a(this.pJR, fVar.pHd);
                }
            }).b(new 10(this, fVar)).c(new 9(this));
        }
        return false;
    }
}
