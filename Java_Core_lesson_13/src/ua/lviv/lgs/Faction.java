package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.imageio.event.IIOReadProgressListener;

public class Faction {

	Deputy deputy;
	private String name;
	// boolean bribeTaker;

	ArrayList<Deputy> deputies = new ArrayList<Deputy>();

// 1 - Add new deputy
	public void addDeputy() {
		Deputy deputy = new Deputy(0, 0);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введіть вагу депутата:");
		int weight = scanner.nextInt();
		System.out.println("Введіть його зріст:");
		int height = scanner.nextInt();
		System.out.println("Введіть прізвище депутата:");
		String surname = scanner.next();
		System.out.println("Введіть імя депутата:");
		String name = scanner.next();
		System.out.println("Введіть його вік:");
		int age = scanner.nextInt();
		System.out.println("Чи є цей депутат хаба ником (так чи ні)?");
		String str = scanner.next();
		if (str.equals("так")) {
			deputy.bribeTaker = true;
			deputy.takeBribe();
			deputies.add(new Deputy(weight, height, surname, name, age, deputy.bribeTaker, deputy.bribeSize));
		} else {
			deputy.bribeTaker = false;
			deputies.add(new Deputy(weight, height, surname, name, age, deputy.bribeTaker));
		}

	}

// 2 - Delete deputy
	public void deleteDeputy() {
		boolean isDeleted = false;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введіть п ізвище депутата: ");
		String str = scanner.nextLine();

		Iterator<Deputy> iterator = deputies.iterator();
		while (iterator.hasNext()) {
			Deputy next = iterator.next();

			if (next.getSurname().equals(str)) {
				iterator.remove();
				isDeleted = true;
			}
			if (isDeleted == false) {
				System.out.println("Шкода, та в нашій ф акції такого депутата немає");
			}
		}
	}

// 3 - Print all briber
	public void printAllBriber() {
		Iterator<Deputy> iterator = deputies.iterator();
		while (iterator.hasNext()) {
			Deputy next = iterator.next();

			if (next.isBribeTaker()) {
				System.out.println(next.toString());
			}
		}
	}

//	4 - Print most briber taker
	public void printMostBriberTaker() {
		int max = 0;
		Iterator<Deputy> iterator = deputies.iterator();
		while (iterator.hasNext()) {
			Deputy next = iterator.next();

			if ((next.isBribeTaker()) && (next.getBribeSize() > max)) {
				max = next.getBribeSize();
			}
		}

		Iterator<Deputy> iterator2 = deputies.iterator();
		while (iterator2.hasNext()) {
			Deputy next = iterator2.next();

			if ((next.isBribeTaker()) && (next.getBribeSize() == max)) {
				System.out.println(next.toString());
			}
		}
	}

// 5 - Print all deputy	
	public void printAllDeputy() {
		Iterator<Deputy> iterator = deputies.iterator();
		while (iterator.hasNext()) {
			Deputy next = iterator.next();
			System.out.println(next.toString());
		}
	}

// 6 - Delete all deputy	
	public void deleteAllDeputy() {
		deputies.clear();
	}

	public Faction(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Фракція= " + name + "]";
	}

	public String toStringAllDeputy() {
		return "Фракція= " + name + ": Депутати= " + deputies + "]";
	}

}
