package org.atteo.classindex.benchmark;

import java.io.IOException;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;

public class GuavaImplementation implements Scanner {
	@Override
	public Iterable<Class<?>> getAnnotated() {
		try {
			ClassPath classpath = ClassPath.from(GuavaImplementation.class.getClassLoader());
			ImmutableSet<ClassPath.ClassInfo> classes = classpath.getTopLevelClasses();

			return classes.stream()
					.map(c -> c.load())
					.filter(c -> c.getAnnotation(Important.class) != null)
					.collect(Collectors.toList());

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
