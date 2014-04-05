package org.atteo.classindex.benchmark;


import org.reflections.Reflections;


public class ReflectionsImplementation implements Scanner {

	@Override
	public Iterable<Class<?>> getAnnotated() {
		return new Reflections().getTypesAnnotatedWith(Important.class);
	}
}
