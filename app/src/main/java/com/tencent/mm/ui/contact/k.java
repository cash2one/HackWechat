package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.n;
import com.tencent.mm.bf.b;
import com.tencent.mm.bf.c;
import com.tencent.mm.bf.f;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.fn;
import com.tencent.mm.modelsimple.aj;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.List;

public final class k extends RelativeLayout {
    public static Boolean ySw = Boolean.valueOf(true);
    private Context context = null;
    private boolean isVisible = true;
    private View lWv = null;
    boolean ySA = false;
    private View ySx = null;
    private final ak ySy = new ak(new a(this) {
        final /* synthetic */ k ySB;

        {
            this.ySB = r1;
        }

        public final boolean uF() {
            x.d("MicroMsg.FMessageContactView", "refresh timer expired, update");
            k.cvU();
            this.ySB.init();
            return false;
        }
    }, true);
    j.a ySz = new j.a(this) {
        final /* synthetic */ k ySB;

        {
            this.ySB = r1;
        }

        public final void a(String str, l lVar) {
            x.d("MicroMsg.FMessageContactView", "onNotifyChange, fmsg change");
            if (!this.ySB.ySy.cfK()) {
                this.ySB.ySy.TG();
            }
            ak b = this.ySB.ySy;
            long j = this.ySB.ySA ? 500 : 1000;
            b.J(j, j);
        }
    };

    public k(Context context) {
        super(context);
        this.context = context;
        com.tencent.mm.bf.l.Tx().c(this.ySz);
        cvU();
        init();
    }

    private void init() {
        c Tx = com.tencent.mm.bf.l.Tx();
        x.v("MicroMsg.FMessageConversationStorage", "getNewLimit, limit = %d", Integer.valueOf(4));
        List arrayList = new ArrayList();
        Cursor a = Tx.gJP.a(new StringBuilder("select * from fmessage_conversation  where isNew = 1 ORDER BY lastModifiedTime DESC limit 4").toString(), null, 2);
        while (a.moveToNext()) {
            b bVar = new b();
            bVar.b(a);
            if (!bh.ov(bVar.field_talker)) {
                arrayList.add(bVar);
            }
        }
        a.close();
        int size = arrayList.size();
        x.d("MicroMsg.FMessageContactView", "init new fconv size = %d (max is 4)", Integer.valueOf(size));
        removeAllViews();
        if (size <= 0) {
            if (this.context == null) {
                x.w("MicroMsg.FMessageContactView", "initNoNew failed. context is null.");
            } else {
                this.lWv = View.inflate(this.context, R.i.dio, this);
                this.ySx = this.lWv.findViewById(R.h.ciB);
                LayoutParams layoutParams = this.ySx.getLayoutParams();
                layoutParams.height = (int) (((float) com.tencent.mm.bv.a.ab(this.context, R.f.buA)) * com.tencent.mm.bv.a.ex(this.context));
                this.ySx.setLayoutParams(layoutParams);
                this.lWv.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ k ySB;

                    {
                        this.ySB = r1;
                    }

                    public final void onClick(View view) {
                        x.d("MicroMsg.FMessageContactView", "initNoNew, goto FMessageConversationUI");
                        d.b(this.ySB.context, "subapp", ".ui.friend.FMessageConversationUI", new Intent());
                    }
                });
                MaskLayout maskLayout = (MaskLayout) this.lWv.findViewById(R.h.cin);
                n.Jz();
                ((ImageView) maskLayout.view).setImageBitmap(com.tencent.mm.ad.d.jf("fmessage"));
            }
        } else if (size == 1) {
            b bVar2 = (b) arrayList.get(0);
            if (this.context == null) {
                x.w("MicroMsg.FMessageContactView", "initSingleNew failed. context is null.");
            } else {
                CharSequence string;
                if (com.tencent.mm.bv.a.ey(this.context)) {
                    this.lWv = View.inflate(this.context, R.i.dir, this);
                } else {
                    this.lWv = View.inflate(this.context, R.i.diq, this);
                }
                ((TextView) this.lWv.findViewById(R.h.ciG)).setText(i.a(this.context, bVar2.field_displayName));
                TextView textView = (TextView) this.lWv.findViewById(R.h.ciF);
                f mW = com.tencent.mm.bf.l.Tw().mW(bVar2.field_talker);
                Context context = this.context;
                int i = mW.field_type;
                int i2 = bVar2.field_addScene;
                String str = mW.field_msgContent;
                x.d("MicroMsg.FMessageProvider", "setDigest, fmsgType = %d, fmsgScene = %d, fmsgContent = %s, isSend = %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(!mW.To()));
                if (i == 0) {
                    if (str != null) {
                        au.a Xr = au.a.Xr(str);
                        switch (Xr.scene) {
                            case 4:
                                string = context.getString(R.l.dQR);
                                break;
                            case 10:
                            case 11:
                                com.tencent.mm.sdk.b.b fnVar = new fn();
                                fnVar.fuR.fuO = Xr.xzj;
                                fnVar.fuR.fuP = Xr.xzk;
                                com.tencent.mm.sdk.b.a.xef.m(fnVar);
                                string = context.getString(R.l.dQU, new Object[]{bh.az(fnVar.fuS.fuT, "")});
                                break;
                            case 31:
                                string = context.getString(R.l.dRd);
                                break;
                            case 32:
                                string = context.getString(R.l.dQX);
                                break;
                            case 58:
                            case 59:
                            case 60:
                                string = context.getString(R.l.dQS);
                                break;
                            default:
                                string = context.getString(R.l.dQW);
                                break;
                        }
                    }
                    x.e("MicroMsg.FMessageProvider", "setDigest fail, fmsgContent is null");
                    string = null;
                } else if (r2) {
                    Object obj = str;
                } else {
                    au.d Xu = au.d.Xu(str);
                    string = (Xu.content == null || Xu.content.trim().equals("")) ? context.getString(R.l.eig) : Xu.content;
                }
                if (t.ov(string)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(string);
                }
                this.ySx = this.lWv.findViewById(R.h.cis);
                this.lWv.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ k ySB;

                    {
                        this.ySB = r1;
                    }

                    public final void onClick(View view) {
                        x.d("MicroMsg.FMessageContactView", "initSingleNew, not goto ContactInfoUI, goto FMessageConversationUI");
                        ar.Hg();
                        com.tencent.mm.z.c.CU().set(143618, Integer.valueOf(0));
                        d.b(this.ySB.context, "subapp", ".ui.friend.FMessageConversationUI", new Intent());
                    }
                });
                com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) ((MaskLayout) this.lWv.findViewById(R.h.cin)).view, bVar2.field_talker);
            }
        } else if (this.context == null) {
            x.w("MicroMsg.FMessageContactView", "initMultiNew failed. context is null.");
        } else {
            this.lWv = View.inflate(this.context, R.i.dip, this);
            int size2 = arrayList.size();
            x.d("MicroMsg.FMessageContactView", "initMultiNew, newList size = %d", Integer.valueOf(size2));
            MaskLayout maskLayout2 = (MaskLayout) this.lWv.findViewById(R.h.cin);
            com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) maskLayout2.view, ((b) arrayList.get(0)).field_talker);
            maskLayout2.setVisibility(0);
            maskLayout2 = (MaskLayout) this.lWv.findViewById(R.h.cio);
            com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) maskLayout2.view, ((b) arrayList.get(1)).field_talker);
            maskLayout2.setVisibility(0);
            if (size2 > 2) {
                maskLayout2 = (MaskLayout) this.lWv.findViewById(R.h.cip);
                com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) maskLayout2.view, ((b) arrayList.get(2)).field_talker);
                maskLayout2.setVisibility(0);
            }
            if (size2 > 3) {
                maskLayout2 = (MaskLayout) this.lWv.findViewById(R.h.ciq);
                com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) maskLayout2.view, ((b) arrayList.get(3)).field_talker);
                maskLayout2.setVisibility(0);
            }
            this.ySx = this.lWv.findViewById(R.h.cis);
            this.ySx.setOnClickListener(new 6(this));
        }
        View findViewById = this.lWv.findViewById(R.h.cis);
        if (findViewById != null) {
            findViewById.setVisibility(this.isVisible ? 0 : 8);
        }
        this.ySx.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ k ySB;

            {
                this.ySB = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.ySB.context instanceof MMActivity) {
                    ((MMActivity) this.ySB.context).aWs();
                }
                return false;
            }
        });
        int Tl = com.tencent.mm.bf.l.Tx().Tl();
        x.d("MicroMsg.FMessageContactView", "init totalNewSize = %d", Integer.valueOf(Tl));
        TextView textView2 = (TextView) this.lWv.findViewById(R.h.ciz);
        textView2.setBackgroundResource(s.gd(this.context));
        if (Tl <= 0) {
            textView2.setVisibility(8);
            ySw = Boolean.valueOf(false);
            return;
        }
        textView2.setVisibility(0);
        ySw = Boolean.valueOf(true);
        if (Tl > 99) {
            textView2.setText(getContext().getString(R.l.eRP));
        } else {
            textView2.setText(String.valueOf(Tl));
        }
    }

    private static void cvU() {
        int Tl = com.tencent.mm.bf.l.Tx().Tl();
        x.v("MicroMsg.FMessageContactView", "updateAddressTabUnread, newCount update to = %d", Integer.valueOf(Tl));
        if (Tl > 0) {
            ar.Hg();
            com.tencent.mm.z.c.CU().set(143618, Integer.valueOf(Tl));
        }
    }

    public static void cvV() {
        ar.Hg();
        if (com.tencent.mm.z.c.ET()) {
            ar.Hg();
            if (com.tencent.mm.z.c.CU().getInt(143618, 0) > 0) {
                aj.S("fmessage", 2);
            }
        }
        ar.Hg();
        com.tencent.mm.z.c.CU().set(143618, Integer.valueOf(0));
    }
}
