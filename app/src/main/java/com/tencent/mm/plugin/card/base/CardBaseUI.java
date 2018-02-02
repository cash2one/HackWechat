package com.tencent.mm.plugin.card.base;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n;
import com.tencent.mm.plugin.card.model.x;
import com.tencent.mm.plugin.card.sharecard.model.b;
import com.tencent.mm.plugin.card.sharecard.ui.g;
import com.tencent.mm.plugin.card.sharecard.ui.h;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.plugin.card.ui.d;
import com.tencent.mm.protocal.c.kg;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class CardBaseUI extends DrawStatusBarActivity implements e, a {
    private float gyA = -1000.0f;
    private com.tencent.mm.modelgeo.a.a gyF = new 7(this);
    private float gyz = -85.0f;
    public c hpO;
    private boolean hpR = false;
    private r jmO = null;
    public ListView kIe = null;
    public BaseAdapter kIf = null;
    public RelativeLayout kIg = null;
    public LinearLayout kIh;
    public LinearLayout kIi;
    public boolean kIj = false;
    public boolean kIk = true;
    public a kIl = null;
    public CardInfo kIm;

    public abstract void asS();

    static /* synthetic */ void a(CardBaseUI cardBaseUI, String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        cardBaseUI.kIj = false;
        cardBaseUI.B(linkedList);
    }

    static /* synthetic */ void c(CardBaseUI cardBaseUI, String str) {
        cardBaseUI.dY(true);
        ar.CG().a(new af(cardBaseUI.kIm.field_card_id, str, 17), 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onResume() {
        super.onResume();
        this.kIk = true;
        ar.CG().a(652, (e) this);
    }

    public void onPause() {
        super.onPause();
        this.kIk = false;
        ar.CG().b(652, (e) this);
    }

    public void initView() {
        a dVar;
        setBackBtn(new 1(this));
        this.kIe = (ListView) findViewById(16908298);
        this.kIg = (RelativeLayout) findViewById(R.h.bYR);
        if (this.kIg != null) {
            this.kIe.setEmptyView(this.kIg);
        }
        this.kIh = (LinearLayout) View.inflate(getBaseContext(), R.i.dcn, null);
        this.kIi = (LinearLayout) View.inflate(getBaseContext(), R.i.dck, null);
        this.kIe.addHeaderView(this.kIh);
        this.kIe.addFooterView(this.kIi);
        this.kIf = asU();
        this.kIe.setAdapter(this.kIf);
        this.kIe.setOnItemClickListener(new 2(this));
        this.kIe.setOnItemLongClickListener(new 3(this));
        ar.CG().a(560, (e) this);
        ar.CG().a(692, (e) this);
        BaseAdapter baseAdapter = this.kIf;
        if (baseAdapter instanceof com.tencent.mm.plugin.card.ui.c) {
            dVar = new d((com.tencent.mm.plugin.card.ui.c) baseAdapter);
        } else {
            Object dVar2 = baseAdapter instanceof com.tencent.mm.plugin.card.sharecard.ui.c ? new com.tencent.mm.plugin.card.sharecard.ui.d((com.tencent.mm.plugin.card.sharecard.ui.c) baseAdapter) : baseAdapter instanceof g ? new h((g) baseAdapter) : new com.tencent.mm.plugin.card.ui.h((com.tencent.mm.plugin.card.ui.g) baseAdapter);
        }
        this.kIl = dVar;
        this.kIl.onCreate();
        asS();
    }

    public int getLayoutId() {
        return R.i.dcg;
    }

    public void onDestroy() {
        ar.CG().b(560, (e) this);
        ar.CG().b(692, (e) this);
        if (this.kIl != null) {
            this.kIl.onDestroy();
        }
        super.onDestroy();
    }

    public void a(b bVar) {
        Intent intent = new Intent(this, CardDetailUI.class);
        intent.putExtra("key_card_id", bVar.atF());
        intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        intent.putExtra("key_from_scene", 3);
        startActivity(intent);
        if (asT() == n.a.kLL) {
            com.tencent.mm.plugin.report.service.g.pQN.h(11324, "ClickMemberCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0));
        } else if (asT() == n.a.kLK) {
            com.tencent.mm.plugin.report.service.g.pQN.h(11324, "ClickMemberCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0));
        }
    }

    public final void dY(boolean z) {
        if (z) {
            this.jmO = r.b(this, getString(R.l.dHc), true, 0, null);
        } else if (this.jmO != null && this.jmO.isShowing()) {
            this.jmO.dismiss();
            this.jmO = null;
        }
    }

    public final void B(LinkedList<String> linkedList) {
        dY(true);
        ar.CG().a(new com.tencent.mm.plugin.card.model.r(linkedList), 0);
    }

    public void a(int i, int i2, String str, k kVar) {
        int i3;
        if (i != 0 || i2 != 0) {
            dY(false);
            if (kVar instanceof af) {
                i3 = ((af) kVar).kLO;
                CharSequence charSequence = ((af) kVar).kLP;
                if (i3 == 10000) {
                    if (TextUtils.isEmpty(charSequence)) {
                        charSequence = getString(R.l.dOj);
                    }
                    str = charSequence;
                }
            }
            if (!(kVar instanceof x) && !(kVar instanceof ad) && !(kVar instanceof b) && this.kIk) {
                com.tencent.mm.plugin.card.b.d.b(this, str, i2);
            }
        } else if (kVar instanceof com.tencent.mm.plugin.card.model.r) {
            dY(false);
            com.tencent.mm.ui.base.h.bu(this, getResources().getString(R.l.dNY));
            am.auz();
            com.tencent.mm.plugin.card.a.b.nF(4);
            this.kIl.Hv();
            ate();
        } else if (kVar instanceof af) {
            dY(false);
            i3 = ((af) kVar).kLO;
            String str2 = ((af) kVar).kLP;
            if (i3 == 10000) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = getString(R.l.dOj);
                }
                com.tencent.mm.plugin.card.b.d.b(this, str2, i3);
                return;
            }
            if (this.kIm != null) {
                kg atC = this.kIm.atC();
                atC.status = 3;
                this.kIm.a(atC);
                if (!am.auA().c(this.kIm, new String[0])) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.CardBaseUI", "update newSerial fail, cardId = %s", this.kIm.field_card_id);
                }
            }
            this.kIl.Hv();
            ate();
        }
    }

    public int asT() {
        return n.a.kLG;
    }

    public BaseAdapter asU() {
        return new com.tencent.mm.plugin.card.ui.c(this, asT());
    }

    public boolean asV() {
        return true;
    }

    public boolean asW() {
        return true;
    }

    public void asX() {
    }

    public void b(b bVar) {
        if (!asV()) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.CardBaseUI", "isItemClickable return false");
        } else if (bVar == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.CardBaseUI", "onListItemClick  item == null");
        } else if (!bVar.atF().equals("PRIVATE_TICKET_TITLE") && !bVar.atF().equals("PRIVATE_INVOICE_TITLE")) {
            if (bVar.atn()) {
                a(bVar);
            } else if (!TextUtils.isEmpty(bVar.atB().vRO)) {
                com.tencent.mm.plugin.card.b.b.a(this, bVar.atB().vRO, 0);
            }
        }
    }

    public void c(b bVar) {
        if (!asW()) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.CardBaseUI", "isItemClickable return false");
        } else if (bVar == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.CardBaseUI", "onListItemLongClick  item == null");
        } else {
            ArrayList arrayList = new ArrayList();
            if (bVar.ato()) {
                arrayList.add(getResources().getString(R.l.dOL));
            }
            arrayList.add(getResources().getString(R.l.dEw));
            String atF = bVar.atF();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(bVar.atB().kKZ);
            com.tencent.mm.ui.base.h.a(this, stringBuilder.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]), null, new 5(this, bVar, atF));
        }
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == 0 && i2 == -1) {
            j(intent.getStringExtra("Select_Conv_User"), 0, false);
        }
    }

    public void a(CardInfo cardInfo) {
        this.kIm = cardInfo;
        com.tencent.mm.plugin.card.b.b.a(this, 0, this);
    }

    public final void j(String str, int i, boolean z) {
        if (this.kIm == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo == null");
        } else if (this.kIm.atB() == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            if (i == 0) {
                if (TextUtils.isEmpty(this.kIm.atD().wLJ)) {
                    stringBuilder.append(getString(R.l.ePW));
                } else {
                    stringBuilder.append(this.kIm.atD().wLJ);
                }
                com.tencent.mm.plugin.report.service.g.pQN.h(11582, "OperGift", Integer.valueOf(2), Integer.valueOf(this.kIm.atB().kJO), this.kIm.field_card_tp_id, this.kIm.field_card_id, str);
            } else if (i == 1) {
                stringBuilder.append(getString(R.l.dOi, new Object[]{this.kIm.atB().kKZ}));
                com.tencent.mm.plugin.report.service.g.pQN.h(11582, "OperGift", Integer.valueOf(3), Integer.valueOf(this.kIm.atB().kJO), this.kIm.field_card_tp_id, this.kIm.field_card_id, str);
            }
            com.tencent.mm.pluginsdk.ui.applet.e.a(this.mController, stringBuilder.toString(), this.kIm.atB().kJP, this.kIm.atB().title + "\n" + this.kIm.atB().kLa, null, false, getResources().getString(R.l.dGA), new 6(this, str, z));
        }
    }

    public final void asY() {
        if (this.hpO == null) {
            this.hpO = c.OP();
        }
        if (this.hpO != null) {
            this.hpO.a(this.gyF, true);
        }
    }

    public final void asZ() {
        if (this.hpO != null) {
            this.hpO.a(this.gyF, true);
        }
    }

    public final void ata() {
        if (this.hpO != null) {
            this.hpO.c(this.gyF);
        }
    }

    public void atb() {
    }

    public void atc() {
    }

    public void atd() {
    }

    public void ate() {
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.CardBaseUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 69:
                if (iArr[0] == 0) {
                    atd();
                    return;
                } else {
                    com.tencent.mm.ui.base.h.a(this, getString(R.l.ezP), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 8(this), null);
                    return;
                }
            default:
                return;
        }
    }
}
