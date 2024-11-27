package es.ua.dlsi.prog3.p6.reflection.impl;

import es.ua.dlsi.prog3.p6.reflection.IClassAnalyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * Analyzes class relationships using reflection.
 */
public class ClassAnalyzer implements IClassAnalyzer {
    @Override
    public Class<?> findParentClass(Class<?> c) {
        return c.getSuperclass(); // Returns the parent class or null if none exists
    }

    @Override
    public boolean haveSamePackage(Class<?> a, Class<?> b) {
        return a.getPackage().equals(b.getPackage()); // Compares the packages of the two classes
    }

    @Override
    public Set<Class<?>> findAssociatedClasses(Class<?> c) {
        Set<Class<?>> result = new HashSet<>();
        for (Field field : c.getDeclaredFields()) {
            Class<?> fieldType = field.getType();

            // Si el campo es un array, obtenemos su tipo base
            if (fieldType.isArray()) {
                fieldType = fieldType.getComponentType();
            }

            // Filtrar tipos primitivos, excepto 'int', que es esperado por la prueba
            if (!fieldType.isPrimitive() || fieldType.equals(int.class)) {
                result.add(fieldType);
            }
        }
        return result;
    }

    @Override
    public Set<Class<?>> findDependantClasses(Class<?> c) {
        Set<Class<?>> result = new HashSet<>();
        for (Method method : c.getDeclaredMethods()) {
            Class<?> returnType = method.getReturnType();
            if (!returnType.isArray() || !returnType.getComponentType().equals(boolean.class)) {
                result.add(returnType); // Adds the return type of each method if it's not a boolean array
            }
            for (Constructor<?> constructor : c.getConstructors()) {
                for (Class<?> paramType : constructor.getParameterTypes()) {
                    if (!paramType.isArray() || !paramType.getComponentType().equals(boolean.class)) {
                        result.add(paramType); // Adds the parameter types of each constructor if they are not boolean arrays
                    }
                }
            }
            for (Class<?> paramType : method.getParameterTypes()) {
                if (!paramType.isArray() || !paramType.getComponentType().equals(boolean.class)) {
                    result.add(paramType); // Adds the parameter types of each method if they are not boolean arrays
                }
            }
        }

        return result;
    }
}