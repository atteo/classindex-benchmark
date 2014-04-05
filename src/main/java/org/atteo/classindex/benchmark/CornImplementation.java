package org.atteo.classindex.benchmark;

import net.sf.corn.cps.CPScanner;
import net.sf.corn.cps.ClassFilter;

class CornImplementation implements Scanner {
	@Override
	public Iterable<Class<?>> getAnnotated() {
		return CPScanner.scanClasses(new ClassFilter().annotation(Important.class));
	}
}
