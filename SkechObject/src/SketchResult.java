import java.util.List;
import java.util.Map;

public class SketchResult {

	Map<Integer, Integer> Result;
	List<Integer> valid_List;
	SketchResult(Map<Integer,Integer> r, List<Integer> l){
		this.Result = r;
		this.valid_List = l;
	}
	
	Map<Integer, Integer> getResult(){ return this.Result;}
	List<Integer> get_Valid_List(){ return this.valid_List;}
	
}
