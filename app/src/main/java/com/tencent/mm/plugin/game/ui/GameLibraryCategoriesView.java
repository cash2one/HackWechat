package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.o;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public class GameLibraryCategoriesView extends LinearLayout implements OnClickListener {
    private Context mContext;
    private LinearLayout muI;
    int ndn;
    private int nsc;
    private int nsd;

    public GameLibraryCategoriesView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.muI = (LinearLayout) findViewById(R.h.cmC);
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        this.nsc = (width * 100) / 750;
        this.nsd = (width - (this.nsc * 6)) / 14;
        this.muI.setPadding(this.nsd, a.fromDPToPix(this.mContext, 12), this.nsd, a.fromDPToPix(this.mContext, 12));
    }

    public final void H(LinkedList<a> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            x.e("MicroMsg.GameLibraryCategoriesView", "No categories");
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.muI.removeAllViews();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            View linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            View imageView = new ImageView(this.mContext);
            ScaleType scaleType = ScaleType.MATRIX;
            imageView.setScaleType(ScaleType.FIT_XY);
            com.tencent.mm.aq.a.a PA = o.PA();
            String str = aVar.iKm;
            c.a aVar2 = new c.a();
            aVar2.hDz = true;
            PA.a(str, imageView, aVar2.PK());
            linearLayout.addView(imageView, this.nsc, this.nsc);
            imageView = new TextView(this.mContext);
            imageView.setText(aVar.nsf);
            imageView.setTextSize(1, 14.0f);
            imageView.setTextColor(getResources().getColor(R.e.bsO));
            imageView.setSingleLine(true);
            imageView.setEllipsize(TruncateAt.END);
            imageView.setGravity(17);
            imageView.setLayoutParams(new LayoutParams(-1, -2));
            imageView.setPadding(0, a.fromDPToPix(this.mContext, 6), 0, 0);
            linearLayout.addView(imageView);
            linearLayout.setTag(aVar);
            linearLayout.setOnClickListener(this);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(this.nsd, 0, this.nsd, 0);
            this.muI.addView(linearLayout, layoutParams);
        }
    }

    public void onClick(View view) {
        if (view.getTag() instanceof a) {
            a aVar = (a) view.getTag();
            int i = 7;
            if (bh.ov(aVar.nsg)) {
                Intent intent = new Intent(this.mContext, GameCategoryUI.class);
                intent.putExtra("extra_type", 1);
                intent.putExtra("extra_category_id", aVar.nse);
                intent.putExtra("extra_category_name", aVar.nsf);
                intent.putExtra("game_report_from_scene", aVar.nse + 100);
                this.mContext.startActivity(intent);
                i = 6;
            } else {
                com.tencent.mm.plugin.game.d.c.ac(this.mContext, aVar.nsg);
            }
            ap.a(this.mContext, 11, aVar.nse + 100, aVar.position, i, this.ndn, null);
        }
    }
}
