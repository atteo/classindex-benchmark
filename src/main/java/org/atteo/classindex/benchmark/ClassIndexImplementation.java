package org.atteo.classindex.benchmark;

import org.atteo.classindex.ClassIndex;

public class ClassIndexImplementation implements Scanner {
	@Override
	public Iterable<Class<?>> getAnnotated() {
		return ClassIndex.getAnnotated(Important.class);
	}
}
