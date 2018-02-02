package com.tencent.mm.plugin.music.model.d;

import com.google.android.exoplayer2.d.a;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.id3.UrlLinkFrame;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.sharp.jni.QLog;
import java.text.NumberFormat;
import java.util.Locale;

public final class b {
    private static final NumberFormat oLL;

    static {
        NumberFormat instance = NumberFormat.getInstance(Locale.US);
        oLL = instance;
        instance.setMinimumFractionDigits(2);
        oLL.setMaximumFractionDigits(2);
        oLL.setGroupingUsed(false);
    }

    public static void beu() {
        com.google.android.exoplayer2.d.b.DEBUG = false;
        com.google.android.exoplayer2.d.b.a(new a() {
            public final void i(String str, String str2, Object... objArr) {
                x.i(str, str2, objArr);
            }

            public final void w(String str, String str2, Object... objArr) {
                x.w(str, str2, objArr);
            }

            public final void e(String str, String str2, Object... objArr) {
                x.e(str, str2, objArr);
            }
        });
    }

    public static String dP(long j) {
        return j == -9223372036854775807L ? "?" : oLL.format((double) (((float) j) / 1000.0f));
    }

    public static String tE(int i) {
        switch (i) {
            case 1:
                return "I";
            case 2:
                return "B";
            case 3:
                return "R";
            case 4:
                return QLog.TAG_REPORTLEVEL_USER;
            default:
                return "?";
        }
    }

    public static void a(Metadata metadata, String str) {
        for (Entry entry : metadata.aqo) {
            if (entry instanceof TextInformationFrame) {
                TextInformationFrame textInformationFrame = (TextInformationFrame) entry;
                x.d("MicroMsg.ExoPlayer", str + String.format("%s: value=%s", new Object[]{textInformationFrame.id, textInformationFrame.value}));
            } else if (entry instanceof UrlLinkFrame) {
                UrlLinkFrame urlLinkFrame = (UrlLinkFrame) entry;
                x.d("MicroMsg.ExoPlayer", str + String.format("%s: url=%s", new Object[]{urlLinkFrame.id, urlLinkFrame.url}));
            } else if (entry instanceof PrivFrame) {
                PrivFrame privFrame = (PrivFrame) entry;
                x.d("MicroMsg.ExoPlayer", str + String.format("%s: owner=%s", new Object[]{privFrame.id, privFrame.aqS}));
            } else if (entry instanceof GeobFrame) {
                GeobFrame geobFrame = (GeobFrame) entry;
                x.d("MicroMsg.ExoPlayer", str + String.format("%s: mimeType=%s, filename=%s, description=%s", new Object[]{geobFrame.id, geobFrame.mimeType, geobFrame.filename, geobFrame.description}));
            } else if (entry instanceof ApicFrame) {
                ApicFrame apicFrame = (ApicFrame) entry;
                x.d("MicroMsg.ExoPlayer", str + String.format("%s: mimeType=%s, description=%s", new Object[]{apicFrame.id, apicFrame.mimeType, apicFrame.description}));
            } else if (entry instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) entry;
                x.d("MicroMsg.ExoPlayer", str + String.format("%s: language=%s, description=%s", new Object[]{commentFrame.id, commentFrame.ael, commentFrame.description}));
            } else if (entry instanceof Id3Frame) {
                Id3Frame id3Frame = (Id3Frame) entry;
                x.d("MicroMsg.ExoPlayer", str + String.format("%s", new Object[]{id3Frame.id}));
            } else if (entry instanceof EventMessage) {
                EventMessage eventMessage = (EventMessage) entry;
                x.d("MicroMsg.ExoPlayer", str + String.format("EMSG: scheme=%s, id=%d, value=%s", new Object[]{eventMessage.aqz, Long.valueOf(eventMessage.id), eventMessage.value}));
            }
        }
    }
}
