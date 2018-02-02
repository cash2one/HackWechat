package com.tencent.mm.plugin.gallery.ui;

import android.media.MediaMetadataRetriever;
import android.os.Looper;
import android.widget.TextView;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map.Entry;

class a$c implements Runnable {
    private static HashMap<TextView, a$c> mRV = new HashMap();
    private VideoMediaItem mRT;
    private a mRU;
    private WeakReference<TextView> mjv;

    private a$c(TextView textView, VideoMediaItem videoMediaItem, a aVar) {
        this.mjv = new WeakReference(textView);
        this.mRT = videoMediaItem;
        this.mRU = aVar;
    }

    private void f(TextView textView) {
        this.mjv = new WeakReference(textView);
    }

    static void a(TextView textView, VideoMediaItem videoMediaItem) {
        Entry entry = null;
        if (textView == null || videoMediaItem == null) {
            x.e("MicroMsg.AlbumAdapter", "Error input for duration fetcher");
            return;
        }
        if (mRV.containsKey(textView)) {
            a$c com_tencent_mm_plugin_gallery_ui_a_c = (a$c) mRV.get(textView);
            if (!com_tencent_mm_plugin_gallery_ui_a_c.mRT.equals(videoMediaItem)) {
                if (textView.equals(com_tencent_mm_plugin_gallery_ui_a_c.mjv.get())) {
                    com_tencent_mm_plugin_gallery_ui_a_c.f(null);
                }
            } else {
                return;
            }
        }
        if (videoMediaItem.hOr >= 0) {
            x.i("MicroMsg.AlbumAdapter", "Directly attach durationMs %d to tv, path %s", new Object[]{Integer.valueOf(videoMediaItem.hOr), videoMediaItem});
            c(textView, videoMediaItem.hOr);
            mRV.remove(textView);
            return;
        }
        textView.setText("");
        Runnable com_tencent_mm_plugin_gallery_ui_a_c2 = new a$c(textView, videoMediaItem, new 2());
        if (e.V(com_tencent_mm_plugin_gallery_ui_a_c2)) {
            x.i("MicroMsg.AlbumAdapter", "task has post to thread pool");
            for (Entry entry2 : mRV.entrySet()) {
                if (com_tencent_mm_plugin_gallery_ui_a_c2.equals(entry2.getValue())) {
                    entry = entry2;
                    break;
                }
            }
            if (entry == null || entry.getValue() == null) {
                x.e("MicroMsg.AlbumAdapter", "no entry found");
                return;
            }
            ((a$c) entry.getValue()).f(textView);
            mRV.remove(entry.getKey());
            mRV.put(textView, entry.getValue());
            return;
        }
        e.post(com_tencent_mm_plugin_gallery_ui_a_c2, "load_duration_for_" + videoMediaItem.hOo);
        mRV.put(textView, com_tencent_mm_plugin_gallery_ui_a_c2);
    }

    private static void c(TextView textView, int i) {
        if (textView != null) {
            if (i < 0) {
                textView.setText("--:--");
                return;
            }
            int round = Math.round(((float) i) / 1000.0f);
            textView.setText(String.format(Locale.CHINA, "%d:%02d", new Object[]{Integer.valueOf(round / 60), Integer.valueOf(round % 60)}));
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof a$c)) {
            return false;
        }
        return this.mRT.equals(((a$c) obj).mRT);
    }

    public final int hashCode() {
        return this.mRT.hashCode();
    }

    public final void run() {
        MediaMetadataRetriever mediaMetadataRetriever;
        Throwable e;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(this.mRT.aNV());
                this.mRT.hOr = bh.getInt(mediaMetadataRetriever.extractMetadata(9), -1);
                try {
                    mediaMetadataRetriever.release();
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.AlbumAdapter", e2, "%s", new Object[]{e2.getMessage()});
                }
            } catch (Exception e3) {
                e2 = e3;
                try {
                    x.printErrStackTrace("MicroMsg.AlbumAdapter", e2, "Analysis duration of mediaItem %s error %s", new Object[]{this.mRT.hOo, e2.getMessage()});
                    if (mediaMetadataRetriever != null) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Throwable e22) {
                            x.printErrStackTrace("MicroMsg.AlbumAdapter", e22, "%s", new Object[]{e22.getMessage()});
                        }
                    }
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        ag.y(new 1(this));
                    } else if (this.mRU == null) {
                        this.mRU.a(this, this.mRT.hOr);
                    }
                } catch (Throwable th) {
                    e22 = th;
                    if (mediaMetadataRetriever != null) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Throwable e4) {
                            x.printErrStackTrace("MicroMsg.AlbumAdapter", e4, "%s", new Object[]{e4.getMessage()});
                        }
                    }
                    throw e22;
                }
            }
        } catch (Exception e5) {
            e22 = e5;
            mediaMetadataRetriever = null;
            x.printErrStackTrace("MicroMsg.AlbumAdapter", e22, "Analysis duration of mediaItem %s error %s", new Object[]{this.mRT.hOo, e22.getMessage()});
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                ag.y(new 1(this));
            } else if (this.mRU == null) {
                this.mRU.a(this, this.mRT.hOr);
            }
        } catch (Throwable th2) {
            e22 = th2;
            mediaMetadataRetriever = null;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            throw e22;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ag.y(new 1(this));
        } else if (this.mRU == null) {
            this.mRU.a(this, this.mRT.hOr);
        }
    }
}
