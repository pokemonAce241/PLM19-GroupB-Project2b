public class Arguments {
		public String description, command, option, metavar, help;
		public int repeat, valid, seed;
		public boolean verbose;
		
		public Arguments(String[] args) {
			command = args[0];

			
			if (args.length != 2) {
				if (command.equals("-h") || command.equals("--help")) {
					// Do Nothing
				}
				else {
					command = "invalid";
				}
			}
			
			description = "Monte Carlo generator.";
			addArguments(command, args);
		}
		
		private void addArguments(String command, String[] args) {
			switch(command) {
			case "-n":
			case "--num-repeats":
				try {
					Integer.parseInt(args[1]);
					setRepeats(args[1]);
				} catch (NumberFormatException e) {
					addArguments("invalid", args);
					System.out.println("error: argument -n/--num-repeats: invalid int value: " + args[1]);
				}
				break;
			case "-s":
			case "--seed":
				try {
					Integer.parseInt(args[1]);
					setSeed(args[1]);
				} catch (NumberFormatException e) {
					addArguments("invalid", args);
					System.out.println("error: argument -s/--seed: invalid int value: " + args[1]);
				}
				break;
			case "-v":
			case "--verbose":
				setVerbose();
				break;
			case "-h":
			case "--help":
				getHelp();
				break;
			default:
				System.out.println("usage: passing.py [-h] [-n rep] [-s seed] [-v verbose]");
				if (args.length > 2) {
					StringBuilder build = new StringBuilder();
					build.append("error: unrecognized arguments: ");
					for ( int i = 1; i < args.length; i++) {
						build.append(args[i] + " ");
					}
					System.out.println(build);
				}
			
		}
		}
		
		private void setRepeats(String arg) {
			repeat = Integer.parseInt(arg);
			seed = 1;
			verbose = false;
		}
		
		private void setSeed(String arg) {
			repeat = 1;
			seed = Integer.parseInt(arg);
			verbose = false;
		}
		
		private void setVerbose() {
			repeat = 1;
			seed = 1;
			//System.out.println("verbose: " + Boolean.getBoolean(arg));
			verbose = true;
		}
		
		private void getHelp() {
			System.out.println("usage: passing.py [-h] [-n rep] [-s seed] [-v verbose]\n\n"
					+ description + "\n\n"
							+ "optional arguments:\n"
							+ "  -h, --help            show this help message and exit\n"
							+ "  -n rep, --num-repeats rep\n"
							+ "                        Number of repeats\n"
							+ "  -s seed, --seed seed  Random number seed\n"
							+ "  -v verbose, --verbose verbose\n"
							+ "                        Verbose mode");
		}
		
	}