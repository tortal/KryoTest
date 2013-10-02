package tortal.kryotest;

import java.util.ArrayList;

public class SomeClass {
	
	ArrayList<String> list;
	
	public SomeClass(){
		list = new ArrayList<String>();
		list.add("Hello kryo");
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
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		return true;
	}

}
