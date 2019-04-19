import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("rawtypes")
public class Attributes {
	public HashMap<String, List> map = new HashMap<String, List>();

	@SuppressWarnings("serial")
	public void setAttributes() {
		map.put("pomposity", new ArrayList<Double>() {{add(0.0); add(100.0);}});
		map.put("learning_curve", new ArrayList<Double>() {{add(1.0); add(100.0);}});
		map.put("optimism", new ArrayList<Double>() {{add(0.1); add(100.0);}});
		map.put("atleast", new ArrayList<Double>() {{add(0.0); add(10.0);}});
		map.put("done_percent", new ArrayList<Double>() {{add(0.0); add(10.0);}});
		map.put("productivity_new", new ArrayList<Double>() {{add(0.0); add(1.0);}});
		map.put("productivity_exp", new ArrayList<Double>() {{add(1.0); add(10.0);}});
		map.put("d", new ArrayList<Double>() {{add(0.0); add(1.0);}});
		map.put("ep", new ArrayList<Double>() {{add(1.0); add(10.0);}});
		map.put("nprod", new ArrayList<Double>() {{add(0.1); add(10.0);}});
		map.put("np", new ArrayList<Double>() {{add(1.0); add(30.0);}});
		map.put("ts", new ArrayList<Double>() {{add(1.0); add(100.0);}});
		map.put("to", new ArrayList<Double>() {{add(1.0); add(100.0);}});
		map.put("r", new ArrayList<Double>() {{add(1.0); add(1000.0);}});

	}

	
	public double getMin(String key) {
		return (double) map.get(key).get(0);
	}
	
	public double getMax(String key) {
		return (double) map.get(key).get(1);
	}
	
	public HashMap<String, List> getMap() {
		return map;
	}

}
