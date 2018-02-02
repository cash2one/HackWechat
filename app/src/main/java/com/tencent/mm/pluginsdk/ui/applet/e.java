package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ag.a.c;
import com.tencent.mm.ag.a.j;
import com.tencent.mm.api.f;
import com.tencent.mm.aq.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.PasterEditText;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.v;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class e implements o {

    static class AnonymousClass10 implements OnClickListener {
        final /* synthetic */ a vnl;
        final /* synthetic */ q vnm;
        final /* synthetic */ View zS;

        AnonymousClass10(a aVar, View view, q qVar) {
            this.vnl = aVar;
            this.zS = view;
            this.vnm = qVar;
        }

        public final void onClick(View view) {
            if (this.vnl != null) {
                this.vnl.a(true, e.cY(this.zS), e.cZ(this.zS));
            }
            this.vnm.dismiss();
            this.vnm.setFocusable(false);
            this.vnm.setTouchable(false);
        }
    }

    static /* synthetic */ String cY(View view) {
        EditText editText = (EditText) view.findViewById(R.h.bWU);
        return editText == null ? null : editText.getText().toString();
    }

    static /* synthetic */ int cZ(View view) {
        EditText editText = (EditText) view.findViewById(R.h.bWU);
        return editText instanceof PasterEditText ? ((PasterEditText) editText).bAS() : 0;
    }

    static void a(Context context, i.a aVar, Object obj) {
        if (obj != null) {
            if (obj instanceof String) {
                obj = bh.F(((String) obj).split(","));
            } else if (obj instanceof List) {
                List list = (List) obj;
            } else {
                obj = null;
            }
            if (!bh.cA(obj)) {
                if (obj.size() == 1) {
                    String str = (String) obj.get(0);
                    int fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(context, (int) (20.0f * com.tencent.mm.bv.a.eu(context)));
                    aVar.P(((com.tencent.mm.plugin.emoji.b.a) g.h(com.tencent.mm.plugin.emoji.b.a.class)).a(context, context.getString(R.l.eEE).toString(), (float) fromDPToPix));
                    String gu = ((b) g.h(b.class)).gu(str);
                    int fromDPToPix2 = com.tencent.mm.bv.a.fromDPToPix(context, (int) (14.0f * com.tencent.mm.bv.a.eu(context)));
                    if (s.eV(str)) {
                        CharSequence a = ((com.tencent.mm.plugin.emoji.b.a) g.h(com.tencent.mm.plugin.emoji.b.a.class)).a(context, (gu + context.getString(R.l.eJh, new Object[]{Integer.valueOf(((com.tencent.mm.plugin.chatroom.b.a) g.h(com.tencent.mm.plugin.chatroom.b.a.class)).gl(str))})).toString(), (float) fromDPToPix2);
                        View inflate = v.fv(context).inflate(R.i.dfv, null);
                        GridView gridView = (GridView) inflate.findViewById(R.h.bSE);
                        List arrayList = new ArrayList();
                        List gj = ((com.tencent.mm.plugin.chatroom.b.a) g.h(com.tencent.mm.plugin.chatroom.b.a.class)).gj(str);
                        aVar.a(str, a, Boolean.valueOf(true), new 1(inflate, arrayList, str, gj));
                        gridView.setAdapter(new j(context, gj, arrayList));
                        gridView.setSelector(new ColorDrawable(context.getResources().getColor(R.e.transparent)));
                        if (gj != null) {
                            if (gj.size() > 16) {
                                gridView.setLayoutParams(new LayoutParams(-1, com.tencent.mm.bv.a.aa(context, R.f.buK)));
                                gridView.setPadding(com.tencent.mm.bv.a.aa(context, R.f.buJ), 0, com.tencent.mm.bv.a.aa(context, R.f.buJ), 0);
                            } else {
                                gridView.setPadding(0, 0, 0, com.tencent.mm.bv.a.aa(context, R.f.buI));
                            }
                        }
                        aVar.xZs.xXh = inflate;
                        return;
                    }
                    aVar.a(str, ((com.tencent.mm.plugin.emoji.b.a) g.h(com.tencent.mm.plugin.emoji.b.a.class)).a(context, gu.toString(), (float) fromDPToPix2), Boolean.valueOf(false), null);
                    return;
                }
                aVar.xZs.xWN = obj;
                aVar.YF(context.getString(R.l.evP));
            }
        }
    }

    static void a(Context context, i iVar, String str, String str2, a aVar, a aVar2) {
        if (bh.ov(str) || str.length() == 0) {
            str = context.getResources().getString(R.l.dUe);
        }
        if (bh.ov(str2) || str2.length() == 0) {
            str2 = context.getResources().getString(R.l.dEn);
        }
        iVar.a(str, true, new 5(iVar, aVar));
        iVar.b(str2, true, new 9(iVar, aVar2));
    }

    public static i a(p pVar, String str, String str2, String str3, String str4, boolean z, String str5, a aVar) {
        if ((str == null || str.length() == 0) && (str3 == null || str3.length() == 0)) {
            x.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
            return null;
        }
        View inflate = View.inflate(pVar.xIM, R.i.deC, null);
        i.a aVar2 = new i.a(pVar.xIM);
        aVar2.mi(false);
        aVar2.mj(false);
        a(aVar2, pVar.xIM, str);
        l(inflate, z);
        a(pVar, aVar2, aVar, inflate, str5);
        TextView textView = (TextView) inflate.findViewById(R.h.bWT);
        textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(pVar.xIM, str3, textView.getTextSize()));
        inflate.findViewById(R.h.bWQ).setVisibility(8);
        int b = BackwardSupportUtil.b.b(pVar.xIM, 120.0f);
        CdnImageView cdnImageView = (CdnImageView) inflate.findViewById(R.h.bWV);
        if (cdnImageView != null) {
            cdnImageView.V(str2, b, b);
        }
        aVar2.dk(inflate);
        i akx = aVar2.akx();
        akx.show();
        return akx;
    }

    public static i a(p pVar, String str, String str2, boolean z, String str3, a aVar) {
        return a(pVar, str, str2, z, str3, aVar, pVar.xIM.getResources().getString(R.l.dGU));
    }

    public static i a(p pVar, String str, String str2, boolean z, String str3, a aVar, String str4) {
        if ((str == null || str.length() == 0) && (str2 == null || str2.length() == 0)) {
            x.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
            return null;
        }
        i.a aVar2 = new i.a(pVar.xIM);
        String string = pVar.xIM.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(pVar.xIM, aVar2, bh.F(string.split(",")));
        }
        aVar2.mh(true);
        aVar2.Q(str).mi(false).mj(false);
        if (z) {
            aVar2.YH(pVar.xIM.getString(R.l.dUb));
        }
        i akx = aVar2.akx();
        a(pVar.xIM, akx, str3, null, aVar, aVar);
        akx.show();
        return akx;
    }

    public static i b(p pVar, String str, String str2, String str3, String str4, String str5, a aVar) {
        if ((str == null || str.length() == 0) && (str3 == null || str3.length() == 0)) {
            x.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
            return null;
        }
        View inflate = View.inflate(pVar.xIM, R.i.deC, null);
        i.a aVar2 = new i.a(pVar.xIM);
        aVar2.mi(false);
        aVar2.mj(false);
        a(aVar2, pVar.xIM, str);
        if (inflate != null) {
            EditText editText = (EditText) inflate.findViewById(R.h.bWU);
            if (editText != null) {
                editText.setVisibility(0);
            }
            editText.setText(str4);
        }
        a(pVar, aVar2, aVar, inflate, str5);
        TextView textView = (TextView) inflate.findViewById(R.h.bWT);
        textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(pVar.xIM, str3, textView.getTextSize()));
        inflate.findViewById(R.h.bWQ).setVisibility(8);
        int b = BackwardSupportUtil.b.b(pVar.xIM, 120.0f);
        CdnImageView cdnImageView = (CdnImageView) inflate.findViewById(R.h.bWV);
        if (cdnImageView != null) {
            cdnImageView.V(str2, b, b);
        }
        aVar2.dk(inflate);
        i akx = aVar2.akx();
        akx.show();
        return akx;
    }

    public static i a(p pVar, String str, boolean z, a aVar) {
        return a(pVar, str, z, "", aVar);
    }

    public static i a(p pVar, String str, boolean z, String str2, a aVar) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MMConfirmDialog", "showDialogItem2 fail, message is empty");
            return null;
        }
        i.a aVar2 = new i.a(pVar.xIM);
        String string = pVar.xIM.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(pVar.xIM, aVar2, bh.F(string.split(",")));
        }
        aVar2.mh(true);
        aVar2.Q(str).mi(false).mj(false);
        if (z) {
            aVar2.YH(pVar.xIM.getString(R.l.dUb));
        }
        i akx = aVar2.akx();
        a(pVar.xIM, akx, str2, null, aVar, aVar);
        akx.show();
        return akx;
    }

    public static i b(p pVar, String str, boolean z, a aVar) {
        return b(pVar, str, z, "", aVar);
    }

    public static i b(p pVar, String str, boolean z, String str2, a aVar) {
        if (str == null || !com.tencent.mm.a.e.bO(str)) {
            x.e("MicroMsg.MMConfirmDialog", "showDialogItem3 fail, img does not exist");
            return null;
        }
        i.a aVar2 = new i.a(pVar.xIM);
        String string = pVar.xIM.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(pVar.xIM, aVar2, bh.F(string.split(",")));
        }
        aVar2.mh(true);
        aVar2.mi(false).mj(false);
        if (z) {
            aVar2.YH(pVar.xIM.getString(R.l.dUb));
        }
        if (!bh.ov(str)) {
            Bitmap UN = d.UN(str);
            if (UN != null) {
                aVar2.a(UN, true, 3);
                a(aVar2, UN);
                aVar2.mh(false);
            }
        }
        i akx = aVar2.akx();
        a(pVar.xIM, akx, str2, null, aVar, aVar);
        akx.show();
        return akx;
    }

    public static i a(p pVar, byte[] bArr, boolean z, a aVar) {
        return a(pVar, bArr, z, "", aVar);
    }

    public static i a(p pVar, byte[] bArr, boolean z, String str, a aVar) {
        if (bArr == null || bArr.length == 0) {
            x.e("MicroMsg.MMConfirmDialog", "showDialogItem3 fail, imgData is null");
            return null;
        }
        i.a aVar2 = new i.a(pVar.xIM);
        String string = pVar.xIM.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(pVar.xIM, aVar2, bh.F(string.split(",")));
        }
        aVar2.mh(true);
        aVar2.mi(false).mj(false);
        if (z) {
            aVar2.YH(pVar.xIM.getString(R.l.dUb));
        }
        if (bArr != null && bArr.length > 0) {
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            if (decodeByteArray != null) {
                aVar2.a(decodeByteArray, true, 3);
                a(aVar2, decodeByteArray);
                aVar2.mh(false);
            }
        }
        i akx = aVar2.akx();
        a(pVar.xIM, akx, str, null, aVar, aVar);
        akx.show();
        return akx;
    }

    public static i b(p pVar, String str, String str2, String str3, a aVar) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MMConfirmDialog", "showDialogItem4 fail, title message both are empty");
            return null;
        }
        View V = V(pVar.xIM, R.i.deD);
        i.a aVar2 = new i.a(pVar.xIM);
        aVar2.mi(false);
        aVar2.mj(false);
        if (V != null) {
            EditText editText = (EditText) V.findViewById(R.h.bWU);
            if (editText != null) {
                editText.setVisibility(0);
                editText.setHint(bh.ou(str2));
            }
        }
        a(pVar, aVar2, aVar, V, str3);
        if (!bh.ov(null)) {
            a(aVar2, pVar.xIM, null);
        }
        ((TextView) V.findViewById(R.h.bWW)).setVisibility(8);
        TextView textView = (TextView) V.findViewById(R.h.bWT);
        textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(pVar.xIM, str, textView.getTextSize()));
        ((TextView) V.findViewById(R.h.bWQ)).setVisibility(8);
        int b = BackwardSupportUtil.b.b(pVar.xIM, 120.0f);
        ImageView imageView = (CdnImageView) V.findViewById(R.h.bWV);
        if (imageView != null) {
            if (!bh.ov(null)) {
                com.tencent.mm.pluginsdk.ui.a.b.a(imageView, null);
            } else if (bh.ov(null)) {
                imageView.setVisibility(8);
            } else {
                imageView.V(null, b, b);
            }
        }
        aVar2.dk(V);
        i akx = aVar2.akx();
        akx.show();
        return akx;
    }

    public static i a(p pVar, int i, String str, boolean z, a aVar) {
        return a(pVar, i, str, z, "", aVar);
    }

    public static i a(p pVar, int i, String str, boolean z, String str2, a aVar) {
        i.a aVar2 = new i.a(pVar.xIM);
        String string = pVar.xIM.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(pVar.xIM, aVar2, bh.F(string.split(",")));
        }
        aVar2.mh(true);
        if (i == R.k.dvj) {
            string = pVar.xIM.getResources().getString(R.l.dFj);
        } else if (i == R.k.dvn) {
            string = pVar.xIM.getResources().getString(R.l.dFJ);
        } else if (i == R.k.dvA) {
            string = pVar.xIM.getResources().getString(R.l.dGX);
        } else {
            string = pVar.xIM.getResources().getString(R.l.dDN);
        }
        aVar2.Q(str).mi(false).mj(false);
        if (z) {
            aVar2.YH(pVar.xIM.getString(R.l.dUb));
        }
        i akx = aVar2.akx();
        a(pVar.xIM, akx, str2, null, aVar, aVar);
        akx.show();
        return akx;
    }

    public static i a(p pVar, String str, boolean z, int i, a aVar) {
        return a(pVar, str, z, i, "", aVar);
    }

    public static i a(p pVar, String str, boolean z, int i, String str2, a aVar) {
        Object F;
        i.a aVar2 = new i.a(pVar.xIM);
        String string = pVar.xIM.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            F = bh.F(string.split(","));
        } else {
            F = null;
        }
        a(pVar.xIM, aVar2, F);
        aVar2.mh(true);
        switch (i) {
            case 1:
                string = pVar.xIM.getResources().getString(R.l.dGX);
                break;
            case 2:
                string = pVar.xIM.getResources().getString(R.l.dFJ);
                break;
            default:
                string = pVar.xIM.getResources().getString(R.l.dDN);
                break;
        }
        aVar2.Q(new StringBuffer(string).append(str).toString()).mi(false).mj(false);
        if (z) {
            aVar2.YH(pVar.xIM.getString(R.l.dUb));
        }
        i akx = aVar2.akx();
        a(pVar.xIM, akx, str2, null, aVar, aVar);
        akx.show();
        return akx;
    }

    public static i a(p pVar, String str, String str2, String str3, a aVar, a aVar2) {
        i.a aVar3 = new i.a(pVar.xIM);
        aVar3.a(com.tencent.mm.compatible.f.a.decodeResource(pVar.xIM.getResources(), R.k.dys), false, 3);
        aVar3.mi(false);
        aVar3.mj(false);
        aVar3.xZs.xWQ = true;
        aVar3.xZs.xWI = str;
        aVar3.EB(17);
        i akx = aVar3.akx();
        a(pVar.xIM, akx, str3, str2, aVar2, aVar);
        akx.Ey(pVar.xIM.getResources().getColor(R.e.bsE));
        akx.show();
        return akx;
    }

    public static q a(p pVar, Bitmap bitmap, String str, String str2, String str3, String str4, String str5, a aVar) {
        View V = V(pVar.xIM, R.i.deG);
        q cX = cX(V);
        a(V, aVar, cX);
        if (bh.ov(str2)) {
            x.e("MicroMsg.MMConfirmDialog", "showDialogItem8 fail,title or  message is empty");
            return null;
        }
        a(V, R.h.bWW, str2, false, 0);
        NoMeasuredTextView noMeasuredTextView = (NoMeasuredTextView) V.findViewById(R.h.bWT);
        noMeasuredTextView.ygb = true;
        noMeasuredTextView.O(pVar.xIM.getResources().getDimension(R.f.bus) * com.tencent.mm.bv.a.eu(pVar.xIM));
        noMeasuredTextView.setTextColor(com.tencent.mm.bv.a.Z(pVar.xIM, R.e.btv));
        if (bh.ov(str)) {
            noMeasuredTextView.setText(((com.tencent.mm.plugin.emoji.b.a) g.h(com.tencent.mm.plugin.emoji.b.a.class)).b(pVar.xIM, str3, noMeasuredTextView.gu.getTextSize()));
        } else {
            noMeasuredTextView.setText(((com.tencent.mm.plugin.emoji.b.a) g.h(com.tencent.mm.plugin.emoji.b.a.class)).b(pVar.xIM, ((b) g.h(b.class)).gu(str), noMeasuredTextView.gu.getTextSize()));
        }
        a(V, R.h.bWR, str4, true, 8);
        Button button = (Button) V.findViewById(R.h.bWM);
        if (!bh.ov(str5)) {
            button.setText(str5);
        }
        button.setOnClickListener(new 11(aVar, V, cX));
        if (!bh.ov(str)) {
            com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) V.findViewById(R.h.bWV), str);
        }
        a(pVar, cX);
        return cX;
    }

    public static q a(p pVar, long j, String str, String str2, String str3, a aVar) {
        View V = V(pVar.xIM, R.i.deG);
        q cX = cX(V);
        a(V, aVar, cX);
        if (bh.ov(str)) {
            x.e("MicroMsg.MMConfirmDialog", "showDialogItem8 fail,title or  message is empty");
            return null;
        }
        String str4;
        a(V, R.h.bWW, str, false, 0);
        NoMeasuredTextView noMeasuredTextView = (NoMeasuredTextView) V.findViewById(R.h.bWT);
        noMeasuredTextView.ygb = true;
        noMeasuredTextView.O(pVar.xIM.getResources().getDimension(R.f.bus) * com.tencent.mm.bv.a.eu(pVar.xIM));
        noMeasuredTextView.setTextColor(com.tencent.mm.bv.a.Z(pVar.xIM, R.e.btv));
        c ag = ((f) g.h(f.class)).ag(j);
        if (ag == null || !ag.Mt()) {
            j ca = ((com.tencent.mm.api.g) g.h(com.tencent.mm.api.g.class)).ca(ag.field_bizChatServId);
            if (ca != null) {
                String str5 = ca.field_userName;
                str4 = ca.field_headImageUrl;
                String str6 = ca.field_brandUserName;
                Object obj = str5;
                str5 = str4;
                str4 = str6;
            } else {
                x.w("MicroMsg.MMConfirmDialog", "showDialogItem8 userInfo is null");
                return null;
            }
        }
        str5 = ag.field_chatName;
        str4 = ag.field_headImageUrl;
        CharSequence charSequence = str5;
        str5 = str4;
        str4 = ag.field_brandUserName;
        if (charSequence == null) {
            charSequence = str2;
        }
        if (bh.ov(charSequence)) {
            noMeasuredTextView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(pVar.xIM, str2, noMeasuredTextView.gu.getTextSize()));
        } else {
            noMeasuredTextView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(pVar.xIM, charSequence, noMeasuredTextView.gu.getTextSize()));
        }
        a(V, R.h.bWR, null, true, 8);
        Button button = (Button) V.findViewById(R.h.bWM);
        if (!bh.ov(str3)) {
            button.setText(str3);
        }
        button.setOnClickListener(new 12(aVar, V, cX));
        com.tencent.mm.aq.a.a.c.a aVar2 = new com.tencent.mm.aq.a.a.c.a();
        aVar2.hDD = com.tencent.mm.api.a.bZ(str4);
        aVar2.hDA = true;
        aVar2.hDX = true;
        aVar2.hDP = R.k.bBB;
        com.tencent.mm.aq.a.a.c PK = aVar2.PK();
        if (!bh.ov(str5)) {
            o.PA().a(str5, (ImageView) V.findViewById(R.h.bWV), PK);
        }
        a(pVar, cX);
        return cX;
    }

    public static i a(p pVar, String str, View view, String str2, final o.b bVar) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
            return null;
        }
        i.a aVar = new i.a(pVar.xIM);
        aVar.mi(false);
        aVar.mj(false);
        a(aVar, pVar.xIM, str);
        if (bh.ov(str2) || str2.length() == 0) {
            str2 = pVar.xIM.getResources().getString(R.l.dUe);
        }
        aVar.YI(str2).a(new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (bVar != null) {
                    bVar.gg(true);
                }
            }
        });
        aVar.ED(R.l.dEn).b(new 2(bVar));
        aVar.dk(view);
        i akx = aVar.akx();
        akx.Ex(pVar.xIM.getResources().getColor(R.e.bui));
        akx.show();
        return akx;
    }

    public static View V(Context context, int i) {
        return ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i, null);
    }

    static q cX(View view) {
        return new q(view, -1, -1);
    }

    public static void a(p pVar, i.a aVar, final a aVar2, View view, String str) {
        if (bh.ov(str) || str.length() == 0) {
            str = pVar.xIM.getResources().getString(R.l.dUe);
        }
        aVar.YI(str).a(new 13(aVar2, view));
        aVar.ED(R.l.dEn).b(new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (aVar2 != null) {
                    aVar2.a(false, null, 0);
                }
            }
        });
    }

    private static void a(i.a aVar, Context context, String str) {
        aVar.YF(str);
        aVar.xZs.vim = context.getResources().getColor(R.e.btv);
        aVar.xZs.xXi = 2;
    }

    static void a(View view, a aVar, q qVar) {
        ((Button) view.findViewById(R.h.bWM)).setOnClickListener(new 3(aVar, view, qVar));
        Button button = (Button) view.findViewById(R.h.bWN);
        if (button != null) {
            button.setOnClickListener(new 4(aVar, qVar));
        }
    }

    public static void l(View view, boolean z) {
        if (view != null) {
            EditText editText = (EditText) view.findViewById(R.h.bWU);
            if (editText != null) {
                editText.setVisibility(z ? 0 : 8);
            }
        }
    }

    private static void a(View view, int i, String str, boolean z, int i2) {
        TextView textView = (TextView) view.findViewById(i);
        Assert.assertTrue(textView != null);
        if (z && bh.ov(str)) {
            textView.setVisibility(i2);
        } else {
            textView.setText(str);
        }
    }

    static void a(p pVar, q qVar) {
        try {
            if (!pVar.xIM.isFinishing()) {
                qVar.setInputMethodMode(1);
                qVar.setSoftInputMode(16);
                qVar.setFocusable(true);
                qVar.setTouchable(true);
                qVar.showAtLocation(pVar.xIM.getWindow().getDecorView(), 17, 0, 0);
            }
        } catch (Throwable e) {
            x.e("MicroMsg.MMConfirmDialog", "show dialog fail: %s", e.getMessage());
            x.printErrStackTrace("MicroMsg.MMConfirmDialog", e, "", new Object[0]);
        }
    }

    public static void a(i.a aVar, Bitmap bitmap) {
        aVar.a(new 7(bitmap));
    }
}
