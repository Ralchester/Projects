
	import java.util.Scanner;

	import javax.swing.*;

	public class PLatin {

	static JTextArea area;

	static JTextArea phraseArea;

	JFrame f;

	PLatin() {

	f = new JFrame();

	phraseArea = new JTextArea(300, 300);

	phraseArea.setBounds(10, 30, 350, 40);

	area = new JTextArea(300, 300);

	area.setBounds(10, 100, 350, 250);

	JLabel phrase = new JLabel("Phrase");

	phrase.setBounds(10, 10, 100, 20);

	JLabel pigLatin = new JLabel("Pig Latin words");

	pigLatin.setBounds(10, 80, 100, 20);

	f.add(phrase);

	f.add(phraseArea);

	f.add(pigLatin);

	f.add(area);

	f.setSize(400, 400);

	f.setLayout(null);

	f.setVisible(true);

	}

	public static void main(String[] args) {

	String phrase;

	Scanner in = new Scanner(System.in);


	System.out.println("Enter phrase");

	phrase = in.nextLine();


	String words[] = phrase.split(" ");


	new PLatin();


	phraseArea.setText(phrase);


	for (String word : words) {


	printLatinWord(word);

	}

	}

	public static void printLatinWord(String word) {

	String temp = word.substring(1);

	temp = temp + word.charAt(0) + "ay";

	System.out.println(temp);

	area.append(temp + "\n");

	}

	}
