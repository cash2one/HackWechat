package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.a.a.c.a;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.b.bq;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.z.ar;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

final class ExdeviceManageDeviceUI$a extends BaseAdapter implements e {
    private d kHp;
    private List<b> lRD;
    private c lRR;
    boolean lUO;
    private WeakReference<Context> lUP;
    private OnClickListener lUQ;
    private l lUR;
    private volatile int lUS = -1;
    private r tipDialog = null;

    static /* synthetic */ void a(Context context, b bVar) {
        Intent intent = new Intent();
        intent.putExtra("device_type", bVar.field_deviceType);
        intent.putExtra("device_id", bVar.field_deviceID);
        intent.putExtra("device_mac", bVar.field_mac);
        intent.putExtra("device_brand_name", bVar.field_brandName);
        intent.putExtra("device_desc", bVar.gfP);
        intent.putExtra("device_title", bVar.gfO);
        intent.putExtra("device_icon_url", bVar.iconUrl);
        intent.putExtra("device_alias", bVar.gfN);
        intent.putExtra("device_jump_url", bVar.jumpUrl);
        intent.putExtra("subscribe_flag", 1);
        com.tencent.mm.bm.d.b(context, "exdevice", ".ui.ExdeviceDeviceProfileUI", intent, 1000);
    }

    static /* synthetic */ void a(ExdeviceManageDeviceUI$a exdeviceManageDeviceUI$a, b bVar) {
        if (bVar != null && exdeviceManageDeviceUI$a.lUP != null) {
            Context context = (Context) exdeviceManageDeviceUI$a.lUP.get();
            if (context == null) {
                x.e("MicroMsg.ExdeviceManageDeviceUI", "context is null.");
                return;
            }
            context.getString(R.l.dGO);
            exdeviceManageDeviceUI$a.tipDialog = h.a(context, context.getString(R.l.dHc), true, new 3(exdeviceManageDeviceUI$a));
            ar.Dm().F(new 4(exdeviceManageDeviceUI$a, bVar));
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return pm(i);
    }

    public ExdeviceManageDeviceUI$a(Context context) {
        this.lUP = new WeakReference(context);
        this.lRD = new LinkedList();
        this.lUR = new l(context);
        a aVar = new a();
        aVar.hDP = R.g.bBZ;
        this.lRR = aVar.PK();
        this.kHp = new 1(this);
        this.lUQ = new 2(this);
        aD(ad.aEk().aEP());
    }

    public final void aD(List<b> list) {
        this.lRD.clear();
        if (list != null && list.size() != 0) {
            this.lRD.addAll(list);
        }
    }

    public final int getCount() {
        return this.lRD.size();
    }

    public final b pm(int i) {
        return (b) this.lRD.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        CharSequence charSequence;
        bq pm = pm(i);
        if (view == null) {
            aVar = new a((byte) 0);
            view = View.inflate(viewGroup.getContext(), R.i.dgP, null);
            aVar.lUV = view.findViewById(R.h.bYF);
            aVar.lgz = (TextView) view.findViewById(R.h.cyA);
            aVar.lUW = view.findViewById(R.h.caL);
            aVar.jCP = (ImageView) view.findViewById(R.h.coK);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (pm == null) {
            charSequence = "";
        } else {
            String cK = !bh.ov(pm.gfN) ? pm.gfN : !bh.ov(pm.gfO) ? pm.gfO : pm.field_mac != 0 ? com.tencent.mm.plugin.exdevice.j.b.cK(pm.field_mac) : !bh.ov(pm.field_deviceID) ? pm.field_deviceID : null;
            charSequence = bh.ou(cK);
        }
        x.d("MicroMsg.ExdeviceManageDeviceUI", "position(%s), name(%s), mac(%s).", new Object[]{Integer.valueOf(i), charSequence, Long.valueOf(pm.field_mac)});
        aVar.lgz.setText(charSequence);
        o.PA().a(pm.iconUrl, aVar.jCP, this.lRR);
        aVar.lUW.setTag(Integer.valueOf(i));
        if (this.lUO) {
            aVar.lUW.setVisibility(0);
        } else {
            aVar.lUW.setVisibility(8);
        }
        aVar.lUV.setTag(Integer.valueOf(i));
        aVar.lUV.setOnClickListener(this.lUQ);
        return view;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar == null) {
            x.e("MicroMsg.ExdeviceManageDeviceUI", "scene is null.");
        } else if (kVar instanceof com.tencent.mm.plugin.exdevice.model.x) {
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            if (i == 0 && i2 == 0 && this.lUS >= 0 && this.lUS < this.lRD.size()) {
                ag.y(new 6(this));
            }
        }
    }
}
