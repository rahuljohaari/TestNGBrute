import java.util.Arrays;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
public class TestNGBrute{
  @Test
   public void testAdd() {
      String str = "TestNG is working fine";
      System.out.println("Inside testAdd()");
      assertEquals("TestNG is working fine", str);
   }

	public static void main(String[] args) {
		String password = "Springer";
		char[] charset = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		TestNGBrute bf = new TestNGBrute(charset, 1);

		String attempt = bf.toString();
		while (true) {
			if (attempt.equals(password)) { 
				System.out.println("Password Found: " + attempt);
				break;
			}
			attempt = bf.toString();
			System.out.println("Tried: " + attempt);
			bf.increment();
		}
	}


	private char[] cs;	// Character Set
	private char[] cg;	// Current Guess

	public TestNGBrute(char[] characterSet, int guessLength) {
		cs = characterSet;
		cg = new char[guessLength];
		Arrays.fill(cg, cs[0]);
	}

	public void increment() {
		int index = cg.length - 1;
		while(index >= 0) {
			if (cg[index] == cs[cs.length-1]) {
				if (index == 0) {
					cg = new char[cg.length+1];
					Arrays.fill(cg, cs[0]);
					break;
				} else {
					cg[index] = cs[0];
					index--;
				}
			} else {
				cg[index] = cs[Arrays.binarySearch(cs, cg[index]) + 1];
				break;
			}
		}
	}

	public String toString() {
		return String.valueOf(cg);
	}
}
	