package com.tencent.mm.ui.chatting.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.a.g;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b extends android.support.v7.widget.RecyclerView.a {
    public static e yyu;
    public static f yyv = null;
    private Context mContext;
    public String yyw;

    public static class a extends t {
        public ImageView iip;
        public TextView iiq;
        public TextView ldK;
        public TextView lgz;
        public View mUL;

        public a(View view) {
            super(view);
            this.mUL = view;
            this.iip = (ImageView) view.findViewById(R.h.cgg);
            this.lgz = (TextView) view.findViewById(R.h.cgR);
            this.ldK = (TextView) view.findViewById(R.h.chn);
            this.iiq = (TextView) view.findViewById(R.h.cho);
            this.iiq.setSingleLine(false);
            this.iiq.setMaxLines(2);
            view.setOnClickListener(new 1(this));
            view.setOnLongClickListener(new 2(this));
        }

        public static void d(TextView textView, String str) {
            if (!bh.ov(str)) {
                textView.getContext();
                textView.setText(com.tencent.mm.bc.b.a(textView.getText(), str));
            }
        }
    }

    public static abstract class b {
        public String bgp;
        public String fpL;
        public long fqm;
        public String jRH;
        public long timestamp;
        public String title;
        public int type;
        public String username;
        Pattern yyy = Pattern.compile("[._a-zA-Z0-9]+");

        public b(long j, int i, String str, long j2, String str2, String str3, String str4, String str5) {
            this.timestamp = j;
            this.type = i;
            this.title = str;
            this.fqm = j2;
            this.username = str2;
            this.fpL = str3;
            this.bgp = str4;
            this.jRH = str5;
        }

        public int getType() {
            return this.type;
        }

        public boolean Zf(String str) {
            if (Zg(str)) {
                if (!bh.ov(this.title) && this.title.toLowerCase().contains(str)) {
                    return true;
                }
                if (!bh.ov(this.fpL) && this.fpL.toLowerCase().contains(str)) {
                    return true;
                }
                if (!bh.ov(this.jRH) && this.jRH.toLowerCase().contains(str)) {
                    return true;
                }
                if (!bh.ov(this.bgp) && this.bgp.toLowerCase().contains(str)) {
                    return true;
                }
            } else if (!bh.ov(this.title) && fN(str, this.title.toLowerCase())) {
                return true;
            } else {
                if (!bh.ov(this.fpL) && fN(str, this.fpL.toLowerCase())) {
                    return true;
                }
                if (!bh.ov(this.jRH) && fN(str, this.jRH.toLowerCase())) {
                    return true;
                }
                if (!bh.ov(this.bgp) && fN(str, this.bgp.toLowerCase())) {
                    return true;
                }
            }
            return false;
        }

        public final boolean fN(String str, String str2) {
            if (bh.ov(str2)) {
                return false;
            }
            Matcher matcher = this.yyy.matcher(str2);
            boolean z = false;
            while (matcher.find()) {
                z = matcher.group().startsWith(str);
                x.i("MicroMsg.MediaHistoryListAdapter", "[isContains] search:%s group:%s", new Object[]{str, r3});
                if (z) {
                    return z;
                }
            }
            return z;
        }

        public static boolean Zg(String str) {
            char[] toCharArray = str.toCharArray();
            int i = 0;
            while (i < toCharArray.length) {
                if (toCharArray[i] >= '一' && toCharArray[i] <= '龻') {
                    return true;
                }
                i++;
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof b)) {
                return super.equals(obj);
            }
            return this.fqm == ((b) obj).fqm;
        }
    }

    public class d extends t {
        TextView ihT;
        final /* synthetic */ b yyz;

        public d(b bVar, View view) {
            this.yyz = bVar;
            super(view);
            this.ihT = (TextView) view.findViewById(R.h.cao);
            this.ihT.setTextColor(bVar.mContext.getResources().getColor(R.e.bsm));
            view.findViewById(R.h.content).setBackgroundColor(bVar.mContext.getResources().getColor(R.e.bsl));
        }
    }

    public b(Context context, f fVar) {
        yyv = fVar;
        this.mContext = context;
    }

    public final int getItemViewType(int i) {
        return yyv.FD(i).getType();
    }

    public final t a(ViewGroup viewGroup, int i) {
        if (i == Integer.MAX_VALUE) {
            return new d(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.i.djp, viewGroup, false));
        }
        return yyv.l(viewGroup);
    }

    public final void a(t tVar, int i) {
        int itemViewType = getItemViewType(i);
        b FD = yyv.FD(i);
        if (itemViewType == Integer.MAX_VALUE) {
            b FD2 = yyv.FD(i + 1);
            if (i == getItemCount() - 1 || gc(FD2.timestamp) != gc(FD.timestamp)) {
                ((d) tVar).ihT.setVisibility(8);
                return;
            }
            ((d) tVar).ihT.setVisibility(0);
            ((d) tVar).ihT.setText(com.tencent.mm.ui.gridviewheaders.a.cxk().a(new Date(FD.timestamp), this.mContext));
            return;
        }
        a aVar = (a) tVar;
        aVar.mUL.setTag(Integer.valueOf(i));
        if (itemViewType != 33) {
            com.tencent.mm.pluginsdk.ui.a.b.a(aVar.iip, FD.username);
        }
        TextView textView = aVar.lgz;
        Context context = this.mContext;
        CharSequence charSequence = bh.ov(this.yyw) ? bh.ov(FD.bgp) ? bh.ov(FD.jRH) ? FD.fpL : FD.jRH : FD.bgp : bh.ov(FD.bgp) ? !bh.ov(FD.jRH) ? (bh.ov(FD.fpL) || !FD.fpL.contains(this.yyw)) ? FD.jRH : FD.jRH + "(" + FD.fpL + ")" : FD.fpL : (bh.ov(FD.jRH) || !FD.jRH.contains(this.yyw)) ? (bh.ov(FD.fpL) || !FD.fpL.contains(this.yyw)) ? FD.bgp : FD.bgp + "(" + FD.fpL + ")" : FD.bgp + "(" + FD.jRH + ")";
        textView.setText(i.b(context, charSequence, aVar.lgz.getTextSize()));
        aVar.ldK.setText(g.e(this.mContext, FD.timestamp));
        aVar.iiq.setText(FD.title);
        yyv.a((a) tVar, i);
        if (!bh.ov(this.yyw)) {
            a.d(aVar.lgz, this.yyw);
            a.d(aVar.iiq, this.yyw);
        }
    }

    public final int getItemCount() {
        boolean z;
        int count = yyv == null ? 0 : yyv.getCount();
        String str = "MicroMsg.MediaHistoryListAdapter";
        String str2 = " null == mIDetail?%s getItemCount:%s";
        Object[] objArr = new Object[2];
        if (yyv == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(count);
        x.i(str, str2, objArr);
        return count;
    }

    private static long gc(long j) {
        return com.tencent.mm.ui.gridviewheaders.a.cxk().b(new Date(j));
    }
}
