package es.ua.dlsi.prog3.p6.reflection.impl;

import es.ua.dlsi.prog3.p6.reflection.IReflectionUtils;

/**
 * Implements utility methods using Java reflection.
 */
public class ReflectionUtils implements IReflectionUtils {
    @Override
    public <T> T instantiate(Class<?> classToBeInstantiated) throws InstantiationException, IllegalAccessException {
		return (T) classToBeInstantiated.newInstance(); // Instantiates the class
	}

    @Override
    public Class<?> findClassInPackage(String packageName, String name) throws ClassNotFoundException {
        return Class.forName(packageName + "." + name); // Concatenates the package name and class name to find the class
    }

    @Override
    public boolean isImplementingInterface(Class<?> clazz, Class<?> interfaceClass) {
        return interfaceClass.isAssignableFrom(clazz); // Checks if clazz implements the interfaceClass
    }
}