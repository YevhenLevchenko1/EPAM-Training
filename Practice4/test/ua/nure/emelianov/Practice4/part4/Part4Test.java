package ua.nure.emelianov.Practice4.part4;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Part4Test {

	Part4 part4;

	class Mock extends Parser {

		public Mock(File file) {
			super(file);
		}
	}

	public Parser getMock() {
		Parser parser = new Mock(new File("part4.txt"));
		return parser;
	}

	@Before
	public void constructorTest() {
		part4 = new Part4("part4.txt") {
			@Override
			public void output() {
				for (String str : getMock()) {
					System.out.println(str);
				}
			}
		};
	}

	@Test
	public void testOutput() {
		part4.output();
	}

	@Test
	public void testMain() {
		Part4.main(new String[] {});
	}

}
