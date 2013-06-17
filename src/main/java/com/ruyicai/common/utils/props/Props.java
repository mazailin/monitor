
package com.ruyicai.common.utils.props;


import java.util.Properties;

/**
 * A singleton to provide access to the standard property containing the
 * name of the property file hierarchy for the currently running
 * logicProcess. The standard property is: props/serv/perseus.properties
 * where <filename> is a full pathname of some properties file.
 */
public class Props {

    protected static Props instance = new Props();
    private static final String propsFileName = "/props/serv/ruyicai.properties";
    protected CCSProps servProps = null;


    /**
     * Protected constructor
     */
    protected Props() {
    }

    /**
     * Retrieve the properties object.
     *
     * @return Returns a Properties object. It may be empty if the property
     *         was not set, or the file could not be found, but it will never
     *         be null.
     */
    public Properties get() {
    	 if (servProps == null) {
    		 return getServProps().getProps();
         }
        return servProps.getProps();
    }

    /**
     * Returns the jvm's server properties
     */
    public synchronized CCSProps getServProps() {
        if (servProps == null) {
            initServProps();
        }
        return servProps;
    }

    /**
     * Return the name of the ten properties file.
     */
    public synchronized String getServPropsFileName() {
        if (servProps == null) {
            initServProps();
        }
        return propsFileName;
    }

  

    public static Props instance() {
        return instance;
    }

    private void initServProps() {
        servProps = createProps(propsFileName, false);
    }


    private static CCSProps createProps(String propsFileName, boolean loadSysProps) {
        CCSProps props = null;

        if (propsFileName == null || propsFileName.length() == 0) {
            // Just create an empty properties object.
            props = new CCSProps("");
        } else {
            props = new CCSProps(propsFileName, loadSysProps);
        }

        return props;
    }

    public static void main(String[] args) {
        System.out.println(Props.instance().get());
    }
}
