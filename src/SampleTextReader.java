import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.StringTokenizer;

public class SampleTextReader {

	public void Reader(String filename) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
		String line;
		StringTokenizer st;
		boolean hasMoreLines = true;
		
		while (hasMoreLines) {
			try {
				line = reader.readLine();
				if (line == null)
					break;
				st = new StringTokenizer(line);
				if (st.countTokens() != 3) {
					System.err.println("Wrong line in file: " + st.countTokens());
					continue;
				}
				String string1 = st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				//Node n = new Node(name, x, y);
				//lsit.add(n);

			} catch (IOException e) {
				hasMoreLines = false;
			} catch (NumberFormatException e) {
				System.err.println(e.getMessage());
			}
		} // end of while
	}
}
