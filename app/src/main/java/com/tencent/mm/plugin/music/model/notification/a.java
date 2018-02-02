package com.tencent.mm.plugin.music.model.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Looper;
import android.support.v4.app.z.d;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.a.js;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.plugin.music.ui.MusicMainUI;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;

public final class a {
    boolean isInit = false;
    MMMusicPlayerService oLT;
    NotificationManager oLU;
    Runnable oLV = new Runnable(this) {
        final /* synthetic */ a oLX;

        {
            this.oLX = r1;
        }

        public final void run() {
            x.i("MicroMsg.Music.MMMusicNotification", "close");
            ag.K(this.oLX.oLV);
            this.oLX.oLT.stopForeground(true);
        }
    };
    BroadcastReceiver oLW;

    public static void a(com.tencent.mm.av.a aVar, int i, boolean z) {
        x.i("MicroMsg.Music.MMMusicNotification", "sendMusicPlayerEvent action:%d", new Object[]{Integer.valueOf(i)});
        b jsVar = new js();
        jsVar.fAz.action = i;
        jsVar.fAz.state = "";
        jsVar.fAz.fAv = aVar.Qn();
        jsVar.fAz.appId = "not from app brand appid";
        jsVar.fAz.fAB = z;
        com.tencent.mm.sdk.b.a.xef.a(jsVar, Looper.getMainLooper());
    }

    final Notification a(Context context, com.tencent.mm.av.a aVar, boolean z) {
        Bitmap bitmap;
        int i;
        Intent intent = new Intent(context, MusicMainUI.class);
        intent.putExtra("key_scene", 5);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 134217728);
        d dVar = new d(context);
        dVar.sa = activity;
        d U = dVar.U(com.tencent.mm.bl.a.bXV());
        CharSequence charSequence = aVar.field_songName;
        String str = aVar.field_songSinger;
        if (bh.ov(aVar.field_songAlbum)) {
            Object obj = str;
        } else {
            CharSequence charSequence2 = str + aVar.field_songAlbum;
        }
        if (aVar == null) {
            x.e("MicroMsg.Music.MMMusicNotification", "music is null, return");
            bitmap = null;
        } else {
            bitmap = null;
            x.i("MicroMsg.Music.MMMusicNotification", "music.field_musicType %d", new Object[]{Integer.valueOf(aVar.field_musicType)});
            switch (aVar.field_musicType) {
                case 0:
                case 5:
                case 7:
                case 10:
                case 11:
                    bitmap = o.Pw().a(aVar.field_songAlbumLocalPath, com.tencent.mm.bv.a.getDensity(this.oLT), true);
                    break;
                case 1:
                case 8:
                case 9:
                    aqr com_tencent_mm_protocal_c_aqr = new aqr();
                    com_tencent_mm_protocal_c_aqr.nGJ = aVar.field_songMediaId;
                    com_tencent_mm_protocal_c_aqr.wxE = aVar.field_songAlbumUrl;
                    com_tencent_mm_protocal_c_aqr.wxF = aVar.field_songAlbumType;
                    com_tencent_mm_protocal_c_aqr.nfX = com_tencent_mm_protocal_c_aqr.wxE;
                    if (n.qQy != null) {
                        bitmap = n.qQy.b(com_tencent_mm_protocal_c_aqr);
                        break;
                    }
                    break;
                case 6:
                    bitmap = o.Pw().b(aVar.field_songAlbumLocalPath, com.tencent.mm.bv.a.getDensity(this.oLT), true);
                    break;
            }
            if (bitmap == null) {
                bitmap = o.PA().lz(aVar.field_songAlbumUrl);
                if (bitmap == null) {
                    String c = g.c(aVar, false);
                    com.tencent.mm.aq.a.a.c.a aVar2 = new com.tencent.mm.aq.a.a.c.a();
                    aVar2.hDC = g.c(aVar, false);
                    aVar2.hDA = true;
                    aVar2.bc(com.tencent.mm.bv.a.aa(this.oLT, R.f.notification_large_icon_width), com.tencent.mm.bv.a.aa(this.oLT, R.f.notification_large_icon_height));
                    aVar2.hDy = true;
                    o.PA().a(aVar.field_songAlbumUrl, aVar2.PK(), new 3(this, aVar, c));
                }
            }
            bitmap = com.tencent.mm.sdk.platformtools.d.a(bitmap, false, 12.0f, false);
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.i.dqN);
        if (bitmap != null) {
            remoteViews.setImageViewBitmap(R.h.cyk, bitmap);
        } else {
            remoteViews.setImageViewResource(R.h.cyk, R.g.bBD);
        }
        if (bh.ov(charSequence)) {
            remoteViews.setViewVisibility(R.h.cyq, 8);
        } else {
            remoteViews.setViewVisibility(R.h.cyq, 0);
            remoteViews.setTextViewText(R.h.cyq, charSequence);
        }
        if (bh.ov(charSequence2)) {
            remoteViews.setViewVisibility(R.h.cym, 8);
        } else {
            remoteViews.setViewVisibility(R.h.cym, 0);
            remoteViews.setTextViewText(R.h.cym, charSequence2);
        }
        Context context2 = this.oLT;
        RemoteViews remoteViews2 = new d(context2).build().contentView;
        if (remoteViews2 == null) {
            i = WebView.NIGHT_MODE_COLOR;
        } else {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context2).inflate(remoteViews2.getLayoutId(), null);
            TextView textView = (TextView) viewGroup.findViewById(16908310);
            i = textView != null ? textView.getCurrentTextColor() : h(viewGroup);
        }
        i |= WebView.NIGHT_MODE_COLOR;
        int red = Color.red(WebView.NIGHT_MODE_COLOR) - Color.red(i);
        int green = Color.green(WebView.NIGHT_MODE_COLOR) - Color.green(i);
        i = Color.blue(WebView.NIGHT_MODE_COLOR) - Color.blue(i);
        Object obj2 = Math.sqrt((double) ((i * i) + ((red * red) + (green * green)))) < 180.0d ? 1 : null;
        Intent intent2 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
        intent2.putExtra("mm_music_notification_action_key", "mm_music_notification_action_pre");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent2, 134217728);
        remoteViews.setImageViewResource(R.h.cyp, obj2 != null ? R.g.bFq : R.g.bFr);
        remoteViews.setOnClickPendingIntent(R.h.cyp, broadcast);
        intent2 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
        if (z) {
            intent2.putExtra("mm_music_notification_action_key", "mm_music_notification_action_pause");
        } else {
            intent2.putExtra("mm_music_notification_action_key", "mm_music_notification_action_play");
        }
        broadcast = PendingIntent.getBroadcast(context, 1, intent2, 134217728);
        int i2 = R.h.cyo;
        red = z ? obj2 != null ? R.g.bFm : R.g.bFn : obj2 != null ? R.g.bFo : R.g.bFp;
        remoteViews.setImageViewResource(i2, red);
        remoteViews.setOnClickPendingIntent(R.h.cyo, broadcast);
        intent2 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
        intent2.putExtra("mm_music_notification_action_key", "mm_music_notification_action_next");
        broadcast = PendingIntent.getBroadcast(context, 2, intent2, 134217728);
        remoteViews.setImageViewResource(R.h.cyn, obj2 != null ? R.g.bFk : R.g.bFl);
        remoteViews.setOnClickPendingIntent(R.h.cyn, broadcast);
        intent2 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
        intent2.putExtra("mm_music_notification_action_key", "mm_music_notification_action_close");
        PendingIntent broadcast2 = PendingIntent.getBroadcast(context, 3, intent2, 134217728);
        remoteViews.setImageViewResource(R.h.cyl, obj2 != null ? R.g.bFi : R.g.bFj);
        remoteViews.setOnClickPendingIntent(R.h.cyl, broadcast2);
        U.sx.contentView = remoteViews;
        return U.build();
    }

    private static int h(ViewGroup viewGroup) {
        List<TextView> arrayList = new ArrayList();
        a(viewGroup, arrayList);
        TextView textView = null;
        for (TextView textView2 : arrayList) {
            TextView textView22;
            if (textView22.getTextSize() <= -1.0f) {
                textView22 = textView;
            }
            textView = textView22;
        }
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return WebView.NIGHT_MODE_COLOR;
    }

    private static void a(View view, List<TextView> list) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i), list);
            }
        } else if (view instanceof TextView) {
            list.add((TextView) view);
        }
    }
}
