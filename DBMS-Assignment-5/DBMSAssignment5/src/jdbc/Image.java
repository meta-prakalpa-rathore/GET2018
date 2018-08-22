package jdbc;

/**
 * Class to store the attributes of image
 * @author User5
 *
 */
public class Image
{
    private String url;
    private String alternateText;
    
    
    /**
     * constructor
     * @param url
     * @param alternateText
     */
    public Image(String url, String alternateText) {
        this.url = url;
        this.alternateText = alternateText;
    }

    
    /**
     * getter method for url
     * @return url
     */
    public String getUrl() {
        return url;
    }
    
    
    /**
     * setter method for url
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }
    
    
    /**
     * getter method for alternameText
     * @return alternameText
     */
    public String getAlternateText() {
        return alternateText;
    }
    
    
    /**
     * setter method for alternameText
     * @param alternateText
     */
    public void setAlternateText(String alternateText) {
        this.alternateText = alternateText;
    }
    
}
