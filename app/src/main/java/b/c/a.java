package b.c;

import b.c.b.e;
import b.e.b;
import b.i;
import com.tencent.tmassistantsdk.downloadservice.DownloadSetting;

public final class a {
    public static final <T> Class<T> a(b<T> bVar) {
        e.i(bVar, "$receiver");
        Class<T> cJx = ((b.c.b.b) bVar).cJx();
        if (cJx.isPrimitive()) {
            String name = cJx.getName();
            if (name != null) {
                switch (name.hashCode()) {
                    case -1325958191:
                        if (name.equals("double")) {
                            cJx = Double.class;
                            break;
                        }
                        break;
                    case 104431:
                        if (name.equals("int")) {
                            cJx = Integer.class;
                            break;
                        }
                        break;
                    case 3039496:
                        if (name.equals("byte")) {
                            cJx = Byte.class;
                            break;
                        }
                        break;
                    case 3052374:
                        if (name.equals("char")) {
                            cJx = Character.class;
                            break;
                        }
                        break;
                    case 3327612:
                        if (name.equals("long")) {
                            cJx = Long.class;
                            break;
                        }
                        break;
                    case 64711720:
                        if (name.equals(DownloadSetting.TYPE_BOOLEAN)) {
                            cJx = Boolean.class;
                            break;
                        }
                        break;
                    case 97526364:
                        if (name.equals("float")) {
                            cJx = Float.class;
                            break;
                        }
                        break;
                    case 109413500:
                        if (name.equals("short")) {
                            cJx = Short.class;
                            break;
                        }
                        break;
                    default:
                        break;
                }
            }
            if (cJx == null) {
                throw new i("null cannot be cast to non-null type java.lang.Class<T>");
            }
        } else if (cJx == null) {
            throw new i("null cannot be cast to non-null type java.lang.Class<T>");
        }
        return cJx;
    }
}
