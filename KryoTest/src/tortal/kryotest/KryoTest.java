package tortal.kryotest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public class KryoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// On Output
		Kryo kryo = new Kryo();
		Output output = null;
		try {
			output = new Output(new FileOutputStream("file.bin"));
		} catch (FileNotFoundException e1) {
		}
		Message outputMsg = new Message();
		kryo.writeObject(output, outputMsg);
		output.close();

		// On Input
		Input input = null;
		try {
			input = new Input(new FileInputStream("file.bin"));
		} catch (FileNotFoundException e) {
		}
		Message inputMsg = kryo.readObject(input, Message.class);
		input.close();

		// Test
		System.out.println(inputMsg.object.getClass() == SomeClass.class); // True
		System.out.println(inputMsg.object.equals(outputMsg.object)); // True
		System.out.println(outputMsg.equals(inputMsg)); // True

		SomeClass someClass = (SomeClass) outputMsg.object; // Safe type casting
		System.out.println(someClass.list.get(0)); // "Hello Kryo" message from
													// arraylist in SomeClass
													// object

	}
}
