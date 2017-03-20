import java.util.List;
import java.util.Map;
import java.util.Set;

public class SketchResult {

	Map<Integer, Integer> Result;
	Set<Integer> valid_Set;
	SketchResult(Map<Integer,Integer> r, Set<Integer> l){
		this.Result = r;
		this.valid_Set = l;
	}
	
	Map<Integer, Integer> getResult(){ return this.Result;}
	Set<Integer> get_Valid_List(){ return this.valid_Set;}
	
}
