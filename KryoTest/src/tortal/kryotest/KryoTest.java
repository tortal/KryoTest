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
		//On Output
		Kryo kryo = new Kryo();
		Output output = null;
		try {
			output = new Output(new FileOutputStream("file.bin"));
		} catch (FileNotFoundException e1) {
		}
		Message someObject = new Message();
		kryo.writeObject(output, someObject);
		output.close();
		
		
		//On Input
		Input input = null;
		try {
			input = new Input(new FileInputStream("file.bin"));
		} catch (FileNotFoundException e) {
		}
		Message someObject1 = kryo.readObject(input, Message.class);
		input.close();
		
		//	Test
		System.out.println(someObject1.cool.getClass() == SomeClass.class); // True
		System.out.println(someObject1.cool.equals(someObject.cool)); // True
		System.out.println(someObject.equals(someObject1));  // True
		

	}
}
