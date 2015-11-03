package ua.nure.emelianov.Practice6.part1;

import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Part1 {

	private String[] arr;

	private WordContainer container = new WordContainer();

	Part1() {
		arr = read();
		fill();
	}

	public final String[] read() {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in, System.getProperty("file.encoding"));
		while (sc.hasNextLine()) {
			sb.append(sc.nextLine());
			break;
		}
		sc.close();
		return sb.toString().split(" ");
	}

	public final void fill() {
		for (int i = 0; i < arr.length; i++) {
			container.add(new Word(arr[i]));
		}
		Collections.sort(container.getArr(), new CompareByWord());
		Collections.sort(container.getArr(), new CompareByFrequency());
	}

	public String output() {
		StringBuilder sb = new StringBuilder();
		for (Iterator<Word> iterator = container.getArr().iterator(); iterator
				.hasNext();) {
			Word word = iterator.next();
			sb.append(word.getWord() + ":" + word.getFrequency()
					+ System.lineSeparator());

		}
		return sb.toString();
	}

	public static void main(String[] args) {

		Part1 pt;
		pt = new Part1();
		System.out.println(pt.output());
	}

}
