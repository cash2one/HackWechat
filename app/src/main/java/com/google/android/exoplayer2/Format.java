package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.video.ColorInfo;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Format implements Parcelable {
    public static final Creator<Format> CREATOR = new 1();
    public final String adS;
    public final Metadata adT;
    public final String adU;
    public final String adV;
    public final int adW;
    public final List<byte[]> adX;
    public final DrmInitData adY;
    public final float adZ;
    public final int aea;
    public final float aeb;
    public final int aec;
    public final byte[] aed;
    public final ColorInfo aee;
    public final int aef;
    public final int aeg;
    public final int aeh;
    public final int aei;
    public final long aej;
    public final int aek;
    public final String ael;
    public final int aem;
    private int aen;
    public final int bitrate;
    public final int height;
    public final String id;
    public final int sampleRate;
    public final int width;

    public static Format a(String str, String str2, String str3, int i, int i2, int i3) {
        return new Format(str, str2, null, str3, i, -1, i2, i3, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, null, null);
    }

    public static Format a(String str, String str2, int i, int i2, List<byte[]> list, float f) {
        return a(str, str2, null, -1, -1, i, i2, -1.0f, list, -1, f, null, -1, null);
    }

    public static Format a(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List<byte[]> list, int i5, float f2, byte[] bArr, int i6, DrmInitData drmInitData) {
        return new Format(str, null, str2, null, -1, -1, i3, i4, -1.0f, i5, f2, bArr, i6, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, list, drmInitData, null);
    }

    public static Format a(String str, String str2, int i, String str3) {
        return new Format(str, str2, null, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i, str3, -1, Long.MAX_VALUE, null, null, null);
    }

    public static Format a(String str, String str2, int i, int i2, int i3, int i4, List<byte[]> list, DrmInitData drmInitData, String str3) {
        return a(str, str2, null, i, i2, i3, i4, -1, list, drmInitData, 0, str3);
    }

    public static Format a(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, List<byte[]> list, DrmInitData drmInitData, int i6, String str4) {
        return a(str, str2, null, i, i2, i3, i4, i5, -1, -1, list, drmInitData, 0, str4, null);
    }

    public static Format a(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, int i6, int i7, List<byte[]> list, DrmInitData drmInitData, int i8, String str4, Metadata metadata) {
        return new Format(str, null, str2, str3, i, i2, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i3, i4, i5, i6, i7, i8, str4, -1, Long.MAX_VALUE, list, drmInitData, metadata);
    }

    public static Format a(String str, String str2, String str3, int i, String str4) {
        return a(str, str2, str3, null, -1, i, str4, -1);
    }

    public static Format a(String str, String str2, String str3, String str4, int i, int i2, String str5, int i3) {
        return new Format(str, str2, str3, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str5, i3, Long.MAX_VALUE, null, null, null);
    }

    public static Format L(String str) {
        return a(null, str, null, -1, 0, null, -1, null, Long.MAX_VALUE, Collections.emptyList());
    }

    public static Format a(String str, String str2, int i, String str3, int i2) {
        return a(str, str2, null, -1, i, str3, i2, null, Long.MAX_VALUE, Collections.emptyList());
    }

    public static Format a(String str, String str2, long j) {
        return a(null, str, null, -1, 0, str2, -1, null, j, Collections.emptyList());
    }

    public static Format a(String str, String str2, String str3, int i, int i2, String str4, int i3, DrmInitData drmInitData, long j, List<byte[]> list) {
        return new Format(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str4, i3, j, list, null, null);
    }

    public static Format a(String str, String str2, List<byte[]> list, String str3) {
        return new Format(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, str3, -1, Long.MAX_VALUE, list, null, null);
    }

    public static Format c(String str, String str2) {
        return new Format(str, str2, null, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, null, null);
    }

    public static Format b(String str, long j) {
        return new Format(null, null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, j, null, null, null);
    }

    public static Format g(String str, String str2) {
        return new Format(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, null, null);
    }

    public Format(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, float f, int i5, float f2, byte[] bArr, int i6, ColorInfo colorInfo, int i7, int i8, int i9, int i10, int i11, int i12, String str5, int i13, long j, List<byte[]> list, DrmInitData drmInitData, Metadata metadata) {
        this.id = str;
        this.adU = str2;
        this.adV = str3;
        this.adS = str4;
        this.bitrate = i;
        this.adW = i2;
        this.width = i3;
        this.height = i4;
        this.adZ = f;
        this.aea = i5;
        this.aeb = f2;
        this.aed = bArr;
        this.aec = i6;
        this.aee = colorInfo;
        this.aef = i7;
        this.sampleRate = i8;
        this.aeg = i9;
        this.aeh = i10;
        this.aei = i11;
        this.aek = i12;
        this.ael = str5;
        this.aem = i13;
        this.aej = j;
        if (list == null) {
            list = Collections.emptyList();
        }
        this.adX = list;
        this.adY = drmInitData;
        this.adT = metadata;
    }

    Format(Parcel parcel) {
        this.id = parcel.readString();
        this.adU = parcel.readString();
        this.adV = parcel.readString();
        this.adS = parcel.readString();
        this.bitrate = parcel.readInt();
        this.adW = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.adZ = parcel.readFloat();
        this.aea = parcel.readInt();
        this.aeb = parcel.readFloat();
        this.aed = (parcel.readInt() != 0 ? 1 : null) != null ? parcel.createByteArray() : null;
        this.aec = parcel.readInt();
        this.aee = (ColorInfo) parcel.readParcelable(ColorInfo.class.getClassLoader());
        this.aef = parcel.readInt();
        this.sampleRate = parcel.readInt();
        this.aeg = parcel.readInt();
        this.aeh = parcel.readInt();
        this.aei = parcel.readInt();
        this.aek = parcel.readInt();
        this.ael = parcel.readString();
        this.aem = parcel.readInt();
        this.aej = parcel.readLong();
        int readInt = parcel.readInt();
        this.adX = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            this.adX.add(parcel.createByteArray());
        }
        this.adY = (DrmInitData) parcel.readParcelable(DrmInitData.class.getClassLoader());
        this.adT = (Metadata) parcel.readParcelable(Metadata.class.getClassLoader());
    }

    public final Format q(long j) {
        return new Format(this.id, this.adU, this.adV, this.adS, this.bitrate, this.adW, this.width, this.height, this.adZ, this.aea, this.aeb, this.aed, this.aec, this.aee, this.aef, this.sampleRate, this.aeg, this.aeh, this.aei, this.aek, this.ael, this.aem, j, this.adX, this.adY, this.adT);
    }

    public final int io() {
        return (this.width == -1 || this.height == -1) ? -1 : this.width * this.height;
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(16)
    public final MediaFormat ip() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.adV);
        String str = FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE;
        String str2 = this.ael;
        if (str2 != null) {
            mediaFormat.setString(str, str2);
        }
        a(mediaFormat, "max-input-size", this.adW);
        a(mediaFormat, "width", this.width);
        a(mediaFormat, "height", this.height);
        str = "frame-rate";
        float f = this.adZ;
        if (f != -1.0f) {
            mediaFormat.setFloat(str, f);
        }
        a(mediaFormat, "rotation-degrees", this.aea);
        a(mediaFormat, "channel-count", this.aef);
        a(mediaFormat, "sample-rate", this.sampleRate);
        a(mediaFormat, "encoder-delay", this.aeh);
        a(mediaFormat, "encoder-padding", this.aei);
        for (int i = 0; i < this.adX.size(); i++) {
            mediaFormat.setByteBuffer("csd-" + i, ByteBuffer.wrap((byte[]) this.adX.get(i)));
        }
        ColorInfo colorInfo = this.aee;
        if (colorInfo != null) {
            a(mediaFormat, "color-transfer", colorInfo.aCQ);
            a(mediaFormat, "color-standard", colorInfo.aCO);
            a(mediaFormat, "color-range", colorInfo.aCP);
            str2 = "hdr-static-info";
            byte[] bArr = colorInfo.aCR;
            if (bArr != null) {
                mediaFormat.setByteBuffer(str2, ByteBuffer.wrap(bArr));
            }
        }
        return mediaFormat;
    }

    public final String toString() {
        return "Format(" + this.id + ", " + this.adU + ", " + this.adV + ", " + this.bitrate + ", " + this.ael + ", [" + this.width + ", " + this.height + ", " + this.adZ + "], [" + this.aef + ", " + this.sampleRate + "])";
    }

    public final int hashCode() {
        int i = 0;
        if (this.aen == 0) {
            int hashCode = ((this.adY == null ? 0 : this.adY.hashCode()) + (((((this.ael == null ? 0 : this.ael.hashCode()) + (((((((((((((this.adS == null ? 0 : this.adS.hashCode()) + (((this.adV == null ? 0 : this.adV.hashCode()) + (((this.adU == null ? 0 : this.adU.hashCode()) + (((this.id == null ? 0 : this.id.hashCode()) + 527) * 31)) * 31)) * 31)) * 31) + this.bitrate) * 31) + this.width) * 31) + this.height) * 31) + this.aef) * 31) + this.sampleRate) * 31)) * 31) + this.aem) * 31)) * 31;
            if (this.adT != null) {
                i = this.adT.hashCode();
            }
            this.aen = hashCode + i;
        }
        return this.aen;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Format format = (Format) obj;
        if (this.bitrate != format.bitrate || this.adW != format.adW || this.width != format.width || this.height != format.height || this.adZ != format.adZ || this.aea != format.aea || this.aeb != format.aeb || this.aec != format.aec || this.aef != format.aef || this.sampleRate != format.sampleRate || this.aeg != format.aeg || this.aeh != format.aeh || this.aei != format.aei || this.aej != format.aej || this.aek != format.aek || !t.h(this.id, format.id) || !t.h(this.ael, format.ael) || this.aem != format.aem || !t.h(this.adU, format.adU) || !t.h(this.adV, format.adV) || !t.h(this.adS, format.adS) || !t.h(this.adY, format.adY) || !t.h(this.adT, format.adT) || !t.h(this.aee, format.aee) || !Arrays.equals(this.aed, format.aed) || this.adX.size() != format.adX.size()) {
            return false;
        }
        for (int i = 0; i < this.adX.size(); i++) {
            if (!Arrays.equals((byte[]) this.adX.get(i), (byte[]) format.adX.get(i))) {
                return false;
            }
        }
        return true;
    }

    @TargetApi(16)
    private static void a(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    public static String a(Format format) {
        if (format == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id=").append(format.id).append(", mimeType=").append(format.adV);
        if (format.bitrate != -1) {
            stringBuilder.append(", bitrate=").append(format.bitrate);
        }
        if (!(format.width == -1 || format.height == -1)) {
            stringBuilder.append(", res=").append(format.width).append("x").append(format.height);
        }
        if (format.adZ != -1.0f) {
            stringBuilder.append(", fps=").append(format.adZ);
        }
        if (format.aef != -1) {
            stringBuilder.append(", channels=").append(format.aef);
        }
        if (format.sampleRate != -1) {
            stringBuilder.append(", sample_rate=").append(format.sampleRate);
        }
        if (format.ael != null) {
            stringBuilder.append(", language=").append(format.ael);
        }
        return stringBuilder.toString();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.adU);
        parcel.writeString(this.adV);
        parcel.writeString(this.adS);
        parcel.writeInt(this.bitrate);
        parcel.writeInt(this.adW);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeFloat(this.adZ);
        parcel.writeInt(this.aea);
        parcel.writeFloat(this.aeb);
        parcel.writeInt(this.aed != null ? 1 : 0);
        if (this.aed != null) {
            parcel.writeByteArray(this.aed);
        }
        parcel.writeInt(this.aec);
        parcel.writeParcelable(this.aee, i);
        parcel.writeInt(this.aef);
        parcel.writeInt(this.sampleRate);
        parcel.writeInt(this.aeg);
        parcel.writeInt(this.aeh);
        parcel.writeInt(this.aei);
        parcel.writeInt(this.aek);
        parcel.writeString(this.ael);
        parcel.writeInt(this.aem);
        parcel.writeLong(this.aej);
        int size = this.adX.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeByteArray((byte[]) this.adX.get(i2));
        }
        parcel.writeParcelable(this.adY, 0);
        parcel.writeParcelable(this.adT, 0);
    }
}
