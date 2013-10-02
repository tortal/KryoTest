package tortal.kryotest;

import java.util.ArrayList;

public class SomeClass {
	
	ArrayList<String> cools;
	
	public SomeClass(){
		cools = new ArrayList<String>();
		cools.add("Hello kryo");
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SomeClass other = (SomeClass) obj;
		if (cools == null) {
			if (other.cools != null)
				return false;
		} else if (!cools.equals(other.cools))
			return false;
		return true;
	}

}
