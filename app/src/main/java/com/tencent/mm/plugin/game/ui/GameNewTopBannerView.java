package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class GameNewTopBannerView extends FrameLayout implements OnClickListener {
    String jcA = null;
    Context mContext;
    int ndn;
    ImageView nmJ;
    ImageView nmK;
    int ntM;
    int ntN;
    String ntO = "";
    private String ntP = "";

    public GameNewTopBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.nmJ = (ImageView) findViewById(R.h.bMX);
        this.nmK = (ImageView) findViewById(R.h.cOM);
        x.i("MicroMsg.GameTopBannerView", "initView finished");
    }

    final int b(ImageView imageView, int i, int i2) {
        int screenWidth = c.getScreenWidth(this.mContext);
        LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams == null) {
            x.e("MicroMsg.GameTopBannerView", "resizeGameThemePic, params is null");
            return 0;
        }
        layoutParams.height = (int) (((float) screenWidth) * (((float) i) / ((float) i2)));
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ScaleType.FIT_XY);
        return layoutParams.height;
    }

    public void onClick(View view) {
        if (view.getTag() != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!bh.ov(str)) {
                ap.a(this.mContext, 10, 1017, 1, c.p(this.mContext, str, "game_center_top_banner"), 0, null, this.ndn, 0, null, null, this.jcA);
            }
        }
    }

    static void aRJ() {
        GameIndexListView.qS(0);
        GameIndexListView.qX(0);
        GameIndexListView.fG(false);
    }
}
