/*
  ===================================
  (C) Advanced Computer Software 2015
  ===================================
 */
package githubdemo;

/**
 *
 * @author N.E. One
 */
public class Issue99 {

    private String message;

    /**
     *
     */
    public Issue99() {
        super();
        message = "áéíóú ÁÉÍÓÚ ¢£¤¥ ¼½¾ ®© ♠♣♥♦ ḉḈ ĉĈ ç æ";
    }

    /**
     *
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     */
    public void setMessage( String message ) {
        this.message = message;
    }

}
