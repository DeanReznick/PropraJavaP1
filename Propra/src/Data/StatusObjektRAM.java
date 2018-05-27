package Data;

public class StatusObjektRAM {

	  String status; 
	  int status_id; 
	  String timestamp;
	  /* (non-Javadoc)
	   * @see java.lang.Object#toString()
	   */
	  @Override
	  public String toString() {
	    return "StatusObjektRAM [status=" + status + ", status_id=" + status_id + ", timestamp=" + timestamp + "]";
	  }
	  /**
	   * @return the status
	   */
	  public String getStatus() {
	    return status;
	  }
	  /**
	   * @return the status_id
	   */
	  public int getStatus_id() {
	    return status_id;
	  }
	  /**
	   * @return the timestamp
	   */
	  public String getTimestamp() {
	    return timestamp;
	  }
	  public StatusObjektRAM(String status, int status_id, String timestamp) {
	    super();
	    this.status = status;
	    this.status_id = status_id;
	    this.timestamp = timestamp;
	  }
	  
	  
	}