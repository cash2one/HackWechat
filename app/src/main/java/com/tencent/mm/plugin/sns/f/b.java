package com.tencent.mm.plugin.sns.f;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i$c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.e;
import com.tencent.mm.plugin.sns.model.t;
import com.tencent.mm.plugin.sns.ui.SnsCommentUI;
import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.v;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b implements e {
    private boolean frp = true;
    Context mContext;
    private int qPd = -1;
    private Map<Long, b> qZA = new HashMap();
    private HashSet<Long> qZB = new HashSet();
    h qZC = null;
    private HashMap<Long, Boolean> qZD = new HashMap();
    public final int qZn = 14;
    private com.tencent.mm.plugin.sns.ui.b.b qZo;
    private FrameLayout qZp;
    AbsoluteLayout qZq = null;
    protected Animation qZr;
    protected Animation qZs;
    boolean qZt = false;
    int[] qZu = new int[]{j.qJT, j.qJU, j.qJV, j.qJW};
    private int[] qZv = new int[]{i.qIB, i.qID, i.qIC, i.qIA};
    private int[] qZw = this.qZu;
    private int[] qZx;
    private int[] qZy;
    Map<Long, b> qZz = new HashMap();

    class a {
        View qOe = null;
        long qQJ;
        final /* synthetic */ b qZH;
        String qZJ;
        com.tencent.mm.plugin.sns.storage.b qZK;

        public a(b bVar, String str, View view, long j, com.tencent.mm.plugin.sns.storage.b bVar2) {
            this.qZH = bVar;
            this.qZJ = str;
            this.qOe = view;
            this.qZK = bVar2;
            this.qQJ = j;
        }
    }

    static /* synthetic */ void a(b bVar, View view, View view2) {
        view.getTag();
        view2.setVisibility(0);
        bVar.qZt = true;
        bVar.qZr.setAnimationListener(new 4(bVar));
        view2.startAnimation(bVar.qZr);
    }

    public final void a(int i, String str, long j, String str2, bnp com_tencent_mm_protocal_c_bnp, boolean z, bf bfVar) {
        if (z && this.frp && this.qZC != null && bfVar != null) {
            this.qZB.add(Long.valueOf(j));
            this.qZA.put(Long.valueOf(j), new b(j, this.qZC.qZP, this.qZC.qZQ, bfVar.bCi()));
        }
    }

    public final void a(int i, String str, long j, String str2, bnp com_tencent_mm_protocal_c_bnp, boolean z) {
        if (z && this.frp) {
            if (this.qZB.contains(Long.valueOf(j))) {
                boolean z2 = false;
                if (this.qZD.containsKey(Long.valueOf(j))) {
                    z2 = ((Boolean) this.qZD.get(Long.valueOf(j))).booleanValue();
                }
                if (z2) {
                    b bVar = (b) this.qZA.get(Long.valueOf(j));
                    if (bVar != null) {
                        bVar.wW();
                    }
                }
            }
            this.qZA.remove(Long.valueOf(j));
            this.qZB.remove(Long.valueOf(j));
        }
    }

    public final void a(b bVar) {
        this.qZz.remove(Long.valueOf(bVar.hOu));
        bVar.wW();
    }

    public b(Context context, com.tencent.mm.plugin.sns.ui.b.b bVar, FrameLayout frameLayout) {
        g bvn = ae.bvn();
        h hVar = new h();
        c fn = com.tencent.mm.z.c.c.IF().fn("100007");
        if (fn.isValid()) {
            Map chI = fn.chI();
            if (chI != null) {
                x.i("MicroMsg.SnsABTestStrategy", "snsabtest feed " + fn.field_expId + " " + fn.field_layerId + " " + fn.field_startTime + " " + fn.field_endTime);
                hVar.d(fn.field_layerId, fn.field_expId, chI);
            }
        } else {
            x.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
            hVar = null;
        }
        bvn.raD = hVar;
        this.qZC = ae.bvn().bwo();
        if (this.qZC != null) {
            this.qZx = this.qZC.raF;
            if (!this.qZC.bwp()) {
                this.frp = false;
            }
        }
        this.mContext = context;
        this.qZo = bVar;
        this.qZp = frameLayout;
        this.qZr = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.qZr = AnimationUtils.loadAnimation(context, com.tencent.mm.plugin.sns.i.a.qyp);
        this.qZs = new ScaleAnimation(1.0f, 1.0f, 1.0f, 0.0f, 1, 1.0f, 1, 0.0f);
        this.qZs = AnimationUtils.loadAnimation(context, com.tencent.mm.plugin.sns.i.a.qyq);
    }

    public final int cx(View view) {
        if (this.qZt) {
            return 0;
        }
        if (this.qZq != null) {
            if (this.qZq.getTag() instanceof a) {
                final View view2 = ((a) this.qZq.getTag()).qOe;
                this.qZt = true;
                view2.startAnimation(this.qZs);
                this.qZs.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ b qZH;

                    public final void onAnimationStart(Animation animation) {
                        this.qZH.qZt = true;
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        if (view2 != null) {
                            view2.clearAnimation();
                            view2.setVisibility(8);
                            this.qZH.bwm();
                        }
                        this.qZH.qZt = false;
                    }
                });
            } else {
                bwm();
            }
            return 0;
        } else if (view.getTag() == null || !(view.getTag() instanceof com.tencent.mm.plugin.sns.data.b)) {
            return 0;
        } else {
            if (!this.frp || this.qZC == null) {
                return 2;
            }
            boolean booleanValue;
            int i;
            com.tencent.mm.plugin.sns.data.b bVar = (com.tencent.mm.plugin.sns.data.b) view.getTag();
            long j = bVar.qQJ;
            com.tencent.mm.plugin.sns.storage.b bVar2 = bVar.qQI.rMm;
            if (this.qZD.containsKey(Long.valueOf(j))) {
                booleanValue = ((Boolean) this.qZD.get(Long.valueOf(j))).booleanValue();
            } else if (this.qZC == null) {
                booleanValue = false;
            } else if (bVar2 == null) {
                booleanValue = false;
            } else {
                for (i = 0; i < this.qZC.ras.size(); i++) {
                    if (bh.ov(a((a) this.qZC.ras.get(i), bVar2.reT))) {
                        this.qZD.put(Long.valueOf(j), Boolean.valueOf(false));
                        booleanValue = false;
                        break;
                    }
                }
                this.qZD.put(Long.valueOf(j), Boolean.valueOf(true));
                booleanValue = true;
            }
            if (!booleanValue) {
                return 2;
            }
            int length;
            int i2;
            String str = bVar.frH;
            this.qZz.put(Long.valueOf(bVar.qQJ), new b(bVar.qQJ, bVar.qQI.bCi(), this.qZC.qZP, this.qZC.qZQ, this.mContext.getString(j.qKa)));
            if (this.qZB.contains(Long.valueOf(bVar.qQJ))) {
                this.qZB.remove(Long.valueOf(bVar.qQJ));
            }
            this.qZq = new AbsoluteLayout(this.mContext);
            this.qZq.setId(f.daa);
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            this.qZp.addView(this.qZq);
            View inflate = v.fv(this.mContext).inflate(g.qGs, null);
            r12 = new TextView[3];
            ImageView[] imageViewArr = new ImageView[]{(TextView) inflate.findViewById(f.qAj), (TextView) inflate.findViewById(f.qAo), (TextView) inflate.findViewById(f.qAn)};
            imageViewArr[0] = (ImageView) inflate.findViewById(f.qAk);
            imageViewArr[1] = (ImageView) inflate.findViewById(f.qAm);
            imageViewArr[2] = (ImageView) inflate.findViewById(f.qAl);
            i = 0;
            if (!t.eA(bVar.qQJ)) {
                for (int i3 : this.qZx) {
                    if (i3 == 3) {
                        i++;
                    }
                }
            }
            int i32 = 0;
            for (int i22 : this.qZx) {
                if (i22 == 0) {
                    i32++;
                }
            }
            if (i32 + i > 0) {
                length = (this.qZx.length - i32) - i;
                if (length == 0) {
                    return 2;
                }
                this.qZy = new int[length];
            } else {
                this.qZy = new int[this.qZx.length];
            }
            length = 0;
            i32 = 0;
            while (length < this.qZx.length) {
                if (this.qZx[length] != 0 && (i <= 0 || this.qZx[length] != 3)) {
                    this.qZy[i32] = this.qZx[length];
                    i32++;
                }
                length++;
            }
            if (t.ez(bVar.qQJ)) {
                for (length = 0; length < this.qZy.length; length++) {
                    if (this.qZy[length] == 3) {
                        this.qZy[length] = 4;
                        break;
                    }
                }
            }
            i = 0;
            int fromDPToPix = ((com.tencent.mm.bv.a.fromDPToPix(this.mContext, 12) * 2) + (com.tencent.mm.bv.a.fromDPToPix(this.mContext, 8) * 2)) + com.tencent.mm.bv.a.fromDPToPix(this.mContext, 12);
            for (int i4 = 0; i4 < this.qZy.length; i4++) {
                int i5;
                i32 = this.qZy[i4];
                i22 = this.qZy[i4] - 1;
                r12[i4].setText(this.qZw[i22]);
                TextView textView = r12[i4];
                Paint paint = new Paint();
                String charSequence = textView.getText().toString();
                paint.setTextSize(textView.getTextSize());
                length = ((int) paint.measureText(charSequence, 0, charSequence.length())) + fromDPToPix;
                if (length > i) {
                    i5 = length;
                } else {
                    i5 = i;
                }
                r12[i4].setCompoundDrawablePadding(com.tencent.mm.bv.a.fromDPToPix(this.mContext, 8));
                r12[i4].setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(this.qZv[i22]), null, null, null);
                if (i22 == 1) {
                    imageViewArr[i4].setVisibility(0);
                } else {
                    imageViewArr[i4].setVisibility(8);
                }
                r12[i4].setTag(bVar);
                r12[i4].setOnClickListener(new 1(this, i32, bVar, inflate, view));
                i = i5;
            }
            for (length = 0; length < this.qZy.length; length++) {
                r12[length].setMaxWidth(i);
            }
            for (length = this.qZy.length; length < 3; length++) {
                r12[length].setVisibility(8);
            }
            Rect rect = new Rect();
            length = com.tencent.mm.pluginsdk.e.ea(this.mContext);
            int[] bCj = bVar.qQI.bCj();
            x.d("MicroMsg.AdNotLikeAbTestHelper", "addCommentView getLocationInWindow " + bCj[0] + "  " + bCj[1] + " height: " + length);
            i += com.tencent.mm.bv.a.fromDPToPix(this.mContext, 12);
            i22 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.mContext, 17.0f);
            int b = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.mContext, 2.0f);
            this.qPd = com.tencent.mm.pluginsdk.e.eb(this.mContext);
            ViewGroup.LayoutParams layoutParams2 = new AbsoluteLayout.LayoutParams(i, -2, (bCj[0] - i) - b, ((bCj[1] - this.qPd) - length) + i22);
            this.qZq.setTag(new a(this, str, inflate, bVar.qQJ, bVar.qQI.rMm));
            this.qZq.addView(inflate, layoutParams2);
            inflate.setVisibility(8);
            this.qZt = true;
            new af().post(new 2(this, view, inflate));
            return 1;
        }
    }

    final void a(View view, AbsoluteLayout absoluteLayout, com.tencent.mm.plugin.sns.data.b bVar) {
        ViewGroup viewGroup = (ViewGroup) view;
        viewGroup.removeAllViews();
        if (this.qZC != null && bVar.qQI != null && bVar.qQI.rMm != null) {
            int i;
            com.tencent.mm.plugin.sns.storage.b bVar2 = bVar.qQI.rMm;
            Paint paint = new Paint(1);
            int b = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.mContext, 12.0f);
            int b2 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.mContext, 10.0f);
            int b3 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.mContext, 150.0f);
            List<TextView> linkedList = new LinkedList();
            float b4 = (((float) com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.mContext, 17.0f)) * com.tencent.mm.bv.a.eu(this.mContext)) + ((float) (b2 * 2));
            int i2 = (int) b4;
            int i3 = 0;
            for (i = 0; i < this.qZC.ras.size(); i++) {
                a aVar = (a) this.qZC.ras.get(i);
                final View textView = new TextView(this.mContext);
                textView.setPadding(b, b2, b, b2);
                textView.setTextSize(1, 14.0f * com.tencent.mm.bv.a.eu(this.mContext));
                textView.setTextColor(this.mContext.getResources().getColor(i$c.qyw));
                Object a = a(aVar, bVar2.reT);
                textView.setText(a);
                paint.setTextSize(textView.getTextSize());
                viewGroup.addView(textView);
                i3 = Math.max(i3, ((int) paint.measureText(a)) + (b * 2));
                textView.setTag(Integer.valueOf(i));
                linkedList.add(textView);
                final com.tencent.mm.plugin.sns.data.b bVar3 = bVar;
                textView.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ b qZH;

                    public final void onClick(View view) {
                        int intValue = ((Integer) view.getTag()).intValue();
                        b bVar = (b) this.qZH.qZz.get(Long.valueOf(bVar3.qQJ));
                        int i = ((a) this.qZH.qZC.ras.get(intValue)).qZi;
                        if (bVar != null) {
                            bVar.KN("3:" + i + ":" + textView.getText());
                        }
                        if (((a) this.qZH.qZC.ras.get(intValue)).qZm == 1) {
                            Intent intent = new Intent();
                            intent.setClass(this.qZH.mContext, SnsCommentUI.class);
                            intent.putExtra("sns_comment_type", 2);
                            intent.putExtra("sns_id", bVar3.qQJ);
                            intent.putExtra("sns_uxinfo", bVar.qZM);
                            intent.putExtra("action_st_time", bVar.qZN);
                            intent.putExtra("sns_actionresult", bVar.qZL.toString());
                            ((MMActivity) this.qZH.mContext).startActivity(intent);
                            this.qZH.qZz.remove(Long.valueOf(bVar3.qQJ));
                            this.qZH.bwm();
                            return;
                        }
                        this.qZH.a(bVar);
                        this.qZH.bwm();
                    }
                });
            }
            x.i("MicroMsg.AdNotLikeAbTestHelper", "w h " + i3 + " " + i2);
            if (i3 < b3) {
                i3 = b3;
            }
            for (TextView textView2 : linkedList) {
                ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = (int) b4;
                textView2.setLayoutParams(layoutParams);
            }
            Rect rect = new Rect();
            int ea = com.tencent.mm.pluginsdk.e.ea(this.mContext);
            int[] bCj = bVar.qQI.bCj();
            i = (bCj[0] - i3) - com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.mContext, 2.0f);
            int i4 = ((bCj[1] - this.qPd) - ea) + i2;
            bf bfVar = bVar.qQI;
            absoluteLayout.updateViewLayout(view, new AbsoluteLayout.LayoutParams(-2, -2, i, i4 - (bfVar.rMi != null ? bfVar.rMi.getHeight() : 0)));
        }
    }

    private static String a(a aVar, Map<String, String> map) {
        if (aVar == null) {
            return "";
        }
        String str;
        if (w.cff()) {
            str = aVar.qZj;
        } else if (w.cfg()) {
            str = aVar.qZk;
        } else {
            str = aVar.qZl;
        }
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '$') {
                if (stringBuffer2.length() == 0) {
                    stringBuffer2.append(charAt);
                } else if (stringBuffer2.charAt(stringBuffer2.length() - 1) == '$') {
                    stringBuffer.append('$');
                    stringBuffer2 = new StringBuffer();
                } else {
                    String str2 = (String) map.get(stringBuffer2.substring(1));
                    if (str2 == null) {
                        return "";
                    }
                    stringBuffer.append(str2);
                }
            } else if (stringBuffer2.length() == 0) {
                stringBuffer.append(charAt);
            } else {
                stringBuffer2.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    public final boolean bwm() {
        boolean z = false;
        if (this.qZq != null) {
            if (this.qZq.getTag() instanceof a) {
                b bVar = (b) this.qZz.get(Long.valueOf(((a) this.qZq.getTag()).qQJ));
                if (bVar != null) {
                    boolean z2 = (bVar.qZL == null || bVar.qZL.length() == 0) ? false : true;
                    if (z2) {
                        if (!(bVar.qZL == null || bVar.qZL.length() == 0 || !bVar.qZL.toString().startsWith("1:0"))) {
                            z = true;
                        }
                        if (z) {
                            bVar.KN("2:0:");
                        }
                        a(bVar);
                    } else {
                        bVar.KN("2:0:");
                        a(bVar);
                    }
                }
            }
            this.qZp.removeView(this.qZq);
            this.qZq = null;
            return true;
        }
        this.qZt = false;
        return false;
    }
}
