package com.tencent.mm.modelfriend;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.protocal.c.aou;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.applet.b;
import com.tencent.mm.ui.applet.b.a;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j extends BaseAdapter {
    private Context context;
    public LinkedList<aou> hvO = new LinkedList();
    private LinkedList<aou> hvP = new LinkedList();
    public List<String[]> hvQ;
    private List<String[]> hvR = new LinkedList();
    public int[] hvS;
    private a hvT;
    public b hvU = new b(new a(this) {
        final /* synthetic */ j hvW;

        {
            this.hvW = r1;
        }

        public final Bitmap kX(String str) {
            return com.tencent.mm.ad.b.a(str, false, -1);
        }
    });
    private b.b hvV = null;
    int showType = 1;

    public final /* synthetic */ Object getItem(int i) {
        return hB(i);
    }

    public j(Context context, a aVar, int i) {
        this.context = context;
        this.showType = i;
        this.hvT = aVar;
        this.hvS = new int[this.hvO.size()];
    }

    public final int NH() {
        int i = 0;
        for (int i2 : this.hvS) {
            if (this.showType == 1) {
                if (i2 == 1) {
                    i++;
                }
            } else if (this.showType == 2 && i2 == 2) {
                i++;
            }
        }
        return i;
    }

    public final boolean NI() {
        if (this.hvS == null || this.hvS.length == 0) {
            return false;
        }
        for (int i : this.hvS) {
            if (this.showType == 1) {
                if (i == 0) {
                    return false;
                }
            } else if (this.showType == 2 && i == 0) {
                return false;
            }
        }
        return true;
    }

    public final void hA(int i) {
        if (this.showType == 1) {
            this.hvS[i] = 1;
        } else if (this.showType == 2) {
            this.hvS[i] = 2;
        }
        notifyDataSetChanged();
    }

    public final void bN(boolean z) {
        int i;
        int i2;
        if (this.showType == 1) {
            for (i = 0; i < this.hvS.length; i++) {
                int[] iArr = this.hvS;
                if (z) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                iArr[i] = i2;
            }
        } else if (this.showType == 2) {
            for (i = 0; i < this.hvS.length; i++) {
                int[] iArr2 = this.hvS;
                if (z) {
                    i2 = 2;
                } else {
                    i2 = 0;
                }
                iArr2[i] = i2;
            }
        }
        notifyDataSetChanged();
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        if (this.hvT != null) {
            this.hvT.notifyDataSetChanged();
        }
    }

    public final void e(LinkedList<aou> linkedList) {
        if (linkedList != null) {
            this.hvP.clear();
            this.hvO.clear();
            this.hvR.clear();
            for (String[] strArr : this.hvQ) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    aou com_tencent_mm_protocal_c_aou = (aou) it.next();
                    if (this.showType == 1) {
                        if ((com_tencent_mm_protocal_c_aou.ktm == 1 || com_tencent_mm_protocal_c_aou.ktm == 0) && !bh.ov(strArr[2]) && com_tencent_mm_protocal_c_aou.pQt.equals(g.s(strArr[2].getBytes()))) {
                            a(com_tencent_mm_protocal_c_aou, strArr);
                        }
                    } else if (this.showType == 2 && com_tencent_mm_protocal_c_aou.ktm == 2 && !bh.ov(strArr[2]) && com_tencent_mm_protocal_c_aou.pQt.equals(g.s(strArr[2].getBytes()))) {
                        a(com_tencent_mm_protocal_c_aou, strArr);
                    }
                }
            }
        }
        this.hvS = new int[this.hvP.size()];
        this.hvO.addAll(this.hvP);
        this.hvP.clear();
    }

    private void a(aou com_tencent_mm_protocal_c_aou, String[] strArr) {
        Iterator it = this.hvP.iterator();
        while (it.hasNext()) {
            aou com_tencent_mm_protocal_c_aou2 = (aou) it.next();
            if (com_tencent_mm_protocal_c_aou2.pQt != null && com_tencent_mm_protocal_c_aou.pQt != null && com_tencent_mm_protocal_c_aou2.pQt.equals(com_tencent_mm_protocal_c_aou.pQt)) {
                x.d("MicroMsg.FriendAdapter", "tigerreg mobile already added");
                return;
            }
        }
        this.hvP.add(com_tencent_mm_protocal_c_aou);
        this.hvR.add(new String[]{strArr[2], strArr[1]});
    }

    public final int getCount() {
        return this.hvO.size();
    }

    public final aou hB(int i) {
        return (aou) this.hvO.get(i);
    }

    public final long getItemId(int i) {
        return (long) ((aou) this.hvO.get(i)).hashCode();
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (this.showType == 1) {
            if (this.hvV == null) {
                this.hvV = new 2(this);
            }
            if (this.hvU != null) {
                this.hvU.a(i, this.hvV);
            }
        }
        aou com_tencent_mm_protocal_c_aou = (aou) this.hvO.get(i);
        if (view == null) {
            bVar = new b();
            if (this.showType == 1) {
                view = View.inflate(this.context, R.i.dic, null);
                bVar.hvZ = (TextView) view.findViewById(R.h.cwD);
                bVar.hwa = (TextView) view.findViewById(R.h.cww);
                bVar.hwb = (Button) view.findViewById(R.h.cwx);
                bVar.hwc = (Button) view.findViewById(R.h.cwz);
                bVar.hvY = (ImageView) view.findViewById(R.h.cjU);
                bVar.hwd = (TextView) view.findViewById(R.h.cwE);
                bVar.hwe = (TextView) view.findViewById(R.h.cwH);
                view.setTag(bVar);
            } else if (this.showType == 2) {
                view = View.inflate(this.context, R.i.did, null);
                bVar.hvZ = (TextView) view.findViewById(R.h.cwD);
                bVar.hwa = (TextView) view.findViewById(R.h.cww);
                bVar.hwb = (Button) view.findViewById(R.h.cwx);
                bVar.hwc = (Button) view.findViewById(R.h.cwz);
                bVar.hwd = (TextView) view.findViewById(R.h.cwE);
                bVar.hwe = (TextView) view.findViewById(R.h.cwH);
                view.setTag(bVar);
            }
        } else {
            bVar = (b) view.getTag();
        }
        bVar.hwe.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ j hvW;

            public final void onClick(View view) {
                j jVar = this.hvW;
                int i = i;
                if (jVar.showType == 1) {
                    jVar.hvS[i] = 0;
                } else if (jVar.showType == 2) {
                    jVar.hvS[i] = 0;
                }
                jVar.notifyDataSetChanged();
            }
        });
        if (this.showType == 1) {
            if (!bh.ov(((String[]) this.hvR.get(i))[1])) {
                bVar.hvZ.setText(((String[]) this.hvR.get(i))[1]);
            } else if (bh.ov(com_tencent_mm_protocal_c_aou.kub)) {
                bVar.hvZ.setText(com_tencent_mm_protocal_c_aou.ksU);
            } else {
                bVar.hvZ.setText(com_tencent_mm_protocal_c_aou.kub);
            }
            bVar.hwb.setOnClickListener(new 4(this, i));
            com.tencent.mm.pluginsdk.ui.a.b.a(bVar.hvY, com_tencent_mm_protocal_c_aou.ksU);
        } else if (this.showType == 2) {
            bVar.hvZ.setText(((String[]) this.hvR.get(i))[1]);
            bVar.hwc.setOnClickListener(new 5(this, i));
        }
        switch (this.hvS[i]) {
            case 0:
                if (this.showType != 1) {
                    if (this.showType == 2) {
                        bVar.hwa.setVisibility(8);
                        bVar.hwb.setVisibility(8);
                        bVar.hwc.setVisibility(0);
                        bVar.hwd.setVisibility(8);
                        bVar.hwe.setVisibility(8);
                        break;
                    }
                }
                bVar.hwa.setVisibility(8);
                bVar.hwb.setVisibility(0);
                bVar.hwc.setVisibility(8);
                bVar.hwd.setVisibility(8);
                bVar.hwe.setVisibility(8);
                break;
                break;
            case 1:
                bVar.hwb.setVisibility(8);
                bVar.hwa.setVisibility(0);
                bVar.hwd.setVisibility(0);
                bVar.hwe.setVisibility(0);
                break;
            case 2:
                bVar.hwb.setVisibility(8);
                bVar.hwc.setVisibility(8);
                bVar.hwa.setVisibility(0);
                bVar.hwd.setVisibility(0);
                bVar.hwe.setVisibility(0);
                break;
            case 3:
                bVar.hwb.setVisibility(8);
                bVar.hwa.setVisibility(0);
                bVar.hwd.setVisibility(0);
                bVar.hwe.setVisibility(0);
                break;
        }
        return view;
    }

    public final void kW(String str) {
        List arrayList = new ArrayList();
        for (int i = 0; i < this.hvR.size(); i++) {
            if (this.hvS[i] == 2) {
                arrayList.add(((String[]) this.hvR.get(i))[0]);
            }
        }
        ar.CG().a(new z(str, arrayList), 0);
    }
}
