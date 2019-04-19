import java.text.DecimalFormat;
import java.util.*;

@SuppressWarnings("rawtypes")
public class MonteCarlo extends Attributes {
	
	public static HashMap<String, List> map;
	private static Random randomHandler = new Random();

	
	public void generator(int iters, boolean verbose) {
		for(int i = 0; i < iters; i++) {
			HashMap<String, Object> row = new HashMap<String, Object>();
			for (Map.Entry<String, List> element : map.entrySet()) {
				double min = getMin(element.getKey());
				double max = getMax(element.getKey());
				row.put(element.getKey(), min + randomHandler.nextDouble() * (max - min));
			}
			row.put("verbose", verbose);
			System.out.println(generateResult(row));
		}
	}
	
	private String generateResult(HashMap<String, Object> row) {
		StringBuilder result = new StringBuilder();
		DecimalFormat format = new DecimalFormat("#.##");
		result.append("{");
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
		System.out.println("Namespace(num_repeats=" + iters + ", seed=" + seed + ", verbose=" + verbose + ")");
		
		MonteCarlo mc = new MonteCarlo();
		mc.setAttributes();
		map = mc.getMap();
		randomHandler.setSeed(seed);
		mc.generator(iters, verbose);
	}

	public static void main(String[] args) {
		Arguments loadedArgs = new Arguments(args);
		MonteCarlo.monteCarloMain(loadedArgs.repeat, loadedArgs.seed, loadedArgs.verbose);
	}
	
	

}
