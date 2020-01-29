package lab06;

public class Paczka {
	public String imieFrom;
	public String imieTo;
	public String telFrom;
	public String telTo;
	public String msg;
	
	public long idfrom;
	public long idto;
	
	public Paczka(String imieFrom, String imieTo, String telFrom, String telTo, String msg,long idfrom, long idto) {
		super();
		this.imieFrom = imieFrom;
		this.imieTo = imieTo;
		this.telFrom = telFrom;
		this.telTo = telTo;
		this.idfrom = idfrom;
		this.idto = idto;
		this.msg = msg;
	}


}
