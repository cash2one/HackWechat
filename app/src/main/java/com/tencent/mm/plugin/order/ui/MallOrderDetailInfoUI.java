package com.tencent.mm.plugin.order.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.order.a.b;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import com.tencent.mm.plugin.order.model.ProductSectionItem$Skus;
import com.tencent.mm.plugin.order.model.f;
import com.tencent.mm.plugin.order.model.j;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MallOrderDetailInfoUI extends WalletBaseUI implements com.tencent.mm.platformtools.j.a {
    private ListView Fv;
    private OnClickListener inN = new 1(this);
    private String lie = "";
    private HashMap<String, View> oXO = new HashMap();
    private List<com.tencent.mm.plugin.order.model.MallOrderDetailObject.a> oZY = new ArrayList();
    String pbR;
    private a pbS;
    private View pbT;
    private View pbU;
    private View pbV;
    private View pbW;
    private View pbX;
    private View pbY;
    private View pbZ;
    protected MallOrderDetailObject pbg = null;
    private boolean pca = false;
    private boolean pcb = false;
    private int pcc = 0;
    private CheckedTextView pcd;
    private CheckedTextView pce;
    OnClickListener pcf = new OnClickListener(this) {
        final /* synthetic */ MallOrderDetailInfoUI pcg;

        {
            this.pcg = r1;
        }

        public final void onClick(View view) {
            if (this.pcg.pcd != null && this.pcg.pce != null) {
                if (view.getId() == a$f.usf) {
                    this.pcg.pcd.setSelected(true);
                    this.pcg.pce.setSelected(false);
                    this.pcg.pcc = 100;
                    return;
                }
                this.pcg.pcd.setSelected(false);
                this.pcg.pce.setSelected(true);
                this.pcg.pcc = -100;
            }
        }
    };

    private class a extends BaseAdapter {
        final /* synthetic */ MallOrderDetailInfoUI pcg;

        private a(MallOrderDetailInfoUI mallOrderDetailInfoUI) {
            this.pcg = mallOrderDetailInfoUI;
        }

        public final /* synthetic */ Object getItem(int i) {
            return ux(i);
        }

        public final int getCount() {
            return this.pcg.oZY.size();
        }

        private com.tencent.mm.plugin.order.model.MallOrderDetailObject.a ux(int i) {
            return (com.tencent.mm.plugin.order.model.MallOrderDetailObject.a) this.pcg.oZY.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            com.tencent.mm.plugin.order.model.MallOrderDetailObject.a ux = ux(i);
            View findViewById;
            switch (ux.type) {
                case 1:
                    view = View.inflate(this.pcg, g.uCS, null);
                    findViewById = view.findViewById(a$f.usd);
                    this.pcg.pcd = (CheckedTextView) view.findViewById(a$f.usf);
                    this.pcg.pce = (CheckedTextView) view.findViewById(a$f.usc);
                    this.pcg.pcd.setOnClickListener(this.pcg.pcf);
                    this.pcg.pce.setOnClickListener(this.pcg.pcf);
                    if (i + 1 < getCount()) {
                        MallOrderDetailInfoUI.a(findViewById, ux(i + 1));
                        break;
                    }
                    break;
                case 2:
                    view = View.inflate(this.pcg, g.uCR, null);
                    TextView textView = (TextView) view.findViewById(a$f.usc);
                    findViewById = view.findViewById(a$f.usd);
                    if (bh.getInt(ux.value, 0) >= 0) {
                        textView.setText(i.uLj);
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, h.uGB, 0);
                    } else {
                        textView.setText(i.uLi);
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, h.uGz, 0);
                    }
                    if (i + 1 < getCount()) {
                        MallOrderDetailInfoUI.a(findViewById, ux(i + 1));
                        break;
                    }
                    break;
                default:
                    b bVar;
                    if (view == null) {
                        view = View.inflate(this.pcg, g.uCQ, null);
                        b bVar2 = new b(this.pcg, (byte) 0);
                        bVar2.kUP = (TextView) view.findViewById(a$f.ush);
                        bVar2.kVS = (TextView) view.findViewById(a$f.usg);
                        bVar2.kVT = (TextView) view.findViewById(a$f.use);
                        bVar2.kpZ = view.findViewById(a$f.usd);
                        view.setTag(bVar2);
                        bVar = bVar2;
                    } else {
                        bVar = (b) view.getTag();
                    }
                    bVar.kUP.setText(ux.name);
                    if (TextUtils.isEmpty(ux.value)) {
                        bVar.kVS.setVisibility(4);
                    } else {
                        bVar.kVS.setVisibility(0);
                        bVar.kVS.setText(ux.value);
                    }
                    if (ux.kKb) {
                        bVar.kVT.setVisibility(0);
                    } else {
                        bVar.kVT.setVisibility(8);
                    }
                    if (i + 1 < getCount()) {
                        MallOrderDetailInfoUI.a(bVar.kpZ, ux(i + 1));
                        break;
                    }
                    break;
            }
            return view;
        }

        public final int getItemViewType(int i) {
            return ux(i).type;
        }

        public final int getViewTypeCount() {
            return 3;
        }
    }

    static /* synthetic */ void c(MallOrderDetailInfoUI mallOrderDetailInfoUI) {
        if (!TextUtils.isEmpty(mallOrderDetailInfoUI.pbR)) {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(mallOrderDetailInfoUI.pbR).toString()));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            mallOrderDetailInfoUI.startActivity(intent);
        }
    }

    static /* synthetic */ void d(MallOrderDetailInfoUI mallOrderDetailInfoUI) {
        Context context = mallOrderDetailInfoUI;
        com.tencent.mm.ui.base.h.a(context, "", new String[]{mallOrderDetailInfoUI.getString(i.uLs)}, "", false, new 5(mallOrderDetailInfoUI));
    }

    protected final int getLayoutId() {
        return g.uCY;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c ag = com.tencent.mm.wallet_core.a.ag(this);
        if (ag != null && (ag instanceof com.tencent.mm.plugin.order.a.a)) {
            String string = this.vf.getString("key_trans_id");
            this.lie = string;
            if (string != null) {
                b.bit();
                if (!b.biw().Hk(string)) {
                    this.pca = false;
                    l(new com.tencent.mm.plugin.order.model.h(string));
                }
            }
            b.bit();
            if (b.biw().Hk(string)) {
                MallOrderDetailObject mallOrderDetailObject;
                this.pca = true;
                b.bit();
                com.tencent.mm.plugin.order.model.c biw = b.biw();
                if (TextUtils.isEmpty(string)) {
                    mallOrderDetailObject = null;
                } else {
                    x.v("MicroMsg.MallPayMsgManager", "getMallOrderDetailObjectByMsgId msgId:" + string);
                    mallOrderDetailObject = com.tencent.mm.plugin.order.model.c.a(biw.Hl(string));
                }
                this.pbg = mallOrderDetailObject;
                if (this.pbg == null) {
                    biG();
                }
            } else {
                x.w("MicroMsg.MallOrderDetailInfoUI", "mOrders info is Illegal!");
                biG();
            }
        }
        initView();
    }

    protected final void initView() {
        if (this.pca) {
            b.bit();
            j Hl = b.biw().Hl(this.lie);
            int intValue = (Hl == null || TextUtils.isEmpty(Hl.pbC) || !com.tencent.mm.plugin.order.c.c.wP(Hl.pbC)) ? -1 : Integer.valueOf(Hl.pbC).intValue();
            if (intValue == 2) {
                setMMTitle(i.uLk);
            } else if (intValue == 1) {
                setMMTitle(i.uLl);
            }
        } else {
            setMMTitle(i.uLm);
        }
        this.pbT = findViewById(a$f.usn);
        this.pbU = findViewById(a$f.usm);
        this.pbY = findViewById(a$f.usB);
        this.pbZ = findViewById(a$f.usz);
        this.pbX = findViewById(a$f.usA);
        this.pbV = findViewById(a$f.usI);
        this.pbW = findViewById(a$f.usH);
        this.pbT.setOnClickListener(this.inN);
        this.pbZ.setOnClickListener(this.inN);
        this.pbY.setOnClickListener(this.inN);
        this.pbX.setOnClickListener(this.inN);
        this.pbV.setOnClickListener(this.inN);
        findViewById(a$f.usj).setOnClickListener(this.inN);
        findViewById(a$f.ukR).setOnClickListener(this.inN);
        findViewById(a$f.uAM).setOnClickListener(this.inN);
        this.Fv = (ListView) findViewById(a$f.usi);
        this.pbS = new a();
        this.Fv.setAdapter(this.pbS);
        this.pbS.notifyDataSetChanged();
        this.Fv.setOnItemClickListener(new 6(this));
        biE();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        if (com.tencent.mm.wallet_core.a.ag(this) instanceof com.tencent.mm.plugin.order.a.a) {
            com.tencent.mm.wallet_core.a.ad(this);
        }
        return true;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        if (kVar instanceof com.tencent.mm.plugin.order.model.h) {
            MallOrderDetailObject mallOrderDetailObject = ((com.tencent.mm.plugin.order.model.h) kVar).pbg;
            x.d("MicroMsg.MallOrderDetailInfoUI", "tempObject:" + mallOrderDetailObject);
            if (mallOrderDetailObject != null) {
                this.pbg = mallOrderDetailObject;
                biE();
            }
        }
        return true;
    }

    private void biE() {
        if (this.pbg != null) {
            com.tencent.mm.platformtools.j.a((com.tencent.mm.platformtools.j.a) this);
            this.oXO.clear();
            MallOrderDetailObject.b bVar = this.pbg.oZW;
            if (bVar != null) {
                CharSequence charSequence;
                String str = bVar.pae;
                if (TextUtils.isEmpty(bVar.paf)) {
                    Object obj = str;
                } else {
                    charSequence = str + "：" + bVar.paf;
                }
                if (this.pca) {
                    this.pbT.setVisibility(8);
                    this.pbU.setVisibility(0);
                    ((TextView) this.pbU.findViewById(a$f.usp)).setText(charSequence);
                    ((TextView) this.pbU.findViewById(a$f.uso)).setText(e.HD(this.pbg.pad));
                    if (TextUtils.isEmpty(bVar.thumbUrl) || !e.aaz(bVar.thumbUrl)) {
                        c((ImageView) this.pbU.findViewById(a$f.usy));
                    } else {
                        m((ImageView) this.pbU.findViewById(a$f.usy), bVar.thumbUrl);
                    }
                } else {
                    this.pbU.setVisibility(8);
                    this.pbT.setVisibility(0);
                    ((TextView) this.pbT.findViewById(a$f.usp)).setText(charSequence);
                    ((TextView) this.pbT.findViewById(a$f.uso)).setText(e.HD(this.pbg.pad));
                    if (TextUtils.isEmpty(bVar.thumbUrl) || !e.aaz(bVar.thumbUrl)) {
                        c((ImageView) this.pbT.findViewById(a$f.usy));
                    } else {
                        m((ImageView) this.pbT.findViewById(a$f.usy), bVar.thumbUrl);
                    }
                }
            } else {
                this.pbT.setVisibility(8);
                this.pbU.setVisibility(8);
            }
            List list = this.pbg.oZX;
            if (list == null || list.size() == 0) {
                this.pbX.setVisibility(8);
                this.pbY.setVisibility(8);
                this.pbZ.setVisibility(8);
            } else if (list.size() == 1) {
                this.pbZ.setVisibility(8);
                ProductSectionItem productSectionItem = (ProductSectionItem) list.get(0);
                if (TextUtils.isEmpty(productSectionItem.iconUrl)) {
                    this.pbY.setVisibility(8);
                    this.pbX.setVisibility(0);
                    ((TextView) this.pbX.findViewById(a$f.uln)).setText(productSectionItem.name);
                    if (TextUtils.isEmpty(productSectionItem.jumpUrl)) {
                        Rect rect = new Rect();
                        rect.set(this.pbX.findViewById(a$f.ulm).getPaddingLeft(), this.pbX.findViewById(a$f.ulm).getPaddingTop(), this.pbX.findViewById(a$f.ulm).getPaddingRight(), this.pbX.findViewById(a$f.ulm).getPaddingBottom());
                        this.pbX.findViewById(a$f.ulm).setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.bDp);
                        this.pbX.findViewById(a$f.ulm).setPadding(rect.left, rect.top, rect.right, rect.bottom);
                    } else {
                        ((TextView) this.pbX.findViewById(a$f.uln)).setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.ube));
                    }
                } else {
                    this.pbX.setVisibility(8);
                    this.pbY.setVisibility(0);
                    ((TextView) this.pbY.findViewById(a$f.uln)).setText(productSectionItem.name);
                    ((TextView) this.pbY.findViewById(a$f.ulp)).setText(productSectionItem.pbN);
                    ((TextView) this.pbY.findViewById(a$f.ull)).setText("+" + productSectionItem.count);
                    ((TextView) this.pbY.findViewById(a$f.ulk)).setText(ProductSectionItem$Skus.bk(productSectionItem.pbM));
                    if (!TextUtils.isEmpty(productSectionItem.iconUrl)) {
                        m((ImageView) this.pbY.findViewById(a$f.ulo), productSectionItem.iconUrl);
                    }
                }
            } else {
                this.pbX.setVisibility(8);
                this.pbY.setVisibility(8);
                this.pbZ.setVisibility(0);
                if (list.size() == 2) {
                    a(this.pbZ.findViewById(a$f.usC), (ProductSectionItem) list.get(0));
                    a(this.pbZ.findViewById(a$f.usD), (ProductSectionItem) list.get(1));
                    this.pbZ.findViewById(a$f.usE).setVisibility(8);
                    this.pbZ.findViewById(a$f.usF).setVisibility(8);
                } else if (list.size() == 3) {
                    a(this.pbZ.findViewById(a$f.usC), (ProductSectionItem) list.get(0));
                    a(this.pbZ.findViewById(a$f.usD), (ProductSectionItem) list.get(1));
                    a(this.pbZ.findViewById(a$f.usE), (ProductSectionItem) list.get(2));
                    this.pbZ.findViewById(a$f.usF).setVisibility(8);
                } else if (list.size() >= 4) {
                    a(this.pbZ.findViewById(a$f.usC), (ProductSectionItem) list.get(0));
                    a(this.pbZ.findViewById(a$f.usD), (ProductSectionItem) list.get(1));
                    a(this.pbZ.findViewById(a$f.usE), (ProductSectionItem) list.get(2));
                    a(this.pbZ.findViewById(a$f.usF), (ProductSectionItem) list.get(3));
                }
            }
            MallTransactionObject mallTransactionObject = this.pbg.oZV;
            if (mallTransactionObject != null) {
                this.pbV.setVisibility(0);
                ((TextView) findViewById(a$f.usJ)).setText(e.d(mallTransactionObject.ljg, mallTransactionObject.paz));
                if (!(this.pbg == null || this.pbg.oZY == null || this.pbg.oZY.size() <= 0)) {
                    a(this.pbW, (com.tencent.mm.plugin.order.model.MallOrderDetailObject.a) this.pbg.oZY.get(0));
                }
            } else {
                this.pbV.setVisibility(8);
            }
            Collection collection = this.pbg.oZY;
            if (collection != null) {
                this.oZY.addAll(collection);
                this.pbS.notifyDataSetChanged();
            }
            findViewById(a$f.uqm).setVisibility(0);
            if (this.pbg != null && TextUtils.isEmpty(this.pbg.pac) && TextUtils.isEmpty(this.pbg.fvL)) {
                findViewById(a$f.uqm).setVisibility(8);
            } else if (this.pbg != null && !TextUtils.isEmpty(this.pbg.pac) && TextUtils.isEmpty(this.pbg.fvL)) {
                findViewById(a$f.uAM).setVisibility(8);
                findViewById(a$f.uAL).setVisibility(8);
                r0 = (TextView) findViewById(a$f.ukR);
                r0.setVisibility(0);
                r0.setGravity(3);
            } else if (!(this.pbg == null || !TextUtils.isEmpty(this.pbg.pac) || TextUtils.isEmpty(this.pbg.fvL))) {
                findViewById(a$f.ukR).setVisibility(8);
                findViewById(a$f.uAL).setVisibility(8);
                r0 = (TextView) findViewById(a$f.uAM);
                r0.setVisibility(0);
                r0.setGravity(3);
            }
            if (this.pbg != null && !TextUtils.isEmpty(this.pbg.pab)) {
                addIconOptionMenu(0, com.tencent.mm.plugin.wxpay.a.e.bDI, new 4(this));
            }
        }
    }

    private void a(View view, ProductSectionItem productSectionItem) {
        if (view != null && productSectionItem != null) {
            view.setVisibility(0);
            TextView textView = (TextView) view.findViewById(a$f.uln);
            if (textView != null) {
                textView.setText(productSectionItem.name);
            }
            if (!TextUtils.isEmpty(productSectionItem.iconUrl)) {
                m((ImageView) view.findViewById(a$f.ulo), productSectionItem.iconUrl);
            }
        }
    }

    private void m(ImageView imageView, String str) {
        if (imageView != null && !TextUtils.isEmpty(str) && e.aaz(str)) {
            imageView.setImageBitmap(com.tencent.mm.platformtools.j.a(new com.tencent.mm.plugin.order.c.b(str)));
            this.oXO.put(str, imageView);
        }
    }

    private static void a(View view, com.tencent.mm.plugin.order.model.MallOrderDetailObject.a aVar) {
        if (aVar != null) {
            Rect rect = new Rect();
            rect.left = view.getPaddingLeft();
            rect.right = view.getPaddingRight();
            rect.top = view.getPaddingTop();
            rect.bottom = view.getPaddingBottom();
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (aVar == null || !aVar.kKb) {
                view.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.bDp);
            } else {
                view.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.bDJ);
            }
            view.setLayoutParams(layoutParams);
            view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    public final void l(String str, Bitmap bitmap) {
        ImageView imageView = (ImageView) this.oXO.get(str);
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    private void c(ImageView imageView) {
        Bitmap decodeResource = com.tencent.mm.compatible.f.a.decodeResource(getResources(), h.uGC);
        if (decodeResource != null) {
            imageView.setImageBitmap(d.a(decodeResource, false, 96.0f));
        }
    }

    private void biF() {
        if (!this.pcb && this.pcc != 0) {
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().gPJ.a(new f(this.lie, "", this.pcc), 0);
            this.pcb = true;
        }
    }

    public void finish() {
        biF();
        super.finish();
    }

    public void onDestroy() {
        biF();
        super.onDestroy();
    }

    public final void uw(int i) {
        finish();
    }

    private void biG() {
        com.tencent.mm.ui.base.h.a(this.mController.xIM, i.uTp, 0, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ MallOrderDetailInfoUI pcg;

            {
                this.pcg = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.pcg.finish();
            }
        });
    }
}
