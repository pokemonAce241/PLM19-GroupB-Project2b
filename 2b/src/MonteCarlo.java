import java.text.DecimalFormat;
import java.util.*;

public class MonteCarlo {
	
	public HashMap<String, Attributes> map = new HashMap<String, Attributes>();
	private static Random randomHandler = new Random();
	
	public MonteCarlo() {
		map.put("pomposity", new Attributes(0, 100));
		map.put("learning_curve", new Attributes(1, 100));
		map.put("optimism", new Attributes(0.1, 100));
		map.put("atleast", new Attributes(0, 10));
		map.put("done_percent", new Attributes(0, 10));
		map.put("productivity_new", new Attributes(0, 1));
		map.put("productivity_exp", new Attributes(1, 10));
		map.put("d", new Attributes(0, 1));
		map.put("ep", new Attributes(1, 10));
		map.put("nprod", new Attributes(0.1, 10));
		map.put("np", new Attributes(1, 30));
		map.put("ts", new Attributes(1, 100));
		map.put("to", new Attributes(1, 100));
		map.put("r", new Attributes(1, 1000));

	}
	
	public void generator(int iters, boolean verbose) {
		for(int i = 0; i < iters; i++) {
			HashMap<String, Object> row = new HashMap<String, Object>();
			for (Map.Entry<String, Attributes> element : map.entrySet()) {
				Attributes current = (Attributes) element.getValue();
				row.put(element.getKey().toString(), current.min + randomHandler.nextDouble() * (current.max - current.min));
			}
			row.put("verbose", verbose);
			System.out.println(generateResult(row));
		}
		
	}
	
	private String generateResult(HashMap<String, Object> row) {
		StringBuilder result = new StringBuilder();
		DecimalFormat format = new DecimalFormat("#.##");
		result.append("{");
//		for (Map.Entry<String, Object> e : row.entrySet()) {
//			result.append("'" + e.getKey() + "': " + e.);
//		}
		result.append("'d': " + format.format(row.get("d")) + ", "
				+ "'ts': " + format.format(row.get("ts")) + ", "
				+ "'optimism': " + format.format(row.get("optimism")) + ", "
				+ "'nprod': " + format.format(row.get("nprod")) + ", "
				+ "'to': " + format.format(row.get("to")) + ", "
				+ "'r': " + format.format(row.get("r")) + ", "
				+ "'learning_curve': " + format.format(row.get("learning_curve")) + ", "
				+ "'atleast': " + format.format(row.get("atleast")) + ", "
				+ "'pomposity': " + format.format(row.get("pomposity")) + ", "
				+ "'np': " + format.format(row.get("np")) + ", "
				+ "'done_percent': " + format.format(row.get("done_percent")) + ", "
				+ "'productivity_new': " + format.format(row.get("productivity_new")) + ", "
				+ "'ep': " + format.format(row.get("ep")) + ", "
				+ "'verbose': " + row.get("verbose") + "}");
		return result.toString();
	}
	
	public static void monteCarloMain(int iters, int seed, boolean verbose) {
		System.out.println("Namespace(num_repeats=" + iters + ", seed=" + seed + ", verbose=" + verbose);
		//Namespace(num_repeats=1, seed=1, verbose=True)
		MonteCarlo mc = new MonteCarlo();
		randomHandler.setSeed(seed);
		mc.generator(iters, verbose);
	}

	public static void main(String[] args) {
		//HashMap<String, HashMap<>> argparse = new HashMap<String, String>();
		Arguments loadedArgs = new Arguments(args);
		MonteCarlo.monteCarloMain(loadedArgs.repeat, loadedArgs.seed, loadedArgs.verbose);
	}
	
	

}
