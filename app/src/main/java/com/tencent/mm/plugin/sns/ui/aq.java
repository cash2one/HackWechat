package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.AnimatedExpandableListView.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class aq extends a {
    public static int[] rCN = new int[]{j.qLr, j.qLp, j.qLl, j.qLe};
    public static int[] rDj = new int[]{j.qLs, j.qLq, j.qLm, j.qLf};
    private LayoutInflater DF;
    private Context mContext;
    ArrayList<String> rDk;
    public int rDl = 0;
    public boolean rDm = false;
    public ArrayList<String> rDn = new ArrayList();
    public ArrayList<String> rDo = new ArrayList();
    public ArrayList<String> rDp = new ArrayList();
    public ArrayList<String> rDq = new ArrayList();
    public int style;

    public aq(Context context) {
        this.mContext = context;
        this.DF = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public final Object getChild(int i, int i2) {
        return this.rDk.get(i2);
    }

    public final long getChildId(int i, int i2) {
        return 0;
    }

    public final void Q(ArrayList<String> arrayList) {
        List<String> bBm = bBm();
        Object arrayList2 = new ArrayList();
        if (!(bBm == null || arrayList == null)) {
            for (String str : bBm) {
                if (j(arrayList, str)) {
                    arrayList.remove(str);
                    arrayList2.add(str);
                }
            }
            arrayList.addAll(0, arrayList2);
            String str2 = bh.d(arrayList2, ",");
            g.Dk();
            g.Dj().CU().set(335875, str2);
        }
        this.rDk = arrayList;
    }

    private static List<String> bBm() {
        g.Dk();
        String str = (String) g.Dj().CU().get(335875, null);
        x.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "dz:getTopFive : %s", new Object[]{str});
        if (bh.ov(str)) {
            return null;
        }
        return bh.F(str.split(","));
    }

    public static void LX(String str) {
        x.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "recordTopFive : %s", new Object[]{str});
        if (bBm() != null) {
            List arrayList = new ArrayList(bBm());
            if (!j(arrayList, str)) {
                if (arrayList.size() == 5) {
                    arrayList.remove(4);
                }
                arrayList.add(0, str);
                String d = bh.d(arrayList, ",");
                g.Dk();
                g.Dj().CU().set(335875, d);
                return;
            }
            return;
        }
        g.Dk();
        g.Dj().CU().set(335875, str);
    }

    private CharSequence LY(String str) {
        List<String> Dr = com.tencent.mm.plugin.label.a.a.aUX().Dr(com.tencent.mm.plugin.label.a.a.aUX().Do(str));
        if (Dr == null || Dr.size() == 0) {
            return "";
        }
        List arrayList = new ArrayList(Dr.size());
        for (String gu : Dr) {
            arrayList.add(((b) g.h(b.class)).gu(gu));
        }
        return i.a(this.mContext, bh.d(arrayList, ","));
    }

    private static boolean j(List<String> list, String str) {
        for (String equals : list) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean aG(int i, String str) {
        if (i == 1) {
            return j(this.rDn, str);
        }
        return j(this.rDo, str);
    }

    public final Object getGroup(int i) {
        return null;
    }

    public final int getGroupCount() {
        return 4;
    }

    public final long getGroupId(int i) {
        return 0;
    }

    public final View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || !(view.getTag() instanceof a)) {
            View inflate;
            if (this.style == 1) {
                inflate = this.DF.inflate(com.tencent.mm.plugin.sns.i.g.qHx, null);
            } else {
                inflate = this.DF.inflate(com.tencent.mm.plugin.sns.i.g.qHw, null);
            }
            a aVar2 = new a(this, (byte) 0);
            aVar2.titleView = (TextView) inflate.findViewById(f.qEH);
            aVar2.olD = (ImageView) inflate.findViewById(f.qED);
            aVar2.nXu = (TextView) inflate.findViewById(f.qEG);
            inflate.setTag(aVar2);
            view = inflate;
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.titleView.setText(rCN[i]);
        aVar.nXu.setText(rDj[i]);
        switch (i) {
            case 0:
            case 1:
                if (this.rDl == i) {
                    aVar.olD.setImageResource(com.tencent.mm.plugin.sns.i.i.dAr);
                    aVar.olD.setContentDescription(this.mContext.getString(j.qJK));
                    break;
                }
                aVar.olD.setImageResource(com.tencent.mm.plugin.sns.i.i.dAq);
                break;
            case 2:
                if (this.rDl == i) {
                    aVar.olD.setImageResource(com.tencent.mm.plugin.sns.i.i.dAr);
                    aVar.olD.setContentDescription(this.mContext.getString(j.qJK));
                    break;
                }
                aVar.olD.setImageResource(com.tencent.mm.plugin.sns.i.i.dAq);
                break;
            case 3:
                if (this.style != 1) {
                    if (this.rDl == i) {
                        aVar.olD.setImageResource(com.tencent.mm.plugin.sns.i.i.qIQ);
                        aVar.olD.setContentDescription(this.mContext.getString(j.qJK));
                        break;
                    }
                    aVar.olD.setImageResource(com.tencent.mm.plugin.sns.i.i.dAq);
                    break;
                } else if (this.rDl == i) {
                    aVar.olD.setImageResource(com.tencent.mm.plugin.sns.i.i.qIR);
                    aVar.olD.setContentDescription(this.mContext.getString(j.qJK));
                    break;
                } else {
                    aVar.olD.setImageResource(com.tencent.mm.plugin.sns.i.i.dAq);
                    break;
                }
        }
        if (!this.rDm || i != 1) {
            return view;
        }
        view = new View(this.mContext);
        view.setVisibility(8);
        return view;
    }

    public final boolean hasStableIds() {
        return false;
    }

    public final boolean isChildSelectable(int i, int i2) {
        return true;
    }

    private static List<String> ar(List<String> list) {
        List<String> linkedList = new LinkedList();
        g.Dk();
        if (!g.Dh().Cy()) {
            return linkedList;
        }
        if (list == null) {
            return linkedList;
        }
        for (Object obj : list) {
            Object obj2;
            g.Dk();
            com.tencent.mm.l.a WO = ((h) g.h(h.class)).EY().WO(obj2);
            if (!(WO == null || ((int) WO.gJd) == 0)) {
                obj2 = WO.AQ();
            }
            linkedList.add(obj2);
        }
        return linkedList;
    }

    public final View d(int i, int i2, View view) {
        a aVar;
        if (view == null) {
            View inflate;
            if (this.style == 1) {
                inflate = this.DF.inflate(com.tencent.mm.plugin.sns.i.g.qHv, null);
            } else {
                inflate = this.DF.inflate(com.tencent.mm.plugin.sns.i.g.qHu, null);
            }
            a aVar2 = new a(this, (byte) 0);
            aVar2.titleView = (TextView) inflate.findViewById(f.qEH);
            aVar2.nXu = (TextView) inflate.findViewById(f.qEG);
            aVar2.rDr = (TextView) inflate.findViewById(f.qEF);
            aVar2.rDs = (TextView) inflate.findViewById(f.qEE);
            aVar2.olD = (ImageView) inflate.findViewById(f.qED);
            inflate.setTag(aVar2);
            view = inflate;
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (i2 == this.rDk.size()) {
            aVar.titleView.setVisibility(8);
            aVar.nXu.setVisibility(8);
            aVar.olD.setVisibility(8);
            aVar.rDr.setVisibility(0);
            aVar.rDs.setVisibility(0);
            if (i == 3) {
                if (this.rDq.size() > 0) {
                    aVar.rDs.setText("√" + bh.d(ar(this.rDq), ","));
                    aVar.rDs.setVisibility(0);
                    aVar.rDs.setTextColor(this.mContext.getResources().getColor(c.qyC));
                } else {
                    aVar.rDs.setText("");
                    aVar.rDs.setVisibility(8);
                }
            } else if (i == 2) {
                if (this.rDp.size() > 0) {
                    aVar.rDs.setText("√" + bh.d(ar(this.rDp), ","));
                    aVar.rDs.setVisibility(0);
                    aVar.rDs.setTextColor(this.mContext.getResources().getColor(c.qyB));
                } else {
                    aVar.rDs.setText("");
                    aVar.rDs.setVisibility(8);
                }
            }
        } else {
            aVar.titleView.setVisibility(0);
            aVar.nXu.setVisibility(0);
            aVar.olD.setVisibility(0);
            aVar.rDr.setVisibility(8);
            aVar.rDs.setVisibility(8);
            String str = (String) this.rDk.get(i2);
            aVar.titleView.setText(i.a(this.mContext, str));
            aVar.nXu.setText(LY(str));
            aVar.olD.setVisibility(0);
            if (this.style == 1) {
                if (i == 2) {
                    if (aG(1, str)) {
                        aVar.olD.setImageResource(com.tencent.mm.plugin.sns.i.i.dAL);
                    } else {
                        aVar.olD.setImageResource(com.tencent.mm.plugin.sns.i.i.dAM);
                    }
                } else if (i == 3) {
                    if (this.rDl != i) {
                        aVar.olD.setImageResource(com.tencent.mm.plugin.sns.i.i.qIZ);
                    } else {
                        aVar.olD.setImageResource(com.tencent.mm.plugin.sns.i.i.qIY);
                    }
                    if (aG(2, str)) {
                        aVar.olD.setImageResource(com.tencent.mm.plugin.sns.i.i.qIY);
                    } else {
                        aVar.olD.setImageResource(com.tencent.mm.plugin.sns.i.i.qIZ);
                    }
                }
            } else if (i == 2) {
                if (aG(1, str)) {
                    aVar.olD.setImageResource(com.tencent.mm.plugin.sns.i.i.dxO);
                } else {
                    aVar.olD.setImageResource(com.tencent.mm.plugin.sns.i.i.dxP);
                }
            } else if (i == 3) {
                if (aG(2, str)) {
                    aVar.olD.setImageResource(com.tencent.mm.plugin.sns.i.i.qIE);
                } else {
                    aVar.olD.setImageResource(com.tencent.mm.plugin.sns.i.i.dxP);
                }
            }
        }
        return view;
    }

    public final int xI(int i) {
        if (i <= 1 || this.rDk == null) {
            return 0;
        }
        return this.rDk.size() + 1;
    }
}
