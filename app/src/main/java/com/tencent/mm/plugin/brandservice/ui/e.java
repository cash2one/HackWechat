package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.sortview.a;
import com.tencent.mm.ui.base.sortview.a.b;

public final class e extends a {
    private static b kFf;
    long kFk;
    String kFl;
    String kGI;
    int wn;

    public e(Object obj, long j, int i, String str) {
        super(2, null);
        this.kFk = j;
        this.kFl = str;
        this.wn = i;
    }

    public final b asm() {
        if (kFf == null) {
            kFf = new b(this) {
                final /* synthetic */ e kGJ;

                {
                    this.kGJ = r1;
                }

                public final boolean a(Context context, a aVar, Object... objArr) {
                    if (!(context == null || aVar == null)) {
                        int i = 0;
                        if (objArr != null && objArr.length >= 2 && (objArr[1] instanceof Integer)) {
                            i = ((Integer) objArr[1]).intValue();
                        }
                        e eVar = (e) aVar;
                        Intent intent = new Intent(context, BizSearchDetailPageUI.class);
                        intent.putExtra("keyword", eVar.kFl);
                        intent.putExtra("businessType", eVar.kFk);
                        intent.putExtra("offset", eVar.wn);
                        intent.putExtra("showEditText", true);
                        intent.putExtra("fromScene", i);
                        context.startActivity(intent);
                    }
                    return true;
                }

                public final View b(Context context, View view) {
                    if (view == null) {
                        return View.inflate(context, R.i.dru, null);
                    }
                    return view;
                }

                public final void a(Context context, a.a aVar, a aVar2) {
                    if (context == null || aVar == null || aVar2 == null) {
                        x.e("MicroMsg.ReadMoreBtnDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
                    } else if (!(aVar instanceof a)) {
                        x.e("MicroMsg.ReadMoreBtnDataItem", "The ViewHolder is not a instance of MoreBtnViewHolder.");
                    } else if (aVar2 instanceof e) {
                        ((a) aVar).jCQ.setText(((e) aVar2).kGI);
                    } else {
                        x.e("MicroMsg.ReadMoreBtnDataItem", "The DataItem is not a instance of MoreBtnDataItem.");
                    }
                }

                public final void a(View view, a.a aVar) {
                    if (view != null && aVar != null && (aVar instanceof a)) {
                        ((a) aVar).jCQ = (TextView) view.findViewById(R.h.cRZ);
                    }
                }
            };
        }
        return kFf;
    }

    public final a.a asn() {
        return new a();
    }

    public final void a(Context context, a.a aVar, Object... objArr) {
        this.kGI = "";
    }
}
