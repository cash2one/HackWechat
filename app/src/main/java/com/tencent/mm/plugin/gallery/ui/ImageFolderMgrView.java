package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;

public class ImageFolderMgrView extends LinearLayout implements OnItemClickListener, com.tencent.mm.plugin.gallery.model.g.a {
    boolean Od = false;
    a mTt = null;
    FrameLayout mTu;
    private View mTv;
    private ListView mTw;
    private b mTx;
    boolean mTy = false;

    public interface a {
        void b(AlbumItem albumItem);
    }

    public ImageFolderMgrView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.mTu = new FrameLayout(getContext());
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.mTu.setVisibility(8);
        addView(this.mTu, layoutParams);
        this.mTv = new View(getContext());
        this.mTv.setBackgroundColor(-872415232);
        this.mTv.setOnClickListener(new 3(this));
        this.mTu.addView(this.mTv, new FrameLayout.LayoutParams(-1, -1));
        this.mTw = new ListView(getContext());
        this.mTw.setCacheColorHint(0);
        this.mTw.setBackgroundResource(R.e.btq);
        this.mTw.setSelector(R.g.bDJ);
        this.mTw.setOnItemClickListener(this);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.f.bvJ);
        this.mTw.setPadding(dimensionPixelSize, dimensionPixelSize / 3, dimensionPixelSize, (dimensionPixelSize * 2) / 3);
        layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = getResources().getDimensionPixelSize(R.f.buG);
        layoutParams.gravity = 80;
        this.mTu.addView(this.mTw, layoutParams);
        this.mTx = new b(getContext(), c.aNE().aOi());
        this.mTw.setAdapter(this.mTx);
    }

    public final void aOs() {
        fr(!this.Od);
    }

    private void fr(boolean z) {
        if (this.Od == z) {
            x.d("MicroMsg.ImageFolderMgrView", "want to expand, but same status, expanded %B", new Object[]{Boolean.valueOf(this.Od)});
        } else if (this.mTy) {
            x.d("MicroMsg.ImageFolderMgrView", "want to expand[%B], but now in animation", new Object[]{Boolean.valueOf(z)});
        } else if (this.Od) {
            this.mTy = true;
            r0 = AnimationUtils.loadAnimation(getContext(), R.a.bqm);
            r0.setAnimationListener(new 1(this));
            this.mTw.startAnimation(r0);
            this.mTv.startAnimation(AnimationUtils.loadAnimation(getContext(), R.a.bqa));
        } else {
            this.mTy = true;
            this.mTu.setVisibility(0);
            this.mTv.startAnimation(AnimationUtils.loadAnimation(getContext(), R.a.bpZ));
            r0 = AnimationUtils.loadAnimation(getContext(), R.a.bqo);
            r0.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ ImageFolderMgrView mTz;

                {
                    this.mTz = r1;
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    this.mTz.Od = true;
                    this.mTz.mTy = false;
                }
            });
            this.mTw.startAnimation(r0);
        }
    }

    public final void x(ArrayList<AlbumItem> arrayList) {
        b bVar = this.mTx;
        bVar.mTa = arrayList;
        if (!(bVar.mTa == null || bVar.mTa.isEmpty() || ((AlbumItem) bVar.mTa.get(0)).mRc == null)) {
            Iterator it = bVar.mTa.iterator();
            AlbumItem albumItem = null;
            while (it.hasNext()) {
                AlbumItem albumItem2 = (AlbumItem) it.next();
                if (albumItem == null) {
                    albumItem = albumItem2;
                } else {
                    if (albumItem.mRc.mRg >= albumItem2.mRc.mRg) {
                        albumItem2 = albumItem;
                    }
                    albumItem = albumItem2;
                }
            }
            if (albumItem != null) {
                bVar.mTb.mRc = albumItem.mRc;
            }
        }
        c.aNF().y(new 4(this));
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AlbumItem qw = this.mTx.qw(i);
        if (qw == null) {
            x.d("MicroMsg.ImageFolderMgrView", "get folder failed:" + i);
            return;
        }
        if (this.mTt != null) {
            this.mTt.b(qw);
        }
        this.mTx.mTc = bh.az(qw.mRb, "");
        this.mTw.setSelection(0);
        this.mTx.notifyDataSetChanged();
        this.mTv.performClick();
    }
}
