package org.xwalk.core.extension;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import org.xwalk.core.extension.ReflectionHelper.MemberInfo;
import org.xwalk.core.extension.ReflectionHelper.MemberType;

public class JsStubGenerator {
    public static final String MSG_TO_CLASS = "postMessageToClass";
    public static final String MSG_TO_EXTENSION = "postMessageToExtension";
    public static final String MSG_TO_OBJECT = "postMessageToObject";
    public static String TAG = "JsStubGenerator";
    String jsHeader = "var v8tools = requireNative(\"v8tools\");\nvar jsStubModule = requireNative(\"jsStub\");\njsStubModule.init(extension, v8tools);\nvar jsStub = jsStubModule.jsStub;\nvar helper = jsStub.createRootStub(exports);\n";
    ReflectionHelper reflection;

    JsStubGenerator(ReflectionHelper reflectionHelper) {
        this.reflection = reflectionHelper;
    }

    String generate() {
        String str = "";
        MemberInfo entryPoint = this.reflection.getEntryPoint();
        if (entryPoint != null) {
            str = generateEntryPoint(entryPoint);
        }
        if (str.length() <= 0) {
            str = this.jsHeader;
        }
        if (this.reflection.getEventList() != null) {
            str = str + generateEventTarget(this.reflection);
        }
        Map members = this.reflection.getMembers();
        String str2 = str;
        for (String str3 : members.keySet()) {
            MemberInfo memberInfo = (MemberInfo) members.get(str3);
            if (!memberInfo.isEntryPoint) {
                switch (1.$SwitchMap$org$xwalk$core$extension$ReflectionHelper$MemberType[memberInfo.type.ordinal()]) {
                    case 1:
                        str2 = str2 + generateProperty(MSG_TO_EXTENSION, memberInfo);
                        continue;
                    case 2:
                        str2 = str2 + generateMethod(MSG_TO_EXTENSION, memberInfo, true);
                        continue;
                    case 3:
                        str3 = str2 + generateConstructor(memberInfo, true);
                        break;
                    default:
                        str3 = str2;
                        break;
                }
                str2 = str3;
            }
        }
        return str2 + "\n";
    }

    String generateEntryPoint(MemberInfo memberInfo) {
        if (memberInfo.type == MemberType.JS_PROPERTY) {
            String simpleName = ((Field) memberInfo.accesser).getType().getSimpleName();
            return this.jsHeader + String.format("%s(exports, helper);\n", new Object[]{getPrototypeName(simpleName)});
        } else if (memberInfo.type == MemberType.JS_METHOD) {
            return String.format("exports = %s;\n %s\n %s", new Object[]{getInternalName(memberInfo.jsName), this.jsHeader, generateMethod(MSG_TO_EXTENSION, memberInfo, false)});
        } else if (memberInfo.type != MemberType.JS_CONSTRUCTOR) {
            return "";
        } else {
            return String.format("exports = %s;\n %s\n %s", new Object[]{memberInfo.jsName, this.jsHeader, generateConstructor(memberInfo, false)});
        }
    }

    String[] classGenerator(ReflectionHelper reflectionHelper) {
        String generateEventTarget;
        String str = "";
        String str2 = "";
        if (reflectionHelper.getEventList() != null) {
            generateEventTarget = generateEventTarget(reflectionHelper);
            str = str + generateEventTarget;
            str2 = str2 + generateEventTarget;
        }
        Map members = reflectionHelper.getMembers();
        generateEventTarget = str2;
        String str3 = str;
        for (String str22 : members.keySet()) {
            MemberInfo memberInfo = (MemberInfo) members.get(str22);
            str = memberInfo.isStatic ? MSG_TO_CLASS : MSG_TO_OBJECT;
            switch (1.$SwitchMap$org$xwalk$core$extension$ReflectionHelper$MemberType[memberInfo.type.ordinal()]) {
                case 1:
                    str = generateProperty(str, memberInfo);
                    break;
                case 2:
                    str = generateMethod(str, memberInfo, true);
                    break;
                default:
                    str = "";
                    break;
            }
            if (memberInfo.isStatic) {
                generateEventTarget = generateEventTarget + str;
            } else {
                str3 = str3 + str;
            }
        }
        return new String[]{str3, generateEventTarget};
    }

    String destroyBindingObject(ReflectionHelper reflectionHelper) {
        String str = "exports.destroy = function() {\n";
        for (String str2 : reflectionHelper.getMembers().keySet()) {
            str = str + "delete exports[\"" + str2 + "\"];\n";
        }
        return (((str + "helper.destroy();\n") + "delete exports[\"__stubHelper\"];\n") + "delete exports[\"destroy\"];\n") + "};";
    }

    String generateEventTarget(ReflectionHelper reflectionHelper) {
        String[] eventList = reflectionHelper.getEventList();
        if (eventList == null || eventList.length == 0) {
            return "";
        }
        int length = eventList.length;
        String str = "jsStub.makeEventTarget(exports);\n";
        int i = 0;
        while (i < length) {
            i++;
            str = str + "helper.addEvent(\"" + eventList[i] + "\");\n";
        }
        return str;
    }

    String generateProperty(String str, MemberInfo memberInfo) {
        String str2 = memberInfo.jsName;
        return String.format("jsStub.defineProperty(\"%s\", exports, \"%s\", %b);\n", new Object[]{str, str2, Boolean.valueOf(memberInfo.isWritable)});
    }

    String generatePromiseMethod(String str, MemberInfo memberInfo) {
        String str2 = memberInfo.jsName;
        String str3 = memberInfo.wrapArgs.length() > 0 ? memberInfo.wrapArgs : "null";
        String str4 = memberInfo.wrapReturns.length() > 0 ? memberInfo.wrapReturns : "null";
        return String.format("jsStub.addMethodWithPromise(\"%s\", exports, \"%s\", %s, %s);\n", new Object[]{str, str2, str3, str4});
    }

    String getArgString(Method method, boolean z) {
        if (method == null) {
            return "";
        }
        Class[] parameterTypes = method.getParameterTypes();
        method.getParameterAnnotations();
        String str = "";
        int length = z ? parameterTypes.length - 1 : parameterTypes.length;
        String str2 = str;
        int i = 0;
        while (i < length) {
            String str3 = "arg" + i + "_" + parameterTypes[i].getSimpleName();
            if (str2.length() > 0) {
                str2 = str2 + ", ";
            }
            i++;
            str2 = str2 + str3;
        }
        return str2;
    }

    String generateMethod(String str, MemberInfo memberInfo, boolean z) {
        if (memberInfo.withPromise) {
            return generatePromiseMethod(str, memberInfo);
        }
        Method method = (Method) memberInfo.accesser;
        String internalName = getInternalName(memberInfo.jsName);
        method.getParameterAnnotations();
        String argString = getArgString(method, memberInfo.withPromise);
        return String.format("function %s(%s) {\n" + (!method.getReturnType().equals(Void.TYPE) ? "  return " : "  ") + "helper.invokeNative(\"%s\", \"%s\", [%s], %b);\n};\n", new Object[]{internalName, argString, str, memberInfo.jsName, argString, Boolean.valueOf(!method.getReturnType().equals(Void.TYPE))}) + (z ? String.format("exports[\"%s\"] = %s;\n", new Object[]{r4, internalName}) : "");
    }

    String getInternalName(String str) {
        return "__" + str;
    }

    String getPrototypeName(String str) {
        return "__" + str + "_prototype";
    }

    String generateConstructor(MemberInfo memberInfo, boolean z) {
        String str = memberInfo.jsName;
        String prototypeName = getPrototypeName(str);
        String argString = getArgString((Method) memberInfo.accesser, false);
        String[] classGenerator = classGenerator(this.reflection.getConstructorReflection(str));
        String format = String.format("function %s(exports, helper){\n%s\n%s\n}\n", new Object[]{prototypeName, classGenerator[0], destroyBindingObject(r3)});
        prototypeName = String.format("function %s(%s) {\nvar newObject = this;\nvar objectId =\nNumber(helper.invokeNative(\"%s\", \"+%s\", [%s], true));\nif (!objectId) throw \"Error to create instance for constructor:%s.\";\nvar objectHelper = jsStub.getHelper(newObject, helper);\nobjectHelper.objectId = objectId;\nobjectHelper.constructorJsName = \"%s\";\nobjectHelper.registerLifecycleTracker();%s(newObject, objectHelper);\nhelper.addBindingObject(objectId, newObject);}\nhelper.constructors[\"%s\"] = %s;\n", new Object[]{str, argString, MSG_TO_EXTENSION, str, argString, str, str, prototypeName, str, str});
        String format2 = String.format("(function(exports, helper){\n  helper.constructorJsName = \"%s\";\n%s\n})(%s, jsStub.getHelper(%s, helper));\n", new Object[]{str, classGenerator[1], str, str});
        if (z) {
            argString = String.format("exports[\"%s\"] = %s;\n", new Object[]{str, str});
        } else {
            argString = "";
        }
        return format + prototypeName + format2 + argString;
    }
}
