package org.atteo.classindex.benchmark;


import org.reflections.Reflections;


public class Reflections2Implementation implements Scanner {

	@Override
	public Iterable<Class<?>> getAnnotated() {
		Reflections reflections = Reflections.collect();
		return reflections.getTypesAnnotatedWith(Important.class);
	}
}
