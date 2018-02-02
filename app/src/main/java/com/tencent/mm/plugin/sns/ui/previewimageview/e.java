package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.ui.w;
import com.tencent.mm.plugin.sns.ui.w.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.List;

public final class e implements w {
    private Context context;
    private ImageView rEt;
    private boolean rQp;
    c rQq;
    DynamicGridView rQr;
    a rQs;
    float rQt;
    View rQu;
    ImageView rQv;
    private View rQw;
    Rect rQx;
    TextView rth;

    static /* synthetic */ void a(e eVar) {
        eVar.rQw.setVisibility(8);
        ac.cft().edit().putBoolean("key_show_tips", false).commit();
    }

    static /* synthetic */ void b(e eVar) {
        eVar.rQu.setBackgroundColor(Color.parseColor("#e64340"));
        eVar.rQv.setImageResource(i.qJa);
        eVar.rth.setText("拖动到此处删除");
    }

    public e(View view, View view2, View view3, Context context, List<String> list, DynamicGridView dynamicGridView, a aVar, c$a com_tencent_mm_plugin_sns_ui_previewimageview_c_a, boolean z) {
        this.rQp = z;
        this.context = context;
        this.rQs = aVar;
        this.rQu = view2;
        this.rQw = view3;
        this.rQr = dynamicGridView;
        this.rQv = (ImageView) view2.findViewById(f.qBO);
        this.rth = (TextView) view2.findViewById(f.qBQ);
        dynamicGridView.rQU = false;
        dynamicGridView.setColumnWidth(context.getResources().getDimensionPixelSize(d.qyP) + (context.getResources().getDimensionPixelSize(d.qyO) * 2));
        dynamicGridView.setNumColumns(4);
        dynamicGridView.setOverScrollMode(2);
        dynamicGridView.setStretchMode(0);
        dynamicGridView.setClipChildren(false);
        dynamicGridView.setClipToPadding(false);
        dynamicGridView.setSelector(new ColorDrawable(0));
        this.rQq = new c(context, list, 9, z, com_tencent_mm_plugin_sns_ui_previewimageview_c_a);
        bCr();
        dynamicGridView.setAdapter(this.rQq);
        dynamicGridView.rQY = new 1(this, dynamicGridView);
        dynamicGridView.setOnItemLongClickListener(new 2(this));
        dynamicGridView.setOnItemClickListener(new 3(this));
        dynamicGridView.rQX = new 4(this, dynamicGridView, view);
        dynamicGridView.getViewTreeObserver().addOnPreDrawListener(new 5(this, dynamicGridView, context, view));
    }

    private void bCr() {
        if (!ac.cft().getBoolean("key_show_tips", true) || this.rQq.bCq() <= 1) {
            this.rQw.setVisibility(8);
            return;
        }
        this.rQw.setVisibility(0);
        this.rEt = (ImageView) this.rQw.findViewById(f.qEx);
        this.rEt.setOnClickListener(new 6(this));
    }

    public final void bzs() {
        this.rQp = false;
    }

    public final void a(a aVar) {
        this.rQs = aVar;
    }

    public final View getView() {
        return this.rQr;
    }

    public final void bU(List<String> list) {
        if (this.rQq != null) {
            this.rQq.bZ(list);
            bCr();
        }
    }

    public final void clean() {
        if (this.rQr != null && this.rQr.getAdapter() == null) {
            ((c) this.rQr.getAdapter()).rvY = true;
        }
    }
}
