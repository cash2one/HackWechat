package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.protocal.c.aof;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class a extends BaseAdapter {
    String ibD = "";
    Context mContext;
    OnClickListener mtg;
    protected String oPG = "";
    boolean oPK = false;
    ArrayList<com.tencent.mm.plugin.nearlife.b.a> oPL = new ArrayList();
    HashSet<String> oPM = new HashSet();
    ArrayList<LatLongData> oPN = null;
    private Map<LatLongData, bdn> oPO;
    private Map<LatLongData, Integer> oPP;
    Map<String, LatLongData> oPQ;
    LatLongData oPR;
    boolean oPS = true;
    int oPT = 0;

    public /* synthetic */ Object getItem(int i) {
        return tS(i);
    }

    public a(Context context, OnClickListener onClickListener, String str, boolean z) {
        this.mContext = context;
        this.mtg = onClickListener;
        this.ibD = str;
        this.oPK = z;
        this.oPN = new ArrayList();
        this.oPO = new HashMap();
        this.oPP = new HashMap();
        this.oPQ = new HashMap();
    }

    public final void bfc() {
        this.oPL.clear();
        this.oPM.clear();
        this.oPP.clear();
        this.oPO.clear();
        this.oPQ.clear();
        this.oPT = 0;
        notifyDataSetChanged();
    }

    public final void a(com.tencent.mm.plugin.nearlife.b.a aVar, int i) {
        if (!this.oPM.contains(aVar.oPt) && i <= this.oPL.size()) {
            this.oPL.add(i, aVar);
            this.oPM.add(aVar.oPt);
            this.oPQ.put(aVar.oPt, this.oPR);
        }
    }

    public final void a(LatLongData latLongData, List<com.tencent.mm.plugin.nearlife.b.a> list) {
        x.i("MicroMsg.BaseLifeAdapter", "mkey %s addlifes %d", new Object[]{this.ibD, Integer.valueOf(list.size())});
        for (com.tencent.mm.plugin.nearlife.b.a aVar : list) {
            if (!this.oPM.contains(aVar.oPt)) {
                this.oPL.add(aVar);
                this.oPM.add(aVar.oPt);
                this.oPQ.put(aVar.oPt, latLongData);
            }
        }
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.oPL.size();
    }

    public final com.tencent.mm.plugin.nearlife.b.a tS(int i) {
        if (i < 0 || i >= this.oPL.size()) {
            return new com.tencent.mm.plugin.nearlife.b.a("", new aof());
        }
        return (com.tencent.mm.plugin.nearlife.b.a) this.oPL.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    public static String bj(List<bdo> list) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            bdo com_tencent_mm_protocal_c_bdo = (bdo) list.get(i);
            if (!(com_tencent_mm_protocal_c_bdo == null || com_tencent_mm_protocal_c_bdo.wJF == null || com_tencent_mm_protocal_c_bdo.wJF.equals("") || com_tencent_mm_protocal_c_bdo.wJF.toLowerCase().equals("null"))) {
                stringBuffer.append(com_tencent_mm_protocal_c_bdo.wJF);
                if (i < list.size() - 1) {
                    stringBuffer.append("·");
                }
            }
        }
        return stringBuffer.toString();
    }

    public final void GA(String str) {
        if (str != null) {
            this.oPG = str;
        }
    }

    public final String bfd() {
        return this.oPG;
    }

    public final void I(ArrayList<LatLongData> arrayList) {
        if (arrayList != null) {
            this.oPN = arrayList;
        }
    }

    public final bdn a(LatLongData latLongData) {
        if (this.oPO.containsKey(latLongData)) {
            return (bdn) this.oPO.get(latLongData);
        }
        return null;
    }

    public final int b(LatLongData latLongData) {
        if (this.oPP.containsKey(latLongData)) {
            return ((Integer) this.oPP.get(latLongData)).intValue();
        }
        return 1;
    }

    public final boolean bfe() {
        Iterator it = this.oPN.iterator();
        while (it.hasNext()) {
            if (b((LatLongData) it.next()) > 0) {
                return true;
            }
        }
        if (this.oPS) {
            return b(this.oPR) > 0;
        } else {
            return false;
        }
    }

    public final void a(LatLongData latLongData, int i, bdn com_tencent_mm_protocal_c_bdn) {
        int i2 = 0;
        String str = "MicroMsg.BaseLifeAdapter";
        String str2 = "set flag & buf, lat:%f long:%f flag:%d len:%d";
        Object[] objArr = new Object[4];
        objArr[0] = Float.valueOf(latLongData.fzt);
        objArr[1] = Float.valueOf(latLongData.hBL);
        objArr[2] = Integer.valueOf(i);
        if (com_tencent_mm_protocal_c_bdn != null) {
            i2 = com_tencent_mm_protocal_c_bdn.wJB;
        }
        objArr[3] = Integer.valueOf(i2);
        x.d(str, str2, objArr);
        if (this.oPN.contains(latLongData) || (this.oPR != null && this.oPR.equals(latLongData))) {
            this.oPP.put(latLongData, Integer.valueOf(i));
            this.oPO.put(latLongData, com_tencent_mm_protocal_c_bdn);
        }
    }

    public final LatLongData GB(String str) {
        if (this.oPQ.containsKey(str)) {
            return (LatLongData) this.oPQ.get(str);
        }
        return null;
    }

    public final int GC(String str) {
        Iterator it = this.oPL.iterator();
        int i = -1;
        while (it.hasNext()) {
            i++;
            if (((com.tencent.mm.plugin.nearlife.b.a) it.next()).oPt.equals(str)) {
                break;
            }
        }
        return i;
    }
}
