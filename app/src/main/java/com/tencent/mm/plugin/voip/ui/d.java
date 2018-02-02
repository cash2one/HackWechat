package com.tencent.mm.plugin.voip.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.bs;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.lang.ref.WeakReference;

public abstract class d extends Fragment {
    protected static int mScreenHeight;
    protected static int mScreenWidth;
    protected static final int[] sqb = new int[]{-1, R.l.eVE, R.l.eVO, R.l.eVN};
    protected String gAb;
    protected af jKT;
    protected int mStatus = -1;
    protected boolean slT;
    protected WeakReference<c> spN;
    protected long spP = -1;
    protected RelativeLayout sqc;
    protected ImageView sqd;
    protected ImageView sqe;
    protected int sqf = Downloads.RECV_BUFFER_SIZE;
    protected d sqg;
    protected c sqh = new c();
    private a sqi;
    private b sqj;

    public class b implements Runnable {
        final /* synthetic */ d sqk;

        public b(d dVar) {
            this.sqk = dVar;
        }

        public final void run() {
            x.i("MicroMsg.VoipBaseFragment", "try create blur bitmap,timestamp: " + System.currentTimeMillis());
            final Bitmap CZ = com.tencent.mm.sdk.platformtools.d.CZ(R.g.bHN);
            x.i("MicroMsg.VoipBaseFragment", "blur transparent ok, timestamp: " + System.currentTimeMillis());
            this.sqk.jKT.post(new Runnable(this) {
                final /* synthetic */ b sqn;

                public final void run() {
                    if (this.sqn.sqk.sqe != null) {
                        this.sqn.sqk.sqe.setBackgroundDrawable(new BitmapDrawable(CZ));
                        this.sqn.sqk.sqe.getBackground().setAlpha(bs.CTRL_INDEX);
                        this.sqn.sqk.sqe.getBackground().setFilterBitmap(true);
                    }
                    this.sqn.sqk.sqj = null;
                }
            });
        }
    }

    public interface d {
        void D(boolean z, boolean z2);
    }

    protected abstract void MD(String str);

    public abstract void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6);

    public abstract void b(int i, int i2, int[] iArr);

    public abstract void b(CaptureView captureView);

    public abstract void bGZ();

    protected abstract void bIc();

    protected abstract void bId();

    protected abstract void co(String str, int i);

    public abstract void setMute(boolean z);

    public abstract void yL(int i);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.gAb = arguments.getString("key_username");
        this.slT = arguments.getBoolean("key_isoutcall");
        if (-1 == this.mStatus) {
            this.mStatus = arguments.getInt("key_status");
        }
        this.jKT = new af();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Display defaultDisplay;
        if (VERSION.SDK_INT >= 23) {
            defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            mScreenWidth = displayMetrics.widthPixels;
            mScreenHeight = displayMetrics.heightPixels;
        } else if (mScreenWidth == 0) {
            defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            mScreenWidth = defaultDisplay.getWidth();
            mScreenHeight = defaultDisplay.getHeight();
        }
    }

    public void dQ(int i, int i2) {
        this.sqf = i;
        this.mStatus = i2;
    }

    public final void ff(long j) {
        this.spP = j;
    }

    public void uninit() {
        x.d("MicroMsg.VoipBaseFragment", "uninit");
        this.sqh.bIg();
        c cVar = this.sqh;
        x.d("MicroMsg.DynamicTextWrap", "uninit");
        cVar.bIg();
        cVar.ikI = null;
        if (this.sqi != null) {
            e.remove(this.sqi);
            this.sqi = null;
        }
        if (this.sqj != null) {
            e.remove(this.sqj);
            this.sqj = null;
        }
    }

    public void onDetach() {
        if (this.jKT != null) {
            this.jKT.removeCallbacksAndMessages(null);
        }
        this.sqg = null;
        super.onDetach();
    }

    public final void a(c cVar) {
        this.spN = new WeakReference(cVar);
    }

    public final void a(d dVar) {
        this.sqg = dVar;
    }

    protected final void b(TextView textView, String str) {
        if (textView == null || bh.ov(str)) {
            x.e("MicroMsg.VoipBaseFragment", "TextView is null or text is null");
            return;
        }
        textView.setText(str);
        textView.measure(MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().widthPixels, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().heightPixels, Integer.MIN_VALUE));
        textView.setWidth(textView.getMeasuredWidth());
    }

    public void onStop() {
        super.onStop();
    }

    protected final void bIe() {
        if (this.gAb != null && this.sqd.getVisibility() != 0) {
            this.sqd.setVisibility(0);
            this.sqi = new a(this);
            e.post(this.sqi, "VoipBaseFragment_blurbitmap");
        }
    }

    protected final void bIf() {
        this.sqe.setVisibility(0);
        this.sqj = new b(this);
        e.post(this.sqj, "VoipBaseFragment_blurtransparentbitmap");
    }

    protected static String bp(long j) {
        return String.format("%02d:%02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)});
    }

    protected static void F(View view, int i) {
        if (view != null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.topMargin += i;
            view.setLayoutParams(layoutParams);
        }
    }
}
