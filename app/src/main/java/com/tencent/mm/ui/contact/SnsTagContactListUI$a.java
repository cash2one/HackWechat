package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.sns.b.k;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.contact.SnsTagContactListUI.b;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

class SnsTagContactListUI$a extends BaseAdapter {
    private Context context = null;
    private ar rzI = null;
    private Map<Integer, a> yUN = new HashMap();
    private ColorStateList yUO;
    private ColorStateList yUP;
    private Map<Integer, String> yUV = new HashMap();

    public SnsTagContactListUI$a(Context context, List<Long> list) {
        this.context = context;
        this.yUN.clear();
        this.yUV.clear();
        com.tencent.mm.z.ar.Hg();
        this.rzI = c.EY();
        int i = 0;
        for (Long longValue : list) {
            long longValue2 = longValue.longValue();
            k kVar = n.qQB;
            if (kVar != null) {
                for (String str : kVar.eo(longValue2)) {
                    a aVar = new a();
                    aVar.setUsername(str);
                    this.yUV.put(Integer.valueOf(this.yUN.size()), kVar.ep(longValue2));
                    int i2 = i + 1;
                    this.yUN.put(Integer.valueOf(i), aVar);
                    i = i2;
                }
            }
            i = i;
        }
        try {
            XmlPullParser xml = context.getResources().getXml(R.e.bth);
            XmlPullParser xml2 = context.getResources().getXml(R.e.bti);
            this.yUO = ColorStateList.createFromXml(context.getResources(), xml);
            this.yUP = ColorStateList.createFromXml(context.getResources(), xml2);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsTagContactList", e, "", new Object[0]);
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.SnsTagContactList", e2, "", new Object[0]);
        }
    }

    public final int getCount() {
        return this.yUN.size();
    }

    public final Object getItem(int i) {
        if (i < 0) {
            return null;
        }
        a aVar = (a) this.yUN.get(Integer.valueOf(i));
        if (aVar.field_showHead != 0) {
            return aVar;
        }
        com.tencent.mm.storage.x WO = this.rzI.WO(aVar.field_username);
        if (WO == null) {
            return aVar;
        }
        this.yUN.put(Integer.valueOf(i), WO);
        return WO;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = View.inflate(this.context, R.i.deO, null);
            b bVar2 = new b((byte) 0);
            bVar2.nJd = (TextView) view.findViewById(R.h.bYz);
            bVar2.ldx = (MaskLayout) view.findViewById(R.h.bYx);
            bVar2.kEZ = (TextView) view.findViewById(R.h.bYB);
            bVar2.yUR = (TextView) view.findViewById(R.h.bYv);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        if (((a) getItem(i - 1)) == null) {
            Object obj = "";
        } else {
            String Gp = Gp(i - 1);
        }
        a aVar = (a) getItem(i);
        if (i == 0) {
            bVar.nJd.setVisibility(0);
            bVar.nJd.setText(Gp(i));
            bVar.nJd.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        } else if (i <= 0 || Gp(i).equals(r1)) {
            bVar.nJd.setVisibility(8);
        } else {
            bVar.nJd.setVisibility(0);
            bVar.nJd.setText(Gp(i));
            bVar.nJd.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        bVar.kEZ.setTextColor(!s.hn(aVar.field_username) ? this.yUO : this.yUP);
        com.tencent.mm.pluginsdk.ui.a.b.b((ImageView) bVar.ldx.view, aVar.field_username, true);
        bVar.yUR.setVisibility(8);
        bVar.ldx.setVisibility(0);
        bVar.kEZ.setText(i.b(this.context, aVar.AQ(), bVar.kEZ.getTextSize()));
        bVar.kEZ.setVisibility(0);
        return view;
    }

    private String Gp(int i) {
        if (this.yUV.containsKey(Integer.valueOf(i))) {
            return (String) this.yUV.get(Integer.valueOf(i));
        }
        return "";
    }
}
