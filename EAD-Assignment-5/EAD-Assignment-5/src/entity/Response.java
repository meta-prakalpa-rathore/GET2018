package entity;

/**
 * class to store the response
 * @author Prakalpa-Rathore
 *
 */
public class Response {

    private int status;
    private String message;
    private Object data;
    
    
    /**
     * default constructor
     */
    public Response(){};
    
    
    /**
     * parameterized constructor
     * @param status
     * @param message
     * @param data
     */
    public Response(int status, String message, Object data) {
       
        this.status = status;
        this.message = message;
        this.data = data;
    }
    

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Object data) {
        this.data = data;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Response [status=" + status + ", message=" + message
                + ", data=" + data + "]";
    }    
    
    
}
