package tortal.kryotest;

public class Message {
	
	public String msg;
	public Object cool;
	
	public Message(){
		msg = "This class declares an Object, but it's actuall a SomeClass";
		cool = new SomeClass();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (cool == null) {
			if (other.cool != null)
				return false;
		} else if (!cool.equals(other.cool))
			return false;
		if (msg == null) {
			if (other.msg != null)
				return false;
		} else if (!msg.equals(other.msg))
			return false;
		return true;
	}

}
