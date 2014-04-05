package org.atteo.classindex.benchmark;

import com.google.common.collect.Iterables;

public class Main {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Please provide implementation name");
		}

		Scanner scanner = getScanner(args[0]);

		if (Iterables.size(scanner.getAnnotated()) != 2) {
			throw new RuntimeException("Incorrect answer");
		}
	}

	private static Scanner getScanner(String name) {
		switch (name) {
			case "hardcoded":
				return new HardcodedImplementation();
			case "classindex":
				return new ClassIndexImplementation();
			case "reflections":
				return new ReflectionsImplementation();
			case "reflections2":
				return new Reflections2Implementation();
			case "guava":
				return new GuavaImplementation();
			case "scannotation":
				return new ScannotationImplementation();
			case "corn":
				return new CornImplementation();
			default:
				throw new RuntimeException("Unknown scanner");
		}
	}
}
