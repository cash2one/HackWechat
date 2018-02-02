package com.tencent.mm.compatible.i;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.media.MediaPlayer;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore.Video.Media;
import android.provider.MediaStore.Video.Thumbnails;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    @TargetApi(5)
    public static String i(Context context, Intent intent) {
        Cursor cursor = null;
        if (intent == null || intent.getData() == null) {
            x.e("MicroMsg.GetVideoMetadata", "input invalid");
            return null;
        }
        long Wq = bh.Wq();
        String dataString = intent.getDataString();
        x.i("MicroMsg.GetVideoMetadata", "get video file name, dataString " + dataString);
        if (dataString == null) {
            x.e("MicroMsg.GetVideoMetadata", "dataString empty");
            return null;
        }
        String str;
        ContentResolver contentResolver = context.getContentResolver();
        if (dataString.startsWith(Media.EXTERNAL_CONTENT_URI.toString())) {
            cursor = contentResolver.query(intent.getData(), null, null, null, null);
            str = null;
        } else {
            String f;
            if (dataString.startsWith("content://")) {
                f = bh.f(context, intent.getData());
            } else if (dataString.startsWith("file://")) {
                if (intent.getExtras() != null) {
                    Uri uri = (Uri) intent.getExtras().getParcelable("android.intent.extra.STREAM");
                    if (!(uri == null || bh.ov(uri.getPath()))) {
                        f = uri.getPath();
                        if (f == null) {
                            f = dataString.substring(7);
                        }
                    }
                }
                f = null;
                if (f == null) {
                    f = dataString.substring(7);
                }
            } else {
                f = null;
            }
            if (f != null) {
                r6 = f.startsWith("/storage/emulated/legacy") ? h.getExternalStorageDirectory().getAbsolutePath() + f.substring(24) : f.startsWith("/sdcard") ? h.getExternalStorageDirectory().getAbsolutePath() + f.substring(7) : f;
                cursor = contentResolver.query(Media.EXTERNAL_CONTENT_URI, null, "_data LIKE " + DatabaseUtils.sqlEscapeString(r6), null, null);
                str = r6;
            } else {
                str = f;
            }
        }
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                if (str == null) {
                    str = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                }
            }
            cursor.close();
        }
        x.i("MicroMsg.GetVideoMetadata", "get video filename:" + str + ", cost time: " + bh.bA(Wq));
        return str;
    }

    @TargetApi(5)
    public static a j(Context context, Intent intent) {
        if (intent == null || intent.getData() == null) {
            x.e("MicroMsg.GetVideoMetadata", "input invalid");
            return null;
        }
        long Wq = bh.Wq();
        String dataString = intent.getDataString();
        x.i("MicroMsg.GetVideoMetadata", "dataString " + dataString);
        if (dataString == null) {
            x.e("MicroMsg.GetVideoMetadata", "dataString empty");
            return null;
        }
        Cursor query;
        ContentResolver contentResolver = context.getContentResolver();
        a aVar = new a();
        if (dataString.startsWith(Media.EXTERNAL_CONTENT_URI.toString())) {
            query = contentResolver.query(intent.getData(), null, null, null, null);
        } else {
            if (dataString.startsWith("content://")) {
                aVar.filename = bh.f(context, intent.getData());
            } else if (dataString.startsWith("file://")) {
                if (intent.getExtras() != null) {
                    Uri uri = (Uri) intent.getExtras().getParcelable("android.intent.extra.STREAM");
                    if (!(uri == null || bh.ov(uri.getPath()))) {
                        aVar.filename = uri.getPath();
                    }
                }
                if (aVar.filename == null) {
                    aVar.filename = dataString.substring(7);
                }
            }
            if (aVar.filename != null) {
                if (aVar.filename.startsWith("/storage/emulated/legacy")) {
                    aVar.filename = h.getExternalStorageDirectory().getAbsolutePath() + aVar.filename.substring(24);
                } else if (aVar.filename.startsWith("/sdcard")) {
                    aVar.filename = h.getExternalStorageDirectory().getAbsolutePath() + aVar.filename.substring(7);
                }
                query = contentResolver.query(Media.EXTERNAL_CONTENT_URI, null, "_data LIKE " + DatabaseUtils.sqlEscapeString(aVar.filename), null, null);
            } else {
                query = null;
            }
        }
        int i = Integer.MAX_VALUE;
        if (query != null) {
            if (query.getCount() > 0) {
                query.moveToFirst();
                i = query.getInt(query.getColumnIndexOrThrow("_id"));
                if (aVar.filename == null) {
                    aVar.filename = query.getString(query.getColumnIndexOrThrow("_data"));
                }
                aVar.duration = query.getInt(query.getColumnIndexOrThrow(FFmpegMetadataRetriever.METADATA_KEY_DURATION));
                if (aVar.duration == 0) {
                    MediaPlayer mediaPlayer = null;
                    try {
                        x.i("MicroMsg.GetVideoMetadata", "get video duration through MediaPlayer");
                        mediaPlayer = j.a(context, Uri.parse(aVar.filename));
                        aVar.duration = mediaPlayer != null ? mediaPlayer.getDuration() : 0;
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.GetVideoMetadata", e, "get duration error, %s", new Object[]{aVar.filename});
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                    } catch (Throwable th) {
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                    }
                }
                aVar.bitmap = null;
            }
            query.close();
        }
        if (i != Integer.MAX_VALUE) {
            try {
                aVar.bitmap = Thumbnails.getThumbnail(contentResolver, (long) i, 1, null);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.GetVideoMetadata", e2, "", new Object[0]);
                aVar.bitmap = null;
            }
        }
        if (!bh.ov(aVar.filename) && aVar.bitmap == null) {
            x.i("MicroMsg.GetVideoMetadata", "createVideoThumbnail manual");
            aVar.bitmap = ThumbnailUtils.createVideoThumbnail(aVar.filename, 1);
            if (aVar.bitmap == null) {
                context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + aVar.bitmap)));
            }
        }
        x.i("MicroMsg.GetVideoMetadata", "get video meta data cost time: %d meta[%s, %d]", new Object[]{Long.valueOf(bh.bA(Wq)), aVar.filename, Integer.valueOf(aVar.duration)});
        if (aVar.filename != null) {
            return aVar;
        }
        return null;
    }
}
