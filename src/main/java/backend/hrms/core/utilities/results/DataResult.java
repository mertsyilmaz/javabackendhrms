package backend.hrms.core.utilities.results;

public class DataResult<T> extends Result{
	
	private T data;
	
	public DataResult(T data, boolean succces) {
		super(succces);
		this.data = data;
	}

	public DataResult(T data, boolean succces, String message) {
		super(succces, message);
		this.data = data;
	}

	public T getData() {
		return this.data;
	}

}
