import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Arguments {
	public String description, usage;
	public int repeat, seed;
	public boolean verbose;
	private StringBuilder build;

	public Arguments(String[] args) {
		repeat = 1;
		seed = 1;
		verbose = false;

		description = "Monte Carlo generator.";
		usage = "usage: passing.py [-h] [-n rep] [-s seed] [-v verbose]";
		
		build = new StringBuilder();
		build.append("error: unrecognized arguments: ");
		
		addArguments(args);
	}

	private void addArguments(String[] args) {
		Iterator<String> iterate = Arrays.asList(args).iterator();
		while (iterate.hasNext()) {
			String current = iterate.next();
			switch (current) {
			case "-n":
			case "--num-repeats":
				String numValue = "";
				try {
					numValue = iterate.next();
					Integer.parseInt(numValue);
					setRepeats(numValue);
				} catch (NumberFormatException e) {
					System.out.println(usage);
					System.out.println("error: argument -n/--num-repeats: invalid int value: '" + numValue + "'");
					System.exit(1);
				} catch (NoSuchElementException e) {
					System.out.println(usage);
					System.out.println("error: argument -n/--num-repeats: expected one argument");
					System.exit(1);
				}
				break;
			case "-s":
			case "--seed":
				String seedValue = "";
				try {
					seedValue = iterate.next();
					Integer.parseInt(seedValue);
					setSeed(seedValue);
				} catch (NumberFormatException e) {
					System.out.println(usage);
					System.out.println("error: argument -s/--seed: invalid int value: '" + seedValue + "'");
					System.exit(1);
				} catch (NoSuchElementException e) {
					System.out.println(usage);
					System.out.println("error: argument -s/--seed: expected one argumnet");
					System.exit(1);
				}
				break;
			case "-v":
			case "--verbose":
				setVerbose();
				iterate.next();
				break;
			case "-h":
			case "--help":
				getHelp();
				System.exit(0);
			default:
				addUnrecognized(current);
				if (!iterate.hasNext()) {
					System.out.println(usage);
					System.out.println(build.toString());
					System.exit(1);
				}
			}

		}
	}

	private void setRepeats(String arg) {
		repeat = Integer.parseInt(arg);
	}

	private void setSeed(String arg) {
		seed = Integer.parseInt(arg);
	}

	private void setVerbose() {
		verbose = true;
	}

	private void getHelp() {
		System.out.println("usage: passing.py [-h] [-n rep] [-s seed] [-v verbose]\n\n" + description + "\n\n"
				+ "optional arguments:\n" + "  -h, --help            show this help message and exit\n"
				+ "  -n rep, --num-repeats rep\n" + "                        Number of repeats\n"
				+ "  -s seed, --seed seed  Random number seed\n" + "  -v verbose, --verbose verbose\n"
				+ "                        Verbose mode");
	}
	
	private void addUnrecognized(String arg) {
		build.append(arg + " ");
	}

}