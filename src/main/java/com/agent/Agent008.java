package com.agent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

public class Agent008 {
    private static Instrumentation instrumentation;

    public static void premain(String args, Instrumentation instrumentation) {
        System.out.println("Agent here.");
        Agent008.instrumentation = instrumentation;
        instrumentation.addTransformer(new ClassCounter());
    }

    public static long getSize(Object obj) {
        return instrumentation.getObjectSize(obj);
    }

    static class ClassCounter implements ClassFileTransformer {

        private static int countCriminal = 0;
        private static int count = 0;

        @Override
        public byte[] transform(ClassLoader loader,
                                String className,
                                Class<?> classBeingRedefined,
                                ProtectionDomain protectionDomain,
                                byte[] classfileBuffer) {
            if (className.equals("com/agent/Criminal")) {
                countCriminal++;
                System.out.println("Criminals: " + countCriminal);
                System.out.println(String.format("\tOther classes: %s", ++count));
            } else {
                count++;
            }
            return classfileBuffer;
        }
    }

}
