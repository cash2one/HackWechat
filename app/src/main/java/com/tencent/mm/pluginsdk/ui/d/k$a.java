package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mars.comm.PlatformComm.C2Java;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;
import java.util.List;
import junit.framework.Assert;

class k$a extends BaseAdapter {
    private Context mContext = null;
    private List<String> not = null;
    private Bundle rG = null;
    private OnDismissListener vuP = null;
    a vuQ = null;

    public interface a {
        void gf(boolean z);
    }

    public k$a(List<String> list, Context context, OnDismissListener onDismissListener, Bundle bundle) {
        Assert.assertTrue(context != null);
        this.not = list;
        this.mContext = context;
        this.vuP = onDismissListener;
        this.rG = bundle;
    }

    public final int getCount() {
        return this.not == null ? 0 : this.not.size();
    }

    public final Object getItem(int i) {
        return this.not.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getViewTypeCount() {
        return 2;
    }

    public final int getItemViewType(int i) {
        if (this.mContext.getString(R.l.dSt).equals((String) this.not.get(i))) {
            return 1;
        }
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        Object obj;
        String str = (String) getItem(i);
        int itemViewType = getItemViewType(i);
        if (view == null) {
            Object bVar;
            View view2;
            LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
            View inflate;
            if (itemViewType == 1) {
                inflate = layoutInflater.inflate(R.i.ddJ, viewGroup, false);
                bVar = new b(this, (byte) 0);
                ((b) bVar).jpW = (TextView) inflate.findViewById(R.h.title);
                ((b) bVar).mvY = (Button) inflate.findViewById(R.h.ccw);
                ((b) bVar).vuS = (TextView) inflate.findViewById(R.h.cRT);
                view2 = inflate;
            } else {
                inflate = layoutInflater.inflate(R.i.ddK, viewGroup, false);
                bVar = new c(this, (byte) 0);
                ((c) bVar).jpW = (TextView) inflate.findViewById(R.h.title);
                view2 = inflate;
            }
            view2.setTag(bVar);
            view = view2;
            obj = bVar;
        } else {
            obj = view.getTag();
        }
        switch (itemViewType) {
            case 0:
                c cVar = (c) obj;
                cVar.jpW.setText(i.b(this.mContext, bh.ou(str), cVar.jpW.getTextSize()));
                break;
            case 1:
                b bVar2 = (b) obj;
                bVar2.jpW.setText(i.b(this.mContext, bh.ou(str), bVar2.jpW.getTextSize()));
                bVar2.vuS.setText(this.mContext.getString(R.l.dSz));
                bVar2.mvY.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ k$a vuR;

                    {
                        this.vuR = r1;
                    }

                    public final void onClick(View view) {
                        if (C2Java.isNetworkConnected()) {
                            p.d(this.vuR.mContext, this.vuR.rG);
                            if (this.vuR.vuQ != null) {
                                this.vuR.vuQ.gf(true);
                                return;
                            }
                            return;
                        }
                        x.w("MicroMsg.MailPhoneMenuHelper", "hy: no network. abort download");
                        u.makeText(this.vuR.mContext, this.vuR.mContext.getString(R.l.eiE), 0).show();
                        if (this.vuR.vuQ != null) {
                            this.vuR.vuQ.gf(false);
                        }
                    }
                });
                break;
            default:
                x.e("MicroMsg.MailPhoneMenuHelper", "hy: error tag");
                break;
        }
        return view;
    }
}
