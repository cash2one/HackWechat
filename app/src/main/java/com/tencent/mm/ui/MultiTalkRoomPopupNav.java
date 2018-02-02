package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.au.b;
import com.tencent.mm.bm.d;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.q$a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.List;

public class MultiTalkRoomPopupNav extends LinearLayout {
    public LinearLayout xLd;
    public View xLe;
    public TextView xLf;
    public TextView xLg;
    public TextView xLh;
    public String xLi;
    public String xLj;
    public boolean xLk;
    public int xLl = b.xLv;
    public a xLm;
    private final int xLn = 6;
    public LinearLayout xLo;
    public boolean xLp = false;
    public b xLq = new b();

    static /* synthetic */ void Yr(String str) {
        x.i("MicroMsg.MultiTalkRoomPopupNav", "when only on menber do clear banner!");
        q$a.vcx.FA(str);
        x.i("MicroMsg.MultiTalkRoomPopupNav", "when only on member do exit talk!");
        if (!q$a.vcx.Fy(str)) {
            x.i("MicroMsg.MultiTalkRoomPopupNav", "when only on member do exit talk failure! groupId:" + str);
        }
    }

    static /* synthetic */ void a(MultiTalkRoomPopupNav multiTalkRoomPopupNav) {
        int i = 0;
        if (multiTalkRoomPopupNav.xLi == null || multiTalkRoomPopupNav.xLj == null) {
            x.e("MicroMsg.MultiTalkRoomPopupNav", "groupUserName or currentSenderUserName is null! groupUserName:" + multiTalkRoomPopupNav.xLi + ",currentSenderUserName:" + multiTalkRoomPopupNav.xLj);
        } else if (!multiTalkRoomPopupNav.xLi.toLowerCase().endsWith("@chatroom") || multiTalkRoomPopupNav.xLk) {
            String str = multiTalkRoomPopupNav.xLi;
            if (q$a.vcx == null || !q$a.vcx.Fs(str)) {
                x.e("MicroMsg.MultiTalkRoomPopupNav", "dealWithMultiTalkroomClick multiTalkInfo is null!");
                h.b(multiTalkRoomPopupNav.getContext(), ac.getContext().getString(R.l.ewI), null, true);
                multiTalkRoomPopupNav.cnv();
                r3 = g.pQN;
                r5 = new Object[7];
                r5[0] = Integer.valueOf(4);
                r5[1] = Integer.valueOf(multiTalkRoomPopupNav.xLl == b.xLt ? 1 : 0);
                r5[2] = Integer.valueOf(0);
                r5[3] = Integer.valueOf(1);
                r5[4] = multiTalkRoomPopupNav.xLi;
                r5[5] = Integer.valueOf(multiTalkRoomPopupNav.xLq.field_roomId);
                r5[6] = Long.valueOf(multiTalkRoomPopupNav.xLq.field_roomKey);
                r3.h(13945, r5);
                return;
            }
            List Fu = q$a.vcx.Fu(str);
            if (Fu.size() == 0) {
                x.e("MicroMsg.MultiTalkRoomPopupNav", "dealWithMultiTalkroomClick multiTalkMemberList is empty!");
                h.b(multiTalkRoomPopupNav.getContext(), ac.getContext().getString(R.l.ewI), null, true);
                multiTalkRoomPopupNav.cnv();
                r3 = g.pQN;
                r5 = new Object[7];
                r5[0] = Integer.valueOf(4);
                r5[1] = Integer.valueOf(multiTalkRoomPopupNav.xLl == b.xLt ? 1 : 0);
                r5[2] = Integer.valueOf(0);
                r5[3] = Integer.valueOf(1);
                r5[4] = multiTalkRoomPopupNav.xLi;
                r5[5] = Integer.valueOf(multiTalkRoomPopupNav.xLq.field_roomId);
                r5[6] = Long.valueOf(multiTalkRoomPopupNav.xLq.field_roomKey);
                r3.h(13945, r5);
                return;
            }
            if (Fu.size() == 1) {
                x.i("MicroMsg.MultiTalkRoomPopupNav", "just one now member now! wait for back service process!");
            }
            if (multiTalkRoomPopupNav.xLl == b.xLu) {
                multiTalkRoomPopupNav.xLp = true;
                Intent intent = new Intent();
                intent.putExtra("enterMainUiSource", 2);
                intent.putExtra("enterMainUiWxGroupId", str);
                d.b(ac.getContext(), "multitalk", ".ui.MultiTalkMainUI", intent);
                r3 = g.pQN;
                r5 = new Object[7];
                r5[0] = Integer.valueOf(4);
                r5[1] = Integer.valueOf(multiTalkRoomPopupNav.xLl == b.xLt ? 1 : 0);
                r5[2] = Integer.valueOf(0);
                r5[3] = Integer.valueOf(0);
                r5[4] = multiTalkRoomPopupNav.xLi;
                r5[5] = Integer.valueOf(multiTalkRoomPopupNav.xLq.field_roomId);
                r5[6] = Long.valueOf(multiTalkRoomPopupNav.xLq.field_roomKey);
                r3.h(13945, r5);
            } else if (multiTalkRoomPopupNav.xLl == b.xLt) {
                if (q$a.vcx.dq(str, multiTalkRoomPopupNav.xLj) != null) {
                    r4 = ac.getContext().getString(R.l.ebB, new Object[]{q$a.vcx.gu(q$a.vcx.dq(str, multiTalkRoomPopupNav.xLj))});
                    r5 = l(Fu, multiTalkRoomPopupNav.xLj);
                    Fu.size();
                    multiTalkRoomPopupNav.d(r4, r5, str);
                }
                r3 = g.pQN;
                r5 = new Object[7];
                r5[0] = Integer.valueOf(4);
                r5[1] = Integer.valueOf(multiTalkRoomPopupNav.xLl == b.xLt ? 1 : 0);
                r5[2] = Integer.valueOf(0);
                r5[3] = Integer.valueOf(0);
                r5[4] = multiTalkRoomPopupNav.xLi;
                r5[5] = Integer.valueOf(multiTalkRoomPopupNav.xLq.field_roomId);
                r5[6] = Long.valueOf(multiTalkRoomPopupNav.xLq.field_roomKey);
                r3.h(13945, r5);
            } else if (q$a.vcx.bcI()) {
                h.b(multiTalkRoomPopupNav.getContext(), ac.getContext().getString(R.l.ews), null, true);
                r3 = g.pQN;
                r5 = new Object[7];
                r5[0] = Integer.valueOf(4);
                r5[1] = Integer.valueOf(multiTalkRoomPopupNav.xLl == b.xLt ? 1 : 0);
                r5[2] = Integer.valueOf(0);
                r5[3] = Integer.valueOf(1);
                r5[4] = multiTalkRoomPopupNav.xLi;
                r5[5] = Integer.valueOf(multiTalkRoomPopupNav.xLq.field_roomId);
                r5[6] = Long.valueOf(multiTalkRoomPopupNav.xLq.field_roomKey);
                r3.h(13945, r5);
            } else if (Fu.size() >= 9) {
                h.b(multiTalkRoomPopupNav.getContext(), ac.getContext().getString(R.l.ewu, new Object[]{Integer.valueOf(9)}), null, true);
                g gVar = g.pQN;
                Object[] objArr = new Object[7];
                objArr[0] = Integer.valueOf(4);
                if (multiTalkRoomPopupNav.xLl == b.xLt) {
                    i = 1;
                }
                objArr[1] = Integer.valueOf(i);
                objArr[2] = Integer.valueOf(1);
                objArr[3] = Integer.valueOf(1);
                objArr[4] = multiTalkRoomPopupNav.xLi;
                objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.xLq.field_roomId);
                objArr[6] = Long.valueOf(multiTalkRoomPopupNav.xLq.field_roomKey);
                gVar.h(13945, objArr);
            } else {
                r4 = ac.getContext().getString(R.l.ewM);
                r5 = l(Fu, "");
                Fu.size();
                multiTalkRoomPopupNav.d(r4, r5, str);
                g.pQN.h(13945, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), multiTalkRoomPopupNav.xLi, Integer.valueOf(multiTalkRoomPopupNav.xLq.field_roomId), Long.valueOf(multiTalkRoomPopupNav.xLq.field_roomKey)});
            }
        } else {
            h.b(multiTalkRoomPopupNav.getContext(), ac.getContext().getString(R.l.ewz), null, true);
            multiTalkRoomPopupNav.cnv();
            q$a.vcx.iF(multiTalkRoomPopupNav.xLi);
            r3 = g.pQN;
            r5 = new Object[7];
            r5[0] = Integer.valueOf(4);
            r5[1] = Integer.valueOf(multiTalkRoomPopupNav.xLl == b.xLt ? 1 : 0);
            r5[2] = Integer.valueOf(0);
            r5[3] = Integer.valueOf(1);
            r5[4] = multiTalkRoomPopupNav.xLi;
            r5[5] = Integer.valueOf(multiTalkRoomPopupNav.xLq.field_roomId);
            r5[6] = Long.valueOf(multiTalkRoomPopupNav.xLq.field_roomKey);
            r3.h(13945, r5);
        }
    }

    static /* synthetic */ void a(MultiTalkRoomPopupNav multiTalkRoomPopupNav, String str) {
        x.i("MicroMsg.MultiTalkRoomPopupNav", "now try enter multitalk:" + str);
        if (q$a.vcx.Fz(str)) {
            q$a.vcx.Fx(str);
            g gVar = g.pQN;
            Object[] objArr = new Object[7];
            objArr[0] = Integer.valueOf(1);
            objArr[1] = Integer.valueOf(multiTalkRoomPopupNav.xLl == b.xLt ? 1 : 0);
            objArr[2] = Integer.valueOf(0);
            objArr[3] = Integer.valueOf(0);
            objArr[4] = multiTalkRoomPopupNav.xLi;
            objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.xLq.field_roomId);
            objArr[6] = Long.valueOf(multiTalkRoomPopupNav.xLq.field_roomKey);
            gVar.h(13945, objArr);
            return;
        }
        x.e("MicroMsg.MultiTalkRoomPopupNav", "try enter fail!" + str);
        Toast.makeText(ac.getContext(), ac.getContext().getString(R.l.ewh), 0).show();
        gVar = g.pQN;
        objArr = new Object[7];
        objArr[0] = Integer.valueOf(1);
        objArr[1] = Integer.valueOf(multiTalkRoomPopupNav.xLl == b.xLt ? 1 : 0);
        objArr[2] = Integer.valueOf(0);
        objArr[3] = Integer.valueOf(1);
        objArr[4] = multiTalkRoomPopupNav.xLi;
        objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.xLq.field_roomId);
        objArr[6] = Long.valueOf(multiTalkRoomPopupNav.xLq.field_roomKey);
        gVar.h(13945, objArr);
    }

    @TargetApi(11)
    public MultiTalkRoomPopupNav(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    public MultiTalkRoomPopupNav(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    private void initView() {
        inflate(getContext(), R.i.doy, this);
        this.xLd = (LinearLayout) findViewById(R.h.cxY);
        this.xLe = findViewById(R.h.cxX);
        this.xLf = (TextView) findViewById(R.h.cyb);
        this.xLg = (TextView) findViewById(R.h.cyc);
        this.xLh = (TextView) findViewById(R.h.cyd);
        this.xLo = (LinearLayout) findViewById(R.h.cxT);
        this.xLd.setOnClickListener(new 1(this));
    }

    public final void Yq(String str) {
        this.xLe.setBackgroundResource(R.g.bDP);
        this.xLf.setTextColor(getResources().getColor(R.e.btm));
        this.xLf.setText(str);
        if (this.xLo == null || this.xLo.getVisibility() != 0) {
            this.xLf.setVisibility(0);
            this.xLh.setVisibility(8);
            this.xLg.setVisibility(8);
            this.xLo.setVisibility(8);
        }
    }

    public final void cnv() {
        this.xLp = false;
        setVisibility(8);
        if (this.xLm != null) {
            a.a(this.xLm);
        }
    }

    private void d(String str, List<String> list, String str2) {
        boolean z;
        this.xLe.setVisibility(8);
        this.xLd.setVisibility(8);
        if (this.xLl == b.xLt) {
            z = true;
        } else {
            z = false;
        }
        this.xLm = new a(this, z, (byte) 0);
        if (q$a.vcx != null) {
            a aVar = this.xLm;
            OnClickListener 2 = new 2(this, str2);
            OnClickListener 3 = new 3(this, str2);
            aVar.titleView.setText(str);
            aVar.xLs.setVisibility(0);
            aVar.xLr.xLo.setVisibility(0);
            aVar.xLr.xLo.removeAllViews();
            for (String str3 : list) {
                View imageView = new ImageView(aVar.xLr.getContext());
                LayoutParams layoutParams = new LinearLayout.LayoutParams(a.fromDPToPix(ac.getContext(), 26), a.fromDPToPix(ac.getContext(), 26));
                layoutParams.rightMargin = a.fromDPToPix(ac.getContext(), 10);
                imageView.setScaleType(ScaleType.FIT_CENTER);
                imageView.setLayoutParams(layoutParams);
                aVar.xLr.xLo.addView(imageView);
                com.tencent.mm.pluginsdk.ui.a.b.a(imageView, str3, 0.1f, false);
            }
            ((Button) aVar.xLr.findViewById(R.h.cxP)).setOnClickListener(2);
            ((Button) aVar.xLr.findViewById(R.h.cxO)).setOnClickListener(3);
        }
    }

    public final void cX(List<String> list) {
        if (this.xLo != null && this.xLo.getVisibility() == 0) {
            this.xLo.removeAllViews();
            for (String str : list) {
                View imageView = new ImageView(getContext());
                LayoutParams layoutParams = new LinearLayout.LayoutParams(a.fromDPToPix(ac.getContext(), 26), a.fromDPToPix(ac.getContext(), 26));
                layoutParams.rightMargin = a.fromDPToPix(ac.getContext(), 10);
                imageView.setScaleType(ScaleType.FIT_CENTER);
                imageView.setLayoutParams(layoutParams);
                this.xLo.addView(imageView);
                com.tencent.mm.pluginsdk.ui.a.b.a(imageView, str, 0.1f, false);
            }
        }
    }

    public static List<String> l(List<String> list, String str) {
        List<String> arrayList = new ArrayList();
        List<String> arrayList2 = new ArrayList();
        if (!(str == null || str == "")) {
            for (String str2 : list) {
                if (!(str2 == null || str2.equals(str))) {
                    arrayList2.add(str2);
                }
            }
            list = arrayList2;
        }
        for (String str22 : r5) {
            arrayList.add(str22);
        }
        return arrayList;
    }
}
