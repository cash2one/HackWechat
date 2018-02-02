package e.a.a.b.a;

import java.io.IOException;

public final class b extends IOException {
    private b(String str) {
        super(str);
    }

    static b cJF() {
        return new b("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static b cJG() {
        return new b("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static b cJH() {
        return new b("CodedInputStream encountered a malformed varint.");
    }

    public static b cJI() {
        return new b("Protocol message contained an invalid tag (zero).");
    }

    static b cJJ() {
        return new b("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }
}
