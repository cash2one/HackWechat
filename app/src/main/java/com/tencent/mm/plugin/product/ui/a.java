package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class a extends BaseAdapter {
    private Context pfh;
    private List<com.tencent.mm.plugin.product.c.a> pfi;
    private List<Boolean> pfj;
    private int pfk = 1;

    public final /* synthetic */ Object getItem(int i) {
        return uE(i);
    }

    public a(Context context) {
        this.pfh = context;
    }

    public final void bn(List<com.tencent.mm.plugin.product.c.a> list) {
        this.pfi = list;
        this.pfk = 0;
        this.pfj = new ArrayList();
        if (this.pfi != null) {
            Set hashSet = new HashSet();
            for (com.tencent.mm.plugin.product.c.a aVar : list) {
                this.pfj.add(Boolean.valueOf(false));
                hashSet.add(Integer.valueOf(aVar.ktN));
            }
            this.pfk = list.size();
        }
        if (this.pfk <= 0) {
            this.pfk = 1;
        }
    }

    public final void a(Activity activity, View view, int i) {
        b bVar = (b) view.getTag();
        x.i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.type" + bVar.type);
        x.i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.content" + bVar.pfo);
        Intent intent;
        switch (bVar.type) {
            case 0:
                return;
            case 1:
                if (bVar.pfo instanceof String) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", (String) bVar.pfo);
                    intent.putExtra("showShare", false);
                    d.b(this.pfh, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, 10000);
                    return;
                }
                return;
            case 2:
                if (bVar.pfo instanceof ArrayList) {
                    ArrayList arrayList = (ArrayList) bVar.pfo;
                    intent = new Intent(activity, MallGalleryUI.class);
                    intent.putExtra("keys_img_urls", arrayList);
                    activity.startActivity(intent);
                    return;
                }
                return;
            case 4:
            case 6:
                if (bVar.pfo instanceof String) {
                    String str = (String) bVar.pfo;
                    Intent intent2 = new Intent();
                    intent2.putExtra("title", bVar.title);
                    intent2.putExtra("neverGetA8Key", false);
                    intent2.putExtra("showShare", false);
                    intent2.putExtra("show_bottom", false);
                    intent2.putExtra(SlookAirButtonFrequentContactAdapter.DATA, str);
                    intent2.putExtra("QRDataFlag", false);
                    d.b(activity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent2);
                    return;
                }
                return;
            case 5:
                if (((Boolean) this.pfj.get(i)).booleanValue()) {
                    this.pfj.set(i, Boolean.valueOf(false));
                } else {
                    this.pfj.set(i, Boolean.valueOf(true));
                }
                notifyDataSetChanged();
                return;
            default:
                x.w("MicroMsg.MallCustomActionAdapter", "not support type");
                return;
        }
    }

    public final int getCount() {
        return this.pfi != null ? this.pfi.size() : 0;
    }

    private com.tencent.mm.plugin.product.c.a uE(int i) {
        return (com.tencent.mm.plugin.product.c.a) this.pfi.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getViewTypeCount() {
        return this.pfk;
    }

    public final int getItemViewType(int i) {
        return uE(i).ktN;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = View.inflate(this.pfh, a$g.uDz, null);
            bVar = new b();
            bVar.jJn = (TextView) view.findViewById(f.cSu);
            bVar.pfl = (TextView) view.findViewById(f.uwG);
            bVar.pfm = (ImageView) view.findViewById(f.ukU);
            bVar.pfn = (HtmlTextView) view.findViewById(f.ujo);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        com.tencent.mm.plugin.product.c.a uE = uE(i);
        if (uE != null) {
            bVar.jJn.setText(uE.nfp);
            bVar.pfl.setText(uE.pew);
            bVar.type = uE.ktN;
            bVar.pfo = uE.nje;
            bVar.title = uE.nfp;
            switch (uE.ktN) {
                case 0:
                    bVar.pfm.setVisibility(8);
                    break;
                case 5:
                case 6:
                    if (((Boolean) this.pfj.get(i)).booleanValue()) {
                        bVar.pfn.setVisibility(0);
                    } else {
                        bVar.pfn.setVisibility(8);
                    }
                    if (!bVar.pfn.getText().equals(uE.nje)) {
                        bVar.pfn.setText(uE.nje);
                        break;
                    }
                    break;
            }
        }
        return view;
    }
}
