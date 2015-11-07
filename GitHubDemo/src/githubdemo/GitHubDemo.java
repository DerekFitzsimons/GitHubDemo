/*
  ===================================
  (C) Advanced Computer Software 2015
  ===================================
 */
package githubdemo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author N.E. One
 */
public class GitHubDemo {
    
    /**
     * Logger
     */
    private static final Logger LOGGER = Logger.getLogger( GitHubDemo.class.getName() );

    /**
     *
     */
    public GitHubDemo() {
        super();
    }

    /**
     * @param args the command line arguments
     */
    public static void main( String[] args ) {
        // This comment added using proper author name
        LOGGER.log(Level.INFO, "Hello from Ubuntu");
    }

}
