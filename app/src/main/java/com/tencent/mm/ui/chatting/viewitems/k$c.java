package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.te;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.y.g;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

public class k$c extends b {
    private a yqa;

    public final boolean aXj() {
        return true;
    }

    public final boolean aj(int i, boolean z) {
        if (z && i == 419430449) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddU);
        view.setTag(new k.a().dx(view));
        return view;
    }

    public final void a(b.a aVar, int i, a aVar2, au auVar, String str) {
        g.a I;
        this.yqa = aVar2;
        k.a aVar3 = (k.a) aVar;
        String str2 = auVar.field_content;
        if (str2 != null) {
            I = g.a.I(str2, auVar.field_reserved);
        } else {
            I = null;
        }
        if (I != null) {
            k.a.O(aVar3.yIy, aVar3.yJw);
            aVar3.yIy.setBackgroundResource(R.g.bAi);
            aVar3.yIy.setPadding(aVar2.getContext().getResources().getDimensionPixelSize(R.f.bvB), 0, com.tencent.mm.bv.a.fromDPToPix(aVar2.getContext(), 13), 0);
            aVar3.yKv.setSingleLine(true);
            b teVar = new te();
            teVar.fLF.fEs = I.hcg;
            com.tencent.mm.sdk.b.a.xef.m(teVar);
            boolean z = teVar.fLG.fLH;
            if (teVar.fLG.status == -2) {
                z = false;
            }
            int i2 = teVar.fLG.status;
            if (i2 <= 0) {
                i2 = I.hcd;
            }
            CharSequence string;
            switch (i2) {
                case 1:
                case 7:
                    ar.Hg();
                    com.tencent.mm.l.a WN = c.EY().WN(auVar.field_talker);
                    if (WN != null) {
                        str2 = WN.AQ();
                    } else {
                        str2 = auVar.field_talker;
                    }
                    if (t.ov(I.hdn)) {
                        aVar3.yKv.setText(i.b(aVar2.getContext(), aVar2.getString(R.l.dRr, new Object[]{t.ou(str2)}), aVar3.yKv.getTextSize()));
                    } else {
                        aVar3.yKv.setText(i.a(aVar2.getContext(), I.hdn));
                    }
                    aVar3.yKw.setText(I.hce);
                    aVar3.yKu.setImageResource(R.k.dxf);
                    break;
                case 3:
                    if (z) {
                        if (t.ov(I.hdn)) {
                            string = ac.getContext().getString(R.l.dRm);
                        } else {
                            string = ac.getContext().getString(R.l.dRm) + "-" + I.hdn;
                        }
                        aVar3.yKv.setText(i.a(aVar2.getContext(), string));
                    } else {
                        aVar3.yKv.setText(R.l.dRn);
                    }
                    aVar3.yKw.setText(I.hce);
                    aVar3.yKu.setImageResource(R.k.dxg);
                    a(aVar3);
                    break;
                case 4:
                    aVar3.yKw.setText(I.hce);
                    aVar3.yKu.setImageResource(R.k.dxh);
                    if (z) {
                        if (t.ov(I.hdn)) {
                            string = ac.getContext().getString(R.l.dRu);
                        } else {
                            string = ac.getContext().getString(R.l.dRu) + "-" + I.hdn;
                        }
                        aVar3.yKv.setText(i.a(aVar2.getContext(), string));
                    } else {
                        aVar3.yKv.setText(R.l.dRt);
                    }
                    a(aVar3);
                    break;
                case 5:
                    if (z) {
                        if (t.ov(I.hdn)) {
                            string = ac.getContext().getString(R.l.dRp);
                        } else {
                            string = ac.getContext().getString(R.l.dRp) + "-" + I.hdn;
                        }
                        aVar3.yKv.setText(i.a(aVar2.getContext(), string));
                    } else {
                        aVar3.yKv.setText(R.l.dRq);
                    }
                    aVar3.yKw.setText(I.hce);
                    aVar3.yKu.setImageResource(R.k.dxg);
                    a(aVar3);
                    break;
                case 6:
                    aVar3.yKv.setText(R.l.dRo);
                    aVar3.yKw.setText(I.hce);
                    aVar3.yKu.setImageResource(R.k.dxe);
                    a(aVar3);
                    break;
                default:
                    aVar3.yKu.setImageResource(R.k.dxf);
                    aVar3.yKv.setSingleLine(false);
                    aVar3.yKv.setMaxLines(2);
                    aVar3.yKw.setText(null);
                    aVar3.yKv.setText(I.description);
                    break;
            }
            aVar3.yIy.setOnClickListener(t(aVar2));
            aVar3.yIy.setOnLongClickListener(s(aVar2));
            aVar3.yIy.setOnTouchListener(aVar2.ysf.ysV);
            aVar3.yIy.setTag(new ar(auVar, this.yqa.ypn, i, null, (byte) 0));
        }
    }

    private static void a(k.a aVar) {
        int paddingLeft = aVar.yIy.getPaddingLeft();
        int paddingTop = aVar.yIy.getPaddingTop();
        int paddingRight = aVar.yIy.getPaddingRight();
        int paddingBottom = aVar.yIy.getPaddingBottom();
        aVar.yIy.setBackgroundResource(R.g.bAj);
        aVar.yIy.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        int i = ((ar) view.getTag()).position;
        String str = auVar.field_content;
        g.a aVar = null;
        if (str != null) {
            aVar = g.a.I(str, auVar.field_reserved);
        }
        if (aVar != null) {
            contextMenu.add(i, 100, 0, this.yqa.getString(R.l.dRH));
            if (aVar.hcd == 1) {
                contextMenu.add(i, 103, 0, this.yqa.getString(R.l.eQh));
            }
        }
        return false;
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        switch (menuItem.getItemId()) {
            case 100:
                ba.aK(auVar.field_msgId);
                return true;
            case 103:
                String str = auVar.field_content;
                g.a aVar2 = null;
                if (str != null) {
                    aVar2 = g.a.I(str, auVar.field_reserved);
                }
                if (aVar2 != null) {
                    String str2 = aVar2.hcf;
                    String str3 = auVar.field_talker;
                    int i = aVar2.hch;
                    int i2 = aVar2.fEZ;
                    String str4 = aVar2.fpP;
                    Context context = aVar.getContext();
                    String string = aVar.getString(R.l.eQg);
                    String string2 = aVar.getString(R.l.dGt);
                    String string3 = aVar.getString(R.l.eQh);
                    String string4 = aVar.getString(R.l.dEn);
                    1 1 = new 1(this, str2, str3, i, i2, str4, aVar);
                    h.a(context, string, string2, string3, string4, (OnClickListener) 1, new 2(this));
                }
                return true;
            default:
                return false;
        }
    }

    public final boolean b(View view, a aVar, au auVar) {
        String str = auVar.field_content;
        g.a aVar2 = null;
        if (str != null) {
            aVar2 = g.a.I(str, auVar.field_reserved);
        }
        if (aVar2 == null) {
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("sender_name", auVar.field_talker);
        switch (aVar2.hcd) {
            case 1:
            case 7:
                intent.putExtra("invalid_time", aVar2.hch);
                intent.putExtra("is_sender", true);
                intent.putExtra("appmsg_type", aVar2.hcd);
                intent.putExtra("transfer_id", aVar2.hcg);
                intent.putExtra("transaction_id", aVar2.hcf);
                intent.putExtra("effective_date", aVar2.hci);
                intent.putExtra("total_fee", aVar2.fEZ);
                intent.putExtra("fee_type", aVar2.fpP);
                if (q.Gf()) {
                    d.a(aVar, "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", intent, 221);
                    return true;
                }
                d.a(aVar, "remittance", ".ui.RemittanceDetailUI", intent, 221);
                return true;
            case 3:
            case 4:
            case 5:
            case 6:
                intent.putExtra("appmsg_type", aVar2.hcd);
                intent.putExtra("transfer_id", aVar2.hcg);
                intent.putExtra("transaction_id", aVar2.hcf);
                intent.putExtra("effective_date", aVar2.hci);
                intent.putExtra("total_fee", aVar2.fEZ);
                intent.putExtra("fee_type", aVar2.fpP);
                if (q.Gf()) {
                    d.b(aVar.getContext(), "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", intent);
                    return true;
                }
                d.b(aVar.getContext(), "remittance", ".ui.RemittanceDetailUI", intent);
                return true;
            default:
                x.w("MicroMsg.ChattingItemAppMsgRemittanceTo", "Unrecognized type %d, probably version to low & check update!", new Object[]{Integer.valueOf(aVar2.hcd)});
                t.bG(aVar.getContext());
                return true;
        }
    }
}
