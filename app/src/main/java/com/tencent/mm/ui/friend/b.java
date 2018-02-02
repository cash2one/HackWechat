package com.tencent.mm.ui.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.wh;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.LinkedList;

final class b extends BaseAdapter {
    private LinkedList<ate> hdX;
    private boolean[] ily;
    private final LayoutInflater nny;
    boolean zcA;
    LinkedList<wh> zcz;

    public b(LayoutInflater layoutInflater) {
        this.nny = layoutInflater;
    }

    public final void jf(int i) {
        if (i >= 0 && i < this.ily.length) {
            this.ily[i] = !this.ily[i];
            super.notifyDataSetChanged();
        }
    }

    public final void h(LinkedList<ate> linkedList, int i) {
        if (i < 0) {
            this.hdX = linkedList;
        } else {
            this.hdX = new LinkedList();
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                if (i == ((ate) linkedList.get(i2)).wgF) {
                    this.hdX.add(linkedList.get(i2));
                }
            }
        }
        this.ily = new boolean[this.hdX.size()];
    }

    public final String[] cwU() {
        int i = 0;
        int i2 = 0;
        for (boolean z : this.ily) {
            if (z) {
                i2++;
            }
        }
        String[] strArr = new String[i2];
        int i3 = 0;
        while (i3 < this.hdX.size()) {
            if (this.ily[i3]) {
                int i4 = i + 1;
                strArr[i] = ((ate) this.hdX.get(i3)).ksU;
                i2 = i4;
            } else {
                i2 = i;
            }
            i3++;
            i = i2;
        }
        return strArr;
    }

    public final int getCount() {
        if (this.zcA) {
            if (this.zcz == null) {
                return 0;
            }
            return this.zcz.size();
        } else if (this.hdX != null) {
            return this.hdX.size();
        } else {
            return 0;
        }
    }

    public final Object getItem(int i) {
        if (this.zcA) {
            return this.zcz.get(i);
        }
        return this.hdX.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        a aVar2;
        if (this.zcA) {
            wh whVar = (wh) this.zcz.get(i);
            if (view == null || ((a) view.getTag()).type != 2) {
                view = this.nny.inflate(R.i.dlO, viewGroup, false);
                aVar = new a();
                aVar.type = 2;
                aVar.lgz = (TextView) view.findViewById(R.h.cEq);
                view.setTag(aVar);
                aVar2 = aVar;
            } else {
                aVar2 = (a) view.getTag();
            }
            aVar2.lgz.setText(whVar.wgG);
        } else {
            CharSequence charSequence;
            TextView textView;
            CharSequence charSequence2;
            String str;
            String[] split;
            ate com_tencent_mm_protocal_c_ate = (ate) this.hdX.get(i);
            if (view == null || ((a) view.getTag()).type != 1) {
                view = this.nny.inflate(R.i.dlN, viewGroup, false);
                aVar = new a();
                aVar.type = 1;
                aVar.kEZ = (TextView) view.findViewById(R.h.cqq);
                aVar.zcB = (TextView) view.findViewById(R.h.cqo);
                aVar.ilA = (CheckBox) view.findViewById(R.h.cqr);
                aVar.ilz = (TextView) view.findViewById(R.h.cqg);
                view.setTag(aVar);
                aVar2 = aVar;
            } else {
                aVar2 = (a) view.getTag();
            }
            if (af.OH().la(com_tencent_mm_protocal_c_ate.ksU)) {
                aVar2.ilz.setVisibility(0);
            } else {
                aVar2.ilz.setVisibility(8);
            }
            TextView textView2 = aVar2.kEZ;
            if (com_tencent_mm_protocal_c_ate != null) {
                charSequence = com_tencent_mm_protocal_c_ate.vXO;
                if (charSequence == null || charSequence.length() <= 0) {
                    charSequence = com_tencent_mm_protocal_c_ate.kub;
                    if (charSequence == null || charSequence.length() <= 0) {
                        charSequence = new o(com_tencent_mm_protocal_c_ate.lOd).toString();
                        if (charSequence == null || charSequence.length() <= 0) {
                            charSequence = com_tencent_mm_protocal_c_ate.vLN;
                            if (charSequence != null) {
                            }
                        }
                    }
                }
                textView2.setText(charSequence);
                textView = aVar2.zcB;
                if (com_tencent_mm_protocal_c_ate != null) {
                    if (com_tencent_mm_protocal_c_ate.wsC == 0) {
                        charSequence2 = com_tencent_mm_protocal_c_ate.ksU;
                    } else if (com_tencent_mm_protocal_c_ate.wsC == 2) {
                        charSequence2 = com_tencent_mm_protocal_c_ate.ksU;
                    } else if (com_tencent_mm_protocal_c_ate.wsC == 1) {
                        str = com_tencent_mm_protocal_c_ate.ksU;
                        if (!bh.ov(str)) {
                            split = str.split("@");
                            charSequence2 = (split != null || split.length < 2 || bh.ov(split[0])) ? "" : "@" + split[0];
                        }
                    }
                    textView.setText(charSequence2);
                    aVar2.ilA.setChecked(this.ily[i]);
                }
                charSequence2 = "";
                textView.setText(charSequence2);
                aVar2.ilA.setChecked(this.ily[i]);
            }
            charSequence = "";
            textView2.setText(charSequence);
            textView = aVar2.zcB;
            if (com_tencent_mm_protocal_c_ate != null) {
                if (com_tencent_mm_protocal_c_ate.wsC == 0) {
                    charSequence2 = com_tencent_mm_protocal_c_ate.ksU;
                } else if (com_tencent_mm_protocal_c_ate.wsC == 2) {
                    charSequence2 = com_tencent_mm_protocal_c_ate.ksU;
                } else if (com_tencent_mm_protocal_c_ate.wsC == 1) {
                    str = com_tencent_mm_protocal_c_ate.ksU;
                    if (bh.ov(str)) {
                        split = str.split("@");
                        if (split != null) {
                        }
                    }
                }
                textView.setText(charSequence2);
                aVar2.ilA.setChecked(this.ily[i]);
            }
            charSequence2 = "";
            textView.setText(charSequence2);
            aVar2.ilA.setChecked(this.ily[i]);
        }
        return view;
    }
}
