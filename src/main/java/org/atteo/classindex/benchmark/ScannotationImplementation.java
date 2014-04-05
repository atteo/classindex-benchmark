package org.atteo.classindex.benchmark;

import java.io.IOException;
import java.net.URL;
import java.util.Set;
import java.util.stream.Collectors;

import org.scannotation.AnnotationDB;
import org.scannotation.ClasspathUrlFinder;

public class ScannotationImplementation implements Scanner {
	@Override
	public Iterable<Class<?>> getAnnotated() {
		try {
			URL[] urls = ClasspathUrlFinder.findClassPaths(); // scan java.class.path
			AnnotationDB db = new AnnotationDB();
			db.scanArchives(urls);
			Set<String> annotatedClasses = db.getAnnotationIndex().get(Important.class.getName());
			return annotatedClasses.stream().map((className) -> {
				try {
					return Class.forName(className);
				} catch (ClassNotFoundException e) {
					throw new RuntimeException(e);
				}
			}).collect(Collectors.toList());

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
